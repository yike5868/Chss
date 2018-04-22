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
import net.greatsoft.main.db.po.hyperinfo.HyperInfo;
import net.greatsoft.main.db.po.hyperinfo.HyperInfoDrug;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuHyperInfoFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2017/03/09
 * Time: 10:05
 * progject: Chss
 * Describe： 高血压专档
 */

public class FuHyperInfoView extends FuUiFrameModel implements View.OnClickListener {

    FuTextView tv_name;//姓名
    FuTextView tv_sex;//性别
    FuTextView tv_minzu;//民族
    FuTextView tv_birthday;//出生日期
    FuEditText tv_houseAdress;//籍贯
    FuTextView tv_cardNo;//身份证号
    LinearLayout ll_hunyin;//婚姻状况
    LinearLayout ll_wenhua;//文化程度
    LinearLayout ll_zhiye;//职业状况
    FuTextView tv_adress;//家庭住址
    FuTextView tv_telNo;//联系电话
    LinearLayout ll_yiliao;//医疗费用支付方式
    FuEditText et_healthcareOrg;//定点医疗单位
    LinearLayout ll_hyperManagLevelCode;//高血压管理级别
    LinearLayout ll_hyperTypeCode;//高血压类型
    FuEditText et_diagnoseSbp;//血压
    FuEditText et_diagnoseDbp;//血压
    FuTextView tv_diagnoseDate;//确诊时间
    FuEditText et_diagnoseOrgName;//确诊医院
    FuEditText et_personalHistory;//个人史
    LinearLayout ll_familyDisease;//家族史
    LinearLayout ll_allergicHistoryCode;//过敏史
    LinearLayout ll_nao;//脑血管疾病
    LinearLayout ll_xinzang;//心脏疾病
    LinearLayout ll_shenzang;//肾脏疾病
    LinearLayout ll_xueguan;//血管疾病
    LinearLayout ll_zhongdugao;//重度高血压性视网膜病变
    LinearLayout ll_selfCareCode;//生活自理能力
    LinearLayout ll_smokingCode;//吸烟情况
    LinearLayout ll_drinkingCode;//饮酒情况
    LinearLayout ll_exerciseCode;//体力活动
    FuEditText et_height;//身高
    FuEditText et_weight;//体重
    FuEditText et_pulse;//脉搏
    FuEditText et_heartRate;//心率
    FuEditText et_sbp;//血压
    FuEditText et_dbp;//血压
    FuEditText et_fbg;//血糖(空腹/餐后)
    FuEditText et_pbg;//血糖(空腹/餐后)
    FuEditText et_hdlc;//高/低密度脂蛋白胆固醇
    FuEditText et_ldlc;//高/低密度脂蛋白胆固醇
    FuEditText et_tg;//甘油三酯
    FuEditText et_tcho;//总胆固醇
    LinearLayout ll_retionopathyCode;//视网膜病变
    FuEditText et_urineMalb;//尿微量白蛋白
    LinearLayout ll_neuropathyCode;//神经病变
    FuEditText et_ecgResult;//心电图检查结果
    FuEditText et_othersExam;//其它检查
    LinearLayout ll_hasUseDrugs;//降压药
    FuButton f_medicine_save;//用药
    Spinner sp_drugName;//药物名称
    Spinner sp_drugUsingFreq;//用法
    FuEditText et_drugPerDose;//每次剂量
    net.greatsoft.main.view.FuListView lv_hyperInfo;//用药集合
    LinearLayout ll_limitSaltCode;//限盐饮食
    LinearLayout ll_physicalActivityCode;//体力活动
    LinearLayout ll_stopSmokingCode;//戒烟
    LinearLayout ll_limitAlcoholCode;//限酒
    Spinner sp_creator;//建档医生
    FuTextView tv_createTime;//建档日期

    TextView fu_title_center;
    Button fu_title_right_btn;

    FuHyperInfoAdapter mHyperInfoAdapter;

    List<Emp> empList;//随访医生
    List<HyperInfoDrug> mDrugList;

    public FuHyperInfoView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_hyperinfo_view, null);

        mDrugList = new ArrayList<>();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_diagnoseDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.tv_createTime:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuHyperInfoFragment.EVENT_SAVE_HYPER_INFO, null);
                break;
            case R.id.f_medicine_save:
                SpinnerItem spinnerItem = (SpinnerItem) sp_drugName.getSelectedItem();

                HyperInfoDrug hyperInfoDrug = new HyperInfoDrug();
                hyperInfoDrug.setDrugId(spinnerItem.getId());
                hyperInfoDrug.setDrugName(spinnerItem.getValue());


                Checks checks = (Checks) sp_drugUsingFreq.getSelectedItem();
                hyperInfoDrug.setDrugUsingFreq(checks.getCode()); //用法
                hyperInfoDrug.setDrugPerDose(et_drugPerDose.getString()); //每次剂量
                mDrugList.add(hyperInfoDrug);
                mHyperInfoAdapter.notifyDataSetChanged();
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

        initCheckBoxMany("hyperFamilyHistory", ll_familyDisease, 4, false, false);//家族史
        initCheckBoxMany("heartDisease", ll_xinzang, 3, false, false);//心脏疾病
        initCheckBoxMany("cerebrovascul", ll_nao, 3, false, false);//脑血管疾病
        initCheckBoxMany("nephropathy", ll_shenzang, 2, false, false);//肾脏疾病
        initCheckBoxMany("angiosis", ll_xueguan, 2, false, false);//血管疾病
        initCheckBoxMany("pressureRetDis", ll_zhongdugao, 2, false, false);//重度高血压性视网膜病变
        // 婚姻
        initCheckBoxSimple("MARRIAGESTATUS", ll_hunyin, 5);
        setRadioOrCheckBoxEnabel(ll_hunyin);
        // 文化程度
        initCheckBoxSimple("CULTUREDEGREE", ll_wenhua, 3);
        setRadioOrCheckBoxEnabel(ll_wenhua);
        // 职业
        initCheckBoxSimple("MEMBERPROFESSION", ll_zhiye, 1);
        setRadioOrCheckBoxEnabel(ll_zhiye);
        // 医疗费用
        initCheckBoxMany("medicalPayWay", ll_yiliao, 2, false, true);
        setRadioOrCheckBoxEnabel(ll_yiliao);
        initCheckBoxSimple("hyperType",ll_hyperTypeCode,3);//高血压类型
        initCheckBoxSimple("allergicHistoryCode",ll_allergicHistoryCode,3,false,true);//过敏史
        initCheckBoxSimple("selfCareCode",ll_selfCareCode,3);//生活自理能力
        initCheckBoxSimple("smokeState",ll_smokingCode,3);//吸烟情况
        initCheckBoxSimple("drinkState",ll_drinkingCode,3);//饮酒情况
        initCheckBoxSimple("physicalActivity",ll_exerciseCode,3);//体力活动
        initCheckBoxSimple("degree",ll_hyperManagLevelCode,3);//高血压管理级别
        initCheckBoxSimple("bloodpressure",ll_hasUseDrugs,3);//降压药
        initCheckBoxSimple("notHas",ll_limitSaltCode,2);//限盐饮食
        initCheckBoxSimple("notHas",ll_physicalActivityCode,2);//体力活动
        initCheckBoxSimple("notHas",ll_stopSmokingCode,2);//戒烟
        initCheckBoxSimple("notHas",ll_limitAlcoholCode,2);//限酒
        initCheckBoxSimple("notHas",ll_retionopathyCode,2);//视网膜病变
        initCheckBoxSimple("notHas",ll_neuropathyCode,2);//神经病变


        empList = sqlHelper.getEmpDao().queryBuilder().list();
        ArrayAdapter adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_creator.setAdapter(adapter);

    }

    @Override
    protected void initWidget() {
        findView();

        mHyperInfoAdapter = new FuHyperInfoAdapter();
        lv_hyperInfo.setAdapter(mHyperInfoAdapter);

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("高血压专档");
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
        tv_birthday.setText(personInfo.getBirthday());//出生日期
        tv_cardNo.setText(personInfo.getIdNo());//身份证号
        setCheckBoxSelect(personInfo.getMarriageCode(),ll_hunyin);//婚姻状况
        setCheckBoxSelect(personInfo.getEducationCode(),ll_wenhua);//文化程度
        setCheckBoxSelect(personInfo.getOccupationCode(),ll_zhiye);////职业状况
        tv_adress.setText(personInfo.getAddress());//家庭住址
        tv_telNo.setText(personInfo.getTelNo());//联系电话
        setCheckBoxSelect("medicalPayWay", personInfo.getRecordChoice(), ll_yiliao);//医疗费用支付方式
    }

    public boolean saveData(HyperInfo hyperInfo) {

        if ("".equals(getCheckBoxSimpleCode(ll_hyperTypeCode))) {
            ToastUtil.showToast(mContext, "请选择高血压类型", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_diagnoseSbp.getString())||"".equals(et_diagnoseDbp.getString())) {
            ToastUtil.showToast(mContext, "请输入血压", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(tv_diagnoseDate.getText())) {
            ToastUtil.showToast(mContext, "请输入确诊时间", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(tv_createTime.getText())) {
            ToastUtil.showToast(mContext, "请输入建档时间", Toast.LENGTH_LONG);
            return false;
        }

        hyperInfo.setHouseholdRegister(tv_houseAdress.getString());//籍贯
        hyperInfo.setHealthcareOrg(et_healthcareOrg.getString());//定点医疗单位
        hyperInfo.setHyperManagLevelCode(getCheckBoxSimpleCode(ll_hyperManagLevelCode));//高血压管理级别
        hyperInfo.setHyperTypeCode(getCheckBoxSimpleCode(ll_hyperTypeCode));//高血压类型
        hyperInfo.setDiagnoseSbp(et_diagnoseSbp.getInt());//血压
        hyperInfo.setDiagnoseDbp(et_diagnoseDbp.getInt());
        hyperInfo.setDiagnoseDate(tv_diagnoseDate.getDate());//确诊时间
        hyperInfo.setDiagnoseOrgName(et_diagnoseOrgName.getString());//确诊医院
        hyperInfo.setPersonalHistory(et_personalHistory.getString());//个人史
        saveCheckBoxMany(null,hyperInfo.getRecordChoice(),ll_familyDisease);//家族史
        hyperInfo.setAllergicHistoryCode(getCheckBoxSimpleCode(ll_allergicHistoryCode));//过敏史
        hyperInfo.setAllergicHistoryValue(getString(ll_allergicHistoryCode));
        saveCheckBoxMany(null,hyperInfo.getRecordChoice(),ll_nao);//脑血管疾病
        saveCheckBoxMany(null,hyperInfo.getRecordChoice(),ll_xinzang);//心脏疾病
        saveCheckBoxMany(null,hyperInfo.getRecordChoice(),ll_shenzang);//肾脏疾病
        saveCheckBoxMany(null,hyperInfo.getRecordChoice(),ll_xueguan);//血管疾病
        saveCheckBoxMany(null,hyperInfo.getRecordChoice(),ll_zhongdugao);//重度高血压性视网膜病变
        hyperInfo.setSelfCareCode(getCheckBoxSimpleCode(ll_selfCareCode));//生活自理能力
        hyperInfo.setSmokingCode(getCheckBoxSimpleCode(ll_smokingCode));//吸烟情况
        hyperInfo.setDrinkingCode(getCheckBoxSimpleCode(ll_drinkingCode));//饮酒情况
        hyperInfo.setExerciseCode(getCheckBoxSimpleCode(ll_exerciseCode));//体力活动
        hyperInfo.setHeight(et_height.getDouble());//身高
        hyperInfo.setWeight(et_weight.getDouble());//体重
        hyperInfo.setPulse(et_pulse.getInt());//脉搏
        hyperInfo.setHeartRate(et_heartRate.getInt());//心率
        hyperInfo.setSbp(et_sbp.getInt());//血压
        hyperInfo.setDbp(et_dbp.getInt());
        hyperInfo.setFbg(et_fbg.getDouble());//血糖(空腹/餐后)
        hyperInfo.setPbg(et_pbg.getDouble());
        hyperInfo.setHdlc(et_hdlc.getDouble());//高/低密度脂蛋白胆固醇
        hyperInfo.setLdlc(et_ldlc.getDouble());
        hyperInfo.setTg(et_tg.getDouble());//甘油三酯
        hyperInfo.setTcho(et_tcho.getDouble());//总胆固醇
        hyperInfo.setRetionopathyCode(getCheckBoxSimpleCode(ll_retionopathyCode));//视网膜病变
        hyperInfo.setUrineMalb(et_urineMalb.getDouble());//尿微量白蛋白
        hyperInfo.setNeuropathyCode(getCheckBoxSimpleCode(ll_neuropathyCode));//神经病变
        hyperInfo.setEcgResult(et_ecgResult.getString());//心电图检查结果
        hyperInfo.setOthersExam(et_othersExam.getString());//其它检查
        hyperInfo.setHasUseDrugs(getCheckBoxSimpleCode(ll_hasUseDrugs));//降压药

        hyperInfo.getHyperInfoDrug().addAll(mDrugList);

        hyperInfo.setLimitSaltCode(getCheckBoxSimpleCode(ll_limitSaltCode));//限盐饮食
        hyperInfo.setPhysicalActivityCode(getCheckBoxSimpleCode(ll_physicalActivityCode));//体力活动
        hyperInfo.setStopSmokingCode(getCheckBoxSimpleCode(ll_stopSmokingCode));//戒烟
        hyperInfo.setLimitAlcoholCode(getCheckBoxSimpleCode(ll_limitAlcoholCode));//限酒
        Emp emp = (Emp) sp_creator.getSelectedItem();
        if (emp != null) {
            hyperInfo.setRespDoctorId(emp.getEmp_id());
            hyperInfo.setRespDoctorName(emp.getEmp_name());
        }
        hyperInfo.setUserCreateTime(tv_createTime.getDate());//建档日期


        return true;
    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name);//姓名
        tv_sex = (FuTextView) mFuView.findViewById(R.id.tv_sex);//性别
        tv_minzu = (FuTextView) mFuView.findViewById(R.id.tv_minzu);//民族
        tv_birthday = (FuTextView) mFuView.findViewById(R.id.tv_birthday);//出生日期
        tv_houseAdress = (FuEditText) mFuView.findViewById(R.id.tv_houseAdress);//籍贯
        tv_cardNo = (FuTextView) mFuView.findViewById(R.id.tv_cardNo);//身份证号
        ll_hunyin = (LinearLayout) mFuView.findViewById(R.id.ll_hunyin);//婚姻状况
        ll_wenhua = (LinearLayout) mFuView.findViewById(R.id.ll_wenhua);//文化程度
        ll_zhiye = (LinearLayout) mFuView.findViewById(R.id.ll_zhiye);//职业状况
        tv_adress = (FuTextView) mFuView.findViewById(R.id.tv_adress);//家庭住址
        tv_telNo = (FuTextView) mFuView.findViewById(R.id.tv_telNo);//联系电话
        ll_yiliao = (LinearLayout) mFuView.findViewById(R.id.ll_yiliao);//医疗费用支付方式
        et_healthcareOrg = (FuEditText) mFuView.findViewById(R.id.et_healthcareOrg);//
        ll_hyperManagLevelCode = (LinearLayout) mFuView.findViewById(R.id.ll_hyperManagLevelCode);//高血
        ll_hyperTypeCode = (LinearLayout) mFuView.findViewById(R.id.ll_hyperTypeCode);//高血压类型
        et_diagnoseSbp = (FuEditText) mFuView.findViewById(R.id.et_diagnoseSbp);//血压
        et_diagnoseDbp = (FuEditText) mFuView.findViewById(R.id.et_diagnoseDbp);//血压
        tv_diagnoseDate = (FuTextView) mFuView.findViewById(R.id.tv_diagnoseDate);//确诊时间
        tv_diagnoseDate.setOnClickListener(this);
        et_diagnoseOrgName = (FuEditText) mFuView.findViewById(R.id.et_diagnoseOrgName);//确诊医院
        et_personalHistory = (FuEditText) mFuView.findViewById(R.id.et_personalHistory);//个人史
        ll_familyDisease = (LinearLayout) mFuView.findViewById(R.id.ll_familyDisease);//家族史
        ll_allergicHistoryCode = (LinearLayout) mFuView.findViewById(R.id.ll_allergicHistoryCode);//过敏史
        ll_nao = (LinearLayout) mFuView.findViewById(R.id.ll_nao);//脑血管疾病
        ll_xinzang = (LinearLayout) mFuView.findViewById(R.id.ll_xinzang);//心脏疾病
        ll_shenzang = (LinearLayout) mFuView.findViewById(R.id.ll_shenzang);//肾脏疾病
        ll_xueguan = (LinearLayout) mFuView.findViewById(R.id.ll_xueguan);//血管疾病
        ll_zhongdugao = (LinearLayout) mFuView.findViewById(R.id.ll_zhongdugao);//重度高血压性视网膜病变
        ll_selfCareCode = (LinearLayout) mFuView.findViewById(R.id.ll_selfCareCode);//生活自理能力
        ll_smokingCode = (LinearLayout) mFuView.findViewById(R.id.ll_smokingCode);//吸烟情况
        ll_drinkingCode = (LinearLayout) mFuView.findViewById(R.id.ll_drinkingCode);//饮酒情况
        ll_exerciseCode = (LinearLayout) mFuView.findViewById(R.id.ll_exerciseCode);//体力活动
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height);//身高
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight);//体重
        et_pulse = (FuEditText) mFuView.findViewById(R.id.et_pulse);//脉搏
        et_heartRate = (FuEditText) mFuView.findViewById(R.id.et_heartRate);//心率
        et_sbp = (FuEditText) mFuView.findViewById(R.id.et_sbp);//血压
        et_dbp = (FuEditText) mFuView.findViewById(R.id.et_dbp);//血压
        et_fbg = (FuEditText) mFuView.findViewById(R.id.et_fbg);//血糖(空腹/餐后)
        et_pbg = (FuEditText) mFuView.findViewById(R.id.et_pbg);//血糖(空腹/餐后)
        et_hdlc = (FuEditText) mFuView.findViewById(R.id.et_hdlc);//高/低密度脂蛋白胆固醇
        et_ldlc = (FuEditText) mFuView.findViewById(R.id.et_ldlc);//高/低密度脂蛋白胆固醇
        et_tg = (FuEditText) mFuView.findViewById(R.id.et_tg);//甘油三酯
        et_tcho = (FuEditText) mFuView.findViewById(R.id.et_tcho);//总胆固醇
        ll_retionopathyCode = (LinearLayout) mFuView.findViewById(R.id.ll_retionopathyCode);//视网膜病变
        et_urineMalb = (FuEditText) mFuView.findViewById(R.id.et_urineMalb);//尿微量白蛋白
        ll_neuropathyCode = (LinearLayout) mFuView.findViewById(R.id.ll_neuropathyCode);//神经病变
        et_ecgResult = (FuEditText) mFuView.findViewById(R.id.et_ecgResult);//心电图检查结果
        et_othersExam = (FuEditText) mFuView.findViewById(R.id.et_othersExam);//其它检查
        ll_hasUseDrugs = (LinearLayout) mFuView.findViewById(R.id.ll_hasUseDrugs);//降压药
        f_medicine_save = (FuButton) mFuView.findViewById(R.id.f_medicine_save);//用药
        f_medicine_save.setOnClickListener(this);
        sp_drugName = (Spinner) mFuView.findViewById(R.id.sp_drugName);//药物名称
        sp_drugUsingFreq = (Spinner) mFuView.findViewById(R.id.sp_drugUsingFreq);//用法
        et_drugPerDose = (FuEditText) mFuView.findViewById(R.id.et_drugPerDose);//每次剂量
        lv_hyperInfo = (net.greatsoft.main.view.FuListView) mFuView.findViewById(R.id.lv_hyperInfo);//用药集合
        ll_limitSaltCode = (LinearLayout) mFuView.findViewById(R.id.ll_limitSaltCode);//限盐饮食
        ll_physicalActivityCode = (LinearLayout) mFuView.findViewById(R.id.ll_physicalActivityCode);//体力活动
        ll_stopSmokingCode = (LinearLayout) mFuView.findViewById(R.id.ll_stopSmokingCode);//戒烟
        ll_limitAlcoholCode = (LinearLayout) mFuView.findViewById(R.id.ll_limitAlcoholCode);//限酒
        sp_creator = (Spinner) mFuView.findViewById(R.id.sp_creator);//建档医生
        tv_createTime = (FuTextView) mFuView.findViewById(R.id.tv_createTime);//建档日期
        tv_createTime.setOnClickListener(this);

    }

    class FuHyperInfoAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public FuHyperInfoAdapter() {
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
                    mHyperInfoAdapter.notifyDataSetChanged();
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
