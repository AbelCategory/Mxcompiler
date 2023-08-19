package asm;

import IR.*;

public class asmBuilder implements IRPass {
    public module topModule;
    public asmBuilder(module top) {
        topModule = top;
    }
    @Override public void visit(module mod) {}
    @Override public void visit(IRFunc fun) {}
    @Override public void visit(IRClass cl) {}
    @Override public void visit(block bl) {}

    @Override public void visit(arith x) {}
    @Override public void visit(icmp x) {}
    @Override public void visit(alloca x) {}
    @Override public void visit(load x) {}
    @Override public void visit(store x) {}
    @Override public void visit(br x) {}
    @Override public void visit(ret x) {}
    @Override public void visit(call x) {}
    @Override public void visit(phi x) {}
    @Override public void visit(getelementptr x) {}

    @Override public void visit(convert x) {}
}
