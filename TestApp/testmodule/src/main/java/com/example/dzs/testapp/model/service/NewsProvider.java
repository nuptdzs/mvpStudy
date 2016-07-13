package com.example.dzs.testapp.model.service;

import com.example.dzs.testapp.commom.ICallBack;
import com.example.dzs.testapp.utils.RetrofitUtils;
import com.example.dzs.testapp.model.bean.NewsModel;
import com.example.dzs.testapp.model.bean.Story;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dzs on 2016/7/11.
 */
public class NewsProvider {
    public static String ZHI_HU_NEWS_BASE_URL = "http://news.at.zhihu.com/";

    /**
     * 获取最新知乎推送消息列表
     * @param callback
     */
    public static void getNewsList(final ICallBack<NewsModel<Story>> callback){
        getNewsService().getLastestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsModel<Story>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(0,e.getMessage());
                    }

                    @Override
                    public void onNext(NewsModel<Story> storyNewsModel) {
                        callback.onSuccess(storyNewsModel);
                    }
                });
    }

    /**
     * 根据id查询文章详情
     * @param id
     * @param callBack
     */
    public static void findNewsById(long id,final ICallBack<Story> callBack){
        getNewsService().getNewsById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Story>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(0,e.getMessage());

                    }

                    @Override
                    public void onNext(Story story) {
                        callBack.onSuccess(story);
                    }
                });
    }

    public static NewsService service;
    public static NewsService getNewsService(){
        if(service == null){
            service=RetrofitUtils.build(ZHI_HU_NEWS_BASE_URL).build().create(NewsService.class);
        }
        return service;
    }
}
