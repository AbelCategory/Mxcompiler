package IR;
import AST.BinaryOperator;

public class arith extends statment {
    public enum binary{
        ADD, SUB, MUL, SDIV, SREM, SHL, ASHR, AND, OR, XOR
    }
    public binary opt;
    public entity ls, rs, res;

    public arith(BinaryOperator op, entity ls, entity rs, entity res) {
        super();
        this.ls = ls;
        this.rs = rs;
        this.res = res;
        switch (op) {
            case ADD -> opt = binary.ADD;
            case SUB -> opt = binary.SUB;
            case MUL -> opt = binary.MUL;
            case DIV -> opt = binary.SDIV;
            case MOD -> opt = binary.SREM;
            case LSH -> opt = binary.SHL;
            case RSH -> opt = binary.ASHR;
            case BAND, LAND -> opt = binary.AND;
            case BOR, LOR -> opt = binary.OR;
            case BXOR -> opt = binary.XOR;
            default -> throw new RuntimeException("make arithmetic node error");
        }
//        switch (opt) {
//            case ADD, MUL, AND, XOR, OR -> {
//                if(ls instanceof literal) {
//                    swap()
//                }
//            }
//        }
    }

    @Override
    public String toString() {
        return res.get_name() + " = " + opt.toString().toLowerCase() + " " + res.type.toString() + " " + ls.get_name() + ", " + rs.get_name();
    }
}
