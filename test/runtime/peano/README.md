# Runtime bundle `peano` — the only way the C backend sees a Lean program

A Lean benchmark erased the ordinary way leaves Lean's `@[extern]` primitives as
λ□ **axioms**, and then:

* our Java backend is fine (it realizes them in `Rt`),
* Peregrine's OCaml backend is fine (it expects a module `Axioms`, see
  `../lean/`),
* **`peregrine c` refuses the program outright** ("Axioms found, use Extract
  Constant to realize them in C") and nobody has written C realizations of Lean's
  primitives — they would have to allocate `Decidable`/`Array` values through the
  CertiRocq GC,
* and `peregrine eval` cannot run it either (an axiom remapped to a native symbol
  has no implementation in the evaluator).

Erasing the *same* benchmark with

    config { nat := .peano, extern := .preferLogical }

removes the axioms instead: `Nat` stays an inductive type and `Nat.add`/`mul`/
`beq`/… are erased from their logical definitions. The resulting λ□ file needs no
attributes and no realizations at all, so **all four backends run the identical
file** — which is what makes these cases the strongest differential test in the
corpus, at the price of unary arithmetic (hence much smaller inputs).

Each such case returns a `Bool` (`Nat.beq (benchmark n) expected`) rather than the
number: a unary result is a term as deep as its value, and every backend renders
values with per-level indentation, so printing it would dominate the run and the
comparison would be about printers. As a `Bool` all four print the constructor's
ordinal — `1` for `Bool.true` — except `eval`, which prints `constr Bool.true`.

Files (all three are the ones `lean-matmul-peano` already used, generalized to the
module name `bench` so any program can share them):

| file | role |
|---|---|
| `main.c` | C driver: calls `body`, prints the returned prim int (`>> 1`: CertiRocq encodes n as 2n+1) |
| `bench_main.ml` | OCaml driver: prints `Bench.main` |
| `bench.mli` | interface for the malfunction-generated module (`malfunction cmx` emits no `.cmi`) |
| `empty.attr` | `(attributes_config () () () () ())` — no remapping; note `peregrine` rejects a zero-byte file. Each program checks in its own copy as `prog.attr` |
| `vars.sh` | the bundle's declarations (module name, driver, extra units, compiler flags) |

**Not every benchmark can be made axiom-free this way.** `rbmap_mono` still leaves
`.False.rec` after `preferLogical` — its map carries a well-formedness proof, and
the absurd-case eliminator survives erasure — so `peregrine c` rejects it
(`Axioms found ... .False.rec`) and the OCaml backend would need an `Axioms` module
defining `def__False_rec`. That variant was therefore dropped; the axiom version
(`corpora/handwritten/lean-rbmap-mono`) covers the program on java/ocaml.

**Beware when writing a new program:** a large numeric *literal* in the Lean source
cannot be erased under `nat := .peano` — the eraser builds it unary and Lean's
interpreter aborts with "deep recursion was detected at 'interpreter'" (this is
its own limit, not the OS stack, so `ulimit -s` does not help). Write the expected
value as arithmetic over small literals instead, e.g. `68*70+12` for 4772.
