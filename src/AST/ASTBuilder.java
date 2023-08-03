package AST;

import Util.*;
import Parser.mxBaseVisitor;
import Parser.mxParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.List;
import java.util.ListIterator;
import Error.semanticError;


public class ASTBuilder extends mxBaseVisitor<ASTNode> {
    public globalScope gScope;
    public IntType inttype = new IntType();
    public BoolType booltype = new BoolType();
    public StringType stringtype = new StringType();
    public VoidType voidtype = new VoidType();
    public nulltype nullType = new nulltype();
    public typeNode intNode = new typeNode("int");
    public typeNode boolNode = new typeNode("bool");
    public typeNode stringNode = new typeNode("string");
    public typeNode voidNode = new typeNode("void");
    public typeNode nullNode = new typeNode("null");
    public ASTBuilder(globalScope gs) {
        gScope = gs;
        gScope.newType("int", inttype, null);
        gScope.newType("bool", booltype, null);
        gScope.newType("string", stringtype, null);
        gScope.newType("void", voidtype, null);
        FuncType Mxprint = new FuncType("print", voidtype),
                 Mxprintln = new FuncType("println", voidtype),
                 MxprintInt = new FuncType("printInt", voidtype),
                 MxprintlnInt = new FuncType("printlnInt", voidtype);
        Mxprint.paraType.add(stringtype);
        Mxprintln.paraType.add(stringtype);
        MxprintInt.paraType.add(inttype);
        MxprintlnInt.paraType.add(inttype);
        FuncType MxgetString = new FuncType("getString", stringtype),
                 MxgetInt = new FuncType("getInt", inttype);
        FuncType MxtoString = new FuncType("toString", stringtype);
        MxtoString.paraType.add(inttype);
        gScope.newFunc("print", Mxprint, null);
        gScope.newFunc("println", Mxprint, null);
        gScope.newFunc("printInt", MxprintInt, null);
        gScope.newFunc("printlnInt", MxprintlnInt, null);
        gScope.newFunc("getString", MxgetString, null);
        gScope.newFunc("getInt", MxgetInt, null);
        gScope.newFunc("toString", MxtoString, null);
    }
    @Override public ASTNode visitProgram(mxParser.ProgramContext ctx) {
        rtNode rt = new rtNode(new position(ctx), (funcNode) visitMainFn(ctx.mainFn()));
        List<mxParser.FuncDefContext> func = ctx.funcDef();
        List<mxParser.ClassDefContext> cl = ctx.classDef();
        List<mxParser.VarDefContext> var = ctx.varDef();
        for(mxParser.FuncDefContext f : func) {
            rt.funcDef.add((funcNode) visitFuncDef(f));
        }
        for(mxParser.ClassDefContext c : cl) {
            rt.classDef.add((classNode) visitClassDef(c));
        }
        for(mxParser.VarDefContext v : var) {
            rt.varDef.add((varDefNode) visitVarDef(v));
        }
        return rt;
//        rtNode rt = new rtNode(new position(ctx), )
    }

    @Override public ASTNode visitMainFn(mxParser.MainFnContext ctx) {
//        ArrayList<funcParameter> par = new ArrayList<>();
        BlockStatNode node = (BlockStatNode) visitSuite(ctx.suite());
        funcNode rt = new funcNode("main", new position(ctx), intNode, node);
        return rt;
    }

    @Override public ASTNode visitFuncDef(mxParser.FuncDefContext ctx) {
        BlockStatNode node = (BlockStatNode) visitSuite(ctx.suite());
        mxParser.TypenameContext t = ctx.typename();
        typeNode tt = (typeNode) visitTypename(ctx.typename());
        funcNode rt = new funcNode(ctx.ID().getText(), new position(ctx), tt, node);
        List<mxParser.TypenameContext> type = ctx.para().typename();
        List<TerminalNode> name = ctx.para().ID();
        ListIterator<mxParser.TypenameContext> i = type.listIterator();
        ListIterator<TerminalNode> j = name.listIterator();
        while(i.hasNext() && j.hasNext()){
            TerminalNode x = j.next();
            mxParser.TypenameContext y = i.next();
            typeNode tp = (typeNode) visitTypename(y);
            rt.pa.add(new funcParameter(x.getText(), new position(y), tp));
        }
        return rt;
    }

    @Override public ASTNode visitClassDef(mxParser.ClassDefContext ctx) {
        classNode rt = new classNode(ctx.ID().getText(), new position(ctx));
        List<mxParser.VarDefContext> var = ctx.varDef();
        List<mxParser.FuncDefContext> fun = ctx.funcDef();
        for(mxParser.VarDefContext v : var) {
            rt.varDef.add((varDefNode) visitVarDef(v));
        }
        for(mxParser.FuncDefContext f: fun) {
            rt.funcDef.add((funcNode) visitFuncDef(f));
        }
        if(!ctx.constructStat().isEmpty()) {
            if(ctx.constructStat().size() > 1) {
                throw new semanticError("more than one constructor", rt.pos);
            }
            rt.constructor = (funcNode) visitConstructStat(ctx.constructStat(0));
            if(!rt.constructor.name.equals(rt.name)) {
                throw new semanticError("wrong constructor name", rt.constructor.pos);
            }
        }
        return rt;
    }

    @Override public ASTNode visitConstructStat(mxParser.ConstructStatContext ctx) {
        BlockStatNode body = (BlockStatNode) visitSuite(ctx.suite());
        return new funcNode(ctx.ID().getText(), new position(ctx), voidNode, body);
//        return super.visitConstructStat(ctx);
    }

    @Override public ASTNode visitSuite(mxParser.SuiteContext ctx) {
        BlockStatNode node  = new BlockStatNode(new position(ctx));
        if(!ctx.stat().isEmpty()) {
            for(ParserRuleContext stat : ctx.stat()) {
                StatNode tmp = (StatNode) visit(stat);
                if(tmp != null) node.stats.add(tmp);
            }
        }
        return node;
    }

    @Override public ASTNode visitVarDef(mxParser.VarDefContext ctx) {
//        mxParser.TypenameContext t = ctx.typename();
        typeNode t = (typeNode) visitTypename(ctx.typename());
        varDefNode rt = new varDefNode(t, new position(ctx));
        if(!ctx.varTerm().isEmpty()) {
            for(mxParser.VarTermContext var : ctx.varTerm()) {
                rt.var.add((varNode) visitVarTerm(var));
            }
        }
        return rt;
    }

    @Override public ASTNode visitVarTerm(mxParser.VarTermContext ctx) {
        exprNode expr = ctx.expr() != null ? (exprNode) visit(ctx.expr()) : null;
        return new varNode(ctx.ID().getText(), expr, new position(ctx));
    }

    @Override public ASTNode visitSuite_statement(mxParser.Suite_statementContext ctx) {
        return visit(ctx.suite());
    }

    @Override public ASTNode visitDef_statement(mxParser.Def_statementContext ctx) {
        return visitVarDef(ctx.varDef());
    }

    @Override public ASTNode visitIf_statement(mxParser.If_statementContext ctx) {
        exprNode exp = (exprNode) visit(ctx.expr());
        StatNode thenNode = (StatNode) visit(ctx.ifstat),
                 elseNode = ctx.elsestat != null ? (StatNode) visit(ctx.elsestat) : null;
        return new IfStatNode(exp, thenNode, elseNode, new position(ctx));
    }

    @Override public ASTNode visitBreak_statement(mxParser.Break_statementContext ctx) {
        return new breakStatNode(new position(ctx));
    }

    @Override public ASTNode visitContinue_statement(mxParser.Continue_statementContext ctx) {
        return new continueStatNode(new position(ctx));
    }

    @Override public ASTNode visitReturn_statement(mxParser.Return_statementContext ctx) {
        exprNode expr = ctx.expr() != null ? (exprNode) visit(ctx.expr()) : null;
        return new returnStatNode(expr, new position(ctx));
    }

    @Override public ASTNode visitWhile_statement(mxParser.While_statementContext ctx) {
        exprNode expr = (exprNode) visit(ctx.expr());
        StatNode body = (StatNode) visit(ctx.stat());
        return new WhileStatNode(expr, body, new position(ctx));
    }

    @Override public ASTNode visitForExp_statement(mxParser.ForExp_statementContext ctx) {
        exprNode init = ctx.init != null ? (exprNode) visit(ctx.init) : null;
        exprNode cond = ctx.cond != null ? (exprNode) visit(ctx.cond) : null,
                 step = ctx.step != null ? (exprNode) visit(ctx.step) : null;
        StatNode body = (StatNode) visit(ctx.stat());
        return new ForExpStatNode(init, cond, step, body, new position(ctx));
    }

    @Override public ASTNode visitForDef_statement(mxParser.ForDef_statementContext ctx) {
        varDefNode init = ctx.init != null ? (varDefNode) visit(ctx.init) : null;
        exprNode cond = ctx.cond != null ? (exprNode) visit(ctx.cond) : null,
                 step = ctx.step != null ? (exprNode) visit(ctx.step) : null;
        StatNode body =  (StatNode) visit(ctx.stat());
        return new ForDefStatNode(init, cond, step, body, new position(ctx));
    }

    @Override public ASTNode visitExpression_statement(mxParser.Expression_statementContext ctx) {
        exprNode exp = (exprNode) visit(ctx.expr());
        return new exprStatNode(exp, new position(ctx));
    }

    @Override public ASTNode visitEmpty_statement(mxParser.Empty_statementContext ctx) {
        return null;
    }

    @Override public ASTNode visitParent_expression(mxParser.Parent_expressionContext ctx) {
        return visit(ctx.expr());
    }

    @Override public ASTNode visitBinary(mxParser.BinaryContext ctx) {
        exprNode lhs = (exprNode) visit(ctx.expr(0)),
                 rhs = (exprNode) visit(ctx.expr(1));
        String s = ctx.op.getText();
        BinaryOperator op;
        switch (s) {
            case "+" -> op = BinaryOperator.ADD;
            case "-" -> op = BinaryOperator.SUB;
            case "*" -> op = BinaryOperator.MUL;
            case "/" -> op = BinaryOperator.DIV;
            case "%" -> op = BinaryOperator.MOD;

            case "==" -> op = BinaryOperator.EQ;
            case "!=" -> op = BinaryOperator.NEQ;
            case "<" -> op = BinaryOperator.LE;
            case ">" -> op = BinaryOperator.GR;
            case "<=" -> op = BinaryOperator.LEQ;
            case ">=" -> op = BinaryOperator.GEQ;

            case "&" -> op = BinaryOperator.BAND;
            case "|" -> op = BinaryOperator.BOR;
            case "^" -> op = BinaryOperator.BXOR;
            case "<<" -> op = BinaryOperator.LSH;
            case ">>" -> op = BinaryOperator.RSH;

            case "&&" -> op = BinaryOperator.LAND;
            case "||" -> op = BinaryOperator.LOR;

            default -> throw new semanticError("wrong binary operator", new position(ctx));
        }
        return new binaryExpNode(lhs, rhs, op, new position(ctx), null);
    }

    @Override public ASTNode visitUnary(mxParser.UnaryContext ctx) {
        exprNode exp = (exprNode) visit(ctx.expr());
        String s = ctx.op.getText();
        UnaryOperator op;
        switch (s) {
            case "~" -> op = UnaryOperator.BNOT;
            case "!" -> op = UnaryOperator.LNOT;
            case "+" -> op = UnaryOperator.POS;
            case "-" -> op = UnaryOperator.NEG;

            default -> throw new semanticError("wrong unary operator", new position(ctx));
        }
        return new unaryExpNode(exp, op, new position(ctx), null);
    }

    @Override public ASTNode visitAssign(mxParser.AssignContext ctx) {
        exprNode lhs = (exprNode) visit(ctx.expr(0));
        exprNode rhs = (exprNode) visit(ctx.expr(1));
        return new assignNode(lhs, rhs, new position(ctx), null);
    }

    @Override public ASTNode visitConditional(mxParser.ConditionalContext ctx) {
        exprNode cond = (exprNode) visit(ctx.expr(0)),
                 exp1 = (exprNode) visit(ctx.expr(1)),
                 exp2 = (exprNode) visit(ctx.expr(2));
        return new condExpNode(cond, exp1, exp2, new position(ctx), null);
    }

    @Override public ASTNode visitLeft_inc_dec(mxParser.Left_inc_decContext ctx) {
        exprNode exp = (exprNode) visit(ctx.expr());
        UPDOperator op = ctx.Inc() != null ? UPDOperator.INC
                       : (ctx.Dec()!= null ? UPDOperator.DEC : null);
        if(op == null) throw new semanticError("wrong update operator", new position(ctx));
        return new preUpdateExpNode(exp, op, new position(ctx), null);
    }

    @Override public ASTNode visitRight_inc_dec(mxParser.Right_inc_decContext ctx) {
        exprNode exp = (exprNode) visit(ctx.expr());
        UPDOperator op = ctx.Inc() != null ? UPDOperator.INC
                : (ctx.Dec()!= null ? UPDOperator.DEC : null);
        if(op == null) throw new semanticError("wrong update operator", new position(ctx));
        return new postUpdateExpNode(exp, op, new position(ctx), null);
    }

    @Override public ASTNode visitBasic_expression(mxParser.Basic_expressionContext ctx) {
        return visit(ctx.basic_expr());
    }


    @Override public ASTNode visitVariable(mxParser.VariableContext ctx) {
        return new varExpNode(ctx.ID().getText(), new position(ctx));
    }

    @Override public ASTNode visitConstvalue(mxParser.ConstvalueContext ctx){
        return visitConst(ctx.const_());
    }

    @Override
    public ASTNode visitConst(mxParser.ConstContext ctx) {
        if(ctx.Str() != null) {
            String str =  ctx.Str().getText();
            int len = str.length();
            String value = str.substring(1, len - 2);
            return new StringNode(value, new position(ctx), stringtype);

        } else if(ctx.Num() != null) {
            return new IntNode(Integer.parseInt(ctx.Num().getText()), new position(ctx), inttype);
        } else if(ctx.True() != null) {
            return new BoolNode(true, new position(ctx), booltype);
        } else if(ctx.False() != null) {
            return new BoolNode(false, new position(ctx), booltype);
        } else if(ctx.Null() != null) {
            return new NullNode(new position(ctx), nullType);
        } else if(ctx.This() != null) {
            return new ThisNode(new position(ctx), nullType);
        } else{
            throw new semanticError("wrong literal type", new position(ctx));
        }
    }

    @Override public ASTNode visitNew_expression(mxParser.New_expressionContext ctx) {
        mxParser.TypenameContext tp = ctx.typename();
        NewExpNode rt = new NewExpNode(1, new position(ctx), null);
        return rt;
    }

    @Override public ASTNode visitFunctionCall(mxParser.FunctionCallContext ctx) {
        funCallNode cur = new funCallNode(ctx.ID().getText(), new position(ctx), null);
        if(!ctx.argu().isEmpty()) {
            List<mxParser.ExprContext> A = ctx.argu().expr();
            for(mxParser.ExprContext a : A)
                cur.arguments.add((exprNode) visit(a));
        }
        return cur;
    }

    @Override public ASTNode visitTypename(mxParser.TypenameContext ctx) {
        if(ctx.bracket().isEmpty()) {
            typeNode t = new typeNode(ctx.ID().getText());
            return t;
        } else {
            int dim = ctx.bracket().size();
            typeArrayNode t = new typeArrayNode(ctx.ID().getText(), dim);
            return  t;
        }
    }

    @Override public ASTNode visitArrayIndex(mxParser.ArrayIndexContext ctx) {
        exprNode array = (exprNode) visit(ctx.expr(0)),
                 index = (exprNode) visit(ctx.expr(1));
        return new ArrayExpNode(array, index, new position(ctx), null);
    }

    @Override public ASTNode visitMemberExp(mxParser.MemberExpContext ctx) {
        exprNode obj = (exprNode) visit(ctx);
        return new memberVarNode(obj, ctx.varName.getText(), new position(ctx), null);
    }

    @Override public ASTNode visitMemberFun(mxParser.MemberFunContext ctx) {
        exprNode obj = (exprNode) visit(ctx);
        String id = ctx.funName.getText();
        memberFuncNode cur = new memberFuncNode(obj, id, new position(ctx), null);
        if(!ctx.argu().isEmpty()) {
            List<mxParser.ExprContext> A = ctx.argu().expr();
            for(mxParser.ExprContext a : A) {
                cur.arguments.add((exprNode) visit(a));
            }
        }
        return cur;
    }
}
