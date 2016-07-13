package com.example.dzs.testapp.commom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.ButterKnife;

/**
 * Created by dzs on 2016/7/8.
 */
public abstract class MvpView<Model> extends LinearLayout{

    protected View rootView;
    public MvpView(Context context) {
        super(context);
    }

    protected void setRootView(int rootViewResId){
        if(rootView == null){
            rootView = LayoutInflater.from(getContext()).inflate(rootViewResId,this);
            ButterKnife.bind(this);
        }
    }
    public abstract void initview();

    public abstract void setData(Model model);
    public abstract MvpView<Model> getInstance();
}
