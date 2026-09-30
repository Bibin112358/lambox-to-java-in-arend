#!/usr/bin/env bash
# The three stages of the (opt-in) c backend, one script:
#
#   stages/c.sh gen   <prog.ast> <outdir> <runtime>
#   stages/c.sh build <outdir> <runtime>
#   stages/c.sh run   <outdir>
#
# gen: Peregrine's C backend (CertiRocq's code generator) turns the λ□ program
# into <outdir>/prog.c. The attribute file is chosen per backend: a program
# whose axioms are realized by DIFFERENT native symbols in C and OCaml ships an
# additional prog-c.attr next to prog.attr, preferred here when present (today
# only `matmul`). Only two shapes of program reach this stage at all: one over
# λ□ primitive ints and an axiom-free ("Peano") one -- `peregrine c` rejects a
# program with unrealized axioms outright, which is why the `lean` bundle has
# no C path.
#
# build: compiles prog.c together with the CertiRocq runtime and the runtime
# bundle's $C_DRIVER into <outdir>/prog. prim_int63.c must be on the gcc line --
# Peregrine's own test harness links only gc_stack.c, enough only for a program
# without primitive ints.
#
# run: runs the compiled binary; output goes to stdout and to
# <outdir>/output.txt. See $NATIVE_RUN_STACK in lib.sh for the ulimit: the
# generated C recurses as deeply as the source program loops, like every other
# backend.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)/lib.sh"
use_opam_switch   # malfunction, ocamlopt and the CertiRocq runtime

stage=${1:?usage: c.sh <gen|build|run> ...}
shift

case $stage in

gen)
  ast=${1:?usage: c.sh gen <prog.ast> <outdir> <runtime>}
  outdir=$(abs_dir "${2:?usage: c.sh gen <prog.ast> <outdir> <runtime>}")
  runtime=${3:?usage: c.sh gen <prog.ast> <outdir> <runtime>}
  [ -f "$ast" ] || die "no such .ast file: $ast"
  load_runtime "$runtime"
  [ -n "${C_DRIVER-}" ] || unsupported "runtime bundle $runtime has no C driver"
  attr="${ast%.ast}-c.attr"
  [ -f "$attr" ] || attr="${ast%.ast}.attr"
  [ -f "$attr" ] || die "no attribute file: $attr (looked for ${ast%.ast}-c.attr first)"
  require_tool "$PEREGRINE" "set PEREGRINE to the peregrine binary"
  run_cmd cp "$ast" "$outdir/prog.ast"
  run_cmd cp "$attr" "$outdir/prog.attr"
  run_cmd "$PEREGRINE" c --attributes "$outdir/prog.attr" \
    -o "$outdir/prog.c" "$outdir/prog.ast"
  ;;

build)
  outdir=$(abs_dir "${1:?usage: c.sh build <outdir> <runtime>}")
  runtime=${2:?usage: c.sh build <outdir> <runtime>}
  load_runtime "$runtime"
  [ -n "${C_DRIVER-}" ] || unsupported "runtime bundle $runtime has no C driver"
  [ -f "$outdir/prog.c" ] || die "no generated prog.c in $outdir (run gen first)"
  require_tool "$GCC"
  if [ ! -d "$CERTIROCQ_RT" ]; then
    # A missing runtime is a missing TOOLCHAIN, not a broken build: same exit
    # status as require_tool, so run.py records skip-no-tool.
    warn "CertiRocq runtime not found: $CERTIROCQ_RT"
    exit "$MISSING_TOOL_EXIT"
  fi
  copy_unit "$C_DRIVER" "$outdir"
  driver_unit=${C_DRIVER##*/}
  run_cmd "$GCC" -o "$outdir/prog" -w -O2 -fomit-frame-pointer \
    -I"$CERTIROCQ_RT" -I"$outdir" \
    "$CERTIROCQ_RT/gc_stack.c" "$CERTIROCQ_RT/prim_int63.c" \
    "$outdir/prog.c" "$outdir/$driver_unit"
  ;;

run)
  outdir=$(abs_dir "${1:?usage: c.sh run <outdir>}")
  [ -x "$outdir/prog" ] || die "no compiled binary in $outdir (run build first)"
  (
    ulimit -s "$NATIVE_RUN_STACK" 2>/dev/null || warn "could not set stack limit to $NATIVE_RUN_STACK"
    run_cmd_capture "$outdir/output.txt" "$outdir/prog"
  )
  ;;

*) die "unknown stage: $stage (gen|build|run)" ;;
esac
