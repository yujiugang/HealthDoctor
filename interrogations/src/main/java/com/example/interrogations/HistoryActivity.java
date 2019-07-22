package com.example.interrogations;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.base.presenter.MainPresenter;
import com.example.base.view.activity.IBaseActivity;
import com.example.base.view.interfaces.IMainView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends IBaseActivity implements IMainView.IMainShow {
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.gitf)
    TextView gitf;
    @BindView(R2.id.recyclerView)
    XRecyclerView recyclerView;

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }*/

    @Override
    protected int setLayout() {
        return R.layout.activity_history;
    }

    @Override
    protected void initView() {

        MainPresenter mainPresenter=new MainPresenter();
        mainPresenter.setView(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFail(String message) {

    }

}
