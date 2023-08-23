package asm;

public class cmpInst extends inst {
    public enum cmpType {
        SLT, SLTI,
        SGTZ, SLTZ, SEQZ, SNEZ,
    }
    public operand rd, rs1, rs2;
    public boolean isZ;
    public cmpType op;
    public cmpInst(operand rd, operand rs1, operand rs2, cmpType opt) {
        op = opt;
        this.rd = rd;
        this.rs1 = rs1;
        this.rs2 = rs2;
        isZ = false;
    }
    public cmpInst(operand rd, operand rs, cmpType opt) {
        op = opt;
        this.rd = rd;
        rs1 = rs; rs2 = null;
        isZ = true;
    }

    @Override
    public String toString() {
        if(isZ) {
            return "\t" + op.toString().toLowerCase() + "\t" + rd + ", " + rs1;
        } else {
            return "\t" + op.toString().toLowerCase() + "\t" + rd + ", " + rs1 + ", " + rs2;
        }
    }

    @Override
    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
