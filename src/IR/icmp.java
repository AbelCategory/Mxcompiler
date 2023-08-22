package IR;

import AST.BinaryOperator;

public class icmp extends statment {
    public enum compareType {
        EQ, NE, UGT, UGE, ULT, ULE, SGT, SGE, SLT, SLE
    }
    public compareType opt;
    public entity ls, rs, res;
    public icmp(BinaryOperator op, entity ls, entity rs, entity res) {
        this.ls = ls;
        this.rs = rs;
        this.res = res;
        switch (op) {
            case EQ -> opt = compareType.EQ;
            case NEQ -> opt = compareType.NE;
            case LE -> opt = compareType.SLT;
            case GR -> opt = compareType.SGT;
            case LEQ -> opt = compareType.SLE;
            case GEQ -> opt = compareType.SGE;
            default -> throw new RuntimeException("make icmp node error");
        }
    }

    @Override public String toString() {
        return res.get_name() + " = icmp " + opt.toString().toLowerCase() + " " + ls.type.toString() + " " + ls.get_name() + ", " + rs.get_name();
    }

    @Override
    public void accept(IRPass pass) {
        pass.visit(this);
    }
}
