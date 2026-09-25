# lambox-to-java-examples

Sample input for the `lambox-to-java` compiler, kept in its own Arend project
(it depends on `lambox-to-java` and `arend-lib`, see `arend.yaml`).

- `Example.ard`, `ExamplePeano.ard`, `ExampleMatMul.ard`, `ExampleLetChain.ard`:
  hand-written λ□ programs. They are the source of `test`'s handwritten corpus
  programs `example`, `peano`, `matmul` (and its size variants) and `letchain`.
- `ExamplePrint.ard`: printing entry points (`*Java` prints the generated Java,
  `*Sexpr` the peregrine export). `test/tools/regen-arend-asts.sh` typechecks
  them to regenerate the checked-in `test/corpora/handwritten/<name>/prog.ast`
  (and, for `matmul`, the `.attr` files); see `test/README.md`.
- `ModelChecks/`: cheap computational sanity checks of the semantic models in
  `lambox-to-java/src/Semantics/` (the general correctness theorem itself is
  proved in `lambox-to-java/src/Proof/`):
  - `Agreement.ard`: λ□ programs run by the λ□ runner and, compiled, by the
    Java-fragment evaluator, with the results compared;
  - `CorrectInstances.ard`: concrete instances of the correctness statement,
    checked by running both models, plus negative checks;
  - `TheoremInstances.ard`: the proved theorem itself applied to concrete
    programs (`Proof/Corollary.ard`), giving the Java value `body()` returns;
  - `JavaEvalRuns.ard`: the Java-fragment evaluator on generated programs;
  - `DiffRuns.ard`: differential tests, the Arend models against a real JVM.

## Running

The Arend CLI resolves the `lambox-to-java` dependency via two `-L` search
roots: the repository root (where `lambox-to-java/` lives) and the default
library root (`~/.arend/libs`, for `arend-lib`). `-L` replaces the default
root rather than adding to it, so both are needed. `test/lib.sh` /
`test/tools/extract-arend.sh` already do this; to run the CLI on this project
by hand:

    java -Xss1g -jar <arend-cli.jar> -L <repo-root> -L ~/.arend/libs arend.yaml ExamplePrint:peanoJava
