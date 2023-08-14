package IR;

public interface IRPass {
    void visit(module mod);
    void visit(IRFunc fun);
    void visit(IRClass cl);
    void visit(block bl);

    void visit(arith x);
    void visit(icmp x);
    void visit(alloca x);
    void visit(load x);
    void visit(store x);
    void visit(br x);
    void visit(ret x);
    void visit(call x);
    void visit(phi x);
    void visit(getelementptr x);
    void visit(convert x);
}
