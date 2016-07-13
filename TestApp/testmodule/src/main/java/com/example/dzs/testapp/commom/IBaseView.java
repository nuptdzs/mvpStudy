package com.example.dzs.testapp.commom;

import android.content.Context;
import android.content.Intent;

/**
 * Created by dzs on 2016/7/8.
 */
public interface IBaseView {
    void showToast(String msg);
    void showLoading(String msg);
    void hideLoading();
    Context getContext();
    Intent _getIntent();

}
