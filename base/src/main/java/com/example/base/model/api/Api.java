package com.example.base.model.api;

import com.example.base.model.bean.CircleBean;
import com.example.base.model.bean.CircleTitleBean;
import com.example.base.model.bean.CustomPhotoBean;
import com.example.base.model.bean.DefaultPhotoBean;
import com.example.base.model.bean.HealthDetailsBean;
import com.example.base.model.bean.HistoryBean;
import com.example.base.model.bean.InterrogationBean;
import com.example.base.model.bean.LoginBean;
import com.example.base.model.bean.MineBean;
import com.example.base.model.bean.RegisterBean;
import com.example.base.model.bean.ForgetPwdBean;
import com.example.base.model.bean.SendCodeBean;
import com.example.base.model.bean.SetChooesBean;
import com.example.base.model.bean.SreachBean;
import com.example.base.model.bean.StatusBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface Api {

    /**
     * 于弟弟的接口
     * @param emailCode
     * @return
     */
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

    //查询系统形象照
    @GET("health/doctor/v1/findSystemImagePic")
    Observable<DefaultPhotoBean> getDefaultPhoto();

    //选择系统提供形象照
    @FormUrlEncoded
    @POST("health/doctor/verify/v1/chooseImagePic")
    Observable<SetChooesBean> getChooseDefault(@Field("imagePic") String imagePic);

    //上传形象照
    @POST("health/doctor/verify/v1/uploadImagePic")
    Observable<CustomPhotoBean> getCustomPhoto(@Body MultipartBody imagePic);

    //根据医生id查询医生信息
    @GET("health/doctor/verify/v1/findDoctorById")
    Observable<MineBean> getMine();

    //查询科室列表
    //http://172.17.8.100/health/share/knowledgeBase/v1/findDepartment
    @GET("health/share/knowledgeBase/v1/findDepartment")
    Observable<CircleTitleBean> circle_title();

    //病友圈列表
    //http://172.17.8.100/health/doctor/sickCircle/v1/findSickCircleList
    @GET("health/doctor/sickCircle/v1/findSickCircleList")
    Observable<CircleBean> circle(@Query("departmentId") int departmentId, @Query("page") int page,
                                  @Query("count") int count);

    //根据关键词查询病友圈
    //http://172.17.8.100/health/doctor/sickCircle/v1/searchSickCircle
    @GET("health/doctor/sickCircle/v1/searchSickCircle")
    Observable<SreachBean> sreach(@Query("keyWord") String keyWord);

    //查看并病友圈详情
    //http：//172.17.8.100/health/doctor/sickCircle/v1/findSickCircleInfo
    @GET("health/doctor/sickCircle/v1/findSickCircleInfo")
    Observable<HealthDetailsBean> details(@Query("sickCircleId") int sickCircleId);

    //发表评论
    //http：//172.17.8.100/health/doctor/sickCircle/verify/v1/publishComment
    @POST("health/doctor/sickCircle/verify/v1/publishComment")
    Observable<StatusBean>  comment(@Query("sickCircleId")int sickCircleId, @Query("content")String content);

    //查询医生的问诊记录列表
    //http：//172.17.8.100/health/doctor/inquiry/verify/v1/findInquiryRecordList
    @GET("health/doctor/inquiry/verify/v1/findInquiryRecordList")
    Observable<InterrogationBean> interrogation();


    //查询医生的历史问诊记录列表
    //http://172.17.8.100/health/doctor/inquiry/verify/v1/findHistoryInquiryRecord
    @GET("health/doctor/inquiry/verify/v1/findHistoryInquiryRecord")
    Observable<HistoryBean> history(@Query("page")int page, @Query("count")int count);

}
