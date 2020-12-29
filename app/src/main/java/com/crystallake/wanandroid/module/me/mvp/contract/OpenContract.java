/**
 * Created by : yds
 * Time: 2020-12-29 10:54 PM
 */
package com.crystallake.wanandroid.module.me.mvp.contract;


import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface OpenContract {
    interface OpenView extends IView{

    }

    interface OpenPresenter extends IPresenter<OpenView>{

    }

    interface OpenModel extends IModel{

    }
}
