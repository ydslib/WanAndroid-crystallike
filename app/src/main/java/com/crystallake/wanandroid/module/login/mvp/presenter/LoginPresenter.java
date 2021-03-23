/**
 * Created by : yds
 * Time: 2020-12-24 11:55 AM
 */
package com.crystallake.wanandroid.module.login.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.basic.http.function.RetryWithDelay;
import com.crystallake.wanandroid.module.login.bean.LoginBean;
import com.crystallake.wanandroid.module.login.mvp.contract.LoginContract;
import com.crystallake.wanandroid.module.login.mvp.model.LoginModel;
import com.crystallake.wanandroid.utils.UserInfoUtils;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

public class LoginPresenter extends BasePresenter<LoginModel, LoginContract.LoginView>
        implements LoginContract.LoginPresenter {

    @Override
    protected LoginModel createModel() {
        return new LoginModel();
    }

    @Override
    public void login(String userName, String password) {
        Disposable disposable1 = getModel().login(userName, password)
                .doOnSubscribe(disposable -> getView().showLoading())
                .doFinally(() -> getView().hideLoading())
                .compose(getView().bindToLife())
                .retryWhen(new RetryWithDelay())
                .subscribe(loginBean -> {
                    UserInfoUtils.getInstance().login(loginBean);
                    getView().loginSuccess(loginBean);
                }, throwable -> getView().loginFailed(throwable.getMessage()));

        addDispose(disposable1);

    }
}
