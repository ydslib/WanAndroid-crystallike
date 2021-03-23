/**
 * Created by : yds
 * Time: 2020-12-12 10:32 PM
 */
package com.crystallake.wanandroid.module.question.mvp.model;

import com.crystallake.basic.base.mvp.model.BaseModel;
import com.crystallake.wanandroid.http.RetrofitHelper;
import com.crystallake.wanandroid.http.response.WanResponse;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;
import com.crystallake.wanandroid.module.question.mvp.contract.QuestionContract;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class QuestionModel extends BaseModel implements QuestionContract.QuestionModel {
    @Override
    public Observable<ArticleListBean> getQuestionList(int page) {
        return RetrofitHelper.getRetrofitService()
                .getQuestionList(page)
                .map(WanResponse::getData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
