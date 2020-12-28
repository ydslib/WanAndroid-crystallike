/**
 * Created by : yds
 * Time: 2020-12-28 10:55 PM
 */
package com.crystallake.wanandroid.module.me.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.me.mvp.contract.CollectContract;
import com.crystallake.wanandroid.module.me.mvp.model.CollectModel;

public class CollectPresenter extends BasePresenter<CollectModel, CollectContract.CollectView> implements CollectContract.CollectPresenter {
    @Override
    protected CollectModel createModel() {
        return new CollectModel();
    }
}
