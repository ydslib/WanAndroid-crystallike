/**
 * Created by : yds
 * Time: 2020-11-22 10:50 PM
 */
package com.crystallake.wanandroid.mvp.presenter;

import com.crystallake.wanandroid.mvp.DemoContract;
import com.crystallake.wanandroid.mvp.model.DemoModel;
import com.crystallake.basic.base.mvp.presenter.BasePresenter;

public class DemoPresenter extends BasePresenter<DemoContract.Model, DemoContract.View> implements DemoContract.Presenter {

    @Override
    protected DemoContract.Model createModel() {
        return new DemoModel();
    }

}
