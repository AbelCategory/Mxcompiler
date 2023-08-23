package asm;

import IR.IRPass;

import java.util.ArrayList;
import java.util.Arrays;

public class asmModule {
    public static ArrayList<String> regName = new ArrayList<>(Arrays.asList(
            "zero", "ra", "sp", "gp", "t0", "t1", "t2", "s0", "s1",
            "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7",
            "s2", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "s11",
            "t3", "t4", "t5", "t6"
    ));
    public ArrayList<phyReg> regs = new ArrayList<>();
    public ArrayList<phyReg> caller = new ArrayList<>(), callee = new ArrayList<>();
    public section text, data, rodata;

    public asmModule() {
        regName.forEach(r -> regs.add(new phyReg(r)));
        callee.add(regs.get(9));
        for(int i = 18; i <= 27; ++i) callee.add(regs.get(i));

        for(int i = 5; i <= 7; ++i) caller.add(regs.get(i));
        for(int i = 10; i <= 17; ++i) caller.add(regs.get(i));
        for(int i = 28; i <= 31; ++i) caller.add(regs.get(i));

        text = new section("text");
        data = new section("data");
        rodata = new section("rodata");
    }

    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
