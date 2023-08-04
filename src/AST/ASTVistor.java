package AST;

public interface ASTVistor {
    void visit(rtNode x);
    void visit(funcNode x);
    void visit(classNode x);
    void visit(varDefNode x);
    void visit(varNode x);

    void visit(BlockStatNode x);
    void visit(IfStatNode x);
    void visit(ForDefStatNode x);
    void visit(ForExpStatNode x);
    void visit(WhileStatNode x);
    void visit(breakStatNode x);
    void visit(continueStatNode x);
    void visit(returnStatNode x);
    void visit(exprStatNode x);

    void visit(binaryExpNode x);
    void visit(unaryExpNode x);
    void visit(postUpdateExpNode x);
    void visit(preUpdateExpNode x);
    void visit(condExpNode x);
    void visit(assignNode x);
    void visit(funCallNode x);
    void visit(memberFuncNode x);
    void visit(memberVarNode x);
    void visit(ArrayExpNode x);
    void visit(varExpNode x);
    void visit(NewExpNode x);

    void visit(constExprNode x);

    void visit(ThisNode x);

}