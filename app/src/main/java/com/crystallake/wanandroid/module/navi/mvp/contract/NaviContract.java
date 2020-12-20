/**
 * Created by : yds
 * Time: 2020-12-20 6:02 PM
 */
package com.crystallake.wanandroid.module.navi.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface NaviContract {
    interface NaviView extends IView{

    }

    interface NaviPresenter extends IPresenter<NaviView>{

    }

    interface NaviModel extends IModel{

    }
}
