/**
 * Created by : yds
 * Time: 2020-12-02 10:37 PM
 */
package com.crystallake.wanandroid.module.main.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.main.mvp.contract.ArticleListContract;
import com.crystallake.wanandroid.module.main.mvp.model.ArticleListModel;

public class ArticleListPresenter extends BasePresenter<ArticleListModel, ArticleListContract.ArticleListView>
        implements ArticleListContract.ArticleListPresenter {
    @Override
    protected ArticleListModel createModel() {
        return new ArticleListModel();
    }
}
