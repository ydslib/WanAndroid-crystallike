/**
 * Created by : yds
 * Time: 2020-12-12 10:30 PM
 */
package com.crystallake.wanandroid.module.question.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crystallake.wanandroid.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.adapter.ArticleAdapter;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;
import com.crystallake.wanandroid.module.question.mvp.contract.QuestionContract;
import com.crystallake.wanandroid.module.question.mvp.presenter.QuestionPresenter;
import com.crystallake.wanandroid.utils.SmartRefreshUtil;
import com.kennyc.view.MultiStateView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import per.goweii.actionbarex.common.ActionBarCommon;

public class QuestionFragment extends BaseMvpFragment<QuestionPresenter> implements QuestionContract.QuestionView {


    private static final int PAGE_START = 1;

    @BindView(R.id.question_action_bar)
    ActionBarCommon mBarCommon;
    @BindView(R.id.question_multistateview)
    MultiStateView mMultiStateView;
    @BindView(R.id.question_smart_refresh)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.question_recycler)
    RecyclerView mRecyclerView;

    private SmartRefreshUtil mSmartRefreshUtil;
    private ArticleAdapter mArticleAdapter;

    private int mCurrPage = PAGE_START;

    public static QuestionFragment create() {
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
        mSmartRefreshUtil = SmartRefreshUtil.with(mSmartRefreshLayout)
                .pureScrollMode()
                .setRefreshListener(new SmartRefreshUtil.RefreshListener() {
                    @Override
                    public void onRefresh() {
                        mCurrPage = PAGE_START;
                        getQuestionList(true);
                    }
                })
                .setLoadMoreListener(new SmartRefreshUtil.LoadMoreListener() {
                    @Override
                    public void onLoadMore() {
                        getQuestionList(true);
                    }
                });

        mArticleAdapter = new ArticleAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mArticleAdapter);

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

    @Override
    public void showLoading() {
        mMultiStateView.setViewState(MultiStateView.ViewState.LOADING);
    }

    @Override
    public void hideLoading() {
        mMultiStateView.setViewState(MultiStateView.ViewState.CONTENT);
    }

    @Override
    public void getQuestionListSuccess(ArticleListBean bean) {
        mCurrPage = bean.getCurPage() + PAGE_START;
        if (mCurrPage == 1) {
            if (bean.getDatas() != null && !bean.getDatas().isEmpty()) {
                mMultiStateView.setViewState(MultiStateView.ViewState.CONTENT);
                mArticleAdapter.setNewInstance(bean.getDatas());
            } else {
                mMultiStateView.setViewState(MultiStateView.ViewState.EMPTY);
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
        if (isFirstVisible){
            mCurrPage = PAGE_START;
            getQuestionList(false);
        }

    }
}
