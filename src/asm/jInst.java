package asm;

public class jInst extends inst {
    String label;
    public jInst(String id) {
        label = id;
    }

    @Override
    public String toString() {
        return "\tj\t" + label;
    }

    @Override
    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
