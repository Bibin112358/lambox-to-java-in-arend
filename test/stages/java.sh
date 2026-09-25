#!/usr/bin/env bash
# The three stages of the java backend, one script:
#
#   stages/java.sh gen   <prog.ast> <outdir> [Module]
#   stages/java.sh build <outdir>
#   stages/java.sh run   <outdir>
#
# gen: λ□ `.ast` -> <outdir>/Prog.java. Arend has no file IO, so two steps:
# tools/import-ast.sh writes the program as test/arend/src/Imported/<Module>.ard,
# then tools/extract-arend.sh typechecks Imported.<Module>:progJava and captures
# what it prints. <Module> defaults to the CamelCase of the program directory.
#
# build: compiles Prog.java with the runtime Rt.java and Main.java (instantiated
# from runtime/Main.java.in; the generated class only exposes `body()`).
#
# run: runs Main; its output goes to stdout and to <outdir>/output.txt.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)/lib.sh"

stage=${1:?usage: java.sh <gen|build|run> ...}
shift

case $stage in

gen)
  ast=${1:?usage: java.sh gen <prog.ast> <outdir> [Module]}
  outdir=$(abs_dir "${2:?usage: java.sh gen <prog.ast> <outdir> [Module]}")
  module=${3-}
  [ -f "$ast" ] || die "no such .ast file: $ast"
  if [ -z "$module" ]; then
    progdir=$(cd "$(dirname "$ast")" && pwd)
    # lean-const-fold -> LeanConstFold
    module=$(printf '%s\n' "${progdir##*/}" |
      awk -F'[-_]' '{for (i = 1; i <= NF; i++) printf "%s%s", toupper(substr($i, 1, 1)), substr($i, 2)}')
  fi
  require_arend
  require_tool "$PEREGRINE" "the peregrine executable"
  require_tool "$PYTHON" "a Python 3 interpreter"
  run_cmd "$TOOLS_DIR/import-ast.sh" "$ast" "$module"
  run_cmd "$TOOLS_DIR/extract-arend.sh" "Imported.$module:progJava" "$outdir/Prog.java"
  ;;

build)
  outdir=$(abs_dir "${1:?usage: java.sh build <outdir>}")
  [ -f "$outdir/Prog.java" ] || die "no generated Prog.java in $outdir (run gen first)"
  require_tool "$JAVAC" "a JDK"
  run_cmd cp "$JAVA_RUNTIME_DIR/Rt.java" "$outdir/Rt.java"
  # `Prog` is the class name every generator call in the harness asks for.
  sed 's/@PROG@/Prog/g' "$JAVA_RUNTIME_DIR/Main.java.in" >"$outdir/Main.java" ||
    die "could not instantiate Main.java from $JAVA_RUNTIME_DIR/Main.java.in"
  info "+ sed s/@PROG@/Prog/g Main.java.in > $outdir/Main.java"
  run_cmd "$JAVAC" -d "$outdir" "$outdir/Rt.java" "$outdir/Prog.java" "$outdir/Main.java"
  ;;

run)
  outdir=$(abs_dir "${1:?usage: java.sh run <outdir>}")
  [ -f "$outdir/Main.class" ] || die "nothing compiled in $outdir (run build first)"
  require_tool "$JAVA" "a JDK"
  # shellcheck disable=SC2086
  run_cmd_capture "$outdir/output.txt" \
    "$JAVA" "$JAVA_RUN_STACK" $JAVA_RUN_FLAGS -cp "$outdir" Main
  ;;

*) die "unknown stage: $stage (gen|build|run)" ;;
esac
