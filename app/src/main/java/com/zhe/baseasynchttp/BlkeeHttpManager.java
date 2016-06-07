package com.zhe.baseasynchttp;

import android.content.Context;

/**
 * Created by zhangyr on 2016/6/7.
 */
public class BlkeeHttpManager {
    private static BlkeeHttpManager blkeeHttpManager = new BlkeeHttpManager();
    private BlkeeHttpManager(){

    }

    public static BlkeeHttpManager getInstance(){
        return blkeeHttpManager;
    }
    NetworkConnected connected = NetworkConnected.getInstance();

    public void login(Context context,LDBaseRequest ldBaseRequest, BlkeeHttpManagerListener listener){
        connected.handleRequest(context,ldBaseRequest,listener);
    }

    public void httpCancle(Context context,boolean isCancle){
        connected.httpCancle(context,isCancle);
    }
}
