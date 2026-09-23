public final class Prog {
  public static Object c___suite_list_sum_foldr(){
    return ((Rt.Fn)(c___list_sum_foldr())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(10L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(10L))));
  }
  public static Object c___list_sum_foldr(){
    return new Rt.Fn(){ public Object apply(Object p){
      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__List__foldrTR())).apply(Rt.BOX))).apply(Rt.BOX))).apply(c__Nat__add()))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__List__replicateTR())).apply(Rt.BOX))).apply(p))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(1L)))));
    } };
  }
  public static Object c__List__replicateTR(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__List_replicateTR__loop())).apply(Rt.BOX))).apply(pLL))).apply(pL))).apply(new Rt.Data(0, new Object[]{  }));
        } };
      } };
    } };
  }
  public static Object c__List_replicateTR__loop(){
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
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                    return C.this.f0(pw0_);
                  } })).apply(Rt.BOX))).apply(pLy0_))).apply(pVBLLLLy0_))).apply(new Rt.Data(1, new Object[]{ pLy0_, pLVBLLLLy0_ }));
                } };
              } };
              final Object lBBLLLLy0_ = pLLy0_;
              final Rt.Data dBBBLLLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Nat__beq())).apply(lBBLLLLy0_))).apply(Long.valueOf(0L))));
              return ((dBBBLLLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFb0_BBBLLLLy0_){
                return ((Rt.Fn)(((Rt.Fn)(lBLLLLy0_)).apply(pFb0_BBBLLLLy0_))).apply(pLLLy0_);
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
  // inductive c___List: erased; values use Data(tag, fields)
  public static Object c__Nat__add(){
    return Rt.PRIM_ADD_INT63;
  }
  public static Object c__List__foldrTR(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Array__foldr())).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLL))).apply(pLLL))).apply(((Rt.Fn)(((Rt.Fn)(c__List__toArray())).apply(Rt.BOX))).apply(pLLLL)))).apply(((Rt.Fn)(((Rt.Fn)(c__Array__size())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__List__toArray())).apply(Rt.BOX))).apply(pLLLL))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(0L))));
            } };
          } };
        } };
      } };
    } };
  }
  public static Object c___instOfNatNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Data(0, new Object[]{ p });
    } };
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
  public static Object c__List__toArray(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return ((Rt.Fn)(((Rt.Fn)(c__Array__mk())).apply(Rt.BOX))).apply(pL);
      } };
    } };
  }
  // inductive c___Array: erased; values use Data(tag, fields)
  public static Object c__Array__mk(){
    return Rt.ARRAY_MK;
  }
  public static Object c__Array__foldr(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              return new Rt.Fn(){ public Object apply(Object pLLLLL){
                return new Rt.Fn(){ public Object apply(Object pLLLLLL){
                  return ((Rt.Fn)(((Rt.Fn)(c__Id__run())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Array__foldrM())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(c__Id__instMonad()))).apply(new Rt.Fn(){ public Object apply(Object pAFFFFALLLLLLL){
                    return new Rt.Fn(){ public Object apply(Object pLAFFFFALLLLLLL){
                      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Pure__pure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Applicative__toPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Monad__toApplicative())).apply(Rt.BOX))).apply(c__Id__instMonad()))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(pLL)).apply(pAFFFFALLLLLLL))).apply(pLAFFFFALLLLLLL));
                    } };
                  } }))).apply(pLLL))).apply(pLLLL))).apply(pLLLLL))).apply(pLLLLLL));
                } };
              } };
            } };
          } };
        } };
      } };
    } };
  }
  public static Object c__Id__instMonad(){
    return new Rt.Data(0, new Object[]{ new Rt.Data(0, new Object[]{ new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_c0_c0_){
      return new Rt.Fn(){ public Object apply(Object pLc0_c0_c0_){
        return new Rt.Fn(){ public Object apply(Object pLLc0_c0_c0_){
          return new Rt.Fn(){ public Object apply(Object pLLLc0_c0_c0_){
            return ((Rt.Fn)(pLLc0_c0_c0_)).apply(pLLLc0_c0_c0_);
          } };
        } };
      } };
    } }, new Rt.Fn(){ public Object apply(Object pc1_c0_c0_){
      return new Rt.Fn(){ public Object apply(Object pLc1_c0_c0_){
        return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Function__comp())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFAFLLc1_c0_c0_){
          return new Rt.Fn(){ public Object apply(Object pLFFAFLLc1_c0_c0_){
            return new Rt.Fn(){ public Object apply(Object pLLFFAFLLc1_c0_c0_){
              return new Rt.Fn(){ public Object apply(Object pLLLFFAFLLc1_c0_c0_){
                return ((Rt.Fn)(pLLFFAFLLc1_c0_c0_)).apply(pLLLFFAFLLc1_c0_c0_);
              } };
            } };
          } };
        } })).apply(Rt.BOX))).apply(Rt.BOX)))).apply(((Rt.Fn)(((Rt.Fn)(c__Function__const())).apply(Rt.BOX))).apply(Rt.BOX));
      } };
    } } }), new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_c1_c0_){
      return new Rt.Fn(){ public Object apply(Object pLc0_c1_c0_){
        return pLc0_c1_c0_;
      } };
    } } }), new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_c2_c0_){
      return new Rt.Fn(){ public Object apply(Object pLc0_c2_c0_){
        return new Rt.Fn(){ public Object apply(Object pLLc0_c2_c0_){
          return new Rt.Fn(){ public Object apply(Object pLLLc0_c2_c0_){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFFFLLLLc0_c2_c0_){
              return new Rt.Fn(){ public Object apply(Object pLFFFFLLLLc0_c2_c0_){
                return new Rt.Fn(){ public Object apply(Object pLLFFFFLLLLc0_c2_c0_){
                  return new Rt.Fn(){ public Object apply(Object pLLLFFFFLLLLc0_c2_c0_){
                    return ((Rt.Fn)(pLLLFFFFLLLLc0_c2_c0_)).apply(pLLFFFFLLLLc0_c2_c0_);
                  } };
                } };
              } };
            } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLc0_c2_c0_))).apply(new Rt.Fn(){ public Object apply(Object pALLLLc0_c2_c0_){
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFFFLALLLLc0_c2_c0_){
                return new Rt.Fn(){ public Object apply(Object pLFFFFLALLLLc0_c2_c0_){
                  return new Rt.Fn(){ public Object apply(Object pLLFFFFLALLLLc0_c2_c0_){
                    return new Rt.Fn(){ public Object apply(Object pLLLFFFFLALLLLc0_c2_c0_){
                      return ((Rt.Fn)(pLLFFFFLALLLLc0_c2_c0_)).apply(pLLLFFFFLALLLLc0_c2_c0_);
                    } };
                  } };
                } };
              } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(pALLLLc0_c2_c0_))).apply(((Rt.Fn)(pLLLc0_c2_c0_)).apply(c__Unit__unit()));
            } });
          } };
        } };
      } };
    } } }), new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_c3_c0_){
      return new Rt.Fn(){ public Object apply(Object pLc0_c3_c0_){
        return new Rt.Fn(){ public Object apply(Object pLLc0_c3_c0_){
          return new Rt.Fn(){ public Object apply(Object pLLLc0_c3_c0_){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFFFLLLLc0_c3_c0_){
              return new Rt.Fn(){ public Object apply(Object pLFFFFLLLLc0_c3_c0_){
                return new Rt.Fn(){ public Object apply(Object pLLFFFFLLLLc0_c3_c0_){
                  return new Rt.Fn(){ public Object apply(Object pLLLFFFFLLLLc0_c3_c0_){
                    return ((Rt.Fn)(pLLLFFFFLLLLc0_c3_c0_)).apply(pLLFFFFLLLLc0_c3_c0_);
                  } };
                } };
              } };
            } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLc0_c3_c0_))).apply(new Rt.Fn(){ public Object apply(Object pALLLLc0_c3_c0_){
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFFFLALLLLc0_c3_c0_){
                return new Rt.Fn(){ public Object apply(Object pLFFFFLALLLLc0_c3_c0_){
                  return new Rt.Fn(){ public Object apply(Object pLLFFFFLALLLLc0_c3_c0_){
                    return new Rt.Fn(){ public Object apply(Object pLLLFFFFLALLLLc0_c3_c0_){
                      return ((Rt.Fn)(pLLLFFFFLALLLLc0_c3_c0_)).apply(pLLFFFFLALLLLc0_c3_c0_);
                    } };
                  } };
                } };
              } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(pLLLc0_c3_c0_)).apply(c__Unit__unit())))).apply(new Rt.Fn(){ public Object apply(Object pALALLLLc0_c3_c0_){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFLALALLLLc0_c3_c0_){
                  return new Rt.Fn(){ public Object apply(Object pLFFLALALLLLc0_c3_c0_){
                    return pLFFLALALLLLc0_c3_c0_;
                  } };
                } })).apply(Rt.BOX))).apply(pALLLLc0_c3_c0_);
              } });
            } });
          } };
        } };
      } };
    } } }), new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_c4_c0_){
      return new Rt.Fn(){ public Object apply(Object pLc0_c4_c0_){
        return new Rt.Fn(){ public Object apply(Object pLLc0_c4_c0_){
          return new Rt.Fn(){ public Object apply(Object pLLLc0_c4_c0_){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFFFLLLLc0_c4_c0_){
              return new Rt.Fn(){ public Object apply(Object pLFFFFLLLLc0_c4_c0_){
                return new Rt.Fn(){ public Object apply(Object pLLFFFFLLLLc0_c4_c0_){
                  return new Rt.Fn(){ public Object apply(Object pLLLFFFFLLLLc0_c4_c0_){
                    return ((Rt.Fn)(pLLLFFFFLLLLc0_c4_c0_)).apply(pLLFFFFLLLLc0_c4_c0_);
                  } };
                } };
              } };
            } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLc0_c4_c0_))).apply(new Rt.Fn(){ public Object apply(Object pALLLLc0_c4_c0_){
              return ((Rt.Fn)(pLLLc0_c4_c0_)).apply(c__Unit__unit());
            } });
          } };
        } };
      } };
    } } }) }), new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_c1_){
      return new Rt.Fn(){ public Object apply(Object pLc0_c1_){
        return new Rt.Fn(){ public Object apply(Object pLLc0_c1_){
          return new Rt.Fn(){ public Object apply(Object pLLLc0_c1_){
            return ((Rt.Fn)(pLLLc0_c1_)).apply(pLLc0_c1_);
          } };
        } };
      } };
    } } }) });
  }
  // inductive c___SeqRight: erased; values use Data(tag, fields)
  // inductive c___SeqLeft: erased; values use Data(tag, fields)
  // inductive c___Seq: erased; values use Data(tag, fields)
  public static Object c__Function__const(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return pLL;
          } };
        } };
      } };
    } };
  }
  public static Object c__Function__comp(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              return new Rt.Fn(){ public Object apply(Object pLLLLL){
                return ((Rt.Fn)(pLLL)).apply(((Rt.Fn)(pLLLL)).apply(pLLLLL));
              } };
            } };
          } };
        } };
      } };
    } };
  }
  // inductive c___Functor: erased; values use Data(tag, fields)
  public static Object c__Array__foldrM(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              return new Rt.Fn(){ public Object apply(Object pLLLLL){
                return new Rt.Fn(){ public Object apply(Object pLLLLLL){
                  return new Rt.Fn(){ public Object apply(Object pLLLLLLL){
                    return new Rt.Fn(){ public Object apply(Object pLLLLLLLL){
                      final Rt.Data dLLLLLLLLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Nat__decLe())).apply(pLLLLLLL))).apply(((Rt.Fn)(((Rt.Fn)(c__Array__size())).apply(Rt.BOX))).apply(pLLLLLL))));
                      return ((dLLLLLLLLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_LLLLLLLLL){
                        final Rt.Data db0_LLLLLLLLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Nat__decLt())).apply(pLLLLLLLL))).apply(((Rt.Fn)(((Rt.Fn)(c__Array__size())).apply(Rt.BOX))).apply(pLLLLLL))));
                        return ((db0_LLLLLLLLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Pure__pure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Applicative__toPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Monad__toApplicative())).apply(Rt.BOX))).apply(pLLL))))).apply(Rt.BOX))).apply(pLLLLL) : ((db0_LLLLLLLLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Array_foldrM__fold())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLL))).apply(pLLLL))).apply(pLLLLLL))).apply(pLLLLLLLL))).apply(((Rt.Fn)(((Rt.Fn)(c__Array__size())).apply(Rt.BOX))).apply(pLLLLLL)))).apply(Rt.BOX))).apply(pLLLLL) : Rt.noBranch(db0_LLLLLLLLL, "b0_LLLLLLLLL")));
                      } })).apply(Rt.BOX) : ((dLLLLLLLLL.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1_LLLLLLLLL){
                        final Rt.Data db1_LLLLLLLLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Nat__decLt())).apply(pLLLLLLLL))).apply(pLLLLLLL)));
                        return ((db1_LLLLLLLLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Pure__pure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Applicative__toPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Monad__toApplicative())).apply(Rt.BOX))).apply(pLLL))))).apply(Rt.BOX))).apply(pLLLLL) : ((db1_LLLLLLLLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Array_foldrM__fold())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLL))).apply(pLLLL))).apply(pLLLLLL))).apply(pLLLLLLLL))).apply(pLLLLLLL))).apply(Rt.BOX))).apply(pLLLLL) : Rt.noBranch(db1_LLLLLLLLL, "b1_LLLLLLLLL")));
                      } })).apply(Rt.BOX) : Rt.noBranch(dLLLLLLLLL, "LLLLLLLLL")));
                    } };
                  } };
                } };
              } };
            } };
          } };
        } };
      } };
    } };
  }
  public static Object c__Array_foldrM__fold(){
    class C {
      public Object f0(Object py0_){
        return new Rt.Fn(){ public Object apply(Object pLy0_){
          return new Rt.Fn(){ public Object apply(Object pLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLLLy0_){
              return new Rt.Fn(){ public Object apply(Object pLLLLy0_){
                return new Rt.Fn(){ public Object apply(Object pLLLLLy0_){
                  return new Rt.Fn(){ public Object apply(Object pLLLLLLy0_){
                    return new Rt.Fn(){ public Object apply(Object pLLLLLLLy0_){
                      return new Rt.Fn(){ public Object apply(Object pLLLLLLLLy0_){
                        return new Rt.Fn(){ public Object apply(Object pLLLLLLLLLy0_){
                          final Rt.Data dLLLLLLLLLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c___instDecidableEqBool())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__BEq__beq())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instBEqOfDecidableEq())).apply(Rt.BOX))).apply(c___instDecidableEqNat())))).apply(pLLLLLLLy0_))).apply(pLLLLLLy0_)))).apply(new Rt.Data(1, new Object[]{  }))));
                          return ((dLLLLLLLLLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_LLLLLLLLLLy0_){
                            final Object lb0_LLLLLLLLLLy0_ = new Rt.Fn(){ public Object apply(Object pVb0_LLLLLLLLLLy0_){
                              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Pure__pure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Applicative__toPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Monad__toApplicative())).apply(Rt.BOX))).apply(pLLLy0_))))).apply(Rt.BOX))).apply(pLLLLLLLLLy0_);
                            } };
                            final Object lBb0_LLLLLLLLLLy0_ = new Rt.Fn(){ public Object apply(Object pVBb0_LLLLLLLLLLy0_){
                              return new Rt.Fn(){ public Object apply(Object pLVBb0_LLLLLLLLLLy0_){
                                final Object lLLVBb0_LLLLLLLLLLy0_ = Rt.BOX;
                                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Bind__bind())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Monad__toBind())).apply(Rt.BOX))).apply(pLLLy0_)))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(pLLLLy0_)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__GetElem__getElem())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(c__Array__instGetElemNatLtSize())).apply(Rt.BOX)))).apply(pLLLLLy0_))).apply(pVBb0_LLLLLLLLLLy0_))).apply(Rt.BOX)))).apply(pLLLLLLLLLy0_)))).apply(new Rt.Fn(){ public Object apply(Object pABLLVBb0_LLLLLLLLLLy0_){
                                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                                    return C.this.f0(pw0_);
                                  } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLLy0_))).apply(pLLLLy0_))).apply(pLLLLLy0_))).apply(pLLLLLLy0_))).apply(pVBb0_LLLLLLLLLLy0_))).apply(Rt.BOX))).apply(pABLLVBb0_LLLLLLLLLLy0_);
                                } });
                              } };
                            } };
                            final Object lFBBb0_LLLLLLLLLLy0_ = pLLLLLLLy0_;
                            final Rt.Data dBFBBb0_LLLLLLLLLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Nat__beq())).apply(lFBBb0_LLLLLLLLLLy0_))).apply(Long.valueOf(0L))));
                            return ((Rt.Fn)(((dBFBBb0_LLLLLLLLLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFb0_BFBBb0_LLLLLLLLLLy0_){
                              return new Rt.Fn(){ public Object apply(Object pLFb0_BFBBb0_LLLLLLLLLLy0_){
                                return ((Rt.Fn)(((Rt.Fn)(lBb0_LLLLLLLLLLy0_)).apply(pFb0_BFBBb0_LLLLLLLLLLy0_))).apply(Rt.BOX);
                              } };
                            } })).apply(((Rt.Fn)(((Rt.Fn)(c__Nat__sub())).apply(lFBBb0_LLLLLLLLLLy0_))).apply(Long.valueOf(1L))) : ((dBFBBb0_LLLLLLLLLLy0_.tag == 1) ? new Rt.Fn(){ public Object apply(Object pb1_BFBBb0_LLLLLLLLLLy0_){
                              return ((Rt.Fn)(lb0_LLLLLLLLLLy0_)).apply(Rt.BOX);
                            } } : Rt.noBranch(dBFBBb0_LLLLLLLLLLy0_, "BFBBb0_LLLLLLLLLLy0_"))))).apply(Rt.BOX);
                          } })).apply(Rt.BOX) : ((dLLLLLLLLLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Pure__pure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Applicative__toPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Monad__toApplicative())).apply(Rt.BOX))).apply(pLLLy0_))))).apply(Rt.BOX))).apply(pLLLLLLLLLy0_) : Rt.noBranch(dLLLLLLLLLLy0_, "LLLLLLLLLLy0_")));
                        } };
                      } };
                    } };
                  } };
                } };
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
  public static Object c__Nat__beq(){
    return Rt.PRIM_EQB_LONG;
  }
  public static Object c__Nat__sub(){
    return Rt.NAT_SUB_LONG;
  }
  public static Object c__Array__instGetElemNatLtSize(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_L){
        return new Rt.Fn(){ public Object apply(Object pLc0_L){
          return new Rt.Fn(){ public Object apply(Object pLLc0_L){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Array__getInternal())).apply(Rt.BOX))).apply(pc0_L))).apply(pLc0_L))).apply(Rt.BOX);
          } };
        } };
      } } });
    } };
  }
  public static Object c__Array__getInternal(){
    return Rt.ARRAY_GET_INTERNAL;
  }
  public static Object c__GetElem__getElem(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              final Rt.Data dLLLLL = ((Rt.Data)(pLLLL));
              return ((dLLLLL.tag == 0) ? dLLLLL.fields[0] : Rt.noBranch(dLLLLL, "LLLLL"));
            } };
          } };
        } };
      } };
    } };
  }
  // inductive c___GetElem: erased; values use Data(tag, fields)
  public static Object c__Monad__toBind(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[1] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  public static Object c__Bind__bind(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Bind: erased; values use Data(tag, fields)
  public static Object c___instDecidableEqNat(){
    return c__Nat__decEq();
  }
  public static Object c__Nat__decEq(){
    return Rt.PRIM_DEC_EQ_LONG;
  }
  public static Object c___instBEqOfDecidableEq(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_LL){
          return new Rt.Fn(){ public Object apply(Object pLc0_LL){
            return ((Rt.Fn)(((Rt.Fn)(c__Decidable__decide())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(pL)).apply(pc0_LL))).apply(pLc0_LL));
          } };
        } } });
      } };
    } };
  }
  public static Object c__Decidable__decide(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? new Rt.Data(0, new Object[]{  }) : ((dLL.tag == 1) ? new Rt.Data(1, new Object[]{  }) : Rt.noBranch(dLL, "LL")));
      } };
    } };
  }
  public static Object c__BEq__beq(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___BEq: erased; values use Data(tag, fields)
  public static Object c___instDecidableEqBool(){
    return c__Bool__decEq();
  }
  public static Object c__Bool__decEq(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Object lLL = new Rt.Fn(){ public Object apply(Object pVLL){
          return new Rt.Data(1, new Object[]{ Rt.BOX });
        } };
        final Object lBLL = new Rt.Fn(){ public Object apply(Object pVBLL){
          return new Rt.Data(0, new Object[]{ Rt.BOX });
        } };
        final Object lBBLL = new Rt.Fn(){ public Object apply(Object pVBBLL){
          return new Rt.Data(0, new Object[]{ Rt.BOX });
        } };
        final Object lBBBLL = new Rt.Fn(){ public Object apply(Object pVBBBLL){
          return new Rt.Data(1, new Object[]{ Rt.BOX });
        } };
        final Rt.Data dBBBBLL = ((Rt.Data)(p));
        return ((dBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_BBBBLL){
          final Rt.Data db0_BBBBLL = ((Rt.Data)(pL));
          return ((db0_BBBBLL.tag == 0) ? ((Rt.Fn)(lLL)).apply(c__Unit__unit()) : ((db0_BBBBLL.tag == 1) ? ((Rt.Fn)(lBLL)).apply(c__Unit__unit()) : Rt.noBranch(db0_BBBBLL, "b0_BBBBLL")));
        } })).apply(Rt.BOX) : ((dBBBBLL.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1_BBBBLL){
          final Rt.Data db1_BBBBLL = ((Rt.Data)(pL));
          return ((db1_BBBBLL.tag == 0) ? ((Rt.Fn)(lBBLL)).apply(c__Unit__unit()) : ((db1_BBBBLL.tag == 1) ? ((Rt.Fn)(lBBBLL)).apply(c__Unit__unit()) : Rt.noBranch(db1_BBBBLL, "b1_BBBBLL")));
        } })).apply(Rt.BOX) : Rt.noBranch(dBBBBLL, "BBBBLL")));
      } };
    } };
  }
  public static Object c__Unit__unit(){
    return new Rt.Data(0, new Object[]{  });
  }
  // inductive c___PUnit: erased; values use Data(tag, fields)
  // inductive c___Bool: erased; values use Data(tag, fields)
  public static Object c__Monad__toApplicative(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Monad: erased; values use Data(tag, fields)
  public static Object c__Applicative__toPure(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[1] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Applicative: erased; values use Data(tag, fields)
  public static Object c__Pure__pure(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Pure: erased; values use Data(tag, fields)
  public static Object c__Nat__decLt(){
    return Rt.PRIM_DEC_LT_LONG;
  }
  // inductive c___Decidable: erased; values use Data(tag, fields)
  public static Object c__Array__size(){
    return Rt.ARRAY_SIZE_LONG;
  }
  public static Object c__Nat__decLe(){
    return Rt.PRIM_DEC_LE_LONG;
  }
  public static Object c__Id__run(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return pL;
      } };
    } };
  }
  public static Object body(){
    return c___suite_list_sum_foldr();
  }
}
