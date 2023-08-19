package IR;

import java.util.ArrayList;
//import java.util.ListIterator;

public class IRFunc extends IRNode {
    public IRType retype;
    public localVar retReg;
    public String name;
    public ArrayList<entity> para = new ArrayList<>();
    public ArrayList<block> suite = new ArrayList<>();
    public block entry, ret;
    public label firstBlock;
    public boolean declare = false;
//    private ListIterator<statment> varDef = null;
    public IRFunc(String id, IRType type) {
        super();
        name = id;
        retype = type;
        entry = new block("entry", true);
        suite.add(new block("entry", true));
        firstBlock = suite.get(0).L;
//        varDef = suite.get(0).stats.listIterator();
    }

    public IRFunc(String id, IRType type, boolean declare) {
        super();
        name = id;
        retype = type;
        entry = null;
        suite = null;
        this.declare = declare;
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
        String str = declare ? "declare " : "define ";
        StringBuilder cur = new StringBuilder(str + "dso_local " + retype.toString());
        cur.append(" @").append(name).append("(");
        if(!para.isEmpty()) {
            cur.append(para.get(0).toString());
            int n = para.size();
            for(int i = 1; i < n; ++i) {
                cur.append(", ").append(para.get(i).toString());
            }
        }
        cur.append(")");
        return cur.toString();
    }
}
