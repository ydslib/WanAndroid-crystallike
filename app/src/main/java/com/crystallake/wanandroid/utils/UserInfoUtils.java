/**
 * Created by : yds
 * Time: 2020-12-06 6:12 PM
 */
package com.crystallake.wanandroid.utils;

import android.content.Context;
import android.text.TextUtils;

import com.crystallake.basic.utils.SPUtils;
import com.crystallake.wanandroid.module.login.activity.LoginActivity;
import com.crystallake.wanandroid.module.login.bean.LoginBean;
import com.google.gson.Gson;

public class UserInfoUtils {
    private LoginBean mLoginBean = null;
    private static final String KEY_LOGIN_BEAN = "KEY_LOGIN_BEAN";

    private static class Holder {
        private static final UserInfoUtils INSTANCE = new UserInfoUtils();
    }

    public static UserInfoUtils getInstance() {
        return Holder.INSTANCE;
    }

    private UserInfoUtils() {
        getLoginBean();
    }

    public LoginBean getLoginBean() {
        if (mLoginBean == null) {
            String json = SPUtils.getInstance().getString(KEY_LOGIN_BEAN);
            if (!TextUtils.isEmpty(json)) {
                try {
                    mLoginBean = new Gson().fromJson(json, LoginBean.class);
                }catch (Exception ignore){

                }
            }
        }
        return mLoginBean;
    }

    public boolean isLogin(){
        return mLoginBean!=null&&mLoginBean.getId()>0;
    }

    public int getUserId(){
        if (mLoginBean==null){
            return 0;
        }
        return mLoginBean.getId();
    }

    public boolean loginIfNot(Context context){
        if (isLogin()){
            return true;
        }
        LoginActivity.start(context);
        return false;
    }
}
