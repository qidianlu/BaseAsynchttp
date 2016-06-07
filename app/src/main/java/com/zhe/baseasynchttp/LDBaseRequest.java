package com.zhe.baseasynchttp;

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
        return null;
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
        return null;
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
    public void responseJSONObject(JSONObject jsonObject, BlkeeHttpManagerListener listener) {

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
        }
    }

    @Override
    public void handleResponseResult(Object object) {

    }

    @Override
    public void responseBinary(byte[] binaryData,BlkeeHttpManagerListener listener) {

    }

    @Override
    public void responseUpload(byte[] uploadData,BlkeeHttpManagerListener listener) {

    }

}
