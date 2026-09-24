public final class Prog {
  public static Object c_nsuite__demo0(){
    return ((Rt.Fn)(c_ndemo0())).apply(c_oUnit_nunit());
  }
  public static Object c_ndemo0(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Data(1, new Object[]{ c_oUnit_nunit(), new Rt.Data(1, new Object[]{ c_oUnit_nunit(), new Rt.Data(1, new Object[]{ c_oUnit_nunit(), new Rt.Data(0, new Object[]{  }) }) }) });
    } };
  }
  public static Object c_oUnit_nunit(){
    return new Rt.Data(0, new Object[]{  });
  }
  // inductive c_nPUnit: erased; values use Data(tag, fields)
  // inductive c_nList: erased; values use Data(tag, fields)
  public static Object body(){
    return c_nsuite__demo0();
  }
}
