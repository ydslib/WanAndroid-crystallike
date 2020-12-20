/**
 * Created by : yds
 * Time: 2020-12-20 6:03 PM
 */
package com.crystallake.wanandroid.module.navi.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.navi.mvp.contract.NaviContract;
import com.crystallake.wanandroid.module.navi.mvp.model.NaviModel;

public class NaviPresenter extends BasePresenter<NaviModel, NaviContract.NaviView> implements NaviContract.NaviPresenter {
    @Override
    protected NaviModel createModel() {
        return new NaviModel();
    }
}
