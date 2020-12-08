/**
 * Created by : yds
 * Time: 2020-12-07 10:03 PM
 */
package com.crystallake.wanandroid.http.api;

import com.crystallake.wanandroid.http.response.WanResponse;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiService {
    /**
     * 广场列表数据
     * 可能出现返回列表数据<每页数据，因为有自见的文章被过滤掉了。
     * page 0开始
     */
    @GET("/user_article/list/{page}/json")
    Observable<WanResponse<ArticleListBean>> getUserArticleList(@Path("page") int page);
}
