package com.example.dzs.testapp.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dzs.testapp.R;
import com.example.dzs.testapp.commom.BaseActivity;
import com.example.dzs.testapp.commom.CommonAdapter;
import com.example.dzs.testapp.model.bean.NewsModel;
import com.example.dzs.testapp.model.bean.Story;
import com.example.dzs.testapp.presenter.MainPresenter;
import com.example.dzs.testapp.view.IMainView;
import com.example.dzs.testapp.view.NewsItemVM;

import butterknife.Bind;

/**
 * 主视图
 */
public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.lvTest)
    ListView lvTest;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }


    @Override
    protected void addEvent() {
        lvTest.setDividerHeight(0);
        lvTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.findNewsByid(position);
            }
        });
        presenter.attachView(this);
    }

    @Override
    protected void loadData() {
        presenter.loadNews();
    }


    @Override
    public void showNews(NewsModel<Story> storyNewsModel) {
        lvTest.setAdapter(new CommonAdapter<>(storyNewsModel.stories,new NewsItemVM(getContext())));
    }

    @Override
    public void showData(String data) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(data);
    }

    @Override
    public void gotoDetail(Story story) {
        Log.d("story",story.toString());
        Intent intent = new Intent(this,NewsDetailActivity.class);
        intent.putExtra("data",story);
        startActivity(intent);
    }
}
