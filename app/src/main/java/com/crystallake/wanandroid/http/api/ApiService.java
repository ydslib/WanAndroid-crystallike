/**
 * Created by : yds
 * Time: 2020-12-07 10:03 PM
 */
package com.crystallake.wanandroid.http.api;

import com.crystallake.wanandroid.http.response.WanResponse;
import com.crystallake.wanandroid.module.home.bean.BannerBean;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleBean;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiService {
    /**
     * 广场列表数据
     * 可能出现返回列表数据<每页数据，因为有自见的文章被过滤掉了。
     * page 0开始
     */
    @GET("user_article/list/{page}/json")
    Observable<WanResponse<ArticleListBean>> getUserArticleList(@Path("page") int page);

    /**
     * 置顶文章
     * 方法：GET
     */
    @GET("article/top/json")
    Observable<WanResponse<List<ArticleBean>>> getTopArticleList();

    /**
     * 首页文章列表
     * 方法：GET
     * 参数：页码，拼接在连接中，从0开始。
     */
    @GET("article/list/{page}/json")
    Observable<WanResponse<ArticleListBean>> getArticleList(@Path("page") int page);

    /**
     * 首页banner
     */
    @GET("banner/json")
    Observable<WanResponse<List<BannerBean>>> getBanner();

    /**
     * 问答
     * pageId,拼接在链接上，例如上面的1
     */
    @GET("wenda/list/{page}/json")
    Observable<WanResponse<ArticleListBean>> getQuestionList(@Path("page") int page);
}
