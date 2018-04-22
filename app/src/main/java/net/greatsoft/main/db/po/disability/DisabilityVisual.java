package net.greatsoft.main.db.po.disability;

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
 * @author HS
 * @date 2016年11月12日 下午2:35:40
 * @Description: 视力残疾人健康管理随访表
 *
 */
@Entity
public class DisabilityVisual extends Entry {
	/**
	 * 视力残疾人健康管理随访表ID
	 */
	private String disabilityVisualId;

	/**
	 * 个人档案ID
	 */
	private String personInfoId;

	/**
	 * 管理机构ID
	 */
	private String manageOrgId;

	/**
	 * 残疾证号
	 */
	private String disabilityVisualNo;

	/**
	 * 致残时间
	 */
	private Date disabilityVisualDate;

	/**
	 * 致残原因
	 */
	private String disabilityReasonCode;

	/**
	 * 致残原因中文
	 */
	private String disabilityReasonValue;

	/**
	 * 残疾程度
	 */
	private String disabilityGrade;

	/**
	 * 持续时间
	 */
	private String durationTimeCode;

	/**
	 * 生活自理能力自我评估代码
	 */
	private String selfCareAssessCode;

	/**
	 * 监护人姓名
	 */
	private String guardianName;

	/**
	 * 监护人电话号码
	 */
	private String guardianTelNo;

	/**
	 * 学历-盲校
	 */
	private String educationBlindCode;

	/**
	 * 学历-盲校-年级
	 */
	private String educationBlindValue;

	/**
	 * 学历-聋校
	 */
	private String educationDeafCode;

	/**
	 * 学历-聋校-年级
	 */
	private String educationDeafValue;

	/**
	 * 学历-其他特殊学校
	 */
	private String educationOtherCode;

	/**
	 * 学历-其他特殊学校中文
	 */
	private String educationOtherValue;

	/**
	 * 就业状况代码
	 */
	private String employmentCode;

	/**
	 * 就业状况其他中文
	 */
	private String employmentValue;

	/**
	 * 工作单位
	 */
	private String workUnit;

	/**
	 * 电话
	 */
	private String workUnitTel;

	/**
	 * 平均收入
	 */
	private String averageIncome;

	/**
	 * 劳动能力
	 */
	private String laborAbility;

	/**
	 * 劳动技能
	 */
	private String laborSkill;

	/**
	 * 检查结果标记
	 */
	private String checkResultCode;

	/**
	 * 左眼裸眼远视力值
	 */
	private Double leftOriginalEyesight;

	/**
	 * 右眼裸眼远视力值
	 */
	private Double rightOriginalEyesight;

	/**
	 * 康复治疗情况
	 */
	private String rehabilitation;

	/**
	 * 康复需求
	 */
	private String rehabilitationNeeds;

	/**
	 * 下次随访日期
	 */
	private Date nextFollowupDate;

	/**
	 * 本次随访日期
	 */
	private Date followupDate;

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

	@Transient
	private List<RecordChoice> recordChoice;
	
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

	public Date getFollowupDate() {
		return this.followupDate;
	}

	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}

	public Date getNextFollowupDate() {
		return this.nextFollowupDate;
	}

	public void setNextFollowupDate(Date nextFollowupDate) {
		this.nextFollowupDate = nextFollowupDate;
	}

	public String getRehabilitationNeeds() {
		return this.rehabilitationNeeds;
	}

	public void setRehabilitationNeeds(String rehabilitationNeeds) {
		this.rehabilitationNeeds = rehabilitationNeeds;
	}

	public String getRehabilitation() {
		return this.rehabilitation;
	}

	public void setRehabilitation(String rehabilitation) {
		this.rehabilitation = rehabilitation;
	}

	public Double getRightOriginalEyesight() {
		return this.rightOriginalEyesight;
	}

	public void setRightOriginalEyesight(Double rightOriginalEyesight) {
		this.rightOriginalEyesight = rightOriginalEyesight;
	}

	public Double getLeftOriginalEyesight() {
		return this.leftOriginalEyesight;
	}

	public void setLeftOriginalEyesight(Double leftOriginalEyesight) {
		this.leftOriginalEyesight = leftOriginalEyesight;
	}

	public String getCheckResultCode() {
		return this.checkResultCode;
	}

	public void setCheckResultCode(String checkResultCode) {
		this.checkResultCode = checkResultCode;
	}

	public String getLaborSkill() {
		return this.laborSkill;
	}

	public void setLaborSkill(String laborSkill) {
		this.laborSkill = laborSkill;
	}

	public String getLaborAbility() {
		return this.laborAbility;
	}

	public void setLaborAbility(String laborAbility) {
		this.laborAbility = laborAbility;
	}

	public String getAverageIncome() {
		return this.averageIncome;
	}

	public void setAverageIncome(String averageIncome) {
		this.averageIncome = averageIncome;
	}

	public String getWorkUnitTel() {
		return this.workUnitTel;
	}

	public void setWorkUnitTel(String workUnitTel) {
		this.workUnitTel = workUnitTel;
	}

	public String getWorkUnit() {
		return this.workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getEmploymentValue() {
		return this.employmentValue;
	}

	public void setEmploymentValue(String employmentValue) {
		this.employmentValue = employmentValue;
	}

	public String getEmploymentCode() {
		return this.employmentCode;
	}

	public void setEmploymentCode(String employmentCode) {
		this.employmentCode = employmentCode;
	}

	public String getEducationOtherValue() {
		return this.educationOtherValue;
	}

	public void setEducationOtherValue(String educationOtherValue) {
		this.educationOtherValue = educationOtherValue;
	}

	public String getEducationOtherCode() {
		return this.educationOtherCode;
	}

	public void setEducationOtherCode(String educationOtherCode) {
		this.educationOtherCode = educationOtherCode;
	}

	public String getEducationDeafValue() {
		return this.educationDeafValue;
	}

	public void setEducationDeafValue(String educationDeafValue) {
		this.educationDeafValue = educationDeafValue;
	}

	public String getEducationDeafCode() {
		return this.educationDeafCode;
	}

	public void setEducationDeafCode(String educationDeafCode) {
		this.educationDeafCode = educationDeafCode;
	}

	public String getEducationBlindValue() {
		return this.educationBlindValue;
	}

	public void setEducationBlindValue(String educationBlindValue) {
		this.educationBlindValue = educationBlindValue;
	}

	public String getEducationBlindCode() {
		return this.educationBlindCode;
	}

	public void setEducationBlindCode(String educationBlindCode) {
		this.educationBlindCode = educationBlindCode;
	}

	public String getGuardianTelNo() {
		return this.guardianTelNo;
	}

	public void setGuardianTelNo(String guardianTelNo) {
		this.guardianTelNo = guardianTelNo;
	}

	public String getGuardianName() {
		return this.guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getSelfCareAssessCode() {
		return this.selfCareAssessCode;
	}

	public void setSelfCareAssessCode(String selfCareAssessCode) {
		this.selfCareAssessCode = selfCareAssessCode;
	}

	public String getDurationTimeCode() {
		return this.durationTimeCode;
	}

	public void setDurationTimeCode(String durationTimeCode) {
		this.durationTimeCode = durationTimeCode;
	}

	public String getDisabilityGrade() {
		return this.disabilityGrade;
	}

	public void setDisabilityGrade(String disabilityGrade) {
		this.disabilityGrade = disabilityGrade;
	}

	public String getDisabilityReasonValue() {
		return this.disabilityReasonValue;
	}

	public void setDisabilityReasonValue(String disabilityReasonValue) {
		this.disabilityReasonValue = disabilityReasonValue;
	}

	public String getDisabilityReasonCode() {
		return this.disabilityReasonCode;
	}

	public void setDisabilityReasonCode(String disabilityReasonCode) {
		this.disabilityReasonCode = disabilityReasonCode;
	}

	public Date getDisabilityVisualDate() {
		return this.disabilityVisualDate;
	}

	public void setDisabilityVisualDate(Date disabilityVisualDate) {
		this.disabilityVisualDate = disabilityVisualDate;
	}

	public String getDisabilityVisualNo() {
		return this.disabilityVisualNo;
	}

	public void setDisabilityVisualNo(String disabilityVisualNo) {
		this.disabilityVisualNo = disabilityVisualNo;
	}

	public String getManageOrgId() {
		return this.manageOrgId;
	}

	public void setManageOrgId(String manageOrgId) {
		this.manageOrgId = manageOrgId;
	}

	public String getPersonInfoId() {
		return this.personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getDisabilityVisualId() {
		return this.disabilityVisualId;
	}

	public void setDisabilityVisualId(String disabilityVisualId) {
		this.disabilityVisualId = disabilityVisualId;
	}

	@Generated(hash = 1992483074)
	public DisabilityVisual(String disabilityVisualId, String personInfoId,
			String manageOrgId, String disabilityVisualNo, Date disabilityVisualDate,
			String disabilityReasonCode, String disabilityReasonValue,
			String disabilityGrade, String durationTimeCode, String selfCareAssessCode,
			String guardianName, String guardianTelNo, String educationBlindCode,
			String educationBlindValue, String educationDeafCode,
			String educationDeafValue, String educationOtherCode,
			String educationOtherValue, String employmentCode, String employmentValue,
			String workUnit, String workUnitTel, String averageIncome,
			String laborAbility, String laborSkill, String checkResultCode,
			Double leftOriginalEyesight, Double rightOriginalEyesight,
			String rehabilitation, String rehabilitationNeeds, Date nextFollowupDate,
			Date followupDate, String followupDoctorId, String followupDoctorName,
			Integer isCancel, String createOrgId, String orgName, String creatorId,
			String creator, Date createTime, String modifiedOrgId,
			String modifiedOrgName, String modifierId, String modifier,
			Date modifiedTime, Integer assessmentCount, Integer missingCount,
			Double intactRate) {
		this.disabilityVisualId = disabilityVisualId;
		this.personInfoId = personInfoId;
		this.manageOrgId = manageOrgId;
		this.disabilityVisualNo = disabilityVisualNo;
		this.disabilityVisualDate = disabilityVisualDate;
		this.disabilityReasonCode = disabilityReasonCode;
		this.disabilityReasonValue = disabilityReasonValue;
		this.disabilityGrade = disabilityGrade;
		this.durationTimeCode = durationTimeCode;
		this.selfCareAssessCode = selfCareAssessCode;
		this.guardianName = guardianName;
		this.guardianTelNo = guardianTelNo;
		this.educationBlindCode = educationBlindCode;
		this.educationBlindValue = educationBlindValue;
		this.educationDeafCode = educationDeafCode;
		this.educationDeafValue = educationDeafValue;
		this.educationOtherCode = educationOtherCode;
		this.educationOtherValue = educationOtherValue;
		this.employmentCode = employmentCode;
		this.employmentValue = employmentValue;
		this.workUnit = workUnit;
		this.workUnitTel = workUnitTel;
		this.averageIncome = averageIncome;
		this.laborAbility = laborAbility;
		this.laborSkill = laborSkill;
		this.checkResultCode = checkResultCode;
		this.leftOriginalEyesight = leftOriginalEyesight;
		this.rightOriginalEyesight = rightOriginalEyesight;
		this.rehabilitation = rehabilitation;
		this.rehabilitationNeeds = rehabilitationNeeds;
		this.nextFollowupDate = nextFollowupDate;
		this.followupDate = followupDate;
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
		this.assessmentCount = assessmentCount;
		this.missingCount = missingCount;
		this.intactRate = intactRate;
	}

	@Generated(hash = 1820064478)
    @Keep
	public DisabilityVisual() {
        recordChoice = new ArrayList<>();
    }
	
}