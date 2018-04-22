package net.greatsoft.main.uiframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.Constant;
import net.greatsoft.main.R;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.helper.DiabetesFollowupDrugDao;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.SickMedicine;
import net.greatsoft.main.db.po.SpinnerItem;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowup;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowupDrug;
import net.greatsoft.main.fragment.FuDiabetesFragment;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 2016/11/26.
 * 糖尿病随访
 */

public class FuDiabetesView extends FuUiFrameModel implements View.OnClickListener, View.OnFocusChangeListener {

    FuEditText et_name; //姓名
    FuEditText et_followupDate; //随访日期
    LinearLayout ll_isMiss; //是否失访
    FuEditText et_missReason; //失访原因
    LinearLayout ll_followupWayCode; //随访方式
    LinearLayout ll_visitType; //随访类型
    LinearLayout ll_symptomCn; //症状
    FuEditText et_sbp; //血压 收缩压
    FuEditText et_dbp; //血压 舒张压
    FuEditText et_weight; //体重
    FuEditText et_aimWeight; //目标体重
    FuEditText et_height; //身高
    FuEditText et_bmi; //体质指数
    FuEditText et_aimBmi; //体质指数 目标
    LinearLayout ll_pofdaCode; //足背动脉搏动
    FuEditText et_otherPositiveSigns; //其他
    FuEditText et_dailySmoking; //日吸烟量
    FuEditText et_aimDailySmoking; //日吸烟量 目标
    FuEditText et_dailyDrinking; //日饮酒量
    FuEditText et_aimDailyDrinking; //日饮酒量 目标
    FuEditText et_exerciseFreqCode; //运动 次数
    FuEditText et_exerciseDurationMins; //运动 时间
    FuEditText et_aimExerciseFreqCode; //运动 目标次数
    FuEditText et_aimExerciseMins; //运动 目标时间
    FuEditText et_dailyStaple; //主食
    FuEditText et_aimDailyStaple; //主食 目标
    FuEditText et_insulinType; //胰岛素种类
    FuEditText et_insulinUsingStr; //胰岛素用法及用量
    LinearLayout ll_psyAdjustResultCode; //心理调整
    LinearLayout ll_complianceResultCode; //遵医行为
    FuEditText et_accessoryExam; //辅助检查
    FuEditText et_fbg; //空腹血糖值
    FuEditText et_pbg; //餐后血糖值
    FuEditText et_ghb; //糖化血红蛋白
    FuEditText et_ghbDate; //检查日期
    LinearLayout ll_drugComplianceCode; //服药依从性
    LinearLayout ll_drugAdverseCode; //药物不良反应
    LinearLayout ll_hypogReactCode; //低血糖反应
    LinearLayout ll_followupClassifyCode; //此次随访分类
    FuEditText et_referralReason; //转诊原因
    FuEditText et_refertoOrgName; //机构及级别
    FuButton d_b_medicine_save; //完成

    List<DiabetesFollowupDrug> mDrugList;
    DiabetesAdapter mDiabetesAdapter;

    Spinner sp_drugName; //药物名称
    Spinner sp_drugUsingFreq; //用法
    FuEditText et_drugPerDose; //每次剂量
    Spinner sp_unit; //单位
    net.greatsoft.main.view.FuListView lv_diabetesFU; //展示药物名称，每次剂量，用法
    FuEditText et_nextFollowupDate; //下次随访日期
    Spinner sp_followupDoctorId; //随访医生签名

    TextView fu_title_center;
    Button fu_title_right_btn;
    DiabetesFollowup mDiabetesFollowup;//为了保存用药

    List<Emp> empList;


    public FuDiabetesView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_diabetes_view, null);

        mDrugList = new ArrayList<>();
    }

    @Override
    protected void initFuData() {

        //用法
        List<Checks> num = Constant.getMedicineNum();
        ArrayAdapter<?> adapter2 = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                num);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_drugUsingFreq.setAdapter(adapter2);

        List<Checks> unit = Constant.getMedicineUnit();
        ArrayAdapter<?> adapter3 = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                unit);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_unit.setAdapter(adapter3);

        initCheckBoxSimple("IS_MISS_ID", ll_isMiss, 0); //是否失访
        initCheckBoxSimple("VISITE_WAY", ll_followupWayCode, 0); //随访方式
        initCheckBoxSimple("visitType", ll_visitType, 0); //随访类型
        initCheckBoxMany("diabetesSymptom", ll_symptomCn, 4, false, true); //症状
        initCheckBoxSimple("FOOT_DORSUMARTERY", ll_pofdaCode, 0); //足背动脉搏动
        initCheckBoxSimple("HEART_ADJUST", ll_psyAdjustResultCode, 0); //心理调整
        initCheckBoxSimple("FOLLOW_DOCTOR", ll_complianceResultCode, 0); //遵医行为
        initCheckBoxSimple("DRUG_COMPLIANCE", ll_drugComplianceCode, 0); //服药依从性
        initCheckBoxSimple("YES_NO_CODE", ll_drugAdverseCode, true); //药物不良反应
        initCheckBoxSimple("HYPOGLYCEMIA", ll_hypogReactCode, 0); //低血糖反应
        initCheckBoxSimple("VISIT_ASSORT", ll_followupClassifyCode, 0); //此次随访分类
        empList = sqlHelper.getEmpDao().queryBuilder().list();
        ArrayAdapter adapter = new ArrayAdapter(mContext,
                R.layout.msimple_spinner_item,
                empList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_followupDoctorId.setAdapter(adapter);
    }

    @Override
    protected void initWidget() {

        findView();

        mDiabetesAdapter = new DiabetesAdapter();
        lv_diabetesFU.setAdapter(mDiabetesAdapter);

        fu_title_center = (TextView) mFuView.findViewById(R.id.fu_title_center);
        fu_title_center.setText("糖尿病随访");
        fu_title_center.setVisibility(View.VISIBLE);
        fu_title_right_btn = (Button) mFuView.findViewById(R.id.fu_title_right_btn);
        fu_title_right_btn.setText("保存");
        fu_title_right_btn.setVisibility(View.VISIBLE);
        fu_title_right_btn.setOnClickListener(this);

    }

    public void setMedicine(List<SickMedicine> sickMedicineList) {
//药物名称
        List<SpinnerItem> spinnerItems;
        spinnerItems = new ArrayList<>();
        for (int i = 0; i < sickMedicineList.size(); i++) {
            SpinnerItem spinnerItem = new SpinnerItem(sickMedicineList.get(i).getSickMedicineId(), sickMedicineList.get(i).getName());
            spinnerItems.add(spinnerItem);
        }
        ArrayAdapter<?> adapter = new ArrayAdapter(mContext, R.layout.msimple_spinner_item,
                spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_drugName.setAdapter(adapter);
    }

    public void setData(DiabetesFollowup diabetesFollowup, String name) {
        et_name.setText(name);
        if (diabetesFollowup == null) {
            return;
        }
        mDiabetesFollowup = diabetesFollowup;

        et_name.setText(name);
        et_followupDate.setText(diabetesFollowup.getFollowupDate());
        setCheckBoxSelect(diabetesFollowup.getIsMiss(), ll_isMiss);
        et_missReason.setText(diabetesFollowup.getMissReason());
        setCheckBoxSelect(diabetesFollowup.getFollowupWayCode(), ll_followupWayCode);
        setCheckBoxSelect("diabetesSymptom", diabetesFollowup.getDiabetesFollowupId(), ll_symptomCn);
        et_sbp.setText(diabetesFollowup.getSbp());
        et_dbp.setText(diabetesFollowup.getDbp());
        et_weight.setText(diabetesFollowup.getWeight());
        et_aimWeight.setText(diabetesFollowup.getAimWeight());
        et_height.setText(diabetesFollowup.getHeight());
        et_bmi.setText(diabetesFollowup.getBmi());
        et_aimBmi.setText(diabetesFollowup.getAimBmi());
        setCheckBoxSelect(diabetesFollowup.getPofdaCode(), ll_pofdaCode);
        et_otherPositiveSigns.setText(diabetesFollowup.getOtherPositiveSigns());
        et_dailySmoking.setText(diabetesFollowup.getDailySmoking());
        et_aimDailySmoking.setText(diabetesFollowup.getAimDailySmoking());
        et_dailyDrinking.setText(diabetesFollowup.getDailyDrinking());
        et_aimDailyDrinking.setText(diabetesFollowup.getAimDailyDrinking());
        et_exerciseFreqCode.setText(diabetesFollowup.getExerciseFreqCode());
        et_exerciseDurationMins.setText(diabetesFollowup.getExerciseDurationMins());
        et_aimExerciseFreqCode.setText(diabetesFollowup.getAimExerciseFreqCode());
        et_aimExerciseMins.setText(diabetesFollowup.getAimExerciseMins());
        et_dailyStaple.setText(diabetesFollowup.getDailyStaple());
        et_aimDailyStaple.setText(diabetesFollowup.getAimDailyStaple());
        et_insulinType.setText(diabetesFollowup.getInsulinType());
        et_insulinUsingStr.setText(diabetesFollowup.getInsulinUsingStr());
        setCheckBoxSelect(diabetesFollowup.getPsyAdjustResultCode(), ll_psyAdjustResultCode);
        setCheckBoxSelect(diabetesFollowup.getComplianceResultCode(), ll_complianceResultCode);
        et_accessoryExam.setText(diabetesFollowup.getAccessoryExam());
        et_fbg.setText(diabetesFollowup.getFbg());
        et_pbg.setText(diabetesFollowup.getPbg());
        et_ghb.setText(diabetesFollowup.getGhb());
        et_ghbDate.setText(diabetesFollowup.getGhbDate());
        setCheckBoxSelect(diabetesFollowup.getDrugComplianceCode(), ll_drugComplianceCode);
        setCheckBoxSelect(diabetesFollowup.getDrugAdverseCode(), ll_drugAdverseCode);
        setCheckBoxSelect(diabetesFollowup.getHypogReactCode(), ll_hypogReactCode);
        setCheckBoxSelect(diabetesFollowup.getFollowupClassifyCode(), ll_followupClassifyCode);
        et_referralReason.setText(diabetesFollowup.getReferralReason());
        et_refertoOrgName.setText(diabetesFollowup.getRefertoOrgName());

        mDrugList.addAll(sqlHelper.getDiabetesFollowupDrugDao().queryBuilder().where(DiabetesFollowupDrugDao.Properties.DiabetesFollowupId.eq(diabetesFollowup.getDiabetesFollowupId())).list());
        mDiabetesAdapter.notifyDataSetChanged();

        et_nextFollowupDate.setText(diabetesFollowup.getNextFollowupDate());
        if (diabetesFollowup.getFollowupDoctorId() != null) {
            for (int i = 0; i < empList.size(); i++) {
                if (diabetesFollowup.getFollowupDoctorId().equals(empList.get(i).getEmp_id())) {
                    sp_followupDoctorId.setSelection(i);
                    break;
                }
            }
        }
    }

    public boolean saveData(DiabetesFollowup diabetesFollowup) {

        if ("".equals(et_followupDate.getString())) {
            ToastUtil.showToast(mContext, "请输入随访日期", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_isMiss))) {
            ToastUtil.showToast(mContext, "请选择是否失访", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_followupWayCode))) {
            ToastUtil.showToast(mContext, "请选择随访方式", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_visitType))) {
            ToastUtil.showToast(mContext, "请选择随访类型", Toast.LENGTH_LONG);
            return false;
        }

        boolean flag = true;
        saveCheckBoxMany(null, diabetesFollowup.getRecordChoice(), ll_symptomCn); //症状
        List<RecordChoice> choice = diabetesFollowup.getRecordChoice();//症状
        for (int i = 0; i < choice.size(); i++) {
            if ("diabetesSymptom".equals(choice.get(i).getCodeType())) {
                flag = false;
            }
        }
        if (flag) {
            ToastUtil.showToast(mContext, "请选择症状", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_sbp.getText().toString()) || "".equals(et_dbp.getText().toString())) {
            ToastUtil.showToast(mContext, "请填写血压", Toast.LENGTH_LONG);
            return false;
        }

        if ((et_weight.getText().toString()).isEmpty() || (et_aimWeight.getText().toString()).isEmpty()) {
            ToastUtil.showToast(mContext, "请填写体重", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_height.getText().toString())) {
            ToastUtil.showToast(mContext, "请填写身高", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_fbg.getText().toString())) {
            ToastUtil.showToast(mContext, "请填写空腹血糖值", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_drugComplianceCode))) {
            ToastUtil.showToast(mContext, "请选择服药依从性", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_hypogReactCode))) {
            ToastUtil.showToast(mContext, "请选择低血糖反应", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(getCheckBoxSimpleCode(ll_followupClassifyCode))) {
            ToastUtil.showToast(mContext, "请选择此次随访分类", Toast.LENGTH_LONG);
            return false;
        }
        if ("".equals(et_nextFollowupDate.getString())) {
            ToastUtil.showToast(mContext, "请填写下次随访日期", Toast.LENGTH_LONG);
            return false;
        }
//        Checks checks = (Checks) sp_followupDoctorId.getSelectedItem();
//        if ("".equals(checks.getCode())) {
//            ToastUtil.showToast(mContext, "请选择随访医生", Toast.LENGTH_LONG);
//            return false;
//        }
        diabetesFollowup.setName(et_name.getString()); //姓名
        diabetesFollowup.setFollowupDate(et_followupDate.getDate()); //随访日期
        diabetesFollowup.setIsMiss(getCheckBoxSimpleCode(ll_isMiss)); //是否失访
        diabetesFollowup.setMissReason(et_missReason.getString()); //失访原因
        diabetesFollowup.setFollowupWayCode(getCheckBoxSimpleCode(ll_followupWayCode)); //随访方式
        diabetesFollowup.setVisitType(getCheckBoxSimpleCode(ll_visitType));//随访类型
        diabetesFollowup.setSbp(et_sbp.getInt()); //血压 收缩压
        diabetesFollowup.setDbp(et_dbp.getInt()); //血压 舒张压
        diabetesFollowup.setWeight(et_weight.getDouble()); //体重
        diabetesFollowup.setAimWeight(et_aimWeight.getDouble()); //目标体重
        diabetesFollowup.setHeight(et_height.getDouble()); //身高
        diabetesFollowup.setBmi(et_bmi.getDouble()); //体质指数
        diabetesFollowup.setAimBmi(et_aimBmi.getDouble()); //体质指数 目标
        diabetesFollowup.setPofdaCode(getCheckBoxSimpleCode(ll_pofdaCode)); //足背动脉搏动
        diabetesFollowup.setOtherPositiveSigns(et_otherPositiveSigns.getString()); //其他
        diabetesFollowup.setDailySmoking(et_dailySmoking.getInt()); //日吸烟量
        diabetesFollowup.setAimDailySmoking(et_aimDailySmoking.getInt()); //日吸烟量 目标
        diabetesFollowup.setDailyDrinking(et_dailyDrinking.getInt()); //日饮酒量
        diabetesFollowup.setAimDailyDrinking(et_aimDailyDrinking.getInt()); //日饮酒量 目标
        diabetesFollowup.setExerciseDurationWeeks(et_exerciseFreqCode.getString()); //运动 次数
        diabetesFollowup.setExerciseDurationMins(et_exerciseDurationMins.getInt()); //运动 时间
        diabetesFollowup.setAimDurationWeeks(et_aimExerciseFreqCode.getString()); //运动 目标次数
        diabetesFollowup.setAimExerciseMins(et_aimExerciseMins.getInt()); //运动 目标时间
        diabetesFollowup.setDailyStaple(et_dailyStaple.getInt()); //主食
        diabetesFollowup.setAimDailyStaple(et_aimDailyStaple.getInt()); //主食 目标
        diabetesFollowup.setInsulinType(et_insulinType.getString());//胰岛素种类
        diabetesFollowup.setInsulinUsingStr(et_insulinUsingStr.getString());//胰岛素用法用量
        diabetesFollowup.setPsyAdjustResultCode(getCheckBoxSimpleCode(ll_psyAdjustResultCode)); //心理调整
        diabetesFollowup.setComplianceResultCode(getCheckBoxSimpleCode(ll_complianceResultCode)); //遵医行为
        diabetesFollowup.setAccessoryExam(et_accessoryExam.getString()); //辅助检查
        diabetesFollowup.setFbg(et_fbg.getDouble()); //空腹血糖值
        diabetesFollowup.setPbg(et_pbg.getDouble()); //餐后血糖值
        diabetesFollowup.setGhb(et_ghb.getDouble()); //糖化血红蛋白
        diabetesFollowup.setGhbDate(et_ghbDate.getDate()); //检查日期
        diabetesFollowup.setDrugComplianceCode(getCheckBoxSimpleCode(ll_drugComplianceCode)); //服药依从性
        diabetesFollowup.setDrugAdverseCode(getCheckBoxSimpleCode(ll_drugAdverseCode)); //药物不良反应
        diabetesFollowup.setDrugAdverseDesc(getString(ll_drugAdverseCode));
        diabetesFollowup.setHypogReactCode(getCheckBoxSimpleCode(ll_hypogReactCode));//低血糖反应
        diabetesFollowup.setFollowupClassifyCode(getCheckBoxSimpleCode(ll_followupClassifyCode));//此次随访分类
        diabetesFollowup.setReferralReason(et_referralReason.getString());//转诊原因
        diabetesFollowup.setRefertoOrgName(et_refertoOrgName.getString());//机构及级别

        diabetesFollowup.getDiabetesFollowupDrug().addAll(this.mDrugList);

        diabetesFollowup.setNextFollowupDate(et_nextFollowupDate.getDate());//下次随访日期

        Emp emp = (Emp) sp_followupDoctorId.getSelectedItem();
        if (emp != null) {
            diabetesFollowup.setFollowupDoctorId(emp.getEmp_id());
            diabetesFollowup.setFollowupDoctorName(emp.getEmp_name());
        }

        diabetesFollowup.setDiabetesFollowupId(null);
        return true;

    }

    private void findView() {

        et_name = (FuEditText) mFuView.findViewById(R.id.et_name); //姓名
        et_followupDate = (FuEditText) mFuView.findViewById(R.id.et_followupDate); //随访日期
        et_followupDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FuContentActivity) mContext).showTimeDialog(et_followupDate)
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
            }
        });
        ll_isMiss = (LinearLayout) mFuView.findViewById(R.id.ll_isMiss); //是否失访
        et_missReason = (FuEditText) mFuView.findViewById(R.id.et_missReason); //失访原因
        ll_followupWayCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupWayCode); //随访方式
        ll_visitType = (LinearLayout) mFuView.findViewById(R.id.ll_visitType); //随访类型
        ll_symptomCn = (LinearLayout) mFuView.findViewById(R.id.ll_symptomCn); //症状
        et_sbp = (FuEditText) mFuView.findViewById(R.id.et_sbp); //血压 收缩压
        et_dbp = (FuEditText) mFuView.findViewById(R.id.et_dbp); //血压 舒张压
        et_weight = (FuEditText) mFuView.findViewById(R.id.et_weight); //体重
        et_weight.setOnFocusChangeListener(this);
        et_aimWeight = (FuEditText) mFuView.findViewById(R.id.et_aimWeight); //目标体重
        et_aimWeight.setOnFocusChangeListener(this);
        et_height = (FuEditText) mFuView.findViewById(R.id.et_height); //身高
        et_height.setOnFocusChangeListener(this);
        et_bmi = (FuEditText) mFuView.findViewById(R.id.et_bmi); //体质指数
        et_aimBmi = (FuEditText) mFuView.findViewById(R.id.et_aimBmi); //体质指数 目标
        ll_pofdaCode = (LinearLayout) mFuView.findViewById(R.id.ll_pofdaCode); //足背动脉搏动
        et_otherPositiveSigns = (FuEditText) mFuView.findViewById(R.id.et_otherPositiveSigns); //其他
        et_dailySmoking = (FuEditText) mFuView.findViewById(R.id.et_dailySmoking); //日吸烟量
        et_aimDailySmoking = (FuEditText) mFuView.findViewById(R.id.et_aimDailySmoking); //日吸烟量 目标
        et_dailyDrinking = (FuEditText) mFuView.findViewById(R.id.et_dailyDrinking); //日饮酒量
        et_aimDailyDrinking = (FuEditText) mFuView.findViewById(R.id.et_aimDailyDrinking); //日饮酒量 目标
        et_exerciseFreqCode = (FuEditText) mFuView.findViewById(R.id.et_exerciseFreqCode); //运动 次数
        et_exerciseDurationMins = (FuEditText) mFuView.findViewById(R.id.et_exerciseDurationMins); //运动 时间
        et_aimExerciseFreqCode = (FuEditText) mFuView.findViewById(R.id.et_aimExerciseFreqCode); //运动 目标次数
        et_aimExerciseMins = (FuEditText) mFuView.findViewById(R.id.et_aimExerciseMins); //运动 目标时间
        et_dailyStaple = (FuEditText) mFuView.findViewById(R.id.et_dailyStaple); //主食
        et_aimDailyStaple = (FuEditText) mFuView.findViewById(R.id.et_aimDailyStaple); //主食 目标
        et_insulinType = (FuEditText) mFuView.findViewById(R.id.et_insulinType); //胰岛素种类
        et_insulinUsingStr = (FuEditText) mFuView.findViewById(R.id.et_insulinUsingStr); //胰岛素用法及用量
        ll_psyAdjustResultCode = (LinearLayout) mFuView.findViewById(R.id.ll_psyAdjustResultCode); //心理调整
        ll_complianceResultCode = (LinearLayout) mFuView.findViewById(R.id.ll_complianceResultCode); //遵医行为
        et_accessoryExam = (FuEditText) mFuView.findViewById(R.id.et_accessoryExam); //辅助检查
        et_fbg = (FuEditText) mFuView.findViewById(R.id.et_fbg); //空腹血糖值
        et_pbg = (FuEditText) mFuView.findViewById(R.id.et_pbg); //餐后血糖值
        et_ghb = (FuEditText) mFuView.findViewById(R.id.et_ghb); //糖化血红蛋白
        et_ghbDate = (FuEditText) mFuView.findViewById(R.id.et_ghbDate); //检查日期
        et_ghbDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FuContentActivity) mContext).showTimeDialog(et_ghbDate)
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
                ;
            }
        });
        ll_drugComplianceCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugComplianceCode); //服药依从性
        ll_drugAdverseCode = (LinearLayout) mFuView.findViewById(R.id.ll_drugAdverseCode); //药物不良反应
        ll_hypogReactCode = (LinearLayout) mFuView.findViewById(R.id.ll_hypogReactCode); //低血糖反应
        ll_followupClassifyCode = (LinearLayout) mFuView.findViewById(R.id.ll_followupClassifyCode); //此次随访分类
        et_referralReason = (FuEditText) mFuView.findViewById(R.id.et_referralReason); //转诊原因
        et_refertoOrgName = (FuEditText) mFuView.findViewById(R.id.et_refertoOrgName); //机构及级别
        d_b_medicine_save = (FuButton) mFuView.findViewById(R.id.d_b_medicine_save); //完成
        d_b_medicine_save.setOnClickListener(this);
        sp_drugName = (Spinner) mFuView.findViewById(R.id.sp_drugName); //药物名称
        sp_drugUsingFreq = (Spinner) mFuView.findViewById(R.id.sp_drugUsingFreq); //用法
        et_drugPerDose = (FuEditText) mFuView.findViewById(R.id.et_drugPerDose); //每次剂量
        sp_unit = (Spinner) mFuView.findViewById(R.id.sp_unit); //单位
        lv_diabetesFU = (net.greatsoft.main.view.FuListView) mFuView.findViewById(R.id.lv_diabetesFU); //展示药物名称，每次剂量，用法
        et_nextFollowupDate = (FuEditText) mFuView.findViewById(R.id.et_nextFollowupDate); //下次随访日期
        et_nextFollowupDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FuContentActivity) mContext).showTimeDialog(et_nextFollowupDate)
                        .show(((FuContentActivity) mContext).getSupportFragmentManager(), "year-month-day");
            }
        });
        sp_followupDoctorId = (Spinner) mFuView.findViewById(R.id.sp_followupDoctorId); //随访医生签名

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.d_b_medicine_save:
                SpinnerItem spinnerItem = (SpinnerItem) sp_drugName.getSelectedItem();

                DiabetesFollowupDrug diabetesFollowupDrug = new DiabetesFollowupDrug();
//                diabetesFollowupDrug.setDiabetesFollowupId(mDiabetesFollowup.getDiabetesFollowupId());
                diabetesFollowupDrug.setDrugId(spinnerItem.getId());
                diabetesFollowupDrug.setDrugName(spinnerItem.getValue());


                Checks checks = (Checks) sp_drugUsingFreq.getSelectedItem();
                diabetesFollowupDrug.setDrugUsingFreq(checks.getCode()); //用法
                diabetesFollowupDrug.setDrugPerDose(et_drugPerDose.getString()); //每次剂量
                Checks checkUnit = (Checks) sp_unit.getSelectedItem();
//                diabetesFollowupDrug.setDrugPerDose(checkUnit.getCode());//单位
                diabetesFollowupDrug.setUnit(checkUnit.getValue());
                mDrugList.add(diabetesFollowupDrug);
                mDiabetesAdapter.notifyDataSetChanged();
                et_drugPerDose.setText("");
                break;
            case R.id.fu_title_right_btn:
                mEventCallBack.EventClick(FuDiabetesFragment.EVENT_SAVE_DIABETES, null);
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
                    if (!et_height.getString().isEmpty() && !et_aimWeight.getString().isEmpty()) {
                        double tizhi = et_aimWeight.getDouble() / (et_height.getDouble() * et_height.getDouble()) * 10000;
                        et_aimBmi.setText(String.format("%.2f", tizhi));
                    }
                }
                break;
            case R.id.et_aimWeight:
                if (!hasFocus) {
                    if (!et_height.getString().isEmpty() && !et_aimWeight.getString().isEmpty()) {
                        double tizhi = et_aimWeight.getDouble() / (et_height.getDouble() * et_height.getDouble()) * 10000;
                        et_aimBmi.setText(String.format("%.2f", tizhi));
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

    class DiabetesAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public DiabetesAdapter() {
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return mDrugList == null ? 0 : mDrugList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            DiabetesHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fu_medicine_item, null);
                holder = new DiabetesHolder();
                holder.tv_name = (FuTextView) convertView.findViewById(R.id.tv_name);
                holder.tv_num = (FuTextView) convertView.findViewById(R.id.tv_num);
                holder.tv_dose = (FuTextView) convertView.findViewById(R.id.tv_dose);
                holder.tv_delete = (FuTextView) convertView.findViewById(R.id.tv_delete);
                convertView.setTag(holder);
            } else {
                holder = (DiabetesHolder) convertView.getTag();
            }
            holder.tv_name.setText(mDrugList.get(position).getDrugName());
            holder.tv_num.setText(mDrugList.get(position).getDrugUsingFreq());
            holder.tv_dose.setText(mDrugList.get(position).getDrugPerDose() + mDrugList.get(position).getUnit());
            holder.tv_delete.setText("删除");
            holder.tv_delete.setTag(mDrugList.get(position));
            holder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrugList.remove(position);
                    mDiabetesAdapter.notifyDataSetChanged();
                }
            });

            return convertView;
        }

        class DiabetesHolder {

            FuTextView tv_name; //药物名称
            FuTextView tv_num; //每日次数
            FuTextView tv_dose;//每次剂量
            FuTextView tv_delete;
        }
    }
}
