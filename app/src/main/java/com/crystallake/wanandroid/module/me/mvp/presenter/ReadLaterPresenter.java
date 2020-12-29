/**
 * Created by : yds
 * Time: 2020-12-29 10:39 PM
 */
package com.crystallake.wanandroid.module.me.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.me.mvp.contract.ReadLaterContract;
import com.crystallake.wanandroid.module.me.mvp.model.ReadLaterModel;

public class ReadLaterPresenter extends BasePresenter<ReadLaterModel, ReadLaterContract.ReadLaterView>
        implements ReadLaterContract.ReadLaterPresenter {

    @Override
    protected ReadLaterModel createModel() {
        return new ReadLaterModel();
    }
}
