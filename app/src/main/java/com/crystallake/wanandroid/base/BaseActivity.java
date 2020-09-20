package com.crystallake.wanandroid.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;

import com.crystallake.mylibrary.utils.ToastUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends RxAppCompatActivity {

    protected Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        init(savedInstanceState);
    }

    protected void showToast(String msg) {
        ToastUtils.show(msg);
    }

    protected abstract @LayoutRes
    int getLayoutId();

    protected abstract void init(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
