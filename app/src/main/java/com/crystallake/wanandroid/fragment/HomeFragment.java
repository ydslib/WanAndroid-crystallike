/**
 * Created by : yds
 * Time: 2020-08-23 2:06 PM
 */
package com.crystallake.wanandroid.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.adapter.ArticleAdapter;
import com.crystallake.wanandroid.adapter.ImageAdapter;
import com.crystallake.wanandroid.base.BaseFragment;
import com.crystallake.wanandroid.mvp.module.HomeModel;
import com.crystallake.wanandroid.request.BannerBean;
import com.crystallake.wanandroid.request.BaseArticleData;
import com.crystallake.wanandroid.utils.SmartRefreshUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {
    private static final int PAGE_START = 0;
    private HomeModel mHomeModel;
    private ImageAdapter mBannerAdapter;
    private SmartRefreshUtils mRefreshUtils;
    private int mCurPage = PAGE_START;

    @BindView(R.id.recycler_view_home)
    RecyclerView mHomeRecycler;

    @BindView(R.id.banner_home)
    Banner mBanner;

    @BindView(R.id.smart_refresh_home)
    SmartRefreshLayout mRefreshLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        mBanner.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mBanner.stop();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    public void init() {
        mHomeModel = new ViewModelProvider(this).get(HomeModel.class);
        mHomeModel.getBannerData();
        mHomeModel.getArticleData(new WeakReference<>(this), 0);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        mHomeRecycler.setLayoutManager(manager);

        getArticleData();
        mRefreshUtils = SmartRefreshUtils.with(mRefreshLayout);
        mRefreshUtils.pureScrollMode();
        mRefreshUtils.setRefreshListener(new SmartRefreshUtils.RefreshListener() {
            @Override
            public void onRefresh() {
                mCurPage = PAGE_START;
                getArticleData();
            }
        });


//        wxArticleModel.getWxAuthorData();

//        wxArticleModel.getWxArticleAuthorData().observe(this, new Observer<WxArticleAuthor>() {
//            @Override
//            public void onChanged(WxArticleAuthor wxArticleAuthor) {
//                if (wxArticleAuthor != null) {
//                    mRecyclerView.setLayoutManager(new LinearLayoutManager(HomeFragment.this.getContext(), RecyclerView.VERTICAL, false));
//                    WxArticleAdapter articleAdapter = new WxArticleAdapter(HomeFragment.this.getContext(), wxArticleAuthor.getData());
//                    mRecyclerView.setAdapter(articleAdapter);
//                }
//            }
//        });

//        wxArticleModel.getImageUrl().observe(this, new Observer<List<String>>() {
//            @Override
//            public void onChanged(List<String> s) {
//                mRecyclerView.setLayoutManager(new LinearLayoutManager(HomeFragment.this.getContext(), RecyclerView.VERTICAL, false));
//                ArticleAdapter articleAdapter = new ArticleAdapter(HomeFragment.this.getContext(), s);
//                mRecyclerView.setAdapter(articleAdapter);
//            }
//        });


//        test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println(mWxArticleModel.getName());
//            }
//        });
    }

    private void getArticleData(){
        mHomeModel.getMutableLiveData().observe(getActivity(), new Observer<BannerBean>() {
            @Override
            public void onChanged(BannerBean bannerBean) {
                mBannerAdapter = new ImageAdapter(getActivity(), bannerBean.getData());
                mBanner.setAdapter(mBannerAdapter);
                mBanner.setIndicator(new CircleIndicator(getActivity())).start();
            }
        });
        mHomeModel.getArticleWrapperMutableLiveData().observe(getActivity(), new Observer<List<BaseArticleData>>() {
            @Override
            public void onChanged(List<BaseArticleData> articleBean) {
                ArticleAdapter articleAdapter = new ArticleAdapter(getActivity(), articleBean);
                mHomeRecycler.setAdapter(articleAdapter);
            }
        });
    }

//    public void getWxAuthorData() {
//        RetrofitHelper.getApiService()
//                .getWxAuthor()
//                .compose(RxUtil.rxSchedulerHelper(this, true))
//                .subscribe(new ResponseObserver<WxArticleAuthor>() {
//                    @Override
//                    public void onSuccess(WxArticleAuthor response) {
//
//                    }
//                });
//    }

//    /**
//     * Get请求
//     */
//    public void getData() {
//        RetrofitHelper.getApiService()
//                .getArticle()
//                .compose(RxUtil.rxSchedulerHelper(this, true))
//                .subscribe(new ResponseObserver<ArticleWrapper>() {
//                    @Override
//                    public void onSuccess(ArticleWrapper response) {
//                        System.out.println(response.getData().getCurPage());
//                    }
//                });
//    }
}
