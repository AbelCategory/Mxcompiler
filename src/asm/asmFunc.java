package asm;

import java.util.ArrayList;

public class asmFunc {
    public int maxCall = 0, vir = 0;
    public String name;
    public ArrayList<Block> st;

    public asmFunc(String name) {
        this.name = name;
        st = new ArrayList<>();
        st.add(new Block(name, true));
    }

    public int getVir() {return vir++;}

    @Override
    public String toString() {
        return "\t.globl\t" + name + "\n\t.type\t" + name + ", " + "@function";
    }
}
