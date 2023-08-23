package asm;

public abstract class inst {
    public inst prev = null, next = null;
    @Override public String toString() {return null;}

    public abstract void accept(asmPass pass);
}
