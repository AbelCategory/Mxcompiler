package asm;

import AST.BinaryOperator;
import IR.*;
import Error.internalError;

import java.util.HashMap;

public class asmBuilder implements IRPass {
    public module topModule;
    public Block curBlock;
    public HashMap<entity, asmReg> regMap;
    public asmBuilder(module top) {
        topModule = top;
    }
    @Override public void visit(module mod) {
        mod.str.forEach(this::visitStrLiteral);
        mod.gvar.forEach(v -> v.accept(this));
        mod.cls.forEach(c -> c.accept(this));
        mod.func.forEach(f -> f.accept(this));
    }

    public operand getReg(entity x) {
        if(x instanceof literal t) {
            long val = t.retVal();
            virtualReg r = new virtualReg();
            curBlock.addInst(new liInst(r, new imm(val)));
        } else if(x instanceof globalVar t) {
        }
    }

    public String getASMBlock(label x) {

    }

    public void visitStrLiteral(literalStr str) {
    }

    @Override public void visit(IRFunc fun) {

    }
    @Override public void visit(IRClass cl) {}
    @Override public void visit(block bl) {
        bl.stats.forEach(s -> s.accept(this));
    }

    private void SBinary(entity ls, entity rs, binaryInst.binaryType op, virtualReg res) {
        if(ls instanceof literal t) {
            binaryInst ins = new binaryInst(res, getReg(rs), new imm(t.retVal()), op);
            ins.imm = true;
            curBlock.addInst(ins);
        } else if(rs instanceof literal t) {
            binaryInst ins = new binaryInst(res, getReg(ls), new imm(t.retVal()), op);
            ins.imm = true;
            curBlock.addInst(ins);
        } else {
            binaryInst ins = new binaryInst(res, getReg(ls), getReg(rs), op);
            curBlock.addInst(ins);
        }
    }

    private void UBinary(entity ls, entity rs, binaryInst.binaryType op, virtualReg res) {
        if(rs instanceof literal t) {
            binaryInst ins = new binaryInst(res, getReg(ls), new imm(t.retVal()), op);
            ins.imm = true;
            curBlock.addInst(ins);
        } else {
            binaryInst ins = new binaryInst(res, getReg(ls), getReg(rs), op);
            curBlock.addInst(ins);
        }
    }

    @Override public void visit(arith x) {
        virtualReg res = new virtualReg();
        switch (x.opt) {
            case ADD -> SBinary(x.ls, x.rs, binaryInst.binaryType.ADD, res);
            case SUB -> UBinary(x.ls, x.rs, binaryInst.binaryType.SUB, res);
            case MUL -> curBlock.addInst(new binaryInst(res, getReg(x.ls), getReg(x.rs), binaryInst.binaryType.MUL));
            case SDIV -> curBlock.addInst(new binaryInst(res, getReg(x.ls), getReg(x.rs), binaryInst.binaryType.DIV));
            case SREM -> curBlock.addInst(new binaryInst(res, getReg(x.ls), getReg(x.rs), binaryInst.binaryType.REM));
            case SHL -> UBinary(x.ls, x.rs, binaryInst.binaryType.SLL, res);
            case ASHR -> UBinary(x.ls, x.rs, binaryInst.binaryType.SRA, res);
            case AND -> SBinary(x.ls, x.rs, binaryInst.binaryType.AND, res);
            case OR -> SBinary(x.ls, x.rs, binaryInst.binaryType.OR, res);
            case XOR -> SBinary(x.ls, x.rs, binaryInst.binaryType.XOR, res);
            default -> throw new internalError("no such binary operator");
        }
        regMap.put(x.res, res);
    }

    private void SCompare(entity ls, entity rs, boolean isNot, virtualReg res) {
        virtualReg tmp;
        if(isNot) tmp = res;
        else tmp = new virtualReg();
        if(rs instanceof literal t) {
            curBlock.addInst(new cmpInst(tmp, getReg(ls), new imm(t.retVal()), cmpInst.cmpType.SLTI));
        } else {
            curBlock.addInst(new cmpInst(tmp, getReg(ls), getReg(rs), cmpInst.cmpType.SLT));
        }
        if(isNot) {
            binaryInst ins = new binaryInst(res, tmp, new imm(1), binaryInst.binaryType.XOR);
            ins.imm = true;
            curBlock.addInst(ins);
        }
    }

    @Override public void visit(icmp x) {
        virtualReg res = new virtualReg();
        switch (x.opt) {
            case EQ, NE -> {
                virtualReg tmp = new virtualReg();
                SBinary(x.ls, x.rs, binaryInst.binaryType.XOR, tmp);
                cmpInst.cmpType op = x.opt.equals(icmp.compareType.EQ) ? cmpInst.cmpType.SEQZ : cmpInst.cmpType.SNEZ;
                curBlock.addInst(new cmpInst(res, tmp, op));
            }
            case SLT, SGE -> SCompare(x.ls, x.rs, x.opt.equals(icmp.compareType.SGE), res);
            case SGT, SLE -> SCompare(x.rs, x.ls, x.opt.equals(icmp.compareType.SLE), res);
            default -> throw new internalError("no such compare type");
        }
        regMap.put(x.res, res);
    }
    @Override public void visit(alloca x) {}
    @Override public void visit(load x) {
        virtualReg res = new virtualReg();
        if(x.ptr instanceof globalVar) {
//            curBlock.addInst(new loadInst());
        } else {

        }
        regMap.put(x.val, res);
    }
    @Override public void visit(store x) {
        if(x.ptr instanceof globalVar) {

        } else {

        }
    }
    @Override public void visit(br x) {
        if(x.isCond()) {

        } else {
            curBlock.addInst(new jInst(getASMBlock(((label) x.label1))));
        }
    }
    @Override public void visit(ret x) {}
    @Override public void visit(call x) {}
    @Override public void visit(phi x) {}
    @Override public void visit(getelementptr x) {}

    @Override public void visit(convert x) {}
}
