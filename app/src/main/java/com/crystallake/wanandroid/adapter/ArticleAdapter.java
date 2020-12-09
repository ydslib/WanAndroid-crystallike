/**
 * Created by : yds
 * Time: 2020-12-09 10:37 PM
 */
package com.crystallake.wanandroid.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.crystallake.appbase.R;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleBean;

import org.jetbrains.annotations.NotNull;


public class ArticleAdapter extends BaseQuickAdapter<ArticleBean, BaseViewHolder> {

    public ArticleAdapter() {
        super(R.layout.item_user_article);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ArticleBean articleBean) {
        TextView tv = baseViewHolder.getView(R.id.tv1);
        tv.setText(articleBean.getChapterName());
    }
}
