/**
 * Created by : yds
 * Time: 2020-12-29 10:17 PM
 */
package com.crystallake.wanandroid.module.me.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface ReadLaterContract {
    interface ReadLaterView extends IView{

    }

    interface ReadLaterPresenter extends IPresenter<ReadLaterView>{

    }

    interface ReadLaterModel extends IModel{

    }
}
