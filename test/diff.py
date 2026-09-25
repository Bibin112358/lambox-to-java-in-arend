#!/usr/bin/env python3
"""diff: do the Arend models agree with the real JVM? (test/check diff)

Typechecks lambox-to-java-examples' ModelChecks.DiffRuns (one Arend run, ~50 s),
which prints for each of its small λ□ programs the generated Java and the value
computed by the λ□ semantics (`runProgram lbAxioms`) and by the Java-fragment
semantics (`runClass rtInt63`). Each Java class is then compiled and run on the
JVM, and the three values must be equal (whitespace ignored). To add a program,
add a `diff<Name> => putStrLn (dump "<name>" <program>)` line to DiffRuns.ard.
"""

import argparse
import sys
import time

import common as c

MARKER = r"^===== (\S+ (?:java|lambdabox-model|java-model|end)) =====$"


def main(argv=None):
    p = argparse.ArgumentParser(prog="check diff", description=__doc__.splitlines()[0])
    p.parse_args(argv)

    start = time.monotonic()
    c.info("diff: typechecking ModelChecks.DiffRuns")
    output = c.arend(c.EXAMPLES, "ModelChecks.DiffRuns")
    errors = c.problems(output)
    if errors:
        print("\n".join(errors[:20]))
        c.die("ModelChecks.DiffRuns does not typecheck")
    parts = c.sections(output, MARKER)
    names = [k[:-len(" java")] for k in parts if k.endswith(" java")]
    if not names:
        c.die("ModelChecks.DiffRuns printed nothing")

    failures = []
    print(f"{'program':20s} {'JVM':22s} {'λ□ model':22s} {'Java model':22s}")
    for name in names:
        outdir = c.WORK_DIR / "diff" / name
        outdir.mkdir(parents=True, exist_ok=True)
        (outdir / "Prog.java").write_text(parts[f"{name} java"])
        status, jvm = c.java_build_and_run(outdir)
        if status != "ok":
            jvm = f"<{status}>"
        lb = c.normalize(parts.get(f"{name} lambdabox-model", "<missing>"))
        jm = c.normalize(parts.get(f"{name} java-model", "<missing>"))
        ok = jvm == lb == jm
        print(f"{name:20s} {jvm:22s} {lb:22s} {jm:22s} {'ok' if ok else 'DIFFERS'}", flush=True)
        if not ok:
            failures.append(name)

    print(f"\ndiff: {len(names)} program(s) in {time.monotonic() - start:.0f}s, "
          f"{len(failures)} failing" + (f": {' '.join(failures)}" if failures else ""))
    return 1 if failures else 0


if __name__ == "__main__":
    sys.exit(main())
