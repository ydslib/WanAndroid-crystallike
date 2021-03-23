/**
 * Created by : yds
 * Time: 2020-12-28 10:53 PM
 */
package com.crystallake.wanandroid.module.me.activity;

import android.content.Context;
import android.content.Intent;

import androidx.viewbinding.ViewBinding;

import com.crystallake.basic.base.activity.BaseMvpActivity;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.databinding.ActivityCollectBinding;
import com.crystallake.wanandroid.module.me.mvp.contract.CollectContract;
import com.crystallake.wanandroid.module.me.mvp.presenter.CollectPresenter;

public class CollectActivity extends BaseMvpActivity<CollectPresenter> implements CollectContract.CollectView {

    public static void start(Context context){
        Intent intent = new Intent(context,CollectActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected CollectPresenter createPresenter() {
        return new CollectPresenter();
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected ViewBinding bindView() {
        return ActivityCollectBinding.inflate(getLayoutInflater());
    }

    @Override
    public void showMsg(String msg) {

    }
}
