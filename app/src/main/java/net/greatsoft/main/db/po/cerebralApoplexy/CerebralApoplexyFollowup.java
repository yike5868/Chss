package net.greatsoft.main.db.po.cerebralApoplexy;

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
 * @date 2016年11月14日 下午3:37:31
 * @Description: 脑卒中随访
 */
@Entity
public class CerebralApoplexyFollowup extends Entry {
    /**
     * 脑卒中患者随访服务记录表ID
     */
    private String cerebralApoplexyFollowupId;

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
     * 身高（cm)
     */
    private Double height;

    /**
     * 体重(kg)
     */
    private Double weight;

    /**
     * 目标体重(kg)
     */
    private Double aimWeight;

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
     * 腰围(cm)
     */
    private Double waist;

    /**
     * 心率(次/min)
     */
    private Integer heartRate;

    /**
     * 空腹血糖值（mmol/L)
     */
    private Double fbgMmol;

    /**
     * 餐后2小时血糖值（mmol/L)
     */
    private Double pbgMmol;

    /**
     * 其他
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
     * 运动时长（min/次)
     */
    private Integer exerciseDurationMins;

    /**
     * 目标运动时长（min/次)
     */
    private Integer aimExerciseMins;

    /**
     * 心理调整评价结果代码
     */
    private String psyAdjustResultCode;

    /**
     * 遵医行为评价结果代码
     */
    private String complianceResultCode;

    /**
     * 生活自理能力自我评估代码
     */
    private String selfCareAssessCode;

    /**
     * 是否用药
     */
    private String hasUseDrugs;

    /**
     * 服药依从性代码
     */
    private String drugComplianceCode;

    /**
     * 药物不良反应代码
     */
    private String adverseReactionsCode;

    /**
     * 药物不良反应中文
     */
    private String adverseReactionsValue;

    /**
     * 此次随访分类/随访评价结果代码
     */
    private String followupClassifyCode;

    /**
     * 肢体功能恢复状况
     */
    private String recoveryStatus;

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
     * 选项指标记录
     */
    @Transient
    List<RecordChoice> recordChoice;

    @Transient
    List<CaInfoDrugs> caInfoDrug;

    public List<RecordChoice> getRecordChoice() {
        return recordChoice;
    }

    public void setRecordChoice(List<RecordChoice> recordChoice) {
        this.recordChoice = recordChoice;
    }

    public List<CaInfoDrugs> getCaInfoDrug() {
        return caInfoDrug;
    }

    public void setCaInfoDrug(List<CaInfoDrugs> caInfoDrug) {
        this.caInfoDrug = caInfoDrug;
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

    public String getRecoveryStatus() {
        return this.recoveryStatus;
    }

    public void setRecoveryStatus(String recoveryStatus) {
        this.recoveryStatus = recoveryStatus;
    }

    public String getFollowupClassifyCode() {
        return this.followupClassifyCode;
    }

    public void setFollowupClassifyCode(String followupClassifyCode) {
        this.followupClassifyCode = followupClassifyCode;
    }

    public String getAdverseReactionsValue() {
        return this.adverseReactionsValue;
    }

    public void setAdverseReactionsValue(String adverseReactionsValue) {
        this.adverseReactionsValue = adverseReactionsValue;
    }

    public String getAdverseReactionsCode() {
        return this.adverseReactionsCode;
    }

    public void setAdverseReactionsCode(String adverseReactionsCode) {
        this.adverseReactionsCode = adverseReactionsCode;
    }

    public String getDrugComplianceCode() {
        return this.drugComplianceCode;
    }

    public void setDrugComplianceCode(String drugComplianceCode) {
        this.drugComplianceCode = drugComplianceCode;
    }

    public String getHasUseDrugs() {
        return this.hasUseDrugs;
    }

    public void setHasUseDrugs(String hasUseDrugs) {
        this.hasUseDrugs = hasUseDrugs;
    }

    public String getSelfCareAssessCode() {
        return this.selfCareAssessCode;
    }

    public void setSelfCareAssessCode(String selfCareAssessCode) {
        this.selfCareAssessCode = selfCareAssessCode;
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

    public String getOtherPositiveSigns() {
        return this.otherPositiveSigns;
    }

    public void setOtherPositiveSigns(String otherPositiveSigns) {
        this.otherPositiveSigns = otherPositiveSigns;
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

    public Integer getHeartRate() {
        return this.heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Double getWaist() {
        return this.waist;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
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

    public Double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
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

    public String getCerebralApoplexyFollowupId() {
        return this.cerebralApoplexyFollowupId;
    }

    public void setCerebralApoplexyFollowupId(String cerebralApoplexyFollowupId) {
        this.cerebralApoplexyFollowupId = cerebralApoplexyFollowupId;
    }

    @Generated(hash = 1547791859)
    public CerebralApoplexyFollowup(String cerebralApoplexyFollowupId,
                                    String personInfoId, String chdFollowupNo, Date followupDate,
                                    String followupWayCode, Double height, Double weight, Double aimWeight,
                                    Double bmi, Double aimBmi, Integer sbp, Integer dbp, Double waist,
                                    Integer heartRate, Double fbgMmol, Double pbgMmol,
                                    String otherPositiveSigns, Integer dailySmoking,
                                    Integer aimDailySmoking, Double dailyDrinking, Double aimDailyDrinking,
                                    Integer exerciseDurationWeeks, Integer aimDurationWeeks,
                                    Integer exerciseDurationMins, Integer aimExerciseMins,
                                    String psyAdjustResultCode, String complianceResultCode,
                                    String selfCareAssessCode, String hasUseDrugs,
                                    String drugComplianceCode, String adverseReactionsCode,
                                    String adverseReactionsValue, String followupClassifyCode,
                                    String recoveryStatus, Date nextFollowupDate, String followupDoctorId,
                                    String followupDoctorName, String followupDoctorAdvise,
                                    Integer isCancel, String createOrgId, String orgName, String creatorId,
                                    String creator, Date createTime, String modifiedOrgId,
                                    String modifiedOrgName, String modifierId, String modifier,
                                    Date modifiedTime, String jsonDetail, Integer assessmentCount,
                                    Integer missingCount, Double intactRate) {
        this.cerebralApoplexyFollowupId = cerebralApoplexyFollowupId;
        this.personInfoId = personInfoId;
        this.chdFollowupNo = chdFollowupNo;
        this.followupDate = followupDate;
        this.followupWayCode = followupWayCode;
        this.height = height;
        this.weight = weight;
        this.aimWeight = aimWeight;
        this.bmi = bmi;
        this.aimBmi = aimBmi;
        this.sbp = sbp;
        this.dbp = dbp;
        this.waist = waist;
        this.heartRate = heartRate;
        this.fbgMmol = fbgMmol;
        this.pbgMmol = pbgMmol;
        this.otherPositiveSigns = otherPositiveSigns;
        this.dailySmoking = dailySmoking;
        this.aimDailySmoking = aimDailySmoking;
        this.dailyDrinking = dailyDrinking;
        this.aimDailyDrinking = aimDailyDrinking;
        this.exerciseDurationWeeks = exerciseDurationWeeks;
        this.aimDurationWeeks = aimDurationWeeks;
        this.exerciseDurationMins = exerciseDurationMins;
        this.aimExerciseMins = aimExerciseMins;
        this.psyAdjustResultCode = psyAdjustResultCode;
        this.complianceResultCode = complianceResultCode;
        this.selfCareAssessCode = selfCareAssessCode;
        this.hasUseDrugs = hasUseDrugs;
        this.drugComplianceCode = drugComplianceCode;
        this.adverseReactionsCode = adverseReactionsCode;
        this.adverseReactionsValue = adverseReactionsValue;
        this.followupClassifyCode = followupClassifyCode;
        this.recoveryStatus = recoveryStatus;
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

    @Generated(hash = 1568058585)
    @Keep
    public CerebralApoplexyFollowup() {
        caInfoDrug = new ArrayList<>();
        recordChoice = new ArrayList<>();
    }

}
