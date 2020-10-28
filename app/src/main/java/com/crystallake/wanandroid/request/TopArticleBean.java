package com.crystallake.wanandroid.request;

import com.crystallake.mylibrary.net.common.BasicResponse;
import com.google.gson.Gson;

import java.util.List;

/**
 * @author CuiZhen
 * @date 2019/5/15
 * GitHub: https://github.com/goweii
 */
public class TopArticleBean extends BasicResponse<List<BaseArticleData>> {

    @Override
    public String toString() {
        return "TopArticleBean{" +
                "errorCode=" + getErrorCode() +
                ", errorMsg='" + getErrorMsg() + '\'' +
                ", data=" + new Gson().toJson(getData()) +
                '}';
    }
}