# Tests

One entry point, `test/check`, answers five questions:

| command | question | how | time |
|---|---|---|---|
| `test/check proofs` | Do the compiler, the semantics and the correctness proof typecheck? | every module of `lambox-to-java/src/{Compiler,Semantics,Proof}` and `lambox-to-java-examples/src/ModelChecks`, **each in its own Arend run**, 2 at a time | ~25 min (measured: 25.6 min for 45 modules on a shared machine) |
| `test/check golden` | Is the generated Java unchanged? | generate Java for 5 programs in one Arend run (4 covering the generator's features, plus `insertion-sort`, the example shown in the top-level README), diff against `golden/*.java` | ~1 min |
| `test/check run P...` | Do compiled programs compute the right value on the JVM? | import `.ast` → generate Java → `javac` → `java`, compare with the corpus' expected value | ~25–50 s per program, mostly the Arend run (`lean-deriv` ~3.5 min) |
| `test/check diff` | Do the Arend models agree with the real JVM? | `ModelChecks.DiffRuns` prints, for 18 small programs, the Java and the values computed by the λ□ semantics and by the Java-fragment semantics; the Java is run for real and all three values must be equal | ~1–1.5 min |
| `test/check rt` | Does `runtime/Rt.java` behave on edge values? | `rt/RtTest.java`: unit tests of single runtime constants, in particular those the Arend model does not cover (`Nat.pow`, Lean array indices) | ~5 s |

Before a commit run **`test/check quick`** (= `proofs` + `golden` + `rt`). Run
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
    test/check run --all                      # all 60 programs (~30–40 min)
    test/check run --ref matmul               # also run Peregrine's OCaml / C backends
    test/check run --names insertion-sort     # print the value with constructor names (debugging)
    test/check run --long matmul              # compile after the Java-long pass (below)

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

### Java `long` arithmetic (`--long`)

`run --long` compiles each program after `Compiler/LongRewrite.ard`, which turns
Rocq's `Uint63` literals and operations (`prim_*_int`, wrapping mod 2^63) into
Java `long` ones (`prim_*_long`, `Rt.PRIM_*_LONG`). The value, and so the
comparison with the expected value, is the same while no intermediate result
reaches 2^63; `ModelChecks/Sanity.ard` and `check diff` include cases on both
sides of that bound. The correctness theorem covers the rewritten program like
any other λ□ program.

## Prerequisites

No path in the repository is specific to one machine. Tools are found on `PATH`
or through environment variables. The easiest way to set them is to copy
`local.sh.example` to `test/local.sh` (gitignored) and fill it in; `lib.sh`
reads it first. The variables are:

| needed for | tool | variable (default) |
|---|---|---|
| everything | Arend CLI built from the unmerged String PR [arend-lang/Arend#131](https://github.com/arend-lang/Arend/pull/131), not the 1.12.0 release (see "Requirements" in the top-level README) | `AREND_JAR` (none: must be set) |
| everything | that PR's arend-lib | `AREND_LIBDIR`, the directory containing `arend-lib/` (`~/.arend/libs`, the CLI's default) |
| everything | a JDK (tested with 26), Python 3 | `JAVA`, `JAVAC` (`$JAVA_HOME/bin/java`, else `java` on `PATH`), `PYTHON` (`python3`) |
| `run` | Peregrine (`peregrine ast box` rewrites the `.ast` inputs before import) | `PEREGRINE` (`peregrine`) |
| the `peregrine` / `lean-benchmarks` corpora | upstream checkouts | `PEREGRINE_DIR`, `LEAN_TO_LAMBDABOX_DIR` (unset: corpus skipped); `LAKE` (`lake`) to regenerate the Lean benchmarks |
| `run --ref` | OCaml + `malfunction`, gcc + the CertiRocq runtime | `OPAM_SWITCH_NAME` (`peregrine`; its `bin/` is put on `PATH`), `CERTIROCQ_RT` (found in that switch) |

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
| `regression` | 3 | `corpora/regression/<p>/prog.ast`, checked in, exported from `lambox-to-java-examples/src/Example{ConstBlowup,MangleCollision,AxiomCollision}.ard`. Each pins down one defect of this compiler; its `meta` says which, and whether it is fixed or open (below) |
| `lean-benchmarks` | 26 | an upstream checkout of the Lean benchmark programs (`tools/extract-lean-benchmarks.sh`) |
| `peregrine` | 14 | the Peregrine test suite's `.ast` files |

Expected values: a checked-in program (`handwritten`, `regression`) has its own
in the `expected=` line of `corpora/<corpus>/<p>/meta`; the two upstream corpora,
whose `.ast` files are not checked in, have one line per program in
`corpora/lean-benchmarks.expected` and `corpora/peregrine.expected`. They were
obtained from the reference backends and checked by hand. A program with an
empty expected value is only checked for not crashing (`none` in `run`'s
output). A corpus whose upstream checkout is missing prints no rows, and
`check` warns about it.

The **regression** programs, run with `run --ref <p>` to see the comparison:

| program | defect | status | what `run` shows |
|---|---|---|---|
| `const-blowup` | constants are re-evaluated on every use: a DAG of N constants costs 2^N calls | **open** (top-level README, "Known limitations") | `ok` (the value is right); the cost is in the java run time, ~12 s at N = 30 against ~0.0 s for OCaml/C |
| `mangle-collision` | `A_B.f` and `A.B.f` got the same Java name | fixed (3bbc010) | `ok` |
| `axiom-mangle-collision` | an axiom `_Nat.add` resolved to Lean's `Nat.add`, so Java silently printed 13 instead of 42 | fixed (3bbc010) | `xfail` for java: it now throws "axiom not implemented", as intended (the Java backend does not read Peregrine's attribute files); a return to 13 would be `wrong` |

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
λ□ `fix` is non-tail recursion, so `Rt.runMain` runs the program on a thread
with a 1 GB stack (`-Dlambox.stack=<bytes>`; `-Xss512m` only sizes the main
thread), and Java runs use
`-XX:-DontCompileHugeMethods` (generated methods exceed HotSpot's 8000-bytecode
JIT limit; `lean-deriv` 24 s → 6 s).

## Layout

    check                 the entry point (proofs, rt, quick; dispatches the others)
    golden.py run.py diff.py common.py
    golden/               expected generated Java (golden check)
    rt/RtTest.java        unit tests of runtime/Rt.java (rt check)
    corpora/              program lists, expected values, checked-in .ast files
    stages/{java,ocaml,c}.sh  gen / build / run of one backend
    runtime/              OCaml/C runtimes of the reference backends (see their READMEs)
    arend/                Arend project for generated programs; src/ is generated and gitignored
    lib.sh                tool lookup and shell helpers
    local.sh.example      template for test/local.sh, this machine's tool locations (gitignored)
    tools/
      import-ast.sh       .ast -> arend/src/Imported/<Module>.ard (peregrine ast box + ast-to-arend)
      ast-to-arend        the .ast -> Arend translator (Python)
      extract-arend.sh    typecheck MODULE:DEF and capture what its putStrLn prints
      regen-arend-asts.sh re-export the checked-in .ast files from the Arend examples
      extract-lean-benchmarks.sh  rebuild the lean-benchmarks .ast files from Lean
    work/                 scratch, gitignored (per-program build dirs, logs, results.tsv)

Generated programs live in a separate Arend project, `test/arend` (depends on
`lambox-to-java`), so that the imported modules (one per program, ~19 MB) do not end up in the
core library's sources. Arend has no file IO, so every generated artefact is
harvested from what a `putStrLn` prints during typechecking. The harness removes
`bin/` caches before each Arend run, because a cached module prints nothing.
