/**
 * Created by : yds
 * Time: 2020-12-12 10:47 PM
 */
package com.crystallake.wanandroid.module.me.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;

import com.crystallake.wanandroid.R;
import com.crystallake.basic.base.fragment.BaseMvpFragment;
import com.crystallake.wanandroid.event.LoginEvent;
import com.crystallake.wanandroid.module.me.activity.CoinActivity;
import com.crystallake.wanandroid.module.me.mvp.contract.MineContract;
import com.crystallake.wanandroid.module.me.mvp.presenter.MinePresenter;
import com.crystallake.wanandroid.utils.SmartRefreshUtil;
import com.crystallake.wanandroid.utils.UserInfoUtils;
import com.makeramen.roundedimageview.RoundedImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.listener.OnMultiListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

public class MineFragment extends BaseMvpFragment<MinePresenter> implements MineContract.MineView {


    @BindView(R.id.background_img)
    ImageView mImageView;
    @BindView(R.id.me_smart_refresh)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.nest_scroll_view)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.rl_user_info)
    RelativeLayout mRelativeLayout;
    @BindView(R.id.civ_user_icon)
    RoundedImageView mUserIcon;
    @BindView(R.id.tv_user_name)
    TextView mUserName;
    @BindView(R.id.tv_user_id)
    TextView mUserId;
    @BindView(R.id.tv_user_level)
    TextView mUserLevel;
    @BindView(R.id.tv_user_ranking)
    TextView mUserRanking;
    @BindView(R.id.ll_coin)
    LinearLayout mMyCoin;
    @BindView(R.id.ll_share)
    LinearLayout mShare;
    @BindView(R.id.ll_collect)
    LinearLayout mCollect;
    @BindView(R.id.ll_read_later)
    LinearLayout mReadLater;
    @BindView(R.id.ll_read_record)
    LinearLayout mReadHistory;
    @BindView(R.id.ll_open)
    LinearLayout mOpenResource;
    @BindView(R.id.ll_about_me)
    LinearLayout mAboutMe;
    @BindView(R.id.ll_setting)
    LinearLayout mSetting;
//    @BindView(R.id.me_action_bar)
//    ActionBarCommon mBarCommon;
    private SmartRefreshUtil mSmartRefreshUtil;

    @Override
    protected boolean useEventBus() {
        return true;
    }

    public static MineFragment create() {
        return new MineFragment();
    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        mNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (mNestedScrollView == null || mRelativeLayout == null) return;
                setBackgroundImageHeight(mRelativeLayout.getMeasuredHeight() - scrollY);
            }
        });

        mSmartRefreshLayout.setOnMultiListener(new OnMultiListener() {
            @Override
            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
                if (mNestedScrollView == null || mRelativeLayout == null) return;
                setBackgroundImageHeight(mRelativeLayout.getMeasuredHeight() - mNestedScrollView.getScrollY() + offset);
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
                if (mNestedScrollView == null || mRelativeLayout == null) return;
                setBackgroundImageHeight(mRelativeLayout.getMeasuredHeight() - mNestedScrollView.getScrollY() - offset);
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
        mSmartRefreshUtil = SmartRefreshUtil.with(mSmartRefreshLayout)
                .pureScrollMode();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showMsg(String msg) {

    }

    private void setBackgroundImageHeight(int h) {
        if (mImageView == null) {
            return;
        }
        if (h >= 0) {
            mImageView.getLayoutParams().height = h;
        } else {
            mImageView.getLayoutParams().height = 0;
        }
        mImageView.requestLayout();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginEvent(LoginEvent event) {

    }

    @OnClick({
            R.id.ll_coin,R.id.ll_about_me
    })
    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    protected void disContinuousClick(View view) {
        switch (view.getId()){
            case R.id.ll_coin:
                if (UserInfoUtils.getInstance().loginIfNot(getContext())){
                    CoinActivity.start(getContext());
                }
                break;
            case R.id.ll_about_me:
                break;
        }
    }
}
