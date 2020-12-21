/**
 * Created by : yds
 * Time: 2020-12-20 6:03 PM
 */
package com.crystallake.wanandroid.module.navi.mvp.model;

import com.crystallake.basic.base.mvp.model.BaseModel;
import com.crystallake.wanandroid.http.RetrofitHelper;
import com.crystallake.wanandroid.http.response.WanResponse;
import com.crystallake.wanandroid.module.navi.bean.NaviBean;
import com.crystallake.wanandroid.module.navi.mvp.contract.NaviContract;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NaviModel extends BaseModel implements NaviContract.NaviModel {
    @Override
    public Observable<List<NaviBean>> getNaviList() {
        return RetrofitHelper.getRetrofitService()
                .getNaviList()
                .map(new Function<WanResponse<List<NaviBean>>, List<NaviBean>>() {
                    @Override
                    public List<NaviBean> apply(WanResponse<List<NaviBean>> response) throws Throwable {
                        return response.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
