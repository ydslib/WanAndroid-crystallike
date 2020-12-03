/**
 * Created by : yds
 * Time: 2020-12-02 10:37 PM
 */
package com.crystallake.wanandroid.module.main.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.main.mvp.contract.UserArticleContract;
import com.crystallake.wanandroid.module.main.mvp.model.UserArticleModel;

public class UserArticlePresenter extends BasePresenter<UserArticleModel, UserArticleContract.UserArticleView>
        implements UserArticleContract.UserArticlePresenter {
    @Override
    protected UserArticleModel createModel() {
        return new UserArticleModel();
    }
}
