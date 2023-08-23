package asm;

public class brInst extends inst {
    public enum brType {
        BEQ, BNE, BLT, BLE, BGT, BGTZ,
    }
    public boolean isZero;

    String label;
    public brType op;
    public operand rs1, rs2;
    public brInst(operand rs1, operand rs2, brType opt, String lb) {
        op = opt;
        this.rs1 = rs1;
        this.rs2 = rs2;
        isZero = false;
        label = lb;
    }
    public brInst(operand rs, brType opt, String lb) {
        op = opt;
        rs1 = rs; rs2 = null;
        isZero = true;
        label = lb;
    }

    @Override
    public String toString() {
        if(isZero) {
            return "\t" + op.toString().toLowerCase() + "z\t" + rs1 + ", " + label;
        } else {
            return "\t" + op.toString().toLowerCase() + "\t" + rs1 + ", " + rs2 + ", " + label;
        }
    }

    @Override
    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
