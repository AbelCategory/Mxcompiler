package asm;

public class retInst extends inst {
    @Override public String toString() {
        return "\tret";
    }

    @Override
    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
