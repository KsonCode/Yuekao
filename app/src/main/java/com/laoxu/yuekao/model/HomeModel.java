package com.laoxu.yuekao.model;

import com.google.gson.Gson;
import com.laoxu.yuekao.contract.IHomeContract;
import com.laoxu.yuekao.model.entity.FlowEntity;
import com.laoxu.yuekao.model.entity.ProductEntity;
import com.laoxu.yuekao.utils.VolleyUtils;

public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getFlowdata(String url, final ModelCallback modelCallback) {

        VolleyUtils.getInstance().doGet(url, new VolleyUtils.VolleyCallback() {
            @Override
            public void success(String response) {

                FlowEntity flowEntity = new Gson().fromJson(response,FlowEntity.class);
                modelCallback.success(flowEntity);
            }

            @Override
            public void failure(Throwable error) {

                modelCallback.error(error);

            }
        });

    }

    @Override
    public void getProductdata(String url, final ModelCallback modelCallback) {
        VolleyUtils.getInstance().doGet(url, new VolleyUtils.VolleyCallback() {
            @Override
            public void success(String response) {
                System.out.println("resonse:"+response);
                ProductEntity productEntity = new Gson().fromJson(response,ProductEntity.class);
                modelCallback.success(productEntity);
            }

            @Override
            public void failure(Throwable error) {
                System.out.println("resonseerror:"+error.getMessage());
                modelCallback.error(error);

            }
        });
    }
}
