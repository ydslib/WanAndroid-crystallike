package com.crystallake.wanandroid.module.main.activity;


import android.os.Bundle;

import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;

import com.crystallake.basic.base.activity.BaseMvpActivity;
import com.crystallake.wanandroid.adapter.FixedFragmentPagerAdapter;
import com.crystallake.wanandroid.databinding.ActivityMainBinding;
import com.crystallake.wanandroid.module.main.fragment.UserArticleFragment;
import com.crystallake.wanandroid.module.main.fragment.MainFragment;
import com.crystallake.wanandroid.module.main.mvp.contract.MainContract;
import com.crystallake.wanandroid.module.main.mvp.presenter.MainPresenter;


public class MainActivity extends BaseMvpActivity<MainPresenter>
        implements MainContract.MainView, ViewPager.OnPageChangeListener {


    private ActivityMainBinding mBinding;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mBinding.mainViewPager.addOnPageChangeListener(this);
        FixedFragmentPagerAdapter adapter = new FixedFragmentPagerAdapter(getSupportFragmentManager());
        adapter.setFragments(UserArticleFragment.create(), MainFragment.create());
        mBinding.mainViewPager.setAdapter(adapter);
        mBinding.mainViewPager.setCurrentItem(1);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected ViewBinding bindView() {
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        return mBinding;
    }

    @Override
    protected boolean swipeBackEnable() {
        return false;
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}