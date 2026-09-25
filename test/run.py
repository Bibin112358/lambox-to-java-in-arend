#!/usr/bin/env python3
"""run: do compiled programs compute the right value? (test/check run)

    test/check run                        # list the programs, run nothing
    test/check run peano leanbench-unit   # run these on the java backend
    test/check run --all                  # every program (~25 min)
    test/check run --ref matmul           # also Peregrine's OCaml/C backends

For each program: stages/java.sh gen (import the .ast, generate Java with
Arend), build (javac), run (java), then compare the printed value with the
program's `expected` value from its corpus. `--ref` also runs the reference
backends a program declares (stages/ocaml.sh, stages/c.sh) and requires all
backends to print the same value. Scratch goes to work/<program>/<backend>/,
the result table to work/results.tsv.
"""

import argparse
import os
import signal
import subprocess
import sys
import time

import common as c

KINDS = ("gen", "build", "run")
EXIT_NO_TOOL, EXIT_UNSUPPORTED = 3, 4          # the stage scripts' contract (lib.sh)
FAILED = ("wrong", "gen-fail", "build-fail", "run-fail", "timeout")


def stage_args(prog, backend, kind, outdir):
    if kind == "gen":
        return [str(prog.ast), outdir, prog.module() if backend == "java" else prog.runtime]
    if kind == "build" and backend != "java":
        return [outdir, prog.runtime]
    return [outdir]


def run_stage(cmd, timeout):
    """Run one stage in its own process group, so a timeout also kills the
    program the stage started. Returns (status, seconds, diagnostics)."""
    start = time.monotonic()
    proc = subprocess.Popen(cmd, cwd=c.TEST_DIR, text=True, start_new_session=True,
                            stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    try:
        out, err = proc.communicate(timeout=timeout)
        status = proc.returncode
    except subprocess.TimeoutExpired:
        os.killpg(os.getpgid(proc.pid), signal.SIGKILL)
        out, err = proc.communicate()
        status = "timeout"
    return status, time.monotonic() - start, err or out


def run_backend(prog, backend, timeout):
    """gen, build, run; stop at the first failure. Returns (status, secs, value)."""
    outdir = c.WORK_DIR / prog.name / backend
    (outdir / "output.txt").unlink(missing_ok=True)   # never read a stale value
    secs = {}
    for kind in KINDS:
        cmd = [str(c.TEST_DIR / "stages" / f"{backend}.sh"), kind] + stage_args(prog, backend, kind, str(outdir))
        status, secs[kind], err = run_stage(cmd, timeout)
        if status == 0:
            continue
        name = {"timeout": "timeout", EXIT_NO_TOOL: "skip-no-tool",
                EXIT_UNSUPPORTED: "skip-unsupported"}.get(status, f"{kind}-fail")
        if name in FAILED and err.strip():
            c.info(f"{prog.name}/{backend} {name}:\n" + "\n".join(err.strip().splitlines()[-10:]))
        return name, secs, ""
    value = c.normalize((outdir / "output.txt").read_text())
    return ("wrong" if prog.expected and value != prog.expected else "ok"), secs, value


def verdict(prog, statuses, values):
    """The row's one word: the worst thing that happened, with its backend."""
    bad = [f"{s}({b})" for b, s in statuses.items() if s in FAILED]
    if bad:
        # xfail absorbs a known failure, never a wrong value.
        if prog.xfail and "wrong" not in statuses.values():
            return "xfail"
        return " ".join(bad)
    if len(set(values.values())) > 1:
        return "disagree"
    if not values:
        return " ".join(f"{s}({b})" for b, s in statuses.items()) or "no-backend"
    return "ok"


def main(argv=None):
    p = argparse.ArgumentParser(prog="check run", description=__doc__.splitlines()[0])
    p.add_argument("programs", nargs="*", metavar="PROGRAM")
    p.add_argument("--all", action="store_true", help="every program of every corpus")
    p.add_argument("--ref", action="store_true",
                   help="also run the OCaml/C reference backends the program declares")
    p.add_argument("--timeout", type=float, default=600, metavar="S", help="per stage (default 600)")
    args = p.parse_args(argv)

    programs = c.load_corpora()
    if not args.programs and not args.all:
        for q in programs:
            print(f"{q.name:30s} {q.corpus:16s} {' '.join(q.backends):12s} "
                  f"{'expected' if q.expected else 'no value':9s} {q.note}")
        return 0
    selection = programs if args.all else c.select(programs, args.programs)

    rows, failures = [], []
    for prog in selection:
        backends = [b for b in prog.backends if args.ref or b == "java"]
        statuses, values, times = {}, {}, {}
        for backend in backends:
            statuses[backend], times[backend], value = run_backend(prog, backend, args.timeout)
            if statuses[backend] in ("ok", "wrong"):
                values[backend] = value
        result = verdict(prog, statuses, values)
        oracle = "expected" if prog.expected and values else "backends" if len(values) > 1 else "none"
        # seconds per stage, gen/build/run
        took = " ".join(f"{b}=" + "/".join(f"{t[k]:.1f}" for k in KINDS if k in t)
                        for b, t in times.items())
        value = next(iter(values.values()), "")
        print(f"{prog.name:30s} {result:12s} check={oracle:8s} {took}", flush=True)
        rows.append([prog.name, result, oracle, took, value, prog.expected])
        if result not in ("ok", "xfail") and not result.startswith("skip"):
            failures.append((prog, result, value))

    c.WORK_DIR.mkdir(exist_ok=True)
    with (c.WORK_DIR / "results.tsv").open("w") as fh:
        fh.write("program\tresult\tcheck\ttimes\toutput\texpected\n")
        fh.writelines("\t".join(r) + "\n" for r in rows)
    print(f"\nrun: {len(rows)} program(s), {len(failures)} failing")
    for prog, result, value in failures:
        print(f"  {prog.name}: {result}"
              + (f" (got {value[:60]}, expected {prog.expected[:60]})" if "wrong" in result else ""))
    unchecked = [r[0] for r in rows if r[2] == "none"]
    if unchecked:
        print(f"  no oracle (only 'did not crash'): {' '.join(unchecked)}")
    return 1 if failures else 0


if __name__ == "__main__":
    sys.exit(main())
