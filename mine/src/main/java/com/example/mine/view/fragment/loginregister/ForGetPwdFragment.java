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
import com.example.mine.model.eventbean.EventSendCode;
import com.example.mine.view.activity.LoginRegisterActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

public class ForGetPwdFragment extends IBaseFragment implements IMainView.IMainShow {

    @BindView(R2.id.forgetEmail)
    EditText forgetEmail;
    @BindView(R2.id.forgetEmailBut)
    Button forgetEmailBut;
    @BindView(R2.id.forgetCode)
    EditText forgetCode;
    @BindView(R2.id.forgetNextBut)
    Button forgetNextBut;
    private MainPresenter mainPresenter;
    private String rEmail;


    @Override
    protected int setLayout() {
        return R.layout.forget_pwd;
    }

    @Override
    protected void initView() {

        mainPresenter = new MainPresenter();

        mainPresenter.setView(this);

        forgetEmailBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rEmail = forgetEmail.getText().toString();

                mainPresenter.SendCodeP(rEmail);
            }
        });


        forgetNextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new EventSendCode(rEmail));

                ((LoginRegisterActivity) getActivity()).forgetTwoFF();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof SendCodeBean) {
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


    }
}
