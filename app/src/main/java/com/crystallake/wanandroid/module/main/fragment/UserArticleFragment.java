/**
 * Created by : yds
 * Time: 2020-12-02 10:26 PM
 */
package com.crystallake.wanandroid.module.main.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.adapter.ArticleAdapter;
import com.crystallake.wanandroid.databinding.FragmentUserArticleBinding;
import com.crystallake.wanandroid.module.main.activity.ShareArticleActivity;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;
import com.crystallake.wanandroid.module.main.mvp.contract.UserArticleContract;
import com.crystallake.wanandroid.module.main.mvp.presenter.UserArticlePresenter;
import com.crystallake.wanandroid.utils.SmartRefreshUtil;
import com.kennyc.view.MultiStateView;

public class UserArticleFragment extends BaseMvpFragment<UserArticlePresenter>
        implements UserArticleContract.UserArticleView {

    private FragmentUserArticleBinding mBinding;

    private static final int PAGE_START = 0;

    private ArticleAdapter mArticleAdapter;

    private SmartRefreshUtil mSmartRefreshUtil;
    private int mCurrPage = PAGE_START;

    public static UserArticleFragment create() {
        return new UserArticleFragment();
    }

    @Override
    protected UserArticlePresenter createPresenter() {
        return new UserArticlePresenter();
    }

    @Override
    protected void initView() {
        mSmartRefreshUtil = SmartRefreshUtil.with(mBinding.smartRefreshUa)
                .pureScrollMode()
                .setRefreshListener(() -> {
                    mCurrPage = PAGE_START;
                    getProjectArticleList(true);
                });

        mSmartRefreshUtil.setLoadMoreListener(() -> getProjectArticleList(true));

        mArticleAdapter = new ArticleAdapter();
        mBinding.recyclerViewUa.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.recyclerViewUa.setAdapter(mArticleAdapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mBinding.actionBarUserArticle.setOnRightIconClickListener(v -> ShareArticleActivity.start(getContext()));
    }

    @Override
    protected ViewBinding bindView(LayoutInflater inflater, ViewGroup container) {
        mBinding = FragmentUserArticleBinding.inflate(inflater,container,false);
        return mBinding;
    }

    @Override
    public void showMsg(String msg) {

    }

    public void getProjectArticleList(boolean refresh) {
        mPresenter.getUserArticleList(mCurrPage, refresh);
    }

    @Override
    public void getUserArticleListSuccess(ArticleListBean data) {
        System.out.println(data.toJson());
        mCurrPage = data.getCurPage() + PAGE_START;
        if (data.getCurPage() == 1) {
            if (data.getDatas() == null || data.getDatas().isEmpty()) {
                mBinding.multiStateViewUa.setViewState(MultiStateView.ViewState.EMPTY);
            } else {
                mBinding.multiStateViewUa.setViewState(MultiStateView.ViewState.CONTENT);
                mArticleAdapter.setNewInstance(data.getDatas());
            }
        } else {
            mArticleAdapter.addData(data.getDatas());
        }
        mSmartRefreshUtil.success();
    }

    @Override
    public void getUserArticleListFailed(String msg) {
//        mMultiStateView.setViewState(MultiStateView.ViewState.ERROR);

        mSmartRefreshUtil.fail();
    }

    @Override
    protected void onVisible(boolean isFirstVisible) {
        super.onVisible(isFirstVisible);
        if (isFirstVisible) {
            mCurrPage = PAGE_START;
            getProjectArticleList(false);
        }
    }

    @Override
    public void showLoading() {
        mBinding.multiStateViewUa.setViewState(MultiStateView.ViewState.LOADING);
    }

    @Override
    public void hideLoading() {
        mBinding.multiStateViewUa.setViewState(MultiStateView.ViewState.CONTENT);
    }
}
