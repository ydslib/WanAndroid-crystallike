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
        getModel().login(userName,password)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Throwable {
                        getView().showLoading();
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Throwable {
                        getView().hideLoading();
                    }
                })
                .compose(getView().bindToLife())
                .retryWhen(new RetryWithDelay())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Throwable {
                        UserInfoUtils.getInstance().login(loginBean);
                        getView().loginSuccess(loginBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        getView().loginFailed(throwable.getMessage());
                    }
                });

    }
}
