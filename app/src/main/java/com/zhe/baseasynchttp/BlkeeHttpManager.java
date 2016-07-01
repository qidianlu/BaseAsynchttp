package com.zhe.baseasynchttp;

import android.content.Context;

import com.zhe.baseasynchttp.BLK.NetworkConnected;

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

    public void adv(Context context,LDBaseRequest ldbaseRequest,BlkeeHttpManagerListener listener){
        connected.handleRequest(context,ldbaseRequest,listener);
    }
}
