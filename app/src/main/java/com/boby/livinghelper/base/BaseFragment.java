package com.boby.livinghelper.base;


import android.support.v4.app.Fragment;

/**
 * Fragment 基础类
 *
 * @author zbobin.com
 * @date 2017/8/28.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected P mPresenter;

    @Override
    public void onResume() {
        super.onResume();
        if (onCreatePresenter() != null)
            mPresenter = onCreatePresenter();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mPresenter != null)
            mPresenter.unSubsribe();
    }

    protected abstract P onCreatePresenter();
}
