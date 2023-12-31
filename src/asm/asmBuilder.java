package asm;

import IR.*;
import Error.internalError;

import java.util.HashMap;

public class asmBuilder implements IRPass {
    public module top;
    public asmModule topModule;
    public asmFunc curFunc;
    public Block curBlock;
    public phyReg a0, sp, s0, s1, ra;
    public imm imm_zero = new imm(0);
    public HashMap<entity, asmReg> regMap = new HashMap<>();
    public HashMap<String, Block> blkMap = new HashMap<>();
    public asmBuilder() {
        topModule = new asmModule();
        a0 = topModule.regs.get(10);
        ra = topModule.regs.get(1);
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

    private boolean isImm(long x) {return x >= -2048 && x <= 2047;}

    public asmReg getReg(entity x) {
        if(x instanceof literalStr t) {
            virtualReg r = new virtualReg(curFunc.getVir());
            curBlock.addInst(new laInst(r, t.asm_name()));
            return r;
        } else if(x instanceof literal t) {
            long val = t.retVal();
            virtualReg r = new virtualReg(curFunc.getVir());
            curBlock.addInst(new liInst(r, new imm(val)));
            return r;
        } else if(x instanceof globalVar t) {
            virtualReg r = new virtualReg(curFunc.getVir());
            curBlock.addInst(new laInst(r, "glo_" + t.name));
            return r;
        } else {
            return regMap.get(x);
        }
    }

    public Block getASMBlock(String x) {
        if(!blkMap.containsKey(x)) {
            Block blk = new Block("__LBB" + curFunc.fun_id + "_");
            blkMap.put(x, blk);
        }
        return blkMap.get(x);
    }

    public void visitStrLiteral(literalStr str) {
        topModule.rodata.addData(new globalData(str.asm_name(), str.val));
    }

    public void visitGlobalVar(globalVar gvar) {
        if(gvar.val == null) {
            topModule.data.addData(new globalData(gvar.asm_name(), 0, true));
        } else if(gvar.val instanceof literalInt) {
            topModule.data.addData(new globalData(gvar.asm_name(), (int) ((literal) gvar.val).retVal(), true));
        } else {
            topModule.data.addData(new globalData(gvar.asm_name(), ((literalStr) gvar.val).asm_name(), true));
        }
//        topModule.data.addData(new globalData(gvar.asm_name(), (int) (gvar.val != null ? ((literal) gvar.val).retVal() : 0L), true));
    }

    @Override public void visit(IRFunc fun) {
        if(fun.declare)  return;
        asmFunc f = new asmFunc(fun.name);
        f.addLocalVar(ra);
        f.addLocalVar(s0);
        topModule.text.addFunc(f);
        curFunc = f;
        curBlock = curFunc.entry;
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
            curBlock.addInst(new loadInst(4, reg, s0, new imm(bytes)));
            regMap.put(p, reg);
            bytes += 4;
        }
        blkMap = new HashMap<>();
        blkMap.put(fun.suite.get(0).L.get_name(), f.st.get(0));
        for(int i = 1; i < fun.suite.size(); ++i) {
            Block blk = getASMBlock(fun.suite.get(i).L.get_name());
            curFunc.addBlock(blk);
        }
        //blkMap.put(fun.suite.get())
        fun.suite.forEach(blk -> blk.accept(this));
    }

    @Override public void visit(IRClass cl) {}

    @Override public void visit(block bl) {
        curBlock = blkMap.get(bl.L.get_name());
        bl.stats.forEach(s -> s.accept(this));
    }

    private void SBinary(entity ls, entity rs, binaryInst.binaryType op, virtualReg res) {
        if((ls instanceof literal t) && isImm(t.retVal())) {
            binaryInst ins = new binaryInst(res, getReg(rs), new imm(t.retVal()), op);
            ins.imm = true;
            curBlock.addInst(ins);
        } else {
            binaryInst ins;
            if((rs instanceof literal t) && isImm(t.retVal())) {
                ins = new binaryInst(res, getReg(ls), new imm(t.retVal()), op);
                ins.imm = true;
            } else {
                ins = new binaryInst(res, getReg(ls), getReg(rs), op);
            }
            curBlock.addInst(ins);
        }
    }

    private void UBinary(entity ls, entity rs, binaryInst.binaryType op, virtualReg res) {
        if((rs instanceof literal t) && isImm(t.retVal())) {
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
            case SUB -> {
                if((x.rs instanceof literal t) && isImm(-t.retVal())) {
                    binaryInst ins = new binaryInst(res, getReg(x.ls), new imm(-t.retVal()), binaryInst.binaryType.ADD);
                    ins.imm = true;
                    curBlock.addInst(ins);
                } else {
                    curBlock.addInst(new binaryInst(res, getReg(x.ls), getReg(x.rs), binaryInst.binaryType.SUB));
                }
            }
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
        if(isNot) tmp = new virtualReg(curFunc.getVir());
        else tmp = res;
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
        virtualReg rg = new virtualReg(curFunc.getVir());
        regMap.put(x.e, rg);
        curFunc.addLocalVar(rg);
    }

    @Override public void visit(load x) {
        virtualReg res = new virtualReg(curFunc.getVir());
        if(x.ptr instanceof globalVar) {
            asmReg rs = getReg(x.ptr);
            curBlock.addInst(new loadInst(4, res, rs, imm_zero));
//            curBlock.addInst(new loadInst(4, res, t.asm_name()));
        } else {
            asmReg rs = getReg(x.ptr);
            if(curFunc.inStack(rs)) {
                curBlock.addInst(new mvInst(res, rs));
            } else {
                curBlock.addInst(new loadInst(4, res, rs, imm_zero));
            }

        }
        regMap.put(x.val, res);
    }
    @Override public void visit(store x) {
        if(x.ptr instanceof globalVar) {
            asmReg rs = getReg(x.ptr), val = getReg(x.val);
            curBlock.addInst(new storeInst(4, val, rs, imm_zero));
//            curBlock.addInst(new storeInst(4, getReg(x.val), t.asm_name()));
        } else {
            asmReg rs = getReg(x.ptr), val = getReg(x.val);
            if(curFunc.inStack(rs)) {
                curBlock.addInst(new mvInst(rs, val));
            } else {
                curBlock.addInst(new storeInst(4, val, rs, imm_zero));
            }
        }
    }
    @Override public void visit(br x) {
        if(x.isCond()) {
            Block blk1 = getASMBlock(x.label1.get_name());
            Block blk2 = getASMBlock(x.label2.get_name());
            if(x.isNeq()) {
                brInst branch = new brInst(getReg(x.condRes), brInst.brType.BNE, blk1.getName());
                curBlock.addInst(branch);
                blk1.addPreBlock(curBlock, branch);
                jInst jump = new jInst(blk2.getName());
                curBlock.addInst(jump);
                blk2.addPreBlock(curBlock, jump);
            } else {
                brInst branch = new brInst(getReg(x.condRes), brInst.brType.BEQ, blk2.getName());
                curBlock.addInst(branch);
                blk2.addPreBlock(curBlock, branch);
                jInst jump = new jInst(blk1.getName());
                curBlock.addInst(jump);
                blk1.addPreBlock(curBlock, jump);
            }
        } else {
            Block blk = getASMBlock(x.label1.get_name());
            jInst jump = new jInst(blk.getName());
            curBlock.addInst(jump);
            blk.addPreBlock(curBlock, jump);
        }
    }
    @Override public void visit(ret x) {
        if(x.retEntity != null) {
            curBlock.addInst(new mvInst(a0, getReg(x.retEntity)));
        }
        curBlock.addInst(new retInst());
    }

    @Override public void visit(call x) {
        int bytes = 0;
        for(int i = 0; i < Math.min(x.para.size(), 8); ++i) {
            entity val = x.para.get(i);
            if(val instanceof literalStr t) {
                curBlock.addInst(new laInst(topModule.regs.get(10 + i), t.asm_name()));
            } else if(val instanceof literal t) {
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

    public asmReg getPhiReg(entity x, Block pre, inst lst) {
        if(x instanceof literalStr t) {
            virtualReg r = new virtualReg(curFunc.getVir());
            pre.addPrev(lst, new laInst(r, t.asm_name()));
            return r;
        } else if(x instanceof literal t) {
            long val = t.retVal();
            virtualReg r = new virtualReg(curFunc.getVir());
            pre.addPrev(lst, new liInst(r, new imm(val)));
            return r;
        } else if(x instanceof globalVar t) {
            virtualReg r = new virtualReg(curFunc.getVir());
            pre.addPrev(lst, new laInst(r, "glo_" + t.name));
            return r;
        } else {
            return regMap.get(x);
        }
    }

    @Override public void visit(phi x) {
        int n = x.lb.size();
        virtualReg cur = new virtualReg(curFunc.getVir());
        for(int i = 0; i < n; ++i) {
            Block pre = getASMBlock(x.lb.get(i).get_name());
            inst lst = curBlock.preInst.get(pre);
            pre.addPrev(lst, new mvInst(cur, getPhiReg(x.val.get(i), pre, lst)));
        }
        regMap.put(x.res, cur);
    }

    @Override public void visit(getelementptr x) {
        virtualReg res = new virtualReg(curFunc.getVir());
        if(x.idx.size() == 1) {
            entity id = x.idx.get(0);
            virtualReg p = new virtualReg(curFunc.getVir());
            if((id instanceof literal t) && isImm(t.retVal())) {
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
                operand Pos = isImm(pos) ? new imm(pos) : new virtualReg(curFunc.getVir());
                if(!isImm(pos)) curBlock.addInst(new liInst(Pos, new imm(pos)));
                binaryInst b = new binaryInst(res, getReg(x.p), Pos, binaryInst.binaryType.ADD);
                b.imm = true;
                curBlock.addInst(b);
                regMap.put(x.res, res);
            } else {
                regMap.put(x.res, getReg(x.p));
            }

        }

    }

    @Override public void visit(convert x) {
        asmReg t = getReg(x.val);
        regMap.put(x.res, t);
    }
}
