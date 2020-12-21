/**
 * Created by : yds
 * Time: 2020-12-20 6:03 PM
 */
package com.crystallake.wanandroid.module.navi.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.basic.http.function.RetryWithDelay;
import com.crystallake.wanandroid.module.navi.bean.NaviBean;
import com.crystallake.wanandroid.module.navi.mvp.contract.NaviContract;
import com.crystallake.wanandroid.module.navi.mvp.model.NaviModel;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

public class NaviPresenter extends BasePresenter<NaviModel, NaviContract.NaviView> implements NaviContract.NaviPresenter {
    @Override
    protected NaviModel createModel() {
        return new NaviModel();
    }

    @Override
    public void getNaviList() {
        getModel().getNaviList()
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Throwable {
                        getView().showLoading();
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Throwable {
                        getView().hideLoading();
                    }
                })
                .compose(getView().bindToLife())
                .retryWhen(new RetryWithDelay())
                .subscribe(new Consumer<List<NaviBean>>() {
                    @Override
                    public void accept(List<NaviBean> naviBeans) throws Throwable {
                        getView().getNaviListSuccess(naviBeans);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        getView().getNaviListFailed(throwable.getMessage());
                    }
                });
    }
}
