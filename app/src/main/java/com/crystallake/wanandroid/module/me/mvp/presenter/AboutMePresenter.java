/**
 * Created by : yds
 * Time: 2020-12-28 10:45 PM
 */
package com.crystallake.wanandroid.module.me.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.me.mvp.contract.AboutMeContract;
import com.crystallake.wanandroid.module.me.mvp.model.AboutMeModel;

public class AboutMePresenter extends BasePresenter<AboutMeModel, AboutMeContract.AboutMeView> implements AboutMeContract.AboutMePresenter {
    @Override
    protected AboutMeModel createModel() {
        return new AboutMeModel();
    }
}
