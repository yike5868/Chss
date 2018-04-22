package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.maternal.MaternalFirstFollowup;
import net.greatsoft.main.fragment.FuMaternalFirstFollowupFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuCheckBox;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/15.
 * 第一次产前随访
 */

public class FuMaternalFirstFollowupView extends FuUiFrameModel implements View.OnClickListener, View.OnFocusChangeListener {

    FuTextView tv_name; //姓名
    FuTextView tv_followupDate; //填表日期
    FuEditText et_gestWeeks; //填表孕周
    FuEditText et_gestDays; //填表孕天
    FuEditText et_age; //孕妇年龄
    FuEditText et_husbandName; //丈夫姓名
    FuEditText et_husbandAge; //丈夫年龄
    FuEditText et_husbandTelNo; //丈夫电话
    FuEditText et_gravidity; //孕次
    FuEditText et_vaginalDeliveryTimes; //阴道分娩
    FuEditText et_caesareanDeliveryTimes; //剖宫产
    FuTextView tv_expectedChildBirthday; //预产期
    FuTextView tv_mensesLastDate; //末次月经
    FuCheckBox cb_no; //不详
    LinearLayout ll_jiwangshi; //既往史
    LinearLayout ll_jiazushi; //家族史
    LinearLayout ll_gerenshi; //个人史
    LinearLayout ll_gynOpHistory; //妇科手术史
    FuEditText et_abortionTimes; //流产
    FuEditText et_deadFetusNum; //死胎
    FuEditText et_stillbirthNum; //死产
    FuEditText et_newbornDeathNum; //新生儿死亡
    FuEditText et_birthDefectCount; //出生儿缺陷
    FuEditText et_height; //身高
    FuEditText et_weight; //体重
    FuEditText et_bmi; //体质指数
    FuEditText et_sbp; //血压
    FuEditText et_dbp; //血压
    LinearLayout ll_heartAbnormCode; //心脏听诊
    LinearLayout ll_lungAbnormCode; //肺部听诊
    LinearLayout ll_vulvaAbnormCode; //外阴
    LinearLayout ll_vaginaAbnormCode; //阴道
    LinearLayout ll_cervixAbnormCode; //宫颈
    LinearLayout ll_corpusuteriAbnormCode; //子宫
    LinearLayout ll_adnexaAbnormCode; //附件
    FuEditText et_hgb; //血红蛋白
    FuEditText et_wbc; //白细胞计数值
    FuEditText et_plt; //血小板计数值
    FuEditText et_cbcOthers; //其他
    FuEditText et_proQuanTestValue; //尿蛋白
    FuEditText et_gluQualResultCode; //尿糖
    FuEditText et_ketQualResultCode; //尿胴体
    FuEditText et_uobTestResultCode; //尿潜血
    FuEditText et_urineRoutineOther; //其他
    FuEditText et_aboRhValue; //血型
    FuEditText et_glu; //血糖
    FuEditText et_sgpt; //血清谷丙转氨酶
    FuEditText et_ast; //血清谷草转氨酶
    FuEditText et_alb; //尿蛋白
    FuEditText et_tbi; //总胆红素
    FuEditText et_dbil; //结合胆红素
    FuEditText et_scr; //血清肌酐
    FuEditText et_bun; //血尿素氮
    LinearLayout ll_ydfmw; //阴道分泌物
    LinearLayout ll_wvdCleanCode; //阴道清洁度
    FuEditText et_hbsagTestResultCode; //乙型肝炎表面抗原
    FuEditText et_hbsabTestResultCode; //乙型肝炎表面抗体
    FuEditText et_hbeagTestResultCode; //乙型肝炎表面e抗原
    FuEditText et_hbeabTestResultCode; //乙型肝炎表面e抗体
    FuEditText et_hbcabTestResultCode; //乙型肝炎核心抗体
    LinearLayout ll_stsResultCode; //梅毒血清学实验
    LinearLayout ll_hivAntiResultCode; //HIV抗体检测
    FuEditText et_bscanResultDesc; //B超
    FuEditText et_examOthers; //其他
    LinearLayout ll_pregHealthAbnormCode; //总体评估
    LinearLayout ll_bjzd; //保健指导
    LinearLayout ll_referralCode; //是否转诊
    FuEditText et_referralReason; //转诊原因
    FuEditText et_refertoDeptName; //机构及科室
    FuTextView tv_nextFollowupDate; //下次访问日期
    Spinner sp_followupDoctorName; //随访医生签名

    public FuMaternalFirstFollowupView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_nextFollowupDate:
                ((FuParentActivity) mContext).showTimeDialog(((FuTextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.tv_followupDate:
                ((FuParentActivity) mContext).showTimeDialog(((FuTextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.tv_expectedChildBirthday:
                ((FuParentActivity) mContext).showTimeDialog(((FuTextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.tv_mensesLastDate:
                ((FuParentActivity) mContext).showTimeDialog(((FuTextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(),"year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuMaternalFirstFollowupFragment.EVENT_SAVE_MATERNAL_FIRST_FOLLOWUP, null);
                break;
        }

    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_maternal_first_followup_view, null);
    }

    public void setData(MaternalFirstFollowup maternalFirstFollowup) {
        tv_name.setText(maternalFirstFollowup.getName());
    }

    public boolean saveData(MaternalFirstFollowup maternalFirstFollowup) {

        if ("".equals(tv_followupDate.getText().toString())) {
            ToastUtil.showToast(mContext, "请选择随访日期", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_gestWeeks.getString()) || "".equals(et_gestDays.getString())) {
            ToastUtil.showToast(mContext, "请填写填表孕周", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_gravidity.getString())) {
            ToastUtil.showToast(mContext, "请填写孕次", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(tv_expectedChildBirthday.getText().toString())) {
            ToastUtil.showToast(mContext, "请选择预产期", Toast.LENGTH_LONG);
            return false;
        }
        boolean flag = true;
        saveCheckBoxMany(null, maternalFirstFollowup.getRecordChoice(), ll_jiwangshi); //既往史
        List<RecordChoice> choice = maternalFirstFollowup.getRecordChoice();
        for (int i = 0; i < choice.size(); i++) {
            if ("womenPastHistory".equals(choice.get(i).getCodeType())) {
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择既往史", Toast.LENGTH_LONG);
            return false;
        }
        flag = true;
        saveCheckBoxMany(null, maternalFirstFollowup.getRecordChoice(), ll_jiazushi);//家族史
        choice = maternalFirstFollowup.getRecordChoice();
        for (int i = 0; i < choice.size(); i++) {
            if ("womenFamilyHistory".equals(choice.get(i).getCodeType())) {
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择家族史", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_abortionTimes.getString()) || "".equals(et_deadFetusNum.getString()) ||
                "".equals(et_stillbirthNum.getString()) || "".equals(et_newbornDeathNum.getString()) ||
                "".equals(et_birthDefectCount.getString())) {
            ToastUtil.showToast(mContext, "请填写孕产史", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_height.getString())) {
            ToastUtil.showToast(mContext, "请填写身高", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_weight.getString())) {
            ToastUtil.showToast(mContext, "请填写体重", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_bmi.getString())) {
            ToastUtil.showToast(mContext, "请填写体质指数", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_sbp.getString()) || "".equals(et_dbp.getString())) {
            ToastUtil.showToast(mContext, "请填写血压", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(tv_nextFollowupDate.getText().toString())) {
            ToastUtil.showToast(mContext, "请填写下次随访日期", Toast.LENGTH_LONG);
            return false;
        }

        maternalFirstFollowup.setFollowupDate(tv_followupDate.getDate());//填表日期
        maternalFirstFollowup.setGestWeeks(et_gestWeeks.getInt());//填表孕周
        maternalFirstFollowup.setGestDays(et_gestDays.getInt());//填表孕天
        maternalFirstFollowup.setAge(et_age.getInt()); //孕妇年龄
        maternalFirstFollowup.setHusbandName(et_husbandName.getString());//丈夫姓名
        maternalFirstFollowup.setHusbandAge(et_husbandAge.getInt());//丈夫年龄
        maternalFirstFollowup.setHusbandTelNo(et_husbandTelNo.getString()); //丈夫电话
        maternalFirstFollowup.setGravidity(et_gravidity.getInt());//孕次
        maternalFirstFollowup.setVaginalDeliveryTimes(et_vaginalDeliveryTimes.getInt());//阴道分娩
        maternalFirstFollowup.setCaesareanDeliveryTimes(et_caesareanDeliveryTimes.getInt());//剖宫产
        maternalFirstFollowup.setExpectedChildBirthday(tv_expectedChildBirthday.getDate());//预产期
        maternalFirstFollowup.setMensesLastDate(tv_mensesLastDate.getDate());//末次月经
        maternalFirstFollowup.setLastMensesCode(cb_no.isChecked() ? "1" : "0");//不详
        saveCheckBoxMany(null, maternalFirstFollowup.getRecordChoice(), ll_gerenshi); //个人史
        maternalFirstFollowup.setGynOpHistory(getString(ll_gynOpHistory));
        maternalFirstFollowup.setGynOpHistoryCode(getCheckBoxSimpleCode(ll_gynOpHistory));//妇科手术史
        maternalFirstFollowup.setAbortionTimes(et_abortionTimes.getInt()); //流产
        maternalFirstFollowup.setDeadFetusNum(et_deadFetusNum.getInt());//死胎
        maternalFirstFollowup.setStillbirthNum(et_stillbirthNum.getInt()); //死产
        maternalFirstFollowup.setNewbornDeathNum(et_newbornDeathNum.getInt());//新生儿死亡
        maternalFirstFollowup.setBirthDefectCount(et_birthDefectCount.getInt()); //出生儿缺陷
        maternalFirstFollowup.setHeight(et_height.getDouble());//身高
        maternalFirstFollowup.setWeight(et_weight.getDouble()); //体重
        maternalFirstFollowup.setBmi(et_bmi.getDouble()); //体重
        maternalFirstFollowup.setSbp(et_sbp.getInt()); //血压
        maternalFirstFollowup.setDbp(et_dbp.getInt()); //血压
        maternalFirstFollowup.setHeartAbnormCode(getCheckBoxSimpleCode(ll_heartAbnormCode));//心脏听诊
        maternalFirstFollowup.setHeartAbnormDesc(getString(ll_heartAbnormCode));
        maternalFirstFollowup.setLungAbnormCode(getCheckBoxSimpleCode(ll_lungAbnormCode));//肺部听诊
        maternalFirstFollowup.setLungAbnormDesc(getString(ll_lungAbnormCode));
        maternalFirstFollowup.setVulvaAbnormCode(getCheckBoxSimpleCode(ll_vulvaAbnormCode));//外阴
        maternalFirstFollowup.setVulvaAbnormDesc(getString(ll_vulvaAbnormCode));
        maternalFirstFollowup.setVaginaAbnormCode(getCheckBoxSimpleCode(ll_vaginaAbnormCode)); //阴道
        maternalFirstFollowup.setVaginaAbnormDesc(getString(ll_vaginaAbnormCode));
        maternalFirstFollowup.setCervixAbnormCode(getCheckBoxSimpleCode(ll_cervixAbnormCode));//宫颈
        maternalFirstFollowup.setCervixAbnormDesc(getString(ll_cervixAbnormCode));
        maternalFirstFollowup.setCorpusuteriAbnormCode(getCheckBoxSimpleCode(ll_corpusuteriAbnormCode));//子宫
        maternalFirstFollowup.setCorpusuteriAbnormDesc(getString(ll_corpusuteriAbnormCode));
        maternalFirstFollowup.setAdnexaAbnormCode(getCheckBoxSimpleCode(ll_adnexaAbnormCode));//附件
        maternalFirstFollowup.setAdnexaAbnormDesc(getString(ll_adnexaAbnormCode));
        maternalFirstFollowup.setHgb(et_hgb.getDouble());//血红蛋白
        maternalFirstFollowup.setWbc(et_wbc.getDouble());//白细胞计数值
        maternalFirstFollowup.setPlt(et_plt.getDouble());//血小板计数值
        maternalFirstFollowup.setCbcOthers(et_cbcOthers.getString());//其他
        maternalFirstFollowup.setProQualResultCode(et_proQuanTestValue.getString()); //尿蛋白
        maternalFirstFollowup.setGluQualResultCode(et_gluQualResultCode.getString());//尿糖
        maternalFirstFollowup.setKetQualResultCode(et_ketQualResultCode.getString());//尿胴体
        maternalFirstFollowup.setUobTestResultCode(et_uobTestResultCode.getString());//尿潜血
        maternalFirstFollowup.setUrineRoutineOther(et_urineRoutineOther.getString());//其他
        maternalFirstFollowup.setAboRhValue(et_aboRhValue.getString());//血型
        maternalFirstFollowup.setGlu(et_glu.getDouble());//血糖
        maternalFirstFollowup.setSgpt(et_sgpt.getDouble());//血清谷丙转氨酶
        maternalFirstFollowup.setAst(et_ast.getDouble());//血清谷草转氨酶
        maternalFirstFollowup.setAlb(et_alb.getDouble());//尿蛋白
        maternalFirstFollowup.setTbi(et_tbi.getDouble());//总胆红素
        maternalFirstFollowup.setDbil(et_dbil.getDouble());//结合胆红素
        maternalFirstFollowup.setScr(et_scr.getDouble());//血清肌酐
        maternalFirstFollowup.setBun(et_bun.getDouble());//血尿素氮
        saveCheckBoxMany(null, maternalFirstFollowup.getRecordChoice(), ll_ydfmw); //阴道分泌物
        maternalFirstFollowup.setWvdCleanCode(getCheckBoxSimpleCode(ll_wvdCleanCode));//阴道清洁度
        maternalFirstFollowup.setHbsagTestResultCode(et_hbsagTestResultCode.getString());//乙型肝炎表面抗原
        maternalFirstFollowup.setHbsabTestResultCode(et_hbsabTestResultCode.getString());//乙型肝炎表面抗体
        maternalFirstFollowup.setHbeagTestResultCode(et_hbeagTestResultCode.getString());//乙型肝炎表面e抗原
        maternalFirstFollowup.setHbeabTestResultCode(et_hbeabTestResultCode.getString()); //乙型肝炎表面e抗体
        maternalFirstFollowup.setHbcabTestResultCode(et_hbcabTestResultCode.getString());//乙型肝炎核心抗体
        maternalFirstFollowup.setStsResultCode(getCheckBoxSimpleCode(ll_stsResultCode));//梅毒血清学实验
        maternalFirstFollowup.setHivAntiResultCode(getCheckBoxSimpleCode(ll_hivAntiResultCode)); //HIV抗体检测
        maternalFirstFollowup.setBscanResultDesc(et_bscanResultDesc.getString()); //B超
        maternalFirstFollowup.setExamOthers(et_examOthers.getString());//其他
        maternalFirstFollowup.setPregHealthAbnormCode(getCheckBoxSimpleCode(ll_pregHealthAbnormCode)); //总体评估
        maternalFirstFollowup.setPregHealthAbnormDesc(getString(ll_pregHealthAbnormCode));
        saveCheckBoxMany(null, maternalFirstFollowup.getRecordChoice(), ll_bjzd);//保健指导
        maternalFirstFollowup.setReferralCode(getCheckBoxSimpleCode(ll_referralCode));//是否转诊
        maternalFirstFollowup.setReferralReason(et_referralReason.getString());//转诊原因
        maternalFirstFollowup.setRefertoOrgName(et_refertoDeptName.getString());//机构及科室
        maternalFirstFollowup.setNextFollowupDate(tv_nextFollowupDate.getDate());//下次访问日期
        Emp emp = (Emp) sp_followupDoctorName.getSelectedItem();
        maternalFirstFollowup.setFollowupDoctorId(emp.getEmp_id());
        maternalFirstFollowup.setFollowupDoctorName(emp.getEmp_name());//随访医生签名

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

        initCheckBoxSimple("EXCEPTION_CODE", ll_heartAbnormCode, true);
        initCheckBoxSimple("EXCEPTION_CODE", ll_lungAbnormCode, true);
        initCheckBoxSimple("EXCEPTION_CODE", ll_vulvaAbnormCode, true);
        initCheckBoxSimple("EXCEPTION_CODE", ll_vaginaAbnormCode, true);
        initCheckBoxSimple("EXCEPTION_CODE", ll_cervixAbnormCode, true);
        initCheckBoxSimple("EXCEPTION_CODE", ll_corpusuteriAbnormCode, true);
        initCheckBoxSimple("EXCEPTION_CODE", ll_adnexaAbnormCode, true);
        initCheckBoxSimple("YES_NO_CODE", ll_referralCode, false);
        initCheckBoxSimple("CQ_05", ll_gynOpHistory, true);
        initCheckBoxSimple("VAGINAL_CLEANLINESS", ll_wvdCleanCode, false);
        initCheckBoxSimple("CV9500.23", ll_stsResultCode, false);
        initCheckBoxSimple("CV9500.23", ll_hivAntiResultCode, false);
        initCheckBoxSimple("EXCEPTION_CODE", ll_pregHealthAbnormCode, true);

        initCheckBoxMany("womenPastHistory", ll_jiwangshi, 3, true, true);

        initCheckBoxMany("womenFamilyHistory", ll_jiazushi, 3, true, true);

        initCheckBoxMany("selfHistory", ll_gerenshi, 2, true, true);

        initCheckBoxMany("womenHealthGuid", ll_bjzd, 2, true, true);

        initCheckBoxMany("wvdExam", ll_ydfmw, 2, true, true);

    }

    @Override
    protected void initWidget() {

        findView();

        FuTextView fu_title_center = (FuTextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("第一次产前随访");
        fu_title_center.setVisibility(View.VISIBLE);
        FuButton fu_title_right_btn = (FuButton) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name); //姓名
        tv_followupDate = (FuTextView) mFuView.findViewById(R.id.tv_followupDate); //填表日期
        tv_followupDate.setOnClickListener(this);
        et_gestWeeks = (FuEditText) mFuView.findViewById(R.id.et_gestWeeks); //填表孕周
        et_gestDays = (FuEditText) mFuView.findViewById(R.id.et_gestDays); //填表孕天
        et_age = (FuEditText) mFuView.findViewById(R.id.et_age); //孕妇年龄
        et_husbandName = (FuEditText) mFuView.findViewById(R.id.et_husbandName); //丈夫姓名
        et_husbandAge = (FuEditText) mFuView.findViewById(R.id.et_husbandAge); //丈夫年龄
        et_husbandTelNo = (FuEditText) mFuView.findViewById(R.id.et_husbandTelNo); //丈夫电话
        et_gravidity = (FuEditText) mFuView.findViewById(R.id.et_gravidity); //孕次
        et_vaginalDeliveryTimes = (FuEditText) mFuView.findViewById(R.id.et_vaginalDeliveryTimes); //阴道分娩
        et_caesareanDeliveryTimes = (FuEditText) mFuView.findViewById(R.id.et_caesareanDeliveryTimes); //剖宫产
        tv_expectedChildBirthday = (FuTextView) mFuView.findViewById(R.id.tv_expectedChildBirthday); //预产期
        tv_expectedChildBirthday.setOnClickListener(this);
        tv_mensesLastDate = (FuTextView) mFuView.findViewById(R.id.tv_mensesLastDate);
        tv_mensesLastDate.setOnClickListener(this);
        cb_no = (FuCheckBox) mFuView.findViewById(R.id.cb_no); //不详
        ll_jiwangshi = (LinearLayout) mFuView.findViewById(R.id.ll_jiwangshi); //既往史
        ll_jiazushi = (LinearLayout) mFuView.findViewById(R.id.ll_jiazushi); //家族史
        ll_gerenshi = (LinearLayout) mFuView.findViewById(R.id.ll_gerenshi); //个人史
        ll_gynOpHistory = (LinearLayout) mFuView.findViewById(R.id.ll_gynOpHistory); //妇科手术史
        et_abortionTimes = (FuEditText) mFuView.findViewById(R.id.et_abortionTimes); //流产
        et_deadFetusNum = (FuEditText) mFuView.findViewById(R.id.et_deadFetusNum); //死胎
        et_stillbirthNum = (FuEditText) mFuView.findViewById(R.id.et_stillbirthNum); //死产
        et_newbornDeathNum = (FuEditText) mFuView.findViewById(R.id.et_newbornDeathNum); //新生儿死亡
        et_birthDefectCount = (FuEditText) mFuView.findViewById(R.id.et_birthDefectCount); //出生儿缺陷
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height); //身高
        et_height.setOnFocusChangeListener(this);
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight); //体重
        et_weight.setOnFocusChangeListener(this);
        et_bmi = (FuEditText) mFuView.findViewById(R.id.et_bmi); //体质指数
        et_sbp = (FuEditText) mFuView.findViewById(R.id.et_sbp); //血压
        et_dbp = (FuEditText) mFuView.findViewById(R.id.et_dbp); //血压
        ll_heartAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_heartAbnormCode); //心脏听诊
        ll_lungAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_lungAbnormCode); //肺部听诊
        ll_vulvaAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_vulvaAbnormCode); //外阴
        ll_vaginaAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_vaginaAbnormCode); //阴道
        ll_cervixAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_cervixAbnormCode); //宫颈
        ll_corpusuteriAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_corpusuteriAbnormCode); //子宫
        ll_adnexaAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_adnexaAbnormCode); //附件
        et_hgb = (FuEditText) mFuView.findViewById(R.id.et_hgb); //血红蛋白
        et_wbc = (FuEditText) mFuView.findViewById(R.id.et_wbc); //白细胞计数值
        et_plt = (FuEditText) mFuView.findViewById(R.id.et_plt); //血小板计数值
        et_cbcOthers = (FuEditText) mFuView.findViewById(R.id.et_cbcOthers); //其他
        et_proQuanTestValue = (FuEditText) mFuView.findViewById(R.id.et_proQuanTestValue); //尿蛋白
        et_gluQualResultCode = (FuEditText) mFuView.findViewById(R.id.et_gluQualResultCode); //尿糖
        et_ketQualResultCode = (FuEditText) mFuView.findViewById(R.id.et_ketQualResultCode); //尿胴体
        et_uobTestResultCode = (FuEditText) mFuView.findViewById(R.id.et_uobTestResultCode); //尿潜血
        et_urineRoutineOther = (FuEditText) mFuView.findViewById(R.id.et_urineRoutineOther); //其他
        et_aboRhValue = (FuEditText) mFuView.findViewById(R.id.et_aboRhValue); //血型
        et_glu = (FuEditText) mFuView.findViewById(R.id.et_glu); //血糖
        et_sgpt = (FuEditText) mFuView.findViewById(R.id.et_sgpt); //血清谷丙转氨酶
        et_ast = (FuEditText) mFuView.findViewById(R.id.et_ast); //血清谷草转氨酶
        et_alb = (FuEditText) mFuView.findViewById(R.id.et_alb); //尿蛋白
        et_tbi = (FuEditText) mFuView.findViewById(R.id.et_tbi); //总胆红素
        et_dbil = (FuEditText) mFuView.findViewById(R.id.et_dbil); //结合胆红素
        et_scr = (FuEditText) mFuView.findViewById(R.id.et_scr); //血清肌酐
        et_bun = (FuEditText) mFuView.findViewById(R.id.et_bun); //血尿素氮
        ll_ydfmw = (LinearLayout) mFuView.findViewById(R.id.ll_ydfmw); //阴道分泌物
        ll_wvdCleanCode = (LinearLayout) mFuView.findViewById(R.id.ll_wvdCleanCode); //阴道清洁度
        et_hbsagTestResultCode = (FuEditText) mFuView.findViewById(R.id.et_hbsagTestResultCode); //乙型肝炎表面抗原
        et_hbsabTestResultCode = (FuEditText) mFuView.findViewById(R.id.et_hbsabTestResultCode); //乙型肝炎表面抗体
        et_hbeagTestResultCode = (FuEditText) mFuView.findViewById(R.id.et_hbeagTestResultCode); //乙型肝炎表面e抗原
        et_hbeabTestResultCode = (FuEditText) mFuView.findViewById(R.id.et_hbeabTestResultCode); //乙型肝炎表面e抗体
        et_hbcabTestResultCode = (FuEditText) mFuView.findViewById(R.id.et_hbcabTestResultCode); //乙型肝炎核心抗体
        ll_stsResultCode = (LinearLayout) mFuView.findViewById(R.id.ll_stsResultCode); //梅毒血清学实验
        ll_hivAntiResultCode = (LinearLayout) mFuView.findViewById(R.id.ll_hivAntiResultCode); //HIV抗体检测
        et_bscanResultDesc = (FuEditText) mFuView.findViewById(R.id.et_bscanResultDesc); //B超
        et_examOthers = (FuEditText) mFuView.findViewById(R.id.et_examOthers); //其他
        ll_pregHealthAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_pregHealthAbnormCode); //总体评估
        ll_bjzd = (LinearLayout) mFuView.findViewById(R.id.ll_bjzd); //保健指导
        ll_referralCode = (LinearLayout) mFuView.findViewById(R.id.ll_referralCode); //是否转诊
        et_referralReason = (FuEditText) mFuView.findViewById(R.id.et_referralReason); //转诊原因
        et_refertoDeptName = (FuEditText) mFuView.findViewById(R.id.et_refertoDeptName); //机构及科室
        tv_nextFollowupDate = (FuTextView) mFuView.findViewById(R.id.tv_nextFollowupDate); //下次访问日期
        tv_nextFollowupDate.setOnClickListener(this);
        sp_followupDoctorName = (Spinner) mFuView.findViewById(R.id.sp_followupDoctorName); //随访医生签名

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
}
