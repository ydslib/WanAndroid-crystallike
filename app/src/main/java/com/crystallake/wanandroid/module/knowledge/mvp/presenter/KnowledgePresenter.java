/**
 * Created by : yds
 * Time: 2020-12-12 10:38 PM
 */
package com.crystallake.wanandroid.module.knowledge.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.basic.http.function.RetryWithDelay;
import com.crystallake.wanandroid.module.knowledge.bean.ChapterBean;
import com.crystallake.wanandroid.module.knowledge.mvp.contract.KnowledgeContract;
import com.crystallake.wanandroid.module.knowledge.mvp.model.KnowledgeModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;

public class KnowledgePresenter extends BasePresenter<KnowledgeModel, KnowledgeContract.KnowledgeView>
        implements KnowledgeContract.KnowledgePresenter {
    @Override
    protected KnowledgeModel createModel() {
        return new KnowledgeModel();
    }

    @Override
    public void getKnowledgeList() {
        getModel().getKnowledgeList()
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Throwable {
                        getView().showLoading();
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Throwable {
                        getView().hideLoading();
                    }
                })
                .compose(getView().bindToLife())
                .retryWhen(new RetryWithDelay())
                .subscribe(new Consumer<List<ChapterBean>>() {
                    @Override
                    public void accept(List<ChapterBean> chapterBeans) throws Throwable {
                        getView().getKnowledgeListSuccess(chapterBeans);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        getView().getKnowledgeListFailed(throwable.getMessage());
                    }
                });
    }
}
