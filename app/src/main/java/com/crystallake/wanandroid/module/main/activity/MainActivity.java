package com.crystallake.wanandroid.module.main.activity;


import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.activity.BaseMvpActivity;
import com.crystallake.wanandroid.adapter.FixedFragmentPagerAdapter;
import com.crystallake.wanandroid.module.main.fragment.ArticleListFragment;
import com.crystallake.wanandroid.module.main.fragment.MainFragment;
import com.crystallake.wanandroid.module.main.mvp.contract.MainContract;
import com.crystallake.wanandroid.module.main.mvp.presenter.MainPresenter;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter>
        implements MainContract.MainView, ViewPager.OnPageChangeListener {

    @BindView(R.id.main_view_pager)
    ViewPager mViewPager;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mViewPager.addOnPageChangeListener(this);
        FixedFragmentPagerAdapter adapter = new FixedFragmentPagerAdapter(getSupportFragmentManager());
        adapter.setFragments(ArticleListFragment.create(), MainFragment.create());
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(1);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

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