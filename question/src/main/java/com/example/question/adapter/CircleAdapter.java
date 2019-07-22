package com.example.question.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.base.R2;
import com.example.base.model.bean.CircleBean;
import com.example.base.model.bean.CircleTitleBean;
import com.example.question.R;
import com.example.question.activity.CircleDetailsActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

/**
 * <p>文件描述：<p>
 * <p>作者：liudada<p>
 * <p>创建时间：2019/7/11<p>
 */
public class CircleAdapter extends RecyclerView.Adapter<CircleAdapter.MyViewHolder> {

    private Context mContext;
    private List<CircleBean.ResultBean> arr = new ArrayList<>();

    public CircleAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setListRefresh(List<CircleBean.ResultBean> list) {
        if (list != null) {
            arr.clear();
            arr.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void setList(List<CircleBean.ResultBean> list) {
        if (list != null) {
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

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.name.setText(arr.get(i).getTitle());
        myViewHolder.content.setText(arr.get(i).getDetail());

        int amount = arr.get(i).getAmount();

        //判断是否有悬赏
        if (amount>0){
            myViewHolder.img.setVisibility(View.VISIBLE);
            myViewHolder.img.setImageResource(R.mipmap.h_currency);
            myViewHolder.num.setText(amount+"");
            //Toast.makeText(mContext, amount + "YYY", Toast.LENGTH_SHORT).show();
        }else {
            myViewHolder.img.setVisibility(View.GONE);
            myViewHolder.num.setText("");
           // Toast.makeText(mContext, amount + "NNN", Toast.LENGTH_SHORT).show();
        }
        long releaseTime = arr.get(i).getReleaseTime();
        Date date = new Date(releaseTime);//用Date构造方法，将long转Date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd  SS:mm");
        String stringDate = format.format(date);
        //设置日期
        myViewHolder.data.setText(stringDate);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mCallBackData_circleDetails.onSickCircleId(arr.get(i).getSickCircleId());
                Intent intent =new Intent(mContext,CircleDetailsActivity.class);
                //传递病友圈ID
                intent.putExtra("sickCircleId",arr.get(i).getSickCircleId());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView data;
        private final TextView num;
        private final TextView content;
        private final ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            data = itemView.findViewById(R.id.data);
            num = itemView.findViewById(R.id.num);
            img = itemView.findViewById(R.id.img);
            content = itemView.findViewById(R.id.content);
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
