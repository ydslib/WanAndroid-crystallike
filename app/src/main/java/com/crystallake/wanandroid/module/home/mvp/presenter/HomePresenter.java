/**
 * Created by : yds
 * Time: 2020-12-12 8:41 PM
 */
package com.crystallake.wanandroid.module.home.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.basic.http.function.RetryWithDelay;
import com.crystallake.wanandroid.module.home.bean.BannerBean;
import com.crystallake.wanandroid.module.home.mvp.contract.HomeContract;
import com.crystallake.wanandroid.module.home.mvp.model.HomeModel;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleBean;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

public class HomePresenter extends BasePresenter<HomeModel, HomeContract.HomeView>
        implements HomeContract.HomePresenter {

    @Override
    protected HomeModel createModel() {
        return new HomeModel();
    }

    @Override
    public void getTopArticleList(boolean refresh) {
        getModel().getTopArticleList()
                .compose(getView().bindToLife())
                .retryWhen(new RetryWithDelay())
                .subscribe(new Consumer<List<ArticleBean>>() {
                    @Override
                    public void accept(List<ArticleBean> articleBeans) throws Throwable {
                        getView().getTopArticleListSuccess(articleBeans);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        getView().getTopArticleListFailed(throwable.getMessage());
                    }
                });

    }

    @Override
    public void getArticleList(int page, boolean refresh) {
        getModel().getArticleListBean(page, refresh)
                .compose(getView().bindToLife())
                .subscribe(new Consumer<ArticleListBean>() {
                    @Override
                    public void accept(ArticleListBean articleListBean) throws Throwable {
                        getView().getArticleListSuccess(articleListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        getView().getArticleListFailed(throwable.getMessage());
                    }
                });

    }

    @Override
    public void getBannerList() {
        getModel().getBannerList()
                .compose(getView().bindToLife())
                .subscribe(new Consumer<List<BannerBean>>() {
                    @Override
                    public void accept(List<BannerBean> bannerBeans) throws Throwable {
                        getView().getBannerListSuccess(bannerBeans);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        getView().getBannerListFailed(throwable.getMessage());
                    }
                });
    }
}
