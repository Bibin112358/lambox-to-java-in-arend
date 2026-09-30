# lambox-to-java-examples

Sample input for the `lambox-to-java` compiler, kept in its own Arend project
(it depends on `lambox-to-java` and `arend-lib`, see `arend.yaml`).

- `Example.ard`, `ExamplePeano.ard`, `ExampleMatMul.ard`, `ExampleLetChain.ard`,
  `ExampleSort.ard`: hand-written λ□ programs. They are the source of `test`'s
  handwritten corpus programs `example`, `peano`, `matmul` (and its size
  variants), `letchain` and `insertion-sort` (the Arend tutorial's insertion
  sort, with the comparison passed as an argument).
- `ExamplePrint.ard`: printing entry points (`*Java` prints the generated Java,
  `*Sexpr` the peregrine export). `test/tools/regen-arend-asts.sh` typechecks
  them to regenerate the checked-in `test/corpora/handwritten/<name>/prog.ast`
  (and, for `matmul`, the `.attr` files); see `test/README.md`.
- `ModelChecks/`: cheap computational sanity checks of the semantic models in
  `lambox-to-java/src/Semantics/` (the general correctness theorem itself is
  proved in `lambox-to-java/src/Proof/`):
  - `Programs.ard`: the small λ□ programs the other three use, one feature
    each (including three after the Java-long pass);
  - `TheoremInstances.ard`: the proved theorem itself applied to them
    (`Proof/Corollary.ard`), giving the Java value `body()` returns;
  - `DiffRuns.ard`: differential tests, the Arend models against a real JVM;
  - `Sanity.ard`: `idp` checks of single definitions: λ□ rules, name
    mangling, the value relation, Java name resolution and casts, and where
    the Java-long pass keeps or changes a value.

## Running

The Arend CLI resolves the `lambox-to-java` dependency via two `-L` search
roots: the repository root (where `lambox-to-java/` lives) and the directory
containing `arend-lib` (by default `~/.arend/libs`). `-L` replaces the default
root rather than adding to it, so both are needed. `test/lib.sh` /
`test/tools/extract-arend.sh` already do this; to run the CLI on this project
by hand, from this directory:

    java -Xss1g -jar <arend-cli.jar> -L .. -L <arend-lib-root> arend.yaml ExamplePrint:peanoJava
