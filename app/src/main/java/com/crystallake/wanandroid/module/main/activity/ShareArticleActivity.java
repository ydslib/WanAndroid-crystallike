/**
 * Created by : yds
 * Time: 2020-12-06 5:37 PM
 */
package com.crystallake.wanandroid.module.main.activity;

import android.content.Context;
import android.content.Intent;

import com.crystallake.wanandroid.R;
import com.crystallake.basic.base.activity.BaseMvpActivity;
import com.crystallake.wanandroid.module.main.mvp.contract.ShareArticleContract;
import com.crystallake.wanandroid.module.main.mvp.presenter.ShareArticlePresenter;

public class ShareArticleActivity extends BaseMvpActivity<ShareArticlePresenter> implements ShareArticleContract.ShareArticleView {

    public static void start(Context context){
        start(context,"");
    }

    private static void start(Context context, String link) {
        start(context,"",link);
    }

    private static void start(Context context, String title, String link) {
        Intent intent = new Intent(context,ShareArticleActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("link",link);
        context.startActivity(intent);
    }

    @Override
    protected ShareArticlePresenter createPresenter() {
        return new ShareArticlePresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_share_article;
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
