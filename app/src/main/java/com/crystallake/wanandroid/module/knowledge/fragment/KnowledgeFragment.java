/**
 * Created by : yds
 * Time: 2020-12-12 10:39 PM
 */
package com.crystallake.wanandroid.module.knowledge.fragment;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.adapter.KnowledgeAdapter;
import com.crystallake.wanandroid.module.knowledge.bean.ChapterBean;
import com.crystallake.wanandroid.module.knowledge.mvp.contract.KnowledgeContract;
import com.crystallake.wanandroid.module.knowledge.mvp.presenter.KnowledgePresenter;
import com.kennyc.view.MultiStateView;

import java.util.List;

import butterknife.BindView;

public class KnowledgeFragment extends BaseMvpFragment<KnowledgePresenter> implements KnowledgeContract.KnowledgeView {

    @BindView(R.id.knowledge_multi_state_view)
    MultiStateView mMultiStateView;
    @BindView(R.id.knowledge_recycler)
    RecyclerView mRecyclerView;

    private KnowledgeAdapter mAdapter;


    public static KnowledgeFragment create() {
        return new KnowledgeFragment();
    }

    @Override
    protected KnowledgePresenter createPresenter() {
        return new KnowledgePresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_knowledge;
    }

    @Override
    protected void initView() {
        mAdapter = new KnowledgeAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
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
    public void getKnowledgeListSuccess(List<ChapterBean> beanList) {
        mMultiStateView.setViewState(MultiStateView.ViewState.CONTENT);
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
        mMultiStateView.setViewState(MultiStateView.ViewState.LOADING);
    }

    @Override
    public void hideLoading() {
        mMultiStateView.setViewState(MultiStateView.ViewState.CONTENT);
    }

    @Override
    protected void onVisible(boolean isFirstVisible) {
        super.onVisible(isFirstVisible);
        if (isFirstVisible) {
            getKnowledgeList();
        }
    }
}
