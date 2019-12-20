package com.laoxu.yuekao.model.entity;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.laoxu.yuekao.app.App;


public class User {
    /**
     * 注解
     */
    @JavascriptInterface
    public void aaa(){

        Log.e("aaa","js无参数传递过来的方法");

        Toast.makeText(App.getContext(), "js无参数传递过来的方法", Toast.LENGTH_SHORT).show();

    }

    @JavascriptInterface
    public void bbb(String name){
        Log.e("aaa",name);
        Toast.makeText(App.getContext(), name, Toast.LENGTH_SHORT).show();

    }
}
