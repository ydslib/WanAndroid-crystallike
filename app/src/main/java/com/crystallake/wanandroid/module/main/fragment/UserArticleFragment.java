/**
 * Created by : yds
 * Time: 2020-12-02 10:26 PM
 */
package com.crystallake.wanandroid.module.main.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.http.response.WanResponse;
import com.crystallake.wanandroid.module.main.activity.ShareArticleActivity;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;
import com.crystallake.wanandroid.module.main.mvp.contract.UserArticleContract;
import com.crystallake.wanandroid.module.main.mvp.presenter.UserArticlePresenter;
import com.crystallake.wanandroid.utils.SmartRefreshUtil;
import com.kennyc.view.MultiStateView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import per.goweii.actionbarex.common.ActionBarCommon;
import per.goweii.actionbarex.common.OnActionBarChildClickListener;

public class UserArticleFragment extends BaseMvpFragment<UserArticlePresenter>
        implements UserArticleContract.UserArticleView {

    private static final int PAGE_START = 0;

    @BindView(R.id.action_bar_user_article)
    ActionBarCommon mActionBarCommon;
    @BindView(R.id.multi_state_view_ua)
    MultiStateView mMultiStateView;
    @BindView(R.id.smart_refresh_ua)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.recycler_view_ua)
    RecyclerView mRecyclerView;

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
    protected int getLayoutRes() {
        return R.layout.fragment_user_article;
    }

    @Override
    protected void initView() {
        mSmartRefreshUtil = SmartRefreshUtil.with(mSmartRefreshLayout)
                .pureScrollMode()
                .setRefreshListener(new SmartRefreshUtil.RefreshListener() {
                    @Override
                    public void onRefresh() {
                        mCurrPage = PAGE_START;
                        getProjectArticleList(true);
                    }
                });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mActionBarCommon.setOnRightIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                ShareArticleActivity.start(getContext());
            }
        });
    }

    @Override
    public void showMsg(String msg) {

    }

    public void getProjectArticleList(boolean refresh) {
        mPresenter.getUserArticleList(mCurrPage, refresh);
    }

    @Override
    public void getUserArticleListSuccess(int code, WanResponse<ArticleListBean> data) {
        System.out.println(data.getData().toJson());
//        mMultiStateView.setViewState(MultiStateView.ViewState.ERROR);
    }

    @Override
    public void getUserArticleListFailed(int code, String msg) {
//        mMultiStateView.setViewState(MultiStateView.ViewState.ERROR);
    }

    @Override
    protected void onVisible(boolean isFirstVisible) {
        super.onVisible(isFirstVisible);
        if (isFirstVisible) {
            mCurrPage = PAGE_START;
            getProjectArticleList(false);
        }
    }
}
