package com.example.dzs.testapp.view;

import com.example.dzs.testapp.commom.IBaseView;
import com.example.dzs.testapp.model.bean.NewsModel;
import com.example.dzs.testapp.model.bean.Story;


/**
 * Created by dzs on 2016/7/8.
 * 主视图 展示层接口
 */
public interface IMainView extends IBaseView{
    void showNews(NewsModel<Story> storyNewsModel);
    void showData(String data);
    void gotoDetail(Story story);
}
