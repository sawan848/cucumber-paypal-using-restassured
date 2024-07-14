package org.example.app.hooks;

import io.restassured.response.Response;
import org.example.app.payload.ResponsePayload;

import java.util.HashMap;
import java.util.Map;

/**
 * 1/15/2024
 * 10:51 AM
 */
public class ScnContext {


    private Map<String,String> SCN_DATA  = new HashMap<>();
    private ResponsePayload responseData;
    private Response _RESP;

    public ResponsePayload getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponsePayload responseData) {
        this.responseData = responseData;
    }

    public Response get_RESP() {
        return _RESP;
    }

    public void set_RESP(Response _RESP) {
        this._RESP = _RESP;
    }

    public void SetScnData(String key,String value) {
        SCN_DATA.put(key, value);
    }

    public String GetScnData(String key) {
        return SCN_DATA.get(key);
    }
}
