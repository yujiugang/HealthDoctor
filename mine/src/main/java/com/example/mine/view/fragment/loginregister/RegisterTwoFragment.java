package com.example.mine.view.fragment.loginregister;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.base.view.fragment.IBaseFragment;
import com.example.mine.R;
import com.example.mine.R2;
import com.example.mine.model.eventbean.EventRegisterTwoBean;
import com.example.mine.view.activity.LoginRegisterActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

public class RegisterTwoFragment extends IBaseFragment {


    @BindView(R2.id.regName)
    EditText regName;
    @BindView(R2.id.regHospital)
    EditText regHospital;
    @BindView(R2.id.regDepartment)
    EditText regDepartment;
    @BindView(R2.id.popDepartment)
    ImageView popDepartment;
    @BindView(R2.id.regTitle)
    EditText regTitle;
    @BindView(R2.id.popTitle)
    ImageView popTitle;
    @BindView(R2.id.regTwoBut)
    Button regTwoBut;

    @Override
    protected int setLayout() {
        return R.layout.register_two;
    }

    @Override
    protected void initView() {

        regTwoBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rName = regName.getText().toString();
                String rHospital = regHospital.getText().toString();
                String rDepartment = regDepartment.getText().toString();
                String rTitle = regTitle.getText().toString();

                EventBus.getDefault().postSticky(new EventRegisterTwoBean(rName,rHospital,rDepartment,rTitle));

                ((LoginRegisterActivity) getActivity()).zhuceThreeFF();
            }
        });
    }

    @Override
    protected void initData() {

    }
}
