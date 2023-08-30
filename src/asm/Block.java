package asm;

import IR.IRPass;

import java.util.HashMap;

public class Block {
    public String name;
    static int block_cnt = 0;
    public boolean istop;
    int id;
    public HashMap<Block, inst> preInst = new HashMap<>();
    public inst head = null, last = null;

    public Block(String name) {
        id = ++block_cnt;
        this.name = name + id;
    }

    public Block(String name, boolean bo) {
        this.name = name;
        istop = bo;
    }

    public void addInst(inst i) {
        if(head == null) {
            head = last = i;
        } else {
            last.next = i;
            i.prev = last;
            last = i;
        }
    }

    public void addPrev(inst i, inst j) {
        if(i.prev == null) {
            i.prev = j; j.next = i;
            head = j;
        } else {
            i.prev.next = j; j.prev = i.prev;
            i.prev = j; j.next = i;
        }
    }

    public void addNext(inst i, inst j) {
        if(i.next == null) {
            i.next = j; j.prev = i;
            last = j;
        } else {
            i.next.prev = j; j.next = i.next;
            i.next = j; j.prev = i;
        }
    }

    @Override
    public String toString() {
        if(istop) return name + ":";
        else return "." + name + ":";
    }

    public void addPreBlock(Block blk, inst j) {
        preInst.put(blk, j);
    }

    public void addTop(inst i) {
        if(head == null) {
            head = last = i;
        } else {
            head.prev = i;
            i.next = head;
            head = i;
        }
    }

    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
