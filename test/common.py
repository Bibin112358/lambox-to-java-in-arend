"""Shared pieces of the test harness: paths, the Arend runner, the corpora."""

import hashlib
import re
import subprocess
import sys
from pathlib import Path

TEST_DIR = Path(__file__).resolve().parent
ROOT = TEST_DIR.parent
WORK_DIR = TEST_DIR / "work"
CORE = ROOT / "lambox-to-java"                 # compiler, semantics, proofs
EXAMPLES = ROOT / "lambox-to-java-examples"    # hand-written programs, model checks
TESTS = TEST_DIR / "arend"                     # generated programs (src/ is gitignored)
IMPORTED = TESTS / "src" / "Imported"
LIB_SH = TEST_DIR / "lib.sh"


def info(msg):
    sys.stdout.flush()
    print(f"[test] {msg}", file=sys.stderr, flush=True)


def warn(msg):
    print(f"[test] WARNING: {msg}", file=sys.stderr, flush=True)


def die(msg):
    print(f"[test] ERROR: {msg}", file=sys.stderr, flush=True)
    sys.exit(1)


def arend(project, *targets, timeout=None):
    """Typecheck modules/definitions in an Arend project; return the CLI output.

    Goes through lib.sh's `arend` so that the command line (jar, JVM flags,
    library roots, AREND_WRAP) is defined in exactly one place."""
    cmd = ["bash", "-c", '. "$0"; arend "$@"', str(LIB_SH), str(project), *targets]
    proc = subprocess.run(cmd, capture_output=True, text=True, timeout=timeout)
    return proc.stdout + proc.stderr


def problems(output):
    """The lines that make an Arend run a failure. The CLI's exit status is not
    reliable; `[ERROR]` and `[GOAL]` (an unfinished proof) lines are, and so is
    a crashed JVM (e.g. `OutOfMemoryError`), which prints neither."""
    return [l for l in output.splitlines()
            if re.match(r"^\[(ERROR|GOAL)\]|^Exception in thread |^java\.lang\.\w*(Error|Exception)", l)]


def sections(output, marker):
    """Split what `putStrLn` printed into named sections. `marker` is a regex
    whose group(1) names the section starting at that line; a section ends at
    the next marker or at the CLI's own `--- ` framing lines. CLI diagnostics
    are dropped (no generated Java line starts with `[`)."""
    out, current = {}, None
    for line in output.splitlines():
        hit = re.match(marker, line)
        if hit:
            current = hit.group(1)
            out[current] = []
        elif current is not None and line.startswith("--- "):
            current = None
        elif current is not None and not re.match(r"^\[(ERROR|WARNING|WARN|INFO|GOAL)\]|^  In: ", line):
            out[current].append(line)
    return {k: "\n".join(v).rstrip("\n") + "\n" for k, v in out.items()}


def normalize(text):
    """A printed value as compared: whitespace deleted (the Java printer indents
    constructor data), and past 200 characters a head plus a sha256 of the
    whole (one program prints 192 MB)."""
    value = "".join(text.split())
    if len(value) <= 200:
        return value
    return f"{value[:200]}...sha256:{hashlib.sha256(value.encode()).hexdigest()}"


def java_build_and_run(outdir, timeout=300):
    """Compile <outdir>/Prog.java with the runtime and run it (stages/java.sh).
    Returns (status, value): status is 'ok', 'build-fail', 'run-fail' or
    'timeout'; value is the normalized output."""
    for kind in ("build", "run"):
        try:
            proc = subprocess.run([str(TEST_DIR / "stages/java.sh"), kind, str(outdir)],
                                  capture_output=True, text=True, timeout=timeout)
        except subprocess.TimeoutExpired:
            return "timeout", ""
        if proc.returncode != 0:
            return f"{kind}-fail", (proc.stderr or proc.stdout).strip()[-2000:]
    return "ok", normalize((Path(outdir) / "output.txt").read_text())


# --- Corpora ----------------------------------------------------------------

CORPUS_COLUMNS = ["program", "ast", "expected", "backends", "runtime", "xfail", "note"]


class Program:
    """One row printed by a corpora/*.sh script."""

    def __init__(self, corpus, fields):
        row = dict(zip(CORPUS_COLUMNS, fields + [""] * len(CORPUS_COLUMNS)))
        self.corpus = corpus
        self.name = row["program"]
        self.ast = TEST_DIR / row["ast"]
        self.expected = normalize(row["expected"])
        self.backends = row["backends"].split()
        self.runtime = row["runtime"].strip()
        self.xfail = row["xfail"].strip()  # a reason, or empty
        self.note = row["note"]

    def module(self):
        """lean-const-fold -> LeanConstFold, the Imported.<Module> of this program."""
        return "".join(w[:1].upper() + w[1:] for w in self.name.replace("_", "-").split("-"))

    def imported(self):
        return IMPORTED / f"{self.module()}.ard"


def load_corpora():
    """Run corpora/*.sh and parse their rows. A corpus whose upstream checkout
    is missing prints no rows; that is reported, not an error."""
    programs = []
    for script in sorted((TEST_DIR / "corpora").glob("*.sh")):
        proc = subprocess.run([str(script)], cwd=TEST_DIR, capture_output=True, text=True)
        if proc.returncode != 0:
            warn(f"corpus {script.stem} exited {proc.returncode}")
        rows = [l for l in proc.stdout.splitlines() if l.strip() and not l.lstrip().startswith("#")]
        if not rows:
            warn(f"corpus {script.stem}: no rows (upstream not installed?)")
        programs += [Program(script.stem, line.split("\t")) for line in rows]
    return programs


def select(programs, names):
    """The named programs, in order; an unknown name is fatal."""
    import difflib
    known = {p.name: p for p in programs}
    for name in names:
        if name not in known:
            near = difflib.get_close_matches(name, known, n=3)
            die(f"no such program: {name}" + (f" (did you mean {', '.join(near)}?)" if near else ""))
    return [known[n] for n in names]


def ensure_imported(prog):
    """Make Imported/<Module>.ard exist and be newer than the program's .ast.
    False if that is impossible (no .ast, no peregrine)."""
    path = prog.imported()
    if path.exists() and (not prog.ast.exists() or path.stat().st_mtime >= prog.ast.stat().st_mtime):
        return True
    if not prog.ast.exists():
        warn(f"{prog.name}: no .ast at {prog.ast}")
        return False
    info(f"{prog.name}: importing {prog.ast.name} -> Imported.{prog.module()}")
    proc = subprocess.run([str(TEST_DIR / "tools/import-ast.sh"), str(prog.ast), prog.module()],
                          capture_output=True, text=True)
    if proc.returncode != 0:
        warn(f"{prog.name}: import failed: "
             + (proc.stderr.strip().splitlines() or ["no message"])[-1])
        return False
    return True
