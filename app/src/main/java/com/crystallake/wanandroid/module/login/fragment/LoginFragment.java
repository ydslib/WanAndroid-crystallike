/**
 * Created by : yds
 * Time: 2021-01-04 8:51 PM
 */
package com.crystallake.wanandroid.module.login.fragment;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.event.LoginEvent;
import com.crystallake.wanandroid.module.login.activity.LoginActivity;
import com.crystallake.wanandroid.module.login.bean.LoginBean;
import com.crystallake.wanandroid.module.login.mvp.contract.LoginContract;
import com.crystallake.wanandroid.module.login.mvp.presenter.LoginPresenter;
import com.crystallake.wanandroid.utils.InputView;
import com.crystallake.wanandroid.utils.PasswordInputView;
import com.crystallake.wanandroid.utils.SubmitView;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginFragment extends BaseMvpFragment<LoginPresenter> implements LoginContract.LoginView {

    @BindView(R.id.ll_go_register)
    LinearLayout mGoRegister;
    @BindView(R.id.piv_login_account)
    InputView mUserName;
    @BindView(R.id.piv_login_password)
    PasswordInputView mPassword;
    @BindView(R.id.sv_login)
    SubmitView mSubmitView;

    LoginActivity mLoginActivity;

    public static LoginFragment create(){
        return new LoginFragment();
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView() {

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
    public void showMsg(String msg) {

    }

    @OnClick({R.id.ll_go_register,R.id.sv_login})
    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    protected boolean isAllowContinuousClick(View v) {
        switch (v.getId()){
            default:
                return false;
            case R.id.ll_go_register:
                mLoginActivity.switchFragment(true);
                break;
            case R.id.sv_login:
                String userName = mUserName.getText();
                String password = mPassword.getText();
                mPresenter.login(userName,password);
                break;

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
