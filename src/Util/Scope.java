package Util;

import java.util.HashMap;
import Error.semanticError;

public class Scope {
    private HashMap<String, Type> members;
    private Scope parentScope;
    boolean isLoop = false, isFunc = false;
    public Scope(Scope parent) {
        members = new HashMap<>();
        parentScope = parent;
        if(parent != null) {
            isLoop = parent.isLoop;
            isFunc = parent.isFunc;
        }
    }

    public Scope getParentScope() {
        return parentScope;
    }

    public void newVariable(String id, Type t, position p) {
        if(members.containsValue(id)) {
            throw new semanticError("multi definition of variable" + id, p);
        }
        members.put(id, t);
    }

    public boolean variableDefined(String id) {
        if(members.containsValue(id))
            return true;
        else if(parentScope != null)
            return parentScope.variableDefined(id);
        else return false;
    }

    public Type getType(String id, position p) {
        if(members.containsValue(id)) {
            return members.get(id);
        }
        if(parentScope != null) {
            return parentScope.getType(id, p);
        } else {
            throw new semanticError("not defined variable: " + id, p);
        }
    }

    public boolean isInLoop() {return isLoop;}

    public boolean isInFunc() {return isFunc;}
}