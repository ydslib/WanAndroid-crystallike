/**
 * Created by : yds
 * Time: 2021-01-04 8:54 PM
 */
package com.crystallake.wanandroid.module.login.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface RegisterContract {

    interface RegisterView extends IView{

    }

    interface RegisterPresenter extends IPresenter<RegisterView>{

    }

    interface RegisterModel extends IModel{

    }
}
