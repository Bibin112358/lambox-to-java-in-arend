#!/usr/bin/env bash
# The three stages of the ocaml backend, one script:
#
#   stages/ocaml.sh gen   <prog.ast> <outdir> <runtime>
#   stages/ocaml.sh build <outdir> <runtime>
#   stages/ocaml.sh run   <outdir>
#
# gen: Peregrine's OCaml (Malfunction) backend turns the λ□ program into
# <outdir>/<module>.mlf. Both the program and its attribute file are copied
# into the work dir first, so that every backend of a program is visibly fed
# the same bytes. Every program ships a prog.attr because Peregrine requires
# the flag; most are the empty attribute file -- the `lean` bundle's contract
# is a module literally named `Axioms` (runtime/lean/vars.sh), which needs no
# attribute entry.
#
# build: compiles <module>.mlf and links it against the runtime bundle's
# drivers (its vars.sh: $OCAML_MODULE, $OCAML_DRIVER, $OCAML_EXTRA,
# $OCAML_FLAGS, $OCAML_LINK_FLAGS) into <outdir>/prog. Runs inside the work
# dir: ocamlopt and malfunction derive module names from file names and drop
# their artifacts next to the sources.
#
# run: runs the linked native binary; output goes to stdout and to
# <outdir>/output.txt. $NATIVE_RUN_STACK is raised for the same reason the
# java backend sizes its own stack -- see lib.sh.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)/lib.sh"
use_opam_switch   # malfunction, ocamlopt and the CertiRocq runtime

stage=${1:?usage: ocaml.sh <gen|build|run> ...}
shift

case $stage in

gen)
  ast=${1:?usage: ocaml.sh gen <prog.ast> <outdir> <runtime>}
  outdir=$(abs_dir "${2:?usage: ocaml.sh gen <prog.ast> <outdir> <runtime>}")
  runtime=${3:?usage: ocaml.sh gen <prog.ast> <outdir> <runtime>}
  [ -f "$ast" ] || die "no such .ast file: $ast"
  load_runtime "$runtime"
  attr="${ast%.ast}.attr"
  [ -f "$attr" ] || die "no attribute file: $attr (copy runtime/peano/empty.attr if the program realizes no axioms)"
  require_tool "$PEREGRINE" "set PEREGRINE to the peregrine binary"
  run_cmd cp "$ast" "$outdir/prog.ast"
  run_cmd cp "$attr" "$outdir/prog.attr"
  run_cmd "$PEREGRINE" ocaml --attributes "$outdir/prog.attr" \
    -o "$outdir/$OCAML_MODULE.mlf" "$outdir/prog.ast"
  ;;

build)
  outdir=$(abs_dir "${1:?usage: ocaml.sh build <outdir> <runtime>}")
  runtime=${2:?usage: ocaml.sh build <outdir> <runtime>}
  load_runtime "$runtime"
  [ -n "${OCAML_MODULE-}" ] || die "runtime bundle $runtime declares no OCAML_MODULE"
  [ -n "${OCAML_DRIVER-}" ] || unsupported "runtime bundle $runtime has no OCaml driver"
  [ -f "$outdir/$OCAML_MODULE.mlf" ] || die "no $OCAML_MODULE.mlf in $outdir (run gen first)"
  read -r -a ocamlopt <<<"$OCAMLOPT ${OCAML_FLAGS-}"
  require_tool "${ocamlopt[0]}" "set OCAMLOPT; ocamlfind comes from the opam switch peregrine was built in"
  require_tool "$MALFUNCTION" "comes from the opam switch peregrine was built in; set OPAM_SWITCH_BIN or MALFUNCTION"

  extra_units=""
  for f in ${OCAML_EXTRA-}; do
    copy_unit "$f" "$outdir"
    extra_units="$extra_units ${f##*/}"
  done
  copy_unit "$OCAML_DRIVER" "$outdir"
  driver_unit=${OCAML_DRIVER##*/}

  link_units=""
  for f in $extra_units; do
    case $f in *.ml) link_units="$link_units ${f%.ml}.cmx" ;; esac
  done

  for f in $extra_units; do
    run_cmd_in "$outdir" "${ocamlopt[@]}" -c "$f"
  done
  run_cmd_in "$outdir" "$MALFUNCTION" cmx "$OCAML_MODULE.mlf"
  run_cmd_in "$outdir" "${ocamlopt[@]}" -c "$driver_unit"
  # The generated module goes between the supporting units and the driver: the
  # driver is the only unit that refers to it.
  # shellcheck disable=SC2086
  run_cmd_in "$outdir" "${ocamlopt[@]}" ${OCAML_LINK_FLAGS-} -o prog \
    $link_units "$OCAML_MODULE.cmx" "${driver_unit%.ml}.cmx"
  ;;

run)
  outdir=$(abs_dir "${1:?usage: ocaml.sh run <outdir>}")
  [ -x "$outdir/prog" ] || die "no linked binary in $outdir (run build first)"
  (
    ulimit -s "$NATIVE_RUN_STACK" 2>/dev/null || warn "could not set stack limit to $NATIVE_RUN_STACK"
    run_cmd_capture "$outdir/output.txt" "$outdir/prog"
  )
  ;;

*) die "unknown stage: $stage (gen|build|run)" ;;
esac
