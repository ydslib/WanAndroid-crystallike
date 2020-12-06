/**
 * Created by : yds
 * Time: 2020-12-06 5:40 PM
 */
package com.crystallake.wanandroid.module.main.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.main.mvp.contract.ShareArticleContract;
import com.crystallake.wanandroid.module.main.mvp.model.ShareArticleModel;

public class ShareArticlePresenter extends BasePresenter<ShareArticleModel, ShareArticleContract.ShareArticleView>
        implements ShareArticleContract.ShareArticlePresenter {

    @Override
    protected ShareArticleModel createModel() {
        return new ShareArticleModel();
    }
}
