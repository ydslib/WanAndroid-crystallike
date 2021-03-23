/**
 * Created by : yds
 * Time: 2020-12-12 10:32 PM
 */
package com.crystallake.wanandroid.module.question.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.basic.http.function.RetryWithDelay;
import com.crystallake.wanandroid.module.question.mvp.contract.QuestionContract;
import com.crystallake.wanandroid.module.question.mvp.model.QuestionModel;

import io.reactivex.rxjava3.disposables.Disposable;

public class QuestionPresenter extends BasePresenter<QuestionModel, QuestionContract.QuestionView>
        implements QuestionContract.QuestionPresenter {
    @Override
    protected QuestionModel createModel() {
        return new QuestionModel();
    }

    @Override
    public void getQuestionList(int page, boolean refresh) {
        Disposable disposable1 = getModel().getQuestionList(page)
                .doOnSubscribe(disposable -> {
                    if (!refresh) {
                        getView().showLoading();
                    }
                })
                .doFinally(() -> {
                    if (!refresh) {
                        getView().hideLoading();
                    }
                })
                .compose(getView().bindToLife())
                .retryWhen(new RetryWithDelay())
                .subscribe(articleListBean -> getView().getQuestionListSuccess(articleListBean),
                        throwable -> getView().getQuestionFailed(throwable.getMessage()));
        addDispose(disposable1);
    }
}
