/**
 * Created by : yds
 * Time: 2020-12-12 8:35 PM
 */
package com.crystallake.wanandroid.module.home.fragment;

import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.adapter.ArticleAdapter;
import com.crystallake.wanandroid.module.home.bean.BannerBean;
import com.crystallake.wanandroid.module.home.mvp.contract.HomeContract;
import com.crystallake.wanandroid.module.home.mvp.presenter.HomePresenter;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleBean;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;
import com.crystallake.wanandroid.utils.DisplayInfoUtils;
import com.crystallake.wanandroid.utils.SmartRefreshUtil;
import com.kennyc.view.MultiStateView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
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
    private Banner mBanner;


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
                        getArticleList(true);
                    }
                }).setLoadMoreListener(new SmartRefreshUtil.LoadMoreListener() {
                    @Override
                    public void onLoadMore() {
                        getArticleList(true);
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
        List<ArticleBean> newData = new ArrayList<>(data);
        List<ArticleBean> oldData = mArticleAdapter.getData();
        for (ArticleBean b : oldData) {
            if (!b.isTop()) {
                newData.add(b);
            }
        }
        mArticleAdapter.setNewInstance(newData);
    }

    @Override
    public void getTopArticleListFailed(String msg) {

    }

    @Override
    public void getArticleListSuccess(ArticleListBean bean) {
        mCurPage = bean.getCurPage() + PAGE_START;
        if (mCurPage == 1) {
            mMultiStateView.setViewState(MultiStateView.ViewState.CONTENT);
            List<ArticleBean> newData = new ArrayList<>();
            List<ArticleBean> data = mArticleAdapter.getData();
            for (ArticleBean b : data) {
                if (b.isTop()) {
                    newData.add(b);
                }
            }
            newData.addAll(bean.getDatas());
            mArticleAdapter.setNewInstance(newData);
        } else {
            mArticleAdapter.addData(bean.getDatas());
        }
        mSmartRefreshUtil.success();
    }

    @Override
    public void getArticleListFailed(String msg) {
        mSmartRefreshUtil.fail();
    }

    @Override
    public void getBannerListSuccess(List<BannerBean> data) {
        createBanner(data);
        mArticleAdapter.addHeaderView(mBanner);
    }

    @Override
    public void getBannerListFailed(String msg) {

    }

    private void getTopArticleList(boolean refresh) {
        mPresenter.getTopArticleList(refresh);
    }

    private void getArticleList(boolean refresh) {
        mPresenter.getArticleList(mCurPage, refresh);
    }

    private void getBannerList() {
        mPresenter.getBannerList();
    }

    @Override
    protected void onVisible(boolean isFirstVisible) {
        super.onVisible(isFirstVisible);
        if (isFirstVisible) {
            showLoading();
            mCurPage = PAGE_START;
            getTopArticleList(false);
            getArticleList(false);
            getBannerList();
        }
    }

    private void createBanner(List<BannerBean> data) {
        if (mBanner == null && getContext() != null) {
            mBanner = new Banner(getContext());
            int height = (int) (DisplayInfoUtils.getInstance().getWidthPixels() * (9F / 16F));
            mBanner.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));
            mBanner.setAdapter(new BannerImageAdapter<BannerBean>(data) {
                @Override
                public void onBindView(BannerImageHolder holder, BannerBean data, int position, int size) {
                    Glide.with(holder.imageView)
                            .load(data.getImagePath())
                            .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                            .into(holder.imageView);
                    System.out.println(data.getUrl());


                }
            })
                    .addBannerLifecycleObserver(this)
                    .setIndicator(new CircleIndicator(getContext()));

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
