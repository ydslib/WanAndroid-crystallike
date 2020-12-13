/**
 * Created by : yds
 * Time: 2020-12-12 8:36 PM
 */
package com.crystallake.wanandroid.module.home.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface HomeContract {
    interface HomeView extends IView{

    }

    interface HomePresenter extends IPresenter<HomeView>{

    }

    interface HomeModel extends IModel{

    }
}
