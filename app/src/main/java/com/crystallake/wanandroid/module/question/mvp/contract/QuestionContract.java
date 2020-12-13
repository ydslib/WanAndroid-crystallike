/**
 * Created by : yds
 * Time: 2020-12-12 10:30 PM
 */
package com.crystallake.wanandroid.module.question.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface QuestionContract {
    interface QuestionView extends IView{

    }

    interface QuestionPresenter extends IPresenter<QuestionView>{

    }

    interface QuestionModel extends IModel{

    }
}
