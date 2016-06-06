package com.zhe.baseasynchttp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zhe on 2016/6/5.
 */
public interface BlkeeHttpInterface {
    String getBaseUrl();
    String getRequestUrl();
    int setTimeOut();
    HttpMethod getRequestMethod();
    Header[] getHeader();
    Map<String,String> getRequestParams();
    void responseHeader(Header[] headers);
    void responseJSONObject(JSONObject jsonObject);
    void getResponseJSONArray(JSONArray jsonArray);
    void responseStatus(int statusCode);
    void responseError(Throwable error);
    void handleResponseResult(Object object);
    void responseBinary(byte[] binaryData);
}
