package com.example.mine.view.fragment.loginregister;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.base.model.bean.SendCodeBean;
import com.example.base.presenter.MainPresenter;
import com.example.base.view.fragment.IBaseFragment;
import com.example.base.view.interfaces.IMainView;
import com.example.mine.R;
import com.example.mine.R2;
import com.example.mine.model.encryption.RsaCoder;
import com.example.mine.model.eventbean.EventRegisterBean;
import com.example.mine.view.activity.LoginRegisterActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

public class RegisterFragment extends IBaseFragment implements IMainView.IMainShow {


    @BindView(R2.id.regEmail)
    EditText regEmail;
    @BindView(R2.id.regCodeBut)
    Button regCodeBut;
    @BindView(R2.id.regInputCode)
    EditText regInputCode;
    @BindView(R2.id.regPwd)
    EditText regPwd;
    @BindView(R2.id.regEye)
    SimpleDraweeView regEye;
    @BindView(R2.id.regPwdTwo)
    EditText regPwdTwo;
    @BindView(R2.id.regEyeTwo)
    SimpleDraweeView regEyeTwo;
    @BindView(R2.id.regBut)
    Button regBut;
    private MainPresenter mainPresenter;
    private String pwd2;

    @Override
    protected int setLayout() {
        return R.layout.register;
    }

    @Override
    protected void initView() {
        mainPresenter = new MainPresenter();

        mainPresenter.setView(this);


        regCodeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rEmail = regEmail.getText().toString();

                mainPresenter.SendCodeP(rEmail);
            }
        });

        regBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rEmail = regEmail.getText().toString();
                String rInputCode = regInputCode.getText().toString();

                String rPwd = regPwd.getText().toString();
                String rPwdTwo = regPwdTwo.getText().toString();
                String pwd1 = null;
                String pwd2 = null;

                try {
                    pwd1 = RsaCoder.encryptByPublicKey(rPwd);
                    pwd2 = RsaCoder.encryptByPublicKey(rPwdTwo);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                EventBus.getDefault().postSticky(new EventRegisterBean(rEmail,rInputCode,pwd1, pwd2));

                ((LoginRegisterActivity) getActivity()).zhuceTwoFF();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof SendCodeBean){
            SendCodeBean sendCodeBean = (SendCodeBean) o;

            Toast.makeText(getContext(),sendCodeBean.getMessage(),Toast.LENGTH_SHORT).show();

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
