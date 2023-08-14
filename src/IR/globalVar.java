package IR;

public class globalVar extends variable {
    public globalVar(String name, IRType t) {
        super(t, name);
    }

    @Override
    public String get_name() {return "@" + name;}

    public String def() {
        String ret = get_name() + " = dso_local global " + type.toString();
        if(type instanceof I_Type) {
            return ret + " 0";
        } else {
            return ret + "zeroinitializer";
        }
    }
}
