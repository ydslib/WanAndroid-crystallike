/**
 * Created by : yds
 * Time: 2020-12-20 6:04 PM
 */
package com.crystallake.wanandroid.module.navi.fragment;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.module.navi.mvp.contract.NaviContract;
import com.crystallake.wanandroid.module.navi.mvp.presenter.NaviPresenter;

public class NaviFragment extends BaseMvpFragment<NaviPresenter> implements NaviContract.NaviView {

    public static NaviFragment create(){
        return new NaviFragment();
    }

    @Override
    protected NaviPresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_navi;
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
