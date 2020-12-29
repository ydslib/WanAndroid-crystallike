/**
 * Created by : yds
 * Time: 2020-12-29 10:47 PM
 */
package com.crystallake.wanandroid.module.me.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface ReadRecordContract {
    interface ReadRecordView extends IView{

    }

    interface ReadRecordPresenter extends IPresenter<ReadRecordView>{

    }

    interface ReadRecordModel extends IModel{

    }
}
