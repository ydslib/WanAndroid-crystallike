/**
 * Created by : yds
 * Time: 2020-12-12 10:39 PM
 */
package com.crystallake.wanandroid.module.knowledge.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.adapter.KnowledgeAdapter;
import com.crystallake.wanandroid.databinding.FragmentKnowledgeBinding;
import com.crystallake.wanandroid.module.knowledge.bean.ChapterBean;
import com.crystallake.wanandroid.module.knowledge.mvp.contract.KnowledgeContract;
import com.crystallake.wanandroid.module.knowledge.mvp.presenter.KnowledgePresenter;
import com.kennyc.view.MultiStateView;

import java.util.List;


public class KnowledgeFragment extends BaseMvpFragment<KnowledgePresenter> implements KnowledgeContract.KnowledgeView {


    private FragmentKnowledgeBinding mBinding;

    private KnowledgeAdapter mAdapter;


    public static KnowledgeFragment create() {
        return new KnowledgeFragment();
    }

    @Override
    protected KnowledgePresenter createPresenter() {
        return new KnowledgePresenter();
    }


    @Override
    protected void initView() {
        mAdapter = new KnowledgeAdapter();
        mBinding.knowledgeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.knowledgeRecycler.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected ViewBinding bindView(LayoutInflater inflater, ViewGroup container) {
        mBinding = FragmentKnowledgeBinding.inflate(inflater, container, false);
        return mBinding;
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void getKnowledgeListSuccess(List<ChapterBean> beanList) {
        mBinding.knowledgeMultiStateView.setViewState(MultiStateView.ViewState.CONTENT);
        mAdapter.setNewInstance(beanList);
    }

    public void getKnowledgeList() {
        mPresenter.getKnowledgeList();
    }

    @Override
    public void getKnowledgeListFailed(String msg) {
        Log.e("getKnowledgeListFailed", msg);
    }

    @Override
    public void showLoading() {
        mBinding.knowledgeMultiStateView.setViewState(MultiStateView.ViewState.LOADING);
    }

    @Override
    public void hideLoading() {
        mBinding.knowledgeMultiStateView.setViewState(MultiStateView.ViewState.CONTENT);
    }

    @Override
    protected void onVisible(boolean isFirstVisible) {
        super.onVisible(isFirstVisible);
        if (isFirstVisible) {
            getKnowledgeList();
        }
    }
}
