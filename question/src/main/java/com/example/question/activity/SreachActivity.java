package com.example.question.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.base.presenter.MainPresenter;
import com.example.base.view.activity.IBaseActivity;
import com.example.base.view.interfaces.IMainView;
import com.example.question.R;
import com.example.question.R2;
import com.example.question.adapter.HistoryAdapter;

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
    private MainPresenter mainPresente;
    private String edit;
    private ArrayList<String> list;
    private HistoryAdapter historyAdapter;

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
        historyAdapter = new HistoryAdapter(this);
        //设置历史列表适配器样式
        recyclerHistory.setLayoutManager(new LinearLayoutManager(SreachActivity.this,
                LinearLayoutManager.VERTICAL,false));
        //设置历史列表数据
        historyAdapter.setListRefresh(list);
        //设置历史列表适配器
        recyclerHistory.setAdapter(historyAdapter);
    }

    @Override
    protected void initData() {
        //点击搜索按钮
        sreach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit = editSreach.getText().toString().trim();
                noSreach.setVisibility(View.VISIBLE);
                //设置没有找到商品的图片下方的文字
                noSreachText.setText(getResources().getString(R.string.go_no_sreach)
                        +edit+getResources().getString(R.string.apirs_no_sreach));

                //请求搜索接口
               // mainPresente.LoadShowSreachData(edit);
                //搜索历史列表数据
                list.add(edit);
                //隐藏搜索栏
                sreachHistoryLinear.setVisibility(View.GONE);
                editSreach.setText("");
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

    }

    @Override
    public void onFail(String message) {

    }
}
