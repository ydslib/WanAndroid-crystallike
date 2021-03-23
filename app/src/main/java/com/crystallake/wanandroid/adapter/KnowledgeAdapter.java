/**
 * Created by : yds
 * Time: 2020-12-20 8:50 PM
 */
package com.crystallake.wanandroid.adapter;

import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.module.knowledge.bean.ChapterBean;
import com.google.android.flexbox.FlexboxLayout;


import java.util.LinkedList;
import java.util.Queue;


public class KnowledgeAdapter extends BaseQuickAdapter<ChapterBean, BaseViewHolder> {

    private Queue<TextView> mFlexTextCaches = new LinkedList<>();
    private LayoutInflater mInflater;

    public KnowledgeAdapter() {
        super(R.layout.item_knowledge);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, ChapterBean bean) {
        holder.setText(R.id.tv_name,bean.getName());
        FlexboxLayout flexboxLayout = holder.getView(R.id.flex_box_layout);
        for(int i=0;i<bean.getChildren().size();i++){
            ChapterBean childItem = bean.getChildren().get(i);
            TextView child = createOrGetCacheFlexItemTextView(flexboxLayout);
            child.setText(childItem.getName());
            flexboxLayout.addView(child);
        }

    }

    @Override
    public void onViewRecycled(@NonNull BaseViewHolder holder) {
        super.onViewRecycled(holder);
        FlexboxLayout fbl = holder.getView(R.id.flex_box_layout);
        for(int i=0;i<fbl.getChildCount();i++){
            mFlexTextCaches.offer((TextView) fbl.getChildAt(i));
        }
        fbl.removeAllViews();
    }

    private TextView createOrGetCacheFlexItemTextView(FlexboxLayout fbl){
        TextView tv = mFlexTextCaches.poll();
        if (tv!=null){
            return tv;
        }
        return createFlexItemTextView(fbl);
    }

    private TextView createFlexItemTextView(FlexboxLayout fbl) {
        if (mInflater==null){
            mInflater = LayoutInflater.from(fbl.getContext());
        }
        return (TextView) mInflater.inflate(R.layout.item_knowledge_child,fbl,false);
    }
}
