package com.example.mine.view.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.model.bean.MineBean;
import com.example.base.presenter.MainPresenter;
import com.example.base.view.activity.IBaseActivity;
import com.example.base.view.interfaces.IMainView;
import com.example.mine.R;
import com.example.mine.R2;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
@Route(path = "/mine/QuestionActivity")
public class MineActivity extends IBaseActivity implements IMainView.IMainShow {

    @BindView(R2.id.my_background)
    SimpleDraweeView myBackground;
    @BindView(R2.id.myReturn)
    ImageView myReturn;
    @BindView(R2.id.myMessage)
    ImageView myMessage;
    @BindView(R2.id.mySeeData)
    TextView mySeeData;
    @BindView(R2.id.myRightLcon)
    ImageView myRightLcon;
    @BindView(R2.id.myHistoricalInquiry)
    ImageView myHistoricalInquiry;
    @BindView(R2.id.myWallet)
    ImageView myWallet;
    @BindView(R2.id.myAdoptIdea)
    ImageView myAdoptIdea;
    @BindView(R2.id.myAutomaticResponse)
    ImageView myAutomaticResponse;
    private MainPresenter mainPresenter;

    @Override
    protected int setLayout() {
        return R.layout.activity_mine;
    }

    @Override
    protected void initView() {

        /*mainPresenter = new MainPresenter();

        mainPresenter.setView(this);

        mainPresenter.MineP();*/
        myBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(MineActivity.this, R.layout.pop_my_background, null);
                PopupWindow popWindow = new PopupWindow(view, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

                //弹出     popwindow
                popWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popWindow.setContentView(view);
                popWindow.setOutsideTouchable(true);
                popWindow.setFocusable(true);
                popWindow.setTouchable(true);
                popWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);

                Button mypopReplaceImage = view.findViewById(R.id.mypopReplaceImage);
                Button mypopCancel = view.findViewById(R.id.mypopCancel);

                mypopReplaceImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MineActivity.this, MyBackGroundActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        myWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MineActivity.this, MyWalletActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof MineBean){
            MineBean mineBean = new MineBean();
            Log.i("name111", "onSuccess: "+mineBean.getResult().getDepartmentName());

            String imagePic = mineBean.getResult().getImagePic();
            myBackground.setImageURI(imagePic);

        }
    }

    @Override
    public void onFail(String message) {

    }
}
