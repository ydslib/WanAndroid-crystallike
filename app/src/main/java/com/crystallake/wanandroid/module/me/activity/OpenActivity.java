/**
 * Created by : yds
 * Time: 2020-12-29 10:53 PM
 */
package com.crystallake.wanandroid.module.me.activity;

import android.content.Context;
import android.content.Intent;

import com.crystallake.basic.base.activity.BaseMvpActivity;
import com.crystallake.wanandroid.module.me.mvp.contract.OpenContract;
import com.crystallake.wanandroid.module.me.mvp.presenter.OpenPresenter;

public class OpenActivity extends BaseMvpActivity<OpenPresenter> implements OpenContract.OpenPresenter {

    public static void start(Context context){
        Intent intent = new Intent(context,OpenActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected OpenPresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutRes() {
        return 0;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void attachView(OpenContract.OpenView mView) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void showMsg(String msg) {

    }
}
