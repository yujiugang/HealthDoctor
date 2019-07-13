package com.example.mine.view.activity;

import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;

import com.example.base.view.activity.IBaseActivity;
import com.example.mine.R;
import com.example.mine.R2;
import com.example.mine.view.fragment.ForGetPwdFragment;
import com.example.mine.view.fragment.ForGetPwdTwoFragment;
import com.example.mine.view.fragment.LoginFragment;
import com.example.mine.view.fragment.RegisterFragment;
import com.example.mine.view.fragment.RegisterThreeFragment;
import com.example.mine.view.fragment.RegisterTwoFragment;

import butterknife.BindView;

public class LoginRegisterActivity extends IBaseActivity {


    @BindView(R2.id.loginRegisterFrame)
    FrameLayout loginRegisterFrame;
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;
    private FragmentManager manager;
    private RegisterTwoFragment registerTwoFragment;
    private RegisterThreeFragment registerThreeFragment;
    private ForGetPwdFragment forGetPwdFragment;
    private ForGetPwdTwoFragment forGetPwdTwoFragment;

    @Override
    protected int setLayout() {
        return R.layout.activity_login_register;
    }

    @Override
    protected void initView() {

        loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();
        registerTwoFragment = new RegisterTwoFragment();
        registerThreeFragment = new RegisterThreeFragment();
        forGetPwdFragment = new ForGetPwdFragment();
        forGetPwdTwoFragment = new ForGetPwdTwoFragment();

        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.loginRegisterFrame, loginFragment)
                .add(R.id.loginRegisterFrame, registerFragment)
                .add(R.id.loginRegisterFrame, registerTwoFragment)
                .add(R.id.loginRegisterFrame, registerThreeFragment)
                .add(R.id.loginRegisterFrame,forGetPwdFragment)
                .add(R.id.loginRegisterFrame,forGetPwdTwoFragment)
                .show(loginFragment)
                .hide(registerFragment)
                .hide(registerTwoFragment)
                .hide(registerThreeFragment)
                .hide(forGetPwdFragment)
                .hide(forGetPwdTwoFragment)
                .commit();

    }

    @Override
    protected void initData() {

    }

    public void loginFF() {
        manager.beginTransaction()
                .show(loginFragment)
                .hide(registerFragment)
                .commit();
    }

    public void zhuceFF() {
        manager.beginTransaction()
                .show(registerFragment)
                .hide(loginFragment)
                .commit();
    }

    public void zhuceTwoFF() {
        manager.beginTransaction()
                .show(registerTwoFragment)
                .hide(loginFragment)
                .hide(registerFragment)
                .commit();
    }

    public void zhuceThreeFF() {
        manager.beginTransaction()
                .show(registerThreeFragment)
                .hide(loginFragment)
                .hide(registerFragment)
                .hide(registerTwoFragment)
                .commit();
    }

    public void forgetFF() {
        manager.beginTransaction()
                .show(forGetPwdFragment)
                .hide(loginFragment)
                .hide(registerFragment)
                .hide(registerTwoFragment)
                .hide(registerThreeFragment)
                .commit();
    }

    public void forgetTwoFF() {
        manager.beginTransaction()
                .show(forGetPwdTwoFragment)
                .hide(loginFragment)
                .hide(registerFragment)
                .hide(registerTwoFragment)
                .hide(registerThreeFragment)
                .hide(forGetPwdFragment)
                .commit();
    }

}
