#!/usr/bin/env bash
# The `regression` corpus: programs that exist to pin down a property of THIS
# REPOSITORY'S COMPILER, one directory each under corpora/regression/.
#
# The distinction from `handwritten` is intent, not mechanism. A `handwritten`
# program is sample input -- a computation we want the backends to get right
# (`peano` adds 1+3, `matmul` multiplies two 130x130 matrices). A `regression`
# program is a claim about the generator, constructed so that a specific
# defect is the ONLY thing its result can be about, and it is worth nothing as a
# computation: `mangle-collision` returns a boolean whose value nobody cares
# about, and the point is that `javac` rejects the class.
#
# Consequently a program here may be EXPECTED TO FAIL with `xfail=` empty, so
# that `run.py --all` stays non-zero until the bug is fixed. That is the
# opposite of the `xfail` convention the wide external corpora need (a
# documented limitation, absorbed), and keeping the two kinds of program in
# separate corpora is what stops the two conventions from being confused.
#
# Same format as every corpus script: one TSV row per program on stdout and
# nothing else (`#` lines are comments run.py skips). The columns are fixed:
#
#   program  ast  expected  backends  runtime  xfail  note
#
# There is no logic here beyond reading each program's `meta` file, which is
# plain key=value data -- deliberately NOT sourced, so a program cannot smuggle
# code into the harness. Kept a separate file from handwritten.sh rather than
# generalized into a shared helper, because that is this directory's contract:
# one self-contained executable per corpus (see README.md, "Adding a corpus").
set -euo pipefail

CORPUS_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
TEST_DIR="$(cd "$CORPUS_DIR/.." && pwd)"

for meta in "$CORPUS_DIR"/regression/*/meta; do
  [ -f "$meta" ] || continue
  dir=${meta%/meta}
  expected= backends= runtime= xfail= note=
  while IFS='=' read -r key value; do
    case $key in
      expected) expected=$value ;;
      backends) backends=$value ;;
      runtime)  runtime=$value ;;
      xfail)    xfail=$value ;;
      note)     note=$value ;;
    esac
  done <"$meta"
  printf '%s\t%s\t%s\t%s\t%s\t%s\t%s\n' \
    "${dir##*/}" "${dir#"$TEST_DIR"/}/prog.ast" \
    "$expected" "$backends" "$runtime" "$xfail" "$note"
done
