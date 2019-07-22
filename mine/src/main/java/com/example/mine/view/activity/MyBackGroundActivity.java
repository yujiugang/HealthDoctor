package com.example.mine.view.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.base.model.bean.CustomPhotoBean;
import com.example.base.model.bean.DefaultPhotoBean;
import com.example.base.model.bean.SetChooesBean;
import com.example.base.presenter.MainPresenter;
import com.example.base.view.activity.IBaseActivity;
import com.example.base.view.interfaces.IMainView;
import com.example.mine.R;
import com.example.mine.R2;
import com.example.mine.view.adapter.GuideViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MyBackGroundActivity extends IBaseActivity implements IMainView.IMainShow, ViewPager.OnPageChangeListener {

    @BindView(R2.id.viewpager)
    ViewPager viewpager;
    private int[] pics = {R.layout.guid_view1, R.layout.guid_view2, R.layout.guid_view3, R.layout.guid_view4, R.layout.guid_view5, R.layout.guid_view6, R.layout.guid_view7, R.layout.guid_view8};
    private MainPresenter mainPresenter;

    //View数据
    private List<View> views;
    private GuideViewPagerAdapter adapter;
    private ArrayList<String> list;
    private Button setFinishBut1;
    private Button setFinishBut2;
    private Button setFinishBut3;
    private Button setFinishBut4;
    private Button setFinishBut5;
    private Button setFinishBut6;
    private Button setFinishBut7;
    private ImageView customPhotoPop;
    private Button setFinishBut8;


    @Override
    protected int setLayout() {
        return R.layout.activity_my_back_ground;
    }

    @Override
    protected void initView() {

        if (views == null) {
            views = new ArrayList<>();
        }
        //初始化引导页视图列表,将4个布局View添加至list中
        for (int i = 0; i < pics.length; i++) {
            View view = LayoutInflater.from(this).inflate(pics[i], null);
            views.add(view);
        }
        //初始化adapter
        adapter = new GuideViewPagerAdapter(views);
        //将adapter设置到viewpager中
        viewpager.setAdapter(adapter);
        //ViewPager切换事件
        viewpager.addOnPageChangeListener(this);

        //查询系统默认形象照
        mainPresenter = new MainPresenter();

        mainPresenter.setView(this);
        //查询系统形象照
        mainPresenter.DefaultPhotoP();

        setFinishBut1 = views.get(0).findViewById(R.id.setFinishBut1);
        setFinishBut2 = views.get(1).findViewById(R.id.setFinishBut2);
        setFinishBut3 = views.get(2).findViewById(R.id.setFinishBut3);
        setFinishBut4 = views.get(3).findViewById(R.id.setFinishBut4);
        setFinishBut5 = views.get(4).findViewById(R.id.setFinishBut5);
        setFinishBut6 = views.get(5).findViewById(R.id.setFinishBut6);
        setFinishBut7 = views.get(6).findViewById(R.id.setFinishBut7);
        customPhotoPop = views.get(7).findViewById(R.id.customPhotoPop);
        setFinishBut8 = views.get(7).findViewById(R.id.setFinishBut8);

        //点击设置形象照
        setFinishBut1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (list != null && list.size() != 0) {

                    String s = list.get(0);

                    mainPresenter.setChooseImageP(s);
                }
            }
        });

        setFinishBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list != null && list.size() != 0) {

                    String s = list.get(1);
                    //选择系统形象照
                    mainPresenter.setChooseImageP(s);
                }
            }
        });

        setFinishBut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list != null && list.size() != 0) {

                    String s = list.get(2);
                    //选择系统形象照
                    mainPresenter.setChooseImageP(s);
                }
            }
        });

        setFinishBut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list != null && list.size() != 0) {

                    String s = list.get(3);
                    //选择系统形象照
                    mainPresenter.setChooseImageP(s);
                }
            }
        });

        setFinishBut5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list != null && list.size() != 0) {

                    String s = list.get(4);
                    //选择系统形象照
                    mainPresenter.setChooseImageP(s);
                }
            }
        });

        setFinishBut6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list != null && list.size() != 0) {

                    String s = list.get(5);
                    //选择系统形象照
                    mainPresenter.setChooseImageP(s);
                }
            }
        });

        setFinishBut7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list != null && list.size() != 0) {

                    String s = list.get(6);
                    //选择系统形象照
                    mainPresenter.setChooseImageP(s);
                }
            }
        });

        customPhotoPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(MyBackGroundActivity.this, R.layout.custon_photo_pop, null);
                PopupWindow popWindow = new PopupWindow(view, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

                //弹出     popwindow
                popWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popWindow.setContentView(view);
                popWindow.setOutsideTouchable(true);
                popWindow.setFocusable(true);
                popWindow.setTouchable(true);
                popWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);


                Button customPhoto = view.findViewById(R.id.customPhoto);
                Button customAlbum = view.findViewById(R.id.customAlbum);
                Button customCancel = view.findViewById(R.id.customCancel);

                customAlbum.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(intent, 0);
                    }
                });


            }
        });

    }

    @Override
    protected void initData() {

    }
    //相册成功回调
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (requestCode == 0) {
            String filePath = getFilePath(requestCode, data);


            mainPresenter.CustomPhotoP(filePath);

            Log.i("myTX", filePath);
        }
    }
    //获取图片的存储
    private String getFilePath(int requestCode, Intent data) {
        if (requestCode == 0) {
            Uri uri = data.getData();
            //存储
            String[] path = {MediaStore.Images.Media.DATA};
            //查询路径和存储
            Cursor cursor = managedQuery(uri, path, null, null, null);
            //cursor光标拿存储
            int orThrow = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            //放第一个
            cursor.moveToFirst();
            //获取string类型的存储的
            String img_path = cursor.getString(orThrow);
            return img_path;
        }
        return null;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof DefaultPhotoBean) {
            DefaultPhotoBean defaultBean = (DefaultPhotoBean) o;

            //查询形象照
            list = new ArrayList<>();
            for (int i = 0; i < defaultBean.getResult().size(); i++) {
                String imagePic = defaultBean.getResult().get(i).getImagePic();
                list.add(imagePic);
            }

        }
        //设置形象照
        if (o instanceof SetChooesBean) {
            SetChooesBean setChooesBean = (SetChooesBean) o;

            Log.i("setdefaultphoto111", "onSuccess: " + setChooesBean.getResult());
            Toast.makeText(MyBackGroundActivity.this, setChooesBean.getMessage(), Toast.LENGTH_LONG).show();
        }

        //设置形象照
        if (o instanceof CustomPhotoBean) {
            CustomPhotoBean customPhotoBean = (CustomPhotoBean) o;

            Log.i("setdefaultphoto222", "onSuccess: " + customPhotoBean.getResult());
            Toast.makeText(MyBackGroundActivity.this, customPhotoBean.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFail(String message) {

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

}
