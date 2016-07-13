package com.example.dzs.testapp.model.service;

import com.example.dzs.testapp.model.bean.NewsModel;
import com.example.dzs.testapp.model.bean.Story;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by dzs on 2016/7/11.
 */
public interface NewsService {
    @GET("/api/4/news/latest")
    Observable<NewsModel<Story>> getLastestNews();

    @GET("/api/4/news/{id}")
    Observable<Story> getNewsById(@Path("id")long id);

}
