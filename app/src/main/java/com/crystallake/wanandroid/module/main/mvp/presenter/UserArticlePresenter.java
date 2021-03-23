/**
 * Created by : yds
 * Time: 2020-12-02 10:37 PM
 */
package com.crystallake.wanandroid.module.main.mvp.presenter;


import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.basic.http.function.RetryWithDelay;
import com.crystallake.wanandroid.module.main.mvp.contract.UserArticleContract;
import com.crystallake.wanandroid.module.main.mvp.model.UserArticleModel;

import io.reactivex.rxjava3.disposables.Disposable;
import timber.log.Timber;

public class UserArticlePresenter extends BasePresenter<UserArticleModel, UserArticleContract.UserArticleView>
        implements UserArticleContract.UserArticlePresenter {
    @Override
    protected UserArticleModel createModel() {
        return new UserArticleModel();
    }

    @Override
    public void getUserArticleList(int page, boolean refresh) {
        Disposable disposable1 = getModel().getUserArticleList(page, refresh)
                .doOnSubscribe(disposable -> {
                    if (!refresh) {
                        getView().showLoading();
                    }
                })
                .doFinally(() -> {
                    if (!refresh) {
                        getView().hideLoading();
                    }
                }).compose(getView().bindToLife())
                .retryWhen(new RetryWithDelay())
                .subscribe(articleListBean -> getView().getUserArticleListSuccess(articleListBean),
                        throwable -> {
                            Timber.d(throwable);
                            getView().showErrorMsg("未知错误");
                        });

        addDispose(disposable1);
    }
}
