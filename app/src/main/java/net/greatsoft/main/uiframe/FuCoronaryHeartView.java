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
import net.greatsoft.main.db.po.corconaryHeart.ChdInfoDrugs;
import net.greatsoft.main.db.po.corconaryHeart.CoronaryHeartDiseaseFollowup;
import net.greatsoft.main.fragment.FucoronaryHeartFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuListView;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2017/03/03
 * Time: 16:48
 * progject: Chss
 * Describe： 冠心病随访
 */

public class FuCoronaryHeartView extends FuUiFrameModel implements View.OnClickListener, View.OnFocusChangeListener {

    FuTextView tv_name;//姓名
    FuEditText et_followupDate;//随访日期
    LinearLayout ll_followupWayCode;//随访方式
    LinearLayout ll_zhengzhuang;//症状
    FuEditText et_sbp;//血压
    FuEditText et_dbp;//血压
    FuEditText et_weight;//体重
    FuEditText et_aimWeight;//体重
    FuEditText et_height;//身高
    FuEditText et_bmi;//体质指数
    FuEditText et_aimBmi;//体质指数
    FuEditText et_fbgMmol;//空腹血糖值
    FuEditText et_tg;//甘油三酯
    FuEditText et_heartRate;//心率
    FuEditText et_ecgAbnormResult;//心电图检查结果
    FuEditText et_ecgExerciseResult;//运动负荷试验结果
    FuEditText et_heartCheckResult;//心脏彩超检查结果
    FuEditText et_coronaryArteryResult;//冠状动脉造影结果
    FuEditText et_cardiacEnzymesResult;//心肌酶学检查结果
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
    LinearLayout ll_drugComplianceCode;//服药依从性
    LinearLayout ll_teshu;//特殊治疗
    LinearLayout ll_feiyaowu;//非药物治疗措施
    LinearLayout ll_followupClassifyCode;//此次随访分类
    FuEditText et_followupDoctorAdvise;//本次随访医生建议
    Spinner sp_drugName;//药物名称
    Spinner sp_drugUsingFreq;//用法
    FuEditText et_drugPerDose;//每次剂量
    Spinner sp_unit; //单位
    FuListView lv_coronary;//用药集合
    FuButton d_b_medicine_save; //完成
    FuEditText et_nextFollowupDate;//下次随访日期
    Spinner sp_followupDoctorId;//随访医生签名

    TextView fu_title_center;
    Button fu_title_right_btn;

    List<ChdInfoDrugs> mDrugsList;
    CoronaryHeartAdapter mCoronaryHeartAdapter;

    List<Emp> empList;//随访医生

    public FuCoronaryHeartView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_coronaryheart_view, null);

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
        initCheckBoxMany("chdSymptoms", ll_zhengzhuang, 4, false, false);//症状
        initCheckBoxSimple("HEART_ADJUST", ll_psyAdjustResultCode, 0); //心理调整
        initCheckBoxSimple("FOLLOW_DOCTOR", ll_complianceResultCode, 0); //遵医行为
        initCheckBoxSimple("DRUG_COMPLIANCE", ll_drugComplianceCode, 0); //服药依从性
        initCheckBoxMany("chdSpecialTreatment", ll_teshu, 4, false, false);//特殊治疗
        initCheckBoxMany("chdDrugTreatment", ll_feiyaowu, 3, false, false);//非药物治疗措施
        initCheckBoxSimple("VISIT_ASSORT", ll_followupClassifyCode, 0); //此次随访分类

        empList = sqlHelper.getEmpDao().queryBuilder().list();
        ArrayAdapter adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_followupDoctorId.setAdapter(adapter);

    }

    @Override
    protected void initWidget() {

        findView();

        mCoronaryHeartAdapter = new CoronaryHeartAdapter();
        lv_coronary.setAdapter(mCoronaryHeartAdapter);

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("冠心病随访");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

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

    public void setData(CoronaryHeartDiseaseFollowup heartDiseaseFollowup, String name) {

        tv_name.setText(name);    //姓名
        if (heartDiseaseFollowup == null) {
            return;
        }
    }

    public boolean saveData(CoronaryHeartDiseaseFollowup followup) {

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
        saveCheckBoxMany(null, followup.getRecordChoice(), ll_zhengzhuang);//症状
        followup.setSbp(et_sbp.getInt());//血压
        followup.setDbp(et_dbp.getInt());//血压
        followup.setWeight(et_weight.getDouble());//体重
        followup.setAimWeight(et_aimWeight.getDouble());//目标体重
        followup.setHeight(et_height.getDouble());//身高
        followup.setBmi(et_bmi.getDouble());//体质指数
        followup.setAimBmi(et_aimBmi.getDouble());//体质指数
        followup.setFbgMmol(et_fbgMmol.getDouble());//空腹血糖值
        followup.setTg(et_tg.getDouble());//甘油三酯
        followup.setHeartRate(et_heartRate.getInt());//心率
        followup.setEcgAbnormResult(et_ecgAbnormResult.getString());//心电图检查结果
        followup.setEcgExerciseResult(et_ecgExerciseResult.getString());//运动负荷试验结果
        followup.setHeartCheckResult(et_heartCheckResult.getString());//心脏彩超检查结果
        followup.setCoronaryArteryResult(et_coronaryArteryResult.getString());//冠状动脉造影结果
        followup.setCardiacEnzymesResult(et_cardiacEnzymesResult.getString());//心肌酶学检查结果
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
        followup.setDrugComplianceCode(getCheckBoxSimpleCode(ll_drugComplianceCode));//服药依从性
        saveCheckBoxMany(null, followup.getRecordChoice(), ll_teshu);//特殊治疗
        saveCheckBoxMany(null, followup.getRecordChoice(), ll_feiyaowu);//非药物治疗措施
        followup.setFollowupClassifyCode(getCheckBoxSimpleCode(ll_followupClassifyCode));//此次随访分类
        followup.setFollowupDoctorAdvise(et_followupDoctorAdvise.getString());//本次随访医生建议

        followup.getChdInfoDrug().addAll(mDrugsList);

        followup.setNextFollowupDate(et_nextFollowupDate.getDate());//下次随访日期
        Emp emp = (Emp) sp_followupDoctorId.getSelectedItem();
        followup.setFollowupDoctorId(emp.getEmp_id());
        followup.setFollowupDoctorName(emp.getEmp_name());

        followup.setChdFollowupId(null);

        return true;
    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name);//姓名
        et_followupDate = (FuEditText) mFuView.findViewById(R.id.et_followupDate);//随访日期
        et_followupDate.setOnClickListener(this);
        ll_followupWayCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupWayCode);//随访方式
        ll_zhengzhuang = (LinearLayout) mFuView.findViewById(R.id.ll_zhengzhuang);//症状
        et_sbp = (FuEditText) mFuView.findViewById(R.id.et_sbp);//血压
        et_dbp = (FuEditText) mFuView.findViewById(R.id.et_dbp);//血压
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight);//体重
        et_weight.setOnFocusChangeListener(this);
        et_aimWeight = (FuEditText) mFuView.findViewById(R.id.et_aimWeight);//体重
        et_aimWeight.setOnFocusChangeListener(this);
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height);//身高
        et_height.setOnFocusChangeListener(this);
        et_bmi = (FuEditText) mFuView.findViewById(R.id.et_bmi);//体质指数
        et_aimBmi = (FuEditText) mFuView.findViewById(R.id.et_aimBmi);//体质指数
        et_fbgMmol = (FuEditText) mFuView.findViewById(R.id.et_fbgMmol);//空腹血糖值
        et_tg = (FuEditText) mFuView.findViewById(R.id.et_tg);//甘油三酯
        et_heartRate = (FuEditText) mFuView.findViewById(R.id.et_heartRate);//心率
        et_ecgAbnormResult = (FuEditText) mFuView.findViewById(R.id.et_ecgAbnormResult);//心电图检查结果
        et_ecgExerciseResult = (FuEditText) mFuView.findViewById(R.id.et_ecgExerciseResult);//运动负荷试验结果
        et_heartCheckResult = (FuEditText) mFuView.findViewById(R.id.et_heartCheckResult);//心脏彩超检查结果
        et_coronaryArteryResult = (FuEditText) mFuView.findViewById(R.id.et_coronaryArteryResult);//冠状动脉造影结果
        et_cardiacEnzymesResult = (FuEditText) mFuView.findViewById(R.id.et_cardiacEnzymesResult);//心肌酶学检查结果
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
        ll_drugComplianceCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugComplianceCode);//服药依从性
        ll_teshu = (LinearLayout) mFuView.findViewById(R.id.ll_teshu);//特殊治疗
        ll_feiyaowu = (LinearLayout) mFuView.findViewById(R.id.ll_feiyaowu);//非药物治疗措施
        ll_followupClassifyCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupClassifyCode);//此次随访分类
        et_followupDoctorAdvise = (FuEditText) mFuView.findViewById(R.id.et_followupDate);//本次随访医生建议
        d_b_medicine_save = (FuButton) mFuView.findViewById(R.id.f_medicine_save); //完成
        d_b_medicine_save.setOnClickListener(this);
        sp_drugName = (Spinner) mFuView.findViewById(R.id.sp_drugName);//药物名称
        sp_drugUsingFreq = (Spinner) mFuView.findViewById(R.id.sp_drugUsingFreq);//用法
        et_drugPerDose = (FuEditText) mFuView.findViewById(R.id.et_drugPerDose);//每次剂量
        sp_unit = (Spinner) mFuView.findViewById(R.id.sp_unit); //单位
        lv_coronary = (FuListView) mFuView.findViewById(R.id.lv_coronary);//用药集合
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
                mEventCallBack.EventClick(FucoronaryHeartFragment.EVENT_SAVE_CORONARYHEART, null);
                break;
            case R.id.f_medicine_save:
                SpinnerItem spinnerItem = (SpinnerItem) sp_drugName.getSelectedItem();

                ChdInfoDrugs chdInfoDrugs = new ChdInfoDrugs();
                chdInfoDrugs.setDrugId(spinnerItem.getId());
                chdInfoDrugs.setDrugName(spinnerItem.getValue());


                Checks checks = (Checks) sp_drugUsingFreq.getSelectedItem();
                chdInfoDrugs.setDrugUsingFreq(checks.getCode()); //用法
                chdInfoDrugs.setDrugPerDose(et_drugPerDose.getString()); //每次剂量

                Checks checkUnit = (Checks) sp_unit.getSelectedItem();
//                chdInfoDrugs.setDrugPerDose(checkUnit.getCode());//单位
                chdInfoDrugs.setUnit(checkUnit.getValue());
                mDrugsList.add(chdInfoDrugs);
                mCoronaryHeartAdapter.notifyDataSetChanged();
                et_drugPerDose.setText("");
                break;
        }
    }

    class CoronaryHeartAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public CoronaryHeartAdapter() {
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
                    mCoronaryHeartAdapter.notifyDataSetChanged();
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
