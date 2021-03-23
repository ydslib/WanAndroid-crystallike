/**
 * Created by : yds
 * Time: 2020-11-22 8:47 PM
 */
package com.crystallake.basic.base.fragment.support;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.trello.rxlifecycle4.components.support.RxFragment;

import org.greenrobot.eventbus.EventBus;

public abstract class BaseFragment extends RxFragment {

    protected boolean mViewCreated = false;

    protected View mRootView;
    protected Context mContext;


    protected ViewBinding mViewBinding;

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    protected boolean useEventBus() {
        return false;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mViewBinding = bindView(inflater, container);
            if (mViewBinding != null) {
                mRootView = mViewBinding.getRoot();
                if (useEventBus()) {
                    EventBus.getDefault().register(this);
                }
            } else {
                return super.onCreateView(inflater, container, savedInstanceState);
            }

        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        mViewCreated = true;
        return mRootView;
    }

    protected abstract ViewBinding bindView(LayoutInflater inflater, ViewGroup container);

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        this.mContext = null;
        this.mRootView = null;
        this.mViewBinding = null;
        mViewCreated = false;
    }
}
