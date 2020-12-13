/**
 * Created by : yds
 * Time: 2020-12-12 10:39 PM
 */
package com.crystallake.wanandroid.module.knowledge.fragment;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.module.knowledge.mvp.contract.KnowledgeContract;
import com.crystallake.wanandroid.module.knowledge.mvp.presenter.KnowledgePresenter;

public class KnowledgeFragment extends BaseMvpFragment<KnowledgePresenter> implements KnowledgeContract.KnowledgeView {
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
}
