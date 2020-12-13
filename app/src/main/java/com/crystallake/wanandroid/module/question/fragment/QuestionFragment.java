/**
 * Created by : yds
 * Time: 2020-12-12 10:30 PM
 */
package com.crystallake.wanandroid.module.question.fragment;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.module.question.mvp.contract.QuestionContract;
import com.crystallake.wanandroid.module.question.mvp.presenter.QuestionPresenter;

public class QuestionFragment extends BaseMvpFragment<QuestionPresenter> implements QuestionContract.QuestionView {

    public static QuestionFragment create(){
        return new QuestionFragment();
    }

    @Override
    protected QuestionPresenter createPresenter() {
        return new QuestionPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_question;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showMsg(String msg) {

    }
}
