package IR;

public class trunc extends statment {
    public entity res, val;
    public IRType ft, tt;
    public trunc(entity res, entity val, IRType ft, IRType tt) {
        super();
        this.res = res;
        this.val = val;
        this.ft = ft;
        this.tt = tt;
    }

    @Override
    public String toString() {
        return res.get_name() + " = trunc " + ft.toString() + " " + val.get_name() + " to " + tt.toString();
    }
}
