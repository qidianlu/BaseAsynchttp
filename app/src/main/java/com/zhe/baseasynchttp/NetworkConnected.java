package com.zhe.baseasynchttp;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

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

    public void jsonRequest(final BlkeeHttpInterface blkeeHttpInterface){

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
                blkeeHttpInterface.responseJSONObject(response);
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
                httpClient.get(url,params,responseHandler);
                break;
            case REQUEST_HTTP_POST:
                httpClient.post(url,params,responseHandler);
                break;
            case REQUEST_HTTP_PUT:
                httpClient.put(url,params,responseHandler);
                break;
            case REQUEST_HTTP_DELETE:
                httpClient.delete(url,params,responseHandler);
                break;
            case REQUEST_HTTP_HEAD:
                httpClient.head(url,params,responseHandler);
                break;
        }
    }

    public void binaryRequest(BlkeeHttpInterface blkeeHttpInterface){

        httpClient.setTimeout(blkeeHttpInterface.setTimeOut());

        url = blkeeHttpInterface.getRequestUrl();

        BlkeeBinaryHandlerInterface binaryHandler = new BlkeeBinaryHandlerInterface(blkeeHttpInterface);

        httpClient.get(url,binaryHandler);
    }

    private Map<String,String> getParams(BlkeeHttpInterface blkeeHttpInterface){
        Map<String,String > params = blkeeHttpInterface.getRequestParams();
        return params;
    }

}
