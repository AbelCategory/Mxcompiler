package asm;

import Error.internalError;

public class storeInst extends inst {
    public enum storeType {
        SB, SH, SW, SD
    }

    public storeType op;
    public operand rs1, rs2, im;
    public String name;
    public boolean isSymbol;

    private void getType(int bytes) {
        switch (bytes) {
            case 1 -> op = storeType.SB;
            case 2 -> op = storeType.SH;
            case 4 -> op = storeType.SW;
            case 8 -> op = storeType.SD;
            default -> throw new internalError("wrong load bytes");
        }
    }

    public storeInst(int bytes, operand rs1, operand rs2, operand im) {
        getType(bytes);
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.im = im;
    }
    public storeInst(int bytes, operand rs, String id) {
        getType(bytes);
        this.rs1 = rs;
        name = id;
    }

    @Override
    public String toString() {
        if(isSymbol) {
            return "\t" + op.toString().toLowerCase() + "\t" + rs1 + ", " + name;
        } else {
            return "\t" + op.toString().toLowerCase() + "\t" + rs1 + ", " + im + "(" + rs2 + ")";
        }
    }

    @Override
    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
