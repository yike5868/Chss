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
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.SickMedicine;
import net.greatsoft.main.db.po.SpinnerItem;
import net.greatsoft.main.db.po.cerebralApoplexy.CaInfoDrugs;
import net.greatsoft.main.db.po.cerebralApoplexy.CerebralApoplexyFollowup;
import net.greatsoft.main.fragment.FuCerebralApoplexyFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2017/03/03
 * Time: 15:07
 * progject: Chss
 * Describe： 脑卒中随访
 */

public class FuCerebralApoplexyView extends FuUiFrameModel implements View.OnClickListener, View.OnFocusChangeListener {

    FuTextView tv_name;//姓名
    FuEditText et_followupDate;//随访日期
    LinearLayout ll_followupWayCode;//随访方式
    LinearLayout ll_zhengZhuang;//症状
    LinearLayout ll_bingfazheng;//脑卒中并发症情况
    LinearLayout ll_xinfazheng;//脑卒中并发症情况
    FuEditText et_sbp;//血压
    FuEditText et_dbp;//血压
    FuEditText et_weight;//体重
    FuEditText et_aimWeight;//体重
    FuEditText et_height;//身高
    FuEditText et_aimBmi;//体质指数
    FuEditText et_bmi;//体质指数
    FuEditText et_waist;//腰围
    FuEditText et_heartRate;//心率
    FuEditText et_otherPositiveSigns;//其他
    FuEditText et_fbgMmol;//空腹血糖值
    FuEditText et_dailySmoking;//日吸烟量
    FuEditText et_aimDailySmoking;//日吸烟量
    FuEditText et_dailyDrinking;//日饮酒量
    FuEditText et_aimDailyDrinking;//日饮酒量
    FuEditText et_exerciseDurationWeeks;//运动
    FuEditText et_exerciseDurationMins;//运动
    FuEditText et_aimDurationWeeks;//运动
    FuEditText et_aimExerciseMins;//运动
    LinearLayout ll_psyAdjustResultCode;//心理调整
    LinearLayout ll_complianceResultCode;//遵医行为
    LinearLayout ll_selfCareAssessCode;//生活自理能力
    LinearLayout ll_kangfu;//康复治疗方式
    LinearLayout ll_drugComplianceCode;//服药依从性
    LinearLayout ll_adverseReactionsCode;//药物不良反应
    LinearLayout ll_followupClassifyCode;//此次随访分类
    LinearLayout ll_recoveryStatus;//肢体功能恢复情况
    FuEditText et_followupDoctorAdvise;//本次随访医生建议
    Spinner sp_drugName;//药物名称
    Spinner sp_drugUsingFreq;//用法
    FuEditText et_drugPerDose;//每次剂量
    Spinner sp_unit; //单位
    net.greatsoft.main.view.FuListView lv_cerebral;//用药集合
    FuButton d_b_medicine_save; //完成
    FuEditText et_nextFollowupDate;//下次随访日期
    Spinner sp_followupDoctorId;//随访医生签名

    TextView fu_title_center;
    Button fu_title_right_btn;

    List<CaInfoDrugs> mDrugsList;
    CerebralApoplexyAdapter mCerebralApoplexyAdapter;

    List<Emp> empList;//随访医生


    public FuCerebralApoplexyView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_cerebralapoplexy_view, null);

        mDrugsList = new ArrayList<>();
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
        ArrayAdapter<?> adapter3 = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                unit);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_unit.setAdapter(adapter3);

        initCheckBoxSimple("VISITE_WAY", ll_followupWayCode, 0); //随访方式
        initCheckBoxSimple("HEART_ADJUST", ll_psyAdjustResultCode, 0); //心理调整
        initCheckBoxSimple("FOLLOW_DOCTOR", ll_complianceResultCode, 0); //遵医行为
        initCheckBoxSimple("DRUG_COMPLIANCE", ll_drugComplianceCode, 0); //服药依从性
        initCheckBoxSimple("VISIT_ASSORT", ll_followupClassifyCode, 0); //此次随访分类
        initCheckBoxSimple("YES_NO_CODE", ll_adverseReactionsCode, true); //药物不良反应
        initCheckBoxSimple("INSIGHT",ll_selfCareAssessCode,0);//生活自理能力
        initCheckBoxSimple("HEART_ADJUST",ll_recoveryStatus,0);//肢体功能恢复情况
        initCheckBoxMany("caCurrSymptoms", ll_zhengZhuang, 3, false, true);//症状
        initCheckBoxMany("caComplication", ll_bingfazheng, 3, false, true);//脑卒中并发症情况
        initCheckBoxMany("caTreatmentWay", ll_kangfu, 3, false, true);//康复治疗措施
        initCheckBoxMany("caSymptoms", ll_xinfazheng, 3, false, true);//新发卒中症状

        empList = sqlHelper.getEmpDao().queryBuilder().list();
        ArrayAdapter adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_followupDoctorId.setAdapter(adapter);

    }

    public void setData(CerebralApoplexyFollowup followup, String name) {
        tv_name.setText(name);//姓名
        if (followup == null) {
            return;
        }
    }

    public boolean saveData(CerebralApoplexyFollowup followup) {

        if ("".equals(et_followupDate.getString())) {
            ToastUtil.showToast(mContext, "请输入随访日期", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_followupWayCode))) {
            ToastUtil.showToast(mContext, "请选择随访方式", Toast.LENGTH_LONG);
            return false;
        }
        followup.setFollowupDate(et_followupDate.getDate());//随访日期
        followup.setFollowupWayCode(getCheckBoxSimpleCode(ll_followupWayCode));//随访方式
        saveCheckBoxMany(null, followup.getRecordChoice(), ll_zhengZhuang);//症状
        saveCheckBoxMany(null, followup.getRecordChoice(), ll_bingfazheng);//脑卒中并发症情况
        saveCheckBoxMany(null, followup.getRecordChoice(), ll_xinfazheng);//脑卒中并发症情况
        followup.setSbp(et_sbp.getInt());//血压
        followup.setDbp(et_dbp.getInt());//血压
        followup.setWeight(et_weight.getDouble());//体重
        followup.setAimWeight(et_aimWeight.getDouble());//目标体重
        followup.setHeight(et_height.getDouble());//身高
        followup.setBmi(et_bmi.getDouble());//体质指数
        followup.setAimBmi(et_aimBmi.getDouble());//体质指数
        followup.setWaist(et_waist.getDouble());//腰围
        followup.setHeartRate(et_heartRate.getInt());//心率
        followup.setOtherPositiveSigns(et_otherPositiveSigns.getString());//其他
        followup.setFbgMmol(et_fbgMmol.getDouble());//空腹血糖值
        followup.setDailySmoking(et_dailySmoking.getInt());//日吸烟量
        followup.setAimDailySmoking(et_aimDailySmoking.getInt());//日吸烟量
        followup.setDailyDrinking(et_dailyDrinking.getDouble());//日饮酒量
        followup.setAimDailyDrinking(et_aimDailyDrinking.getDouble());//日饮酒量
        followup.setExerciseDurationWeeks(et_exerciseDurationWeeks.getInt());//运动
        followup.setExerciseDurationMins(et_exerciseDurationMins.getInt());
        followup.setAimDurationWeeks(et_aimDurationWeeks.getInt());
        followup.setAimExerciseMins(et_aimExerciseMins.getInt());
        followup.setPsyAdjustResultCode(getCheckBoxSimpleCode(ll_psyAdjustResultCode));//心理调整
        followup.setComplianceResultCode(getCheckBoxSimpleCode(ll_complianceResultCode));//遵医行为
        followup.setRecoveryStatus(getCheckBoxSimpleCode(ll_recoveryStatus));//肢体功能恢复情况
        followup.setSelfCareAssessCode(getCheckBoxSimpleCode(ll_selfCareAssessCode));//生活自理能力
        saveCheckBoxMany(null, followup.getRecordChoice(), ll_kangfu);//康复治疗方式
        followup.setDrugComplianceCode(getCheckBoxSimpleCode(ll_drugComplianceCode));//服药依从性
        followup.setAdverseReactionsCode(getCheckBoxSimpleCode(ll_adverseReactionsCode));//药物不良反应
        followup.setAdverseReactionsValue(getString(ll_adverseReactionsCode));
        followup.setFollowupClassifyCode(getCheckBoxSimpleCode(ll_followupClassifyCode));//此次随访分类
        followup.setFollowupDoctorAdvise(et_followupDoctorAdvise.getString());//本次随访医生建议

        followup.getCaInfoDrug().addAll(mDrugsList);//药物

        followup.setNextFollowupDate(et_nextFollowupDate.getDate());//下次随访日期
        Emp emp = (Emp) sp_followupDoctorId.getSelectedItem();
        followup.setFollowupDoctorId(emp.getEmp_id());
        followup.setFollowupDoctorName(emp.getEmp_name());

        followup.setCerebralApoplexyFollowupId(null);

        return true;
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

        mCerebralApoplexyAdapter = new CerebralApoplexyAdapter();
        lv_cerebral.setAdapter(mCerebralApoplexyAdapter);

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("脑卒中随访");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name);//姓名
        et_followupDate = (FuEditText) mFuView.findViewById(R.id.et_followupDate);//随访日期
        et_followupDate.setOnClickListener(this);
        ll_followupWayCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupWayCode);//随访方式
        ll_zhengZhuang = (LinearLayout) mFuView.findViewById(R.id.ll_zhengZhuang);//症状
        ll_bingfazheng = (LinearLayout) mFuView.findViewById(R.id.ll_bingfazheng);//脑卒中并发症情况
        ll_xinfazheng = (LinearLayout) mFuView.findViewById(R.id.ll_xinfazheng);//新发卒中症状
        et_sbp = (FuEditText) mFuView.findViewById(R.id.et_sbp);//血压
        et_dbp = (FuEditText) mFuView.findViewById(R.id.et_dbp);//血压
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight);//体重
        et_weight.setOnFocusChangeListener(this);
        et_aimWeight = (FuEditText) mFuView.findViewById(R.id.et_aimWeight);//体重
        et_aimWeight.setOnFocusChangeListener(this);
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height);//身高
        et_height.setOnFocusChangeListener(this);
        et_aimBmi = (FuEditText) mFuView.findViewById(R.id.et_aimBmi);//体质指数
        et_bmi = (FuEditText) mFuView.findViewById(R.id.et_bmi);//体质指数
        et_waist = (FuEditText) mFuView.findViewById(R.id.et_waist);//腰围
        et_heartRate = (FuEditText) mFuView.findViewById(R.id.et_heartRate);//心率
        et_otherPositiveSigns = (FuEditText) mFuView.findViewById(R.id.et_otherPositiveSigns);//其他
        et_fbgMmol = (FuEditText) mFuView.findViewById(R.id.et_fbgMmol);//空腹血糖值
        et_dailySmoking = (FuEditText) mFuView.findViewById(R.id.et_dailySmoking);//日吸烟量
        et_aimDailySmoking = (FuEditText) mFuView.findViewById(R.id.et_aimDailySmoking);//日吸烟量
        et_dailyDrinking = (FuEditText) mFuView.findViewById(R.id.et_dailyDrinking);//日饮酒量
        et_aimDailyDrinking = (FuEditText) mFuView.findViewById(R.id.et_aimDailyDrinking);//日饮酒量
        et_exerciseDurationWeeks = (FuEditText) mFuView.findViewById(R.id.et_exerciseDurationWeeks);//运动
        et_exerciseDurationMins = (FuEditText) mFuView.findViewById(R.id.et_exerciseDurationMins);//运动
        et_aimDurationWeeks = (FuEditText) mFuView.findViewById(R.id.et_aimDurationWeeks);//运动
        et_aimExerciseMins = (FuEditText) mFuView.findViewById(R.id.et_aimExerciseMins);//运动
        ll_psyAdjustResultCode = (LinearLayout) mFuView.findViewById(R.id.ll_psyAdjustResultCode);//心理调整
        ll_complianceResultCode = (LinearLayout) mFuView.findViewById(R.id.ll_complianceResultCode);//遵医行为
        ll_selfCareAssessCode = (LinearLayout) mFuView.findViewById(R.id.ll_selfCareAssessCode);//生活自理能力
        ll_kangfu = (LinearLayout) mFuView.findViewById(R.id.ll_kangfu);//康复治疗方式
        ll_drugComplianceCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugComplianceCode);//服药依从性
        ll_adverseReactionsCode = (LinearLayout) mFuView.findViewById(R.id.ll_adverseReactionsCode);//药物不良反应
        ll_followupClassifyCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupClassifyCode);//此次随访分类
        ll_recoveryStatus = (LinearLayout) mFuView.findViewById(R.id.ll_recoveryStatus);//肢体功能恢复情况
        et_followupDoctorAdvise = (FuEditText) mFuView.findViewById(R.id.et_followupDoctorAdvise);//本次随访医生建议
        sp_drugName = (Spinner) mFuView.findViewById(R.id.sp_drugName);//药物名称
        sp_drugUsingFreq = (Spinner) mFuView.findViewById(R.id.sp_drugUsingFreq);//用法
        et_drugPerDose = (FuEditText) mFuView.findViewById(R.id.et_drugPerDose);//每次剂量
        sp_unit = (Spinner) mFuView.findViewById(R.id.sp_unit); //单位
        lv_cerebral = (net.greatsoft.main.view.FuListView) mFuView.findViewById(R.id.lv_cerebral);//用药集合
        d_b_medicine_save = (FuButton) mFuView.findViewById(R.id.f_medicine_save);
        d_b_medicine_save.setOnClickListener(this);
        et_nextFollowupDate = (FuEditText) mFuView.findViewById(R.id.et_nextFollowupDate);//下次随访日期
        et_nextFollowupDate.setOnClickListener(this);
        sp_followupDoctorId = (Spinner) mFuView.findViewById(R.id.sp_followupDoctorId);//随访医生签名

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_followupDate:
                ((FuContentActivity) mContext).showTimeDialog(et_followupDate)
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.et_nextFollowupDate:
                ((FuContentActivity) mContext).showTimeDialog(et_nextFollowupDate)
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuCerebralApoplexyFragment.EVENT_SAVE_CEREBRALAPOPLEXY, null);
                break;
            case R.id.f_medicine_save:
                SpinnerItem spinnerItem = (SpinnerItem) sp_drugName.getSelectedItem();

                CaInfoDrugs caInfoDrugs = new CaInfoDrugs();
                caInfoDrugs.setDrugId(spinnerItem.getId());
                caInfoDrugs.setDrugName(spinnerItem.getValue());


                Checks checks = (Checks) sp_drugUsingFreq.getSelectedItem();
                caInfoDrugs.setDrugUsingFreq(checks.getCode()); //用法
                caInfoDrugs.setDrugPerDose(et_drugPerDose.getString()); //每次剂量
                Checks checkUnit = (Checks) sp_unit.getSelectedItem();
//                caInfoDrugs.setDrugPerDose(checkUnit.getCode());//单位
                caInfoDrugs.setUnit(checkUnit.getValue());
                mDrugsList.add(caInfoDrugs);
                mCerebralApoplexyAdapter.notifyDataSetChanged();
                et_drugPerDose.setText("");
                break;
        }
    }

    class CerebralApoplexyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public CerebralApoplexyAdapter() {
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return mDrugsList == null ? 0 : mDrugsList.size();
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
            Holder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fu_medicine_item, null);
                holder = new Holder();
                holder.tv_name = (FuTextView) convertView.findViewById(R.id.tv_name);
                holder.tv_num = (FuTextView) convertView.findViewById(R.id.tv_num);
                holder.tv_dose = (FuTextView) convertView.findViewById(R.id.tv_dose);
                holder.tv_delete = (FuTextView) convertView.findViewById(R.id.tv_delete);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            holder.tv_name.setText(mDrugsList.get(position).getDrugName());
            holder.tv_num.setText(mDrugsList.get(position).getDrugUsingFreq());
            holder.tv_dose.setText(mDrugsList.get(position).getDrugPerDose()+mDrugsList.get(position).getUnit());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setTag(mDrugsList.get(position));
            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrugsList.remove(position);
                    mCerebralApoplexyAdapter.notifyDataSetChanged();
                }
            });

            return convertView;
        }

        class Holder {

            FuTextView tv_name; //药物名称
            FuTextView tv_num; //每日次数
            FuTextView tv_dose;//每次剂量
            FuTextView tv_delete;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
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
            case R.id.et_aimWeight:
                if (!hasFocus) {
                    if (!et_height.getString().isEmpty() && !et_aimWeight.getString().isEmpty()) {
                        double tizhi = et_aimWeight.getDouble() / (et_height.getDouble() * et_height.getDouble()) * 10000;
                        et_aimBmi.setText(String.format("%.2f", tizhi));
                    }
                }
                break;
            case R.id.et_weight:
                if (!hasFocus) {
                    if (!et_height.getString().isEmpty() && !et_weight.getString().isEmpty()) {
                        double tizhi = et_weight.getDouble() / (et_height.getDouble() * et_height.getDouble()) * 10000;
                        et_bmi.setText(String.format("%.2f", tizhi));
                    }
                }
                break;
        }
    }
}
