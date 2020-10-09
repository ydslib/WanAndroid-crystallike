/**
 * Created by : yds
 * Time: 2020-08-23 2:06 PM
 */
package com.crystallake.wanandroid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crystallake.mylibrary.net.common.ResponseObserver;
import com.crystallake.mylibrary.utils.RxUtil;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.adapter.ArticleAdapter;
import com.crystallake.wanandroid.base.BaseFragment;
import com.crystallake.wanandroid.mvp.module.ArticleModel;
import com.crystallake.wanandroid.net.RetrofitHelper;
import com.crystallake.wanandroid.request.ArticleWrapper;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.List;

import butterknife.BindView;

public class HomeFragment extends RxFragment {

    ArticleModel mArticleModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        mHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

//        mHomeBinding = DataBindingUtil.setContentView(this.getActivity(),R.layout.fragment_home);
//        ArticleModel wxArticleModel = new ViewModelProvider.NewInstanceFactory().create(ArticleModel.class);
//        wxArticleModel.setFragment(this);
//        mArticleModel = new ViewModelProvider.NewInstanceFactory().create(ArticleModel.class);
//        mArticleModel.getWxAuthorData();
//        mArticleModel.getArticleDataBean().observe(getActivity(), new Observer<ArticleWrapper.DataBean>() {
//            @Override
//            public void onChanged(ArticleWrapper.DataBean dataBean) {
//                mHomeBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
//                ArticleAdapter articleAdapter = new ArticleAdapter(HomeFragment.this.getContext(), dataBean.getDatas());
//                mHomeBinding.recyclerView.setAdapter(articleAdapter);
//            }
//        });
//        mHomeBinding.setLifecycleOwner(this);
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        init(view);
        return view;
    }

    public void init(View view) {


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

    /**
     * Get请求
     */
    public void getData() {
        RetrofitHelper.getApiService()
                .getArticle()
                .compose(RxUtil.rxSchedulerHelper(this, true))
                .subscribe(new ResponseObserver<ArticleWrapper>() {
                    @Override
                    public void onSuccess(ArticleWrapper response) {
                        System.out.println(response.getData().getCurPage());
                    }
                });
    }
}
