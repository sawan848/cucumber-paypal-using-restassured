package org.example.app.util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.example.app.endpoints.Routes;
import org.example.app.payload.Orders;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.codehaus.groovy.runtime.InvokerHelper.asList;

/**
 * 1/19/2024
 * 10:24 AM
 */
public class RestAssuredExtension {
    private static RequestSpecification request;
    static String clientId;
    static String clientSecret;

    static String baseURL;
    static {

        baseURL = ConfigReader.getReaderInstance( ).init_properties( ).getProperty("baseURL");
        clientId = ConfigReader.getReaderInstance( ).init_properties( ).getProperty("client_id");
        clientSecret = ConfigReader.getReaderInstance( ).init_properties( ).getProperty("client_secret");

    }

    public RestAssuredExtension() {
        RequestSpecBuilder builder=new RequestSpecBuilder();
        builder.setBaseUri(baseURL);
        builder.setContentType(ContentType.JSON);


        var specification = builder.build( );

        request=given().spec(specification);


    }


    public  ResponseOptions<Response>createOrder(Orders order,String accessToken){
        return request.
            auth().oauth2(accessToken).
            body( order ).
            post( "/v2/checkout/orders" );

    }


    public   ResponseOptions<Response>getAccessToken(){


         return request.
                param("grant_type","client_credentials").
                auth().preemptive().
                basic(clientId,clientSecret).
                post( "/v1/oauth2/token" );
    }

}