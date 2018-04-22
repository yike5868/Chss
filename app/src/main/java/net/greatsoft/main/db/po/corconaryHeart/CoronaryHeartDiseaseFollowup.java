package net.greatsoft.main.db.po.corconaryHeart;

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
 * @author HS
 * @date 2016年11月14日 下午3:38:21
 * @Description: 冠心病随访
 */
@Entity
public class CoronaryHeartDiseaseFollowup extends Entry {
    /**
     * 冠心病患者随访记录表ID
     */
    private String chdFollowupId;

    /**
     * 个人档案ID
     */
    private String personInfoId;

    /**
     * 健康档案编号
     */
    private String chdFollowupNo;

    /**
     * 本次随访日期
     */
    private Date followupDate;

    /**
     * 随访方式代码
     */
    private String followupWayCode;

    /**
     * 心率(次/min)
     */
    private Integer heartRate;

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
     * 收缩压(mmHg)
     */
    private Integer sbp;

    /**
     * 舒张压(mmHg)
     */
    private Integer dbp;

    /**
     * 空腹血糖值（mmol/L)
     */
    private Double fbgMmol;

    /**
     * 餐后2小时血糖值（mmol/L)
     */
    private Double pbgMmol;

    /**
     * 总胆固醇值（mmol/L)
     */
    private Double tcho;

    /**
     * 甘油三酯值（mmol/L)
     */
    private Double tg;

    /**
     * 血清低密度脂蛋白胆固醇检测值（mmol/L)
     */
    private Double ldlc;

    /**
     * 血淸高密度脂蛋白胆固醇检测值(mmol/L)
     */
    private Double hdlc;

    /**
     * 心电图检查结果
     */
    private String ecgAbnormResult;

    /**
     * 心脏彩超检查结果
     */
    private String heartCheckResult;

    /**
     * 冠状动脉造影结果
     */
    private String coronaryArteryResult;

    /**
     * 心电图运动负荷试验结果
     */
    private String ecgExerciseResult;

    /**
     * 心肌酶学检查结果（u/L）
     */
    private String cardiacEnzymesResult;

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
    private Double dailyDrinking;

    /**
     * 目标日饮酒量（两）
     */
    private Double aimDailyDrinking;

    /**
     * 运动次/周
     */
    private Integer exerciseDurationWeeks;

    /**
     * 目标运动次/周
     */
    private Integer aimDurationWeeks;

    /**
     * 运动时长（min)
     */
    private Integer exerciseDurationMins;

    /**
     * 目标运动时长（min)
     */
    private Integer aimExerciseMins;

    /**
     * 此次随访分类/随访评价结果代码
     */
    private String followupClassifyCode;

    /**
     * 服药依从性代码
     */
    private String drugComplianceCode;

    /**
     * 心理调整评价结果代码
     */
    private String psyAdjustResultCode;

    /**
     * 遵医行为评价结果代码
     */
    private String complianceResultCode;

    /**
     * 下次随访日期
     */
    private Date nextFollowupDate;

    /**
     * 本次随访医师ID
     */
    private String followupDoctorId;

    /**
     * 本次随访医师姓名
     */
    private String followupDoctorName;

    /**
     * 本次随访医生建议
     */
    private String followupDoctorAdvise;

    /**
     * 是否删除
     */
    private Integer isCancel;

    /**
     * 录入机构ID
     */
    private String createOrgId;

    /**
     * 录入机构名称
     */
    private String orgName;

    /**
     * 录入人ID
     */
    private String creatorId;

    /**
     * 录入人姓名
     */
    private String creator;

    /**
     * 录入时间
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
     * 选项指标记录 json串
     */
    private String jsonDetail;


    /**
     * 考核项总数
     */
    private Integer assessmentCount;

    /**
     * 考核未通过数
     */
    private Integer missingCount;

    /**
     * 完整率
     */
    private Double intactRate;

    /**
     * 冠心病患者随访信息用药
     */
    @Transient
    List<ChdInfoDrugs> chdInfoDrug;

    @Transient
    List<RecordChoice> recordChoice;

    public List<ChdInfoDrugs> getChdInfoDrug() {
        return chdInfoDrug;
    }

    public void setChdInfoDrug(List<ChdInfoDrugs> chdInfoDrug) {
        this.chdInfoDrug = chdInfoDrug;
    }

    public List<RecordChoice> getRecordChoice() {
        return recordChoice;
    }

    public void setRecordChoice(List<RecordChoice> recordChoice) {
        this.recordChoice = recordChoice;
    }

    public Double getIntactRate() {
        return this.intactRate;
    }

    public void setIntactRate(Double intactRate) {
        this.intactRate = intactRate;
    }

    public Integer getMissingCount() {
        return this.missingCount;
    }

    public void setMissingCount(Integer missingCount) {
        this.missingCount = missingCount;
    }

    public Integer getAssessmentCount() {
        return this.assessmentCount;
    }

    public void setAssessmentCount(Integer assessmentCount) {
        this.assessmentCount = assessmentCount;
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

    public String getFollowupDoctorAdvise() {
        return this.followupDoctorAdvise;
    }

    public void setFollowupDoctorAdvise(String followupDoctorAdvise) {
        this.followupDoctorAdvise = followupDoctorAdvise;
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

    public String getDrugComplianceCode() {
        return this.drugComplianceCode;
    }

    public void setDrugComplianceCode(String drugComplianceCode) {
        this.drugComplianceCode = drugComplianceCode;
    }

    public String getFollowupClassifyCode() {
        return this.followupClassifyCode;
    }

    public void setFollowupClassifyCode(String followupClassifyCode) {
        this.followupClassifyCode = followupClassifyCode;
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

    public Integer getAimDurationWeeks() {
        return this.aimDurationWeeks;
    }

    public void setAimDurationWeeks(Integer aimDurationWeeks) {
        this.aimDurationWeeks = aimDurationWeeks;
    }

    public Integer getExerciseDurationWeeks() {
        return this.exerciseDurationWeeks;
    }

    public void setExerciseDurationWeeks(Integer exerciseDurationWeeks) {
        this.exerciseDurationWeeks = exerciseDurationWeeks;
    }

    public Double getAimDailyDrinking() {
        return this.aimDailyDrinking;
    }

    public void setAimDailyDrinking(Double aimDailyDrinking) {
        this.aimDailyDrinking = aimDailyDrinking;
    }

    public Double getDailyDrinking() {
        return this.dailyDrinking;
    }

    public void setDailyDrinking(Double dailyDrinking) {
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

    public String getCardiacEnzymesResult() {
        return this.cardiacEnzymesResult;
    }

    public void setCardiacEnzymesResult(String cardiacEnzymesResult) {
        this.cardiacEnzymesResult = cardiacEnzymesResult;
    }

    public String getEcgExerciseResult() {
        return this.ecgExerciseResult;
    }

    public void setEcgExerciseResult(String ecgExerciseResult) {
        this.ecgExerciseResult = ecgExerciseResult;
    }

    public String getCoronaryArteryResult() {
        return this.coronaryArteryResult;
    }

    public void setCoronaryArteryResult(String coronaryArteryResult) {
        this.coronaryArteryResult = coronaryArteryResult;
    }

    public String getHeartCheckResult() {
        return this.heartCheckResult;
    }

    public void setHeartCheckResult(String heartCheckResult) {
        this.heartCheckResult = heartCheckResult;
    }

    public String getEcgAbnormResult() {
        return this.ecgAbnormResult;
    }

    public void setEcgAbnormResult(String ecgAbnormResult) {
        this.ecgAbnormResult = ecgAbnormResult;
    }

    public Double getHdlc() {
        return this.hdlc;
    }

    public void setHdlc(Double hdlc) {
        this.hdlc = hdlc;
    }

    public Double getLdlc() {
        return this.ldlc;
    }

    public void setLdlc(Double ldlc) {
        this.ldlc = ldlc;
    }

    public Double getTg() {
        return this.tg;
    }

    public void setTg(Double tg) {
        this.tg = tg;
    }

    public Double getTcho() {
        return this.tcho;
    }

    public void setTcho(Double tcho) {
        this.tcho = tcho;
    }

    public Double getPbgMmol() {
        return this.pbgMmol;
    }

    public void setPbgMmol(Double pbgMmol) {
        this.pbgMmol = pbgMmol;
    }

    public Double getFbgMmol() {
        return this.fbgMmol;
    }

    public void setFbgMmol(Double fbgMmol) {
        this.fbgMmol = fbgMmol;
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

    public Integer getHeartRate() {
        return this.heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
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

    public String getChdFollowupNo() {
        return this.chdFollowupNo;
    }

    public void setChdFollowupNo(String chdFollowupNo) {
        this.chdFollowupNo = chdFollowupNo;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getChdFollowupId() {
        return this.chdFollowupId;
    }

    public void setChdFollowupId(String chdFollowupId) {
        this.chdFollowupId = chdFollowupId;
    }

    @Generated(hash = 1772027668)
    public CoronaryHeartDiseaseFollowup(String chdFollowupId, String personInfoId,
                                        String chdFollowupNo, Date followupDate, String followupWayCode,
                                        Integer heartRate, Double weight, Double aimWeight, Double height,
                                        Double bmi, Double aimBmi, Integer sbp, Integer dbp, Double fbgMmol,
                                        Double pbgMmol, Double tcho, Double tg, Double ldlc, Double hdlc,
                                        String ecgAbnormResult, String heartCheckResult,
                                        String coronaryArteryResult, String ecgExerciseResult,
                                        String cardiacEnzymesResult, Integer dailySmoking,
                                        Integer aimDailySmoking, Double dailyDrinking, Double aimDailyDrinking,
                                        Integer exerciseDurationWeeks, Integer aimDurationWeeks,
                                        Integer exerciseDurationMins, Integer aimExerciseMins,
                                        String followupClassifyCode, String drugComplianceCode,
                                        String psyAdjustResultCode, String complianceResultCode,
                                        Date nextFollowupDate, String followupDoctorId,
                                        String followupDoctorName, String followupDoctorAdvise,
                                        Integer isCancel, String createOrgId, String orgName, String creatorId,
                                        String creator, Date createTime, String modifiedOrgId,
                                        String modifiedOrgName, String modifierId, String modifier,
                                        Date modifiedTime, String jsonDetail, Integer assessmentCount,
                                        Integer missingCount, Double intactRate) {
        this.chdFollowupId = chdFollowupId;
        this.personInfoId = personInfoId;
        this.chdFollowupNo = chdFollowupNo;
        this.followupDate = followupDate;
        this.followupWayCode = followupWayCode;
        this.heartRate = heartRate;
        this.weight = weight;
        this.aimWeight = aimWeight;
        this.height = height;
        this.bmi = bmi;
        this.aimBmi = aimBmi;
        this.sbp = sbp;
        this.dbp = dbp;
        this.fbgMmol = fbgMmol;
        this.pbgMmol = pbgMmol;
        this.tcho = tcho;
        this.tg = tg;
        this.ldlc = ldlc;
        this.hdlc = hdlc;
        this.ecgAbnormResult = ecgAbnormResult;
        this.heartCheckResult = heartCheckResult;
        this.coronaryArteryResult = coronaryArteryResult;
        this.ecgExerciseResult = ecgExerciseResult;
        this.cardiacEnzymesResult = cardiacEnzymesResult;
        this.dailySmoking = dailySmoking;
        this.aimDailySmoking = aimDailySmoking;
        this.dailyDrinking = dailyDrinking;
        this.aimDailyDrinking = aimDailyDrinking;
        this.exerciseDurationWeeks = exerciseDurationWeeks;
        this.aimDurationWeeks = aimDurationWeeks;
        this.exerciseDurationMins = exerciseDurationMins;
        this.aimExerciseMins = aimExerciseMins;
        this.followupClassifyCode = followupClassifyCode;
        this.drugComplianceCode = drugComplianceCode;
        this.psyAdjustResultCode = psyAdjustResultCode;
        this.complianceResultCode = complianceResultCode;
        this.nextFollowupDate = nextFollowupDate;
        this.followupDoctorId = followupDoctorId;
        this.followupDoctorName = followupDoctorName;
        this.followupDoctorAdvise = followupDoctorAdvise;
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
        this.assessmentCount = assessmentCount;
        this.missingCount = missingCount;
        this.intactRate = intactRate;
    }

    @Generated(hash = 66077514)
    @Keep
    public CoronaryHeartDiseaseFollowup() {
        recordChoice = new ArrayList<>();
        chdInfoDrug = new ArrayList<>();
    }

}
