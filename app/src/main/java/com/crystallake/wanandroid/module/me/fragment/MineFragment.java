/**
 * Created by : yds
 * Time: 2020-12-12 10:47 PM
 */
package com.crystallake.wanandroid.module.me.fragment;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.module.me.mvp.contract.MineContract;
import com.crystallake.wanandroid.module.me.mvp.presenter.MinePresenter;

public class MineFragment extends BaseMvpFragment<MinePresenter> implements MineContract.MineView {

    public static MineFragment create(){
        return new MineFragment();
    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_mine;
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
