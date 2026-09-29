public final class Prog {
  public static Object c_nsort(){
    class C {
      public Object f0(Object py0_){
        return new Rt.Fn(){ public Object apply(Object pLy0_){
          final Rt.Data dLLy0_ = ((Rt.Data)(pLy0_));
          return ((dLLy0_.tag == 0) ? new Rt.Data(0, new Object[]{  }) : ((dLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_ninsert())).apply(py0_))).apply(dLLy0_.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
            return C.this.f0(pw0_);
          } })).apply(py0_))).apply(dLLy0_.fields[1])) : Rt.noBranch(dLLy0_, "LLy0_")));
        } };
      }
    }
    final C z = new C();
    return new Rt.Fn(){ public Object apply(Object pw0_){
      return z.f0(pw0_);
    } };
  }
  public static Object c_ninsert(){
    class C {
      public Object f0(Object py0_){
        return new Rt.Fn(){ public Object apply(Object pLy0_){
          return new Rt.Fn(){ public Object apply(Object pLLy0_){
            final Rt.Data dLLLy0_ = ((Rt.Data)(pLLy0_));
            return ((dLLLy0_.tag == 0) ? new Rt.Data(1, new Object[]{ pLy0_, new Rt.Data(0, new Object[]{  }) }) : ((dLLLy0_.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1_LLLy0_){
              final Rt.Data db1_LLLy0_ = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(py0_)).apply(dLLLy0_.fields[0]))).apply(pLy0_)));
              return ((db1_LLLy0_.tag == 0) ? new Rt.Data(1, new Object[]{ dLLLy0_.fields[0], ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                return C.this.f0(pw0_);
              } })).apply(py0_))).apply(pLy0_))).apply(dLLLy0_.fields[1]) }) : ((db1_LLLy0_.tag == 1) ? new Rt.Data(1, new Object[]{ pLy0_, pLLy0_ }) : Rt.noBranch(db1_LLLy0_, "b1_LLLy0_")));
            } })).apply(Rt.BOX) : Rt.noBranch(dLLLy0_, "LLLy0_")));
          } };
        } };
      }
    }
    final C z = new C();
    return new Rt.Fn(){ public Object apply(Object pw0_){
      return z.f0(pw0_);
    } };
  }
  public static Object c_nle(){
    class C {
      public Object f0(Object py0_){
        return new Rt.Fn(){ public Object apply(Object pLy0_){
          final Rt.Data dLLy0_ = ((Rt.Data)(py0_));
          return ((dLLy0_.tag == 0) ? new Rt.Data(0, new Object[]{  }) : ((dLLy0_.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1_LLy0_){
            final Rt.Data db1_LLy0_ = ((Rt.Data)(pLy0_));
            return ((db1_LLy0_.tag == 0) ? new Rt.Data(1, new Object[]{  }) : ((db1_LLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
              return C.this.f0(pw0_);
            } })).apply(dLLy0_.fields[0]))).apply(db1_LLy0_.fields[0]) : Rt.noBranch(db1_LLy0_, "b1_LLy0_")));
          } })).apply(Rt.BOX) : Rt.noBranch(dLLy0_, "LLy0_")));
        } };
      }
    }
    final C z = new C();
    return new Rt.Fn(){ public Object apply(Object pw0_){
      return z.f0(pw0_);
    } };
  }
  // inductive c_nList: erased; values use Data(tag, fields)
  // inductive c_nBool: erased; values use Data(tag, fields)
  // inductive c_nNat: erased; values use Data(tag, fields)
  public static Object body(){
    return ((Rt.Fn)(((Rt.Fn)(c_nsort())).apply(c_nle()))).apply(new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }) }), new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }), new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }) }) }), new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }), new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }), new Rt.Data(0, new Object[]{  }) }) }) }) }) }));
  }
}
