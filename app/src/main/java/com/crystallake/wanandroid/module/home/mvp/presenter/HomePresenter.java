/**
 * Created by : yds
 * Time: 2020-12-12 8:41 PM
 */
package com.crystallake.wanandroid.module.home.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.home.mvp.contract.HomeContract;
import com.crystallake.wanandroid.module.home.mvp.model.HomeModel;

public class HomePresenter extends BasePresenter<HomeModel, HomeContract.HomeView>
        implements HomeContract.HomePresenter {

    @Override
    protected HomeModel createModel() {
        return new HomeModel();
    }
}
