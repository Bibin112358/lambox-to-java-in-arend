#!/usr/bin/env bash
# regen-arend-asts.sh [program...]
#
# Refreshes the checked-in `prog.ast` of the programs written in Arend
# (`$ALL_PROGRAMS` below; sources in lambox-to-java-examples, printed by
# ExamplePrint.ard). Every corpus program is a λ□ s-expression file, so these
# terms are serialized once (Compiler/Serialize.ard) and committed; the harness
# itself never runs Arend to obtain a program. Every run of such a program then
# also exercises the round trip Serialize -> tools/ast-to-arend -> compile.
#
# Most live in corpora/handwritten/; `const-blowup`, `mangle-collision` and
# `axiom-mangle-collision` pin down properties of the compiler and live in
# corpora/regression/ (see corpora/regression.sh).
#
# Attribute files are refreshed too: `matmul*` remaps four primitive-op axioms
# per backend (prog.attr for OCaml, prog-c.attr for C), `axiom-mangle-collision`
# one axiom for OCaml.
#
# Cost: one Arend CLI run per file, ~40 s each (library loading dominates), so
# this is a rare, manual step -- never part of `test/check`.
set -euo pipefail

ALL_PROGRAMS="example peano matmul matmul250 letchain insertion-sort const-blowup mangle-collision axiom-mangle-collision"

TOOLS_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$TOOLS_DIR/../lib.sh"

# program -> its directory: sample computations are in `handwritten`, programs
# that pin down a property of the compiler in `regression`.
prog_dir() {
  case $1 in
    const-blowup|mangle-collision|axiom-mangle-collision)
      printf '%s/regression/%s\n' "$CORPORA_DIR" "$1" ;;
    *) printf '%s/handwritten/%s\n' "$CORPORA_DIR" "$1" ;;
  esac
}

# program -> the ExamplePrint definition that prints its serialized λ□ term.
sexpr_def() {
  case $1 in
    example) printf 'ExamplePrint:exampleSexpr\n' ;;
    peano)   printf 'ExamplePrint:peanoSexpr\n' ;;
    matmul)  printf 'ExamplePrint:matMulSexpr\n' ;;
    matmul200) printf 'ExamplePrint:matMulSexpr200\n' ;;
    matmul250) printf 'ExamplePrint:matMulSexpr250\n' ;;
    matmul300) printf 'ExamplePrint:matMulSexpr300\n' ;;
    letchain) printf 'ExamplePrint:letChainSexpr\n' ;;
    insertion-sort) printf 'ExamplePrint:sortSexpr\n' ;;
    const-blowup) printf 'ExamplePrint:constBlowupSexpr\n' ;;
    mangle-collision) printf 'ExamplePrint:mangleCollisionSexpr\n' ;;
    axiom-mangle-collision) printf 'ExamplePrint:axiomCollisionSexpr\n' ;;
    *)       die "no Arend source for program: $1 (regenerable: $ALL_PROGRAMS matmul200 matmul300)" ;;
  esac
}

regen() {
  local prog=$1 dir
  dir=$(prog_dir "$prog")
  [ -d "$dir" ] || die "no such program directory: $dir"
  info "regenerating $prog/prog.ast from $(sexpr_def "$prog")"
  "$TOOLS_DIR/extract-arend.sh" "$(sexpr_def "$prog")" "$dir/prog.ast"
  case $prog in matmul|matmul200|matmul250|matmul300)
    # Two files, because the two backends remap the four primitive-op axioms
    # onto different native symbols; see runtime/int63/README.md.
    "$TOOLS_DIR/extract-arend.sh" ExamplePrint:matMulAttrsCText     "$dir/prog-c.attr"
    "$TOOLS_DIR/extract-arend.sh" ExamplePrint:matMulAttrsOCamlText "$dir/prog.attr" ;;
  axiom-mangle-collision)
    # OCaml only: realizes the axiom as int63 multiplication.
    "$TOOLS_DIR/extract-arend.sh" ExamplePrint:axiomCollisionAttrsOCamlText "$dir/prog.attr" ;;
  esac
}

if [ $# -gt 0 ]; then
  for prog in "$@"; do regen "$prog"; done
else
  # matmul200/matmul300 are known to sexpr_def but have no program directory:
  # 250 is the kept benchmark size (test/README.md "Performance"); either of
  # the others is one `mkdir` plus a `meta` away.
  for prog in $ALL_PROGRAMS; do regen "$prog"; done
fi
