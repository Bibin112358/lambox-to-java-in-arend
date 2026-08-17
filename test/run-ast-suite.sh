#!/usr/bin/env bash
# run-ast-suite.sh <suite-name> <file-or-directory>...
#
# Runs every untyped Peregrine .ast below the given paths through the complete
# ast box -> Arend import -> Java compile -> JVM pipeline. Failures are kept in
# the report instead of stopping the suite, so unsupported corpus features are
# visible alongside passing programs.
#
# SUITE_RUN_TIMEOUT bounds the JVM run of one program (seconds), so a single
# non-terminating or very slow corpus entry cannot stall the whole suite. Such a
# program is reported as `timeout` and counted separately: it compiled and
# started, so it is an ACCEPTED outcome and does not fail the suite -- only
# import, compile and runtime errors do.
#
# The report also carries the wall-clock seconds of each phase, so "generating
# the program" (box + import + Arend extraction + javac) and "running it" stay
# distinguishable -- for this pipeline the former dominates by far.
set -uo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$here/config.sh"

[ $# -ge 2 ] || die "usage: $(basename "$0") <suite-name> <file-or-directory>..."
suite=$1
shift
case $suite in *[!A-Za-z0-9._-]*|'') die "suite name must use only A-Z, a-z, 0-9, '.', '_' or '-'" ;; esac

require_tool "$PYTHON" "set PYTHON to a Python 3 interpreter"
require_tool "$JAVAC" "set JAVAC (or JAVA) to a JDK"
require_tool "$JAVA" "set JAVA to a JDK's java"

: "${SUITE_RUN_TIMEOUT:=300}"
case $SUITE_RUN_TIMEOUT in *[!0-9]*|'') die "SUITE_RUN_TIMEOUT must be a number of seconds" ;; esac

suite_dir="$WORK_DIR/suites/$suite"
report="$suite_dir/results.tsv"
mkdir -p "$suite_dir"
printf 'file\tstatus\timport_s\textract_s\tjavac_s\trun_s\toutput\n' >"$report"

# Wall clock to a tenth of a second: `date +%s` alone would round each phase
# down by up to a second, which matters for the sub-second javac step. Note that
# `extract_s` includes the Arend CLI's constant arend-lib loading (tens of
# seconds), so it is an upper bound on the code generation proper.
now() { date +%s.%N; }
elapsed() { "$PYTHON" -c 'import sys; print("%.1f" % (float(sys.argv[2]) - float(sys.argv[1])))' "$1" "$2"; }

files=$(
  "$PYTHON" - "$@" <<'PY'
import os
import sys

files = []
for path in sys.argv[1:]:
    if os.path.isfile(path):
        if path.endswith('.ast') and not path.endswith('.tast'):
            files.append(os.path.abspath(path))
    elif os.path.isdir(path):
        for root, dirs, names in os.walk(path):
            dirs.sort()
            for name in sorted(names):
                if name.endswith('.ast') and not name.endswith('.tast'):
                    files.append(os.path.abspath(os.path.join(root, name)))
    else:
        print("run-ast-suite: no such file or directory: " + path, file=sys.stderr)
        sys.exit(2)

print('\n'.join(sorted(set(files))))
PY
) || exit $?

[ -n "$files" ] || die "suite $suite contains no untyped .ast files"

passed=0
failed=0
timedout=0
index=0
while IFS= read -r ast; do
  index=$((index + 1))
  module="Suite${index}"
  case_dir="$suite_dir/$index"
  log="$case_dir/pipeline.log"
  mkdir -p "$case_dir"
  rm -f "$case_dir/output.txt"
  : >"$log"
  info "=== $suite / $ast ==="

  status=passed
  t_import= t_extract= t_javac= t_run=
  t0=$(now)
  if ! "$here/import-ast.sh" "$ast" "$module" >>"$log" 2>&1; then
    status=import-failed
    t_import=$(elapsed "$t0" "$(now)")
  else
    t1=$(now)
    t_import=$(elapsed "$t0" "$t1")
    if ! "$here/extract-arend.sh" "Imported.$module:progJava$JAVA_DEF_SUFFIX" \
        "$case_dir/Prog.java" >>"$log" 2>&1; then
      status=extract-failed
      t_extract=$(elapsed "$t1" "$(now)")
    else
      t2=$(now)
      t_extract=$(elapsed "$t1" "$t2")
      cp "$JAVA_RUNTIME_DIR/Rt.java" "$case_dir/Rt.java"
      if ! "$JAVAC" -d "$case_dir" "$case_dir/Rt.java" "$case_dir/Prog.java" \
          >>"$log" 2>&1; then
        status=compile-failed
        t_javac=$(elapsed "$t2" "$(now)")
      else
        t3=$(now)
        t_javac=$(elapsed "$t2" "$t3")
        timeout "$SUITE_RUN_TIMEOUT" "$JAVA" "$JAVA_RUN_STACK" $JAVA_RUN_FLAGS -cp "$case_dir" Prog \
          >"$case_dir/output.txt" 2>>"$log"
        code=$?
        t_run=$(elapsed "$t3" "$(now)")
        case $code in
          0)   ;;
          124) status=timeout ;;
          *)   status=runtime-failed ;;
        esac
      fi
    fi
  fi

  output=
  if [ -f "$case_dir/output.txt" ]; then
    output=$(tr '\n\t' '  ' <"$case_dir/output.txt" | sed 's/  *$//')
    if [ "${#output}" -gt 160 ]; then output="${output:0:157}..."; fi
  fi
  printf '%s\t%s\t%s\t%s\t%s\t%s\t%s\n' "$ast" "$status" \
    "$t_import" "$t_extract" "$t_javac" "$t_run" "$output" >>"$report"
  case $status in
    passed)
      passed=$((passed + 1)) ;;
    timeout)
      timedout=$((timedout + 1))
      warn "$ast: no result within ${SUITE_RUN_TIMEOUT}s (accepted; see $log)" ;;
    *)
      failed=$((failed + 1))
      warn "$ast: $status (see $log)" ;;
  esac
done <<EOF
$files
EOF

info "$suite: $passed passed, $failed failed, $timedout timed out; report: $report"
[ "$failed" -eq 0 ]