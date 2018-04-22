package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.Constant;
import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.SickMedicine;
import net.greatsoft.main.db.po.SpinnerItem;
import net.greatsoft.main.db.po.smi.SmiFollowup;
import net.greatsoft.main.db.po.smi.SmiFollowupDrug;
import net.greatsoft.main.fragment.FuSmiFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuCheckBox;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuListView;
import net.greatsoft.main.view.FuRadioButton;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 2016/11/26.
 * 重性精神病
 */

public class FuSmiView extends FuUiFrameModel implements View.OnClickListener {

    FuEditText et_name; //姓名
    FuEditText et_followupDate; //随访日期
    LinearLayout ll_isMiss; //是否失访
    LinearLayout ll_visitType; //随访类型
    LinearLayout ll_riskLevelCode; //危险性
    LinearLayout ll_zhengZhuang; //目前症状
    LinearLayout ll_selfRecogEvalCode; //自知力
    LinearLayout ll_sleepQualityCode; //睡眠情况
    LinearLayout ll_dietQualityCode; //饮食情况
    LinearLayout ll_liveQualityCode; //个人生活料理
    LinearLayout ll_houseworkQualityCode; //家务劳动
    LinearLayout ll_workQualityCode; //生产劳动及工作
    LinearLayout ll_studyQualityCode; //学习能力
    LinearLayout ll_contactQualityCode; //社会人际交往
    FuCheckBox input_check1; //无
    FuCheckBox cb_lowRandalieren; //轻度滋事
    FuEditText et_lowRandalierenTimes; //轻度滋事
    FuCheckBox cb_causeTrouble; //肇事
    FuEditText et_causeTroubleTimes; //肇事
    FuCheckBox cb_accident; //肇祸
    FuEditText et_accidentTimes; //肇祸
    FuCheckBox cb_autolesion; //自伤
    FuEditText et_autolesionTimes; //自伤
    FuCheckBox cb_incompleteSuicide; //自杀未遂
    FuEditText et_incompleteSuicideTimes; //自杀未遂
    LinearLayout ll_lockCode; //关锁情况
    LinearLayout ll_followupInhosCode; //住院情况
    FuRadioButton input_radioBtn0; //从未住院
    FuRadioButton input_radioBtn1; //目前正在住院
    FuRadioButton input_radioBtn2; //既往住院,现未住院
    FuEditText et_outpatientDate; //末次出院时间
    LinearLayout ll_labExamCode; //实验室检查
    LinearLayout ll_drugComplianceCode; //服药依从性
    LinearLayout ll_drugAdverseCode; //药物不良反应
    LinearLayout ll_treatmentEffectCode; //治疗效果
    LinearLayout ll_isReferralCode; //是否转诊
    FuEditText et_referralReason; //转诊原因
    FuEditText et_refertoOrgName; //转诊至机构及科室
    LinearLayout layout_kangFuCuoShi; //康复措施
    LinearLayout ll_followupClassifyCode; //本次随访分类
    FuButton btn_medicine_save; //添加
    FuButton btn_medicine_save1; //添加

    List<SmiFollowupDrug> mDrugList;
    List<SmiFollowupDrug> mDrugList1;
    SmiAdapter mSmiAdapter;
    SmiAdapter1 mSmiAdapter1;

    Spinner sp_drugName, sp_drugName1; //药物名称
    Spinner sp_drugUsingFreq, sp_drugUsingFreq1; //用法
    FuEditText et_drugPerDose, et_drugPerDose1; //每次剂量
    Spinner sp_unit, sp_unit1; //单位
    FuListView lv_smiFU, lv_smiFU1; //展示药物，剂量，用法

    FuEditText et_nextFollowupDate; //下次随访日期
    Spinner sp_followupDoctorId; //随访医生签名


    LinearLayout ll_visitFormal; //本次随访形式
    LinearLayout ll_visitReasonCode; //失访原因
    LinearLayout ll_isDeath; //是否死亡
    FuEditText et_deathDate; //死亡日期

    LinearLayout ll_deathReasonBig; //死亡原因
    LinearLayout ll_deathReasonSmall; //死亡原因

    TextView fu_title_center;
    Button fu_title_right_btn;
    SmiFollowup mSmiFollowup;//为了保存用药


    public FuSmiView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_smi_view, null);
        mDrugList = new ArrayList<>();
        mDrugList1 = new ArrayList<>();
    }

    public void setMedicine(List<SickMedicine> sickMedicineList) {
//药物名称
        List<SpinnerItem> spinnerItems;
        spinnerItems = new ArrayList<>();
        for (int i = 0; i < sickMedicineList.size(); i++) {
            SpinnerItem spinnerItem = new SpinnerItem(sickMedicineList.get(i).getSickMedicineId(), sickMedicineList.get(i).getName());
            spinnerItems.add(spinnerItem);
        }
        ArrayAdapter<?> adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<?> adapter1 = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                spinnerItems);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_drugName.setAdapter(adapter);
        sp_drugName1.setAdapter(adapter1);
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

        //药物名称
//        List<SpinnerItem> spinnerItems = sqlHelper.getSpinnerItemBySickCode("3");
//
//        adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
//                spinnerItems);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        sp_drugName.setAdapter(adapter);

        //用法
        List<Checks> num = Constant.getMedicineNum();
        ArrayAdapter<?> adapter2 = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                num);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_drugUsingFreq.setAdapter(adapter2);
        sp_drugUsingFreq1.setAdapter(adapter2);

        //单位
        List<Checks> unit = Constant.getMedicineUnit();
        ArrayAdapter<?> adapter3 = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                unit);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_unit.setAdapter(adapter3);
        sp_unit1.setAdapter(adapter3);

        initCheckBoxSimple("IS_MISS_ID", ll_isMiss, 0); //是否失访
        initCheckBoxSimple("visitType", ll_visitType, 0); //随访类型
        initCheckBoxSimple("DANGEROUS_LEVER", ll_riskLevelCode, 0); //危险性

        initCheckBoxMany("smiSymptom", ll_zhengZhuang, 4, false, true); //目前症状

        initCheckBoxSimple("INSIGHT", ll_selfRecogEvalCode, 0); //自知力
        initCheckBoxSimple("SLEEP", ll_sleepQualityCode, 0); //睡眠情况
        initCheckBoxSimple("DIET", ll_dietQualityCode, 0);  //饮食情况
        initCheckBoxSimple("LIVE", ll_liveQualityCode, 0);  //个人生活料理
        initCheckBoxSimple("HOUSEWORK", ll_houseworkQualityCode, 0); //家务劳动
        initCheckBoxSimple("WORK", ll_workQualityCode, 0); //生产劳动及工作
        initCheckBoxSimple("STUDYABILITY", ll_studyQualityCode, 0); //学习能力
        initCheckBoxSimple("SOCIAL_CUMMUNICATION", ll_contactQualityCode, 0); //社会人际交往
        initCheckBoxSimple("LOCK_SITUATION", ll_lockCode, 0); //关锁情况
        initCheckBoxSimple("LABCHECK", ll_labExamCode, true);  //实验室检查
        initCheckBoxSimple("smidrugComplianceCode", ll_drugComplianceCode, 0);  //服药依从性
        initCheckBoxSimple("CHOKECODE", ll_drugAdverseCode, true);  //药物不良反应
        initCheckBoxSimple("treatmentEffectCode", ll_treatmentEffectCode, 0);  //治疗效果
        initCheckBoxSimple("YES_NO_CODE", ll_isReferralCode, 0);  //是否转诊
        initCheckBoxMany("rehabilitation", layout_kangFuCuoShi, 3, false, true); //康复措施
        initCheckBoxSimple("CONTOL_FEEDBACK", ll_followupClassifyCode, 0); //本次随访分类
        initCheckBoxSimple("visitFormal", ll_visitFormal, 0);  //本次随访形式
        initCheckBoxSimple("visitReasonCode", ll_visitReasonCode, 3);  //失访原因
        initCheckBoxSimple("IS_MISS_ID", ll_isDeath, 0); //是否死亡
        initCheckBoxSimple("deathReasonBig", ll_deathReasonBig, 3); //死亡原因
        initCheckBoxSimple("deathReasonSmall", ll_deathReasonSmall, 3); //死亡原因

    }

    @Override
    protected void initWidget() {

        findView();

        mSmiAdapter = new SmiAdapter();
        mSmiAdapter1 = new SmiAdapter1();
        lv_smiFU.setAdapter(mSmiAdapter);
        lv_smiFU1.setAdapter(mSmiAdapter1);

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("重性精神病患者随访");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    public void setData(SmiFollowup smiFollowup) {
        if (smiFollowup == null) {
            return;
        }
        mSmiFollowup = smiFollowup;
        et_name.setText(smiFollowup.getName());
        et_followupDate.setText(smiFollowup.getFollowupDate());
        setCheckBoxSelect(smiFollowup.getIsMiss(), ll_isMiss);
        setCheckBoxSelect(smiFollowup.getRiskLevelCode(), ll_riskLevelCode);
        setCheckBoxSelect("smiSymptom", smiFollowup.getRecordChoice(), ll_zhengZhuang);
        setCheckBoxSelect(smiFollowup.getSelfRecogEvalCode(), ll_selfRecogEvalCode);
        setCheckBoxSelect(smiFollowup.getSleepQualityCode(), ll_sleepQualityCode);
        setCheckBoxSelect(smiFollowup.getDietQualityCode(), ll_dietQualityCode);
        setCheckBoxSelect(smiFollowup.getLiveQualityCode(), ll_liveQualityCode);
        setCheckBoxSelect(smiFollowup.getHouseworkQualityCode(), ll_houseworkQualityCode);
        setCheckBoxSelect(smiFollowup.getWorkQualityCode(), ll_workQualityCode);
        setCheckBoxSelect(smiFollowup.getStudyQualityCode(), ll_studyQualityCode);
        setCheckBoxSelect(smiFollowup.getContactQualityCode(), ll_contactQualityCode);
        setCheckBoxSelect(smiFollowup.getLockCode(), ll_lockCode);
        if (smiFollowup.getLowRandalieren() != null && smiFollowup.getLowRandalieren().equals("1")) {
            cb_lowRandalieren.setChecked(true);
        }
        et_lowRandalierenTimes.setText(smiFollowup.getLowRandalierenTimes());
        if (smiFollowup.getCauseTrouble() != null && smiFollowup.getCauseTrouble().equals("1")) {
            cb_causeTrouble.setChecked(true);
        }
        et_causeTroubleTimes.setText(smiFollowup.getCauseTroubleTimes());
        if (smiFollowup.getAccident() != null && smiFollowup.getAccident().equals("1")) {
            cb_accident.setChecked(true);
        }
        et_accidentTimes.setText(smiFollowup.getAccidentTimes());
        if (smiFollowup.getAutolesion() != null && smiFollowup.getAutolesion().equals("1")) {
            cb_autolesion.setChecked(true);
        }
        et_autolesionTimes.setText(smiFollowup.getAccidentTimes());
        if (smiFollowup.getIncompleteSuicide() != null && smiFollowup.getIncompleteSuicide().equals("1")) {
            cb_incompleteSuicide.setChecked(true);
        }
        et_incompleteSuicideTimes.setText(smiFollowup.getIncompleteSuicideTimes());
        if (smiFollowup.getFollowupInhosCode() != null && smiFollowup.getFollowupInhosCode().equals("0")) {
            input_radioBtn0.setChecked(true);
        } else if (smiFollowup.getFollowupInhosCode() != null && smiFollowup.getFollowupInhosCode().equals("1")) {
            input_radioBtn1.setChecked(true);
        } else if (smiFollowup.getFollowupInhosCode() != null && smiFollowup.getFollowupInhosCode().equals("2")) {
            input_radioBtn2.setChecked(true);
        }
        et_outpatientDate.setText(smiFollowup.getOutpatientDate());
        setCheckBoxSelect(smiFollowup.getLabExamCode(), ll_labExamCode);
        setCheckBoxSelect(smiFollowup.getDrugComplianceCode(), ll_drugComplianceCode);
        setCheckBoxSelect(smiFollowup.getDrugAdverseCode(), ll_drugAdverseCode);
        setCheckBoxSelect(smiFollowup.getTreatmentEffectCode(), ll_treatmentEffectCode);
        setCheckBoxSelect(smiFollowup.getIsReferralCode(), ll_isReferralCode);
        et_referralReason.setText(smiFollowup.getReferralReason());
        et_refertoOrgName.setText(smiFollowup.getRefertoOrgName());

//        setCheckBoxSelect("RECOVER_GUIDE",smiFollowup.getSmiFollowupId(),layout_kangFuCuoShi);
        setCheckBoxSelect("RECOVER_GUIDE", smiFollowup.getRecordChoice(), layout_kangFuCuoShi);

        setCheckBoxSelect(smiFollowup.getFollowupClassifyCode(), ll_followupClassifyCode);

        mDrugList = smiFollowup.getSmiFollowupDrug();

        mSmiAdapter.notifyDataSetChanged();

        et_nextFollowupDate.setText(smiFollowup.getNextFollowupDate());
        setSpinnerSelected("3", smiFollowup.getFollowupDoctorId(), sp_followupDoctorId);

    }

    public boolean saveData(SmiFollowup smiFollowup) {

        if ("".equals(et_followupDate.getString())) {
            ToastUtil.showToast(mContext, "请输入随访日期", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_isMiss))) {
            ToastUtil.showToast(mContext, "请选择是否失访", Toast.LENGTH_LONG);
            return false;
        } else if ("1".equals(getCheckBoxSimpleCode(ll_isMiss))) {
            if ("".equals(getCheckBoxSimpleCode(ll_visitReasonCode))) {
                ToastUtil.showToast(mContext, "请选择失访原因", Toast.LENGTH_LONG);
                return false;
            }
        }

        if ("".equals(getCheckBoxSimpleCode(ll_isDeath))) {
            ToastUtil.showToast(mContext, "请选择是否死亡", Toast.LENGTH_LONG);
            return false;
        } else if ("1".equals(getCheckBoxSimpleCode(ll_isDeath))) {
            if ("".equals(et_deathDate.getString())) {
                ToastUtil.showToast(mContext, "请输入死亡日期", Toast.LENGTH_LONG);
                return false;
            }
            if ("".equals(getCheckBoxSimpleCode(ll_deathReasonBig))) {
                ToastUtil.showToast(mContext, "请选择死亡原因", Toast.LENGTH_LONG);
                return false;
            }
        }


        if ("".equals(getCheckBoxSimpleCode(ll_visitType))) {
            ToastUtil.showToast(mContext, "请选择随访类型", Toast.LENGTH_LONG);
            return false;
        }

        boolean flag = true;
        saveCheckBoxMany(null, smiFollowup.getRecordChoice(), ll_zhengZhuang); //目前症状
        List<RecordChoice> choice = smiFollowup.getRecordChoice();//目前症状
        for (int i = 0; i < choice.size(); i++) {
            if ("smiSymptom".equals(choice.get(i).getCodeType())) {
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择目前症状", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_selfRecogEvalCode))) {
            ToastUtil.showToast(mContext, "请选择自知力", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_sleepQualityCode))) {
            ToastUtil.showToast(mContext, "请选择睡眠情况", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_dietQualityCode))) {
            ToastUtil.showToast(mContext, "请选择饮食情况", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_liveQualityCode))) {
            ToastUtil.showToast(mContext, "请选择个人生活料理", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_houseworkQualityCode))) {
            ToastUtil.showToast(mContext, "请选择家务劳动", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_workQualityCode))) {
            ToastUtil.showToast(mContext, "请选择生产劳动及工作", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_studyQualityCode))) {
            ToastUtil.showToast(mContext, "请选择学习能力", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_contactQualityCode))) {
            ToastUtil.showToast(mContext, "请选择社会人际交往", Toast.LENGTH_LONG);
            return false;
        }
        flag = true;
        saveCheckBoxMany(null, smiFollowup.getRecordChoice(), layout_kangFuCuoShi);   //康复措施
        choice = smiFollowup.getRecordChoice();//目前症状
        for (int i = 0; i < choice.size(); i++) {
            if ("rehabilitation".equals(choice.get(i).getCodeType())) {
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择目前康复措施", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_followupClassifyCode))) {
            ToastUtil.showToast(mContext, "请选择本次随访分类", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_nextFollowupDate.getString())) {
            ToastUtil.showToast(mContext, "请输入下次随访日期", Toast.LENGTH_LONG);
            return false;
        }

        smiFollowup.setName(et_name.getString());   //姓名
        smiFollowup.setFollowupDate(et_followupDate.getDate());  //随访日期
        smiFollowup.setDeathDate(et_deathDate.getDate());//死亡日期
        smiFollowup.setDeathReasonBig(getCheckBoxSimpleCode(ll_deathReasonBig));//死亡原因
        smiFollowup.setDeathReasonSmall(getCheckBoxSimpleCode(ll_deathReasonSmall));//死亡原因
        smiFollowup.setVisitFormal(getCheckBoxSimpleCode(ll_visitFormal)); //随访形式
        smiFollowup.setIsMiss(getCheckBoxSimpleCode(ll_isMiss)); //是否失访
        smiFollowup.setIsDeath(getCheckBoxSimpleCode(ll_isDeath)); //是否失访
        smiFollowup.setVisitReasonCode(getCheckBoxSimpleCode(ll_visitReasonCode)); //失访原因
        smiFollowup.setVisitType(getCheckBoxSimpleCode(ll_visitType));//随访类型
        smiFollowup.setRiskLevelCode(getCheckBoxSimpleCode(ll_riskLevelCode)); //危险性
        smiFollowup.setSelfRecogEvalCode(getCheckBoxSimpleCode(ll_selfRecogEvalCode));         //自知力
        smiFollowup.setSleepQualityCode(getCheckBoxSimpleCode(ll_sleepQualityCode));     //睡眠情况
        smiFollowup.setDietQualityCode(getCheckBoxSimpleCode(ll_dietQualityCode));    //饮食情况
        smiFollowup.setLiveQualityCode(getCheckBoxSimpleCode(ll_liveQualityCode));     //个人生活料理
        smiFollowup.setHouseworkQualityCode(getCheckBoxSimpleCode(ll_houseworkQualityCode));                //家务劳动
        smiFollowup.setWorkQualityCode(getCheckBoxSimpleCode(ll_workQualityCode));   //生产劳动及工作
        smiFollowup.setStudyQualityCode(getCheckBoxSimpleCode(ll_studyQualityCode));        //学习能力
        smiFollowup.setContactQualityCode(getCheckBoxSimpleCode(ll_contactQualityCode));        //社会人际交往
        smiFollowup.setLowRandalieren(cb_lowRandalieren.isChecked() ? "1" : "0");  //轻度滋事
        smiFollowup.setLowRandalierenTimes(et_lowRandalierenTimes.getInt());  //轻度滋事
        smiFollowup.setCauseTrouble(cb_causeTrouble.isChecked() ? "1" : "0");//肇事
        smiFollowup.setCauseTroubleTimes(et_causeTroubleTimes.getInt());      //肇事
        smiFollowup.setAccident(cb_accident.isChecked() ? "1" : "0");  //肇祸
        smiFollowup.setAccidentTimes(et_accidentTimes.getInt());    //肇祸
        smiFollowup.setAutolesion(cb_autolesion.isChecked() ? "1" : "0");     //自伤
        smiFollowup.setAutolesionTimes(et_autolesionTimes.getInt());            //自伤
        smiFollowup.setIncompleteSuicide(cb_incompleteSuicide.isChecked() ? "1" : "0");   //自杀未遂
        smiFollowup.setIncompleteSuicideTimes(et_incompleteSuicideTimes.getInt());  //自杀未遂
        smiFollowup.setLockCode(getCheckBoxSimpleCode(ll_lockCode));
        if (input_radioBtn0.isChecked()) {
            smiFollowup.setFollowupInhosCode(input_radioBtn0.getTag().toString());//从未住院
        } else if (input_radioBtn1.isChecked()) {
            smiFollowup.setFollowupInhosCode(input_radioBtn1.getTag().toString());//目前正在住院
        } else if (input_radioBtn2.isChecked()) {
            smiFollowup.setFollowupInhosCode(input_radioBtn2.getTag().toString());//既往住院,现未住院
        } else {
            smiFollowup.setFollowupInhosCode(null);
        }
        smiFollowup.setOutpatientDate(et_outpatientDate.getDate());    //末次出院时间
        smiFollowup.setLabExamCode(getCheckBoxSimpleCode(ll_labExamCode));   //实验室检查
        smiFollowup.setLabExamResultDesc(getString(ll_labExamCode));
        smiFollowup.setDrugComplianceCode(getCheckBoxSimpleCode(ll_drugComplianceCode));  //服药依从性
        smiFollowup.setDrugAdverseCode(getCheckBoxSimpleCode(ll_drugAdverseCode));//药物不良反应
        smiFollowup.setDrugAdverseDesc(getString(ll_drugAdverseCode));
        smiFollowup.setTreatmentEffectCode(getCheckBoxSimpleCode(ll_treatmentEffectCode));   //治疗效果
        smiFollowup.setIsReferralCode(getCheckBoxSimpleCode(ll_isReferralCode));  //是否转诊
        smiFollowup.setReferralReason(et_referralReason.getString());  //转诊原因
        smiFollowup.setRefertoDeptName(et_refertoOrgName.getString());  //转诊至机构及科室
        smiFollowup.setFollowupClassifyCode(getCheckBoxSimpleCode(ll_followupClassifyCode));    //本次随访分类

        smiFollowup.setSmiFollowupDrug(mDrugList);
        smiFollowup.getSmiFollowupDrug().addAll(mDrugList1);

        smiFollowup.setNextFollowupDate(et_nextFollowupDate.getDate());//下次随访日期

        Emp emp = (Emp) sp_followupDoctorId.getSelectedItem();              //责任医生
        smiFollowup.setFollowupDoctorId(emp.getEmp_id());
        smiFollowup.setFollowupDoctorName(emp.getEmp_name());

//        Checks checks = (Checks) sp_followupDoctorId.getSelectedItem();
//        hyperFU.setFollowupDoctorName(checks.getCode()); //随访医生签名

        return true;
    }

    private void findView() {

        et_name = (FuEditText) mFuView.findViewById(R.id.et_name);   //姓名
        et_followupDate = (FuEditText) mFuView.findViewById(R.id.et_followupDate);  //随访日期
        et_followupDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FuContentActivity) mContext).showTimeDialog(et_followupDate)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
            }
        });
        ll_isMiss = (LinearLayout) mFuView.findViewById(R.id.ll_isMiss);    //是否失访
        ll_visitType = (LinearLayout) mFuView.findViewById(R.id.ll_visitType); //随访类型
        ll_riskLevelCode = (LinearLayout) mFuView.findViewById(R.id.ll_riskLevelCode); //危险性
        ll_zhengZhuang = (LinearLayout) mFuView.findViewById(R.id.ll_zhengZhuang);    //目前症状
        ll_selfRecogEvalCode = (LinearLayout) mFuView.findViewById(R.id.ll_selfRecogEvalCode);   //自知力
        ll_sleepQualityCode = (LinearLayout) mFuView.findViewById(R.id.ll_sleepQualityCode); //睡眠情况
        ll_dietQualityCode = (LinearLayout) mFuView.findViewById(R.id.ll_dietQualityCode);  //饮食情况
        ll_liveQualityCode = (LinearLayout) mFuView.findViewById(R.id.ll_liveQualityCode);    //个人生活料理
        ll_houseworkQualityCode = (LinearLayout) mFuView.findViewById(R.id.ll_houseworkQualityCode);    //家务劳动
        ll_workQualityCode = (LinearLayout) mFuView.findViewById(R.id.ll_workQualityCode);   //生产劳动及工作
        ll_studyQualityCode = (LinearLayout) mFuView.findViewById(R.id.ll_studyQualityCode);  //学习能力
        ll_contactQualityCode = (LinearLayout) mFuView.findViewById(R.id.ll_contactQualityCode);   //社会人际交往
        input_check1 = (FuCheckBox) mFuView.findViewById(R.id.input_check1);     //无
        cb_lowRandalieren = (FuCheckBox) mFuView.findViewById(R.id.cb_lowRandalieren);    //轻度滋事
        et_lowRandalierenTimes = (FuEditText) mFuView.findViewById(R.id.et_lowRandalierenTimes);    //轻度滋事
        cb_causeTrouble = (FuCheckBox) mFuView.findViewById(R.id.cb_causeTrouble);   //肇事
        et_causeTroubleTimes = (FuEditText) mFuView.findViewById(R.id.et_causeTroubleTimes);    //肇事
        cb_accident = (FuCheckBox) mFuView.findViewById(R.id.cb_accident);    //肇祸
        et_accidentTimes = (FuEditText) mFuView.findViewById(R.id.et_accidentTimes);   //肇祸
        cb_autolesion = (FuCheckBox) mFuView.findViewById(R.id.cb_autolesion);    //自伤
        et_autolesionTimes = (FuEditText) mFuView.findViewById(R.id.et_autolesionTimes);   //自伤
        cb_incompleteSuicide = (FuCheckBox) mFuView.findViewById(R.id.cb_incompleteSuicide);   //自杀未遂
        et_incompleteSuicideTimes = (FuEditText) mFuView.findViewById(R.id.et_incompleteSuicideTimes);  //自杀未遂
        ll_lockCode = (LinearLayout) mFuView.findViewById(R.id.ll_lockCode);     //关锁情况
        ll_followupInhosCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupInhosCode);    //住院情况
        input_radioBtn0 = (FuRadioButton) mFuView.findViewById(R.id.input_radioBtn0); //从未住院
        input_radioBtn1 = (FuRadioButton) mFuView.findViewById(R.id.input_radioBtn1); //目前正在住院
        input_radioBtn2 = (FuRadioButton) mFuView.findViewById(R.id.input_radioBtn2); //既往住院,现未住院
        et_outpatientDate = (FuEditText) mFuView.findViewById(R.id.et_outpatientDate); //末次出院时间
        et_outpatientDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FuContentActivity) mContext).showTimeDialog(et_outpatientDate)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
            }
        });
        ll_labExamCode = (LinearLayout) mFuView.findViewById(R.id.ll_labExamCode);    //实验室检查
        ll_drugComplianceCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugComplianceCode);  //服药依从性
        ll_drugAdverseCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugAdverseCode);  //药物不良反应
        ll_treatmentEffectCode = (LinearLayout) mFuView.findViewById(R.id.ll_treatmentEffectCode);  //治疗效果
        ll_isReferralCode = (LinearLayout) mFuView.findViewById(R.id.ll_isReferralCode);   //是否转诊
        et_referralReason = (FuEditText) mFuView.findViewById(R.id.et_referralReason);  //转诊原因
        et_refertoOrgName = (FuEditText) mFuView.findViewById(R.id.et_refertoOrgName);    //转诊至机构及科室
        layout_kangFuCuoShi = (LinearLayout) mFuView.findViewById(R.id.layout_kangFuCuoShi);//康复措施
        ll_followupClassifyCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupClassifyCode); //本次随访分类
        btn_medicine_save = (FuButton) mFuView.findViewById(R.id.btn_medicine_save); //添加
        btn_medicine_save.setOnClickListener(this);
        btn_medicine_save1 = (FuButton) mFuView.findViewById(R.id.btn_medicine_save1); //添加
        btn_medicine_save1.setOnClickListener(this);
        sp_drugName = (Spinner) mFuView.findViewById(R.id.sp_drugName); //药物名称
        sp_drugName1 = (Spinner) mFuView.findViewById(R.id.sp_drugName1); //药物名称
        sp_drugUsingFreq = (Spinner) mFuView.findViewById(R.id.sp_drugUsingFreq); //用法
        sp_drugUsingFreq1 = (Spinner) mFuView.findViewById(R.id.sp_drugUsingFreq1); //用法
        et_drugPerDose = (FuEditText) mFuView.findViewById(R.id.et_drugPerDose); //每次剂量
        et_drugPerDose1 = (FuEditText) mFuView.findViewById(R.id.et_drugPerDose1); //每次剂量
        sp_unit = (Spinner) mFuView.findViewById(R.id.sp_unit); //单位
        sp_unit1 = (Spinner) mFuView.findViewById(R.id.sp_unit1); //单位
        lv_smiFU = (FuListView) mFuView.findViewById(R.id.lv_smiFU); //展示药物，剂量，用法
        lv_smiFU1 = (FuListView) mFuView.findViewById(R.id.lv_smiFU1); //展示药物，剂量，用法
        et_nextFollowupDate = (FuEditText) mFuView.findViewById(R.id.et_nextFollowupDate); //下次随访日期
        et_nextFollowupDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FuContentActivity) mContext).showTimeDialog(et_nextFollowupDate)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
            }
        });
        sp_followupDoctorId = (Spinner) mFuView.findViewById(R.id.sp_followupDoctorName); //随访医生签名

        ll_visitFormal = (LinearLayout) mFuView.findViewById(R.id.ll_visitFormal); //本次随访形式
        ll_visitReasonCode = (LinearLayout) mFuView.findViewById(R.id.ll_visitReasonCode); //失访原因
        ll_isDeath = (LinearLayout) mFuView.findViewById(R.id.ll_isDeath); //是否死亡
        et_deathDate = (FuEditText) mFuView.findViewById(R.id.et_deathDate); //死亡日期
        et_deathDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FuContentActivity) mContext).showTimeDialog(et_deathDate)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
            }
        });
        ll_deathReasonBig = (LinearLayout) mFuView.findViewById(R.id.ll_deathReasonBig); //死亡原因
        ll_deathReasonSmall = (LinearLayout) mFuView.findViewById(R.id.ll_deathReasonSmall); //死亡原因

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_medicine_save:
                SpinnerItem selectedItem = (SpinnerItem) sp_drugName.getSelectedItem();
                SmiFollowupDrug smiFollowupDrug = new SmiFollowupDrug();
                smiFollowupDrug.setDrugId(selectedItem.getId());
//                smiFollowupDrug.setSmiFollowupId(mSmiFollowup.getSmiFollowupId());
                smiFollowupDrug.setDrugName(selectedItem.getValue());//药物名称
                Checks checks = (Checks) sp_drugUsingFreq.getSelectedItem();
                smiFollowupDrug.setDrugUsingFreq(checks.getCode()); //用法
                smiFollowupDrug.setDrugPerDose(et_drugPerDose.getString()); //每次剂量
                Checks checkUnit = (Checks) sp_unit.getSelectedItem();
//                smiFollowupDrug.setDrugPerDose(checkUnit.getCode());//单位
                smiFollowupDrug.setUnit(checkUnit.getValue());
                smiFollowupDrug.setDrugType("1");
                mDrugList.add(smiFollowupDrug);
                mSmiAdapter.notifyDataSetChanged();
                et_drugPerDose.setText("");
                break;
            case R.id.btn_medicine_save1:
                SpinnerItem selectedItem1 = (SpinnerItem) sp_drugName1.getSelectedItem();
                SmiFollowupDrug smiFollowupDrug1 = new SmiFollowupDrug();
                smiFollowupDrug1.setDrugId(selectedItem1.getId());
//                smiFollowupDrug.setSmiFollowupId(mSmiFollowup.getSmiFollowupId());
                smiFollowupDrug1.setDrugName(selectedItem1.getValue());//药物名称
                Checks checks1 = (Checks) sp_drugUsingFreq1.getSelectedItem();
                smiFollowupDrug1.setDrugUsingFreq(checks1.getCode()); //用法
                smiFollowupDrug1.setDrugPerDose(et_drugPerDose1.getString()); //每次剂量
                Checks checkUnit1 = (Checks) sp_unit1.getSelectedItem();
//                smiFollowupDrug.setDrugPerDose(checkUnit.getCode());//单位
                smiFollowupDrug1.setUnit(checkUnit1.getValue());
                smiFollowupDrug1.setDrugType("2");
                mDrugList1.add(smiFollowupDrug1);
                mSmiAdapter1.notifyDataSetChanged();
                et_drugPerDose1.setText("");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuSmiFragment.EVENT_SAVE_SMI, null);
                break;
        }
    }

    class SmiAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public SmiAdapter() {
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return mDrugList == null ? 0 : mDrugList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            SmiHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fu_medicine_item, null);
                holder = new SmiHolder();
                holder.tv_name = (FuTextView) convertView.findViewById(R.id.tv_name);
                holder.tv_num = (FuTextView) convertView.findViewById(R.id.tv_num);
                holder.tv_dose = (FuTextView) convertView.findViewById(R.id.tv_dose);
                holder.tv_delete = (FuTextView) convertView.findViewById(R.id.tv_delete);
                convertView.setTag(holder);
            } else {
                holder = (SmiHolder) convertView.getTag();
            }
            holder.tv_name.setText(mDrugList.get(position).getDrugName());
            holder.tv_num.setText(mDrugList.get(position).getDrugUsingFreq());
            holder.tv_dose.setText(mDrugList.get(position).getDrugPerDose() + mDrugList.get(position).getUnit());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setTag(mDrugList.get(position));
            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrugList.remove(position);
                    mSmiAdapter.notifyDataSetChanged();
                }
            });

            return convertView;
        }

        class SmiHolder {

            FuTextView tv_name; //药物名称
            FuTextView tv_num; //每日次数
            FuTextView tv_dose;//每次剂量
            FuTextView tv_delete;
        }
    }

    class SmiAdapter1 extends BaseAdapter {

        private LayoutInflater mInflater;

        public SmiAdapter1() {
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return mDrugList1 == null ? 0 : mDrugList1.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            SmiHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fu_medicine_item, null);
                holder = new SmiHolder();
                holder.tv_name = (FuTextView) convertView.findViewById(R.id.tv_name);
                holder.tv_num = (FuTextView) convertView.findViewById(R.id.tv_num);
                holder.tv_dose = (FuTextView) convertView.findViewById(R.id.tv_dose);
                holder.tv_delete = (FuTextView) convertView.findViewById(R.id.tv_delete);
                convertView.setTag(holder);
            } else {
                holder = (SmiHolder) convertView.getTag();
            }
            holder.tv_name.setText(mDrugList1.get(position).getDrugName());
            holder.tv_num.setText(mDrugList1.get(position).getDrugUsingFreq());
            holder.tv_dose.setText(mDrugList1.get(position).getDrugPerDose() + mDrugList1.get(position).getUnit());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setTag(mDrugList1.get(position));
            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrugList1.remove(position);
                    mSmiAdapter1.notifyDataSetChanged();
                }
            });

            return convertView;
        }

        class SmiHolder {

            FuTextView tv_name; //药物名称
            FuTextView tv_num; //每日次数
            FuTextView tv_dose;//每次剂量
            FuTextView tv_delete;
        }
    }
}
