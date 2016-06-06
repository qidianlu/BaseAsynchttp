package com.zhe.baseasynchttp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyr on 2016/6/5.
 */
public class LoginApi extends BlkeeHttpRequest{
    private String password;
    private String username;

    @Override
    public String getRequestUrl() {
        return "login";
    }

    @Override
    public Map<String, String> getRequestParams() {
        Map<String,String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        return map;
    }

    @Override
    public void handleResponseResult(Object object) {
        super.handleResponseResult(object);
    }
}
