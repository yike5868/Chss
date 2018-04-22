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
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.Term;
import net.greatsoft.main.db.po.child.ChildHomeVisit;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuChildHomeVisitFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuCheckBox;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhanglin on 2016/12/12.
 * 新生儿访视
 */

public class FuChildHomeVisitView extends FuUiFrameModel implements View.OnClickListener {

    FuTextView tv_newbornName; //姓名
    LinearLayout ll_newbornSexCode; //性别
    FuEditText et_newbornBirthDate; //出生日期
    FuEditText et_newbornIdNo; //身份证号
    FuEditText et_presentAddrProvince; //家庭地址
    FuEditText et_fatherName; //父亲姓名
    Spinner sp_fatherOccupCode; //职业
    FuEditText et_fatherTelNo; //联系电话
    FuEditText et_fatherBirthDate; //出生日期
    FuEditText et_motherName; //母亲姓名
    Spinner sp_motherOccupCode; //职业
    FuEditText et_motherTelNo; //联系电话
    FuEditText et_motherBirthDate; //出生日期
    FuEditText et_birthGestWeeks; //出生孕期周
    FuEditText et_birthGestDays; //出生孕期天
    LinearLayout ll_motherHdcpCode; //母亲妊娠期患病情况
    FuEditText et_deliveryOrgName; //助产机构名称
    LinearLayout ll_lastDeliverWayCode; //出生情况
    LinearLayout ll_asphyxiaCode; //新生儿窒息
    LinearLayout ll_malformCode; //畸形
//    LinearLayout ll_apgarScore; //Apgan评分 页面，保存错误，写死

    FuEditText et_1_min;//评分1分钟
    FuEditText et_5_min;//评分5分钟
    FuCheckBox cb_no;//评分不详

    LinearLayout ll_hearingScreenCode; //新生儿听力筛查
    LinearLayout ll_diseaseScreenCode; //新生儿疾病筛查
    FuEditText et_birthWeight; //新生儿出生体重
    FuEditText et_weight; //目前体重
    FuEditText et_birthLength; //出生身长
    LinearLayout ll_feedWayCode; //喂养方式
    FuEditText et_feedingAmountEachTime; //吃奶量ml/次
    FuEditText et_dailyFeedingTimes; //吃奶次数
    LinearLayout ll_vomitCode; //呕吐
    LinearLayout ll_stoolPropCode; //大便
    FuEditText et_stoolTimes; //大便次数
    FuEditText et_bodyTemperature; //体温
    FuEditText et_pulses; //脉率
    FuEditText et_breathingRate; //呼吸频率
    LinearLayout ll_newbornComplexionCode; //面色
    LinearLayout ll_jaundiceSiteCode; //黄疸部位
    FuEditText et_bregmaHorizDiameter; //前卤
    FuEditText et_bregmaVertDiameter; //前卤
    LinearLayout ll_bregmaTensionCode; //前卤
    LinearLayout ll_limbsAbnormCode; //四肢活动度
    LinearLayout ll_eyeAbnormCode; //眼外观
    LinearLayout ll_earAbnormCode; //耳外观
    LinearLayout ll_neckMassCode; //颈部包块
    LinearLayout ll_noseAbnormCode; //鼻
    LinearLayout ll_skinCode; //皮肤
    LinearLayout ll_oralAbnormCode; //口腔
    LinearLayout ll_anusCode; //肛门
    LinearLayout ll_heartAbnormCode; //心肺听诊
    LinearLayout ll_genitaliaCode; //外生殖器
    LinearLayout ll_abdomenAbnormCode; //腹部触诊
    LinearLayout ll_spineAbnormCode; //脊柱
    LinearLayout ll_chestCode; //胸部
    LinearLayout ll_umbCordResultCode; //脐带
    LinearLayout ll_referralCode; //转诊建议
    FuEditText et_referralReason; //原因
    FuEditText et_refertoOrgName; //机构及科室
    LinearLayout ll_zhidao; //指导
    FuEditText et_thisVisitDate; //本次访视日期
    FuEditText et_nextVisitPlace; //下次随访地点
    FuEditText et_nextVisitDate; //下次访视日期
    Spinner sp_visitDoctorName; //随访医生签名

    Date birthday;


    public FuChildHomeVisitView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_child_home_visit_view, null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuChildHomeVisitFragment.EVENT_SAVE_CHILD_HOME_VISIT, null);
                break;
//            case R.id.et_newbornBirthDate:
//                ((FuParentActivity) mContext).showTimeDialog(((TextView) v))
//                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
//                break;
            case R.id.et_fatherBirthDate:
                ((FuParentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.et_motherBirthDate:
                ((FuParentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.et_thisVisitDate:
                ((FuParentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.et_nextVisitDate:
                ((FuParentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
        }
    }

    public void setData(ChildHomeVisit childHomeVisit, PersonInfo personInfo) {
        tv_newbornName.setText(childHomeVisit.getNewbornName());
        setCheckBoxSelect(personInfo.getSexCode(), ll_newbornSexCode);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        et_newbornBirthDate.setText(simpleDateFormat.format(personInfo.getBirthday()));
        birthday = personInfo.getBirthday();
        et_presentAddrProvince.setText(personInfo.getAddress());
        et_newbornIdNo.setText(personInfo.getIdNo());

    }

    public boolean saveData(ChildHomeVisit childHomeVisit) {
//         tv_newbornName; //姓名
        if ("".equals(et_motherName.getString())) {
            ToastUtil.showToast(mContext, "请输入母亲姓名", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_birthGestWeeks.getString()) || "".equals(et_birthGestDays.getString())) {
            ToastUtil.showToast(mContext, "请输入出生孕周", Toast.LENGTH_LONG);
            return false;
        }
        //母亲妊娠期患病情况
        saveCheckBoxMany(null, childHomeVisit.getRecordChoice(), ll_motherHdcpCode);
        boolean flag = true;
        List<RecordChoice> choice = childHomeVisit.getRecordChoice();//母亲妊娠期患病情况
        for (int i = 0; i < choice.size(); i++) {
            if ("pregnantDisease".equals(choice.get(i).getCodeType())) {
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择母亲妊娠期患病情况", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_deliveryOrgName.getString())) {
            ToastUtil.showToast(mContext, "请输入助产机构医院", Toast.LENGTH_LONG);
            return false;
        }
        saveCheckBoxMany(null, childHomeVisit.getRecordChoice(), ll_lastDeliverWayCode); //出生情况
        flag = true;
        choice = childHomeVisit.getRecordChoice();//出生情况
        for (int i = 0; i < choice.size(); i++) {
            if ("bornStatus".equals(choice.get(i).getCodeType())) {
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择出生情况", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_asphyxiaCode))) {
            ToastUtil.showToast(mContext, "请选择新生儿窒息", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_malformCode))) {
            ToastUtil.showToast(mContext, "请选择畸形", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_birthWeight.getString())) {
            ToastUtil.showToast(mContext, "请输入新生儿出生体重", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_birthLength.getString())) {
            ToastUtil.showToast(mContext, "请输入新生儿出生身长", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_feedWayCode))) {
            ToastUtil.showToast(mContext, "请选择喂养方式", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_bodyTemperature.getString())) {
            ToastUtil.showToast(mContext, "请输入新生儿体温", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_pulses.getString())) {
            ToastUtil.showToast(mContext, "请输入新生儿脉率", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_breathingRate.getString())) {
            ToastUtil.showToast(mContext, "请输入新生儿呼吸频率", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_newbornComplexionCode))) {
            ToastUtil.showToast(mContext, "请选择面色", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_bregmaTensionCode)) || "".equals(et_bregmaHorizDiameter.getString()) ||
                "".equals(et_bregmaVertDiameter.getString())) {
            ToastUtil.showToast(mContext, "请填选前卤", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_thisVisitDate.getString())) {
            ToastUtil.showToast(mContext, "请选择本次随访日期", Toast.LENGTH_LONG);
            return false;
        }

        childHomeVisit.setNewbornSexCode(getCheckBoxSimpleCode(ll_newbornSexCode)); //性别
        childHomeVisit.setNewbornBirthDate(birthday); //出生日期
        childHomeVisit.setNewbornIdNo(et_newbornIdNo.getString()); //身份证号
        childHomeVisit.setPresentAddrProvince(et_presentAddrProvince.getString()); //家庭地址
        childHomeVisit.setFatherName(et_fatherName.getString()); //父亲姓名
        Term term = (Term) sp_fatherOccupCode.getSelectedItem();//职业
        childHomeVisit.setFatherOccupCode(term.getTerm_code());
        childHomeVisit.setFatherTelNo(et_fatherTelNo.getString()); //联系电话
        childHomeVisit.setFatherBirthDate(et_fatherBirthDate.getDate()); //出生日期
        childHomeVisit.setMotherName(et_motherName.getString()); //母亲姓名
        term = (Term) sp_motherOccupCode.getSelectedItem();
        childHomeVisit.setMotherOccupCode(term.getTerm_code()); //母亲职业
        childHomeVisit.setMotherTelNo(et_motherTelNo.getString()); //联系电话
        childHomeVisit.setMotherBirthDate(et_motherBirthDate.getDate()); //出生日期
        childHomeVisit.setBirthGestWeeks(et_birthGestWeeks.getInt()); //出生孕期周
        childHomeVisit.setBirthGestDays(et_birthGestDays.getInt()); //出生孕期天

        childHomeVisit.setDeliveryOrgName(et_deliveryOrgName.getString()); //助产机构名称

        childHomeVisit.setAsphyxiaCode(getCheckBoxSimpleCode(ll_asphyxiaCode)); //新生儿窒息

        childHomeVisit.setMalformCode(getCheckBoxSimpleCode(ll_malformCode)); //畸形
        childHomeVisit.setMalformDesc(getString(ll_malformCode));


        childHomeVisit.setApgarScore1(et_1_min.getInt());//Apgan评分
        childHomeVisit.setApgarScore5(et_5_min.getInt());
        childHomeVisit.setApgarScoreCode(cb_no.isChecked() ? "1" : "0");

        childHomeVisit.setHearingScreenCode(getCheckBoxSimpleCode(ll_hearingScreenCode)); //新生儿听力筛查
        saveCheckBoxMany(null, childHomeVisit.getRecordChoice(), ll_diseaseScreenCode);//新生儿疾病筛查
        childHomeVisit.setBirthWeight(et_birthWeight.getDouble()); //新生儿出生体重
        childHomeVisit.setWeight(et_weight.getDouble()); //目前体重
        childHomeVisit.setBirthLength(et_birthLength.getDouble()); //出生身长
        childHomeVisit.setFeedWayCode(getCheckBoxSimpleCode(ll_feedWayCode)); //喂养方式
        childHomeVisit.setFeedingAmountEachTime(et_feedingAmountEachTime.getInt()); //吃奶量ml/次
        childHomeVisit.setDailyFeedingTimes(et_dailyFeedingTimes.getString()); //吃奶次数
        childHomeVisit.setVomitCode(getCheckBoxSimpleCode(ll_vomitCode)); //呕吐
        childHomeVisit.setStoolPropCode(getCheckBoxSimpleCode(ll_stoolPropCode)); //大便
        childHomeVisit.setStoolTimes(et_stoolTimes.getString()); //大便次数
        childHomeVisit.setBodyTemperature(et_bodyTemperature.getDouble()); //体温
        childHomeVisit.setPulses(et_pulses.getInt()); //脉率
        childHomeVisit.setBreathingRate(et_breathingRate.getInt()); //呼吸频率
        childHomeVisit.setNewbornComplexionCode(getCheckBoxSimpleCode(ll_newbornComplexionCode)); //面色
        childHomeVisit.setNewbornComplexionOthersDesc(getString(ll_newbornComplexionCode));
//        childHomeVisit.setJaundiceSiteCode(getCheckBoxSimpleCode(ll_jaundiceSiteCode)); //黄疸部位
        saveCheckBoxMany(null, childHomeVisit.getRecordChoice(), ll_jaundiceSiteCode);//黄疸部位
        childHomeVisit.setBregmaHorizDiameter(et_bregmaHorizDiameter.getDouble()); //前卤
        childHomeVisit.setBregmaVertDiameter(et_bregmaVertDiameter.getDouble()); //前卤
        childHomeVisit.setBregmaTensionCode(getCheckBoxSimpleCode(ll_bregmaTensionCode)); //前卤
        childHomeVisit.setBregmaTensionOthersDesc(getString(ll_bregmaTensionCode));

        childHomeVisit.setLimbsAbnormCode(getCheckBoxSimpleCode(ll_limbsAbnormCode)); //四肢活动度
        childHomeVisit.setLimbsAbnormDesc(getString(ll_limbsAbnormCode));
        childHomeVisit.setEyeAbnormCode(getCheckBoxSimpleCode(ll_eyeAbnormCode)); //眼外观
        childHomeVisit.setEyeAbnormDesc(getString(ll_eyeAbnormCode));
        childHomeVisit.setEarAbnormCode(getCheckBoxSimpleCode(ll_earAbnormCode)); //耳外观
        childHomeVisit.setEarAbnormDesc(getString(ll_earAbnormCode));
        childHomeVisit.setNeckMassCode(getCheckBoxSimpleCode(ll_neckMassCode)); //颈部包块
        childHomeVisit.setNeckMassDesc(getString(ll_neckMassCode));
        childHomeVisit.setNoseAbnormCode(getCheckBoxSimpleCode(ll_noseAbnormCode)); //鼻
        childHomeVisit.setNoseAbnormDesc(getString(ll_noseAbnormCode));
        childHomeVisit.setSkinCode(getCheckBoxSimpleCode(ll_skinCode)); //皮肤
        childHomeVisit.setSkinOthersDesc(getString(ll_skinCode));
        childHomeVisit.setOralAbnormCode(getCheckBoxSimpleCode(ll_oralAbnormCode)); //口腔
        childHomeVisit.setOralAbnormDesc(getString(ll_oralAbnormCode));
        childHomeVisit.setAnusCode(getCheckBoxSimpleCode(ll_anusCode)); //肛门
        childHomeVisit.setAnusAbnormDesc(getString(ll_anusCode));
        childHomeVisit.setHeartAbnormCode(getCheckBoxSimpleCode(ll_heartAbnormCode)); //心肺听诊
        childHomeVisit.setHeartAbnormDesc(getString(ll_heartAbnormCode));
        childHomeVisit.setGenitaliaCode(getCheckBoxSimpleCode(ll_genitaliaCode)); //外生殖器
        childHomeVisit.setGenitaliaAbnormDesc(getString(ll_genitaliaCode));
        childHomeVisit.setAbdomenAbnormCode(getCheckBoxSimpleCode(ll_abdomenAbnormCode)); //腹部触诊
        childHomeVisit.setAbdomenAbnormDesc(getString(ll_abdomenAbnormCode));
        childHomeVisit.setSpineAbnormCode(getCheckBoxSimpleCode(ll_spineAbnormCode)); //脊柱
        childHomeVisit.setSpineAbnormDesc(getString(ll_spineAbnormCode));
        childHomeVisit.setChestCode(getCheckBoxSimpleCode(ll_chestCode));//胸部
        childHomeVisit.setChestAbnormDesc(getString(ll_chestCode));
        childHomeVisit.setUmbCordResultCode(getCheckBoxSimpleCode(ll_umbCordResultCode)); //脐带
        childHomeVisit.setUmbCordOthersDesc(getString(ll_umbCordResultCode));
        childHomeVisit.setReferralCode(getCheckBoxSimpleCode(ll_referralCode)); //转诊建议
        childHomeVisit.setReferralReason(et_referralReason.getString()); //原因
        childHomeVisit.setRefertoDeptName(et_refertoOrgName.getString()); //机构及科室
        saveCheckBoxMany(null, childHomeVisit.getRecordChoice(), ll_zhidao);//指导

        childHomeVisit.setThisVisitDate(et_thisVisitDate.getDate()); //本次访视日期
        childHomeVisit.setNextVisitPlace(et_nextVisitPlace.getString()); //下次随访地点
        childHomeVisit.setNextVisitDate(et_nextVisitDate.getDate()); //下次访视日期
        Emp emp = (Emp) sp_visitDoctorName.getSelectedItem(); //随访医生签名
        childHomeVisit.setVisitDoctorId(emp.getEmp_id());
        childHomeVisit.setVisitDoctorName(emp.getEmp_name());

        return true;
    }


    @Override
    protected void initFuData() {


        ArrayAdapter adapter;
        List<Term> termList = sqlHelper.getProfession();
        adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                termList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_fatherOccupCode.setAdapter(adapter);
        sp_motherOccupCode.setAdapter(adapter);


        List<Emp> empList = sqlHelper.getDoctors();

        adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_visitDoctorName.setAdapter(adapter);

        //性别
        initCheckBoxSimple("CV9500.48", ll_newbornSexCode, 0);
        // 母亲妊娠期患病情况
        initCheckBoxMany("pregnantDisease", ll_motherHdcpCode, 3, true, true);
        // 出生情况
        initCheckBoxMany("bornStatus", ll_lastDeliverWayCode, 4, true, true);
        // 新生儿窒息
        initCheckBoxSimple("YES_NO_CODE", ll_asphyxiaCode, false);
        // Apgar评分
//        initCheckBoxSimple("NEWBORN_APGAR", ll_apgarScore, true);
        // 是否有畸形
        initCheckBoxSimple("YES_NO_CODE", ll_malformCode, true);
        // 新生儿听力筛查
        initCheckBoxSimple("AUDITION_FILTER", ll_hearingScreenCode, false);
        // 新生儿疾病筛查其他
        initCheckBoxMany("childHomeDisease", ll_diseaseScreenCode, 2, true, true);

        // 喂养方式
        initCheckBoxSimple("FEEDWAY", ll_feedWayCode, false);
        // 呕吐
        initCheckBoxSimple("YES_NO_CODE", ll_vomitCode, false);
        // 大便
        initCheckBoxSimple("DEFCATE", ll_stoolPropCode, false);
        // 面色
        initCheckBoxSimple("childComplexionCode", ll_newbornComplexionCode, true);
        // 黄疸部位
        initCheckBoxMany("jaundicePosition", ll_jaundiceSiteCode, 5);

        // 前囟其他
        initCheckBoxSimple("BREGMA_CLOSE1", ll_bregmaTensionCode, 4, true, true);
        // 眼外观
        initCheckBoxSimple("EXCEPTION_CODE", ll_eyeAbnormCode, 2, true, true);
        // 颈部包块
        initCheckBoxSimple("YES_NO_CODE", ll_neckMassCode, 2, true, true);
        // 四肢活动度
        initCheckBoxSimple("EXCEPTION_CODE", ll_limbsAbnormCode, 2, true, true);
        // 耳外观
        initCheckBoxSimple("EXCEPTION_CODE", ll_earAbnormCode, 2, true, true);
        // 鼻
        initCheckBoxSimple("EXCEPTION_CODE", ll_noseAbnormCode, true);
        // 皮肤
        initCheckBoxSimple("SKIN_STATUS", ll_skinCode, true);
        // 口腔
        initCheckBoxSimple("EXCEPTION_CODE", ll_oralAbnormCode, true);
        // 肛门
        initCheckBoxSimple("EXCEPTION_CODE", ll_anusCode, true);
        // 心肺听诊
        initCheckBoxSimple("EXCEPTION_CODE", ll_heartAbnormCode, true);
        // 外生殖器
        initCheckBoxSimple("EXCEPTION_CODE", ll_genitaliaCode, true);
        // 腹部触诊
        initCheckBoxSimple("EXCEPTION_CODE", ll_abdomenAbnormCode, true);
        // 脊柱
        initCheckBoxSimple("EXCEPTION_CODE", ll_spineAbnormCode, true);
        //胸部
        initCheckBoxSimple("EXCEPTION_CODE", ll_chestCode, true);
        // 脐带
        initCheckBoxSimple("UMBILICAL", ll_umbCordResultCode, true);
        // 转诊建议
        initCheckBoxSimple("YES_NO_CODE", ll_referralCode, false);
        // 指导
        initCheckBoxMany("childHomeGuide", ll_zhidao, 2, false, true);

    }

    @Override
    protected void initWidget() {

        findView();
        FuTextView fu_title_center = (FuTextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("新生儿家庭访视");
        fu_title_center.setVisibility(View.VISIBLE);
        FuButton fu_title_right_btn = (FuButton) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);
    }

    private void findView() {

        tv_newbornName = (FuTextView) mFuView.findViewById(R.id.tv_newbornName); //姓名
        ll_newbornSexCode = (LinearLayout) mFuView.findViewById(R.id.ll_newbornSexCode); //性别
        et_newbornIdNo = (FuEditText) mFuView.findViewById(R.id.et_newbornIdNo); //身份证号
        et_newbornBirthDate = (FuEditText) mFuView.findViewById(R.id.et_newbornBirthDate); //出生日期
//        et_newbornBirthDate.setOnClickListener(this);
        et_presentAddrProvince = (FuEditText) mFuView.findViewById(R.id.et_presentAddrProvince); //家庭地址
        et_fatherName = (FuEditText) mFuView.findViewById(R.id.et_fatherName); //父亲姓名
        sp_fatherOccupCode = (Spinner) mFuView.findViewById(R.id.sp_fatherOccupCode); //职业
        et_fatherTelNo = (FuEditText) mFuView.findViewById(R.id.et_fatherTelNo); //联系电话
        et_fatherBirthDate = (FuEditText) mFuView.findViewById(R.id.et_fatherBirthDate); //出生日期
        et_fatherBirthDate.setOnClickListener(this);
        et_motherName = (FuEditText) mFuView.findViewById(R.id.et_motherName); //母亲姓名
        sp_motherOccupCode = (Spinner) mFuView.findViewById(R.id.sp_motherOccupCode); //职业
        et_motherTelNo = (FuEditText) mFuView.findViewById(R.id.et_motherTelNo); //联系电话
        et_motherBirthDate = (FuEditText) mFuView.findViewById(R.id.et_motherBirthDate); //出生日期
        et_motherBirthDate.setOnClickListener(this);
        et_birthGestWeeks = (FuEditText) mFuView.findViewById(R.id.et_birthGestWeeks); //出生孕期周
        et_birthGestDays = (FuEditText) mFuView.findViewById(R.id.et_birthGestDays); //出生孕期天
        ll_motherHdcpCode = (LinearLayout) mFuView.findViewById(R.id.ll_motherHdcpCode); //母亲妊娠期患病情况
        et_deliveryOrgName = (FuEditText) mFuView.findViewById(R.id.et_deliveryOrgName); //助产机构名称
        ll_lastDeliverWayCode = (LinearLayout) mFuView.findViewById(R.id.ll_lastDeliverWayCode); //出生情况
        ll_asphyxiaCode = (LinearLayout) mFuView.findViewById(R.id.ll_asphyxiaCode); //新生儿窒息
        ll_malformCode = (LinearLayout) mFuView.findViewById(R.id.ll_malformCode); //畸形
//        ll_apgarScore = (LinearLayout) mFuView.findViewById(R.id.ll_apgarScore); //Apgan评分
        et_1_min = (FuEditText) mFuView.findViewById(R.id.et_1_min);//评分1分钟
        et_5_min = (FuEditText) mFuView.findViewById(R.id.et_5_min);//评分5分钟
        cb_no = (FuCheckBox) mFuView.findViewById(R.id.cb_no);//评分不详
        ll_hearingScreenCode = (LinearLayout) mFuView.findViewById(R.id.ll_hearingScreenCode); //新生儿听力筛查
        ll_diseaseScreenCode = (LinearLayout) mFuView.findViewById(R.id.ll_diseaseScreenCode); //新生儿疾病筛查
        et_birthWeight = (FuEditText) mFuView.findViewById(R.id.et_birthWeight); //新生儿出生体重
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight); //目前体重
        et_birthLength = (FuEditText) mFuView.findViewById(R.id.et_birthLength); //出生身长
        ll_feedWayCode = (LinearLayout) mFuView.findViewById(R.id.ll_feedWayCode); //喂养方式
        et_feedingAmountEachTime = (FuEditText) mFuView.findViewById(R.id.et_feedingAmountEachTime); //吃奶量ml/次
        et_dailyFeedingTimes = (FuEditText) mFuView.findViewById(R.id.et_dailyFeedingTimes); //吃奶次数
        ll_vomitCode = (LinearLayout) mFuView.findViewById(R.id.ll_vomitCode); //呕吐
        ll_stoolPropCode = (LinearLayout) mFuView.findViewById(R.id.ll_stoolPropCode); //大便
        et_stoolTimes = (FuEditText) mFuView.findViewById(R.id.et_stoolTimes); //大便次数
        et_bodyTemperature = (FuEditText) mFuView.findViewById(R.id.et_bodyTemperature); //体温
        et_pulses = (FuEditText) mFuView.findViewById(R.id.et_pulses); //脉率
        et_breathingRate = (FuEditText) mFuView.findViewById(R.id.et_breathingRate); //呼吸频率
        ll_newbornComplexionCode = (LinearLayout) mFuView.findViewById(R.id.ll_newbornComplexionCode); //面色
        ll_jaundiceSiteCode = (LinearLayout) mFuView.findViewById(R.id.ll_jaundiceSiteCode); //黄疸部位
        et_bregmaHorizDiameter = (FuEditText) mFuView.findViewById(R.id.et_bregmaHorizDiameter); //前卤
        et_bregmaVertDiameter = (FuEditText) mFuView.findViewById(R.id.et_bregmaVertDiameter); //前卤
        ll_bregmaTensionCode = (LinearLayout) mFuView.findViewById(R.id.ll_bregmaTensionCode); //前卤
        ll_limbsAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_limbsAbnormCode); //四肢活动度
        ll_eyeAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_eyeAbnormCode); //眼外观
        ll_earAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_earAbnormCode); //耳外观
        ll_neckMassCode = (LinearLayout) mFuView.findViewById(R.id.ll_neckMassCode); //颈部包块
        ll_noseAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_noseAbnormCode); //鼻
        ll_skinCode = (LinearLayout) mFuView.findViewById(R.id.ll_skinCode); //皮肤
        ll_oralAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_oralAbnormCode); //口腔
        ll_anusCode = (LinearLayout) mFuView.findViewById(R.id.ll_anusCode); //肛门
        ll_heartAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_heartAbnormCode); //心肺听诊
        ll_genitaliaCode = (LinearLayout) mFuView.findViewById(R.id.ll_genitaliaCode); //外生殖器
        ll_abdomenAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_abdomenAbnormCode); //腹部触诊
        ll_spineAbnormCode = (LinearLayout) mFuView.findViewById(R.id.ll_spineAbnormCode); //脊柱
        ll_chestCode = (LinearLayout) mFuView.findViewById(R.id.ll_chestCode); //胸部
        ll_umbCordResultCode = (LinearLayout) mFuView.findViewById(R.id.ll_umbCordResultCode); //脐带
        ll_referralCode = (LinearLayout) mFuView.findViewById(R.id.ll_referralCode); //转诊建议
        et_referralReason = (FuEditText) mFuView.findViewById(R.id.et_referralReason); //原因
        et_refertoOrgName = (FuEditText) mFuView.findViewById(R.id.et_refertoOrgName); //机构及科室
        ll_zhidao = (LinearLayout) mFuView.findViewById(R.id.ll_zhidao); //指导
        et_thisVisitDate = (FuEditText) mFuView.findViewById(R.id.et_thisVisitDate); //本次访视日期
        et_thisVisitDate.setOnClickListener(this);
        et_nextVisitPlace = (FuEditText) mFuView.findViewById(R.id.et_nextVisitPlace); //下次随访地点
        et_nextVisitDate = (FuEditText) mFuView.findViewById(R.id.et_nextVisitDate); //下次访视日期
        et_nextVisitDate.setOnClickListener(this);
        sp_visitDoctorName = (Spinner) mFuView.findViewById(R.id.sp_visitDoctorName); //随访医生签名

    }
}
