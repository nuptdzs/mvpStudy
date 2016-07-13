package com.example.dzs.testapp.presenter;

import com.example.dzs.testapp.commom.ICallBack;
import com.example.dzs.testapp.view.IMainView;
import com.example.dzs.testapp.model.bean.NewsModel;
import com.example.dzs.testapp.model.service.NewsProvider;
import com.example.dzs.testapp.model.bean.Story;
import com.example.dzs.testapp.commom.BasePresenter;

import java.util.List;


/**
 * Created by dzs on 2016/7/11.
 * 主视图逻辑交互层
 */
public class MainPresenter extends BasePresenter<IMainView> implements IMainLogics {

    public MainPresenter(IMainView view) {
        super(view);
    }
    private List<Story> storyList;
    @Override
    public void loadNews() {
        if(!isViewAttached()){
            return;
        }
        getView().showLoading("正在加载。。。");
        NewsProvider.getNewsList(new ICallBack<NewsModel<Story>>() {

            @Override
            public void onSuccess(NewsModel<Story> storyNewsModel) {
                if(isViewAttached()){
                    storyList = storyNewsModel.stories;
                    getView().showNews(storyNewsModel);
                    getView().showData("知乎日报 "+storyNewsModel.date);
                    getView().hideLoading();
                }
            }

            @Override
            public void onFailure(int code, String err_msg) {
                if(isViewAttached()){
                    getView().hideLoading();
                    getView().showToast(code+err_msg);
                }

            }
        });
    }

    @Override
    public void findNewsByid(int id) {
        if(!isViewAttached()){
            return;
        }
        NewsProvider.findNewsById(storyList.get(id).getId(), new ICallBack<Story>() {
            @Override
            public void onSuccess(Story story) {
               getView().gotoDetail(story);
            }

            @Override
            public void onFailure(int code, String err_msg) {
                getView().showToast(err_msg);
            }
        });
    }


}
