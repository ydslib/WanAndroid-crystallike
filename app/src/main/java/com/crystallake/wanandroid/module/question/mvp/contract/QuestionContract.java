/**
 * Created by : yds
 * Time: 2020-12-12 10:30 PM
 */
package com.crystallake.wanandroid.module.question.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;

import io.reactivex.rxjava3.core.Observable;

public interface QuestionContract {
    interface QuestionView extends IView{
        void getQuestionListSuccess(ArticleListBean bean);
        void getQuestionFailed(String msg);
    }

    interface QuestionPresenter extends IPresenter<QuestionView>{
        void getQuestionList(int page,boolean refresh);
    }

    interface QuestionModel extends IModel{
        Observable<ArticleListBean> getQuestionList(int page);
    }
}
