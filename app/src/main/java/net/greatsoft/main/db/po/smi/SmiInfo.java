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
 * @date 2016年7月7日 上午12:00:30
 * @Description: 严重精神障碍患者个人补充信息数据模型
 *
 */
@Entity
public class SmiInfo extends Entry{
	
	/**
	 * 严重精神障碍患者个人补充信息ID
	 */
	
	private String smiInfoId;

	/**
	 * 个人档案ID
	 */
	
	private String personInfoId;

	/**
	 * 严重精神障碍患者个人补充信息编号
	 */
	
	private String smiInfoNo;

	/**
	 * 管理机构ID
	 */
	
	private String manageOrgId;

	/**
	 * 纳入管理日期
	 */
	
    
	private Date manageDate;

	/**
	 * 本人姓名
	 */
	
	private String name;

	/**
	 * 监护人姓名
	 */
	
	private String guardianName;

	/**
	 * 监护人与本人关系代码
	 */
	private String guardianRelationCode;

	/**
	 * 监护人地址
	 */
	private String guardianAddr;

	/**
	 * 监护人电话号码
	 */
	
	private String guardianTelNo;

	/**
	 * 居委会ID(预留)
	 */
	
	private String communityId;

	/**
	 * 居委会名称(预留)
	 */
	
	private String communityName;

	/**
	 * 居委会联系人姓名(预留)
	 */
	
	private String communityContactName;

	/**
	 * 居委会联系人电话号码
	 */
	
	private String communityContactTelNo;

	/**
	 * 居住地区类型代码
	 */
	
	private String permanentTypeCode;

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
	 * 就业情况代码
	 */
	private String employmentStatusCode;

	/**
	 * 责任医师姓名
	 */
	
	private String respDoctorName;

	/**
	 * 知情同意管理标志
	 */
	
	private String informedConsentCode;

	/**
	 * 知情同意签字人姓名
	 */
	
	private String informedConsentSignerName;

	/**
	 * 知情同意签字日期
	 */
	
    
	private Date informedConsentSignDate;

	/**
	 * 首次发病日期
	 */
	
    
	private Date smiFirstOnsetDate;

	/**
	 * 首次发病年龄（岁）
	 */
	private Integer smiFirstOnsetAge;

	/**
	 * 既往关锁情况代码
	 */
	
	private String passLockCode;

	/**
	 * 既往门诊治疗情况代码
	 */
	
	private String pastClinicTreatCode;

	/**
	 * 首次抗精祌病药治疗日期
	 */
	
    
	private Date firstAntipsyTreatDate;

	/**
	 * 既往精神专科住院次数(次）
	 */
	private Integer pastPsyInpatTimes;

	/**
	 * 重性精神疾病名称代码
	 */
	
	private String smiCode;

	/**
	 * 重性精神疾病名称
	 */
	
	private String smiName;

	/**
	 * 确诊医疗机构名称
	 */
	
	private String confirmedDiagOrgName;

	/**
	 * 确诊日期
	 */
	
    
	private Date confirmedDiagDate;

	/**
	 * 最近一次治疗效果代码
	 */
	
	private String lastTreatResultCode;

	/**
	 * 经济状况代码
	 */
	
	private String financialSituationCode;

	/**
	 * 专科医生意见
	 */
	
	private String specialistAdvice;

	/**
	 * 签字医生
	 */
	
	private String signatureDoctorName;
	
	/**
	 * 签字医生ID
	 */
	
	private String signatureDoctorId;

	/**
	 * 填表日期
	 */
	
    
	private Date fillDate;

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


	public Date getFillDate() {
		return this.fillDate;
	}


	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}


	public String getSignatureDoctorId() {
		return this.signatureDoctorId;
	}


	public void setSignatureDoctorId(String signatureDoctorId) {
		this.signatureDoctorId = signatureDoctorId;
	}


	public String getSignatureDoctorName() {
		return this.signatureDoctorName;
	}


	public void setSignatureDoctorName(String signatureDoctorName) {
		this.signatureDoctorName = signatureDoctorName;
	}


	public String getSpecialistAdvice() {
		return this.specialistAdvice;
	}


	public void setSpecialistAdvice(String specialistAdvice) {
		this.specialistAdvice = specialistAdvice;
	}


	public String getFinancialSituationCode() {
		return this.financialSituationCode;
	}


	public void setFinancialSituationCode(String financialSituationCode) {
		this.financialSituationCode = financialSituationCode;
	}


	public String getLastTreatResultCode() {
		return this.lastTreatResultCode;
	}


	public void setLastTreatResultCode(String lastTreatResultCode) {
		this.lastTreatResultCode = lastTreatResultCode;
	}


	public Date getConfirmedDiagDate() {
		return this.confirmedDiagDate;
	}


	public void setConfirmedDiagDate(Date confirmedDiagDate) {
		this.confirmedDiagDate = confirmedDiagDate;
	}


	public String getConfirmedDiagOrgName() {
		return this.confirmedDiagOrgName;
	}


	public void setConfirmedDiagOrgName(String confirmedDiagOrgName) {
		this.confirmedDiagOrgName = confirmedDiagOrgName;
	}


	public String getSmiName() {
		return this.smiName;
	}


	public void setSmiName(String smiName) {
		this.smiName = smiName;
	}


	public String getSmiCode() {
		return this.smiCode;
	}


	public void setSmiCode(String smiCode) {
		this.smiCode = smiCode;
	}


	public Integer getPastPsyInpatTimes() {
		return this.pastPsyInpatTimes;
	}


	public void setPastPsyInpatTimes(Integer pastPsyInpatTimes) {
		this.pastPsyInpatTimes = pastPsyInpatTimes;
	}


	public Date getFirstAntipsyTreatDate() {
		return this.firstAntipsyTreatDate;
	}


	public void setFirstAntipsyTreatDate(Date firstAntipsyTreatDate) {
		this.firstAntipsyTreatDate = firstAntipsyTreatDate;
	}


	public String getPastClinicTreatCode() {
		return this.pastClinicTreatCode;
	}


	public void setPastClinicTreatCode(String pastClinicTreatCode) {
		this.pastClinicTreatCode = pastClinicTreatCode;
	}


	public String getPassLockCode() {
		return this.passLockCode;
	}


	public void setPassLockCode(String passLockCode) {
		this.passLockCode = passLockCode;
	}


	public Integer getSmiFirstOnsetAge() {
		return this.smiFirstOnsetAge;
	}


	public void setSmiFirstOnsetAge(Integer smiFirstOnsetAge) {
		this.smiFirstOnsetAge = smiFirstOnsetAge;
	}


	public Date getSmiFirstOnsetDate() {
		return this.smiFirstOnsetDate;
	}


	public void setSmiFirstOnsetDate(Date smiFirstOnsetDate) {
		this.smiFirstOnsetDate = smiFirstOnsetDate;
	}


	public Date getInformedConsentSignDate() {
		return this.informedConsentSignDate;
	}


	public void setInformedConsentSignDate(Date informedConsentSignDate) {
		this.informedConsentSignDate = informedConsentSignDate;
	}


	public String getInformedConsentSignerName() {
		return this.informedConsentSignerName;
	}


	public void setInformedConsentSignerName(String informedConsentSignerName) {
		this.informedConsentSignerName = informedConsentSignerName;
	}


	public String getInformedConsentCode() {
		return this.informedConsentCode;
	}


	public void setInformedConsentCode(String informedConsentCode) {
		this.informedConsentCode = informedConsentCode;
	}


	public String getRespDoctorName() {
		return this.respDoctorName;
	}


	public void setRespDoctorName(String respDoctorName) {
		this.respDoctorName = respDoctorName;
	}


	public String getEmploymentStatusCode() {
		return this.employmentStatusCode;
	}


	public void setEmploymentStatusCode(String employmentStatusCode) {
		this.employmentStatusCode = employmentStatusCode;
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


	public String getPermanentTypeCode() {
		return this.permanentTypeCode;
	}


	public void setPermanentTypeCode(String permanentTypeCode) {
		this.permanentTypeCode = permanentTypeCode;
	}


	public String getCommunityContactTelNo() {
		return this.communityContactTelNo;
	}


	public void setCommunityContactTelNo(String communityContactTelNo) {
		this.communityContactTelNo = communityContactTelNo;
	}


	public String getCommunityContactName() {
		return this.communityContactName;
	}


	public void setCommunityContactName(String communityContactName) {
		this.communityContactName = communityContactName;
	}


	public String getCommunityName() {
		return this.communityName;
	}


	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}


	public String getCommunityId() {
		return this.communityId;
	}


	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}


	public String getGuardianTelNo() {
		return this.guardianTelNo;
	}


	public void setGuardianTelNo(String guardianTelNo) {
		this.guardianTelNo = guardianTelNo;
	}


	public String getGuardianAddr() {
		return this.guardianAddr;
	}


	public void setGuardianAddr(String guardianAddr) {
		this.guardianAddr = guardianAddr;
	}


	public String getGuardianRelationCode() {
		return this.guardianRelationCode;
	}


	public void setGuardianRelationCode(String guardianRelationCode) {
		this.guardianRelationCode = guardianRelationCode;
	}


	public String getGuardianName() {
		return this.guardianName;
	}


	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}


	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getManageDate() {
		return this.manageDate;
	}


	public void setManageDate(Date manageDate) {
		this.manageDate = manageDate;
	}


	public String getManageOrgId() {
		return this.manageOrgId;
	}


	public void setManageOrgId(String manageOrgId) {
		this.manageOrgId = manageOrgId;
	}


	public String getSmiInfoNo() {
		return this.smiInfoNo;
	}


	public void setSmiInfoNo(String smiInfoNo) {
		this.smiInfoNo = smiInfoNo;
	}


	public String getPersonInfoId() {
		return this.personInfoId;
	}


	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}


	public String getSmiInfoId() {
		return this.smiInfoId;
	}


	public void setSmiInfoId(String smiInfoId) {
		this.smiInfoId = smiInfoId;
	}


	@Generated(hash = 720780504)
	public SmiInfo(String smiInfoId, String personInfoId, String smiInfoNo,
			String manageOrgId, Date manageDate, String name, String guardianName,
			String guardianRelationCode, String guardianAddr, String guardianTelNo,
			String communityId, String communityName, String communityContactName,
			String communityContactTelNo, String permanentTypeCode, String societyEffect,
			String lowRandalieren, Integer lowRandalierenTimes, String causeTrouble,
			Integer causeTroubleTimes, String accident, Integer accidentTimes,
			String otherHarm, Integer otherHarmTimes, String autolesion,
			Integer autolesionTimes, String incompleteSuicide,
			Integer incompleteSuicideTimes, String employmentStatusCode,
			String respDoctorName, String informedConsentCode,
			String informedConsentSignerName, Date informedConsentSignDate,
			Date smiFirstOnsetDate, Integer smiFirstOnsetAge, String passLockCode,
			String pastClinicTreatCode, Date firstAntipsyTreatDate,
			Integer pastPsyInpatTimes, String smiCode, String smiName,
			String confirmedDiagOrgName, Date confirmedDiagDate,
			String lastTreatResultCode, String financialSituationCode,
			String specialistAdvice, String signatureDoctorName,
			String signatureDoctorId, Date fillDate, Integer isCancel,
			String createOrgId, String orgName, String creatorId, String creator,
			Date createTime, String modifiedOrgId, String modifiedOrgName,
			String modifierId, String modifier, Date modifiedTime) {
		this.smiInfoId = smiInfoId;
		this.personInfoId = personInfoId;
		this.smiInfoNo = smiInfoNo;
		this.manageOrgId = manageOrgId;
		this.manageDate = manageDate;
		this.name = name;
		this.guardianName = guardianName;
		this.guardianRelationCode = guardianRelationCode;
		this.guardianAddr = guardianAddr;
		this.guardianTelNo = guardianTelNo;
		this.communityId = communityId;
		this.communityName = communityName;
		this.communityContactName = communityContactName;
		this.communityContactTelNo = communityContactTelNo;
		this.permanentTypeCode = permanentTypeCode;
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
		this.employmentStatusCode = employmentStatusCode;
		this.respDoctorName = respDoctorName;
		this.informedConsentCode = informedConsentCode;
		this.informedConsentSignerName = informedConsentSignerName;
		this.informedConsentSignDate = informedConsentSignDate;
		this.smiFirstOnsetDate = smiFirstOnsetDate;
		this.smiFirstOnsetAge = smiFirstOnsetAge;
		this.passLockCode = passLockCode;
		this.pastClinicTreatCode = pastClinicTreatCode;
		this.firstAntipsyTreatDate = firstAntipsyTreatDate;
		this.pastPsyInpatTimes = pastPsyInpatTimes;
		this.smiCode = smiCode;
		this.smiName = smiName;
		this.confirmedDiagOrgName = confirmedDiagOrgName;
		this.confirmedDiagDate = confirmedDiagDate;
		this.lastTreatResultCode = lastTreatResultCode;
		this.financialSituationCode = financialSituationCode;
		this.specialistAdvice = specialistAdvice;
		this.signatureDoctorName = signatureDoctorName;
		this.signatureDoctorId = signatureDoctorId;
		this.fillDate = fillDate;
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


	@Generated(hash = 1497713884)@Keep
	public SmiInfo() {

		recordChoice = new ArrayList<>();

	}


}