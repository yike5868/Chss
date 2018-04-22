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
import net.greatsoft.main.fragment.FuChildHealthExam04Fragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/12.
 */

public class FuChildHealthExam04View extends FuUiFrameModel implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    FuTextView tv_newbornName; //姓名
    Spinner sp_ageCode; //月龄
    FuTextView tv_followupVisitDate; //随访日期
    LinearLayout ll_zyyjkglfw; //中医药健康管理服务
    FuEditText et_weight; //体重
    LinearLayout ll_weightEvalCode; //体重
    FuEditText et_height; //身长
    LinearLayout ll_heightEvalCode; //身长
    LinearLayout ll_physicalDevelopEvalCode; //体格发育评价
    FuEditText et_vitamindName; //视力
    LinearLayout ll_hearingScreenResultCode; //听力
    LinearLayout ll_heartAbnormCode; //心肺
    LinearLayout ll_abdomenAbnormCode; //腹部
    FuEditText et_hgb; //血红蛋白值
    FuEditText et_teethCount; //出牙数
    FuEditText et_cariesCount; //龋齿数
    LinearLayout ll_developPassCode; //运动发育评估
    LinearLayout ll_sickVisitCode; //两次随访患病情况
    LinearLayout ll_referralCode; //转诊建议
    FuEditText et_pneumVisitTimes; //肺炎次数
    FuEditText et_diarrheaVisitTimes; //腹泻次数
    FuEditText et_traumaVisitTimes; //外伤次数
    FuEditText et_othersVisitDesc; //其他
    FuEditText et_referralReason; //原因
    FuEditText et_refertoOrgName; //机构及科室
    LinearLayout ll_zhidao; //指导
    FuTextView tv_nextFollowupDate; //下次随访日期
    Spinner sp_followupVisitDoctorName; //随访医生签名

    LinearLayout ll_vitamindMain;//视力

    LinearLayout ll_ll_hearingMain;//听力

    LinearLayout ll_zyMain;//中医药

    public FuChildHealthExam04View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuChildHealthExam04Fragment.EVENT_SAVE_HEALTH, null);
                break;
            case R.id.tv_followupVisitDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_nextFollowupDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
        }
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_child_health_exam_04, null);
    }

    public void setData(ChildHealthExam childHealthExam) {
        tv_newbornName.setText(childHealthExam.getNewbornName());
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

        if ("".equals(tv_nextFollowupDate.getText().toString())) {
            ToastUtil.showToast(mContext, "请选择下次随访日期", Toast.LENGTH_LONG);
            return false;
        }
//         tv_newbornName; //姓名
        Checks checks = (Checks) sp_ageCode.getSelectedItem();
        childHealthExam.setAgeCode(checks.getCode());
        childHealthExam.setVisitType(4);
        childHealthExam.setFollowupVisitDate(tv_followupVisitDate.getDate()); //随访日期
        saveCheckBoxMany(null, childHealthExam.getRecordChoice(), ll_zyyjkglfw); //中医药健康管理服务
        childHealthExam.setWeight(et_weight.getDouble()); //体重
        childHealthExam.setWeightEvalCode(getCheckBoxSimpleCode(ll_weightEvalCode)); //体重
        childHealthExam.setHeight(et_height.getDouble()); //身长
        childHealthExam.setHeightEvalCode(getCheckBoxSimpleCode(ll_heightEvalCode)); //身长
        childHealthExam.setPhysicalDevelopEvalCode(getCheckBoxSimpleCode(ll_physicalDevelopEvalCode));//体格
        childHealthExam.setVitamindName(et_vitamindName.getString());//视力
        childHealthExam.setHearingScreenResultCode(getCheckBoxSimpleCode(ll_hearingScreenResultCode)); //听力
        childHealthExam.setHeartAbnormCode(getCheckBoxSimpleCode(ll_heartAbnormCode));//心肺
        childHealthExam.setHeartAbnormValue(getString(ll_heartAbnormCode));
        childHealthExam.setAbdomenAbnormCode(getCheckBoxSimpleCode(ll_abdomenAbnormCode)); //腹部
        childHealthExam.setAbdomenAbnormValue(getRadioString(ll_abdomenAbnormCode));
        childHealthExam.setHgb(et_hgb.getDouble()); //血红蛋白值
        childHealthExam.setTeethCount(et_teethCount.getInt()); //出牙数
        childHealthExam.setCariesCount(et_cariesCount.getInt()); //龋齿数
        saveCheckBoxMany(null, childHealthExam.getRecordChoice(), ll_developPassCode);//运动发育评估
        childHealthExam.setSickVisitCode(getCheckBoxSimpleCode(ll_sickVisitCode)); //两次随访患病情况
        childHealthExam.setReferralCode(getCheckBoxSimpleCode(ll_referralCode)); //转诊建议
        childHealthExam.setPneumVisitTimes(et_pneumVisitTimes.getInt());//肺炎次数
        childHealthExam.setDiarrheaVisitTimes(et_diarrheaVisitTimes.getInt());//腹泻次数
        childHealthExam.setTraumaVisitTimes(et_traumaVisitTimes.getInt());//外伤次数
        childHealthExam.setOthersVisitDesc(et_othersVisitDesc.getString());//其他
        childHealthExam.setReferralReason(et_referralReason.getString()); //原因
        childHealthExam.setRefertoOrgName(et_refertoOrgName.getString()); //机构及科室
        saveCheckBoxMany(null, childHealthExam.getRecordChoice(), ll_zhidao); //指导
        childHealthExam.setNextFollowupDate(tv_nextFollowupDate.getDate()); //下次随访日期
        Emp emp = (Emp) sp_followupVisitDoctorName.getSelectedItem(); //随访医生签名
        childHealthExam.setFollowupDoctorId(emp.getEmp_id());
        childHealthExam.setFollowupVisitDoctorName(emp.getEmp_name());

        for (int i = 0; i < childHealthExam.getRecordChoice().size(); i++) {
            if (childHealthExam.getRecordChoice().get(i).getCodeType().equals("GROWTHEVALUATE3") ||
                    childHealthExam.getRecordChoice().get(i).getCodeType().equals("GROWTHEVALUATE4") ||
                    childHealthExam.getRecordChoice().get(i).getCodeType().equals("GROWTHEVALUATE5") ||
                    childHealthExam.getRecordChoice().get(i).getCodeType().equals("GROWTHEVALUATE6")) {
                childHealthExam.getRecordChoice().get(i).setCodeType("developPass");//将check表取的type改为developPass
            }
        }

        return true;
    }

    @Override
    protected void initFuData() {
        List<Checks> checkses = sqlHelper.getChecksByType("AFTERTHREEOLDS");

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
        // 初使化复选框、单选框
        initCheckBoxMany("childTcmGuide36", ll_zyyjkglfw, 2, true, true); //中医药健康管理
        initCheckBoxSimple("AUDITION_PASS", ll_hearingScreenResultCode, false); //听力
        initCheckBoxSimple("BODYEVALUATE", ll_physicalDevelopEvalCode, 4, true); //体格发育评价
        initCheckBoxSimple("EXCEPTION_CODE", ll_heartAbnormCode, false); //心肺
        initCheckBoxSimple("EXCEPTION_CODE", ll_abdomenAbnormCode, false); //腹部
        initCheckBoxMany("GROWTHEVALUATE3", ll_developPassCode, 2, false);
        initCheckBoxSimple("SICKENCODE", ll_sickVisitCode, false); //两次随访患病
        initCheckBoxSimple("HEIGHTINDEX", ll_heightEvalCode, false); //身长
        initCheckBoxSimple("WEIGHTINDEX", ll_weightEvalCode, false); //体重
        initCheckBoxSimple("YES_NO_CODE", ll_referralCode, false); //转诊
        initCheckBoxMany("childGuideAfter18", ll_zhidao, 3, false); //指导

    }

    @Override
    protected void initWidget() {

        findView();
        FuTextView fu_title_center = (FuTextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("3~6岁龄儿童健康检查记录表");
        fu_title_center.setVisibility(View.VISIBLE);
        FuButton fu_title_right_btn = (FuButton) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);
    }

    private void findView() {

        tv_newbornName = (FuTextView) mFuView.findViewById(R.id.tv_newbornName); //姓名
        sp_ageCode = (Spinner) mFuView.findViewById(R.id.sp_ageCode); //月龄
        tv_followupVisitDate = (FuTextView) mFuView.findViewById(R.id.tv_followupVisitDate); //随访日期
        tv_followupVisitDate.setOnClickListener(this);
        ll_zyyjkglfw = (LinearLayout) mFuView.findViewById(R.id.ll_zyyjkglfw); //中医药健康管理服务
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight); //体重
        ll_weightEvalCode = (LinearLayout) mFuView.findViewById(R.id.ll_weightEvalCode); //体重
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height); //身长
        ll_heightEvalCode = (LinearLayout) mFuView.findViewById(R.id.ll_heightEvalCode); //身长
        ll_physicalDevelopEvalCode = (LinearLayout) mFuView.findViewById(R.id.ll_physicalDevelopEvalCode); //身长
        et_vitamindName = (FuEditText) mFuView.findViewById(R.id.et_vitamindName); //视力
        ll_hearingScreenResultCode = (LinearLayout) mFuView.findViewById(R.id.ll_hearingScreenResultCode); //听力
        ll_heartAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_heartAbnormCode); //心肺
        ll_abdomenAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_abdomenAbnormCode); //腹部
        et_hgb = (FuEditText) mFuView.findViewById(R.id.et_hgb); ///血红蛋白值
        et_teethCount = (FuEditText) mFuView.findViewById(R.id.et_teethCount); ///出牙数
        et_cariesCount = (FuEditText) mFuView.findViewById(R.id.et_cariesCount); ///龋齿数
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
        ll_vitamindMain = (LinearLayout) mFuView.findViewById(R.id.ll_vitamindMain);//视力

        ll_ll_hearingMain = (LinearLayout) mFuView.findViewById(R.id.ll_ll_hearingMain);//听力
        ll_zyMain = (LinearLayout) mFuView.findViewById(R.id.ll_zyMain);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        setViewGone(position);
    }

    public void setViewGone(int i) {
        switch (i) {
            case 0:
                ll_ll_hearingMain.setVisibility(View.VISIBLE);
                ll_vitamindMain.setVisibility(View.GONE);
                ll_zyMain.setVisibility(View.VISIBLE);
                ll_developPassCode.removeAllViews();
                initCheckBoxMany("GROWTHEVALUATE3", ll_developPassCode, 2, false);
                break;
            case 1:
                ll_ll_hearingMain.setVisibility(View.GONE);
                ll_vitamindMain.setVisibility(View.VISIBLE);
                ll_zyMain.setVisibility(View.GONE);
                ll_developPassCode.removeAllViews();
                initCheckBoxMany("GROWTHEVALUATE4", ll_developPassCode, 2, false);
                break;
            case 2:
                ll_ll_hearingMain.setVisibility(View.GONE);
                ll_vitamindMain.setVisibility(View.VISIBLE);
                ll_zyMain.setVisibility(View.GONE);
                ll_developPassCode.removeAllViews();
                initCheckBoxMany("GROWTHEVALUATE5", ll_developPassCode, 2, false);
                break;
            case 3:
                ll_ll_hearingMain.setVisibility(View.GONE);
                ll_vitamindMain.setVisibility(View.VISIBLE);
                ll_zyMain.setVisibility(View.GONE);
                ll_developPassCode.removeAllViews();
                initCheckBoxMany("GROWTHEVALUATE6", ll_developPassCode, 2, false);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
