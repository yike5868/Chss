package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.old.ElderSelfcareAbility;
import net.greatsoft.main.fragment.FuSelfcareFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuRadioButton;
import net.greatsoft.main.view.FuTextView;

/**
 * Created by zhanglin on 2016/11/26.
 */

public class FuSelfcareView extends FuUiFrameModel implements View.OnClickListener {

    FuTextView tv_dineScore; //进餐
    FuTextView tv_cleanupScore; //梳洗
    FuTextView tv_dressedScore; //穿衣
    FuTextView tv_defecationScore; //如厕
    FuTextView tv_activityScore; //活动
    FuTextView tv_totalScore; //总评分
    FuTextView tv_fillDate; //填表日期
    RadioGroup rg_jincan; //进餐
    RadioGroup rg_shuxi; //梳洗
    RadioGroup rg_chuanyi; //穿衣
    RadioGroup rg_ruce; //如厕
    RadioGroup rg_huodong; //活动

    TextView fu_title_center;
    Button fu_title_right_btn;
    int t = 0;

    public FuSelfcareView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_old_slef, null);
    }

    @Override
    protected void initFuData() {

        initOldCognitiveRadios(rg_jincan, tv_dineScore, tv_totalScore);
        initOldCognitiveRadios(rg_chuanyi, tv_dressedScore, tv_totalScore);
        initOldCognitiveRadios(rg_huodong, tv_activityScore, tv_totalScore);
        initOldCognitiveRadios(rg_ruce, tv_defecationScore, tv_totalScore);
        initOldCognitiveRadios(rg_shuxi, tv_cleanupScore, tv_totalScore);

    }

    @Override
    protected void initWidget() {

        findView();

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("老年人自理能力随访");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    public boolean saveData(ElderSelfcareAbility elderSelfcareAbility) {

        if ("".equals(tv_fillDate.getText().toString())) {
            ToastUtil.showToast(mContext, "请选择填表日期", Toast.LENGTH_LONG);
            return false;
        }

        elderSelfcareAbility.setDineScore(tv_dineScore.getInt());
        elderSelfcareAbility.setCleanupScore(tv_cleanupScore.getInt());
        elderSelfcareAbility.setDressedScore(tv_dressedScore.getInt());
        elderSelfcareAbility.setDefecationScore(tv_defecationScore.getInt());
        elderSelfcareAbility.setActivityScore(tv_activityScore.getInt());
        elderSelfcareAbility.setTotalScore(t);
        elderSelfcareAbility.setFillDate(tv_fillDate.getDate());

        return true;
    }

    private void findView() {

        tv_dineScore = (FuTextView) mFuView.findViewById(R.id.tv_dineScore); //进餐
        tv_cleanupScore = (FuTextView) mFuView.findViewById(R.id.tv_cleanupScore); //梳洗
        tv_dressedScore = (FuTextView) mFuView.findViewById(R.id.tv_dressedScore); //穿衣
        tv_defecationScore = (FuTextView) mFuView.findViewById(R.id.tv_defecationScore); //如厕
        tv_activityScore = (FuTextView) mFuView.findViewById(R.id.tv_activityScore); //活动
        tv_totalScore = (FuTextView) mFuView.findViewById(R.id.tv_totalScore); //总评分
        tv_fillDate = (FuTextView) mFuView.findViewById(R.id.tv_fillDate); //填表日期
        tv_fillDate.setOnClickListener(this);
        rg_jincan = (RadioGroup) mFuView.findViewById(R.id.rg_jincan); //进餐
        rg_shuxi = (RadioGroup) mFuView.findViewById(R.id.rg_shuxi); //梳洗
        rg_chuanyi = (RadioGroup) mFuView.findViewById(R.id.rg_chuanyi); //穿衣
        rg_ruce = (RadioGroup) mFuView.findViewById(R.id.rg_ruce); //如厕
        rg_huodong = (RadioGroup) mFuView.findViewById(R.id.rg_huodong); //活动

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_fillDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuSelfcareFragment.EVENT_SAVE_SELFCARE, null);
                break;
        }
    }

    // 初始化radio
    private void initOldCognitiveRadios(final RadioGroup ll, final FuTextView tv, final FuTextView total) {

        if (ll != null) {
            for (int i = 0; i < ll.getChildCount(); i++) {
                View v = ll.getChildAt(i);
                if (v instanceof FuRadioButton) {
                    FuRadioButton rb = (FuRadioButton) v;

                    rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonView,
                                                     boolean isChecked) {
                            if (isChecked) {
                                for (int j = 0; j < ll.getChildCount(); j++) {
                                    View v = ll.getChildAt(j);
                                    if (v instanceof RadioButton) {
                                        if (buttonView.getTag().equals(v.getTag())) {
                                            tv.setText(buttonView.getTag().toString() + "");
                                        }

                                    }
                                }
                            }
                        }
                    });

                    ll.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            t = getSocure(rg_chuanyi) + getSocure(rg_huodong) + getSocure(rg_jincan) +
                                    getSocure(rg_ruce) + getSocure(rg_shuxi);

                            total.setText("总评分：" + t + "分");
                        }
                    });

                }

            }
        }

    }

    private int getSocure(RadioGroup rg) {

        int j = 0;

        for (int i = 0; i < rg.getChildCount(); i++) {
            View view = rg.getChildAt(i);
            if (view instanceof FuRadioButton) {
                if (((FuRadioButton) view).isChecked()) {
                    j = Integer.parseInt(view.getTag().toString());
                }
            }
        }

        return j;
    }

}
