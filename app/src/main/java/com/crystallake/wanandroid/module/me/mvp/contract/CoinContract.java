/**
 * Created by : yds
 * Time: 2020-12-28 10:02 PM
 */
package com.crystallake.wanandroid.module.me.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

import io.reactivex.rxjava3.core.Observable;

public interface CoinContract {
    interface CoinView extends IView{
        void getCoinSuccess(int coin);
        void getCoinFailed(String msg);
    }

    interface CoinPresenter extends IPresenter<CoinView>{
        void getCoin();
    }

    interface CoinModel extends IModel{
        Observable<Integer> getCoin();
    }
}
