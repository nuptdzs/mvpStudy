package com.example.dzs.testapp.commom;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by dzs on 2016/7/11.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    protected P presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        presenter = getPresenter();
        addEvent();
        loadData();
    }

    /**弹窗提示*/
    private Toast toast;
    @Override
    public void showToast(String msg) {
        if(toast == null){
            toast = Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT);
        }else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**加载窗口*/
    private ProgressDialog progressDialog;
    @Override
    public void showLoading(String msg) {
        if(progressDialog == null){
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.hide();
    }

    @Override
    public Context getContext() {
        return getBaseContext();
    }

    @Override
    public Intent _getIntent() {
        return getIntent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        presenter.detachView();
    }

    /**获取当前activity的布局id*/
    protected abstract int getLayoutId();
    /**获取当前activity的presenter*/
    protected abstract P getPresenter();
    /**给当前activity添加控制事件*/
    protected abstract void addEvent();
    /**加载数据*/
    protected abstract void loadData();

}
