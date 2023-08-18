package IR;

public class getelementptr extends statment {
    public entity res, p;
    public IRType t;
    public entity idx;
//    public ArrayList<literalInt> idx = new ArrayList<>();
    public getelementptr(entity res, entity p, IRType tp, entity idx) {
        super();
        this.res = res;
        this.p = p;
        t = tp;
        this.idx = idx;
    }

    @Override
    public String toString() {
        return res.get_name() + " = getelementptr " + t.toString() + ", ptr " + p.get_name() + ", " + idx.toString();
    }
}
