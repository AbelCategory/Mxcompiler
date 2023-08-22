package asm;

public class registerAllocation implements asmPass {
    public registerAllocation() {

    }

    @Override
    public void visit(asmModule topMod) {
        visit(topMod.text);
    }

    @Override
    public void visit(asmFunc fun) {

    }

    @Override
    public void visit(Block blk) {

    }

    @Override
    public void visit(section sec) {
        sec.funcs.forEach(this::visit);
    }
    @Override public void visit(globalData data) {}

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
}
