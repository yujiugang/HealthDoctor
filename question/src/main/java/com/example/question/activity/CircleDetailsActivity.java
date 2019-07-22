package com.example.question.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.base.model.bean.HealthDetailsBean;
import com.example.base.model.bean.StatusBean;
import com.example.base.presenter.MainPresenter;
import com.example.base.view.activity.IBaseActivity;
import com.example.base.view.interfaces.IMainView;
import com.example.question.R;
import com.example.question.R2;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

public class CircleDetailsActivity extends IBaseActivity implements IMainView.IMainShow {
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.name)
    TextView name;
    @BindView(R2.id.diseaseContent)
    TextView diseaseContent;
    @BindView(R2.id.departmentContent)
    TextView departmentContent;
    @BindView(R2.id.diseaseContentDetails)
    TextView diseaseContentDetails;
    @BindView(R2.id.treatment)
    TextView treatment;
    @BindView(R2.id.hospital)
    TextView hospital;
    @BindView(R2.id.data)
    TextView data;
    @BindView(R2.id.recycler_img)
    SimpleDraweeView recyclerImg;
    @BindView(R2.id.know)
    ImageView know;
    @BindView(R2.id.rela_alpha)
    RelativeLayout relaAlpha;
    @BindView(R2.id.money_text)
    TextView moneyText;
    @BindView(R2.id.answer_btn)
    TextView answerBtn;
    @BindView(R2.id.answer_edit)
    LinearLayout answer_edit;
    @BindView(R2.id.content_linear)
    LinearLayout content_linear;
    @BindView(R2.id.content_details)
    TextView content_details;
    private SharedPreferences sp;
    private MainPresenter mainPresenter;
    private int id;
    private String trim;
    private EditText editText;
    private PopupWindow window;
    private StatusBean statusBean;
    Handler handler=new Handler();
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_details);
    }*/

    @Override
    protected int setLayout() {
        return R.layout.activity_circle_details;
    }

    @Override
    protected void initView() {
        //创建sharedPreferences
        sp = getSharedPreferences("circle", Context.MODE_PRIVATE);

        if (sp.getBoolean("one", false)) {
            relaAlpha.setVisibility(View.GONE);
        } else {
            relaAlpha.setVisibility(View.VISIBLE);
            //第一次进入
            SharedPreferences.Editor edit = sp.edit();

            edit.putBoolean("one", true);

            edit.commit();
        }
        //获取病友圈传来的id
        int sickCircleId = getIntent().getIntExtra("sickCircleId", 0);
        Log.e("myMsg:", sickCircleId + "");
        //绑定p层
        mainPresenter = new MainPresenter();
        mainPresenter.setView(this);
        //展示详情
        mainPresenter.LoadShowDetailsData(sickCircleId);
    }

    @Override
    protected void initData() {
        //点击我知道了
        know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relaAlpha.setVisibility(View.GONE);
            }
        });
        //点击返回
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //点击我来解答
        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer_edit.setVisibility(View.GONE);

                //弹出popwindow
                pop();

            }
        });

    }

    @Override
    public void onSuccess(Object o) {

        //病友圈详情
        if (o instanceof HealthDetailsBean) {
            HealthDetailsBean healthDetailsBean = (HealthDetailsBean) o;
            HealthDetailsBean.ResultBean result = healthDetailsBean.getResult();
            //病友圈id
            id = result.getId();
            //赋值
            title.setText(result.getTitle());
            name.setText(result.getAuthorName());
            diseaseContent.setText(result.getDetail());
            departmentContent.setText(result.getDepartmentName());
            diseaseContentDetails.setText(result.getDisease());
            hospital.setText(result.getTreatmentHospital());
            moneyText.setText(result.getAmount() + getResources().getString(R.string.h_money));
            long treatmentStartTime = result.getTreatmentStartTime();
            long treatmentEndTime = result.getTreatmentEndTime();
            //转换日期格式
            //开始时间
            Date date = new Date(treatmentStartTime);//用Date构造方法，将long转Date
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
            String format1 = format.format(date);
            //结束时间
            Date date2 = new Date(treatmentEndTime);//用Date构造方法，将long转Date
            SimpleDateFormat format2 = new SimpleDateFormat("MM.dd");
            String format3 = format2.format(date2);
            data.setText(format1 + "-" + format3);
            treatment.setText(result.getTreatmentProcess());
            if (result.getWhetherContent()==1){//判断是否解答过
                content_linear.setVisibility(View.VISIBLE);//展示解答内容
                answer_edit.setVisibility(View.GONE);//隐藏解答框
                content_details.setText(result.getContent());
            }
            try {
                recyclerImg.setImageURI(Uri.parse(result.getPicture()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (o instanceof StatusBean) {//发表评论
            statusBean = (StatusBean) o;
            editText.setText("");
            if (statusBean.getMessage().equals("发表成功")) {
                Toast.makeText(CircleDetailsActivity.this,
                        statusBean.getMessage(), Toast.LENGTH_SHORT).show();
                //隐藏解答按钮
                answer_edit.setVisibility(View.GONE);
                //展示内容
                content_linear.setVisibility(View.VISIBLE);
                //将评论内容赋值给内容
                content_details.setText(trim);
                window.dismiss();//取消弹框
                Log.d("CircleDetailsActivity", trim);
            } else {
                window.dismiss();//取消弹框
                //展示内容
                content_linear.setVisibility(View.VISIBLE);
                //将评论内容赋值给内容
                content_details.setText(trim);
                Toast.makeText(CircleDetailsActivity.this,
                        statusBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onFail(String message) {

    }

    //popwindow
    private void pop() {
        final View view1 = View.inflate(this, R.layout.edit_pop, null);
        window = new PopupWindow(view1, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, true);

        //设置背景可拉
        window.setBackgroundDrawable(new ColorDrawable());
        //设置外面可触
        window.setOutsideTouchable(true);
        //设置可触
        window.setTouchable(true);
        editText = view1.findViewById(R.id.popup_live_comment_edit);
        ImageView expression = view1.findViewById(R.id.expression);
        ImageView send = view1.findViewById(R.id.send);

        //展示软键盘
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    editText.requestFocus();
                    imm.showSoftInput(editText, 0);

                }
            }
        }, 100);
        //点击发表评论
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入框的值
                trim = editText.getText().toString().trim();
                if (trim.equals("")) {//不为空
                    answer_edit.setVisibility(View.VISIBLE);//展示
                    Toast.makeText(CircleDetailsActivity.this, "请输入评论内容",
                            Toast.LENGTH_SHORT).show();
                    window.dismiss();

                    return;
                } else {
                    mainPresenter.LoadShowCommentData(id, trim);
                }
            }
        });
        if (!window.isShowing()) {
            answer_edit.setVisibility(View.VISIBLE);//展示
        }
        window.showAtLocation(view1, Gravity.BOTTOM, 0, 0);
    }
}
