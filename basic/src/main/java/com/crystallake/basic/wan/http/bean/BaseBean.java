package com.crystallake.basic.wan.http.bean;

import com.crystallake.basic.utils.JsonFormatUtils;
import com.google.gson.Gson;

import java.io.Serializable;

public class BaseBean implements Serializable {

    public String toJson() {
        return new Gson().toJson(this);
    }

    public String toFormatJson() {
        return JsonFormatUtils.format(toJson());
    }
}