package asm;

import IR.IRPass;

import java.util.ArrayList;

public class section {
    public String name;
    ArrayList<globalData> gd;
    ArrayList<asmFunc> funcs;
    public section(String name) {
        this.name = name;
        gd = new ArrayList<>();
        funcs = new ArrayList<>();
    }

    public void addData(globalData d) {
        gd.add(d);
    }

    public void addFunc(asmFunc func) {
        funcs.add(func);
    }

    @Override
    public String toString() {
        return "\t.section\t" + "." + name;
    }

    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
