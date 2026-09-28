# Critical review, and the last week (Wed 23 Sep – ~Tue 30 Sep 2026)

## Context

`lambox-to-java-in-arend` compiles MetaRocq λ□ to Java, in Arend, with a formalization (λ□ semantics, Java-fragment semantics, a correctness statement over the real generator, and a machine-checked refutation of that statement at the shipped runtime). It is an internship deliverable with about one week left. The question is what to do with that week so that the work survives the author's departure and reads as what it is.

Caveat: the working tree was being edited during the review (an int63 representation: `Rt.java`, `JavaAxioms.ard`, `Formal/{Correct,LbAxioms}.ard` modified; `Int63.ard`, `Formal/RtInt63.ard` created at 12:42 today). Everything below cites HEAD `80549ed` unless marked *WT* (working tree).

## Verdict in one paragraph

The strongest thing here is the *shape* of the evidence: a theorem statement that quantifies over the real `compileClass` (`Formal/Correct.ard:185-197`), obligations named and sized rather than hidden (`:243-272`), a refutation and a proven weakness of the statement (`CorrectInstances.ard:345,394`), a soundness proof by induction (`LambdaBoxSound.ard:137`), an injectivity proof (`NodePathUnique.ard:303`), and a harness with two external oracles and provenance-pinned benchmarks. The weakest things are all *bookkeeping*: three known compiler bugs, one a silent wrong answer, have sat on an unmerged branch since 27 Aug while `--all` stays green; the design record (6,200 lines in `notes/`) is gitignored and exists on no remote; ~10 header comments and the top-level README say things the tree contradicts, in a project whose stated rule is "no status claim a command cannot verify"; the evidence of record is three weeks and ~20 commits stale; and the last-day int63 rework is half-landed. None of that needs new ideas. All of it fits in a week, and a successor will judge the project by exactly these things.

## Findings

### A. Correctness of the compiler (open, documented, not on main)

1. **Silent wrong answer.** The axiom table is keyed by *mangled* names (`JavaAxioms.ard:56-81`), and mangling is not injective: `joinDirs` joins with `_` (`ToJava.ard:78`) while `javaIdentPart` passes `_` through (`StringUtil.ard:77`). An axiom at `_Nat.add` is realized as Lean's `Nat.add`. Regression program `axiom-mangle-collision` exists only on branch `test/regression-corpus-const-sharing-and-mangling` (`3c76662`).
2. **javac rejection.** Same root cause: `mpFile ["A_B"]` and `mpFile ["A","B"]` mangle equal. `StringUtil.ard:79-82` still advertises "a collision-free encoding".
3. **Exponential re-evaluation of shared constants.** Every `const` is a zero-arg static call re-running its body (`ToJava.ard:182`); a DAG of N constants costs 2^N. Every other recorded gap is a bounded constant factor; this one is unbounded.
4. Latent `Rt.java` issues (HEAD): `idx` truncates a Nat index via `intValue()` (`:569`); `curry` under-application returns a closure as the program value silently (`:549-561`); `PRIM_POW_LONG` is O(exponent) (`:408-413`); `emod` breaks at `Long.MIN_VALUE` (`:485-490`); `BOX` prints `java.lang.Object@hash`, non-deterministic, contrary to its comment (`:65-67`); `fvar` names reach `litStr` unescaped (`ToJava.ard:178` → `JavaAxioms.ard:191`) contradicting `JavaPrint.ard:32-34`.

### B. Formalization (honest, but three headers overclaim)

5. `Correct.ard:192` says `Correct` is "REFUTED". Only `CorrectAtProgram 200 …` is (`CorrectInstances.ard:345`); lifting to `Correct` needs `FuelMono`, which is open.
6. `JavaEval.ard:54-59` lists "four nodes the generator never emits" as the stuck states; there are ~12 `rStuck` sites and several are reachable through `javaAxioms` (`PRIM_DIV_LONG`, `INT_*`, `ARRAY_*`), as `Agreement.ard:353-355` itself demonstrates (`natDivDisagrees`).
7. `check-formal.sh:11-13` ("typechecking IS the checking … asserted by `idp`") holds for 3 of 11 modules; for the other 8 it checks well-formedness only. Still valuable, differently.
8. What is actually proved by induction: `evalT-sound` (+ 2 helpers), 20 lemmas in `NodePathUnique`, `int63NotRelated`. Everything else is 59 `idp` facts on programs of ≤ 1+3 Peano depth; benchmark-size terms OOM the normalizer (`Agreement.ard:193-199`). No `{?}`, no postulates anywhere. This is fine, and should be *said in the README*.

### C. Evidence (stale)

9. Last `run.py --all`: **2026-08-31**, 55 programs, 136 ok / 2 xfail / 0 wrong. Since then ~20 commits including generator changes (`case` → ternary 09-01, path datatype 09-15) with only `peano`/`leanbench-even` smoke rows. `test/README.md:38` says `--all` before a commit.
10. No mutation-test table (item #1 of `notes/INTERNSHIP_TODOS.md`), so it is unknown whether the suite *can* fail. `check=none` on 6 programs; the TODO names 4.
11. `example`'s meta claims the row reports `gen-fail` under xfail; `run.py:296-297` records the literal `xfail`.

### D. Documentation and repo hygiene

12. **`notes/` is gitignored** (`.gitignore:11`): `RESEARCH_AND_PLAN.md`, `INTERNSHIP_TODOS.md`, `tojava-design-notes.md`, two decision records are on no remote.
13. `notes/RESEARCH_AND_PLAN.md:1307,437-445` claims "Done" for `ExampleEval.ard`, `run-ast-suite.sh`, `run-lean-benchmark-suite.sh`; none is in the tree. The 08-24 decision record cites `test/NOTES.md` 11 times; it does not exist.
14. Root `README.md` lists 4 of 10 `Formal/` files, has no prerequisites (dev Arend 1.12 build, `-Xss1g`, JDK, Peregrine, OCaml, gcc), no end-to-end command, no mention of the int63 mismatch, the refutation, or `golden.py`. The examples README lists 3 of 4 examples.
15. Dangling pointers: `LambdaBox.ard:20,93` → "KNOWN MISMATCH in ToJava.ard" (it is in `JavaAxioms.ard:22`); `Rt.java:169-176` → `JavaTarget`/"axiom table in ToJava.ard" (gone); `Rt.java:175` "two families" (three). Five unresolved `TODO`/`Q` in `LambdaBox.ard:49,94,138,146,157`. `Serialize.ard:261` `LambdaBoxToSrting` (typo in an entry point); `ToJava.ard:351-352` dead.
16. `lambox-to-java/src/Generated.ard` (306 KB, "Generated by arend-to-lambdabox") is untracked, unignored, and inside `sourcesDir`, so every build typechecks it. `exportToHTML/`, `.air/`, `.junie/`, empty `AGENTS.md`/`CLAUDE.md` untracked; one `.air` plan is *staged*. A July stash (`stash@{0}`) is still around. `main` is 2 commits ahead of both `origin` and `arend`.
17. *WT*: the int63 rework's comments say "DONE, and it is now the DEFAULT" (`Rt.java:193`) and cite `Formal/RtInt63.ard` (created minutes later) and `Formal/CorrectInstances.ard` (lives in the examples project). After it, the whole `_INT` BigInteger family (~20 constants, ~150 lines) and `PRIM_SUB_LONG` are dead. Half a change is the worst state to leave a repo in.

## The week, in priority order

Uses the author's own filter (`INTERNSHIP_TODOS.md`): survives departure, bounded, buys understanding. ~4.5 working days remain if the end is Fri 26, ~6 if Tue 30.

### Day 1 — close or shelve the int63 change; make the repo safe to leave

- **Decision gate for the *WT* int63 work** (morning). Run `test/tools/check-formal.sh` and `test/golden.py --set cover`. If both are green and the header comments match the tree, land it as one commit whose message states: `OracleAgree` now holds at the int63 pair for `+ - * eqb`, `Correct` is no longer refuted at the shipped pair, limitation (L) (Lean `Nat` truncation) still stands. Delete or explicitly justify the now-dead `_INT` family and `PRIM_SUB_LONG` in `Rt.java`. If not green by noon: `git stash` → `git switch -c int63-repr` → commit as WIP there, restore `main`, and record it as a next step in the handover. Either outcome is fine; an uncommitted diff on the last day is not.
- **Un-ignore `notes/`** (`.gitignore:11`) and commit the five design documents. Prepend a one-paragraph "historical; superseded where it disagrees with `HANDOVER.md`" banner to `RESEARCH_AND_PLAN.md` instead of editing 1,300 lines; fix only the three false "Done" lines (`:1307`, `:437-445`) and the `test/NOTES.md` references (point at `test/README.md` / `benchmarks.md`).
- **Hygiene, 20 minutes:** add `/lambox-to-java/src/Generated.ard`, `/exportToHTML/`, `/.air/`, `/.junie/`, `/AGENTS.md`, `/CLAUDE.md` to `.gitignore`; `git restore --staged .air/plans/push-to-arend-lang-remote.plan.md`; inspect and drop `stash@{0}`; discard the no-op `.iml` diff; push `main` to `origin` and `arend`.

### Day 2 — make the known bugs visible, refresh the evidence

- **Land the regression corpus.** Take `3c76662`'s files by path (`git checkout 3c76662 -- lambox-to-java-examples/src/Example{ConstBlowup,MangleCollision,AxiomCollision}.ard test/corpora/regression.sh test/corpora/regression`), re-run `tools/regen-arend-asts.sh` for the three programs, and fix the stale line citations in the three `meta` files (`ToJava.ard:182`, `:78-85`, `:295`). Keep `xfail=` empty on purpose so `--all` goes red on three known defects, as the branch intended. Update `StringUtil.ard:79-82` to say what is true: collision-free for *generated* names (`NodePathUnique`), not for source-derived ones.
- **One full sweep**, unattended: `test/run.py --all` (~30 min) then `test/tools/check-formal.sh`. Record the commit hash and the counts (expect 55 ok + 3 regression red) in `test/benchmarks.md`'s provenance style. This is the sentence the handover needs: "at commit X, N programs, M failures, all M documented".

### Day 3 — the handover document and a README a stranger can use

- **Create `HANDOVER.md`** at the root, committed. Sections, each checkable by a command:
  1. Trusted base, file by file, with what each is checked against (`LambdaBox.ard` vs MetaRocq `EAst`; `LambdaBoxEval.ard` vs `EWcbvEval.v`; `JavaAst`+`JavaEval` vs Jinja/JLS citations; `JavaPrint.ard` trusted; `Rt.java` trusted, 695 lines).
  2. What is proved by induction / checked by `idp` / stated / refuted / known-weak (L). Take the table from §B.8.
  3. The three open bugs with their regression programs and root cause (§A.1-3), and the `Rt.java` latent list (§A.4).
  4. Open obligations with the size estimates already in `Correct.ard:238-267`.
  5. Coverage gaps: `check=none` programs (6), `proj`/`fvar`/unguarded `fix` never exercised (`test/README.md:62-64`), normalizer OOM on benchmark-size agreement checks.
  6. How to run everything: prerequisites, `golden.py`, `run.py`, `check-formal.sh`, the daemon, the `-L` flags for the examples project.
  7. Three next steps, in order: (i) injective mangling (escape `_` in `javaIdentPart`, make `_` the exclusive separator, regenerate golden + axiom keys), closes bugs 1 and 2; (ii) memoize constants (`static Object` field with a lazy holder), closes bug 3; (iii) `FuelMono`, mechanical, ~size of `JavaEval.ard`.
- **Rewrite `README.md`** (≤ 80 lines): what it is, a 5-command quickstart, prerequisites, the full `Formal/` listing, one paragraph stating the result honestly (statement over the real generator; refuted at HEAD or fixed by int63 depending on Day 1; (L) stands; soundness and injectivity proved), and a pointer to `HANDOVER.md`. Fix `lambox-to-java-examples/README.md:3-13` (add `ExampleLetChain`, `Formal/`).

### Day 4 — comment truth, then one bounded measurement

- **Comment fixes, each a one-liner** (≈1 hour, then `check-formal.sh` + `golden.py`): `Correct.ard:192` ("refuted at a fixed clock; lifting needs `FuelMono`"); `JavaEval.ard:54-59` (replace the four-node census with unreachable-for-generated-code vs reachable-through-the-runtime-instance, citing `RtLong.ard:22-24`); `check-formal.sh:11-13`; `LambdaBox.ard:20,93` pointers; `Rt.java:65-67,169-176`; `JavaPrint.ard:32-34` (name the `fvar` exception); `example/meta`'s `gen-fail` claim; resolve or delete the five `TODO`/`Q` in `LambdaBox.ard`; fix `LambdaBoxToSrting` if `grep -rn LambdaBoxToSrting` shows only the two sites.
- **Mutation table, reduced to 5 mutations** (half day): the author's own #1 item. Inject one at a time into `ToJava.ard`/`Rt.java`: swap two constructor tags; off-by-one in `Rt.curry`; drop the `npars` offset in `pushFields`; shift a `bvar` index; swap two `case` branches. Run `golden.py --set smoke` (35 s) and, where a value is needed, `run.py peano matmul`. Record "5 injected, N caught by golden, M by run, K by neither" in `test/README.md`. `git stash` between mutations; commit nothing but the table.

### Day 5 (and any spare) — final sweep, push, buffer

- Rerun `golden.py --set cover`, `check-formal.sh`, and `run.py --all` if anything under `src/` changed after Day 2. Push to both remotes. Confirm `git ls-tree -r arend/main | grep -E '^\.(air|junie)|^AGENTS|^CLAUDE|Generated\.ard'` is empty and `git status --short` is empty.
- Spare time goes to next-step (i), injective mangling, only if a full day remains: it changes every generated name, so it needs `golden.py --update` on all sets and a fresh `--all`. Otherwise it stays as the first item of `HANDOVER.md` §7.

### Explicitly not this week

No proof of `FuelMono`/`SubstLemma`, no constant memoization unless mangling is already done, no new corpora or backends, no CertiCoq probe, no `Rt.java` bug fixes beyond comments (each needs a regression program to be worth anything; list them instead).

## Acceptance criteria

- `git status --short` is empty on `main`; `main` equals `origin/main` and `arend/main`.
- `notes/*.md` are tracked; `Generated.ard`, `exportToHTML/`, `.air/`, `.junie/` are ignored.
- `HANDOVER.md` exists; every status sentence in it names a command or a file:line.
- `test/results.tsv` has a `--all` sweep dated ≥ Day 2 at the final commit; its counts appear in `benchmarks.md` with the commit hash.
- `test/corpora/regression/{const-blowup,mangle-collision,axiom-mangle-collision}` exist on `main` and `run.py --all` exits non-zero *because of them and nothing else*.
- `grep -n REFUTED lambox-to-java/src/Formal/Correct.ard` shows the qualified wording; `grep -rn 'test/NOTES.md' notes/` returns nothing; `grep -rn 'ToJava.ard (KNOWN' lambox-to-java/src` returns nothing.
- Either the int63 change is committed with a green `check-formal.sh` and `golden.py`, or it lives on `int63-repr` and `HANDOVER.md` §7 says so.
- `test/README.md` contains a mutation table with ≥ 5 rows (Day 4, if reached).

## Verification

    test/tools/check-formal.sh            # [ERROR]/[GOAL] lines = failure
    test/golden.py --set cover            # 5/5, ~130 s
    test/run.py --all                     # ~30 min; only regression/* rows red
    git status --short; git log origin/main..main; git log arend/main..main   # all empty

## Risks

- **Cherry-picking `3c76662`** conflicts on harness files 30 commits old. Mitigation: take only the example `.ard` files, `regression.sh`, and the three `corpora/regression/*` directories by path, then re-serialize with the current `regen-arend-asts.sh`.
- **The int63 change alters generated Java** (literal normalization, `PRIM_*_INT63` names): golden files change and the C/OCaml differential must still agree. That is why it is gated on Day 1 with a hard noon cutoff.
- **Un-ignoring `notes/`** publishes working documents to the `arend-lang` org remote. Skim them for anything not meant for colleagues before committing; `Arend-extractor-AI-discussion.md` is the one to look at.
