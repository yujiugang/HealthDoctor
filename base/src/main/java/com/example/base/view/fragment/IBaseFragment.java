package com.example.base.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.base.presenter.MainPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class IBaseFragment extends Fragment {

    private Unbinder unbinder;
    private MainPresenter mainPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(), container, false);
        unbinder = ButterKnife.bind(this,view);

        mainPresenter = new MainPresenter();
        initView();
        initData();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mainPresenter.detachView();
    }

    protected abstract int setLayout();

    protected abstract void initView();

    protected abstract void initData();

}
