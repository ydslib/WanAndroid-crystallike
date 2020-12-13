/**
 * Created by : yds
 * Time: 2020-12-12 8:35 PM
 */
package com.crystallake.wanandroid.module.home.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.adapter.ArticleAdapter;
import com.crystallake.wanandroid.module.home.mvp.contract.HomeContract;
import com.crystallake.wanandroid.module.home.mvp.presenter.HomePresenter;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleBean;
import com.crystallake.wanandroid.utils.SmartRefreshUtil;
import com.kennyc.view.MultiStateView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import per.goweii.actionbarex.common.ActionBarCommon;

public class HomeFragment extends BaseMvpFragment<HomePresenter> implements HomeContract.HomeView {

    private static final int PAGE_START = 0;

    @BindView(R.id.action_bar_user_article)
    ActionBarCommon mBarCommon;
    @BindView(R.id.home_multi_state)
    MultiStateView mMultiStateView;
    @BindView(R.id.home_smart_refresh)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.home_recycler_view)
    RecyclerView mRecyclerView;

    private ArticleAdapter mArticleAdapter;
    private SmartRefreshUtil mSmartRefreshUtil;
    private int mCurPage = PAGE_START;


    public static HomeFragment create() {
        return new HomeFragment();
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        mSmartRefreshUtil = SmartRefreshUtil.with(mRefreshLayout)
                .pureScrollMode()
                .setRefreshListener(new SmartRefreshUtil.RefreshListener() {
                    @Override
                    public void onRefresh() {
                        mCurPage = PAGE_START;
                        getTopArticleList(true);
                    }
                }).setLoadMoreListener(new SmartRefreshUtil.LoadMoreListener() {
                    @Override
                    public void onLoadMore() {

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
    public void getTopArticleListSuccess(List<ArticleBean> data) {
        System.out.println(data.get(0).toJson());
        for (ArticleBean bean : data) {
            bean.setTop(true);
        }
        mArticleAdapter.setNewInstance(data);

    }

    @Override
    public void getTopArticleListFailed(String msg) {

    }

    private void getTopArticleList(boolean refresh) {
        mPresenter.getTopArticleList(refresh);
    }

    @Override
    protected void onVisible(boolean isFirstVisible) {
        super.onVisible(isFirstVisible);
        if (isFirstVisible) {
            mCurPage = PAGE_START;
            getTopArticleList(false);
        }
    }

    @Override
    public void showLoading() {
        mMultiStateView.setViewState(MultiStateView.ViewState.LOADING);
    }

    @Override
    public void hideLoading() {
        mMultiStateView.setViewState(MultiStateView.ViewState.CONTENT);
    }
}
