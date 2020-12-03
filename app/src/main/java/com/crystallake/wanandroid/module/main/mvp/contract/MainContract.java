package com.crystallake.wanandroid.module.main.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface MainContract {
    interface MainView extends IView{

    }

    interface MainPresenter extends IPresenter<MainView>{

    }

    interface MainModel extends IModel{

    }
}
