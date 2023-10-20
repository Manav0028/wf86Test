# Read Me
###### Application uses **Java 17 SDK**

## How to run
1. Pull and Build the project.
2. Run the Wf86TestApplication, by default it will run on port 8080.
3. There is one only API to hit. Use Postman to hit the API with following properties:
    1. Set the method to POST.
    2. Fill the address bar with this address: localhost:8080/api/query
    3. Add the JSON request body from the shared examples.
    4. Click Send.
4. Check the response in Postman.

## Deliverables
1. JSON formatted if-statements query are attached in the zip file. These queries can also be used as input in the request.
2. 3 Examples are also included in the report with different conditions and variable values.
3. example1.json is the conversion of given example in test.
4. There is only POST API available, which will process the query and its inputs.

    localhost:8080/api/query

## Design Process 
1. Query Controller is the main controller class which will receive the POST API request.
2. QueryRequest has two objects
   1. Query, for evaluation.
   2. Map of variable values(userInputs) for the query.
3. Query consists of IfObjects and each object have the followings:
   1. List of conditions in that if block.
   2. Another IfObject for nested if block.
   3. List IfObjects for else and else if (nested) blocks.
   4. One boolean thenObject.
4. Controller calls the Service class "QueryService", which processes the query and query inputs.
5. After processing, it will return the QueryResponse objects with the result and query.
6. As JSON is converted into the query objects, it can be converted to any other form as required.


Example:
<img width="865" alt="Screenshot 2023-10-20 at 2 48 03 pm" src="https://github.com/Manav0028/wf86Test/assets/12201377/aa041e0a-8fb0-464e-9ec8-c9b648261381">


### Note:
###### Variable names defined in query object conditions should match with UserInputs variables. The values are mapped with the variable names.
###### Example: see variable b, variable used in condition should be same in queryInputs. In this case its value is 12.
"conditions":
...
{
    "variable": **"b"**,
    "expectedValue": 14,
    "operator": ">"
}
...

"queryInputs": {
**"b"**: 12 
}
