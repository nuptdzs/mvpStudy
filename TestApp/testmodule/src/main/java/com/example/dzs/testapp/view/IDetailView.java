package com.example.dzs.testapp.view;

import com.example.dzs.testapp.commom.IBaseView;
import com.example.dzs.testapp.model.bean.Story;

/**
 * Created by dzs on 2016/7/12.
 */
public interface IDetailView extends IBaseView {
    void showStory(Story story);
}
