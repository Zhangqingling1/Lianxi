package com.aqinga.lianxi;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by
 * 张庆龄
 * 1506A
 * Administrator
 * 2017/9/1417:14
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "680861abc7", false);
    }
}
