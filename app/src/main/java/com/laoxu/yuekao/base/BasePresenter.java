package com.laoxu.yuekao.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {

    public M model;
    public WeakReference<V> weakReference;

    public BasePresenter(){
        model = initModel();

    }

    /**
     * 绑定vieww
     * @param v
     */
    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }


    protected abstract M initModel();

    /**
     * 解绑vieww，解决内存泄漏问题
     */
    public void dettach(){
       if (weakReference!=null){
           weakReference.clear();
           weakReference = null;
       }
    }


    public V getView(){
        return weakReference.get();
    }

}
