package com.manavs.wf86test.model;

import java.util.HashMap;

/**
 * @project: wf86Test
 * @author: manavsharma
 * @date: 19/10/2023
 **/
public class QueryRequest {
    private IfObject query;
    private HashMap<String, Object> queryInputs;

    public IfObject getQuery() {
        return query;
    }

    public void setQuery(IfObject query) {
        this.query = query;
    }

    public HashMap<String, Object> getQueryInputs() {
        return queryInputs;
    }

    public void setQueryInputs(HashMap<String, Object> queryInputs) {
        this.queryInputs = queryInputs;
    }
}
