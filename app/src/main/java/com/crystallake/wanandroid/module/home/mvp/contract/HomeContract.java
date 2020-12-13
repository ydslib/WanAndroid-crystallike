/**
 * Created by : yds
 * Time: 2020-12-12 8:36 PM
 */
package com.crystallake.wanandroid.module.home.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface HomeContract {
    interface HomeView extends IView{
        void getTopArticleListSuccess(List<ArticleBean> data);
        void getTopArticleListFailed(String msg);
    }

    interface HomePresenter extends IPresenter<HomeView>{
        void getTopArticleList(boolean refresh);
    }

    interface HomeModel extends IModel{
        Observable<List<ArticleBean>> getTopArticleList();
    }
}
