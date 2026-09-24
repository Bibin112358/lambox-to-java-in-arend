// Fixed runtime for the generated Java code (see ToJava.ard).
//
// This file is *not* generated: the compiler only emits the program-specific
// class, which references the types below as `Rt.Fn`, `Rt.Data` and `Rt.BOX`.
// That class has no entry point, so a hand-written `main` is compiled alongside
// it (runtime/Main.java.in):
//   javac -d <dir> <dir>/Rt.java <dir>/Prog.java <dir>/Main.java
//
// Design (matches the untyped λ□ encoding):
//   * untyped values     -> Object
//   * closures           -> Fn (anonymous inner classes, no invokedynamic)
//   * constructors       -> Data(tag, fields)
//   * erased proofs/types -> BOX
//
// Kept to plain loops/casts (no lambdas/streams/pattern-switch) per the
// classic-bytecode-only codegen style used by the generator.
public final class Rt {
  private Rt() {}

  public interface Fn {
    Object apply(Object x);
  }

  // `toString` overrides here are purely for making printed program output
  // human-readable (e.g. inspecting `System.out.println(Prog.body())`): a
  // recursive, indented `tag(\n  field,\n  field\n)` tree, where flat leaves
  // like `0` print with no parens.
  public static final class Data {
    public final int tag;
    public final Object[] fields;

    public Data(int tag, Object[] fields) { this.tag = tag; this.fields = fields; }

    @Override public String toString() {
      StringBuilder sb = new StringBuilder();
      render(sb, 0);
      return sb.toString();
    }

    // Renders into ONE buffer. Returning a String per level instead (as this
    // used to) copies the whole rendered subtree once per enclosing level, which
    // is quadratic in the nesting depth: a list of 8000 elements -- the shape a
    // `List` of that length has -- then took minutes to print, dwarfing the
    // program that produced it. The text produced is unchanged.
    public void render(StringBuilder sb, int indent) {
      sb.append(tag);
      if (fields.length == 0) return;
      sb.append("(\n");
      for (int i = 0; i < fields.length; i++) {
        indentBy(sb, indent + 1);
        Object f = fields[i];
        if (f instanceof Data) { ((Data) f).render(sb, indent + 1); } else { sb.append(String.valueOf(f)); }
        if (i < fields.length - 1) sb.append(",");
        sb.append("\n");
      }
      indentBy(sb, indent);
      sb.append(")");
    }

    private static void indentBy(StringBuilder sb, int indent) {
      for (int j = 0; j < indent; j++) sb.append("  ");
    }
  }

  // An erased proof or type. It is an `Fn` RETURNING ITSELF, not a bare
  // `Object`: λ□ applies erased values (`eval_box`: if `f` evaluates to `box`
  // then `app f a` evaluates to `box`), and the generated code spells every
  // application `((Rt.Fn)f).apply(a)`. A bare `Object` made that application a
  // ClassCastException -- a program λ□ evaluates, failing in Java. The OCaml
  // backend's box is the same self-returning function. It prints as `BOX`
  // rather than as a hash code, so output is deterministic.
  public static final Fn BOX = new Fn() {
    public Object apply(Object x) { return BOX; }
    @Override public String toString() { return "BOX"; }
  };

  // --- Entry point -----------------------------------------------------------
  //
  // WHY A CALLER'S `main` SHOULD GO THROUGH THIS RATHER THAN PRINT `body()`.
  //
  // (The extractor generates no `main` at all: a generated class exposes
  // `public static Object body()` and nothing else, so the entry point is
  // hand-written -- see runtime/Main.java.in for the one the harness uses.)
  //
  // λ□'s `fix` compiles to plain Java recursion, and the recursive call is
  // usually NOT in tail position (building a list, `map`, `foldr`, the deriv
  // tree walk), so evaluation depth is bounded by the thread stack. Passing
  // `-Xss` to the launcher is not a dependable way to raise that bound: `-Xss`
  // sizes threads the JVM creates, while the *primordial* thread running `main`
  // gets its stack from the OS (`ulimit -s`, typically 8 MB) on several
  // JVM/OS combinations. So a program that needs a deep stack would work or
  // overflow depending on how it happened to be launched.
  //
  // Running the body on a thread we create ourselves makes the requested stack
  // size a property of the generated program instead: the size below is honoured
  // by every JVM, and it is still tunable without recompiling via
  // `-Dlambox.stack=<bytes>`. This bounds depth, it does not remove the bound --
  // making non-tail `fix` stack-independent needs CPS/heap-allocated frames, and
  // is deliberately not attempted here (a trampoline would only flatten TAIL
  // calls, which is not the recursion we see).
  //
  // The value is printed on that thread, since `toString` of a deep `Data` is
  // recursive too. An exception is reported and turned into a non-zero exit
  // status, so a stack overflow cannot look like success with no output.
  public static final long STACK_BYTES =
    Long.getLong("lambox.stack", 1L << 30).longValue();

  public static void runMain(final Fn body) {
    final Throwable[] failure = new Throwable[1];
    Runnable r = new Runnable() {
      public void run() {
        try {
          System.out.println(body.apply(BOX));
        } catch (Throwable t) {
          failure[0] = t;
        }
      }
    };
    Thread t = new Thread(null, r, "lambox-main", STACK_BYTES);
    t.start();
    try {
      t.join();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
    if (failure[0] != null) {
      failure[0].printStackTrace();
      System.exit(1);
    }
  }

  // --- Ill-formed input ------------------------------------------------------
  //
  // Two λ□ nodes have no Java value: a `bvar` whose de Bruijn index exceeds the
  // enclosing binders (out of scope) and a `fvar` (locally-nameless free
  // variable) — a closed program produced by erasure contains neither. The
  // generator used to emit a commented `null` for them, which then either blew
  // up far away as a NullPointerException or, worse, propagated silently as a
  // value; it now emits a call of one of these, so the failure is immediate and
  // names the offending node (`path` is the generator's structural node id, see
  // `compileExpr` in ToJava.ard).
  public static Object unbound(int index, String path) {
    throw new IllegalStateException(
      "ill-formed lambda-box: de Bruijn index " + index + " is out of scope (node " + path + ")");
  }

  public static Object freeVar(String name, String path) {
    throw new IllegalStateException(
      "ill-formed lambda-box: free variable \"" + name + "\" has no Java counterpart (node " + path + ")");
  }

  // The last alternative of the ternary chain a λ□ `case` compiles to: reached
  // when the scrutinee's tag matches no branch. Unreachable for a well-typed
  // program, since a match is total over its inductive's constructors — this is
  // the `default:` that the earlier `switch` encoding threw from, kept for the
  // same reason. It cannot be dropped in favour of using the last branch as the
  // final `else`: that would turn a malformed tag from a loud error into a
  // silently wrong answer.
  // Takes the scrutinee rather than its tag so that the generated code needs no
  // node for reading a tag on its own: every other tag read is part of a `tag ==
  // n` test.
  public static Object noBranch(Object scrutinee, String path) {
    String what = scrutinee instanceof Data
      ? "constructor tag " + ((Data) scrutinee).tag
      : "non-constructor value " + scrutinee;
    throw new IllegalStateException(
      "ill-formed lambda-box: " + what + " matches no branch (node " + path + ")");
  }

  // --- Primitive integer ops -------------------------------------------------
  //
  // Realization of the arity-2 λ□ axioms `prim_add_int`, `prim_mul_int`,
  // `prim_sub_int` and `prim_eqb_int` (see ExampleMatMul.ard). The C/OCaml
  // backends get these by remapping the axioms onto CertiRocq's
  // prim_int63_add/mul/sub/eqb via peregrine's `--attributes`; for Java the
  // generator emits a reference to the constants below (axiom table in
  // ToJava.ard) instead of a throwing stub.
  //
  // Both arguments are taken one at a time, since generated code is fully
  // curried: `((Fn)((Fn)PRIM_ADD_INT).apply(a)).apply(b)`.
  //
  // There are TWO families, one per int representation the generator can pick
  // (the `JavaTarget` record in ToJava.ard) — a program uses exactly one of
  // them, and its `prim` literals are of the matching type:
  //   * `PRIM_*_INT`  — java.math.BigInteger values: unbounded, never overflow,
  //     but boxed arithmetic and NO wraparound.
  //   * `PRIM_*_LONG` — java.lang.Long values, i.e. Java's built-in integers:
  //     much faster, wrap — but at 2^64 and signed, whereas λ□ ints are 63-bit
  //     with unsigned/cyclic (mod 2^63) arithmetic.
  //
  // KNOWN MISMATCH (documented, not fixed). λ□'s `tPrim primInt` payload is
  // int63 by definition of the language: MetaRocq
  // erasure/theories/EPrimitive.v — `primIntModel (i : PrimInt63.int)`;
  // lean-to-lambdabox — `PrimModel .primInt := BitVec 63`; Rocq refman
  // "Primitive objects / Primitive integers" (63-bit machine int, unsigned view
  // `Uint63`, signed view `Sint63`). Neither family below matches that, nor the
  // C runtime (CertiRocq prim_int63_add/mul/sub/eqb) or the OCaml one (unboxed
  // OCaml `int`, cf. ExtrOCamlInt63); they agree as long as values stay well
  // below 2^62, which holds for the current examples.
  // DONE, and it is now the DEFAULT: the `PRIM_*_INT63` family below
  // normalizes mod 2^63 per `Uint63` and is selected by `JavaAxioms.ard`'s
  // `primRepr`. The mismatch above therefore stands only for the two older
  // families, which remain because `_LONG` is the fast deviation a program can
  // still be compiled against and `_INT` is what the unbounded families use.
  //
  // It does NOT fix the other half. Lean's `Nat` is arbitrary-precision, and
  // its operations (`NAT_*`, and the `Nat.*` entries of the axiom table) stay
  // on `long`, where they still truncate at 2^64. That is a separate defect,
  // tracked as limitation (L) in `Formal/Correct.ard`.
  private static java.math.BigInteger num(Object x) { return (java.math.BigInteger) x; }

  private static long lng(Object x) { return ((Long) x).longValue(); }

  // eqb's result ABI: the two-constructor Bool inductive with no fields,
  // false = tag 0, true = tag 1 (matching the declared constructor order).
  public static final Data FALSE = new Data(0, new Object[]{});
  public static final Data TRUE = new Data(1, new Object[]{});

  public static final Fn PRIM_ADD_INT = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return num(x).add(num(y)); } };
    }
  };

  public static final Fn PRIM_MUL_INT = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return num(x).multiply(num(y)); } };
    }
  };

  public static final Fn PRIM_SUB_INT = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return num(x).subtract(num(y)); } };
    }
  };

  public static final Fn PRIM_EQB_INT = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return num(x).equals(num(y)) ? TRUE : FALSE; } };
    }
  };

  public static final Fn PRIM_ADD_LONG = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return Long.valueOf(lng(x) + lng(y)); } };
    }
  };

  public static final Fn PRIM_MUL_LONG = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return Long.valueOf(lng(x) * lng(y)); } };
    }
  };

  public static final Fn PRIM_SUB_LONG = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return Long.valueOf(lng(x) - lng(y)); } };
    }
  };

  public static final Fn PRIM_EQB_LONG = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return lng(x) == lng(y) ? TRUE : FALSE; } };
    }
  };

  // --- PRIM_*_INT63: λ□'s primitive int, as the language actually defines it -
  //
  // `Uint63` — unsigned, 63-bit, cyclic mod 2^63. This is the family the
  // FUTURE WORK note above asked for, and it is the only one of the three that
  // agrees with λ□'s own evaluation (MetaRocq `primIntModel (i :
  // PrimInt63.int)`; lean-to-lambdabox `PrimModel .primInt := BitVec 63`; the
  // Rocq refman's `Uint63`). The other two are deviations: `_INT` never wraps,
  // `_LONG` wraps at 2^64 and signed.
  //
  // AND IT IS ESSENTIALLY FREE, which is the reason there is no longer a
  // correctness/speed trade here. A value is held in a `long` restricted to
  // [0, 2^63), which is exactly the non-negative half of `long`'s range, so
  // nothing is boxed differently from `_LONG` and no BigInteger is involved.
  // Java's `+`, `-` and `*` on `long` are two's-complement, i.e. mod 2^64
  // (JLS 4.2.2), so masking the result with 2^63-1 gives mod 2^63: one AND
  // instruction per operation. Checked against BigInteger `mod 2^63` on two
  // million random operand pairs for +, -, * and /, plus the two boundary
  // cases `(2^63-1) + 1 = 0` and `1 - 2 = 2^63-1`.
  //
  // Division and remainder need no mask: both operands are already in
  // [0, 2^63), so they are non-negative `long`s and Java's `/` and `%` are the
  // unsigned operations on them.
  //
  // Arguments are re-normalized on the way in rather than assumed normalized.
  // That costs nothing and makes each constant correct in isolation, which is
  // what lets the Arend model (`Formal/RtInt63.ard`) state the same thing.
  public static final long MASK63 = Long.MAX_VALUE; // 2^63 - 1

  private static long u63(Object x) { return ((Long) x).longValue() & MASK63; }

  public static final Fn PRIM_ADD_INT63 = new Bin() {
    Object run(Object x, Object y) { return Long.valueOf((u63(x) + u63(y)) & MASK63); }
  };

  public static final Fn PRIM_MUL_INT63 = new Bin() {
    Object run(Object x, Object y) { return Long.valueOf((u63(x) * u63(y)) & MASK63); }
  };

  public static final Fn PRIM_SUB_INT63 = new Bin() {
    Object run(Object x, Object y) { return Long.valueOf((u63(x) - u63(y)) & MASK63); }
  };

  public static final Fn PRIM_EQB_INT63 = new Bin() {
    Object run(Object x, Object y) { return u63(x) == u63(y) ? TRUE : FALSE; }
  };

  // --- Lean machine-Nat operations -------------------------------------------
  //
  // lean-to-lambdabox erases `Nat` to λ□ primitive ints (`PrimModel .primInt :=
  // BitVec 63`) and leaves the operations below as axioms, exactly like
  // `Nat.add`/`mul`/`sub`/`beq` above. Same curried ABI, same two
  // representations, same 63-bit caveat.
  //
  // A binary operation is written once by extending `Bin`: the outer `apply`
  // returns the closure that takes the second argument.
  private abstract static class Bin implements Fn {
    abstract Object run(Object x, Object y);

    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return Bin.this.run(x, y); } };
    }
  }

  // Lean's `Nat.sub` is TRUNCATED subtraction: `a - b = 0` when `b >= a`. It
  // therefore cannot share `PRIM_SUB_*`, which realizes the hand-written
  // `prim_sub_int` axiom whose reference implementation is Peregrine's int63
  // subtraction (wrapping, and freely negative). A shared realization produced
  // wrong -- not crashing -- results: `const_fold` returned 2048 instead of
  // 4772, because its `v-1` fell below zero and its `if v = 0` guard then never
  // fired.
  public static final Fn NAT_SUB_INT = new Bin() {
    Object run(Object x, Object y) {
      java.math.BigInteger d = num(x).subtract(num(y));
      return d.signum() < 0 ? java.math.BigInteger.ZERO : d;
    }
  };

  public static final Fn NAT_SUB_LONG = new Bin() {
    Object run(Object x, Object y) {
      long d = lng(x) - lng(y);
      return Long.valueOf(d < 0L ? 0L : d);
    }
  };

  // Result ABI of `Nat.decEq`/`decLe`/`decLt`: Lean's
  //   inductive Decidable (p : Prop) | isFalse (h : Not p) | isTrue (h : p)
  // so isFalse = tag 0, isTrue = tag 1, and the single field is the erased
  // proof. TWO box fields are stored on purpose: the boxed λ□ artifacts
  // produced by lean-to-lambdabox carry `npars = 0` on some `tCase` nodes and
  // `npars = 1` on others, and a branch reads `fields[npars]`. The field is a
  // proof, hence never inspected -- only its presence matters.
  public static final Data IS_FALSE = new Data(0, new Object[]{ BOX, BOX });
  public static final Data IS_TRUE = new Data(1, new Object[]{ BOX, BOX });

  private static Data dec(boolean b) { return b ? IS_TRUE : IS_FALSE; }

  // Lean total-function conventions, which differ from Java's: division and
  // modulo by zero are `n / 0 = 0` and `n % 0 = n` rather than an exception.
  public static final Fn PRIM_DIV_INT = new Bin() {
    Object run(Object x, Object y) {
      return num(y).signum() == 0 ? java.math.BigInteger.ZERO : num(x).divide(num(y));
    }
  };

  public static final Fn PRIM_MOD_INT = new Bin() {
    Object run(Object x, Object y) {
      return num(y).signum() == 0 ? num(x) : num(x).mod(num(y));
    }
  };

  public static final Fn PRIM_POW_INT = new Bin() {
    Object run(Object x, Object y) { return num(x).pow(num(y).intValueExact()); }
  };

  public static final Fn PRIM_BLE_INT = new Bin() {
    Object run(Object x, Object y) { return num(x).compareTo(num(y)) <= 0 ? TRUE : FALSE; }
  };

  public static final Fn PRIM_BLT_INT = new Bin() {
    Object run(Object x, Object y) { return num(x).compareTo(num(y)) < 0 ? TRUE : FALSE; }
  };

  public static final Fn PRIM_DEC_EQ_INT = new Bin() {
    Object run(Object x, Object y) { return dec(num(x).equals(num(y))); }
  };

  public static final Fn PRIM_DEC_LE_INT = new Bin() {
    Object run(Object x, Object y) { return dec(num(x).compareTo(num(y)) <= 0); }
  };

  public static final Fn PRIM_DEC_LT_INT = new Bin() {
    Object run(Object x, Object y) { return dec(num(x).compareTo(num(y)) < 0); }
  };

  public static final Fn PRIM_DIV_LONG = new Bin() {
    Object run(Object x, Object y) {
      return Long.valueOf(lng(y) == 0L ? 0L : lng(x) / lng(y));
    }
  };

  public static final Fn PRIM_MOD_LONG = new Bin() {
    Object run(Object x, Object y) {
      return Long.valueOf(lng(y) == 0L ? lng(x) : lng(x) % lng(y));
    }
  };

  // `Math.pow` is floating point, so the exponentiation is an explicit loop;
  // it wraps like every other `*_LONG` operation.
  public static final Fn PRIM_POW_LONG = new Bin() {
    Object run(Object x, Object y) {
      long base = lng(x), acc = 1L;
      for (long i = lng(y); i > 0L; i--) acc = acc * base;
      return Long.valueOf(acc);
    }
  };

  public static final Fn PRIM_BLE_LONG = new Bin() {
    Object run(Object x, Object y) { return lng(x) <= lng(y) ? TRUE : FALSE; }
  };

  public static final Fn PRIM_BLT_LONG = new Bin() {
    Object run(Object x, Object y) { return lng(x) < lng(y) ? TRUE : FALSE; }
  };

  public static final Fn PRIM_DEC_EQ_LONG = new Bin() {
    Object run(Object x, Object y) { return dec(lng(x) == lng(y)); }
  };

  public static final Fn PRIM_DEC_LE_LONG = new Bin() {
    Object run(Object x, Object y) { return dec(lng(x) <= lng(y)); }
  };

  public static final Fn PRIM_DEC_LT_LONG = new Bin() {
    Object run(Object x, Object y) { return dec(lng(x) < lng(y)); }
  };

  // --- Lean machine-Int operations -------------------------------------------
  //
  // With `config.int = .machine`, lean-to-lambdabox erases `Int` to the SAME λ□
  // primitive int as `Nat` (a signed 63-bit value), which is why `Int.ofNat` is
  // the identity here and `Int.negSucc n` is `-(n+1)`; its erasure of
  // `Int.casesOn` relies on exactly that (`Erasure.lean`, machine-Int case).
  //
  // `ediv`/`emod` are Lean's EUCLIDEAN division: the remainder is never
  // negative, and division by zero is total (`a / 0 = 0`, `a % 0 = a`). Neither
  // matches Java's `/` and `%`, so both are computed from the remainder.
  public static final Fn INT_OF_NAT = new Fn() {
    public Object apply(Object x) { return x; }
  };

  public static final Fn INT_NEG_INT = new Fn() {
    public Object apply(Object x) { return num(x).negate(); }
  };

  public static final Fn INT_NEG_SUCC_INT = new Fn() {
    public Object apply(Object x) {
      return num(x).add(java.math.BigInteger.ONE).negate();
    }
  };

  public static final Fn INT_ADD_INT = new Bin() {
    Object run(Object x, Object y) { return num(x).add(num(y)); }
  };

  public static final Fn INT_MUL_INT = new Bin() {
    Object run(Object x, Object y) { return num(x).multiply(num(y)); }
  };

  public static final Fn INT_EMOD_INT = new Bin() {
    Object run(Object x, Object y) {
      return num(y).signum() == 0 ? num(x) : num(x).mod(num(y).abs());
    }
  };

  public static final Fn INT_EDIV_INT = new Bin() {
    Object run(Object x, Object y) {
      if (num(y).signum() == 0) return java.math.BigInteger.ZERO;
      java.math.BigInteger r = num(x).mod(num(y).abs());
      return num(x).subtract(r).divide(num(y));
    }
  };

  public static final Fn INT_DEC_EQ_INT = new Bin() {
    Object run(Object x, Object y) { return dec(num(x).equals(num(y))); }
  };

  private static long emod(long a, long b) {
    if (b == 0L) return a;
    long r = a % b;
    return r < 0L ? r + Math.abs(b) : r;
  }

  public static final Fn INT_NEG_LONG = new Fn() {
    public Object apply(Object x) { return Long.valueOf(-lng(x)); }
  };

  public static final Fn INT_NEG_SUCC_LONG = new Fn() {
    public Object apply(Object x) { return Long.valueOf(-(lng(x) + 1L)); }
  };

  public static final Fn INT_ADD_LONG = new Bin() {
    Object run(Object x, Object y) { return Long.valueOf(lng(x) + lng(y)); }
  };

  public static final Fn INT_MUL_LONG = new Bin() {
    Object run(Object x, Object y) { return Long.valueOf(lng(x) * lng(y)); }
  };

  public static final Fn INT_EMOD_LONG = new Bin() {
    Object run(Object x, Object y) { return Long.valueOf(emod(lng(x), lng(y))); }
  };

  public static final Fn INT_EDIV_LONG = new Bin() {
    Object run(Object x, Object y) {
      long b = lng(y);
      if (b == 0L) return Long.valueOf(0L);
      long a = lng(x);
      return Long.valueOf((a - emod(a, b)) / b);
    }
  };

  public static final Fn INT_DEC_EQ_LONG = new Bin() {
    Object run(Object x, Object y) { return dec(lng(x) == lng(y)); }
  };

  // --- Lean arrays -----------------------------------------------------------
  //
  // Lean's `Array` operations are axioms too (they are `@[extern]` in Lean's
  // prelude, so erasure keeps no body). A λ□ value of type `Array α` is
  // therefore whatever this runtime says it is, and the simplest choice is a
  // plain Java `Object[]` -- distinguishable from every other runtime value,
  // since a constructor is always a `Data`.
  //
  // PERSISTENT, NOT MUTABLE. Lean's `push`/`set!`/`swap` are destructive only
  // because its compiler proves the array is used linearly; λ□ has no such
  // information left, so each of them COPIES. That is O(n) per operation where
  // Lean is O(1) -- correct, and the reason array-heavy benchmarks are slow
  // here.
  //
  // Erased implicit arguments (the element type, and `Inhabited`/bounds proofs)
  // are still passed, as `BOX`, so each operation below takes exactly as many
  // curried arguments as Lean's signature has -- see the argument comments.
  private interface Op {
    Object run(Object[] args);
  }

  // `curry(n, op)` collects n arguments one `apply` at a time and then runs
  // `op`. Each partial application gets its own array, so a partially applied
  // operation stays a value that can be shared.
  private static Fn curry(final int arity, final Op op) {
    return curry(arity, op, new Object[0]);
  }

  private static Fn curry(final int arity, final Op op, final Object[] got) {
    return new Fn() {
      public Object apply(Object x) {
        Object[] next = new Object[got.length + 1];
        System.arraycopy(got, 0, next, 0, got.length);
        next[got.length] = x;
        if (next.length == arity) return op.run(next);
        return curry(arity, op, next);
      }
    };
  }

  private static Object[] arr(Object x) { return (Object[]) x; }

  // Both int representations are `java.lang.Number`s, so an index needs no
  // target-specific version; only `Array.size`, which RETURNS a Nat, does.
  private static int idx(Object x) { return ((Number) x).intValue(); }

  private static Object[] copyWith(Object[] a, int extra) {
    Object[] b = new Object[a.length + extra];
    System.arraycopy(a, 0, b, 0, a.length);
    return b;
  }

  private static void checkIndex(Object[] a, int i, String what) {
    if (i < 0 || i >= a.length) {
      throw new IndexOutOfBoundsException(
        "Lean " + what + ": index " + i + " outside array of size " + a.length);
    }
  }

  // `Array.mk {α} (toList : List α) : Array α`. Reading the list is the one
  // place the runtime depends on the shape of a source inductive: `List.nil` is
  // tag 0 and `List.cons` tag 1. The fields are taken from the END of the
  // block, because a boxed λ□ constructor may or may not carry the inductive's
  // erased parameter in front of them (lean-to-lambdabox is not consistent
  // about `npars`, cf. IS_TRUE above).
  public static final Fn ARRAY_MK = curry(2, new Op() {
    public Object run(Object[] a) {
      java.util.ArrayList<Object> out = new java.util.ArrayList<Object>();
      Object cur = a[1];
      while (true) {
        Data d = (Data) cur;
        if (d.tag == 0) break;
        out.add(d.fields[d.fields.length - 2]);
        cur = d.fields[d.fields.length - 1];
      }
      return out.toArray();
    }
  });

  // `Array.emptyWithCapacity {α} (c : Nat) : Array α` -- the capacity is an
  // allocation hint with no observable effect, and this representation grows on
  // demand, so it is ignored.
  public static final Fn ARRAY_EMPTY_WITH_CAPACITY = curry(2, new Op() {
    public Object run(Object[] a) { return new Object[0]; }
  });

  // `Array.push {α} (a : Array α) (v : α) : Array α`
  public static final Fn ARRAY_PUSH = curry(3, new Op() {
    public Object run(Object[] a) {
      Object[] b = copyWith(arr(a[1]), 1);
      b[b.length - 1] = a[2];
      return b;
    }
  });

  // `Array.getInternal {α} (a : Array α) (i : Nat) (h : i < a.size) : α`
  public static final Fn ARRAY_GET_INTERNAL = curry(4, new Op() {
    public Object run(Object[] a) {
      Object[] xs = arr(a[1]);
      int i = idx(a[2]);
      checkIndex(xs, i, "Array.getInternal");
      return xs[i];
    }
  });

  // `Array.get!Internal {α} [Inhabited α] (a : Array α) (i : Nat) : α`, which
  // panics out of bounds rather than returning `default`, since the erased
  // `Inhabited` instance carries no value we could return.
  public static final Fn ARRAY_GET_BANG_INTERNAL = curry(4, new Op() {
    public Object run(Object[] a) {
      Object[] xs = arr(a[2]);
      int i = idx(a[3]);
      checkIndex(xs, i, "Array.get!Internal");
      return xs[i];
    }
  });

  // `Array.set! {α} (a : Array α) (i : Nat) (v : α) : Array α`
  public static final Fn ARRAY_SET_BANG = curry(4, new Op() {
    public Object run(Object[] a) {
      Object[] xs = arr(a[1]);
      int i = idx(a[2]);
      checkIndex(xs, i, "Array.set!");
      Object[] b = copyWith(xs, 0);
      b[i] = a[3];
      return b;
    }
  });

  // `Array.swap {α} (xs : Array α) (i j : Nat) (hi : _) (hj : _) : Array α`
  public static final Fn ARRAY_SWAP = curry(6, new Op() {
    public Object run(Object[] a) {
      Object[] xs = arr(a[1]);
      int i = idx(a[2]), j = idx(a[3]);
      checkIndex(xs, i, "Array.swap");
      checkIndex(xs, j, "Array.swap");
      Object[] b = copyWith(xs, 0);
      Object t = b[i];
      b[i] = b[j];
      b[j] = t;
      return b;
    }
  });

  // `Array.size {α} (a : Array α) : Nat` -- the only array operation whose
  // result is a Nat, hence the only one with a per-representation version.
  public static final Fn ARRAY_SIZE_INT = curry(2, new Op() {
    public Object run(Object[] a) {
      return java.math.BigInteger.valueOf(arr(a[1]).length);
    }
  });

  public static final Fn ARRAY_SIZE_LONG = curry(2, new Op() {
    public Object run(Object[] a) { return Long.valueOf(arr(a[1]).length); }
  });

  // --- Lean's equality eliminators -------------------------------------------
  //
  //   @Eq.rec   {α} {a} {motive} (refl : motive a rfl) {b} (h : a = b)
  //   @Eq.ndrec {α} {a} {motive} (m : motive a)         {b} (h : a = b)
  //
  // Both have SIX arguments, of which only the fourth is computational -- the
  // others are a type, two endpoints, a motive and a proof, all erased to `BOX`
  // but still passed. Rewriting along an equality does nothing at runtime, so
  // the realization returns that fourth argument unchanged. Over-application
  // (the result is itself a function) works because the returned value is then
  // applied by the enclosing `app` node, as usual.
  public static final Fn EQ_REC = curry(6, new Op() {
    public Object run(Object[] a) { return a[3]; }
  });
}
