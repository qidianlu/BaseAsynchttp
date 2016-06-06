package com.zhe.baseasynchttp;

import com.loopj.android.http.BinaryHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zhangyr on 2016/6/5.
 */
public class BlkeeBinaryHandlerInterface extends BinaryHttpResponseHandler{
    BlkeeListener blkeeListener;

    public BlkeeBinaryHandlerInterface(BlkeeListener blkeeListener){
        this.blkeeListener = blkeeListener;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] binaryData) {
        blkeeListener.getResponseHeader(headers);
        blkeeListener.getResponseBinary(binaryData);
        blkeeListener.getResponseStatus(statusCode);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] binaryData, Throwable error) {
        blkeeListener.getResponseHeader(headers);
        blkeeListener.getResponseStatus(statusCode);
        blkeeListener.getResponseError(error);

    }
}
