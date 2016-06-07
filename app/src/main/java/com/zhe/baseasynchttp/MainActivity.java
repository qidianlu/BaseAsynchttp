package com.zhe.baseasynchttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData(){
        LoginApi loginApi = new LoginApi();
        BlkeeHttpManager.getInstance().login(this, loginApi, new BlkeeHttpManagerListener() {
            @Override
            public void run(LDBaseRequest ldBaseRequest) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BlkeeHttpManager.getInstance().httpCancle(this,true);
    }
}
