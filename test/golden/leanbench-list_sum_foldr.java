public final class Prog {
  public static Object c_nsuite__list__sum__foldr(){
    return ((Rt.Fn)(c_nlist__sum__foldr())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oOfNat_nofNat())).apply(Rt.BOX))).apply(Long.valueOf(10L)))).apply(((Rt.Fn)(c_ninstOfNatNat())).apply(Long.valueOf(10L))));
  }
  public static Object c_nlist__sum__foldr(){
    return new Rt.Fn(){ public Object apply(Object p){
      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oList_nfoldrTR())).apply(Rt.BOX))).apply(Rt.BOX))).apply(c_oNat_nadd()))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oOfNat_nofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c_ninstOfNatNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oList_nreplicateTR())).apply(Rt.BOX))).apply(p))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oOfNat_nofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c_ninstOfNatNat())).apply(Long.valueOf(1L)))));
    } };
  }
  public static Object c_oList_nreplicateTR(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oList_oreplicateTR_nloop())).apply(Rt.BOX))).apply(pLL))).apply(pL))).apply(new Rt.Data(0, new Object[]{  }));
        } };
      } };
    } };
  }
  public static Object c_oList_oreplicateTR_nloop(){
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
              final Rt.Data dBBBLLLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c_oNat_nbeq())).apply(lBBLLLLy0_))).apply(Long.valueOf(0L))));
              return ((dBBBLLLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFb0_BBBLLLLy0_){
                return ((Rt.Fn)(((Rt.Fn)(lBLLLLy0_)).apply(pFb0_BBBLLLLy0_))).apply(pLLLy0_);
              } })).apply(((Rt.Fn)(((Rt.Fn)(c_oNat_nsub())).apply(lBBLLLLy0_))).apply(Long.valueOf(1L))) : ((dBBBLLLLy0_.tag == 1) ? ((Rt.Fn)(lLLLLy0_)).apply(pLLLy0_) : Rt.noBranch(dBBBLLLLy0_, "BBBLLLLy0_")));
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
  public static Object c_oNat_nadd(){
    return Rt.PRIM_ADD_INT63;
  }
  public static Object c_oList_nfoldrTR(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oArray_nfoldr())).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLL))).apply(pLLL))).apply(((Rt.Fn)(((Rt.Fn)(c_oList_ntoArray())).apply(Rt.BOX))).apply(pLLLL)))).apply(((Rt.Fn)(((Rt.Fn)(c_oArray_nsize())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_oList_ntoArray())).apply(Rt.BOX))).apply(pLLLL))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oOfNat_nofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c_ninstOfNatNat())).apply(Long.valueOf(0L))));
            } };
          } };
        } };
      } };
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
  public static Object c_oList_ntoArray(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return ((Rt.Fn)(((Rt.Fn)(c_oArray_nmk())).apply(Rt.BOX))).apply(pL);
      } };
    } };
  }
  // inductive c_nArray: erased; values use Data(tag, fields)
  public static Object c_oArray_nmk(){
    return Rt.ARRAY_MK;
  }
  public static Object c_oArray_nfoldr(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              return new Rt.Fn(){ public Object apply(Object pLLLLL){
                return new Rt.Fn(){ public Object apply(Object pLLLLLL){
                  return ((Rt.Fn)(((Rt.Fn)(c_oId_nrun())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oArray_nfoldrM())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(c_oId_ninstMonad()))).apply(new Rt.Fn(){ public Object apply(Object pAFFFFALLLLLLL){
                    return new Rt.Fn(){ public Object apply(Object pLAFFFFALLLLLLL){
                      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oPure_npure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_oApplicative_ntoPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_oMonad_ntoApplicative())).apply(Rt.BOX))).apply(c_oId_ninstMonad()))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(pLL)).apply(pAFFFFALLLLLLL))).apply(pLAFFFFALLLLLLL));
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
  public static Object c_oId_ninstMonad(){
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
        return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oFunction_ncomp())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFAFLLc1_c0_c0_){
          return new Rt.Fn(){ public Object apply(Object pLFFAFLLc1_c0_c0_){
            return new Rt.Fn(){ public Object apply(Object pLLFFAFLLc1_c0_c0_){
              return new Rt.Fn(){ public Object apply(Object pLLLFFAFLLc1_c0_c0_){
                return ((Rt.Fn)(pLLFFAFLLc1_c0_c0_)).apply(pLLLFFAFLLc1_c0_c0_);
              } };
            } };
          } };
        } })).apply(Rt.BOX))).apply(Rt.BOX)))).apply(((Rt.Fn)(((Rt.Fn)(c_oFunction_nconst())).apply(Rt.BOX))).apply(Rt.BOX));
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
              } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(pALLLLc0_c2_c0_))).apply(((Rt.Fn)(pLLLc0_c2_c0_)).apply(c_oUnit_nunit()));
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
              } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(pLLLc0_c3_c0_)).apply(c_oUnit_nunit())))).apply(new Rt.Fn(){ public Object apply(Object pALALLLLc0_c3_c0_){
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
              return ((Rt.Fn)(pLLLc0_c4_c0_)).apply(c_oUnit_nunit());
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
  // inductive c_nSeqRight: erased; values use Data(tag, fields)
  // inductive c_nSeqLeft: erased; values use Data(tag, fields)
  // inductive c_nSeq: erased; values use Data(tag, fields)
  public static Object c_oFunction_nconst(){
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
  public static Object c_oFunction_ncomp(){
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
  // inductive c_nFunctor: erased; values use Data(tag, fields)
  public static Object c_oArray_nfoldrM(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              return new Rt.Fn(){ public Object apply(Object pLLLLL){
                return new Rt.Fn(){ public Object apply(Object pLLLLLL){
                  return new Rt.Fn(){ public Object apply(Object pLLLLLLL){
                    return new Rt.Fn(){ public Object apply(Object pLLLLLLLL){
                      final Rt.Data dLLLLLLLLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c_oNat_ndecLe())).apply(pLLLLLLL))).apply(((Rt.Fn)(((Rt.Fn)(c_oArray_nsize())).apply(Rt.BOX))).apply(pLLLLLL))));
                      return ((dLLLLLLLLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_LLLLLLLLL){
                        final Rt.Data db0_LLLLLLLLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c_oNat_ndecLt())).apply(pLLLLLLLL))).apply(((Rt.Fn)(((Rt.Fn)(c_oArray_nsize())).apply(Rt.BOX))).apply(pLLLLLL))));
                        return ((db0_LLLLLLLLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oPure_npure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_oApplicative_ntoPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_oMonad_ntoApplicative())).apply(Rt.BOX))).apply(pLLL))))).apply(Rt.BOX))).apply(pLLLLL) : ((db0_LLLLLLLLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oArray_ofoldrM_nfold())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLL))).apply(pLLLL))).apply(pLLLLLL))).apply(pLLLLLLLL))).apply(((Rt.Fn)(((Rt.Fn)(c_oArray_nsize())).apply(Rt.BOX))).apply(pLLLLLL)))).apply(Rt.BOX))).apply(pLLLLL) : Rt.noBranch(db0_LLLLLLLLL, "b0_LLLLLLLLL")));
                      } })).apply(Rt.BOX) : ((dLLLLLLLLL.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1_LLLLLLLLL){
                        final Rt.Data db1_LLLLLLLLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c_oNat_ndecLt())).apply(pLLLLLLLL))).apply(pLLLLLLL)));
                        return ((db1_LLLLLLLLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oPure_npure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_oApplicative_ntoPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_oMonad_ntoApplicative())).apply(Rt.BOX))).apply(pLLL))))).apply(Rt.BOX))).apply(pLLLLL) : ((db1_LLLLLLLLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oArray_ofoldrM_nfold())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLL))).apply(pLLLL))).apply(pLLLLLL))).apply(pLLLLLLLL))).apply(pLLLLLLL))).apply(Rt.BOX))).apply(pLLLLL) : Rt.noBranch(db1_LLLLLLLLL, "b1_LLLLLLLLL")));
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
  public static Object c_oArray_ofoldrM_nfold(){
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
                          final Rt.Data dLLLLLLLLLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c_ninstDecidableEqBool())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oBEq_nbeq())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_ninstBEqOfDecidableEq())).apply(Rt.BOX))).apply(c_ninstDecidableEqNat())))).apply(pLLLLLLLy0_))).apply(pLLLLLLy0_)))).apply(new Rt.Data(1, new Object[]{  }))));
                          return ((dLLLLLLLLLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0_LLLLLLLLLLy0_){
                            final Object lb0_LLLLLLLLLLy0_ = new Rt.Fn(){ public Object apply(Object pVb0_LLLLLLLLLLy0_){
                              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oPure_npure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_oApplicative_ntoPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_oMonad_ntoApplicative())).apply(Rt.BOX))).apply(pLLLy0_))))).apply(Rt.BOX))).apply(pLLLLLLLLLy0_);
                            } };
                            final Object lBb0_LLLLLLLLLLy0_ = new Rt.Fn(){ public Object apply(Object pVBb0_LLLLLLLLLLy0_){
                              return new Rt.Fn(){ public Object apply(Object pLVBb0_LLLLLLLLLLy0_){
                                final Object lLLVBb0_LLLLLLLLLLy0_ = Rt.BOX;
                                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oBind_nbind())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_oMonad_ntoBind())).apply(Rt.BOX))).apply(pLLLy0_)))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(pLLLLy0_)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oGetElem_ngetElem())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(c_oArray_ninstGetElemNatLtSize())).apply(Rt.BOX)))).apply(pLLLLLy0_))).apply(pVBb0_LLLLLLLLLLy0_))).apply(Rt.BOX)))).apply(pLLLLLLLLLy0_)))).apply(new Rt.Fn(){ public Object apply(Object pABLLVBb0_LLLLLLLLLLy0_){
                                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                                    return C.this.f0(pw0_);
                                  } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLLy0_))).apply(pLLLLy0_))).apply(pLLLLLy0_))).apply(pLLLLLLy0_))).apply(pVBb0_LLLLLLLLLLy0_))).apply(Rt.BOX))).apply(pABLLVBb0_LLLLLLLLLLy0_);
                                } });
                              } };
                            } };
                            final Object lFBBb0_LLLLLLLLLLy0_ = pLLLLLLLy0_;
                            final Rt.Data dBFBBb0_LLLLLLLLLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c_oNat_nbeq())).apply(lFBBb0_LLLLLLLLLLy0_))).apply(Long.valueOf(0L))));
                            return ((Rt.Fn)(((dBFBBb0_LLLLLLLLLLy0_.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFb0_BFBBb0_LLLLLLLLLLy0_){
                              return new Rt.Fn(){ public Object apply(Object pLFb0_BFBBb0_LLLLLLLLLLy0_){
                                return ((Rt.Fn)(((Rt.Fn)(lBb0_LLLLLLLLLLy0_)).apply(pFb0_BFBBb0_LLLLLLLLLLy0_))).apply(Rt.BOX);
                              } };
                            } })).apply(((Rt.Fn)(((Rt.Fn)(c_oNat_nsub())).apply(lFBBb0_LLLLLLLLLLy0_))).apply(Long.valueOf(1L))) : ((dBFBBb0_LLLLLLLLLLy0_.tag == 1) ? new Rt.Fn(){ public Object apply(Object pb1_BFBBb0_LLLLLLLLLLy0_){
                              return ((Rt.Fn)(lb0_LLLLLLLLLLy0_)).apply(Rt.BOX);
                            } } : Rt.noBranch(dBFBBb0_LLLLLLLLLLy0_, "BFBBb0_LLLLLLLLLLy0_"))))).apply(Rt.BOX);
                          } })).apply(Rt.BOX) : ((dLLLLLLLLLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oPure_npure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_oApplicative_ntoPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c_oMonad_ntoApplicative())).apply(Rt.BOX))).apply(pLLLy0_))))).apply(Rt.BOX))).apply(pLLLLLLLLLy0_) : Rt.noBranch(dLLLLLLLLLLy0_, "LLLLLLLLLLy0_")));
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
  public static Object c_oNat_nbeq(){
    return Rt.PRIM_EQB_LONG;
  }
  public static Object c_oNat_nsub(){
    return Rt.NAT_SUB_LONG;
  }
  public static Object c_oArray_ninstGetElemNatLtSize(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_L){
        return new Rt.Fn(){ public Object apply(Object pLc0_L){
          return new Rt.Fn(){ public Object apply(Object pLLc0_L){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_oArray_ngetInternal())).apply(Rt.BOX))).apply(pc0_L))).apply(pLc0_L))).apply(Rt.BOX);
          } };
        } };
      } } });
    } };
  }
  public static Object c_oArray_ngetInternal(){
    return Rt.ARRAY_GET_INTERNAL;
  }
  public static Object c_oGetElem_ngetElem(){
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
  // inductive c_nGetElem: erased; values use Data(tag, fields)
  public static Object c_oMonad_ntoBind(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[1] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  public static Object c_oBind_nbind(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c_nBind: erased; values use Data(tag, fields)
  public static Object c_ninstDecidableEqNat(){
    return c_oNat_ndecEq();
  }
  public static Object c_oNat_ndecEq(){
    return Rt.PRIM_DEC_EQ_LONG;
  }
  public static Object c_ninstBEqOfDecidableEq(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0_LL){
          return new Rt.Fn(){ public Object apply(Object pLc0_LL){
            return ((Rt.Fn)(((Rt.Fn)(c_oDecidable_ndecide())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(pL)).apply(pc0_LL))).apply(pLc0_LL));
          } };
        } } });
      } };
    } };
  }
  public static Object c_oDecidable_ndecide(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? new Rt.Data(0, new Object[]{  }) : ((dLL.tag == 1) ? new Rt.Data(1, new Object[]{  }) : Rt.noBranch(dLL, "LL")));
      } };
    } };
  }
  public static Object c_oBEq_nbeq(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c_nBEq: erased; values use Data(tag, fields)
  public static Object c_ninstDecidableEqBool(){
    return c_oBool_ndecEq();
  }
  public static Object c_oBool_ndecEq(){
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
          return ((db0_BBBBLL.tag == 0) ? ((Rt.Fn)(lLL)).apply(c_oUnit_nunit()) : ((db0_BBBBLL.tag == 1) ? ((Rt.Fn)(lBLL)).apply(c_oUnit_nunit()) : Rt.noBranch(db0_BBBBLL, "b0_BBBBLL")));
        } })).apply(Rt.BOX) : ((dBBBBLL.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1_BBBBLL){
          final Rt.Data db1_BBBBLL = ((Rt.Data)(pL));
          return ((db1_BBBBLL.tag == 0) ? ((Rt.Fn)(lBBLL)).apply(c_oUnit_nunit()) : ((db1_BBBBLL.tag == 1) ? ((Rt.Fn)(lBBBLL)).apply(c_oUnit_nunit()) : Rt.noBranch(db1_BBBBLL, "b1_BBBBLL")));
        } })).apply(Rt.BOX) : Rt.noBranch(dBBBBLL, "BBBBLL")));
      } };
    } };
  }
  public static Object c_oUnit_nunit(){
    return new Rt.Data(0, new Object[]{  });
  }
  // inductive c_nPUnit: erased; values use Data(tag, fields)
  // inductive c_nBool: erased; values use Data(tag, fields)
  public static Object c_oMonad_ntoApplicative(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c_nMonad: erased; values use Data(tag, fields)
  public static Object c_oApplicative_ntoPure(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[1] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c_nApplicative: erased; values use Data(tag, fields)
  public static Object c_oPure_npure(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c_nPure: erased; values use Data(tag, fields)
  public static Object c_oNat_ndecLt(){
    return Rt.PRIM_DEC_LT_LONG;
  }
  // inductive c_nDecidable: erased; values use Data(tag, fields)
  public static Object c_oArray_nsize(){
    return Rt.ARRAY_SIZE_LONG;
  }
  public static Object c_oNat_ndecLe(){
    return Rt.PRIM_DEC_LE_LONG;
  }
  public static Object c_oId_nrun(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return pL;
      } };
    } };
  }
  public static Object body(){
    return c_nsuite__list__sum__foldr();
  }
}
