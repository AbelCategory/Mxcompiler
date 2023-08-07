package IR;

public class literalInt extends literal{
    public int val;
    public literalInt(I_Type t, int val) {
        super(t);
        this.val = val;
    }

    @Override
    public String get_name() {return Integer.toString(val);}

}
