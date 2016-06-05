package com.zhe.baseasynchttp;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.security.Policy;
import java.util.Map;

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

    public void request(BlkeeListener blkeeListener){

        url = blkeeListener.getBaseUrl()+blkeeListener.getRequestUrl();
        Map<String,String> map = blkeeListener.getRequestParams();
        params = new RequestParams(map);
        BlkeeResponseHandlerInterface responseHandler = new BlkeeResponseHandlerInterface(blkeeListener);

        switch (blkeeListener.getRequestMethod()){
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

}
