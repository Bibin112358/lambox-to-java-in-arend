# Test harness

Compiles λ□ programs with this repository's Arend-implemented backend and with
two reference backends (Peregrine's OCaml/Malfunction and C), runs the result,
and checks the value that comes out.

A program is always a λ□ s-expression file (`prog.ast`). One driver, `run.py`,
owns the matrix of (program × backend); everything else is a small script it
calls.

    test/run.py                      # list the programs there are, run nothing
    test/run.py matmul peano         # run exactly these
    test/run.py --all                # every program, every backend it declares

## Prerequisites

Nothing has to be installed to run the harness: a stage whose toolchain is
missing exits 3, the row is recorded as `skip-no-tool`, and the run prints one
warning per backend. It never aborts, and a missing toolchain is never a
failure. Tool paths are hard-coded in `lib.sh` (edit them there if a tool
moves on this machine) rather than configurable through the environment:
Arend CLI (a **development** 1.12 build), a JDK, Peregrine, Python 3, OCaml
(`ocamlopt`/`malfunction`), and gcc plus the CertiRocq runtime.

## Usage

    test/run.py [PROGRAM...] [--all] [--repeat N] [--timeout S]

Selection is program names, and nothing else. With no name and no `--all` the
run lists what there is (name, backends, corpus, note) and stops; an unknown
name is an error that suggests the nearest ones. A program always runs on every
backend it declares — there is no way to ask for one, because a run of a single
backend cannot use the differential oracle (see below).

* `--repeat N` — run the RUN stage N times and keep the best time; generation
  and build are deterministic and are paid once.
* `--timeout S` — per-stage timeout in seconds (default 300; java generation is
  30-60 s on this corpus). The stage runs in its own process group, so a
  timeout kills the compiled program too.

The exit status is non-zero if any program failed **or** if two backends of one
program disagreed. Every program appends one row to `results.tsv`; the scratch
of a run (generated code, binaries, `output.txt`) is in
`work/<program>/<backend>/`.

While iterating, two programs are worth running (about two minutes together,
most of it java generation):

    test/run.py matmul lean-matmul-peano

`matmul` has an upstream value and all three backends; `lean-matmul-peano` is
the same computation with no primitives and no attributes, so a break in the
axiom machinery shows up as one of the two going red rather than both.
Everything else belongs to `--all` before a commit.

## Layout

    run.py         the driver: the matrix, the timing, the statuses, the table
    lib.sh         tool paths (hard-coded) + require_tool + run_cmd helpers
    stages/        one script per backend: java.sh, ocaml.sh, c.sh, each
                   taking `gen|build|run` as its first argument
    corpora/       one script per corpus, each printing TSV rows:
                     handwritten.sh     our own programs, one directory each
                     regression.sh      our own DEFECT WITNESSES, one dir each
                     lean-benchmarks.sh lean-to-lambdabox's benchmark suite (upstream)
                     peregrine.sh       peregrine's own .ast fixtures (upstream)
    runtime/       C/OCaml driver bundles: lean, peano, int63 (each a vars.sh + README)
    tools/         manual tools: extract-arend.sh, import-ast.sh, ast-to-arend,
                   eval-ast.sh, regen-arend-asts.sh, extract-lean-benchmarks.sh
    work/          gitignored scratch, work/<program>/<backend>/
    results.tsv    append-only history, one row per program per run

A stage script takes positional arguments only and knows nothing about
programs or corpora; it can always be re-run by hand:

    test/stages/java.sh gen corpora/handwritten/matmul/prog.ast work/matmul/java Matmul

Its contract with `run.py` is the exit status: **3** = a tool is missing,
**4** = this backend cannot run this program, any other non-zero = failure.

## Adding a program to the handwritten corpus

Create `corpora/handwritten/<name>/` with a `prog.ast` (the λ□ program) and a
`meta` file of `key=value` lines — plain data, deliberately *not* sourced.

    expected=2197000            # the value every backend must print; empty = no such oracle
    backends=java ocaml c       # which backends can consume this program
    runtime=int63               # a runtime/ bundle, for the C/OCaml drivers; empty for java-only
    xfail=                      # non-empty = the REASON this program is known to fail
    note=130^3; the corpus' only int63-vs-long witness

The OCaml and C stages also need `prog.attr` next to `prog.ast` (Peregrine
requires the flag); copy `runtime/peano/empty.attr` if the program realizes no
axioms. A program whose axioms map to *different* native symbols in C ships an
additional `prog-c.attr`, which `stages/c.sh gen` prefers when present.

If the program is written in Arend rather than coming from Lean/Rocq, add its
`\func` to the `lambox-to-java-examples` project, not `lambox-to-java` itself
(see `lambox-to-java-examples/README.md`), and run
`tools/regen-arend-asts.sh <name>` once to serialize and commit the `.ast`.

## The `regression` corpus: our own defect witnesses

`corpora/regression/` has the identical layout and `meta` format, and differs
only in intent. A `handwritten` program is a computation we want the backends to
get right; a `regression` program is a **claim about the generator**, built so a
specific defect is the only thing its result can be about — it is worthless as a
computation. `mangle-collision` returns a boolean nobody cares about, and the
point is that `javac` rejects the class.

So a program here may be **expected to fail with `xfail=` empty**, deliberately
keeping `run.py --all` non-zero until the bug is fixed. That is the opposite of
the `xfail` convention the wide external corpora need (a documented limitation,
absorbed), which is why the two live in separate corpora. Currently:

| program | claim | status |
|---|---|---|
| `const-blowup` | every `const` reference re-executes its body, so a DAG of constants costs 2^N in Java and N in OCaml/C | `ok` — the gap is a timing, not a failure |
| `mangle-collision` | `mangleKername` is not injective, so `javac` rejects a duplicate method | **`build-fail(java)` — open bug** |
| `axiom-mangle-collision` | `javaAxioms` is keyed by *mangled* names, so an unrelated axiom is silently realized as a Lean primitive | **`wrong(java)` — open bug** |

`--all` is therefore expected to exit non-zero, naming exactly those two. Read
each program's `meta` for the mechanism, the file and line it lives on, and (for
`const-blowup`) the measurements that chose its size parameter.

## Adding a corpus

Drop one executable bash script `corpora/<name>.sh` that prints one TSV row per
program on stdout and nothing else. The columns are fixed:

    program  ast  expected  backends  runtime  xfail  note

`ast` is a path relative to `test/`, or absolute. A corpus whose upstream is
not installed must print **no rows and exit 0**: `run.py` then reports it as
unavailable instead of failing. `corpora/handwritten.sh` is the template.

The two upstream corpora (`lean-benchmarks`, `peregrine`) each read a checkout
that is not part of this repository, at `$HOME/lean-to-lambdabox` and
`$HOME/peregrine-tool`, and treat it as read-only. `lean-benchmarks` also needs
its `.ast` cache produced once with `tools/extract-lean-benchmarks.sh`.

## Statuses

    ok                the backend ran and, if the row has one, matched `expected`
    wrong             it ran and produced a different value than `expected`
    gen-fail          the gen stage failed (our generator, or peregrine's)
    build-fail        the build stage failed (javac / ocamlopt+malfunction / gcc)
    run-fail          the compiled program exited non-zero
    timeout           a stage exceeded --timeout; its process group was killed
    skip-unsupported  exit 4: this backend cannot run this program (no driver in
                      the runtime bundle)
    skip-no-tool      exit 3: the toolchain is not installed on this machine
    disagree          two backends of one program printed different values
    xfail             a known, documented failure of this program

Only `wrong`, `gen-fail`, `build-fail`, `run-fail`, `timeout` and `disagree` are
failures; the two `skip-*` statuses and `xfail` let a wide external corpus say
what it cannot do without going permanently red. A program's row reports the
worst thing that happened, with the backend that caused it (`build-fail(ocaml)`).
`xfail` absorbs a genuine failure and *only* that: a `wrong` value is still
reported as wrong on an `xfail` program.

## The two oracles

Every row says in its `check` column what actually verified it:

1. **`expected`** — the program's `expected` value, compared against what it
   printed. It comes from *outside* this project: upstream's own recorded
   answer, Lean's `#eval`, or a value derived by hand from the program's
   constructor declaration order.
2. **`differential`** — the backends of one program agreed, with no value to
   compare against.
3. **`none`** — neither applied: one backend, no value. The run only
   established that the program did not crash; the summary names these.

Values are compared with whitespace deleted (our Java printer indents
constructor data by nesting depth; the other backends do not), and a value
longer than 200 characters is recorded and compared as a head plus a `sha256`
of the whole of it. The value itself is always in
`work/<program>/<backend>/output.txt`.

## Known limitations

* **Comparison ignores whitespace**, so a program printing two adjacent numbers
  (`2 3`) would compare equal to one printing `23`. No current program prints
  more than one value.
* **The OCaml `lean` runtime bundle can only print a `Nat`** (its driver is
  `print_endline (Z.to_string Bench.main)`), so a program returning `Unit` or a
  list declares `java` only.
* **The OCaml drivers read malfunction export slot 0, not `$main`.** Peregrine
  emits `(export $<c> $main)`, where `$<c>` is the constant the program's `main`
  refers to; Malfunction module fields are positional and every bundle's
  hand-written `.mli` declares a single `val main`, so the driver picks up the
  *first* export. A program whose `main` is a bare `tConst` is unaffected
  (`matmul` exports `($sumRes $main)`, both 2197000) — which is every program
  here, so nothing has ever caught this. Make a new program's entry point a
  named constant: with an *application* as `main`, slot 0 held a remapped
  closure and the driver printed it as an int. See
  `corpora/regression/axiom-mangle-collision/meta`.
* **No artifact caching**: every run regenerates from the `.ast`; java
  generation costs 20-60 s per program because an Arend CLI start loads
  arend-lib.
* **Serial execution**: timings are ball-park and can come from a dirty tree
  (only the timestamp identifies a `results.tsv` row).
* **`peregrine eval`** (Peregrine's own evaluator) is not a backend of the
  matrix — its output is a rendered λ□ term, not a comparable value. It
  survives as the standalone `tools/eval-ast.sh`, run by hand.
