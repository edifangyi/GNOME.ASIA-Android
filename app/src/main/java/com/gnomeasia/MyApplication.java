package com.gnomeasia;


import android.app.Application;
import android.os.Handler;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


/**
 * ================================================
 * 作    者：FangYi
 * 邮    箱：87649669@qq.com
 * 版    本：1.0
 * 日    期：2017/7/12
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class MyApplication extends Application {

    private static Handler mHandler;

    private static SPUtils spUtils;

    @Override
    public void onCreate() {
        super.onCreate();

        initOkGo();

        //bugly
//        CrashReport.initCrashReport(getApplicationContext());
        CrashReport.initCrashReport(getApplicationContext(), "c7511e9f5e", false);

        //工具类
        Utils.init(this);
        spUtils = SPUtils.getInstance("GNOME.ASIA");
        //二维码

        mHandler = new Handler();


    }

    private void initOkGo() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //超时时间设置，默认60秒
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);      //全局的读取超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);     //全局的写入超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);   //全局的连接超时时间

        //必须调用初始化
        OkGo.getInstance().init(this)
                .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(3);//全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
    }


    public static Handler getHandler() {
        if (mHandler == null) {
            mHandler = new Handler();
        }
        return mHandler;
    }

    public static SPUtils getSpUtils() {
        return spUtils;
    }
}
