package IR;

public class literalStr extends literal {
    public String val;
    public int id;
    static int cnt;
    public literalStr(IRString t, String val) {
        super(t);
        this.val = val;
        id = ++cnt;
    }

    @Override
    public String get_name() {
        return "@.str." + cnt;
    }

    public String def() {
        return "@.str." + cnt + " = private unnamed_addr const [" + (val.length() + 1) + " x i8] c\"" + val + "\"";

    }
}
