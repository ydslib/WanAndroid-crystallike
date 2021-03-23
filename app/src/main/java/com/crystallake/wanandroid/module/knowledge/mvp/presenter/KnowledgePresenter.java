/**
 * Created by : yds
 * Time: 2020-12-12 10:38 PM
 */
package com.crystallake.wanandroid.module.knowledge.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.basic.http.function.RetryWithDelay;
import com.crystallake.wanandroid.module.knowledge.mvp.contract.KnowledgeContract;
import com.crystallake.wanandroid.module.knowledge.mvp.model.KnowledgeModel;


import io.reactivex.rxjava3.disposables.Disposable;

public class KnowledgePresenter extends BasePresenter<KnowledgeModel, KnowledgeContract.KnowledgeView>
        implements KnowledgeContract.KnowledgePresenter {
    @Override
    protected KnowledgeModel createModel() {
        return new KnowledgeModel();
    }

    @Override
    public void getKnowledgeList() {
        Disposable disposable = getModel().getKnowledgeList()
                .doOnSubscribe(disposable1 -> getView().showLoading())
                .doFinally(() -> getView().hideLoading())
                .compose(getView().bindToLife())
                .retryWhen(new RetryWithDelay())
                .subscribe(chapterBeans -> getView().getKnowledgeListSuccess(chapterBeans),
                        throwable -> getView().getKnowledgeListFailed(throwable.getMessage()));

        addDispose(disposable);
    }
}
