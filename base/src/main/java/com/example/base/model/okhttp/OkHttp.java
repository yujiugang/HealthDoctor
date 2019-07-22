package com.example.base.model.okhttp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.base.model.api.Api;
import com.example.base.model.app.MyApp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class OkHttp {

    public final Api api;

    private OkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Logg())
                .connectTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.SECONDS)
                .writeTimeout(5000, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mobile.bwstudent.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }

    public static OkHttp getInStance() {
        return ok.okHttp;
    }

    static class ok {
        private static OkHttp okHttp = new OkHttp();
    }

    private class Logg implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {

            SharedPreferences saves = MyApp.getContentInstace().getSharedPreferences("saves", Context.MODE_PRIVATE);

            Request request = chain.request();
            Request.Builder headers = request.newBuilder()
                    .addHeader("doctorId", saves.getString("id", ""))
                    .addHeader("sessionId", saves.getString("sessionId", ""));

            Request request1 = headers.build();
            Response response = chain.proceed(request1);
            Log.i("======", "拦截" + response);
            return response;
        }
    }

    //判断网络
    public boolean isNet(Context context) {
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }
}
