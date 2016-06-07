package com.zhe.baseasynchttp;

import com.loopj.android.http.BinaryHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zhangyr on 2016/6/5.
 */
public class BlkeeBinaryHandlerInterface extends BinaryHttpResponseHandler{
    BlkeeHttpInterface blkeeHttpInterface;

    public BlkeeBinaryHandlerInterface(BlkeeHttpInterface blkeeHttpInterface){
        this.blkeeHttpInterface = blkeeHttpInterface;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] binaryData) {

    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] binaryData, Throwable error) {


    }
}
