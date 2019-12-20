package com.laoxu.yuekao.view.frament;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.laoxu.yuekao.R;
import com.laoxu.yuekao.base.BaseFragment;
import com.laoxu.yuekao.base.BasePresenter;
import com.laoxu.yuekao.model.entity.User;


public class MyFragment extends BaseFragment {
    private WebView webView;
    private Button button;
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {


    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_my_layout;
    }



    @Override
    protected void initData() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
