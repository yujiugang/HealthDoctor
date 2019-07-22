package com.example.mine.view.fragment.mywallet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.base.view.fragment.IBaseFragment;
import com.example.mine.R;
import com.example.mine.R2;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BingDingIDFragment extends IBaseFragment {


    @BindView(R2.id.bindIDReturn)
    ImageView bindIDReturn;
    @BindView(R2.id.bindPortrait)
    TextView bindPortrait;
    @BindView(R2.id.bindNationalEmblem)
    TextView bindNationalEmblem;
    @BindView(R2.id.bindIDSim1)
    SimpleDraweeView bindIDSim1;
    @BindView(R2.id.bindIDSim2)
    SimpleDraweeView bindIDSim2;
    Unbinder unbinder;

    @Override
    protected int setLayout() {
        return R.layout.binding_id;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
