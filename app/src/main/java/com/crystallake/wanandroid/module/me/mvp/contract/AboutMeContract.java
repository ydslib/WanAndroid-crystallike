/**
 * Created by : yds
 * Time: 2020-12-28 10:43 PM
 */
package com.crystallake.wanandroid.module.me.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface AboutMeContract {

    interface AboutMeView extends IView{

    }

    interface AboutMePresenter extends IPresenter<AboutMeView>{

    }

    interface AboutMeModel extends IModel{

    }
}
