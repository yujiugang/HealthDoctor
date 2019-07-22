package com.example.base.model.app;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);

        Fresco.initialize(this);

        //存user,sessionid
        getInstace();
        //MultiDex.install(this);
    }

    private void getInstace() {
        context = getApplicationContext();
    }

    public static Context getContentInstace(){
        return context;
    }
}
