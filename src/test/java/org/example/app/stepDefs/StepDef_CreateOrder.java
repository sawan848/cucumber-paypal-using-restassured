package org.example.app.stepDefs;

import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.example.app.endpoints.Routes;
import org.example.app.hooks.ResponseContext;
import org.example.app.payload.Amount;
import org.example.app.payload.Orders;
import org.example.app.payload.PurchaseUnits;
import org.example.app.util.RestAssuredExtension;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

/**
 * 2/20/2024
 * 11:06 AM
 */
public class StepDef_CreateOrder {

    private final ResponseContext context;
    private final RestAssuredExtension extension;

    public StepDef_CreateOrder(ResponseContext context,RestAssuredExtension extension) {
        this.context = context;
        this.extension=extension;
        System.out.println(extension==null );

    }


    @When("I set reference id {string} and currency code as  {string} and value as {string}")
    public void iSetReferenceIdAndCurrencyCodeAsAndValueAs(String reference_id,String currencyCode, String currencyValue) {
        System.out.println(extension==null );
        ArrayList<PurchaseUnits> purchase_units=new ArrayList<>();
        purchase_units.add(new PurchaseUnits(
                reference_id ,new Amount(currencyCode,currencyValue)));

        Orders orders=new Orders("CAPTURE",purchase_units);

        String accessToken = context.getScnContext().getResponseData().access_token();
        assert extension != null;
        int statusCode =  extension.createOrder(orders,accessToken).getStatusCode( );

       assertEquals(201, statusCode);


    }
    @When("I verify the status code {int}")
    public void iVerifyTheStatusAsCREATED(int status) {
//        System.out.println(context.getResponse( ).getBody().asPrettyString());
//        System.out.println(status+"" +context.getResponse().getStatusCode());
        assertEquals( status, context.getResponse( ).getStatusCode());

    }

}
