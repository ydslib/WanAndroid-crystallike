/**
 * Created by : yds
 * Time: 2020-12-29 10:17 PM
 */
package com.crystallake.wanandroid.module.me.activity;

import android.content.Context;
import android.content.Intent;

import androidx.viewbinding.ViewBinding;

import com.crystallake.basic.base.activity.BaseMvpActivity;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.databinding.ActivityReadLaterBinding;
import com.crystallake.wanandroid.module.me.mvp.contract.ReadLaterContract;
import com.crystallake.wanandroid.module.me.mvp.presenter.ReadLaterPresenter;

public class ReadLaterActivity extends BaseMvpActivity<ReadLaterPresenter> implements ReadLaterContract.ReadLaterPresenter {

    public static void start(Context context) {
        Intent intent = new Intent(context, ReadLaterActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected ReadLaterPresenter createPresenter() {
        return new ReadLaterPresenter();
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected ViewBinding bindView() {
        return ActivityReadLaterBinding.inflate(getLayoutInflater());
    }

    @Override
    public void attachView(ReadLaterContract.ReadLaterView mView) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void showMsg(String msg) {

    }
}
