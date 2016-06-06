package com.zhe.baseasynchttp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zhangyr on 2016/6/5.
 */
public class BlkeeHttpRequest extends BaseRequest{
    private static final String resultKey = "result";
    private static final String resultCodeKey = "result_code";
    private static final String resultMsgKey = "result_msg";
    private final int REQUEST_SUCCESS_CODE = 1011;
    private final int REQUEST_LOSE_PARAMS = 1022;//缺少参数
    private final int REQUEST_TOKEN_ERROR = 1033;//token错误

    protected Object responseResultObject;
    protected String responseResultMsg;
    protected int responseResultCode;

    @Override
    public void responseJSONObject(JSONObject jsonObject) {
        super.responseJSONObject(jsonObject);

        if(error != null){
            return;
        }
        try{
            responseResultCode = jsonObject.getInt(resultCodeKey);
            responseResultMsg = jsonObject.getString(resultMsgKey);
            responseResultObject = jsonObject.get(resultKey);

            handleResponseResult(responseResultObject);
        }catch (JSONException exception){

        }

    }

    @Override
    public void getResponseJSONArray(JSONArray jsonArray) {
        super.getResponseJSONArray(jsonArray);
    }

    @Override
    public void responseError(Throwable error) {
        super.responseError(error);

    }

    @Override
    public void responseHeader(Header[] headers) {
        super.responseHeader(headers);
    }

    @Override
    public void responseStatus(int statusCode) {
        super.responseStatus(statusCode);
    }
}
