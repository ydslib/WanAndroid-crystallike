/**
 * Created by : yds
 * Time: 2020-12-24 11:55 AM
 */
package com.crystallake.wanandroid.module.login.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.login.mvp.contract.LoginContract;
import com.crystallake.wanandroid.module.login.mvp.model.LoginModel;

public class LoginPresenter extends BasePresenter<LoginModel, LoginContract.LoginView>
        implements LoginContract.LoginPresenter {

    @Override
    protected LoginModel createModel() {
        return new LoginModel();
    }
}
