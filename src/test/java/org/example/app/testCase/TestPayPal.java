package org.example.app.testCase;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.app.payload.Amount;
import org.example.app.payload.Orders;
import org.example.app.payload.PurchaseUnits;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

/**
 * 2/19/2024
 * 12:03 PM
 */
public class TestPayPal {

    static String access_token="";
    Properties properties;
    Response response;
    static String clientId="";
    static String clientSecret="";

    RequestSpecification request;


    @BeforeTest
    public void getProperties() throws IOException {

       FileInputStream stream= new FileInputStream("src/test/resources/properties/application.properties");
        properties=new Properties();
        properties.load(stream);
        TestPayPal.clientId = properties.getProperty("client_id");
        TestPayPal.clientSecret = properties.getProperty("client_secret");
        RestAssured.baseURI=properties.getProperty("baseURL");

        RequestSpecBuilder builder=new RequestSpecBuilder();
        builder.setBaseUri(properties.getProperty("baseURL"));
        builder.setContentType(ContentType.JSON);


        var specification = builder.build( );

        request=given().spec(specification);
    }


    @Test(priority = 1)
    public void getAuthKeyUsingRequestSpecification(){

        request.

                param("grant_type","client_credentials").
                auth().preemptive().
                basic(clientId,clientSecret).
                post( "/v1/oauth2/token" ).
                then().log().everything();


    }

    @Test(priority = 1)
    public void getAuthKey(){


        response=given().
                param("grant_type","client_credentials").
                auth().preemptive().
                basic(clientId,clientSecret).
                post( "/v1/oauth2/token" );
        TestPayPal.access_token=response.jsonPath().get( "access_token" ).toString();

        assert 200==response.getStatusCode();

    }
    @Test(priority = 2,dependsOnMethods = {"getAuthKey"})
    public void test_createOrder(){
//        RestAssured.baseURI="https://api-m.sandbox.paypal.com/";
        String payload= """
                {
                  "intent": "CAPTURE",
                  "purchase_units": [
                    {
                      "reference_id": "d9f80740-38f0-11e8-b467-0ed5f89f718b",
                      "amount": {
                        "currency_code": "USD",
                        "value": "100.00"
                      }
                    }
                  ]
               
                }
                """;
        ArrayList<PurchaseUnits>purchase_units=new ArrayList<>();
        purchase_units.add(new PurchaseUnits("d9f80740-38f0-11e8-b467-0ed5f89f718b" ,new Amount("USD","100.00")));
        Orders orders=new Orders("CAPTURE",purchase_units);

        response=given().contentType(ContentType.JSON).
                auth().oauth2(access_token).
                body(orders).
                post( "v2/checkout/orders" );


        assertEquals("CREATED",response.jsonPath().get( "status" ).toString());
    }

    @Test(priority = 2,dependsOnMethods = {"getAuthKey","test_createOrder"})
    public void getOrder(){

        String orderId=response.jsonPath().get( "id" ).toString();

        response=given().contentType(ContentType.JSON).
                auth().oauth2(access_token).
                get( "v2/checkout/orders/"+orderId );


        assert 200==response.getStatusCode();


    }




}
