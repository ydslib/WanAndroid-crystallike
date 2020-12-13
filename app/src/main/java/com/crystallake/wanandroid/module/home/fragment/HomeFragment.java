/**
 * Created by : yds
 * Time: 2020-12-12 8:35 PM
 */
package com.crystallake.wanandroid.module.home.fragment;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.module.home.mvp.contract.HomeContract;
import com.crystallake.wanandroid.module.home.mvp.presenter.HomePresenter;

public class HomeFragment extends BaseMvpFragment<HomePresenter> implements HomeContract.HomeView {

    public static HomeFragment create(){
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
