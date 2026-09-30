#!/usr/bin/env bash
# Shared by the stage scripts (stages/*.sh), corpora/*.sh and tools/*.sh.
# Sourced, never run.
#
# Nothing here is specific to one machine: repository paths are derived from
# this file's location, and every external tool is taken from an environment
# variable, else found on PATH. A machine's own settings go into test/local.sh
# (gitignored; copy local.sh.example), which is read first.

TEST_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT="$(cd "$TEST_DIR/.." && pwd)"

# shellcheck source=/dev/null
[ -f "$TEST_DIR/local.sh" ] && . "$TEST_DIR/local.sh"

info() { printf '[test] %s\n' "$*" >&2; }
warn() { printf '[test] WARNING: %s\n' "$*" >&2; }
die()  { printf '[test] ERROR: %s\n' "$*" >&2; exit 1; }

# --- Layout -------------------------------------------------------------
WORK_DIR="$TEST_DIR/work"
TOOLS_DIR="$TEST_DIR/tools"
CORPORA_DIR="$TEST_DIR/corpora"
RUNTIME_DIR="$TEST_DIR/runtime"

# --- Arend ---------------------------------------------------------------
# The Arend CLI jar, built from the String PR (README "Requirements"); no default.
AREND_JAR="${AREND_JAR:-}"
# The directory containing arend-lib (that PR's arend-lib/); the default is
# the CLI's own default library root.
AREND_LIBDIR="${AREND_LIBDIR:-$HOME/.arend/libs}"
AREND_CORE="$ROOT/lambox-to-java"           # the compiler, semantics, proofs
AREND_EXAMPLES="$ROOT/lambox-to-java-examples"
AREND_TESTS="$TEST_DIR/arend"               # generated programs (src/ is gitignored)
# The JDK: $JAVA, else $JAVA_HOME/bin/java, else `java` on PATH.
JAVA="${JAVA:-${JAVA_HOME:+$JAVA_HOME/bin/java}}"
JAVA="${JAVA:-java}"
JAVAC="${JAVAC:-${JAVA}c}"
# Optional command prefix for every Arend JVM, e.g. a lock that limits how many
# run at once on a memory-constrained machine: AREND_WRAP="/path/to/slot.sh".
AREND_WRAP="${AREND_WRAP:-}"

# arend <project-dir> <module-or-def>... -- typecheck in that project, all output
# to stdout. The exit status means nothing: callers look for `[ERROR]` lines.
# Libraries are found through -L: arend-lib in $AREND_LIBDIR, and for the two
# projects that depend on lambox-to-java, the repository root.
arend() {
  local project=$1; shift
  # A missing tool is reported the way callers look for failures.
  if [ -z "$AREND_JAR" ] || [ ! -f "$AREND_JAR" ]; then
    echo "[ERROR] Arend CLI jar not found (AREND_JAR='$AREND_JAR'); see test/local.sh.example"
    return 0
  fi
  if ! command -v "$JAVA" >/dev/null 2>&1; then
    echo "[ERROR] no JVM '$JAVA'; set JAVA or JAVA_HOME (see test/local.sh.example)"
    return 0
  fi
  local -a libs=(-L "$AREND_LIBDIR")
  [ "$project" = "$AREND_CORE" ] || libs+=(-L "$ROOT")
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
PYTHON="${PYTHON:-python3}"
AST_TO_AREND="$TOOLS_DIR/ast-to-arend"

# --- Upstream checkouts (optional corpora) --------------------------------
# Each corpus is skipped when its variable is unset.
PEREGRINE_DIR="${PEREGRINE_DIR:-}"                   # peregrine-tool: corpora/peregrine.sh
LEAN_TO_LAMBDABOX_DIR="${LEAN_TO_LAMBDABOX_DIR:-}"   # corpora/lean-benchmarks.sh
LAKE="${LAKE:-lake}"   # Lean's build tool, for tools/extract-lean-benchmarks.sh

# --- Peregrine / CertiRocq (import, and the OCaml and C reference backends)
PEREGRINE="${PEREGRINE:-peregrine}"
PEREGRINE_BOX_FLAGS="${PEREGRINE_BOX_FLAGS:-}"   # extra passes for `peregrine ast box`
# The opam switch with malfunction and CertiRocq, and CertiRocq's C runtime in
# it (found through `opam` by use_opam_switch unless set).
OPAM_SWITCH_NAME="${OPAM_SWITCH_NAME:-peregrine}"
CERTIROCQ_RT="${CERTIROCQ_RT:-}"
GCC="${GCC:-gcc}"
OCAMLOPT="${OCAMLOPT:-ocamlopt}"
MALFUNCTION="${MALFUNCTION:-malfunction}"
NATIVE_RUN_STACK=unlimited   # `ulimit -s` for native programs (deep recursion)

# use_opam_switch -- put $OPAM_SWITCH_NAME's bin/ on PATH and locate
# $CERTIROCQ_RT in it. Without opam (or that switch) both are left to PATH and
# the variable. Only the reference backends call this.
use_opam_switch() {
  local prefix
  command -v opam >/dev/null 2>&1 || return 0
  prefix=$(opam var --switch="$OPAM_SWITCH_NAME" prefix 2>/dev/null) || return 0
  [ -n "$prefix" ] || return 0
  PATH="$prefix/bin:$PATH"
  CERTIROCQ_RT="${CERTIROCQ_RT:-$prefix/lib/coq/user-contrib/CertiRocq/Plugin/runtime}"
}

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
  require_tool "$JAVA" "a JDK: set JAVA or JAVA_HOME"
  [ -n "$AREND_JAR" ] || { warn "AREND_JAR is not set (see test/local.sh.example)"; exit "$MISSING_TOOL_EXIT"; }
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
