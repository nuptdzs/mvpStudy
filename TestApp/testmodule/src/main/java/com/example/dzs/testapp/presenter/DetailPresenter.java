package com.example.dzs.testapp.presenter;

import com.example.dzs.testapp.view.IDetailView;
import com.example.dzs.testapp.model.bean.Story;
import com.example.dzs.testapp.commom.BasePresenter;

/**
 * Created by dzs on 2016/7/12.
 */
public class DetailPresenter extends BasePresenter<IDetailView> implements IDetailLogics{
    /**
     * 创建presenter的时候加载view
     *
     * @param view
     */
    public DetailPresenter(IDetailView view) {
        super(view);
    }

    @Override
    public void loadStory(){
        Story story = (Story) getView()._getIntent().getSerializableExtra("data");
        if(isViewAttached()){
            getView().showStory(story);
        }
    }
}
