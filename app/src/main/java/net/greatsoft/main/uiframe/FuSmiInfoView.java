package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.helper.ChecksDao;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.smi.SmiInfo;
import net.greatsoft.main.fragment.FuSmiInfoFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuCheckBox;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/12/21
 * Time: 10:44
 * progject: Chss
 * Describe： 重性精神病个人信息补全表
 */

public class FuSmiInfoView extends FuUiFrameModel implements View.OnClickListener {

    FuTextView tv_name; //姓名
    FuTextView tv_manageDate; //纳入管理日期
    FuEditText et_guardianName; //监护人姓名
    Spinner sp_guardianRelationCode; //与患者关系
    FuEditText et_guardianAddr; //监护人地址
    FuEditText et_guardianTelNo; //监护人电话
    FuEditText et_communityContactTelNo; //辖区村(局)委会联系人、电话
    LinearLayout ll_permanentTypeCode; //居住地
    LinearLayout ll_employmentStatusCode; //就业情况
    LinearLayout ll_informedConsentCode; //知情情况
    FuEditText et_informedConsentSignerName; //签字
    FuTextView tv_informedConsentSignDate; //签字时间
    FuTextView tv_smiFirstOnsetDate; //初次发病时间
    LinearLayout ll_jwzz; //既往主要症状
    LinearLayout ll_passLockCode; //既往关锁情况
    LinearLayout ll_pastClinicTreatCode; //门诊
    FuTextView tv_firstAntipsyTreatDate; //首次抗精神病治疗时间
    FuEditText et_pastPsyInpatTimes; //曾住精神病专科医院
    LinearLayout ll_lastTreatResultCode; //最近一次治疗效果
    Spinner sp_smiCode; //诊断
    FuEditText et_confirmedDiagOrgName; //确诊医院
    FuTextView tv_confirmedDiagDate; //确诊日期
    FuCheckBox cb_check1; //无
    FuCheckBox cb_lowRandalieren; //轻度滋事
    FuEditText et_lowRandalierenTimes; //轻度滋事
    FuCheckBox cb_causeTrouble; //肇事
    FuEditText et_causeTroubleTimes; //肇事
    FuCheckBox cb_accident; //肇祸
    FuEditText et_accidentTimes; //肇祸
    FuCheckBox cb_otherHarm; //其他危害行为
    FuEditText et_otherHarmTimes; //其他危害行为
    FuCheckBox cb_autolesion; //自伤
    FuEditText et_autolesionTimes; //自伤
    FuCheckBox cb_incompleteSuicide; //自杀未遂
    FuEditText et_incompleteSuicideTimes; //自杀未遂
    LinearLayout ll_financialSituationCode; //经济情况
    FuEditText et_specialistAdvice; //专科医生的意见
    FuTextView tv_fillDate; //填表日期
    Spinner sp_signatureDoctorName; //医生签字

    TextView fu_title_center;
    Button fu_title_right_btn;


    public FuSmiInfoView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_manageDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_smiFirstOnsetDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_firstAntipsyTreatDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_confirmedDiagDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_fillDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuSmiInfoFragment.EVENT_SAVE_SMI_INFO, null);
                break;
            case R.id.tv_informedConsentSignDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
        }

    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(R.layout.fu_smi_info_view, null);
    }

    @Override
    protected void initFuData() {

        //与户主关系 不同意参加管理

        List list = sqlHelper.getChecksByTerm("relation");
        ArrayAdapter adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_guardianRelationCode.setAdapter(adapter);

        list = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq("seriousMentalDisease")).orderAsc(ChecksDao.Properties.Code).list();
        adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_smiCode.setAdapter(adapter);

        //医生
        List<Emp> empList = sqlHelper.getAllEmpList();
        adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_signatureDoctorName.setAdapter(adapter);

        initCheckBoxMany("smiSymptom", ll_jwzz, 3, true, true);
        initCheckBoxSimple("OUTPATIENT", ll_pastClinicTreatCode, 2, true);
        initCheckBoxSimple("TREAT_EFFECT", ll_lastTreatResultCode, false);
        initCheckBoxSimple("LOCK_SITUATION", ll_passLockCode, false);
        initCheckBoxSimple("ECONOMY_STATUS", ll_financialSituationCode, 2);
        initCheckBoxSimple("smiAgree", ll_informedConsentCode, 2);
        initCheckBoxSimple("employmentStatusCode", ll_employmentStatusCode, 3);
        initCheckBoxSimple("permanentTypeCode", ll_permanentTypeCode, 2);

    }

    @Override
    protected void initWidget() {

        findView();

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("重性精神病个人信息补充表");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    public void setData(SmiInfo smiInfo) {
        tv_name.setText(smiInfo.getName());
    }

    public boolean saveData(SmiInfo smiInfo) {

        if ("".equals(tv_manageDate.getText().toString())) {
            ToastUtil.showToast(mContext, "请输入纳入管理日期", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_guardianName.getString())) {
            ToastUtil.showToast(mContext, "请输入监护人姓名", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_guardianAddr.getString())) {
            ToastUtil.showToast(mContext, "请输入监护人地址", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_guardianTelNo.getString())) {
            ToastUtil.showToast(mContext, "请输入监护人电话", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(tv_smiFirstOnsetDate.getText().toString())) {
            ToastUtil.showToast(mContext, "请输入初次发病时间", Toast.LENGTH_LONG);
            return false;
        }
        boolean flag = true;
        saveCheckBoxMany(null, smiInfo.getRecordChoice(), ll_jwzz); //目前症状
        List<RecordChoice> choice = smiInfo.getRecordChoice();//目前症状
        for (int i = 0; i < choice.size(); i++) {
            if ("smiSymptom".equals(choice.get(i).getCodeType())) {
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择主要症状", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_passLockCode))) {
            ToastUtil.showToast(mContext, "请选择既往关锁情况", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_pastClinicTreatCode)) || "".equals(tv_firstAntipsyTreatDate.getText().toString())) {
            ToastUtil.showToast(mContext, "请填选门诊", Toast.LENGTH_LONG);
            return false;
        }
//        if ("".equals(et_pastPsyInpatTimes.getString())) {
//            ToastUtil.showToast(mContext, "请输入曾住精神病专科医院次数", Toast.LENGTH_LONG);
//            return false;
//        }
        if ("".equals(getCheckBoxSimpleCode(ll_lastTreatResultCode))) {
            ToastUtil.showToast(mContext, "请选择最近一次治疗效果", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(tv_fillDate.getText().toString())) {
            ToastUtil.showToast(mContext, "请选择填表日期", Toast.LENGTH_LONG);
            return false;
        }

        smiInfo.setManageDate(tv_manageDate.getDate()); //纳入管理日期
        smiInfo.setGuardianName(et_guardianName.getString()); //监护人姓名
        Checks checks = (Checks) sp_guardianRelationCode.getSelectedItem();
        smiInfo.setGuardianRelationCode(checks.getCode());  //与户主关系
        smiInfo.setGuardianAddr(et_guardianAddr.getString());//监护人地址
        smiInfo.setGuardianTelNo(et_guardianTelNo.getString()); //监护人电话
        smiInfo.setCommunityContactTelNo(et_communityContactTelNo.getString());//辖区村(局)委会联系人、电话
        smiInfo.setPermanentTypeCode(getCheckBoxSimpleCode(ll_permanentTypeCode)); //居住地
        smiInfo.setEmploymentStatusCode(getCheckBoxSimpleCode(ll_employmentStatusCode)); //就业情况
        smiInfo.setInformedConsentCode(getCheckBoxSimpleCode(ll_informedConsentCode));//知情情况
        smiInfo.setInformedConsentSignerName(et_informedConsentSignerName.getString());
        smiInfo.setInformedConsentSignDate(tv_informedConsentSignDate.getDate());
        smiInfo.setSmiFirstOnsetDate(tv_smiFirstOnsetDate.getDate());//初次发病时间
        smiInfo.setPassLockCode(getCheckBoxSimpleCode(ll_passLockCode));//既往关锁情况
        smiInfo.setPastClinicTreatCode(getCheckBoxSimpleCode(ll_pastClinicTreatCode));//门诊
        smiInfo.setFirstAntipsyTreatDate(tv_firstAntipsyTreatDate.getDate());//首次抗精神病治疗时间
        smiInfo.setPastPsyInpatTimes(et_pastPsyInpatTimes.getInt());//曾住精神病专科医院
        smiInfo.setLastTreatResultCode(getCheckBoxSimpleCode(ll_lastTreatResultCode));//最近一次治疗效果
//        smiInfo.setSmiCode(et_smiName.getString());//诊断
        Checks item = (Checks) sp_smiCode.getSelectedItem();
        smiInfo.setSmiCode(item.getCode());
        smiInfo.setSmiName(item.getValue());
        smiInfo.setConfirmedDiagOrgName(et_confirmedDiagOrgName.getString()); //确诊医院
        smiInfo.setConfirmedDiagDate(tv_confirmedDiagDate.getDate()); //确诊日期
        smiInfo.setLowRandalieren(cb_lowRandalieren.isChecked() ? "1" : "0");  //轻度滋事
        smiInfo.setLowRandalierenTimes(et_lowRandalierenTimes.getInt());  //轻度滋事
        smiInfo.setCauseTrouble(cb_causeTrouble.isChecked() ? "1" : "0");//肇事
        smiInfo.setCauseTroubleTimes(et_causeTroubleTimes.getInt());      //肇事
        smiInfo.setAccident(cb_accident.isChecked() ? "1" : "0");  //肇祸
        smiInfo.setAccidentTimes(et_accidentTimes.getInt());    //肇祸
        smiInfo.setOtherHarm(cb_otherHarm.isChecked() ? "1" : "0");  //其他危害行为
        smiInfo.setOtherHarmTimes(et_otherHarmTimes.getInt());    //其他危害行为
        smiInfo.setAutolesion(cb_autolesion.isChecked() ? "1" : "0");     //自伤
        smiInfo.setAutolesionTimes(et_autolesionTimes.getInt());            //自伤
        smiInfo.setIncompleteSuicide(cb_incompleteSuicide.isChecked() ? "1" : "0");   //
        smiInfo.setIncompleteSuicideTimes(et_incompleteSuicideTimes.getInt());  //自杀未遂
        smiInfo.setFinancialSituationCode(getCheckBoxSimpleCode(ll_financialSituationCode)); //经济情况
        smiInfo.setSpecialistAdvice(et_specialistAdvice.getString());//专科医生的意见
        smiInfo.setFillDate(tv_fillDate.getDate());//填表日期
        Emp emp = (Emp) sp_signatureDoctorName.getSelectedItem();
        smiInfo.setSignatureDoctorId(emp.getEmp_id());
        smiInfo.setSignatureDoctorName(emp.getEmp_name());  //医生签字

        return true;
    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name); //姓名
        tv_manageDate = (FuTextView) mFuView.findViewById(R.id.tv_manageDate); //纳入管理日期
        tv_manageDate.setOnClickListener(this);
        et_guardianName = (FuEditText) mFuView.findViewById(R.id.et_guardianName); //监护人姓名
        sp_guardianRelationCode = (Spinner) mFuView.findViewById(R.id.sp_guardianRelationCode); //与患者关系
        et_guardianAddr = (FuEditText) mFuView.findViewById(R.id.et_guardianAddr); //监护人地址
        et_guardianTelNo = (FuEditText) mFuView.findViewById(R.id.et_guardianTelNo); //监护人电话
        et_communityContactTelNo = (FuEditText) mFuView.findViewById(R.id.et_communityContactTelNo); //辖区村(局)委会联系人、电话
        ll_permanentTypeCode = (LinearLayout) mFuView.findViewById(R.id.ll_permanentTypeCode); //居住地
        ll_employmentStatusCode = (LinearLayout) mFuView.findViewById(R.id.ll_employmentStatusCode); //就业情况
        ll_informedConsentCode = (LinearLayout) mFuView.findViewById(R.id.ll_informedConsentCode); //知情情况
        et_informedConsentSignerName = (FuEditText) mFuView.findViewById(R.id.et_informedConsentSignerName); //签字
        tv_informedConsentSignDate = (FuTextView) mFuView.findViewById(R.id.tv_informedConsentSignDate); //签字时间
        tv_informedConsentSignDate.setOnClickListener(this);
        tv_smiFirstOnsetDate = (FuTextView) mFuView.findViewById(R.id.tv_smiFirstOnsetDate); //初次发病时间
        tv_smiFirstOnsetDate.setOnClickListener(this);
        ll_jwzz = (LinearLayout) mFuView.findViewById(R.id.ll_jwzz); //既往主要症状
        ll_passLockCode = (LinearLayout) mFuView.findViewById(R.id.ll_passLockCode); //既往关锁情况
        ll_pastClinicTreatCode = (LinearLayout) mFuView.findViewById(R.id.ll_pastClinicTreatCode); //门诊
        tv_firstAntipsyTreatDate = (FuTextView) mFuView.findViewById(R.id.tv_firstAntipsyTreatDate); //首次抗精神病治疗时间
        tv_firstAntipsyTreatDate.setOnClickListener(this);
        et_pastPsyInpatTimes = (FuEditText) mFuView.findViewById(R.id.et_pastPsyInpatTimes); //曾住精神病专科医院
        ll_lastTreatResultCode = (LinearLayout) mFuView.findViewById(R.id.ll_lastTreatResultCode); //最近一次治疗效果
        sp_smiCode = (Spinner) mFuView.findViewById(R.id.sp_smiCode); //诊断
        et_confirmedDiagOrgName = (FuEditText) mFuView.findViewById(R.id.et_confirmedDiagOrgName); //确诊医院
        tv_confirmedDiagDate = (FuTextView) mFuView.findViewById(R.id.tv_confirmedDiagDate); //确诊日期
        tv_confirmedDiagDate.setOnClickListener(this);
        cb_check1 = (FuCheckBox) mFuView.findViewById(R.id.cb_check1); //无
        cb_lowRandalieren = (FuCheckBox) mFuView.findViewById(R.id.cb_lowRandalieren); //轻度滋事
        et_lowRandalierenTimes = (FuEditText) mFuView.findViewById(R.id.et_lowRandalierenTimes); //轻度滋事
        cb_causeTrouble = (FuCheckBox) mFuView.findViewById(R.id.cb_causeTrouble); //肇事
        et_causeTroubleTimes = (FuEditText) mFuView.findViewById(R.id.et_causeTroubleTimes); //肇事
        cb_accident = (FuCheckBox) mFuView.findViewById(R.id.cb_accident); //肇祸
        et_accidentTimes = (FuEditText) mFuView.findViewById(R.id.et_accidentTimes); //肇祸
        cb_otherHarm = (FuCheckBox) mFuView.findViewById(R.id.cb_otherHarm); //其他危害行为
        et_otherHarmTimes = (FuEditText) mFuView.findViewById(R.id.et_otherHarmTimes); //其他危害行为
        cb_autolesion = (FuCheckBox) mFuView.findViewById(R.id.cb_autolesion); //自伤
        et_autolesionTimes = (FuEditText) mFuView.findViewById(R.id.et_autolesionTimes); //自伤
        cb_incompleteSuicide = (FuCheckBox) mFuView.findViewById(R.id.cb_incompleteSuicide); //自杀未遂
        et_incompleteSuicideTimes = (FuEditText) mFuView.findViewById(R.id.et_incompleteSuicideTimes); //自杀未遂
        ll_financialSituationCode = (LinearLayout) mFuView.findViewById(R.id.ll_financialSituationCode); //经济情况
        et_specialistAdvice = (FuEditText) mFuView.findViewById(R.id.et_specialistAdvice); //专科医生的意见
        tv_fillDate = (FuTextView) mFuView.findViewById(R.id.tv_fillDate); //填表日期
        tv_fillDate.setOnClickListener(this);
        sp_signatureDoctorName = (Spinner) mFuView.findViewById(R.id.sp_signatureDoctorName); //医生签字

    }
}
