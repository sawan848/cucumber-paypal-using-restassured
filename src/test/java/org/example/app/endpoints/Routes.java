package org.example.app.endpoints;

/**
 * 1/16/2024
 * 1:01 PM
 */

public enum Routes {
    BASE_URL("https://api-m.sandbox.paypal.com");


    private String url;

    public String getUrl() {
        return url;
    }

    Routes(String url){
        this.url=url;
    }
}
