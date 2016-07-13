package com.example.dzs.testapp.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dzs.testapp.R;
import com.example.dzs.testapp.commom.MvpView;
import com.example.dzs.testapp.model.bean.Story;
import com.squareup.picasso.Picasso;

import butterknife.Bind;

/**
 * Created by dzs on 2016/7/8.
 */
public class NewsItemVM extends MvpView<Story> {
    @Bind(R.id.tvTitle)
    TextView tvTitle;
    @Bind(R.id.img)
    ImageView img;

    public NewsItemVM(Context context) {
        super(context);
    }

    @Override
    public void initview() {
        setRootView(R.layout.item_news);
    }

    @Override
    public void setData(Story story) {
        tvTitle.setText(story.getTitle()+"");
        Picasso.with(getContext()).load(story.getImages().get(0)).into(img);
    }



    @Override
    public MvpView<Story> getInstance() {
        return new NewsItemVM(getContext());
    }
}
