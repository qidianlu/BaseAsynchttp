package com.zhe.baseasynchttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData(){
        final LoginApi loginApi = new LoginApi("18615170853","a123456");
        BlkeeHttpManager.getInstance().login(this, loginApi, new BlkeeHttpManagerListener() {
            @Override
            public void run(BlkeeHttpInterface blkeeHttpInterface) {
                LoginApi loginApi1 = (LoginApi)blkeeHttpInterface;
                Log.e("token",loginApi.getToken());
            }
        });

        final AdvApi advApi = new AdvApi();
        BlkeeHttpManager.getInstance().adv(this, advApi, new BlkeeHttpManagerListener() {
            @Override
            public void run(BlkeeHttpInterface blkeeHttpInterface) {
                AdvApi advApi = (AdvApi)blkeeHttpInterface;
                Log.e("url",advApi.getPicUrl());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BlkeeHttpManager.getInstance().httpCancle(this,true);
    }
}
