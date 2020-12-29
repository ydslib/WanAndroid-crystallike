/**
 * Created by : yds
 * Time: 2020-12-29 10:55 PM
 */
package com.crystallake.wanandroid.module.me.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.me.mvp.contract.OpenContract;
import com.crystallake.wanandroid.module.me.mvp.model.OpenModel;

public class OpenPresenter extends BasePresenter<OpenModel, OpenContract.OpenView> implements OpenContract.OpenPresenter {
    @Override
    protected OpenModel createModel() {
        return new OpenModel();
    }
}
