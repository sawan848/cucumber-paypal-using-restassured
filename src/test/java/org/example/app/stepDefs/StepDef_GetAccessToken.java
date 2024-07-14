package org.example.app.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.example.app.endpoints.Routes;
import org.example.app.hooks.ResponseContext;
import org.example.app.hooks.ScnContext;
import org.example.app.payload.ResponsePayload;
import org.example.app.util.RestAssuredExtension;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

/**
 * 2/19/2024
 * 3:38 PM
 */
public class StepDef_GetAccessToken {

    private final ResponseContext context;
    private final RestAssuredExtension extension;
    ResponseOptions<Response> response;



    public StepDef_GetAccessToken(ResponseContext context,RestAssuredExtension extension) {
        this.context = context;
        this.extension=extension;
    }

    @Given("I want to get access token from PayPal api")
    public void iWantToGetAccessTokenFromPayPalApi() {
//        context.setRequestSpecification(
//                given().baseUri("https://api-m.sandbox.paypal.com/")

//        );
//        context.getResponse( ).getBody().prettyPrint();
         response = extension.getAccessToken();
        System.out.println(context.getResponse() );
        context.getScenario().log("Api base uri: "+"https://api-m.sandbox.paypal.com/");
    }

//    @Then("I have PayPal {string} and {string}")
    @Then("I have PayPal client id and client secret")
    public void iHavePayPalAnd() {
//        response = extension.getAccessToken();
       context.setResponse(response);
//               then().log().everything();
    }

    @Then("I should receive a response with status code {int}")
    public void iShouldReceiveAResponseWithStatusCode(Integer statusCode) {
        assertEquals(200,context.getResponse().getStatusCode() );
        System.out.println( context.getResponse().getStatusCode());
    }
    @Then("the response should contain an access token")
    public void theResponseShouldContainAnAccessToken() {
//        ResponsePayload  responsePayload= context.getResponse( ).getBody().jsonPath( ).getObject("", ResponsePayload.class);
////
//        ScnContext scnContext=new ScnContext();
//        scnContext.setResponseData(responsePayload);
//        context.setScnContext(scnContext);

    }






}
