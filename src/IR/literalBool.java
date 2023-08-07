package IR;

public class literalBool extends literal {
    public boolean val;
    public literalBool(I_Type t, boolean val) {
        super(t);
        this.val = val;
    }

    @Override
    public String get_name() {return val ? "true" : "false";}
}
