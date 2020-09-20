package com.crystallake.wanandroid.net;


import com.crystallake.wanandroid.request.ArticleWrapper;
import com.crystallake.wanandroid.request.WxArticleAuthor;
import com.crystallake.wanandroid.response.LoginResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by dell on 2017/4/1.
 */

public interface IdeaApiService {

    /**
     * 首页文章列表
     */
    @GET("article/list/0/json")
    Observable<ArticleWrapper> getArticle();

    /**
     * 登录 appId secret
     * 使用实体类作为参数
     *
     * @return
     */
    @POST("user/login")
    Observable<LoginResponse> login(@Body LoginRequest request);

    /**
     * 使用map作为参数
     *
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginResponse> login(@FieldMap Map<String, Object> map);

    /**
     * 微信公众号作者列表
     */
    @GET("wxarticle/chapters/json")
    Observable<WxArticleAuthor> getWxAuthor();

}
