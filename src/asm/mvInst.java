package asm;

public class mvInst extends inst {
    public operand rd, rs;
    public mvInst(operand rd, operand rs) {
        this.rd = rd;
        this.rs = rs;
    }

    @Override
    public String toString() {
        return "\tmv\t" + rd + ", " + rs;
    }

    @Override
    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
