# Tests

One entry point, `test/check`, answers four questions:

| command | question | how | time |
|---|---|---|---|
| `test/check proofs` | Do the compiler, the semantics and the correctness proof typecheck? | every module of `lambox-to-java/src/{Compiler,Semantics,Proof}` and `lambox-to-java-examples/src/ModelChecks`, **each in its own Arend run**, 2 at a time | ~15–25 min |
| `test/check golden` | Is the generated Java unchanged? | generate Java for 4 programs in one Arend run, diff against `golden/*.java` | ~40 s |
| `test/check run P...` | Do compiled programs compute the right value on the JVM? | import `.ast` → generate Java → `javac` → `java`, compare with the corpus' expected value | ~40–70 s per program |
| `test/check diff` | Do the Arend models agree with the real JVM? | `ModelChecks.DiffRuns` prints, for 14 small programs, the Java and the values computed by the λ□ semantics and by the Java-fragment semantics; the Java is run for real and all three values must be equal | ~1.5 min |

Before a commit run **`test/check quick`** (= `proofs` + `golden`). Run
`run`/`diff` as well after touching `Compiler/ToJava.ard`, `runtime/Rt.java` or the
models. Every command exits 0 iff everything passed; `test/check <cmd> -h` lists
its options.

Why one Arend run per module in `proofs`: typechecking several modules in one CLI
invocation has been seen to hide errors (e.g. "String literals require the String
type to be in scope"). Each run costs ~20 s of arend-lib parsing on top of the
module itself (`Semantics.JavaEval` ~10 min, `Compiler.ToJava` ~7 min,
`Proof.MainTheorem` ~4 min on a loaded machine). The CLI's exit status is
meaningless, so any `[ERROR]` or `[GOAL]` line counts as a failure. Logs are in
`work/proofs/<Module>.log`.

## Common invocations

    test/check proofs Proof.MainTheorem       # one module
    test/check golden --update                # accept an intended change (prints the diff)
    test/check golden --set cover             # + lean-deriv, the only program using Eq.rec / Int axioms (~2 min more)
    test/check run                            # list all programs, run nothing
    test/check run peano leanbench-unit peregrine-rocq-nat
    test/check run --all                      # all 56 programs (~30 min)
    test/check run --ref matmul               # also run Peregrine's OCaml / C backends
    test/check run --names insertion-sort     # print the value with constructor names (debugging)

`run` prints one line per program: its verdict (`ok`, `wrong`, `gen-fail`,
`build-fail`, `run-fail`, `timeout`, `xfail`, `skip-no-tool`, or `disagree` with
`--ref`), which oracle was used (`expected` = the corpus value, `backends` = only
agreement between backends, `none` = only "did not crash") and the seconds for
gen/build/run per backend. The table is also written to `work/results.tsv`.

### Readable values (`--names`)

A compiled constructor is an `Rt.Data(tag, fields)` without its inductive, so
values normally print as bare tags (`1(\n  0\n)`). For debugging, `run --names`
prints them by name and shows the value instead of comparing it:

    List.cons(
      Nat.suc(
        List.nil|Bool.true|Nat.zero
      ),
      ...

How: `gen` also writes `work/<p>/java/Prog.names`, one line per constructor of
the program's inductives (`tag npars nargs inductive constructor`, from
`Compiler/CtorNames.ard`; one more Arend run), and `run` starts Java with
`-Dlambox.names=Prog.names`. `Rt` then names a `Data` by every constructor with
its tag and field count. That can be ambiguous, mostly for constructors without
fields (above: tag 0 with no fields), and all candidates are printed, separated
by `|`. The table is not part of the generated class, so the generated Java, the
Java model and the proofs are unaffected; without the property `Rt` prints bare
tags as before. By hand: `LAMBOX_NAMES=1 stages/java.sh gen|build|run ...`, or
`java -Dlambox.names=<file> ...` with a table printed by `progNames` of an
imported module.

## Prerequisites

Paths are set in `lib.sh` (edit them there):

* Arend CLI, a **development 1.12 build** (`~/arend-lang-bibin/cli/build/libs/cli-1.12.0-full.jar`), arend-lib in `~/.arend/libs`;
* a JDK (`~/.jdks/openjdk-26.0.1`), Python 3;
* for `run` only: Peregrine (`peregrine ast box` rewrites the `.ast` inputs before import);
* for `run --ref` only: OCaml + `malfunction` (opam switch `peregrine`), gcc + the CertiRocq runtime.

Each Arend run takes up to 2 GB. `proofs -j N` sets the parallelism. On a shared
machine set `AREND_WRAP=/path/to/lock-script` to put a command in front of every
Arend JVM. A missing tool makes a `run` row `skip-no-tool`, never a failure.

## Programs (corpora)

A program is a λ□ `.ast` file (Peregrine's s-expression format) plus its expected
printed value. Each `corpora/<name>.sh` prints one tab-separated row per program:
`program`, `ast`, `expected`, `backends`, `runtime`, `xfail`, `note`.

| corpus | programs | source |
|---|---|---|
| `handwritten` | 17 | `corpora/handwritten/<p>/prog.ast`, checked in: exported from `lambox-to-java-examples` (`tools/regen-arend-asts.sh`) or extracted from Lean |
| `lean-benchmarks` | 26 | an upstream checkout of the Lean benchmark programs (`tools/extract-lean-benchmarks.sh`) |
| `peregrine` | 14 | the Peregrine test suite's `.ast` files |

Expected values live in `corpora/*.expected`. They were obtained from the
reference backends and checked by hand. A corpus whose upstream checkout is
missing prints no rows, and `check` warns about it.

The **reference backends** (`stages/ocaml.sh`, `stages/c.sh`, runtimes in
`runtime/`) are no longer on the default path: every value they could confirm is
already recorded in an `.expected` file, and they need a large opam/CertiRocq
toolchain. They are still useful to create the expected value of a NEW program,
and as a timing control for performance work: `run --ref`.

## Performance

A handful of programs run long enough to measure the generated code (the others
finish in ~0.1 s, which is JVM start-up). Use the programs whose `.ast` is checked
in, so that the input is identical before and after a change:

| program | stresses | java run | ocaml | c |
|---|---|---|---|---|
| `matmul` (130³) | int63 arithmetic | 1.8 s | 1.1 s | 0.6 s |
| `matmul250` (250³) | the same term, 7× the work | 23.7 s | 15.0 s | 9.8 s |
| `lean-deriv` | closures, deep `case`, 13 Lean axioms | 13.1 s | 5.1 s | – |
| `lean-const-fold` | building and folding a 2²⁰-node tree | 9.8 s | 2.1 s | – |
| `lean-binarytrees` | allocation and GC | 1.8 s | 0.1 s | – |
| `letchain` | long `let` chains (the only program sensitive to the `letIn` encoding) | | | |

Measured 2026-08-31 (best of 5; i7-1160G7, OpenJDK 26), before later encoding
changes. Treat them as orders of magnitude and compare A/B runs made in the same
session. With `--ref`, the OCaml/C times are the control for machine noise.
Measured design decisions: `case` as a ternary chain (not `switch`) and `fix` as
a local class (not a `Fn[]` knot) were neutral to slightly faster; `letIn` as a
β-redex instead of `final` locals was ~5× slower on `letchain` and was rejected.
Java runs use `-Xss512m` (λ□ `fix` is non-tail recursion) and
`-XX:-DontCompileHugeMethods` (generated methods exceed HotSpot's 8000-bytecode
JIT limit; `lean-deriv` 24 s → 6 s).

## Layout

    check                 the entry point (proofs, quick; dispatches the others)
    golden.py run.py diff.py common.py
    golden/               expected generated Java (golden check)
    corpora/              program lists, expected values, hand-written .ast files
    stages/{java,ocaml,c}.sh  gen / build / run of one backend
    runtime/              OCaml/C runtimes of the reference backends (see their READMEs)
    arend/                Arend project for generated programs; src/ is generated and gitignored
    lib.sh                tool paths and shell helpers
    tools/
      import-ast.sh       .ast -> arend/src/Imported/<Module>.ard (peregrine ast box + ast-to-arend)
      ast-to-arend        the .ast -> Arend translator (Python)
      extract-arend.sh    typecheck MODULE:DEF and capture what its putStrLn prints
      regen-arend-asts.sh re-export corpora/handwritten .ast files from the Arend examples
      extract-lean-benchmarks.sh  rebuild the lean-benchmarks .ast files from Lean
    work/                 scratch, gitignored (per-program build dirs, logs, results.tsv)

Generated programs live in a separate Arend project, `test/arend` (depends on
`lambox-to-java`), so that the 55 imported modules (~19 MB) do not end up in the
core library's sources. Arend has no file IO, so every generated artefact is
harvested from what a `putStrLn` prints during typechecking. The harness removes
`bin/` caches before each Arend run, because a cached module prints nothing.
