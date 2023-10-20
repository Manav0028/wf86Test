package com.manavs.wf86test.model;

import java.util.List;

/**
 * @project: wf86Test
 * @author: manavsharma
 * @date: 19/10/2023
 **/
public class IfObject {
    private List<IfCondition> conditions;
    private IfObject ifObject;
    private List<IfObject> elseObjects;
    // assuming request will have true or false
    private boolean thenObject;

    public List<IfCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<IfCondition> conditions) {
        this.conditions = conditions;
    }

    public IfObject getIfObject() {
        return ifObject;
    }

    public void setIfObject(IfObject ifObject) {
        this.ifObject = ifObject;
    }

    public List<IfObject> getElseObjects() {
        return elseObjects;
    }

    public void setElseObjects(List<IfObject> elseObjects) {
        this.elseObjects = elseObjects;
    }

    public boolean isThenObject() {
        return thenObject;
    }

    public void setThenObject(boolean thenObject) {
        this.thenObject = thenObject;
    }
}
