#!/usr/bin/env bash
# bench.sh <case> [variant...]
#
# Compares the backends on ONE program: builds each variant once, then runs it
# $BENCH_REPEATS times and reports the fastest and the median run. Separating
# the two matters here because they differ by two orders of magnitude --
# generating the Java takes ~40 s of Arend, running it ~1 s -- so a single
# wall-clock number per backend would hide which of them is being compared.
#
# A "variant" is a backend, plus one alias for the Java backend's other integer
# representation (JAVA_INT in config.sh):
#
#   java          Java, λ□ primitive ints as Java's 64-bit long (the default)
#   java-long     the same thing, spelled explicitly
#   java-bigint   Java, λ□ primitive ints as java.math.BigInteger
#   c             Peregrine's C backend (CertiRocq, gcc -O2)
#   ocaml         Peregrine's OCaml backend (Malfunction, ocamlopt)
#   eval          Peregrine's own evaluator: no code generation, no compilation
#
# With no variants given, every backend the case declares is used, once. Only
# `long` is measured: it is the closer approximation of λ□'s 63-bit primitive
# ints, and BigInteger was never a candidate representation -- it was measured
# 6x slower on matmul-bench and 5% slower on lean-deriv, i.e. it either loses or
# says nothing. `java-bigint` remains available for an explicit one-off.
#
# Rows are APPENDED to work/bench/<case>/results.tsv, so a run at another size
# extends the history instead of replacing it. The per-stage breakdown of a
# build (extract vs. javac, peregrine vs. gcc) lands in work/timings.tsv as
# usual.
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$here/load-case.sh" "$@"
shift

: "${BENCH_REPEATS:=3}"
# Free-form label distinguishing rows of the same case, e.g. the matrix size.
: "${BENCH_LABEL:=${MATMUL_SIZE-default}}"

variants=$*
if [ -z "$variants" ]; then
  for b in ${BACKENDS-}; do variants="$variants $b"; done
fi
[ -n "$variants" ] || die "case $CASE_NAME declares no BACKENDS"

results="$WORK_DIR/bench/$CASE_NAME/results.tsv"
mkdir -p "$(dirname "$results")"
[ -s "$results" ] || printf 'case\tlabel\tvariant\tstage\tn\tms\n' >"$results"

# Wall clock in milliseconds: `time` would need parsing and $SECONDS has
# one-second granularity, which the C backend's whole run is close to.
now_ms() { echo $(($(date +%s%N) / 1000000)); }
as_s() { awk -v ms="$1" 'BEGIN { printf "%.2f", ms / 1000 }'; }
# Lower median; with the default three repetitions the distinction never arises.
median() { sort -n | awk '{v[NR]=$1} END {print v[int((NR+1)/2)]}'; }

backend_of()  { case $1 in java-long|java-bigint) echo java ;; *) echo "$1" ;; esac; }
java_int_of() { case $1 in java-bigint) echo bigint ;; *) echo long ;; esac; }

# set_run_cmd <backend> -- fills the global array `cmd` with the command that
# RUNS the already-built program. This is the one place the runners are
# duplicated: run-<backend>.sh always rebuilds and always times exactly one run,
# whereas here the build must happen once and the run many times.
set_run_cmd() {
  local dir
  dir=$(work_dir "$CASE_NAME" "$1")
  case $1 in
    java)     cmd=("$JAVA" "$JAVA_RUN_STACK" $JAVA_RUN_FLAGS -cp "$dir" Prog) ;;
    c|ocaml)  cmd=("$dir/prog") ;;
    eval)     cmd=("$PEREGRINE" eval --anf "$EVAL_ANF" --fuel "$EVAL_FUEL" "$dir/prog.ast") ;;
    *)        die "bench.sh: no run command for backend '$1'" ;;
  esac
}

table=$(printf 'variant\tbuild_s\tbest_run_s\tmedian_run_s\truns')

for variant in $variants; do
  backend=$(backend_of "$variant")
  dir=$(work_dir "$CASE_NAME" "$backend")

  info "=== $CASE_NAME [$BENCH_LABEL] / $variant: building ==="
  t0=$(now_ms)
  if [ -x "$here/build-$backend.sh" ]; then
    JAVA_INT=$(java_int_of "$variant") "$here/build-$backend.sh" "$CASE_NAME"
  else
    # `eval` has no build step; it only needs the program itself.
    produce "${AST_PRODUCER-}" "$dir/prog.ast"
  fi
  build_ms=$(( $(now_ms) - t0 ))
  printf '%s\t%s\t%s\t%s\t%s\t%s\n' \
    "$CASE_NAME" "$BENCH_LABEL" "$variant" build - "$build_ms" >>"$results"

  set_run_cmd "$backend"
  runs=""
  for i in $(seq 1 "$BENCH_REPEATS"); do
    info "$CASE_NAME [$BENCH_LABEL] / $variant: run $i/$BENCH_REPEATS"
    t0=$(now_ms)
    "${cmd[@]}" >"$dir/output.txt" 2>&1
    ms=$(( $(now_ms) - t0 ))
    runs="$runs$ms"$'\n'
    printf '%s\t%s\t%s\t%s\t%s\t%s\n' \
      "$CASE_NAME" "$BENCH_LABEL" "$variant" run "$i" "$ms" >>"$results"
  done

  # The two Java variants share work/<case>/java, so keep a per-variant copy.
  cp "$dir/output.txt" "$dir/output-$variant.txt"

  best=$(printf '%s' "$runs" | sort -n | head -1)
  med=$(printf '%s' "$runs" | median)
  table="$table"$'\n'$(printf '%s\t%s\t%s\t%s\t%s' "$variant" \
    "$(as_s "$build_ms")" "$(as_s "$best")" "$(as_s "$med")" "$BENCH_REPEATS")
done

echo
echo "=== $CASE_NAME [$BENCH_LABEL] ==="
printf '%s\n' "$table" | column -t -s "$(printf '\t')"

echo
echo "=== outputs (first 3 lines) ==="
for variant in $variants; do
  out="$WORK_DIR/$CASE_NAME/$(backend_of "$variant")/output-$variant.txt"
  [ -f "$out" ] || continue
  printf '%s:\n' "$variant"
  head -3 "$out" | sed 's/^/  /'
done

if [ -n "${NOTE-}" ]; then info "$CASE_NAME: $NOTE"; fi
info "rows appended to $results"
