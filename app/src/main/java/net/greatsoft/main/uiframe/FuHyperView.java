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
import net.greatsoft.main.db.po.hyperinfo.HyperFollowup;
import net.greatsoft.main.db.po.hyperinfo.HyperFollowupDrug;
import net.greatsoft.main.fragment.FuHyperFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuListView;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 2016/11/26.
 * 高血压随访
 */

public class FuHyperView extends FuUiFrameModel implements View.OnClickListener, View.OnFocusChangeListener {

    FuEditText et_name; //姓名
    FuEditText et_followupDate; //随访日期
    LinearLayout isMiss; //是否失访
    FuEditText missReason; //失访原因
    LinearLayout ll_followupWayCode; //随访方式
    LinearLayout ll_visitType; //随访类型
    LinearLayout ll_symptomCn; //症状
    FuEditText et_sbp; //血压 收缩压
    FuEditText et_dbp; //血压 舒张
    FuEditText et_weight; //体重
    FuEditText et_aimWeight; //目标体重
    FuEditText et_height; //身高
    FuEditText et_bmi; //体质指数 实际
    FuEditText et_aimBmi; //体质指数 目标
    FuEditText et_heartRate; //心率
    FuEditText et_otherPositiveSigns; //其他
    FuEditText et_dailySmoking; //日吸烟量
    FuEditText et_aimDailySmoking; //日吸烟量 目标
    FuEditText et_dailyDrinking; //日饮酒量
    FuEditText et_aimDailyDrinking; //日吸烟量 目标
    FuEditText et_exerciseDurationWeeks; //运动 次数
    FuEditText et_exerciseDurationMins; //运动 时间
    FuEditText et_aimDurationWeeks; //运动 目标次数
    FuEditText et_aimExerciseMins; //运动 目标时间
    LinearLayout ll_aimSalttakenLevelCode; //摄盐量
    LinearLayout ll_saltTakenLevelCode; //摄盐量
    LinearLayout ll_psyAdjustResultCode; //心理调整
    LinearLayout ll_complianceResultCode; //遵医行为
    FuEditText et_accessoryExam; //辅助检查
    LinearLayout ll_drugComplianceCode; //服药依从性
    LinearLayout ll_drugAdverseCode; //药物不良反应
    LinearLayout ll_followupClassifyCode; //此次随访分类
    FuEditText et_referralReason; //转诊原因
    FuEditText et_refertoOrgName; //机构及级别
    FuButton f_medicine_save; //添加

    HyperDrugAdapter mHyperDrugAdapter;

    Spinner sp_drugName; //药物名称
    Spinner sp_drugUsingFreq; //用法
    FuEditText et_drugPerDose; //每次剂量
    Spinner sp_unit; //单位
    FuListView lv_hyperFU; //展示药物名称，用法，每次剂量
    FuEditText et_nextFollowupDate; //下次随访日期
    Spinner sp_followupDoctorId; //随访医生签名

    TextView fu_title_center;
    Button fu_title_right_btn;
    HyperFollowup mHyperFollowup;//为了保存用药

    List<Emp> empList;

    public FuHyperView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_hyper_view, null);

    }

    @Override
    protected void initFuData() {


        //用法
        List<Checks> num = Constant.getMedicineNum();
        ArrayAdapter<?> adapter2 = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                num);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_drugUsingFreq.setAdapter(adapter2);
        //单位
        List<Checks> unit = Constant.getMedicineUnit();
        ArrayAdapter<?> adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                unit);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_unit.setAdapter(adapter);

        initCheckBoxSimple("IS_MISS_ID", isMiss, 0); //是否失访
        initCheckBoxSimple("VISITE_WAY", ll_followupWayCode, 0); //随访方式
        initCheckBoxSimple("visitType", ll_visitType, 0); //随访方式
        initCheckBoxMany("hyperSymptom", ll_symptomCn, 4, false, true); //症状
        initCheckBoxSimple("CHOKEDEGREE", ll_saltTakenLevelCode, 0); //摄盐量
        initCheckBoxSimple("CHOKEDEGREE", ll_aimSalttakenLevelCode, 0); //目标摄盐量
        initCheckBoxSimple("HEART_ADJUST", ll_psyAdjustResultCode, 0); //心理调整
        initCheckBoxSimple("FOLLOW_DOCTOR", ll_complianceResultCode, 0); //遵医行为
        initCheckBoxSimple("DRUG_COMPLIANCE", ll_drugComplianceCode, 0); //服药依从性
        initCheckBoxSimple("YES_NO_CODE", ll_drugAdverseCode, true); //药物不良反应
        initCheckBoxSimple("VISIT_ASSORT", ll_followupClassifyCode, 0); //此次随访分类


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
        sp_drugName.setAdapter(adapter);
    }

    @Override
    protected void initWidget() {

        findView();

        mHyperDrugAdapter = new HyperDrugAdapter();
        lv_hyperFU.setAdapter(mHyperDrugAdapter);


        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("高血压随访");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

        empList = sqlHelper.getAllEmpList();
        ArrayAdapter adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_followupDoctorId.setAdapter(adapter);
    }

    public void setData(HyperFollowup hyperFollowup, String personInfoName) {
        et_name.setText(personInfoName);

        if (hyperFollowup == null) {
            return;
        }
        mHyperFollowup = hyperFollowup;
//        et_name.setText(hyperFollowup.getName());

        et_followupDate.setText(hyperFollowup.getFollowupDate());
        setCheckBoxSelect(hyperFollowup.getIsMiss(), isMiss);
        missReason.setText(hyperFollowup.getMissReason());
        setCheckBoxSelect(hyperFollowup.getFollowupWayCode(), ll_followupWayCode);
        setCheckBoxSelect("hyperSymptom", hyperFollowup.getHyperFollowupId(), ll_symptomCn);//症状
        et_sbp.setText(hyperFollowup.getSbp());
        et_dbp.setText(hyperFollowup.getDbp());
        et_weight.setText(hyperFollowup.getWeight());
        et_aimWeight.setText(hyperFollowup.getAimWeight());
        et_height.setText(hyperFollowup.getHeight());
        et_bmi.setText(hyperFollowup.getBmi());
        et_aimBmi.setText(hyperFollowup.getAimBmi());
        et_heartRate.setText(hyperFollowup.getHeartRate());
        et_otherPositiveSigns.setText(hyperFollowup.getOtherPositiveSigns());
        et_dailySmoking.setText(hyperFollowup.getDailySmoking());
        et_aimDailySmoking.setText(hyperFollowup.getAimDailySmoking());
        et_dailyDrinking.setText(hyperFollowup.getDailyDrinking());
        et_aimDailyDrinking.setText(hyperFollowup.getAimDailyDrinking());
        et_exerciseDurationWeeks.setText(hyperFollowup.getExerciseDurationWeeks());
        et_exerciseDurationMins.setText(hyperFollowup.getExerciseDurationMins());
        et_aimDurationWeeks.setText(hyperFollowup.getAimDurationWeeks());
        et_aimExerciseMins.setText(hyperFollowup.getAimExerciseMins());
        setCheckBoxSelect(hyperFollowup.getSaltTakenLevelCode(), ll_saltTakenLevelCode);
        setCheckBoxSelect(hyperFollowup.getAimSalttakenLevelCode(), ll_aimSalttakenLevelCode);
        setCheckBoxSelect(hyperFollowup.getPsyAdjustResultCode(), ll_psyAdjustResultCode);
        setCheckBoxSelect(hyperFollowup.getComplianceResultCode(), ll_complianceResultCode);
        et_accessoryExam.setText(hyperFollowup.getAccessoryExam());
        setCheckBoxSelect(hyperFollowup.getDrugComplianceCode(), ll_drugComplianceCode);
        setCheckBoxSelect(hyperFollowup.getDrugAdverseCode(), ll_drugAdverseCode);
        setCheckBoxSelect(hyperFollowup.getFollowupClassifyCode(), ll_followupClassifyCode);
        et_referralReason.setText(hyperFollowup.getReferralReason());
        et_refertoOrgName.setText(hyperFollowup.getRefertoOrgName());

        mHyperDrugAdapter.notifyDataSetChanged();

        et_nextFollowupDate.setText(hyperFollowup.getNextFollowupDate());

        if (hyperFollowup.getFollowupDoctorId() != null) {
            for (int i = 0; i < empList.size(); i++) {
                if (hyperFollowup.getFollowupDoctorId().equals(empList.get(i).getEmp_id())) {
                    sp_followupDoctorId.setSelection(i);
                    break;
                }
            }
        }

//        setSpinnerSelected("2", hyperFollowup.getFollowupDoctorId(), sp_followupDoctorId);
    }

    public boolean saveData(HyperFollowup hyperFU) {

        if ("".equals(et_followupDate.getString())) {
            ToastUtil.showToast(mContext, "请输入随访日期", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(isMiss))) {
            ToastUtil.showToast(mContext, "请选择是否失访", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_followupWayCode))) {
            ToastUtil.showToast(mContext, "请选择随访方式", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_visitType))) {
            ToastUtil.showToast(mContext, "请选择随访类型", Toast.LENGTH_LONG);
            return false;
        }

        boolean flag = true;
        saveCheckBoxMany(null, hyperFU.getRecordChoice(), ll_symptomCn); //症状
        List<RecordChoice> choice = hyperFU.getRecordChoice();//症状
        for (int i = 0; i < choice.size(); i++) {
            if ("hyperSymptom".equals(choice.get(i).getCodeType())) {
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择症状", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_sbp.getText().toString()) || "".equals(et_dbp.getText().toString())) {
            ToastUtil.showToast(mContext, "请填写血压", Toast.LENGTH_LONG);
            return false;
        }

        if ((et_weight.getText().toString()).isEmpty() || (et_aimWeight.getText().toString()).isEmpty()) {
            ToastUtil.showToast(mContext, "请填写体重", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_bmi.getText().toString()) || "".equals(et_aimBmi.getText().toString())) {
            ToastUtil.showToast(mContext, "请填写体质指数", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_heartRate.getText().toString())) {
            ToastUtil.showToast(mContext, "请填写心率", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_drugComplianceCode))) {
            ToastUtil.showToast(mContext, "请选择服药依从性", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_followupClassifyCode))) {
            ToastUtil.showToast(mContext, "请选择此次随访分类", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_nextFollowupDate.getString())) {
            ToastUtil.showToast(mContext, "请填写下次随访日期", Toast.LENGTH_LONG);
            return false;
        }
//        Checks checks = (Checks) sp_followupDoctorId.getSelectedItem();
//        if ("".equals(checks.getCode())) {
//            ToastUtil.showToast(mContext, "请选择随访医生", Toast.LENGTH_LONG);
//            return false;
//        }

        hyperFU.setName(et_name.getString()); //姓名
        hyperFU.setFollowupDate(et_followupDate.getDate()); //随访日期
        hyperFU.setIsMiss(getCheckBoxSimpleCode(isMiss)); //是否失访
        hyperFU.setMissReason(missReason.getString()); //失访原因
        hyperFU.setFollowupWayCode(getCheckBoxSimpleCode(ll_followupWayCode)); //随访方式
        hyperFU.setVisitType(getCheckBoxSimpleCode(ll_visitType));//随访类型
        hyperFU.setSbp(et_sbp.getInt()); //血压 收缩压
        hyperFU.setDbp(et_dbp.getInt()); //血压 舒张压
        hyperFU.setWeight(et_weight.getDouble()); //体重
        hyperFU.setAimWeight(et_aimWeight.getDouble());  //目标体重
        hyperFU.setHeight(et_height.getDouble());  //身高
        hyperFU.setBmi(et_bmi.getDouble()); //体质指数 实际
        hyperFU.setAimBmi(et_aimBmi.getDouble()); //体质指数 目标
        hyperFU.setHeartRate(et_heartRate.getInt()); //心率
        hyperFU.setOtherPositiveSigns(et_otherPositiveSigns.getString()); //其他
        hyperFU.setDailySmoking(et_dailySmoking.getInt()); //日吸烟量
        hyperFU.setAimDailySmoking(et_aimDailySmoking.getInt()); //日吸烟量 目标
        hyperFU.setDailyDrinking(et_dailyDrinking.getInt()); //日饮酒量
        hyperFU.setAimDailyDrinking(et_aimDailyDrinking.getInt()); //日饮酒 目标
        hyperFU.setExerciseDurationWeeks(et_exerciseDurationWeeks.getInt()); //运动 次数
        hyperFU.setExerciseDurationMins(et_exerciseDurationMins.getInt()); //运动 时间
        hyperFU.setAimDurationWeeks(et_aimDurationWeeks.getInt()); //运动 目标次数
        hyperFU.setAimExerciseMins(et_aimExerciseMins.getInt()); //运动 目标时间
        hyperFU.setSaltTakenLevelCode(getCheckBoxSimpleCode(ll_saltTakenLevelCode)); //摄盐量
        hyperFU.setAimSalttakenLevelCode(getCheckBoxSimpleCode(ll_aimSalttakenLevelCode)); //目标摄盐量
        hyperFU.setPsyAdjustResultCode(getCheckBoxSimpleCode(ll_psyAdjustResultCode)); //心理调整
        hyperFU.setComplianceResultCode(getCheckBoxSimpleCode(ll_complianceResultCode)); //遵医行为
        hyperFU.setAccessoryExam(et_accessoryExam.getString()); //辅助检查
        hyperFU.setDrugComplianceCode(getCheckBoxSimpleCode(ll_drugComplianceCode)); //服药依从性
        hyperFU.setDrugAdverseCode(getCheckBoxSimpleCode(ll_drugAdverseCode)); //药物不良反应
        hyperFU.setDrugAdverseDesc(getString(ll_drugAdverseCode));
        hyperFU.setFollowupClassifyCode(getCheckBoxSimpleCode(ll_followupClassifyCode)); //此次随访分类
        hyperFU.setReferralReason(et_referralReason.getString()); //转诊原因
        hyperFU.setRefertoOrgName(et_refertoOrgName.getString()); //机构及级别
        hyperFU.setHyperFollowupId(null);
        hyperFU.setNextFollowupDate(et_nextFollowupDate.getDate()); //下次随访日期
        Emp emp = (Emp) sp_followupDoctorId.getSelectedItem();
        if (emp != null) {
            hyperFU.setFollowupDoctorId(emp.getEmp_id());
            hyperFU.setFollowupDoctorName(emp.getEmp_name());
        }

//        hyperFU.setFollowupDoctorName(checks.getCode()); //随访医生签名
        return true;

    }

    private void findView() {

        et_name = (FuEditText) mFuView.findViewById(R.id.et_name); //姓名
        et_followupDate = (FuEditText) mFuView.findViewById(R.id.et_followupDate); //随访日期
        et_followupDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FuContentActivity) mContext).showTimeDialog(et_followupDate)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
            }
        });
        isMiss = (LinearLayout) mFuView.findViewById(R.id.ll_isMiss); //是否失访
        missReason = (FuEditText) mFuView.findViewById(R.id.et_missReason); //失访原因
        ll_followupWayCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupWayCode); //随访方式
        ll_visitType = (LinearLayout) mFuView.findViewById(R.id.ll_visitType); //随访类型
        ll_symptomCn = (LinearLayout) mFuView.findViewById(R.id.ll_symptomCn); //症状
        et_sbp = (FuEditText) mFuView.findViewById(R.id.et_sbp); //血压 收缩压
        et_dbp = (FuEditText) mFuView.findViewById(R.id.et_dbp); //血压 舒张压
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight); //体重
        et_weight.setOnFocusChangeListener(this);
        et_aimWeight = (FuEditText) mFuView.findViewById(R.id.et_aimWeight); //目标体重
        et_aimWeight.setOnFocusChangeListener(this);
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height); //身高
        et_height.setOnFocusChangeListener(this);
        et_bmi = (FuEditText) mFuView.findViewById(R.id.et_bmi); //体质指数 实际
        et_aimBmi = (FuEditText) mFuView.findViewById(R.id.et_aimBmi); //体质指数 目标
        et_heartRate = (FuEditText) mFuView.findViewById(R.id.et_heartRate); //心率
        et_otherPositiveSigns = (FuEditText) mFuView.findViewById(R.id.et_otherPositiveSigns); //其他
        et_dailySmoking = (FuEditText) mFuView.findViewById(R.id.et_dailySmoking); //日吸烟量
        et_aimDailySmoking = (FuEditText) mFuView.findViewById(R.id.et_aimDailySmoking); //日吸烟量 目标
        et_dailyDrinking = (FuEditText) mFuView.findViewById(R.id.et_dailyDrinking); //日饮酒量
        et_aimDailyDrinking = (FuEditText) mFuView.findViewById(R.id.et_aimDailyDrinking); //日饮酒 目标
        et_exerciseDurationWeeks = (FuEditText) mFuView.findViewById(R.id.et_exerciseDurationWeeks); //运动 次数
        et_exerciseDurationMins = (FuEditText) mFuView.findViewById(R.id.et_exerciseDurationMins); //运动 时间
        et_aimDurationWeeks = (FuEditText) mFuView.findViewById(R.id.et_aimDurationWeeks); //运动 目标次数
        et_aimExerciseMins = (FuEditText) mFuView.findViewById(R.id.et_aimExerciseMins); //运动 目标时间
        ll_saltTakenLevelCode = (LinearLayout) mFuView.findViewById(R.id.ll_saltTakenLevelCode); //摄盐量
        ll_aimSalttakenLevelCode = (LinearLayout) mFuView.findViewById(R.id.ll_aimSalttakenLevelCode); //目标摄盐量
        ll_psyAdjustResultCode = (LinearLayout) mFuView.findViewById(R.id.ll_psyAdjustResultCode); //心理调整
        ll_complianceResultCode = (LinearLayout) mFuView.findViewById(R.id.ll_complianceResultCode); //遵医行为
        et_accessoryExam = (FuEditText) mFuView.findViewById(R.id.et_accessoryExam); //辅助检查
        ll_drugComplianceCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugComplianceCode); //服药依从性
        ll_drugAdverseCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugAdverseCode); //药物不良反应
        ll_followupClassifyCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupClassifyCode); //此次随访分类
        et_referralReason = (FuEditText) mFuView.findViewById(R.id.et_referralReason); //转诊原因
        et_refertoOrgName = (FuEditText) mFuView.findViewById(R.id.et_refertoOrgName); //机构及级别
        f_medicine_save = (FuButton) mFuView.findViewById(R.id.f_medicine_save); //添加
        f_medicine_save.setOnClickListener(this);
        sp_drugName = (Spinner) mFuView.findViewById(R.id.sp_drugName); //药物名称
        sp_drugUsingFreq = (Spinner) mFuView.findViewById(R.id.sp_drugUsingFreq); //用法
        et_drugPerDose = (FuEditText) mFuView.findViewById(R.id.et_drugPerDose); //每次剂量
        sp_unit = (Spinner) mFuView.findViewById(R.id.sp_unit); //单位
        lv_hyperFU = (FuListView) mFuView.findViewById(R.id.lv_hyperFU); //展示药物名称，用法，每次剂量
        et_nextFollowupDate = (FuEditText) mFuView.findViewById(R.id.et_nextFollowupDate); //下次随访日期
        et_nextFollowupDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FuContentActivity) mContext).showTimeDialog(et_nextFollowupDate)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
            }
        });
        sp_followupDoctorId = (Spinner) mFuView.findViewById(R.id.sp_followupDoctorId); //随访医生签名

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.f_medicine_save:
                SpinnerItem spinnerItem = (SpinnerItem) sp_drugName.getSelectedItem();

                HyperFollowupDrug hyperFollowupDrug = new HyperFollowupDrug();
                hyperFollowupDrug.setDrugId(spinnerItem.getId());
                hyperFollowupDrug.setDrugName(spinnerItem.getValue());
//                hyperFollowupDrug.setHyperFollowupId(mHyperFollowup.getHyperFollowupId());//添加更新的时候还要加判断
                Checks checks = (Checks) sp_drugUsingFreq.getSelectedItem();
                hyperFollowupDrug.setDrugUsingFreq(checks.getCode()); //用法
                hyperFollowupDrug.setDrugPerDose(et_drugPerDose.getString()); //每次剂量
                Checks checkUnit = (Checks) sp_unit.getSelectedItem();
//                hyperFollowupDrug.setDrugPerDose(checkUnit.getCode());//单位
                hyperFollowupDrug.setUnit(checkUnit.getValue());
                mHyperFollowup.getHyperFollowupDrug().add(hyperFollowupDrug);
                mHyperDrugAdapter.notifyDataSetChanged();
                et_drugPerDose.setText("");

                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuHyperFragment.EVENT_SAVE_HYPER, null);
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.et_weight:
                if (!hasFocus) {
                    if (!et_height.getString().isEmpty() && !et_weight.getString().isEmpty()) {
                        double tizhi = et_weight.getDouble() / (et_height.getDouble() * et_height.getDouble()) * 10000;
                        et_bmi.setText(String.format("%.2f", tizhi));
                    }
                }
                break;
            case R.id.et_aimWeight:
                if (!hasFocus) {
                    if (!et_height.getString().isEmpty() && !et_aimWeight.getString().isEmpty()) {
                        double tizhi = et_aimWeight.getDouble() / (et_height.getDouble() * et_height.getDouble()) * 10000;
                        et_aimBmi.setText(String.format("%.2f", tizhi));
                    }
                }
                break;
            case R.id.et_height:
                if (!hasFocus) {
                    if (!et_height.getString().isEmpty() && !et_weight.getString().isEmpty()) {
                        double tizhi = et_weight.getDouble() / (et_height.getDouble() * et_height.getDouble()) * 10000;
                        et_bmi.setText(String.format("%.2f", tizhi));
                    }
                    if (!et_height.getString().isEmpty() && !et_aimWeight.getString().isEmpty()) {
                        double tizhi = et_aimWeight.getDouble() / (et_height.getDouble() * et_height.getDouble()) * 10000;
                        et_aimBmi.setText(String.format("%.2f", tizhi));
                    }
                }
                break;
        }
    }

    class HyperDrugAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public HyperDrugAdapter() {
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return mHyperFollowup == null || mHyperFollowup.getHyperFollowupDrug() == null ? 0 : mHyperFollowup.getHyperFollowupDrug().size();
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
            HyperDrugHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fu_medicine_item, null);
                holder = new HyperDrugHolder();
                holder.tv_name = (FuTextView) convertView.findViewById(R.id.tv_name);
                holder.tv_num = (FuTextView) convertView.findViewById(R.id.tv_num);
                holder.tv_dose = (FuTextView) convertView.findViewById(R.id.tv_dose);
                holder.tv_delete = (FuTextView) convertView.findViewById(R.id.tv_delete);
                convertView.setTag(holder);
            } else {
                holder = (HyperDrugHolder) convertView.getTag();
            }
            holder.tv_name.setText(mHyperFollowup.getHyperFollowupDrug().get(position).getDrugName());
            holder.tv_num.setText(mHyperFollowup.getHyperFollowupDrug().get(position).getDrugUsingFreq());
            holder.tv_dose.setText(mHyperFollowup.getHyperFollowupDrug().get(position).getDrugPerDose() +
                    mHyperFollowup.getHyperFollowupDrug().get(position).getUnit());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setTag(mHyperFollowup.getHyperFollowupDrug().get(position));
            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mHyperFollowup.getHyperFollowupDrug().remove(position);
                    mHyperDrugAdapter.notifyDataSetChanged();
                }
            });

            return convertView;
        }

        class HyperDrugHolder {

            FuTextView tv_name; //药物名称
            FuTextView tv_num; //每日次数
            FuTextView tv_dose;//每次剂量
            FuTextView tv_delete;
        }
    }
}
