/**
 * Created by : yds
 * Time: 2020-12-12 10:41 PM
 */
package com.crystallake.wanandroid.module.main.fragment;

import androidx.viewpager.widget.ViewPager;

import com.crystallake.appbase.R;
import com.crystallake.basic.base.fragment.support.BaseFragment;
import com.crystallake.wanandroid.adapter.FixedFragmentPagerAdapter;
import com.crystallake.wanandroid.module.knowledge.fragment.KnowledgeFragment;
import com.crystallake.wanandroid.module.navi.fragment.NaviFragment;
import com.crystallake.wanandroid.utils.MagicIndicatorUtils;
import com.crystallake.wanandroid.listener.ScrollTop;
import com.crystallake.wanandroid.listener.SimpleCallback;

import net.lucode.hackware.magicindicator.MagicIndicator;

import butterknife.BindView;
import per.goweii.actionbarex.ActionBarEx;

public class KnowledgeNavigationFragment extends BaseFragment implements ScrollTop{

    @BindView(R.id.know_navi_view_pager)
    ViewPager mViewPager;

    @BindView(R.id.know_navi_action_bar)
    ActionBarEx mActionBarEx;

    private FixedFragmentPagerAdapter mAdapter;

    public static KnowledgeNavigationFragment create(){
        return new KnowledgeNavigationFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_knowledge_navigation;
    }

    @Override
    protected void initView() {
        mAdapter = new FixedFragmentPagerAdapter(getChildFragmentManager());
        mAdapter.setTitle("体系","导航");
        mAdapter.setFragments(KnowledgeFragment.create(),
                NaviFragment.create());
        mViewPager.setAdapter(mAdapter);
        MagicIndicator magicIndicator = mActionBarEx.getView(R.id.magic_indicator);
        MagicIndicatorUtils.commonNavigator(magicIndicator,mViewPager,mAdapter,
                new SimpleCallback<Integer>() {
                    @Override
                    public void onResult(Integer data) {
                        scrollTop();
                    }
                });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void scrollTop() {

    }

}
