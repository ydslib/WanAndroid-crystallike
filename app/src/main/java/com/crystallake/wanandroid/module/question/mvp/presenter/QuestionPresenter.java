/**
 * Created by : yds
 * Time: 2020-12-12 10:32 PM
 */
package com.crystallake.wanandroid.module.question.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.basic.http.function.RetryWithDelay;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;
import com.crystallake.wanandroid.module.question.mvp.contract.QuestionContract;
import com.crystallake.wanandroid.module.question.mvp.model.QuestionModel;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

public class QuestionPresenter extends BasePresenter<QuestionModel, QuestionContract.QuestionView>
        implements QuestionContract.QuestionPresenter {
    @Override
    protected QuestionModel createModel() {
        return new QuestionModel();
    }

    @Override
    public void getQuestionList(int page, boolean refresh) {
        getModel().getQuestionList(page)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Throwable {
                        if (!refresh) {
                            getView().showLoading();
                        }
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Throwable {
                        if (!refresh) {
                            getView().hideLoading();
                        }
                    }
                })
                .compose(getView().bindToLife())
                .retryWhen(new RetryWithDelay())
                .subscribe(new Consumer<ArticleListBean>() {
                    @Override
                    public void accept(ArticleListBean articleListBean) throws Throwable {
                        getView().getQuestionListSuccess(articleListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        getView().getQuestionFailed(throwable.getMessage());
                    }
                });
    }
}
