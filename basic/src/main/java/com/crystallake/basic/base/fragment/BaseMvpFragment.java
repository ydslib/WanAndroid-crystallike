/**
 * Created by : yds
 * Time: 2020-11-23 9:36 PM
 */
package com.crystallake.basic.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.crystallake.basic.base.fragment.support.BaseLazyFragment;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;
import com.crystallake.basic.utils.LoadingDialog;
import com.crystallake.basic.utils.click.ClickUtils;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.android.FragmentEvent;

public abstract class BaseMvpFragment<P extends IPresenter> extends BaseLazyFragment implements IView, View.OnClickListener {


    private LoadingDialog mLoadingDialog;

    protected P mPresenter;

    protected abstract P createPresenter();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void showLoading() {
        if (mLoadingDialog == null) {
            mLoadingDialog = LoadingDialog.with(getContext());
        }
        mLoadingDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public void showDefaultMsg(String msg) {

    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mLoadingDialog != null) {
            mLoadingDialog.clear();
        }
        mLoadingDialog = null;

        if (mPresenter != null) {
            mPresenter.detachView();
        }
        mPresenter = null;
    }

    /**
     * @return true表示允许连续, false表示不允许
     */
    protected boolean isAllowContinuousClick(View view) {
        return false;
    }

    protected void disContinuousClick(View view) {

    }

    @Nullable
    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.bindUntilEvent(FragmentEvent.DESTROY_VIEW);
    }

    @Override
    public void onClick(View v) {
        if (!isAllowContinuousClick(v)) {
            long time1 = System.currentTimeMillis();
            ClickUtils.disContinuousClick(v, new ClickUtils.Callback() {
                @Override
                public void onClick(View view) {
                    disContinuousClick(view);
                    System.out.println(System.currentTimeMillis() - time1);
                }
            });
        }
    }

    public void finish(){
        if (getActivity()!=null){
            getActivity().finish();
        }
    }
}
