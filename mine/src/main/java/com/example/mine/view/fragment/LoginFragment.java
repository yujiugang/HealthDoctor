package com.example.mine.view.fragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.base.model.bean.LoginBean;
import com.example.base.presenter.MainPresenter;
import com.example.base.view.fragment.IBaseFragment;
import com.example.base.view.interfaces.IMainView;
import com.example.mine.R;
import com.example.mine.R2;
import com.example.mine.model.encryption.RsaCoder;
import com.example.mine.view.activity.LoginRegisterActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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

    @Override
    protected int setLayout() {
        return R.layout.login;
    }

    @Override
    protected void initView() {


        mainPresenter = new MainPresenter();

        mainPresenter.setView(this);

        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lEmail = loginEmail.getText().toString();

                String lPwd = loginPwd.getText().toString();
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

            Log.i("login111", "onSuccess: " + loginBean.getMessage());
            Toast.makeText(getContext(), loginBean.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onFail(String message) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mainPresenter.detachView();
    }
}
