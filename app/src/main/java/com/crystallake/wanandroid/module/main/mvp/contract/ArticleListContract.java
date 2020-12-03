/**
 * Created by : yds
 * Time: 2020-12-02 10:27 PM
 */
package com.crystallake.wanandroid.module.main.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface ArticleListContract {

    interface ArticleListView extends IView{

    }

    interface ArticleListPresenter extends IPresenter<ArticleListView>{

    }

    interface ArticleListModel extends IModel{

    }
}
