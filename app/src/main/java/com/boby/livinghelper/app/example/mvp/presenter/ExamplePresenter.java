package com.boby.livinghelper.app.example.mvp.presenter;

import android.widget.Toast;

import com.boby.livinghelper.R;
import com.boby.livinghelper.app.example.entity.ExampleEntity;
import com.boby.livinghelper.app.example.mvp.contract.ExampleContact;
import com.boby.livinghelper.app.example.mvp.model.ExampleModel;
import com.boby.livinghelper.base.BaseApplication;
import com.boby.livinghelper.util.NetworkUtil;
import rx.Subscriber;
import rx.Subscription;

/**
 * Example Presenter层
 *
 * @author zbobin.com
 * @date 2017/8/28.
 */

public class ExamplePresenter extends ExampleContact.Precenter {

    public ExamplePresenter(ExampleContact.View view) {
        mView = view;
        mModel = new ExampleModel();
    }

    @Override
    public void getExampleEntity() {

        //无网络提示
        if (!NetworkUtil.isConnected(BaseApplication.getContext())) {
            Toast.makeText(BaseApplication.getContext(), R.string.network_interrupted, Toast.LENGTH_SHORT).show();
            return;
        }

        Subscription subscription = mModel.getExampleEntity()
                .subscribe(new Subscriber<ExampleEntity>() {
                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onFail(e.getMessage());
                        onCompleted();
                    }

                    @Override
                    public void onNext(ExampleEntity entity) {
                        mView.onSuccess(entity);
                    }
                });
        addSubscribe(subscription);
    }

}
