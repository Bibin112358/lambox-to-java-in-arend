public final class Prog {
  public static Object c_dMap_dTests_dPeregrine_nys(){
    return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_dListDef_dLists_dCorelib_nmap())).apply(Rt.BOX))).apply(Rt.BOX))).apply(c_dMap_dTests_dPeregrine_ndouble()))).apply(c_dMap_dTests_dPeregrine_nxs());
  }
  public static Object c_dMap_dTests_dPeregrine_nxs(){
    return new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }), new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }) }), new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }) }) }) }), new Rt.Data(0, new Object[]{  }) }) }) });
  }
  public static Object c_dMap_dTests_dPeregrine_ndouble(){
    return new Rt.Fn(){ public Object apply(Object p){
      class CFL {
        public Object f0(Object py0_FL){
          final Rt.Data dLy0_FL = ((Rt.Data)(py0_FL));
          return ((dLy0_FL.tag == 0) ? new Rt.Data(0, new Object[]{  }) : ((dLy0_FL.tag == 1) ? new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_FL){
            return CFL.this.f0(pw0_FL);
          } })).apply(dLy0_FL.fields[0]) }) }) : Rt.noBranch(dLy0_FL, "Ly0_FL")));
        }
      }
      final CFL zFL = new CFL();
      return ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_FL){
        return zFL.f0(pw0_FL);
      } })).apply(p);
    } };
  }
  // inductive c_dDatatypes_dInit_dCorelib_nnat: erased; values use Data(tag, fields)
  public static Object c_dListDef_dLists_dCorelib_nmap(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            class CFLLLL {
              public Object f0(Object py0_FLLLL){
                final Rt.Data dLy0_FLLLL = ((Rt.Data)(py0_FLLLL));
                return ((dLy0_FLLLL.tag == 0) ? new Rt.Data(0, new Object[]{  }) : ((dLy0_FLLLL.tag == 1) ? new Rt.Data(1, new Object[]{ ((Rt.Fn)(pLL)).apply(dLy0_FLLLL.fields[0]), ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_FLLLL){
                  return CFLLLL.this.f0(pw0_FLLLL);
                } })).apply(dLy0_FLLLL.fields[1]) }) : Rt.noBranch(dLy0_FLLLL, "Ly0_FLLLL")));
              }
            }
            final CFLLLL zFLLLL = new CFLLLL();
            return ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pw0_FLLLL){
              return zFLLLL.f0(pw0_FLLLL);
            } })).apply(pLLL);
          } };
        } };
      } };
    } };
  }
  // inductive c_dDatatypes_dInit_dCorelib_nlist: erased; values use Data(tag, fields)
  public static Object body(){
    return c_dMap_dTests_dPeregrine_nys();
  }
}
