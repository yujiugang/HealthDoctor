package com.example.base.presenter;

import com.example.base.model.bean.CircleBean;
import com.example.base.model.bean.CircleTitleBean;
import com.example.base.model.bean.CustomPhotoBean;
import com.example.base.model.bean.DefaultPhotoBean;
import com.example.base.model.bean.ForgetPwdBean;
import com.example.base.model.bean.HealthDetailsBean;
import com.example.base.model.bean.InterrogationBean;
import com.example.base.model.bean.LoginBean;
import com.example.base.model.bean.MineBean;
import com.example.base.model.bean.RegisterBean;
import com.example.base.model.bean.SendCodeBean;
import com.example.base.model.bean.SetChooesBean;
import com.example.base.model.bean.SreachBean;
import com.example.base.model.bean.StatusBean;
import com.example.base.model.okhttp.OkHttp;
import com.example.base.view.interfaces.IMainView;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

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

    //查询系统形象照
    public void DefaultPhotoP() {
        okHttp.api.getDefaultPhoto()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DefaultPhotoBean>() {
                    @Override
                    public void accept(DefaultPhotoBean defaultPhotoBean) throws Exception {
                        getView().onSuccess(defaultPhotoBean);
                    }
                });
    }

    //选择系统提供形象照
    public void setChooseImageP(String imagePic) {
        okHttp.api.getChooseDefault(imagePic)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SetChooesBean>() {
                    @Override
                    public void accept(SetChooesBean setChooesBean) throws Exception {
                        getView().onSuccess(setChooesBean);
                    }
                });
    }

    //根据医生id查询医生信息
    public void MineP() {
        okHttp.api.getMine()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MineBean>() {
                    @Override
                    public void accept(MineBean mineBean) throws Exception {
                        getView().onSuccess(mineBean);
                    }
                });
    }






    //查询科室列表
    public void LoadShowCricleTitleData() {
        okHttp.api.circle_title()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CircleTitleBean>() {
                    @Override
                    public void accept(CircleTitleBean bean) throws Exception {
                        getView().onSuccess(bean);
                    }
                });
    }

    //病友圈列表
    public void LoadShowCircleData(int departmentId, int page, int count) {
        okHttp.api.circle(departmentId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CircleBean>() {
                    @Override
                    public void accept(CircleBean bean) throws Exception {
                        getView().onSuccess(bean);
                    }
                });
    }


    //搜索病友圈列表
    public void LoadShowSreachData(String keyWord) {
        okHttp.api.sreach(keyWord)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SreachBean>() {
                    @Override
                    public void accept(SreachBean bean) throws Exception {
                        getView().onSuccess(bean);
                    }
                });
    }

    //病友圈详情列表
    public void LoadShowDetailsData(int sickCircleId) {
        okHttp.api.details(sickCircleId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HealthDetailsBean>() {
                    @Override
                    public void accept(HealthDetailsBean bean) throws Exception {
                        getView().onSuccess(bean);
                    }
                });
    }

    //上传形象照
    public void CustomPhotoP(String imagePic) {
        File file = new File(imagePic);
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("imagePic", file.getName(), RequestBody.create(MediaType.parse("multipart/octet-stream"), file));
        Observable<CustomPhotoBean> img1 = okHttp.api.getCustomPhoto(builder.build());

        img1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CustomPhotoBean>() {
                    @Override
                    public void accept(CustomPhotoBean customPhotoBean) throws Exception {
                        getView().onSuccess(customPhotoBean);
                    }
                });
    }

    //发表病友圈评论
    public void LoadShowCommentData(int sickCircleId, String content) {
        okHttp.api.comment(sickCircleId, content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<StatusBean>() {
                    @Override
                    public void accept(StatusBean bean) throws Exception {
                        getView().onSuccess(bean);
                    }
                });
    }

    //查询医生的问诊记录列表
    public void LoadShowInterrogationBeanData() {
        okHttp.api.interrogation()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<InterrogationBean>() {
                    @Override
                    public void accept(InterrogationBean bean) throws Exception {
                        getView().onSuccess(bean);
                    }
                });
    }




}
