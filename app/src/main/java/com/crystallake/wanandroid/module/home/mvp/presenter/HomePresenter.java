/**
 * Created by : yds
 * Time: 2020-12-12 8:41 PM
 */
package com.crystallake.wanandroid.module.home.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.basic.http.function.RetryWithDelay;
import com.crystallake.wanandroid.module.home.mvp.contract.HomeContract;
import com.crystallake.wanandroid.module.home.mvp.model.HomeModel;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleBean;

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
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Throwable {
                        if (!refresh){
                            getView().showLoading();
                        }
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Throwable {
                        if (!refresh){
                            getView().hideLoading();
                        }
                    }
                })
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
}
