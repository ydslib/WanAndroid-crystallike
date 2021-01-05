/**
 * Created by : yds
 * Time: 2020-12-24 11:52 AM
 */
package com.crystallake.wanandroid.module.login.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.crystallake.basic.base.activity.BaseActivity;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.adapter.FixedFragmentPagerAdapter;
import com.crystallake.wanandroid.module.login.fragment.LoginFragment;
import com.crystallake.wanandroid.module.login.fragment.RegisterFragment;

import butterknife.BindView;
import per.goweii.actionbarex.common.ActionBarCommon;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.action_bar)
    ActionBarCommon mBarCommon;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private FixedFragmentPagerAdapter mAdapter;


    public static void start(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        if (context instanceof Activity){
            Activity activity = (Activity) context;
            activity.overridePendingTransition(R.anim.swipeback_activity_open_bottom_in,
                    R.anim.swipeback_activity_open_top_out);
        }
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mAdapter = new FixedFragmentPagerAdapter(getSupportFragmentManager());
        mAdapter.setFragments(LoginFragment.create(), RegisterFragment.create());
        mViewPager.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    public void switchFragment(boolean isLogin){
        if(mViewPager!=null){
            if (isLogin) {
                mViewPager.setCurrentItem(0);
            }else{
                mViewPager.setCurrentItem(1);
            }
        }
    }

}
