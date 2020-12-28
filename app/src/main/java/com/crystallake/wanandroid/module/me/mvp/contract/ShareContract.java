/**
 * Created by : yds
 * Time: 2020-12-28 10:48 PM
 */
package com.crystallake.wanandroid.module.me.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface ShareContract {
    interface ShareView extends IView{

    }

    interface SharePresenter extends IPresenter<ShareView>{

    }

    interface ShareModel extends IModel{

    }
}
