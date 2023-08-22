package IR;

import java.util.ArrayList;

public class getelementptr extends statment {
    public entity res, p;
    public IRType t;
    public ArrayList<entity> idx = new ArrayList<>();
//    public ArrayList<literalInt> idx = new ArrayList<>();
    public getelementptr(entity res, entity p, IRType tp, entity idx) {
        super();
        this.res = res;
        this.p = p;
        t = tp;
        this.idx.add(idx);
    }

    public getelementptr(entity res, entity p, IRType tp, entity idx, int pos) {
        super();
        this.res = res;
        this.p = p;
        t = tp;
        this.idx.add(new literalInt(new I_Type(32), pos));
        this.idx.add(idx);
    }

    @Override
    public String toString() {
        StringBuilder sbt = new StringBuilder(idx.get(0).toString());
        int n = idx.size();
        for(int i = 1; i < n; ++i) {
            sbt.append(", ").append(idx.get(i).toString());
        }
        return res.get_name() + " = getelementptr " + t.toString() + ", ptr " + p.get_name() + ", " + sbt.toString();
    }

    @Override
    public void accept(IRPass pass) {
        pass.visit(this);
    }
}
