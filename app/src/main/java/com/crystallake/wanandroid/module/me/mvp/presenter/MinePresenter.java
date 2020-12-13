/**
 * Created by : yds
 * Time: 2020-12-12 10:46 PM
 */
package com.crystallake.wanandroid.module.me.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.me.mvp.contract.MineContract;
import com.crystallake.wanandroid.module.me.mvp.model.MineModel;

public class MinePresenter extends BasePresenter<MineModel, MineContract.MineView> implements MineContract.MinePresenter {
    @Override
    protected MineModel createModel() {
        return new MineModel();
    }
}
