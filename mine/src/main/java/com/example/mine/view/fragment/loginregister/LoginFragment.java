package com.example.mine.view.fragment.loginregister;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.model.bean.LoginBean;
import com.example.base.presenter.MainPresenter;
import com.example.base.view.fragment.IBaseFragment;
import com.example.base.view.interfaces.IMainView;
import com.example.mine.R;
import com.example.mine.R2;
import com.example.mine.model.encryption.RsaCoder;
import com.example.mine.view.activity.LoginRegisterActivity;
import com.example.mine.view.activity.MineActivity;
import com.example.mine.view.activity.MyBackGroundActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;

public class LoginFragment extends IBaseFragment implements IMainView.IMainShow {

    @BindView(R2.id.loginEmail)
    EditText loginEmail;
    @BindView(R2.id.loginPwd)
    EditText loginPwd;
    @BindView(R2.id.loginEye)
    SimpleDraweeView loginEye;
    @BindView(R2.id.forgetPwd)
    TextView forgetPwd;
    @BindView(R2.id.registerText)
    TextView registerText;
    @BindView(R2.id.loginBut)
    Button loginBut;
    private MainPresenter mainPresenter;
    private SharedPreferences saves;
    private String lEmail;
    private String lPwd;

    @Override
    protected int setLayout() {
        return R.layout.login;
    }

    @Override
    protected void initView() {

        saves = getActivity().getSharedPreferences("saves", Context.MODE_PRIVATE);

        if (saves.getBoolean("one", false)) {
            loginEmail.setText(saves.getString("phone", ""));
            loginPwd.setText(saves.getString("pwd", ""));
            //跳转首页
            // ARouter.getInstance().build("/homepage/QuestionActivity").navigation();
            //  getActivity().finish();
        }
        mainPresenter = new MainPresenter();

        mainPresenter.setView(this);

        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lEmail = loginEmail.getText().toString();

                lPwd = loginPwd.getText().toString();
                //不知
                String pwd = null;
                try {
                    pwd = RsaCoder.encryptByPublicKey(lPwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mainPresenter.LoginP(lEmail, pwd + "");
            }
        });

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginRegisterActivity) getActivity()).zhuceFF();
            }
        });

        forgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginRegisterActivity) getActivity()).forgetFF();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof LoginBean) {
            LoginBean loginBean = (LoginBean) o;
            LoginBean.ResultBean result = loginBean.getResult();
            if (loginBean.getStatus().equals("0000")) {
                SharedPreferences.Editor edit = saves.edit();

                edit.putString("id", loginBean.getResult().getId() + "");
                edit.putString("sessionId", loginBean.getResult().getSessionId());
                edit.putString("phone", lEmail);
                edit.putString("pwd", lPwd);
                edit.putString("img", result.getImagePic());
                edit.putString("name", result.getName());
                edit.putString("hospital", result.getInauguralHospital());
                edit.putString("job", result.getJobTitle());
                edit.putString("partName", result.getDepartmentName());
                edit.putBoolean("one", true);
                edit.commit();
                Log.d("LoginFragment", result.getId()+"@@@"+result.getSessionId());
                int whetherHaveImagePic = loginBean.getResult().getWhetherHaveImagePic();
                if (whetherHaveImagePic == 1) {
                    Toast.makeText(getContext(), loginBean.getMessage(), Toast.LENGTH_SHORT).show();
                    //跳转答疑页面
                    ARouter.getInstance().build("/homepage/QuestionActivity").navigation();
                    getActivity().finish();
                } else {
                    Toast.makeText(getContext(), "请您设置自己的形象主页", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), MyBackGroundActivity.class);
                    startActivity(intent);
                }
                //  Log.i("login111", "onSuccess: " + loginBean.getMessage());
            } else {
                Toast.makeText(getContext(), loginBean.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onFail(String message) {

    }
}
