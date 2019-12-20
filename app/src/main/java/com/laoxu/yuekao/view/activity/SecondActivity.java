package com.laoxu.yuekao.view.activity;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.laoxu.yuekao.R;
import com.laoxu.yuekao.base.BaseActivity;
import com.laoxu.yuekao.base.BasePresenter;
import com.laoxu.yuekao.model.entity.User;

public class SecondActivity extends BaseActivity {
    private WebView webView;
    private Button button;
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        webView  = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


        webView.loadUrl("file:///android_asset/h.html");
        //把android的user的对象映射到webview里面
        User user = new User();
        webView.addJavascriptInterface(user,"ccc");

        button = findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = "我来自于adnroid的世界";
                webView.loadUrl("javascript:jsFunction2('"+s+"')");

            }
        });

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_second;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
