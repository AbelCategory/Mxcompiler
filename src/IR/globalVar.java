package IR;

public class globalVar extends variable {
    public entity val = null;
    public globalVar(String name, IRType t) {
        super(t, name);
    }

    @Override
    public String get_name() {return "@" + name;}

    public String def() {
        IRType tp = ((ptrType) type).type;
        String ret = get_name() + " = dso_local global " + tp;
        if(val != null) {
            return ret + " " + val.get_name();
        } else if(tp instanceof I_Type) {
            return ret + " 0";
        } else {
            return ret + "ptr null";
        }
    }
}
