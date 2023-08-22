package asm;

public class brInst extends inst {
    public enum brType {
        BEQ, BNE, BLT, BLE, BGT, BGTZ
    }
    public boolean isZero;

    String label;
    public brType op;
    public operand rs1, rs2, rd;
    public brInst(operand rd, operand rs1, operand rs2, brType opt, String lb) {
        op = opt;
        this.rd = rd;
        this.rs1 = rs1;
        this.rs2 = rs2;
        isZero = false;
        label = lb;
    }
    public brInst(operand rd, operand rs, brType opt, String lb) {
        op = opt;
        this.rd = rd;
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
}
