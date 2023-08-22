package asm;

public class callInst extends inst {
    String name;
    public callInst(String id) {
        name = id;
    }

    @Override
    public String toString() {
        return "\tcall\t" + name;
    }
}
