package com.manavs.wf86test.controller;

import com.manavs.wf86test.model.IfCondition;
import com.manavs.wf86test.model.IfObject;
import com.manavs.wf86test.model.QueryRequest;
import com.manavs.wf86test.model.QueryResponse;
import com.manavs.wf86test.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @project: wf86Test
 * @author: manavsharma
 * @date: 19/10/2023
 **/
@RestController
@RequestMapping("/api")
public class QueryController {

    @Autowired
    private QueryService queryServices;

    @PostMapping(value = "/query")
    public ResponseEntity<?> evaluateQuery(@RequestBody QueryRequest query) {
        // Evaluate the query
        boolean result = queryServices.resolveQuery(query.getQuery(), query.getQueryInputs());

        // returns the result of the query calculation and the received.
        // Query is converted into object after passing as JSON response.
        // We can use the objects to transform into any other form as required.
        return ResponseEntity.status(HttpStatus.OK).body(new QueryResponse(result, query.getQuery()));
    }
}
