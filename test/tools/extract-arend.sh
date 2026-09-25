#!/usr/bin/env bash
# extract-arend.sh <MODULE:DEF> [outfile]
#
# Typechecks one definition whose body is `putStrLn <text>` and prints that
# text (or writes it to outfile). `ExamplePrint:*` targets live in the examples
# project; everything else (chiefly `Imported.<Module>:progJava`) in the test
# project test/arend/.
#
# The CLI frames what a definition prints between `--- Typechecking <DEF> ---`
# and `--- Done (NNms) ---`. Cost: ~20 s per call, nearly all of it parsing
# arend-lib, so batch many programs into one call where possible (golden.py).
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)/lib.sh"

[ $# -ge 1 ] || die "usage: extract-arend.sh <MODULE:DEF> [outfile]"
target=$1
out=${2-}

case $target in
  ExamplePrint:*) project="$AREND_EXAMPLES" ;;
  *)              project="$AREND_TESTS" ;;
esac
require_arend

mkdir -p "$WORK_DIR"
log=$(mktemp "$WORK_DIR/extract-XXXXXX.log")
trap 'rm -f "$log"' EXIT

start=$(date +%s%N)
arend "$project" "$target" >"$log"
info "extract $target took $(( ($(date +%s%N) - start) / 1000000 ))ms"

if grep -q '^\[ERROR\]' "$log"; then
  cat "$log" >&2
  die "Arend reported errors on $target"
fi

# Generated Java never starts a line with `[`, so CLI diagnostics are dropped.
text=$(sed -n '/^--- Typechecking /,/^--- Done (/p' "$log" | sed '1d;$d' | grep -vE '^\[(WARN|INFO)\]' || true)
[ -n "$text" ] || { cat "$log" >&2; die "no printed output found for $target"; }

if [ -n "$out" ]; then
  mkdir -p "$(dirname "$out")"
  printf '%s\n' "$text" >"$out"
  info "wrote $out"
else
  printf '%s\n' "$text"
fi
