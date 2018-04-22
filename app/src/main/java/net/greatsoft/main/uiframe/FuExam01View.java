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
import net.greatsoft.main.activity.FuChangeActivity;
import net.greatsoft.main.activity.FuParentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.exam.HealthExam;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuRadioButton;
import net.greatsoft.main.view.FuTextView;

import java.util.List;

/**
 * Created by zhanglin on 16/8/3.
 */
public class FuExam01View extends FuUiFrameModel implements View.OnClickListener, View.OnFocusChangeListener {

    LinearLayout ll_exam_info;
    FuRadioButton rb_isBigExam_true;
    FuRadioButton rb_isBigExam_false;
    FuTextView tv_exam_info;
    FuTextView tv_name;                   //姓名
    FuTextView tv_healthExamNo;           //编号
    FuTextView tv_healthExamDate;         //体检日期
    Spinner sp_respDoctor;              //责任医生
    LinearLayout ll_exam_symptom;       //症状
    FuEditText et_bodyTemperature;        //体温
    FuEditText et_pulseRate;              //脉率
    FuEditText et_breathingRate;          //呼吸频率
    FuEditText et_lsbp;                   //左侧血压
    FuEditText et_ldbp;                   //左侧血压
    FuEditText et_rsbp;                   //右侧血压
    FuEditText et_rdbp;                   //右侧血压
    FuEditText et_height;                 //身高
    FuEditText et_weight;                 //体重
    FuEditText et_waist;                  //腰围
    FuEditText et_bmi;                    //体质指数
    LinearLayout ll_elderHealthAssess;  //老年人健康状态自我评估
    LinearLayout ll_elderSelfCareAssess;//老年人生活自理能力自我评估*
    LinearLayout ll_elderCognitionResult;//老年人认知功能
    LinearLayout ll_elderEmotionalResult;//老年人情感状态*
    LinearLayout ll_exerciseFreq;       //体育锻炼频率
    FuEditText et_exerciseDurationMins;   //每次锻炼时间
    FuEditText et_exerciseYear;           //坚持锻炼时间
    FuEditText et_exerciseWay;            //锻炼方式
    LinearLayout ll_eatingHabits;       //饮食方式
    LinearLayout ll_smokingStatus;      //吸烟情况
    FuEditText et_dailySmoking;           //日吸烟量
    FuEditText et_startSmokingAge;        //开始吸烟年龄
    FuEditText et_stopSmokingAge;         //戒烟年龄
    LinearLayout ll_drinkingFreq;       //饮酒频率
    FuEditText et_dailyDrinking;          //日饮酒量
    LinearLayout ll_stopDrinking;       //是否戒酒
    FuEditText et_stopDrinkingAge;        //戒酒年龄
    FuEditText et_startDrinkingAge;       //开始饮酒年龄
    LinearLayout ll_drunkCode;          //近一年内是否曾醉酒
    LinearLayout ll_typesOfDrinking;    //饮酒种类
    LinearLayout ll_occupExposure;      //职业病危险因素标志
    FuEditText et_occupExposureWork;      //工种
    FuEditText et_occupExposureWorkYear;  //从业时间
    FuEditText et_poisonDust;             //粉尘
    LinearLayout ll_poisonDust;         //防护措施
    FuEditText et_poisonRadiogen;         //放射物质
    LinearLayout ll_poisonRadiogen;     //防护措施
    FuEditText et_poisonPhysical;         //物理物质
    LinearLayout ll_poisonPhysical;     //防护措施
    FuEditText et_poisonChemical;         //化学物质
    LinearLayout ll_poisonChemical;     //防护措施
    FuEditText et_poisonOthers;           //其他
    LinearLayout ll_poisonOthers;       //其他防护措施


    View tv_old;//老年人相关
    View view_old_01;// 老年人
    View ll_old_01;// 老年人
    View view_old_02;// 老年人
    View ll_old_02;// 老年人
    View view_old_03;// 老年人
    View ll_old_03;// 老年人
    View view_old_04;// 老年人
    View ll_old_04;// 老年人

    public FuExam01View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_exam01_jn_view, null);
    }

    @Override
    protected void initFuData() {

    }

    public void setVisibility(PersonInfo personInfo) {
        if (personInfo.getIsElder() == null || 0 == personInfo.getIsElder()) {
            tv_old.setVisibility(View.GONE);//老年人相关
            view_old_01.setVisibility(View.GONE);// 老年人
            ll_old_01.setVisibility(View.GONE);// 老年人
            view_old_02.setVisibility(View.GONE);// 老年人
            ll_old_02.setVisibility(View.GONE);// 老年人
            view_old_03.setVisibility(View.GONE);// 老年人
            ll_old_03.setVisibility(View.GONE);// 老年人
            view_old_04.setVisibility(View.GONE);// 老年人
            ll_old_04.setVisibility(View.GONE);// 老年人
        } else {
            tv_old.setVisibility(View.VISIBLE);//老年人相关
            view_old_01.setVisibility(View.VISIBLE);// 老年人
            ll_old_01.setVisibility(View.VISIBLE);// 老年人
            view_old_02.setVisibility(View.VISIBLE);// 老年人
            ll_old_02.setVisibility(View.VISIBLE);// 老年人
            view_old_03.setVisibility(View.VISIBLE);// 老年人
            ll_old_03.setVisibility(View.VISIBLE);// 老年人
            view_old_04.setVisibility(View.VISIBLE);// 老年人
            ll_old_04.setVisibility(View.VISIBLE);// 老年人
        }
    }

    public void setData(HealthExam healthExam, PersonInfo personInfo) {
        tv_healthExamNo.setText(personInfo.getPersonInfoNo());

        setVisibility(personInfo);
        healthExam.setPersonInfoId(personInfo.getPersonInfoId());
        tv_name.setText(healthExam.getName());                   //姓名
//        tv_healthExamNo.setText(healthExam.getHealthExamNo());           //编号
//        tv_healthExamDate.setText(healthExam.getHealthExamDate().toString());         //体检日期
        //  sp_respDoctor;              //责任医生
//        setCheckBoxSelect("healthExamSymptom",healthExam.getHealthExamId(),ll_exam_symptom); //症状
        setCheckBoxSelect("healthExamSymptom", healthExam.getRecordChoice(), ll_exam_symptom); //症状
        et_bodyTemperature.setText(healthExam.getBodyTemperature());        //体温
        et_pulseRate.setText(healthExam.getPulseRate());              //脉率
        et_breathingRate.setText(healthExam.getBreathingRate());          //呼吸频率
        et_lsbp.setText(healthExam.getLsbp());                   //左侧血压
        et_ldbp.setText(healthExam.getLdbp());                   //左侧血压
        et_rsbp.setText(healthExam.getRsbp());                   //右侧血压
        et_rdbp.setText(healthExam.getRdbp());                   //右侧血压
        et_height.setText(healthExam.getHeight());                 //身高
        et_weight.setText(healthExam.getWeight());                 //体重
        et_waist.setText(healthExam.getWaist());                  //腰围
        et_bmi.setText(healthExam.getBmi());                    //体质指数
        setCheckBoxSelect(healthExam.getElderHealthAssessCode(), ll_elderHealthAssess);//老年人健康状态自我评估
        setCheckBoxSelect(healthExam.getElderSelfCareAssessCode(), ll_elderSelfCareAssess);//老年人生活自理能力自我评估*
        setCheckBoxSelect(healthExam.getElderCognitionResultCode(), ll_elderCognitionResult);//老年人认知功能

        setText(healthExam.getElderBrainScore(), ll_elderCognitionResult);

        setCheckBoxSelect(healthExam.getElderEmotionalResultCode(), ll_elderEmotionalResult);//老年人情感状态*

        setText(healthExam.getElderDepressionScore(), ll_elderEmotionalResult);

        setCheckBoxSelect(healthExam.getExerciseFreqCode(), ll_exerciseFreq);       //体育锻炼频率
        et_exerciseDurationMins.setText(healthExam.getExerciseDurationMins());   //每次锻炼时间
        et_exerciseYear.setText(healthExam.getExerciseYear());           //坚持锻炼时间
        et_exerciseWay.setText(healthExam.getExerciseWay());            //锻炼方式
//        setCheckBoxSelect("eatingHabit",healthExam.getHealthExamId(),ll_eatingHabits);       //饮食习惯
        setCheckBoxSelect("eatingHabit", healthExam.getRecordChoice(), ll_eatingHabits);       //饮食习惯
        setCheckBoxSelect(healthExam.getSmokingStatusCode(), ll_smokingStatus);      //吸烟情况
        et_dailySmoking.setText(healthExam.getDailySmoking());           //日吸烟量
        et_startSmokingAge.setText(healthExam.getStartSmokingAge());        //开始吸烟年龄
        et_stopSmokingAge.setText(healthExam.getStopSmokingAge());         //戒烟年龄
        setCheckBoxSelect(healthExam.getDrinkingFreqCode(), ll_drinkingFreq);       //饮酒频率
        et_dailyDrinking.setText(healthExam.getDailyDrinking());          //日饮酒量
        setCheckBoxSelect(healthExam.getStopDrinkingCode(), ll_stopDrinking);       //是否戒酒
        et_stopDrinkingAge.setText(healthExam.getStopDrinkingAge());        //戒酒年龄
        et_startDrinkingAge.setText(healthExam.getStartDrinkingAge());       //开始饮酒年龄
        setCheckBoxSelect(healthExam.getDrunkCode(), ll_drunkCode);          //近一年内是否曾醉酒
//        setCheckBoxSelect("drinkingType",healthExam.getHealthExamId(),ll_typesOfDrinking);    //饮酒种类
        setCheckBoxSelect("drinkingType", healthExam.getRecordChoice(), ll_typesOfDrinking);    //饮酒种类
        setCheckBoxSelect(healthExam.getOccupExposureCode(), ll_occupExposure);      //职业病危险因素标志
        et_occupExposureWork.setText(healthExam.getOccupExposureWork());      //工种
        et_occupExposureWorkYear.setText(healthExam.getOccupExposureWorkYear());  //从业时间
        et_poisonDust.setText(healthExam.getPoisonDust());             //粉尘
        setCheckBoxSelect(healthExam.getPoisonDustProtectCode(), ll_poisonDust);         //防护措施
        setText(healthExam.getPoisonDustProtectValue(), ll_poisonDust);

        et_poisonRadiogen.setText(healthExam.getPoisonRadiogen());         //放射物质
        setCheckBoxSelect(healthExam.getPoisonRadiogenProtectCode(), ll_poisonRadiogen);     //防护措施

        setText(healthExam.getPoisonRadiogenProtectValue(), ll_poisonRadiogen);

        et_poisonPhysical.setText(healthExam.getPoisonPhysical());         //物理物质
        setCheckBoxSelect(healthExam.getPoisonPhysicalProtectCode(), ll_poisonPhysical);    //防护措施
        setText(healthExam.getPoisonPhysicalProtectValue(), ll_poisonPhysical);

        et_poisonChemical.setText(healthExam.getPoisonChemical());         //化学物质
        setCheckBoxSelect(healthExam.getPoisonChemicalProtectCode(), ll_poisonChemical);     //防护措施
        setText(healthExam.getPoisonChemicalProtectValue(), ll_poisonChemical);

        et_poisonOthers.setText(healthExam.getPoisonOthers());           //其他
        setCheckBoxSelect(healthExam.getPoisonOthersProtectCode(), ll_poisonOthers);       //其他防护措施
        setText(healthExam.getPoisonOthersProtectValue(), ll_poisonOthers);
    }

    public boolean saveData(HealthExam healthExam) {


        if (tv_healthExamDate.getDate() == null) {
            ToastUtil.showToast(mContext, "请输入体检日期", Toast.LENGTH_SHORT);
            return false;
        }

        tv_name.setText(healthExam.getName());                   //姓名
//        tv_healthExamNo;           //编号
        healthExam.setHealthExamDate(tv_healthExamDate.getDate());         //体检日期
        healthExam.setIsAllExam(0);
        if (rb_isBigExam_false.isChecked())
            healthExam.setIsBigExam(0);
        else
            healthExam.setIsBigExam(1);
        Emp emp = (Emp) sp_respDoctor.getSelectedItem();              //责任医生
        healthExam.setRespDoctorId(emp.getEmp_id());
        healthExam.setRespDoctorName(emp.getEmp_name());
//        saveCheckBoxMany(healthExam.getHealthExamId(),healthExam.getRecordChoice(),ll_exam_symptom);//症状
        saveCheckBoxMany(null, healthExam.getRecordChoice(), ll_exam_symptom);//症状
        healthExam.setBodyTemperature(et_bodyTemperature.getDouble());        //体温
        healthExam.setPulseRate(et_pulseRate.getInt());              //脉率
        healthExam.setBreathingRate(et_breathingRate.getInt());         //呼吸频率
        healthExam.setLsbp(et_lsbp.getInt());                   //左侧血压
        healthExam.setLdbp(et_ldbp.getInt());                   //左侧血压
        healthExam.setRsbp(et_rsbp.getInt());                   //右侧血压
        healthExam.setRdbp(et_rdbp.getInt());                   //右侧血压
        healthExam.setHeight(et_height.getDouble());                 //身高
        healthExam.setWeight(et_weight.getDouble());                 //体重
        healthExam.setWaist(et_waist.getDouble());                  //腰围
        healthExam.setBmi(et_bmi.getDouble());                    //体质指数
        healthExam.setElderHealthAssessCode(getCheckBoxSimpleCode(ll_elderHealthAssess));  //老年人健康状态自我评估
        healthExam.setElderSelfCareAssessCode(getCheckBoxSimpleCode(ll_elderSelfCareAssess));//老年人生活自理能力自我评估*
        healthExam.setElderCognitionResultCode(getCheckBoxSimpleCode(ll_elderCognitionResult));//老年人认知功能

        healthExam.setElderBrainScore(getInt(ll_elderCognitionResult));

        healthExam.setElderEmotionalResultCode(getCheckBoxSimpleCode(ll_elderEmotionalResult));//老年人情感状态*
        healthExam.setElderDepressionScore(getInt(ll_elderEmotionalResult));
        healthExam.setExerciseFreqCode(getCheckBoxSimpleCode(ll_exerciseFreq));       //体育锻炼频率
        healthExam.setExerciseDurationMins(et_exerciseDurationMins.getInt());   //每次锻炼时间
        healthExam.setExerciseYear(et_exerciseYear.getInt());           //坚持锻炼时间
        healthExam.setExerciseWay(et_exerciseWay.getString());            //锻炼方式
//        saveCheckBoxMany(healthExam.getHealthExamId(),healthExam.getRecordChoice(),ll_eatingHabits);
        saveCheckBoxMany(null, healthExam.getRecordChoice(), ll_eatingHabits);
        healthExam.setSmokingStatusCode(getCheckBoxSimpleCode(ll_smokingStatus));      //吸烟情况
        healthExam.setDailySmoking(et_dailySmoking.getInt());           //日吸烟量
        healthExam.setStartSmokingAge(et_startSmokingAge.getInt());        //开始吸烟年龄
        healthExam.setStopSmokingAge(et_stopSmokingAge.getInt());         //戒烟年龄
        healthExam.setDrinkingFreqCode(getCheckBoxSimpleCode(ll_drinkingFreq));       //饮酒频率
        healthExam.setDailyDrinking(et_dailyDrinking.getInt());          //日饮酒量
        healthExam.setStopDrinkingCode(getCheckBoxSimpleCode(ll_stopDrinking));       //是否戒酒
        healthExam.setStopDrinkingAge(et_stopDrinkingAge.getInt());        //戒酒年龄
        healthExam.setStartDrinkingAge(et_startDrinkingAge.getInt());       //开始饮酒年龄
        healthExam.setDrunkCode(getCheckBoxSimpleCode(ll_drunkCode));          //近一年内是否曾醉酒
//        saveCheckBoxMany(healthExam.getHealthExamId(),healthExam.getRecordChoice(),ll_typesOfDrinking);
        saveCheckBoxMany(null, healthExam.getRecordChoice(), ll_typesOfDrinking);
        healthExam.setOccupExposureCode(getCheckBoxSimpleCode(ll_occupExposure));      //职业病危险因素标志
        healthExam.setOccupExposureWork(et_occupExposureWork.getString());      //工种
        healthExam.setOccupExposureWorkYear(et_occupExposureWorkYear.getInt());  //从业时间
        healthExam.setPoisonDust(et_poisonDust.getString());             //粉尘
        healthExam.setPoisonDustProtectCode(getCheckBoxSimpleCode(ll_poisonDust));         //防护措施
        healthExam.setPoisonDustProtectValue(getString(ll_poisonDust));
        healthExam.setPoisonRadiogen(et_poisonRadiogen.getString());         //放射物质
        healthExam.setPoisonRadiogenProtectCode(getCheckBoxSimpleCode(ll_poisonRadiogen));     //防护措施
        healthExam.setPoisonRadiogenProtectValue(getString(ll_poisonRadiogen));
        healthExam.setPoisonPhysical(et_poisonPhysical.getString());         //物理物质
        healthExam.setPoisonPhysicalProtectCode(getCheckBoxSimpleCode(ll_poisonPhysical));     //防护措施
        healthExam.setPoisonPhysicalProtectValue(getString(ll_poisonPhysical));
        healthExam.setPoisonChemical(et_poisonChemical.getString());         //化学物质
        healthExam.setPoisonChemicalProtectCode(getCheckBoxSimpleCode(ll_poisonChemical));     //防护措施
        healthExam.setPoisonChemicalProtectValue(getString(ll_poisonChemical));
        healthExam.setPoisonOthers(et_poisonOthers.getString());           //其他
        healthExam.setPoisonOthersProtectCode(getCheckBoxSimpleCode(ll_poisonOthers));       //其他防护措施
        healthExam.setPoisonOthersProtectValue(getString(ll_poisonOthers));
        return true;
    }


    public void setError() {
    }

    @Override
    protected void initWidget() {
//        Constant.EXAM_ID = 1;
        findView();

        List<Emp> empList = sqlHelper.getAllEmpList();
        ArrayAdapter adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_respDoctor.setAdapter(adapter);


        tv_healthExamDate.setOnClickListener(this);

        initCheckBoxMany("healthExamSymptom", ll_exam_symptom, 5, true, true);          //症状
        initCheckBoxSimple("EXERCISEFREQUENCY", ll_exerciseFreq, 0, true, false, false);    //锻炼频率
        initCheckBoxMany("eatingHabit", ll_eatingHabits, 4, false, false);                //饮食习惯
        initCheckBoxSimple("SMOKESTATUS", ll_smokingStatus, 0, true, false, false);           //吸烟情况
        initCheckBoxSimple("DRINKFREQUENCY", ll_drinkingFreq, 0, true, false, false);       //饮酒频率
        initCheckBoxSimple("ISNOTDRINK", ll_stopDrinking, 0, true, false, false);          //是否戒酒
        initCheckBoxSimple("CV9600.051", ll_drunkCode, 0, false, false, false);               //近一年是否醉酒
        initCheckBoxMany("drinkingType", ll_typesOfDrinking, 5, false, true);          //饮酒种类
        initCheckBoxSimple("YES_NO_CODE", ll_occupExposure, 0, true, false, false);          //职业病危害因素
        initCheckBoxSimple("YES_NO_CODE", ll_poisonDust, 0, false, true, false);               //粉尘
        initCheckBoxSimple("YES_NO_CODE", ll_poisonRadiogen, 0, false, true, false);           //放射物质
        initCheckBoxSimple("YES_NO_CODE", ll_poisonPhysical, 0, false, true, false);           //物理物质
        initCheckBoxSimple("YES_NO_CODE", ll_poisonChemical, 0, false, true, false);           //化学物质
        initCheckBoxSimple("YES_NO_CODE", ll_poisonOthers, 0, false, true, false);             //其他防护措施
        // 老年人健康状态自我评估
        initCheckBoxSimple("HEALTH_STATUS_REC", ll_elderHealthAssess, 3, false, false, false);
        // 老年人生活自理能力自我评估
        initCheckBoxSimple("LIFT_ABILITY_REC", ll_elderSelfCareAssess, 2, false, false, false);
        // 老年人认知功能
        initCheckBoxSimple("COGNITIONFUNCTION", ll_elderCognitionResult, 1, false, true, true);
        // 老年人情感状态
        initCheckBoxSimple("OLDEMOTIONSTATUS", ll_elderEmotionalResult, 1, false, true, true);

    }


    private void findView() {
        ll_exam_info = (LinearLayout) mFuView.findViewById(R.id.ll_exam_info);
        tv_exam_info = (FuTextView) mFuView.findViewById(R.id.tv_exam_info);
        tv_exam_info.setOnClickListener(this);
        rb_isBigExam_true = (FuRadioButton) mFuView.findViewById(R.id.rb_isBigExam_true);
        rb_isBigExam_false = (FuRadioButton) mFuView.findViewById(R.id.rb_isBigExam_false);

        tv_name = (FuTextView) mFuView.findViewById(R.id.tv_name);                   //姓名
        tv_healthExamNo = (FuTextView) mFuView.findViewById(R.id.tv_healthExamNo);           //编号
        tv_healthExamDate = (FuTextView) mFuView.findViewById(R.id.tv_healthExamDate);         //体检日期
        sp_respDoctor = (Spinner) mFuView.findViewById(R.id.sp_respDoctor);              //责任医生
        ll_exam_symptom = (LinearLayout) mFuView.findViewById(R.id.ll_exam_symptom);
        et_bodyTemperature = (FuEditText) mFuView.findViewById(R.id.et_bodyTemperature);        //体温
        et_pulseRate = (FuEditText) mFuView.findViewById(R.id.et_pulseRate);              //脉率
        et_breathingRate = (FuEditText) mFuView.findViewById(R.id.et_breathingRate);          //呼吸频率
        et_lsbp = (FuEditText) mFuView.findViewById(R.id.et_lsbp);                   //左侧血压
        et_ldbp = (FuEditText) mFuView.findViewById(R.id.et_ldbp);                   //左侧血压
        et_rsbp = (FuEditText) mFuView.findViewById(R.id.et_rsbp);                   //右侧血压
        et_rdbp = (FuEditText) mFuView.findViewById(R.id.et_rdbp);                   //右侧血压
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height);                 //身高
        et_height.setOnFocusChangeListener(this);
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight);                 //体重
        et_weight.setOnFocusChangeListener(this);
        et_waist = (FuEditText) mFuView.findViewById(R.id.et_waist);                  //腰围
        et_bmi = (FuEditText) mFuView.findViewById(R.id.et_bmi);                    //体质指数
        ll_elderHealthAssess = (LinearLayout) mFuView.findViewById(R.id.ll_elderHealthAssess);  //老年人健康状态自我评估
        ll_elderSelfCareAssess = (LinearLayout) mFuView.findViewById(R.id.ll_elderSelfCareAssess);//老年人生活自理能力自我评估*
        ll_elderCognitionResult = (LinearLayout) mFuView.findViewById(R.id.ll_elderCognitionResult);//老年人认知功能
        ll_elderEmotionalResult = (LinearLayout) mFuView.findViewById(R.id.ll_elderEmotionalResult);//老年人情感状态*
        ll_exerciseFreq = (LinearLayout) mFuView.findViewById(R.id.ll_exerciseFreq);       //体育锻炼频率
        et_exerciseDurationMins = (FuEditText) mFuView.findViewById(R.id.et_exerciseDurationMins);   //每次锻炼时间
        et_exerciseYear = (FuEditText) mFuView.findViewById(R.id.et_exerciseYear);           //坚持锻炼时间
        et_exerciseWay = (FuEditText) mFuView.findViewById(R.id.et_exerciseWay);            //锻炼方式
        ll_eatingHabits = (LinearLayout) mFuView.findViewById(R.id.ll_eatingHabits);         //饮食方式
        ll_smokingStatus = (LinearLayout) mFuView.findViewById(R.id.ll_smokingStatus);      //吸烟情况
        et_dailySmoking = (FuEditText) mFuView.findViewById(R.id.et_dailySmoking);           //日吸烟量
        et_startSmokingAge = (FuEditText) mFuView.findViewById(R.id.et_startSmokingAge);        //开始吸烟年龄
        et_stopSmokingAge = (FuEditText) mFuView.findViewById(R.id.et_stopSmokingAge);         //戒烟年龄
        ll_drinkingFreq = (LinearLayout) mFuView.findViewById(R.id.ll_drinkingFreq);       //饮酒频率
        et_dailyDrinking = (FuEditText) mFuView.findViewById(R.id.et_dailyDrinking);          //日饮酒量
        ll_stopDrinking = (LinearLayout) mFuView.findViewById(R.id.ll_stopDrinking);       //是否戒酒
        et_stopDrinkingAge = (FuEditText) mFuView.findViewById(R.id.et_stopDrinkingAge);        //戒酒年龄
        et_startDrinkingAge = (FuEditText) mFuView.findViewById(R.id.et_startDrinkingAge);       //开始饮酒年龄
        ll_drunkCode = (LinearLayout) mFuView.findViewById(R.id.ll_drunkCode);          //近一年内是否曾醉酒
        ll_typesOfDrinking = (LinearLayout) mFuView.findViewById(R.id.ll_typesOfDrinking);//饮酒种类
        ll_occupExposure = (LinearLayout) mFuView.findViewById(R.id.ll_occupExposure);      //职业病危险因素标志
        et_occupExposureWork = (FuEditText) mFuView.findViewById(R.id.et_occupExposureWork);      //工种
        et_occupExposureWorkYear = (FuEditText) mFuView.findViewById(R.id.et_occupExposureWorkYear);  //从业时间
        et_poisonDust = (FuEditText) mFuView.findViewById(R.id.et_poisonDust);             //粉尘
        ll_poisonDust = (LinearLayout) mFuView.findViewById(R.id.ll_poisonDust);         //防护措施
        et_poisonRadiogen = (FuEditText) mFuView.findViewById(R.id.et_poisonRadiogen);         //放射物质
        ll_poisonRadiogen = (LinearLayout) mFuView.findViewById(R.id.ll_poisonRadiogen);     //防护措施
        et_poisonPhysical = (FuEditText) mFuView.findViewById(R.id.et_poisonPhysical);         //物理物质
        ll_poisonPhysical = (LinearLayout) mFuView.findViewById(R.id.ll_poisonPhysical);     //防护措施
        et_poisonChemical = (FuEditText) mFuView.findViewById(R.id.et_poisonChemical);         //化学物质
        ll_poisonChemical = (LinearLayout) mFuView.findViewById(R.id.ll_poisonChemical);     //防护措施
        et_poisonOthers = (FuEditText) mFuView.findViewById(R.id.et_poisonOthers);           //其他
        ll_poisonOthers = (LinearLayout) mFuView.findViewById(R.id.ll_poisonOthers);       //其他防护措施


        tv_old = mFuView.findViewById(R.id.tv_old);//老年人相关
        view_old_01 = mFuView.findViewById(R.id.view_old_01);// 老年人
        ll_old_01 = mFuView.findViewById(R.id.ll_old_01);// 老年人
        view_old_02 = mFuView.findViewById(R.id.view_old_02);// 老年人
        ll_old_02 = mFuView.findViewById(R.id.ll_old_02);// 老年人
        view_old_03 = mFuView.findViewById(R.id.view_old_03);// 老年人
        ll_old_03 = mFuView.findViewById(R.id.ll_old_03);// 老年人
        view_old_04 = mFuView.findViewById(R.id.view_old_04);// 老年人
        ll_old_04 = mFuView.findViewById(R.id.ll_old_04);// 老年人

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_exam_info:
                if (ll_exam_info.getVisibility() == View.GONE)
                    ll_exam_info.setVisibility(View.VISIBLE);
                else
                    ll_exam_info.setVisibility(View.GONE);
                break;
            case R.id.tv_healthExamDate:
                ((FuChangeActivity) mContext).showTimeDialog((TextView) v)
                        .show(((FuParentActivity) mContext).getSupportFragmentManager(), "year-month-day");

                break;
        }
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
