/*
 * $Id: codetemplates.xml 2918 2014-01-22 15:29:26Z hn $
 * 版权所有 2016 冠新软件。
 * 保留所有权利。
 */
package net.greatsoft.main.db.po.hyperinfo;

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
 * @author hn
 * @date 2016年6月24日 下午4:17:20
 * @Description: 高血压患者随访表
 * 
 */
@Entity
public class HyperFollowup extends Entry {

	/**
	 * 高血压患者随访ID
	 */
	private String hyperFollowupId;

	/**
	 * 个人档案ID
	 */
	private String personInfoId;

	/**
	 * 高血压患者随访编号
	 */
	private String hyperFollowupNo;

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
	 * 腰围(cm)
	 */
	private Double waist;

	/**
	 * 体质指数
	 */
	private Double bmi;

	/**
	 * 目标体质指数
	 */
	private Double aimBmi;

	/**
	 * 心率（次/分钟）
	 */
	private Integer heartRate;

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
	 * 摄盐量分级代码
	 */
	private String saltTakenLevelCode;

	/**
	 * 目标摄盐量分级代码
	 */
	private String aimSalttakenLevelCode;

	/**
	 * 心理调整评价结果代码
	 */
	private String psyAdjustResultCode;

	/**
	 * 遵医行为评价结果代码
	 */
	private String complianceResultCode;

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
	 * 本次随访医师ID
	 */
	private String followupDoctorId;

	/**
	 * 本次随访医师姓名
	 */
	private String followupDoctorName;

	/**
	 * 辅助检查
	 */
	private String accessoryExam;

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
	 * 此次随访分类/随访评价结果代码
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
	 * 选项指标记录 json串
	 */
	private String jsonDetail;
	@Transient
	List<HyperFollowupDrug> hyperFollowupDrug;

	@Transient
	private List<RecordChoice> recordChoice;

	public List<RecordChoice> getRecordChoice() {
		return recordChoice;
	}

	public void setRecordChoice(List<RecordChoice> recordChoice) {
		this.recordChoice = recordChoice;
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

	public String getAccessoryExam() {
		return this.accessoryExam;
	}

	public void setAccessoryExam(String accessoryExam) {
		this.accessoryExam = accessoryExam;
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

	public String getAimSalttakenLevelCode() {
		return this.aimSalttakenLevelCode;
	}

	public void setAimSalttakenLevelCode(String aimSalttakenLevelCode) {
		this.aimSalttakenLevelCode = aimSalttakenLevelCode;
	}

	public String getSaltTakenLevelCode() {
		return this.saltTakenLevelCode;
	}

	public void setSaltTakenLevelCode(String saltTakenLevelCode) {
		this.saltTakenLevelCode = saltTakenLevelCode;
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

	public Integer getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
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

	public Double getWaist() {
		return this.waist;
	}

	public void setWaist(Double waist) {
		this.waist = waist;
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

	public String getHyperFollowupNo() {
		return this.hyperFollowupNo;
	}

	public void setHyperFollowupNo(String hyperFollowupNo) {
		this.hyperFollowupNo = hyperFollowupNo;
	}

	public String getPersonInfoId() {
		return this.personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getHyperFollowupId() {
		return this.hyperFollowupId;
	}

	public void setHyperFollowupId(String hyperFollowupId) {
		this.hyperFollowupId = hyperFollowupId;
	}

	public List<HyperFollowupDrug> getHyperFollowupDrug() {
		return hyperFollowupDrug;
	}

	public void setHyperFollowupDrug(List<HyperFollowupDrug> hyperFollowupDrug) {
		this.hyperFollowupDrug = hyperFollowupDrug;
	}

	@Generated(hash = 634894235)
	public HyperFollowup(String hyperFollowupId, String personInfoId,
			String hyperFollowupNo, String name, String respDoctorName,
			Date followupDate, String followupWayCode, String visitType, String isMiss,
			String missReason, Integer sbp, Integer dbp, Double weight, Double aimWeight,
			Double height, Double waist, Double bmi, Double aimBmi, Integer heartRate,
			String otherPositiveSigns, Integer dailySmoking, Integer aimDailySmoking,
			Integer dailyDrinking, Integer aimDailyDrinking, String exerciseFreqCode,
			String aimExerciseFreqCode, Integer exerciseDurationWeeks,
			Integer aimDurationWeeks, Integer exerciseDurationMins,
			Integer aimExerciseMins, String saltTakenLevelCode,
			String aimSalttakenLevelCode, String psyAdjustResultCode,
			String complianceResultCode, String isReferralCode, String referralReason,
			String refertoOrgName, String refertoDeptName, Date nextFollowupDate,
			String followupDoctorId, String followupDoctorName, String accessoryExam,
			String drugComplianceCode, String drugAdverseCode, String drugAdverseDesc,
			String followupClassifyCode, Integer isCancel, String createOrgId,
			String orgName, String creatorId, String creator, Date createTime,
			String modifiedOrgId, String modifiedOrgName, String modifierId,
			String modifier, Date modifiedTime, String jsonDetail) {
		this.hyperFollowupId = hyperFollowupId;
		this.personInfoId = personInfoId;
		this.hyperFollowupNo = hyperFollowupNo;
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
		this.waist = waist;
		this.bmi = bmi;
		this.aimBmi = aimBmi;
		this.heartRate = heartRate;
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
		this.saltTakenLevelCode = saltTakenLevelCode;
		this.aimSalttakenLevelCode = aimSalttakenLevelCode;
		this.psyAdjustResultCode = psyAdjustResultCode;
		this.complianceResultCode = complianceResultCode;
		this.isReferralCode = isReferralCode;
		this.referralReason = referralReason;
		this.refertoOrgName = refertoOrgName;
		this.refertoDeptName = refertoDeptName;
		this.nextFollowupDate = nextFollowupDate;
		this.followupDoctorId = followupDoctorId;
		this.followupDoctorName = followupDoctorName;
		this.accessoryExam = accessoryExam;
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
	}

	@Generated(hash = 1597212996)@Keep
	public HyperFollowup() {
		recordChoice = new ArrayList<>();
		hyperFollowupDrug = new ArrayList<>();
	}



}
