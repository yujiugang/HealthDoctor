package com.example.mine.view.fragment.mywallet;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.base.view.fragment.IBaseFragment;
import com.example.mine.R;
import com.example.mine.R2;

import butterknife.BindView;

public class BingDingFragment extends IBaseFragment {

    @BindView(R2.id.bindReturn)
    ImageView bindReturn;
    @BindView(R2.id.bindID)
    TextView bindID;
    @BindView(R2.id.bindBank)
    TextView bindBank;

    @Override
    protected int setLayout() {
        return R.layout.binding;
    }

    @Override
    protected void initView() {

        bindID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BingDingIDFragment bingDingIDFragment = new BingDingIDFragment();

                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.myWalletFrame, bingDingIDFragment)
                        .commit();

            }
        });

        bindBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BingDingBankFragment bingDingBankFragment = new BingDingBankFragment();

                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.myWalletFrame, bingDingBankFragment)
                        .commit();

            }
        });


    }

    @Override
    protected void initData() {

    }

}
