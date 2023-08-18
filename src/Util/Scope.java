package Util;

import java.util.HashMap;

import IR.entity;
import IR.label;
import Error.semanticError;
import Error.internalError;

public class Scope {
    private HashMap<String, Type> members;
    private HashMap<String, entity> entities;

//    private HashSet<String> memberFun;
    private Scope parentScope;

    public Type funcReturnType, thisClassType;
    public boolean isClass = false;
    public boolean isLoop = false, isFunc = false;
    public label loopCond, loopEnd;
    public Scope(Scope parent) {
        members = new HashMap<>();
        entities = new HashMap<>();
//        memberFun = new HashSet<>();
        parentScope = parent;
        if(parent != null) {
            isLoop = parent.isLoop;
            isFunc = parent.isFunc;
            funcReturnType = parent.funcReturnType;
            isClass = parent.isClass;
            thisClassType = parent.thisClassType;
            loopCond = parent.loopCond;
            loopEnd = parent.loopEnd;
        }
    }

    public Scope getParentScope() {
        return parentScope;
    }

    public void newVariable(String id, Type t, position p) {
        if(members.containsKey(id)) {
            throw new semanticError("multi definition of variable: " + id, p);
        }
        members.put(id, t);
    }

//    public boolean isClassEntity(String id) {return entities.containsKey(id);}

    public void newVarEntity(String id, entity t) {
        if(entities.containsKey(id)) {
            throw new internalError("entity " + id + "redefined");
        }
        entities.put(id, t);
    }

    public entity getVarEntity(String id) {
        if(entities.containsKey(id)) {
            return entities.get(id);
        } else if(parentScope != null) {
            return parentScope.getVarEntity(id);
        } else {
            throw new internalError("not defined variable " + id);
        }
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