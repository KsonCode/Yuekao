package com.laoxu.yuekao.base;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView{
    public P presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(LayoutId(),container,false);
        presenter = initPresenter();
        if (presenter!=null){
            presenter.attach(this);//绑定view
        }


        initView(view);
        return view;
    }


    protected abstract P initPresenter();

    protected abstract void initView(View view);


    protected abstract int LayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }


    protected abstract void initData();


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.dettach();//解决内存泄漏
        }
    }
}
