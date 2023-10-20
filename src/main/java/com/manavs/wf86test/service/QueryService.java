package com.manavs.wf86test.service;

import com.manavs.wf86test.model.IfCondition;
import com.manavs.wf86test.model.IfObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @project: wf86Test
 * @author: manavsharma
 * @date: 19/10/2023
 **/
@Service
public class QueryService {

    public boolean resolveQuery(IfObject query, HashMap<String, Object> queryInputs) {
        // just else block, returns the thenObject
        if (query.getConditions() == null && query.getIfObject() == null) {
            return query.isThenObject();
        }

        List<IfCondition> conditions = query.getConditions();
        try {
            // if or else's if block check
            if (conditions == null || evaluateExpression(conditions, queryInputs)) {
                if (query.getIfObject() == null)
                    return query.isThenObject();
                else
                    return resolveQuery(query.getIfObject(), queryInputs);
            }
            // multiple else block, containing if check within else
            else if (query.getElseObjects() != null) {
                // iterate until get a true result
                for (IfObject elseObj :
                        query.getElseObjects()) {
                    if (resolveQuery(elseObj, queryInputs))
                        return true;
                }
            } else
                // no other else block
                return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
        return false;
    }

    private boolean evaluateExpression(List<IfCondition> conditions, HashMap<String, Object> userInputs) throws Exception {
        // return false if conditions are null
        if (conditions == null)
            return false;

        boolean result = evaluateCondition(conditions.get(0), userInputs.get(conditions.get(0).getVariable()));

        // return result based on single condition if size is 1
        if (conditions.size() == 1) {
            return result;
        }

        String joinCondition = conditions.get(0).getJoinCondition();

        for (int i = 1; i < conditions.size(); i++) {
            IfCondition condition = conditions.get(i);
            System.out.println(condition);
            if (joinCondition != null && joinCondition.equals("&&"))
                result = result && evaluateCondition(condition, userInputs.get(condition.getVariable()));
            else if (joinCondition != null && joinCondition.equals("||"))
                result = result || evaluateCondition(condition, userInputs.get(condition.getVariable()));
            joinCondition = condition.getJoinCondition();
        }
        return result;
    }

    private boolean evaluateCondition(IfCondition condition, Object userInput) throws Exception {
        return switch (condition.getOperator()) {
            case "==" -> userInput.toString().equals(condition.getExpectedValue().toString());
            case "!=" -> !userInput.toString().equals(condition.getExpectedValue().toString());
            case "<=" -> ((Integer) userInput) <= ((Integer) condition.getExpectedValue());
            case "<" -> ((Integer) userInput) < ((Integer) condition.getExpectedValue());
            case ">=" -> ((Integer) userInput) >= ((Integer) condition.getExpectedValue());
            case ">" -> ((Integer) userInput) > ((Integer) condition.getExpectedValue());
            default -> throw new Exception("Invalid Operator to compare.");
        };
    }
}
