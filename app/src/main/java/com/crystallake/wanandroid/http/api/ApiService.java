/**
 * Created by : yds
 * Time: 2020-12-07 10:03 PM
 */
package com.crystallake.wanandroid.http.api;

import com.crystallake.wanandroid.http.response.WanResponse;
import com.crystallake.wanandroid.module.home.bean.BannerBean;
import com.crystallake.wanandroid.module.knowledge.bean.ChapterBean;
import com.crystallake.wanandroid.module.login.bean.LoginBean;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleBean;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;
import com.crystallake.wanandroid.module.navi.bean.NaviBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    /**
     * 体系数据
     */
    @GET("tree/json")
    Observable<WanResponse<List<ChapterBean>>> getKnowledgeList();
    /**
     * 搜索热词
     */
    @GET("navi/json")
    Observable<WanResponse<List<NaviBean>>> getNaviList();

    /**
     * 登录
     * 方法： POST
     * 参数：
     * username，password
     * 登录后会在cookie中返回账号密码，只要在客户端做cookie持久化存储即可自动登录验证。
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<WanResponse<LoginBean>> login(@Field("username") String username,
                                                          @Field("password") String password);



    /**
     * 获取个人积分
     */
    @GET("lg/coin/getcount/json")
    Observable<WanResponse<Integer>> getCoin();


}
