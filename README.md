# λ□ to Java, in Arend, with a correctness proof

A compiler from λ□ ("lambda-box", the erased intermediate language of
[MetaRocq](https://github.com/MetaRocq/metarocq) and Peregrine) to Java source,
written in [Arend](https://arend-lang.github.io/), together with a
machine-checked proof that the generated Java computes what the λ□ program
computes. Internship project at JetBrains.

Lean and Rocq programs reach λ□ through Peregrine / lean-to-lambdabox; this
backend turns them into one Java class plus a small hand-written runtime
(`Rt.java`).

## What is proved

`Proof/Statement.ard` states the theorem, `Proof/MainTheorem.ard` proves it
(`correctClosedFO`):

> For a λ□ program whose body and constant bodies are closed: if λ□ (with the
> shipped axioms for `Nat`/`Int63`/... arithmetic) evaluates the program to a
> first-order value `v`, then the generated class's `body()` method, run in the
> Java model with the model of the shipped runtime, **returns** a value that
> corresponds to `v`: it does not throw and does not get stuck.

`backendShipped` in the same file covers every result, including functions:
Java returns the closure compiled from the λ□ function.

`Proof/Corollary.ard` (`correctChecked`) restates the theorem for use on a
concrete program: the closedness and first-order hypotheses become Boolean
checks, and the conclusion names the returned Java value exactly. It is applied
to seven programs (beta, axioms, overflow, projection, `fix`, Peano addition
through a constant) in `lambox-to-java-examples/src/ModelChecks/TheoremInstances.ard`,
which shows the hypotheses can be met, i.e. the theorem is not vacuous.

The proof follows MetaRocq's structure in two steps:

1. **λ□ by substitution ⇒ λ□ with environments** (`Proof/SubstToEnv.ard`), the
   analogue of MetaRocq's `eval_to_eval_named`.
2. **λ□ with environments ⇒ Java** (`Proof/EnvToJava.ard`). Values are related
   by construction: a Java closure is related to a λ□ closure when it was
   compiled from the same body with a related environment (`Proof/CompileValue.ard`),
   like MetaRocq's `compile_value`.

The generic result (`Proof/BackendCorrect.ard`) holds for any runtime model and
λ□ axiom oracle that satisfy the listed hypotheses; `MainTheorem` discharges
them for the shipped ones. Among those facts: the two axiom oracles agree
(`Proof/OracleShipped.ard`), mangled Java names are injective
(`Proof/MangleInj.ard`) and generated local names are unique
(`Proof/NodePathUnique.ard`, `Proof/PathFresh.ard`).

**Trusted, not proved:**
- the printer from the Java AST to text (`Compiler/JavaPrint.ard`);
- that the real JVM behaves like the Java model (`Semantics/JavaEval.ard`),
  including that `javac` accepts the output and that the stack is deep enough
  (the model has unbounded recursion depth; `Rt.runMain` runs programs on a
  thread with a 1 GB stack);
- that `runtime/Rt.java` behaves like its model (`Semantics/RtInt63.ard`).

These are exercised by the tests, including an automated differential test
that runs small programs in both Arend models and on the real JVM
(`test/check diff`).

**Scope of the statement.** Programs must be closed (λ□'s substitution captures
free variables, which no scope-respecting compiler can imitate). Programs λ□
cannot evaluate (divergent or stuck) are not covered, as in CompCert and
MetaRocq. Integers are Lean's machine integers as lean-to-lambdabox emits them
(63-bit), not unbounded naturals.

## Layout

    lambox-to-java/                 the main Arend library
      src/Compiler/                 THE TRANSLATION (what runs on every compile)
        LambdaBox.ard                 λ□ syntax (MetaRocq's EAst)
        JavaAst.ard                   the Java fragment we generate
        ToJava.ard                    the generator λ□ -> JavaAst  (start here)
        JavaPrint.ard                 JavaAst -> text (trusted)
        JavaAxioms.ard                axioms realized by the runtime
        Mangle.ard, NodePath.ard      Java names for constants / local variables
        Int63.ard, Int64Rewrite.ard   machine-integer helpers and a rewrite pass
        Serialize.ard, StringUtil.ard helpers
      src/Semantics/                MODELS the proof is stated against
        LambdaBoxEval.ard             λ□ big-step semantics (MetaRocq's EWcbvEval)
        LambdaBoxEnv.ard              λ□ with environments (intermediate)
        LambdaBoxAxioms.ard           the λ□ meaning of the axioms
        LambdaBoxRun.ard              a fuelled λ□ interpreter, for testing
        JavaValue.ard, JavaEval.ard   semantics of the generated Java fragment
        RtLong.ard, RtInt63.ard       model of runtime/Rt.java
        Res.ard                       result type of the fuelled evaluators
      src/Proof/                    THE PROOF  (start at Statement.ard)
      runtime/Rt.java               hand-written Java runtime
    lambox-to-java-examples/        hand-written λ□ example programs, and
      src/ModelChecks/              executable sanity checks of the models
    test/                           test harness; see test/README.md

Nothing in `Compiler/` imports `Semantics/` or `Proof/`, and `Semantics/`
does not import `Proof/`.

## Checking it

Everything goes through one script; see `test/README.md` for details.

    test/check quick        # typecheck every module + golden Java (~25 min)
    test/check proofs       # typecheck every module, each in its own run
    test/check golden       # generated Java unchanged (~1 min)
    test/check run peano    # compile a program, run it on the JVM, compare
    test/check diff         # λ□ model vs Java model vs real JVM

Requirements: a development build of the Arend 1.12 CLI, arend-lib, and a JDK.
Tool paths are configured in `test/lib.sh`. Typecheck modules one per
invocation: checking several at once can hide errors.
