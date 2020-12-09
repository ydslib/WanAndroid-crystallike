/**
 * Created by : yds
 * Time: 2020-12-02 10:34 PM
 */
package com.crystallake.wanandroid.module.main.mvp.model;

import com.crystallake.basic.base.mvp.model.BaseModel;
import com.crystallake.wanandroid.http.RetrofitHelper;
import com.crystallake.wanandroid.http.response.WanResponse;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;
import com.crystallake.wanandroid.module.main.mvp.contract.UserArticleContract;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class UserArticleModel extends BaseModel implements UserArticleContract.UserArticleModel {

    @Override
    public Observable<ArticleListBean> getUserArticleList(int page, boolean refresh) {
        return RetrofitHelper.getRetrofitService().getUserArticleList(page)
                .map(new Function<WanResponse<ArticleListBean>, ArticleListBean>() {
                    @Override
                    public ArticleListBean apply(WanResponse<ArticleListBean> response) throws Throwable {
                        return response.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
