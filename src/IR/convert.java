package IR;

public class convert extends statment {
    public enum conv {
        TRUNC, ZEXT
    }
    public entity res, val;
    public IRType ft, tt;
    public conv op;
    public convert(entity res, entity val, IRType tt, IRType ft, conv c) {
        super();
        this.res = res;
        this.val = val;
        this.ft = ft;
        this.tt = tt;
        op = c;
    }

    @Override
    public String toString() {
        return res.get_name() + " = " + op.toString().toLowerCase() + " " + ft.toString() + " " + val.get_name() + " to " + tt.toString();
    }
}
