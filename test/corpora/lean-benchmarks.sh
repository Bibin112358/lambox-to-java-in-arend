#!/usr/bin/env bash
# The `lean-benchmarks` corpus: lean-to-lambdabox's own benchmark suite, one row
# per line of its `benchmarks/TESTS` manifest.
#
# Upstream ships Lean sources, not λ□ programs, so the `.ast` files are a CACHE
# produced by tools/extract-lean-benchmarks.sh (each benchmark closed over input
# 10) under work/lean-benchmarks/ -- nothing per-program is checked in here. A
# benchmark whose `.ast` is not in the cache simply gets no row, and with the
# upstream directory absent the manifest is missing and the corpus prints
# nothing at all, which run.py reports as unavailable.
#
# Six of these benchmarks also exist in the handwritten corpus (`lean-qsort`,
# `lean-deriv`, ...). They stay separate programs on purpose: those are pinned,
# checked-in `.ast` files closed over their own inputs, these follow upstream's
# manifest at whatever revision is installed. The `leanbench-` prefix keeps the
# two sets of program IDs apart -- an ID is what names a work directory and a
# generated Arend module, so it has to be unique across corpora.
#
# `expected` comes from Lean's own `#eval` at the same input; see
# lean-benchmarks.expected, which has no row for the five benchmarks returning
# `Unit` or a list.
set -euo pipefail

CORPUS_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$CORPUS_DIR/../lib.sh"
# A lean-to-lambdabox checkout; without one the corpus is empty.
[ -n "$LEAN_TO_LAMBDABOX_DIR" ] || exit 0
TESTS="$LEAN_TO_LAMBDABOX_DIR/benchmarks/TESTS"
[ -f "$TESTS" ] || exit 0

while IFS=: read -r name runner _; do
  [ -f "$CORPUS_DIR/../work/lean-benchmarks/$name.ast" ] || continue
  backends="java ocaml" note="upstream TESTS entry $name:$runner, input 10"
  case $name in
    # The five benchmarks that do not return a `Nat`. runtime/lean's OCaml driver
    # is `print_endline (Z.to_string Bench.main)` against a `val main: Z.t`
    # interface, so a `Unit` or list result is read as a Zarith integer and
    # segfaults: no driver, hence not a declared backend (`unit` happens to print
    # `0` either way, which is luck, not support).
    unit|demo0|demo2) backends=java note="returns Unit/a list; runtime/lean's OCaml driver prints a Nat only" ;;
    # Same shape, and the two biggest values in the harness: these return an
    # 8000-element list, and our Java printer indents by
    # nesting depth, so the value is 192 MB of text. They pass (1.4 s), which is
    # why they are NOT xfail -- but they are what run.py's output hashing exists
    # for, and no other program in the harness writes that much.
    demo1|demo1_tc) backends=java note="8000-element list; 192 MB of rendered java output" ;;
  esac
  printf '%s\t%s\t%s\t%s\t%s\t%s\t%s\n' \
    "leanbench-$name" "work/lean-benchmarks/$name.ast" \
    "$(awk -v n="$name" '$1 == n { print $2 }' "$CORPUS_DIR/lean-benchmarks.expected")" \
    "$backends" "lean" "" "$note"
done <"$TESTS"
