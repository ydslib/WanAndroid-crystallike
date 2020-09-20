/**
 * Created by : yds
 * Time: 2020-08-16 9:18 PM
 */
package com.crystallake.mylibrary.net.interceptor;

import com.crystallake.mylibrary.utils.LogUtils;
import com.crystallake.mylibrary.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HttpCacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetworkUtils.isConnected()) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            LogUtils.d("Okhttp","no network");
        }
        Response originalResponse = chain.proceed(request);
        if(NetworkUtils.isConnected()){
            String cacheControl = request.cacheControl().toString();
            return originalResponse.newBuilder()
                    .header("Cache-Control",cacheControl)
                    .removeHeader("Pragma")
                    .build();
        }else{
            return originalResponse.newBuilder()
                    .header("Cache-Control","public,only-if-cached,max-stale=2419200")
                    .removeHeader("Progma")
                    .build();
        }
    }
}
