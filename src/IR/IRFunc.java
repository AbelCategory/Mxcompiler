package IR;

import java.util.ArrayList;
//import java.util.ListIterator;

public class IRFunc extends IRNode {
    public IRType retype;
    public reg retReg;
    public String name;
    public ArrayList<entity> para = new ArrayList<>();
    public ArrayList<block> suite = new ArrayList<>();
    public block entry;
    public label firstBlock;
//    private ListIterator<statment> varDef = null;
    public IRFunc(String id, IRType type) {
        super();
        name = id;
        retype = type;
        entry = new block("entry", true);
        suite.add(new block("entry"));
        firstBlock = suite.get(0).L;
//        varDef = suite.get(0).stats.listIterator();
    }

    public void addVarDef(IRType t, entity v) {
        entry.addInst(new alloca(t, v));
    }

    public void addBlock(block blk) {
        suite.add(blk);
    }

    public void addAugment(entity t) {
        para.add(t);
    }

    @Override public String toString() {
        StringBuilder cur = new StringBuilder("define dso_local " + retype.toString());
        cur.append("@").append(name).append("(");
        if(!para.isEmpty()) {
            cur.append(para.get(0).toString());
            int n = para.size();
            for(int i = 1; i < n; ++i) {
                cur.append(",").append(para.get(i).toString());
            }
        }
        cur.append(")");
        return cur.toString();
    }
}
