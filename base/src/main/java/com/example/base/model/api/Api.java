package com.example.base.model.api;

import com.example.base.model.bean.LoginBean;
import com.example.base.model.bean.RegisterBean;
import com.example.base.model.bean.ForgetPwdBean;
import com.example.base.model.bean.SendCodeBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface Api {

    //发送邮箱
    @FormUrlEncoded
    @POST("health/doctor/v1/sendEmailCode")
    Observable<SendCodeBean> getSendCode(@Field("email") String emailCode);

    //申请入住
    @FormUrlEncoded
    @POST("health/doctor/v1/applyJoin")
    Observable<RegisterBean> getRegister(@Field("email") String email, @Field("code") String code, @Field("pwd1") String pwd1, @Field("pwd2") String pwd2, @Field("name") String name, @Field("inauguralHospital") String inauguralHospital, @Field("departmentName") String departmentName, @Field("jobTitle") String jobTitle, @Field("personalProfile") String personalProfile, @Field("goodField") String goodField);

    //登录
    @FormUrlEncoded
    @POST("health/doctor/v1/login")
    Observable<LoginBean> getLogin(@Field("email") String emailLogin, @Field("pwd") String pwdLogin);

    //修改密码
    @FormUrlEncoded
    @PUT("health/doctor/v1/resetUserPwd")
    Observable<ForgetPwdBean> getForgetPwd(@Field("email") String email, @Field("pwd1") String pwd1, @Field("pwd2") String pwd2);

}
