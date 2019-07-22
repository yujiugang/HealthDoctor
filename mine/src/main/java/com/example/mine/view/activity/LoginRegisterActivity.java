package com.example.mine.view.activity;

import android.support.v4.app.FragmentManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.view.activity.IBaseActivity;
import com.example.mine.R;
import com.example.mine.view.fragment.loginregister.ForGetPwdFragment;
import com.example.mine.view.fragment.loginregister.ForGetPwdTwoFragment;
import com.example.mine.view.fragment.loginregister.LoginFragment;
import com.example.mine.view.fragment.loginregister.RegisterFragment;
import com.example.mine.view.fragment.loginregister.RegisterThreeFragment;
import com.example.mine.view.fragment.loginregister.RegisterTwoFragment;

@Route(path = "/one/two/three")
public class LoginRegisterActivity extends IBaseActivity {

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
                .add(R.id.loginRegisterFrame, forGetPwdFragment)
                .add(R.id.loginRegisterFrame, forGetPwdTwoFragment)
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
