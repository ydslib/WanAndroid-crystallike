/**
 * Created by : yds
 * Time: 2020-12-28 10:50 PM
 */
package com.crystallake.wanandroid.module.me.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.me.mvp.contract.ShareContract;
import com.crystallake.wanandroid.module.me.mvp.model.ShareModel;

public class SharePresenter extends BasePresenter<ShareModel, ShareContract.ShareView> implements ShareContract.SharePresenter {
    @Override
    protected ShareModel createModel() {
        return new ShareModel();
    }
}
