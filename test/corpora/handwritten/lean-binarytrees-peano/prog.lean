-- Axiom-free ("Peano") extraction of the upstream `binarytrees` benchmark, so that
-- ALL THREE backends can run the same file -- see ../../../runtime/peano/README.md.
-- `binarytrees.lean` in ../lean-binarytrees/ is the verbatim upstream program (revision
-- 58701f8); nothing here changes it.
--
-- Regenerate prog.ast (otherwise unmodified):
--   cp prog.lean $LEAN_TO_LAMBDABOX_DIR/GenP.lean
--   cd $LEAN_TO_LAMBDABOX_DIR && LEAN_PATH=$PWD/benchmarks/.lake/build/lib/lean \
--     lake env lean GenP.lean
--   cp $LEAN_TO_LAMBDABOX_DIR/prog.ast <this directory>
--
-- The result is a Bool, and the expected value is written as ARITHMETIC over small
-- literals (163*160+48 = 26128): under `nat := .peano` a large literal is erased to a
-- unary term and Lean's eraser aborts with "deep recursion".
import FromLeanCommon
import LeanToLambdaBox

def suite_p : Bool := Nat.beq (binarytrees 8) (163*160+48)
#erase suite_p config { nat := .peano, extern := .preferLogical } to "prog.ast"
