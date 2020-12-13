/**
 * Created by : yds
 * Time: 2020-12-12 8:57 PM
 */
package com.crystallake.wanandroid.entity;

public class TabEntity {
    private String mTabName;
    private int mTabIconRes;
    private int mMsgCount;

    public TabEntity(String tabName,int tabIconRes,int msgCount){
        mTabName = tabName;
        mTabIconRes = tabIconRes;
        mMsgCount = msgCount;
    }

    public String getTabName() {
        return mTabName;
    }

    public void setTabName(String tabName) {
        mTabName = tabName;
    }

    public int getTabIconRes() {
        return mTabIconRes;
    }

    public void setTabIconRes(int tabIconRes) {
        mTabIconRes = tabIconRes;
    }

    public int getMsgCount() {
        return mMsgCount;
    }

    public void setMsgCount(int msgCount) {
        mMsgCount = msgCount;
    }
}
