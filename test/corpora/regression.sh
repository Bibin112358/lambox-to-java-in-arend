#!/usr/bin/env bash
# The `regression` corpus: programs that pin down a property of THIS compiler,
# one directory each under corpora/regression/. A `handwritten` program is a
# computation we want every backend to get right; a regression program is
# built so that one specific defect is the only thing its result can show. Its
# `meta` says which defect, and whether it is fixed or open.
#
# Same format as handwritten.sh: one TSV row per program,
#
#   program  ast  expected  backends  runtime  xfail  note
#
# read from each program's `meta` (plain key=value data, never sourced).
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
