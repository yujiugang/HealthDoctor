package com.example.question.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.model.bean.CircleBean;
import com.example.base.model.bean.CircleTitleBean;
import com.example.base.presenter.MainPresenter;
import com.example.base.view.activity.IBaseActivity;
import com.example.base.view.interfaces.IMainView;
import com.example.question.R;
import com.example.question.R2;
import com.example.question.adapter.CircleAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/question/QuestionActivity")
public class QusetionActivity extends IBaseActivity implements IMainView.IMainShow {
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.message)
    ImageView message;
    @BindView(R2.id.sreach)
    ImageView sreach;
    @BindView(R2.id.recycler_content)
    XRecyclerView recyclerContent;
    @BindView(R2.id.tab)
    TabLayout tab;
    private MainPresenter mainPresenter;
    private CircleAdapter circleAdapter;
    private int departmentId = 7;
    private int page = 1;
    private int count = 5;
    private int id;

    Handler mHandler = new Handler();

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qusetion);
    }*/

    @Override
    protected int setLayout() {
        return R.layout.activity_qusetion;
    }

    @Override
    protected void initView() {
        //获取P层
        mainPresenter = new MainPresenter();
        mainPresenter.setView(this);
        //加载病友圈头部列表数据
        mainPresenter.LoadShowCricleTitleData();
        //获取病友圈列表适配器
        circleAdapter = new CircleAdapter(this);
        //加载病友圈列表数据
        mainPresenter.LoadShowCircleData(departmentId, page, count);
        //设置病友圈列表样式
        recyclerContent.setLayoutManager(new LinearLayoutManager(QusetionActivity.this,
                LinearLayoutManager.VERTICAL, false));
        //设置适配器
        recyclerContent.setAdapter(circleAdapter);
        //设置可刷新加载
        recyclerContent.setPullRefreshEnabled(true);
        recyclerContent.setLoadingMoreEnabled(true);

        //刷新加载
        recyclerContent.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {//刷新

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page = 1;
                        //加载病友圈列表数据
                        mainPresenter.LoadShowCircleData(id, page, count);
                        recyclerContent.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {//加载

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        //加载病友圈列表数据
                        mainPresenter.LoadShowCircleData(id, page, count);
                        recyclerContent.loadMoreComplete();
                    }
                }, 1000);
            }
        });
    }

    @Override
    protected void initData() {

        //点击返回按钮
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //点击搜索按钮
        sreach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//跳转搜索页面
                startActivity(new Intent(QusetionActivity.this,SreachActivity.class));
            }
        });
    }

    @Override
    public void onSuccess(Object o) {
        //病友圈头部
        if (o instanceof CircleTitleBean) {
            final CircleTitleBean titleBean = (CircleTitleBean) o;
            //给tab添加数据
            for (int i = 0; i < titleBean.getResult().size(); i++) {
                tab.addTab(tab.newTab().setText(titleBean.getResult().get(i).getDepartmentName()));
            }
            //设置tab监听状态
            tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

                @Override
                public void onTabSelected(TabLayout.Tab tab) {//选中
                    //获取选中的下标
                    int position = tab.getPosition();
                    //获取当前科室的id
                    id = titleBean.getResult().get(position).getId();
                    //加载病友圈列表数据
                    mainPresenter.LoadShowCircleData(id, page, count);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }

        //病友圈列表
        if (o instanceof CircleBean) {
            CircleBean circleBean = (CircleBean) o;
            if (page == 1) {
                circleAdapter.setListRefresh(circleBean.getResult());
            } else {
                circleAdapter.setList(circleBean.getResult());
            }
        }
    }

    @Override
    public void onFail(String message) {
        Toast.makeText(QusetionActivity.this, message + "", Toast.LENGTH_SHORT).show();
    }

}
