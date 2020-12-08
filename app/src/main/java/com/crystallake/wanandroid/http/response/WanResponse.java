/**
 * Created by : yds
 * Time: 2020-12-07 10:10 PM
 */
package com.crystallake.wanandroid.http.response;

import com.crystallake.basic.wan.http.response.BaseResponse;

public class WanResponse<E> implements BaseResponse<E> {

    private int errorCode;
    private String errorMsg;
    private E data;

    @Override
    public int getCode() {
        return errorCode;
    }

    @Override
    public void setCode(int code) {
        errorCode = code;
    }

    @Override
    public E getData() {
        return data;
    }

    @Override
    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String getMsg() {
        return errorMsg;
    }

    @Override
    public void setMsg(String msg) {
        errorMsg = msg;
    }
}
