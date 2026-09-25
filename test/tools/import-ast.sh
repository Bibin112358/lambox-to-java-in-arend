#!/usr/bin/env bash
# import-ast.sh <ast-file> <Module> [--mode=builder|literal]
#
# Turns a Peregrine λ□ `.ast` file into the Arend module
# test/arend/src/Imported/<Module>.ard (generated, gitignored), which defines
# `program : LBProgram` and `progJava` (prints the generated Java):
#
#   1. `peregrine ast box` rewrites curried constructor applications into the
#      saturated constructor-block form LambdaBox.ard expects (MetaRocq's
#      verified pass; no normalization of our own);
#   2. tools/ast-to-arend translates that form into Arend source.
#
# Writes nothing to stdout; errors (and peregrine's progress) go to stderr.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)/lib.sh"

[ $# -ge 2 ] || die "usage: import-ast.sh <ast-file> <Module> [--mode=...]"
ast=$1
module=$2
shift 2

[ -f "$ast" ] || die "no such .ast file: $ast"
require_tool "$PEREGRINE" "the peregrine executable"
require_tool "$PYTHON" "a Python 3 interpreter"

dir="$AREND_TESTS/src/Imported"
mkdir -p "$dir"
out="$dir/$module.ard"
boxed=$(mktemp --suffix=.boxed.ast)
trap 'rm -f "$boxed"' EXIT

# shellcheck disable=SC2086
"$PEREGRINE" ast box "$ast" $PEREGRINE_BOX_FLAGS -o "$boxed" >&2
"$PYTHON" "$AST_TO_AREND" "$@" -o "$out" "$boxed"
info "imported $ast -> Imported.$module ($(wc -l <"$out") lines)"
