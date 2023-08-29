package asm;

import java.util.ArrayList;
import java.util.HashMap;

public class asmFunc {
    public int maxCall = 0, vir = 0, bytes = 0, fun_id;
    static int fun_cnt = 0;
    public String name;
    public Block entry;
    public ArrayList<Block> st = new ArrayList<>();
    public HashMap<asmReg, Integer> stack = new HashMap<>();

    public asmFunc(String name) {
        this.name = name;
        st.add(entry = new Block(name, true));
        fun_id = fun_cnt++;
//        addLocalVar();
    }

    public void addBlock(Block b) {
        st.add(b);
    }

    public int getVir() {return vir++;}

    public boolean inStack(asmReg x) {return stack.containsKey(x);}

    public int stackPos(asmReg x) {
        if(!inStack(x))  addLocalVar(x);
        return stack.get(x);
    }

    @Override
    public String toString() {
        return "\t.globl\t" + name + "\n\t.type\t" + name + ", " + "@function";
    }

    public String endString() {
        return ".Lfunc_end" + fun_id + ":\n" + "\t.size\t" + name + ", .Lfunc_end" + fun_id + "-" + name;
    }

    public void addLocalVar(asmReg rg) {
        stack.put(rg, bytes);
        bytes += 4;
    }

    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
