#!/usr/bin/env bash
# regen-arend-asts.sh [program...]
#
# Refreshes the checked-in `prog.ast` of the six AREND-AUTHORED programs.
#
# Every program in the corpus is a λ□ s-expression file -- that is the single
# program input shape of the harness, so the six programs whose source is a
# hand-written `LBTerm` in the Arend project rather than a file from Lean or
# Rocq need their term serialized once and committed. This script is the only
# producer of those files; the harness itself never runs Arend to obtain a
# program, only to compile one.
#
# The six: `example`, `peano`, `matmul`, and the three that exist because a
# λ□ program is the only way to state a property of the GENERATOR precisely --
# `const-blowup` (Java re-evaluates a constant per reference, so a DAG of
# constants costs 2^N there and N in OCaml) and `mangle-collision` /
# `axiom-mangle-collision` (two consequences of `mangleKername` not being
# injective).
#
# The six span TWO corpora -- `example`/`peano`/`matmul` are sample computations
# under corpora/handwritten/, the other three are defect witnesses under
# corpora/regression/ (see corpora/regression.sh for the distinction) -- so a
# program's directory is resolved by `prog_dir` below rather than assumed. Each
# program's `meta` records its own mechanism.
#
# The round trip that makes this legitimate -- serialize with `Serialize.ard`,
# read back with `tools/ast-to-arend`, compile, and get the same output as
# compiling the original term -- is what the retired `peano-ast` and `matmul-ast`
# cases used to check by hand. Running it on every program instead of on two is
# an improvement, not a loss: `Serialize` and the importer are now on the path of
# all six.
#
# Cost: one Arend CLI run per program, ~40 s each (library loading dominates), so
# this is a rare, manual step -- never part of a `run.py` run.
#
# Two programs additionally need an attribute file, extracted from the same
# Arend module and refreshed here as well: `matmul` remaps its four primitive-op
# axioms per backend (two files), and `axiom-mangle-collision` remaps its single
# colliding axiom for OCaml (one file -- it declares no `c` backend). Both are
# fixed declarations independent of any size parameter, which is why they are
# checked in rather than re-extracted per run.
set -euo pipefail

TOOLS_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$TOOLS_DIR/../lib.sh"

ALL_PROGRAMS="example peano matmul const-blowup mangle-collision axiom-mangle-collision"

# program -> its corpus directory. The Arend-authored programs live in TWO
# corpora: `handwritten` for the ones that are sample computations, `regression`
# for the ones that exist to pin down a defect of the generator (see
# corpora/regression.sh). Both are regenerated from the same Arend project, so
# this script spans them and has to resolve the directory per program rather
# than assume one parent.
prog_dir() {
  case $1 in
    example|peano|matmul)
      printf '%s/handwritten/%s\n' "$CORPORA_DIR" "$1" ;;
    const-blowup|mangle-collision|axiom-mangle-collision)
      printf '%s/regression/%s\n' "$CORPORA_DIR" "$1" ;;
    *) die "no Arend source for program: $1 (regenerable: $ALL_PROGRAMS)" ;;
  esac
}

# program -> the ExamplePrint definition that prints its serialized λ□ term.
sexpr_def() {
  case $1 in
    example)                printf 'ExamplePrint:exampleSexpr\n' ;;
    peano)                  printf 'ExamplePrint:peanoSexpr\n' ;;
    matmul)                 printf 'ExamplePrint:matMulSexpr\n' ;;
    const-blowup)           printf 'ExamplePrint:constBlowupSexpr\n' ;;
    mangle-collision)       printf 'ExamplePrint:mangleCollisionSexpr\n' ;;
    axiom-mangle-collision) printf 'ExamplePrint:axiomCollisionSexpr\n' ;;
    *)       die "no Arend source for program: $1 (regenerable: $ALL_PROGRAMS)" ;;
  esac
}

regen() {
  local prog=$1 dir
  dir=$(prog_dir "$prog")
  [ -d "$dir" ] || die "no such program directory: $dir"
  info "regenerating $prog/prog.ast from $(sexpr_def "$prog")"
  "$TOOLS_DIR/extract-arend.sh" "$(sexpr_def "$prog")" "$dir/prog.ast"
  case $prog in
    matmul)
      # Two files, because the two backends remap the four primitive-op axioms
      # onto different native symbols; see runtime/int63/README.md.
      "$TOOLS_DIR/extract-arend.sh" ExamplePrint:matMulAttrsCText     "$dir/prog-c.attr"
      "$TOOLS_DIR/extract-arend.sh" ExamplePrint:matMulAttrsOCamlText "$dir/prog.attr"
      ;;
    axiom-mangle-collision)
      # One file: only the `ocaml` backend of this program realizes the axiom
      # (it declares no `c` backend), and it must realize it as MULTIPLICATION
      # so that the Java backend's silently-wrong ADD is visible as 13 vs 42.
      "$TOOLS_DIR/extract-arend.sh" ExamplePrint:axiomCollisionAttrsOCamlText "$dir/prog.attr"
      ;;
  esac
}

if [ $# -gt 0 ]; then
  for prog in "$@"; do regen "$prog"; done
else
  # shellcheck disable=SC2086
  for prog in $ALL_PROGRAMS; do regen "$prog"; done
fi
