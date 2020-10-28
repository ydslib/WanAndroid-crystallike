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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.request.BaseArticleData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleAuthorHolder> {
    private Context mContext;
    private List<BaseArticleData> mDataList;

    public ArticleAdapter(Context context, List<BaseArticleData> dataList) {
        this.mContext = context;
        this.mDataList = dataList;
    }

    @NonNull
    @Override
    public ArticleAdapter.ArticleAuthorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_article_layout, parent, false);
        return new ArticleAuthorHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ArticleAuthorHolder holder, int position) {
        BaseArticleData datasBean = mDataList.get(position);
        if (!TextUtils.isEmpty(datasBean.getTitle())) {
            holder.mArticleTitle.setText(datasBean.getTitle());
        }
        holder.mArticleChapterName.setText(datasBean.getSuperChapterName());
        holder.mArticleAuthor.setText(datasBean.getAuthor());
        holder.mArticleTime.setText(datasBean.getNiceShareDate());
        if (!TextUtils.isEmpty(datasBean.getEnvelopePic())) {
            holder.mArticleImg.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(datasBean.getEnvelopePic()).into(holder.mArticleImg);
        } else {
            holder.mArticleImg.setVisibility(View.GONE);
        }
        holder.mArticleTop.setVisibility(datasBean.getType() > 0 ? View.VISIBLE : View.GONE);
        holder.mArticleNew.setVisibility(datasBean.isFresh() ? View.VISIBLE : View.GONE);
        holder.mArticleCollect.setVisibility(View.VISIBLE);
        if(datasBean.isCollect()){
            holder.mArticleCollect.setImageResource(R.drawable.ic_favorite_black_24dp);
        }else{
            holder.mArticleCollect.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class ArticleAuthorHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.article_author)
        TextView mArticleAuthor;
        @BindView(R.id.article_new)
        TextView mArticleNew;
        @BindView(R.id.article_top)
        TextView mArticleTop;
        @BindView(R.id.article_time)
        TextView mArticleTime;
        @BindView(R.id.article_title)
        TextView mArticleTitle;
        @BindView(R.id.article_img)
        ImageView mArticleImg;
        @BindView(R.id.article_chapter_name)
        TextView mArticleChapterName;
        @BindView(R.id.article_collect)
        ImageView mArticleCollect;

        public ArticleAuthorHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
    