package asm;

public class laInst extends inst {
    public String name;
    public operand rd;

    public laInst(operand rd, String id) {
        this.rd = rd;
        name = id;
    }

    @Override
    public String toString() {
        return "\tla\t" + rd + ", " + name;
    }

    @Override
    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
