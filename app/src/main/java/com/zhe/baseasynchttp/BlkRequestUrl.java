package com.zhe.baseasynchttp;

/**
 * Created by zhangyr on 2016/6/2.
 */
public enum BlkRequestUrl {
    APP(""),
    TESTAPP("");
    private String url;
    private BlkRequestUrl(String request_url){
        this.url = request_url;
    }
    public String getUrl(){
        return url;
    }
}
