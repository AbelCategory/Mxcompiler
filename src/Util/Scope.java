package Util;

import java.util.HashMap;

public class Scope {
    private HashMap<String, Type> members;
    private Scope parentScope;
    public Scope(Scope parent) {
        members = new HashMap<>();
        parentScope = parent;
    }

    public Scope getParentScope() {
        return parentScope;
    }

    public void newVariable(String id, Type t) {
        if(members.containsValue(id))
            return;
        members.put(id, t);
    }

    public boolean variableDefined(String id) {
        if(members.containsValue(id))
            return true;
        else if(parentScope != null)
            return parentScope.variableDefined(id);
        else return false;
    }

    public Type getType(String id) {
        if(members.containsValue(id))
            return members.get(id);
        else if(parentScope != null)
            return parentScope.getType(id);
        else return null;
    }
}