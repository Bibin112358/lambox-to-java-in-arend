
This is for anyone who wants to continue with this work.
First read [README.md](README.md) for the overview.

## Design and implementation choices

Highlighting some modeling decisions for the compiler.

### Everything as Objects

We treat Java as an untyped language, in the sense that we export everything as Objects.
The source and the compiler should guarantee type safety.

### `fix` modelling

`fix` is a construct in lambda-box, to define mutual recursive functions.
Our first modeling idea was to model functions as Objects,
and have an array of objects to store and reference each function.
Now, we have decided to model it as one class, with each function as a method,
that they can refer to.
This way, there is no need for any assignments, as it would be for the array case.

### Mangling of names

Avoid naming collisions when translating kernames.
It relies on `_`, see  [Mangle.ard](lambox-to-java/src/Compiler/Mangle.ard).

### Fresh name mechanism

Avoid variable name collisions.
Global counter is inconvenient, as it is stateful.
So the names reflect the path it took in the AST.
In every branch a different latter is added to ensure uniqueness.
It is modeled as an inductive data type, for proving uniqueness,
and then translated to a String.

### Primitives (Rocq vs Java)

Lambda-box is developed using Rocq (formerly Coq) in mind.
This is why its primitive integer uses an unsigned 63 bit integer.
We added a second primitive to reflect Java Long.
This would be more convenient for the Java target.
I am not quite sure what our guarantees regarding our primitive models are currently.

### Python script hack: Translate S-expression -> Arend AST

Arend was not intended as a programming language.
That is why I had to first design a usable String implementation in Arend.
It still lacks any kind of input.
Thus, we cannot read lambda-box programs written as S-expressions in text files.
We have a Python script, that takes such a lambda-box file and outputs an Arend file,
containing the lambda-box program modeled as the AST defined in Arend.

### Abstracted Java: closure, data, no store, no heap

As mentioned in the [README.md](README.md), we do not model Java directly,
but an abstracted simpler version of it.
We add things like closure and data, that are implemented using inner classes and objects,
for easier verification.
We also made sure to have no assignement operation, except for final local variable assignement,
such that we do not need to model the heap, and thus stateful memory.

### Other Java research

We looked into other existing research in Java formalization.
Most do not fit, as they are either more about the type system,
missing features, like anonymous inner classes, or overly complex for our scenario.
That is why we defined our own for this particular use case of
an untyped, pure Java with closure and data types.


- **Featherweight Java (FJ)** — Igarashi, Pierce, Wadler (OOPSLA '99 / TOPLAS '01)
- **Jinja / JinjaThreads** — Klein & Nipkow (TOPLAS 2006), Lochbihler: a Java-like language, VM, and verified compiler in Isabelle.
- **Bicolano** (Coq, MOBIUS project, Pichardie et al.): sequential JVM bytecode semantics; used in Barthe–Pichardie–Rezk's certified non-interference verifier. The most reusable Coq artifact if your proofs live in Coq/Rocq alongside MetaCoq's λ□.
- **K-Java** — Bogdănaș & Roșu (POPL 2015): complete Java 1.4 semantics in the K framework, with the *dynamic* semantics written over an elaborated, type-annotated program, cleanly separated from the static semantics.

- **Java_s** — Drossopoulou & Eisenbach, "Java is type safe — probably" (ECOOP '97 / '99).
- **Java_light / Bali** — Nipkow & von Oheimb, "Java_light is type-safe — definitely" (POPL '98); von Oheimb's thesis (2001) extends it with a Hoare logic, all in Isabelle/HOL.
- **Syme**, "Proving Java type soundness" (1999, Declare).
- **Middleweight Java (MJ)** — Bierman, Parkinson, Pitts (2003): adds statements, assignment, object identity, `null`.
- **Lightweight Java (LJ)** — Strniša, Sewell, Parkinson (OOPSLA '07): specified in Ott, generating Coq/Isabelle/HOL.
- **Welterweight Java** — Östlund & Wrigstad (2010), adds concurrency.
- **Stärk, Schmid, Börger**, *Java and the Java Virtual Machine* (2001): ASM semantics built in layers — Java_I (imperative expressions/statements), Java_C, Java_O, Java_E, Java_T. The Java_I layer is essentially an expression/statement-only imperative core.
- **JavaFAN** — Farzan, Chen, Meseguer, Roșu (2004): Java and JVM semantics in Maude/rewriting logic.
- **Cenciarelli, Knapp, Reus, Wirsing** (1999): event-based SOS for multithreaded Java, including expression evaluation order.

### Proof: stricter Java eval semantics

As mentioned above we have our own Java semantics, modeled as an eval function.
As mentioned in the [README.md](README.md) it is stricter than necessary.
It might get stuck on theoretical permissible Java code, but which our compiler will not omit.
This is a difference to the Java semantics, but which does not affect the proof, as it does not weaken the statement.

### Closely Reviewed

Here is a list of files that have been closely reviewed,
as AI was used heavily in this project.

- LambdaBox.ard (lambda-box AST, ported)
- JavaAst.ard (our Java AST)
- ToJava.ard (the main compiler parts)
- (JavaPrint.ard (trusted printer))
  - did not check very closely (might need better Arend syntax to review)
- Statement.ard (the main proven theorem)
- JavaEval.ard, JavaValue.ard, Res.ard (our Java semantics)
  - refactored for easier reading
  - seems reasonable, but there is no (formal or informal) argument about correctness
- Semantics/LambdaBox*.ard (LambdaBox semantics)
  - not reviewed
  - ported from MetaRocq (formerly MetaCoq)
- Proof/*.ard
  - not reviewed
  - no need for close review, as it is typechecked by Arend


## Future Work

This is currently just an experimental prototype, showing a proof of concept:
It is possible to write a compiler in Arend, use Arend as a programming language,
and proof properties about it.

### Motivation and direction

First, it should be made clear what direction this project should go
and what purpose it should fulfill.
These decide for which trade-offs one wants to optimize for:
trust, verifiability, performance, usability, feature-rich, interoperability ...

If verified extraction is the goal,
then one should probably do more testing and bring the semantic model closer to Java.
Even here performance might become an issue, if it is too impractical slow.

It could be used to let users define metas in Arend, as opposed to Java.
This would not necessarily require verification, as metas should not be able to break Arends type checker.
In that case, performance, usability and interoperability is more important.

### Arend to lambda-box

This project was motivated by code extraction from Arend to a JVM language.
We now have a way to compile lambda-box to Java.
Now, an Arend to lambda-box pipeline would be the natural next step.

### I/O Arend

### move string utils to arend-lib

### refactor Java print for easier trusted review? (needs maybe better string helpers)

### Performance (compiler and runtime)
- trampolining
- Java, Kotlin
- multi-arity calls

#### Const sharing performance

### Peregrine and LambdaANF

### closed of program vs component and interaction with other components

### closer Semantics to Java

### Mutation Testing?
- primitives
- parsing and printing issues
