package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.old.ElderTcmHealth;
import net.greatsoft.main.fragment.FuElderTcmHealthFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.ElderInterFace;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/21.
 * 中医药健康管理
 */

public class FuElderTcmHealthView extends FuUiFrameModel implements View.OnClickListener {

    FuTextView tv_name; //姓名
    LinearLayout ll_energy; //1
    LinearLayout ll_fatigue; //2
    LinearLayout ll_breathe; //3
    LinearLayout ll_speak; //4
    LinearLayout ll_unpleasant; //5
    LinearLayout ll_nervous; //6
    LinearLayout ll_solitary; //7
    LinearLayout ll_scare; //8
    LinearLayout ll_weight; //9
    LinearLayout ll_eye; //10
    LinearLayout ll_hand; //11
    LinearLayout ll_craw; //12
    LinearLayout ll_cold; //13
    LinearLayout ll_catchacold; //14
    LinearLayout ll_runathenose; //15
    LinearLayout ll_mouth; //16
    LinearLayout ll_food; //17
    LinearLayout ll_derma; //18
    LinearLayout ll_bleeding; //19
    LinearLayout ll_fingermail; //20
    LinearLayout ll_oraldry; //21
    LinearLayout ll_ache; //22
    LinearLayout ll_face; //23
    LinearLayout ll_spot; //24
    LinearLayout ll_sore; //25
    LinearLayout ll_drinking; //26
    LinearLayout _bittertaste; //27
    LinearLayout ll_abdomen; //28
    LinearLayout ll_uncomfortable; //29
    LinearLayout ll_unwell; //30
    LinearLayout ll_malaise; //31
    LinearLayout ll_tongue; //32
    LinearLayout ll_vein; //33
    LinearLayout ll_qiDeficiencyCode; //气虚质
    LinearLayout ll_qi; //气虚质中医药保健指导
    LinearLayout ll_yangDeficiencyCode; //阳虚质
    LinearLayout ll_yang; //阳虚质中医药保健指导
    LinearLayout ll_yinDeficiencyCode; //阴虚质
    LinearLayout ll_yin; //阴虚质中医药保健指导
    LinearLayout ll_phlegmWetCode; //痰湿质
    LinearLayout ll_phlegm; //痰湿质中医药保健指导
    LinearLayout ll_dampHeatCode; //湿热质
    LinearLayout ll_damp; //湿热质中医药保健指导
    LinearLayout ll_bloodStasisCode; //血瘀质
    LinearLayout ll_blood; //血瘀质中医药保健指导
    LinearLayout ll_qiDepressionCode; //气郁质
    LinearLayout ll_qiDepression; //气郁质中医药保健指导
    LinearLayout ll_specialDiathsisCode; //特禀质
    LinearLayout ll_special; //特禀质中医药保健指导
    LinearLayout ll_gentleQualityCode; //平和质
    LinearLayout ll_gentle; //平和质中医药保健指导
    FuTextView tv_fillDate; //填表日期
    Spinner sp_doctorName; //医生签名

    TextView fu_title_center;
    Button fu_title_right_btn;

    OnChange onChange;

    public FuElderTcmHealthView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    /**
     * type =  ElderTcmS
     * ElderTcmS9
     * ElderTcmS14
     * ElderTcmS17
     * ElderTcmS28
     * <p>
     * ElderTcmSf
     * initCheckBoxSimpleElder
     */

    //
    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_elder_tcm_health, null);
        onChange = new OnChange();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_fillDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuElderTcmHealthFragment.EVENT_SAVE_ELDER_TCM_HEALTH, null);
                break;
        }

    }



    @Override
    protected void initFuData() {

        initCheckBoxSimpleElder("ElderTcmS", ll_energy, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_fatigue, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_breathe, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_speak, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_unpleasant, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_nervous, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_solitary, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_scare, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS9", ll_weight, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_eye, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_hand, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_craw, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_cold, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS14", ll_catchacold, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_runathenose, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_mouth, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS17", ll_food, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_derma, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_bleeding, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_fingermail, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_oraldry, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_ache, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_face, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_spot, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_sore, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_drinking, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", _bittertaste, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS28", ll_abdomen, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_uncomfortable, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_unwell, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_malaise, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_tongue, 2, onChange, false);
        initCheckBoxSimpleElder("ElderTcmS", ll_vein, 2, onChange, false);


        initCheckBoxSimpleElder("ElderTcmSf", ll_qiDeficiencyCode, 0, null, true);
        initCheckBoxSimpleElder("ElderTcmSf", ll_yangDeficiencyCode, 0, null, true);
        initCheckBoxSimpleElder("ElderTcmSf", ll_yinDeficiencyCode, 0, null, true);
        initCheckBoxSimpleElder("ElderTcmSf", ll_phlegmWetCode, 0, null, true);
        initCheckBoxSimpleElder("ElderTcmSf", ll_dampHeatCode, 0, null, true);
        initCheckBoxSimpleElder("ElderTcmSf", ll_bloodStasisCode, 0, null, true);
        initCheckBoxSimpleElder("ElderTcmSf", ll_qiDepressionCode, 0, null, true);
        initCheckBoxSimpleElder("ElderTcmSf", ll_specialDiathsisCode, 0, null, true);
        initCheckBoxSimpleElder("ElderTcmSf", ll_gentleQualityCode, 0, null, true);


        initCheckBoxMany("qiDeficiencyCode", ll_qi, 3, false, true);
        initCheckBoxMany("yangDeficiencyCode", ll_yang, 3, false, true);
        initCheckBoxMany("yinDeficiencyCode", ll_yin, 3, false, true);
        initCheckBoxMany("phlegmWetCode", ll_phlegm, 3, false, true);
        initCheckBoxMany("dampHeatCode", ll_damp, 3, false, true);
        initCheckBoxMany("bloodStasisCode", ll_blood, 3, false, true);
        initCheckBoxMany("qiDepressionCode", ll_qiDepression, 3, false, true);
        initCheckBoxMany("specialDiathsisCode", ll_special, 3, false, true);
        initCheckBoxMany("gentleQualityCode", ll_gentle, 3, false, true);

    }


    class OnChange implements ElderInterFace {

        @Override
        public void onChangeEvent() {
            int score1 = getScore(ll_fatigue, ll_breathe, ll_speak, ll_catchacold); //气虚质
            setCheckBoxSelectElder(getCode(score1), score1, ll_qiDeficiencyCode);
            int score2 = getScore(ll_hand, ll_craw, ll_cold, ll_uncomfortable); //阳虚质
            setCheckBoxSelectElder(getCode(score2), score2, ll_yangDeficiencyCode);
            int score3 = getScore(ll_eye, ll_oraldry, ll_drinking, ll_malaise); //阴虚质
            setCheckBoxSelectElder(getCode(score3), score3, ll_yinDeficiencyCode);
            int score4 = getScore(ll_weight, ll_mouth, ll_abdomen, ll_tongue); //痰湿质
            setCheckBoxSelectElder(getCode(score4), score4, ll_phlegmWetCode);
            int score5 = getScore(ll_face, ll_sore, _bittertaste, ll_unwell); //湿热质
            setCheckBoxSelectElder(getCode(score5), score5, ll_dampHeatCode);
            int score6 = getScore(ll_bleeding, ll_ache, ll_spot, ll_vein); //血瘀质
            setCheckBoxSelectElder(getCode(score6), score6, ll_bloodStasisCode);
            int score7 = getScore(ll_unpleasant, ll_nervous, ll_solitary, ll_scare); //气郁质
            setCheckBoxSelectElder(getCode(score7), score7, ll_qiDepressionCode);
            int score8 = getScore(ll_runathenose, ll_food, ll_derma, ll_fingermail); //特禀质
            setCheckBoxSelectElder(getCode(score8), score8, ll_specialDiathsisCode);
            int score9 = getScoreElse(ll_energy, ll_fatigue, ll_speak, ll_unpleasant, ll_cold); //平和质
            setCheckBoxSelectElder(getCodeElse(score9, score1, score2, score3,
                    score4, score5, score6, score7, score8), score9, ll_gentleQualityCode);
            setCheckBoxSelectElder(getCode(score1), ll_qi);
            setCheckBoxSelectElder(getCode(score2), ll_yang);
            setCheckBoxSelectElder(getCode(score3), ll_yin);
            setCheckBoxSelectElder(getCode(score4), ll_phlegm);
            setCheckBoxSelectElder(getCode(score5), ll_damp);
            setCheckBoxSelectElder(getCode(score6), ll_blood);
            setCheckBoxSelectElder(getCode(score7), ll_qiDepression);
            setCheckBoxSelectElder(getCode(score8), ll_special);
            setCheckBoxSelectElder(getCodeElse(score9, score1, score2, score3,
                    score4, score5, score6, score7, score8), score9, ll_gentle);

        }
    }

    @Override
    protected void initWidget() {

        findView();

        List<Emp> empList = sqlHelper.getAllEmpList();
        ArrayAdapter adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_doctorName.setAdapter(adapter);

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("老年人中医药健康管理");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    public void setData(ElderTcmHealth elderTcmHealth) {
        tv_name.setText(elderTcmHealth.getName());
    }

    public boolean saveData(ElderTcmHealth elderTcmHealth) {

        if ("".equals(tv_fillDate.getText().toString())) {
            ToastUtil.showToast(mContext, "请选择填表日期", Toast.LENGTH_LONG);
            return false;
        }

        elderTcmHealth.setEnergy(getCheckBoxSimpleCode(ll_energy));
        elderTcmHealth.setFatigue(getCheckBoxSimpleCode(ll_fatigue));
        elderTcmHealth.setBreathe(getCheckBoxSimpleCode(ll_breathe));
        elderTcmHealth.setSpeak(getCheckBoxSimpleCode(ll_speak));
        elderTcmHealth.setUnpleasant(getCheckBoxSimpleCode(ll_unpleasant));
        elderTcmHealth.setNervous(getCheckBoxSimpleCode(ll_nervous));
        elderTcmHealth.setSolitary(getCheckBoxSimpleCode(ll_solitary));
        elderTcmHealth.setScare(getCheckBoxSimpleCode(ll_scare));
        elderTcmHealth.setWeight(getCheckBoxSimpleCode(ll_weight));
        elderTcmHealth.setEye(getCheckBoxSimpleCode(ll_eye));
        elderTcmHealth.setHand(getCheckBoxSimpleCode(ll_hand));
        elderTcmHealth.setCraw(getCheckBoxSimpleCode(ll_craw));
        elderTcmHealth.setCold(getCheckBoxSimpleCode(ll_cold));
        elderTcmHealth.setCatchacold(getCheckBoxSimpleCode(ll_catchacold));
        elderTcmHealth.setRunathenose(getCheckBoxSimpleCode(ll_runathenose));
        elderTcmHealth.setMouth(getCheckBoxSimpleCode(ll_mouth));
        elderTcmHealth.setFood(getCheckBoxSimpleCode(ll_food));
        elderTcmHealth.setDerma(getCheckBoxSimpleCode(ll_derma));
        elderTcmHealth.setBleeding(getCheckBoxSimpleCode(ll_bleeding));
        elderTcmHealth.setFingermail(getCheckBoxSimpleCode(ll_fingermail));
        elderTcmHealth.setOraldry(getCheckBoxSimpleCode(ll_oraldry));
        elderTcmHealth.setAche(getCheckBoxSimpleCode(ll_ache));
        elderTcmHealth.setFace(getCheckBoxSimpleCode(ll_face));
        elderTcmHealth.setSpot(getCheckBoxSimpleCode(ll_spot));
        elderTcmHealth.setSore(getCheckBoxSimpleCode(ll_sore));
        elderTcmHealth.setDrinking(getCheckBoxSimpleCode(ll_drinking));
        elderTcmHealth.setBittertaste(getCheckBoxSimpleCode(_bittertaste));
        elderTcmHealth.setAbdomen(getCheckBoxSimpleCode(ll_abdomen));
        elderTcmHealth.setUncomfortable(getCheckBoxSimpleCode(ll_uncomfortable));
        elderTcmHealth.setUnwell(getCheckBoxSimpleCode(ll_unwell));
        elderTcmHealth.setMalaise(getCheckBoxSimpleCode(ll_malaise));
        elderTcmHealth.setTongue(getCheckBoxSimpleCode(ll_tongue));
        elderTcmHealth.setVein(getCheckBoxSimpleCode(ll_vein));
        elderTcmHealth.setQiDeficiencyScore(Integer.parseInt(getLinearLayoutString(ll_qiDepressionCode)));
        elderTcmHealth.setQiDeficiencyCode(getCheckBoxSimpleCode(ll_qiDeficiencyCode));
        elderTcmHealth.setYangDeficiencyScore(Integer.parseInt(getLinearLayoutString(ll_yangDeficiencyCode)));
        elderTcmHealth.setYangDeficiencyCode(getCheckBoxSimpleCode(ll_yangDeficiencyCode));
        elderTcmHealth.setYinDeficiencyScore(Integer.parseInt(getLinearLayoutString(ll_yinDeficiencyCode)));
        elderTcmHealth.setYinDeficiencyCode(getCheckBoxSimpleCode(ll_yinDeficiencyCode));
        elderTcmHealth.setPhlegmWetScore(Integer.parseInt(getLinearLayoutString(ll_phlegmWetCode)));
        elderTcmHealth.setPhlegmWetCode(getCheckBoxSimpleCode(ll_phlegmWetCode));
        elderTcmHealth.setDampHeatScore(Integer.parseInt(getLinearLayoutString(ll_dampHeatCode)));
        elderTcmHealth.setDampHeatCode(getCheckBoxSimpleCode(ll_dampHeatCode));
        elderTcmHealth.setBloodStasisScore(Integer.parseInt(getLinearLayoutString(ll_bloodStasisCode)));
        elderTcmHealth.setBloodStasisCode(getCheckBoxSimpleCode(ll_bloodStasisCode));
        elderTcmHealth.setQiDepressionScore(Integer.parseInt(getLinearLayoutString(ll_qiDepressionCode)));
        elderTcmHealth.setQiDepressionCode(getCheckBoxSimpleCode(ll_qiDepressionCode));
        elderTcmHealth.setSpecialDiathsisScore(Integer.parseInt(getLinearLayoutString(ll_specialDiathsisCode)));
        elderTcmHealth.setSpecialDiathsisCode(getCheckBoxSimpleCode(ll_specialDiathsisCode));
        elderTcmHealth.setGentleQualityScore(Integer.parseInt(getLinearLayoutString(ll_gentleQualityCode)));
        elderTcmHealth.setGentleQualityCode(getCheckBoxSimpleCode(ll_gentleQualityCode));
        saveCheckBoxMany("qiDeficiencyCode", elderTcmHealth.getRecordChoice(), ll_qi);
        saveCheckBoxMany("yangDeficiencyCode", elderTcmHealth.getRecordChoice(), ll_yang);
        saveCheckBoxMany("yinDeficiencyCode", elderTcmHealth.getRecordChoice(), ll_yin);
        saveCheckBoxMany("phlegmWetCode", elderTcmHealth.getRecordChoice(), ll_phlegm);
        saveCheckBoxMany("dampHeatCode", elderTcmHealth.getRecordChoice(), ll_damp);
        saveCheckBoxMany("bloodStasisCode", elderTcmHealth.getRecordChoice(), ll_blood);
        saveCheckBoxMany("qiDepressionCode", elderTcmHealth.getRecordChoice(), ll_qiDepression);
        saveCheckBoxMany("specialDiathsisCode", elderTcmHealth.getRecordChoice(), ll_speak);
        saveCheckBoxMany("gentleQualityCode", elderTcmHealth.getRecordChoice(), ll_gentle);
        elderTcmHealth.setFillDate(tv_fillDate.getDate());
        Emp emp = (Emp) sp_doctorName.getSelectedItem();
        elderTcmHealth.setDoctorId(emp.getEmp_id());
        elderTcmHealth.setDoctorName(emp.getEmp_name());  //医生签字

        return true;
    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name); //姓名
        ll_energy = (LinearLayout) mFuView.findViewById(R.id.ll_energy); //1
        ll_fatigue = (LinearLayout) mFuView.findViewById(R.id.ll_fatigue); //2
        ll_breathe = (LinearLayout) mFuView.findViewById(R.id.ll_breathe); //3
        ll_speak = (LinearLayout) mFuView.findViewById(R.id.ll_speak); //4
        ll_unpleasant = (LinearLayout) mFuView.findViewById(R.id.ll_unpleasant); //5
        ll_nervous = (LinearLayout) mFuView.findViewById(R.id.ll_nervous); //6
        ll_solitary = (LinearLayout) mFuView.findViewById(R.id.ll_solitary); //7
        ll_scare = (LinearLayout) mFuView.findViewById(R.id.ll_scare); //8
        ll_weight = (LinearLayout) mFuView.findViewById(R.id.ll_weight); //9
        ll_eye = (LinearLayout) mFuView.findViewById(R.id.ll_eye); //10
        ll_hand = (LinearLayout) mFuView.findViewById(R.id.ll_hand); //11
        ll_craw = (LinearLayout) mFuView.findViewById(R.id.ll_craw); //12
        ll_cold = (LinearLayout) mFuView.findViewById(R.id.ll_cold); //13
        ll_catchacold = (LinearLayout) mFuView.findViewById(R.id.ll_catchacold); //14
        ll_runathenose = (LinearLayout) mFuView.findViewById(R.id.ll_runathenose); //15
        ll_mouth = (LinearLayout) mFuView.findViewById(R.id.ll_mouth); //16
        ll_food = (LinearLayout) mFuView.findViewById(R.id.ll_food); //17
        ll_derma = (LinearLayout) mFuView.findViewById(R.id.ll_derma); //18
        ll_bleeding = (LinearLayout) mFuView.findViewById(R.id.ll_bleeding); //19
        ll_fingermail = (LinearLayout) mFuView.findViewById(R.id.ll_fingermail); //20
        ll_oraldry = (LinearLayout) mFuView.findViewById(R.id.ll_oraldry); //21
        ll_ache = (LinearLayout) mFuView.findViewById(R.id.ll_ache); //22
        ll_face = (LinearLayout) mFuView.findViewById(R.id.ll_face); //23
        ll_spot = (LinearLayout) mFuView.findViewById(R.id.ll_spot); //24
        ll_sore = (LinearLayout) mFuView.findViewById(R.id.ll_sore); //25
        ll_drinking = (LinearLayout) mFuView.findViewById(R.id.ll_drinking); //26
        _bittertaste = (LinearLayout) mFuView.findViewById(R.id._bittertaste); //27
        ll_abdomen = (LinearLayout) mFuView.findViewById(R.id.ll_abdomen); //28
        ll_uncomfortable = (LinearLayout) mFuView.findViewById(R.id.ll_uncomfortable); //29
        ll_unwell = (LinearLayout) mFuView.findViewById(R.id.ll_unwell); //30
        ll_malaise = (LinearLayout) mFuView.findViewById(R.id.ll_malaise); //31
        ll_tongue = (LinearLayout) mFuView.findViewById(R.id.ll_tongue); //32
        ll_vein = (LinearLayout) mFuView.findViewById(R.id.ll_vein); //33
        ll_qiDeficiencyCode = (LinearLayout) mFuView.findViewById(R.id.ll_qiDeficiencyCode); //气虚质
        ll_qi = (LinearLayout) mFuView.findViewById(R.id.ll_qi); //气虚质中医药保健指导
        ll_yangDeficiencyCode = (LinearLayout) mFuView.findViewById(R.id.ll_yangDeficiencyCode); //阳虚质
        ll_yang = (LinearLayout) mFuView.findViewById(R.id.ll_yang); //阳虚质中医药保健指导
        ll_yinDeficiencyCode = (LinearLayout) mFuView.findViewById(R.id.ll_yinDeficiencyCode); //阴虚质
        ll_yin = (LinearLayout) mFuView.findViewById(R.id.ll_yin); //阴虚质中医药保健指导
        ll_phlegmWetCode = (LinearLayout) mFuView.findViewById(R.id.ll_phlegmWetCode); //痰湿质
        ll_phlegm = (LinearLayout) mFuView.findViewById(R.id.ll_phlegm); //痰湿质中医药保健指导
        ll_dampHeatCode = (LinearLayout) mFuView.findViewById(R.id.ll_dampHeatCode); //湿热质
        ll_damp = (LinearLayout) mFuView.findViewById(R.id.ll_damp); //湿热质中医药保健指导
        ll_bloodStasisCode = (LinearLayout) mFuView.findViewById(R.id.ll_bloodStasisCode); //血瘀质
        ll_blood = (LinearLayout) mFuView.findViewById(R.id.ll_blood); //血瘀质中医药保健指导
        ll_qiDepressionCode = (LinearLayout) mFuView.findViewById(R.id.ll_qiDepressionCode); //气郁质
        ll_qiDepression = (LinearLayout) mFuView.findViewById(R.id.ll_qiDepression); //气郁质中医药保健指导
        ll_specialDiathsisCode = (LinearLayout) mFuView.findViewById(R.id.ll_specialDiathsisCode); //特禀质
        ll_special = (LinearLayout) mFuView.findViewById(R.id.ll_special); //特禀质中医药保健指导
        ll_gentleQualityCode = (LinearLayout) mFuView.findViewById(R.id.ll_gentleQualityCode); //平和质
        ll_gentle = (LinearLayout) mFuView.findViewById(R.id.ll_gentle); //平和质中医药保健指导
        tv_fillDate = (FuTextView) mFuView.findViewById(R.id.tv_fillDate); //填表日期
        tv_fillDate.setOnClickListener(this);
        sp_doctorName = (Spinner) mFuView.findViewById(R.id.sp_doctorName); //医生签名

    }


    public int getScore(LinearLayout... ll) {
        int score = 0;
        for (int i = 0; i < ll.length; i++) {
            if (!"".equals(getCheckBoxSimpleCode(ll[i])))
                score += Integer.parseInt(getCheckBoxSimpleCode(ll[i]));
        }

        return score;
    }

    public int getScoreElse(LinearLayout... ll) {
        int score = 0;
        for (int i = 0; i < ll.length; i++) {
            if (i == 0) {
                if (!"".equals(getCheckBoxSimpleCode(ll[i])))
                    score += Integer.parseInt(getCheckBoxSimpleCode(ll[i]));
            } else {
                if (!"".equals(getCheckBoxSimpleCode(ll[i])))
                    score += (6 - Integer.parseInt(getCheckBoxSimpleCode(ll[i])));
            }
        }

        return score;
    }

    private String getCode(int i) {
        String code = "";
        if (i - 11 >= 0) {
            code = "2";
        } else if (i - 10 <= 0 && i - 9 >= 0) {
            code = "3";
        } else if (i - 8 <= 0) {
            code = "4";
        }
        return code;
    }

    private String getCodeElse(int i, int j1, int j2, int j3, int j4, int j5, int j6, int j7, int j8) {
        String code = "";
        if (i - 17 >= 0 && j1 <= 8 && j2 <= 8 && j3 <= 8 && j4 <= 8 && j5 <= 8 && j6 <= 8 && j7 <= 8 && j8 <= 8) {
            code = "2";
        } else if (i >= 17 && j1 <= 10 && j2 <= 10 && j3 <= 10 && j4 <= 10 && j5 <= 10 && j6 <= 10 && j7 <= 10 && j8 <= 10) {
            code = "3";
        } else
            code = "4";

        return code;
    }

}
