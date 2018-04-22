package net.greatsoft.main.db.po.old;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
/**
 * 
 * @author hn
 * @date 2016年7月25日 下午10:50:14
 * @Description: 65岁老年人体检管理台账
 *
 */
@Entity
public class ElderExamLedger  extends Entry {
	/**
	 * 65岁老年人体检管理台账ID
	 */
	
	private String elderExamLedgerId;

	/**
	 * 个人档案ID
	 */
	
	private String personInfoId;
	
	/**
	 * 体检ID
	 */
	
	private String healthExamId;

	/**
	 * 编号
	 */
	
	private String personInfoNo;

	/**
	 * 年份
	 */
	private Integer year;

	/**
	 * 本人姓名
	 */
	
	private String name;

	/**
	 * 身份证证号
	 */
	
	private String idNo;

	/**
	 * 地址
	 */
	
	private String address;

	/**
	 * 性别中文
	 */
	private String sexValue;

	/**
	 * 电话号码
	 */
	
	private String telNo;

	/**
	 * ABO血型
	 */
	
	private String aboCode;

	/**
	 * 文化程度
	 */
	
	private String educationCode;

	/**
	 * 婚姻状况
	 */
	
	private String marriageCode;

	/**
	 * 体检日期
	 */
	
	
	private Date examDate;

	/**
	 * 烟
	 */
	
	private String smoking;

	/**
	 * 酒
	 */
	
	private String drink;

	/**
	 * 牙齿
	 */
	
	private String teeth;

	/**
	 * 锻炼
	 */
	
	private String exercise;

	/**
	 * 高血压药物
	 */
	
	private String hyperDrugs;

	/**
	 * 糖尿病药物
	 */
	
	private String diabetesDrugs;

	/**
	 * 心脏病药物
	 */
	
	private String heartDrugs;

	/**
	 * 医保
	 */
	
	private String medical;

	/**
	 * 过敏史
	 */
	
	private String drugAllergy;

	/**
	 * 工作单位
	 */
	
	private String workUnit;

	/**
	 * 自理能力评估
	 */
	
	private String elderSelfCareAssess;
	/**
	 * 老年人认知
	 */
	
	private String elderCognition;
	/**
	 * 老年人认知
	 */
	private String elderDepression;
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
	 * 出生日期
	 */
	
	
	private Date birthday;

	/**
	 * 年龄
	 */
	private Integer age;

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getElderDepression() {
		return this.elderDepression;
	}

	public void setElderDepression(String elderDepression) {
		this.elderDepression = elderDepression;
	}

	public String getElderCognition() {
		return this.elderCognition;
	}

	public void setElderCognition(String elderCognition) {
		this.elderCognition = elderCognition;
	}

	public String getElderSelfCareAssess() {
		return this.elderSelfCareAssess;
	}

	public void setElderSelfCareAssess(String elderSelfCareAssess) {
		this.elderSelfCareAssess = elderSelfCareAssess;
	}

	public String getWorkUnit() {
		return this.workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getDrugAllergy() {
		return this.drugAllergy;
	}

	public void setDrugAllergy(String drugAllergy) {
		this.drugAllergy = drugAllergy;
	}

	public String getMedical() {
		return this.medical;
	}

	public void setMedical(String medical) {
		this.medical = medical;
	}

	public String getHeartDrugs() {
		return this.heartDrugs;
	}

	public void setHeartDrugs(String heartDrugs) {
		this.heartDrugs = heartDrugs;
	}

	public String getDiabetesDrugs() {
		return this.diabetesDrugs;
	}

	public void setDiabetesDrugs(String diabetesDrugs) {
		this.diabetesDrugs = diabetesDrugs;
	}

	public String getHyperDrugs() {
		return this.hyperDrugs;
	}

	public void setHyperDrugs(String hyperDrugs) {
		this.hyperDrugs = hyperDrugs;
	}

	public String getExercise() {
		return this.exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public String getTeeth() {
		return this.teeth;
	}

	public void setTeeth(String teeth) {
		this.teeth = teeth;
	}

	public String getDrink() {
		return this.drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getSmoking() {
		return this.smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public Date getExamDate() {
		return this.examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getMarriageCode() {
		return this.marriageCode;
	}

	public void setMarriageCode(String marriageCode) {
		this.marriageCode = marriageCode;
	}

	public String getEducationCode() {
		return this.educationCode;
	}

	public void setEducationCode(String educationCode) {
		this.educationCode = educationCode;
	}

	public String getAboCode() {
		return this.aboCode;
	}

	public void setAboCode(String aboCode) {
		this.aboCode = aboCode;
	}

	public String getTelNo() {
		return this.telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getSexValue() {
		return this.sexValue;
	}

	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getPersonInfoNo() {
		return this.personInfoNo;
	}

	public void setPersonInfoNo(String personInfoNo) {
		this.personInfoNo = personInfoNo;
	}

	public String getHealthExamId() {
		return this.healthExamId;
	}

	public void setHealthExamId(String healthExamId) {
		this.healthExamId = healthExamId;
	}

	public String getPersonInfoId() {
		return this.personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getElderExamLedgerId() {
		return this.elderExamLedgerId;
	}

	public void setElderExamLedgerId(String elderExamLedgerId) {
		this.elderExamLedgerId = elderExamLedgerId;
	}

	@Generated(hash = 888873692)
	public ElderExamLedger(String elderExamLedgerId, String personInfoId,
			String healthExamId, String personInfoNo, Integer year, String name,
			String idNo, String address, String sexValue, String telNo, String aboCode,
			String educationCode, String marriageCode, Date examDate, String smoking,
			String drink, String teeth, String exercise, String hyperDrugs,
			String diabetesDrugs, String heartDrugs, String medical, String drugAllergy,
			String workUnit, String elderSelfCareAssess, String elderCognition,
			String elderDepression, Integer isCancel, String createOrgId, String orgName,
			String creatorId, String creator, Date createTime, String modifiedOrgId,
			String modifiedOrgName, String modifierId, String modifier,
			Date modifiedTime, Date birthday, Integer age) {
		this.elderExamLedgerId = elderExamLedgerId;
		this.personInfoId = personInfoId;
		this.healthExamId = healthExamId;
		this.personInfoNo = personInfoNo;
		this.year = year;
		this.name = name;
		this.idNo = idNo;
		this.address = address;
		this.sexValue = sexValue;
		this.telNo = telNo;
		this.aboCode = aboCode;
		this.educationCode = educationCode;
		this.marriageCode = marriageCode;
		this.examDate = examDate;
		this.smoking = smoking;
		this.drink = drink;
		this.teeth = teeth;
		this.exercise = exercise;
		this.hyperDrugs = hyperDrugs;
		this.diabetesDrugs = diabetesDrugs;
		this.heartDrugs = heartDrugs;
		this.medical = medical;
		this.drugAllergy = drugAllergy;
		this.workUnit = workUnit;
		this.elderSelfCareAssess = elderSelfCareAssess;
		this.elderCognition = elderCognition;
		this.elderDepression = elderDepression;
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
		this.birthday = birthday;
		this.age = age;
	}

	@Generated(hash = 1071442910)
	public ElderExamLedger() {
	}



}