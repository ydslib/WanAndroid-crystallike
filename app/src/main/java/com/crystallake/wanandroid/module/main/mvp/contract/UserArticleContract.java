/**
 * Created by : yds
 * Time: 2020-12-02 10:27 PM
 */
package com.crystallake.wanandroid.module.main.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;

import io.reactivex.rxjava3.core.Observable;

public interface UserArticleContract {

    interface UserArticleView extends IView{
        void getUserArticleListSuccess(int code,ArticleListBean data);
        void getUserArticleListFailed(int code, String msg);
    }

    interface UserArticlePresenter extends IPresenter<UserArticleView>{
        void getUserArticleList(int page, boolean refresh);
    }

    interface UserArticleModel extends IModel{
        Observable<ArticleListBean> getUserArticleList(int page, boolean refresh);
    }
}
