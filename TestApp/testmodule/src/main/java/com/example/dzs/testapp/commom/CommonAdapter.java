package com.example.dzs.testapp.commom;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by dzs on 2016/7/8.
 * @author dingzs@landicorp.com
 * @version 1.0
 * this adapter can be used by single item ListView or GridView
 */
public class CommonAdapter<MODEL> extends BaseAdapter {

    /**
     * Item 布局视图 view-model 连接体
     */
    private MvpView<MODEL> instance;
    /**
     * list布局所需要承载的数据源
     */
    private List<MODEL> modelList;

    /**
     * 构造方法 加载数据源和模型视图源
     * @param models 数据源
     * @param t 模型视图源
     */
    public CommonAdapter(List<MODEL> models,MvpView<MODEL> t){
        instance = t;
        modelList = models;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MvpView<MODEL> t;
        if(view == null){
            t = instance.getInstance();//从源视图衍生出模型视图作为每个item的布局体
            t.initview();//此处加载控件内容 findviewbyId
        }else{
            t = (MvpView<MODEL>) view;//直接获取view 即缓存好的 mvpview
        }
        t.setData(modelList.get(i));//此处加载数据到视图中并进行展示，具体的绑定操作交由继承了mvpview的itemVM操作
        return t;
    }
}
