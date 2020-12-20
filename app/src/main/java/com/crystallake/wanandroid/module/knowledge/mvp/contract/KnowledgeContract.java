/**
 * Created by : yds
 * Time: 2020-12-12 10:36 PM
 */
package com.crystallake.wanandroid.module.knowledge.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;
import com.crystallake.wanandroid.module.knowledge.bean.ChapterBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface KnowledgeContract {
    interface KnowledgeView extends IView{
        void getKnowledgeListSuccess(List<ChapterBean> beanList);
        void getKnowledgeListFailed(String msg);
    }

    interface KnowledgePresenter extends IPresenter<KnowledgeView>{
        void getKnowledgeList();
    }

    interface KnowledgeModel extends IModel{
        Observable<List<ChapterBean>> getKnowledgeList();
    }
}
