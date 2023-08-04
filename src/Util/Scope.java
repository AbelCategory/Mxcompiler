package Util;

import java.util.HashMap;
import Error.semanticError;

public class Scope {
    private HashMap<String, Type> members;
    private Scope parentScope;

    public Type funcReturnType, thisClassType;
    public boolean isClass = false;
    public boolean isLoop = false, isFunc = false;
    public Scope(Scope parent) {
        members = new HashMap<>();
        parentScope = parent;
        if(parent != null) {
            isLoop = parent.isLoop;
            isFunc = parent.isFunc;
            funcReturnType = parent.funcReturnType;
            isClass = parent.isClass;
            thisClassType = parent.thisClassType;
        }
    }

    public Scope getParentScope() {
        return parentScope;
    }

    public void newVariable(String id, Type t, position p) {
        if(members.containsKey(id)) {
            throw new semanticError("multi definition of variable" + id, p);
        }
        members.put(id, t);
    }

    public boolean variableDefined(String id) {
        if(members.containsKey(id))
            return true;
        else if(parentScope != null)
            return parentScope.variableDefined(id);
        else return false;
    }

    public Type getVarType(String id, position p) {
        if(members.containsKey(id)) {
            return members.get(id);
        }
        if(parentScope != null) {
            return parentScope.getVarType(id, p);
        } else {
            throw new semanticError("not defined variable: " + id, p);
        }
    }

    public Type getFuncReturnType() {
        return funcReturnType;
    }

    public Type getThisClassType() {return thisClassType;}

    public boolean isInLoop() {return isLoop;}

    public boolean isInFunc() {return isFunc;}

    public boolean isInClass() {return isClass;}
}