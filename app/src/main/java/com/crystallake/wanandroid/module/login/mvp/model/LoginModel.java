/**
 * Created by : yds
 * Time: 2020-12-24 11:54 AM
 */
package com.crystallake.wanandroid.module.login.mvp.model;

import com.crystallake.basic.base.mvp.model.BaseModel;
import com.crystallake.wanandroid.http.RetrofitHelper;
import com.crystallake.wanandroid.http.response.WanResponse;
import com.crystallake.wanandroid.module.login.bean.LoginBean;
import com.crystallake.wanandroid.module.login.mvp.contract.LoginContract;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginModel extends BaseModel implements LoginContract.LoginModel {

    @Override
    public Observable<LoginBean> login(String userName, String password) {
        return RetrofitHelper.getRetrofitService().login(userName,password)
                .map(WanResponse::getData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
