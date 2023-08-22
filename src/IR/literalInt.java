package IR;

public class literalInt extends literal{
    public long val;
    public literalInt(I_Type t, long val) {
        super(t);
        this.val = val;
    }

    @Override
    public String get_name() {return Long.toString(val);}

    @Override public boolean isInt() {return true;}

    @Override public long retVal() {return val;}

}
