/**
 * Created by : yds
 * Time: 2020-12-12 8:45 PM
 */
package com.crystallake.wanandroid.adapter;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class TabFragmentPageAdapter<T> extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {
    private final ViewPager mViewPager;
    private final LinearLayout mContainer;
    private final int mTabItemRes;
    private Page<T>[] mPage;

    public TabFragmentPageAdapter(@NonNull FragmentManager fm,
                                  @NonNull ViewPager viewPager,
                                  @NonNull LinearLayout container,
                                  @LayoutRes int tabItemRes
    ) {
        super(fm);
        mViewPager = viewPager;
        mContainer = container;
        mTabItemRes = tabItemRes;

        mViewPager.setAdapter(this);
        mViewPager.addOnPageChangeListener(this);
    }

    public void setPages(Page<T>... pages) {
        mViewPager.setOffscreenPageLimit(pages.length);
        mContainer.removeAllViews();
        mPage = pages;
        for (Page<T> page : pages) {
            initPageTab(page);
        }
        notifyDataSetChanged();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        notifyPageDataChange();
    }

    public void notifyPageDataChange() {
        int currPage = mViewPager.getCurrentItem();
        for (int i = 0; i < mPage.length; i++) {
            mPage[i].notifyAdapterBindData(i == currPage);
        }
    }

    private void initPageTab(@NonNull Page<T> page) {
        page.mView = LayoutInflater.from(mContainer.getContext()).inflate(mTabItemRes, mContainer, false);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) page.mView.getLayoutParams();
        layoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT;
        layoutParams.width = 0;
        layoutParams.weight = 1;
        mContainer.addView(page.mView);

        GestureDetector gestureDetector = new GestureDetector(page.mView.getContext(), new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                switchCurrentItem(page);
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return false;
            }
        });
        page.mView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });



    }

    private void switchCurrentItem(Page<T> page){
        for(int i=0;i<mPage.length;i++){
            if (page.mFragment == getItem(i)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mPage[position].mFragment;
    }

    @Override
    public int getCount() {
        return mPage == null ? 0 : mPage.length;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < mPage.length; i++) {
            mPage[i].notifyAdapterBindData(i == position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 页的管理
     *
     * @param <T>
     */
    public static class Page<T> {
        @NonNull
        private final Fragment mFragment;
        @NonNull
        private final T mData;
        @NonNull
        private final TabAdapter<T> mTabAdapter;

        private View mView;

        public Page(@NonNull Fragment fragment, @NonNull T data, @NonNull TabAdapter<T> tabAdapter) {
            mFragment = fragment;
            mData = data;
            mTabAdapter = tabAdapter;
        }

        @NonNull
        public T getData() {
            return mData;
        }

        public void notifyAdapterBindData(boolean selected) {
            mTabAdapter.onBindData(mView, mData, selected);
        }

        public void notifyAdapterDoubleTab() {
            mTabAdapter.onDoubleTap(mFragment);
        }

    }
}
