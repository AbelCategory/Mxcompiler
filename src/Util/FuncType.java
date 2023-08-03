package Util;

import java.util.ArrayList;

public class FuncType {
    public Type returnType;
    public String name;
    public ArrayList<Type> paraType;
    public FuncType(String s, Type returnType) {
        this.returnType = returnType;
        name = s;
        paraType = new ArrayList<>();
    }

    public boolean equal(Object b) {
        if(!b.getClass().equals(FuncType.class)){
            return false;
        }
        FuncType B = (FuncType) b;
        if(!B.returnType.equal(returnType)) {
            return false;
        }
        if(B.paraType.size() != paraType.size()) {
            return false;
        }
        int n = paraType.size();
        for(int i = 0; i < n; ++i)
            if(!paraType.get(i).equal(B.paraType.get(i))) {
                return false;
            }
        return true;
    }

    public String toString() {
        StringBuilder s = new StringBuilder(returnType.toString() + "(");
        if(!paraType.isEmpty()) {
            s.append(paraType.get(0));
            int n = paraType.size();
            for(int i = 1; i < n; ++i) {
                s.append(",").append(paraType.get(i));
            }
        }
        s.append(")");
        return s.toString();
    }
}
