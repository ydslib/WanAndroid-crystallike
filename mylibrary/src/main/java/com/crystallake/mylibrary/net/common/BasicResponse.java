/**
 * Created by : yds
 * Time: 2020-08-16 8:55 PM
 */
package com.crystallake.mylibrary.net.common;

public class BasicResponse<T> {
    private int errorCode;
    private String errorMsg;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T results) {
        this.data = results;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public void setCode(int code) {
        this.errorCode = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String message) {
        this.errorMsg = message;
    }
}
