/**
 * Created by : yds
 * Time: 2020-12-02 10:26 PM
 */
package com.crystallake.wanandroid.module.main.fragment;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.module.main.mvp.contract.UserArticleContract;
import com.crystallake.wanandroid.module.main.mvp.presenter.UserArticlePresenter;

public class UserArticleFragment extends BaseMvpFragment<UserArticlePresenter>
        implements UserArticleContract.UserArticleView {


    public static UserArticleFragment create(){
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
