/**
 * Created by : yds
 * Time: 2020-12-29 10:58 PM
 */
package com.crystallake.wanandroid.module.me.activity;

import android.content.Context;
import android.content.Intent;

import com.crystallake.basic.base.activity.BaseMvpActivity;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.module.me.mvp.contract.SettingContract;
import com.crystallake.wanandroid.module.me.mvp.presenter.SettingPresenter;

public class SettingActivity extends BaseMvpActivity<SettingPresenter> implements SettingContract.SettingPresenter {

    public static void start(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected SettingPresenter createPresenter() {
        return new SettingPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void attachView(SettingContract.SettingView mView) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void showMsg(String msg) {

    }
}
