package com.example.dzs.testapp.commom;

import java.lang.ref.WeakReference;

/**
 * Created by dzs on 2016/7/8.
 */
public class BasePresenter<V extends IBaseView> implements IMvpPresenter<V> {

    /**当前presenter所持有的视图对象*/
    private WeakReference<V> viewReference;

    /**创建presenter的时候加载view*/
    public BasePresenter(V view){
        attachView(view);
    }

    /**绑定view对象 供presenter使用*/
    @Override
    public void attachView(V v) {
        viewReference = new WeakReference<>(v);
    }

    /**解除view的引用 防止持有对象导致内存泄露*/
    @Override
    public void detachView() {
        if(viewReference!=null){
            viewReference.clear();
            viewReference = null;
        }
    }

    /**
     * 判断view是否可用
     */
    @Override
    public boolean isViewAttached() {
        return viewReference!=null&&viewReference.get()!=null;
    }

    @Override
    public V getView() {
        return viewReference.get();
    }
}
