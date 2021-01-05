/**
 * Created by : yds
 * Time: 2020-12-24 4:04 PM
 */
package com.crystallake.wanandroid.event;

import com.crystallake.basic.wan.base.BaseEvent;

public class LoginEvent extends BaseEvent {

    private boolean login;

    public LoginEvent(boolean login){
        this.login = login;
    }
    public void setLogin(boolean login){
        this.login = login;
    }

    public boolean isLogin(){
        return login;
    }
}
