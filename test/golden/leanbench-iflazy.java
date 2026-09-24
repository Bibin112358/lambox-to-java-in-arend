public final class Prog {
  public static Object c_nsuite__iflazy(){
    return ((Rt.Fn)(c_niflazy())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oOfNat_nofNat())).apply(Rt.BOX))).apply(Long.valueOf(10L)))).apply(((Rt.Fn)(c_ninstOfNatNat())).apply(Long.valueOf(10L))));
  }
  public static Object c_niflazy(){
    class C {
      public Object f0(Object py0_){
        final Rt.Data dLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c_ninstDecidableEqNat())).apply(py0_))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oOfNat_nofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c_ninstOfNatNat())).apply(Long.valueOf(0L))))));
        return ((dLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
          return C.this.f0(pw0_);
        } })).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oHSub_nhSub())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_ninstHSub())).apply(Rt.BOX))).apply(c_ninstSubNat())))).apply(py0_))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oOfNat_nofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c_ninstOfNatNat())).apply(Long.valueOf(1L))))) : ((dLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oOfNat_nofNat())).apply(Rt.BOX))).apply(Long.valueOf(42L)))).apply(((Rt.Fn)(c_ninstOfNatNat())).apply(Long.valueOf(42L))) : Rt.noBranch(dLy0_, "Ly0_")));
      }
    }
    final C z = new C();
    return new Rt.Fn(){ public Object apply(Object pw0_){
      return z.f0(pw0_);
    } };
  }
  public static Object c_ninstSubNat(){
    return new Rt.Data(0, new Object[]{ c_oNat_nsub() });
  }
  public static Object c_oNat_nsub(){
    return Rt.NAT_SUB_LONG;
  }
  public static Object c_ninstHSub(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_LL){
          return new Rt.Fn(){ public Object apply(Object pLc0_LL){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oSub_nsub())).apply(Rt.BOX))).apply(pL))).apply(pc0_LL))).apply(pLc0_LL);
          } };
        } } });
      } };
    } };
  }
  public static Object c_oSub_nsub(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c_nSub: erased; values use Data(tag, fields)
  public static Object c_oHSub_nhSub(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            final Rt.Data dLLLL = ((Rt.Data)(pLLL));
            return ((dLLLL.tag == 0) ? dLLLL.fields[0] : Rt.noBranch(dLLLL, "LLLL"));
          } };
        } };
      } };
    } };
  }
  // inductive c_nHSub: erased; values use Data(tag, fields)
  // inductive c_nDecidable: erased; values use Data(tag, fields)
  public static Object c_ninstOfNatNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Data(0, new Object[]{ p });
    } };
  }
  public static Object c_oOfNat_nofNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          final Rt.Data dLLL = ((Rt.Data)(pLL));
          return ((dLLL.tag == 0) ? dLLL.fields[0] : Rt.noBranch(dLLL, "LLL"));
        } };
      } };
    } };
  }
  // inductive c_nOfNat: erased; values use Data(tag, fields)
  public static Object c_ninstDecidableEqNat(){
    return c_oNat_ndecEq();
  }
  public static Object c_oNat_ndecEq(){
    return Rt.PRIM_DEC_EQ_LONG;
  }
  public static Object body(){
    return c_nsuite__iflazy();
  }
}
