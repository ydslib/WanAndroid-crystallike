/**
 * Created by : yds
 * Time: 2020-12-12 8:41 PM
 */
package com.crystallake.wanandroid.module.home.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.basic.http.function.RetryWithDelay;
import com.crystallake.wanandroid.module.home.mvp.contract.HomeContract;
import com.crystallake.wanandroid.module.home.mvp.model.HomeModel;

import io.reactivex.rxjava3.disposables.Disposable;

public class HomePresenter extends BasePresenter<HomeModel, HomeContract.HomeView>
        implements HomeContract.HomePresenter {

    @Override
    protected HomeModel createModel() {
        return new HomeModel();
    }

    @Override
    public void getTopArticleList(boolean refresh) {
        Disposable disposable = getModel().getTopArticleList()
                .compose(getView().bindToLife())
                .retryWhen(new RetryWithDelay())
                .subscribe(articleBeans -> getView().getTopArticleListSuccess(articleBeans),
                        throwable -> getView().getTopArticleListFailed(throwable.getMessage()));

        addDispose(disposable);

    }

    @Override
    public void getArticleList(int page, boolean refresh) {
        Disposable disposable = getModel().getArticleListBean(page, refresh)
                .compose(getView().bindToLife())
                .subscribe(articleListBean -> getView().getArticleListSuccess(articleListBean),
                        throwable -> getView().getArticleListFailed(throwable.getMessage()));

        addDispose(disposable);

    }

    @Override
    public void getBannerList() {
        Disposable disposable = getModel().getBannerList()
                .compose(getView().bindToLife())
                .subscribe(bannerBeans -> getView().getBannerListSuccess(bannerBeans),
                        throwable -> getView().getBannerListFailed(throwable.getMessage()));

        addDispose(disposable);
    }
}
