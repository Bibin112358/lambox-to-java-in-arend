#!/usr/bin/env bash
# extract-lean-benchmarks.sh [lean-to-lambdabox-directory]
#
# The directory defaults to $LEAN_TO_LAMBDABOX_DIR (see lib.sh).
#
# The producer of the `lean-benchmarks` corpus' programs: closes every benchmark
# of upstream's `benchmarks/TESTS` over one small input and erases it to a λ□
# `.ast` file in $WORK_DIR/lean-benchmarks/.
#
# Upstream has no `.ast` files to point a corpus row at: a benchmark is a Lean
# FUNCTION (`Nat -> Nat` or `Unit -> Unit`), and its Makefile erases a closed
# wrapper into a build directory named after the malfunction configuration. So
# the corpus needs the same wrapper, which is what this script writes -- one
# `#erase` per benchmark, all in a single Lean file, i.e. one elaboration for the
# whole suite. The result is a CACHE, not checked in: the corpus stays "no
# per-program files in the repository", and `corpora/lean-benchmarks.sh` simply
# prints no row for a benchmark whose `.ast` is not there.
#
# Input value: fixed at 10 below -- a coverage suite, not a performance run
# (upstream's own counts, up to 10^8, would run for minutes each).
# corpora/lean-benchmarks.expected holds the Lean `#eval` value at THAT input, so
# the two must be regenerated together (changing `input` here included); the
# header of that file says how.
#
# Read-only towards upstream: nothing is written below the lean-to-lambdabox
# directory, and `lake build` is deliberately NOT run -- the benchmark library
# must already be built there (it is what LEAN_PATH points at).
set -euo pipefail

TOOLS_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$TOOLS_DIR/../lib.sh"

lean_root=${1:-$LEAN_TO_LAMBDABOX_DIR}
[ -n "$lean_root" ] || die "no lean-to-lambdabox checkout: pass it or set LEAN_TO_LAMBDABOX_DIR"
tests="$lean_root/benchmarks/TESTS"
lib="$lean_root/benchmarks/.lake/build/lib/lean"
input=10
ast_dir="$WORK_DIR/lean-benchmarks"
source="$ast_dir/BenchmarkSuite.lean"

[ -f "$tests" ] || die "benchmark manifest not found: $tests"
[ -d "$lib" ] || die "benchmark library not built: $lib (run \`lake build\` in $lean_root/benchmarks)"
require_tool "$LAKE" "Lean's lake (install elan, or set LAKE)"
mkdir -p "$ast_dir"

# The wrapper: `runonce`/`repeat` benchmarks take `()`, `natio` ones take the
# input value. `#erase` writes an absolute path, which is how the elaboration can
# run with upstream as its cwd and still produce files only under work/.
rm -f "$ast_dir"/*.ast "$ast_dir"/*.ast.inlinings "$ast_dir"/*.attr
{
  printf 'import FromLeanCommon\nimport LeanToLambdaBox\n\n'
  while IFS=: read -r name runner _; do
    [ -n "$name" ] || continue
    case $runner in runonce|repeat) arg='()' ;; *) arg=$input ;; esac
    printf 'def suite_%s := %s %s\n#erase suite_%s to "%s/%s.ast"\n\n' \
      "$name" "$name" "$arg" "$name" "$ast_dir" "$name"
  done <"$tests"
} >"$source"

info "erasing $(grep -c '^#erase' "$source") benchmarks of $lean_root at input $input"
(cd "$lean_root" && LEAN_PATH="$lib${LEAN_PATH:+:$LEAN_PATH}" \
  "$LAKE" env lean "$source")

# The OCaml stage requires an attribute file next to the program (peregrine
# demands the flag); a benchmark realizes its axioms through the `lean` runtime
# bundle's `Axioms` module, so the empty one is the right one for all of them.
for ast in "$ast_dir"/*.ast; do
  cp "$RUNTIME_DIR/peano/empty.attr" "${ast%.ast}.attr"
done
info "wrote $(ls "$ast_dir"/*.ast | wc -l) .ast files to $ast_dir"
