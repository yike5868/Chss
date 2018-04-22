package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.maternal.MaternalPostpartumFollowup;
import net.greatsoft.main.fragment.FuMaternalPostpartumFollowupFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/15.
 * 产后42天
 */

public class FuMaternalPostpartumFollowupView extends FuUiFrameModel implements View.OnClickListener {

    FuTextView tv_name; //姓名
    FuTextView tv_followupDate; //随访日期
    FuTextView tv_deliveryDate; //分娩日期
    FuTextView tv_resiOutDate; //出院日期
    FuEditText et_bodyTemperature; //体温
    FuEditText et_healthDesc; //一般健康情况
    FuEditText et_psyDesc; //一般心理情况
    FuEditText et_systilic; //血压
    FuEditText et_diastolic; //血压
    LinearLayout ll_uberCode; //乳房
    LinearLayout ll_lochiaCode; //恶露
    LinearLayout ll_uterusCode; //子宫
    LinearLayout ll_woundCode; //伤口
    FuEditText et_othersDesc; //其他
    LinearLayout ll_followupClassifyCode; //分类
    LinearLayout ll_zhidao; //指导
    LinearLayout ll_referralCode; //转诊
    FuEditText et_referralReason; //转诊原因
    FuEditText et_refertoDeptName; //机构及科室
    FuTextView tv_nextFollowupDate; //下次随访日期
    Spinner sp_followupDoctorName; //随访医生签名
    int type;

    FuTextView tv_chuyuanData;//出院日期
    FuTextView tv_jiankang;//一般健康情况
    FuTextView tv_xinli;//一般心理情况
    FuTextView tv_rufang;//乳房
    FuTextView tv_elou;//恶露
    FuTextView tv_zigong;//子宫
    FuTextView tv_shangkou;//伤口
    FuTextView tv_fenlei;//分类
    LinearLayout ll_tiwen;//体温
    LinearLayout ll_xiaciData;//下次随访日期

    FuTextView fu_title_center;

    public FuMaternalPostpartumFollowupView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuMaternalPostpartumFollowupFragment.EVENT_SAVE_MATERNAL_POSTPARTUM_FOLLOWUP, null);
                break;
            case R.id.tv_followupDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.tv_deliveryDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.tv_resiOutDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.tv_nextFollowupDate:
                ((FuParentActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
        }
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_maternal_postpartum_followup_view, null);
    }

    public void setData(MaternalPostpartumFollowup maternalPostpartumFollowup, int type) {

        tv_name.setText(maternalPostpartumFollowup.getName());
        this.type = type;
        setView(type);
    }

    public boolean saveData(MaternalPostpartumFollowup maternalPostpartumFollowup) {

        if ("".equals(tv_followupDate.getText().toString())) {
            ToastUtil.showToast(mContext, "请选择填表日期", Toast.LENGTH_LONG);
            return false;
        }
        if (type == 0) {
            if ("".equals(et_bodyTemperature.getString())) {
                ToastUtil.showToast(mContext, "请填写体温", Toast.LENGTH_LONG);
                return false;
            }
            if ("".equals(et_healthDesc.getString())) {
                ToastUtil.showToast(mContext, "请填写一般健康问题", Toast.LENGTH_LONG);
                return false;
            }
            if ("".equals(et_psyDesc.getString())) {
                ToastUtil.showToast(mContext, "请填写一般心理问题", Toast.LENGTH_LONG);
                return false;
            }
            if ("".equals(getCheckBoxSimpleCode(ll_uberCode))) {
                ToastUtil.showToast(mContext, "请选择乳房", Toast.LENGTH_LONG);
                return false;
            }
            if ("".equals(getCheckBoxSimpleCode(ll_lochiaCode))) {
                ToastUtil.showToast(mContext, "请选择恶露", Toast.LENGTH_LONG);
                return false;
            }
            if ("".equals(getCheckBoxSimpleCode(ll_uterusCode))) {
                ToastUtil.showToast(mContext, "请选择子宫", Toast.LENGTH_LONG);
                return false;
            }
            if ("".equals(getCheckBoxSimpleCode(ll_woundCode))) {
                ToastUtil.showToast(mContext, "请选择伤口", Toast.LENGTH_LONG);
                return false;
            }
            if ("".equals(getCheckBoxSimpleCode(ll_followupClassifyCode))) {
                ToastUtil.showToast(mContext, "请选择分类", Toast.LENGTH_LONG);
                return false;
            }
            if ("".equals(tv_nextFollowupDate.getText().toString())) {
                ToastUtil.showToast(mContext, "请选择下次随访日期", Toast.LENGTH_LONG);
                return false;
            }
        } else {

            if ("".equals(et_healthDesc.getString())) {
                ToastUtil.showToast(mContext, "请填写一般健康问题", Toast.LENGTH_LONG);
                return false;
            }
            if ("".equals(et_psyDesc.getString())) {
                ToastUtil.showToast(mContext, "请填写一般心理问题", Toast.LENGTH_LONG);
                return false;
            }

        }
        if ("".equals(et_systilic.getString()) || "".equals(et_diastolic.getString())) {
            ToastUtil.showToast(mContext, "请填写血压", Toast.LENGTH_LONG);
            return false;
        }

        maternalPostpartumFollowup.setFollowupDate(tv_followupDate.getDate());//随访日期
        maternalPostpartumFollowup.setDeliveryDate(tv_deliveryDate.getDate());//分娩日期
        maternalPostpartumFollowup.setResiOutDate(tv_resiOutDate.getDate()); //出院日期
        maternalPostpartumFollowup.setBodyTemperature(et_bodyTemperature.getDouble());//体温
        maternalPostpartumFollowup.setHealthDesc(et_healthDesc.getString());//一般健康情况
        maternalPostpartumFollowup.setPsyDesc(et_psyDesc.getString());//一般心理情况
        maternalPostpartumFollowup.setSystilic(et_systilic.getInt());//血压
        maternalPostpartumFollowup.setDiastolic(et_diastolic.getInt()); //血压
        maternalPostpartumFollowup.setUberCode(getCheckBoxSimpleCode(ll_uberCode));//乳房
        maternalPostpartumFollowup.setUberAbnormDesc(getString(ll_uberCode));
        maternalPostpartumFollowup.setLochiaCode(getCheckBoxSimpleCode(ll_lochiaCode));//恶露
        maternalPostpartumFollowup.setLochiaAbnormDesc(getString(ll_lochiaCode));
        maternalPostpartumFollowup.setUterusCode(getCheckBoxSimpleCode(ll_uterusCode));//子宫
        maternalPostpartumFollowup.setUterusAbnormDesc(getString(ll_uterusCode));
        maternalPostpartumFollowup.setWoundCode(getCheckBoxSimpleCode(ll_woundCode)); //伤口
        maternalPostpartumFollowup.setWoundAbnormDesc(getString(ll_woundCode));
        maternalPostpartumFollowup.setOthersDesc(et_othersDesc.getString()); //其他
        maternalPostpartumFollowup.setFollowupClassifyCode(getCheckBoxSimpleCode(ll_followupClassifyCode));//分类
        maternalPostpartumFollowup.setFollowupClassifyValue(getString(ll_followupClassifyCode));
        saveCheckBoxMany(null, maternalPostpartumFollowup.getRecordChoice(), ll_zhidao);//指导
        maternalPostpartumFollowup.setReferralCode(getCheckBoxSimpleCode(ll_referralCode)); //转诊
        maternalPostpartumFollowup.setReferralReason(et_referralReason.getString()); //转诊原因
        maternalPostpartumFollowup.setRefertoOrgName(et_refertoDeptName.getString()); //机构及科室
        maternalPostpartumFollowup.setNextFollowupDate(tv_nextFollowupDate.getDate());//下次随访日期
        Emp item = (Emp) sp_followupDoctorName.getSelectedItem();
        maternalPostpartumFollowup.setFollowupDoctorId(item.getEmp_id());
        maternalPostpartumFollowup.setFollowupDoctorName(item.getEmp_name()); //随访医生签名

        return true;
    }

    @Override
    protected void initFuData() {

        ArrayAdapter adapter;
        List<Emp> empList = sqlHelper.getDoctors();
        adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_followupDoctorName.setAdapter(adapter);

        // 初使化复选框、单选框
        initCheckBoxSimple("EXCEPTION_CODE", ll_uberCode, true);// 乳房
        initCheckBoxSimple("EXCEPTION_CODE", ll_lochiaCode, true);// 恶露
        initCheckBoxSimple("EXCEPTION_CODE", ll_uterusCode, true);// 子宫
        initCheckBoxSimple("EXCEPTION_CODE", ll_woundCode, true);// 伤口
        initCheckBoxSimple("ASSORT", ll_followupClassifyCode, true);// 分类
        initCheckBoxSimple("TREATWAY", ll_referralCode, false);// 是否失访

        fu_title_center = (FuTextView) mFuView.findViewById(R.id.fu_title_center);

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
        tv_followupDate = (FuTextView) mFuView.findViewById(R.id.tv_followupDate); //随访日期
        tv_followupDate.setOnClickListener(this);
        tv_deliveryDate = (FuTextView) mFuView.findViewById(R.id.tv_deliveryDate); //分娩日期
        tv_deliveryDate.setOnClickListener(this);
        tv_resiOutDate = (FuTextView) mFuView.findViewById(R.id.tv_resiOutDate); //出院日期
        tv_resiOutDate.setOnClickListener(this);
        et_bodyTemperature = (FuEditText) mFuView.findViewById(R.id.et_bodyTemperature); //体温
        et_healthDesc = (FuEditText) mFuView.findViewById(R.id.et_healthDesc); //一般健康情况
        et_psyDesc = (FuEditText) mFuView.findViewById(R.id.et_psyDesc); //一般心理情况
        et_systilic = (FuEditText) mFuView.findViewById(R.id.et_systilic); //血压
        et_diastolic = (FuEditText) mFuView.findViewById(R.id.et_diastolic); //血压
        ll_uberCode = (LinearLayout) mFuView.findViewById(R.id.ll_uberCode); //乳房
        ll_lochiaCode = (LinearLayout) mFuView.findViewById(R.id.ll_lochiaCode); //恶露
        ll_uterusCode = (LinearLayout) mFuView.findViewById(R.id.ll_uterusCode); //子宫
        ll_woundCode = (LinearLayout) mFuView.findViewById(R.id.ll_woundCode); //伤口
        et_othersDesc = (FuEditText) mFuView.findViewById(R.id.et_othersDesc); //其他
        ll_followupClassifyCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupClassifyCode); //分类
        ll_zhidao = (LinearLayout) mFuView.findViewById(R.id.ll_zhidao); //指导
        ll_referralCode = (LinearLayout) mFuView.findViewById(R.id.ll_referralCode); //转诊
        et_referralReason = (FuEditText) mFuView.findViewById(R.id.et_referralReason); //转诊原因
        et_refertoDeptName = (FuEditText) mFuView.findViewById(R.id.et_refertoDeptName); //机构及科室
        tv_nextFollowupDate = (FuTextView) mFuView.findViewById(R.id.tv_nextFollowupDate); //下次随访日期
        tv_nextFollowupDate.setOnClickListener(this);
        sp_followupDoctorName = (Spinner) mFuView.findViewById(R.id.sp_followupDoctorName); //随访医生签名


        tv_chuyuanData = (FuTextView) mFuView.findViewById(R.id.tv_chuyuanData);//出院日期
        tv_jiankang = (FuTextView) mFuView.findViewById(R.id.tv_jiankang);//一般健康情况
        tv_xinli = (FuTextView) mFuView.findViewById(R.id.tv_xinli);//一般心理情况
        tv_rufang = (FuTextView) mFuView.findViewById(R.id.tv_rufang);//乳房
        tv_elou = (FuTextView) mFuView.findViewById(R.id.tv_elou);//恶露
        tv_zigong = (FuTextView) mFuView.findViewById(R.id.tv_zigong);//子宫
        tv_shangkou = (FuTextView) mFuView.findViewById(R.id.tv_shangkou);//伤口
        tv_fenlei = (FuTextView) mFuView.findViewById(R.id.tv_fenlei);//分类
        ll_tiwen = (LinearLayout) mFuView.findViewById(R.id.ll_tiwen);//体温
        ll_xiaciData = (LinearLayout) mFuView.findViewById(R.id.ll_xiaciData);//下次随访日期

    }

    public void setView(int type) {
        if (type == 1) {
            tv_jiankang.setText("一般健康情况*");
            tv_xinli.setText("一般心理情况*");
            ll_tiwen.setVisibility(View.GONE);
            ll_xiaciData.setVisibility(View.GONE);
            tv_chuyuanData.setVisibility(View.INVISIBLE);
            tv_chuyuanData.setVisibility(View.INVISIBLE);
            tv_resiOutDate.setVisibility(View.INVISIBLE);
            initCheckBoxMany("womenPostpartumLastGuide", ll_zhidao, 2, true, true);// 指导
            fu_title_center.setText("产后42天访视");
            ll_referralCode.removeAllViews();
            initCheckBoxSimple("TREATWAY", ll_referralCode, false);// 是否失访
        } else {
            tv_jiankang.setText("一般健康情况*");
            tv_xinli.setText("一般心理情况*");
            tv_rufang.setText("乳房*");
            tv_elou.setText("恶露*");
            tv_zigong.setText("子宫*");
            tv_shangkou.setText("伤口*");
            tv_fenlei.setText("分类*");
            initCheckBoxMany("womenPostpartumGuide", ll_zhidao, 2, true, true);// 指导
            fu_title_center.setText("产后访视");
            ll_referralCode.removeAllViews();
            initCheckBoxSimple("YES_NO_CODE", ll_referralCode, false);// 是否失访
        }
    }
}
