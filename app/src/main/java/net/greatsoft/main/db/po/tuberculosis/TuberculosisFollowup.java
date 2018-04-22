package net.greatsoft.main.db.po.tuberculosis;

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
 * @author hn
 * @date 2016年7月6日 下午5:54:51
 * @Description: 肺结核患者随访
 *
 */
@Entity
public class TuberculosisFollowup extends Entry{
	/**
	 * 肺结核患者随访ID
	 */
	
	private String tuberculosisFollowupId;

	/**
	 * 肺结核档案ID
	 */
	
	private String tuberculosisInfoId;

	/**
	 * 个人档案ID
	 */
	
	private String personInfoId;

	/**
	 * 肺结核患者随访编号
	 */
	
	private String tuberculosisFollowupNo;

	/**
	 * 治疗月数
	 */
	private Integer trentmentMonth;

	/**
	 * 督导人员类别代码
	 */
	
	private String superviseTypeCode;

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
	 * 化疗方案
	 */
	
	private String chemotherapyCode;

	/**
	 * 化疗方案结果
	 */
	private String chemotherapyValue;

	/**
	 * 药物用法代码
	 */
	
	private String drugUseCode;

	/**
	 * 漏服药次数
	 */
	private Integer loseDrugTimes;

	/**
	 * 药物不良反应代码
	 */
	
	private String drugAdverseCode;

	/**
	 * 药物不良反应描述
	 */
	
	private String drugAdverseDesc;

	/**
	 * 并发症或合并症代码
	 */
	
	private String complicationCode;

	/**
	 * 并发症或合并症描述
	 */
	
	private String complicationDesc;

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
	 * 转诊两周内随访结果
	 */
	
	private String getMedicinePlace;

	/**
	 * 处理意见
	 */
	
	private String suggestion;

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
	 * 选项指标记录，用来前后交互传输数据使用的
	 */
	@Transient
	private List<RecordChoice> recordChoice;

	public List<RecordChoice> getRecordChoice() {
		return recordChoice;
	}

	public void setRecordChoice(List<RecordChoice> recordChoice) {
		this.recordChoice = recordChoice;
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

	public String getSuggestion() {
		return this.suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getGetMedicinePlace() {
		return this.getMedicinePlace;
	}

	public void setGetMedicinePlace(String getMedicinePlace) {
		this.getMedicinePlace = getMedicinePlace;
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

	public String getComplicationDesc() {
		return this.complicationDesc;
	}

	public void setComplicationDesc(String complicationDesc) {
		this.complicationDesc = complicationDesc;
	}

	public String getComplicationCode() {
		return this.complicationCode;
	}

	public void setComplicationCode(String complicationCode) {
		this.complicationCode = complicationCode;
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

	public Integer getLoseDrugTimes() {
		return this.loseDrugTimes;
	}

	public void setLoseDrugTimes(Integer loseDrugTimes) {
		this.loseDrugTimes = loseDrugTimes;
	}

	public String getDrugUseCode() {
		return this.drugUseCode;
	}

	public void setDrugUseCode(String drugUseCode) {
		this.drugUseCode = drugUseCode;
	}

	public String getChemotherapyValue() {
		return this.chemotherapyValue;
	}

	public void setChemotherapyValue(String chemotherapyValue) {
		this.chemotherapyValue = chemotherapyValue;
	}

	public String getChemotherapyCode() {
		return this.chemotherapyCode;
	}

	public void setChemotherapyCode(String chemotherapyCode) {
		this.chemotherapyCode = chemotherapyCode;
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

	public String getSuperviseTypeCode() {
		return this.superviseTypeCode;
	}

	public void setSuperviseTypeCode(String superviseTypeCode) {
		this.superviseTypeCode = superviseTypeCode;
	}

	public Integer getTrentmentMonth() {
		return this.trentmentMonth;
	}

	public void setTrentmentMonth(Integer trentmentMonth) {
		this.trentmentMonth = trentmentMonth;
	}

	public String getTuberculosisFollowupNo() {
		return this.tuberculosisFollowupNo;
	}

	public void setTuberculosisFollowupNo(String tuberculosisFollowupNo) {
		this.tuberculosisFollowupNo = tuberculosisFollowupNo;
	}

	public String getPersonInfoId() {
		return this.personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getTuberculosisInfoId() {
		return this.tuberculosisInfoId;
	}

	public void setTuberculosisInfoId(String tuberculosisInfoId) {
		this.tuberculosisInfoId = tuberculosisInfoId;
	}

	public String getTuberculosisFollowupId() {
		return this.tuberculosisFollowupId;
	}

	public void setTuberculosisFollowupId(String tuberculosisFollowupId) {
		this.tuberculosisFollowupId = tuberculosisFollowupId;
	}

	@Generated(hash = 1621060491)
	public TuberculosisFollowup(String tuberculosisFollowupId,
			String tuberculosisInfoId, String personInfoId,
			String tuberculosisFollowupNo, Integer trentmentMonth,
			String superviseTypeCode, String name, Date followupDate,
			String followupWayCode, Integer dailySmoking, Integer aimDailySmoking,
			Integer dailyDrinking, Integer aimDailyDrinking, String chemotherapyCode,
			String chemotherapyValue, String drugUseCode, Integer loseDrugTimes,
			String drugAdverseCode, String drugAdverseDesc, String complicationCode,
			String complicationDesc, String isReferralCode, String referralReason,
			String refertoOrgName, String refertoDeptName, String getMedicinePlace,
			String suggestion, Date nextFollowupDate, String followupDoctorId,
			String followupDoctorName, Integer isCancel, String createOrgId,
			String orgName, String creatorId, String creator, Date createTime,
			String modifiedOrgId, String modifiedOrgName, String modifierId,
			String modifier, Date modifiedTime) {
		this.tuberculosisFollowupId = tuberculosisFollowupId;
		this.tuberculosisInfoId = tuberculosisInfoId;
		this.personInfoId = personInfoId;
		this.tuberculosisFollowupNo = tuberculosisFollowupNo;
		this.trentmentMonth = trentmentMonth;
		this.superviseTypeCode = superviseTypeCode;
		this.name = name;
		this.followupDate = followupDate;
		this.followupWayCode = followupWayCode;
		this.dailySmoking = dailySmoking;
		this.aimDailySmoking = aimDailySmoking;
		this.dailyDrinking = dailyDrinking;
		this.aimDailyDrinking = aimDailyDrinking;
		this.chemotherapyCode = chemotherapyCode;
		this.chemotherapyValue = chemotherapyValue;
		this.drugUseCode = drugUseCode;
		this.loseDrugTimes = loseDrugTimes;
		this.drugAdverseCode = drugAdverseCode;
		this.drugAdverseDesc = drugAdverseDesc;
		this.complicationCode = complicationCode;
		this.complicationDesc = complicationDesc;
		this.isReferralCode = isReferralCode;
		this.referralReason = referralReason;
		this.refertoOrgName = refertoOrgName;
		this.refertoDeptName = refertoDeptName;
		this.getMedicinePlace = getMedicinePlace;
		this.suggestion = suggestion;
		this.nextFollowupDate = nextFollowupDate;
		this.followupDoctorId = followupDoctorId;
		this.followupDoctorName = followupDoctorName;
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
	}

	@Generated(hash = 1406215970)@Keep
	public TuberculosisFollowup() {
		recordChoice = new ArrayList<>();
	}



}
