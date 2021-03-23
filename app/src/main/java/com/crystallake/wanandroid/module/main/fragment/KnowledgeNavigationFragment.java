/**
 * Created by : yds
 * Time: 2020-12-12 10:41 PM
 */
package com.crystallake.wanandroid.module.main.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.crystallake.basic.base.fragment.support.BaseFragment;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.adapter.FixedFragmentPagerAdapter;
import com.crystallake.wanandroid.databinding.FragmentKnowledgeNavigationBinding;
import com.crystallake.wanandroid.module.knowledge.fragment.KnowledgeFragment;
import com.crystallake.wanandroid.module.navi.fragment.NaviFragment;
import com.crystallake.wanandroid.utils.MagicIndicatorUtils;
import com.crystallake.wanandroid.listener.ScrollTop;

import net.lucode.hackware.magicindicator.MagicIndicator;


public class KnowledgeNavigationFragment extends BaseFragment implements ScrollTop{


    private FragmentKnowledgeNavigationBinding mBinding;

    public static KnowledgeNavigationFragment create(){
        return new KnowledgeNavigationFragment();
    }


    @Override
    protected void initView() {
        FixedFragmentPagerAdapter adapter = new FixedFragmentPagerAdapter(getChildFragmentManager());
        adapter.setTitle("体系","导航");
        adapter.setFragments(KnowledgeFragment.create(),
                NaviFragment.create());
        mBinding.knowNaviViewPager.setAdapter(adapter);
        MagicIndicator magicIndicator = mBinding.knowNaviActionBar.getView(R.id.magic_indicator);
        MagicIndicatorUtils.commonNavigator(magicIndicator,mBinding.knowNaviViewPager, adapter,
                data -> scrollTop());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected ViewBinding bindView(LayoutInflater inflater, ViewGroup container) {
        mBinding = FragmentKnowledgeNavigationBinding.inflate(inflater,container,false);
        return mBinding;
    }

    @Override
    public void scrollTop() {

    }

}
