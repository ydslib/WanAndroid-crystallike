/**
 * Created by : yds
 * Time: 2020-10-09 10:48 PM
 */
package com.crystallake.wanandroid.mvp.module;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.crystallake.mylibrary.net.common.ResponseObserver;
import com.crystallake.mylibrary.utils.RxUtil;
import com.crystallake.wanandroid.net.RetrofitHelper;
import com.crystallake.wanandroid.request.ArticleBean;
import com.crystallake.wanandroid.request.BannerBean;
import com.crystallake.wanandroid.request.BaseArticleData;
import com.crystallake.wanandroid.request.TopArticleBean;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class HomeModel extends AndroidViewModel {
    MutableLiveData<BannerBean> mMutableLiveData;
    MutableLiveData<List<BaseArticleData>> mArticleWrapperMutableLiveData;
    private Application mApplication;

    public HomeModel(@NonNull Application application) {
        super(application);
        mApplication = application;
    }

    public MutableLiveData<List<BaseArticleData>> getArticleWrapperMutableLiveData() {
        if (mArticleWrapperMutableLiveData == null) {
            mArticleWrapperMutableLiveData = new MutableLiveData<>();
        }
        return mArticleWrapperMutableLiveData;
    }

    public MutableLiveData<BannerBean> getMutableLiveData() {
        if (mMutableLiveData == null) {
            mMutableLiveData = new MutableLiveData<>();
        }
        return mMutableLiveData;
    }

    private Observable<List<BaseArticleData>> getTopArticle() throws IOException {
        return RetrofitHelper.getApiService().getTopArticle().subscribeOn(Schedulers.io()).flatMap(new Function<TopArticleBean, ObservableSource<List<BaseArticleData>>>() {
            @Override
            public ObservableSource<List<BaseArticleData>> apply(TopArticleBean bean) throws Exception {
                return Observable.just(bean.getData());
            }
        });
    }

    private Observable<List<BaseArticleData>> getArticle() throws IOException {
        return RetrofitHelper.getApiService().getArticle(0).subscribeOn(Schedulers.io()).flatMap(new Function<ArticleBean, ObservableSource<List<BaseArticleData>>>() {
            @Override
            public ObservableSource<List<BaseArticleData>> apply(ArticleBean bean) throws Exception {
                return Observable.just(bean.getData().getDatas());
            }
        });
    }

    public void getArticleData(WeakReference<RxFragment> weakReference, int curPage) {
        try {
            Disposable subscribe = Observable.concat(getTopArticle(), getArticle())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<BaseArticleData>>() {
                        @Override
                        public void accept(List<BaseArticleData> baseArticleData) throws Exception {
                            getArticleWrapperMutableLiveData().setValue(baseArticleData);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(ServerConfig.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        IdeaApiService apiService = retrofit.create(IdeaApiService.class);
//
//        Observable.just(1).concatMap(new Function<Integer, ObservableSource<ArticleBean>>() {
//            @Override
//            public ObservableSource<ArticleBean> apply(Integer integer) throws Exception {
//
//                ArticleBean articleBean = apiService.getTopArticle().execute().body();
//                return Observable.just(articleBean);
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<ArticleBean>() {
//                    @Override
//                    public void accept(ArticleBean wrapper) throws Exception {
//                        System.out.println(wrapper);
//                    }
//                });
//
//        Observable.just(0)
//                .concatMap(new Function<Integer, ObservableSource<List<BaseArticleData>>>() {
//                    @Override
//                    public ObservableSource<List<BaseArticleData>> apply(Integer integer) throws Exception {
//                        TopArticleBean topArticleBean = apiService.getTopArticle().execute().body();
//                        List<BaseArticleData> list = new ArrayList<BaseArticleData>(topArticleBean.getData());
//                        ArticleBean articleBean = apiService.getArticle(integer).execute().body();
//                        list.addAll(articleBean.getData().getDatas());
//
//                        return Observable.just(list);
//                    }
//                }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<List<BaseArticleData>>() {
//                    @Override
//                    public void accept(List<BaseArticleData> list) throws Exception {
//                        getArticleWrapperMutableLiveData().setValue(list);
//                    }
//                });
//        RetrofitHelper.getApiService()
//                .getTopArticle()
//                .concatMap(new Function<ArticleBean, ObservableSource<ArticleWrapper.DataBean.DatasBean>>() {
//                    @Override
//                    public ObservableSource<ArticleWrapper.DataBean.DatasBean> apply(ArticleBean articleBean) throws Exception {
//                        ArticleWrapper.DataBean.DatasBean datasBean = convert(articleBean);
//                        return Observable.just(datasBean);
//                    }
//                }).concatMap(new Function<ArticleWrapper.DataBean.DatasBean, ObservableSource<List<ArticleWrapper.DataBean.DatasBean>>>() {
//            @Override
//            public ObservableSource<List<ArticleWrapper.DataBean.DatasBean>> apply(ArticleWrapper.DataBean.DatasBean datasBean) throws Exception {
//                List<ArticleWrapper.DataBean.DatasBean> datasBeanList = new ArrayList<>();
//                datasBeanList.add(datasBean);
//                RetrofitHelper.getApiService().getArticle(0);
//                return null;
//            }
//        })
//        RetrofitHelper.getApiService()
//                .getArticle(curPage)
//                .compose(RxUtil.rxSchedulerHelper(weakReference.get(),true))
//                .subscribe(new ResponseObserver<ArticleWrapper>() {
//                    @Override
//                    public void onSuccess(ArticleWrapper response) {
//                        if (response != null) {
//                            getArticleWrapperMutableLiveData().setValue(response);
//                        }
//                    }
//                });
    }

    public void getTopArticleData() {

    }


    public void getBannerData() {
        RetrofitHelper.getApiService()
                .getBannerBean()
                .compose(RxUtil.rxSchedulerHelper())
                .subscribe(new ResponseObserver<BannerBean>() {
                    @Override
                    public void onSuccess(BannerBean response) {
                        System.out.println("----------");
                        if (response != null) {
                            getMutableLiveData().setValue(response);
                            System.out.println("result:" + response.getData());
                        }
                    }
                });
    }
}
