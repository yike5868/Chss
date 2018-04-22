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
import net.greatsoft.main.db.po.maternal.MaternalFollowup;
import net.greatsoft.main.fragment.FuMaternalFollowupFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/15.
 * 2-5次产前随访
 */

public class FuMaternalFollowupView extends FuUiFrameModel implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    FuTextView tv_name; //姓名
    Spinner sp_count; //产前随访
    FuTextView tv_followupDate; //随访日期
    FuEditText et_gestWeeks; //填表孕周
    FuEditText et_gestDays; //填表孕天
    FuEditText et_chiefComplaint; //主诉
    FuEditText et_weight; //体重
    FuEditText et_fundusHeight; //宫底高度
    FuEditText et_abdomenCircum; //腹围
    FuEditText et_fetusPositionValue; //胎位
    FuEditText et_fetalHeartRate; //胎心率
    FuEditText et_sbp; //血压
    FuEditText et_dbp; //血压
    FuEditText et_hgb; //血红蛋白
    FuEditText et_proQuanTestValue; //尿蛋白
    FuEditText et_otherAssistExam; //其他辅助检查
    LinearLayout ll_pregHealthAbnormCode; //分类
    LinearLayout ll_zhidao; //指导
    LinearLayout ll_referralCode; //转诊
    FuEditText et_referralReason; //转诊原因
    FuEditText et_refertoDeptName; //机构及科室
    FuTextView tv_nextFollowupDate; //下次随访日期
    Spinner sp_followupDoctorName; //随访医生签名

    public FuMaternalFollowupView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_nextFollowupDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.tv_followupDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuMaternalFollowupFragment.EVENT_SAVE_MATERNAL_FOLLOWUP, null);
                break;
        }
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_maternal_followup_view, null);
    }

    public void setData(MaternalFollowup maternalFollowup) {

        tv_name.setText(maternalFollowup.getName());

    }

    public boolean saveData(MaternalFollowup maternalFollowup) {

        if ("".equals(tv_followupDate.getText().toString())) {
            ToastUtil.showToast(mContext, "请选择随访日期", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_gestWeeks.getString()) || "".equals(et_gestDays.getString())) {
            ToastUtil.showToast(mContext, "请填写填表孕周", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_weight.getString())) {
            ToastUtil.showToast(mContext, "请填写体重", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_sbp.getString()) || "".equals(et_dbp.getString())) {
            ToastUtil.showToast(mContext, "请填写血压", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_pregHealthAbnormCode))) {
            ToastUtil.showToast(mContext, "请选择分类", Toast.LENGTH_LONG);
            return false;
        }

        Checks checks = (Checks) sp_count.getSelectedItem();
        maternalFollowup.setServiceTimes(Integer.parseInt(checks.getCode()));//项目
        maternalFollowup.setFollowupDate(tv_followupDate.getDate()); //随访日期
        maternalFollowup.setGestWeeks(et_gestWeeks.getInt()); //填表孕周
        maternalFollowup.setGestDays(et_gestDays.getInt());//填表孕天
        maternalFollowup.setChiefComplaint(et_chiefComplaint.getString());//主诉
        maternalFollowup.setWeight(et_weight.getDouble());//体重
        maternalFollowup.setFundusHeight(et_fundusHeight.getDouble());//宫底高度
        maternalFollowup.setAbdomenCircum(et_abdomenCircum.getDouble());//腹围
        maternalFollowup.setFetusPositionValue(et_fetusPositionValue.getString());//胎位
        maternalFollowup.setFetalHeartRate(et_fetalHeartRate.getString());//胎心率
        maternalFollowup.setSbp(et_sbp.getInt());//血压
        maternalFollowup.setDbp(et_dbp.getInt());//血压
        maternalFollowup.setHgb(et_hgb.getDouble()); //血红蛋白
        maternalFollowup.setProQualResultCode(et_proQuanTestValue.getString());//尿蛋白
        maternalFollowup.setOtherAssistExam(et_otherAssistExam.getString());//其他辅助检查
        maternalFollowup.setPregHealthAbnormCode(getCheckBoxSimpleCode(ll_pregHealthAbnormCode)); //分类
        maternalFollowup.setPregHealthAbnormDesc(getString(ll_pregHealthAbnormCode));

        saveCheckBoxMany(null, maternalFollowup.getRecordChoice(), ll_zhidao);//指导
        maternalFollowup.setReferralCode(getCheckBoxSimpleCode(ll_referralCode));//转诊
        maternalFollowup.setReferralReason(et_referralReason.getString());//转诊原因
        maternalFollowup.setRefertoOrgName(et_refertoDeptName.getString());//机构及科室
        maternalFollowup.setNextFollowupDate(tv_nextFollowupDate.getDate());//下次随访日期
        Emp item = (Emp) sp_followupDoctorName.getSelectedItem();
        maternalFollowup.setFollowupDoctorId(item.getEmp_id());
        maternalFollowup.setFollowupDoctorName(item.getEmp_name());//随访医生签名
        return true;
    }

    @Override
    protected void initFuData() {

        List<Checks> checkses = sqlHelper.getChecksByType("PREGNANCYVISITTIME");//第几次随访

        ArrayAdapter adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                checkses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_count.setAdapter(adapter);
        sp_count.setOnItemSelectedListener(this);

        List<Emp> empList = sqlHelper.getDoctors();//随访医生姓名
        adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_followupDoctorName.setAdapter(adapter);

        initCheckBoxSimple("EXCEPTION_CODE", ll_pregHealthAbnormCode, true);
        initCheckBoxSimple("YES_NO_CODE", ll_referralCode, false);
        initCheckBoxMany("womenHealthGuid2", ll_zhidao, 2, false, true);

        FuTextView fu_title_center = (FuTextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("第2-5次产前随访");
        fu_title_center.setVisibility(View.VISIBLE);
        FuButton fu_title_right_btn = (FuButton) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    @Override
    protected void initWidget() {

        findView();

    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name); //姓名
        sp_count = (Spinner) mFuView.findViewById(R.id.sp_count); //产前随访
        tv_followupDate = (FuTextView) mFuView.findViewById(R.id.tv_followupDate); //随访日期
        tv_followupDate.setOnClickListener(this);
        et_gestWeeks = (FuEditText) mFuView.findViewById(R.id.et_gestWeeks); //填表孕周
        et_gestDays = (FuEditText) mFuView.findViewById(R.id.et_gestDays); //填表孕天
        et_chiefComplaint = (FuEditText) mFuView.findViewById(R.id.et_chiefComplaint); //主诉
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight); //体重
        et_fundusHeight = (FuEditText) mFuView.findViewById(R.id.et_fundusHeight); //宫底高度
        et_abdomenCircum = (FuEditText) mFuView.findViewById(R.id.et_abdomenCircum); //腹围
        et_fetusPositionValue = (FuEditText) mFuView.findViewById(R.id.et_fetusPositionValue); //胎位
        et_fetalHeartRate = (FuEditText) mFuView.findViewById(R.id.et_fetalHeartRate); //胎心率
        et_sbp = (FuEditText) mFuView.findViewById(R.id.et_sbp); //血压
        et_dbp = (FuEditText) mFuView.findViewById(R.id.et_dbp); //血压
        et_hgb = (FuEditText) mFuView.findViewById(R.id.et_hgb); //血红蛋白
        et_proQuanTestValue = (FuEditText) mFuView.findViewById(R.id.et_proQuanTestValue); //尿蛋白
        et_otherAssistExam = (FuEditText) mFuView.findViewById(R.id.et_otherAssistExam); //其他辅助检查
        ll_pregHealthAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_pregHealthAbnormCode); //分类
        ll_zhidao = (LinearLayout) mFuView.findViewById(R.id.ll_zhidao); //指导
        ll_referralCode = (LinearLayout) mFuView.findViewById(R.id.ll_referralCode); //转诊
        et_referralReason = (FuEditText) mFuView.findViewById(R.id.et_referralReason); //转诊原因
        et_refertoDeptName = (FuEditText) mFuView.findViewById(R.id.et_refertoDeptName); //机构及科室
        tv_nextFollowupDate = (FuTextView) mFuView.findViewById(R.id.tv_nextFollowupDate); //下次随访日期
        tv_nextFollowupDate.setOnClickListener(this);
        sp_followupDoctorName = (Spinner) mFuView.findViewById(R.id.sp_followupDoctorName); //随访医生签名

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        setZhiDao(position);
    }

    private void setZhiDao(int position) {
        if (position == 1) {
            ll_zhidao.removeAllViews();
            initCheckBoxMany("womenHealthGuid3", ll_zhidao, 2, false, true);
        } else if (position == 2 || position == 3||position==4) {
            ll_zhidao.removeAllViews();
            initCheckBoxMany("womenHealthGuid45", ll_zhidao, 2, false, true);
        } else if (position == 0) {
            ll_zhidao.removeAllViews();
            initCheckBoxMany("womenHealthGuid2", ll_zhidao, 2, false, true);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
