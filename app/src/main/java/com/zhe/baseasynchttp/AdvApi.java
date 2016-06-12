package com.zhe.baseasynchttp;

import android.util.Log;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyr on 2016/6/1.
 */
public class AdvApi extends LDHttpRequest {
    private String picUrl = "";

    @Override
    public Map<String, String> getRequestParams() {
        Map<String, String> map = new HashMap<>();
        return map;
    }


    @Override
    public String getRequestUrl() {
        return "";
    }

    @Override
    public void handleResponseResult(Object object) {
        super.handleResponseResult(object);
        if (error == null) {
            JSONArray jsonObject = (JSONArray) object;
            Log.e("jsonobject", jsonObject.toString());
            picUrl = jsonObject.toString();
        }
    }

    public String getPicUrl(){
        return picUrl;
    }

}
