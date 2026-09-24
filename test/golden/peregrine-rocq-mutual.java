public final class Prog {
  public static Object c_dMutual_dTests_dPeregrine_ntest(){
    return ((Rt.Fn)(c_dMutual_dTests_dPeregrine_noddNat())).apply(new Rt.Data(0, new Object[]{ new Rt.Data(0, new Object[]{  }) }));
  }
  public static Object c_dMutual_dTests_dPeregrine_noddNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      class CFL {
        public Object f0(Object py0_FL){
          final Rt.Data dLy0_FL = ((Rt.Data)(py0_FL));
          return ((dLy0_FL.tag == 0) ? new Rt.Data(1, new Object[]{ ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw1_FL){
            return CFL.this.f1(pw1_FL);
          } })).apply(dLy0_FL.fields[0]) }) : Rt.noBranch(dLy0_FL, "Ly0_FL"));
        }
        public Object f1(Object py1_FL){
          final Rt.Data dLy1_FL = ((Rt.Data)(py1_FL));
          return ((dLy1_FL.tag == 0) ? new Rt.Data(0, new Object[]{  }) : ((dLy1_FL.tag == 1) ? new Rt.Data(1, new Object[]{ ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_FL){
            return CFL.this.f0(pw0_FL);
          } })).apply(dLy1_FL.fields[0]) }) : Rt.noBranch(dLy1_FL, "Ly1_FL")));
        }
      }
      final CFL zFL = new CFL();
      return ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_FL){
        return zFL.f0(pw0_FL);
      } })).apply(p);
    } };
  }
  // inductive c_dDatatypes_dInit_dCorelib_nnat: erased; values use Data(tag, fields)
  // inductive c_dMutual_dTests_dPeregrine_nEven: erased; values use Data(tag, fields)
  public static Object body(){
    return c_dMutual_dTests_dPeregrine_ntest();
  }
}
