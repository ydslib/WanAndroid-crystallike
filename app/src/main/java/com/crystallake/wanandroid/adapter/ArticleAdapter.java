/**
 * Created by : yds
 * Time: 2020-12-09 10:37 PM
 */
package com.crystallake.wanandroid.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

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
    protected void convert(@NotNull BaseViewHolder holder, ArticleBean bean) {
        bindDataToWidget(holder, bean);
    }

    private void bindDataToWidget(@NotNull BaseViewHolder holder, ArticleBean bean) {
        TextView tvTop = holder.getView(R.id.tv_top);
        TextView tvNew = holder.getView(R.id.tv_new);
        TextView tvAuthor = holder.getView(R.id.tv_author);
        TextView tvTag = holder.getView(R.id.tv_tag);
        TextView tvTime = holder.getView(R.id.tv_time);

        TextView tvTitle = holder.getView(R.id.tv_title);
        TextView tvDesc = holder.getView(R.id.tv_desc);
        TextView tvChapterName = holder.getView(R.id.tv_chapter_name);
        ImageView zan = holder.getView(R.id.cv_collect);


        if (bean.isTop()) {
            tvTop.setVisibility(View.VISIBLE);
        } else {
            tvTop.setVisibility(View.GONE);
        }

        if (bean.isFresh()) {
            tvNew.setVisibility(View.VISIBLE);
        } else {
            tvNew.setVisibility(View.GONE);
        }

        if (bean.getZan() == 0) {
            zan.setImageResource(R.drawable.like_def);
        } else {
            zan.setImageResource(R.drawable.like_selected);
        }

        tvAuthor.setText(bean.getAuthor());
        tvTime.setText(bean.getNiceDate());
        tvTitle.setText(bean.getTitle());
        tvDesc.setText(bean.getDesc());
        tvChapterName.setText(formatChapterName(bean.getSuperChapterName(), bean.getChapterName()));
    }

    private static String formatChapterName(String... names) {
        StringBuilder format = new StringBuilder();
        for (String name : names) {
            if (!TextUtils.isEmpty(name)) {
                if (format.length() > 0) {
                    format.append("·");
                }
                format.append(name);
            }
        }
        return format.toString();
    }
}
