/**
 * Created by : yds
 * Time: 2020-08-16 9:00 PM
 */
package com.crystallake.mylibrary.net.interceptor;

import com.crystallake.mylibrary.utils.LogUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LoggingInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = System.nanoTime();
        LogUtils.e(String.format("请求URL------%s on %s%n请求头------%s",
                request.url(), chain.connection(), request.headers()));
        Response response = chain.proceed(request);

        long endTime = System.nanoTime();
        ResponseBody responseBody = response.peekBody(1024*1024);
        LogUtils.e(String.format("响应URL-------: %s %n响应数据------%s 请求用时--------%.1fms%n%s",
                response.request().url(),
                responseBody.string(),
                (startTime - endTime) / 1e6d,
                response.headers()));

        return response;
    }
}
