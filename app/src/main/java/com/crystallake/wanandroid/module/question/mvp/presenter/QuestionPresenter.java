/**
 * Created by : yds
 * Time: 2020-12-12 10:32 PM
 */
package com.crystallake.wanandroid.module.question.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.question.mvp.contract.QuestionContract;
import com.crystallake.wanandroid.module.question.mvp.model.QuestionModel;

public class QuestionPresenter extends BasePresenter<QuestionModel, QuestionContract.QuestionView>
        implements QuestionContract.QuestionPresenter {
    @Override
    protected QuestionModel createModel() {
        return new QuestionModel();
    }
}
