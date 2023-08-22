package IR;

public class literalBool extends literal {
    public boolean val;
    public literalBool(I_Type t, boolean val) {
        super(t);
        this.val = val;
    }

    @Override
    public String get_name() {
        if(((I_Type) type).i_N == 1) return val ? "true" : "false";
        else return val ? "1" : "0";
    }

    @Override public boolean isInt() {return true;}

    @Override public long retVal() {return val ? 1 : 0;}
}
