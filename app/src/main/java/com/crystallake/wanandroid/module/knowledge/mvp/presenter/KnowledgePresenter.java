/**
 * Created by : yds
 * Time: 2020-12-12 10:38 PM
 */
package com.crystallake.wanandroid.module.knowledge.mvp.presenter;

import com.crystallake.basic.base.mvp.presenter.BasePresenter;
import com.crystallake.wanandroid.module.knowledge.mvp.contract.KnowledgeContract;
import com.crystallake.wanandroid.module.knowledge.mvp.model.KnowledgeModel;

public class KnowledgePresenter extends BasePresenter<KnowledgeModel, KnowledgeContract.KnowledgeView>
        implements KnowledgeContract.KnowledgePresenter {
    @Override
    protected KnowledgeModel createModel() {
        return new KnowledgeModel();
    }
}
