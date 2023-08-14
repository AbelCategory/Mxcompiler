package IR;

public class literalStr extends literal {
    public String val;
    public literalStr(IRString t, String val) {
        super(t);
        this.val = val;
    }

    @Override
    public String get_name() {return null;}
}
