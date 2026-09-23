public final class Prog {
  public static Object c___suite_deriv(){
    return ((Rt.Fn)(c___deriv())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(10L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(10L))));
  }
  public static Object c___deriv(){
    return new Rt.Fn(){ public Object apply(Object p){
      final Object lL = ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__pow())).apply(new Rt.Data(1, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(0L))) })))).apply(new Rt.Data(1, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(0L))) }));
      return ((Rt.Fn)(c__Deriv_Expr__count())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__nest())).apply(c__Deriv_Expr__deriv()))).apply(p))).apply(lL));
    } };
  }
  public static Object c__Deriv_Expr__deriv(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__d())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(0L)))))).apply(pL);
      } };
    } };
  }
  public static Object c__Deriv_Expr__d(){
    class C {
      public Object f0(Object py0_){
        return new Rt.Fn(){ public Object apply(Object pLy0_){
          final Object lLLy0_ = new Rt.Fn(){ public Object apply(Object pVLLy0_){
            return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))) });
          } };
          final Object lBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBLLy0_){
            final Rt.Data dLVBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c___instDecidableEqNat())).apply(py0_))).apply(pVBLLy0_)));
            return ((dLVBLLy0_.tag == 0) ? new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))) }) : ((dLVBLLy0_.tag == 1) ? new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))) }) : Rt.noBranch(dLVBLLy0_, "LVBLLy0_")));
          } };
          final Object lBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBLLy0_){
              return ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__add())).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                return C.this.f0(pw0_);
              } })).apply(py0_))).apply(pVBBLLy0_)))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                return C.this.f0(pw0_);
              } })).apply(py0_))).apply(pLVBBLLy0_));
            } };
          } };
          final Object lBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBBLLy0_){
              return ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__add())).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(pVBBBLLy0_))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                return C.this.f0(pw0_);
              } })).apply(py0_))).apply(pLVBBBLLy0_))))).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(pLVBBBLLy0_))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                return C.this.f0(pw0_);
              } })).apply(py0_))).apply(pVBBBLLy0_)));
            } };
          } };
          final Object lBBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBLLy0_){
              return ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__pow())).apply(pVBBBBLLy0_))).apply(pLVBBBBLLy0_)))).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__add())).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(pLVBBBBLLy0_))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                return C.this.f0(pw0_);
              } })).apply(py0_))).apply(pVBBBBLLy0_))))).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__pow())).apply(pVBBBBLLy0_))).apply(new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Neg__neg())).apply(Rt.BOX))).apply(c__Int__instNegInt()))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))) })))))).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(((Rt.Fn)(c__Deriv_Expr__ln())).apply(pVBBBBLLy0_)))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                return C.this.f0(pw0_);
              } })).apply(py0_))).apply(pLVBBBBLLy0_))));
            } };
          } };
          final Object lBBBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBBLLy0_){
            return ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
              return C.this.f0(pw0_);
            } })).apply(py0_))).apply(pVBBBBBLLy0_)))).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__pow())).apply(pVBBBBBLLy0_))).apply(new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Neg__neg())).apply(Rt.BOX))).apply(c__Int__instNegInt()))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))) })));
          } };
          final Rt.Data dBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
          return ((dBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(lLLy0_)).apply(dBBBBBBLLy0_.fields[0]) : ((dBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(lBLLy0_)).apply(dBBBBBBLLy0_.fields[0]) : ((dBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBLLy0_)).apply(dBBBBBBLLy0_.fields[0]))).apply(dBBBBBBLLy0_.fields[1]) : ((dBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBLLy0_)).apply(dBBBBBBLLy0_.fields[0]))).apply(dBBBBBBLLy0_.fields[1]) : ((dBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLLy0_)).apply(dBBBBBBLLy0_.fields[0]))).apply(dBBBBBBLLy0_.fields[1]) : ((dBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(lBBBBBLLy0_)).apply(dBBBBBBLLy0_.fields[0]) : Rt.noBranch(dBBBBBBLLy0_, "BBBBBBLLy0_")))))));
        } };
      }
    }
    final C z = new C();
    return new Rt.Fn(){ public Object apply(Object pw0_){
      return z.f0(pw0_);
    } };
  }
  public static Object c__Deriv_Expr__ln(){
    return new Rt.Fn(){ public Object apply(Object p){
      final Object lL = new Rt.Fn(){ public Object apply(Object pVL){
        return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))) });
      } };
      final Object lBL = new Rt.Fn(){ public Object apply(Object pVBL){
        return new Rt.Data(5, new Object[]{ pVBL });
      } };
      final Rt.Data dBBL = ((Rt.Data)(p));
      return ((dBBL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_BBL){
        final Rt.Data db0_BBL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dBBL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
        return ((db0_BBL.tag == 0) ? ((Rt.Fn)(lBL)).apply(new Rt.Data(0, new Object[]{ dBBL.fields[0] })) : ((db0_BBL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lL)).apply(c__Unit__unit())))).apply(dBBL.fields[0]))).apply(Rt.BOX)))).apply(dBBL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_BBL, "b0_BBL")));
      } })).apply(Rt.BOX) : ((dBBL.tag == 1) ? ((Rt.Fn)(lBL)).apply(new Rt.Data(1, new Object[]{ dBBL.fields[0] })) : ((dBBL.tag == 2) ? ((Rt.Fn)(lBL)).apply(new Rt.Data(2, new Object[]{ dBBL.fields[0], dBBL.fields[1] })) : ((dBBL.tag == 3) ? ((Rt.Fn)(lBL)).apply(new Rt.Data(3, new Object[]{ dBBL.fields[0], dBBL.fields[1] })) : ((dBBL.tag == 4) ? ((Rt.Fn)(lBL)).apply(new Rt.Data(4, new Object[]{ dBBL.fields[0], dBBL.fields[1] })) : ((dBBL.tag == 5) ? ((Rt.Fn)(lBL)).apply(new Rt.Data(5, new Object[]{ dBBL.fields[0] })) : Rt.noBranch(dBBL, "BBL")))))));
    } };
  }
  public static Object c__Unit__unit(){
    return new Rt.Data(0, new Object[]{  });
  }
  // inductive c___PUnit: erased; values use Data(tag, fields)
  public static Object c__Int__instNegInt(){
    return new Rt.Data(0, new Object[]{ c__Int__neg() });
  }
  public static Object c__Int__neg(){
    return Rt.INT_NEG_LONG;
  }
  public static Object c__Neg__neg(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Neg: erased; values use Data(tag, fields)
  public static Object c__Deriv_Expr__mul(){
    class C {
      public Object f0(Object py0_){
        return new Rt.Fn(){ public Object apply(Object pLy0_){
          final Object lLLy0_ = new Rt.Fn(){ public Object apply(Object pVLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVLLy0_){
              return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HMul__hMul())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHMul())).apply(Rt.BOX))).apply(c__Int__instMul())))).apply(pVLLy0_))).apply(pLVLLy0_) });
            } };
          } };
          final Object lBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBLLy0_){
            return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))) });
          } };
          final Object lBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBLLy0_){
            return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))) });
          } };
          final Object lBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBLLy0_){
            return pVBBBLLy0_;
          } };
          final Object lBBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBLLy0_){
            return pVBBBBLLy0_;
          } };
          final Object lBBBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBLLy0_){
              return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                return C.this.f0(pw0_);
              } })).apply(new Rt.Data(0, new Object[]{ pLVBBBBBLLy0_ })))).apply(pVBBBBBLLy0_);
            } };
          } };
          final Object lBBBBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBBLLy0_){
              return new Rt.Fn(){ public Object apply(Object pLLVBBBBBBLLy0_){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                  return C.this.f0(pw0_);
                } })).apply(new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HMul__hMul())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHMul())).apply(Rt.BOX))).apply(c__Int__instMul())))).apply(pVBBBBBBLLy0_))).apply(pLVBBBBBBLLy0_) })))).apply(pLLVBBBBBBLLy0_);
              } };
            } };
          } };
          final Object lBBBBBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBBBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBBBLLy0_){
              return new Rt.Fn(){ public Object apply(Object pLLVBBBBBBBLLy0_){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                  return C.this.f0(pw0_);
                } })).apply(new Rt.Data(0, new Object[]{ pLVBBBBBBBLLy0_ })))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                  return C.this.f0(pw0_);
                } })).apply(pVBBBBBBBLLy0_))).apply(pLLVBBBBBBBLLy0_));
              } };
            } };
          } };
          final Object lBBBBBBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBBBBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBBBBLLy0_){
              return new Rt.Fn(){ public Object apply(Object pLLVBBBBBBBBLLy0_){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                  return C.this.f0(pw0_);
                } })).apply(pVBBBBBBBBLLy0_))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                  return C.this.f0(pw0_);
                } })).apply(pLVBBBBBBBBLLy0_))).apply(pLLVBBBBBBBBLLy0_));
              } };
            } };
          } };
          final Object lBBBBBBBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBBBBBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBBBBBLLy0_){
              return new Rt.Data(3, new Object[]{ pVBBBBBBBBBLLy0_, pLVBBBBBBBBBLLy0_ });
            } };
          } };
          final Rt.Data dBBBBBBBBBBLLy0_ = ((Rt.Data)(py0_));
          return ((dBBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_BBBBBBBBBBLLy0_){
            final Rt.Data db0_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_BBBBBBBBBBLLy0_){
              final Rt.Data db0_b0_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
              return ((db0_b0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b0_BBBBBBBBBBLLy0_){
                final Rt.Data db0_b0_b0_BBBBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
                return ((db0_b0_b0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b0_b0_BBBBBBBBBBLLy0_){
                  final Rt.Data db0_b0_b0_b0_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db0_b0_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
                  return ((db0_b0_b0_b0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b0_b0_b0_BBBBBBBBBBLLy0_){
                    final Rt.Data db0_b0_b0_b0_b0_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db0_b0_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                    return ((db0_b0_b0_b0_b0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLLy0_)).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(db0_b0_b0_BBBBBBBBBBLLy0_.fields[0]) : ((db0_b0_b0_b0_b0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_b0_b0_b0_BBBBBBBBBBLLy0_){
                      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0_)).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))))).apply(db0_b0_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX);
                    } }))).apply(db0_b0_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b0_b0_b0_BBBBBBBBBBLLy0_, "b0_b0_b0_b0_b0_BBBBBBBBBBLLy0_")));
                  } })).apply(Rt.BOX) : ((db0_b0_b0_b0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0_)).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(db0_b0_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(db0_b0_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b0_b0_BBBBBBBBBBLLy0_, "b0_b0_b0_b0_BBBBBBBBBBLLy0_")));
                } })).apply(Rt.BOX) : ((db0_b0_b0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db0_b0_b0_BBBBBBBBBBLLy0_.fields[0] })) : ((db0_b0_b0_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ db0_b0_b0_BBBBBBBBBBLLy0_.fields[0], db0_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db0_b0_b0_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3_b0_b0_b0_BBBBBBBBBBLLy0_){
                  final Rt.Data db3_b0_b0_b0_BBBBBBBBBBLLy0_ = ((Rt.Data)(db0_b0_b0_BBBBBBBBBBLLy0_.fields[0]));
                  return ((db3_b0_b0_b0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0_)).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(db3_b0_b0_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(db0_b0_b0_BBBBBBBBBBLLy0_.fields[1]) : ((db3_b0_b0_b0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3_b0_b0_b0_BBBBBBBBBBLLy0_.fields[0] }), db0_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b0_b0_b0_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3_b0_b0_b0_BBBBBBBBBBLLy0_.fields[0], db3_b0_b0_b0_BBBBBBBBBBLLy0_.fields[1] }), db0_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b0_b0_b0_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3_b0_b0_b0_BBBBBBBBBBLLy0_.fields[0], db3_b0_b0_b0_BBBBBBBBBBLLy0_.fields[1] }), db0_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b0_b0_b0_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3_b0_b0_b0_BBBBBBBBBBLLy0_.fields[0], db3_b0_b0_b0_BBBBBBBBBBLLy0_.fields[1] }), db0_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b0_b0_b0_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3_b0_b0_b0_BBBBBBBBBBLLy0_.fields[0] }), db0_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db3_b0_b0_b0_BBBBBBBBBBLLy0_, "b3_b0_b0_b0_BBBBBBBBBBLLy0_")))))));
                } })).apply(Rt.BOX) : ((db0_b0_b0_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db0_b0_b0_BBBBBBBBBBLLy0_.fields[0], db0_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db0_b0_b0_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db0_b0_b0_BBBBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(db0_b0_b0_BBBBBBBBBBLLy0_, "b0_b0_b0_BBBBBBBBBBLLy0_")))))));
              } })).apply(Rt.BOX) : ((db0_b0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_BBBBBBBBBBLLy0_){
                final Rt.Data dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_){
                  final Rt.Data db0_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
                  return ((db0_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_){
                    final Rt.Data db0_b0_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                    return ((db0_b0_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLLy0_)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0]) : ((db0_b0_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_){
                      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0_)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))))).apply(dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX);
                    } }))).apply(dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_, "b0_b0_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_")));
                  } })).apply(Rt.BOX) : ((db0_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0_)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_, "b0_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_")));
                } })).apply(Rt.BOX) : ((dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0] })) : ((dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0], dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_){
                  final Rt.Data db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_ = ((Rt.Data)(dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0]));
                  return ((db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(0, new Object[]{ db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0] }), dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0] }), dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0], db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[1] }), dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0], db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[1] }), dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0], db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[1] }), dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0] }), dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_, "b3_AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_")))))));
                } })).apply(Rt.BOX) : ((dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0], dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(dAFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_, "AFFLAFFFb1_b0_b0_BBBBBBBBBBLLy0_")))))))))).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX);
              } }))).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_BBBBBBBBBBLLy0_, "b0_b0_BBBBBBBBBBLLy0_")));
            } })).apply(Rt.BOX) : ((db0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1_b0_BBBBBBBBBBLLy0_){
              final Rt.Data dAFFAFFb1_b0_BBBBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((dAFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_AFFAFFb1_b0_BBBBBBBBBBLLy0_){
                final Rt.Data db0_AFFAFFb1_b0_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
                return ((db0_AFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_AFFAFFb1_b0_BBBBBBBBBBLLy0_){
                  final Rt.Data db0_b0_AFFAFFb1_b0_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                  return ((db0_b0_AFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLLy0_)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0]) : ((db0_b0_AFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_AFFAFFb1_b0_BBBBBBBBBBLLy0_){
                    return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0_)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))))).apply(dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX);
                  } }))).apply(dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_AFFAFFb1_b0_BBBBBBBBBBLLy0_, "b0_b0_AFFAFFb1_b0_BBBBBBBBBBLLy0_")));
                } })).apply(Rt.BOX) : ((db0_AFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0_)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_AFFAFFb1_b0_BBBBBBBBBBLLy0_, "b0_AFFAFFb1_b0_BBBBBBBBBBLLy0_")));
              } })).apply(Rt.BOX) : ((dAFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(1, new Object[]{ dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0] })) : ((dAFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(2, new Object[]{ dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0], dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((dAFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3_AFFAFFb1_b0_BBBBBBBBBBLLy0_){
                final Rt.Data db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_ = ((Rt.Data)(dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0]));
                return ((db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(0, new Object[]{ db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0] }), dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0] }), dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0], db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[1] }), dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0], db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[1] }), dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0], db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[1] }), dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0] }), dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db3_AFFAFFb1_b0_BBBBBBBBBBLLy0_, "b3_AFFAFFb1_b0_BBBBBBBBBBLLy0_")))))));
              } })).apply(Rt.BOX) : ((dAFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(4, new Object[]{ dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0], dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[1] })) : ((dAFFAFFb1_b0_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(5, new Object[]{ dAFFAFFb1_b0_BBBBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(dAFFAFFb1_b0_BBBBBBBBBBLLy0_, "AFFAFFb1_b0_BBBBBBBBBBLLy0_")))))))))).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX);
            } })).apply(Rt.BOX) : Rt.noBranch(db0_BBBBBBBBBBLLy0_, "b0_BBBBBBBBBBLLy0_")));
          } })).apply(Rt.BOX) : ((dBBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1_BBBBBBBBBBLLy0_){
            final Rt.Data db1_BBBBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
            return ((db1_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b1_BBBBBBBBBBLLy0_){
              final Rt.Data db0_b1_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db1_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0_b1_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b1_BBBBBBBBBBLLy0_){
                final Rt.Data db0_b0_b1_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db1_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0_b0_b1_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(db1_BBBBBBBBBBLLy0_.fields[0]) : ((db0_b0_b1_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_b1_BBBBBBBBBBLLy0_){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] }))))).apply(db1_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX);
                } }))).apply(db1_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b1_BBBBBBBBBBLLy0_, "b0_b0_b1_BBBBBBBBBBLLy0_")));
              } })).apply(Rt.BOX) : ((db0_b1_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] }))))).apply(db1_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(db1_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b1_BBBBBBBBBBLLy0_, "b0_b1_BBBBBBBBBBLLy0_")));
            } })).apply(Rt.BOX) : ((db1_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db1_BBBBBBBBBBLLy0_.fields[0] })) : ((db1_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ db1_BBBBBBBBBBLLy0_.fields[0], db1_BBBBBBBBBBLLy0_.fields[1] })) : ((db1_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3_b1_BBBBBBBBBBLLy0_){
              final Rt.Data db3_b1_BBBBBBBBBBLLy0_ = ((Rt.Data)(db1_BBBBBBBBBBLLy0_.fields[0]));
              return ((db3_b1_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(db3_b1_BBBBBBBBBBLLy0_.fields[0]))).apply(db1_BBBBBBBBBBLLy0_.fields[1]) : ((db3_b1_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3_b1_BBBBBBBBBBLLy0_.fields[0] }), db1_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b1_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3_b1_BBBBBBBBBBLLy0_.fields[0], db3_b1_BBBBBBBBBBLLy0_.fields[1] }), db1_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b1_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3_b1_BBBBBBBBBBLLy0_.fields[0], db3_b1_BBBBBBBBBBLLy0_.fields[1] }), db1_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b1_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3_b1_BBBBBBBBBBLLy0_.fields[0], db3_b1_BBBBBBBBBBLLy0_.fields[1] }), db1_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b1_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3_b1_BBBBBBBBBBLLy0_.fields[0] }), db1_BBBBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db3_b1_BBBBBBBBBBLLy0_, "b3_b1_BBBBBBBBBBLLy0_")))))));
            } })).apply(Rt.BOX) : ((db1_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db1_BBBBBBBBBBLLy0_.fields[0], db1_BBBBBBBBBBLLy0_.fields[1] })) : ((db1_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db1_BBBBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(db1_BBBBBBBBBBLLy0_, "b1_BBBBBBBBBBLLy0_")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2_BBBBBBBBBBLLy0_){
            final Rt.Data db2_BBBBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
            return ((db2_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b2_BBBBBBBBBBLLy0_){
              final Rt.Data db0_b2_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db2_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0_b2_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b2_BBBBBBBBBBLLy0_){
                final Rt.Data db0_b0_b2_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db2_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0_b0_b2_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(db2_BBBBBBBBBBLLy0_.fields[0]) : ((db0_b0_b2_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_b2_BBBBBBBBBBLLy0_){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] }))))).apply(db2_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX);
                } }))).apply(db2_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b2_BBBBBBBBBBLLy0_, "b0_b0_b2_BBBBBBBBBBLLy0_")));
              } })).apply(Rt.BOX) : ((db0_b2_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] }))))).apply(db2_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(db2_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b2_BBBBBBBBBBLLy0_, "b0_b2_BBBBBBBBBBLLy0_")));
            } })).apply(Rt.BOX) : ((db2_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db2_BBBBBBBBBBLLy0_.fields[0] })) : ((db2_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(2, new Object[]{ db2_BBBBBBBBBBLLy0_.fields[0], db2_BBBBBBBBBBLLy0_.fields[1] })) : ((db2_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3_b2_BBBBBBBBBBLLy0_){
              final Rt.Data db3_b2_BBBBBBBBBBLLy0_ = ((Rt.Data)(db2_BBBBBBBBBBLLy0_.fields[0]));
              return ((db3_b2_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(db3_b2_BBBBBBBBBBLLy0_.fields[0]))).apply(db2_BBBBBBBBBBLLy0_.fields[1]) : ((db3_b2_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3_b2_BBBBBBBBBBLLy0_.fields[0] }), db2_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b2_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3_b2_BBBBBBBBBBLLy0_.fields[0], db3_b2_BBBBBBBBBBLLy0_.fields[1] }), db2_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b2_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3_b2_BBBBBBBBBBLLy0_.fields[0], db3_b2_BBBBBBBBBBLLy0_.fields[1] }), db2_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b2_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3_b2_BBBBBBBBBBLLy0_.fields[0], db3_b2_BBBBBBBBBBLLy0_.fields[1] }), db2_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b2_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3_b2_BBBBBBBBBBLLy0_.fields[0] }), db2_BBBBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db3_b2_BBBBBBBBBBLLy0_, "b3_b2_BBBBBBBBBBLLy0_")))))));
            } })).apply(Rt.BOX) : ((db2_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db2_BBBBBBBBBBLLy0_.fields[0], db2_BBBBBBBBBBLLy0_.fields[1] })) : ((db2_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db2_BBBBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(db2_BBBBBBBBBBLLy0_, "b2_BBBBBBBBBBLLy0_")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3_BBBBBBBBBBLLy0_){
            final Rt.Data db3_BBBBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
            return ((db3_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b3_BBBBBBBBBBLLy0_){
              final Rt.Data db0_b3_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db3_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0_b3_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b3_BBBBBBBBBBLLy0_){
                final Rt.Data db0_b0_b3_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db3_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0_b0_b3_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(db3_BBBBBBBBBBLLy0_.fields[0]) : ((db0_b0_b3_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_b3_BBBBBBBBBBLLy0_){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] }))))).apply(db3_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX);
                } }))).apply(db3_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b3_BBBBBBBBBBLLy0_, "b0_b0_b3_BBBBBBBBBBLLy0_")));
              } })).apply(Rt.BOX) : ((db0_b3_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] }))))).apply(db3_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(db3_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b3_BBBBBBBBBBLLy0_, "b0_b3_BBBBBBBBBBLLy0_")));
            } })).apply(Rt.BOX) : ((db3_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0_)).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(1, new Object[]{ db3_BBBBBBBBBBLLy0_.fields[0] })) : ((db3_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0_)).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(2, new Object[]{ db3_BBBBBBBBBBLLy0_.fields[0], db3_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3_b3_BBBBBBBBBBLLy0_){
              final Rt.Data db3_b3_BBBBBBBBBBLLy0_ = ((Rt.Data)(db3_BBBBBBBBBBLLy0_.fields[0]));
              return ((db3_b3_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(db3_b3_BBBBBBBBBBLLy0_.fields[0]))).apply(db3_BBBBBBBBBBLLy0_.fields[1]) : ((db3_b3_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0_)).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3_b3_BBBBBBBBBBLLy0_.fields[0] }), db3_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b3_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0_)).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3_b3_BBBBBBBBBBLLy0_.fields[0], db3_b3_BBBBBBBBBBLLy0_.fields[1] }), db3_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b3_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0_)).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3_b3_BBBBBBBBBBLLy0_.fields[0], db3_b3_BBBBBBBBBBLLy0_.fields[1] }), db3_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b3_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0_)).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3_b3_BBBBBBBBBBLLy0_.fields[0], db3_b3_BBBBBBBBBBLLy0_.fields[1] }), db3_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b3_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0_)).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3_b3_BBBBBBBBBBLLy0_.fields[0] }), db3_BBBBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db3_b3_BBBBBBBBBBLLy0_, "b3_b3_BBBBBBBBBBLLy0_")))))));
            } })).apply(Rt.BOX) : ((db3_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0_)).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(4, new Object[]{ db3_BBBBBBBBBBLLy0_.fields[0], db3_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0_)).apply(dBBBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(5, new Object[]{ db3_BBBBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(db3_BBBBBBBBBBLLy0_, "b3_BBBBBBBBBBLLy0_")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb4_BBBBBBBBBBLLy0_){
            final Rt.Data db4_BBBBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
            return ((db4_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b4_BBBBBBBBBBLLy0_){
              final Rt.Data db0_b4_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db4_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0_b4_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b4_BBBBBBBBBBLLy0_){
                final Rt.Data db0_b0_b4_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db4_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0_b0_b4_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(db4_BBBBBBBBBBLLy0_.fields[0]) : ((db0_b0_b4_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_b4_BBBBBBBBBBLLy0_){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] }))))).apply(db4_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX);
                } }))).apply(db4_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b4_BBBBBBBBBBLLy0_, "b0_b0_b4_BBBBBBBBBBLLy0_")));
              } })).apply(Rt.BOX) : ((db0_b4_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] }))))).apply(db4_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(db4_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b4_BBBBBBBBBBLLy0_, "b0_b4_BBBBBBBBBBLLy0_")));
            } })).apply(Rt.BOX) : ((db4_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db4_BBBBBBBBBBLLy0_.fields[0] })) : ((db4_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(2, new Object[]{ db4_BBBBBBBBBBLLy0_.fields[0], db4_BBBBBBBBBBLLy0_.fields[1] })) : ((db4_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3_b4_BBBBBBBBBBLLy0_){
              final Rt.Data db3_b4_BBBBBBBBBBLLy0_ = ((Rt.Data)(db4_BBBBBBBBBBLLy0_.fields[0]));
              return ((db3_b4_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(db3_b4_BBBBBBBBBBLLy0_.fields[0]))).apply(db4_BBBBBBBBBBLLy0_.fields[1]) : ((db3_b4_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3_b4_BBBBBBBBBBLLy0_.fields[0] }), db4_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b4_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3_b4_BBBBBBBBBBLLy0_.fields[0], db3_b4_BBBBBBBBBBLLy0_.fields[1] }), db4_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b4_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3_b4_BBBBBBBBBBLLy0_.fields[0], db3_b4_BBBBBBBBBBLLy0_.fields[1] }), db4_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b4_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3_b4_BBBBBBBBBBLLy0_.fields[0], db3_b4_BBBBBBBBBBLLy0_.fields[1] }), db4_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b4_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3_b4_BBBBBBBBBBLLy0_.fields[0] }), db4_BBBBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db3_b4_BBBBBBBBBBLLy0_, "b3_b4_BBBBBBBBBBLLy0_")))))));
            } })).apply(Rt.BOX) : ((db4_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db4_BBBBBBBBBBLLy0_.fields[0], db4_BBBBBBBBBBLLy0_.fields[1] })) : ((db4_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0_.fields[0], dBBBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db4_BBBBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(db4_BBBBBBBBBBLLy0_, "b4_BBBBBBBBBBLLy0_")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb5_BBBBBBBBBBLLy0_){
            final Rt.Data db5_BBBBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
            return ((db5_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b5_BBBBBBBBBBLLy0_){
              final Rt.Data db0_b5_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db5_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0_b5_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b5_BBBBBBBBBBLLy0_){
                final Rt.Data db0_b0_b5_BBBBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db5_BBBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0_b0_b5_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(db5_BBBBBBBBBBLLy0_.fields[0]) : ((db0_b0_b5_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_b5_BBBBBBBBBBLLy0_){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] }))))).apply(db5_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX);
                } }))).apply(db5_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b5_BBBBBBBBBBLLy0_, "b0_b0_b5_BBBBBBBBBBLLy0_")));
              } })).apply(Rt.BOX) : ((db0_b5_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] }))))).apply(db5_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(db5_BBBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b5_BBBBBBBBBBLLy0_, "b0_b5_BBBBBBBBBBLLy0_")));
            } })).apply(Rt.BOX) : ((db5_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db5_BBBBBBBBBBLLy0_.fields[0] })) : ((db5_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ db5_BBBBBBBBBBLLy0_.fields[0], db5_BBBBBBBBBBLLy0_.fields[1] })) : ((db5_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3_b5_BBBBBBBBBBLLy0_){
              final Rt.Data db3_b5_BBBBBBBBBBLLy0_ = ((Rt.Data)(db5_BBBBBBBBBBLLy0_.fields[0]));
              return ((db3_b5_BBBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(db3_b5_BBBBBBBBBBLLy0_.fields[0]))).apply(db5_BBBBBBBBBBLLy0_.fields[1]) : ((db3_b5_BBBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3_b5_BBBBBBBBBBLLy0_.fields[0] }), db5_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b5_BBBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3_b5_BBBBBBBBBBLLy0_.fields[0], db3_b5_BBBBBBBBBBLLy0_.fields[1] }), db5_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b5_BBBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3_b5_BBBBBBBBBBLLy0_.fields[0], db3_b5_BBBBBBBBBBLLy0_.fields[1] }), db5_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b5_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3_b5_BBBBBBBBBBLLy0_.fields[0], db3_b5_BBBBBBBBBBLLy0_.fields[1] }), db5_BBBBBBBBBBLLy0_.fields[1] })) : ((db3_b5_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3_b5_BBBBBBBBBBLLy0_.fields[0] }), db5_BBBBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db3_b5_BBBBBBBBBBLLy0_, "b3_b5_BBBBBBBBBBLLy0_")))))));
            } })).apply(Rt.BOX) : ((db5_BBBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db5_BBBBBBBBBBLLy0_.fields[0], db5_BBBBBBBBBBLLy0_.fields[1] })) : ((db5_BBBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db5_BBBBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(db5_BBBBBBBBBBLLy0_, "b5_BBBBBBBBBBLLy0_")))))));
          } })).apply(Rt.BOX) : Rt.noBranch(dBBBBBBBBBBLLy0_, "BBBBBBBBBBLLy0_")))))));
        } };
      }
    }
    final C z = new C();
    return new Rt.Fn(){ public Object apply(Object pw0_){
      return z.f0(pw0_);
    } };
  }
  public static Object c__Deriv_Expr__add(){
    class C {
      public Object f0(Object py0_){
        return new Rt.Fn(){ public Object apply(Object pLy0_){
          final Object lLLy0_ = new Rt.Fn(){ public Object apply(Object pVLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVLLy0_){
              return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HAdd__hAdd())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHAdd())).apply(Rt.BOX))).apply(c__Int__instAdd())))).apply(pVLLy0_))).apply(pLVLLy0_) });
            } };
          } };
          final Object lBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBLLy0_){
            return pVBLLy0_;
          } };
          final Object lBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBLLy0_){
            return pVBBLLy0_;
          } };
          final Object lBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBBLLy0_){
              return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                return C.this.f0(pw0_);
              } })).apply(new Rt.Data(0, new Object[]{ pLVBBBLLy0_ })))).apply(pVBBBLLy0_);
            } };
          } };
          final Object lBBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBLLy0_){
              return new Rt.Fn(){ public Object apply(Object pLLVBBBBLLy0_){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                  return C.this.f0(pw0_);
                } })).apply(new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HAdd__hAdd())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHAdd())).apply(Rt.BOX))).apply(c__Int__instAdd())))).apply(pVBBBBLLy0_))).apply(pLVBBBBLLy0_) })))).apply(pLLVBBBBLLy0_);
              } };
            } };
          } };
          final Object lBBBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBLLy0_){
              return new Rt.Fn(){ public Object apply(Object pLLVBBBBBLLy0_){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                  return C.this.f0(pw0_);
                } })).apply(new Rt.Data(0, new Object[]{ pLVBBBBBLLy0_ })))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                  return C.this.f0(pw0_);
                } })).apply(pVBBBBBLLy0_))).apply(pLLVBBBBBLLy0_));
              } };
            } };
          } };
          final Object lBBBBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBBLLy0_){
              return new Rt.Fn(){ public Object apply(Object pLLVBBBBBBLLy0_){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                  return C.this.f0(pw0_);
                } })).apply(pVBBBBBBLLy0_))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                  return C.this.f0(pw0_);
                } })).apply(pLVBBBBBBLLy0_))).apply(pLLVBBBBBBLLy0_));
              } };
            } };
          } };
          final Object lBBBBBBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBBBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBBBLLy0_){
              return new Rt.Data(2, new Object[]{ pVBBBBBBBLLy0_, pLVBBBBBBBLLy0_ });
            } };
          } };
          final Rt.Data dBBBBBBBBLLy0_ = ((Rt.Data)(py0_));
          return ((dBBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_BBBBBBBBLLy0_){
            final Rt.Data db0_BBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_BBBBBBBBLLy0_){
              final Rt.Data db0_b0_BBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
              return ((db0_b0_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b0_BBBBBBBBLLy0_){
                final Rt.Data db0_b0_b0_BBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db0_b0_BBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
                return ((db0_b0_b0_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLLy0_)).apply(dBBBBBBBBLLy0_.fields[0]))).apply(db0_b0_BBBBBBBBLLy0_.fields[0]) : ((db0_b0_b0_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0_)).apply(dBBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(db0_b0_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(db0_b0_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b0_BBBBBBBBLLy0_, "b0_b0_b0_BBBBBBBBLLy0_")));
              } })).apply(Rt.BOX) : ((db0_b0_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db0_b0_BBBBBBBBLLy0_.fields[0] })) : ((db0_b0_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2_b0_b0_BBBBBBBBLLy0_){
                final Rt.Data db2_b0_b0_BBBBBBBBLLy0_ = ((Rt.Data)(db0_b0_BBBBBBBBLLy0_.fields[0]));
                return ((db2_b0_b0_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBLLy0_)).apply(dBBBBBBBBLLy0_.fields[0]))).apply(db2_b0_b0_BBBBBBBBLLy0_.fields[0]))).apply(db0_b0_BBBBBBBBLLy0_.fields[1]) : ((db2_b0_b0_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2_b0_b0_BBBBBBBBLLy0_.fields[0] }), db0_b0_BBBBBBBBLLy0_.fields[1] })) : ((db2_b0_b0_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2_b0_b0_BBBBBBBBLLy0_.fields[0], db2_b0_b0_BBBBBBBBLLy0_.fields[1] }), db0_b0_BBBBBBBBLLy0_.fields[1] })) : ((db2_b0_b0_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2_b0_b0_BBBBBBBBLLy0_.fields[0], db2_b0_b0_BBBBBBBBLLy0_.fields[1] }), db0_b0_BBBBBBBBLLy0_.fields[1] })) : ((db2_b0_b0_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2_b0_b0_BBBBBBBBLLy0_.fields[0], db2_b0_b0_BBBBBBBBLLy0_.fields[1] }), db0_b0_BBBBBBBBLLy0_.fields[1] })) : ((db2_b0_b0_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2_b0_b0_BBBBBBBBLLy0_.fields[0] }), db0_b0_BBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db2_b0_b0_BBBBBBBBLLy0_, "b2_b0_b0_BBBBBBBBLLy0_")))))));
              } })).apply(Rt.BOX) : ((db0_b0_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ db0_b0_BBBBBBBBLLy0_.fields[0], db0_b0_BBBBBBBBLLy0_.fields[1] })) : ((db0_b0_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db0_b0_BBBBBBBBLLy0_.fields[0], db0_b0_BBBBBBBBLLy0_.fields[1] })) : ((db0_b0_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db0_b0_BBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(db0_b0_BBBBBBBBLLy0_, "b0_b0_BBBBBBBBLLy0_")))))));
            } })).apply(Rt.BOX) : ((db0_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1_b0_BBBBBBBBLLy0_){
              final Rt.Data dAFFAFFb1_b0_BBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((dAFFAFFb1_b0_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_AFFAFFb1_b0_BBBBBBBBLLy0_){
                final Rt.Data db0_AFFAFFb1_b0_BBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
                return ((db0_AFFAFFb1_b0_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLLy0_)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[0]) : ((db0_AFFAFFb1_b0_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0_)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_AFFAFFb1_b0_BBBBBBBBLLy0_, "b0_AFFAFFb1_b0_BBBBBBBBLLy0_")));
              } })).apply(Rt.BOX) : ((dAFFAFFb1_b0_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(1, new Object[]{ dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[0] })) : ((dAFFAFFb1_b0_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2_AFFAFFb1_b0_BBBBBBBBLLy0_){
                final Rt.Data db2_AFFAFFb1_b0_BBBBBBBBLLy0_ = ((Rt.Data)(dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[0]));
                return ((db2_AFFAFFb1_b0_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(2, new Object[]{ new Rt.Data(0, new Object[]{ db2_AFFAFFb1_b0_BBBBBBBBLLy0_.fields[0] }), dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[1] })) : ((db2_AFFAFFb1_b0_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2_AFFAFFb1_b0_BBBBBBBBLLy0_.fields[0] }), dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[1] })) : ((db2_AFFAFFb1_b0_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2_AFFAFFb1_b0_BBBBBBBBLLy0_.fields[0], db2_AFFAFFb1_b0_BBBBBBBBLLy0_.fields[1] }), dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[1] })) : ((db2_AFFAFFb1_b0_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2_AFFAFFb1_b0_BBBBBBBBLLy0_.fields[0], db2_AFFAFFb1_b0_BBBBBBBBLLy0_.fields[1] }), dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[1] })) : ((db2_AFFAFFb1_b0_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2_AFFAFFb1_b0_BBBBBBBBLLy0_.fields[0], db2_AFFAFFb1_b0_BBBBBBBBLLy0_.fields[1] }), dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[1] })) : ((db2_AFFAFFb1_b0_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2_AFFAFFb1_b0_BBBBBBBBLLy0_.fields[0] }), dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db2_AFFAFFb1_b0_BBBBBBBBLLy0_, "b2_AFFAFFb1_b0_BBBBBBBBLLy0_")))))));
              } })).apply(Rt.BOX) : ((dAFFAFFb1_b0_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(3, new Object[]{ dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[0], dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[1] })) : ((dAFFAFFb1_b0_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(4, new Object[]{ dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[0], dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[1] })) : ((dAFFAFFb1_b0_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(lBLLy0_)).apply(new Rt.Data(5, new Object[]{ dAFFAFFb1_b0_BBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(dAFFAFFb1_b0_BBBBBBBBLLy0_, "AFFAFFb1_b0_BBBBBBBBLLy0_")))))))))).apply(dBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(dBBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX);
            } })).apply(Rt.BOX) : Rt.noBranch(db0_BBBBBBBBLLy0_, "b0_BBBBBBBBLLy0_")));
          } })).apply(Rt.BOX) : ((dBBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1_BBBBBBBBLLy0_){
            final Rt.Data db1_BBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
            return ((db1_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b1_BBBBBBBBLLy0_){
              final Rt.Data db0_b1_BBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db1_BBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0_b1_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(db1_BBBBBBBBLLy0_.fields[0]) : ((db0_b1_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0_.fields[0] }))))).apply(db1_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(db1_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b1_BBBBBBBBLLy0_, "b0_b1_BBBBBBBBLLy0_")));
            } })).apply(Rt.BOX) : ((db1_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db1_BBBBBBBBLLy0_.fields[0] })) : ((db1_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2_b1_BBBBBBBBLLy0_){
              final Rt.Data db2_b1_BBBBBBBBLLy0_ = ((Rt.Data)(db1_BBBBBBBBLLy0_.fields[0]));
              return ((db2_b1_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(db2_b1_BBBBBBBBLLy0_.fields[0]))).apply(db1_BBBBBBBBLLy0_.fields[1]) : ((db2_b1_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2_b1_BBBBBBBBLLy0_.fields[0] }), db1_BBBBBBBBLLy0_.fields[1] })) : ((db2_b1_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2_b1_BBBBBBBBLLy0_.fields[0], db2_b1_BBBBBBBBLLy0_.fields[1] }), db1_BBBBBBBBLLy0_.fields[1] })) : ((db2_b1_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2_b1_BBBBBBBBLLy0_.fields[0], db2_b1_BBBBBBBBLLy0_.fields[1] }), db1_BBBBBBBBLLy0_.fields[1] })) : ((db2_b1_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2_b1_BBBBBBBBLLy0_.fields[0], db2_b1_BBBBBBBBLLy0_.fields[1] }), db1_BBBBBBBBLLy0_.fields[1] })) : ((db2_b1_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2_b1_BBBBBBBBLLy0_.fields[0] }), db1_BBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db2_b1_BBBBBBBBLLy0_, "b2_b1_BBBBBBBBLLy0_")))))));
            } })).apply(Rt.BOX) : ((db1_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ db1_BBBBBBBBLLy0_.fields[0], db1_BBBBBBBBLLy0_.fields[1] })) : ((db1_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db1_BBBBBBBBLLy0_.fields[0], db1_BBBBBBBBLLy0_.fields[1] })) : ((db1_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db1_BBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(db1_BBBBBBBBLLy0_, "b1_BBBBBBBBLLy0_")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2_BBBBBBBBLLy0_){
            final Rt.Data db2_BBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
            return ((db2_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b2_BBBBBBBBLLy0_){
              final Rt.Data db0_b2_BBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db2_BBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0_b2_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(db2_BBBBBBBBLLy0_.fields[0]) : ((db0_b2_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] }))))).apply(db2_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(db2_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b2_BBBBBBBBLLy0_, "b0_b2_BBBBBBBBLLy0_")));
            } })).apply(Rt.BOX) : ((db2_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0_)).apply(dBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(1, new Object[]{ db2_BBBBBBBBLLy0_.fields[0] })) : ((db2_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2_b2_BBBBBBBBLLy0_){
              final Rt.Data db2_b2_BBBBBBBBLLy0_ = ((Rt.Data)(db2_BBBBBBBBLLy0_.fields[0]));
              return ((db2_b2_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0_)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(db2_b2_BBBBBBBBLLy0_.fields[0]))).apply(db2_BBBBBBBBLLy0_.fields[1]) : ((db2_b2_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0_)).apply(dBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2_b2_BBBBBBBBLLy0_.fields[0] }), db2_BBBBBBBBLLy0_.fields[1] })) : ((db2_b2_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0_)).apply(dBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2_b2_BBBBBBBBLLy0_.fields[0], db2_b2_BBBBBBBBLLy0_.fields[1] }), db2_BBBBBBBBLLy0_.fields[1] })) : ((db2_b2_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0_)).apply(dBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2_b2_BBBBBBBBLLy0_.fields[0], db2_b2_BBBBBBBBLLy0_.fields[1] }), db2_BBBBBBBBLLy0_.fields[1] })) : ((db2_b2_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0_)).apply(dBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2_b2_BBBBBBBBLLy0_.fields[0], db2_b2_BBBBBBBBLLy0_.fields[1] }), db2_BBBBBBBBLLy0_.fields[1] })) : ((db2_b2_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0_)).apply(dBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2_b2_BBBBBBBBLLy0_.fields[0] }), db2_BBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db2_b2_BBBBBBBBLLy0_, "b2_b2_BBBBBBBBLLy0_")))))));
            } })).apply(Rt.BOX) : ((db2_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0_)).apply(dBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(3, new Object[]{ db2_BBBBBBBBLLy0_.fields[0], db2_BBBBBBBBLLy0_.fields[1] })) : ((db2_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0_)).apply(dBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(4, new Object[]{ db2_BBBBBBBBLLy0_.fields[0], db2_BBBBBBBBLLy0_.fields[1] })) : ((db2_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0_)).apply(dBBBBBBBBLLy0_.fields[0]))).apply(dBBBBBBBBLLy0_.fields[1]))).apply(new Rt.Data(5, new Object[]{ db2_BBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(db2_BBBBBBBBLLy0_, "b2_BBBBBBBBLLy0_")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3_BBBBBBBBLLy0_){
            final Rt.Data db3_BBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
            return ((db3_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b3_BBBBBBBBLLy0_){
              final Rt.Data db0_b3_BBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db3_BBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0_b3_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(db3_BBBBBBBBLLy0_.fields[0]) : ((db0_b3_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] }))))).apply(db3_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(db3_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b3_BBBBBBBBLLy0_, "b0_b3_BBBBBBBBLLy0_")));
            } })).apply(Rt.BOX) : ((db3_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db3_BBBBBBBBLLy0_.fields[0] })) : ((db3_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2_b3_BBBBBBBBLLy0_){
              final Rt.Data db2_b3_BBBBBBBBLLy0_ = ((Rt.Data)(db3_BBBBBBBBLLy0_.fields[0]));
              return ((db2_b3_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(db2_b3_BBBBBBBBLLy0_.fields[0]))).apply(db3_BBBBBBBBLLy0_.fields[1]) : ((db2_b3_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2_b3_BBBBBBBBLLy0_.fields[0] }), db3_BBBBBBBBLLy0_.fields[1] })) : ((db2_b3_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2_b3_BBBBBBBBLLy0_.fields[0], db2_b3_BBBBBBBBLLy0_.fields[1] }), db3_BBBBBBBBLLy0_.fields[1] })) : ((db2_b3_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2_b3_BBBBBBBBLLy0_.fields[0], db2_b3_BBBBBBBBLLy0_.fields[1] }), db3_BBBBBBBBLLy0_.fields[1] })) : ((db2_b3_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2_b3_BBBBBBBBLLy0_.fields[0], db2_b3_BBBBBBBBLLy0_.fields[1] }), db3_BBBBBBBBLLy0_.fields[1] })) : ((db2_b3_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2_b3_BBBBBBBBLLy0_.fields[0] }), db3_BBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db2_b3_BBBBBBBBLLy0_, "b2_b3_BBBBBBBBLLy0_")))))));
            } })).apply(Rt.BOX) : ((db3_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(3, new Object[]{ db3_BBBBBBBBLLy0_.fields[0], db3_BBBBBBBBLLy0_.fields[1] })) : ((db3_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db3_BBBBBBBBLLy0_.fields[0], db3_BBBBBBBBLLy0_.fields[1] })) : ((db3_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db3_BBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(db3_BBBBBBBBLLy0_, "b3_BBBBBBBBLLy0_")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb4_BBBBBBBBLLy0_){
            final Rt.Data db4_BBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
            return ((db4_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b4_BBBBBBBBLLy0_){
              final Rt.Data db0_b4_BBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db4_BBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0_b4_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(db4_BBBBBBBBLLy0_.fields[0]) : ((db0_b4_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] }))))).apply(db4_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(db4_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b4_BBBBBBBBLLy0_, "b0_b4_BBBBBBBBLLy0_")));
            } })).apply(Rt.BOX) : ((db4_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db4_BBBBBBBBLLy0_.fields[0] })) : ((db4_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2_b4_BBBBBBBBLLy0_){
              final Rt.Data db2_b4_BBBBBBBBLLy0_ = ((Rt.Data)(db4_BBBBBBBBLLy0_.fields[0]));
              return ((db2_b4_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(db2_b4_BBBBBBBBLLy0_.fields[0]))).apply(db4_BBBBBBBBLLy0_.fields[1]) : ((db2_b4_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2_b4_BBBBBBBBLLy0_.fields[0] }), db4_BBBBBBBBLLy0_.fields[1] })) : ((db2_b4_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2_b4_BBBBBBBBLLy0_.fields[0], db2_b4_BBBBBBBBLLy0_.fields[1] }), db4_BBBBBBBBLLy0_.fields[1] })) : ((db2_b4_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2_b4_BBBBBBBBLLy0_.fields[0], db2_b4_BBBBBBBBLLy0_.fields[1] }), db4_BBBBBBBBLLy0_.fields[1] })) : ((db2_b4_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2_b4_BBBBBBBBLLy0_.fields[0], db2_b4_BBBBBBBBLLy0_.fields[1] }), db4_BBBBBBBBLLy0_.fields[1] })) : ((db2_b4_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2_b4_BBBBBBBBLLy0_.fields[0] }), db4_BBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db2_b4_BBBBBBBBLLy0_, "b2_b4_BBBBBBBBLLy0_")))))));
            } })).apply(Rt.BOX) : ((db4_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(3, new Object[]{ db4_BBBBBBBBLLy0_.fields[0], db4_BBBBBBBBLLy0_.fields[1] })) : ((db4_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db4_BBBBBBBBLLy0_.fields[0], db4_BBBBBBBBLLy0_.fields[1] })) : ((db4_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0_.fields[0], dBBBBBBBBLLy0_.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db4_BBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(db4_BBBBBBBBLLy0_, "b4_BBBBBBBBLLy0_")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb5_BBBBBBBBLLy0_){
            final Rt.Data db5_BBBBBBBBLLy0_ = ((Rt.Data)(pLy0_));
            return ((db5_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b5_BBBBBBBBLLy0_){
              final Rt.Data db0_b5_BBBBBBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db5_BBBBBBBBLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0_b5_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(db5_BBBBBBBBLLy0_.fields[0]) : ((db0_b5_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0_.fields[0] }))))).apply(db5_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX)))).apply(db5_BBBBBBBBLLy0_.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b5_BBBBBBBBLLy0_, "b0_b5_BBBBBBBBLLy0_")));
            } })).apply(Rt.BOX) : ((db5_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db5_BBBBBBBBLLy0_.fields[0] })) : ((db5_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2_b5_BBBBBBBBLLy0_){
              final Rt.Data db2_b5_BBBBBBBBLLy0_ = ((Rt.Data)(db5_BBBBBBBBLLy0_.fields[0]));
              return ((db2_b5_BBBBBBBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(db2_b5_BBBBBBBBLLy0_.fields[0]))).apply(db5_BBBBBBBBLLy0_.fields[1]) : ((db2_b5_BBBBBBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2_b5_BBBBBBBBLLy0_.fields[0] }), db5_BBBBBBBBLLy0_.fields[1] })) : ((db2_b5_BBBBBBBBLLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2_b5_BBBBBBBBLLy0_.fields[0], db2_b5_BBBBBBBBLLy0_.fields[1] }), db5_BBBBBBBBLLy0_.fields[1] })) : ((db2_b5_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2_b5_BBBBBBBBLLy0_.fields[0], db2_b5_BBBBBBBBLLy0_.fields[1] }), db5_BBBBBBBBLLy0_.fields[1] })) : ((db2_b5_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2_b5_BBBBBBBBLLy0_.fields[0], db2_b5_BBBBBBBBLLy0_.fields[1] }), db5_BBBBBBBBLLy0_.fields[1] })) : ((db2_b5_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2_b5_BBBBBBBBLLy0_.fields[0] }), db5_BBBBBBBBLLy0_.fields[1] })) : Rt.noBranch(db2_b5_BBBBBBBBLLy0_, "b2_b5_BBBBBBBBLLy0_")))))));
            } })).apply(Rt.BOX) : ((db5_BBBBBBBBLLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(3, new Object[]{ db5_BBBBBBBBLLy0_.fields[0], db5_BBBBBBBBLLy0_.fields[1] })) : ((db5_BBBBBBBBLLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db5_BBBBBBBBLLy0_.fields[0], db5_BBBBBBBBLLy0_.fields[1] })) : ((db5_BBBBBBBBLLy0_.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0_)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0_.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db5_BBBBBBBBLLy0_.fields[0] })) : Rt.noBranch(db5_BBBBBBBBLLy0_, "b5_BBBBBBBBLLy0_")))))));
          } })).apply(Rt.BOX) : Rt.noBranch(dBBBBBBBBLLy0_, "BBBBBBBBLLy0_")))))));
        } };
      }
    }
    final C z = new C();
    return new Rt.Fn(){ public Object apply(Object pw0_){
      return z.f0(pw0_);
    } };
  }
  public static Object c__Int__instAdd(){
    return new Rt.Data(0, new Object[]{ c__Int__add() });
  }
  public static Object c__Int__add(){
    return Rt.INT_ADD_LONG;
  }
  public static Object c___instDecidableEqNat(){
    return c__Nat__decEq();
  }
  public static Object c__Nat__decEq(){
    return Rt.PRIM_DEC_EQ_LONG;
  }
  public static Object c__Deriv_Expr__nest(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__nestAux())).apply(pL))).apply(p))).apply(pL))).apply(pLL);
        } };
      } };
    } };
  }
  public static Object c__Deriv_Expr__nestAux(){
    class C {
      public Object f0(Object py0_){
        return new Rt.Fn(){ public Object apply(Object pLy0_){
          return new Rt.Fn(){ public Object apply(Object pLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLLLy0_){
              final Object lLLLLy0_ = new Rt.Fn(){ public Object apply(Object pVLLLLy0_){
                return pVLLLLy0_;
              } };
              final Object lBLLLLy0_ = new Rt.Fn(){ public Object apply(Object pVBLLLLy0_){
                return new Rt.Fn(){ public Object apply(Object pLVBLLLLy0_){
                  return new Rt.Fn(){ public Object apply(Object pLLVBLLLLy0_){
                    return new Rt.Fn(){ public Object apply(Object pLLLVBLLLLy0_){
                      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                        return C.this.f0(pw0_);
                      } })).apply(py0_))).apply(pLy0_))).apply(pLVBLLLLy0_))).apply(((Rt.Fn)(((Rt.Fn)(pLy0_)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HSub__hSub())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHSub())).apply(Rt.BOX))).apply(c___instSubNat())))).apply(py0_))).apply(pVBLLLLy0_)))).apply(pLLLVBLLLLy0_));
                    } };
                  } };
                } };
              } };
              final Object lBBLLLLy0_ = pLLy0_;
              final Rt.Data dBBBLLLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Nat__beq())).apply(lBBLLLLy0_))).apply(Long.valueOf(0L))));
              return ((dBBBLLLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFb0_BBBLLLLy0_){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBLLLLy0_)).apply(((Rt.Fn)(((Rt.Fn)(c__Nat__add())).apply(pFb0_BBBLLLLy0_))).apply(Long.valueOf(1L))))).apply(pFb0_BBBLLLLy0_))).apply(Rt.BOX))).apply(pLLLy0_);
              } })).apply(((Rt.Fn)(((Rt.Fn)(c__Nat__sub())).apply(lBBLLLLy0_))).apply(Long.valueOf(1L))) : ((dBBBLLLLy0_.tag == 1) ? ((Rt.Fn)(lLLLLy0_)).apply(pLLLy0_) : Rt.noBranch(dBBBLLLLy0_, "BBBLLLLy0_")));
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
  public static Object c__Nat__beq(){
    return Rt.PRIM_EQB_LONG;
  }
  // inductive c___Nat: erased; values use Data(tag, fields)
  // inductive c___Bool: erased; values use Data(tag, fields)
  public static Object c___instSubNat(){
    return new Rt.Data(0, new Object[]{ c__Nat__sub() });
  }
  public static Object c__Nat__sub(){
    return Rt.NAT_SUB_LONG;
  }
  public static Object c___instHSub(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_LL){
          return new Rt.Fn(){ public Object apply(Object pLc0_LL){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Sub__sub())).apply(Rt.BOX))).apply(pL))).apply(pc0_LL))).apply(pLc0_LL);
          } };
        } } });
      } };
    } };
  }
  public static Object c__Sub__sub(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Sub: erased; values use Data(tag, fields)
  public static Object c__HSub__hSub(){
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
  // inductive c___HSub: erased; values use Data(tag, fields)
  public static Object c__Deriv_Expr__count(){
    class C {
      public Object f0(Object py0_){
        final Object lLy0_ = new Rt.Fn(){ public Object apply(Object pVLy0_){
          return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(1L)));
        } };
        final Object lBLy0_ = new Rt.Fn(){ public Object apply(Object pVBLy0_){
          return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(1L)));
        } };
        final Object lBBLy0_ = new Rt.Fn(){ public Object apply(Object pVBBLy0_){
          return new Rt.Fn(){ public Object apply(Object pLVBBLy0_){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HAdd__hAdd())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHAdd())).apply(Rt.BOX))).apply(c___instAddNat())))).apply(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
              return C.this.f0(pw0_);
            } })).apply(pVBBLy0_)))).apply(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
              return C.this.f0(pw0_);
            } })).apply(pLVBBLy0_));
          } };
        } };
        final Object lBBBLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBLy0_){
          return new Rt.Fn(){ public Object apply(Object pLVBBBLy0_){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HAdd__hAdd())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHAdd())).apply(Rt.BOX))).apply(c___instAddNat())))).apply(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
              return C.this.f0(pw0_);
            } })).apply(pVBBBLy0_)))).apply(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
              return C.this.f0(pw0_);
            } })).apply(pLVBBBLy0_));
          } };
        } };
        final Object lBBBBLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBLy0_){
          return new Rt.Fn(){ public Object apply(Object pLVBBBBLy0_){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HAdd__hAdd())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHAdd())).apply(Rt.BOX))).apply(c___instAddNat())))).apply(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
              return C.this.f0(pw0_);
            } })).apply(pVBBBBLy0_)))).apply(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
              return C.this.f0(pw0_);
            } })).apply(pLVBBBBLy0_));
          } };
        } };
        final Object lBBBBBLy0_ = new Rt.Fn(){ public Object apply(Object pVBBBBBLy0_){
          return ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
            return C.this.f0(pw0_);
          } })).apply(pVBBBBBLy0_);
        } };
        final Rt.Data dBBBBBBLy0_ = ((Rt.Data)(py0_));
        return ((dBBBBBBLy0_.tag == 0) ? ((Rt.Fn)(lLy0_)).apply(dBBBBBBLy0_.fields[0]) : ((dBBBBBBLy0_.tag == 1) ? ((Rt.Fn)(lBLy0_)).apply(dBBBBBBLy0_.fields[0]) : ((dBBBBBBLy0_.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBLy0_)).apply(dBBBBBBLy0_.fields[0]))).apply(dBBBBBBLy0_.fields[1]) : ((dBBBBBBLy0_.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBLy0_)).apply(dBBBBBBLy0_.fields[0]))).apply(dBBBBBBLy0_.fields[1]) : ((dBBBBBBLy0_.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLy0_)).apply(dBBBBBBLy0_.fields[0]))).apply(dBBBBBBLy0_.fields[1]) : ((dBBBBBBLy0_.tag == 5) ? ((Rt.Fn)(lBBBBBLy0_)).apply(dBBBBBBLy0_.fields[0]) : Rt.noBranch(dBBBBBBLy0_, "BBBBBBLy0_")))))));
      }
    }
    final C z = new C();
    return new Rt.Fn(){ public Object apply(Object pw0_){
      return z.f0(pw0_);
    } };
  }
  public static Object c___instAddNat(){
    return new Rt.Data(0, new Object[]{ c__Nat__add() });
  }
  public static Object c__Nat__add(){
    return Rt.PRIM_ADD_INT63;
  }
  public static Object c___instHAdd(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_LL){
          return new Rt.Fn(){ public Object apply(Object pLc0_LL){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Add__add())).apply(Rt.BOX))).apply(pL))).apply(pc0_LL))).apply(pLc0_LL);
          } };
        } } });
      } };
    } };
  }
  public static Object c__Add__add(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Add: erased; values use Data(tag, fields)
  public static Object c__HAdd__hAdd(){
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
  // inductive c___HAdd: erased; values use Data(tag, fields)
  public static Object c___instOfNatNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Data(0, new Object[]{ p });
    } };
  }
  public static Object c__Deriv_Expr__pow(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Object lLL = new Rt.Fn(){ public Object apply(Object pVLL){
          return new Rt.Fn(){ public Object apply(Object pLVLL){
            return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__pown())).apply(pVLL))).apply(pLVLL) });
          } };
        } };
        final Object lBLL = new Rt.Fn(){ public Object apply(Object pVBLL){
          return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))) });
        } };
        final Object lBBLL = new Rt.Fn(){ public Object apply(Object pVBBLL){
          return pVBBLL;
        } };
        final Object lBBBLL = new Rt.Fn(){ public Object apply(Object pVBBBLL){
          return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))) });
        } };
        final Object lBBBBLL = new Rt.Fn(){ public Object apply(Object pVBBBBLL){
          return new Rt.Fn(){ public Object apply(Object pLVBBBBLL){
            return new Rt.Data(4, new Object[]{ pVBBBBLL, pLVBBBBLL });
          } };
        } };
        final Rt.Data dBBBBBLL = ((Rt.Data)(p));
        return ((dBBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_BBBBBLL){
          final Rt.Data db0_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dBBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
          return ((db0_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_BBBBBLL){
            final Rt.Data db0_b0_BBBBBLL = ((Rt.Data)(pL));
            return ((db0_b0_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b0_BBBBBLL){
              final Rt.Data db0_b0_b0_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db0_b0_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0_b0_b0_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b0_b0_BBBBBLL){
                final Rt.Data db0_b0_b0_b0_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db0_b0_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0_b0_b0_b0_BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLL)).apply(dBBBBBLL.fields[0]))).apply(db0_b0_BBBBBLL.fields[0]) : ((db0_b0_b0_b0_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_b0_b0_BBBBBLL){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLL)).apply(dBBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))))).apply(db0_b0_BBBBBLL.fields[0]))).apply(Rt.BOX);
                } }))).apply(db0_b0_BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b0_b0_BBBBBLL, "b0_b0_b0_b0_BBBBBLL")));
              } })).apply(Rt.BOX) : ((db0_b0_b0_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLL)).apply(dBBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(db0_b0_BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(db0_b0_BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b0_BBBBBLL, "b0_b0_b0_BBBBBLL")));
            } })).apply(Rt.BOX) : ((db0_b0_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(0, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db0_b0_BBBBBLL.fields[0] })) : ((db0_b0_BBBBBLL.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(0, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(2, new Object[]{ db0_b0_BBBBBLL.fields[0], db0_b0_BBBBBLL.fields[1] })) : ((db0_b0_BBBBBLL.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(0, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(3, new Object[]{ db0_b0_BBBBBLL.fields[0], db0_b0_BBBBBLL.fields[1] })) : ((db0_b0_BBBBBLL.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(0, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db0_b0_BBBBBLL.fields[0], db0_b0_BBBBBLL.fields[1] })) : ((db0_b0_BBBBBLL.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(0, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db0_b0_BBBBBLL.fields[0] })) : Rt.noBranch(db0_b0_BBBBBLL, "b0_b0_BBBBBLL")))))));
          } })).apply(Rt.BOX) : ((db0_BBBBBLL.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1_b0_BBBBBLL){
            final Rt.Data dAFFAFFb1_b0_BBBBBLL = ((Rt.Data)(pL));
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((dAFFAFFb1_b0_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_AFFAFFb1_b0_BBBBBLL){
              final Rt.Data db0_AFFAFFb1_b0_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFAFFb1_b0_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0_AFFAFFb1_b0_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_AFFAFFb1_b0_BBBBBLL){
                final Rt.Data db0_b0_AFFAFFb1_b0_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFAFFb1_b0_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0_b0_AFFAFFb1_b0_BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLL)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(dAFFAFFb1_b0_BBBBBLL.fields[0]) : ((db0_b0_AFFAFFb1_b0_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_AFFAFFb1_b0_BBBBBLL){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLL)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))))).apply(dAFFAFFb1_b0_BBBBBLL.fields[0]))).apply(Rt.BOX);
                } }))).apply(dAFFAFFb1_b0_BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_AFFAFFb1_b0_BBBBBLL, "b0_b0_AFFAFFb1_b0_BBBBBLL")));
              } })).apply(Rt.BOX) : ((db0_AFFAFFb1_b0_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLL)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(dAFFAFFb1_b0_BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(dAFFAFFb1_b0_BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_AFFAFFb1_b0_BBBBBLL, "b0_AFFAFFb1_b0_BBBBBLL")));
            } })).apply(Rt.BOX) : ((dAFFAFFb1_b0_BBBBBLL.tag == 1) ? ((Rt.Fn)(lBBBLL)).apply(new Rt.Data(1, new Object[]{ dAFFAFFb1_b0_BBBBBLL.fields[0] })) : ((dAFFAFFb1_b0_BBBBBLL.tag == 2) ? ((Rt.Fn)(lBBBLL)).apply(new Rt.Data(2, new Object[]{ dAFFAFFb1_b0_BBBBBLL.fields[0], dAFFAFFb1_b0_BBBBBLL.fields[1] })) : ((dAFFAFFb1_b0_BBBBBLL.tag == 3) ? ((Rt.Fn)(lBBBLL)).apply(new Rt.Data(3, new Object[]{ dAFFAFFb1_b0_BBBBBLL.fields[0], dAFFAFFb1_b0_BBBBBLL.fields[1] })) : ((dAFFAFFb1_b0_BBBBBLL.tag == 4) ? ((Rt.Fn)(lBBBLL)).apply(new Rt.Data(4, new Object[]{ dAFFAFFb1_b0_BBBBBLL.fields[0], dAFFAFFb1_b0_BBBBBLL.fields[1] })) : ((dAFFAFFb1_b0_BBBBBLL.tag == 5) ? ((Rt.Fn)(lBBBLL)).apply(new Rt.Data(5, new Object[]{ dAFFAFFb1_b0_BBBBBLL.fields[0] })) : Rt.noBranch(dAFFAFFb1_b0_BBBBBLL, "AFFAFFb1_b0_BBBBBLL")))))))))).apply(dBBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(dBBBBBLL.fields[0]))).apply(Rt.BOX);
          } })).apply(Rt.BOX) : Rt.noBranch(db0_BBBBBLL, "b0_BBBBBLL")));
        } })).apply(Rt.BOX) : ((dBBBBBLL.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1_BBBBBLL){
          final Rt.Data db1_BBBBBLL = ((Rt.Data)(pL));
          return ((db1_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b1_BBBBBLL){
            final Rt.Data db0_b1_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db1_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0_b1_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b1_BBBBBLL){
              final Rt.Data db0_b0_b1_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db1_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
              return ((db0_b0_b1_BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(0, new Object[]{ db1_BBBBBLL.fields[0] })) : ((db0_b0_b1_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_b1_BBBBBLL){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] }))))).apply(db1_BBBBBLL.fields[0]))).apply(Rt.BOX);
              } }))).apply(db1_BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b1_BBBBBLL, "b0_b0_b1_BBBBBLL")));
            } })).apply(Rt.BOX) : ((db0_b1_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] }))))).apply(db1_BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(db1_BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b1_BBBBBLL, "b0_b1_BBBBBLL")));
          } })).apply(Rt.BOX) : ((db1_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db1_BBBBBLL.fields[0] })) : ((db1_BBBBBLL.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(2, new Object[]{ db1_BBBBBLL.fields[0], db1_BBBBBLL.fields[1] })) : ((db1_BBBBBLL.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(3, new Object[]{ db1_BBBBBLL.fields[0], db1_BBBBBLL.fields[1] })) : ((db1_BBBBBLL.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db1_BBBBBLL.fields[0], db1_BBBBBLL.fields[1] })) : ((db1_BBBBBLL.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db1_BBBBBLL.fields[0] })) : Rt.noBranch(db1_BBBBBLL, "b1_BBBBBLL")))))));
        } })).apply(Rt.BOX) : ((dBBBBBLL.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2_BBBBBLL){
          final Rt.Data db2_BBBBBLL = ((Rt.Data)(pL));
          return ((db2_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b2_BBBBBLL){
            final Rt.Data db0_b2_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db2_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0_b2_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b2_BBBBBLL){
              final Rt.Data db0_b0_b2_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db2_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
              return ((db0_b0_b2_BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(0, new Object[]{ db2_BBBBBLL.fields[0] })) : ((db0_b0_b2_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_b2_BBBBBLL){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] }))))).apply(db2_BBBBBLL.fields[0]))).apply(Rt.BOX);
              } }))).apply(db2_BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b2_BBBBBLL, "b0_b0_b2_BBBBBLL")));
            } })).apply(Rt.BOX) : ((db0_b2_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] }))))).apply(db2_BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(db2_BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b2_BBBBBLL, "b0_b2_BBBBBLL")));
          } })).apply(Rt.BOX) : ((db2_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db2_BBBBBLL.fields[0] })) : ((db2_BBBBBLL.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(2, new Object[]{ db2_BBBBBLL.fields[0], db2_BBBBBLL.fields[1] })) : ((db2_BBBBBLL.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(3, new Object[]{ db2_BBBBBLL.fields[0], db2_BBBBBLL.fields[1] })) : ((db2_BBBBBLL.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db2_BBBBBLL.fields[0], db2_BBBBBLL.fields[1] })) : ((db2_BBBBBLL.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db2_BBBBBLL.fields[0] })) : Rt.noBranch(db2_BBBBBLL, "b2_BBBBBLL")))))));
        } })).apply(Rt.BOX) : ((dBBBBBLL.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3_BBBBBLL){
          final Rt.Data db3_BBBBBLL = ((Rt.Data)(pL));
          return ((db3_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b3_BBBBBLL){
            final Rt.Data db0_b3_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db3_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0_b3_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b3_BBBBBLL){
              final Rt.Data db0_b0_b3_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db3_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
              return ((db0_b0_b3_BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(0, new Object[]{ db3_BBBBBLL.fields[0] })) : ((db0_b0_b3_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_b3_BBBBBLL){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] }))))).apply(db3_BBBBBLL.fields[0]))).apply(Rt.BOX);
              } }))).apply(db3_BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b3_BBBBBLL, "b0_b0_b3_BBBBBLL")));
            } })).apply(Rt.BOX) : ((db0_b3_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] }))))).apply(db3_BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(db3_BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b3_BBBBBLL, "b0_b3_BBBBBLL")));
          } })).apply(Rt.BOX) : ((db3_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db3_BBBBBLL.fields[0] })) : ((db3_BBBBBLL.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(2, new Object[]{ db3_BBBBBLL.fields[0], db3_BBBBBLL.fields[1] })) : ((db3_BBBBBLL.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(3, new Object[]{ db3_BBBBBLL.fields[0], db3_BBBBBLL.fields[1] })) : ((db3_BBBBBLL.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db3_BBBBBLL.fields[0], db3_BBBBBLL.fields[1] })) : ((db3_BBBBBLL.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db3_BBBBBLL.fields[0] })) : Rt.noBranch(db3_BBBBBLL, "b3_BBBBBLL")))))));
        } })).apply(Rt.BOX) : ((dBBBBBLL.tag == 4) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb4_BBBBBLL){
          final Rt.Data db4_BBBBBLL = ((Rt.Data)(pL));
          return ((db4_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b4_BBBBBLL){
            final Rt.Data db0_b4_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db4_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0_b4_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b4_BBBBBLL){
              final Rt.Data db0_b0_b4_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db4_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
              return ((db0_b0_b4_BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(0, new Object[]{ db4_BBBBBLL.fields[0] })) : ((db0_b0_b4_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_b4_BBBBBLL){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] }))))).apply(db4_BBBBBLL.fields[0]))).apply(Rt.BOX);
              } }))).apply(db4_BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b4_BBBBBLL, "b0_b0_b4_BBBBBLL")));
            } })).apply(Rt.BOX) : ((db0_b4_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] }))))).apply(db4_BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(db4_BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b4_BBBBBLL, "b0_b4_BBBBBLL")));
          } })).apply(Rt.BOX) : ((db4_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db4_BBBBBLL.fields[0] })) : ((db4_BBBBBLL.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(2, new Object[]{ db4_BBBBBLL.fields[0], db4_BBBBBLL.fields[1] })) : ((db4_BBBBBLL.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(3, new Object[]{ db4_BBBBBLL.fields[0], db4_BBBBBLL.fields[1] })) : ((db4_BBBBBLL.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db4_BBBBBLL.fields[0], db4_BBBBBLL.fields[1] })) : ((db4_BBBBBLL.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db4_BBBBBLL.fields[0] })) : Rt.noBranch(db4_BBBBBLL, "b4_BBBBBLL")))))));
        } })).apply(Rt.BOX) : ((dBBBBBLL.tag == 5) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb5_BBBBBLL){
          final Rt.Data db5_BBBBBLL = ((Rt.Data)(pL));
          return ((db5_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b5_BBBBBLL){
            final Rt.Data db0_b5_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db5_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0_b5_BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_b0_b5_BBBBBLL){
              final Rt.Data db0_b0_b5_BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db5_BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
              return ((db0_b0_b5_BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(0, new Object[]{ db5_BBBBBLL.fields[0] })) : ((db0_b0_b5_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_b0_b5_BBBBBLL){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] }))))).apply(db5_BBBBBLL.fields[0]))).apply(Rt.BOX);
              } }))).apply(db5_BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_b0_b5_BBBBBLL, "b0_b0_b5_BBBBBLL")));
            } })).apply(Rt.BOX) : ((db0_b5_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] }))))).apply(db5_BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(db5_BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0_b5_BBBBBLL, "b0_b5_BBBBBLL")));
          } })).apply(Rt.BOX) : ((db5_BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db5_BBBBBLL.fields[0] })) : ((db5_BBBBBLL.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(2, new Object[]{ db5_BBBBBLL.fields[0], db5_BBBBBLL.fields[1] })) : ((db5_BBBBBLL.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(3, new Object[]{ db5_BBBBBLL.fields[0], db5_BBBBBLL.fields[1] })) : ((db5_BBBBBLL.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db5_BBBBBLL.fields[0], db5_BBBBBLL.fields[1] })) : ((db5_BBBBBLL.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db5_BBBBBLL.fields[0] })) : Rt.noBranch(db5_BBBBBLL, "b5_BBBBBLL")))))));
        } })).apply(Rt.BOX) : Rt.noBranch(dBBBBBLL, "BBBBBLL")))))));
      } };
    } };
  }
  public static Object c__Deriv_Expr__pown(){
    class C {
      public Object f0(Object py0_){
        return new Rt.Fn(){ public Object apply(Object pLy0_){
          final Object lLLy0_ = new Rt.Fn(){ public Object apply(Object pVLLy0_){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)));
          } };
          final Object lBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBLLy0_){
            return pVBLLy0_;
          } };
          final Object lBBLLy0_ = new Rt.Fn(){ public Object apply(Object pVBBLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLVBBLLy0_){
              final Object lLLVBBLLy0_ = ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                return C.this.f0(pw0_);
              } })).apply(pVBBLLy0_))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HDiv__hDiv())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHDiv())).apply(Rt.BOX))).apply(c__Int__instDiv())))).apply(pLVBBLLy0_))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(2L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(2L)))));
              final Rt.Data dABLLVBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HMod__hMod())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHMod())).apply(Rt.BOX))).apply(c__Int__instMod())))).apply(pLVBBLLy0_))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(2L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(2L))))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HMul__hMul())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHMul())).apply(Rt.BOX))).apply(c__Int__instMul())))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HMul__hMul())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHMul())).apply(Rt.BOX))).apply(c__Int__instMul())))).apply(lLLVBBLLy0_))).apply(lLLVBBLLy0_)))).apply(((dABLLVBBLLy0_.tag == 0) ? pVBBLLy0_ : ((dABLLVBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))) : Rt.noBranch(dABLLVBBLLy0_, "ABLLVBBLLy0_"))));
            } };
          } };
          final Rt.Data dBBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(pLy0_))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
          return ((dBBBLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_BBBLLy0_){
            final Rt.Data db0_BBBLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(pLy0_))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
            return ((db0_BBBLLy0_.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBLLy0_)).apply(py0_))).apply(pLy0_) : ((db0_BBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1_b0_BBBLLy0_){
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBLLy0_)).apply(py0_)))).apply(pLy0_))).apply(Rt.BOX);
            } }))).apply(pLy0_))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0_BBBLLy0_, "b0_BBBLLy0_")));
          } })).apply(Rt.BOX) : ((dBBBLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lLLy0_)).apply(py0_)))).apply(pLy0_))).apply(Rt.BOX)))).apply(pLy0_))).apply(Rt.BOX) : Rt.noBranch(dBBBLLy0_, "BBBLLy0_")));
        } };
      }
    }
    final C z = new C();
    return new Rt.Fn(){ public Object apply(Object pw0_){
      return z.f0(pw0_);
    } };
  }
  public static Object c__Eq__ndrec(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              return new Rt.Fn(){ public Object apply(Object pLLLLL){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__rec())).apply(Rt.BOX))).apply(pL))).apply(Rt.BOX))).apply(pLLL))).apply(pLLLL))).apply(Rt.BOX);
              } };
            } };
          } };
        } };
      } };
    } };
  }
  public static Object c__Eq__rec(){
    return Rt.EQ_REC;
  }
  // inductive c___Decidable: erased; values use Data(tag, fields)
  public static Object c__Int__instMod(){
    return new Rt.Data(0, new Object[]{ c__Int__emod() });
  }
  public static Object c__Int__emod(){
    return Rt.INT_EMOD_LONG;
  }
  public static Object c___instHMod(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_LL){
          return new Rt.Fn(){ public Object apply(Object pLc0_LL){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Mod__mod())).apply(Rt.BOX))).apply(pL))).apply(pc0_LL))).apply(pLc0_LL);
          } };
        } } });
      } };
    } };
  }
  public static Object c__Mod__mod(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Mod: erased; values use Data(tag, fields)
  public static Object c__HMod__hMod(){
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
  // inductive c___HMod: erased; values use Data(tag, fields)
  public static Object c__Int__instDecidableEq(){
    return c__Int__decEq();
  }
  public static Object c__Int__decEq(){
    return Rt.INT_DEC_EQ_LONG;
  }
  public static Object c__Int__instMul(){
    return new Rt.Data(0, new Object[]{ c__Int__mul() });
  }
  public static Object c__Int__mul(){
    return Rt.INT_MUL_LONG;
  }
  public static Object c___instHMul(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_LL){
          return new Rt.Fn(){ public Object apply(Object pLc0_LL){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Mul__mul())).apply(Rt.BOX))).apply(pL))).apply(pc0_LL))).apply(pLc0_LL);
          } };
        } } });
      } };
    } };
  }
  public static Object c__Mul__mul(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Mul: erased; values use Data(tag, fields)
  public static Object c__HMul__hMul(){
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
  // inductive c___HMul: erased; values use Data(tag, fields)
  public static Object c__Int__instDiv(){
    return new Rt.Data(0, new Object[]{ c__Int__ediv() });
  }
  public static Object c__Int__ediv(){
    return Rt.INT_EDIV_LONG;
  }
  public static Object c___instHDiv(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_LL){
          return new Rt.Fn(){ public Object apply(Object pLc0_LL){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Div__div())).apply(Rt.BOX))).apply(pL))).apply(pc0_LL))).apply(pLc0_LL);
          } };
        } } });
      } };
    } };
  }
  public static Object c__Div__div(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Div: erased; values use Data(tag, fields)
  public static Object c__HDiv__hDiv(){
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
  // inductive c___HDiv: erased; values use Data(tag, fields)
  public static Object c___instOfNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Data(0, new Object[]{ ((Rt.Fn)(c__Int__ofNat())).apply(p) });
    } };
  }
  // inductive c___Int: erased; values use Data(tag, fields)
  public static Object c__Int__negSucc(){
    return Rt.INT_NEG_SUCC_LONG;
  }
  public static Object c__Int__ofNat(){
    return Rt.INT_OF_NAT;
  }
  public static Object c__OfNat__ofNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          final Rt.Data dLLL = ((Rt.Data)(pLL));
          return ((dLLL.tag == 0) ? dLLL.fields[0] : Rt.noBranch(dLLL, "LLL"));
        } };
      } };
    } };
  }
  // inductive c___OfNat: erased; values use Data(tag, fields)
  // inductive c___Deriv_u46Expr: erased; values use Data(tag, fields)
  public static Object body(){
    return c___suite_deriv();
  }
}
