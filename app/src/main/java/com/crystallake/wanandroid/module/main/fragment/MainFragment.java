/**
 * Created by : yds
 * Time: 2020-12-02 10:18 PM
 */
package com.crystallake.wanandroid.module.main.fragment;

import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.support.BaseFragment;
import com.crystallake.wanandroid.adapter.MainTabAdapter;
import com.crystallake.wanandroid.adapter.TabFragmentPageAdapter;
import com.crystallake.wanandroid.entity.TabEntity;
import com.crystallake.wanandroid.module.home.fragment.HomeFragment;
import com.crystallake.wanandroid.module.me.fragment.MineFragment;
import com.crystallake.wanandroid.module.question.fragment.QuestionFragment;

import butterknife.BindView;

public class MainFragment extends BaseFragment {

    @BindView(R.id.nav_view_pager)
    ViewPager mViewPager;
    @BindView(R.id.container)
    LinearLayout mContainer;

    private TabFragmentPageAdapter<TabEntity> mPageAdapter;

    public static MainFragment create(){
        return new MainFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        mPageAdapter = new TabFragmentPageAdapter<>(getChildFragmentManager(),
                mViewPager,mContainer,R.layout.tab_item_main);

        mPageAdapter.setPages(new TabFragmentPageAdapter.Page<>(HomeFragment.create(),new TabEntity("首页",R.drawable.ic_bottom_bar_home,-1),new MainTabAdapter()),
                new TabFragmentPageAdapter.Page<>(QuestionFragment.create(),new TabEntity("问答",R.drawable.ic_bottom_bar_wechat,-1),new MainTabAdapter()),
                new TabFragmentPageAdapter.Page<>(KnowledgeNavigationFragment.create(),new TabEntity("体系",R.drawable.ic_bottom_bar_navi,-1),new MainTabAdapter()),
                new TabFragmentPageAdapter.Page<>(MineFragment.create(),new TabEntity("我的",R.drawable.ic_bottom_bar_mine,-1),new MainTabAdapter()));
    }

    @Override
    protected void initData() {
        mPageAdapter.notifyPageDataChange();
    }

    @Override
    protected void initListener() {

    }

}
