/************************************************************
 * Copyright 2000-2020 OPPO Mobile Comm Corp., Ltd.
 * All rights reserved.
 * <p>
 * FileName       : ImageAdapter.java
 * Version Number : 1.0
 * Description    :
 * Author         : Dongsheng.Ye
 * Date           : 2020/10/12
 * History        :( ID,     Date,         Author, Description)
 * v1.0, 2020/10/12, Dongsheng.Ye, create
 ************************************************************/
package com.crystallake.wanandroid.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crystallake.wanandroid.request.BannerBean;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class ImageAdapter extends BannerAdapter<BannerBean.DataBean,ImageAdapter.BannerViewHolder> {

    private Context mContext;
    List<BannerBean.DataBean> mDatas;
    public ImageAdapter(Context context, List<BannerBean.DataBean> datas) {
        super(datas);
        mContext = context;
        mDatas = datas;
    }

    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerViewHolder(imageView);
    }

    @Override
    public void onBindView(BannerViewHolder holder, BannerBean.DataBean data, int position, int size) {
        Glide.with(mContext).load(data.getImagePath()).into(holder.mImageView);
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    public static class BannerViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView;
        }
    }
}
    