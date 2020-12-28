/**
 * Created by : yds
 * Time: 2020-12-20 6:04 PM
 */
package com.crystallake.wanandroid.module.navi.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crystallake.wanandroid.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.adapter.NaviAdapter;
import com.crystallake.wanandroid.module.navi.bean.NaviBean;
import com.crystallake.wanandroid.module.navi.mvp.contract.NaviContract;
import com.crystallake.wanandroid.module.navi.mvp.presenter.NaviPresenter;
import com.kennyc.view.MultiStateView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;

public class NaviFragment extends BaseMvpFragment<NaviPresenter> implements NaviContract.NaviView {

    @BindView(R.id.multi_state_view_navi)
    MultiStateView mMultiStateView;
    @BindView(R.id.recycler_navi)
    RecyclerView mRecyclerView;

    private NaviAdapter mNaviAdapter;


    public static NaviFragment create(){
        return new NaviFragment();
    }

    @Override
    protected NaviPresenter createPresenter() {
        return new NaviPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_navi;
    }

    @Override
    protected void initView() {
        mNaviAdapter = new NaviAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mNaviAdapter);
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
    public void getNaviListSuccess(List<NaviBean> data) {
        mNaviAdapter.setNewInstance(data);
        if (data==null||data.isEmpty()){
            mMultiStateView.setViewState(MultiStateView.ViewState.EMPTY);
        }else{
            mMultiStateView.setViewState(MultiStateView.ViewState.CONTENT);
        }
    }

    @Override
    public void getNaviListFailed(String msg) {
        mMultiStateView.setViewState(MultiStateView.ViewState.ERROR);
    }

    private void getNaviList(){
        mPresenter.getNaviList();
    }

    @Override
    protected void onVisible(boolean isFirstVisible) {
        super.onVisible(isFirstVisible);
        if (isFirstVisible){
            getNaviList();
        }
    }
}
