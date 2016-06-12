package com.zhe.baseasynchttp;

import android.util.Log;

import org.json.JSONObject;

import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zhe on 2016/6/5.
 */
public class LDBaseRequest implements BlkeeHttpInterface {
    protected Throwable error;
    protected HttpStatusCode statusCode;

    @Override
    public String getBaseUrl() {
        String baseUrl ;
        int i=0;//从文件中获取服务器地址
        switch (i){
            case 0:
                baseUrl =  BlkRequestUrl.APP.getUrl();
                break;
            case 1:
                baseUrl = BlkRequestUrl.TESTAPP.getUrl();
                break;
            default:
                baseUrl = "";
                break;
        }
        return baseUrl;
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
        return HttpMethod.REQUEST_HTTP_POST;
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
    public void responseHeader(Header[] headers) {

    }

    @Override
    public void responseJSONObject(JSONObject jsonObject) {

    }

    @Override
    public void responseStatus(int statusCode) {
        if(200<=statusCode&&statusCode<300){
            this.statusCode = HttpStatusCode.STATUS_SUCCESS;
        }else if(300<=statusCode&&statusCode<400){
            this.statusCode = HttpStatusCode.STATUS_MULTIPLE_CHOICE;
        }else if(400<=statusCode&&statusCode<500){
            this.statusCode = HttpStatusCode.STATUS_BAS_REQUEST;
        }else if(500<=statusCode&&statusCode<=510){
            this.statusCode = HttpStatusCode.STATUS_SERVER_ERROR;
        }else{
            this.statusCode = HttpStatusCode.STATUS_UNKNOWN;
        }
    }

    @Override
    public void responseError(Throwable error) {
        if(error!=null){
            this.error = error;
            Log.e("error:",error.toString());
        }
    }

    @Override
    public void handleResponseResult(Object object) {

    }

    @Override
    public void responseBinary(byte[] binaryData) {

    }

    @Override
    public void responseUpload(byte[] uploadData) {

    }

}
