package com.boby.livinghelper.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Presenter层 基础类
 *
 * @author zbobin.com
 * @date 2017/8/28.
 */

public class BasePresenter<M extends BaseModel, V extends BaseView> {

    protected M mModel;
    protected V mView;

    private CompositeSubscription mCompositeSubscription;

    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    protected void unSubsribe() {
        if (mView != null)
            mView = null;
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.clear();
        }
    }

}
