/**
 * Created by : yds
 * Time: 2020-12-24 8:31 PM
 */
package com.crystallake.basic.utils.click;

import android.util.LongSparseArray;
import android.view.View;

import androidx.annotation.NonNull;


public class ClickUtils {


    /**
     * 500毫秒内只能点击一次
     */
    public static void disContinuousClick(final View target, @NonNull final Callback callback) {
        int id = target.getId();
        ViewCacheNode node = ViewCacheNode.getOrDefault(id);
        System.out.println();
        if (node.isCanClick) {
            callback.onClick(target);
        }

    }

    public interface Callback {
        void onClick(View view);
    }

}
