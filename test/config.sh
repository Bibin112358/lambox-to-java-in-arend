#!/usr/bin/env bash
# Single source of truth for tool locations. Every path is overridable by an
# environment variable of the same name, e.g.
#   AREND_JAR=/other/cli-full.jar test/run-case.sh peano
#
# Sourced by every script; never executed on its own.

TEST_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT="$(cd "$TEST_DIR/.." && pwd)"

. "$TEST_DIR/lib/log.sh"

# --- Arend ------------------------------------------------------------------
# A *development* build of Arend is required: the library relies on the new
# String implementation, which is not in a release yet (expected in 1.13).
# The project's `arend.yaml` declares `langVersion: 1.12`, so the CLI must be a
# 1.12 build -- an older jar rejects the library outright ("Incompatible
# language version"), and arend-lib in ~/.arend is 1.12 as well.
: "${AREND_JAR:=$HOME/arend-lang-bibin/cli/build/libs/cli-1.12.0-full.jar}"
: "${AREND_PROJECT:=$ROOT/lambox-to-java}"
: "${JAVA:=$HOME/.jdks/openjdk-26.0.1/bin/java}"
: "${JAVAC:=${JAVA}c}"
# Evaluating a whole generated program during typechecking needs a big stack.
: "${JAVA_STACK:=-Xss1g}"
# So does RUNNING a generated program: the backend compiles λ□ `fix` to ordinary
# recursive calls, with no tail-call elimination or trampoline, so a source-level
# loop becomes a Java call chain as deep as the number of iterations. The JVM's
# default thread stack (~1 MB) overflows on inputs a source language considers
# small; several lean-to-lambdabox benchmarks need this.
: "${JAVA_RUN_STACK:=-Xss512m}"
# Additional JVM flags for RUNNING a generated program.
#
# `-XX:-DontCompileHugeMethods` lifts HotSpot's default refusal to JIT-compile a
# method larger than 8000 bytecodes (`-XX:HugeMethodLimit`). That heuristic is
# written for hand-written code, where such a method is a mistake; our methods
# are machine-generated, and a single Lean definition (say `Deriv.Expr.mul` with
# its ten match alternatives) is naturally one huge method. Crossing the limit is
# a CLIFF, not a slope: the method is interpreted forever. Measured on
# `lean-deriv`, whose `mul` sits at ~8.0k bytecodes, i.e. right at the edge --
# 23.8-24.5 s without the flag versus 5.1-7.0 s with it, from a 4% change in
# method size. Neutral (within noise) on every case whose methods are small.
: "${JAVA_RUN_FLAGS:=-XX:-DontCompileHugeMethods}"
# The fixed Java runtime (`Rt.java`: Fn, Data, BOX, PRIM_*) is hand-written, not
# generated; it is compiled next to every generated `Prog.java`.
: "${JAVA_RUNTIME_DIR:=$AREND_PROJECT/runtime}"
# Representation of λ□ primitive ints in the generated Java (the `JavaTarget`
# record in ToJava.ard): `long` = Java's built-in 64-bit integer, `bigint` =
# java.math.BigInteger (unbounded, no wraparound). It selects the
# print-definition variant a case asks for, so
#   JAVA_INT=bigint test/run-case.sh matmul java
# builds the same program with BigInteger arithmetic instead.
#
# `long` is the DEFAULT because it is the closer approximation of the source
# semantics: a λ□ `prim (primInt, _)` is a 63-bit machine integer with cyclic
# arithmetic, so a fixed-width wrapping integer is the right shape and only the
# width is off by one bit. `bigint` is neither faster nor more faithful -- it is
# kept only because unbounded arithmetic is occasionally useful for debugging,
# and it is no longer exercised by the benchmark or suite runners.
: "${JAVA_INT:=long}"
case $JAVA_INT in
  long)   JAVA_DEF_SUFFIX="" ;;
  bigint) JAVA_DEF_SUFFIX="BigInteger" ;;
  *)      die "JAVA_INT must be 'long' or 'bigint', got: $JAVA_INT" ;;
esac

# --- Importing external λ□ programs -----------------------------------------
# `.ast` files coming from Rocq/Lean/Agda are first normalized with Peregrine's
# `ast box`, then turned into Arend source by test/tools/ast-to-arend (a
# harness tool, not part of the compiler -- its output is validated by the
# Arend typechecker). The importer itself is deliberately language-agnostic.
: "${PYTHON:=python3}"
: "${AST_TO_AREND:=$TEST_DIR/tools/ast-to-arend}"

# --- Peregrine / CertiRocq (C and OCaml backends) ---------------------------
: "${PEREGRINE:=$HOME/peregrine-tool/_build/install/default/bin/peregrine}"
# Extra flags for the `peregrine ast box` normalization run in import-ast.sh,
# i.e. Peregrine's OPTIONAL middle-end passes (`doc/middleend.md`). They are
# semantics-preserving, so turning them on only changes how much work reaches
# our generator; word-split on purpose. Useful values:
#   --betared=true    collapse (\x. e) a redexes  (default off)
#   --unboxing=true   unbox 1-constructor/1-field inductives (default off)
#   --dearg-consts=true --dearg-ctors=true   dead-argument removal -- REQUIRES a
#     typed AST, so it is silently a no-op on the untyped `.ast` files we import
#     (verified byte-identical output on lean-deriv).
# See test/README.md for what these measured on lean-deriv.
: "${PEREGRINE_BOX_FLAGS:=}"
: "${CERTIROCQ_RT:=$HOME/.opam/peregrine/lib/coq/user-contrib/CertiRocq/Plugin/runtime}"
# `malfunction` lives in the opam switch peregrine was built in and is usually
# not on PATH; prepend that switch's bin dir instead of requiring `opam env`.
: "${OPAM_SWITCH_BIN:=$HOME/.opam/peregrine/bin}"
if [ -d "$OPAM_SWITCH_BIN" ]; then
  case ":$PATH:" in
    *":$OPAM_SWITCH_BIN:"*) ;;
    *) PATH="$OPAM_SWITCH_BIN:$PATH"; export PATH ;;
  esac
fi
: "${GCC:=gcc}"
: "${OCAMLOPT:=ocamlopt}"
: "${MALFUNCTION:=malfunction}"

# --- Peregrine's evaluator (the `eval` backend) -----------------------------
# `peregrine eval` runs the program instead of compiling it, so it is a
# reference/oracle backend. Its default fuel (10000 steps) is far too small for
# anything but a toy, but overshooting is NOT free: fuel is a Rocq `nat`, i.e. a
# unary number the evaluator allocates up front, ~16 bytes per unit. Measured on
# the tiny `peano-ast` program, where the program itself is instant:
#   fuel 1e6 -> 0.03 s / 29 MB, 1e7 -> 0.45 s / 171 MB, 1e8 -> 4.6 s / 1.6 GB,
#   1e9 -> 222 s.
# So ~1e7-1e8 is the practical ceiling, and it bounds which programs can be
# evaluated at all. The overhead is constant per fuel value, so subtract it when
# reading an eval timing.
: "${EVAL_FUEL:=10000000}"
# `true` = the ANF evaluator (Peregrine's default), `false` = the direct λ□ one.
: "${EVAL_ANF:=true}"

# --- Layout -----------------------------------------------------------------
: "${WORK_DIR:=$TEST_DIR/work}"
: "${CASES_DIR:=$TEST_DIR/cases}"
: "${TIMINGS_TSV:=$WORK_DIR/timings.tsv}"

# require_tool <name-or-path> [hint]
# Dies with a clear message instead of failing cryptically deep in a build.
require_tool() {
  local tool=$1 hint=${2-}
  case $tool in
    */*) [ -x "$tool" ] && return 0 ;;
    *)   command -v "$tool" >/dev/null 2>&1 && return 0 ;;
  esac
  die "tool not found: $tool${hint:+ ($hint)}"
}

# Producers are commands declared by a case, e.g.
#   JAVA_PRODUCER="extract-arend ExamplePrint:peanoJava"
#   AST_PRODUCER="cat $CASE_DIR/prog.ast"        # a future deserializer fits here
# They write the artifact to stdout; `produce` redirects it to a file. This is
# why the backends need no knowledge of where an artifact comes from.
extract-arend() { "$TEST_DIR/extract-arend.sh" "$@"; }
# `import-ast <file.ast> <Module>` boxes the program, writes Imported.<Module>,
# and prints nothing, so it chains in front of an extract-arend producer:
#   JAVA_PRODUCER="import-ast $CASE_DIR/prog.ast Mutual && extract-arend Imported.Mutual:progJava"
import-ast() { "$TEST_DIR/import-ast.sh" "$@"; }

# produce <producer-command> <outfile>
produce() {
  local producer=$1 out=$2
  [ -n "$producer" ] || die "no producer declared for $out"
  mkdir -p "$(dirname "$out")"
  eval "$producer" >"$out"
}

# work_dir <case> <backend> -- create and echo the scratch dir for one run.
work_dir() {
  local dir="$WORK_DIR/$1/$2"
  mkdir -p "$dir"
  printf '%s\n' "$dir"
}
