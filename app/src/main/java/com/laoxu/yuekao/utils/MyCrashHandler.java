package com.laoxu.yuekao.utils;

import android.util.Log;

public class MyCrashHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.e("bug====",e.getMessage());
    }
}
