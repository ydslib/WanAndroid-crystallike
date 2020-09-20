/**
 * Created by : yds
 * Time: 2020-08-23 2:06 PM
 */
package com.crystallake.wanandroid.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.crystallake.mylibrary.net.common.ResponseObserver;
import com.crystallake.mylibrary.utils.RxUtil;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.base.BaseFragment;
import com.crystallake.wanandroid.net.RetrofitHelper;
import com.crystallake.wanandroid.request.ArticleWrapper;
import com.crystallake.wanandroid.request.WxArticleAuthor;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.test)
    Button test;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void init() {
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWxAuthorData();
            }
        });
    }

    public void getWxAuthorData(){
        RetrofitHelper.getApiService()
                .getWxAuthor()
                .compose(RxUtil.rxSchedulerHelper(this,true))
                .subscribe(new ResponseObserver<WxArticleAuthor>() {
                    @Override
                    public void onSuccess(WxArticleAuthor response) {

                    }
                });
    }
    /**
     * Get请求
     *
     *
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
