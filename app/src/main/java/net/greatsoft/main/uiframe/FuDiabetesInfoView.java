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
import net.greatsoft.main.db.po.diabetes.DiabetesInfo;
import net.greatsoft.main.db.po.diabetes.DiabetesInfoComp;
import net.greatsoft.main.db.po.diabetes.DiabetesInfoDrug;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuDiabetesInfoFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuListView;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2017/03/09
 * Time: 17:23
 * progject: Chss
 * Describe： 糖尿病专档
 */

public class FuDiabetesInfoView extends FuUiFrameModel implements View.OnClickListener, View.OnFocusChangeListener {

    FuTextView tv_name;//患者姓名
    FuTextView tv_birthDate;//出生日期
    FuTextView tv_sex;//性别
    FuTextView tv_minzu;//民族
    FuTextView tv_cardNo;//身份证号
    LinearLayout ll_hunyin;//婚姻状况
    LinearLayout ll_xuexing;//血型
    FuEditText tv_householder;//籍贯
    LinearLayout ll_zhiye;//职业状况
    LinearLayout ll_wenhua;//文化程度
    FuEditText et_familyTel;//家庭电话
    FuTextView tv_houseAdress;//家庭住址
    FuTextView tv_danwei;//工作单位
    FuEditText et_companyTel;//单位电话
    LinearLayout ll_yiliao;//付费方式
    FuEditText et_healthcareOrg;//定点医疗单位
    FuEditText et_personalHistory;//个人史
    FuEditText et_diseaseHistory;//现病史
    FuEditText et_dmFamilyHistory;//糖尿病家族史
    FuEditText et_allergicHistory;//过敏史
    FuTextView tv_diagnoseDate;//确诊时间
    LinearLayout ll_diagnoseModeCode;//确诊方式
    FuEditText et_diagnoseOrgName;//确诊单位
    LinearLayout ll_diagnoseHyperCode;//高血压
    LinearLayout ll_diagnoseRetionopathyCode;//视网膜病变
    LinearLayout ll_diagnoseDmFootCode;//糖尿病足
    LinearLayout ll_diagnoseDnCode;//糖尿病肾病
    LinearLayout ll_diagnoseNeuropathyCode;//糖尿病神经病变
    LinearLayout ll_diagnoseHyperlipidemiaCode;//高血脂
    LinearLayout ll_diagnoseAmiCode;//冠心病（心肌梗死）
    LinearLayout ll_diagnoseStrokeCode;//脑卒中
    FuEditText et_pastFbg;//既往空腹血糖
    FuEditText et_pastPbg;//既往餐后2小时血糖
    FuEditText et_pastGhb;//既往糖化血红蛋白
    LinearLayout ll_smokingCode;//吸烟
    FuEditText et_dailySmoking;//平均每日
    LinearLayout ll_drinkingCode;//饮酒
    FuEditText et_dailyDrinking;//平均每日
    FuButton bt_sure;//确认
    Spinner sp_jibingleixing;//疾病类型
    FuTextView tv_jibingData;//诊断时间
    FuEditText et_zhiliaofangshi;//治疗方式
    net.greatsoft.main.view.FuListView lv_bingfazheng;//并发症情况
    FuEditText et_height;//身高
    FuEditText et_weight;//体重
    FuEditText et_bmi;//体质指数
    FuEditText et_fbg;//空腹血糖
    FuEditText et_pbg;//餐后血糖
    FuEditText et_ghb;//糖化血红蛋白
    FuEditText et_tg;//甘油三酯
    FuEditText et_sbp;//血压
    FuEditText et_dbp;//血压
    FuEditText et_tcho;//总胆固醇
    FuEditText et_ldlc;//低密度脂蛋白胆固醇(LDL-C)
    FuEditText et_hdlc;//高密度脂蛋白胆固醇(HDL-C)
    LinearLayout ll_dmFootCode;//糖尿病足
    LinearLayout ll_urineMalb;//尿微量白蛋白
    LinearLayout ll_retionopathyCode;//视网膜病变
    LinearLayout ll_neuropathyCode;//神经病变
    LinearLayout ll_exerciseCode;//体力活动
    FuEditText et_exerciseFreqCode;//每次
    FuEditText et_exerciseDurationMins;//分钟
    LinearLayout ll_takeMedicineCode;//口服降糖药
    LinearLayout ll_dietControlCode;//饮食控制
    FuButton f_medicine_save;//用药
    Spinner sp_drugName;//药物名称
    Spinner sp_drugUsingFreq;//用法
    FuEditText et_drugPerDose;//每次剂量
    net.greatsoft.main.view.FuListView lv_diabetsInfo;//用药合集
    LinearLayout ll_insulinCode;//胰岛素
    FuEditText et_insulinType;//胰岛素种类
    FuEditText et_insulinPerDose;//用量
    LinearLayout ll_stopSmokingCode;//戒烟
    LinearLayout ll_limitAlcoholCode;//限酒
    Spinner sp_respDoctorId;//建档医生
    FuTextView tv_userCreateTime;//建档日期

    TextView fu_title_center;
    Button fu_title_right_btn;

    FuDiabetesInfoAdapter mDiabetesInfoAdapter;
    FuDiabetesInfoCompAdapter mDiabetesInfoCompAdapter;

    List<Emp> empList;//随访医生
    List<DiabetesInfoDrug> mDrugList;
    List<DiabetesInfoComp> mCompList;

    public FuDiabetesInfoView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_diabetesinfo_view, null);

        mDrugList = new ArrayList<>();
        mCompList = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_diagnoseDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_userCreateTime:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_jibingData:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.f_medicine_save:
                SpinnerItem spinnerItem = (SpinnerItem) sp_drugName.getSelectedItem();

                DiabetesInfoDrug diabetesInfoDrug = new DiabetesInfoDrug();
                diabetesInfoDrug.setDrugId(spinnerItem.getId());
                diabetesInfoDrug.setDrugName(spinnerItem.getValue());


                Checks checks = (Checks) sp_drugUsingFreq.getSelectedItem();
                diabetesInfoDrug.setDrugUsingFreq(checks.getCode()); //用法
                diabetesInfoDrug.setDrugPerDose(et_drugPerDose.getString()); //每次剂量
                mDrugList.add(diabetesInfoDrug);
                mDiabetesInfoAdapter.notifyDataSetChanged();
                et_drugPerDose.setText("");
                break;
            case R.id.bt_sure:
                Checks checks1 = (Checks) sp_jibingleixing.getSelectedItem();
                DiabetesInfoComp diabetesInfoComp = new DiabetesInfoComp();
                diabetesInfoComp.setComplication(checks1.getValue());//疾病类型
                diabetesInfoComp.setComplicationId(checks1.getCode());
                diabetesInfoComp.setDiagnoseDate(tv_jibingData.getDate());//时间
                diabetesInfoComp.setTreatmentMethod(et_zhiliaofangshi.getString());//治疗方式
                mCompList.add(diabetesInfoComp);
                mDiabetesInfoCompAdapter.notifyDataSetChanged();
                tv_jibingData.setText("");
                et_zhiliaofangshi.setText("");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuDiabetesInfoFragment.EVENT_SAVE_DIABETESINFO, null);
                break;

        }

    }

    @Override
    protected void initFuData() {

        //用法
        List<Checks> num = Constant.getMedicineNum();
        ArrayAdapter<?> adapter2 = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                num);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_drugUsingFreq.setAdapter(adapter2);

        //疾病类型
        List<Checks> comp = Constant.getDiabetesInfoComp();
        ArrayAdapter<?> adapter3 = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                comp);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_jibingleixing.setAdapter(adapter3);

        initCheckBoxSimple("MARRIAGESTATUS", ll_hunyin, 5);// 婚姻
        setRadioOrCheckBoxEnabel(ll_hunyin);
        // 血型
        initCheckBoxSimple("aboCode", ll_xuexing, 5);
        setRadioOrCheckBoxEnabel(ll_xuexing);
        // 职业
        initCheckBoxSimple("MEMBERPROFESSION", ll_zhiye, 1);
        setRadioOrCheckBoxEnabel(ll_zhiye);
        // 文化程度
        initCheckBoxSimple("CULTUREDEGREE", ll_wenhua, 3);
        setRadioOrCheckBoxEnabel(ll_wenhua);
        // 医疗费用
        initCheckBoxMany("medicalPayWay", ll_yiliao, 2, false, true);
        setRadioOrCheckBoxEnabel(ll_yiliao);
        initCheckBoxSimple("diagnoseModeCode", ll_diagnoseModeCode, 3);//确诊方式
        initCheckBoxSimple("notHas", ll_diagnoseHyperCode, 2);//高血压
        initCheckBoxSimple("notHas", ll_diagnoseRetionopathyCode, 2);//视网膜病变
        initCheckBoxSimple("notHas", ll_diagnoseDmFootCode, 2);//糖尿病足
        initCheckBoxSimple("notHas", ll_diagnoseDnCode, 2);//糖尿病肾病
        initCheckBoxSimple("notHas", ll_diagnoseNeuropathyCode, 2);//糖尿病神经病变
        initCheckBoxSimple("notHas", ll_diagnoseHyperlipidemiaCode, 2);//高血脂
        initCheckBoxSimple("notHas", ll_diagnoseAmiCode, 2);//冠心病（心肌梗死）
        initCheckBoxSimple("notHas", ll_diagnoseStrokeCode, 2);//脑卒中
        initCheckBoxSimple("notHas", ll_smokingCode, 2);//吸烟
        initCheckBoxSimple("notHas", ll_drinkingCode, 2);//饮酒
        initCheckBoxSimple("notHas", ll_dmFootCode, 2);//糖尿病足
        initCheckBoxSimple("notHas", ll_urineMalb, 2);//尿微量白蛋白
        initCheckBoxSimple("notHas", ll_retionopathyCode, 2);//视网膜病变
        initCheckBoxSimple("notHas", ll_neuropathyCode, 2);//神经病变
        initCheckBoxSimple("notHas", ll_exerciseCode, 2);//神经病变
        initCheckBoxSimple("notHas", ll_takeMedicineCode, 2);//口服降糖药
        initCheckBoxSimple("notHas", ll_insulinCode, 2);//胰岛素
        initCheckBoxSimple("notHas", ll_stopSmokingCode, 2);//戒烟
        initCheckBoxSimple("notHas", ll_dietControlCode, 2);//饮食控制
        initCheckBoxSimple("notHas", ll_limitAlcoholCode, 2);//限酒


        empList = sqlHelper.getEmpDao().queryBuilder().list();
        ArrayAdapter adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_respDoctorId.setAdapter(adapter);

    }

    @Override
    protected void initWidget() {

        findView();

        mDiabetesInfoAdapter = new FuDiabetesInfoAdapter();
        lv_diabetsInfo.setAdapter(mDiabetesInfoAdapter);

        mDiabetesInfoCompAdapter = new FuDiabetesInfoCompAdapter();
        lv_bingfazheng.setAdapter(mDiabetesInfoCompAdapter);

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("糖尿病专档");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);
    }

    public void setData(PersonInfo personInfo) {
        tv_name.setText(personInfo.getName());//姓名
        tv_sex.setText(personInfo.getSexValue());//性别
        tv_minzu.setText(personInfo.getNationalityValue());//民族
        tv_birthDate.setText(personInfo.getBirthday());//出生日期
//        String str = personInfo.getHouseholdAddress();//为了防止java指针指向错位导致空值
//        Log.e("aaa", str);
        tv_danwei.setText(personInfo.getWorkUnit());//工作单位
        tv_cardNo.setText(personInfo.getIdNo());//身份证号
        setCheckBoxSelect(personInfo.getMarriageCode(), ll_hunyin);//婚姻状况
        setCheckBoxSelect(personInfo.getEducationCode(), ll_wenhua);//文化程度
        setCheckBoxSelect(personInfo.getOccupationCode(), ll_zhiye);////职业状况
        setCheckBoxSelect(personInfo.getAboCode(), ll_xuexing);//血型
        tv_houseAdress.setText(personInfo.getAddress());//家庭住址
        setCheckBoxSelect("medicalPayWay", personInfo.getRecordChoice(), ll_yiliao);//医疗费用支付方式
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

    public boolean saveData(DiabetesInfo diabetesInfo) {

        if ("".equals(tv_diagnoseDate.getText())) {
            ToastUtil.showToast(mContext, "请输入确诊时间", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_diagnoseModeCode))) {
            ToastUtil.showToast(mContext, "请选择确诊方式", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_pastFbg.getText())) {
            ToastUtil.showToast(mContext, "请输入既往空腹血糖", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(tv_userCreateTime.getText())) {
            ToastUtil.showToast(mContext, "请输入建档日期", Toast.LENGTH_LONG);
            return false;
        }

        diabetesInfo.setHouseholdRegister(tv_householder.getString());//籍贯
        diabetesInfo.setFamilyTel(et_familyTel.getString());//家庭电话
        diabetesInfo.setCompanyTel(et_companyTel.getString());//单位电话
        diabetesInfo.setHealthcareOrg(et_healthcareOrg.getString());//定点医疗单位
        diabetesInfo.setPersonalHistory(et_personalHistory.getString());//个人史
        diabetesInfo.setDiseaseHistory(et_diseaseHistory.getString());//现病史
        diabetesInfo.setDmFamilyHistory(et_dmFamilyHistory.getString());//糖尿病家族史
        diabetesInfo.setAllergicHistory(et_allergicHistory.getString());//过敏史
        diabetesInfo.setDiagnoseDate(tv_diagnoseDate.getDate());//确诊时间
        diabetesInfo.setDiagnoseModeCode(getCheckBoxSimpleCode(ll_diagnoseModeCode));//确诊方式
        diabetesInfo.setDiagnoseOrgName(et_diagnoseOrgName.getString());//确诊单位
        diabetesInfo.setDiagnoseHyperCode(getCheckBoxSimpleCode(ll_diagnoseHyperCode));//高血压
        diabetesInfo.setDiagnoseRetionopathyCode(getCheckBoxSimpleCode(ll_diagnoseRetionopathyCode));//视网膜病变
        diabetesInfo.setDiagnoseDmFootCode(getCheckBoxSimpleCode(ll_diagnoseDmFootCode));//糖尿病足
        diabetesInfo.setDiagnoseDnCode(getCheckBoxSimpleCode(ll_diagnoseDnCode));//糖尿病肾病
        diabetesInfo.setDiagnoseNeuropathyCode(getCheckBoxSimpleCode(ll_diagnoseNeuropathyCode));//糖尿病神经病变
        diabetesInfo.setDiagnoseHyperlipidemiaCode(getCheckBoxSimpleCode(ll_diagnoseHyperlipidemiaCode));//高血脂
        diabetesInfo.setDiagnoseAmiCode(getCheckBoxSimpleCode(ll_diagnoseAmiCode));//冠心病（心肌梗死）
        diabetesInfo.setDiagnoseStrokeCode(getCheckBoxSimpleCode(ll_diagnoseStrokeCode));//脑卒中
        diabetesInfo.setPastFbg(et_pastFbg.getDouble());//既往空腹血糖
        diabetesInfo.setPastPbg(et_pastPbg.getDouble());//既往餐后2小时血糖
        diabetesInfo.setPastGhb(et_pastGhb.getDouble());//既往糖化血红蛋白
        diabetesInfo.setSmokingCode(getCheckBoxSimpleCode(ll_smokingCode));//吸烟
        diabetesInfo.setDailySmoking(et_dailySmoking.getInt());//平均每日
        diabetesInfo.setDrinkingCode(getCheckBoxSimpleCode(ll_drinkingCode));//饮酒
        diabetesInfo.setDailyDrinking(et_dailyDrinking.getInt());//平均每日
        diabetesInfo.setHeight(et_height.getDouble());//身高
        diabetesInfo.setWeight(et_weight.getDouble());//体重
        diabetesInfo.setBmi(et_bmi.getDouble());//体质指数
        diabetesInfo.setFbg(et_fbg.getDouble());//空腹血糖
        diabetesInfo.setPbg(et_pbg.getDouble());//餐后血糖
        diabetesInfo.setGhb(et_ghb.getDouble());//糖化血红蛋白
        diabetesInfo.setTg(et_tg.getDouble());//甘油三酯
        diabetesInfo.setSbp(et_sbp.getInt());//血压
        diabetesInfo.setDbp(et_dbp.getInt());
        diabetesInfo.setTcho(et_tcho.getDouble());//总胆固醇
        diabetesInfo.setLdlc(et_ldlc.getDouble());//低密度脂蛋白胆固醇(LDL-C)
        diabetesInfo.setHdlc(et_hdlc.getDouble());//高密度脂蛋白胆固醇(HDL-C)
        diabetesInfo.setDmFootCode(getCheckBoxSimpleCode(ll_dmFootCode));//糖尿病足
        if (getCheckBoxSimpleCode(ll_urineMalb) != null && !"".equals(getCheckBoxSimpleCode(ll_urineMalb)))
            diabetesInfo.setUrineMalb(Double.valueOf(getCheckBoxSimpleCode(ll_urineMalb)));//尿微量白蛋白
        diabetesInfo.setRetionopathyCode(getCheckBoxSimpleCode(ll_retionopathyCode));//视网膜病变
        diabetesInfo.setNeuropathyCode(getCheckBoxSimpleCode(ll_neuropathyCode));//神经病变
        diabetesInfo.setExerciseCode(getCheckBoxSimpleCode(ll_exerciseCode));//体力活动
        diabetesInfo.setExerciseFreqCode(et_exerciseFreqCode.getInt());//每次
        diabetesInfo.setExerciseDurationMins(et_exerciseDurationMins.getInt());//分钟
        diabetesInfo.setTakeMedicineCode(getCheckBoxSimpleCode(ll_takeMedicineCode));//口服降糖药
        diabetesInfo.setDietControlCode(getCheckBoxSimpleCode(ll_dietControlCode));//饮食控制
        diabetesInfo.setInsulinCode(getCheckBoxSimpleCode(ll_insulinCode));//胰岛素
        diabetesInfo.setInsulinType(et_insulinType.getString());//胰岛素种类
        diabetesInfo.setInsulinPerDose(et_insulinPerDose.getString());//用量
        diabetesInfo.setStopSmokingCode(getCheckBoxSimpleCode(ll_stopSmokingCode));//戒烟
        diabetesInfo.setLimitAlcoholCode(getCheckBoxSimpleCode(ll_limitAlcoholCode));//限酒

        Emp emp = (Emp) sp_respDoctorId.getSelectedItem();//建档医生
        if (emp != null) {
            diabetesInfo.setRespDoctorId(emp.getEmp_id());
            diabetesInfo.setRespDoctorName(emp.getEmp_name());
        }
        diabetesInfo.setUserCreateTime(tv_userCreateTime.getDate());//建档日期
        diabetesInfo.getDiabetesInfoDrug().addAll(mDrugList);
        diabetesInfo.getDiabetesInfoComp().addAll(mCompList);

        return true;
    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name);//患者姓名
        tv_birthDate = (FuTextView) mFuView.findViewById(R.id.tv_birthDate);//出生日期
        tv_sex = (FuTextView) mFuView.findViewById(R.id.tv_sex);//性别
        tv_minzu = (FuTextView) mFuView.findViewById(R.id.tv_minzu);//民族
        tv_cardNo = (FuTextView) mFuView.findViewById(R.id.tv_cardNo);//身份证号
        ll_hunyin = (LinearLayout) mFuView.findViewById(R.id.ll_hunyin);//婚姻状况
        ll_xuexing = (LinearLayout) mFuView.findViewById(R.id.ll_xuexing);//血型
        tv_householder = (FuEditText) mFuView.findViewById(R.id.tv_householder);//籍贯
        ll_zhiye = (LinearLayout) mFuView.findViewById(R.id.ll_zhiye);//职业状况
        ll_wenhua = (LinearLayout) mFuView.findViewById(R.id.ll_wenhua);//文化程度
        et_familyTel = (FuEditText) mFuView.findViewById(R.id.et_familyTel);//家庭电话
        tv_houseAdress = (FuTextView) mFuView.findViewById(R.id.tv_houseAdress);//家庭住址
        tv_danwei = (FuTextView) mFuView.findViewById(R.id.tv_danwei);//工作单位
        et_companyTel = (FuEditText) mFuView.findViewById(R.id.et_companyTel);//单位电话
        ll_yiliao = (LinearLayout) mFuView.findViewById(R.id.ll_yiliao);//付费方式
        et_healthcareOrg = (FuEditText) mFuView.findViewById(R.id.et_healthcareOrg);//定点医疗单位
        et_personalHistory = (FuEditText) mFuView.findViewById(R.id.et_personalHistory);//个人史
        et_diseaseHistory = (FuEditText) mFuView.findViewById(R.id.et_diseaseHistory);//现病史
        et_dmFamilyHistory = (FuEditText) mFuView.findViewById(R.id.et_dmFamilyHistory);//糖尿病家族史
        et_allergicHistory = (FuEditText) mFuView.findViewById(R.id.et_allergicHistory);//过敏史
        tv_diagnoseDate = (FuTextView) mFuView.findViewById(R.id.tv_diagnoseDate);//确诊时间
        tv_diagnoseDate.setOnClickListener(this);
        ll_diagnoseModeCode = (LinearLayout) mFuView.findViewById(R.id.ll_diagnoseModeCode);//确诊方式
        et_diagnoseOrgName = (FuEditText) mFuView.findViewById(R.id.et_diagnoseOrgName);//确诊单位

        ll_diagnoseHyperCode = (LinearLayout) mFuView.findViewById(R.id.ll_diagnoseHyperCode);//高血压
        ll_diagnoseRetionopathyCode = (LinearLayout) mFuView.findViewById(R.id.ll_diagnoseRetionopathyCode);//视网膜病变
        ll_diagnoseDmFootCode = (LinearLayout) mFuView.findViewById(R.id.ll_diagnoseDmFootCode);//糖尿病足
        ll_diagnoseDnCode = (LinearLayout) mFuView.findViewById(R.id.ll_diagnoseDnCode);//糖尿病肾病
        ll_diagnoseNeuropathyCode = (LinearLayout) mFuView.findViewById(R.id.ll_diagnoseNeuropathyCode);//糖尿病神经病变
        ll_diagnoseHyperlipidemiaCode = (LinearLayout) mFuView.findViewById(R.id.ll_diagnoseHyperlipidemiaCode);//高血脂
        ll_diagnoseAmiCode = (LinearLayout) mFuView.findViewById(R.id.ll_diagnoseAmiCode);//冠心病（心肌梗死）
        ll_diagnoseStrokeCode = (LinearLayout) mFuView.findViewById(R.id.ll_diagnoseStrokeCode);//脑卒中
        et_pastFbg = (FuEditText) mFuView.findViewById(R.id.et_pastFbg);//既往空腹血糖
        et_pastPbg = (FuEditText) mFuView.findViewById(R.id.et_pastPbg);//既往餐后2小时血糖
        et_pastGhb = (FuEditText) mFuView.findViewById(R.id.et_pastGhb);//既往糖化血红蛋白
        ll_smokingCode = (LinearLayout) mFuView.findViewById(R.id.ll_smokingCode);//吸烟
        et_dailySmoking = (FuEditText) mFuView.findViewById(R.id.et_dailySmoking);//平均每日
        ll_drinkingCode = (LinearLayout) mFuView.findViewById(R.id.ll_drinkingCode);//饮酒
        et_dailyDrinking = (FuEditText) mFuView.findViewById(R.id.et_dailyDrinking);//平均每日
        bt_sure = (FuButton) mFuView.findViewById(R.id.bt_sure);//确认
        bt_sure.setOnClickListener(this);
        sp_jibingleixing = (Spinner) mFuView.findViewById(R.id.sp_jibingleixing);//疾病类型
        tv_jibingData = (FuTextView) mFuView.findViewById(R.id.tv_jibingData);//诊断时间
        tv_jibingData.setOnClickListener(this);
        et_zhiliaofangshi = (FuEditText) mFuView.findViewById(R.id.et_zhiliaofangshi);//治疗方式
        lv_bingfazheng = (FuListView) mFuView.findViewById(R.id.lv_bingfazheng);//并发症情况
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height);//身高
        et_height.setOnFocusChangeListener(this);
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight);//体重
        et_weight.setOnFocusChangeListener(this);
        et_bmi = (FuEditText) mFuView.findViewById(R.id.et_bmi);//体质指数
        et_fbg = (FuEditText) mFuView.findViewById(R.id.et_fbg);//空腹血糖
        et_pbg = (FuEditText) mFuView.findViewById(R.id.et_pbg);//餐后血糖
        et_ghb = (FuEditText) mFuView.findViewById(R.id.et_ghb);//糖化血红蛋白


        et_tg = (FuEditText) mFuView.findViewById(R.id.et_tg);//甘油三酯
        et_sbp = (FuEditText) mFuView.findViewById(R.id.et_sbp);//血压
        et_dbp = (FuEditText) mFuView.findViewById(R.id.et_dbp);//血压
        et_tcho = (FuEditText) mFuView.findViewById(R.id.et_tcho);//总胆固醇
        et_ldlc = (FuEditText) mFuView.findViewById(R.id.et_ldlc);//低密度脂蛋白胆固醇(LDL-C)
        et_hdlc = (FuEditText) mFuView.findViewById(R.id.et_hdlc);//高密度脂蛋白胆固醇(HDL-C)
        ll_dmFootCode = (LinearLayout) mFuView.findViewById(R.id.ll_dmFootCode);//糖尿病足
        ll_urineMalb = (LinearLayout) mFuView.findViewById(R.id.ll_urineMalb);//尿微量白蛋白
        ll_retionopathyCode = (LinearLayout) mFuView.findViewById(R.id.ll_retionopathyCode);//视网膜病变
        ll_neuropathyCode = (LinearLayout) mFuView.findViewById(R.id.ll_neuropathyCode);//神经病变
        ll_exerciseCode = (LinearLayout) mFuView.findViewById(R.id.ll_exerciseCode);//体力活动
        et_exerciseFreqCode = (FuEditText) mFuView.findViewById(R.id.et_exerciseFreqCode);//每次
        et_exerciseDurationMins = (FuEditText) mFuView.findViewById(R.id.et_exerciseDurationMins);//分钟
        ll_takeMedicineCode = (LinearLayout) mFuView.findViewById(R.id.ll_takeMedicineCode);//口服降糖药
        ll_dietControlCode = (LinearLayout) mFuView.findViewById(R.id.ll_dietControlCode);//饮食控制
        f_medicine_save = (FuButton) mFuView.findViewById(R.id.f_medicine_save);//用药
        f_medicine_save.setOnClickListener(this);
        sp_drugName = (Spinner) mFuView.findViewById(R.id.sp_drugName);//药物名称
        sp_drugUsingFreq = (Spinner) mFuView.findViewById(R.id.sp_drugUsingFreq);//用法
        et_drugPerDose = (FuEditText) mFuView.findViewById(R.id.et_drugPerDose);//每次剂量
        lv_diabetsInfo = (net.greatsoft.main.view.FuListView) mFuView.findViewById(R.id.lv_diabetsInfo);//用药合集
        ll_insulinCode = (LinearLayout) mFuView.findViewById(R.id.ll_insulinCode);//胰岛素
        et_insulinType = (FuEditText) mFuView.findViewById(R.id.et_insulinType);//胰岛素种类
        et_insulinPerDose = (FuEditText) mFuView.findViewById(R.id.et_insulinPerDose);//用量
        ll_stopSmokingCode = (LinearLayout) mFuView.findViewById(R.id.ll_stopSmokingCode);//戒烟
        ll_limitAlcoholCode = (LinearLayout) mFuView.findViewById(R.id.ll_limitAlcoholCode);//限酒
        sp_respDoctorId = (Spinner) mFuView.findViewById(R.id.sp_respDoctorId);//建档医生
        tv_userCreateTime = (FuTextView) mFuView.findViewById(R.id.tv_userCreateTime);//建档日期
        tv_userCreateTime.setOnClickListener(this);

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

    class FuDiabetesInfoAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public FuDiabetesInfoAdapter() {
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
            holder.tv_dose.setText(mDrugList.get(position).getDrugPerDose());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setTag(mDrugList.get(position));
            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrugList.remove(position);
                    mDiabetesInfoAdapter.notifyDataSetChanged();
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

    class FuDiabetesInfoCompAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public FuDiabetesInfoCompAdapter() {
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return mCompList == null ? 0 : mCompList.size();
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
                convertView = mInflater.inflate(R.layout.fu_diabetesinfo_zhiliaoitem, null);
                holder = new Holder();
                holder.tv_name = (FuTextView) convertView.findViewById(R.id.tv_name);
                holder.tv_time = (FuTextView) convertView.findViewById(R.id.tv_time);
                holder.tv_method = (FuTextView) convertView.findViewById(R.id.tv_method);
                holder.tv_delete = (FuTextView) convertView.findViewById(R.id.tv_delete);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            holder.tv_name.setText(mCompList.get(position).getComplication());
            holder.tv_time.setText(mCompList.get(position).getDiagnoseDate());
            holder.tv_method.setText(mCompList.get(position).getTreatmentMethod());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setTag(mCompList.get(position));
            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCompList.remove(position);
                    mDiabetesInfoCompAdapter.notifyDataSetChanged();
                }
            });

            return convertView;
        }

        class Holder {

            FuTextView tv_name; //疾病类型
            FuTextView tv_time; //诊断时间
            FuTextView tv_method;//治疗方式
            FuTextView tv_delete;
        }
    }
}
