package asm;

public class binaryInst extends inst {
    public enum binaryType {
        ADD, SUB, SLL, XOR, SRL, SRA, OR, AND,
        MUL, DIV, REM
    }

    public operand rs1, rs2, rd;
    public binaryType op;
    public boolean imm = false;

    public binaryInst(operand rd, operand rs1, operand rs2, binaryType opt) {
        this.rd = rd;
        this.rs1 = rs1;
        this.rs2 = rs2;
        op = opt;
    }

    @Override
    public String toString() {
        return "\t" + op.toString().toLowerCase() + (imm ? "i\t" : "\t") + rd + ", " + rs1 + ", " + rs2;
    }
}
