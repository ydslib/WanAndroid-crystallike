/**
 * Created by : yds
 * Time: 2020-12-28 10:21 PM
 */
package com.crystallake.wanandroid.module.me.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.me.mvp.contract.CoinContract;
import com.crystallake.wanandroid.module.me.mvp.model.CoinModel;

import io.reactivex.rxjava3.functions.Consumer;

public class CoinPresenter extends BasePresenter<CoinModel, CoinContract.CoinView> implements CoinContract.CoinPresenter {
    @Override
    protected CoinModel createModel() {
        return new CoinModel();
    }

    @Override
    public void getCoin() {
        getModel().getCoin()
                .compose(getView().bindToLife())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Throwable {
                        getView().getCoinSuccess(integer);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        getView().getCoinFailed(throwable.getMessage());
                    }
                });
    }
}
