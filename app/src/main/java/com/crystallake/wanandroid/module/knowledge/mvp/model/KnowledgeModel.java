/**
 * Created by : yds
 * Time: 2020-12-12 10:38 PM
 */
package com.crystallake.wanandroid.module.knowledge.mvp.model;

import com.crystallake.basic.base.mvp.model.BaseModel;
import com.crystallake.wanandroid.http.RetrofitHelper;
import com.crystallake.wanandroid.http.response.WanResponse;
import com.crystallake.wanandroid.module.knowledge.bean.ChapterBean;
import com.crystallake.wanandroid.module.knowledge.mvp.contract.KnowledgeContract;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class KnowledgeModel extends BaseModel implements KnowledgeContract.KnowledgeModel {
    @Override
    public Observable<List<ChapterBean>> getKnowledgeList() {
        return RetrofitHelper.getRetrofitService()
                .getKnowledgeList()
                .map(new Function<WanResponse<List<ChapterBean>>, List<ChapterBean>>() {
                    @Override
                    public List<ChapterBean> apply(WanResponse<List<ChapterBean>> response) throws Throwable {
                        return response.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
