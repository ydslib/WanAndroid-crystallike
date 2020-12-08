package com.crystallake.basic.wan.http.response;

public interface BaseResponse<E> {
    int getCode();
    void setCode(int code);

    E getData();
    void setData(E data);

    String getMsg();

    void setMsg(String msg);
}
