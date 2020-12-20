/**
 * Created by : yds
 * Time: 2020-12-20 6:11 PM
 */
package com.crystallake.wanandroid.utils;

import android.app.Application;
import android.content.Context;

public class AppUtils {
    private static Application mApp;
    public static void init(Application application){
        mApp = application;
    }

    public static Context getAppContext(){
        if (mApp==null){
            throw new RuntimeException("please init in application first");
        }
        return mApp.getApplicationContext();
    }
}
