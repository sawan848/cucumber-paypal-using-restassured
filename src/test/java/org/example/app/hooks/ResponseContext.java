package org.example.app.hooks;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

/**
 * 1/15/2024
 * 2:35 PM
 */
public class ResponseContext {
    private ScnContext scnContext;
    private RequestSpecification requestSpecification;
//    private Response response;
    private Scenario scenario;
    private  ResponseOptions<Response> response;

    public ScnContext getScnContext() {
        return scnContext;
    }

    public void setScnContext(ScnContext scnContext) {
        this.scnContext = scnContext;
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public void setRequestSpecification(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public ResponseOptions<Response>  getResponse() {
        return response;
    }

    public void setResponse( ResponseOptions<Response> response) {
        this.response = response;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }


}
