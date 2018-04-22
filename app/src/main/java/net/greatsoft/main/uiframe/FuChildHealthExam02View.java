package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.child.ChildHealthExam;
import net.greatsoft.main.fragment.FuChildHealthExam02Fragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/12.
 */

public class FuChildHealthExam02View extends FuUiFrameModel implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    FuTextView tv_newbornName; //姓名
    Spinner sp_ageCode; //月龄
    FuTextView tv_followupVisitDate; //随访日期
    FuEditText et_headCircumference; //头围
    LinearLayout zyyjkglfw; //中医药健康管理服务容器
    LinearLayout ll_zyyjkglfw; //中医药健康管理服务
    FuEditText et_weight; //体重
    LinearLayout ll_weightEvalCode; //体重
    FuEditText et_height; //身长
    LinearLayout ll_heightEvalCode; //身长
    LinearLayout ll_childComplexionCode; //面色
    LinearLayout ll_skinAbnorm; //皮肤
    LinearLayout ll_bregmaClose; //前囟
    FuEditText et_bregmaHorizDiameter; //前囟
    FuEditText et_bregmaVertDiameter; //前囟
    LinearLayout neckMassCode; //颈部包块容器
    LinearLayout ll_neckMassCode; //颈部包块
    LinearLayout ll_eyeAbnormCode; //眼外观
    LinearLayout ll_earAbnormCode; //耳朵
    LinearLayout hearingScreenResultCode; //听力容器
    LinearLayout ll_hearingScreenResultCode; //听力
    LinearLayout oralAbnormCode; //口腔容器
    LinearLayout ll_oralAbnormCode; //口腔
    FuEditText et_teethCount; //出牙数
    LinearLayout teethCount; //出牙数容器
    LinearLayout ll_heartAbnormCode; //胸部
    LinearLayout ll_abdomenAbnormCode; //腹部
    LinearLayout umbcordFallCode; //脐部容器
    LinearLayout ll_umbcordFallCode; //脐部
    LinearLayout ll_limbsAbnormCode; //四肢
    LinearLayout ricketsSymptomCode; //可疑佝偻病症状容器
    LinearLayout ricketsSignCode; //可疑佝偻病体征容器
    LinearLayout ll_ricketsSymptomCode; //可疑佝偻病症状
    LinearLayout ll_ricketsSignCode; //可疑佝偻病体征
    LinearLayout ll_anusAbnormCode; //肛门/外生殖器
    LinearLayout hgb; //血红蛋白值容器
    FuEditText et_hgb; //血红蛋白值
    FuEditText et_outdoorActHours; //户外活动
    FuEditText et_vitamindDose; //服用维生素D
    LinearLayout developPassCode; //运动发育评估容器
    LinearLayout ll_developPassCode; //运动发育评估
    LinearLayout ll_sickVisitCode; //两次随访患病情况
    FuEditText et_pneumVisitTimes; //肺炎次数
    FuEditText et_diarrheaVisitTimes; //腹泻次数
    FuEditText et_traumaVisitTimes; //外伤次数
    FuEditText et_othersVisitDesc; //其他
    LinearLayout ll_referralCode; //转诊建议
    FuEditText et_referralReason; //原因
    FuEditText et_refertoOrgName; //机构及科室
    LinearLayout ll_zhidao; //指导
    FuTextView tv_nextFollowupDate; //下次随访日期
    Spinner sp_followupVisitDoctorName; //随访医生签名


    public FuChildHealthExam02View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_child_health_exam_02, null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuChildHealthExam02Fragment.EVENT_SAVE_HEALTH, null);
                break;
            case R.id.tv_nextFollowupDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_followupVisitDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
        }
    }

    public boolean saveData(ChildHealthExam childHealthExam) {

        if ("".equals(tv_followupVisitDate.getText().toString())) {
            ToastUtil.showToast(mContext, "请选择随访日期", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_weight.getString()) || "".equals(getCheckBoxSimpleCode(ll_weightEvalCode))) {
            ToastUtil.showToast(mContext, "请填选体重", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_height.getString()) || "".equals(getCheckBoxSimpleCode(ll_heightEvalCode))) {
            ToastUtil.showToast(mContext, "请填选身长", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_childComplexionCode))) {
            ToastUtil.showToast(mContext, "请选择面色", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_skinAbnorm))) {
            ToastUtil.showToast(mContext, "请选择皮肤", Toast.LENGTH_LONG);
            return false;
        }
        if ("2".equals(getCheckBoxSimpleCode(ll_bregmaClose))) {
            if ("".equals(et_bregmaHorizDiameter.getString()) || "".equals(et_bregmaVertDiameter.getString())) {
                ToastUtil.showToast(mContext, "请填选前囟", Toast.LENGTH_LONG);
                return false;
            }
        }
        if ("".equals(getCheckBoxSimpleCode(ll_eyeAbnormCode))) {
            ToastUtil.showToast(mContext, "请选择眼外观", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_earAbnormCode))) {
            ToastUtil.showToast(mContext, "请选择耳朵", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_heartAbnormCode))) {
            ToastUtil.showToast(mContext, "请选择心肺", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_abdomenAbnormCode))) {
            ToastUtil.showToast(mContext, "请选择腹部", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_limbsAbnormCode))) {
            ToastUtil.showToast(mContext, "请选择四肢", Toast.LENGTH_LONG);
            return false;
        }
        boolean flag = true;
        List<RecordChoice> choice = childHealthExam.getRecordChoice();
        if (ricketsSymptomCode.getVisibility() == View.VISIBLE) {
            saveCheckBoxMany(null, childHealthExam.getRecordChoice(), ll_ricketsSymptomCode);//可疑佝偻病症状
            for (int i = 0; i < choice.size(); i++) {
                if ("ricketsSymptoms".equals(choice.get(i).getCodeType())) {
                    flag = false;
                }
            }
            if (flag) {
                ToastUtil.showToast(mContext, "请选择可疑佝偻病症状", Toast.LENGTH_LONG);
                return false;
            }
        }
        flag = true;
        if (ricketsSignCode.getVisibility() == View.VISIBLE) {
            saveCheckBoxMany(null, childHealthExam.getRecordChoice(), ll_ricketsSignCode);//可疑佝偻病体征
            choice = childHealthExam.getRecordChoice();
            for (int i = 0; i < choice.size(); i++) {
                if ("ricketsSign13".equals(choice.get(i).getCodeType()) || "ricketsSign68".equals(choice.get(i).getCodeType())) {
                    flag = false;
                }
            }
            if (flag) {
                ToastUtil.showToast(mContext, "请选择可疑佝偻病体征", Toast.LENGTH_LONG);
                return false;
            }
        }
        if ("".equals(getCheckBoxSimpleCode(ll_anusAbnormCode))) {
            ToastUtil.showToast(mContext, "请选择肛门/外生殖器", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_outdoorActHours.getString())) {
            ToastUtil.showToast(mContext, "请选择户外活动", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(tv_nextFollowupDate.getText().toString())) {
            ToastUtil.showToast(mContext, "请选择下次随访日期", Toast.LENGTH_LONG);
            return false;
        }

        Checks checks = (Checks) sp_ageCode.getSelectedItem();
        childHealthExam.setAgeCode(checks.getCode());
        childHealthExam.setVisitType(2);


        childHealthExam.setFollowupVisitDate(tv_followupVisitDate.getDate()); //随访日期
        childHealthExam.setHeadCircumference(et_headCircumference.getDouble()); //头围
        saveCheckBoxMany(null, childHealthExam.getRecordChoice(), ll_zyyjkglfw); //中医药健康管理服务
        childHealthExam.setWeight(et_weight.getDouble()); //体重
        childHealthExam.setWeightEvalCode(getCheckBoxSimpleCode(ll_weightEvalCode)); //体重
        childHealthExam.setHeight(et_height.getDouble()); //身长
        childHealthExam.setHeightEvalCode(getCheckBoxSimpleCode(ll_heightEvalCode)); //身长
        childHealthExam.setChildComplexionCode(getCheckBoxSimpleCode(ll_childComplexionCode)); //面色
        childHealthExam.setChildComplexionValue(getString(ll_childComplexionCode));
        childHealthExam.setSkinAbnormCode(getCheckBoxSimpleCode(ll_skinAbnorm)); //皮肤
        childHealthExam.setSkinAbnormValue(getString(ll_skinAbnorm));
        childHealthExam.setBregmaCloseCode(getCheckBoxSimpleCode(ll_bregmaClose)); //前囟
        childHealthExam.setBregmaHorizDiameter(et_bregmaHorizDiameter.getDouble()); //前囟
        childHealthExam.setBregmaVertDiameter(et_bregmaVertDiameter.getDouble()); //前囟
        childHealthExam.setNeckMassCode(getCheckBoxSimpleCode(ll_neckMassCode)); //颈部包块
        childHealthExam.setEyeAbnormCode(getCheckBoxSimpleCode(ll_eyeAbnormCode)); //眼外观
        childHealthExam.setEyeAbnormValue(getString(ll_eyeAbnormCode));
        childHealthExam.setEarAbnormCode(getCheckBoxSimpleCode(ll_earAbnormCode)); //耳朵
        childHealthExam.setTeethCount(et_teethCount.getInt()); //耳朵
        childHealthExam.setEarAbnormValue(getString(ll_earAbnormCode));
        childHealthExam.setHearingScreenResultCode(getCheckBoxSimpleCode(ll_hearingScreenResultCode)); //听力
        childHealthExam.setOralAbnormCode(getCheckBoxSimpleCode(ll_oralAbnormCode)); //口腔
        childHealthExam.setOralAbnormValue(getString(ll_oralAbnormCode));
        childHealthExam.setHeartAbnormCode(getCheckBoxSimpleCode(ll_heartAbnormCode)); //心肺
        childHealthExam.setHeartAbnormValue(getString(ll_heartAbnormCode));
        childHealthExam.setAbdomenAbnormCode(getCheckBoxSimpleCode(ll_abdomenAbnormCode)); //腹部
        childHealthExam.setAbdomenAbnormValue(getString(ll_abdomenAbnormCode));
        childHealthExam.setUmbcordFallCode(getCheckBoxSimpleCode(ll_umbcordFallCode)); //脐部
        childHealthExam.setUmbcordFallValue(getString(ll_umbcordFallCode));
        childHealthExam.setLimbsAbnormCode(getCheckBoxSimpleCode(ll_limbsAbnormCode)); //四肢
        childHealthExam.setLimbsAbnormValue(getString(ll_limbsAbnormCode));
        childHealthExam.setAnusAbnormCode(getCheckBoxSimpleCode(ll_anusAbnormCode)); //肛门/外生殖器
        childHealthExam.setAnusAbnormValue(getString(ll_anusAbnormCode));
        childHealthExam.setHgb(et_hgb.getDouble()); //血红蛋白值
        childHealthExam.setOutdoorActHours(et_outdoorActHours.getDouble()); //户外活动
        childHealthExam.setVitamindDose(et_vitamindDose.getInt()); //服用维生素D
        saveCheckBoxMany(null, childHealthExam.getRecordChoice(), ll_developPassCode);//运动发育评估
        childHealthExam.setSickVisitCode(getCheckBoxSimpleCode(ll_sickVisitCode)); //两次随访患病情况
        childHealthExam.setPneumVisitTimes(et_pneumVisitTimes.getInt());//肺炎次数
        childHealthExam.setDiarrheaVisitTimes(et_diarrheaVisitTimes.getInt());//腹泻次数
        childHealthExam.setTraumaVisitTimes(et_traumaVisitTimes.getInt());//外伤次数
        childHealthExam.setOthersVisitDesc(et_othersVisitDesc.getString());//其他
        childHealthExam.setReferralCode(getCheckBoxSimpleCode(ll_referralCode)); //转诊建议
        childHealthExam.setReferralReason(et_referralReason.getString()); //原因
        childHealthExam.setRefertoOrgName(et_refertoOrgName.getString()); //机构及科室
        saveCheckBoxMany(null, childHealthExam.getRecordChoice(), ll_zhidao); //指导
        childHealthExam.setNextFollowupDate(tv_nextFollowupDate.getDate()); //下次随访日期
        Emp emp = (Emp) sp_followupVisitDoctorName.getSelectedItem(); //随访医生签名
        childHealthExam.setFollowupDoctorId(emp.getEmp_id());
        childHealthExam.setFollowupVisitDoctorName(emp.getEmp_name());

        for (int i = 0; i < childHealthExam.getRecordChoice().size(); i++) {
            if ("UMBILICAL1".equals(childHealthExam.getRecordChoice().get(i).getCodeType()) || "UMBILICAL".equals(childHealthExam.getRecordChoice().get(i).getCodeType())) {
                childHealthExam.getRecordChoice().get(i).setCodeType("umbcordFallCode");
            }

            if ("childComplexionCode1".equals(childHealthExam.getRecordChoice().get(i).getCodeType())) {
                childHealthExam.getRecordChoice().get(i).setCodeType("childComplexionCode");
            }
        }

        for (int i = 0; i < childHealthExam.getRecordChoice().size(); i++) {
            if (childHealthExam.getRecordChoice().get(i).getCodeType().equals("GROWTHEVALUATE03") ||
                    childHealthExam.getRecordChoice().get(i).getCodeType().equals("GROWTHEVALUATE06") ||
                    childHealthExam.getRecordChoice().get(i).getCodeType().equals("GROWTHEVALUATE08")) {
                childHealthExam.getRecordChoice().get(i).setCodeType("developPass");//将check表取的type改为developPass
            }
        }
//        childHealthExam.setIS_APP_CREATE(1);

        return true;
    }

    public void setData(ChildHealthExam childHealthExam) {
        tv_newbornName.setText(childHealthExam.getNewbornName());
    }

    @Override
    protected void initFuData() {

        List<Checks> checkses = sqlHelper.getChecksByType("ONEYEAROLDSTIMES");

        ArrayAdapter adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                checkses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_ageCode.setAdapter(adapter);
        sp_ageCode.setOnItemSelectedListener(this);

        List<Emp> empList = sqlHelper.getDoctors();

        adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_followupVisitDoctorName.setAdapter(adapter);

        initCheckBoxSimple("isJBBK", ll_neckMassCode, false);

        initCheckBoxSimple("WEIGHTINDEX", ll_weightEvalCode, false);
        initCheckBoxSimple("HEIGHTINDEX", ll_heightEvalCode, false);
        initCheckBoxSimple("EXCEPTION_CODE", ll_skinAbnorm, false);
        initCheckBoxSimple("EXCEPTION_CODE", ll_eyeAbnormCode, false);
        initCheckBoxSimple("EXCEPTION_CODE", ll_earAbnormCode, false);
        initCheckBoxSimple("EXCEPTION_CODE", ll_oralAbnormCode, false);
        initCheckBoxSimple("EXCEPTION_CODE", ll_heartAbnormCode, false);
        initCheckBoxSimple("EXCEPTION_CODE", ll_abdomenAbnormCode, false);
        initCheckBoxSimple("EXCEPTION_CODE", ll_limbsAbnormCode, false);
        initCheckBoxSimple("EXCEPTION_CODE", ll_anusAbnormCode, false);
        initCheckBoxSimple("UMBILICAL", ll_umbcordFallCode, false);
        initCheckBoxSimple("SICKENCODE", ll_sickVisitCode, false);
        initCheckBoxMany("GROWTHEVALUATE03", ll_developPassCode, 2, false);
        initCheckBoxSimple("AUDITION_PASS", ll_hearingScreenResultCode, false);
        initCheckBoxSimple("ISBREGMA", ll_bregmaClose, false);//
        initCheckBoxSimple("YES_NO_CODE", ll_referralCode, false);
        initCheckBoxMany("ricketsSymptoms", ll_ricketsSymptomCode, 4, true);
        initCheckBoxMany("childTcmGuide12", ll_zyyjkglfw, 2, true, true);
        initCheckBoxSimple("childComplexionCode", ll_childComplexionCode, false);
        initCheckBoxMany("ricketsSign13", ll_ricketsSignCode, 4, true);
        initCheckBoxMany("oneAgeGuide", ll_zhidao, 3, false, true);
        /**
         * 鸡胸
         * 面色  +1
         * 脐部  +1
         */
    }

    @Override
    protected void initWidget() {

        findView();
        FuTextView fu_title_center = (FuTextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("1~8月龄儿童健康检查记录表");
        fu_title_center.setVisibility(View.VISIBLE);
        FuButton fu_title_right_btn = (FuButton) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    private void findView() {

        tv_newbornName = (FuTextView) mFuView.findViewById(R.id.tv_newbornName); //姓名
        sp_ageCode = (Spinner) mFuView.findViewById(R.id.sp_ageCode); //月龄
        sp_ageCode.setOnItemSelectedListener(FuChildHealthExam02View.this);
        tv_followupVisitDate = (FuTextView) mFuView.findViewById(R.id.tv_followupVisitDate); //随访日期
        tv_followupVisitDate.setOnClickListener(this);
        et_headCircumference = (FuEditText) mFuView.findViewById(R.id.et_headCircumference); //头围
        zyyjkglfw = (LinearLayout) mFuView.findViewById(R.id.zyyjkglfw); //中医药健康管理服务容器
        ll_zyyjkglfw = (LinearLayout) mFuView.findViewById(R.id.ll_zyyjkglfw); //中医药健康管理服务
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight); //体重
        ll_weightEvalCode = (LinearLayout) mFuView.findViewById(R.id.ll_weightEvalCode); //体重
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height); //身长
        ll_heightEvalCode = (LinearLayout) mFuView.findViewById(R.id.ll_heightEvalCode); //身长
        ll_childComplexionCode = (LinearLayout) mFuView.findViewById(R.id.ll_childComplexionCode); //面色
        ll_skinAbnorm = (LinearLayout) mFuView.findViewById(R.id.ll_skinAbnorm); //皮肤
        ll_bregmaClose = (LinearLayout) mFuView.findViewById(R.id.ll_bregmaClose); //前囟
        et_bregmaHorizDiameter = (FuEditText) mFuView.findViewById(R.id.et_bregmaHorizDiameter); //前囟
        et_bregmaVertDiameter = (FuEditText) mFuView.findViewById(R.id.et_bregmaVertDiameter); //前囟
        neckMassCode = (LinearLayout) mFuView.findViewById(R.id.neckMassCode); //颈部包块
        ll_neckMassCode = (LinearLayout) mFuView.findViewById(R.id.ll_neckMassCode); //颈部包块
        ll_eyeAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_eyeAbnormCode); //眼外观
        ll_earAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_earAbnormCode); //耳朵
        hearingScreenResultCode = (LinearLayout) mFuView.findViewById(R.id.hearingScreenResultCode); //听力容器
        ll_hearingScreenResultCode = (LinearLayout) mFuView.findViewById(R.id.ll_hearingScreenResultCode); //听力
        oralAbnormCode = (LinearLayout) mFuView.findViewById(R.id.oralAbnormCode); //口腔容器
        ll_oralAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_oralAbnormCode); //口腔
        teethCount = (LinearLayout) mFuView.findViewById(R.id.teethCount); //出牙数容器
        et_teethCount = (FuEditText) mFuView.findViewById(R.id.et_teethCount); //口腔/出牙数
        ll_heartAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_heartAbnormCode); //心肺
        ll_abdomenAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_abdomenAbnormCode); //腹部
        umbcordFallCode = (LinearLayout) mFuView.findViewById(R.id.umbcordFallCode); //脐部容器
        ll_umbcordFallCode = (LinearLayout) mFuView.findViewById(R.id.ll_umbcordFallCode); //脐部
        ll_limbsAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_limbsAbnormCode); //四肢
        ricketsSymptomCode = (LinearLayout) mFuView.findViewById(R.id.ricketsSymptomCode); //可疑佝偻病症状容器
        ricketsSignCode = (LinearLayout) mFuView.findViewById(R.id.ricketsSignCode); //可疑佝偻病体征容器
        ll_ricketsSymptomCode = (LinearLayout) mFuView.findViewById(R.id.ll_ricketsSymptomCode); //可疑佝偻病症状
        ll_ricketsSignCode = (LinearLayout) mFuView.findViewById(R.id.ll_ricketsSignCode); //可疑佝偻病体征
        ll_anusAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_anusAbnormCode); //肛门/外生殖器
        hgb = (LinearLayout) mFuView.findViewById(R.id.hgb); ///血红蛋白值容器
        et_hgb = (FuEditText) mFuView.findViewById(R.id.et_hgb); ///血红蛋白值
        et_outdoorActHours = (FuEditText) mFuView.findViewById(R.id.et_outdoorActHours); //户外活动
        et_vitamindDose = (FuEditText) mFuView.findViewById(R.id.et_vitamindDose); //服用维生素D
        developPassCode = (LinearLayout) mFuView.findViewById(R.id.developPassCode); //运动发育评估容器
        ll_developPassCode = (LinearLayout) mFuView.findViewById(R.id.ll_developPassCode); //运动发育评估
        ll_sickVisitCode = (LinearLayout) mFuView.findViewById(R.id.ll_sickVisitCode); //两次随访患病情况
        ll_referralCode = (LinearLayout) mFuView.findViewById(R.id.ll_referralCode); //转诊建议
        et_pneumVisitTimes = (FuEditText) mFuView.findViewById(R.id.et_pneumVisitTimes); //肺炎次数
        et_diarrheaVisitTimes = (FuEditText) mFuView.findViewById(R.id.et_diarrheaVisitTimes); //肺炎次数
        et_othersVisitDesc = (FuEditText) mFuView.findViewById(R.id.et_othersVisitDesc); //其他
        et_traumaVisitTimes = (FuEditText) mFuView.findViewById(R.id.et_traumaVisitTimes); //外伤次数
        et_referralReason = (FuEditText) mFuView.findViewById(R.id.et_referralReason); //原因
        et_refertoOrgName = (FuEditText) mFuView.findViewById(R.id.et_refertoOrgName); //机构及科室
        ll_zhidao = (LinearLayout) mFuView.findViewById(R.id.ll_zhidao); //指导
        tv_nextFollowupDate = (FuTextView) mFuView.findViewById(R.id.tv_nextFollowupDate); //下次随访日期
        tv_nextFollowupDate.setOnClickListener(this);
        sp_followupVisitDoctorName = (Spinner) mFuView.findViewById(R.id.sp_followupVisitDoctorName); //随访医生签名

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        setViewGone(position);
    }

    public void setViewGone(int i) {
        if (i == 0) {
            //1月
            zyyjkglfw.setVisibility(View.GONE);//中医药
            hearingScreenResultCode.setVisibility(View.GONE);//听力
            ricketsSymptomCode.setVisibility(View.GONE);//可疑佝偻病症状
            ricketsSignCode.setVisibility(View.GONE);//可疑佝偻病体征
            hgb.setVisibility(View.GONE);//血红蛋白
            oralAbnormCode.setVisibility(View.VISIBLE);
            teethCount.setVisibility(View.GONE);
            umbcordFallCode.setVisibility(View.VISIBLE);
            neckMassCode.setVisibility(View.VISIBLE);
            developPassCode.setVisibility(View.GONE);//运动发育评估
//            ll_ricketsSignCode.removeAllViews();
//            initCheckBoxMany("ricketsSign13", ll_ricketsSignCode, 4, true);//第三版规范满月龄已去除体征

            ll_childComplexionCode.removeAllViews();
            initCheckBoxSimple("childComplexionCode", ll_childComplexionCode, 3, true);
            ll_umbcordFallCode.setVisibility(View.VISIBLE);
            ll_umbcordFallCode.removeAllViews();
            initCheckBoxSimple("UMBILICAL", ll_umbcordFallCode, false);
        } else if (i == 1) {
            //3月
            zyyjkglfw.setVisibility(View.GONE);//中医药
            hearingScreenResultCode.setVisibility(View.GONE);//听力
            hgb.setVisibility(View.GONE);//血红蛋白
            oralAbnormCode.setVisibility(View.VISIBLE);
            teethCount.setVisibility(View.GONE);
            umbcordFallCode.setVisibility(View.VISIBLE);
            ricketsSymptomCode.setVisibility(View.VISIBLE);
            ricketsSignCode.setVisibility(View.VISIBLE);
            neckMassCode.setVisibility(View.VISIBLE);
            developPassCode.setVisibility(View.VISIBLE);//运动发育评估

            ll_developPassCode.removeAllViews();
            initCheckBoxMany("GROWTHEVALUATE03", ll_developPassCode, 2, false);

            ll_ricketsSignCode.removeAllViews();
            initCheckBoxMany("ricketsSign13", ll_ricketsSignCode, 2, true);

            ll_childComplexionCode.removeAllViews();
            initCheckBoxSimple("childComplexionCode", ll_childComplexionCode, 3, true);

            ll_umbcordFallCode.setVisibility(View.VISIBLE);
            ll_umbcordFallCode.removeAllViews();
            initCheckBoxSimple("UMBILICAL1", ll_umbcordFallCode, false);
        } else if (i == 2) {
            //6月
            umbcordFallCode.setVisibility(View.GONE);//脐部
            zyyjkglfw.setVisibility(View.VISIBLE);
            hearingScreenResultCode.setVisibility(View.VISIBLE);
            ricketsSymptomCode.setVisibility(View.VISIBLE);
            ricketsSignCode.setVisibility(View.VISIBLE);
            oralAbnormCode.setVisibility(View.GONE);
            teethCount.setVisibility(View.VISIBLE);
            hgb.setVisibility(View.VISIBLE);
            neckMassCode.setVisibility(View.VISIBLE);
            developPassCode.setVisibility(View.VISIBLE);//运动发育评估

            ll_developPassCode.removeAllViews();
            initCheckBoxMany("GROWTHEVALUATE06", ll_developPassCode, 2, false);

            ll_ricketsSignCode.removeAllViews();
            initCheckBoxMany("ricketsSign68", ll_ricketsSignCode, 4, true);

            ll_childComplexionCode.removeAllViews();
            initCheckBoxSimple("childComplexionCode1", ll_childComplexionCode, 3, true);

            ll_umbcordFallCode.setVisibility(View.GONE);

        } else if (i == 3) {
            //8月
            zyyjkglfw.setVisibility(View.GONE);//中医药
            neckMassCode.setVisibility(View.GONE);//颈部包块
            hearingScreenResultCode.setVisibility(View.GONE);//听力
            umbcordFallCode.setVisibility(View.GONE);//脐部
            oralAbnormCode.setVisibility(View.GONE);
            teethCount.setVisibility(View.VISIBLE);
            hgb.setVisibility(View.VISIBLE);
            ricketsSymptomCode.setVisibility(View.VISIBLE);
            ricketsSignCode.setVisibility(View.VISIBLE);
            ll_ricketsSignCode.removeAllViews();
            initCheckBoxMany("ricketsSign68", ll_ricketsSignCode, 4, true);
            developPassCode.setVisibility(View.VISIBLE);//运动发育评估

            ll_developPassCode.removeAllViews();
            initCheckBoxMany("GROWTHEVALUATE08", ll_developPassCode, 2, false);

            ll_childComplexionCode.removeAllViews();
            initCheckBoxSimple("childComplexionCode1", ll_childComplexionCode, 3, true);

            ll_umbcordFallCode.setVisibility(View.GONE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
