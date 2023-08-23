package asm;

public class liInst extends inst {
    public operand rd;
    public imm i;

    public liInst(operand rd, imm i) {
        this.rd = rd;
        this.i = i;
    }

    @Override
    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
