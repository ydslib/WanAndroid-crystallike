/**
 * Created by : yds
 * Time: 2020-08-16 9:13 PM
 */
package com.crystallake.mylibrary.net.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HttpHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        String accessToken = "token";
        String tokenType = "tokenType";
        Request request = chain.request().newBuilder()
                .header("app_key","appId")
                .header("Authorization",tokenType+" "+accessToken)
                .header("Content-Type","application/json")
                .addHeader("Connection","close")
                .addHeader("Accept-Encoding","identity")
                .build();

        return chain.proceed(request);
    }
}
