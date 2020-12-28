/**
 * Created by : yds
 * Time: 2020-12-28 10:53 PM
 */
package com.crystallake.wanandroid.module.me.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface CollectContract {
    interface CollectView extends IView{

    }

    interface CollectPresenter extends IPresenter<CollectView>{

    }

    interface CollectModel extends IModel{

    }
}
