package com.zhe.baseasynchttp;

import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zhe on 2016/6/5.
 */
public class BaseRequest implements BlkeeListener{
    @Override
    public String getBaseUrl() {
        return null;
    }

    @Override
    public String getRequestUrl() {
        return null;
    }

    @Override
    public float setTimeOut() {
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
}
