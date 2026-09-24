public final class Prog {
  public static Object c_nsuite__triangle__foldl(){
    return ((Rt.Fn)(c_ntriangle__foldl())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oOfNat_nofNat())).apply(Rt.BOX))).apply(Long.valueOf(10L)))).apply(((Rt.Fn)(c_ninstOfNatNat())).apply(Long.valueOf(10L))));
  }
  public static Object c_ntriangle__foldl(){
    return new Rt.Fn(){ public Object apply(Object p){
      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oList_nfoldl())).apply(Rt.BOX))).apply(Rt.BOX))).apply(c_oNat_nadd()))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oOfNat_nofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c_ninstOfNatNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(c_oList_nrange())).apply(p));
    } };
  }
  public static Object c_oList_nrange(){
    return new Rt.Fn(){ public Object apply(Object p){
      return ((Rt.Fn)(((Rt.Fn)(c_oList_orange_nloop())).apply(p))).apply(new Rt.Data(0, new Object[]{  }));
    } };
  }
  public static Object c_oList_orange_nloop(){
    class C {
      public Object f0(Object py0_){
        return new Rt.Fn(){ public Object apply(Object pLy0_){
          final Object lLLy0_ = new Rt.Fn(){ public Object apply(Object pVLLy0_){
            return pVLLy0_;
          } };
          final Object lBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBLLy0_){
              return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                return C.this.f0(pw0_);
              } })).apply(pVBLLy0_))).apply(new Rt.Data(1, new Object[]{ pVBLLy0_, pLVBLLy0_ }));
            } };
          } };
          final Object lBBLLy0_ = py0_;
          final Rt.Data dBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c_oNat_nbeq())).apply(lBBLLy0_))).apply(Long.valueOf(0L))));
          return ((dBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFb0_BBBLLy0_){
            return ((Rt.Fn)(((Rt.Fn)(lBLLy0_)).apply(pFb0_BBBLLy0_))).apply(pLy0_);
          } })).apply(((Rt.Fn)(((Rt.Fn)(c_oNat_nsub())).apply(lBBLLy0_))).apply(Long.valueOf(1L))) : ((dBBBLLy0_.tag == 1) ? ((Rt.Fn)(lLLy0_)).apply(pLy0_) : Rt.noBranch(dBBBLLy0_, "BBBLLy0_")));
        } };
      }
    }
    final C z = new C();
    return new Rt.Fn(){ public Object apply(Object pw0_){
      return z.f0(pw0_);
    } };
  }
  public static Object c_oNat_nbeq(){
    return Rt.PRIM_EQB_LONG;
  }
  public static Object c_oNat_nsub(){
    return Rt.NAT_SUB_LONG;
  }
  // inductive c_nBool: erased; values use Data(tag, fields)
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
  public static Object c_oNat_nadd(){
    return Rt.PRIM_ADD_INT63;
  }
  public static Object c_oList_nfoldl(){
    class C {
      public Object f0(Object py0_){
        return new Rt.Fn(){ public Object apply(Object pLy0_){
          return new Rt.Fn(){ public Object apply(Object pLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLLLy0_){
              return new Rt.Fn(){ public Object apply(Object pLLLLy0_){
                final Object lLLLLLy0_ = new Rt.Fn(){ public Object apply(Object pVLLLLLy0_){
                  return pVLLLLLy0_;
                } };
                final Object lBLLLLLy0_ = new Rt.Fn(){ public Object apply(Object pVBLLLLLy0_){
                  return new Rt.Fn(){ public Object apply(Object pLVBLLLLLy0_){
                    return new Rt.Fn(){ public Object apply(Object pLLVBLLLLLy0_){
                      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                        return C.this.f0(pw0_);
                      } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLy0_))).apply(((Rt.Fn)(((Rt.Fn)(pLLy0_)).apply(pVBLLLLLy0_))).apply(pLVBLLLLLy0_)))).apply(pLLVBLLLLLy0_);
                    } };
                  } };
                } };
                final Rt.Data dBBLLLLLy0_ = ((Rt.Data)(pLLLLy0_));
                return ((dBBLLLLLy0_.tag == 0) ? ((Rt.Fn)(lLLLLLy0_)).apply(pLLLy0_) : ((dBBLLLLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBLLLLLy0_)).apply(pLLLy0_))).apply(dBBLLLLLy0_.fields[0]))).apply(dBBLLLLLy0_.fields[1]) : Rt.noBranch(dBBLLLLLy0_, "BBLLLLLy0_")));
              } };
            } };
          } };
        } };
      }
    }
    final C z = new C();
    return new Rt.Fn(){ public Object apply(Object pw0_){
      return z.f0(pw0_);
    } };
  }
  // inductive c_nList: erased; values use Data(tag, fields)
  public static Object body(){
    return c_nsuite__triangle__foldl();
  }
}
