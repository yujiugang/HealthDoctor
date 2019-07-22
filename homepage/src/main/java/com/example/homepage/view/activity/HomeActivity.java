package com.example.homepage.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.view.activity.IBaseActivity;
import com.example.homepage.R;
import com.example.homepage.R2;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/homepage/QuestionActivity")
public class HomeActivity extends IBaseActivity {
    @BindView(R2.id.interrogation)
    ImageView interrogation;
    @BindView(R2.id.question)
    ImageView question;
    @BindView(R2.id.mine)
    ImageView mine;
    @BindView(R2.id.headPic)
    SimpleDraweeView headPic;
    @BindView(R2.id.name)
    TextView name;
    @BindView(R2.id.address)
    TextView address;
    @BindView(R2.id.position)
    TextView position;
    @BindView(R2.id.subject)
    TextView subject;
    private SharedPreferences saves;

/*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
*/

    @Override
    protected int setLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {

        saves = getSharedPreferences("saves", Context.MODE_PRIVATE);

        //赋值
        headPic.setImageURI(Uri.parse(saves.getString("img", "")));
        name.setText(saves.getString("name", ""));
        address.setText(saves.getString("hospital", ""));
        position.setText(saves.getString("job", ""));
        subject.setText(saves.getString("partName", ""));

    }

    @Override
    protected void initData() {

        //答疑的点击事件
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转答疑页面
                ARouter.getInstance().build("/question/QuestionActivity").navigation();
            }
        });

        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转我的页面
                ARouter.getInstance().build("/mine/QuestionActivity").navigation();
            }
        });
//点击跳转到问诊列表
        interrogation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转问诊页面
                ARouter.getInstance().build("/interrogation/QuestionActivity").navigation();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume(); //赋值
        headPic.setImageURI(Uri.parse(saves.getString("img", "")));
    }
}
