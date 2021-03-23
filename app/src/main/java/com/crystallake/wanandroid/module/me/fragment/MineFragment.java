/**
 * Created by : yds
 * Time: 2020-12-12 10:47 PM
 */
package com.crystallake.wanandroid.module.me.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;

import com.crystallake.wanandroid.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.databinding.FragmentMineBinding;
import com.crystallake.wanandroid.event.LoginEvent;
import com.crystallake.wanandroid.module.login.bean.LoginBean;
import com.crystallake.wanandroid.module.me.activity.AboutMeActivity;
import com.crystallake.wanandroid.module.me.activity.CoinActivity;
import com.crystallake.wanandroid.module.me.activity.CollectActivity;
import com.crystallake.wanandroid.module.me.activity.OpenActivity;
import com.crystallake.wanandroid.module.me.activity.ReadLaterActivity;
import com.crystallake.wanandroid.module.me.activity.ReadRecordActivity;
import com.crystallake.wanandroid.module.me.activity.SettingActivity;
import com.crystallake.wanandroid.module.me.activity.ShareActivity;
import com.crystallake.wanandroid.module.me.mvp.contract.MineContract;
import com.crystallake.wanandroid.module.me.mvp.presenter.MinePresenter;
import com.crystallake.wanandroid.utils.SmartRefreshUtil;
import com.crystallake.wanandroid.utils.UserInfoUtils;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.listener.OnMultiListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MineFragment extends BaseMvpFragment<MinePresenter> implements MineContract.MineView {

    private FragmentMineBinding mBinding;

    @Override
    protected boolean useEventBus() {
        return true;
    }

    @Override
    protected ViewBinding bindView(LayoutInflater inflater, ViewGroup container) {
        mBinding = FragmentMineBinding.inflate(inflater,container,false);
        return mBinding;
    }

    public static MineFragment create() {
        return new MineFragment();
    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
    }


    @Override
    protected void initView() {
        mBinding.nestScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> setBackgroundImageHeight(mBinding.rlUserInfo.getMeasuredHeight() - scrollY));

        mBinding.meSmartRefresh.setOnMultiListener(new OnMultiListener() {
            @Override
            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
                setBackgroundImageHeight(mBinding.rlUserInfo.getMeasuredHeight() - mBinding.nestScrollView.getScrollY() + offset);
            }

            @Override
            public void onHeaderReleased(RefreshHeader header, int headerHeight, int maxDragHeight) {

            }

            @Override
            public void onHeaderStartAnimator(RefreshHeader header, int headerHeight, int maxDragHeight) {

            }

            @Override
            public void onHeaderFinish(RefreshHeader header, boolean success) {

            }

            @Override
            public void onFooterMoving(RefreshFooter footer, boolean isDragging, float percent, int offset, int footerHeight, int maxDragHeight) {

                setBackgroundImageHeight(mBinding.rlUserInfo.getMeasuredHeight() - mBinding.nestScrollView.getScrollY() - offset);
            }

            @Override
            public void onFooterReleased(RefreshFooter footer, int footerHeight, int maxDragHeight) {

            }

            @Override
            public void onFooterStartAnimator(RefreshFooter footer, int footerHeight, int maxDragHeight) {

            }

            @Override
            public void onFooterFinish(RefreshFooter footer, boolean success) {

            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }

            @Override
            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {

            }
        });
        SmartRefreshUtil.with(mBinding.meSmartRefresh)
                .pureScrollMode();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mBinding.llCoin.setOnClickListener(this);
        mBinding.llAboutMe.setOnClickListener(this);
        mBinding.llShare.setOnClickListener(this);
        mBinding.llCollect.setOnClickListener(this);
        mBinding.llReadLater.setOnClickListener(this);
        mBinding.llReadRecord.setOnClickListener(this);
        mBinding.llOpen.setOnClickListener(this);
        mBinding.llSetting.setOnClickListener(this);
    }

    @Override
    public void showMsg(String msg) {

    }

    private void setBackgroundImageHeight(int h) {
        mBinding.backgroundImg.getLayoutParams().height = Math.max(h, 0);
        mBinding.backgroundImg.requestLayout();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginEvent(LoginEvent event) {
        if (isDetached()){
            return;
        }
        changeUserInfo();
    }

    private void changeUserInfo() {
        if (UserInfoUtils.getInstance().isLogin()){
            LoginBean bean = UserInfoUtils.getInstance().getLoginBean();
            mBinding.tvUserName.setText(bean.getUsername());
            mBinding.tvUserId.setVisibility(View.VISIBLE);
            mBinding.tvUserId.setText(bean.getId()+"");
            System.out.println(bean.toJson());
        }
    }

//    private void setRefresh(){
//        if (UserInfoUtils.getInstance().isLogin()){
//            mSmartRefreshUtil.setRefreshListener(new SmartRefreshUtil.RefreshListener() {
//                @Override
//                public void onRefresh() {
//
//                }
//            });
//        }
//    }


    @Override
    protected void disContinuousClick(View view) {
        int id = view.getId();
        if (id == R.id.ll_coin) {
            if (UserInfoUtils.getInstance().loginIfNot(getContext())) {
                CoinActivity.start(getContext());
            }
        } else if (id == R.id.ll_about_me) {
            AboutMeActivity.start(getContext());
        } else if (id == R.id.ll_share) {
            if (UserInfoUtils.getInstance().loginIfNot(getContext())) {
                ShareActivity.start(getContext());
            }
        } else if (id == R.id.ll_collect) {
            if (UserInfoUtils.getInstance().loginIfNot(getContext())) {
                CollectActivity.start(getContext());
            }
        } else if (id == R.id.ll_read_later) {
            ReadLaterActivity.start(getContext());
        } else if (id == R.id.ll_read_record) {
            ReadRecordActivity.start(getContext());
        } else if (id == R.id.ll_open) {
            OpenActivity.start(getContext());
        } else if (id == R.id.ll_setting) {
            SettingActivity.start(getContext());
        }
    }
}
