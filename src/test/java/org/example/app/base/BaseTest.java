package org.example.app.base;

import io.restassured.RestAssured;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 2/19/2024
 * 3:16 PM
 */
public class BaseTest {
    static Properties properties =new Properties();
    static FileInputStream fileInputStream;
    public static String clientId;
    public static String clientSecret;

    public static void init() throws IOException {
        fileInputStream=new FileInputStream("src/test/resources/properties/application.properties");
        properties.load(fileInputStream);
        RestAssured.baseURI=properties.getProperty("baseURL");
        clientId= properties.getProperty("client_id" );
        clientSecret= properties.getProperty("client_secret" );


    }

}
