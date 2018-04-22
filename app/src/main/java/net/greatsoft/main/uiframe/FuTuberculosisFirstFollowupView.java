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
import net.greatsoft.main.db.po.tuberculosis.TuberculosisFirstFollowup;
import net.greatsoft.main.fragment.FuTuberculosisFirstFollowupFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/23.
 * 肺结核患者第一次入户随访
 */

public class FuTuberculosisFirstFollowupView extends FuUiFrameModel implements View.OnClickListener {

    FuTextView tv_name; //姓名
    FuTextView tv_followupDate; //随访日期
    LinearLayout ll_followupWayCode; //随访方式
    LinearLayout ll_patientTypeCode; //患者类型
    LinearLayout ll_sputumCode; //痰菌情况
    LinearLayout ll_drugResistanceCode; //耐药情况
    LinearLayout ll_zhengZhuang; //症状及体征
    FuEditText et_chemotherapyCode; //化疗方案
    LinearLayout ll_drugUseCode; //用法
    LinearLayout ll_yaoji; //药品剂型
    LinearLayout ll_supervisorKindCode; //督导人员选择
    LinearLayout ll_separateRoomCode; //单独的居室
    LinearLayout ll_ventilationCode; //通风情况
    FuEditText et_dailySmoking; //吸烟
    FuEditText et_aimDailySmoking; //吸烟
    FuEditText et_dailyDrinking; //饮酒
    FuEditText et_aimDailyDrinking; //饮酒
    FuEditText et_getMedicinePlace; //取药地点
    FuTextView tv_getMedicineDate; //取药时间
    LinearLayout ll_medicationRecCardCode; //服药记录卡填写
    LinearLayout ll_drugLimitCode; //服药方法及存放
    LinearLayout ll_treatmentCourseCode; //肺结核治疗疗程
    LinearLayout ll_irregularMedicationCode; //不规律服药危害
    LinearLayout ll_artCode; //服药后不良反应及处理
    LinearLayout ll_treatmentSputumCode; //治疗期间复诊查痰
    LinearLayout ll_adhereMedicationCode; //外出期间如何坚持服药
    LinearLayout ll_livingHabitsCode; //生活习惯及注意事项
    LinearLayout ll_closeContactCheckCode; //密切接触者检查
    FuTextView tv_nextFollowupDate; //下次随访时间
    Spinner sp_followupDoctorId; //评估医生签名

    public FuTuberculosisFirstFollowupView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_followupDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.tv_getMedicineDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.tv_nextFollowupDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuTuberculosisFirstFollowupFragment.SAVE_TUBERCULOSIS_FIRST_FOLLOWUP, null);
                break;
        }
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_tuberculosis_first_followup_view, null);
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

        initCheckBoxSimple("TuberculosisWay", ll_followupWayCode, false);//随访方式
        initCheckBoxSimple("TuberculosisType", ll_patientTypeCode, false);//患者类型
        initCheckBoxSimple("TuberculosisSputum", ll_sputumCode, false);//痰菌情况
        initCheckBoxSimple("TuberculosisTolerance", ll_drugResistanceCode, false);//耐药情况
        initCheckBoxMany("tuberculosisFirstSymptom", ll_zhengZhuang, 3, false, true);//症状及体征
        initCheckBoxSimple("TuberculosisUsage", ll_drugUseCode, false);//用法
        initCheckBoxMany("medicineFormulation", ll_yaoji, 3);//药品剂型
        initCheckBoxSimple("TuberculosisSupervised", ll_supervisorKindCode, false);//督导人员选择
        initCheckBoxSimple("TuberculosisHas", ll_separateRoomCode, false);//单独的居室
        initCheckBoxSimple("TuberculosisAir", ll_ventilationCode, false);//通风情况
        initCheckBoxSimple("TuberculosisTrain", ll_medicationRecCardCode, false);//服药记录卡填写
        initCheckBoxSimple("TuberculosisTrain", ll_drugLimitCode, false);//服药方法及存放
        initCheckBoxSimple("TuberculosisTrain", ll_treatmentCourseCode, false);//肺结核治疗疗程
        initCheckBoxSimple("TuberculosisTrain", ll_irregularMedicationCode, false);//不规律服药危害
        initCheckBoxSimple("TuberculosisTrain", ll_artCode, false);//服药后不良反应及处理
        initCheckBoxSimple("TuberculosisTrain", ll_treatmentSputumCode, false);//治疗期间复诊查痰
        initCheckBoxSimple("TuberculosisTrain", ll_adhereMedicationCode, false);//外出期间如何坚持服药
        initCheckBoxSimple("TuberculosisTrain", ll_livingHabitsCode, false);//生活习惯及注意事项
        initCheckBoxSimple("TuberculosisTrain", ll_closeContactCheckCode, false);//密切接触者检查

        FuTextView fu_title_center = (FuTextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("肺结核患者第一次入户随访");
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

    public void setData(TuberculosisFirstFollowup tuberculosisFirstFollowup) {
        tv_name.setText(tuberculosisFirstFollowup.getName());
    }

    public boolean saveData(TuberculosisFirstFollowup tuberculosis) {

        if ("".equals(getCheckBoxSimpleCode(ll_followupWayCode))) {
            ToastUtil.showToast(mContext, "请选择随访方式", Toast.LENGTH_LONG);
            return false;
        }
        boolean flag = true;
        saveCheckBoxMany("", tuberculosis.getRecordChoice(), ll_zhengZhuang);
        List<RecordChoice> choice = tuberculosis.getRecordChoice();//目前症状
        for (int i = 0; i < choice.size(); i++) {
            if ("tuberculosisFirstSymptom".equals(choice.get(i).getCodeType())) {
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择症状及体征", Toast.LENGTH_LONG);
            return false;
        }
        tuberculosis.setFollowupDate(tv_followupDate.getDate()); //随访日期
        tuberculosis.setFollowupWayCode(getCheckBoxSimpleCode(ll_followupWayCode));//随访方式
        tuberculosis.setPatientTypeCode(getCheckBoxSimpleCode(ll_patientTypeCode)); //患者类型
        tuberculosis.setSputumCode(getCheckBoxSimpleCode(ll_sputumCode));//痰菌情况
        tuberculosis.setDrugResistanceCode(getCheckBoxSimpleCode(ll_drugResistanceCode));//耐药情况
        tuberculosis.setChemotherapyValue(et_chemotherapyCode.getString());//化疗方案
        tuberculosis.setDrugUseCode(getCheckBoxSimpleCode(ll_drugUseCode));//用法
        saveCheckBoxMany("", tuberculosis.getRecordChoice(), ll_yaoji); //药品剂型
        tuberculosis.setSupervisorKindCode(getCheckBoxSimpleCode(ll_supervisorKindCode));//督导人员选择
        tuberculosis.setSeparateRoomCode(getCheckBoxSimpleCode(ll_separateRoomCode)); //单独的居室
        tuberculosis.setVentilationCode(getCheckBoxSimpleCode(ll_ventilationCode));//通风情况
        tuberculosis.setDailySmoking(et_dailySmoking.getInt());//吸烟
        tuberculosis.setAimDailySmoking(et_aimDailySmoking.getInt());//吸烟
        tuberculosis.setDailyDrinking(et_dailyDrinking.getInt());//饮酒
        tuberculosis.setAimDailyDrinking(et_aimDailyDrinking.getInt());//饮酒
        tuberculosis.setGetMedicinePlace(et_getMedicinePlace.getString()); //取药地点
        tuberculosis.setGetMedicineDate(tv_getMedicineDate.getDate());//取药时间
        tuberculosis.setMedicationRecCardCode(getCheckBoxSimpleCode(ll_medicationRecCardCode)); //服药记录卡填写
        tuberculosis.setDrugLimitCode(getCheckBoxSimpleCode(ll_drugLimitCode));//服药方法及存放
        tuberculosis.setTreatmentCourseCode(getCheckBoxSimpleCode(ll_treatmentCourseCode));//肺结核治疗疗程
        tuberculosis.setIrregularMedicationCode(getCheckBoxSimpleCode(ll_irregularMedicationCode));//不规律服药危害
        tuberculosis.setArtCode(getCheckBoxSimpleCode(ll_artCode));//服药后不良反应及处理
        tuberculosis.setTreatmentSputumCode(getCheckBoxSimpleCode(ll_treatmentSputumCode));//治疗期间复诊查痰
        tuberculosis.setAdhereMedicationCode(getCheckBoxSimpleCode(ll_adhereMedicationCode));//外出期间如何坚持服药
        tuberculosis.setLivingHabitsCode(getCheckBoxSimpleCode(ll_livingHabitsCode)); //生活习惯及注意事项
        tuberculosis.setCloseContactCheckCode(getCheckBoxSimpleCode(ll_closeContactCheckCode)); //密切接触者检查
        tuberculosis.setNextFollowupDate(tv_nextFollowupDate.getDate());//下次随访时间
        Emp emp = (Emp) sp_followupDoctorId.getSelectedItem();
        tuberculosis.setFollowupDoctorId(emp.getEmp_id());
        tuberculosis.setFollowupDoctorName(emp.getEmp_name());//评估医生签名


        return true;
    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name); //姓名
        tv_followupDate = (FuTextView) mFuView.findViewById(R.id.tv_followupDate); //随访日期
        tv_followupDate.setOnClickListener(this);
        ll_followupWayCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupWayCode); //随访方式
        ll_patientTypeCode = (LinearLayout) mFuView.findViewById(R.id.ll_patientTypeCode); //患者类型
        ll_sputumCode = (LinearLayout) mFuView.findViewById(R.id.ll_sputumCode); //痰菌情况
        ll_drugResistanceCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugResistanceCode); //耐药情况
        ll_zhengZhuang = (LinearLayout) mFuView.findViewById(R.id.ll_zhengZhuang); //症状及体征
        et_chemotherapyCode = (FuEditText) mFuView.findViewById(R.id.et_chemotherapyCode); //化疗方案
        ll_drugUseCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugUseCode); //用法
        ll_yaoji = (LinearLayout) mFuView.findViewById(R.id.ll_yaoji); //药品剂型
        ll_supervisorKindCode = (LinearLayout) mFuView.findViewById(R.id.ll_supervisorKindCode); //督导人员选择
        ll_separateRoomCode = (LinearLayout) mFuView.findViewById(R.id.ll_separateRoomCode); //单独的居室
        ll_ventilationCode = (LinearLayout) mFuView.findViewById(R.id.ll_ventilationCode); //通风情况
        et_dailySmoking = (FuEditText) mFuView.findViewById(R.id.et_dailySmoking); //吸烟
        et_aimDailySmoking = (FuEditText) mFuView.findViewById(R.id.et_aimDailySmoking); //吸烟
        et_dailyDrinking = (FuEditText) mFuView.findViewById(R.id.et_dailyDrinking); //饮酒
        et_aimDailyDrinking = (FuEditText) mFuView.findViewById(R.id.et_aimDailyDrinking); //饮酒
        et_getMedicinePlace = (FuEditText) mFuView.findViewById(R.id.et_getMedicinePlace); //取药地点
        tv_getMedicineDate = (FuTextView) mFuView.findViewById(R.id.tv_getMedicineDate); //取药时间
        tv_getMedicineDate.setOnClickListener(this);
        ll_medicationRecCardCode = (LinearLayout) mFuView.findViewById(R.id.ll_medicationRecCardCode); //服药记录卡填写
        ll_drugLimitCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugLimitCode); //服药方法及存放
        ll_treatmentCourseCode = (LinearLayout) mFuView.findViewById(R.id.ll_treatmentCourseCode); //肺结核治疗疗程
        ll_irregularMedicationCode = (LinearLayout) mFuView.findViewById(R.id.ll_irregularMedicationCode); //不规律服药危害
        ll_artCode = (LinearLayout) mFuView.findViewById(R.id.ll_artCode); //服药后不良反应及处理
        ll_treatmentSputumCode = (LinearLayout) mFuView.findViewById(R.id.ll_treatmentSputumCode); //治疗期间复诊查痰
        ll_adhereMedicationCode = (LinearLayout) mFuView.findViewById(R.id.ll_adhereMedicationCode); //外出期间如何坚持服药
        ll_livingHabitsCode = (LinearLayout) mFuView.findViewById(R.id.ll_livingHabitsCode); //生活习惯及注意事项
        ll_closeContactCheckCode = (LinearLayout) mFuView.findViewById(R.id.ll_closeContactCheckCode); //密切接触者检查
        tv_nextFollowupDate = (FuTextView) mFuView.findViewById(R.id.tv_nextFollowupDate); //下次随访时间
        tv_nextFollowupDate.setOnClickListener(this);
        sp_followupDoctorId = (Spinner) mFuView.findViewById(R.id.sp_followupDoctorId); //评估医生签名

    }
}
