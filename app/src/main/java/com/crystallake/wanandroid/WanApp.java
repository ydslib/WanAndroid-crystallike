/**
 * Created by : yds
 * Time: 2020-08-23 12:32 PM
 */
package com.crystallake.wanandroid;

import android.app.Application;

import com.crystallake.mylibrary.utils.Utils;

public class WanApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
