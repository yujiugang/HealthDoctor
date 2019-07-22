package com.example.homepage.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.homepage.R;
import com.gyf.immersionbar.ImmersionBar;

public class StartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //沉浸状态栏
        ImmersionBar immersionBar = ImmersionBar.with(this);
        immersionBar.statusBarDarkFont(true, 0.2f)
                .init();
        //发送消息
        handler.sendEmptyMessage(0);

    }

    Handler handler=new Handler(){
        int a=3;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (a==1){
                startActivity(new Intent(StartActivity.this,HomeActivity.class));
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                finish();

                ARouter.getInstance().build("/one/two/three").navigation();
            }else {
                a--;
                handler.sendEmptyMessageDelayed(0,1000);
            }
        }
    };
}
