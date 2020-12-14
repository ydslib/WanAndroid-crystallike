/**
 * Created by : yds
 * Time: 2020-12-12 8:37 PM
 */
package com.crystallake.wanandroid.module.home.mvp.model;

import com.crystallake.basic.base.mvp.model.BaseModel;
import com.crystallake.wanandroid.http.RetrofitHelper;
import com.crystallake.wanandroid.http.response.WanResponse;
import com.crystallake.wanandroid.module.home.mvp.contract.HomeContract;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleBean;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeModel extends BaseModel implements HomeContract.HomeModel {
    @Override
    public Observable<List<ArticleBean>> getTopArticleList() {
        return RetrofitHelper.getRetrofitService()
                .getTopArticleList()
                .map(new Function<WanResponse<List<ArticleBean>>, List<ArticleBean>>() {
                    @Override
                    public List<ArticleBean> apply(WanResponse<List<ArticleBean>> response) throws Exception {
                        return response.getData();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ArticleListBean> getArticleListBean(int page, boolean refresh) {
        return RetrofitHelper.getRetrofitService()
                .getArticleList(page)
                .map(new Function<WanResponse<ArticleListBean>, ArticleListBean>() {
                    @Override
                    public ArticleListBean apply(WanResponse<ArticleListBean> response) throws Throwable {
                        return response.getData();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
