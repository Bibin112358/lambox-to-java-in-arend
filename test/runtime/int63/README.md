# Runtime bundle `int63` — the drivers for programs over λ□ primitive integers

A program in this bundle computes over `tPrim (primInt, _)`, i.e. λ□'s **63-bit
machine integers**, and leaves the four arithmetic operations as axioms
`prim_add_int`, `prim_mul_int`, `prim_sub_int`, `prim_eqb_int`. The program's
attribute files remap them onto native symbols, and because the two backends
have different notions of "native symbol" there are two files per program:

| file | backend | remapping |
|---|---|---|
| `prog-c.attr` | `c` | `prim_int63_{add,mul,sub,eqb}` from the CertiRocq runtime's `prim_int63.h` |
| `prog.attr` | `ocaml` | `Prim_int63.{add,mul,sub,eqb}`, the wrapper module below |

Files:

| file | role |
|---|---|
| `main.c` | C driver: calls `body`, prints the returned prim int (`>> 1`: CertiRocq encodes n as the odd word 2n+1) |
| `matmul_main.ml` | OCaml driver: prints `Matmul.main`; under Malfunction a prim int is a plain unboxed OCaml `int`, so no decoding |
| `matmul.mli` | `val main : int`, the interface for the malfunction-generated module (`malfunction cmx` emits no `.cmi`) |
| `prim_int63.mli`, `prim_int63.ml` | the OCaml realizations the attribute file remaps onto |
| `vars.sh` | the bundle's declarations |

All three backends implement int63 (wrapping mod 2^63); Java needs no attribute
file, since its axiom table maps `prim_*_int` to `Rt.PRIM_*_INT63`. These
reference backends only run with `test/check run --ref`.
