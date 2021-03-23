/**
 * Created by : yds
 * Time: 2020-11-22 5:04 PM
 */
package com.crystallake.basic.base.activity;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.crystallake.rxswipeback.SwipeBackActivity;

import org.greenrobot.eventbus.EventBus;

public abstract class BaseActivity extends SwipeBackActivity {

    protected ViewBinding mViewBinding;

    /**
     * 初始化View
     */
    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initData();

    protected abstract void initListener();

    protected boolean useEventBus() {
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = bindView();
        if (mViewBinding != null) {
            View root = mViewBinding.getRoot();
            setContentView(root);
            if (useEventBus()) {
                EventBus.getDefault().register(this);
            }
            initView(savedInstanceState);
            initData();
            initListener();
        }

    }

    protected abstract ViewBinding bindView();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);
        }

        mViewBinding = null;
    }

}
