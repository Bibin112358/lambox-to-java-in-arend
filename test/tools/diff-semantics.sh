#!/usr/bin/env bash
set -euo pipefail

# This script performs a differential test of a program by:
# 1. Extracting its Java code from the Arend examples project.
# 2. Building and running it on the real JVM.
# 3. Printing the output.

. "$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)/lib.sh"

[ $# -ge 1 ] || die "usage: diff-semantics.sh <program_name>"
name=$1
outdir="$JUNIE_TMPDIR/$name"
mkdir -p "$outdir"

info "--- Differential Test: $name ---"

# 1. Extract Java
# We use the Arend CLI to extract the Java string from our Formal.DiffRuns module.
info "Extracting Java for $name..."
log="$outdir/extract.log"

# We need to point to both projects because lambox-to-java-examples depends on lambox-to-java
(cd "$AREND_EXAMPLES_PROJECT" && "$JAVA" $JAVA_STACK -jar "$AREND_JAR" \
  -L "$ROOT" -L "$AREND_LIBDIR" --no-daemon arend.yaml "Formal.DiffRuns:${name}Java") >"$log" 2>&1 || true

# Extract the text between delimiters, ignoring [WARNING] lines that can appear before it
text=$(sed -n '/^--- Typechecking /,/^--- Done (/p' "$log" | sed '1d;$d' | grep -vE '^\[(WARN|WARNING|INFO|ERROR)\]' | grep -v '^  In: ' || true)
if [ -z "$text" ]; then
    cat "$log" >&2
    die "Failed to extract Java for $name"
fi
printf '%s\n' "$text" > "$outdir/Prog.java"
info "Wrote $outdir/Prog.java"

# 2. Build
info "Building $name..."
cp "$AREND_PROJECT/runtime/Rt.java" "$outdir/Rt.java"
# Main.java.in expects @PROG@ to be the class name
sed 's/@PROG@/Prog/g' "$AREND_PROJECT/runtime/Main.java.in" >"$outdir/Main.java"
"$JAVAC" -d "$outdir" "$outdir/Rt.java" "$outdir/Prog.java" "$outdir/Main.java"

# 3. Run
info "Running $name on JVM..."
# Capturing output
"$JAVA" $JAVA_RUN_STACK $JAVA_RUN_FLAGS -cp "$outdir" Main > "$outdir/output.txt" 2>&1
cat "$outdir/output.txt"
info "Done $name."
