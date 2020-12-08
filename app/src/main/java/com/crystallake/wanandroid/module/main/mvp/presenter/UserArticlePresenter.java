/**
 * Created by : yds
 * Time: 2020-12-02 10:37 PM
 */
package com.crystallake.wanandroid.module.main.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.basic.http.function.RetryWithDelay;
import com.crystallake.wanandroid.http.response.WanResponse;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;
import com.crystallake.wanandroid.module.main.mvp.contract.UserArticleContract;
import com.crystallake.wanandroid.module.main.mvp.model.UserArticleModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserArticlePresenter extends BasePresenter<UserArticleModel, UserArticleContract.UserArticleView>
        implements UserArticleContract.UserArticlePresenter {
    @Override
    protected UserArticleModel createModel() {
        return new UserArticleModel();
    }

    @Override
    public void getUserArticleList(int page, boolean refresh) {
        getModel().getUserArticleList(page,refresh)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Throwable {
                        getView().showLoading();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(new Action() {
                    @Override
                    public void run() throws Throwable {
                        getView().hideLoading();
                    }
                }).compose(getView().<WanResponse<ArticleListBean>>bindToLife())
                .retryWhen(new RetryWithDelay())
                .subscribe(new Consumer<WanResponse<ArticleListBean>>() {
                    @Override
                    public void accept(WanResponse<ArticleListBean> articleListBean) throws Throwable {
                        getView().getUserArticleListSuccess(0, articleListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {

                    }
                });
    }
}
