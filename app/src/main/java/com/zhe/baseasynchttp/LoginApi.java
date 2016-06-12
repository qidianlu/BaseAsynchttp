package com.zhe.baseasynchttp;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyr on 2016/6/5.
 */
public class LoginApi extends LDHttpRequest {
    private String password;
    private String username;
    private String token = "";

    public LoginApi(String username,String password){
        this.password= password;
        this.username = username;
    }

    @Override
    public String getRequestUrl() {
        return "";
    }

    @Override
    public Map<String, String> getRequestParams() {
        Map<String,String> map = new HashMap<>();
        map.put("",username);
        map.put("",password);
        return map;
    }

    @Override
    public void handleResponseResult(Object object) {
        super.handleResponseResult(object);
        JSONObject jsonObject = (JSONObject)object;
        Log.e("object:",jsonObject.toString());
        try{
            token = jsonObject.getString("token");
        }catch (JSONException excetpion){
            Log.e("exception",excetpion.toString());
        }
    }

    public String getToken(){
        return token;
    }
}
