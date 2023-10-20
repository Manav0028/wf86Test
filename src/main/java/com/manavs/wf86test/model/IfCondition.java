package com.manavs.wf86test.model;

/**
 * @project: wf86Test
 * @author: manavsharma
 * @date: 19/10/2023
 **/
public class IfCondition {
    // assuming variable name to be String always
    private String variable;
    // assuming variable value can be anything
    private Object expectedValue;
    // assuming operator to be retrieved in String format
    private String operator;
    // conditions join in single if block either "&&" or "||"
    private String joinCondition;

    // user variable value to check with
    // either use it in request or response for future.
    private Object userValue;

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public Object getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(Object expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getJoinCondition() {
        return joinCondition;
    }

    public void setJoinCondition(String joinCondition) {
        this.joinCondition = joinCondition;
    }

    public Object getUserValue() {
        return userValue;
    }

    public void setUserValue(Object userValue) {
        this.userValue = userValue;
    }

    @Override
    public String toString() {
        return "IfCondition{" +
                "variable='" + variable + '\'' +
                ", expectedValue=" + expectedValue +
                ", operator='" + operator + '\'' +
                ", joinCondition='" + joinCondition + '\'' +
                ", userValue=" + userValue +
                '}';
    }
}
