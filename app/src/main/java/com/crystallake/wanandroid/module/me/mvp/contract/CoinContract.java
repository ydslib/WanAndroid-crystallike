/**
 * Created by : yds
 * Time: 2020-12-28 10:02 PM
 */
package com.crystallake.wanandroid.module.me.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface CoinContract {
    interface CoinView extends IView{

    }

    interface CoinPresenter extends IPresenter<CoinView>{

    }

    interface CoinModel extends IModel{

    }
}
