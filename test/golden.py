#!/usr/bin/env python3
"""The fast check: does the generator still produce the Java it produced before?

    test/golden.py                   # the smoke set, diff against test/golden/
    test/golden.py --set cover       # + lean-deriv, for complete feature coverage
    test/golden.py --set all         # every program that has an Imported module
    test/golden.py peano lean-map    # exactly these
    test/golden.py --update          # show the diff, then accept it
    test/golden.py --jobs 4          # shard across 4 Arend processes

WHY THIS EXISTS, NEXT TO run.py. `run.py` answers "does the compiled program
compute the right value", which costs peregrine + Arend + javac + running the
program, per program, and half an hour for `--all`. Most changes to `ToJava.ard`
do not need that question answered: they need "did the generated source change,
and where". This answers only that, and it is two orders of magnitude cheaper --
no peregrine, no javac, nothing executed.

It is worth having BOTH because they fail differently. A golden diff catches a
change `run.py` cannot see (a program whose value is unchanged but whose code
got worse) and vice versa (a printer that emits uncompilable Java would pass
here if the golden file were blessed with the same bug). This is the inner loop;
`run.py --all` is what says the output still means something.

HOW. One temporary Arend module is written into the project (`GoldenDump*.ard`),
with one `\func` per selected program whose body is
`putStrLn ("===== <name> =====\\n" ++ compileProgram "Prog" <Module>.program)`; ONE
Arend invocation typechecks it, which prints all of them; the output is split on
the markers. The per-program cost is Arend evaluating the generator over that
program's λ□ term, so the SIZE of the selected terms is what this script's
runtime is made of -- hence the sets below.

It deliberately does not go through `stages/java.sh`/`tools/extract-arend.sh`:
those run one Arend process per program (paying JVM start + arend-lib load every
time) and `extract-arend.sh` does `rm -rf "$project/bin"`, which is also why
sharding needs a private copy of the project per shard rather than just more
processes.

REQUIRES `src/Imported/<Module>.ard`, which is generated (gitignored) by a java
`gen` stage. A missing one is imported here, from the corpus row's `.ast`, using
the same `tools/import-ast.sh` the harness uses -- so a fresh checkout works,
it just pays peregrine once per program.
"""

import argparse
import difflib
import os
import re
import shutil
import subprocess
import sys
import tempfile
import time
from concurrent.futures import ThreadPoolExecutor
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import run as harness  # load_corpora, Program.module(), info/warn/die

TEST_DIR = Path(__file__).resolve().parent
ROOT = TEST_DIR.parent
GOLDEN_DIR = TEST_DIR / "golden"
AREND_PROJECT = ROOT / "lambox-to-java"
AREND_JAR = Path.home() / "arend-lang-bibin/cli/build/libs/cli-1.12.0-full.jar"
JAVA = os.environ.get("JAVA", str(Path.home() / ".jdks/openjdk-26.0.1/bin/java"))
JAVA_STACK = "-Xss1g"

# The smoke set, and WHAT EACH PROGRAM IS HERE FOR. Chosen by set cover over the
# features observable in generated Java (`class Fix`, a Fix class with more than
# one method, `.tag ==`, `.fields[`, `Rt.BOX`, `Long.valueOf`,
# `new Rt.Data`, a `final Object l..` from letIn, and each `Rt.<family>_` axiom
# family), minimized by INPUT size, since that is what the cost is.
#
# Do not prune this list by size without re-running that computation: three of
# the four are the cheapest program in the whole corpus that exhibits their
# feature, so dropping one silently drops coverage.
SMOKE = {
    "peano":                    "the canonical small one: fix, case, construct, no axioms",
    "peregrine-rocq-oddeven":   "mutual-fix + qual-this, and the only Rocq-frontend program in the set",
    "leanbench-even":           "cheapest mutual-fix; also ax:NAT, ax:PRIM, int-lit, letIn, box",
    "leanbench-list_sum_foldr": "the only cheap source of ax:ARRAY (Lean's Array axioms)",
}

# `lean-deriv` and `leanbench-deriv` are the ONLY two programs in the corpus that
# reach `Rt.EQ_REC` and the `Rt.INT_*` family, and both are 23k lines of λ□ --
# roughly ten times the whole smoke set. So complete axiom coverage is a separate,
# slower set rather than part of the inner loop.
COVER_EXTRA = {
    "lean-deriv": "sole source of ax:EQ_REC and ax:INT (Lean machine-Int + Eq.rec)",
}

# NOT COVERED BY ANY SET, because no program in the corpus exercises it: λ□ `proj`
# (zero occurrences across all 68 programs), `fvar`, and an unguarded `fix` body.
# `compileExpr`'s `proj` clause and `compileFixMethod`'s second clause are
# therefore checked by nothing here; closing that needs a hand-written λ□ term,
# not a wider corpus. One now exists, but on the other side of the fence: the
# examples project's `Formal/JavaEvalRuns.ard` compiles a hand-written `proj`
# term and EVALUATES it with the fragment's semantics. That checks the generator
# against the semantics, not against `javac`, so the gap is narrower than it was
# and not closed.

MARKER = re.compile(r"^===== (\S+) =====$")

# A CLI diagnostic can land BETWEEN two dumps -- the daemon prints them while
# typechecking, i.e. while the `putStrLn`s we harvest are running -- so a dump
# would otherwise end with someone else's warning. Belt and braces: the dump
# module above is written not to provoke any. Safe to drop because no line of
# generated Java starts with `[`, and none is a Java label (`In:`); see
# tools/extract-arend.sh, which filters the same thing for the same reason.
DIAGNOSTIC = re.compile(r"^\[(?:ERROR|WARNING|WARN|INFO|GOAL)\]|^  In: ")


def select(args, programs):
    """The programs to dump, as (name, Program). Unknown names are fatal, since a
    typo would otherwise silently check less than asked."""
    known = {p.name: p for p in programs}
    if args.programs:
        wanted = list(args.programs)
    elif args.set == "all":
        wanted = [p.name for p in programs
                  if (AREND_PROJECT / "src/Imported" / f"{p.module()}.ard").exists()]
    elif args.set == "cover":
        wanted = list(SMOKE) + list(COVER_EXTRA)
    else:
        wanted = list(SMOKE)
    missing = [n for n in wanted if n not in known]
    if missing:
        harness.die(f"no such program(s): {', '.join(missing)}")
    return [(n, known[n]) for n in wanted]


def ensure_imported(prog):
    """The Imported module is generated and gitignored; make it exist. Returns
    False if it cannot be built (no peregrine), which is a skip, not a failure."""
    module = prog.module()
    path = AREND_PROJECT / "src/Imported" / f"{module}.ard"
    ast = TEST_DIR / prog.ast
    if path.exists() and (not ast.exists() or path.stat().st_mtime >= ast.stat().st_mtime):
        return True
    if not ast.exists():
        harness.warn(f"{prog.name}: no .ast at {ast}")
        return False
    harness.info(f"{prog.name}: importing {ast.name} -> Imported.{module}")
    proc = subprocess.run([str(TEST_DIR / "tools/import-ast.sh"), str(ast), module],
                          cwd=TEST_DIR, capture_output=True, text=True)
    if proc.returncode != 0:
        harness.warn(f"{prog.name}: import failed ({proc.returncode}); "
                     + (proc.stderr.strip().splitlines() or ["no message"])[-1])
        return False
    return True


def shard_project(modules, tmp):
    """A private copy of the Arend project for one shard.

    Only the top-level sources and the Imported modules this shard names are
    copied: Arend typechecks the target module and its dependencies, so the rest
    of `Imported/` would be dead weight. A copy (rather than more processes in
    one project) is required because a run clears the project's `bin/`."""
    dst = Path(tmp)
    shutil.copy(AREND_PROJECT / "arend.yaml", dst / "arend.yaml")
    (dst / "src/Imported").mkdir(parents=True)
    shutil.copytree(AREND_PROJECT / "src/Compiler", dst / "src/Compiler")
    for module in modules:
        shutil.copy(AREND_PROJECT / "src/Imported" / f"{module}.ard",
                    dst / "src/Imported" / f"{module}.ard")
    return dst


DAEMON = os.environ.get("AREND_DAEMON") == "1"


def dump_module(selection, stamp=""):
    """The Arend source that prints every selected program's generated Java.

    `stamp` is appended to each DEFINITION NAME in daemon mode, and it has to be
    the name: the daemon re-typechecks per DEFINITION, and the `putStrLn` we
    harvest is a side effect OF typechecking, so a definition it considers
    unchanged prints nothing. A stamped comment is NOT enough -- measured: an
    appended comment left the definition untouched and the second run harvested
    nothing. A fresh name makes the definition new, so it runs."""
    lines = ["-- GENERATED by test/golden.py -- do not edit, do not commit.",
             "\\import Data.String", "\\import Debug", "\\import Compiler.ToJava"]
    # `()`: bring in NO names, only the module for qualified use. Every Imported
    # module exports `program`/`progTerm`/`progJava`, so a plain import of two of
    # them makes Arend warn about each clash -- and those warnings are printed
    # INTERLEAVED with the dumps we are harvesting, which corrupted the last
    # program's Java (the qualified references below never needed the names).
    lines += [f"\\import Imported.{p.module()} ()" for _, p in selection]
    lines.append("")
    for i, (name, prog) in enumerate(selection):
        lines.append(f'\\func d{i}{stamp} => putStrLn ("===== {name} =====\\n"'
                     f' ++ compileProgram "Prog" Imported.{prog.module()}.program)')
    return "\n".join(lines) + "\n"


def run_arend(selection, index):
    """Typecheck one dump module and return {name: java}.

    Normally this happens in a PRIVATE COPY of the project, so a run cannot see
    or disturb the real one. With AREND_DAEMON=1 the dump module is written into
    the real project instead and the request is routed to a running daemon --
    a copy would be a different library, which the daemon does not serve.

    The CLI's exit status is not a success signal (see extract-arend.sh): the
    `[ERROR]` lines are."""
    module = f"GoldenDump{index}"
    if DAEMON:
        project = AREND_PROJECT
        target = project / "src" / f"{module}.ard"
        target.write_text(dump_module(selection, stamp=f"_s{time.monotonic_ns()}"))
        try:
            proc = subprocess.run([JAVA, JAVA_STACK, "-jar", str(AREND_JAR),
                                   "arend.yaml", module],
                                  cwd=project, capture_output=True, text=True)
        finally:
            target.unlink(missing_ok=True)
    else:
        with tempfile.TemporaryDirectory(prefix="golden-shard-") as tmp:
            project = shard_project([p.module() for _, p in selection], tmp)
            (project / "src" / f"{module}.ard").write_text(dump_module(selection))
            cmd = [JAVA, JAVA_STACK, "-jar", str(AREND_JAR), "arend.yaml", module]
            proc = subprocess.run(cmd, cwd=project, capture_output=True, text=True)
    text = proc.stdout + proc.stderr
    errors = [l for l in text.splitlines() if l.startswith("[ERROR]")]
    if errors:
        harness.warn(f"shard {index}: Arend reported errors:\n  "
                     + "\n  ".join(errors[:8]))
    out, current = {}, None
    for line in text.splitlines():
        hit = MARKER.match(line)
        if hit:
            current = hit.group(1)
            out[current] = []
        elif current is not None and line.startswith("--- "):
            current = None          # the CLI's own framing ends the last dump
        elif current is not None and not DIAGNOSTIC.match(line):
            out[current].append(line)
    return {k: "\n".join(v).rstrip("\n") + "\n" for k, v in out.items()}


def term_size(prog):
    """Cost proxy for one program: the size of its Imported module. The work is
    Arend evaluating the generator over that λ□ term, and the term IS that file,
    so its byte count tracks the cost far better than the program count does
    (the corpus spans 39 to 23023 lines)."""
    path = AREND_PROJECT / "src/Imported" / f"{prog.module()}.ard"
    return path.stat().st_size if path.exists() else 0


def shard(selection, jobs):
    """Split into `jobs` shards by longest-processing-time-first.

    Round-robin is actively bad here: one 23k-line program can cost more than
    every other program put together, so what matters is isolating the big ones
    and filling the remaining shards with small ones. LPT does that -- assign
    each program, largest first, to the shard with the least work so far.

    MEASURE BEFORE USING THIS. Every shard is a fresh Arend process, and its
    FIXED cost -- JVM start, arend-lib load, typechecking `ToJava.ard` and its
    dependencies -- is about 25 s, which on small selections is nearly the whole
    runtime. Measured on this machine:

      12 small programs, 1 shard   31 s     |  --set cover, 1 shard   129 s
      12 small programs, 4 shards  82 s     |  --set cover, 2 shards  205 s

    i.e. sharding LOST both times, by 2.6x and 1.1x. It can only win when the
    per-program work dominates that fixed cost, which needs a selection far
    bigger than the smoke set (`--set all` is 197k lines of λ□ against a 25 s
    fixed cost, and is the one case expected to gain -- unmeasured). Default is
    and should stay 1."""
    order = sorted(selection, key=lambda np: -term_size(np[1]))
    shards = [[] for _ in range(jobs)]
    load = [0] * jobs
    for name, prog in order:
        i = load.index(min(load))
        shards[i].append((name, prog))
        load[i] += term_size(prog) or 1
    return [s for s in shards if s]


def generate(selection, jobs):
    """All selected programs' generated Java, sharded across `jobs` processes."""
    if jobs <= 1 or len(selection) == 1:
        return run_arend(selection, 0)
    shards = shard(selection, jobs)
    result = {}
    with ThreadPoolExecutor(max_workers=len(shards)) as pool:
        for part in pool.map(lambda a: run_arend(a[1], a[0]), enumerate(shards)):
            result.update(part)
    return result


def compare(name, produced, update):
    """Diff one program against its golden file. Returns a status word."""
    path = GOLDEN_DIR / f"{name}.java"
    if not path.exists():
        if update:
            path.parent.mkdir(parents=True, exist_ok=True)
            path.write_text(produced)
            return "new"
        return "no-golden"
    expected = path.read_text()
    if expected == produced:
        return "ok"
    diff = list(difflib.unified_diff(expected.splitlines(True), produced.splitlines(True),
                                     fromfile=f"golden/{name}.java", tofile=f"{name} (now)"))
    # The diff is printed even when accepting it: blessing a regression must at
    # least be visible in the terminal that did it, and in `git diff` afterwards.
    print(f"--- {name}: {len(diff)} diff line(s) "
          + ("(accepting)" if update else "(differs)"))
    sys.stdout.writelines(diff[:400])
    if len(diff) > 400:
        print(f"... {len(diff) - 400} more diff line(s) suppressed")
    if update:
        path.write_text(produced)
        return "updated"
    return "differs"


def parse_args(argv):
    p = argparse.ArgumentParser(description=__doc__.splitlines()[0])
    p.add_argument("programs", nargs="*", metavar="PROGRAM")
    p.add_argument("--set", choices=("smoke", "cover", "all"), default="smoke",
                   help="which built-in selection to use (default: %(default)s)")
    p.add_argument("--update", action="store_true",
                   help="accept the current output as golden (prints the diff first)")
    p.add_argument("--jobs", type=int, default=1, metavar="N",
                   help="shard across N Arend processes (default: 1)")
    p.add_argument("--list", action="store_true", help="print the selection and exit")
    return p.parse_args(argv)


def main(argv=None):
    args = parse_args(argv)
    if args.jobs < 1:
        harness.die("--jobs must be at least 1")
    selection = select(args, harness.load_corpora())
    reasons = {**SMOKE, **COVER_EXTRA}
    if args.list:
        for name, prog in selection:
            print(f"{name}\t{prog.module()}\t{reasons.get(name, '')}")
        return 0

    selection = [(n, p) for n, p in selection if ensure_imported(p)]
    if not selection:
        harness.die("nothing to check (no Imported modules, and none could be built)")

    start = time.monotonic()
    harness.info(f"{len(selection)} program(s), {args.jobs} shard(s)")
    produced = generate(selection, args.jobs)
    took = time.monotonic() - start

    statuses = {}
    for name, _ in selection:
        if name not in produced:
            statuses[name] = "no-output"
            continue
        statuses[name] = compare(name, produced[name], args.update)

    print()
    for name, status in statuses.items():
        print(f"  {name:28s} {status}")
    bad = {n: s for n, s in statuses.items() if s in ("differs", "no-output", "no-golden")}
    print(f"\n{len(statuses)} program(s) in {took:.1f}s, {len(bad)} needing attention")
    if bad:
        for name, status in bad.items():
            hint = {"no-golden": "run with --update to create it",
                    "no-output": "the dump printed nothing -- check the Arend errors above",
                    "differs": "generated Java changed"}[status]
            print(f"  {name}: {status} -- {hint}")
    return 1 if bad else 0


if __name__ == "__main__":
    sys.exit(main())
