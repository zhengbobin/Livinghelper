package com.boby.livinghelper.app.example.mvp.contract;

import com.boby.livinghelper.app.example.entity.ExampleEntity;
import com.boby.livinghelper.base.BaseModel;
import com.boby.livinghelper.base.BasePresenter;
import com.boby.livinghelper.base.BaseView;

import rx.Observable;

/**
 * Example 契约类
 *
 * @author zbobin.com
 * @date 2017/8/28.
 */

public interface ExampleContact {

    interface Model extends BaseModel {
        Observable<ExampleEntity> getExampleEntity();
    }

    interface View extends BaseView {
        void showDialog();
        void onSuccess(ExampleEntity entity);
        void onFail(String s);
        void hideDialog();
    }

    abstract class Precenter extends BasePresenter<Model, View> {
        public abstract void getExampleEntity();
    }

}
