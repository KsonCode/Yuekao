package com.laoxu.yuekao.presenter;

import com.laoxu.yuekao.base.BasePresenter;
import com.laoxu.yuekao.contract.IHomeContract;
import com.laoxu.yuekao.model.HomeModel;

public class HomePresenter extends BasePresenter<HomeModel, IHomeContract.IView> implements IHomeContract.IPresenter {
    @Override
    protected HomeModel initModel() {
        return new HomeModel();
    }

    @Override
    public void getFlowdata(String url) {

        model.getFlowdata(url, new IHomeContract.IModel.ModelCallback() {
            @Override
            public void success(Object data) {

                getView().success(data);

            }

            @Override
            public void error(Throwable throwable) {

                getView().error(throwable);

            }
        });


    }

    @Override
    public void getProductdata(String url) {
        model.getProductdata(url, new IHomeContract.IModel.ModelCallback() {
            @Override
            public void success(Object data) {

                getView().success(data);

            }

            @Override
            public void error(Throwable throwable) {

                getView().error(throwable);

            }
        });
    }
}
