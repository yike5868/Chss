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
import net.greatsoft.main.db.po.SickMedicine;
import net.greatsoft.main.db.po.SpinnerItem;
import net.greatsoft.main.db.po.corconaryHeart.ChdInfoDrugs;
import net.greatsoft.main.db.po.corconaryHeart.CoronaryHeartDiseaseInfo;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuCoronaryHeartInfoFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2017/03/22
 * Time: 11:20
 * progject: Chss
 * Describe： 冠心病专档
 */

public class FuCoronaryHeartInfoView extends FuUiFrameModel implements View.OnClickListener, View.OnFocusChangeListener {

    FuTextView tv_name;//姓名
    FuTextView tv_sex;//性别
    FuTextView tv_birthDate;//出生日期
    FuTextView tv_telNo;//联系电话
    FuTextView tv_idNo;//身份证号
    LinearLayout ll_zhiye;//职业
    FuTextView tv_houseAdress;//家庭地址
    FuEditText et_heartDiseaseInfoNo;//管理卡编号
    LinearLayout ll_manageGroup;//管理组别
    LinearLayout ll_caseSource;//病例来源
    LinearLayout ll_jiazushi;//家族史
    FuTextView tv_confirmDate;//冠心病确诊日期
    FuEditText et_confirmOrgName;//确诊机构
    LinearLayout ll_heartDiseaseType;//冠心病类型
    LinearLayout ll_zhengZhuang;//目前症状
    LinearLayout ll_bingshi;//病史
    FuEditText et_height;//身高
    FuEditText et_weight;//体重
    FuEditText et_bmi;//BMI
    FuEditText et_heartRate;//心率
    FuEditText et_sbp;//血压值
    FuEditText et_dbp;//血压值
    FuEditText et_fbgMmol;//空腹血糖
    FuEditText et_hdlc;//高密度脂蛋白
    FuEditText et_ldlc;//低密度脂蛋白
    FuEditText et_waist;//腰围
    FuEditText et_tg;//甘油三酯
    FuEditText et_tcho;//胆固醇
    FuTextView tv_checkDate;//体检日期
    FuEditText et_ecgAbnormResult;//心电图检查结果
    FuEditText et_heartCheckResult;//心脏彩超检查结果
    FuEditText et_coronaryArteryResult;//冠状动脉造影结果
    FuEditText et_ecgExerciseResult;//心电图运动负荷试验结果
    FuEditText et_cardiacEnzymesResult;//心肌酶学检查结果
    LinearLayout ll_smokingStatusCode;//吸烟情况
    LinearLayout ll_drinkingFreqCode;//饮酒情况
    LinearLayout ll_exerciseFreqCode;//体育锻炼
    LinearLayout ll_selfCareAssessCode;//生活自理能力
    LinearLayout ll_hasUseDrugs;//用药情况
    FuButton f_medicine_save;//添加
    Spinner sp_drugName;//药物名称
    Spinner sp_drugUsingFreq;//用法
    FuEditText et_drugPerDose;//每次剂量
    Spinner sp_unit; //单位
    net.greatsoft.main.view.FuListView lv_coronaryHeartInfo;//用药集合
    LinearLayout ll_drugComplianceCode;//服药依从性
    LinearLayout ll_teshuzhiliao;//特殊治疗
    LinearLayout ll_feiyaowu;//非药物治疗措施
    LinearLayout ll_hasEndManage;//是否终止管理
    FuTextView tv_endManageDate;//终止管理日期
    LinearLayout ll_endManageReason;//终止管理原因
    FuTextView tv_userCreateTime;//建卡日期

    TextView fu_title_center;
    Button fu_title_right_btn;

    List<ChdInfoDrugs> mDrugList;

    FuCoronaryHeartInfoAdapter mCoronaryHeartInfoAdapter;

    public FuCoronaryHeartInfoView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {

        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_coronaryheart_info_view, null);

        mDrugList = new ArrayList<>();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_confirmDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_checkDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_endManageDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_userCreateTime:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuCoronaryHeartInfoFragment.EVENT_SAVE_CONARANYHEART_INFO, null);
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
                mDrugList.add(chdInfoDrugs);
                mCoronaryHeartInfoAdapter.notifyDataSetChanged();
                et_drugPerDose.setText("");
                break;
        }
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

        initCheckBoxSimple("MEMBERPROFESSION", ll_zhiye, 1);// 职业
        setRadioOrCheckBoxEnabel(ll_zhiye);
        initCheckBoxMany("chdFamilyHistory", ll_jiazushi, 4);//家族史
        initCheckBoxMany("chdSymptoms2", ll_zhengZhuang, 3);//目前症状
        initCheckBoxMany("chdMedicalHistory", ll_bingshi, 3);//病史
        initCheckBoxMany("chdSpecialTreatment", ll_teshuzhiliao, 4);//特殊治疗
        initCheckBoxMany("chdDrugTreatment", ll_feiyaowu, 3);//非药物治疗措施
        initCheckBoxSimple("manageGroup2", ll_manageGroup, 0);// 管理组别
        initCheckBoxSimple("caseSource", ll_caseSource, 1);// 病例来源
        initCheckBoxSimple("heartDiseaseType", ll_heartDiseaseType, 2);// 冠心病类型
        initCheckBoxSimple("smokingStatusCode", ll_smokingStatusCode, 0);// 吸烟情况
        initCheckBoxSimple("drinkingFreqCode", ll_drinkingFreqCode, 0);// 饮酒情况
        initCheckBoxSimple("exerciseFreqCode", ll_exerciseFreqCode, 0);// 体育锻炼
        initCheckBoxSimple("selfCareAssessCode", ll_selfCareAssessCode, 0);// 生活自理能力
        initCheckBoxSimple("hasUseDrugs", ll_hasUseDrugs, 0);// 用药情况
        initCheckBoxSimple("drugComplianceCode", ll_drugComplianceCode, 0);// 服药依从性
        initCheckBoxSimple("hasEndManage", ll_hasEndManage, 0);// 是否终止管理
        initCheckBoxSimple("endManageReason", ll_endManageReason, 0);// 终止管理原因


    }

    @Override
    protected void initWidget() {

        findView();

        mCoronaryHeartInfoAdapter = new FuCoronaryHeartInfoAdapter();
        lv_coronaryHeartInfo.setAdapter(mCoronaryHeartInfoAdapter);

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("冠心病专档");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    public void setData(PersonInfo personInfo) {

        tv_name.setText(personInfo.getName());//姓名
        tv_sex.setText(personInfo.getSexValue());//性别
        tv_birthDate.setText(personInfo.getBirthday());//出生日期
        tv_telNo.setText(personInfo.getTelNo());//联系电话
        tv_idNo.setText(personInfo.getIdNo());//身份证号
        setCheckBoxSelect(personInfo.getOccupationCode(), ll_zhiye);//职业
        tv_houseAdress.setText(personInfo.getHouseholdAddress());//家庭地址
        et_heartDiseaseInfoNo.setText(personInfo.getPersonInfoNo());//管理卡编号

    }

    public boolean saveData(CoronaryHeartDiseaseInfo coronaryInfo) {

        if ("".equals(tv_confirmDate.getText())) {
            ToastUtil.showToast(mContext, "请填写确诊日期", Toast.LENGTH_LONG);
            return false;
        }

        coronaryInfo.setHeartDiseaseInfoNo(et_heartDiseaseInfoNo.getString());//管理卡编号
        coronaryInfo.setManageGroup(getCheckBoxSimpleCode(ll_manageGroup));//管理组别
        coronaryInfo.setCaseSource(getCheckBoxSimpleCode(ll_caseSource));//病例来源
        saveCheckBoxMany(null, coronaryInfo.getRecordChoice(), ll_jiazushi);//家族史
        coronaryInfo.setConfirmDate(tv_confirmDate.getDate());//冠心病确诊日期
        coronaryInfo.setConfirmOrgName(et_confirmOrgName.getString());//确诊机构
        coronaryInfo.setHeartDiseaseType(getCheckBoxSimpleCode(ll_heartDiseaseType));//冠心病类型
        saveCheckBoxMany(null, coronaryInfo.getRecordChoice(), ll_zhengZhuang);//目前症状
        saveCheckBoxMany(null, coronaryInfo.getRecordChoice(), ll_bingshi);//病史
        coronaryInfo.setHeight(et_height.getDouble());//身高
        coronaryInfo.setWeight(et_weight.getDouble());//体重
        coronaryInfo.setBmi(et_bmi.getDouble());//BMI
        coronaryInfo.setHeartRate(et_heartRate.getInt());//心率
        coronaryInfo.setSbp(et_sbp.getInt());//血压值
        coronaryInfo.setDbp(et_dbp.getInt());//血压值
        coronaryInfo.setFbgMmol(et_fbgMmol.getDouble());//空腹血糖
        coronaryInfo.setHdlc(et_hdlc.getDouble());//高密度脂蛋白
        coronaryInfo.setLdlc(et_ldlc.getDouble());//低密度脂蛋白
        coronaryInfo.setWaist(et_waist.getDouble());//腰围
        coronaryInfo.setTg(et_tg.getDouble());//甘油三酯
        coronaryInfo.setTcho(et_tcho.getDouble());//胆固醇
        coronaryInfo.setCheckDate(tv_checkDate.getDate());//体检日期
        coronaryInfo.setEcgAbnormResult(et_ecgAbnormResult.getString());//心电图检查结果
        coronaryInfo.setHeartCheckResult(et_heartCheckResult.getString());//心脏彩超检查结果
        coronaryInfo.setCoronaryArteryResult(et_coronaryArteryResult.getString());//冠状动脉造影结果
        coronaryInfo.setEcgExerciseResult(et_ecgExerciseResult.getString());//心电图运动负荷试验结果
        coronaryInfo.setCardiacEnzymesResult(et_cardiacEnzymesResult.getString());//心肌酶学检查结果
        coronaryInfo.setSmokingStatusCode(getCheckBoxSimpleCode(ll_smokingStatusCode));//吸烟情况
        coronaryInfo.setDrinkingFreqCode(getCheckBoxSimpleCode(ll_drinkingFreqCode));//饮酒情况
        coronaryInfo.setExerciseFreqCode(getCheckBoxSimpleCode(ll_exerciseFreqCode));//体育锻炼
        coronaryInfo.setSelfCareAssessCode(getCheckBoxSimpleCode(ll_selfCareAssessCode));//生活自理能力
        coronaryInfo.setHasUseDrugs(getCheckBoxSimpleCode(ll_hasUseDrugs));//用药情况
        coronaryInfo.getChdInfoDrug().addAll(mDrugList);//用药
        coronaryInfo.setDrugComplianceCode(getCheckBoxSimpleCode(ll_drugComplianceCode));//服药依从性
        saveCheckBoxMany(null, coronaryInfo.getRecordChoice(), ll_teshuzhiliao);//特殊治疗
        saveCheckBoxMany(null, coronaryInfo.getRecordChoice(), ll_feiyaowu);//非药物治疗措施
        coronaryInfo.setHasEndManage(getCheckBoxSimpleCode(ll_hasEndManage));//是否终止管理
        coronaryInfo.setEndManageDate(tv_endManageDate.getDate());//终止管理日期
        coronaryInfo.setEndManageReason(getCheckBoxSimpleCode(ll_endManageReason));//终止管理原因
        coronaryInfo.setUserCreateTime(tv_userCreateTime.getDate());//建卡日期

        return true;
    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name);//姓名
        tv_sex = (FuTextView) mFuView.findViewById(R.id.tv_sex);//性别
        tv_birthDate = (FuTextView) mFuView.findViewById(R.id.tv_birthDate);//出生日期
        tv_telNo = (FuTextView) mFuView.findViewById(R.id.tv_telNo);//联系电话
        tv_idNo = (FuTextView) mFuView.findViewById(R.id.tv_idNo);//身份证号
        ll_zhiye = (LinearLayout) mFuView.findViewById(R.id.ll_zhiye);//职业
        tv_houseAdress = (FuTextView) mFuView.findViewById(R.id.tv_houseAdress);//家庭地址
        et_heartDiseaseInfoNo = (FuEditText) mFuView.findViewById(R.id.et_heartDiseaseInfoNo);//管理卡编号
        ll_manageGroup = (LinearLayout) mFuView.findViewById(R.id.ll_manageGroup);//管理组别
        ll_caseSource = (LinearLayout) mFuView.findViewById(R.id.ll_caseSource);//病例来源
        ll_jiazushi = (LinearLayout) mFuView.findViewById(R.id.ll_jiazushi);//家族史
        tv_confirmDate = (FuTextView) mFuView.findViewById(R.id.tv_confirmDate);//冠心病确诊日期
        tv_confirmDate.setOnClickListener(this);
        et_confirmOrgName = (FuEditText) mFuView.findViewById(R.id.et_confirmOrgName);//确诊机构
        ll_heartDiseaseType = (LinearLayout) mFuView.findViewById(R.id.ll_heartDiseaseType);//冠心病类型
        ll_zhengZhuang = (LinearLayout) mFuView.findViewById(R.id.ll_zhengZhuang);//目前症状
        ll_bingshi = (LinearLayout) mFuView.findViewById(R.id.ll_bingshi);//病史
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height);//身高
        et_height.setOnFocusChangeListener(this);
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight);//体重
        et_weight.setOnFocusChangeListener(this);
        et_bmi = (FuEditText) mFuView.findViewById(R.id.et_bmi);//BMI
        et_heartRate = (FuEditText) mFuView.findViewById(R.id.et_heartRate);//心率
        et_sbp = (FuEditText) mFuView.findViewById(R.id.et_sbp);//血压值
        et_dbp = (FuEditText) mFuView.findViewById(R.id.et_dbp);//血压值
        et_fbgMmol = (FuEditText) mFuView.findViewById(R.id.et_fbgMmol);//空腹血糖
        et_hdlc = (FuEditText) mFuView.findViewById(R.id.et_hdlc);//高密度脂蛋白
        et_ldlc = (FuEditText) mFuView.findViewById(R.id.et_ldlc);//低密度脂蛋白
        et_waist = (FuEditText) mFuView.findViewById(R.id.et_waist);//腰围
        et_tg = (FuEditText) mFuView.findViewById(R.id.et_tg);//甘油三酯
        et_tcho = (FuEditText) mFuView.findViewById(R.id.et_tcho);//胆固醇
        tv_checkDate = (FuTextView) mFuView.findViewById(R.id.tv_checkDate);//体检日期
        tv_checkDate.setOnClickListener(this);
        et_ecgAbnormResult = (FuEditText) mFuView.findViewById(R.id.et_ecgAbnormResult);//心电图检查结果
        et_heartCheckResult = (FuEditText) mFuView.findViewById(R.id.et_heartCheckResult);//心脏彩超检查结果
        et_coronaryArteryResult = (FuEditText) mFuView.findViewById(R.id.et_coronaryArteryResult);//冠状动脉造影结果
        et_ecgExerciseResult = (FuEditText) mFuView.findViewById(R.id.et_ecgExerciseResult);//心电图运动负荷试验结果
        et_cardiacEnzymesResult = (FuEditText) mFuView.findViewById(R.id.et_cardiacEnzymesResult);//心肌酶学检查结果
        ll_smokingStatusCode = (LinearLayout) mFuView.findViewById(R.id.ll_smokingStatusCode);//吸烟情况
        ll_drinkingFreqCode = (LinearLayout) mFuView.findViewById(R.id.ll_drinkingFreqCode);//饮酒情况
        ll_exerciseFreqCode = (LinearLayout) mFuView.findViewById(R.id.ll_exerciseFreqCode);//体育锻炼
        ll_selfCareAssessCode = (LinearLayout) mFuView.findViewById(R.id.ll_selfCareAssessCode);//生活自理能力
        ll_hasUseDrugs = (LinearLayout) mFuView.findViewById(R.id.ll_hasUseDrugs);//用药情况
        f_medicine_save = (FuButton) mFuView.findViewById(R.id.f_medicine_save);//添加
        f_medicine_save.setOnClickListener(this);
        sp_drugName = (Spinner) mFuView.findViewById(R.id.sp_drugName);//药物名称
        sp_drugUsingFreq = (Spinner) mFuView.findViewById(R.id.sp_drugUsingFreq);//用法
        et_drugPerDose = (FuEditText) mFuView.findViewById(R.id.et_drugPerDose);//每次剂量
        sp_unit = (Spinner) mFuView.findViewById(R.id.sp_unit); //单位
        lv_coronaryHeartInfo = (net.greatsoft.main.view.FuListView) mFuView.findViewById(R.id.lv_coronaryHeartInfo);//用药集合
        ll_drugComplianceCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugComplianceCode);//服药依从性
        ll_teshuzhiliao = (LinearLayout) mFuView.findViewById(R.id.ll_teshuzhiliao);//特殊治疗
        ll_feiyaowu = (LinearLayout) mFuView.findViewById(R.id.ll_feiyaowu);//非药物治疗措施
        ll_hasEndManage = (LinearLayout) mFuView.findViewById(R.id.ll_hasEndManage);//是否终止管理
        tv_endManageDate = (FuTextView) mFuView.findViewById(R.id.tv_endManageDate);//终止管理日期
        tv_endManageDate.setOnClickListener(this);
        ll_endManageReason = (LinearLayout) mFuView.findViewById(R.id.ll_endManageReason);//终止管理原因
        tv_userCreateTime = (FuTextView) mFuView.findViewById(R.id.tv_userCreateTime);//建卡日期
        tv_userCreateTime.setOnClickListener(this);

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

            case R.id.et_height:
                if (!hasFocus) {
                    if (!et_height.getString().isEmpty() && !et_weight.getString().isEmpty()) {
                        double tizhi = et_weight.getDouble() / (et_height.getDouble() * et_height.getDouble()) * 10000;
                        et_bmi.setText(String.format("%.2f", tizhi));
                    }
                }
                break;
        }
    }

    class FuCoronaryHeartInfoAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public FuCoronaryHeartInfoAdapter() {
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
            holder.tv_name.setText(mDrugList.get(position).getDrugName());
            holder.tv_num.setText(mDrugList.get(position).getDrugUsingFreq());
            holder.tv_dose.setText(mDrugList.get(position).getDrugPerDose()+mDrugList.get(position).getUnit());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setTag(mDrugList.get(position));
            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrugList.remove(position);
                    mCoronaryHeartInfoAdapter.notifyDataSetChanged();
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
}
