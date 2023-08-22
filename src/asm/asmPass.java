package asm;

public interface asmPass {
    void visit(asmModule topMod);
    void visit(asmFunc fun);
    void visit(section sec);
    void visit(Block blk);
    void visit(globalData data);

    void visit(brInst br);
    void visit(binaryInst bin);
    void visit(callInst call);
    void visit(cmpInst cmp);
    void visit(jInst j);
    void visit(laInst la);
    void visit(liInst li);
    void visit(loadInst load);
    void visit(mvInst mv);
    void visit(storeInst store);
}
