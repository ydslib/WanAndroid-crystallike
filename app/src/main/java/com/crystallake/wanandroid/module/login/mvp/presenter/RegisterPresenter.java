/**
 * Created by : yds
 * Time: 2021-01-04 8:55 PM
 */
package com.crystallake.wanandroid.module.login.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.login.mvp.contract.RegisterContract;
import com.crystallake.wanandroid.module.login.mvp.model.RegisterModel;

public class RegisterPresenter extends BasePresenter<RegisterModel, RegisterContract.RegisterView>
        implements RegisterContract.RegisterPresenter {

    @Override
    protected RegisterModel createModel() {
        return new RegisterModel();
    }
}
