package com.example.dzs.testapp.commom;

/**
 * Created by dzs on 2016/7/8.
 */
public interface IMvpPresenter<View> {

    void attachView(View view);
    void detachView();
    boolean isViewAttached();
    View getView();
}
