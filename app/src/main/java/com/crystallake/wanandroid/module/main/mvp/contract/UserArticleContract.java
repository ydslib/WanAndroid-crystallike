/**
 * Created by : yds
 * Time: 2020-12-02 10:27 PM
 */
package com.crystallake.wanandroid.module.main.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface UserArticleContract {

    interface UserArticleView extends IView{

    }

    interface UserArticlePresenter extends IPresenter<UserArticleView>{

    }

    interface UserArticleModel extends IModel{

    }
}
