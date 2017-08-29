package com.boby.livinghelper.base;

import android.app.Application;

/**
 * 自定义 Application
 *
 * @author zbobin.com
 * @date 2017/8/28.
 */

public class BaseApplication extends Application {

    public static BaseApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static BaseApplication getContext() {
        return mContext;
    }

}
