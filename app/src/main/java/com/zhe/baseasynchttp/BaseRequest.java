package com.zhe.baseasynchttp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zhe on 2016/6/5.
 */
public class BaseRequest implements BlkeeListener{
    protected Throwable error;
    private int statusCode;


    @Override
    public String getBaseUrl() {
        return null;
    }

    @Override
    public String getRequestUrl() {
        return null;
    }

    @Override
    public int setTimeOut() {
        return 0;
    }

    @Override
    public HttpMethod getRequestMethod() {
        return null;
    }

    @Override
    public Header[] getHeader() {
        return new Header[0];
    }

    @Override
    public Map<String, String> getRequestParams() {
        return null;
    }

    @Override
    public void getResponseHeader(Header[] headers) {

    }

    @Override
    public void getResponseJSONObject(JSONObject jsonObject) {

    }

    @Override
    public void getResponseJSONArray(JSONArray jsonArray) {

    }

    @Override
    public void getResponseStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public void getResponseError(Throwable error) {
        if(error!=null){
            this.error = error;
        }
    }

    @Override
    public void handleResponseResult(Object object) {

    }

    @Override
    public void getResponseBinary(byte[] binaryData) {

    }
}
