public final class Prog {
  public static Object c_nadd(){
    class C {
      public Object f0(Object py0_){
        return new Rt.Fn(){ public Object apply(Object pLy0_){
          final Rt.Data dLLy0_ = ((Rt.Data)(py0_));
          return ((dLLy0_.tag == 0) ? pLy0_ : ((dLLy0_.tag == 1) ? new Rt.Data(1, new Object[]{ ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_){
            return C.this.f0(pw0_);
          } })).apply(dLLy0_.fields[0]))).apply(pLy0_) }) : Rt.noBranch(dLLy0_, "LLy0_")));
        } };
      }
    }
    final C z = new C();
    return new Rt.Fn(){ public Object apply(Object pw0_){
      return z.f0(pw0_);
    } };
  }
  // inductive c_nNat: erased; values use Data(tag, fields)
  public static Object body(){
    return ((Rt.Fn)(((Rt.Fn)(c_nadd())).apply(new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) })))).apply(new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }) }));
  }
}
