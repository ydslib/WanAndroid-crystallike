/**
 * Created by : yds
 * Time: 2020-12-28 10:48 PM
 */
package com.crystallake.wanandroid.module.me.activity;

import android.content.Context;
import android.content.Intent;

import androidx.viewbinding.ViewBinding;

import com.crystallake.basic.base.activity.BaseMvpActivity;
import com.crystallake.wanandroid.databinding.ActivityShareBinding;
import com.crystallake.wanandroid.module.me.mvp.contract.ShareContract;
import com.crystallake.wanandroid.module.me.mvp.presenter.SharePresenter;

public class ShareActivity extends BaseMvpActivity<SharePresenter> implements ShareContract.ShareView {

    public static void start(Context context){
        Intent intent = new Intent(context,ShareActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected SharePresenter createPresenter() {
        return new SharePresenter();
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected ViewBinding bindView() {
        return ActivityShareBinding.inflate(getLayoutInflater());
    }

    @Override
    public void showMsg(String msg) {

    }
}
