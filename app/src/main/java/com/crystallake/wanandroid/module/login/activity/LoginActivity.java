/**
 * Created by : yds
 * Time: 2020-12-24 11:52 AM
 */
package com.crystallake.wanandroid.module.login.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.crystallake.wanandroid.R;
import com.crystallake.basic.base.activity.BaseMvpActivity;
import com.crystallake.wanandroid.module.login.mvp.contract.LoginContract;
import com.crystallake.wanandroid.module.login.mvp.presenter.LoginPresenter;

public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.LoginView {

    public static void start(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        if (context instanceof Activity){
            Activity activity = (Activity) context;
            activity.overridePendingTransition(R.anim.swipeback_activity_open_bottom_in,
                    R.anim.swipeback_activity_open_top_out);
        }
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
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
