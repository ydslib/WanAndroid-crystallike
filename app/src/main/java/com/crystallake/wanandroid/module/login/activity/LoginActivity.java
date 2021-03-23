/**
 * Created by : yds
 * Time: 2020-12-24 11:52 AM
 */
package com.crystallake.wanandroid.module.login.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.crystallake.basic.base.activity.BaseActivity;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.adapter.FixedFragmentPagerAdapter;
import com.crystallake.wanandroid.databinding.ActivityLoginBinding;
import com.crystallake.wanandroid.module.login.fragment.LoginFragment;
import com.crystallake.wanandroid.module.login.fragment.RegisterFragment;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding mBinding;


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
    protected void initView(Bundle savedInstanceState) {
        FixedFragmentPagerAdapter adapter = new FixedFragmentPagerAdapter(getSupportFragmentManager());
        adapter.setFragments(LoginFragment.create(), RegisterFragment.create());
        mBinding.viewPager.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected ViewBinding bindView() {
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        return mBinding;
    }

    public void switchFragment(boolean isLogin){
        if (isLogin) {
            mBinding.viewPager.setCurrentItem(0);
        }else{
            mBinding.viewPager.setCurrentItem(1);
        }
    }

}
