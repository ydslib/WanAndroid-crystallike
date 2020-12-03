/**
 * Created by : yds
 * Time: 2020-12-02 10:26 PM
 */
package com.crystallake.wanandroid.module.main.fragment;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.module.main.mvp.contract.ArticleListContract;
import com.crystallake.wanandroid.module.main.mvp.presenter.ArticleListPresenter;

public class ArticleListFragment extends BaseMvpFragment<ArticleListPresenter>
        implements ArticleListContract.ArticleListView {


    public static ArticleListFragment create(){
        return new ArticleListFragment();
    }

    @Override
    protected ArticleListPresenter createPresenter() {
        return new ArticleListPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_article_list;
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
