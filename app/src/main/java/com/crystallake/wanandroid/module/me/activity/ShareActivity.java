/**
 * Created by : yds
 * Time: 2020-12-28 10:48 PM
 */
package com.crystallake.wanandroid.module.me.activity;

import android.content.Context;
import android.content.Intent;

import com.crystallake.basic.base.activity.BaseMvpActivity;
import com.crystallake.wanandroid.R;
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
    protected int getLayoutRes() {
        return R.layout.activity_share;
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
