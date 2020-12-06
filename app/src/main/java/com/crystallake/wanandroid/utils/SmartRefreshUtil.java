/**
 * Created by : yds
 * Time: 2020-12-06 8:12 PM
 */
package com.crystallake.wanandroid.utils;

import androidx.annotation.NonNull;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

public class SmartRefreshUtil {
    private static final int FIRST_PAGE = 0;

    private RefreshLayout mRefreshLayout;
    private RefreshListener mRefreshListener;
    private LoadMoreListener mLoadMoreListener;

    private SmartRefreshUtil(RefreshLayout refreshLayout){
        mRefreshLayout = refreshLayout;
        //禁止自动加载更多
        mRefreshLayout.setEnableAutoLoadMore(false);
        //设置可以滑动到边界外
        mRefreshLayout.setEnableOverScrollBounce(true);
    }


    public static SmartRefreshUtil with(RefreshLayout refreshLayout){
        return new SmartRefreshUtil(refreshLayout);
    }
    /**
     * 下拉刷新监听
     * @param listener
     * @return
     */
    public SmartRefreshUtil setRefreshListener(RefreshListener listener){
        mRefreshListener = listener;
        if (listener == null) {
            mRefreshLayout.setEnableRefresh(false);
        }else{
            mRefreshLayout.setEnableRefresh(true);
            mRefreshLayout.setEnablePureScrollMode(false);
            mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    refreshLayout.finishRefresh((int) Config.HTTP_TIMEOUT,false,false);
                    mRefreshListener.onRefresh();
                }
            });
        }
        return this;
    }

    public SmartRefreshUtil setLoadMoreListener(LoadMoreListener listener){
        mLoadMoreListener = listener;
        if (listener == null) {
            mRefreshLayout.setEnableLoadMore(false);
        }else{
            mRefreshLayout.setEnablePureScrollMode(false);
            mRefreshLayout.setEnableLoadMore(true);
            mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    refreshLayout.finishLoadMore((int) Config.HTTP_TIMEOUT);
                    mLoadMoreListener.onLoadMore();
                }
            });
        }
        return this;
    }

    public SmartRefreshUtil pureScrollMode(){
        mRefreshLayout.setEnableRefresh(false);
        mRefreshLayout.setEnableLoadMore(false);
        mRefreshLayout.setEnablePureScrollMode(true);
        mRefreshLayout.setEnableNestedScroll(true);
        mRefreshLayout.setEnableOverScrollDrag(true);
        return this;
    }

    public void success(){
        mRefreshLayout.finishRefresh(true);
        mRefreshLayout.finishLoadMore(true);
    }

    public void fail(){
        mRefreshLayout.finishRefresh(false);
        mRefreshLayout.finishLoadMore(false);
    }

    public interface RefreshListener{
        void onRefresh();
    }

    public interface LoadMoreListener{
        void onLoadMore();
    }
}
