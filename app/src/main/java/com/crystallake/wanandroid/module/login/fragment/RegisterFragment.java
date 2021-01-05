/**
 * Created by : yds
 * Time: 2021-01-04 8:56 PM
 */
package com.crystallake.wanandroid.module.login.fragment;

import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.module.login.mvp.contract.RegisterContract;
import com.crystallake.wanandroid.module.login.mvp.presenter.RegisterPresenter;

public class RegisterFragment extends BaseMvpFragment<RegisterPresenter> implements RegisterContract.RegisterPresenter {

    public static RegisterFragment create(){
        return new RegisterFragment();
    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_register;
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
    public void attachView(RegisterContract.RegisterView mView) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void showMsg(String msg) {

    }
}
