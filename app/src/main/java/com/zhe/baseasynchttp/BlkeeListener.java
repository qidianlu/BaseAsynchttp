package com.zhe.baseasynchttp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zhe on 2016/6/5.
 */
public interface BlkeeListener {
    String getBaseUrl();
    String getRequestUrl();
    float setTimeOut();
    HttpMethod getRequestMethod();
    Header[] getHeader();
    Map<String,String> getRequestParams();
    void getResponseHeader(Header[] headers);
    void getResponseJSONObject(JSONObject jsonObject);
    void getResponseJSONArray(JSONArray jsonArray);
    void getResponseStatus(int statusCode);
    void getResponseError(Throwable error);
}
