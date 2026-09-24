public final class Prog {
  public static Object c_nsuite__unit(){
    return ((Rt.Fn)(c_nunit())).apply(c_oUnit_nunit());
  }
  public static Object c_nunit(){
    return new Rt.Fn(){ public Object apply(Object p){
      return c_oUnit_nunit();
    } };
  }
  public static Object c_oUnit_nunit(){
    return new Rt.Data(0, new Object[]{  });
  }
  // inductive c_nPUnit: erased; values use Data(tag, fields)
  public static Object body(){
    return c_nsuite__unit();
  }
}
