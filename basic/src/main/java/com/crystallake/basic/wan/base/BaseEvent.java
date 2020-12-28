/**
 * Created by : yds
 * Time: 2020-12-24 4:02 PM
 */
package com.crystallake.basic.wan.base;

import org.greenrobot.eventbus.EventBus;

public class BaseEvent {
    public void post(){
        EventBus.getDefault().post(this);
    }

    public void postSticky(){
        EventBus.getDefault().postSticky(this);
    }

    public void removeSticky(){
        EventBus.getDefault().removeStickyEvent(this);
    }

}
