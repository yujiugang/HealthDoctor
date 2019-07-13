package com.example.homepage.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.base.view.activity.IBaseActivity;
import com.example.homepage.R;
import com.example.homepage.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends IBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

}
