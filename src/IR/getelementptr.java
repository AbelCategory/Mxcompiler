package IR;

import java.util.ArrayList;

public class getelementptr extends statment {
    public entity res, p;
    public ArrayList<literalInt> idx = new ArrayList<>();
    public getelementptr(entity res, entity p) {
        super();
        this.res = res;
        this.p = p;
    }

    public void addOffSet(literalInt offset) {
        idx.add(offset);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder(res.get_name() + " = getelementptr " + ((ptrType) p.type).type.toString() + ", " + p.toString());
        return ret.toString();
    }
}
