/**
 * Created by : yds
 * Time: 2020-12-02 9:53 PM
 */
package com.crystallake.wanandroid.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FixedFragmentPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] mFragments;
    private String[] mTitle;

    public FixedFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void setFragments(Fragment... fragments) {
        mFragments = fragments;
        notifyDataSetChanged();
    }

    public void setTitle(String... title) {
        mTitle = title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitle != null&&mTitle.length==getCount()) {
            return mTitle[position];
        }

        Fragment fragment = mFragments[position];
        if (fragment instanceof PageTitle){
            PageTitle pageTitle = (PageTitle) fragment;
            return pageTitle.getPageTitle();
        }

        return "";
    }

    public interface PageTitle{
        CharSequence getPageTitle();
    }
}
