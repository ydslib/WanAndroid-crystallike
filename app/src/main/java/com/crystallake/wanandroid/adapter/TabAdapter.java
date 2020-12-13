/**
 * Created by : yds
 * Time: 2020-12-12 8:52 PM
 */
package com.crystallake.wanandroid.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public interface TabAdapter<T> {
    void onBindData(@NonNull View view, @NonNull T data, boolean selected);
    void onDoubleTap(Fragment fragment);
}
