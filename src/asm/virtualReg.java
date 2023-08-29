package asm;

public class virtualReg extends asmReg {
    public int index;
    public virtualReg(int index) {
        this.index = index;
    }

    public String toString() {return "%" + index;}
}
