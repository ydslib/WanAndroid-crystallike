package com.crystallake.wanandroid.module.login.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface LoginContract {
    interface LoginView extends IView{

    }

    interface LoginPresenter extends IPresenter<LoginView>{

    }

    interface LoginModel extends IModel{

    }
}
