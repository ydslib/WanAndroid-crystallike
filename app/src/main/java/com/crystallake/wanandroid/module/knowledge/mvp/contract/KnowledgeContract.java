/**
 * Created by : yds
 * Time: 2020-12-12 10:36 PM
 */
package com.crystallake.wanandroid.module.knowledge.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;

public interface KnowledgeContract {
    interface KnowledgeView extends IView{

    }

    interface KnowledgePresenter extends IPresenter<KnowledgeView>{

    }

    interface KnowledgeModel extends IModel{

    }
}
