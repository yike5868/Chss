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
import net.greatsoft.main.db.po.child.ChildHealthExam;
import net.greatsoft.main.fragment.FuChildHealthExam03Fragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/12.
 */

public class FuChildHealthExam03View extends FuUiFrameModel implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    FuTextView tv_newbornName; //姓名
    Spinner sp_ageCode; //月龄
    FuTextView tv_followupVisitDate; //随访日期
    LinearLayout ll_zyyjkglfw; //中医药健康管理服务
    FuEditText et_weight; //体重
    LinearLayout ll_weightEvalCode; //体重
    FuEditText et_height; //身长
    LinearLayout ll_heightEvalCode; //身长
    LinearLayout ll_childComplexionCode; //面色
    LinearLayout ll_skinAbnorm; //皮肤
    LinearLayout bregmaClose; //前囟容器
    LinearLayout ll_bregmaClose; //前囟
    FuEditText et_bregmaHorizDiameter; //前囟
    FuEditText et_bregmaVertDiameter; //前囟
    LinearLayout ll_eyeAbnormCode; //眼外观
    LinearLayout ll_earAbnormCode; //耳朵
    LinearLayout hearingScreenResultCode; //听力容器
    LinearLayout ll_hearingScreenResultCode; //听力
    LinearLayout ll_heartAbnormCode; //胸部
    LinearLayout ll_abdomenAbnormCode; //腹部
    LinearLayout ll_limbsAbnormCode; //四肢
    LinearLayout gaitAbnormCode; //步态容器
    LinearLayout ll_gaitAbnormCode; //步态
    LinearLayout ricketsSignCode; //可疑佝偻病体征容器
    LinearLayout ll_ricketsSignCode; //可疑佝偻病体征
    LinearLayout hgb; //血红蛋白值容器
    FuEditText et_hgb; //血红蛋白值
    LinearLayout chuyashu; //出牙数容器f
    FuEditText et_teethCount; //出牙数
    FuEditText et_cariesCount; //龋齿数
    FuEditText et_outdoorActHours; //户外活动
    FuEditText et_vitamindDose; //服用维生素D
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

    int j = 0;

    public FuChildHealthExam03View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuChildHealthExam03Fragment.EVENT_SAVE_HEALTH, null);
                break;
            case R.id.tv_nextFollowupDate:
                ((FuParentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_followupVisitDate:
                ((FuParentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
        }
    }

    public void setData(ChildHealthExam childHealthExam) {
        tv_newbornName.setText(childHealthExam.getNewbornName());
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_child_health_exam_03, null);
    }


    public boolean saveData(ChildHealthExam childHealthExam) {

//         tv_newbornName; //姓名
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
        if (j != 3) {
            if ("2".equals(getCheckBoxSimpleCode(ll_bregmaClose))) {
                if ("".equals(et_bregmaHorizDiameter.getString()) || "".equals(et_bregmaVertDiameter.getString())) {
                    ToastUtil.showToast(mContext, "请填选前囟", Toast.LENGTH_LONG);
                    return false;
                }
            }
        }
        if (j == 0) {
            if ("".equals(et_teethCount.getString()) || "".equals(et_cariesCount.getString())) {
                ToastUtil.showToast(mContext, "请填选出牙数/龋齿数", Toast.LENGTH_LONG);
                return false;
            }
        }
        if (j == 1 || j == 3) {
            if ("".equals(et_hgb.getString())) {
                ToastUtil.showToast(mContext, "请填写血红蛋白", Toast.LENGTH_LONG);
                return false;
            }
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
        childHealthExam.setVisitType(3);
        childHealthExam.setFollowupVisitDate(tv_followupVisitDate.getDate()); //随访日期
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
        childHealthExam.setEyeAbnormCode(getCheckBoxSimpleCode(ll_eyeAbnormCode)); //眼外观
        childHealthExam.setEyeAbnormValue(getString(ll_eyeAbnormCode));
        childHealthExam.setEarAbnormCode(getCheckBoxSimpleCode(ll_earAbnormCode)); //耳朵
        childHealthExam.setEarAbnormValue(getString(ll_earAbnormCode));
        childHealthExam.setHearingScreenResultCode(getCheckBoxSimpleCode(ll_hearingScreenResultCode)); //听力
        childHealthExam.setHeartAbnormCode(getCheckBoxSimpleCode(ll_heartAbnormCode)); //心肺
        childHealthExam.setHeartAbnormValue(getString(ll_heartAbnormCode));
        childHealthExam.setAbdomenAbnormCode(getCheckBoxSimpleCode(ll_abdomenAbnormCode)); //腹部
        childHealthExam.setAbdomenAbnormValue(getRadioString(ll_abdomenAbnormCode));
        childHealthExam.setLimbsAbnormCode(getCheckBoxSimpleCode(ll_limbsAbnormCode)); //四肢
        childHealthExam.setGaitAbnormCode(getCheckBoxSimpleCode(ll_gaitAbnormCode)); //步态
        childHealthExam.setGaitAbnormValue(getString(ll_gaitAbnormCode));
        saveCheckBoxMany(null, childHealthExam.getRecordChoice(), ll_ricketsSignCode); //可疑佝偻病体征
        childHealthExam.setHgb(et_hgb.getDouble()); //血红蛋白值
        childHealthExam.setTeethCount(et_teethCount.getInt()); //出牙数
        childHealthExam.setCariesCount(et_cariesCount.getInt()); //龋齿数
        childHealthExam.setOutdoorActHours(et_outdoorActHours.getDouble()); //户外活动
        childHealthExam.setVitamindName(et_vitamindDose.getString()); //服用维生素D
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
            if (childHealthExam.getRecordChoice().get(i).getCodeType().equals("GROWTHEVALUATE12") ||
                    childHealthExam.getRecordChoice().get(i).getCodeType().equals("GROWTHEVALUATE18") ||
                    childHealthExam.getRecordChoice().get(i).getCodeType().equals("GROWTHEVALUATE24") ||
                    childHealthExam.getRecordChoice().get(i).getCodeType().equals("GROWTHEVALUATE30")) {
                childHealthExam.getRecordChoice().get(i).setCodeType("developPass");//将check表取的type改为developPass
            }
        }

        return true;
    }

    @Override
    protected void initFuData() {

        List<Checks> checkses = sqlHelper.getChecksByType("ONETWOYEAROLDSTIMES");

        ArrayAdapter adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                checkses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_ageCode.setAdapter(adapter);
        sp_ageCode
                .setOnItemSelectedListener(this);

        List<Emp> empList = sqlHelper.getDoctors();

        adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_followupVisitDoctorName.setAdapter(adapter);


        initCheckBoxMany("childTcmGuide12", ll_zyyjkglfw, 2, true, true); //中医药管理
        initCheckBoxSimple("WEIGHTINDEX", ll_weightEvalCode, false); //体重
        initCheckBoxSimple("HEIGHTINDEX", ll_heightEvalCode, false); //身长
        initCheckBoxSimple("COMPLEXION12", ll_childComplexionCode, false); //面色
        initCheckBoxSimple("EXCEPTION_CODE", ll_skinAbnorm, false);//皮肤
        initCheckBoxSimple("ISBREGMA", ll_bregmaClose, false);//前囟
        initCheckBoxSimple("EXCEPTION_CODE", ll_eyeAbnormCode, false);//眼外观
        initCheckBoxSimple("EXCEPTION_CODE", ll_earAbnormCode, false);//耳朵
        initCheckBoxSimple("AUDITION_PASS", ll_hearingScreenResultCode, false);//听力
        initCheckBoxSimple("EXCEPTION_CODE", ll_heartAbnormCode, false);
        initCheckBoxSimple("EXCEPTION_CODE", ll_abdomenAbnormCode, false);//腹部
        initCheckBoxSimple("EXCEPTION_CODE", ll_limbsAbnormCode, false);//四肢
        initCheckBoxSimple("EXCEPTION_CODE", ll_gaitAbnormCode, false);//步态
        initCheckBoxMany("ricketsSign1224", ll_ricketsSignCode, 3, false);//可疑佝偻病体征
        initCheckBoxSimple("SICKENCODE", ll_sickVisitCode, false);//两次随访患病情况
        initCheckBoxMany("GROWTHEVALUATE12", ll_developPassCode, 2, false);
        initCheckBoxSimple("YES_NO_CODE", ll_referralCode, false);//转诊建议
        initCheckBoxMany("oneAgeGuide", ll_zhidao, 3, false);//指导

    }

    @Override
    protected void initWidget() {

        findView();
        FuTextView fu_title_center = (FuTextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("12~30月龄儿童健康检查记录表");
        fu_title_center.setVisibility(View.VISIBLE);
        FuButton fu_title_right_btn = (FuButton) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);
    }

    private void findView() {

        tv_newbornName = (FuTextView) mFuView.findViewById(R.id.tv_newbornName); //姓名
        sp_ageCode = (Spinner) mFuView.findViewById(R.id.sp_ageCode); //月龄
        sp_ageCode.setOnItemSelectedListener(this);
        tv_followupVisitDate = (FuTextView) mFuView.findViewById(R.id.tv_followupVisitDate); //随访日期
        tv_followupVisitDate.setOnClickListener(this);
        ll_zyyjkglfw = (LinearLayout) mFuView.findViewById(R.id.ll_zyyjkglfw); //中医药健康管理服务
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight); //体重
        ll_weightEvalCode = (LinearLayout) mFuView.findViewById(R.id.ll_weightEvalCode); //体重
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height); //身长
        ll_heightEvalCode = (LinearLayout) mFuView.findViewById(R.id.ll_heightEvalCode); //身长
        ll_childComplexionCode = (LinearLayout) mFuView.findViewById(R.id.ll_childComplexionCode); //面色
        ll_skinAbnorm = (LinearLayout) mFuView.findViewById(R.id.ll_skinAbnorm); //皮肤
        bregmaClose = (LinearLayout) mFuView.findViewById(R.id.bregmaClose); //前囟容器
        ll_bregmaClose = (LinearLayout) mFuView.findViewById(R.id.ll_bregmaClose); //前囟
        et_bregmaHorizDiameter = (FuEditText) mFuView.findViewById(R.id.et_bregmaHorizDiameter); //前囟
        et_bregmaVertDiameter = (FuEditText) mFuView.findViewById(R.id.et_bregmaVertDiameter); //前囟
        ll_eyeAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_eyeAbnormCode); //眼外观
        ll_earAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_earAbnormCode); //耳朵
        hearingScreenResultCode = (LinearLayout) mFuView.findViewById(R.id.hearingScreenResultCode); //听力容器
        ll_hearingScreenResultCode = (LinearLayout) mFuView.findViewById(R.id.ll_hearingScreenResultCode); //听力
        ll_heartAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_heartAbnormCode); //心肺
        ll_abdomenAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_abdomenAbnormCode); //腹部
        ll_limbsAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_limbsAbnormCode); //四肢
        ricketsSignCode = (LinearLayout) mFuView.findViewById(R.id.ricketsSignCode); //可疑佝偻病体征容器
        ll_ricketsSignCode = (LinearLayout) mFuView.findViewById(R.id.ll_ricketsSignCode); //可疑佝偻病体征
        gaitAbnormCode = (LinearLayout) mFuView.findViewById(R.id.gaitAbnormCode); //步态容器
        ll_gaitAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_gaitAbnormCode); //步态
        hgb = (LinearLayout) mFuView.findViewById(R.id.hgb); ///血红蛋白值
        et_hgb = (FuEditText) mFuView.findViewById(R.id.et_hgb); ///血红蛋白值
        chuyashu = (LinearLayout) mFuView.findViewById(R.id.chuyashu); ///出牙数容器
        et_teethCount = (FuEditText) mFuView.findViewById(R.id.et_teethCount); ///出牙数
        et_cariesCount = (FuEditText) mFuView.findViewById(R.id.et_cariesCount); ///龋齿数
        et_outdoorActHours = (FuEditText) mFuView.findViewById(R.id.et_outdoorActHours); //户外活动
        et_vitamindDose = (FuEditText) mFuView.findViewById(R.id.et_vitamindDose); //服用维生素D
        ll_developPassCode = (LinearLayout) mFuView.findViewById(R.id.ll_developPassCode); //运动发育评估
        ll_sickVisitCode = (LinearLayout) mFuView.findViewById(R.id.ll_sickVisitCode); //两次随访患病情况
        et_pneumVisitTimes = (FuEditText) mFuView.findViewById(R.id.et_pneumVisitTimes); //肺炎次数
        et_diarrheaVisitTimes = (FuEditText) mFuView.findViewById(R.id.et_diarrheaVisitTimes); //肺炎次数
        et_othersVisitDesc = (FuEditText) mFuView.findViewById(R.id.et_othersVisitDesc); //其他
        et_traumaVisitTimes = (FuEditText) mFuView.findViewById(R.id.et_traumaVisitTimes); //外伤次数
        ll_referralCode = (LinearLayout) mFuView.findViewById(R.id.ll_referralCode); //转诊建议
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
        setViewGone1(position);
    }

    public void setViewGone(int i) {
        j = i;
        if (i == 0) {
            chuyashu.setVisibility(View.VISIBLE);//出牙数容器
            gaitAbnormCode.setVisibility(View.GONE);//步态容器
            hgb.setVisibility(View.GONE);//血红蛋白值
            hearingScreenResultCode.setVisibility(View.VISIBLE);//听力
            bregmaClose.setVisibility(View.VISIBLE);//前
            ricketsSignCode.setVisibility(View.VISIBLE);//可以佝偻病体征
            ll_developPassCode.removeAllViews();
            initCheckBoxMany("GROWTHEVALUATE12", ll_developPassCode, 2, false);
        } else if (i == 1) {
            chuyashu.setVisibility(View.GONE);//出牙数容器
            gaitAbnormCode.setVisibility(View.VISIBLE);
            hgb.setVisibility(View.VISIBLE);//血红蛋白值
            hearingScreenResultCode.setVisibility(View.GONE);//听力
            bregmaClose.setVisibility(View.VISIBLE);//前
            ricketsSignCode.setVisibility(View.VISIBLE);//可以佝偻病体征
            ll_developPassCode.removeAllViews();
            initCheckBoxMany("GROWTHEVALUATE18", ll_developPassCode, 2, false);
        } else if (i == 2) {//
            chuyashu.setVisibility(View.GONE);//出牙数容器
            gaitAbnormCode.setVisibility(View.VISIBLE);
            hgb.setVisibility(View.GONE);//血红蛋白值
            hearingScreenResultCode.setVisibility(View.VISIBLE);//听力
            bregmaClose.setVisibility(View.VISIBLE);//前
            ricketsSignCode.setVisibility(View.VISIBLE);//可以佝偻病体征
            ll_developPassCode.removeAllViews();
            initCheckBoxMany("GROWTHEVALUATE24", ll_developPassCode, 2, false);
        } else if (i == 3) {//
            chuyashu.setVisibility(View.GONE);//出牙数容器
            gaitAbnormCode.setVisibility(View.VISIBLE);
            hgb.setVisibility(View.VISIBLE);//血红蛋白值
            hearingScreenResultCode.setVisibility(View.GONE);//听力
            bregmaClose.setVisibility(View.GONE);//前
            ricketsSignCode.setVisibility(View.GONE);//可以佝偻病体征
            ll_developPassCode.removeAllViews();
            initCheckBoxMany("GROWTHEVALUATE30", ll_developPassCode, 2, false);
        }
    }

    public void setViewGone1(int i) {
        switch (i) {
            case 0:

                ll_zhidao.removeAllViews();
                initCheckBoxMany("oneAgeGuide", ll_zhidao, 3, false);//指导

                ll_zyyjkglfw.removeAllViews();
                initCheckBoxMany("childTcmGuide12", ll_zyyjkglfw, 2, true, true); //中医药管理

                break;
            case 1:

                ll_zhidao.removeAllViews();
                initCheckBoxMany("oneAgeGuide", ll_zhidao, 3, false);//指导

                ll_zyyjkglfw.removeAllViews();
                initCheckBoxMany("childTcmGuide24", ll_zyyjkglfw, 2, true, true); //中医药管理

                break;
            case 2:

                ll_zhidao.removeAllViews();
                initCheckBoxMany("childGuideAfter18", ll_zhidao, 3, false);//指导

                ll_zyyjkglfw.removeAllViews();
                initCheckBoxMany("childTcmGuide24", ll_zyyjkglfw, 2, true, true); //中医药管理

                break;
            case 3:
                ll_zhidao.removeAllViews();
                initCheckBoxMany("childGuideAfter18", ll_zhidao, 3, false);//指导

                ll_zyyjkglfw.removeAllViews();
                initCheckBoxMany("childTcmGuide36", ll_zyyjkglfw, 2, true, true); //中医药管理

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
