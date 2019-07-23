package com.example.question.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.base.model.bean.SreachBean;
import com.example.base.presenter.MainPresenter;
import com.example.base.view.activity.IBaseActivity;
import com.example.base.view.interfaces.IMainView;
import com.example.question.R;
import com.example.question.R2;
import com.example.question.adapter.HistoryAdapter;
import com.example.question.adapter.SreachAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SreachActivity extends IBaseActivity implements IMainView.IMainShow {

    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.edit_sreach)
    EditText editSreach;
    @BindView(R2.id.sreach)
    TextView sreach;
    @BindView(R2.id.no_sreach_text)
    TextView noSreachText;
    @BindView(R2.id.no_sreach)
    LinearLayout noSreach;
    @BindView(R2.id.recycler_history)
    RecyclerView recyclerHistory;
    @BindView(R2.id.sreach_History_Linear)
    LinearLayout sreachHistoryLinear;
    @BindView(R2.id.recycler_sreach)
    RecyclerView recyclerSreach;
    private MainPresenter mainPresente;
    private String edit;
    private ArrayList<String> list;
    private HistoryAdapter historyAdapter;
    private SreachAdapter sreachAdapter;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sreach);
    }*/

    @Override
    protected int setLayout() {
        return R.layout.activity_sreach;
    }

    @Override
    protected void initView() {

        //获取P层对象
        mainPresente = new MainPresenter();
        mainPresente.setView(this);

        //搜索历史列表
        list = new ArrayList<>();
        /*   historyAdapter = new HistoryAdapter(this);
        设置历史列表适配器样式
        recyclerHistory.setLayoutManager(new LinearLayoutManager(SreachActivity.this,
                LinearLayoutManager.VERTICAL,false));
        //设置历史列表数据
        historyAdapter.setListRefresh(list);
        //设置历史列表适配器112
        recyclerHistory.setAdapter(historyAdapter);*/

        //搜索适配器
        sreachAdapter = new SreachAdapter(SreachActivity.this);
        //设置布局样式
        recyclerSreach.setLayoutManager(new LinearLayoutManager(SreachActivity.this,
                LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void initData() {
        //点击搜索按钮
        sreach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit = editSreach.getText().toString().trim();
                if (edit.equals("")) {
                    Toast.makeText(SreachActivity.this, "请输入搜索的内容",
                            Toast.LENGTH_SHORT).show();

                    noSreach.setVisibility(View.GONE);//无数据界面
                    recyclerSreach.setVisibility(View.GONE);//适配器
                    sreachHistoryLinear.setVisibility(View.VISIBLE);//搜索历史
                } else {

                    //请求搜索接口
                    mainPresente.LoadShowSreachData(edit);
                    //搜索历史列表数据
                    list.add(edit);
                }
                //隐藏软键盘
                keyWordHide();

            }
        });

        //点击返回
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof SreachBean) {
            SreachBean sreachBean = (SreachBean) o;
            Toast.makeText(this, sreachBean.getResult().size() + "",
                    Toast.LENGTH_SHORT).show();
            if (sreachBean.getResult().size() != 0) {
                noSreach.setVisibility(View.GONE);//无数据界面
                recyclerSreach.setVisibility(View.VISIBLE);//适配器
                sreachHistoryLinear.setVisibility(View.GONE);//搜索历史
                //给适配器赋值
                sreachAdapter.setList(sreachBean.getResult());
                //设置适配器
                recyclerSreach.setAdapter(sreachAdapter);
            } else {
                noSreach.setVisibility(View.VISIBLE);//无数据界面
                recyclerSreach.setVisibility(View.GONE);//适配器
                sreachHistoryLinear.setVisibility(View.GONE);//搜索历史
                //设置没有找到商品的图片下方的文字
                noSreachText.setText(getResources().getString(R.string.go_no_sreach)
                        + edit + getResources().getString(R.string.apirs_no_sreach));
            }
        }
    }

    @Override
    public void onFail(String message) {

    }
}
