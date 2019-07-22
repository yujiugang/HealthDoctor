package com.example.question.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.base.model.bean.CircleBean;
import com.example.question.R;
import com.example.question.activity.CircleDetailsActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：liudada<p>
 * <p>创建时间：2019/7/11<p>
 */
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<String> arr = new ArrayList<>();

    public HistoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setListRefresh(ArrayList<String> list) {
        if (list != null) {
            arr.clear();
            arr.addAll(list);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.circle_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.name.setText(arr.get(i));

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*// mCallBackData_circleDetails.onSickCircleId(arr.get(i).getSickCircleId());
                Intent intent =new Intent(mContext,CircleDetailsActivity.class);
                //传递病友圈ID
                intent.putExtra("sickCircleId",arr.get(i).getSickCircleId());
                mContext.startActivity(intent);*/
            }
        });


    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
/*
    //跳转详情 需要的病友圈ID
    public interface CallBackData_CircleDetails {
        void onSickCircleId(int id);
    }

    private CallBackData_CircleDetails mCallBackData_circleDetails;

    public void setCallBackData_circleDetails(CallBackData_CircleDetails callBackData_circleDetails) {
        this.mCallBackData_circleDetails = callBackData_circleDetails;
    }*/
}
