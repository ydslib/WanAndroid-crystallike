/**
 * Created by : yds
 * Time: 2020-12-02 10:18 PM
 */
package com.crystallake.wanandroid.module.main.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.crystallake.wanandroid.R;
import com.crystallake.basic.base.fragment.support.BaseFragment;
import com.crystallake.wanandroid.adapter.MainTabAdapter;
import com.crystallake.wanandroid.adapter.TabFragmentPageAdapter;
import com.crystallake.wanandroid.databinding.FragmentMainBinding;
import com.crystallake.wanandroid.entity.TabEntity;
import com.crystallake.wanandroid.module.home.fragment.HomeFragment;
import com.crystallake.wanandroid.module.me.fragment.MineFragment;
import com.crystallake.wanandroid.module.question.fragment.QuestionFragment;

public class MainFragment extends BaseFragment {

    private FragmentMainBinding mBinding;

    private TabFragmentPageAdapter<TabEntity> mPageAdapter;

    public static MainFragment create(){
        return new MainFragment();
    }

    @Override
    protected void initView() {
        mPageAdapter = new TabFragmentPageAdapter<>(getChildFragmentManager(),
                mBinding.navViewPager,mBinding.container,R.layout.tab_item_main);

        mPageAdapter.setPages(new TabFragmentPageAdapter.Page<>(HomeFragment.create(),new TabEntity("首页",R.drawable.ic_bottom_bar_home,-1),new MainTabAdapter()),
                new TabFragmentPageAdapter.Page<>(QuestionFragment.create(),new TabEntity("问答",R.drawable.ic_bottom_bar_wechat,-1),new MainTabAdapter()),
                new TabFragmentPageAdapter.Page<>(KnowledgeNavigationFragment.create(),new TabEntity("体系",R.drawable.ic_bottom_bar_navi,-1),new MainTabAdapter()),
                new TabFragmentPageAdapter.Page<>(MineFragment.create(),new TabEntity("我的",R.drawable.ic_bottom_bar_mine,-1),new MainTabAdapter()));
    }

    @Override
    protected void initData() {
        mPageAdapter.notifyPageDataChange();
        mBinding.navViewPager.setCurrentItem(0);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected ViewBinding bindView(LayoutInflater inflater, ViewGroup container) {
        mBinding = FragmentMainBinding.inflate(inflater,container,false);
        return mBinding;
    }

}
