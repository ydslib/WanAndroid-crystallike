/**
 * Created by : yds
 * Time: 2020-12-12 10:30 PM
 */
package com.crystallake.wanandroid.module.question.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.adapter.ArticleAdapter;
import com.crystallake.wanandroid.databinding.FragmentQuestionBinding;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;
import com.crystallake.wanandroid.module.question.mvp.contract.QuestionContract;
import com.crystallake.wanandroid.module.question.mvp.presenter.QuestionPresenter;
import com.crystallake.wanandroid.utils.SmartRefreshUtil;
import com.kennyc.view.MultiStateView;

public class QuestionFragment extends BaseMvpFragment<QuestionPresenter> implements QuestionContract.QuestionView {


    private static final int PAGE_START = 1;
    private SmartRefreshUtil mSmartRefreshUtil;
    private ArticleAdapter mArticleAdapter;

    private FragmentQuestionBinding mBinding;

    private int mCurrPage = PAGE_START;

    public static QuestionFragment create() {
        return new QuestionFragment();
    }

    @Override
    protected QuestionPresenter createPresenter() {
        return new QuestionPresenter();
    }


    @Override
    protected void initView() {
        mSmartRefreshUtil = SmartRefreshUtil.with(mBinding.questionSmartRefresh)
                .pureScrollMode()
                .setRefreshListener(() -> {
                    mCurrPage = PAGE_START;
                    getQuestionList(true);
                })
                .setLoadMoreListener(() -> getQuestionList(true));

        mArticleAdapter = new ArticleAdapter();
        mBinding.questionRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.questionRecycler.setAdapter(mArticleAdapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected ViewBinding bindView(LayoutInflater inflater, ViewGroup container) {
        mBinding = FragmentQuestionBinding.inflate(inflater, container, false);
        return mBinding;
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void showLoading() {
        mBinding.questionMultistateview.setViewState(MultiStateView.ViewState.LOADING);
    }

    @Override
    public void hideLoading() {
        mBinding.questionMultistateview.setViewState(MultiStateView.ViewState.CONTENT);
    }

    @Override
    public void getQuestionListSuccess(ArticleListBean bean) {
        mCurrPage = bean.getCurPage() + PAGE_START;
        if (mCurrPage == 1) {
            if (bean.getDatas() != null && !bean.getDatas().isEmpty()) {
                mBinding.questionMultistateview.setViewState(MultiStateView.ViewState.CONTENT);
                mArticleAdapter.setNewInstance(bean.getDatas());
            } else {
                mBinding.questionMultistateview.setViewState(MultiStateView.ViewState.EMPTY);
            }
        } else {
            mArticleAdapter.addData(bean.getDatas());
        }
        mSmartRefreshUtil.success();

    }

    @Override
    public void getQuestionFailed(String msg) {
        mSmartRefreshUtil.fail();
    }

    private void getQuestionList(boolean refresh) {
        mPresenter.getQuestionList(mCurrPage, refresh);
    }

    @Override
    protected void onVisible(boolean isFirstVisible) {
        super.onVisible(isFirstVisible);
        if (isFirstVisible) {
            mCurrPage = PAGE_START;
            getQuestionList(false);
        }

    }
}
