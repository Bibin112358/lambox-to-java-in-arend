# λ□ to Java, in Arend, with a correctness proof

A compiler from λ□ ("lambda-box", the erased intermediate language of
[MetaRocq](https://github.com/MetaRocq/metarocq) and Peregrine) to Java source,
written in [Arend](https://arend-lang.github.io/), together with a
machine-checked proof that the generated Java computes what the λ□ program
computes. "Java" in the proof means a model of the small, heap-free Java
fragment the compiler emits, with the runtime's closure and data classes built
in; see [What "Java" means in the proof](#what-java-means-in-the-proof).
Internship project at JetBrains.

It needs an Arend build that is not released yet (the String support of
[arend-lang/Arend#131](https://github.com/arend-lang/Arend/pull/131)); see
[Requirements](#requirements).

Lean and Rocq programs reach λ□ through Peregrine / lean-to-lambdabox; this
backend turns them into one Java class plus a small hand-written runtime
(`Rt.java`).

## Example: insertion sort

[`test/golden/insertion-sort.java`](test/golden/insertion-sort.java) is the
complete output (64 lines) for insertion sort on Peano naturals, written as a
λ□ program in
[`lambox-to-java-examples/src/ExampleSort.ard`](lambox-to-java-examples/src/ExampleSort.ard)
after the [Arend tutorial](https://arend-lang.github.io/documentation/tutorial/PartI/universes#correctness-of-insertion-sort).
The golden check (`test/check golden`) makes sure the file is exactly what the
compiler produces today. The source, before erasure:

    le : Nat -> Nat -> Bool                      -- the comparison
    insert : (Nat -> Nat -> Bool) -> Nat -> List -> List
      insert le a nil         = cons a nil
      insert le a (cons x xs) = if le x a then cons x (insert le a xs)
                                          else cons a (cons x xs)
    sort : (Nat -> Nat -> Bool) -> List -> List
      sort le nil         = nil
      sort le (cons a xs) = insert le a (sort le xs)

    main = sort le [3, 1, 4, 1, 2]

The comparison is an ordinary argument: erasure turns the tutorial's
`TotalPreorder` instance into a value. Here is `insert` as generated. Long lines
are not wrapped; that is how the compiler prints them:

```java
public static Object c_ninsert(){
  class C {
    public Object f0(Object py0_){
      return new Rt.Fn(){ public Object apply(Object pLy0_){
        return new Rt.Fn(){ public Object apply(Object pLLy0_){
          final Rt.Data dLLLy0_ = ((Rt.Data)(pLLy0_));
          return ((dLLLy0_.tag == 0) ? new Rt.Data(1, new Object[]{ pLy0_, new Rt.Data(0, new Object[]{  }) }) : ((dLLLy0_.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1_LLLy0_){
            final Rt.Data db1_LLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(py0_)).apply(dLLLy0_.fields[0]))).apply(pLy0_)));
            return ((db1_LLLy0_.tag == 0) ? new Rt.Data(1, new Object[]{ dLLLy0_.fields[0], ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
              return C.this.f0(pw0_);
            } })).apply(py0_))).apply(pLy0_))).apply(dLLLy0_.fields[1]) }) : ((db1_LLLy0_.tag == 1) ? new Rt.Data(1, new Object[]{ pLy0_, pLLy0_ }) : Rt.noBranch(db1_LLLy0_, "b1_LLLy0_")));
          } })).apply(Rt.BOX) : Rt.noBranch(dLLLy0_, "LLLy0_")));
        } };
      } };
    }
  }
  final C z = new C();
  return new Rt.Fn(){ public Object apply(Object pw0_){
    return z.f0(pw0_);
  } };
}
```

How to read it:
- **Constants** become static methods with no arguments: `insert` is
  `c_ninsert()` (`Compiler/Mangle.ard`); the program itself is `body()`.
- **Functions** are curried `Rt.Fn` objects with one `apply`, and every call is
  `((Rt.Fn)f).apply(x)`. Of `insert`'s three parameters, `le` is the method
  parameter `py0_`, and `a` and `xs` are the parameters `pLy0_` and `pLLy0_` of
  two nested closures.
- **A recursive definition (`fix`)** becomes a local class `C` with one method
  `f0` per function. A recursive call goes through `C.this.f0`, and the constant
  returns a closure over an instance `z`.
- **Constructors** are `new Rt.Data(tag, fields)`; the inductive is not stored.
  `cons a nil` is `new Rt.Data(1, new Object[]{ a, new Rt.Data(0, new Object[]{  }) })`.
- **`case`** casts the scrutinee to `Rt.Data` in a `final` local and picks a
  branch with a chain of `tag ==` tests. `Rt.noBranch` is the unreachable
  fall-through. A branch that needs statements of its own (here the inner test
  `le x a`) becomes a closure applied immediately to `Rt.BOX`, since a
  conditional expression cannot contain statements.
- **Local names** are derived from the node's position in the λ□ term,
  not from a counter (`Compiler/NodePath.ard`). The first letter is the kind:
  `p` parameter, `d` scrutinee, `t` branch thunk, `z`/`C` a `fix`'s instance
  and class. The rest is the path to the root: `L` inside a λ, `b1_` the second
  branch, `y0_` the first `fix` function, `w0_` its forwarding closure. The
  proof relies on these names being unique (`Proof/NodePathUnique.ard`).

`test/check run insertion-sort` compiles the class with `runtime/Rt.java`,
runs it and compares its output with the expected value. `Rt` prints a
constructor as its tag followed by its fields. With `--names` it prints
constructor names instead:

    List.cons(Nat.suc(Nat.zero), List.cons(Nat.suc(Nat.zero), List.cons(Nat.suc(Nat.suc(Nat.zero)), ...)))

(shortened and on one line; the runtime indents, and it prints `Nat.zero`
ambiguously as `List.nil|Bool.true|Nat.zero`, see `test/README.md`).

## What is proved

`Proof/Statement.ard` states the theorem, `Proof/MainTheorem.ard` proves it
(`correctClosedFO`):

> For a λ□ program whose body and constant bodies are closed: if λ□ (with the
> shipped axioms for `Nat`/`Int63`/... arithmetic) **terminates** and evaluates
> the program to a first-order value `v`, then the generated class's `body()`
> method, run in the Java model with the model of the shipped runtime,
> **returns** a value that corresponds to `v`: it does not throw and does not
> get stuck.

The hypothesis "λ□ evaluates the program to `v`" is a finite big-step
derivation (`EvalProgram`), so the theorem is only about terminating programs.
For a program that diverges, or gets stuck in λ□, it says nothing, not even
that the Java diverges too.

`backendShipped` in the same file covers every result, including functions:
Java returns the closure compiled from the λ□ function.

`Proof/Corollary.ard` (`correctChecked`) restates the theorem for use on a
concrete program: the closedness and first-order hypotheses become Boolean
checks, and the conclusion names the returned Java value exactly. It is applied
to 15 programs in `lambox-to-java-examples/src/ModelChecks/TheoremInstances.ard`
(`box`, `let`, beta, applying `box`, a primitive, projection, `fix`, Peano
addition through a constant, Lean's `Nat.add`/`Nat.sub`/overflow, a `case` on
a boolean axiom result, and two programs after the Java-long pass), which shows
the hypotheses can be met, i.e. the theorem is not vacuous.

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
(`Proof/NodePathUnique.ard`, `Proof/PathFresh.ard`). A Java `long` is a
`JLong` (`Compiler/JavaLong.ard`), an integer with a proof that it lies in
[-2^63, 2^63), both in the Java AST's literals and in the model's `vLong`, so
an out-of-range long cannot even be written.

The Java model resolves names as Java does: variables and types are separate
namespaces, a type name means a local class in scope before a top-level class
(so `Object` and `java.lang.Object` are one class), and a cast succeeds exactly
when the value's class is a subtype of the target (the JVM's `checkcast`). The
proof shows that generated code never shadows `Rt` (every name it binds starts
with a lowercase letter or `C`), so its casts to `Rt.Fn`/`Rt.Data` mean the
runtime's classes.

### What "Java" means in the proof

The theorem is not about the JVM, or the Java Language Specification as a
whole. Its target is a model (`Semantics/JavaEval.ard`, `Semantics/JavaValue.ard`)
of exactly the fragment the compiler emits (`Compiler/JavaAst.ard`), and that
model is simpler than Java in four ways:

- **Closures and data are built in.** Application `((Rt.Fn)f).apply(x)`,
  closures `new Rt.Fn(){..}`, constructors `new Rt.Data(tag, fields)` and the
  reads `d.tag == n` / `d.fields[i]` are dedicated AST nodes that the model
  interprets directly, as values `vClos` and `vData`. The model does not run
  the Java code of `Rt.Fn`/`Rt.Data`, nor dynamic dispatch through an
  interface. The target is therefore "Java plus a function type and a data
  type", which we trust `runtime/Rt.java` to implement.
- **No heap.** There is no store, no object identity and no assignment: values
  are immutable trees, and a closure captures its environment by value. That is
  enough because generated code never mutates anything (locals are `final`,
  `fix` is a local class rather than a mutable cell) and never compares
  references. Allocation, garbage collection, memory limits and stack depth are
  not modelled either.
- **The rest of the runtime is a parameter.** Arithmetic and the other runtime
  constants (`Rt.PRIM_ADD_INT63`, ...) are given by an abstract interface
  (`RtSpec`) with a model (`Semantics/RtInt63.ard`), not by interpreting
  `Rt.java`. Only uncaught exceptions are modelled; there is no `try`/`catch`.
- **Only the emitted shapes have a meaning.** The model is less permissive
  than Java: forms the generator never produces are *stuck* even when they are
  valid Java, e.g. `e.f` on anything but `Rt`, `new Object()`, or a method call
  with two arguments. Code `javac` would reject is stuck too, since the model
  has no type checker (e.g. `d.tag` on a value that is not an `Rt.Data`). This
  is sound for our purpose: the theorem proves that `body()` *returns*, so it
  also shows that generated code never reaches these cases. But the model is a
  semantics of the compiler's output, not of a Java subset in general. (A
  failed cast is not stuck: it throws `ClassCastException`, as in Java.)

What the model does follow is Java's evaluation order, name resolution (JLS 6.5),
casts (`checkcast`) and `long` wraparound. So "verified λ□ to Java" means:
verified down to this model, with the step from the model to a real JVM covered
only by tests.

**Trusted, not proved:**
- the printer from the Java AST to text (`Compiler/JavaPrint.ard`);
- that the real JVM behaves like the Java model (`Semantics/JavaEval.ard`),
  including that `javac` accepts the output and that the stack is deep enough
  (the model has unbounded recursion depth; `Rt.runMain` runs programs on a
  thread with a 1 GB stack);
- that `runtime/Rt.java` behaves like its model (`Semantics/RtInt63.ard`), and
  that the model's class table (`knownClasses`, `supertypes` in
  `Semantics/JavaEval.ard`) matches the JDK and `Rt.java`.

These are exercised by the tests, including an automated differential test
that runs small programs in both Arend models and on the real JVM
(`test/check diff`).

**Scope of the statement.**
- Programs must be closed (λ□'s substitution captures free variables, which no
  scope-respecting compiler can imitate).
- Only terminating programs are covered: programs λ□ cannot evaluate
  (divergent or stuck) are outside the theorem, as in MetaRocq's erasure and
  verified-extraction theorems. (CompCert, by contrast, also preserves
  divergence.)
- Integers are Lean's machine integers as lean-to-lambdabox emits them
  (63-bit), not unbounded naturals.
- Some axioms the compiler does emit are modelled on neither side: they have no
  λ□ meaning in `Semantics/LambdaBoxAxioms.ard`, and their runtime constants
  are missing from `Semantics/RtLong.ard`. λ□ gets stuck on them, so programs
  that use them are outside the theorem; they are only tested:

  | Lean axiom | `Rt` constant | tested by (`test/check run`, unless noted) |
  |---|---|---|
  | `Nat.pow` | `PRIM_POW_LONG` | `test/check rt`; `lean-binarytrees`, `lean-deriv` |
  | `Nat.decEq`, `decLe`, `decLt` (return `Decidable`) | `PRIM_DEC_{EQ,LE,LT}_LONG` | `lean-qsort`, `lean-binarytrees`, `lean-unionfind` |
  | `Int.*` (`ofNat`, `neg`, `add`, `mul`, `ediv`, `emod`, ...) | `INT_*` | `lean-deriv` |
  | `Array.*` (`mk`, `push`, `getInternal`, `set!`, `swap`, `size`, ...) | `ARRAY_*` | `test/check rt` (indices); `lean-qsort`, `lean-unionfind`, `lean-matmul` |
  | `Eq.rec`, `Eq.ndrec` | `EQ_REC` | `lean-deriv` |

## Known limitations

- **Constants are re-evaluated on every use.** `const k` compiles to a call of
  the zero-argument static method `c_k()`, which runs the constant's whole body
  each time; nothing is memoized. A constant used twice is computed twice, so
  a DAG of N constants that share each other costs 2^N calls, where Peregrine's
  OCaml and C backends compute each constant once. The value is still correct
  (the theorem is about values, not cost). The regression program
  `const-blowup` (`test/corpora/regression/`) shows it: at N = 30 Java takes
  about 12 s against OCaml's 0.0 s, and interpreted (`-Xint`) the time doubles
  with each level. The fix, a lazily initialized static field per constant,
  needs static state in the Java model and a new `const` case in the proof, so
  it is not done.
- **Stack depth.** λ□ `fix` compiles to non-tail recursion; `Rt.runMain` runs
  programs on a thread with a 1 GB stack, and deeper recursion throws
  `StackOverflowError` (the model has no depth limit, see above).
- **Performance** is a constant factor behind OCaml/C on most programs; see
  "Performance" in `test/README.md`.

## Layout

    lambox-to-java/                 the main Arend library
      src/Compiler/                 THE TRANSLATION (what runs on every compile)
        LambdaBox.ard                 λ□ syntax (MetaRocq's EAst)
        JavaAst.ard                   the Java fragment we generate
        ToJava.ard                    the generator λ□ -> JavaAst  (start here)
        JavaPrint.ard                 JavaAst -> text (trusted)
        JavaAxioms.ard                axioms realized by the runtime
        JavaLong.ard                  Java's `long`: an Int in range, and wraparound
        Mangle.ard, NodePath.ard      Java names for constants / local variables
        Int63.ard, LongRewrite.ard    machine-integer helpers and a rewrite pass
        Serialize.ard, StringUtil.ard helpers
        CtorNames.ard                 constructor-name table for readable output (debugging only)
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

    test/check quick        # typecheck every module + golden Java + rt (~25 min)
    test/check proofs       # typecheck every module, each in its own run
    test/check golden       # generated Java unchanged (~1 min)
    test/check run peano    # compile a program, run it on the JVM, compare
    test/check diff         # λ□ model vs Java model vs real JVM
    test/check rt           # unit tests of runtime/Rt.java

Typecheck modules one per invocation: checking several at once can hide
errors.

### Requirements

- **An unreleased Arend.** The code needs `String` as an arend-lib type
  (`\import Data.String`: a record over its UTF-8 bytes, with `==`, `++` and
  `Debug.putStrLn`). This project is what prompted that change, submitted as
  [arend-lang/Arend#131](https://github.com/arend-lang/Arend/pull/131), which
  is **not merged yet**. In the released Arend 1.12.0, `String` is a
  constructor-less Prelude type and arend-lib has no `Data.String`, so this
  project does not typecheck there. The change touches both the typechecker
  and arend-lib, so both the CLI and arend-lib have to come from that PR's
  branch (`Bibin112358/Arend`, `master`):

      git clone -b master https://github.com/Bibin112358/Arend.git
      cd Arend && ./gradlew :cli:jarDep    # -> cli/build/libs/cli-1.12.0-full.jar

  and use that checkout's `arend-lib/` as arend-lib, with its extension
  (`arend-lib/meta`, built by the same Gradle project).
- A JDK (tested with JDK 26) and Python 3.
- Optional, for `test/check run`: Peregrine, to import `.ast` programs; see
  `test/README.md`.

Nothing in the repository depends on where these are installed. Tell the test
harness where they are by copying `test/local.sh.example` to `test/local.sh`
(gitignored) and setting at least `AREND_JAR`, plus `AREND_LIBDIR` if arend-lib is
not in `~/.arend/libs`. Everything else is found on `PATH`, and each setting can
also come from the environment (see "Prerequisites" in `test/README.md`).
