/************************************************************
 * Copyright 2000-2020 OPPO Mobile Comm Corp., Ltd.
 * All rights reserved.
 * <p>
 * FileName       : RequestLifecycle.java
 * Version Number : 1.0
 * Description    :
 * Author         : Dongsheng.Ye
 * Date           : 2020/10/12
 * History        :( ID,     Date,         Author, Description)
 * v1.0, 2020/10/12, Dongsheng.Ye, create
 ************************************************************/
package com.crystallake.wanandroid.core;

public interface RequestLifecycle {
    void startLoading();
    void loadFinished();
    void loadFailed(String msg);
}
    