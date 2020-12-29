/**
 * Created by : yds
 * Time: 2020-12-29 10:59 PM
 */
package com.crystallake.wanandroid.module.me.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface SettingContract {
    interface SettingView extends IView{

    }

    interface SettingPresenter extends IPresenter<SettingView>{

    }
    interface SettingModel extends IModel{

    }
}
