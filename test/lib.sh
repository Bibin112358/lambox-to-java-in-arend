#!/usr/bin/env bash
# Shared by the stage scripts (stages/*.sh) and tools/*.sh. Sourced, never run.
# Tool paths are hard-coded for this machine; edit them here if they move.

TEST_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT="$(cd "$TEST_DIR/.." && pwd)"

info() { printf '[test] %s\n' "$*" >&2; }
warn() { printf '[test] WARNING: %s\n' "$*" >&2; }
die()  { printf '[test] ERROR: %s\n' "$*" >&2; exit 1; }

# --- Layout -------------------------------------------------------------
WORK_DIR="$TEST_DIR/work"
TOOLS_DIR="$TEST_DIR/tools"
CORPORA_DIR="$TEST_DIR/corpora"
RUNTIME_DIR="$TEST_DIR/runtime"

# --- Arend ---------------------------------------------------------------
# A development 1.12 build of the Arend CLI (the library needs its String
# implementation).
AREND_JAR="$HOME/arend-lang-bibin/cli/build/libs/cli-1.12.0-full.jar"
AREND_LIBDIR="$HOME/.arend/libs"            # where arend-lib is installed
AREND_CORE="$ROOT/lambox-to-java"           # the compiler, semantics, proofs
AREND_EXAMPLES="$ROOT/lambox-to-java-examples"
AREND_TESTS="$TEST_DIR/arend"               # generated programs (src/ is gitignored)
JAVA="$HOME/.jdks/openjdk-26.0.1/bin/java"
JAVAC="${JAVA}c"
# Optional command prefix for every Arend JVM, e.g. a lock that limits how many
# run at once on a memory-constrained machine: AREND_WRAP="/path/to/slot.sh".
AREND_WRAP="${AREND_WRAP:-}"

# arend <project-dir> <module-or-def>... -- typecheck in that project, all output
# to stdout. The exit status means nothing: callers look for `[ERROR]` lines.
# The two projects that depend on lambox-to-java find it through -L (which
# replaces the default library root, hence arend-lib's root as well).
arend() {
  local project=$1; shift
  local -a libs=()
  [ "$project" = "$AREND_CORE" ] || libs=(-L "$ROOT" -L "$AREND_LIBDIR")
  # A binary cache can hide a source change and suppresses the putStrLn output
  # the harness harvests, so no run may use one.
  rm -rf "$project/bin" "$AREND_CORE/bin"
  # shellcheck disable=SC2086
  (cd "$project" && $AREND_WRAP "$JAVA" -Xss1g -Xmx2g -jar "$AREND_JAR" "${libs[@]}" \
     --no-daemon arend.yaml "$@") 2>&1 || true
}

# --- Running generated Java ----------------------------------------------
# Rt.java and the Main.java.in entry-point template are compiled next to the
# generated class (the generator emits no `main`).
JAVA_RUNTIME_DIR="$AREND_CORE/runtime"
# λ□ `fix` becomes ordinary non-tail recursion, so programs need deep stacks.
JAVA_RUN_STACK=-Xss512m
# HotSpot refuses to JIT methods over 8000 bytecodes; generated methods are often
# bigger (lean-deriv: 24 s without this flag, 6 s with it).
JAVA_RUN_FLAGS=-XX:-DontCompileHugeMethods

# --- Importing .ast programs ---------------------------------------------
PYTHON=python3
AST_TO_AREND="$TOOLS_DIR/ast-to-arend"

# --- Peregrine / CertiRocq (import, and the OCaml and C reference backends)
PEREGRINE="$HOME/peregrine-tool/_build/install/default/bin/peregrine"
PEREGRINE_BOX_FLAGS=   # optional extra passes for `peregrine ast box`
CERTIROCQ_RT="$HOME/.opam/peregrine/lib/coq/user-contrib/CertiRocq/Plugin/runtime"
OPAM_SWITCH_BIN="$HOME/.opam/peregrine/bin"   # malfunction lives here
case ":$PATH:" in
  *":$OPAM_SWITCH_BIN:"*) ;;
  *) PATH="$OPAM_SWITCH_BIN:$PATH" ;;
esac
GCC=gcc
OCAMLOPT=ocamlopt
MALFUNCTION=malfunction
NATIVE_RUN_STACK=unlimited   # `ulimit -s` for native programs (deep recursion)

# --- Exit codes: the stage scripts' contract with run.py -----------------
MISSING_TOOL_EXIT=3      # a toolchain is absent               -> skip-no-tool
STAGE_EXIT_UNSUPPORTED=4 # this backend can't run this program -> skip-unsupported

# require_tool <name-or-path> [hint]
require_tool() {
  local tool=$1 hint=${2-}
  case $tool in
    */*) [ -x "$tool" ] && return 0 ;;
    *)   command -v "$tool" >/dev/null 2>&1 && return 0 ;;
  esac
  warn "tool not found: $tool${hint:+ ($hint)}"
  exit "$MISSING_TOOL_EXIT"
}

require_arend() {
  require_tool "$JAVA" "a JDK"
  [ -f "$AREND_JAR" ] || { warn "Arend CLI jar not found: $AREND_JAR"; exit "$MISSING_TOOL_EXIT"; }
}

# unsupported <reason> -- a declared but impossible combination.
unsupported() { warn "unsupported: $*"; exit "$STAGE_EXIT_UNSUPPORTED"; }

# abs_dir <path> -- create the directory and print its absolute path
# (`peregrine c` writes the -o path verbatim into an #include).
abs_dir() { mkdir -p "$1" && (cd "$1" && pwd); }

# run_cmd <cmd> [args...] -- print, then execute.
run_cmd() { info "+ $*"; "$@"; }

# run_cmd_in <dir> <cmd> [args...] -- the same, inside <dir>.
run_cmd_in() {
  local dir=$1
  shift
  info "+ (cd $dir && $*)"
  (cd "$dir" && "$@")
}

# run_cmd_capture <outfile> <cmd> [args...] -- run with stdout and stderr into
# <outfile> (run.py reads it as the program's value), echo it, keep the status.
run_cmd_capture() {
  local outfile=$1
  shift
  info "+ $*"
  local status=0
  "$@" >"$outfile" 2>&1 || status=$?
  cat "$outfile"
  return "$status"
}

# load_runtime <bundle> -- source runtime/<bundle>/vars.sh (assignments only).
load_runtime() {
  RUNTIME_BUNDLE_DIR="$RUNTIME_DIR/$1"
  [ -f "$RUNTIME_BUNDLE_DIR/vars.sh" ] || die "unknown runtime bundle '$1' (no $RUNTIME_BUNDLE_DIR/vars.sh)"
  . "$RUNTIME_BUNDLE_DIR/vars.sh"
}

# copy_unit <name> <outdir> -- a bundle file name, or an absolute path.
copy_unit() {
  case $1 in
    /*) run_cmd cp "$1" "$2/" ;;
    *)  run_cmd cp "$RUNTIME_BUNDLE_DIR/$1" "$2/" ;;
  esac
}
