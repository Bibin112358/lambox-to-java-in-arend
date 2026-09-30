-- Extraction driver for the `const_fold` benchmark. `const_fold.lean` next to
-- this file is a verbatim copy of lean-to-lambdabox's
-- benchmarks/FromLeanCommon/const_fold.lean (revision 58701f8); this file only
-- closes it over the input its benchmark manifest (benchmarks/TESTS) uses, and
-- asks for the OCaml interface as well.
--
-- Regenerate prog.ast / bench.mli (both are otherwise unmodified):
--   cp prog.lean $LEAN_TO_LAMBDABOX_DIR/ConstFold.lean
--   cd $LEAN_TO_LAMBDABOX_DIR && LEAN_PATH=$PWD/benchmarks/.lake/build/lib/lean \
--     lake env lean ConstFold.lean
--   cp $LEAN_TO_LAMBDABOX_DIR/{prog.ast,bench.mli} <this directory>
-- (`#erase` writes relative to the working directory, hence the copy back.)
-- Change the input below to scale the benchmark; the expected value in case.sh
-- then has to be recomputed (`#eval const_fold <n>` -- needs `ulimit -s
-- unlimited`, Lean's interpreter recurses deeply here).
import FromLeanCommon
import LeanToLambdaBox

def suite_const_fold := const_fold 20
#erase suite_const_fold to "prog.ast" mli "bench.mli"
