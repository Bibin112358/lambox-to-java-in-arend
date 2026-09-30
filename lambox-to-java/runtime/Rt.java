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
// Plain loops and casts only (no lambdas, streams or pattern switches), like
// the generated code.
//
// The Arend model of this file is `Semantics/RtLong.ard` + `Semantics/RtInt63.ard`;
// the correctness proof trusts that the two agree (`test/check diff` spot-checks it).
public final class Rt {
  private Rt() {}

  public interface Fn {
    Object apply(Object x);
  }

  // `toString` prints an indented `tag(\n  field,\n  field\n)` tree; a
  // constructor without fields prints as its bare tag. With
  // `-Dlambox.names=<file>` the tag is replaced by a constructor name (see
  // `Names` below).
  public static final class Data {
    public final int tag;
    public final Object[] fields;

    public Data(int tag, Object[] fields) { this.tag = tag; this.fields = fields; }

    @Override public String toString() {
      StringBuilder sb = new StringBuilder();
      render(sb, 0);
      return sb.toString();
    }

    // Renders into one shared buffer: building a String per level would be
    // quadratic in the nesting depth (a long list is deeply nested).
    public void render(StringBuilder sb, int indent) {
      sb.append(Names.label(tag, fields.length));
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

  // Constructor names, for debugging only; not modelled, not used by the
  // generated code. A `Data` carries no inductive, so the table the harness
  // writes next to the generated class (`Prog.names`, one line per constructor:
  // `tag TAB npars TAB nargs TAB inductive TAB constructor`, from
  // Compiler/CtorNames.ard) is looked up by tag and field count. The field
  // count is `npars + nargs`, or `nargs` since some erasure output drops the
  // parameters. Every matching constructor is listed, e.g. `Bool.false|Nat.zero`;
  // with no match, or without `-Dlambox.names`, the bare tag is printed.
  static final class Names {
    private static final java.util.Map<String, String> LABELS = load(System.getProperty("lambox.names"));

    static String label(int tag, int nfields) {
      String l = LABELS.get(tag + "/" + nfields);
      return l != null ? l : Integer.toString(tag);
    }

    private static java.util.Map<String, String> load(String file) {
      java.util.Map<String, String> m = new java.util.HashMap<String, String>();
      if (file == null) return m;
      try {
        for (String line : java.nio.file.Files.readAllLines(java.nio.file.Paths.get(file))) {
          String[] c = line.split("\t");
          if (c.length != 5) continue;
          int tag = Integer.parseInt(c[0]), npars = Integer.parseInt(c[1]), nargs = Integer.parseInt(c[2]);
          // Lean's constructor names are qualified already (`Nat.succ`), Rocq's not (`S`).
          String name = c[4].indexOf('.') >= 0 ? c[4] : c[3] + "." + c[4];
          add(m, tag + "/" + (npars + nargs), name);
          if (npars > 0) add(m, tag + "/" + nargs, name);
        }
      } catch (java.io.IOException e) {
        throw new IllegalArgumentException("cannot read -Dlambox.names file " + file, e);
      }
      return m;
    }

    private static void add(java.util.Map<String, String> m, String key, String name) {
      String old = m.get(key);
      if (old == null) m.put(key, name);
      else if (!java.util.Arrays.asList(old.split("\\|")).contains(name)) m.put(key, old + "|" + name);
    }
  }

  // An erased proof or type. It is an `Fn` that returns itself, because λ□ may
  // apply erased values (`eval_box`: `app box a` evaluates to `box`) and the
  // generated code writes every application as `((Rt.Fn)f).apply(a)`.
  public static final Fn BOX = new Fn() {
    public Object apply(Object x) { return BOX; }
    @Override public String toString() { return "BOX"; }
  };

  // --- Entry point -----------------------------------------------------------
  //
  // A generated class only exposes `public static Object body()`; the `main`
  // is hand-written (runtime/Main.java.in) and should call `runMain`.
  //
  // `fix` compiles to ordinary, mostly non-tail Java recursion, so evaluation
  // depth is bounded by the stack. `-Xss` does not reliably size the thread
  // running `main` (it gets the OS stack on some platforms), so `runMain` runs
  // the body, and prints its value, on a thread of its own with a large stack
  // (`-Dlambox.stack=<bytes>` overrides it). This raises the bound; it does not
  // remove it. Exceptions are reported and give a non-zero exit status.
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
  // variable). A closed program produced by erasure contains neither; the
  // generator compiles them to a call of one of these, so the failure is
  // immediate and names the node (`path` is the generator's structural node id,
  // see `compileExpr` in ToJava.ard).
  public static Object unbound(String path) {
    throw new IllegalStateException(
      "ill-formed lambda-box: de Bruijn index out of scope (node " + path + ")");
  }

  public static Object freeVar(String name, String path) {
    throw new IllegalStateException(
      "ill-formed lambda-box: free variable \"" + name + "\" has no Java counterpart (node " + path + ")");
  }

  // The last alternative of the ternary chain a λ□ `case` compiles to: reached
  // when the scrutinee's tag matches no branch. Unreachable for a well-typed
  // program, since a match is total over its inductive's constructors; using
  // the last branch as the final `else` instead would turn a malformed tag into
  // a silently wrong answer. Takes the scrutinee rather than its tag, so the
  // generated code only ever reads a tag inside a `tag == n` test.
  public static Object noBranch(Object scrutinee, String path) {
    String what = scrutinee instanceof Data
      ? "constructor tag " + ((Data) scrutinee).tag
      : "non-constructor value " + scrutinee;
    throw new IllegalStateException(
      "ill-formed lambda-box: " + what + " matches no branch (node " + path + ")");
  }

  // --- Primitive integer ops -------------------------------------------------
  //
  // The λ□ axioms the backend realizes (table: `Compiler/JavaAxioms.ard`).
  // Every value is a `java.lang.Long`, and every operation is curried like
  // generated code: `((Fn)((Fn)PRIM_ADD_INT63).apply(a)).apply(b)`. Two families:
  //   * `*_INT63`: λ□'s primitive int, unsigned 63-bit, mod 2^63 (MetaRocq's
  //     `PrimInt63.int`, lean-to-lambdabox's `BitVec 63`). Used for
  //     `prim_*_int` and `Nat.add`/`mul`/`beq` (lean-to-lambdabox erases `Nat`
  //     to this primitive int).
  //   * `*_LONG`: Java's signed 64-bit `long`. Used for the `prim_*_long`
  //     operations introduced by `Compiler/LongRewrite.ard`, and for the other
  //     Lean `Nat`/`Int` operations below (on values in [0, 2^63) they agree
  //     with the 63-bit reading).
  private static long lng(Object x) { return ((Long) x).longValue(); }

  // eqb's result ABI: the two-constructor Bool inductive with no fields,
  // false = tag 0, true = tag 1 (matching the declared constructor order).
  public static final Data FALSE = new Data(0, new Object[]{});
  public static final Data TRUE = new Data(1, new Object[]{});

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

  // --- PRIM_*_INT63 ------------------------------------------------------------
  //
  // A value is a `long` in [0, 2^63). Java's `+`, `-`, `*` on `long` are mod
  // 2^64 (JLS 4.2.2), so masking the result with 2^63-1 gives mod 2^63: one AND
  // per operation. Arguments are masked on the way in as well, so each constant
  // is correct on any input, which is how `Semantics/RtInt63.ard` models it.
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
  // lean-to-lambdabox erases `Nat` to λ□ primitive ints and leaves these
  // operations as axioms.
  //
  // A binary operation is written once by extending `Bin`: the outer `apply`
  // returns the closure that takes the second argument.
  private abstract static class Bin implements Fn {
    abstract Object run(Object x, Object y);

    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return Bin.this.run(x, y); } };
    }
  }

  // Lean's `Nat.sub` truncates (`a - b = 0` when `b >= a`), unlike the wrapping
  // `prim_sub_int`, so it has its own constant.
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

  // `Math.pow` is floating point, so the exponentiation is square-and-multiply
  // in O(log y) steps. It wraps like every other `*_LONG` operation: `long`
  // multiplication is multiplication mod 2^64, so the result equals the naive
  // product of y copies of x mod 2^64. An exponent <= 0 gives 1.
  public static final Fn PRIM_POW_LONG = new Bin() {
    Object run(Object x, Object y) {
      long base = lng(x), acc = 1L;
      for (long e = lng(y); e > 0L; e >>= 1) {
        if ((e & 1L) != 0L) acc = acc * base;
        base = base * base;
      }
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

  // An index is a Nat, i.e. a `Long`, and a Java array index an `int`. It is
  // bounds-checked as a `long` before narrowing: a plain `intValue()` would
  // truncate, so that index 2^32 read element 0 of a one-element array.
  private static int index(Object[] a, Object x, String what) {
    long i = ((Number) x).longValue();
    if (i < 0L || i >= a.length) {
      throw new IndexOutOfBoundsException(
        "Lean " + what + ": index " + i + " outside array of size " + a.length);
    }
    return (int) i;
  }

  private static Object[] copyWith(Object[] a, int extra) {
    Object[] b = new Object[a.length + extra];
    System.arraycopy(a, 0, b, 0, a.length);
    return b;
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
      int i = index(xs, a[2], "Array.getInternal");
      return xs[i];
    }
  });

  // `Array.get!Internal {α} [Inhabited α] (a : Array α) (i : Nat) : α`, which
  // panics out of bounds rather than returning `default`, since the erased
  // `Inhabited` instance carries no value we could return.
  public static final Fn ARRAY_GET_BANG_INTERNAL = curry(4, new Op() {
    public Object run(Object[] a) {
      Object[] xs = arr(a[2]);
      int i = index(xs, a[3], "Array.get!Internal");
      return xs[i];
    }
  });

  // `Array.set! {α} (a : Array α) (i : Nat) (v : α) : Array α`
  public static final Fn ARRAY_SET_BANG = curry(4, new Op() {
    public Object run(Object[] a) {
      Object[] xs = arr(a[1]);
      int i = index(xs, a[2], "Array.set!");
      Object[] b = copyWith(xs, 0);
      b[i] = a[3];
      return b;
    }
  });

  // `Array.swap {α} (xs : Array α) (i j : Nat) (hi : _) (hj : _) : Array α`
  public static final Fn ARRAY_SWAP = curry(6, new Op() {
    public Object run(Object[] a) {
      Object[] xs = arr(a[1]);
      int i = index(xs, a[2], "Array.swap"), j = index(xs, a[3], "Array.swap");
      Object[] b = copyWith(xs, 0);
      Object t = b[i];
      b[i] = b[j];
      b[j] = t;
      return b;
    }
  });

  // `Array.size {α} (a : Array α) : Nat` -- the only array operation whose
  // result is a Nat, hence the only one with a per-representation version.
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
