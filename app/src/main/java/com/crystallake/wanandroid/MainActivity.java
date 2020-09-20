package com.crystallake.wanandroid;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.crystallake.mylibrary.net.common.ResponseObserver;
import com.crystallake.mylibrary.utils.RxUtil;
import com.crystallake.wanandroid.base.BaseActivity;
import com.crystallake.wanandroid.base.BaseTabFragmentPagerAdapter;
import com.crystallake.wanandroid.fragment.FollowFragment;
import com.crystallake.wanandroid.fragment.HomeFragment;
import com.crystallake.wanandroid.fragment.MeFragment;
import com.crystallake.wanandroid.fragment.MessageFragment;
import com.crystallake.wanandroid.net.RetrofitHelper;
import com.crystallake.wanandroid.request.ArticleWrapper;
import com.crystallake.wanandroid.request.WxArticleAuthor;
import com.crystallake.wanandroid.response.LoginResponse;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_tab_viewpager)
    ViewPager mViewPager;
    @BindView(R.id.main_bottom_tabLayout)
    TabLayout mTabLayout;

    private List<Fragment> mFragmentList;
    private FragmentPagerAdapter mPagerAdapter;

    private String[] mTabTitles = new String[]{"首页", "关注", "消息", "我的"};
    private int[] mTabImages = new int[]{
            R.drawable.tabbar_subscription_img_selecter,
            R.drawable.tabbar__follow_img_selecter,
            R.drawable.tabbar_notification_img_selecter,
            R.drawable.tabbar_me_img_selecter
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        setTabs(mTabTitles,mTabImages);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new FollowFragment());
        mFragmentList.add(new MessageFragment());
        mFragmentList.add(new MeFragment());

        mPagerAdapter = new BaseTabFragmentPagerAdapter(getSupportFragmentManager(),mFragmentList);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

    private void setTabs(String[] bottomTabTitles, int[] bottomTabImages) {
        for (int i = 0; i < bottomTabTitles.length; i++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            View view = getLayoutInflater().inflate(R.layout.tab_bottom_nav, null);
            tab.setCustomView(view);

            TextView tabTitle = view.findViewById(R.id.home_item_tv);
            tabTitle.setText(bottomTabTitles[i]);

            ImageView tabImage = view.findViewById(R.id.home_item_iv);
            tabImage.setImageResource(bottomTabImages[i]);
            if (i == 0) {
                mTabLayout.addTab(tab, true);
            } else {
                mTabLayout.addTab(tab, false);
            }

        }
    }



    /**
     * Post请求
     */
    public void login(View view) {
        RetrofitHelper.getApiService()
                .login(getParameters())
                .compose(RxUtil.rxSchedulerHelper(this, false))
                .subscribe(new ResponseObserver<LoginResponse>() {
                    @Override
                    public void onSuccess(LoginResponse response) {
                        showToast("登录成功");
                    }
                });
    }

    private Map<String, Object> getParameters() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "110120");
        map.put("password", "123456");
        return map;
    }

    /**
     * Get请求
     *
     * @param view
     */
//    public void getData(View view) {
//        RetrofitHelper.getApiService()
//                .getArticle()
//                .compose(RxUtil.rxSchedulerHelper(this, true))
//                .subscribe(new ResponseObserver<ArticleWrapper>() {
//                    @Override
//                    public void onSuccess(ArticleWrapper response) {
//                        showToast("Request Success，size is：" + response.getDatas().size());
//                    }
//                });
//    }


}