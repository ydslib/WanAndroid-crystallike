/**
 * Created by : yds
 * Time: 2020-12-20 6:04 PM
 */
package com.crystallake.wanandroid.module.navi.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.adapter.NaviAdapter;
import com.crystallake.wanandroid.databinding.FragmentNaviBinding;
import com.crystallake.wanandroid.module.navi.bean.NaviBean;
import com.crystallake.wanandroid.module.navi.mvp.contract.NaviContract;
import com.crystallake.wanandroid.module.navi.mvp.presenter.NaviPresenter;
import com.kennyc.view.MultiStateView;

import java.util.List;


public class NaviFragment extends BaseMvpFragment<NaviPresenter> implements NaviContract.NaviView {

    private FragmentNaviBinding mBinding;

    private NaviAdapter mNaviAdapter;


    public static NaviFragment create(){
        return new NaviFragment();
    }

    @Override
    protected NaviPresenter createPresenter() {
        return new NaviPresenter();
    }


    @Override
    protected void initView() {
        mNaviAdapter = new NaviAdapter();
        mBinding.recyclerNavi.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.recyclerNavi.setAdapter(mNaviAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected ViewBinding bindView(LayoutInflater inflater, ViewGroup container) {
        mBinding = FragmentNaviBinding.inflate(inflater,container,false);
        return mBinding;
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void showLoading() {
        mBinding.multiStateViewNavi.setViewState(MultiStateView.ViewState.LOADING);
    }

    @Override
    public void hideLoading() {
        mBinding.multiStateViewNavi.setViewState(MultiStateView.ViewState.CONTENT);
    }

    @Override
    public void getNaviListSuccess(List<NaviBean> data) {
        mNaviAdapter.setNewInstance(data);
        if (data==null||data.isEmpty()){
            mBinding.multiStateViewNavi.setViewState(MultiStateView.ViewState.EMPTY);
        }else{
            mBinding.multiStateViewNavi.setViewState(MultiStateView.ViewState.CONTENT);
        }
    }

    @Override
    public void getNaviListFailed(String msg) {
        mBinding.multiStateViewNavi.setViewState(MultiStateView.ViewState.ERROR);
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
