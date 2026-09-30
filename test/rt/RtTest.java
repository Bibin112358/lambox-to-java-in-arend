// Unit tests of runtime/Rt.java on edge values (`test/check rt`).
//
// Rt.java is trusted: the proof assumes it behaves like its Arend model
// (Semantics/RtLong.ard, RtInt63.ard). `check diff` compares the two on whole
// programs; this file pins down single constants, in particular the ones the
// model does not cover (Nat.pow, Lean arrays), where no other check exists.
// Exit status 0 iff every check passed.

public class RtTest {
  static int failed = 0;

  static Object ap(Object f, Object... xs) {
    for (Object x : xs) f = ((Rt.Fn) f).apply(x);
    return f;
  }

  static void check(String what, Object actual, Object expected) {
    boolean ok = expected.equals(actual);
    if (!ok) failed++;
    System.out.println((ok ? "  ok   " : "  FAIL ") + what + " = " + actual + (ok ? "" : ", expected " + expected));
  }

  static void throwsIoobe(String what, Runnable r) {
    String got;
    try { r.run(); got = "no exception"; }
    catch (IndexOutOfBoundsException e) { got = "IndexOutOfBoundsException"; }
    check(what, got, "IndexOutOfBoundsException");
  }

  static long naivePow(long x, long y) {
    long acc = 1L;
    for (long i = y; i > 0L; i--) acc *= x;
    return acc;
  }

  public static void main(String[] args) {
    System.out.println("Nat.pow (PRIM_POW_LONG): wraps mod 2^64 like the other *_LONG operations");
    check("3^5", ap(Rt.PRIM_POW_LONG, 3L, 5L), 243L);
    check("0^0", ap(Rt.PRIM_POW_LONG, 0L, 0L), 1L);
    check("2^63 (wraps to Long.MIN_VALUE)", ap(Rt.PRIM_POW_LONG, 2L, 63L), Long.MIN_VALUE);
    check("2^64 (wraps to 0)", ap(Rt.PRIM_POW_LONG, 2L, 64L), 0L);
    java.util.Random rnd = new java.util.Random(1);
    int mismatches = 0;
    for (int k = 0; k < 20000; k++) {
      long x = rnd.nextLong() % 50, y = rnd.nextInt(200);
      if (!ap(Rt.PRIM_POW_LONG, x, y).equals(naivePow(x, y))) mismatches++;
    }
    check("mismatches vs the naive product on 20000 random cases", mismatches, 0);
    // Was a loop of y multiplications: ~7 s for 2^33, centuries for 2^62.
    long t0 = System.nanoTime();
    Object big = ap(Rt.PRIM_POW_LONG, 1L, (1L << 62));
    long ms = (System.nanoTime() - t0) / 1000000L;
    check("1^(2^62)", big, 1L);
    check("1^(2^62) finishes within 1 s", ms < 1000L, true);

    System.out.println("Nat division by zero (Lean: n / 0 = 0, n % 0 = n)");
    check("7 / 0", ap(Rt.PRIM_DIV_LONG, 7L, 0L), 0L);
    check("7 % 0", ap(Rt.PRIM_MOD_LONG, 7L, 0L), 7L);

    System.out.println("Lean array indices are bounds-checked as longs");
    final Object one = ap(Rt.ARRAY_PUSH, Rt.BOX, ap(Rt.ARRAY_EMPTY_WITH_CAPACITY, Rt.BOX, 0L), 42L);
    check("#[42].get!Internal 0", ap(Rt.ARRAY_GET_BANG_INTERNAL, Rt.BOX, Rt.BOX, one, 0L), 42L);
    // Was truncated by intValue(): index 2^32 read element 0.
    throwsIoobe("#[42].get!Internal 2^32", () -> ap(Rt.ARRAY_GET_BANG_INTERNAL, Rt.BOX, Rt.BOX, one, 1L << 32));
    throwsIoobe("#[42].getInternal 2^32", () -> ap(Rt.ARRAY_GET_INTERNAL, Rt.BOX, one, 1L << 32, Rt.BOX));
    throwsIoobe("#[42].set! (2^32 + 1)", () -> ap(Rt.ARRAY_SET_BANG, Rt.BOX, one, (1L << 32) + 1, 0L));
    throwsIoobe("#[42].swap 0 2^32", () -> ap(Rt.ARRAY_SWAP, Rt.BOX, one, 0L, 1L << 32, Rt.BOX, Rt.BOX));
    throwsIoobe("#[42].get!Internal 1", () -> ap(Rt.ARRAY_GET_BANG_INTERNAL, Rt.BOX, Rt.BOX, one, 1L));

    System.out.println(failed == 0 ? "rt: all checks passed" : "rt: " + failed + " failing");
    System.exit(failed == 0 ? 0 : 1);
  }
}
