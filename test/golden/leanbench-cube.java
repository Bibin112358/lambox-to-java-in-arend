public final class Prog {
  public static Object c_nsuite__cube(){
    return ((Rt.Fn)(c_ncube())).apply(c_oUnit_nunit());
  }
  public static Object c_oUnit_nunit(){
    return new Rt.Data(0, new Object[]{  });
  }
  // inductive c_nPUnit: erased; values use Data(tag, fields)
  public static Object c_ncube(){
    return new Rt.Fn(){ public Object apply(Object p){
      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oHPow_nhPow())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_ninstHPow())).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_ninstPowNat())).apply(Rt.BOX))).apply(c_ninstNatPowNat()))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oOfNat_nofNat())).apply(Rt.BOX))).apply(Long.valueOf(300L)))).apply(((Rt.Fn)(c_ninstOfNatNat())).apply(Long.valueOf(300L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oOfNat_nofNat())).apply(Rt.BOX))).apply(Long.valueOf(3L)))).apply(((Rt.Fn)(c_ninstOfNatNat())).apply(Long.valueOf(3L))));
    } };
  }
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
  public static Object c_ninstNatPowNat(){
    return new Rt.Data(0, new Object[]{ c_oNat_npow() });
  }
  public static Object c_oNat_npow(){
    return Rt.PRIM_POW_LONG;
  }
  public static Object c_ninstPowNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_LL){
          return new Rt.Fn(){ public Object apply(Object pLc0_LL){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oNatPow_npow())).apply(Rt.BOX))).apply(pL))).apply(pc0_LL))).apply(pLc0_LL);
          } };
        } } });
      } };
    } };
  }
  public static Object c_oNatPow_npow(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c_nNatPow: erased; values use Data(tag, fields)
  public static Object c_ninstHPow(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_LLL){
            return new Rt.Fn(){ public Object apply(Object pLc0_LLL){
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oPow_npow())).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLL))).apply(pc0_LLL))).apply(pLc0_LLL);
            } };
          } } });
        } };
      } };
    } };
  }
  public static Object c_oPow_npow(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          final Rt.Data dLLL = ((Rt.Data)(pLL));
          return ((dLLL.tag == 0) ? dLLL.fields[0] : Rt.noBranch(dLLL, "LLL"));
        } };
      } };
    } };
  }
  // inductive c_nPow: erased; values use Data(tag, fields)
  public static Object c_oHPow_nhPow(){
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
  // inductive c_nHPow: erased; values use Data(tag, fields)
  public static Object body(){
    return c_nsuite__cube();
  }
}
