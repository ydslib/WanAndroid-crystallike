/**
 * Created by : yds
 * Time: 2020-12-20 6:02 PM
 */
package com.crystallake.wanandroid.module.navi.mvp.contract;

import com.crystallake.basic.base.mvp.model.IModel;
import com.crystallake.basic.base.mvp.presenter.IPresenter;
import com.crystallake.basic.base.mvp.view.IView;
import com.crystallake.wanandroid.module.navi.bean.NaviBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface NaviContract {
    interface NaviView extends IView{
        void getNaviListSuccess(List<NaviBean> data);
        void getNaviListFailed(String msg);
    }

    interface NaviPresenter extends IPresenter<NaviView>{
        void getNaviList();
    }

    interface NaviModel extends IModel{
        Observable<List<NaviBean>> getNaviList();
    }
}
