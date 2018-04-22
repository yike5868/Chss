package net.greatsoft.main.uiframe;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.exam.HealthExam;
import net.greatsoft.main.db.po.exam.HealthExamDrug;
import net.greatsoft.main.db.po.exam.HealthExamInhos;
import net.greatsoft.main.db.po.exam.HealthExamNoplanVacc;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhanglin on 16/8/3.
 */
public class FuExam04View extends FuUiFrameModel implements View.OnClickListener {

    List<HealthExamInhos> list_healthExamInhos1;//住院史  家庭病床史
    //
    List<HealthExamInhos> list_healthExamInhos2;//家庭病床史


    List<HealthExamDrug> list_healthExamDrug;//住院用药情况


    List<HealthExamNoplanVacc> list_healthExamNoplanVacc;//非免疫规划预防接种史


    HealthExamInhos1Adapter healthExamInhos1Adapter;//住院史
    HealthExamInhos2Adapter healthExamInhos2Adapter;//家庭住院史
    HealthExamDrugAdapter healthExamDrugAdapter;//住院用药情况
    HealthExamNoplanVaccAdapter healthExamNoplanVaccAdapter;//非免疫规划预防接种史


    ListView lv_healthExamInhos1;   //住院史
    ListView lv_healthExamInhos2;   //家庭病床史
    ListView lv_healthExamDrug;     //住院用药情况
    ListView lv_healthExamNoplanVacc;   //非免疫规划预防接种史

    LinearLayout ll_cerebralVascularDisease;//脑血管疾病
    LinearLayout ll_kidneyDisease;          //肾脏疾病
    LinearLayout ll_heartDisease;           //心脏疾病
    LinearLayout ll_vascularDisease;        //血管疾病
    LinearLayout ll_eyeDiseases;            //眼部疾病
    LinearLayout ll_nervousSystemDiseases;  //神经系统疾病
    LinearLayout ll_diseOthers;  //其他系统疾病
    LinearLayout ll_healthAbnorm;           //健康评价
    FuEditText et_healthAbnormDesc1;          //异常1
    FuEditText et_healthAbnormDesc2;          //
    FuEditText et_healthAbnormDesc3;          //
    FuEditText et_healthAbnormDesc4;          //
    LinearLayout ll_healthGuidance;         //健康指导
    FuEditText et_orgName;                    //录入机构
    FuEditText et_creator;                    //录入人
    FuEditText et_createTime;                 //录入时间

    Button btn_healthExamInhos1;        //住院史
    Button btn_healthExamInhos2;        //家庭病床史
    Button btn_healthExamDrug;          //住院用药情况
    Button btn_healthExamNoplanVacc;    //非免疫规划预防接种史


    FuEditText et_medicalRecordNo1;    //病案号
    FuEditText et_admissionDate1;      //入院日期
    FuEditText et_dischargeDate1;       //出院日期
    FuEditText et_hospitalName1;       //医疗机构名称
    FuEditText et_admissionReason1;    //原因

    FuEditText et_medicalRecordNo2;    //病案号
    FuEditText et_admissionDate2;      //入院日期
    FuEditText et_dischargeDate2;       //出院日期
    FuEditText et_hospitalName2;       //医疗机构名称
    FuEditText et_admissionReason2;    //原因


    FuEditText et_drugName;        //用药名称
    FuEditText et_drugUsageCode;   //用法
    FuEditText et_drugDose;        //用量
    FuEditText et_drugTime;        //用药时间
    LinearLayout ll_drugCompliance;//服药依从性

    FuEditText et_vaccineCode;     //名称
    FuEditText et_vaccinationDate;//接种日期
    FuEditText et_vaccinationOrgName;// 接种机构

    String healthExamId;    //体检ID


    CheckBox cb_isSmoking;//戒烟
    CheckBox cb_isDrinking;//健康饮酒
    CheckBox cb_isFood; // 饮食
    CheckBox cb_isExercise;//锻炼
    CheckBox cb_isLost; // 减体重
    FuEditText et_lost;   //减体重
    CheckBox cb_vaccination;//建议接种疫苗
    FuEditText et_vaccination;//疫苗
    CheckBox cb_other;//其他
    FuEditText et_other;//其他


    public FuExam04View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_exam04_jn_view, null);
    }

    public void setData(HealthExam healthExam) {

        healthExamId = healthExam.getHealthExamId();
//        list_healthExamInhos1 = sqlHelper.getHealthExamInhosDao().queryBuilder().where(HealthExamInhosDao.Properties.HealthExamId.eq(healthExam.getHealthExamId()), HealthExamInhosDao.Properties.InhosHistoryTypeCode.eq("1")).list();//住院史
//        list_healthExamInhos2 = sqlHelper.getHealthExamInhosDao().queryBuilder().where(HealthExamInhosDao.Properties.HealthExamId.eq(healthExam.getHealthExamId()), HealthExamInhosDao.Properties.InhosHistoryTypeCode.eq("2")).list();//家庭病床史
//        list_healthExamDrug = sqlHelper.getHealthExamDrugDao().queryBuilder().where(HealthExamDrugDao.Properties.HealthExamId.eq(healthExam.getHealthExamId())).list();//住院用药情况
//        list_healthExamNoplanVacc = sqlHelper.getHealthExamNoplanVaccDao().queryBuilder().where(HealthExamNoplanVaccDao.Properties.HealthExamId.eq(healthExam.getHealthExamId())).list();//非免疫规划预防接种史

        list_healthExamInhos1 = new ArrayList<>();//住院史
        list_healthExamInhos2 = new ArrayList<>();//家庭病床史


        list_healthExamDrug = healthExam.getHealthExamDrug();//住院用药情况
        list_healthExamNoplanVacc = healthExam.getHealthExamNoplanVacc();//非免疫规划预防接种史

        healthExamInhos1Adapter = new HealthExamInhos1Adapter(mContext);//住院史
        healthExamInhos2Adapter = new HealthExamInhos2Adapter(mContext);//家庭住院史
        healthExamDrugAdapter = new HealthExamDrugAdapter(mContext);//住院用药情况
        healthExamNoplanVaccAdapter = new HealthExamNoplanVaccAdapter(mContext);//非免疫规划预防接种史


        lv_healthExamInhos1.setAdapter(healthExamInhos1Adapter);   //住院史
        lv_healthExamInhos2.setAdapter(healthExamInhos2Adapter);   //家庭病床史
        lv_healthExamDrug.setAdapter(healthExamDrugAdapter);     //住院用药情况
        lv_healthExamNoplanVacc.setAdapter(healthExamNoplanVaccAdapter);   //非免疫规划预防接种史

//
//        setCheckBoxSelect("diseBrainVessel", healthExam.getHealthExamId(), ll_cerebralVascularDisease);//脑血管疾病
//        setCheckBoxSelect("diseKidney", healthExam.getHealthExamId(), ll_kidneyDisease);          //肾脏疾病
//        setCheckBoxSelect("diseHeart", healthExam.getHealthExamId(), ll_heartDisease);           //心脏疾病
//        setCheckBoxSelect("diseBloodVessel", healthExam.getHealthExamId(), ll_vascularDisease);        //血管疾病
//        setCheckBoxSelect("diseEye", healthExam.getHealthExamId(), ll_eyeDiseases);            //眼部疾病

        setCheckBoxSelect("diseBrainVessel", healthExam.getRecordChoice(), ll_cerebralVascularDisease);//脑血管疾病
        setCheckBoxSelect("diseKidney", healthExam.getRecordChoice(), ll_kidneyDisease);          //肾脏疾病
        setCheckBoxSelect("diseHeart", healthExam.getRecordChoice(), ll_heartDisease);           //心脏疾病
        setCheckBoxSelect("diseBloodVessel", healthExam.getRecordChoice(), ll_vascularDisease);        //血管疾病
        setCheckBoxSelect("diseEye", healthExam.getRecordChoice(), ll_eyeDiseases);            //眼部疾病


        setCheckBoxSelect(healthExam.getDiseNervousCode(), ll_nervousSystemDiseases);  //神经系统疾病
        setText(healthExam.getDiseNervousAbnormDesc(), ll_nervousSystemDiseases);
        setCheckBoxSelect(healthExam.getDiseOthersCode(), ll_diseOthers);  //其他系统疾病
        setText(healthExam.getDiseOthersAbnormDesc(), ll_diseOthers);
        setCheckBoxSelect(healthExam.getHealthAbnormCode(), ll_healthAbnorm);           //健康评价
        et_healthAbnormDesc1.setText(healthExam.getHealthAbnormDesc1());          //异常1
        et_healthAbnormDesc2.setText(healthExam.getHealthAbnormDesc2());          //
        et_healthAbnormDesc3.setText(healthExam.getHealthAbnormDesc3());          //
        et_healthAbnormDesc4.setText(healthExam.getHealthAbnormDesc4());          //
//        setCheckBoxSelect("healthGuidance", healthExam.getHealthExamId(), ll_healthGuidance);         //健康指导
        setCheckBoxSelect("healthGuidance", healthExam.getRecordChoice(), ll_healthGuidance);         //健康指导

        SharedPreferences preferences = mContext.getSharedPreferences("AccessToken", Context.MODE_PRIVATE);


        et_orgName.setText(preferences.getString("pos_name", ""));                    //录入机构
        et_creator.setText(preferences.getString("emp_name", ""));                    //录入人
//        et_createTime.setText(healthExam.getCreateTime().toString());                 //录入时间

//        List<RecordChoice> list = sqlHelper.getRecordChoiceDao().queryBuilder().where(RecordChoiceDao.Properties.TableKey.eq(healthExam.getHealthExamId()),RecordChoiceDao.Properties.CodeType.eq("riskFactorControl")).list();
        List<RecordChoice> list = healthExam.getRecordChoice();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                RecordChoice rc = list.get(i);
                int index = Integer.parseInt(rc.getCode());
                switch (index) {
                    case 1:
                        cb_isSmoking.setChecked(true);
                        break;
                    case 2:
                        cb_isDrinking.setChecked(true);
                        break;
                    case 3:
                        cb_isFood.setChecked(true);
                        break;
                    case 4:
                        cb_isExercise.setChecked(true);
                        break;
                    case 5:
                        cb_isLost.setChecked(true);
                        et_lost.setText(rc.getName());
                        break;
                    case 6:
                        cb_vaccination.setChecked(true);
                        et_vaccination.setText(rc.getName());
                        break;
                    case 7:
                        cb_other.setChecked(true);
                        et_other.setText(rc.getName());
                        break;
                }
            }
        }
    }

    public boolean saveData(HealthExam healthExam) {
        saveCheckBoxMany(null, healthExam.getRecordChoice(), ll_cerebralVascularDisease);//脑血管疾病
        saveCheckBoxMany(null, healthExam.getRecordChoice(), ll_kidneyDisease);          //肾脏疾病
        saveCheckBoxMany(null, healthExam.getRecordChoice(), ll_heartDisease);           //心脏疾病
        saveCheckBoxMany(null, healthExam.getRecordChoice(), ll_vascularDisease);        //血管疾病
        saveCheckBoxMany(null, healthExam.getRecordChoice(), ll_eyeDiseases);            //眼部疾病
        healthExam.setDiseNervousCode(getCheckBoxSimpleCode(ll_nervousSystemDiseases));  //神经系统疾病
        healthExam.setDiseNervousAbnormDesc(getString(ll_nervousSystemDiseases));
        healthExam.setDiseOthersCode(getCheckBoxSimpleCode(ll_diseOthers));  //其他系统疾病
        healthExam.setDiseOthersAbnormDesc(getString(ll_diseOthers));

        healthExam.setHealthAbnormCode(getCheckBoxSimpleCode(ll_healthAbnorm));           //健康评价

        healthExam.setHealthAbnormDesc1(et_healthAbnormDesc1.getString());          //异常1
        healthExam.setHealthAbnormDesc2(et_healthAbnormDesc2.getString());          //
        healthExam.setHealthAbnormDesc3(et_healthAbnormDesc3.getString());          //
        healthExam.setHealthAbnormDesc4(et_healthAbnormDesc4.getString());          //
        saveCheckBoxMany(null, healthExam.getRecordChoice(), ll_healthGuidance);         //健康指导
        healthExam.setOrgName(et_orgName.getString());                    //录入机构
        healthExam.setCreator(et_creator.getString());                    //录入人
        healthExam.setCreateTime(new Date(System.currentTimeMillis()));                 //录入时间
        if (cb_isSmoking.isChecked()) {
            RecordChoice rc = new RecordChoice();
            rc.setCode("1");
            rc.setName("戒烟");
            rc.setTableKey(null);
            rc.setCodeType("riskFactorControl");
            healthExam.getRecordChoice().add(rc);
        }
        if (cb_isDrinking.isChecked()) {
            RecordChoice rc = new RecordChoice();
            rc.setCode("2");
            rc.setName("戒酒");
            rc.setTableKey(null);
            rc.setCodeType("riskFactorControl");
            healthExam.getRecordChoice().add(rc);
        }
        if (cb_isFood.isChecked()) {
            RecordChoice rc = new RecordChoice();
            rc.setCode("3");
            rc.setName("饮食");
            rc.setTableKey(null);
            rc.setCodeType("riskFactorControl");
            healthExam.getRecordChoice().add(rc);
        }
        if (cb_isExercise.isChecked()) {
            RecordChoice rc = new RecordChoice();
            rc.setCode("4");
            rc.setName("锻炼");
            rc.setTableKey(null);
            rc.setCodeType("riskFactorControl");
            healthExam.getRecordChoice().add(rc);
        }
        if (cb_isLost.isChecked()) {
            RecordChoice rc = new RecordChoice();
            rc.setCode("5");
            rc.setName(et_lost.getString());
            rc.setTableKey(null);
            rc.setCodeType("riskFactorControl");
            healthExam.getRecordChoice().add(rc);
        }
        if (cb_vaccination.isChecked()) {
            RecordChoice rc = new RecordChoice();
            rc.setCode("6");
            rc.setName(et_vaccination.getString());
            rc.setTableKey(null);
            rc.setCodeType("riskFactorControl");
            healthExam.getRecordChoice().add(rc);
        }
        if (cb_other.isChecked()) {
            RecordChoice rc = new RecordChoice();
            rc.setCode("7");
            rc.setName(et_other.getString());
            rc.setTableKey(null);
            rc.setCodeType("riskFactorControl");
            healthExam.getRecordChoice().add(rc);
        }


//        sqlHelper.getHealthExamInhosDao().insertInTx(list_healthExamInhos1);
//        sqlHelper.getHealthExamInhosDao().insertInTx(list_healthExamInhos2);
//        sqlHelper.getHealthExamDrugDao().insertInTx(list_healthExamDrug);
//        sqlHelper.getHealthExamNoplanVaccDao().insertInTx(list_healthExamNoplanVacc);


        healthExam.setHealthExamInhos(list_healthExamInhos1);
        healthExam.getHealthExamInhos().addAll(list_healthExamInhos2);

        healthExam.setHealthExamDrug(list_healthExamDrug);
        healthExam.setHealthExamNoplanVacc(list_healthExamNoplanVacc);
        return true;
    }

    @Override
    protected void initFuData() {

    }


    public void setError() {
    }

    @Override
    protected void initWidget() {
        findView();
        // 脑血管疾病
        initCheckBoxMany("diseBrainVessel", ll_cerebralVascularDisease, 3, false, true);
        // 肾脏疾病
        initCheckBoxMany("diseKidney", ll_kidneyDisease, 3, false, true);
        // 心脏疾病
        initCheckBoxMany("diseHeart", ll_heartDisease, 3, false, true);
        // 血管疾病
        initCheckBoxMany("diseBloodVessel", ll_vascularDisease, 3, false, true);
        // 眼部疾病
        initCheckBoxMany("diseEye", ll_eyeDiseases, 2, false, true);
        // 神经系统疾病
        initCheckBoxSimple("NERVEDISEASE", ll_nervousSystemDiseases, 0, false, true, false);
        // 其他系统疾病
        initCheckBoxSimple("NERVEDISEASE", ll_diseOthers, 0, false, true, false);
        //健康评价
        initCheckBoxSimple("HEALTHEVALUATE", ll_healthAbnorm, 0, false, false, false);
        //健康指导
        initCheckBoxMany("healthGuidance", ll_healthGuidance, 3, false, true);
        //服药依从性
        initCheckBoxSimple("DRUG_COMPLIANCE", ll_drugCompliance, 3, false, false);
        et_admissionDate1.setOnClickListener(this);
        et_admissionDate2.setOnClickListener(this);
        et_dischargeDate1.setOnClickListener(this);
        et_dischargeDate2.setOnClickListener(this);
        et_vaccinationDate.setOnClickListener(this);
    }

    private void findView() {

        lv_healthExamInhos1 = (ListView) mFuView.findViewById(R.id.lv_healthExamInhos1);   //住院史
        lv_healthExamInhos2 = (ListView) mFuView.findViewById(R.id.lv_healthExamInhos2);   //家庭病床史
        lv_healthExamDrug = (ListView) mFuView.findViewById(R.id.lv_healthExamDrug);     //住院用药情况
        lv_healthExamNoplanVacc = (ListView) mFuView.findViewById(R.id.lv_healthExamNoplanVacc);   //非免疫规划预防接种史
        ll_cerebralVascularDisease = (LinearLayout) mFuView.findViewById(R.id.ll_cerebralVascularDisease);//脑血管疾病
        ll_kidneyDisease = (LinearLayout) mFuView.findViewById(R.id.ll_kidneyDisease);          //肾脏疾病
        ll_heartDisease = (LinearLayout) mFuView.findViewById(R.id.ll_heartDisease);           //心脏疾病
        ll_vascularDisease = (LinearLayout) mFuView.findViewById(R.id.ll_vascularDisease);        //血管疾病
        ll_eyeDiseases = (LinearLayout) mFuView.findViewById(R.id.ll_eyeDiseases);            //眼部疾病
        ll_nervousSystemDiseases = (LinearLayout) mFuView.findViewById(R.id.ll_nervousSystemDiseases);  //神经系统疾病
        ll_diseOthers = (LinearLayout) mFuView.findViewById(R.id.ll_diseOthers);  //其他系统疾病
        ll_healthAbnorm = (LinearLayout) mFuView.findViewById(R.id.ll_healthAbnorm);           //健康评价
        et_healthAbnormDesc1 = (FuEditText) mFuView.findViewById(R.id.et_healthAbnormDesc1);          //异常1
        et_healthAbnormDesc2 = (FuEditText) mFuView.findViewById(R.id.et_healthAbnormDesc2);          //
        et_healthAbnormDesc3 = (FuEditText) mFuView.findViewById(R.id.et_healthAbnormDesc3);          //
        et_healthAbnormDesc4 = (FuEditText) mFuView.findViewById(R.id.et_healthAbnormDesc4);          //
        ll_healthGuidance = (LinearLayout) mFuView.findViewById(R.id.ll_healthGuidance);//健康指导
        et_orgName = (FuEditText) mFuView.findViewById(R.id.et_orgName);                    //录入机构
        et_creator = (FuEditText) mFuView.findViewById(R.id.et_creator);                    //录入人
        et_createTime = (FuEditText) mFuView.findViewById(R.id.et_createTime);//录入时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        et_createTime.setText(simpleDateFormat.format(new Date(System.currentTimeMillis())));
        btn_healthExamInhos1 = (Button) mFuView.findViewById(R.id.btn_healthExamInhos1);        //住院史
        btn_healthExamInhos2 = (Button) mFuView.findViewById(R.id.btn_healthExamInhos2);        //家庭病床史
        btn_healthExamDrug = (Button) mFuView.findViewById(R.id.btn_healthExamDrug);          //住院用药情况
        btn_healthExamNoplanVacc = (Button) mFuView.findViewById(R.id.btn_healthExamNoplanVacc);    //非免疫规划预防接种史
        btn_healthExamInhos1.setOnClickListener(this);        //住院史
        btn_healthExamInhos2.setOnClickListener(this);        //家庭病床史
        btn_healthExamDrug.setOnClickListener(this);          //住院用药情况
        btn_healthExamNoplanVacc.setOnClickListener(this);    //非免疫规划预防接种史
        et_medicalRecordNo1 = (FuEditText) mFuView.findViewById(R.id.et_medicalRecordNo1);    //病案号
        et_admissionDate1 = (FuEditText) mFuView.findViewById(R.id.et_admissionDate1);      //入院日期
        et_admissionDate1.setOnClickListener(this);
        et_dischargeDate1 = (FuEditText) mFuView.findViewById(R.id.et_dischargeDate1);       //出院日期
        et_dischargeDate1.setOnClickListener(this);
        et_hospitalName1 = (FuEditText) mFuView.findViewById(R.id.et_hospitalName1);       //医疗机构名称
        et_admissionReason1 = (FuEditText) mFuView.findViewById(R.id.et_admissionReason1);    //原因
        et_medicalRecordNo2 = (FuEditText) mFuView.findViewById(R.id.et_medicalRecordNo2);    //病案号
        et_admissionDate2 = (FuEditText) mFuView.findViewById(R.id.et_admissionDate2);      //入院日期
        et_admissionDate2.setOnClickListener(this);
        et_dischargeDate2 = (FuEditText) mFuView.findViewById(R.id.et_dischargeDate2);       //出院日期
        et_dischargeDate2.setOnClickListener(this);
        et_hospitalName2 = (FuEditText) mFuView.findViewById(R.id.et_hospitalName2);       //医疗机构名称
        et_admissionReason2 = (FuEditText) mFuView.findViewById(R.id.et_admissionReason2);    //原因
        et_drugName = (FuEditText) mFuView.findViewById(R.id.et_drugName);        //用药名称
        et_drugUsageCode = (FuEditText) mFuView.findViewById(R.id.et_drugUsageCode);   //用法
        et_drugDose = (FuEditText) mFuView.findViewById(R.id.et_drugDose);        //用量
        et_drugTime = (FuEditText) mFuView.findViewById(R.id.et_drugTime);        //用药时间
        ll_drugCompliance = (LinearLayout) mFuView.findViewById(R.id.ll_drugCompliance);//服药依从性
        et_vaccineCode = (FuEditText) mFuView.findViewById(R.id.et_vaccineCode);     //名称
        et_vaccinationDate = (FuEditText) mFuView.findViewById(R.id.et_vaccinationDate);//接种日期
        et_vaccinationDate.setOnClickListener(this);
        et_vaccinationOrgName = (FuEditText) mFuView.findViewById(R.id.et_vaccinationOrgName);// 接种机构
        cb_isSmoking = (CheckBox) mFuView.findViewById(R.id.cb_isSmoking);//戒烟
        cb_isDrinking = (CheckBox) mFuView.findViewById(R.id.cb_isDrinking);//健康饮酒
        cb_isFood = (CheckBox) mFuView.findViewById(R.id.cb_isFood); // 饮食
        cb_isExercise = (CheckBox) mFuView.findViewById(R.id.cb_isExercise);//锻炼
        cb_isLost = (CheckBox) mFuView.findViewById(R.id.cb_isLost); // 减体重
        et_lost = (FuEditText) mFuView.findViewById(R.id.et_lost);   //减体重
        cb_vaccination = (CheckBox) mFuView.findViewById(R.id.cb_vaccination);//建议接种疫苗
        et_vaccination = (FuEditText) mFuView.findViewById(R.id.et_vaccination);//疫苗
        cb_other = (CheckBox) mFuView.findViewById(R.id.cb_other);//其他
        et_other = (FuEditText) mFuView.findViewById(R.id.et_other);//其他
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_healthExamInhos1:
                addhealthExamInhos1();
                break;
            case R.id.btn_healthExamInhos2:
                addhealthExamInhos2();
                break;
            case R.id.btn_healthExamDrug:
                addhealthExamDrug();
                break;
            case R.id.btn_healthExamNoplanVacc:
                addhealthExamNoplanVacc();
                break;
            case R.id.et_admissionDate1:
                ((FuParentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.et_admissionDate2:
                ((FuParentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.et_dischargeDate1:
                ((FuParentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.et_dischargeDate2:
                ((FuParentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.et_vaccinationDate:
                ((FuParentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
        }
    }

    public void addhealthExamInhos1() {
        HealthExamInhos healthExamInhos = new HealthExamInhos();
        healthExamInhos.setMedicalRecordNo(et_medicalRecordNo1.getString());
        healthExamInhos.setAdmissionDate(et_admissionDate1.getDate());
        healthExamInhos.setDischargeDate(et_dischargeDate1.getDate());
        healthExamInhos.setHospitalName(et_hospitalName1.getString());
        healthExamInhos.setAdmissionReason(et_admissionReason1.getString());
        healthExamInhos.setInhosHistoryTypeCode("1");
        healthExamInhos.setHealthExamId(healthExamId);
        list_healthExamInhos1.add(healthExamInhos);
        healthExamInhos1Adapter.notifyDataSetChanged();
    }

    public void addhealthExamInhos2() {
        HealthExamInhos healthExamInhos = new HealthExamInhos();
        healthExamInhos.setMedicalRecordNo(et_medicalRecordNo2.getString());
        healthExamInhos.setAdmissionDate(et_admissionDate2.getDate());
        healthExamInhos.setDischargeDate(et_dischargeDate2.getDate());
        healthExamInhos.setHospitalName(et_hospitalName2.getString());
        healthExamInhos.setAdmissionReason(et_admissionReason2.getString());
        healthExamInhos.setHealthExamId(healthExamId);
        healthExamInhos.setInhosHistoryTypeCode("2");
        list_healthExamInhos2.add(healthExamInhos);
        healthExamInhos2Adapter.notifyDataSetChanged();
    }

    public void addhealthExamDrug() {
        HealthExamDrug healthExamDrug = new HealthExamDrug();
        healthExamDrug.setHealthExamId(healthExamId);
        healthExamDrug.setDrugName(et_drugName.getString());    //用药名称
        healthExamDrug.setDrugUsageCode(et_drugUsageCode.getString());//用法
        healthExamDrug.setDrugDose(et_drugDose.getString());    //用量
        healthExamDrug.setDrugTime(et_drugTime.getString());    //用药时间
        healthExamDrug.setDrugComplianceCode(getCheckBoxSimpleCode(ll_drugCompliance));
        healthExamDrug.setDrugComplianceValue(getRadioString(ll_drugCompliance));
        list_healthExamDrug.add(healthExamDrug);
        healthExamDrugAdapter.notifyDataSetChanged();

    }

    public void addhealthExamNoplanVacc() {

        HealthExamNoplanVacc healthExamNoplanVacc = new HealthExamNoplanVacc();
        healthExamNoplanVacc.setHealthExamId(healthExamId);
        healthExamNoplanVacc.setVaccineCode(et_vaccineCode.getString());
        healthExamNoplanVacc.setVaccinationOrgName(et_vaccinationOrgName.getString());
        healthExamNoplanVacc.setVaccinationDate(et_vaccinationDate.getDate());
        list_healthExamNoplanVacc.add(healthExamNoplanVacc);
        healthExamNoplanVaccAdapter.notifyDataSetChanged();

    }


    class HealthExamInhos1Adapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public HealthExamInhos1Adapter(Context c) {
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return list_healthExamInhos1 == null ? 0 : list_healthExamInhos1.size();
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
            HealthExamInhosHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fu_exam_item_zys, null);
                holder = new HealthExamInhosHolder();
                holder.tv_medicalRecordNo = (FuTextView) convertView.findViewById(R.id.tv_medicalRecordNo);
                holder.tv_hospitalName = (FuTextView) convertView.findViewById(R.id.tv_hospitalName);
                holder.tv_admissionDate = (FuTextView) convertView.findViewById(R.id.tv_admissionDate);
                holder.tv_dischargeDate = (FuTextView) convertView.findViewById(R.id.tv_dischargeDate);
                holder.tv_admissionReason = (FuTextView) convertView.findViewById(R.id.tv_admissionReason);
                holder.tv_delete = (FuTextView) convertView.findViewById(R.id.tv_delete);
                convertView.setTag(holder);
            } else {
                holder = (HealthExamInhosHolder) convertView.getTag();
            }
            holder.tv_medicalRecordNo.setText(list_healthExamInhos1.get(position).getMedicalRecordNo());
            holder.tv_hospitalName.setText(list_healthExamInhos1.get(position).getHospitalName());
            holder.tv_admissionDate.setText(list_healthExamInhos1.get(position).getAdmissionDate());
            holder.tv_dischargeDate.setText(list_healthExamInhos1.get(position).getDischargeDate());
            holder.tv_admissionReason.setText(list_healthExamInhos1.get(position).getAdmissionReason());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setTag(list_healthExamInhos1.get(position));

            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list_healthExamInhos1.remove(position);
                    healthExamInhos1Adapter.notifyDataSetChanged();
                }
            });
            return convertView;
        }

        private class HealthExamInhosHolder {
            FuTextView tv_medicalRecordNo;   //病案号
            FuTextView tv_hospitalName;       //医疗机构名称
            FuTextView tv_admissionDate;      //入院日期
            FuTextView tv_dischargeDate;    //出院日期
            FuTextView tv_admissionReason;    //原因
            FuTextView tv_delete;             //删除
        }

    }


    class HealthExamInhos2Adapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public HealthExamInhos2Adapter(Context c) {
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return list_healthExamInhos2 == null ? 0 : list_healthExamInhos2.size();
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
            HealthExamInhosHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fu_exam_item_zys, null);
                holder = new HealthExamInhosHolder();
                holder.tv_medicalRecordNo = (FuTextView) convertView.findViewById(R.id.tv_medicalRecordNo);
                holder.tv_hospitalName = (FuTextView) convertView.findViewById(R.id.tv_hospitalName);
                holder.tv_admissionDate = (FuTextView) convertView.findViewById(R.id.tv_admissionDate);
                holder.tv_dischargeDate = (FuTextView) convertView.findViewById(R.id.tv_dischargeDate);
                holder.tv_admissionReason = (FuTextView) convertView.findViewById(R.id.tv_admissionReason);
                holder.tv_delete = (FuTextView) convertView.findViewById(R.id.tv_delete);
                convertView.setTag(holder);
            } else {
                holder = (HealthExamInhosHolder) convertView.getTag();
            }
            holder.tv_medicalRecordNo.setText(list_healthExamInhos2.get(position).getMedicalRecordNo());
            holder.tv_hospitalName.setText(list_healthExamInhos2.get(position).getHospitalName());
            holder.tv_admissionDate.setText(list_healthExamInhos2.get(position).getAdmissionDate());
            holder.tv_dischargeDate.setText(list_healthExamInhos2.get(position).getDischargeDate());
            holder.tv_admissionReason.setText(list_healthExamInhos2.get(position).getAdmissionReason());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setTag(list_healthExamInhos2.get(position));
            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list_healthExamInhos2.remove(position);
                    healthExamInhos2Adapter.notifyDataSetChanged();
                }
            });
            return convertView;
        }

        private class HealthExamInhosHolder {
            FuTextView tv_medicalRecordNo;   //病案号
            FuTextView tv_hospitalName;       //医疗机构名称
            FuTextView tv_admissionDate;      //入院日期
            FuTextView tv_dischargeDate;    //出院日期
            FuTextView tv_admissionReason;    //原因
            FuTextView tv_delete;             //删除
        }

    }


    class HealthExamDrugAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public HealthExamDrugAdapter(Context c) {
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return list_healthExamDrug == null ? 0 : list_healthExamDrug.size();
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
            HealthExamInhosHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fu_exam_item_yyqk, null);
                holder = new HealthExamInhosHolder();
                holder.tv_drugName = (FuTextView) convertView.findViewById(R.id.tv_drugName);
                holder.tv_drugUsageCode = (FuTextView) convertView.findViewById(R.id.tv_drugUsageCode);
                holder.tv_drugDose = (FuTextView) convertView.findViewById(R.id.tv_drugDose);
                holder.tv_drugTime = (FuTextView) convertView.findViewById(R.id.tv_drugTime);
                holder.tv_drugComplianceValue = (FuTextView) convertView.findViewById(R.id.tv_drugComplianceValue);
                holder.tv_delete = (FuTextView) convertView.findViewById(R.id.tv_delete);
                convertView.setTag(holder);
            } else {
                holder = (HealthExamInhosHolder) convertView.getTag();
            }
            holder.tv_drugName.setText(list_healthExamDrug.get(position).getDrugName());
            holder.tv_drugUsageCode.setText(list_healthExamDrug.get(position).getDrugUsageCode());
            holder.tv_drugDose.setText(list_healthExamDrug.get(position).getDrugDose());
            holder.tv_drugTime.setText(list_healthExamDrug.get(position).getDrugTime());
            holder.tv_drugComplianceValue.setText(list_healthExamDrug.get(position).getDrugComplianceValue());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list_healthExamDrug.remove(position);
                    healthExamDrugAdapter.notifyDataSetChanged();
                }
            });
            return convertView;
        }

        private class HealthExamInhosHolder {
            FuTextView tv_drugName;   //药物名称
            FuTextView tv_drugUsageCode;       //用法
            FuTextView tv_drugDose;      //用量
            FuTextView tv_drugTime;    //用药时间
            FuTextView tv_drugComplianceValue;    //服药依从性
            FuTextView tv_delete;         //删除
        }
    }


    class HealthExamNoplanVaccAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public HealthExamNoplanVaccAdapter(Context c) {
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return list_healthExamNoplanVacc == null ? 0 : list_healthExamNoplanVacc.size();
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
            HealthExamInhosHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fu_exam_item_jzs, null);
                holder = new HealthExamInhosHolder();
                holder.tv_vaccineCode = (FuTextView) convertView.findViewById(R.id.tv_vaccineCode);
                holder.tv_vaccinationDate = (FuTextView) convertView.findViewById(R.id.tv_vaccinationDate);
                holder.tv_vaccinationOrgName = (FuTextView) convertView.findViewById(R.id.tv_vaccinationOrgName);
                holder.tv_delete = (FuTextView) convertView.findViewById(R.id.tv_delete);
                convertView.setTag(holder);
            } else {
                holder = (HealthExamInhosHolder) convertView.getTag();
            }
            holder.tv_vaccineCode.setText(list_healthExamNoplanVacc.get(position).getVaccineCode());
            holder.tv_vaccinationDate.setText(list_healthExamNoplanVacc.get(position).getVaccinationDate());
            holder.tv_vaccinationOrgName.setText(list_healthExamNoplanVacc.get(position).getVaccinationOrgName());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setTag(list_healthExamNoplanVacc.get(position));
            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list_healthExamNoplanVacc.remove(position);
                    healthExamNoplanVaccAdapter.notifyDataSetChanged();
                }
            });
            return convertView;
        }

        private class HealthExamInhosHolder {
            FuTextView tv_vaccineCode;        //名称
            FuTextView tv_vaccinationDate;       //接种日期
            FuTextView tv_vaccinationOrgName;      //接种机构
            FuTextView tv_delete;             // 删除
        }

    }

}
