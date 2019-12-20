package com.laoxu.yuekao.contract;

import com.laoxu.yuekao.base.IBaseModel;
import com.laoxu.yuekao.base.IBaseView;
import com.laoxu.yuekao.model.entity.FlowEntity;

public interface IHomeContract {

    interface IModel extends IBaseModel{

        void getFlowdata(String url,ModelCallback modelCallback);
        void getProductdata(String url,ModelCallback modelCallback);


        interface ModelCallback{
            void success(Object data);

            void error(Throwable throwable);
        }

    }
     interface IView extends IBaseView {

        void success(Object data);
        void error(Throwable throwable);

    }
     interface IPresenter {

         void getFlowdata(String url);
         void getProductdata(String url);

    }


}
