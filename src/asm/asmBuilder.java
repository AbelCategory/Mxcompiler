package asm;

import IR.*;
import Error.internalError;

import java.util.HashMap;

public class asmBuilder implements IRPass {
    public module top;
    public asmModule topModule;
    public asmFunc curFunc;
    public Block curBlock;
    public phyReg a0, sp, s0, s1;
    public HashMap<entity, asmReg> regMap;
    public HashMap<label, Block> blkMap;
    public asmBuilder() {
        topModule = new asmModule();
        a0 = topModule.regs.get(10);
        sp = topModule.regs.get(2);
        s0 = topModule.regs.get(8);
        s1 = topModule.regs.get(9);
    }
    @Override public void visit(module mod) {
        mod.str.forEach(this::visitStrLiteral);
        mod.gvar.forEach(this::visitGlobalVar);
        mod.cls.forEach(c -> c.accept(this));
        mod.func.forEach(f -> f.accept(this));
    }

    public asmReg getReg(entity x) {
        if(x instanceof literal t) {
            long val = t.retVal();
            virtualReg r = new virtualReg(curFunc.getVir());
            curBlock.addInst(new liInst(r, new imm(val)));
            return r;
        } else if(x instanceof globalVar t) {
            virtualReg r = new virtualReg(curFunc.getVir());
            curBlock.addInst(new laInst(r, t.name));
            return r;
        } else {
            return regMap.get(x);
        }
    }

    public Block getASMBlock(label x) {
        if(!blkMap.containsKey(x)) {
            Block blk = new Block(x.name);
            blkMap.put(x, blk);
        }
        return blkMap.get(x);
    }

    public void visitStrLiteral(literalStr str) {
        topModule.rodata.addData(new globalData(str.asm_name(), str.val));
    }

    public void visitGlobalVar(globalVar gvar) {
        topModule.rodata.addData(new globalData(gvar.asm_name(), (int) (gvar.val != null ? 0L : ((literal) gvar.val).retVal()), true));
    }

    @Override public void visit(IRFunc fun) {
        asmFunc f = new asmFunc(fun.name);
        topModule.text.addFunc(f);
        curFunc = f;
        for(int i = 0; i < Math.min(8, fun.para.size()); ++i) {
            entity p = fun.para.get(i);
            virtualReg reg = new virtualReg(curFunc.getVir());
            curBlock.addInst(new mvInst(reg, topModule.regs.get(10 + i)));
            regMap.put(p, reg);
        }
        int bytes = 0;
        for(int i = 8; i < fun.para.size(); ++i) {
            entity p = fun.para.get(i);
            virtualReg reg = new virtualReg(curFunc.getVir());
            curBlock.addInst(new loadInst(4, reg, sp, new imm(bytes)));
            regMap.put(p, reg);
            bytes += 4;
        }
        blkMap = new HashMap<>();
        blkMap.put(fun.suite.get(0).L, f.st.get(0));
        //blkMap.put(fun.suite.get())
        fun.suite.forEach(blk -> blk.accept(this));
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
        } else {
            binaryInst ins;
            if(rs instanceof literal t) {
                ins = new binaryInst(res, getReg(ls), new imm(t.retVal()), op);
                ins.imm = true;
            } else {
                ins = new binaryInst(res, getReg(ls), getReg(rs), op);
            }
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
        virtualReg res = new virtualReg(curFunc.getVir());
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
        else tmp = new virtualReg(curFunc.getVir());
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
        virtualReg res = new virtualReg(curFunc.getVir());
        switch (x.opt) {
            case EQ, NE -> {
                virtualReg tmp = new virtualReg(curFunc.getVir());
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

    @Override public void visit(alloca x) {

    }

    @Override public void visit(load x) {
        virtualReg res = new virtualReg(curFunc.getVir());
        if(x.ptr instanceof globalVar t) {
            curBlock.addInst(new loadInst(4, res, t.asm_name()));
        } else {
            asmReg rs = getReg(x.ptr);

        }
        regMap.put(x.val, res);
    }
    @Override public void visit(store x) {
        if(x.ptr instanceof globalVar t) {
            curBlock.addInst(new storeInst(4, getReg(x.val), t.asm_name()));
        } else {

        }
    }
    @Override public void visit(br x) {
        if(x.isCond()) {
            Block blk1 = getASMBlock(((label) x.label1));
            Block blk2 = getASMBlock(((label) x.label2));
            brInst branch = new brInst(getReg(x.condRes), brInst.brType.BNE, blk1.name);
            curBlock.addInst(branch);
            blk1.addPreBlock(curBlock, branch);
            jInst jump = new jInst(blk2.name);
            curBlock.addInst(jump);
            blk2.addPreBlock(curBlock, jump);
        } else {
            Block blk = getASMBlock(((label) x.label1));
            jInst jump = new jInst(blk.name);
            curBlock.addInst(jump);
            blk.addPreBlock(curBlock, jump);
        }
    }
    @Override public void visit(ret x) {
        curBlock.addInst(new mvInst(a0, getReg(x.retEntity)));
        curBlock.addInst(new retInst());
    }

    @Override public void visit(call x) {
        int bytes = 0;
        for(int i = 0; i < Math.min(x.para.size(), 8); ++i) {
            entity val = x.para.get(i);
            if(val instanceof literal t) {
                curBlock.addInst(new liInst(topModule.regs.get(10 + i), new imm(t.retVal())));
            } else {
                curBlock.addInst(new mvInst(topModule.regs.get(10 + i), getReg(val)));
            }
        }
        for(int i = 8; i < x.para.size(); ++i) {
            entity val = x.para.get(i);
            curBlock.addInst(new storeInst(4, getReg(val), sp, new imm(bytes)));
            bytes += 4;
        }
        curFunc.maxCall = Math.max(curFunc.maxCall, bytes);
        curBlock.addInst(new callInst(x.name));
        if(x.rd != null) {
            virtualReg res = new virtualReg(curFunc.getVir());
            curBlock.addInst(new mvInst(res, a0));
            regMap.put(x.rd, res);
        }
    }

    @Override public void visit(phi x) {
        int n = x.lb.size();
        virtualReg cur = new virtualReg(curFunc.getVir());
        for(int i = 0; i < n; ++i) {
            Block pre = getASMBlock(x.lb.get(i));
            inst lst = curBlock.preInst.get(pre);
            pre.addPrev(lst, new mvInst(cur, getReg(x.val.get(i))));
        }
        regMap.put(x.res, cur);
    }

    @Override public void visit(getelementptr x) {
        virtualReg res = new virtualReg(curFunc.getVir());
        if(x.idx.size() == 1) {
            entity id = x.idx.get(0);
            virtualReg p = new virtualReg(curFunc.getVir());
            if(id instanceof literal t) {
                curBlock.addInst(new liInst(p, new imm(t.retVal() * 4)));
                curBlock.addInst(new binaryInst(res, getReg(x.p), p, binaryInst.binaryType.ADD));
            } else {
                binaryInst b = new binaryInst(p, getReg(id), new imm(2), binaryInst.binaryType.SLL);
                b.imm = true;
                curBlock.addInst(b);
                curBlock.addInst(new binaryInst(res, getReg(x.p), p, binaryInst.binaryType.ADD));
            }
            regMap.put(x.res, res);
        } else {
            entity id = x.idx.get(1);
            int pos = (int) (((literalInt) id).val * 4);
            if(pos != 0) {
                binaryInst b = new binaryInst(res, getReg(x.p), new imm(pos), binaryInst.binaryType.ADD);
                b.imm = true;
                curBlock.addInst(b);
                regMap.put(x.res, res);
            } else {
                regMap.put(x.res, getReg(x.p));
            }

        }

    }

    @Override public void visit(convert x) {}
}
