/**
 * Created by : yds
 * Time: 2020-12-06 9:14 PM
 */
package com.crystallake.wanandroid.http;

import com.crystallake.basic.http.RetrofitManager;
import com.crystallake.wanandroid.http.api.Api;
import com.crystallake.wanandroid.http.api.ApiService;

public class RetrofitHelper {

    public static ApiService getRetrofitService(){
        return RetrofitManager.getInstance().obtainRetrofitService(Api.BASE_URL,ApiService.class);
    }
}
