/************************************************************
 * Copyright 2000-2020 OPPO Mobile Comm Corp., Ltd.
 * All rights reserved.
 * <p>
 * FileName       : WxArticleModel.java
 * Version Number : 1.0
 * Description    :
 * Author         : Dongsheng.Ye
 * Date           : 2020/9/27
 * History        :( ID,     Date,         Author, Description)
 * v1.0, 2020/9/27, Dongsheng.Ye, create
 ************************************************************/
package com.crystallake.wanandroid.mvp.module;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.crystallake.mylibrary.net.common.ResponseObserver;
import com.crystallake.mylibrary.utils.RxUtil;
import com.crystallake.wanandroid.net.RetrofitHelper;
import com.crystallake.wanandroid.request.ArticleWrapper;
import com.crystallake.wanandroid.request.WxArticleAuthor;
import com.crystallake.wanandroid.utils.AssetsUtils;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;

public class ArticleModel extends ViewModel {
    private MutableLiveData<ArticleWrapper.DataBean> mArticalDataBean;
//    private MutableLiveData<String> mImageUrl;
    private String name;
    private RxFragment mFragment;
    List<WxArticleAuthor.DataBean> mDataList;

    public void setFragment(@NonNull RxFragment mFragment) {
        this.mFragment = mFragment;
    }

    public String getName() {
        return name;
    }

    public MutableLiveData<ArticleWrapper.DataBean> getArticleDataBean() {
        if (mArticalDataBean == null) {
            mArticalDataBean = new MutableLiveData<>();
        }
        return mArticalDataBean;
    }

    public List<ArticleWrapper.DataBean.DatasBean> getDatasBean(){
        ArticleWrapper.DataBean dataBean = mArticalDataBean.getValue();
        if (dataBean==null){
            return new ArrayList<>();
        }
        return dataBean.getDatas();
    }

    public MutableLiveData<List<String>> getImageUrl() {
        MutableLiveData<List<String>> mImageUrl = new MutableLiveData<>();
        if (mFragment != null) {
            String result = AssetsUtils.getJson(mFragment.getContext(), "image.json");
            JSONArray array = JSON.parseArray(result);
            JSONObject imgObj;
            for (int j = 0; j < array.size(); j++) {
                JSONObject obj = array.getJSONObject(j);
                JSONArray jsonArray = obj.getJSONArray("image_list");
                List<String> list = new ArrayList<>();
                for (int i = 0; i < jsonArray.size(); i++) {
                    imgObj = jsonArray.getJSONObject(i);
                    list.add(imgObj.getString("image_url"));
                    mImageUrl.setValue(list);
                }
            }
        }
        return mImageUrl;
    }

    public void getWxAuthorData() {
        RetrofitHelper.getApiService()
                .getArticle()
                .compose(RxUtil.rxSchedulerHelper(mFragment, true))
                .subscribe(new ResponseObserver<ArticleWrapper>() {
                    @Override
                    public void onSuccess(ArticleWrapper response) {
                        mArticalDataBean.setValue(response.getData());
                    }
                });
    }
}
    