package asm;

import IR.IRPass;

public class globalData {
    public enum dataType {
        ASCIZ, WORD, BYTE
    }
    dataType t;
    String name;
    int int_val;
    String str_val, ptr_val;
    boolean is_glo = false, is_str, is_ptr = false;

    public globalData(String id, int val, boolean glo) {
        t = dataType.WORD;
        name = "glo_" + id;
        int_val = val;
        is_glo = glo;
        is_str = false;
    }

    public globalData(String id, String ptr, boolean glo) {
        t = dataType.WORD;
        name = "glo_" + id;
        ptr_val = ptr;
        is_glo = glo;
        is_str = false;
        is_ptr = true;
    }

    public globalData(String id, String val) {
        t = dataType.ASCIZ;
        name = id;
        str_val = val;
        is_str = true;
    }

    private int get_len(String s) {
        int len = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '\\') ++i;
            ++len;
        }
        return len + 1;
    }

    @Override
    public String toString() {
        String ret = (is_glo ? "\t.globl\t" + name : "") + "\n" + name + ":\n";
        if(is_ptr) {
            return ret + "\t." + t.toString().toLowerCase() + "\t" + ptr_val;
        } else if(!is_str) {
            return ret + "\t." + t.toString().toLowerCase() + "\t" + int_val;
        } else {
            String val = "\t." + t.toString().toLowerCase() + "\t\"" + str_val + "\"\n";
            return ret + val + "\t.size\t" + name + ", " + get_len(str_val);
        }
//        String ff = ret + "." + t.toString().toLowerCase() + "\n";
    }

    public void accept(asmPass pass) {
        pass.visit(this);
    }
}
