/**
 * Created by : yds
 * Time: 2020-12-12 10:45 PM
 */
package com.crystallake.wanandroid.module.me.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface MineContract {
    interface MineView extends IView{

    }

    interface MinePresenter extends IPresenter<MineView>{

    }

    interface MineModel extends IModel{

    }
}
