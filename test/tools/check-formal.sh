#!/usr/bin/env bash
# check-formal.sh
#
# Typechecks the formalization. NOTHING ELSE DOES, on purpose: no module of the
# translation imports `Formal.*`, so `golden.py` and `run.py` never look at it
# and a normal compile stays as cheap as it was. The cost of that is this
# script's reason to exist -- without it, the semantics rots silently the first
# time `compileClass`, `runClass` or `evalT` changes shape, and nobody finds out
# until they next remember to name a module by hand.
#
# TYPECHECKING IS THE CHECKING. Everything in there is either a proof
# (`renderName` injective) or a run whose expected value is asserted by `idp`
# (the fragment's semantics on compiled programs; λ□'s semantics and the
# fragment's agreeing on the same program). So a disagreement is a type error,
# and this script needs no output of its own beyond Arend's.
#
# Two projects, because the checks that need λ□ PROGRAMS live where the programs
# are (the examples project, which depends on the compiler one). Each project
# takes one invocation with all its modules, since the ~18 s of parsing arend-lib
# is per invocation, not per module (see extract-arend.sh).
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)/lib.sh"

require_tool "$JAVA" "set JAVA to a JDK's java"
if [ ! -f "$AREND_JAR" ]; then
  warn "Arend CLI jar not found: $AREND_JAR (a development build is required)"
  exit "$MISSING_TOOL_EXIT"
fi

# Every module of Compiler/, Semantics/ and Proof/, and the examples project's
# ModelChecks/ -- listed from the directories, so a new file is never missed.
modules_in() {  # <project> <dir>...
  local project=$1; shift
  (cd "$project/src" && for d in "$@"; do ls "$d"/*.ard; done) | sed 's/\.ard$//; s#/#.#g'
}
mapfile -t compiler_modules < <(modules_in "$AREND_PROJECT" Compiler Semantics Proof)
mapfile -t example_modules < <(modules_in "$AREND_EXAMPLES_PROJECT" ModelChecks)

fail=0

check() {
  local project=$1; shift
  local -a extra_l=()
  [ "$project" = "$AREND_EXAMPLES_PROJECT" ] && extra_l=(-L "$ROOT" -L "$AREND_LIBDIR")
  info "+ (cd $project && $JAVA $JAVA_STACK -jar $AREND_JAR ${extra_l[*]} arend.yaml $*)"
  local log
  log=$(mktemp "${WORK_DIR:-/tmp}/check-formal-XXXXXX.log")
  # The exit status is not a success signal (see extract-arend.sh); `[ERROR]`
  # lines are. `[GOAL]` counts too: an unfinished proof is not a check.
  (cd "$project" && "$JAVA" "$JAVA_STACK" -jar "$AREND_JAR" \
     "${extra_l[@]}" --no-daemon arend.yaml "$@") >"$log" 2>&1 || true
  if grep -qE '^\[(ERROR|GOAL)\]' "$log"; then
    grep -E '^\[(ERROR|GOAL)\]' "$log" >&2
    fail=1
  fi
  grep -E '^--- (Typechecking|Done)' "$log" | sed 's/^/  /'
  rm -f "$log"
}

mkdir -p "$WORK_DIR"
check "$AREND_PROJECT" "${compiler_modules[@]}"
check "$AREND_EXAMPLES_PROJECT" "${example_modules[@]}"

if [ "$fail" = 0 ]; then
  info "formalization checks out (${#compiler_modules[@]} + ${#example_modules[@]} modules)"
else
  die "the formalization does not typecheck (see above)"
fi
