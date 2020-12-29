/**
 * Created by : yds
 * Time: 2020-12-29 11:00 PM
 */
package com.crystallake.wanandroid.module.me.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.me.mvp.contract.SettingContract;
import com.crystallake.wanandroid.module.me.mvp.model.SettingModel;

public class SettingPresenter extends BasePresenter<SettingModel, SettingContract.SettingView> implements SettingContract.SettingPresenter {
    @Override
    protected SettingModel createModel() {
        return new SettingModel();
    }
}
