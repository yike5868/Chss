package net.greatsoft.main.db.po.smi;

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
 * 
 * @author AlphGo
 * @date 2016年7月7日 下午7:20:31
 * @Description: 严重精神障碍患者随访数据模型
 *
 */
@Entity
public class SmiFollowup  extends Entry {
	/**
	 * 严重精神障碍患者随访ID
	 */
	private String smiFollowupId;

	/**
	 * 个人档案ID
	 */
	private String personInfoId;

	/**
	 * 严重精神障碍患者随访编号
	 */
	private String smiFollowupNo;

	/**
	 * 本人姓名
	 */
	private String name;

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
	 * 危险性分级代码
	 */
	private String riskLevelCode;

	/**
	 * 自知力评价结果代码
	 */
	private String selfRecogEvalCode;

	/**
	 * 睡眠情况代码
	 */
	private String sleepQualityCode;

	/**
	 * 饮食情况代码
	 */
	private String dietQualityCode;

	/**
	 * 个人生活料理情况代码
	 */
	private String liveQualityCode;

	/**
	 * 家务劳动情况代码
	 */
	private String houseworkQualityCode;

	/**
	 * 生产劳动及工作情况代码
	 */
	private String workQualityCode;

	/**
	 * 学习能力情况代码
	 */
	private String studyQualityCode;

	/**
	 * 社会人际交往情况代码
	 */
	private String contactQualityCode;

	/**
	 * 危险行为/患病对社会家庭影响
	 */
	private String societyEffect;

	/**
	 * 轻度滋事
	 */
	private String lowRandalieren;

	/**
	 * 轻度滋事次数
	 */
	private Integer lowRandalierenTimes;

	/**
	 * 肇事
	 */
	private String causeTrouble;

	/**
	 * 肇事次数
	 */
	private Integer causeTroubleTimes;

	/**
	 * 肇祸
	 */
	private String accident;

	/**
	 * 肇祸次数
	 */
	private Integer accidentTimes;

	/**
	 * 其他危害行为
	 */
	private String otherHarm;

	/**
	 * 其他危害行为次数
	 */
	private Integer otherHarmTimes;

	/**
	 * 自伤
	 */
	private String autolesion;

	/**
	 * 自伤次数
	 */
	private Integer autolesionTimes;

	/**
	 * 自杀未遂
	 */
	private String incompleteSuicide;

	/**
	 * 自杀未遂次数
	 */
	private Integer incompleteSuicideTimes;
	/**
	 * 随访期间关锁情况代码
	 */
	private String lockCode;

	/**
	 * 随访期间住院情况
	 */
	private String followupInhosCode;

	/**
	 * 末次出院日期
	 */
	private Date outpatientDate;

	/**
	 * 实验室检查情况代码
	 */
	private String labExamCode;

	/**
	 * 实验室检查结果
	 */
	private String labExamResultDesc;

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
	 * 治疗效果
	 */
	private String treatmentEffectCode;

	/**
	 * 是否转诊代码
	 */
	private String isReferralCode;

	/**
	 * 转诊原因
	 */
	private String referralReason;

	/**
	 * 转入医疗机构名称
	 */
	private String refertoOrgName;

	/**
	 * 转入机构科室名称
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
	 * 此次随访分类
	 */
	private String followupClassifyCode;

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
	 * 从表 json串
	 */
	private String jsonDetail;
	@Transient
	List<SmiFollowupDrug> smiFollowupDrug;
	@Transient
	List<RecordChoice> recordChoice;

	/**
	 * 随访形式1.门诊2.家庭3.电话（第三版规范添加）
	 */
	private String visitFormal;

	/**
	 * 失访原因代码（第三版规范添加）
	 */
	private String visitReasonCode;

	/**
	 * 是否死亡（第三版规范添加）
	 */
	private String isDeath;

	/**
	 * 死亡日期（第三版规范添加）
	 */
	private Date deathDate;

	/**
	 * 死亡原因大类（第三版规范添加）
	 */
	private String deathReasonBig;

	/**
	 * 死亡原因小类（第三版规范添加）
	 */
	private String deathReasonSmall;

	public String getVisitFormal() {
		return visitFormal;
	}

	public void setVisitFormal(String visitFormal) {
		this.visitFormal = visitFormal;
	}

	public String getVisitReasonCode() {
		return visitReasonCode;
	}

	public void setVisitReasonCode(String visitReasonCode) {
		this.visitReasonCode = visitReasonCode;
	}

	public String getIsDeath() {
		return isDeath;
	}

	public void setIsDeath(String isDeath) {
		this.isDeath = isDeath;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathReasonBig() {
		return deathReasonBig;
	}

	public void setDeathReasonBig(String deathReasonBig) {
		this.deathReasonBig = deathReasonBig;
	}

	public String getDeathReasonSmall() {
		return deathReasonSmall;
	}

	public void setDeathReasonSmall(String deathReasonSmall) {
		this.deathReasonSmall = deathReasonSmall;
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

	public String getTreatmentEffectCode() {
		return this.treatmentEffectCode;
	}

	public void setTreatmentEffectCode(String treatmentEffectCode) {
		this.treatmentEffectCode = treatmentEffectCode;
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

	public String getLabExamResultDesc() {
		return this.labExamResultDesc;
	}

	public void setLabExamResultDesc(String labExamResultDesc) {
		this.labExamResultDesc = labExamResultDesc;
	}

	public String getLabExamCode() {
		return this.labExamCode;
	}

	public void setLabExamCode(String labExamCode) {
		this.labExamCode = labExamCode;
	}

	public Date getOutpatientDate() {
		return this.outpatientDate;
	}

	public void setOutpatientDate(Date outpatientDate) {
		this.outpatientDate = outpatientDate;
	}

	public String getFollowupInhosCode() {
		return this.followupInhosCode;
	}

	public void setFollowupInhosCode(String followupInhosCode) {
		this.followupInhosCode = followupInhosCode;
	}

	public String getLockCode() {
		return this.lockCode;
	}

	public void setLockCode(String lockCode) {
		this.lockCode = lockCode;
	}

	public Integer getIncompleteSuicideTimes() {
		return this.incompleteSuicideTimes;
	}

	public void setIncompleteSuicideTimes(Integer incompleteSuicideTimes) {
		this.incompleteSuicideTimes = incompleteSuicideTimes;
	}

	public String getIncompleteSuicide() {
		return this.incompleteSuicide;
	}

	public void setIncompleteSuicide(String incompleteSuicide) {
		this.incompleteSuicide = incompleteSuicide;
	}

	public Integer getAutolesionTimes() {
		return this.autolesionTimes;
	}

	public void setAutolesionTimes(Integer autolesionTimes) {
		this.autolesionTimes = autolesionTimes;
	}

	public String getAutolesion() {
		return this.autolesion;
	}

	public void setAutolesion(String autolesion) {
		this.autolesion = autolesion;
	}

	public Integer getOtherHarmTimes() {
		return this.otherHarmTimes;
	}

	public void setOtherHarmTimes(Integer otherHarmTimes) {
		this.otherHarmTimes = otherHarmTimes;
	}

	public String getOtherHarm() {
		return this.otherHarm;
	}

	public void setOtherHarm(String otherHarm) {
		this.otherHarm = otherHarm;
	}

	public Integer getAccidentTimes() {
		return this.accidentTimes;
	}

	public void setAccidentTimes(Integer accidentTimes) {
		this.accidentTimes = accidentTimes;
	}

	public String getAccident() {
		return this.accident;
	}

	public void setAccident(String accident) {
		this.accident = accident;
	}

	public Integer getCauseTroubleTimes() {
		return this.causeTroubleTimes;
	}

	public void setCauseTroubleTimes(Integer causeTroubleTimes) {
		this.causeTroubleTimes = causeTroubleTimes;
	}

	public String getCauseTrouble() {
		return this.causeTrouble;
	}

	public void setCauseTrouble(String causeTrouble) {
		this.causeTrouble = causeTrouble;
	}

	public Integer getLowRandalierenTimes() {
		return this.lowRandalierenTimes;
	}

	public void setLowRandalierenTimes(Integer lowRandalierenTimes) {
		this.lowRandalierenTimes = lowRandalierenTimes;
	}

	public String getLowRandalieren() {
		return this.lowRandalieren;
	}

	public void setLowRandalieren(String lowRandalieren) {
		this.lowRandalieren = lowRandalieren;
	}

	public String getSocietyEffect() {
		return this.societyEffect;
	}

	public void setSocietyEffect(String societyEffect) {
		this.societyEffect = societyEffect;
	}

	public String getContactQualityCode() {
		return this.contactQualityCode;
	}

	public void setContactQualityCode(String contactQualityCode) {
		this.contactQualityCode = contactQualityCode;
	}

	public String getStudyQualityCode() {
		return this.studyQualityCode;
	}

	public void setStudyQualityCode(String studyQualityCode) {
		this.studyQualityCode = studyQualityCode;
	}

	public String getWorkQualityCode() {
		return this.workQualityCode;
	}

	public void setWorkQualityCode(String workQualityCode) {
		this.workQualityCode = workQualityCode;
	}

	public String getHouseworkQualityCode() {
		return this.houseworkQualityCode;
	}

	public void setHouseworkQualityCode(String houseworkQualityCode) {
		this.houseworkQualityCode = houseworkQualityCode;
	}

	public String getLiveQualityCode() {
		return this.liveQualityCode;
	}

	public void setLiveQualityCode(String liveQualityCode) {
		this.liveQualityCode = liveQualityCode;
	}

	public String getDietQualityCode() {
		return this.dietQualityCode;
	}

	public void setDietQualityCode(String dietQualityCode) {
		this.dietQualityCode = dietQualityCode;
	}

	public String getSleepQualityCode() {
		return this.sleepQualityCode;
	}

	public void setSleepQualityCode(String sleepQualityCode) {
		this.sleepQualityCode = sleepQualityCode;
	}

	public String getSelfRecogEvalCode() {
		return this.selfRecogEvalCode;
	}

	public void setSelfRecogEvalCode(String selfRecogEvalCode) {
		this.selfRecogEvalCode = selfRecogEvalCode;
	}

	public String getRiskLevelCode() {
		return this.riskLevelCode;
	}

	public void setRiskLevelCode(String riskLevelCode) {
		this.riskLevelCode = riskLevelCode;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSmiFollowupNo() {
		return this.smiFollowupNo;
	}

	public void setSmiFollowupNo(String smiFollowupNo) {
		this.smiFollowupNo = smiFollowupNo;
	}

	public String getPersonInfoId() {
		return this.personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getSmiFollowupId() {
		return this.smiFollowupId;
	}

	public void setSmiFollowupId(String smiFollowupId) {
		this.smiFollowupId = smiFollowupId;
	}

	public List<SmiFollowupDrug> getSmiFollowupDrug() {
		return smiFollowupDrug;
	}

	public void setSmiFollowupDrug(List<SmiFollowupDrug> smiFollowupDrug) {
		this.smiFollowupDrug = smiFollowupDrug;
	}

	public List<RecordChoice> getRecordChoice() {
		return recordChoice;
	}

	public void setRecordChoice(List<RecordChoice> recordChoice) {
		this.recordChoice = recordChoice;
	}

	@Generated(hash = 617507814)
	public SmiFollowup(String smiFollowupId, String personInfoId,
			String smiFollowupNo, String name, Date followupDate, String followupWayCode,
			String visitType, String isMiss, String missReason, String riskLevelCode,
			String selfRecogEvalCode, String sleepQualityCode, String dietQualityCode,
			String liveQualityCode, String houseworkQualityCode, String workQualityCode,
			String studyQualityCode, String contactQualityCode, String societyEffect,
			String lowRandalieren, Integer lowRandalierenTimes, String causeTrouble,
			Integer causeTroubleTimes, String accident, Integer accidentTimes,
			String otherHarm, Integer otherHarmTimes, String autolesion,
			Integer autolesionTimes, String incompleteSuicide,
			Integer incompleteSuicideTimes, String lockCode, String followupInhosCode,
			Date outpatientDate, String labExamCode, String labExamResultDesc,
			String drugComplianceCode, String drugAdverseCode, String drugAdverseDesc,
			String treatmentEffectCode, String isReferralCode, String referralReason,
			String refertoOrgName, String refertoDeptName, Date nextFollowupDate,
			String followupDoctorId, String followupDoctorName,
			String followupClassifyCode, Integer isCancel, String createOrgId,
			String orgName, String creatorId, String creator, Date createTime,
			String modifiedOrgId, String modifiedOrgName, String modifierId,
			String modifier, Date modifiedTime, String jsonDetail, String visitFormal,
			String visitReasonCode, String isDeath, Date deathDate,
			String deathReasonBig, String deathReasonSmall) {
		this.smiFollowupId = smiFollowupId;
		this.personInfoId = personInfoId;
		this.smiFollowupNo = smiFollowupNo;
		this.name = name;
		this.followupDate = followupDate;
		this.followupWayCode = followupWayCode;
		this.visitType = visitType;
		this.isMiss = isMiss;
		this.missReason = missReason;
		this.riskLevelCode = riskLevelCode;
		this.selfRecogEvalCode = selfRecogEvalCode;
		this.sleepQualityCode = sleepQualityCode;
		this.dietQualityCode = dietQualityCode;
		this.liveQualityCode = liveQualityCode;
		this.houseworkQualityCode = houseworkQualityCode;
		this.workQualityCode = workQualityCode;
		this.studyQualityCode = studyQualityCode;
		this.contactQualityCode = contactQualityCode;
		this.societyEffect = societyEffect;
		this.lowRandalieren = lowRandalieren;
		this.lowRandalierenTimes = lowRandalierenTimes;
		this.causeTrouble = causeTrouble;
		this.causeTroubleTimes = causeTroubleTimes;
		this.accident = accident;
		this.accidentTimes = accidentTimes;
		this.otherHarm = otherHarm;
		this.otherHarmTimes = otherHarmTimes;
		this.autolesion = autolesion;
		this.autolesionTimes = autolesionTimes;
		this.incompleteSuicide = incompleteSuicide;
		this.incompleteSuicideTimes = incompleteSuicideTimes;
		this.lockCode = lockCode;
		this.followupInhosCode = followupInhosCode;
		this.outpatientDate = outpatientDate;
		this.labExamCode = labExamCode;
		this.labExamResultDesc = labExamResultDesc;
		this.drugComplianceCode = drugComplianceCode;
		this.drugAdverseCode = drugAdverseCode;
		this.drugAdverseDesc = drugAdverseDesc;
		this.treatmentEffectCode = treatmentEffectCode;
		this.isReferralCode = isReferralCode;
		this.referralReason = referralReason;
		this.refertoOrgName = refertoOrgName;
		this.refertoDeptName = refertoDeptName;
		this.nextFollowupDate = nextFollowupDate;
		this.followupDoctorId = followupDoctorId;
		this.followupDoctorName = followupDoctorName;
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
		this.visitFormal = visitFormal;
		this.visitReasonCode = visitReasonCode;
		this.isDeath = isDeath;
		this.deathDate = deathDate;
		this.deathReasonBig = deathReasonBig;
		this.deathReasonSmall = deathReasonSmall;
	}

	@Generated(hash = 523074590)
	@Keep
	public SmiFollowup() {
		 smiFollowupDrug = new ArrayList<>();
		 recordChoice = new ArrayList<>();
	}


}