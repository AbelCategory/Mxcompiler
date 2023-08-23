package asm;

public class phyReg extends asmReg {
    public String name;
    public phyReg(String id) {
        name = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
