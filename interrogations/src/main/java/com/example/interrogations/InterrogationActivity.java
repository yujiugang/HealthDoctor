package com.example.interrogations;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.presenter.MainPresenter;
import com.example.base.view.activity.IBaseActivity;
import com.example.base.view.interfaces.IMainView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/interrogation/QuestionActivity")
public class InterrogationActivity extends IBaseActivity implements IMainView.IMainShow {
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.edit_sreach)
    TextView editSreach;
    @BindView(R2.id.sreach)
    ImageView sreach;
    @BindView(R2.id.no_people)
    LinearLayout noPeople;
    @BindView(R2.id.recyclerView)
    XRecyclerView recyclerView;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interrogation);
    }*/

    @Override
    protected int setLayout() {
        return R.layout.activity_interrogation;
    }

    @Override
    protected void initView() {
        //获取P层对象
        MainPresenter mainPresenter=new MainPresenter();
        mainPresenter.setView(this);

        noPeople.setVisibility(View.VISIBLE);

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
