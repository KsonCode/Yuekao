package com.laoxu.yuekao.app;

import android.app.Application;
import android.content.Context;

import com.laoxu.yuekao.utils.MyCrashHandler;

public class App extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

//        MyCrashHandler myCrashHandler = new MyCrashHandler();
//        Thread.setDefaultUncaughtExceptionHandler(myCrashHandler);
    }

    public static Context getContext() {
        return context;
    }
}
