-- Extraction driver for the `deriv` benchmark: it is the upstream program in
-- `deriv.lean` (a verbatim copy of lean-to-lambdabox's
-- benchmarks/FromLeanCommon/deriv.lean, revision 58701f8), closed over the
-- input the benchmark suite uses.
--
-- Regenerate prog.ast (the file is otherwise unmodified):
--   cp prog.lean $LEAN_TO_LAMBDABOX_DIR/Deriv10.lean
--   cd $LEAN_TO_LAMBDABOX_DIR && LEAN_PATH=$PWD/benchmarks/.lake/build/lib/lean \
--     lake env lean Deriv10.lean
-- which is exactly what test/run-lean-benchmark-suite.sh does for the whole
-- manifest; this case pins one entry of it so it can be run and benchmarked on
-- its own.
import FromLeanCommon
import LeanToLambdaBox

def suite_deriv := deriv 10
#erase suite_deriv to "prog.ast"
