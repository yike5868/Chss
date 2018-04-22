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
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.disability.DisabilityIntelligence;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuDisabilityIntelligenceFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuCheckBox;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Date: 2017/03/30
 * Time: 11:00
 * progject: Chss
 * Describe： 智力残疾随访
 */

public class FuDisabilityIntelligenceView extends FuUiFrameModel implements View.OnClickListener {

    FuTextView tv_name;//姓名
    FuTextView tv_sex;//性别
    FuTextView tv_birthDate;//出生日期
    FuTextView tv_telNo;//联系电话
    FuTextView tv_idNo;//身份证号
    FuTextView tv_houseAdress;//家庭住址
    LinearLayout ll_hunyin;//婚姻状况
    FuTextView tv_disabilityIntelligenceDate;//致残时间
    FuEditText et_disabilityIntelligenceNo;//残疾证号
    LinearLayout ll_disabilityReasonCode;//致残原因
    LinearLayout ll_disabilityGrade;//致残程度
    LinearLayout ll_durationTimeCode;//持续时间
    LinearLayout ll_qitacanji;//其他伴随残疾
    LinearLayout ll_selfCareAssessCode;//个人自理
    FuEditText et_guardianName;//监护人姓名
    FuEditText et_guardianTelNo;//联系电话
    FuCheckBox cb_educationBlindCode;//盲校
    FuEditText et_educationBlindValue;//年级
    FuCheckBox cb_educationDeafCode;//聋校
    FuEditText et_educationDeafValue;//年级
    FuCheckBox cb_educationOtherCode;//其他特殊学校
    FuEditText et_educationOtherValue;//年级
    LinearLayout ll_employmentCode;//就业状况
    FuEditText et_workUnit;//工作单位
    FuEditText et_workUnitTel;//电话
    LinearLayout ll_shourulaiyuan;//收入来源
    LinearLayout ll_averageIncome;//平均收入
    LinearLayout ll_laborAbility;//劳动能力
    LinearLayout ll_laborSkill;//劳动技能
    LinearLayout ll_nenglilaiyuan;//能力来源
    LinearLayout ll_iq;//智商
    FuEditText et_symptom;//症状表现
    FuEditText et_rehabilitation;//康复治疗情况
    FuEditText et_rehabilitationNeeds;//康复需求
    FuTextView tv_followupDate;//本次随访日期
    Spinner sp_followupDoctorId;//随访医生
    FuTextView tv_nextFollowupDate;//下次随访日期

    TextView fu_title_center;
    Button fu_title_right_btn;

    List<Emp> empList;//随访医生

    public FuDisabilityIntelligenceView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_disability_intelligence_view, null);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_followupDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_nextFollowupDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.tv_disabilityIntelligenceDate:
                ((FuContentActivity) mContext).showTimeDialog(((TextView) v))
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuDisabilityIntelligenceFragment.EVENT_SAVE_DISABILITY_INTELLIGENCE, null);
                break;
        }
    }


    @Override
    protected void initFuData() {

        initCheckBoxSimple("MARRIAGESTATUS", ll_hunyin, 5);// 婚姻
        setRadioOrCheckBoxEnabel(ll_hunyin);
        initCheckBoxSimple("disabilityReasonCode", ll_disabilityReasonCode, 3, false, true);//致残原因
        initCheckBoxSimple("disabilityGrade", ll_disabilityGrade, 3);//致残程度
        initCheckBoxSimple("durationTimeCode", ll_durationTimeCode, 3);//持续时间
        initCheckBoxMany("disabilityIntelOthers", ll_qitacanji, 4);//其他伴随残疾
        initCheckBoxSimple("hearing.selfCareAssessCode", ll_selfCareAssessCode, 3);//个人自理
        initCheckBoxSimple("employmentCode", ll_employmentCode, 4, false, true);//就业状况
        initCheckBoxMany("disabilityIncome", ll_shourulaiyuan, 3, false, true);//收入来源
        initCheckBoxSimple("averageIncome", ll_averageIncome, 3);//平均收入
        initCheckBoxSimple("laborAbility", ll_laborAbility, 4);//劳动能力
        initCheckBoxSimple("laborSkill", ll_laborSkill, 4);//劳动技能
        initCheckBoxMany("disabilitySkill", ll_nenglilaiyuan, 3, false, true);//能力来源
        initCheckBoxSimple("iq", ll_iq, 3);//智商

        empList = sqlHelper.getEmpDao().queryBuilder().list();
        ArrayAdapter adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_followupDoctorId.setAdapter(adapter);

    }

    public void setData(PersonInfo personInfo) {
        tv_name.setText(personInfo.getName());//姓名
        tv_sex.setText(personInfo.getSexValue());//性别
        tv_birthDate.setText(personInfo.getBirthday());//出生日期
        tv_idNo.setText(personInfo.getIdNo());//身份证号
        setCheckBoxSelect(personInfo.getMarriageCode(), ll_hunyin);//婚姻状况
        tv_houseAdress.setText(personInfo.getAddress());//家庭住址
        tv_telNo.setText(personInfo.getTelNo());//联系电话

    }

    public boolean saveData(DisabilityIntelligence disabilityIntelligence) {

        if ("".equals(tv_disabilityIntelligenceDate.getText())) {
            ToastUtil.showToast(mContext, "请输入致残时间", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(tv_followupDate.getText())) {
            ToastUtil.showToast(mContext, "请输入本次时间", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(tv_nextFollowupDate.getText())) {
            ToastUtil.showToast(mContext, "请输入下次时间", Toast.LENGTH_LONG);
            return false;
        }

        disabilityIntelligence.setDisabilityIntelligenceDate(tv_disabilityIntelligenceDate.getDate());//致残时间
        disabilityIntelligence.setDisabilityIntelligenceNo(et_disabilityIntelligenceNo.getString());//残疾证号
        disabilityIntelligence.setDisabilityReasonCode(getCheckBoxSimpleCode(ll_disabilityReasonCode));//致残原因
        disabilityIntelligence.setDisabilityReasonValue(getString(ll_disabilityReasonCode));
        disabilityIntelligence.setDisabilityGrade(getCheckBoxSimpleCode(ll_disabilityGrade));//致残程度
        disabilityIntelligence.setDurationTimeCode(getCheckBoxSimpleCode(ll_durationTimeCode));//持续时间
        saveCheckBoxMany(null, disabilityIntelligence.getRecordChoice(), ll_qitacanji);//其他伴随残疾
        disabilityIntelligence.setSelfCareAssessCode(getCheckBoxSimpleCode(ll_selfCareAssessCode));//个人自理
        disabilityIntelligence.setGuardianName(et_guardianName.getString());//监护人姓名
        disabilityIntelligence.setGuardianTelNo(et_guardianTelNo.getString());//联系电话
        if (cb_educationBlindCode.isChecked()) {
            disabilityIntelligence.setEducationBlindCode("1");//盲校
            disabilityIntelligence.setEducationBlindValue(et_educationBlindValue.getString());//年级
        }
        if (cb_educationDeafCode.isChecked()) {
            disabilityIntelligence.setEducationDeafCode("1");//聋校
            disabilityIntelligence.setEducationDeafValue(et_educationDeafValue.getString());//年级
        }
        if (cb_educationOtherCode.isChecked()) {
            disabilityIntelligence.setEducationOtherCode("1");//其他特殊学校
            disabilityIntelligence.setEducationOtherValue(et_educationOtherValue.getString());//年级
        }
        disabilityIntelligence.setEmploymentCode(getCheckBoxSimpleCode(ll_employmentCode));//就业状况
        disabilityIntelligence.setEmploymentValue(getString(ll_employmentCode));
        disabilityIntelligence.setWorkUnit(et_workUnit.getString());//工作单位
        disabilityIntelligence.setWorkUnitTel(et_workUnitTel.getString());//电话
        saveCheckBoxMany(null, disabilityIntelligence.getRecordChoice(), ll_shourulaiyuan);//收入来源
        disabilityIntelligence.setAverageIncome(getCheckBoxSimpleCode(ll_averageIncome));//平均收入
        disabilityIntelligence.setLaborAbility(getCheckBoxSimpleCode(ll_laborAbility));//劳动能力
        disabilityIntelligence.setLaborSkill(getCheckBoxSimpleCode(ll_laborSkill));//劳动技能
        saveCheckBoxMany(null, disabilityIntelligence.getRecordChoice(), ll_nenglilaiyuan);//能力来源
        disabilityIntelligence.setIq(getCheckBoxSimpleCode(ll_iq));//智商
        disabilityIntelligence.setSymptom(et_symptom.getString());//症状表现
        disabilityIntelligence.setRehabilitation(et_rehabilitation.getString());//康复治疗情况
        disabilityIntelligence.setRehabilitationNeeds(et_rehabilitationNeeds.getString());//康复需求
        disabilityIntelligence.setCreateTime(tv_followupDate.getDate());//本次随访日期  服务端有问题
        disabilityIntelligence.setFollowupDate(tv_followupDate.getDate());//本次随访日期
        Emp emp = (Emp) sp_followupDoctorId.getSelectedItem();
        disabilityIntelligence.setFollowupDoctorId(emp.getEmp_id());
        disabilityIntelligence.setFollowupDoctorName(emp.getEmp_name());//医生
        disabilityIntelligence.setNextFollowupDate(tv_nextFollowupDate.getDate());//下次随访日期

        return true;
    }

    @Override
    protected void initWidget() {

        findView();

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("智力残疾人随访");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    private void findView() {

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name);//姓名
        tv_sex = (FuTextView) mFuView.findViewById(R.id.tv_sex);//性别
        tv_birthDate = (FuTextView) mFuView.findViewById(R.id.tv_birthDate);//出生日期
        tv_telNo = (FuTextView) mFuView.findViewById(R.id.tv_telNo);//联系电话
        tv_idNo = (FuTextView) mFuView.findViewById(R.id.tv_idNo);//身份证号
        tv_houseAdress = (FuTextView) mFuView.findViewById(R.id.tv_houseAdress);//家庭住址
        ll_hunyin = (LinearLayout) mFuView.findViewById(R.id.ll_hunyin);//婚姻状况
        tv_disabilityIntelligenceDate = (FuTextView) mFuView.findViewById(R.id.tv_disabilityIntelligenceDate);//致残时间
        tv_disabilityIntelligenceDate.setOnClickListener(this);
        et_disabilityIntelligenceNo = (FuEditText) mFuView.findViewById(R.id.et_disabilityIntelligenceNo);//残疾证号
        ll_disabilityReasonCode = (LinearLayout) mFuView.findViewById(R.id.ll_disabilityReasonCode);//致残原因
        ll_disabilityGrade = (LinearLayout) mFuView.findViewById(R.id.ll_disabilityGrade);//致残程度
        ll_durationTimeCode = (LinearLayout) mFuView.findViewById(R.id.ll_durationTimeCode);//持续时间
        ll_qitacanji = (LinearLayout) mFuView.findViewById(R.id.ll_qitacanji);//其他伴随残疾
        ll_selfCareAssessCode = (LinearLayout) mFuView.findViewById(R.id.ll_selfCareAssessCode);//个人自理
        et_guardianName = (FuEditText) mFuView.findViewById(R.id.et_guardianName);//监护人姓名
        et_guardianTelNo = (FuEditText) mFuView.findViewById(R.id.et_guardianTelNo);//联系电话
        cb_educationBlindCode = (FuCheckBox) mFuView.findViewById(R.id.cb_educationBlindCode);//盲校
        et_educationBlindValue = (FuEditText) mFuView.findViewById(R.id.et_educationBlindValue);//年级
        cb_educationDeafCode = (FuCheckBox) mFuView.findViewById(R.id.cb_educationDeafCode);//聋校
        et_educationDeafValue = (FuEditText) mFuView.findViewById(R.id.et_educationDeafValue);//年级
        cb_educationOtherCode = (FuCheckBox) mFuView.findViewById(R.id.cb_educationOtherCode);//其他特殊学校
        et_educationOtherValue = (FuEditText) mFuView.findViewById(R.id.et_educationOtherValue);//年级
        ll_employmentCode = (LinearLayout) mFuView.findViewById(R.id.ll_employmentCode);//就业状况
        et_workUnit = (FuEditText) mFuView.findViewById(R.id.et_workUnit);//工作单位
        et_workUnitTel = (FuEditText) mFuView.findViewById(R.id.et_workUnitTel);//电话
        ll_shourulaiyuan = (LinearLayout) mFuView.findViewById(R.id.ll_shourulaiyuan);//收入来源
        ll_averageIncome = (LinearLayout) mFuView.findViewById(R.id.ll_averageIncome);//平均收入
        ll_laborAbility = (LinearLayout) mFuView.findViewById(R.id.ll_laborAbility);//劳动能力
        ll_laborSkill = (LinearLayout) mFuView.findViewById(R.id.ll_laborSkill);//劳动技能
        ll_nenglilaiyuan = (LinearLayout) mFuView.findViewById(R.id.ll_nenglilaiyuan);//能力来源
        ll_iq = (LinearLayout) mFuView.findViewById(R.id.ll_iq);//智商
        et_symptom = (FuEditText) mFuView.findViewById(R.id.et_symptom);//症状表现
        et_rehabilitation = (FuEditText) mFuView.findViewById(R.id.et_rehabilitation);//康复治疗情况
        et_rehabilitationNeeds = (FuEditText) mFuView.findViewById(R.id.et_rehabilitationNeeds);//康复需求
        tv_followupDate = (FuTextView) mFuView.findViewById(R.id.tv_followupDate);//本次随访日期
        tv_followupDate.setOnClickListener(this);
        sp_followupDoctorId = (Spinner) mFuView.findViewById(R.id.sp_followupDoctorId);//随访医生
        tv_nextFollowupDate = (FuTextView) mFuView.findViewById(R.id.tv_nextFollowupDate);//下次随访日期
        tv_nextFollowupDate.setOnClickListener(this);

    }
}
