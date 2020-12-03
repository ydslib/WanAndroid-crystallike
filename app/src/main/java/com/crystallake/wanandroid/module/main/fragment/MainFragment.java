/**
 * Created by : yds
 * Time: 2020-12-02 10:18 PM
 */
package com.crystallake.wanandroid.module.main.fragment;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.basic.base.fragment.support.BaseFragment;

public class MainFragment extends BaseFragment {

    public static MainFragment create(){
        return new MainFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_main;
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

}
