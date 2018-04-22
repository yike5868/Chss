package net.greatsoft.main.db.po.diabetes;

import net.greatsoft.main.db.po.Entry;
import net.greatsoft.main.db.po.RecordChoice;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Transient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author AlphGo
 * @date 2016年6月28日 下午10:38:14
 * @Description: 2型糖尿病患者随访实体类
 */
@Entity
public class DiabetesFollowup extends Entry {
    /**
     * 2型糖尿病患者随访ID
     */
    private String diabetesFollowupId;

    /**
     * 个人档案ID
     */
    private String personInfoId;

    /**
     * 2型糖尿病患者随访编号
     */
    private String diabetesFollowupNo;

    /**
     * 本人姓名
     */
    private String name;

    /**
     * 责任医师姓名
     */
    private String respDoctorName;

    /**
     * 本次随访日期
     */
    private Date followupDate;

    /**
     * 随访方式代码
     */
    private String followupWayCode;

    /**
     * 随访类型(1正常随访0二次随访，对应原公卫中的IS_REPEAT_VISIT字段)
     */
    private String visitType;

    /**
     * 是否失访(1是，0否)
     */
    private String isMiss;

    /**
     * 失访原因
     */
    private String missReason;

    /**
     * 收缩压(mmHg)
     */
    private Integer sbp;

    /**
     * 舒张压(mmHg)
     */
    private Integer dbp;

    /**
     * 体重(kg)
     */
    private Double weight;

    /**
     * 目标体重(kg)
     */
    private Double aimWeight;

    /**
     * 身高(cm)
     */
    private Double height;

    /**
     * 体质指数
     */
    private Double bmi;

    /**
     * 目标体质指数
     */
    private Double aimBmi;

    /**
     * 足背动脉搏动标志
     */
    private String pofdaCode;

    /**
     * 其他阳性体征
     */
    private String otherPositiveSigns;

    /**
     * 日吸烟量（支）
     */
    private Integer dailySmoking;

    /**
     * 目标日吸烟量(支）
     */
    private Integer aimDailySmoking;

    /**
     * 日饮酒量（两）
     */
    private Integer dailyDrinking;

    /**
     * 目标日饮酒量（两）
     */
    private Integer aimDailyDrinking;

    /**
     * 运动频率代码
     */
    private String exerciseFreqCode;

    /**
     * 目标运动频率代码
     */
    private String aimExerciseFreqCode;

    /**
     * 运动频率代码
     */
    private String exerciseDurationWeeks;

    /**
     * 目标运动频率代码
     */
    private String aimDurationWeeks;

    /**
     * 运动时长（min)
     */
    private Integer exerciseDurationMins;

    /**
     * 目标运动时长（min)
     */
    private Integer aimExerciseMins;

    /**
     * 日主食量(g)
     */
    private Integer dailyStaple;

    /**
     * 目标日主食量（g)
     */
    private Integer aimDailyStaple;

    /**
     * 心理调整评价结果代码
     */
    private String psyAdjustResultCode;

    /**
     * 遵医行为评价结果代码
     */
    private String complianceResultCode;

    /**
     * 空腹血糖值（mmol/L)
     */
    private Double fbg;

    /**
     * 餐后两小时血糖值（mmol/L)
     */
    private Double pbg;

    /**
     * 糖化血红蛋白值（％)
     */
    private Double ghb;

    /**
     * 糖化血红蛋白检查日期
     */
    private Date ghbDate;

    /**
     * 辅助检查
     */
    private String accessoryExam;

    /**
     * 低血糖反应代码
     */
    private String hypogReactCode;

    /**
     * 随访评价结果代码
     */
    private String visitEvalResultCode;

    /**
     * 胰岛素用药种类
     */
    private String insulinType;

    /**
     * 胰岛素用药使用频率（次/d)
     */
    private Integer insulinUsingFreq;

    /**
     * 胰岛素用药次剂量（u)
     */
    private Integer insulinPerDose;

    /**
     * 是否转诊代码
     */
    private String isReferralCode;

    /**
     * 转诊原因
     */
    private String referralReason;

    /**
     * 转入医疗机构
     */
    private String refertoOrgName;
    /**
     * 转入医疗机构科别
     */
    private String refertoDeptName;

    /**
     * 下次随访日期
     */
    private Date nextFollowupDate;

    /**
     * 本次随访医师Id
     */
    private String followupDoctorId;

    /**
     * 本次随访医师姓名
     */
    private String followupDoctorName;

    /**
     * 服药依从性代码
     */
    private String drugComplianceCode;

    /**
     * 药物不良反应标志
     */
    private String drugAdverseCode;

    /**
     * 药物不良反应描述
     */
    private String drugAdverseDesc;

    /**
     * 此次随访分类
     */
    private String followupClassifyCode;

    /**
     * 是否删除
     */
    private Integer isCancel;

    /**
     * 建档机构ID
     */
    private String createOrgId;

    /**
     * 建档机构名称
     */
    private String orgName;

    /**
     * 建档人ID
     */
    private String creatorId;

    /**
     * 建档人姓名
     */
    private String creator;

    /**
     * 建档时间
     */
    private Date createTime;

    /**
     * 最后更新机构ID
     */
    private String modifiedOrgId;

    /**
     * 最后更新机构名称
     */
    private String modifiedOrgName;

    /**
     * 最后更新人ID
     */
    private String modifierId;

    /**
     * 最后更新人姓名
     */
    private String modifier;

    /**
     * 最后更新时间
     */
    private Date modifiedTime;

    /**
     * 返回给前台使用的json串
     */
    private String jsonDetail;

    /**
     * 胰岛素使用情况
     */
    private String insulinUsingStr;


    @Transient
    List<DiabetesFollowupDrug> diabetesFollowupDrug;
    @Transient
    List<RecordChoice> recordChoice;

    public List<DiabetesFollowupDrug> getDiabetesFollowupDrug() {
        return diabetesFollowupDrug;
    }

    public void setDiabetesFollowupDrug(List<DiabetesFollowupDrug> diabetesFollowupDrug) {
        this.diabetesFollowupDrug = diabetesFollowupDrug;
    }

    public List<RecordChoice> getRecordChoice() {
        return recordChoice;
    }

    public void setRecordChoice(List<RecordChoice> recordChoice) {
        this.recordChoice = recordChoice;
    }

    public String getInsulinUsingStr() {
        return insulinUsingStr;
    }

    public void setInsulinUsingStr(String insulinUsingStr) {
        this.insulinUsingStr = insulinUsingStr;
    }

    public String getJsonDetail() {
        return this.jsonDetail;
    }

    public void setJsonDetail(String jsonDetail) {
        this.jsonDetail = jsonDetail;
    }

    public Date getModifiedTime() {
        return this.modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifier() {
        return this.modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifierId() {
        return this.modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
    }

    public String getModifiedOrgName() {
        return this.modifiedOrgName;
    }

    public void setModifiedOrgName(String modifiedOrgName) {
        this.modifiedOrgName = modifiedOrgName;
    }

    public String getModifiedOrgId() {
        return this.modifiedOrgId;
    }

    public void setModifiedOrgId(String modifiedOrgId) {
        this.modifiedOrgId = modifiedOrgId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorId() {
        return this.creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getOrgName() {
        return this.orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getCreateOrgId() {
        return this.createOrgId;
    }

    public void setCreateOrgId(String createOrgId) {
        this.createOrgId = createOrgId;
    }

    public Integer getIsCancel() {
        return this.isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public String getFollowupClassifyCode() {
        return this.followupClassifyCode;
    }

    public void setFollowupClassifyCode(String followupClassifyCode) {
        this.followupClassifyCode = followupClassifyCode;
    }

    public String getDrugAdverseDesc() {
        return this.drugAdverseDesc;
    }

    public void setDrugAdverseDesc(String drugAdverseDesc) {
        this.drugAdverseDesc = drugAdverseDesc;
    }

    public String getDrugAdverseCode() {
        return this.drugAdverseCode;
    }

    public void setDrugAdverseCode(String drugAdverseCode) {
        this.drugAdverseCode = drugAdverseCode;
    }

    public String getDrugComplianceCode() {
        return this.drugComplianceCode;
    }

    public void setDrugComplianceCode(String drugComplianceCode) {
        this.drugComplianceCode = drugComplianceCode;
    }

    public String getFollowupDoctorName() {
        return this.followupDoctorName;
    }

    public void setFollowupDoctorName(String followupDoctorName) {
        this.followupDoctorName = followupDoctorName;
    }

    public String getFollowupDoctorId() {
        return this.followupDoctorId;
    }

    public void setFollowupDoctorId(String followupDoctorId) {
        this.followupDoctorId = followupDoctorId;
    }

    public Date getNextFollowupDate() {
        return this.nextFollowupDate;
    }

    public void setNextFollowupDate(Date nextFollowupDate) {
        this.nextFollowupDate = nextFollowupDate;
    }

    public String getRefertoDeptName() {
        return this.refertoDeptName;
    }

    public void setRefertoDeptName(String refertoDeptName) {
        this.refertoDeptName = refertoDeptName;
    }

    public String getRefertoOrgName() {
        return this.refertoOrgName;
    }

    public void setRefertoOrgName(String refertoOrgName) {
        this.refertoOrgName = refertoOrgName;
    }

    public String getReferralReason() {
        return this.referralReason;
    }

    public void setReferralReason(String referralReason) {
        this.referralReason = referralReason;
    }

    public String getIsReferralCode() {
        return this.isReferralCode;
    }

    public void setIsReferralCode(String isReferralCode) {
        this.isReferralCode = isReferralCode;
    }

    public Integer getInsulinPerDose() {
        return this.insulinPerDose;
    }

    public void setInsulinPerDose(Integer insulinPerDose) {
        this.insulinPerDose = insulinPerDose;
    }

    public Integer getInsulinUsingFreq() {
        return this.insulinUsingFreq;
    }

    public void setInsulinUsingFreq(Integer insulinUsingFreq) {
        this.insulinUsingFreq = insulinUsingFreq;
    }

    public String getInsulinType() {
        return this.insulinType;
    }

    public void setInsulinType(String insulinType) {
        this.insulinType = insulinType;
    }

    public String getVisitEvalResultCode() {
        return this.visitEvalResultCode;
    }

    public void setVisitEvalResultCode(String visitEvalResultCode) {
        this.visitEvalResultCode = visitEvalResultCode;
    }

    public String getHypogReactCode() {
        return this.hypogReactCode;
    }

    public void setHypogReactCode(String hypogReactCode) {
        this.hypogReactCode = hypogReactCode;
    }

    public String getAccessoryExam() {
        return this.accessoryExam;
    }

    public void setAccessoryExam(String accessoryExam) {
        this.accessoryExam = accessoryExam;
    }

    public Date getGhbDate() {
        return this.ghbDate;
    }

    public void setGhbDate(Date ghbDate) {
        this.ghbDate = ghbDate;
    }

    public Double getGhb() {
        return this.ghb;
    }

    public void setGhb(Double ghb) {
        this.ghb = ghb;
    }

    public Double getPbg() {
        return this.pbg;
    }

    public void setPbg(Double pbg) {
        this.pbg = pbg;
    }

    public Double getFbg() {
        return this.fbg;
    }

    public void setFbg(Double fbg) {
        this.fbg = fbg;
    }

    public String getComplianceResultCode() {
        return this.complianceResultCode;
    }

    public void setComplianceResultCode(String complianceResultCode) {
        this.complianceResultCode = complianceResultCode;
    }

    public String getPsyAdjustResultCode() {
        return this.psyAdjustResultCode;
    }

    public void setPsyAdjustResultCode(String psyAdjustResultCode) {
        this.psyAdjustResultCode = psyAdjustResultCode;
    }

    public Integer getAimDailyStaple() {
        return this.aimDailyStaple;
    }

    public void setAimDailyStaple(Integer aimDailyStaple) {
        this.aimDailyStaple = aimDailyStaple;
    }

    public Integer getDailyStaple() {
        return this.dailyStaple;
    }

    public void setDailyStaple(Integer dailyStaple) {
        this.dailyStaple = dailyStaple;
    }

    public Integer getAimExerciseMins() {
        return this.aimExerciseMins;
    }

    public void setAimExerciseMins(Integer aimExerciseMins) {
        this.aimExerciseMins = aimExerciseMins;
    }

    public Integer getExerciseDurationMins() {
        return this.exerciseDurationMins;
    }

    public void setExerciseDurationMins(Integer exerciseDurationMins) {
        this.exerciseDurationMins = exerciseDurationMins;
    }

    public String getAimDurationWeeks() {
        return this.aimDurationWeeks;
    }

    public void setAimDurationWeeks(String aimDurationWeeks) {
        this.aimDurationWeeks = aimDurationWeeks;
    }

    public String getExerciseDurationWeeks() {
        return this.exerciseDurationWeeks;
    }

    public void setExerciseDurationWeeks(String exerciseDurationWeeks) {
        this.exerciseDurationWeeks = exerciseDurationWeeks;
    }

    public String getAimExerciseFreqCode() {
        return this.aimExerciseFreqCode;
    }

    public void setAimExerciseFreqCode(String aimExerciseFreqCode) {
        this.aimExerciseFreqCode = aimExerciseFreqCode;
    }

    public String getExerciseFreqCode() {
        return this.exerciseFreqCode;
    }

    public void setExerciseFreqCode(String exerciseFreqCode) {
        this.exerciseFreqCode = exerciseFreqCode;
    }

    public Integer getAimDailyDrinking() {
        return this.aimDailyDrinking;
    }

    public void setAimDailyDrinking(Integer aimDailyDrinking) {
        this.aimDailyDrinking = aimDailyDrinking;
    }

    public Integer getDailyDrinking() {
        return this.dailyDrinking;
    }

    public void setDailyDrinking(Integer dailyDrinking) {
        this.dailyDrinking = dailyDrinking;
    }

    public Integer getAimDailySmoking() {
        return this.aimDailySmoking;
    }

    public void setAimDailySmoking(Integer aimDailySmoking) {
        this.aimDailySmoking = aimDailySmoking;
    }

    public Integer getDailySmoking() {
        return this.dailySmoking;
    }

    public void setDailySmoking(Integer dailySmoking) {
        this.dailySmoking = dailySmoking;
    }

    public String getOtherPositiveSigns() {
        return this.otherPositiveSigns;
    }

    public void setOtherPositiveSigns(String otherPositiveSigns) {
        this.otherPositiveSigns = otherPositiveSigns;
    }

    public String getPofdaCode() {
        return this.pofdaCode;
    }

    public void setPofdaCode(String pofdaCode) {
        this.pofdaCode = pofdaCode;
    }

    public Double getAimBmi() {
        return this.aimBmi;
    }

    public void setAimBmi(Double aimBmi) {
        this.aimBmi = aimBmi;
    }

    public Double getBmi() {
        return this.bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getAimWeight() {
        return this.aimWeight;
    }

    public void setAimWeight(Double aimWeight) {
        this.aimWeight = aimWeight;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getDbp() {
        return this.dbp;
    }

    public void setDbp(Integer dbp) {
        this.dbp = dbp;
    }

    public Integer getSbp() {
        return this.sbp;
    }

    public void setSbp(Integer sbp) {
        this.sbp = sbp;
    }

    public String getMissReason() {
        return this.missReason;
    }

    public void setMissReason(String missReason) {
        this.missReason = missReason;
    }

    public String getIsMiss() {
        return this.isMiss;
    }

    public void setIsMiss(String isMiss) {
        this.isMiss = isMiss;
    }

    public String getVisitType() {
        return this.visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public String getFollowupWayCode() {
        return this.followupWayCode;
    }

    public void setFollowupWayCode(String followupWayCode) {
        this.followupWayCode = followupWayCode;
    }

    public Date getFollowupDate() {
        return this.followupDate;
    }

    public void setFollowupDate(Date followupDate) {
        this.followupDate = followupDate;
    }

    public String getRespDoctorName() {
        return this.respDoctorName;
    }

    public void setRespDoctorName(String respDoctorName) {
        this.respDoctorName = respDoctorName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiabetesFollowupNo() {
        return this.diabetesFollowupNo;
    }

    public void setDiabetesFollowupNo(String diabetesFollowupNo) {
        this.diabetesFollowupNo = diabetesFollowupNo;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getDiabetesFollowupId() {
        return this.diabetesFollowupId;
    }

    public void setDiabetesFollowupId(String diabetesFollowupId) {
        this.diabetesFollowupId = diabetesFollowupId;
    }


    @Generated(hash = 1667230199)
    public DiabetesFollowup(String diabetesFollowupId, String personInfoId,
            String diabetesFollowupNo, String name, String respDoctorName,
            Date followupDate, String followupWayCode, String visitType,
            String isMiss, String missReason, Integer sbp, Integer dbp,
            Double weight, Double aimWeight, Double height, Double bmi,
            Double aimBmi, String pofdaCode, String otherPositiveSigns,
            Integer dailySmoking, Integer aimDailySmoking, Integer dailyDrinking,
            Integer aimDailyDrinking, String exerciseFreqCode,
            String aimExerciseFreqCode, String exerciseDurationWeeks,
            String aimDurationWeeks, Integer exerciseDurationMins,
            Integer aimExerciseMins, Integer dailyStaple, Integer aimDailyStaple,
            String psyAdjustResultCode, String complianceResultCode, Double fbg,
            Double pbg, Double ghb, Date ghbDate, String accessoryExam,
            String hypogReactCode, String visitEvalResultCode, String insulinType,
            Integer insulinUsingFreq, Integer insulinPerDose,
            String isReferralCode, String referralReason, String refertoOrgName,
            String refertoDeptName, Date nextFollowupDate, String followupDoctorId,
            String followupDoctorName, String drugComplianceCode,
            String drugAdverseCode, String drugAdverseDesc,
            String followupClassifyCode, Integer isCancel, String createOrgId,
            String orgName, String creatorId, String creator, Date createTime,
            String modifiedOrgId, String modifiedOrgName, String modifierId,
            String modifier, Date modifiedTime, String jsonDetail,
            String insulinUsingStr) {
        this.diabetesFollowupId = diabetesFollowupId;
        this.personInfoId = personInfoId;
        this.diabetesFollowupNo = diabetesFollowupNo;
        this.name = name;
        this.respDoctorName = respDoctorName;
        this.followupDate = followupDate;
        this.followupWayCode = followupWayCode;
        this.visitType = visitType;
        this.isMiss = isMiss;
        this.missReason = missReason;
        this.sbp = sbp;
        this.dbp = dbp;
        this.weight = weight;
        this.aimWeight = aimWeight;
        this.height = height;
        this.bmi = bmi;
        this.aimBmi = aimBmi;
        this.pofdaCode = pofdaCode;
        this.otherPositiveSigns = otherPositiveSigns;
        this.dailySmoking = dailySmoking;
        this.aimDailySmoking = aimDailySmoking;
        this.dailyDrinking = dailyDrinking;
        this.aimDailyDrinking = aimDailyDrinking;
        this.exerciseFreqCode = exerciseFreqCode;
        this.aimExerciseFreqCode = aimExerciseFreqCode;
        this.exerciseDurationWeeks = exerciseDurationWeeks;
        this.aimDurationWeeks = aimDurationWeeks;
        this.exerciseDurationMins = exerciseDurationMins;
        this.aimExerciseMins = aimExerciseMins;
        this.dailyStaple = dailyStaple;
        this.aimDailyStaple = aimDailyStaple;
        this.psyAdjustResultCode = psyAdjustResultCode;
        this.complianceResultCode = complianceResultCode;
        this.fbg = fbg;
        this.pbg = pbg;
        this.ghb = ghb;
        this.ghbDate = ghbDate;
        this.accessoryExam = accessoryExam;
        this.hypogReactCode = hypogReactCode;
        this.visitEvalResultCode = visitEvalResultCode;
        this.insulinType = insulinType;
        this.insulinUsingFreq = insulinUsingFreq;
        this.insulinPerDose = insulinPerDose;
        this.isReferralCode = isReferralCode;
        this.referralReason = referralReason;
        this.refertoOrgName = refertoOrgName;
        this.refertoDeptName = refertoDeptName;
        this.nextFollowupDate = nextFollowupDate;
        this.followupDoctorId = followupDoctorId;
        this.followupDoctorName = followupDoctorName;
        this.drugComplianceCode = drugComplianceCode;
        this.drugAdverseCode = drugAdverseCode;
        this.drugAdverseDesc = drugAdverseDesc;
        this.followupClassifyCode = followupClassifyCode;
        this.isCancel = isCancel;
        this.createOrgId = createOrgId;
        this.orgName = orgName;
        this.creatorId = creatorId;
        this.creator = creator;
        this.createTime = createTime;
        this.modifiedOrgId = modifiedOrgId;
        this.modifiedOrgName = modifiedOrgName;
        this.modifierId = modifierId;
        this.modifier = modifier;
        this.modifiedTime = modifiedTime;
        this.jsonDetail = jsonDetail;
        this.insulinUsingStr = insulinUsingStr;
    }

    @Generated(hash = 461903278)
    @Keep
    public DiabetesFollowup() {
        diabetesFollowupDrug = new ArrayList<>();
        recordChoice = new ArrayList<>();
    }

    

}