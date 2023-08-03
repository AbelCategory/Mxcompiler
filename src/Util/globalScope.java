package Util;

import java.util.HashMap;
import Error.semanticError;
import AST.typeNode;
import AST.typeArrayNode;

public class globalScope extends Scope{
    public HashMap<String, Type> types = new HashMap<>();
    public HashMap<String, FuncType> funcs = new HashMap<>();
    public globalScope(Scope parentScope) {
        super(parentScope);
    }
    public void newType(String type, Type t, position p) {
        if(types.containsValue(type)) {
            throw new semanticError("multiple definition of" + type, p);
        }
        types.put(type, t);
    }
    public Type getType(typeNode type, position p) {
        if(types.containsValue(type.type)) {
            if(type.isArray()){
                Type t = types.get(type.type);
                return new ArrayType(t, ((typeArrayNode) type).dim);
            } else {
                return types.get(type.type);
            }
        }
        throw new semanticError("no such type: " + type, p);
    }

    public void newFunc(String func, FuncType f, position p) {
        if(funcs.containsValue(func)) {
            throw new semanticError("multiple definition of" + func, p);
        }
        if(types.containsValue(func)) {
            throw new semanticError("function and class with same name: " + func, p);
        }
        funcs.put(func, f);
    }

    public FuncType getFunc(String func, position p) {
        if(funcs.containsValue(func)){
            return funcs.get(func);
        }
        throw new semanticError("no such function: " + func, p);
    }
}
