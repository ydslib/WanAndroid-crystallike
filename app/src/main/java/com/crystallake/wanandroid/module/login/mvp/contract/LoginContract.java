package com.crystallake.wanandroid.module.login.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;
import com.crystallake.wanandroid.module.login.bean.LoginBean;

import io.reactivex.rxjava3.core.Observable;

public interface LoginContract {
    interface LoginView extends IView{
        void loginSuccess(LoginBean bean);
        void loginFailed(String msg);
    }

    interface LoginPresenter extends IPresenter<LoginView>{
        void login(String userName,String password);
    }

    interface LoginModel extends IModel{
        Observable<LoginBean> login(String userName,String password);
    }
}
