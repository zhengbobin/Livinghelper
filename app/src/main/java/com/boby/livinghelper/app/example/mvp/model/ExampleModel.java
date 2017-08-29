package com.boby.livinghelper.app.example.mvp.model;

import com.boby.livinghelper.api.ApiEngine;
import com.boby.livinghelper.app.example.entity.ExampleEntity;
import com.boby.livinghelper.app.example.mvp.contract.ExampleContact;
import com.boby.livinghelper.rx.RxSchedulers;

import rx.Observable;

/**
 * Example Model层
 *
 * @author zbobin.com
 * @date 2017/8/28.
 */

public class ExampleModel implements ExampleContact.Model {

    @Override
    public Observable<ExampleEntity> getExampleEntity() {
        return ApiEngine.getInstance().getApiService()
                .getExampleEntity("api_kind.php")
                .compose(RxSchedulers.<ExampleEntity>switchThread());
    }

}
