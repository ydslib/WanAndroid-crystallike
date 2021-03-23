/**
 * Created by : yds
 * Time: 2021-01-04 8:51 PM
 */
package com.crystallake.wanandroid.module.login.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.databinding.FragmentLoginBinding;
import com.crystallake.wanandroid.event.LoginEvent;
import com.crystallake.wanandroid.module.login.activity.LoginActivity;
import com.crystallake.wanandroid.module.login.bean.LoginBean;
import com.crystallake.wanandroid.module.login.mvp.contract.LoginContract;
import com.crystallake.wanandroid.module.login.mvp.presenter.LoginPresenter;

public class LoginFragment extends BaseMvpFragment<LoginPresenter> implements LoginContract.LoginView {


    LoginActivity mLoginActivity;

    private FragmentLoginBinding mBinding;

    public static LoginFragment create(){
        return new LoginFragment();
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }


    @Override
    protected void initView() {
        mBinding.llGoRegister.setOnClickListener(this);
        mBinding.svLogin.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mLoginActivity = (LoginActivity) context;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected ViewBinding bindView(LayoutInflater inflater, ViewGroup container) {
        mBinding = FragmentLoginBinding.inflate(inflater,container,false);
        return mBinding;
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    protected boolean isAllowContinuousClick(View v) {
        int id = v.getId();
        if (id == R.id.ll_go_register) {
            mLoginActivity.switchFragment(true);
        } else if (id == R.id.sv_login) {
            String userName = mBinding.pivLoginAccount.getText();
            String password = mBinding.pivLoginPassword.getText();
            mPresenter.login(userName, password);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public void loginSuccess(LoginBean bean) {
        System.out.println("LoginBean:"+bean.toJson());
        new LoginEvent(true).post();
        finish();
    }

    @Override
    public void loginFailed(String msg) {

    }
}
