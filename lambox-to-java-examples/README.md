# lambox-to-java-examples

Hand-written λ□ example programs and their printing entry points
(`ExamplePrint.ard`), kept in their own Arend project so they don't clutter
`lambox-to-java`'s own sources -- that project is the compiler; this one is
sample input for it.

This project depends on `lambox-to-java` (see its `arend.yaml`). The six
`Example*.ard` programs are the source of `test`'s six Arend-authored corpus
programs; `test/tools/regen-arend-asts.sh` typechecks `ExamplePrint`'s
definitions to (re)generate the checked-in `prog.ast` (and, where a program
realizes axioms, its `.attr` files) from them -- see `test/README.md`.

They fall into two corpora, because they are two different kinds of thing.
Three are sample *computations*; three exist because a λ□ program is the only
precise way to state a property of the *generator*, and are worthless as
computations:

| module | corpus / program | what it is |
|---|---|---|
| `Example.ard` | `handwritten/example` | the original smoke-test term |
| `ExamplePeano.ard` | `handwritten/peano` | unary `1 + 3`; fix / case / construct |
| `ExampleMatMul.ard` | `handwritten/matmul` | 130³ over primitive int63, with axioms |
| `ExampleConstBlowup.ard` | `regression/const-blowup` | every `const` reference re-executes its body, so a DAG of constants costs 2^N in Java and N in OCaml/C |
| `ExampleMangleCollision.ard` | `regression/mangle-collision` | `mangleKername` is not injective: `javac` rejects a duplicate method (**open bug**) |
| `ExampleAxiomCollision.ard` | `regression/axiom-mangle-collision` | the same non-injectivity silently realizes an axiom as an unrelated primitive (**open bug**) |

The last two are expected to FAIL, with `xfail=` deliberately empty, so
`test/run.py --all` exits non-zero until the mangling is fixed -- which is why
they live in `regression/` rather than `handwritten/`. Each program's `meta`
file records the mechanism, the file and line it lives on, and for
`const-blowup` the measurements that chose its size parameter.

## Running

The Arend CLI resolves the `lambox-to-java` dependency via two `-L` search
roots: the repository root (where `lambox-to-java/` lives) and the default
library root (`~/.arend/libs`, for `arend-lib`) -- `-L` replaces the default
root rather than adding to it, so both are needed. `test/lib.sh` /
`test/tools/extract-arend.sh` already do this; to run the CLI on this project
by hand:

    java -Xss1g -jar <arend-cli.jar> -L <repo-root> -L ~/.arend/libs arend.yaml ExamplePrint:peanoJava
