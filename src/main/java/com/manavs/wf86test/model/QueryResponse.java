package com.manavs.wf86test.model;

/**
 * @project: wf86Test
 * @author: manavsharma
 * @date: 20/10/2023
 **/
public class QueryResponse {
    private boolean result;
    private IfObject query;

    public QueryResponse() {
    }

    public QueryResponse(boolean result, IfObject query) {
        this.result = result;
        this.query = query;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public IfObject getQuery() {
        return query;
    }

    public void setQuery(IfObject query) {
        this.query = query;
    }
}
