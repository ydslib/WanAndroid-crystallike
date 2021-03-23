/**
 * Created by : yds
 * Time: 2020-12-02 10:09 PM
 */
package com.crystallake.wanandroid.module.main.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.main.mvp.contract.MainContract;
import com.crystallake.wanandroid.module.main.mvp.model.MainModel;

public class MainPresenter extends BasePresenter<MainModel, MainContract.MainView> implements MainContract.MainPresenter{

    @Override
    protected MainModel createModel() {
        return new MainModel();
    }
}
