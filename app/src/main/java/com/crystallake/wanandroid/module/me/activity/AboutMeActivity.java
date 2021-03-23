/**
 * Created by : yds
 * Time: 2020-12-28 10:42 PM
 */
package com.crystallake.wanandroid.module.me.activity;

import android.content.Context;
import android.content.Intent;

import androidx.viewbinding.ViewBinding;

import com.crystallake.basic.base.activity.BaseMvpActivity;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.databinding.ActivityAboutMeBinding;
import com.crystallake.wanandroid.module.me.mvp.contract.AboutMeContract;
import com.crystallake.wanandroid.module.me.mvp.presenter.AboutMePresenter;

public class AboutMeActivity extends BaseMvpActivity<AboutMePresenter> implements AboutMeContract.AboutMeView {

    public static void start(Context context) {
        Intent intent = new Intent(context, AboutMeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected AboutMePresenter createPresenter() {
        return new AboutMePresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected ViewBinding bindView() {
        return ActivityAboutMeBinding.inflate(getLayoutInflater());
    }

    @Override
    public void showMsg(String msg) {

    }
}
