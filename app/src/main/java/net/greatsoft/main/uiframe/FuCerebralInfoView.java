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
import net.greatsoft.main.db.po.cerebralApoplexy.CaInfoDrugs;
import net.greatsoft.main.db.po.cerebralApoplexy.CerebralApoplexyInfo;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuCoronaryHeartInfoFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2017/03/23
 * Time: 13:54
 * progject: Chss
 * Describe： 脑卒中专档
 */

public class FuCerebralInfoView extends FuUiFrameModel implements View.OnClickListener, View.OnFocusChangeListener {

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
    FuTextView tv_confirmDate;//发病时间
    FuEditText et_confirmOrgName;//诊断医院
    LinearLayout ll_jiazushi;//家族史
    LinearLayout ll_zhengZhuang;//就诊时症状
    FuEditText et_mrsScore;//mRS评分
    LinearLayout ll_weixian;//脑卒中危险因素
    FuEditText et_ctResult;//CT检查结果
    FuEditText et_mriResult;//MRI检查结果
    LinearLayout ll_cerebralApoplexyType;//脑卒中分类
    LinearLayout ll_cerebralApoplexyPosition;//脑卒中部位
    LinearLayout ll_selfCareAssessCode;//生活自理能力
    FuEditText et_height;//身高
    FuEditText et_weight;//体重
    FuEditText et_bmi;//BMI
    FuEditText et_waist;//腰围
    FuEditText et_sbp;//血压值
    FuEditText et_dbp;//血压值
    FuEditText et_fbgMmol;//空腹血糖
    FuEditText et_hdlc;//高密度脂蛋白
    FuEditText et_ldlc;//低密度脂蛋白
    FuEditText et_tcho;//胆固醇
    FuTextView tv_checkDate;//体检日期
    LinearLayout ll_hasUseDrugs;//用药情况
    FuButton f_medicine_save;//添加
    Spinner sp_drugName;//药物名称
    Spinner sp_drugUsingFreq;//用法
    FuEditText et_drugPerDose;//每次剂量
    Spinner sp_unit; //单位
    net.greatsoft.main.view.FuListView lv_coronaryHeartInfo;//保存用药集合
    LinearLayout ll_drugComplianceCode;//服药依从性
    LinearLayout ll_teshuzhiliao;//特殊治疗
    LinearLayout ll_feiyaowu;//非药物治疗措施
    LinearLayout ll_hasEndManage;//是否终止管理
    FuTextView tv_endManageDate;//终止管理日期
    LinearLayout ll_endManageReason;//终止管理原因
    FuTextView tv_userCreateTime;//建卡日期

    TextView fu_title_center;
    Button fu_title_right_btn;

    List<CaInfoDrugs> mDrugList;

    FuCerebralInfoAdapter mCerebralInfoAdapter;

    public FuCerebralInfoView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {

        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_cerebralinfo_view, null);

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

                CaInfoDrugs caInfoDrugs = new CaInfoDrugs();
                caInfoDrugs.setDrugId(spinnerItem.getId());
                caInfoDrugs.setDrugName(spinnerItem.getValue());


                Checks checks = (Checks) sp_drugUsingFreq.getSelectedItem();
                caInfoDrugs.setDrugUsingFreq(checks.getCode()); //用法
                caInfoDrugs.setDrugPerDose(et_drugPerDose.getString()); //每次剂量

                Checks checkUnit = (Checks) sp_unit.getSelectedItem();
//                caInfoDrugs.setDrugPerDose(checkUnit.getCode());//单位
                caInfoDrugs.setUnit(checkUnit.getValue());
                mDrugList.add(caInfoDrugs);
                mCerebralInfoAdapter.notifyDataSetChanged();
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
        initCheckBoxSimple("manageGroup", ll_manageGroup, 0);//管理组别
        initCheckBoxSimple("caseSource", ll_caseSource, 1);//病例来源
        initCheckBoxMany("caFamilyHistory", ll_jiazushi, 4);//家族史
        initCheckBoxMany("caSymptoms", ll_zhengZhuang, 3);//就诊时症状
        initCheckBoxMany("caDangers", ll_weixian, 4);//脑卒中危险因素
        initCheckBoxSimple("cerebralApoplexyType", ll_cerebralApoplexyType, 4);//脑卒中分类
        initCheckBoxSimple("cerebralApoplexyPosition", ll_cerebralApoplexyPosition, 3);//脑卒中部位
        initCheckBoxSimple("selfCareAssessCode", ll_selfCareAssessCode, 0);//生活自理能力
        initCheckBoxSimple("hasUseDrugs", ll_hasUseDrugs, 3);//用药情况
        initCheckBoxMany("caSpecialTreatment", ll_teshuzhiliao, 3);//特殊治疗
        initCheckBoxMany("caDrugTreatment", ll_feiyaowu, 3);//非药物治疗措施
        initCheckBoxSimple("drugComplianceCode", ll_drugComplianceCode, 0);// 服药依从性
        initCheckBoxSimple("hasEndManage", ll_hasEndManage, 0);// 是否终止管理
        initCheckBoxSimple("endManageReason", ll_endManageReason, 0);// 终止管理原因

    }

    @Override
    protected void initWidget() {

        findView();
        mCerebralInfoAdapter = new FuCerebralInfoAdapter();
        lv_coronaryHeartInfo.setAdapter(mCerebralInfoAdapter);

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("脑卒中专档");
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

    public boolean saveData(CerebralApoplexyInfo cerebralInfo) {

        if ("".equals(tv_confirmDate.getText())) {
            ToastUtil.showToast(mContext, "请填写发病时间", Toast.LENGTH_LONG);
            return false;
        }

        cerebralInfo.setHeartDiseaseInfoNo(et_heartDiseaseInfoNo.getString());//管理卡编号
        cerebralInfo.setManageGroup(getCheckBoxSimpleCode(ll_manageGroup));//管理组别
        cerebralInfo.setCaseSource(getCheckBoxSimpleCode(ll_caseSource));//病例来源
        cerebralInfo.setConfirmDate(tv_confirmDate.getDate());//发病时间
        cerebralInfo.setConfirmOrgName(et_confirmOrgName.getString());//诊断医院
        saveCheckBoxMany(null, cerebralInfo.getRecordChoice(), ll_jiazushi);//家族史
        saveCheckBoxMany(null, cerebralInfo.getRecordChoice(), ll_zhengZhuang);//就诊时症状
        cerebralInfo.setMrsScore(et_mrsScore.getString());//mRS评分
        saveCheckBoxMany(null, cerebralInfo.getRecordChoice(), ll_weixian);//脑卒中危险因素
        cerebralInfo.setCtResult(et_ctResult.getString());//CT检查结果
        cerebralInfo.setMriResult(et_mriResult.getString());//MRI检查结果
        cerebralInfo.setCerebralApoplexyType(getCheckBoxSimpleCode(ll_cerebralApoplexyType));//脑卒中分类
        cerebralInfo.setCerebralApoplexyPosition(getCheckBoxSimpleCode(ll_cerebralApoplexyPosition));//脑卒中部位
        cerebralInfo.setSelfCareAssessCode(getCheckBoxSimpleCode(ll_selfCareAssessCode));//生活自理能力
        cerebralInfo.setHeight(et_height.getDouble());//身高
        cerebralInfo.setWeight(et_weight.getDouble());//体重
        cerebralInfo.setBmi(et_bmi.getDouble());//BMI
        cerebralInfo.setWaist(et_waist.getDouble());//腰围
        cerebralInfo.setSbp(et_sbp.getInt());//血压值
        cerebralInfo.setDbp(et_dbp.getInt());
        cerebralInfo.setFbgMmol(et_fbgMmol.getDouble());//空腹血糖
        cerebralInfo.setHdlc(et_hdlc.getDouble());//高密度脂蛋白
        cerebralInfo.setLdlc(et_ldlc.getDouble());//低密度脂蛋白
        cerebralInfo.setTcho(et_tcho.getDouble());//胆固醇
        cerebralInfo.setCheckDate(tv_checkDate.getDate());//体检日期
        cerebralInfo.setHasUseDrugs(getCheckBoxSimpleCode(ll_hasUseDrugs));//是否用药
        cerebralInfo.getCaInfoDrug().addAll(mDrugList);//药物
        cerebralInfo.setDrugComplianceCode(getCheckBoxSimpleCode(ll_drugComplianceCode));//服药依从性
        saveCheckBoxMany(null, cerebralInfo.getRecordChoice(), ll_teshuzhiliao);//特殊治疗
        saveCheckBoxMany(null, cerebralInfo.getRecordChoice(), ll_feiyaowu);//非药物治疗措施
        cerebralInfo.setHasEndManage(getCheckBoxSimpleCode(ll_hasEndManage));//是否终止管理
        cerebralInfo.setEndManageDate(tv_endManageDate.getDate());//终止管理日期
        tv_endManageDate.setOnClickListener(this);
        cerebralInfo.setEndManageReason(getCheckBoxSimpleCode(ll_endManageReason));//终止管理原因
        cerebralInfo.setUserCreateTime(tv_userCreateTime.getDate());//建卡日期

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
        tv_confirmDate = (FuTextView) mFuView.findViewById(R.id.tv_confirmDate);//发病时间
        tv_confirmDate.setOnClickListener(this);
        et_confirmOrgName = (FuEditText) mFuView.findViewById(R.id.et_confirmOrgName);//诊断医院
        ll_jiazushi = (LinearLayout) mFuView.findViewById(R.id.ll_jiazushi);//家族史
        ll_zhengZhuang = (LinearLayout) mFuView.findViewById(R.id.ll_zhengZhuang);//就诊时症状
        et_mrsScore = (FuEditText) mFuView.findViewById(R.id.et_mrsScore);//mRS评分
        ll_weixian = (LinearLayout) mFuView.findViewById(R.id.ll_weixian);//脑卒中危险因素
        et_ctResult = (FuEditText) mFuView.findViewById(R.id.et_ctResult);//CT检查结果
        et_mriResult = (FuEditText) mFuView.findViewById(R.id.et_mriResult);//MRI检查结果
        ll_cerebralApoplexyType = (LinearLayout) mFuView.findViewById(R.id.ll_cerebralApoplexyType);//脑卒中分类
        ll_cerebralApoplexyPosition = (LinearLayout) mFuView.findViewById(R.id.ll_cerebralApoplexyPosition);//脑卒中部位
        ll_selfCareAssessCode = (LinearLayout) mFuView.findViewById(R.id.ll_selfCareAssessCode);//生活自理能力
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height);//身高
        et_height.setOnFocusChangeListener(this);
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight);//体重
        et_weight.setOnFocusChangeListener(this);
        et_bmi = (FuEditText) mFuView.findViewById(R.id.et_bmi);//BMI
        et_waist = (FuEditText) mFuView.findViewById(R.id.et_waist);//腰围
        et_sbp = (FuEditText) mFuView.findViewById(R.id.et_sbp);//血压值
        et_dbp = (FuEditText) mFuView.findViewById(R.id.et_dbp);//血压值
        et_fbgMmol = (FuEditText) mFuView.findViewById(R.id.et_fbgMmol);//空腹血糖
        et_hdlc = (FuEditText) mFuView.findViewById(R.id.et_hdlc);//高密度脂蛋白
        et_ldlc = (FuEditText) mFuView.findViewById(R.id.et_ldlc);//低密度脂蛋白
        et_tcho = (FuEditText) mFuView.findViewById(R.id.et_tcho);//胆固醇
        tv_checkDate = (FuTextView) mFuView.findViewById(R.id.tv_checkDate);//体检日期
        tv_checkDate.setOnClickListener(this);
        ll_hasUseDrugs = (LinearLayout) mFuView.findViewById(R.id.ll_hasUseDrugs);//用药情况
        f_medicine_save = (FuButton) mFuView.findViewById(R.id.f_medicine_save);//添加
        f_medicine_save.setOnClickListener(this);
        sp_drugName = (Spinner) mFuView.findViewById(R.id.sp_drugName);//药物名称
        sp_drugUsingFreq = (Spinner) mFuView.findViewById(R.id.sp_drugUsingFreq);//用法
        et_drugPerDose = (FuEditText) mFuView.findViewById(R.id.et_drugPerDose);//每次剂量
        sp_unit = (Spinner) mFuView.findViewById(R.id.sp_unit); //单位
        lv_coronaryHeartInfo = (net.greatsoft.main.view.FuListView) mFuView.findViewById(R.id.lv_coronaryHeartInfo);//保存用药集合
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

    class FuCerebralInfoAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public FuCerebralInfoAdapter() {
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
                    mCerebralInfoAdapter.notifyDataSetChanged();
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
