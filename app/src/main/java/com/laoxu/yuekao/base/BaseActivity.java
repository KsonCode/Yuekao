package com.laoxu.yuekao.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView{

    public P presenter;
    /**
     * 一个参数的
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());


       presenter = initPresenter();
       if (presenter!=null){
           presenter.attach(this);//绑定view
       }


        initView();
        initData();
        
        
    }

    //让子类创建
    protected abstract P initPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.dettach();//解决内存泄漏
        }

    }
}
