#!/usr/bin/env bash
# run-java.sh <case> -- build the generated Java and run it.
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$here/load-case.sh" "$@"

require_tool "$JAVA" "set JAVA to a JDK's java"

dir=$(work_dir "$CASE_NAME" java)

"$here/build-java.sh" "$CASE_NAME"
"$here/run-timed.sh" "$CASE_NAME" java -- "$JAVA" "$JAVA_RUN_STACK" $JAVA_RUN_FLAGS -cp "$dir" Prog
