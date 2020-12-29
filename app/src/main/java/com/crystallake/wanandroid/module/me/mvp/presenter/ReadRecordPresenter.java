/**
 * Created by : yds
 * Time: 2020-12-29 10:49 PM
 */
package com.crystallake.wanandroid.module.me.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.me.mvp.contract.ReadRecordContract;
import com.crystallake.wanandroid.module.me.mvp.model.ReadRecordModel;

public class ReadRecordPresenter extends BasePresenter<ReadRecordModel, ReadRecordContract.ReadRecordView>
        implements ReadRecordContract.ReadRecordPresenter {

    @Override
    protected ReadRecordModel createModel() {
        return new ReadRecordModel();
    }
}
