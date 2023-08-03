package Util;

import java.util.HashMap;

public class globalScope extends Scope{
    public HashMap<String, Type> types;
    public globalScope(Scope parentScope) {
        super(parentScope);
    }
    public void newType(String type, Type t) {
        if(types.containsValue(type))
            return;
        types.put(type, t);
    }
    public Type getType(String type) {
        if(types.containsValue(type))
            return types.get(type);
        return null;
    }
}
