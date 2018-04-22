package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.tuberculosis.TuberculosisFollowup;
import net.greatsoft.main.db.po.tuberculosis.TuberculosisInfo;
import net.greatsoft.main.fragment.FuTuberculosisFollowupFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/23.
 * 肺结核患者随访
 */

public class FuTuberculosisFollowupView extends FuUiFrameModel implements View.OnClickListener {

    FuTextView tv_name; //姓名
    FuTextView tv_followupDate; //随访日期
    FuEditText et_trentmentMonth; //治疗月序
    LinearLayout ll_superviseTypeCode; //督导人员选择
    LinearLayout ll_followupWayCode; //随访方式
    LinearLayout ll_zhengZhuang; //症状及体征
    FuEditText et_chemotherapyCode; //化疗方案
    LinearLayout ll_drugUseCode; //用法
    LinearLayout ll_yaoji; //药品剂型
    FuEditText et_loseDrugTimes; //漏服药次数
    LinearLayout ll_drugAdverseCode; //药物不良反应
    LinearLayout ll_complicationCode; //并发症或合并症
    FuEditText et_dailySmoking; //吸烟
    FuEditText et_aimDailySmoking; //吸烟
    FuEditText et_dailyDrinking; //饮酒
    FuEditText et_aimDailyDrinking; //饮酒
    FuEditText et_refertoOrgName; //转诊科别
    FuEditText et_referralReason; //转诊原因
    FuEditText et_getMedicinePlace; //2周内随访结果
    FuEditText et_suggestion; //处理意见
    FuTextView tv_nextFollowupDate; //下次随访时间
    Spinner sp_followupDoctorId; //评估医生签名
    FuTextView tv_stopTreatmentDate; //出现停止治疗时间
    LinearLayout ll_stopTreatmentReasonCode; //停止治疗及原因
    FuEditText et_shouldFollowupTimes; //应访视患者
    FuEditText et_actualFollowupTimes; //实际访视
    FuEditText et_shouldDrugTimes; //应服药
    FuEditText et_actualDrugTimes; //实际服药
    FuEditText et_drugRatio; //服药率
    Spinner sp_assessDoctorId; //评估医生签名

    public FuTuberculosisFollowupView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_followupDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.tv_stopTreatmentDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.tv_nextFollowupDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuTuberculosisFollowupFragment.SAVE_TUBERCULOSIS_FOLLOWUP, null);
                break;
        }

    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_tuberculosis_followup_view, null);
    }

    @Override
    protected void initFuData() {

        //医生
        List<Emp> empList = sqlHelper.getAllEmpList();
        ArrayAdapter adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_followupDoctorId.setAdapter(adapter);
        sp_assessDoctorId.setAdapter(adapter);

        initCheckBoxSimple("TuberculosisSupervised", ll_superviseTypeCode, false);//督导人员选择
        initCheckBoxSimple("TuberculosisWay", ll_followupWayCode, false);//随访方式
        initCheckBoxMany("tuberculosisSymptom", ll_zhengZhuang, 3, false, true);//症状及体征
        initCheckBoxSimple("TuberculosisUsage", ll_drugUseCode, false);//用法
        initCheckBoxMany("medicineFormulation", ll_yaoji, 3);//药品剂型
        initCheckBoxSimple("notHas", ll_drugAdverseCode, true);//药物不良反应
        initCheckBoxSimple("notHas", ll_complicationCode, true);//并发症或合并症
        initCheckBoxSimple("TuberculosisStop", ll_stopTreatmentReasonCode, 2);//停止治疗及原因

        FuTextView fu_title_center = (FuTextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("肺结核患者随访");
        fu_title_center.setVisibility(View.VISIBLE);
        FuButton fu_title_right_btn = (FuButton) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    @Override
    protected void initWidget() {

        findView();

    }

    public void setData(TuberculosisFollowup tuberculosis) {
        tv_name.setText(tuberculosis.getName());
    }

    public boolean saveData(TuberculosisFollowup tuberculosis, TuberculosisInfo tuberculosisInfo) {
        if ("".equals(getCheckBoxSimpleCode(ll_followupWayCode))) {
            ToastUtil.showToast(mContext, "请选择随访方式", Toast.LENGTH_LONG);
            return false;
        }
        boolean flag = true;
        saveCheckBoxMany("", tuberculosis.getRecordChoice(), ll_zhengZhuang);
        List<RecordChoice> choice = tuberculosis.getRecordChoice();//目前症状
        for (int i = 0; i < choice.size(); i++) {
            if ("tuberculosisSymptom".equals(choice.get(i).getCodeType())) {
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择症状及体征", Toast.LENGTH_LONG);
            return false;
        }
        tuberculosis.setFollowupDate(tv_followupDate.getDate());
        tuberculosis.setTrentmentMonth(et_trentmentMonth.getInt());
        tuberculosis.setSuperviseTypeCode(getCheckBoxSimpleCode(ll_superviseTypeCode));
        tuberculosis.setFollowupWayCode(getCheckBoxSimpleCode(ll_followupWayCode));
        tuberculosis.setChemotherapyValue(et_chemotherapyCode.getString());
        tuberculosis.setDrugUseCode(getCheckBoxSimpleCode(ll_drugUseCode));
        saveCheckBoxMany("", tuberculosis.getRecordChoice(), ll_yaoji);
        tuberculosis.setLoseDrugTimes(et_loseDrugTimes.getInt());
        tuberculosis.setDrugAdverseCode(getCheckBoxSimpleCode(ll_drugAdverseCode));
        tuberculosis.setDrugAdverseDesc(getString(ll_drugAdverseCode));
        tuberculosis.setComplicationCode(getCheckBoxSimpleCode(ll_complicationCode));
        tuberculosis.setComplicationDesc(getString(ll_complicationCode));
        tuberculosis.setDailySmoking(et_dailySmoking.getInt());
        tuberculosis.setAimDailySmoking(et_aimDailySmoking.getInt());
        tuberculosis.setDailyDrinking(et_dailyDrinking.getInt());
        tuberculosis.setAimDailyDrinking(et_aimDailyDrinking.getInt());
        tuberculosis.setRefertoDeptName(et_refertoOrgName.getString());
        tuberculosis.setReferralReason(et_referralReason.getString());
        tuberculosis.setGetMedicinePlace(et_getMedicinePlace.getString());
        tuberculosis.setSuggestion(et_suggestion.getString());
        tuberculosis.setNextFollowupDate(tv_nextFollowupDate.getDate());
        Emp emp = (Emp) sp_followupDoctorId.getSelectedItem();
        tuberculosis.setFollowupDoctorId(emp.getEmp_id());
        tuberculosis.setFollowupDoctorName(emp.getEmp_name());//随访医生签名
        tuberculosisInfo.setStopTreatmentDate(tv_stopTreatmentDate.getDate());
        tuberculosisInfo.setStopTreatmentReasonCode(getCheckBoxSimpleCode(ll_stopTreatmentReasonCode));
        tuberculosisInfo.setShouldFollowupTimes(et_shouldFollowupTimes.getInt());
        tuberculosisInfo.setActualFollowupTimes(et_actualFollowupTimes.getInt());
        tuberculosisInfo.setShouldDrugTimes(et_shouldDrugTimes.getInt());
        tuberculosisInfo.setActualDrugTimes(et_actualDrugTimes.getInt());
        tuberculosisInfo.setDrugRatio(et_drugRatio.getInt());
        emp = (Emp) sp_assessDoctorId.getSelectedItem();
        tuberculosisInfo.setAssessDoctorId(emp.getEmp_id());
        tuberculosisInfo.setAssessDoctorName(emp.getEmp_name());//随访医生签名

        return true;
    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name); //姓名
        tv_followupDate = (FuTextView) mFuView.findViewById(R.id.tv_followupDate); //随访日期
        tv_followupDate.setOnClickListener(this);
        et_trentmentMonth = (FuEditText) mFuView.findViewById(R.id.et_trentmentMonth); //治疗月序
        ll_superviseTypeCode = (LinearLayout) mFuView.findViewById(R.id.ll_superviseTypeCode); //督导人员选择
        ll_followupWayCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupWayCode); //随访方式
        ll_zhengZhuang = (LinearLayout) mFuView.findViewById(R.id.ll_zhengZhuang); //症状及体征
        et_chemotherapyCode = (FuEditText) mFuView.findViewById(R.id.et_chemotherapyCode); //化疗方案
        ll_drugUseCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugUseCode); //用法
        ll_yaoji = (LinearLayout) mFuView.findViewById(R.id.ll_yaoji); //药品剂型
        et_loseDrugTimes = (FuEditText) mFuView.findViewById(R.id.et_loseDrugTimes); //漏服药次数
        ll_drugAdverseCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugAdverseCode); //药物不良反应
        ll_complicationCode = (LinearLayout) mFuView.findViewById(R.id.ll_complicationCode); //并发症或合并症
        et_dailySmoking = (FuEditText) mFuView.findViewById(R.id.et_dailySmoking); //吸烟
        et_aimDailySmoking = (FuEditText) mFuView.findViewById(R.id.et_aimDailySmoking); //吸烟
        et_dailyDrinking = (FuEditText) mFuView.findViewById(R.id.et_dailyDrinking); //饮酒
        et_aimDailyDrinking = (FuEditText) mFuView.findViewById(R.id.et_aimDailyDrinking); //饮酒
        et_refertoOrgName = (FuEditText) mFuView.findViewById(R.id.et_refertoOrgName); //转诊科别
        et_referralReason = (FuEditText) mFuView.findViewById(R.id.et_referralReason); //转诊原因
        et_getMedicinePlace = (FuEditText) mFuView.findViewById(R.id.et_getMedicinePlace); //2周内随访结果
        et_suggestion = (FuEditText) mFuView.findViewById(R.id.et_suggestion); //处理意见
        tv_nextFollowupDate = (FuTextView) mFuView.findViewById(R.id.tv_nextFollowupDate); //下次随访时间
        tv_nextFollowupDate.setOnClickListener(this);
        sp_followupDoctorId = (Spinner) mFuView.findViewById(R.id.sp_followupDoctorId); //随访医生签名
        tv_stopTreatmentDate = (FuTextView) mFuView.findViewById(R.id.tv_stopTreatmentDate); //出现停止治疗时间
        tv_stopTreatmentDate.setOnClickListener(this);
        ll_stopTreatmentReasonCode = (LinearLayout) mFuView.findViewById(R.id.ll_stopTreatmentReasonCode); //停止治疗及原因
        et_shouldFollowupTimes = (FuEditText) mFuView.findViewById(R.id.et_shouldFollowupTimes); //应访视患者
        et_actualFollowupTimes = (FuEditText) mFuView.findViewById(R.id.et_actualFollowupTimes); //实际访视
        et_shouldDrugTimes = (FuEditText) mFuView.findViewById(R.id.et_shouldDrugTimes); //应服药
        et_actualDrugTimes = (FuEditText) mFuView.findViewById(R.id.et_actualDrugTimes); //实际服药
        et_drugRatio = (FuEditText) mFuView.findViewById(R.id.et_drugRatio); //服药率
        sp_assessDoctorId = (Spinner) mFuView.findViewById(R.id.sp_assessDoctorId); //评估医生签名

    }
}
