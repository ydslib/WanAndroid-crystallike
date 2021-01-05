/**
 * Created by : yds
 * Time: 2020-12-28 10:01 PM
 */
package com.crystallake.wanandroid.module.me.activity;

import android.content.Context;
import android.content.Intent;

import com.crystallake.basic.base.activity.BaseMvpActivity;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.module.me.mvp.contract.CoinContract;
import com.crystallake.wanandroid.module.me.mvp.presenter.CoinPresenter;

public class CoinActivity extends BaseMvpActivity<CoinPresenter> implements CoinContract.CoinView {

    public static void start(Context context) {
        Intent intent = new Intent(context, CoinActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected CoinPresenter createPresenter() {
        return new CoinPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_coin;
    }

    @Override
    protected void initData() {
        mPresenter.getCoin();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void getCoinSuccess(int coin) {

    }

    @Override
    public void getCoinFailed(String msg) {

    }
}
