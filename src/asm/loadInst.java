package asm;

import Error.internalError;

public class loadInst extends inst {
    public enum loadType {
        LB, LH, LW, LD
    }

    public loadType op;
    public boolean isSymbol;
    public operand rd, rs, im;
    public String name;

    private void getType(int bytes) {
        switch (bytes) {
            case 1 -> op = loadType.LB;
            case 2 -> op = loadType.LH;
            case 4 -> op = loadType.LW;
            case 8 -> op = loadType.LD;
            default -> throw new internalError("wrong load bytes");
        }
    }

    public loadInst(int bytes, operand rd, operand rs, operand im) {
        getType(bytes);
        this.rd = rd;
        this.rs = rs;
        this.im = im;
        isSymbol = false;
    }
    public loadInst(int bytes, operand rd, String id) {
        getType(bytes);
        this.rd = rd;
        name = id;
        isSymbol = true;
    }

    @Override
    public String toString() {
        if(isSymbol) {
            return "\t" + op.toString().toLowerCase() + "\t" + rd + ", " + name;
        } else {
            return "\t" + op.toString().toLowerCase() + "\t" + rd + ", " + im + "(" + rs + ")";
        }
    }

    @Override
    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
