public final class Prog {
  public static Object c_nys(){
    return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_nmap())).apply(Rt.BOX))).apply(Rt.BOX))).apply(c_ndouble()))).apply(c_nxs());
  }
  public static Object c_nxs(){
    return new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }), new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }) }), new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }) }) }) }), new Rt.Data(0, new Object[]{  }) }) }) });
  }
  public static Object c_ndouble(){
    class C {
      public Object f0(Object py0_){
        final Object lLy0_ = new Rt.Fn(){ public Object apply(Object pVLy0_){
          return new Rt.Data(0, new Object[]{  });
        } };
        final Object lBLy0_ = new Rt.Fn(){ public Object apply(Object pVBLy0_){
          return new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
            return C.this.f0(pw0_);
          } })).apply(pVBLy0_) }) });
        } };
        final Rt.Data dBBLy0_ = ((Rt.Data)(py0_));
        return ((dBBLy0_.tag == 0) ? ((Rt.Fn)(lLy0_)).apply(c_oUnit_nunit()) : ((dBBLy0_.tag == 1) ? ((Rt.Fn)(lBLy0_)).apply(dBBLy0_.fields[0]) : Rt.noBranch(dBBLy0_, "BBLy0_")));
      }
    }
    final C z = new C();
    return new Rt.Fn(){ public Object apply(Object pw0_){
      return z.f0(pw0_);
    } };
  }
  // inductive c_nNat__: erased; values use Data(tag, fields)
  public static Object c_nmap(){
    class C {
      public Object f0(Object py0_){
        return new Rt.Fn(){ public Object apply(Object pLy0_){
          return new Rt.Fn(){ public Object apply(Object pLLy0_){
            return new Rt.Fn(){ public Object apply(Object pLLLy0_){
              final Object lLLLLy0_ = new Rt.Fn(){ public Object apply(Object pVLLLLy0_){
                return new Rt.Data(0, new Object[]{  });
              } };
              final Object lBLLLLy0_ = new Rt.Fn(){ public Object apply(Object pVBLLLLy0_){
                return new Rt.Fn(){ public Object apply(Object pLVBLLLLy0_){
                  return new Rt.Data(1, new Object[]{ ((Rt.Fn)(pLLy0_)).apply(pVBLLLLy0_), ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
                    return C.this.f0(pw0_);
                  } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLy0_))).apply(pLVBLLLLy0_) });
                } };
              } };
              final Rt.Data dBBLLLLy0_ = ((Rt.Data)(pLLLy0_));
              return ((dBBLLLLy0_.tag == 0) ? ((Rt.Fn)(lLLLLy0_)).apply(c_oUnit_nunit()) : ((dBBLLLLy0_.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBLLLLy0_)).apply(dBBLLLLy0_.fields[0]))).apply(dBBLLLLy0_.fields[1]) : Rt.noBranch(dBBLLLLy0_, "BBLLLLy0_")));
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
  public static Object c_oUnit_nunit(){
    return new Rt.Data(0, new Object[]{  });
  }
  // inductive c_nPUnit: erased; values use Data(tag, fields)
  // inductive c_nList__: erased; values use Data(tag, fields)
  public static Object body(){
    return c_nys();
  }
}
