public final class Prog {
  public static Object c_dNat_dTests_dPeregrine_nthing(){
    return ((Rt.Fn)(((Rt.Fn)(c_dNat_dInit_dCorelib_nadd())).apply(new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) })))).apply(new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }));
  }
  public static Object c_dNat_dInit_dCorelib_nadd(){
    return new Rt.Fn(){ public Object apply(Object p){
      class CFL {
        public Object f0(Object py0_FL){
          return new Rt.Fn(){ public Object apply(Object pLy0_FL){
            final Rt.Data dLLy0_FL = ((Rt.Data)(py0_FL));
            return ((dLLy0_FL.tag == 0) ? pLy0_FL : ((dLLy0_FL.tag == 1) ? new Rt.Data(1, new Object[]{ ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_FL){
              return CFL.this.f0(pw0_FL);
            } })).apply(dLLy0_FL.fields[0]))).apply(pLy0_FL) }) : Rt.noBranch(dLLy0_FL, "LLy0_FL")));
          } };
        }
      }
      final CFL zFL = new CFL();
      return ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_FL){
        return zFL.f0(pw0_FL);
      } })).apply(p);
    } };
  }
  // inductive c_dDatatypes_dInit_dCorelib_nnat: erased; values use Data(tag, fields)
  public static Object body(){
    return c_dNat_dTests_dPeregrine_nthing();
  }
}
