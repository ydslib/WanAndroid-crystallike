/**
 * Created by : yds
 * Time: 2020-12-12 8:56 PM
 */
package com.crystallake.wanandroid.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.crystallake.wanandroid.R;
import com.crystallake.wanandroid.entity.TabEntity;

public class MainTabAdapter implements TabAdapter<TabEntity> {


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindData(@NonNull View view, @NonNull TabEntity data, boolean selected) {
        Context context = view.getContext();
        ImageView tabIcon = view.findViewById(R.id.tab_icon);
        TextView tabName = view.findViewById(R.id.tab_name);
        TextView tabMsg = view.findViewById(R.id.tv_tab_msg);
        tabIcon.setImageResource(data.getTabIconRes());
        tabName.setText(data.getTabName());
        if (selected){
            tabIcon.setColorFilter(ContextCompat.getColor(context,R.color.main));
            tabName.setTextColor(ContextCompat.getColor(context,R.color.main));
        }else{
            tabIcon.setColorFilter(ContextCompat.getColor(context,R.color.text_def));
            tabName.setTextColor(ContextCompat.getColor(context,R.color.text_def));
        }

        if (data.getMsgCount()>0){
            tabMsg.setVisibility(View.VISIBLE);
            if (data.getMsgCount()>99){
                tabMsg.setText("99+");
            }else{
                tabMsg.setText(data.getMsgCount()+"");
            }
        }else{
            tabMsg.setVisibility(View.GONE);
        }

    }

    @Override
    public void onDoubleTap(Fragment fragment) {

    }
}
