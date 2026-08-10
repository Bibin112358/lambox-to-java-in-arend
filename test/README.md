# Test harness

Takes a λ□ program defined in Arend, produces the target code for each backend,
compiles it, runs it, times every stage and prints the program's output.
There are **no assertions** — correctness is judged by eye, with the backends'
outputs next to each other.

## Layout

One script per verb; scripts call scripts, no `case`/`if` dispatch tables.

    config.sh           tool paths (all env-overridable) + require_tool, produce
    load-case.sh        sourced by every backend script: config + timing + the case
    lib/log.sh          info / warn / die (everything to stderr)
    lib/timing.sh       timed <case> <backend> <stage> -- cmd...
    extract-arend.sh    <MODULE:DEF> [outfile] -> the artifact that definition printed
    build-java.sh       <case>  extract Prog.java + copy Rt.java + javac
    run-java.sh         <case>  build-java.sh + run-timed.sh
    build-c.sh          <case>  extract .ast/.attr + peregrine c + gcc
    run-c.sh            <case>  build-c.sh + run-timed.sh
    build-ocaml.sh      <case>  extract .ast/.attr + peregrine ocaml + malfunction + ocamlopt
    run-ocaml.sh        <case>  build-ocaml.sh + run-timed.sh
    run-timed.sh        <case> <backend> -- cmd...   time, print and tee output.txt
    run-case.sh         <case> [backend...]          one case, its declared backends
    run-all.sh          [case...]                    every case, then summary.sh
    summary.sh          [case...]  timing table + every backend's output
    case-backends.sh    <case>  the case's BACKENDS, one per line
    case-note.sh        <case>  the case's NOTE (expected result)
    cases/<case>/case.sh  declarative case description (variables only)
    work/               gitignored scratch: work/<case>/<backend>/...

## Usage

    test/run-all.sh                                         # everything + summary
    test/run-case.sh matmul                                 # one case, all its backends
    test/run-case.sh matmul java                            # one backend only
    test/build-c.sh matmul                                  # a single stage, by hand
    test/extract-arend.sh ExamplePrint:peanoJava            # print generated Java
    test/extract-arend.sh ExamplePrint:matMulSexpr prog.ast # write the λ□ s-expression
    test/extract-arend.sh ExamplePrint:matMulSexprPretty    # ... indented, for reading

## How artifacts are obtained

`lambox-to-java/src/ExamplePrint.ard` has one `\func` per artifact, each of the
form `putStrLn <text>`, so *typechecking* the definition prints it.
`extract-arend.sh` runs the CLI narrowed to a single `MODULE:DEF` and slices the
text between the CLI's `--- Typechecking ... ---` and `--- Done (NNms) ---`
lines, which replaces the old manual copy-paste into `lambox-to-java/out*/`.

The CLI is never invoked with `--serialize`: a binary cache would suppress the
print on subsequent runs.

## Prerequisites

* A **development build** of Arend (`AREND_JAR`, e.g.
  `cli-1.11.0-full.jar`). The library relies on the new `String`
  implementation, which is not released yet (expected in 1.13).
* A JDK (`JAVA`, `JAVAC`); `JAVA_STACK=-Xss1g` is required, since evaluating a
  whole generated program during typechecking is stack-hungry.
* The fixed Java runtime `Rt.java` (`Fn`, `Data`, `BOX`, the primitive int
  ops `PRIM_{ADD,MUL,SUB,EQB}_{INT,LONG}` and the `unbound`/`freeVar` failure
  helpers for ill-formed λ□ input) from
  `JAVA_RUNTIME_DIR` (`lambox-to-java/runtime`). It is hand-written, not
  generated: `build-java.sh` copies it into the work dir and compiles it
  together with the generated `Prog.java`. The primitive ops realize matmul's
  four arity-2 λ□ axioms — the Java counterpart of remapping them onto
  CertiRocq's `prim_int63_*` via peregrine's `--attributes`; the mapping lives
  in `javaAxioms` in `ToJava.ard`.
* For the C/OCaml backends: `PEREGRINE`, the CertiRocq runtime
  (`CERTIROCQ_RT`, providing `gc_stack.c` and `prim_int63.c`), `gcc`,
  `ocamlopt` and `malfunction` (the latter comes from the opam switch
  Peregrine was built in; `config.sh` puts `$OPAM_SWITCH_BIN` on `PATH`).

Missing tools are reported by `require_tool` with a clear message.

## Integer representation of the Java backend

`JAVA_INT` picks how λ□ primitive ints are represented in the generated Java
(the `JavaTarget` record in `ToJava.ard`); both variants use the same
`Rt.java`:

    test/run-case.sh matmul java               # JAVA_INT=bigint (default)
    JAVA_INT=long test/run-case.sh matmul java

* `bigint` — `java.math.BigInteger` literals and `Rt.PRIM_*_INT`: unbounded,
  never overflows, but boxed arithmetic and no wraparound.
* `long` — `Long.valueOf(..L)` literals and `Rt.PRIM_*_LONG`, i.e. Java's
  built-in 64-bit integers: much faster (matmul: ~1.1s vs ~8.1s run time), wraps
  at 2^64 and signed.

Neither matches the source semantics: a λ□ `prim (primInt, _)` is a 63-bit
machine integer with cyclic (mod 2^63) arithmetic — MetaRocq
`erasure/theories/EPrimitive.v` (`primIntModel (i : PrimInt63.int)`) and the
[Rocq refman on primitive integers](https://rocq-prover.org/doc/master/refman/language/core/primitive.html)
(unsigned view `Uint63`, signed view `Sint63`) — which is what the C backend
(CertiRocq `prim_int63_{add,mul,sub,eqb}`) and the OCaml backend (unboxed OCaml
`int`, cf. `ExtrOCamlInt63`) implement. Our own AST is unbounded too
(`LambdaBox.ard`'s `PrimModel primInt => Int`), so the three layers agree only
while values stay well below 2^62 — true for all current cases. A future
`JAVA_INT=int63` (backed by a `Rt.PRIM_*_INT63` family normalizing mod 2^63) is
the planned fix; see the int63-mismatch section of `RESEARCH_AND_PLAN.md`. Until
then, comparing the `java` output against `c`/`ocaml` for a case whose values
exceed 2^62 is expected to differ.

A case declares its Java producer as `...:<name>Java$JAVA_DEF_SUFFIX`, and
`config.sh` turns `JAVA_INT` into that suffix (`""` / `"Long"`), so the switch
applies to every case without touching any backend script. Both variants build
into the same `work/<case>/java` dir, i.e. the last run wins.

## Cases

A case is a directory under `cases/` with a `case.sh` holding *variables only*,
plus any driver files it needs (`main.c` for C; `matmul_main.ml`,
`prim_int63.ml/.mli` and the hand-written `matmul.mli` for OCaml — `malfunction
cmx` emits no `.cmi`, so the interface is compiled separately).

`BACKENDS` lists the backends the case supports; `example` and `peano` only
declare `java`, since they return constructor data rather than a primitive int
and have no C/OCaml driver yet.

### Producers

Every artifact is obtained by running a *producer command* declared by the case
(`JAVA_PRODUCER`, `AST_PRODUCER`, `ATTR_C_PRODUCER`, `ATTR_OCAML_PRODUCER`),
which writes the artifact to stdout. That is the extension point: to test a λ□
program that comes from an s-expression file instead of Arend, declare

    AST_PRODUCER="cat $CASE_DIR/prog.ast"

and, once the deserializer exists, point it at that instead — the backend
scripts do not change.

### Attribute files

`matmul`'s four primitive-op axioms are realized per backend: for C on the
CertiRocq runtime's `prim_int63_{add,mul,sub,eqb}` (so `prim_int63.c` must be on
the `gcc` line — the default Peregrine harness links only `gc_stack.c`), for
OCaml on the hand-written `Prim_int63` wrapper (the OCaml backend only consumes
`reConstS`, i.e. `"Module.value"`; the rest of `RemappedConstant` is ignored).

ABI notes: CertiRocq encodes a prim int `n` as the odd machine word `2n+1`,
hence the `>> 1` in `main.c`. In OCaml, `tPrim primInt` is a plain `int`, and
nullary inductive constructors are plain ints too (ordinal among nullary
constructors only) — only non-nullary constructors become real blocks.

This replaces the former hand-run `lambox-to-java/outc/build-and-run.sh` and
`outocaml/build-and-run-ocaml.sh`, which required copy-pasting the printed
`.ast`/`.attr` lines into `lambox-to-java/out*/` by hand.
