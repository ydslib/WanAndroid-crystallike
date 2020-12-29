/**
 * Created by : yds
 * Time: 2020-12-29 10:46 PM
 */
package com.crystallake.wanandroid.module.me.activity;

import android.content.Context;
import android.content.Intent;

import com.crystallake.basic.base.activity.BaseMvpActivity;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.module.me.mvp.contract.ReadRecordContract;
import com.crystallake.wanandroid.module.me.mvp.presenter.ReadRecordPresenter;

public class ReadRecordActivity extends BaseMvpActivity<ReadRecordPresenter> implements ReadRecordContract.ReadRecordPresenter {

    public static void start(Context context) {
        Intent intent = new Intent(context, ReadRecordActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected ReadRecordPresenter createPresenter() {
        return new ReadRecordPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_read_record;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void attachView(ReadRecordContract.ReadRecordView mView) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void showMsg(String msg) {

    }
}
