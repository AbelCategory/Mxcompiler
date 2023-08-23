package asm;

import java.io.PrintStream;

public class asmPrinter implements asmPass {
    PrintStream out;
    public asmPrinter(PrintStream out) {
        this.out = out;
    }

    @Override
    public void visit(asmModule topMod) {
        visit(topMod.text);
        visit(topMod.data);
        visit(topMod.rodata);
    }

    @Override
    public void visit(asmFunc fun) {
        out.println(fun);
        fun.st.forEach(this::visit);
        out.println(fun.endString());
    }

    @Override
    public void visit(section sec) {
        out.println(sec);
        if(sec.funcs != null) {
            sec.funcs.forEach(this::visit);
        }
        if(sec.gd != null) {
            sec.gd.forEach(this::visit);
        }
    }

    @Override
    public void visit(Block blk) {
        out.println(blk);
        for(var it = blk.head; it != null; it = it.next) {
            out.println(it);
        }
    }

    @Override
    public void visit(globalData data) {
        out.println(data);
    }

    @Override public void visit(brInst br) {}
    @Override public void visit(binaryInst bin) {}
    @Override public void visit(callInst call) {}
    @Override public void visit(cmpInst cmp) {}
    @Override public void visit(jInst j) {}
    @Override public void visit(laInst la) {}
    @Override public void visit(liInst li) {}
    @Override public void visit(loadInst load) {}
    @Override public void visit(mvInst mv) {}
    @Override public void visit(storeInst store) {}
    @Override public void visit(retInst retInst) {}
}
