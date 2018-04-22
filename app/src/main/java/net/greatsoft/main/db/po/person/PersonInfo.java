package net.greatsoft.main.db.po.person;

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
 * @author :hn
 * @createDate:2016年6月3日
 * @description:个人健康档案基本信息表
 */
@Entity
public class PersonInfo extends Entry {

    /**
     * 个人档案ID
     */
    private String personInfoId;

    /**
     * 管理机构ID
     */
    private String manageOrgId;

    /**
     * 城乡居民健康档案编号
     */
    private String personInfoNo;

    /**
     * 城乡居民健康档案自行编号
     */
    private String personInfoSno;

    /**
     * 定点医疗机构
     */
    private String healthcareOrg;

    /**
     * 居民健康卡号
     */
    private String cardNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 曾用名
     */
    private String formerName;

    /**
     * 性别代码
     */
    private String sexCode;

    /**
     * 性别中文
     */
    private String sexValue;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 身份证证号
     */
    private String idNo;

    /**
     * 工作单位
     */
    private String workUnit;

    /**
     * 电话号码
     */
    private String telNo;

    /**
     * 固定电话(对应原公卫中的手机号码)
     */
    private String fixedPhones;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人电话
     */
    private String contactTelNo;

    /**
     * 常住类型代码
     */
    private String residenceTypeCode;

    /**
     * 户籍类型
     */
    private String householdTypeCode;

    /**
     * 民族代码
     */
    private String nationalityCode;

    /**
     * 民族代码中文
     */
    private String nationalityValue;

    /**
     * ABO血型代码
     */
    private String aboCode;

    /**
     * Rh血型代码
     */
    private String rhCode;

    /**
     * 与户主关系
     */
    private String relationCode;

    /**
     * 与户主关系中文
     */
    private String relationValue;

    /**
     * 文化程度代码
     */
    private String educationCode;

    /**
     * 职业类别代码
     */
    private String occupationCode;

    /**
     * 婚姻状况代码
     */
    private String marriageCode;

    /**
     * 遗传病史
     */
    private String geneticDiseaseHistoryCode;

    /**
     * 遗传病史名称
     */
    private String geneticDiseaseHistoryName;

    /**
     * 厨房排风设施
     */
    private String kitchenExhaustCode;

    /**
     * 厕所
     */
    private String toiletCode;

    /**
     * 禽畜栏
     */
    private String livestockFenceCode;

    /**
     * 体检次数
     */
    private Integer examCount;

    /**
     * 最近一次健康体检时间
     */
    private Date lastHealthExamDate;

    /**
     * 0否  1是
     * 是否0~6岁儿童
     */
    private Integer isChild;

    /**
     * 纳入0~6岁儿童管理
     */
    private Date isChildDate;

    /**
     * 是否孕产妇
     */
    private Integer isMaternal;

    /**
     * 纳入孕产妇管理
     */
    private Date isMaternalDate;

    /**
     * 是否老年人
     */
    private Integer isElder;

    /**
     * 纳入老年人管理日期
     */
    private Date isElderDate;

    /**
     * 是否高血压
     */
    private Integer isHypertension;

    /**
     * 纳入高血压管理日期
     */
    private Date isHypertensionDate;

    /**
     * 是否糖尿病
     */
    private Integer isDiabetes;

    /**
     * 纳入糖尿病管理日期
     */
    private Date isDiabetesDate;

    /**
     * 是否严重精神障碍
     */
    private Integer isSmi;

    /**
     * 纳入严重精神障碍日期
     */
    private Date isSmiDate;

    /**
     * 是否肺结核患者
     */
    private Integer isTuberculosis;

    /**
     * 纳入肺结核患者管理日期
     */
    private Date isTuberculosisDate;

    /**
     * 是否死亡
     */
    private Integer isDeath;

    /**
     * 死亡日期
     */
    private Date deathDate;

    /**
     * 家庭地址
     */
    private String address;

    /**
     * 户籍地址
     */
    private String householdAddress;

    /**
     * 纸质档案建档时间
     */
    private Date paperArchiveDate;

    /**
     * 纸质档案编号
     */
    private String paperCardNum;

    /**
     * 居（村）委会
     */
    private String committee;

    /**
     * 居（村）委会
     */
    private String committeeCN;

    /**
     * 小区
     */
    private String residential;

    /**
     * residentialCN
     */

    private String residentialCN;

    /**
     * 楼栋
     */
    private String building;

    /**
     *
     */
    private String buildingCN;

    /**
     * 家庭健康档案ID
     */
    private String familyInfoId;

    /**
     * 责任医生ID
     */
    private String respDoctorId;

    /**
     * 照片地址
     */
    private String photoUrl;

    /**
     * 档案状态代码
     */
    private String statusCode;

    /**
     * 档案注销删除原因代码
     */
    private String cancelReasonCode;

    /**
     * 档案注销删除原因
     */
    private String cancelReason;

    /**
     * 档案注销删除时间
     */
    private Date cancelTime;

    /**
     * 建档机构ID
     */
    private String createOrgId;

    /**
     * 建档机构名称
     */
    private String orgName;

    /**
     * 建档机构代码
     */
    private String orgCode;

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
     * 个人档案标识符
     */
    private String personInfoCode;

    /**
     * 是否高血压高危
     */
    private Integer isHyperHr;

    /**
     * 纳入高血压高危管理日期
     */
    private Date isHyperHrDate;

    /**
     * 是否糖尿病高危
     */
    private Integer isDiabetesHr;

    /**
     * 纳入糖尿病高危管理日期
     */
    private Date isDiabetesHrDate;

    /**
     * 是否是否冠心病
     */
    private Integer isChd;

    /**
     * 纳入冠心病管理日期
     */
    private Date isChdDate;
    /**
     * 是否脑卒中
     */
    private Integer isCa;

    /**
     * 纳入脑卒中管理日期
     */
    private Date isCaDate;

    private String jsonDetail;

    /**
     * 是否视力残疾
     */
    private Integer isDisabilityEyesight;

    /**
     * 是否听力残疾
     */
    private Integer isDisabilityHearing;

    /**
     * 是否言语残疾
     */
    private Integer isDisabilityLanguage;

    /**
     * 是否肢体残疾
     */
    private Integer isDisabilityLimbs;

    /**
     * 是否智力残疾
     */
    private Integer isDisabilityBrain;

    /**
     * 是否精神残疾
     */
    private Integer isDisabilityMind;

    @Transient
    private List<PersonDisease> personDisease;
    @Transient
    private List<PersonPastHistory> personPastHistory;
    @Transient
    private List<PersonCredential> personCredential;
    @Transient
    private List<RecordChoice> recordChoice;

    public List<PersonDisease> getPersonDisease() {
        return personDisease;
    }

    public void setPersonDisease(List<PersonDisease> personDisease) {
        this.personDisease = personDisease;
    }

    public List<PersonPastHistory> getPersonPastHistory() {
        return personPastHistory;
    }

    public void setPersonPastHistory(List<PersonPastHistory> personPastHistory) {
        this.personPastHistory = personPastHistory;
    }

    public List<PersonCredential> getPersonCredential() {
        return personCredential;
    }

    public void setPersonCredential(List<PersonCredential> personCredential) {
        this.personCredential = personCredential;
    }

    public List<RecordChoice> getRecordChoice() {
        return recordChoice;
    }

    public void setRecordChoice(List<RecordChoice> recordChoice) {
        this.recordChoice = recordChoice;
    }

    public Integer getIsDisabilityMind() {
        return this.isDisabilityMind;
    }

    public void setIsDisabilityMind(Integer isDisabilityMind) {
        this.isDisabilityMind = isDisabilityMind;
    }

    public Integer getIsDisabilityBrain() {
        return this.isDisabilityBrain;
    }

    public void setIsDisabilityBrain(Integer isDisabilityBrain) {
        this.isDisabilityBrain = isDisabilityBrain;
    }

    public Integer getIsDisabilityLimbs() {
        return this.isDisabilityLimbs;
    }

    public void setIsDisabilityLimbs(Integer isDisabilityLimbs) {
        this.isDisabilityLimbs = isDisabilityLimbs;
    }

    public Integer getIsDisabilityLanguage() {
        return this.isDisabilityLanguage;
    }

    public void setIsDisabilityLanguage(Integer isDisabilityLanguage) {
        this.isDisabilityLanguage = isDisabilityLanguage;
    }

    public Integer getIsDisabilityHearing() {
        return this.isDisabilityHearing;
    }

    public void setIsDisabilityHearing(Integer isDisabilityHearing) {
        this.isDisabilityHearing = isDisabilityHearing;
    }

    public Integer getIsDisabilityEyesight() {
        return this.isDisabilityEyesight;
    }

    public void setIsDisabilityEyesight(Integer isDisabilityEyesight) {
        this.isDisabilityEyesight = isDisabilityEyesight;
    }

    public String getJsonDetail() {
        return this.jsonDetail;
    }

    public void setJsonDetail(String jsonDetail) {
        this.jsonDetail = jsonDetail;
    }

    public Date getIsCaDate() {
        return this.isCaDate;
    }

    public void setIsCaDate(Date isCaDate) {
        this.isCaDate = isCaDate;
    }

    public Integer getIsCa() {
        return this.isCa;
    }

    public void setIsCa(Integer isCa) {
        this.isCa = isCa;
    }

    public Date getIsChdDate() {
        return this.isChdDate;
    }

    public void setIsChdDate(Date isChdDate) {
        this.isChdDate = isChdDate;
    }

    public Integer getIsChd() {
        return this.isChd;
    }

    public void setIsChd(Integer isChd) {
        this.isChd = isChd;
    }

    public Date getIsDiabetesHrDate() {
        return this.isDiabetesHrDate;
    }

    public void setIsDiabetesHrDate(Date isDiabetesHrDate) {
        this.isDiabetesHrDate = isDiabetesHrDate;
    }

    public Integer getIsDiabetesHr() {
        return this.isDiabetesHr;
    }

    public void setIsDiabetesHr(Integer isDiabetesHr) {
        this.isDiabetesHr = isDiabetesHr;
    }

    public Date getIsHyperHrDate() {
        return this.isHyperHrDate;
    }

    public void setIsHyperHrDate(Date isHyperHrDate) {
        this.isHyperHrDate = isHyperHrDate;
    }

    public Integer getIsHyperHr() {
        return this.isHyperHr;
    }

    public void setIsHyperHr(Integer isHyperHr) {
        this.isHyperHr = isHyperHr;
    }

    public String getPersonInfoCode() {
        return this.personInfoCode;
    }

    public void setPersonInfoCode(String personInfoCode) {
        this.personInfoCode = personInfoCode;
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

    public String getOrgCode() {
        return this.orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
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

    public Date getCancelTime() {
        return this.cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getCancelReason() {
        return this.cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getCancelReasonCode() {
        return this.cancelReasonCode;
    }

    public void setCancelReasonCode(String cancelReasonCode) {
        this.cancelReasonCode = cancelReasonCode;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getRespDoctorId() {
        return this.respDoctorId;
    }

    public void setRespDoctorId(String respDoctorId) {
        this.respDoctorId = respDoctorId;
    }

    public String getFamilyInfoId() {
        return this.familyInfoId;
    }

    public void setFamilyInfoId(String familyInfoId) {
        this.familyInfoId = familyInfoId;
    }

    public String getBuildingCN() {
        return this.buildingCN;
    }

    public void setBuildingCN(String buildingCN) {
        this.buildingCN = buildingCN;
    }

    public String getBuilding() {
        return this.building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getResidentialCN() {
        return this.residentialCN;
    }

    public void setResidentialCN(String residentialCN) {
        this.residentialCN = residentialCN;
    }

    public String getResidential() {
        return this.residential;
    }

    public void setResidential(String residential) {
        this.residential = residential;
    }

    public String getCommitteeCN() {
        return this.committeeCN;
    }

    public void setCommitteeCN(String committeeCN) {
        this.committeeCN = committeeCN;
    }

    public String getCommittee() {
        return this.committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }

    public String getPaperCardNum() {
        return this.paperCardNum;
    }

    public void setPaperCardNum(String paperCardNum) {
        this.paperCardNum = paperCardNum;
    }

    public Date getPaperArchiveDate() {
        return this.paperArchiveDate;
    }

    public void setPaperArchiveDate(Date paperArchiveDate) {
        this.paperArchiveDate = paperArchiveDate;
    }

    public String getHouseholdAddress() {
        return this.householdAddress;
    }

    public void setHouseholdAddress(String householdAddress) {
        this.householdAddress = householdAddress;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDeathDate() {
        return this.deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public Integer getIsDeath() {
        return this.isDeath;
    }

    public void setIsDeath(Integer isDeath) {
        this.isDeath = isDeath;
    }

    public Date getIsTuberculosisDate() {
        return this.isTuberculosisDate;
    }

    public void setIsTuberculosisDate(Date isTuberculosisDate) {
        this.isTuberculosisDate = isTuberculosisDate;
    }

    public Integer getIsTuberculosis() {
        return this.isTuberculosis;
    }

    public void setIsTuberculosis(Integer isTuberculosis) {
        this.isTuberculosis = isTuberculosis;
    }

    public Date getIsSmiDate() {
        return this.isSmiDate;
    }

    public void setIsSmiDate(Date isSmiDate) {
        this.isSmiDate = isSmiDate;
    }

    public Integer getIsSmi() {
        return this.isSmi;
    }

    public void setIsSmi(Integer isSmi) {
        this.isSmi = isSmi;
    }

    public Date getIsDiabetesDate() {
        return this.isDiabetesDate;
    }

    public void setIsDiabetesDate(Date isDiabetesDate) {
        this.isDiabetesDate = isDiabetesDate;
    }

    public Integer getIsDiabetes() {
        return this.isDiabetes;
    }

    public void setIsDiabetes(Integer isDiabetes) {
        this.isDiabetes = isDiabetes;
    }

    public Date getIsHypertensionDate() {
        return this.isHypertensionDate;
    }

    public void setIsHypertensionDate(Date isHypertensionDate) {
        this.isHypertensionDate = isHypertensionDate;
    }

    public Integer getIsHypertension() {
        return this.isHypertension;
    }

    public void setIsHypertension(Integer isHypertension) {
        this.isHypertension = isHypertension;
    }

    public Date getIsElderDate() {
        return this.isElderDate;
    }

    public void setIsElderDate(Date isElderDate) {
        this.isElderDate = isElderDate;
    }

    public Integer getIsElder() {
        return this.isElder;
    }

    public void setIsElder(Integer isElder) {
        this.isElder = isElder;
    }

    public Date getIsMaternalDate() {
        return this.isMaternalDate;
    }

    public void setIsMaternalDate(Date isMaternalDate) {
        this.isMaternalDate = isMaternalDate;
    }

    public Integer getIsMaternal() {
        return this.isMaternal;
    }

    public void setIsMaternal(Integer isMaternal) {
        this.isMaternal = isMaternal;
    }

    public Date getIsChildDate() {
        return this.isChildDate;
    }

    public void setIsChildDate(Date isChildDate) {
        this.isChildDate = isChildDate;
    }

    public Integer getIsChild() {
        return this.isChild;
    }

    public void setIsChild(Integer isChild) {
        this.isChild = isChild;
    }

    public Date getLastHealthExamDate() {
        return this.lastHealthExamDate;
    }

    public void setLastHealthExamDate(Date lastHealthExamDate) {
        this.lastHealthExamDate = lastHealthExamDate;
    }

    public Integer getExamCount() {
        return this.examCount;
    }

    public void setExamCount(Integer examCount) {
        this.examCount = examCount;
    }

    public String getLivestockFenceCode() {
        return this.livestockFenceCode;
    }

    public void setLivestockFenceCode(String livestockFenceCode) {
        this.livestockFenceCode = livestockFenceCode;
    }

    public String getToiletCode() {
        return this.toiletCode;
    }

    public void setToiletCode(String toiletCode) {
        this.toiletCode = toiletCode;
    }

    public String getKitchenExhaustCode() {
        return this.kitchenExhaustCode;
    }

    public void setKitchenExhaustCode(String kitchenExhaustCode) {
        this.kitchenExhaustCode = kitchenExhaustCode;
    }

    public String getGeneticDiseaseHistoryName() {
        return this.geneticDiseaseHistoryName;
    }

    public void setGeneticDiseaseHistoryName(String geneticDiseaseHistoryName) {
        this.geneticDiseaseHistoryName = geneticDiseaseHistoryName;
    }

    public String getGeneticDiseaseHistoryCode() {
        return this.geneticDiseaseHistoryCode;
    }

    public void setGeneticDiseaseHistoryCode(String geneticDiseaseHistoryCode) {
        this.geneticDiseaseHistoryCode = geneticDiseaseHistoryCode;
    }

    public String getMarriageCode() {
        return this.marriageCode;
    }

    public void setMarriageCode(String marriageCode) {
        this.marriageCode = marriageCode;
    }

    public String getOccupationCode() {
        return this.occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public String getEducationCode() {
        return this.educationCode;
    }

    public void setEducationCode(String educationCode) {
        this.educationCode = educationCode;
    }

    public String getRelationValue() {
        return this.relationValue;
    }

    public void setRelationValue(String relationValue) {
        this.relationValue = relationValue;
    }

    public String getRelationCode() {
        return this.relationCode;
    }

    public void setRelationCode(String relationCode) {
        this.relationCode = relationCode;
    }

    public String getRhCode() {
        return this.rhCode;
    }

    public void setRhCode(String rhCode) {
        this.rhCode = rhCode;
    }

    public String getAboCode() {
        return this.aboCode;
    }

    public void setAboCode(String aboCode) {
        this.aboCode = aboCode;
    }

    public String getNationalityValue() {
        return this.nationalityValue;
    }

    public void setNationalityValue(String nationalityValue) {
        this.nationalityValue = nationalityValue;
    }

    public String getNationalityCode() {
        return this.nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public String getHouseholdTypeCode() {
        return this.householdTypeCode;
    }

    public void setHouseholdTypeCode(String householdTypeCode) {
        this.householdTypeCode = householdTypeCode;
    }

    public String getResidenceTypeCode() {
        return this.residenceTypeCode;
    }

    public void setResidenceTypeCode(String residenceTypeCode) {
        this.residenceTypeCode = residenceTypeCode;
    }

    public String getContactTelNo() {
        return this.contactTelNo;
    }

    public void setContactTelNo(String contactTelNo) {
        this.contactTelNo = contactTelNo;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getFixedPhones() {
        return this.fixedPhones;
    }

    public void setFixedPhones(String fixedPhones) {
        this.fixedPhones = fixedPhones;
    }

    public String getTelNo() {
        return this.telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getWorkUnit() {
        return this.workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getIdNo() {
        return this.idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSexValue() {
        return this.sexValue;
    }

    public void setSexValue(String sexValue) {
        this.sexValue = sexValue;
    }

    public String getSexCode() {
        return this.sexCode;
    }

    public void setSexCode(String sexCode) {
        this.sexCode = sexCode;
    }

    public String getFormerName() {
        return this.formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getHealthcareOrg() {
        return this.healthcareOrg;
    }

    public void setHealthcareOrg(String healthcareOrg) {
        this.healthcareOrg = healthcareOrg;
    }

    public String getPersonInfoSno() {
        return this.personInfoSno;
    }

    public void setPersonInfoSno(String personInfoSno) {
        this.personInfoSno = personInfoSno;
    }

    public String getPersonInfoNo() {
        return this.personInfoNo;
    }

    public void setPersonInfoNo(String personInfoNo) {
        this.personInfoNo = personInfoNo;
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

    @Generated(hash = 931057902)
    public PersonInfo(String personInfoId, String manageOrgId, String personInfoNo,
                      String personInfoSno, String healthcareOrg, String cardNo, String name,
                      String formerName, String sexCode, String sexValue, Date birthday,
                      String idNo, String workUnit, String telNo, String fixedPhones,
                      String contactName, String contactTelNo, String residenceTypeCode,
                      String householdTypeCode, String nationalityCode,
                      String nationalityValue, String aboCode, String rhCode,
                      String relationCode, String relationValue, String educationCode,
                      String occupationCode, String marriageCode,
                      String geneticDiseaseHistoryCode, String geneticDiseaseHistoryName,
                      String kitchenExhaustCode, String toiletCode,
                      String livestockFenceCode, Integer examCount, Date lastHealthExamDate,
                      Integer isChild, Date isChildDate, Integer isMaternal,
                      Date isMaternalDate, Integer isElder, Date isElderDate,
                      Integer isHypertension, Date isHypertensionDate, Integer isDiabetes,
                      Date isDiabetesDate, Integer isSmi, Date isSmiDate,
                      Integer isTuberculosis, Date isTuberculosisDate, Integer isDeath,
                      Date deathDate, String address, String householdAddress,
                      Date paperArchiveDate, String paperCardNum, String committee,
                      String committeeCN, String residential, String residentialCN,
                      String building, String buildingCN, String familyInfoId,
                      String respDoctorId, String photoUrl, String statusCode,
                      String cancelReasonCode, String cancelReason, Date cancelTime,
                      String createOrgId, String orgName, String orgCode, String creatorId,
                      String creator, Date createTime, String modifiedOrgId,
                      String modifiedOrgName, String modifierId, String modifier,
                      Date modifiedTime, String personInfoCode, Integer isHyperHr,
                      Date isHyperHrDate, Integer isDiabetesHr, Date isDiabetesHrDate,
                      Integer isChd, Date isChdDate, Integer isCa, Date isCaDate,
                      String jsonDetail, Integer isDisabilityEyesight,
                      Integer isDisabilityHearing, Integer isDisabilityLanguage,
                      Integer isDisabilityLimbs, Integer isDisabilityBrain,
                      Integer isDisabilityMind) {
        this.personInfoId = personInfoId;
        this.manageOrgId = manageOrgId;
        this.personInfoNo = personInfoNo;
        this.personInfoSno = personInfoSno;
        this.healthcareOrg = healthcareOrg;
        this.cardNo = cardNo;
        this.name = name;
        this.formerName = formerName;
        this.sexCode = sexCode;
        this.sexValue = sexValue;
        this.birthday = birthday;
        this.idNo = idNo;
        this.workUnit = workUnit;
        this.telNo = telNo;
        this.fixedPhones = fixedPhones;
        this.contactName = contactName;
        this.contactTelNo = contactTelNo;
        this.residenceTypeCode = residenceTypeCode;
        this.householdTypeCode = householdTypeCode;
        this.nationalityCode = nationalityCode;
        this.nationalityValue = nationalityValue;
        this.aboCode = aboCode;
        this.rhCode = rhCode;
        this.relationCode = relationCode;
        this.relationValue = relationValue;
        this.educationCode = educationCode;
        this.occupationCode = occupationCode;
        this.marriageCode = marriageCode;
        this.geneticDiseaseHistoryCode = geneticDiseaseHistoryCode;
        this.geneticDiseaseHistoryName = geneticDiseaseHistoryName;
        this.kitchenExhaustCode = kitchenExhaustCode;
        this.toiletCode = toiletCode;
        this.livestockFenceCode = livestockFenceCode;
        this.examCount = examCount;
        this.lastHealthExamDate = lastHealthExamDate;
        this.isChild = isChild;
        this.isChildDate = isChildDate;
        this.isMaternal = isMaternal;
        this.isMaternalDate = isMaternalDate;
        this.isElder = isElder;
        this.isElderDate = isElderDate;
        this.isHypertension = isHypertension;
        this.isHypertensionDate = isHypertensionDate;
        this.isDiabetes = isDiabetes;
        this.isDiabetesDate = isDiabetesDate;
        this.isSmi = isSmi;
        this.isSmiDate = isSmiDate;
        this.isTuberculosis = isTuberculosis;
        this.isTuberculosisDate = isTuberculosisDate;
        this.isDeath = isDeath;
        this.deathDate = deathDate;
        this.address = address;
        this.householdAddress = householdAddress;
        this.paperArchiveDate = paperArchiveDate;
        this.paperCardNum = paperCardNum;
        this.committee = committee;
        this.committeeCN = committeeCN;
        this.residential = residential;
        this.residentialCN = residentialCN;
        this.building = building;
        this.buildingCN = buildingCN;
        this.familyInfoId = familyInfoId;
        this.respDoctorId = respDoctorId;
        this.photoUrl = photoUrl;
        this.statusCode = statusCode;
        this.cancelReasonCode = cancelReasonCode;
        this.cancelReason = cancelReason;
        this.cancelTime = cancelTime;
        this.createOrgId = createOrgId;
        this.orgName = orgName;
        this.orgCode = orgCode;
        this.creatorId = creatorId;
        this.creator = creator;
        this.createTime = createTime;
        this.modifiedOrgId = modifiedOrgId;
        this.modifiedOrgName = modifiedOrgName;
        this.modifierId = modifierId;
        this.modifier = modifier;
        this.modifiedTime = modifiedTime;
        this.personInfoCode = personInfoCode;
        this.isHyperHr = isHyperHr;
        this.isHyperHrDate = isHyperHrDate;
        this.isDiabetesHr = isDiabetesHr;
        this.isDiabetesHrDate = isDiabetesHrDate;
        this.isChd = isChd;
        this.isChdDate = isChdDate;
        this.isCa = isCa;
        this.isCaDate = isCaDate;
        this.jsonDetail = jsonDetail;
        this.isDisabilityEyesight = isDisabilityEyesight;
        this.isDisabilityHearing = isDisabilityHearing;
        this.isDisabilityLanguage = isDisabilityLanguage;
        this.isDisabilityLimbs = isDisabilityLimbs;
        this.isDisabilityBrain = isDisabilityBrain;
        this.isDisabilityMind = isDisabilityMind;
    }

    @Generated(hash = 1597442618)
    @Keep
    public PersonInfo() {
        recordChoice = new ArrayList<>();
        personCredential = new ArrayList<>();
        personPastHistory = new ArrayList<>();
        personDisease = new ArrayList<>();
    }

}
