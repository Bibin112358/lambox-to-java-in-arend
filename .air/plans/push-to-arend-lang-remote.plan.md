## Context

Today the only remote is your personal fork:

```
origin  git@github.com:Bibin112358/lambox-to-java-in-arend.git
```

You want the work to also land in the org repo `arend-lang/lambox-to-java-in-arend`.

What I verified (read-only):

- `git ls-remote git@github.com:arend-lang/lambox-to-java-in-arend.git` succeeds and returns **no refs** — the repo exists, your SSH key already has access, and it is **completely empty**. No force-push or history reconciliation needed; the first push defines the repo.
- Local `main` is **16 commits ahead** of `origin/main` (`ed21012 refactor: make the generated-name scheme a datatype` → `d2ab4fc test: an agreement instance for the other branch of a case`). Those commits are not in your fork either — they only exist locally right now.
- `origin` also carries 6 side branches: `inline-data-and-arity-calls`, `known-arity-and-sinking`, `lambox-formal-semantics`, `readability-annotations`, `test/regression-corpus-const-sharing-and-mangling`, `test/runtime-benchmark-baseline`.
- None of the 16 unpushed commits touch `.air/`, `.junie/`, `AGENTS.md`, `CLAUDE.md`, or `lambox-to-java/src/Generated.ard` — those stay untracked in the working copy, so nothing leaks to a public org repo.
- `.git` is 9.4 MB, largest tracked file 160 KB — no LFS concerns.

I tried to ask you about push scope and remote naming, but the question prompt timed out (1800 s). **This plan assumes the conservative default: a separate `arend` remote, `main` only.** Both decisions are one-line variations, spelled out under "Variations".

## Goal

Publish local `main` (all 16 unpushed commits) to `arend-lang/lambox-to-java-in-arend` as its default branch, while keeping `origin` on your fork so no future `git push` reaches the org repo unless you name it.

## Approach

Add a second named remote rather than rewiring `origin` or stacking dual push URLs. A named remote keeps publication to a public org repo an explicit act — `git push arend main` — which matters more here than the convenience of one `git push` hitting both, given the repo is public and the working tree carries files that must never be committed.

## Steps

**1. Add the remote**

```bash
git remote add arend git@github.com:arend-lang/lambox-to-java-in-arend.git
git remote -v            # expect origin (x2) + arend (x2)
```

SSH already works for `origin` and `ls-remote` on the target succeeded — no credential setup needed.

**2. Review what you are about to publish**

```bash
git log --oneline origin/main..main            # the 16 commits
git log --stat -1 d2ab4fc                      # spot-check the tip
git status --short                             # confirm .air/, .junie/, AGENTS.md, CLAUDE.md, Generated.ard are untracked (??), not staged
```

If any of those paths show as staged (`A `/`M ` in the first column), unstage with `git restore --staged <path>` first. Nothing is staged as of now, but the tree is dirty and the index can drift.

**3. Push main**

```bash
git push arend main
```

Creates `refs/heads/main` on the empty remote. GitHub makes the first pushed branch the repo default automatically — no extra step.

**4. Confirm**

```bash
git ls-remote arend                            # expect HEAD + refs/heads/main at d2ab4fc
git fetch arend && git log --oneline -1 arend/main
```

**5. Decide about your fork's `main` (separate call)**

`origin/main` stays 16 commits behind after this. If you want the fork to match: `git push origin main`, as an independent step. Not part of this plan — pushing to the fork wasn't the ask.

**6. Optional: retarget `main`'s upstream**

`main` tracks `origin/main`, so bare `git push`/`git pull` still talk to your fork — the intended default. To have `main` follow the org repo instead:

```bash
git branch --set-upstream-to=arend/main main
```

Skip unless you want bare `git push` to publish to arend-lang.

## Variations

- **Also push side branches** (replaces step 3):
  ```bash
  git push arend main lambox-formal-semantics          # main + the active worktree branch
  # or all of them:
  git push arend main inline-data-and-arity-calls known-arity-and-sinking \
      lambox-formal-semantics readability-annotations \
      test/regression-corpus-const-sharing-and-mangling test/runtime-benchmark-baseline
  ```
  `known-arity-and-sinking` is labelled "Backup: … (reverted on main)" — worth leaving out of a public org repo unless you want the record.

- **Make arend-lang the canonical `origin`** (replaces step 1):
  ```bash
  git remote rename origin fork
  git remote add origin git@github.com:arend-lang/lambox-to-java-in-arend.git
  git push -u origin main
  ```

- **One push writes to both** (replaces step 1):
  ```bash
  git remote set-url --add --push origin git@github.com:Bibin112358/lambox-to-java-in-arend.git
  git remote set-url --add --push origin git@github.com:arend-lang/lambox-to-java-in-arend.git
  ```
  Convenient, but publishes to the public repo on every `git push` — why it isn't the default here.

## Acceptance criteria

- `git remote -v` lists `arend` with fetch and push URLs at `git@github.com:arend-lang/lambox-to-java-in-arend.git`.
- `git ls-remote arend refs/heads/main` prints `d2ab4fc…` (or the then-current tip of local `main`).
- `git ls-remote arend` lists exactly the intended refs — `main` alone under the default plan.
- `git rev-parse --abbrev-ref main@{upstream}` still prints `origin/main` (unless step 6 was taken deliberately).
- `git ls-tree -r arend/main --name-only | grep -E '^\.(air|junie)|^AGENTS|^CLAUDE|Generated\.ard'` returns nothing.

## Risks

- **Publishing AI-tool files to a public org repo.** Mitigated by step 2's check and the last acceptance criterion; the 16 commits are already verified clean. Consider adding `.air/`, `.junie/`, `AGENTS.md`, `CLAUDE.md` to `.gitignore` so the index can never pick them up — they are not there today.
- **Accidental future publication.** Avoided by the named-remote choice; the dual-push-URL variation gives this up.
- **Write permission.** `ls-remote` proves read access, not push access. If step 3 returns `ERROR: Permission to arend-lang/… denied`, you need write access on the org repo (or push to a fork and open a PR). Nothing local needs undoing — the remote entry is harmless.
- **No `gh` CLI here** (`command not found`), so repo-settings work (visibility, branch protection) must happen in the GitHub web UI. The default-branch case is handled by the first push.
