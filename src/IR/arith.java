package IR;
import AST.BinaryOperator;

public class arith extends statment {
    public enum binary{
        ADD, SUB, MUL, SDIV, SREM, SHL, ASHR, AND, OR, XOR
    }
    public binary opt;
    public entity ls, rs, res;

    public arith(BinaryOperator op, entity ls, entity rs) {
        super();
        this.ls = ls;
        this.rs = rs;
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
            default -> throw new RuntimeException();
        }
    }

    @Override
    public String toString() {

    }
}
