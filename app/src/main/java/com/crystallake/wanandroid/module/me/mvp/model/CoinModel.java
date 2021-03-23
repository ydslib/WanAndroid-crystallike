/**
 * Created by : yds
 * Time: 2020-12-28 10:21 PM
 */
package com.crystallake.wanandroid.module.me.mvp.model;

import com.crystallake.basic.base.mvp.model.BaseModel;
import com.crystallake.wanandroid.http.RetrofitHelper;
import com.crystallake.wanandroid.http.response.WanResponse;
import com.crystallake.wanandroid.module.me.mvp.contract.CoinContract;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CoinModel extends BaseModel implements CoinContract.CoinModel {
    @Override
    public Observable<Integer> getCoin() {
        return RetrofitHelper.getRetrofitService()
                .getCoin()
                .map(WanResponse::getData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
