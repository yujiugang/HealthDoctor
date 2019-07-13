package com.example.mine.view.fragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.base.model.bean.RegisterBean;
import com.example.base.presenter.MainPresenter;
import com.example.base.view.fragment.IBaseFragment;
import com.example.base.view.interfaces.IMainView;
import com.example.mine.R;
import com.example.mine.R2;
import com.example.mine.model.eventbean.EventRegisterBean;
import com.example.mine.model.eventbean.EventRegisterTwoBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

public class RegisterThreeFragment extends IBaseFragment implements IMainView.IMainShow {

    @BindView(R2.id.regReturn)
    ImageView regReturn;
    @BindView(R2.id.regResume)
    EditText regResume;
    @BindView(R2.id.text_intro_resume_num)
    TextView textIntroResumeNum;
    @BindView(R2.id.regField)
    EditText regField;
    @BindView(R2.id.text_intro_territory_num)
    TextView textIntroTerritoryNum;
    @BindView(R2.id.regThreeBut)
    Button regThreeBut;
    private MainPresenter mainPresenter;
    private String email;
    private String inputCode;
    private String pwd1;
    private String pwd2;
    private String name;
    private String hospital;
    private String department;
    private String title;

    @Override
    protected int setLayout() {
        return R.layout.register_three;

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Value(EventRegisterBean message) {
        email = message.getEmail();
        inputCode = message.getInputCode();
        pwd1 = message.getPwd1();
        pwd2 = message.getPwd2();

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Value(EventRegisterTwoBean messageTwo) {
        name = messageTwo.getName();
        hospital = messageTwo.getHospital();
        department = messageTwo.getDepartment();
        title = messageTwo.getTitle();

    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);

        mainPresenter = new MainPresenter();

        mainPresenter.setView(this);

        regThreeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rResume = regResume.getText().toString();
                String rField = regField.getText().toString();

                mainPresenter.RegisterP(email, inputCode, pwd1 + "", pwd2 + "", name, hospital, department, title, rResume, rField);

                Log.i("one111", "email: " + email);
                Log.i("one111", "inputCode: " + inputCode);
                Log.i("one111", "pwd1: " + pwd1);
                Log.i("one111", "pwd2: " + pwd2);
                Log.i("one111", "name: " + name);
                Log.i("one111", "hospital: " + hospital);
                Log.i("one111", "department: " + department);
                Log.i("one111", "title: " + title);

                Log.i("one111", "rResume: " + rResume);
                Log.i("one111", "rField: " + rField);
            }
        });

    }

    @Override
    protected void initData() {

    }


    @Override
    public void onSuccess(Object o) {
        if (o instanceof RegisterBean) {
            RegisterBean registerBean = (RegisterBean) o;

            Log.i("giao111", "onSuccess: " + registerBean.getMessage());
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
