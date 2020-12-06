/**
 * Created by : yds
 * Time: 2020-12-02 10:34 PM
 */
package com.crystallake.wanandroid.module.main.mvp.model;

import com.crystallake.basic.base.mvp.model.BaseModel;
import com.crystallake.wanandroid.module.main.mvp.bean.ArticleListBean;
import com.crystallake.wanandroid.module.main.mvp.contract.UserArticleContract;

import io.reactivex.rxjava3.core.Observable;

public class UserArticleModel extends BaseModel implements UserArticleContract.UserArticleModel {

    @Override
    public Observable<ArticleListBean> getUserArticleList(int page, boolean refresh) {
        return null;
    }
}
