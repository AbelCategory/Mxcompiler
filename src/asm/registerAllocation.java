package asm;

public class registerAllocation implements asmPass {
    public phyReg[] T = new phyReg[7];
    public phyReg s0, sp, t0, t1, t2, ra;
    public imm imm_zero = new imm(0);
    public asmFunc curFun;
    public Block curBlock;
    public int idx = 0;

    public registerAllocation(asmModule topMod) {
        t0 = T[0] = topMod.regs.get(5);
        t1 = T[1] = topMod.regs.get(6);
        t2 = T[2] = topMod.regs.get(7);
        T[3] = topMod.regs.get(28);
        T[4] = topMod.regs.get(29);
        T[5] = topMod.regs.get(30);
        T[6] = topMod.regs.get(31);
        s0 = topMod.regs.get(8);
        ra = topMod.regs.get(1);
        sp = topMod.regs.get(2);
    }

    private boolean isImm(long x) {return x >= -2048 && x <= 2047;}

    public asmReg Load(asmReg r, inst s) {
        if(r instanceof phyReg) return r;
        asmReg t = T[(idx++) % 6 + 1];
        virtualReg u = (virtualReg) r;
        int pos = curFun.stackPos(u);
        imm p = new imm(pos);
        if(!isImm(pos)) {
            asmReg t3 = T[0];
            curBlock.addPrev(s, new liInst(t3, p));
            curBlock.addPrev(s, new binaryInst(t3, t3, s0, binaryInst.binaryType.ADD));
            curBlock.addPrev(s, new loadInst(4, t, u, imm_zero));
        } else {
            curBlock.addPrev(s, new loadInst(4, t, u, p));
        }
        return t;
    }

    public asmReg Store(asmReg r, inst s) {
        if(r instanceof phyReg) return r;
        asmReg t = T[(idx++) % 6 + 1];
        virtualReg u = (virtualReg) r;
        int pos = curFun.stackPos(u);
        imm p = new imm(pos);
        if(!isImm(pos)) {
            asmReg t3 = T[0];
            curBlock.addNext(s, new storeInst(4, t, u, imm_zero));
            curBlock.addNext(s, new binaryInst(t3, t3, s0, binaryInst.binaryType.ADD));
            curBlock.addNext(s, new liInst(t3, p));
        } else {
            curBlock.addNext(s, new storeInst(4, t, u, p));
        }
        return t;
    }

    @Override
    public void visit(asmModule topMod) {
        visit(topMod.text);
    }

    @Override
    public void visit(asmFunc fun) {
        curFun = fun;
        fun.st.forEach(this::visit);

        int siz = (fun.bytes + fun.maxCall + 15) / 16 * 16;
        Block entry = fun.entry;
        Block ret = fun.entry;
        inst lst = ret.last;
        if(siz < 2048) {
            entry.addTop(new binaryInst(s0, sp, new imm(siz), binaryInst.binaryType.ADD));
            entry.addTop(new storeInst(4, s0, sp, new imm(siz - 8)));
            entry.addTop(new storeInst(4, ra, sp, new imm(siz - 4)));
            entry.addTop(new binaryInst(sp, sp, new imm(-siz), binaryInst.binaryType.ADD));

            ret.addPrev(lst, new loadInst(4, s0, sp, new imm(siz - 8)));
            ret.addPrev(lst, new loadInst(4, ra, sp, new imm(siz - 4)));
            ret.addPrev(lst, new binaryInst(sp, sp, new imm(siz), binaryInst.binaryType.ADD));
        } else {
            entry.addTop(new binaryInst(s0, sp, t0, binaryInst.binaryType.ADD));
            entry.addTop(new storeInst(4, s0, t1, new imm(-8)));
            entry.addTop(new storeInst(4, ra, t1, new imm(-4)));
            entry.addTop(new binaryInst(t1, sp, t0, binaryInst.binaryType.ADD));
            entry.addTop(new binaryInst(sp, sp, t0, binaryInst.binaryType.SUB));
            entry.addTop(new liInst(t0, new imm(siz)));

            ret.addPrev(lst, new liInst(t0, new imm(siz)));
            ret.addPrev(lst, new binaryInst(t1, sp, t0, binaryInst.binaryType.ADD));
            ret.addPrev(lst, new loadInst(4, s0, t1, new imm(-8)));
            ret.addPrev(lst, new loadInst(4, ra, t1, new imm(-4)));
            ret.addPrev(lst, new binaryInst(sp, sp, t0, binaryInst.binaryType.ADD));

        }
    }

    @Override
    public void visit(Block blk) {
        curBlock = blk;
        for(var it = blk.head; it != null; it = it.next) {
            it.accept(this);
        }
    }

    @Override
    public void visit(section sec) {
        sec.funcs.forEach(this::visit);
    }
    @Override public void visit(globalData data) {}

    @Override public void visit(brInst br) {
        if(br.rs1 instanceof virtualReg rs1) br.rs1 = Load(rs1, br);
        if(br.rs2 instanceof virtualReg rs2) br.rs2 = Load(rs2, br);
    }

    @Override public void visit(binaryInst bin) {
        if(bin.rs1 instanceof virtualReg rs1) bin.rs1 = Load(rs1, bin);
        if(!bin.imm && bin.rs2 instanceof virtualReg rs2) bin.rs2 = Load(rs2, bin);
        if(bin.rd instanceof virtualReg rd) bin.rd = Store(rd, bin);
    }

    @Override public void visit(callInst call) {}

    @Override public void visit(cmpInst cmp) {
        if(cmp.rs1 instanceof virtualReg rs1) cmp.rs1 = Load(rs1, cmp);
        if(!cmp.isZ && (cmp.rs2 instanceof virtualReg rs2)) cmp.rs2 = Load(rs2, cmp);
        if(cmp.rd instanceof virtualReg rd) cmp.rd = Store(rd, cmp);
    }

    @Override public void visit(jInst j) {}

    @Override public void visit(laInst la) {
        if(la.rd instanceof virtualReg rd) la.rd = Store(rd, la);
    }

    @Override public void visit(liInst li) {
        if(li.rd instanceof virtualReg) li.rd = Store((virtualReg) li.rd, li);
    }

    @Override public void visit(loadInst load) {
        if(!load.isSymbol) {
            if(load.rs instanceof virtualReg) load.rs = Load((virtualReg) load.rs, load);
            if(load.rd instanceof virtualReg) load.rd = Store((virtualReg) load.rd, load);
        }
    }

    @Override public void visit(mvInst mv) {
        if(mv.rs instanceof virtualReg) mv.rs = Load((virtualReg) mv.rs, mv);
        if(mv.rd instanceof virtualReg) mv.rd = Store((virtualReg) mv.rd, mv);
    }

    @Override public void visit(storeInst store) {
        if(store.isSymbol) {
            if(store.rs1 instanceof virtualReg) store.rs1 = Load((virtualReg) store.rs1, store);
            if(store.rs2 instanceof virtualReg) store.rs2 = Load((virtualReg) store.rs2, store);
        }
    }

    @Override public void visit(retInst retInst) {}
}
