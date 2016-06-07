package com.zhe.baseasynchttp;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zhe on 2016/6/5.
 */
public class NetworkConnected {

    private static AsyncHttpClient httpClient;
    private String url;
    private RequestParams params;
    private static NetworkConnected networkConnected = new NetworkConnected();

    private NetworkConnected(){
    }

    public static NetworkConnected getInstance(){
        httpClient = new AsyncHttpClient(true,80,443);
        return networkConnected;
    }

    public void handleRequest(Context context, final BlkeeHttpInterface blkeeHttpInterface, final BlkeeHttpManagerListener listener){

        httpClient.setTimeout(blkeeHttpInterface.setTimeOut());

        url = blkeeHttpInterface.getBaseUrl()+ blkeeHttpInterface.getRequestUrl();
        Map<String,String> map = getParams(blkeeHttpInterface);
        params = new RequestParams(map);
        BlkeeResponseHandlerInterface responseHandler = new BlkeeResponseHandlerInterface(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                blkeeHttpInterface.responseStatus(statusCode);
                blkeeHttpInterface.responseHeader(headers);
                blkeeHttpInterface.responseJSONObject(response,listener);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                blkeeHttpInterface.responseStatus(statusCode);
                blkeeHttpInterface.responseError(throwable);
                blkeeHttpInterface.responseHeader(headers);
            }
        };

        switch (blkeeHttpInterface.getRequestMethod()){
            case REQUEST_HTTP_GET:
                httpClient.get(context,url,params,responseHandler);
                break;
            case REQUEST_HTTP_POST:
                httpClient.post(context,url,params,responseHandler);
                break;
            case REQUEST_HTTP_PUT:
                httpClient.put(context,url,params,responseHandler);
                break;
            case REQUEST_HTTP_DELETE:
                httpClient.delete(context,url,responseHandler);
                break;
            case REQUEST_HTTP_HEAD:
                httpClient.head(context,url,params,responseHandler);
                break;
        }
    }

    public void binaryRequest(Context context,final BlkeeHttpInterface blkeeHttpInterface,final BlkeeHttpManagerListener listener){

        httpClient.setTimeout(blkeeHttpInterface.setTimeOut());

        url = blkeeHttpInterface.getRequestUrl();

        BlkeeBinaryHandlerInterface binaryHandler = new BlkeeBinaryHandlerInterface(blkeeHttpInterface);

        httpClient.get(context,url, new BinaryHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] binaryData) {
                blkeeHttpInterface.responseHeader(headers);
                blkeeHttpInterface.responseBinary(binaryData,listener);
                blkeeHttpInterface.responseStatus(statusCode);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] binaryData, Throwable error) {
                blkeeHttpInterface.responseHeader(headers);
                blkeeHttpInterface.responseStatus(statusCode);
                blkeeHttpInterface.responseError(error);
            }
        });
    }

    public void uploadFile(Context context,final BlkeeHttpInterface blkeeHttpInterface,String name,File file,String url,final BlkeeHttpManagerListener listener){
        RequestParams params = new RequestParams();
        try{
            params.put(name,file);
            httpClient.post(context,url, params, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    blkeeHttpInterface.responseStatus(statusCode);
                    blkeeHttpInterface.responseHeader(headers);
                    blkeeHttpInterface.responseUpload(responseBody,listener);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    blkeeHttpInterface.responseHeader(headers);
                    blkeeHttpInterface.responseStatus(statusCode);
                    blkeeHttpInterface.responseError(error);
                }
            });
        }catch (FileNotFoundException exception){

        }

    }

    public void httpCancle(Context context,boolean isCancle){
        httpClient.cancelRequests(context,isCancle);
    }

    private Map<String,String> getParams(BlkeeHttpInterface blkeeHttpInterface){
        Map<String,String > params = blkeeHttpInterface.getRequestParams();
        return params;
    }

}
