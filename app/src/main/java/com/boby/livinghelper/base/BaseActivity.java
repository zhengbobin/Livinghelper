package com.boby.livinghelper.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.BaseMenuPresenter;

/**
 * Activity 基础类
 *
 * @author zbobin.com
 * @date 2017/8/28.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (onCreatePresenter() != null)
            mPresenter = onCreatePresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.unSubsribe();
    }

    protected abstract P onCreatePresenter();
}
