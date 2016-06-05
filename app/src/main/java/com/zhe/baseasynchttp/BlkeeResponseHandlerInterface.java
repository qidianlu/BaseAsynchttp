package com.zhe.baseasynchttp;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.ResponseHandlerInterface;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zhe on 2016/6/5.
 */
public class BlkeeResponseHandlerInterface extends JsonHttpResponseHandler{
    private BlkeeListener blkeeListener;

    public BlkeeResponseHandlerInterface(BlkeeListener blkeeListener){
        this.blkeeListener = blkeeListener;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        super.onSuccess(statusCode, headers, response);
        blkeeListener.getResponseStatus(statusCode);
        blkeeListener.getResponseHeader(headers);
        blkeeListener.getResponseJSONObject(response);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        super.onFailure(statusCode, headers, throwable, errorResponse);
        blkeeListener.getResponseStatus(statusCode);
        blkeeListener.getResponseError(throwable);
        blkeeListener.getResponseHeader(headers);
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        super.onSuccess(statusCode, headers, response);
        blkeeListener.getResponseStatus(statusCode);
        blkeeListener.getResponseHeader(headers);
        blkeeListener.getResponseJSONArray(response);
    }
}
