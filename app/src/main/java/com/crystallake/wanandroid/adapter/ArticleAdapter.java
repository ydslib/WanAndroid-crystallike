/************************************************************
 * Copyright 2000-2020 OPPO Mobile Comm Corp., Ltd.
 * All rights reserved.
 * <p>
 * FileName       : WxArticleAdapter.java
 * Version Number : 1.0
 * Description    :
 * Author         : Dongsheng.Ye
 * Date           : 2020/9/27
 * History        :( ID,     Date,         Author, Description)
 * v1.0, 2020/9/27, Dongsheng.Ye, create
 ************************************************************/
package com.crystallake.wanandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.databinding.ItemWxAuthorLayoutBinding;
import com.crystallake.wanandroid.fragment.GlideLoadImage;
import com.crystallake.wanandroid.request.ArticleWrapper;
import com.yds.library.MultiImageView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.WxArticleAuthorHolder> {
    private Context mContext;
    private List<ArticleWrapper.DataBean.DatasBean> mDataList;
    public ArticleAdapter(Context context, List<ArticleWrapper.DataBean.DatasBean> dataList){
        this.mContext = context;
        this.mDataList = dataList;
    }
    @NonNull
    @Override
    public ArticleAdapter.WxArticleAuthorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemWxAuthorLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_wx_author_layout,parent,false);
        return new WxArticleAuthorHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.WxArticleAuthorHolder holder, int position) {
//        holder.mAuthor.setText(mDataList.get(position).getName());
//        holder.mMultiImageView.setImagesData(mDataList);
//        holder.mMultiImageView.setMultiImageLoader(new GlideLoadImage());
        ItemWxAuthorLayoutBinding binding = holder.mBinding;
        ArticleWrapper.DataBean.DatasBean datasBean = mDataList.get(position);
        System.out.println("ChapterName:"+datasBean.getChapterName());
        binding.setData(datasBean);
        binding.getRoot().setTag(position);
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class WxArticleAuthorHolder extends RecyclerView.ViewHolder{
        ItemWxAuthorLayoutBinding mBinding;
        public WxArticleAuthorHolder(ItemWxAuthorLayoutBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }
    }


}
    