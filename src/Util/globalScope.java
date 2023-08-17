package Util;

import java.util.HashMap;
import Error.semanticError;
import AST.typeNode;
import AST.typeArrayNode;
import IR.IRClass;
import IR.IRType;

public class globalScope extends Scope{
    public HashMap<String, Type> types = new HashMap<>();
    public HashMap<String, FuncType> funcs = new HashMap<>();
    public HashMap<String, Integer> index = new HashMap<>();
    public HashMap<String, IRType> irt = new HashMap<>();
    public HashMap<String, String> irf = new HashMap<>();
    public globalScope(Scope parentScope) {
        super(parentScope);
    }
    public void newType(String type, Type t, position p) {
        if(types.containsKey(type)) {
            throw new semanticError("multiple definition of class " + type, p);
        }
        types.put(type, t);
    }

    public Type getType(typeNode type, position p) {
        if(types.containsKey(type.type)) {
            if(type.isArray()){
                Type t = types.get(type.type);
                return new ArrayType(t, ((typeArrayNode) type).dim);
            } else {
                return types.get(type.type);
            }
        }
        throw new semanticError("no such type: " + type.type, p);
    }

    public void addClassVar(String s, int idx) {
        index.put(s, idx);
    }

    public int getVarIndex(String s) {
        return index.get(s);
    }

    public boolean typeDefined(String type) {
        return types.containsKey(type);
    }

    public boolean funcDefined(String func) {
        return funcs.containsKey(func);
    }

    public Type getType_(String type, position p) {
        if(types.containsKey(type)) {
            return types.get(type);
        }
        throw new semanticError("no such type: " + type, p);
    }

    public void newFunc(String func, FuncType f, position p) {
        if(funcs.containsKey(func)) {
            throw new semanticError("multiple definition of function " + func, p);
        }
        funcs.put(func, f);
    }

    public FuncType getFunc(String func, position p) {
        if(funcs.containsKey(func)){
            return funcs.get(func);
        }
        throw new semanticError("no such function: " + func, p);
    }
}
