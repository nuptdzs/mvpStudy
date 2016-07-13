package com.example.dzs.testapp.view.activity;

import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.example.dzs.testapp.R;
import com.example.dzs.testapp.commom.BaseActivity;
import com.example.dzs.testapp.model.bean.Story;
import com.example.dzs.testapp.presenter.DetailPresenter;
import com.example.dzs.testapp.view.IDetailView;

import butterknife.Bind;

public class NewsDetailActivity extends BaseActivity<DetailPresenter> implements IDetailView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.webView)
    WebView webView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected DetailPresenter getPresenter() {
        return new DetailPresenter(this);
    }

    @Override
    protected void addEvent() {

    }

    @Override
    protected void loadData() {
        presenter.loadStory();
    }

    @Override
    public void showStory(Story story) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(story.getTitle());
        webView.loadUrl(story.getShare_url());
    }
}
