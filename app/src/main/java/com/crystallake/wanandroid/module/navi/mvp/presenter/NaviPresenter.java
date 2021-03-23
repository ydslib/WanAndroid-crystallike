/**
 * Created by : yds
 * Time: 2020-12-20 6:03 PM
 */
package com.crystallake.wanandroid.module.navi.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.basic.http.function.RetryWithDelay;
import com.crystallake.wanandroid.module.navi.mvp.contract.NaviContract;
import com.crystallake.wanandroid.module.navi.mvp.model.NaviModel;


import io.reactivex.rxjava3.disposables.Disposable;

public class NaviPresenter extends BasePresenter<NaviModel, NaviContract.NaviView> implements NaviContract.NaviPresenter {
    @Override
    protected NaviModel createModel() {
        return new NaviModel();
    }

    @Override
    public void getNaviList() {
        Disposable disposable1 = getModel().getNaviList()
                .doOnSubscribe(disposable -> getView().showLoading())
                .doFinally(() -> getView().hideLoading())
                .compose(getView().bindToLife())
                .retryWhen(new RetryWithDelay())
                .subscribe(naviBeans -> getView().getNaviListSuccess(naviBeans),
                        throwable -> getView().getNaviListFailed(throwable.getMessage()));

        addDispose(disposable1);
    }
}
