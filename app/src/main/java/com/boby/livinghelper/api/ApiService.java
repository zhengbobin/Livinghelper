package com.boby.livinghelper.api;

import com.boby.livinghelper.app.example.entity.ExampleEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * API 接口统一管理类
 *
 * @author zbobin.com
 * @date 2017/8/28.
 */

public interface ApiService {

    String BASE_URL="http://www.zbobin.com/";

    @GET("app/kaifadaohang/{page}")
    Observable<ExampleEntity> getExampleEntity(@Path("page") String page);

}
