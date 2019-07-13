package com.example.base.presenter;

import com.example.base.model.bean.ForgetPwdBean;
import com.example.base.model.bean.LoginBean;
import com.example.base.model.bean.RegisterBean;
import com.example.base.model.bean.SendCodeBean;
import com.example.base.model.okhttp.OkHttp;
import com.example.base.view.interfaces.IMainView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<IMainView.IMainShow> {


    private final OkHttp okHttp;

    public MainPresenter() {
        okHttp = OkHttp.getInStance();
    }

    //注册
    public void RegisterP(String email, String code, String pwd1, String pwd2, String name, String inauguralHospital, String departmentName, String jobTitle, String personalProfile, String goodField) {
        okHttp.api.getRegister(email, code, pwd1, pwd2, name, inauguralHospital, departmentName, jobTitle, personalProfile, goodField)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterBean>() {
                    @Override
                    public void accept(RegisterBean registerBean) throws Exception {
                        getView().onSuccess(registerBean);
                    }
                });
    }

    //发送邮箱
    public void SendCodeP(String emailCode) {
        okHttp.api.getSendCode(emailCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SendCodeBean>() {
                    @Override
                    public void accept(SendCodeBean sendCodeBean) throws Exception {
                        getView().onSuccess(sendCodeBean);
                    }
                });
    }

    //登录
    public void LoginP(String emailLogin, String pwdLogin) {
        okHttp.api.getLogin(emailLogin, pwdLogin)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        getView().onSuccess(loginBean);
                    }
                });
    }

    //忘记密码
    public void ForGetPwdP(String email, String pwd1, String pwd2) {
        okHttp.api.getForgetPwd(email, pwd1, pwd2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ForgetPwdBean>() {
                    @Override
                    public void accept(ForgetPwdBean forgetPwdBean) throws Exception {
                        getView().onSuccess(forgetPwdBean);
                    }
                });
    }

}
