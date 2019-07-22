package com.example.base.view.activity;

import android.Manifest;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.base.R;
import com.example.base.model.okhttp.OkHttp;
import com.example.base.presenter.MainPresenter;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public abstract class IBaseActivity extends AppCompatActivity {

    private static final int RC_CAMERA_AND_LOCATION = 123;
    private MainPresenter mainPresenter;
    private boolean net;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        bind = ButterKnife.bind(this);

        ImmersionBar immersionBar = ImmersionBar.with(this);
        immersionBar.statusBarDarkFont(true, 0.2f)
                .init();
        mainPresenter = new MainPresenter();
        //动态权限
        cameraTask();
        net = OkHttp.getInStance().isNet(this);

        if (net){

            initView();
            initData();
        }else {
            Toast.makeText(this,"兄嘚,没网啊!!!",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        //解绑P层
        mainPresenter.detachView();
    }

    protected abstract int setLayout();

    protected abstract void initView();

    protected abstract void initData();

    //动态权限
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    //动态权限
    @AfterPermissionGranted(RC_CAMERA_AND_LOCATION)
    private void cameraTask() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            // Already have permission, do the thing
            // ...
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, getString(R.string.app_name),
                    RC_CAMERA_AND_LOCATION, perms);
        }
    }

    public void keyWordHide(){
        //隐藏软键盘
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(new View(this).getWindowToken(), 0);
        }
        InputMethodManager imm1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm1 != null) {
            View v1 = new View(this);
            ViewGroup g1 = (ViewGroup)getWindow().getDecorView();
            ViewGroup g2 = (ViewGroup)g1.getChildAt(0);
            g2.addView(v1);
            imm.hideSoftInputFromWindow(v1.getWindowToken(), 0);
        }
    }

}
