package net.greatsoft.main.db.po.maternal;

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
 * @date 2016年7月12日 上午12:08:08
 * @Description: 产后访视记录表数据模型
 *
 */
@Entity
public class MaternalPostpartumFollowup extends Entry {
	/**
	 * 产后访视ID
	 */
	private String maternalPostpartumFollowupId;

	/**
	 * 孕产妇基本信息ID
	 */
	private String maternalInfoId;

	/**
	 * 个人档案ID
	 */
	private String personInfoId;

	/**
	 * 产后访视编号
	 */
	private String maternalPostpartumFollowupNo;

	/**
	 * 产后随访类型代码
	 *
	 */
	private String maternalPostpartumTypeCode;

	/**
	 * 孕产登记次数
	 */
	private Integer pregnantCount;

	/**
	 * 孕产登记ID
	 */
	private String maternalRegisterId;
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
	 * 分娩日期
	 */
	private Date deliveryDate;

	/**
	 * 出院日期
	 */
	private Date resiOutDate;

	/**
	 * 一般健康情况
	 */
	private String healthDesc;

	/**
	 * 一般心理情况
	 */
	private String psyDesc;

	/**
	 * 收缩压
	 */
	private Integer systilic;

	/**
	 * 舒张压
	 */
	private Integer diastolic;

	/**
	 * 乳房情况代码
	 */
	private String uberCode;

	/**
	 * 乳房异常描述
	 */
	private String uberAbnormDesc;

	/**
	 * 恶露状况代码
	 */
	private String lochiaCode;

	/**
	 * 恶露异常描述
	 */
	private String lochiaAbnormDesc;

	/**
	 * 子宫情况代码
	 */
	private String uterusCode;

	/**
	 * 子宫异常描述
	 */
	private String uterusAbnormDesc;

	/**
	 * 伤口情况代码
	 */
	private String woundCode;

	/**
	 * 伤口异常描述
	 */
	private String woundAbnormDesc;

	/**
	 * 其他
	 */
	private String othersDesc;

	/**
	 * 此次随访分类代码
	 */
	private String followupClassifyCode;

	/**
	 * 此次随访分类中文
	 */
	private String followupClassifyValue;

	/**
	 * 脉博
	 */
	private Integer pulses;

	/**
	 * 体温(℃)
	 */
	private Double bodyTemperature;

	/**
	 * 转诊/结案标志
	 */
	private String referralCode;

	/**
	 * 转入医疗机构名称
	 */
	private String refertoOrgName;

	/**
	 * 转入机构科室名称
	 */
	private String refertoDeptName;

	/**
	 * 转诊原因
	 */
	private String referralReason;

	/**
	 * 结案标志
	 */
	private String caseCloseCode;

	/**
	 * 下次随访日期
	 */
	private Date nextFollowupDate;

	/**
	 * 上次随访日期
	 */
	private Date previousVisitDate;

	/**
	 * 上次随访医师
	 */
	private String previousVisitPerson;

	/**
	 * 上次随访类型
	 */
	private String previousVisitTypeCode;

	/**
	 * 本次随访医师ID
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

	public String getPreviousVisitTypeCode() {
		return this.previousVisitTypeCode;
	}

	public void setPreviousVisitTypeCode(String previousVisitTypeCode) {
		this.previousVisitTypeCode = previousVisitTypeCode;
	}

	public String getPreviousVisitPerson() {
		return this.previousVisitPerson;
	}

	public void setPreviousVisitPerson(String previousVisitPerson) {
		this.previousVisitPerson = previousVisitPerson;
	}

	public Date getPreviousVisitDate() {
		return this.previousVisitDate;
	}

	public void setPreviousVisitDate(Date previousVisitDate) {
		this.previousVisitDate = previousVisitDate;
	}

	public Date getNextFollowupDate() {
		return this.nextFollowupDate;
	}

	public void setNextFollowupDate(Date nextFollowupDate) {
		this.nextFollowupDate = nextFollowupDate;
	}

	public String getCaseCloseCode() {
		return this.caseCloseCode;
	}

	public void setCaseCloseCode(String caseCloseCode) {
		this.caseCloseCode = caseCloseCode;
	}

	public String getReferralReason() {
		return this.referralReason;
	}

	public void setReferralReason(String referralReason) {
		this.referralReason = referralReason;
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

	public String getReferralCode() {
		return this.referralCode;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	public Double getBodyTemperature() {
		return this.bodyTemperature;
	}

	public void setBodyTemperature(Double bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public Integer getPulses() {
		return this.pulses;
	}

	public void setPulses(Integer pulses) {
		this.pulses = pulses;
	}

	public String getFollowupClassifyValue() {
		return this.followupClassifyValue;
	}

	public void setFollowupClassifyValue(String followupClassifyValue) {
		this.followupClassifyValue = followupClassifyValue;
	}

	public String getFollowupClassifyCode() {
		return this.followupClassifyCode;
	}

	public void setFollowupClassifyCode(String followupClassifyCode) {
		this.followupClassifyCode = followupClassifyCode;
	}

	public String getOthersDesc() {
		return this.othersDesc;
	}

	public void setOthersDesc(String othersDesc) {
		this.othersDesc = othersDesc;
	}

	public String getWoundAbnormDesc() {
		return this.woundAbnormDesc;
	}

	public void setWoundAbnormDesc(String woundAbnormDesc) {
		this.woundAbnormDesc = woundAbnormDesc;
	}

	public String getWoundCode() {
		return this.woundCode;
	}

	public void setWoundCode(String woundCode) {
		this.woundCode = woundCode;
	}

	public String getUterusAbnormDesc() {
		return this.uterusAbnormDesc;
	}

	public void setUterusAbnormDesc(String uterusAbnormDesc) {
		this.uterusAbnormDesc = uterusAbnormDesc;
	}

	public String getUterusCode() {
		return this.uterusCode;
	}

	public void setUterusCode(String uterusCode) {
		this.uterusCode = uterusCode;
	}

	public String getLochiaAbnormDesc() {
		return this.lochiaAbnormDesc;
	}

	public void setLochiaAbnormDesc(String lochiaAbnormDesc) {
		this.lochiaAbnormDesc = lochiaAbnormDesc;
	}

	public String getLochiaCode() {
		return this.lochiaCode;
	}

	public void setLochiaCode(String lochiaCode) {
		this.lochiaCode = lochiaCode;
	}

	public String getUberAbnormDesc() {
		return this.uberAbnormDesc;
	}

	public void setUberAbnormDesc(String uberAbnormDesc) {
		this.uberAbnormDesc = uberAbnormDesc;
	}

	public String getUberCode() {
		return this.uberCode;
	}

	public void setUberCode(String uberCode) {
		this.uberCode = uberCode;
	}

	public Integer getDiastolic() {
		return this.diastolic;
	}

	public void setDiastolic(Integer diastolic) {
		this.diastolic = diastolic;
	}

	public Integer getSystilic() {
		return this.systilic;
	}

	public void setSystilic(Integer systilic) {
		this.systilic = systilic;
	}

	public String getPsyDesc() {
		return this.psyDesc;
	}

	public void setPsyDesc(String psyDesc) {
		this.psyDesc = psyDesc;
	}

	public String getHealthDesc() {
		return this.healthDesc;
	}

	public void setHealthDesc(String healthDesc) {
		this.healthDesc = healthDesc;
	}

	public Date getResiOutDate() {
		return this.resiOutDate;
	}

	public void setResiOutDate(Date resiOutDate) {
		this.resiOutDate = resiOutDate;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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

	public String getMaternalRegisterId() {
		return this.maternalRegisterId;
	}

	public void setMaternalRegisterId(String maternalRegisterId) {
		this.maternalRegisterId = maternalRegisterId;
	}

	public Integer getPregnantCount() {
		return this.pregnantCount;
	}

	public void setPregnantCount(Integer pregnantCount) {
		this.pregnantCount = pregnantCount;
	}

	public String getMaternalPostpartumTypeCode() {
		return this.maternalPostpartumTypeCode;
	}

	public void setMaternalPostpartumTypeCode(String maternalPostpartumTypeCode) {
		this.maternalPostpartumTypeCode = maternalPostpartumTypeCode;
	}

	public String getMaternalPostpartumFollowupNo() {
		return this.maternalPostpartumFollowupNo;
	}

	public void setMaternalPostpartumFollowupNo(String maternalPostpartumFollowupNo) {
		this.maternalPostpartumFollowupNo = maternalPostpartumFollowupNo;
	}

	public String getPersonInfoId() {
		return this.personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getMaternalInfoId() {
		return this.maternalInfoId;
	}

	public void setMaternalInfoId(String maternalInfoId) {
		this.maternalInfoId = maternalInfoId;
	}

	public String getMaternalPostpartumFollowupId() {
		return this.maternalPostpartumFollowupId;
	}

	public void setMaternalPostpartumFollowupId(String maternalPostpartumFollowupId) {
		this.maternalPostpartumFollowupId = maternalPostpartumFollowupId;
	}

	@Generated(hash = 1154051522)
	public MaternalPostpartumFollowup(String maternalPostpartumFollowupId,
			String maternalInfoId, String personInfoId,
			String maternalPostpartumFollowupNo, String maternalPostpartumTypeCode,
			Integer pregnantCount, String maternalRegisterId, String name,
			Date followupDate, String followupWayCode, Date deliveryDate,
			Date resiOutDate, String healthDesc, String psyDesc, Integer systilic,
			Integer diastolic, String uberCode, String uberAbnormDesc, String lochiaCode,
			String lochiaAbnormDesc, String uterusCode, String uterusAbnormDesc,
			String woundCode, String woundAbnormDesc, String othersDesc,
			String followupClassifyCode, String followupClassifyValue, Integer pulses,
			Double bodyTemperature, String referralCode, String refertoOrgName,
			String refertoDeptName, String referralReason, String caseCloseCode,
			Date nextFollowupDate, Date previousVisitDate, String previousVisitPerson,
			String previousVisitTypeCode, String followupDoctorId,
			String followupDoctorName, Integer isCancel, String createOrgId,
			String orgName, String creatorId, String creator, Date createTime,
			String modifiedOrgId, String modifiedOrgName, String modifierId,
			String modifier, Date modifiedTime, String jsonDetail) {
		this.maternalPostpartumFollowupId = maternalPostpartumFollowupId;
		this.maternalInfoId = maternalInfoId;
		this.personInfoId = personInfoId;
		this.maternalPostpartumFollowupNo = maternalPostpartumFollowupNo;
		this.maternalPostpartumTypeCode = maternalPostpartumTypeCode;
		this.pregnantCount = pregnantCount;
		this.maternalRegisterId = maternalRegisterId;
		this.name = name;
		this.followupDate = followupDate;
		this.followupWayCode = followupWayCode;
		this.deliveryDate = deliveryDate;
		this.resiOutDate = resiOutDate;
		this.healthDesc = healthDesc;
		this.psyDesc = psyDesc;
		this.systilic = systilic;
		this.diastolic = diastolic;
		this.uberCode = uberCode;
		this.uberAbnormDesc = uberAbnormDesc;
		this.lochiaCode = lochiaCode;
		this.lochiaAbnormDesc = lochiaAbnormDesc;
		this.uterusCode = uterusCode;
		this.uterusAbnormDesc = uterusAbnormDesc;
		this.woundCode = woundCode;
		this.woundAbnormDesc = woundAbnormDesc;
		this.othersDesc = othersDesc;
		this.followupClassifyCode = followupClassifyCode;
		this.followupClassifyValue = followupClassifyValue;
		this.pulses = pulses;
		this.bodyTemperature = bodyTemperature;
		this.referralCode = referralCode;
		this.refertoOrgName = refertoOrgName;
		this.refertoDeptName = refertoDeptName;
		this.referralReason = referralReason;
		this.caseCloseCode = caseCloseCode;
		this.nextFollowupDate = nextFollowupDate;
		this.previousVisitDate = previousVisitDate;
		this.previousVisitPerson = previousVisitPerson;
		this.previousVisitTypeCode = previousVisitTypeCode;
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
		this.jsonDetail = jsonDetail;
	}

	@Generated(hash = 2127253569)@Keep
	public MaternalPostpartumFollowup() {
		recordChoice = new ArrayList<>();
	}

}