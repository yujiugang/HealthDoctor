package com.example.mine.view.fragment.loginregister;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.base.model.bean.ForgetPwdBean;
import com.example.base.presenter.MainPresenter;
import com.example.base.view.fragment.IBaseFragment;
import com.example.base.view.interfaces.IMainView;
import com.example.mine.R;
import com.example.mine.R2;
import com.example.mine.model.encryption.RsaCoder;
import com.example.mine.model.eventbean.EventSendCode;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

public class ForGetPwdTwoFragment extends IBaseFragment implements IMainView.IMainShow {

    @BindView(R2.id.forgetPwd1)
    EditText forgetPwd1;
    @BindView(R2.id.forgetEye)
    SimpleDraweeView forgetEye;
    @BindView(R2.id.forgetPwd2)
    EditText forgetPwd2;
    @BindView(R2.id.forgetEyeTwo)
    SimpleDraweeView forgetEyeTwo;
    @BindView(R2.id.forgetFinishBut)
    Button forgetFinishBut;
    private String emailForget;
    private MainPresenter mainPresenter;
    private String p1;
    private String p2;

    @Override
    protected int setLayout() {
        return R.layout.forget_pwd_two;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Value(EventSendCode message) {
        emailForget = message.getEmailForget();
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);

        mainPresenter = new MainPresenter();

        mainPresenter.setView(this);

        forgetFinishBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd1 = forgetPwd1.getText().toString();
                String pwd2 = forgetPwd2.getText().toString();

                try {
                    p1 = RsaCoder.encryptByPublicKey(pwd1);
                    p2 = RsaCoder.encryptByPublicKey(pwd2);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                mainPresenter.ForGetPwdP(emailForget, p1 + "", p2 + "");
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ForgetPwdBean) {
            ForgetPwdBean forgetPwdBean = (ForgetPwdBean) o;

            Log.i("setPwd111", "onSuccess: "+forgetPwdBean.getMessage());
            Toast.makeText(getContext(), forgetPwdBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFail(String message) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

        mainPresenter.detachView();
    }

}
