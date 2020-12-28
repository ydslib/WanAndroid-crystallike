/**
 * Created by : yds
 * Time: 2020-12-21 10:31 PM
 */
package com.crystallake.wanandroid.adapter;

import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleBean;
import com.crystallake.wanandroid.module.navi.bean.NaviBean;
import com.google.android.flexbox.FlexboxLayout;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Queue;

public class NaviAdapter extends BaseQuickAdapter<NaviBean, BaseViewHolder> {

    private LayoutInflater mInflater;
    private Queue<TextView> mTextViewQueue = new LinkedList<>();

    public NaviAdapter() {
        super(R.layout.item_knowledge);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, NaviBean naviBean) {
        holder.setText(R.id.tv_name,naviBean.getName());
        FlexboxLayout fbl = holder.getView(R.id.flex_box_layout);
        for (int i=0;i<naviBean.getArticles().size();i++){
            ArticleBean childItem = naviBean.getArticles().get(i);
            TextView child = createOrGetCacheFlexItemTextView(fbl);
            child.setText(childItem.getTitle());
            fbl.addView(child);
        }
    }

    @Override
    public void onViewRecycled(@NonNull BaseViewHolder holder) {
        super.onViewRecycled(holder);
        FlexboxLayout fbl = holder.getView(R.id.flex_box_layout);
        for(int i=0;i<fbl.getChildCount();i++){
            mTextViewQueue.offer((TextView) fbl.getChildAt(i));
        }
        fbl.removeAllViews();
    }

    private TextView createOrGetCacheFlexItemTextView(FlexboxLayout fbl) {
        TextView tv = mTextViewQueue.poll();
        if (tv!=null){
            return tv;
        }
        return createFlexItemTextView(fbl);
    }

    private TextView createFlexItemTextView(FlexboxLayout fbl) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(fbl.getContext());
        }
        return (TextView) mInflater.inflate(R.layout.item_knowledge_child,fbl,false);
    }
}
