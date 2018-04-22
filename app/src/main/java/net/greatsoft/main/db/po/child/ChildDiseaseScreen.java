package net.greatsoft.main.db.po.child;

import java.util.Date;


import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年7月19日 下午12:01:49 
 * @Description: 新生儿疾病筛查
 *
 */
@Entity
public class ChildDiseaseScreen extends Entry {
    /**
     * 新生儿疾病筛查ID
     */
    
    private String childDiseaseScreenId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;

    /**
     * 新生儿疾病筛查编号
     */

    private String childDiseaseScreenNo;

    /**
     * 新生儿姓名
     */
    private String name;

    /**
     * 新生儿性别代码
     */
    private String sexCode;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 母亲姓名
     */
    private String motherName;

    /**
     * 母亲出生日期
     */
    private Date motherBirthDate;

    /**
     * 母亲身份证件-类别代码
     */
    private String motherIdTypeCode;

    /**
     * 母亲身份证件-号码
     */
    private String motherIdNo;

    /**
     * 分娩机构名称
     */
    private String deliveryOrgName;

    /**
     * 住院号
     */
    private String resiCaseNo;

    /**
     * 床位号
     */
    private String bedNo;

    /**
     * 孕周(周),格式：孕周+天
     */
    private String pregnancyNo;

    /**
     * 分娩方式
     */
    private String deliveryWay;

    /**
     * Apgar1分钟评分值（分）
     */
    private Integer apgar1Score;

    /**
     * Apgar5分钟评分值（分）
     */
    private Integer apgar5Score;

    /**
     * Apgar10分钟评分值（分）
     */
    private Integer apgar10Score;

    /**
     * 体重(kg)
     */
    private Double weight;

    /**
     * 新生儿情况
     */
    private String childInfo;

    /**
     * 产妇情况
     */
    private String parturientInfo;

    /**
     * 通讯地址
     */
    private String communicationAddress;

    /**
     * 户籍地址
     */
    private String householdAddress;

    /**
     * 现住地址
     */
    private String presentAddress;

    /**
     * 邮政编码
     */
    private String postalCode;

    /**
     * 联系电话-号码
     */
    private String telNo;

    /**
     * 筛查类别
     */
    private String screenType;

    /**
     * 标本编号
     */
    private String sampleNo;

    /**
     * 采血日期时间
     */
    private Date bloodTime;

    /**
     * 采血方式代码
     */
    private String bloodWay;

    /**
     * 采血部位代码
     */
    private String bloodPart;

    /**
     * 采血机构名称
     */
    private String bloodOrgName;

    /**
     * 采血人员姓名
     */
    private String bloodOperatorName;

    /**
     * 标本寄出日期
     */
    private Date sampleSendDate;

    /**
     * 标本收到日期
     */
    private Date sampleReceiveDate;

    /**
     * 标本质量
     */
    private String specimenQuantity;

    /**
     * 标本不合格原因
     */
    private String sampleUncheckoutReason;

    /**
     * 新生儿疾病筛查方法代码
     */
    private String screenWay;

    /**
     * 检查日期
     */
    private Date examineDate;

    /**
     * 检查人员姓名
     */
    private String examineOperatorName;

    /**
     * 检查机构名称
     */
    private String examineOrgName;

    /**
     * 召回日期
     */
    private Date callbackDate;

    /**
     * 筛查结果通知日期
     */
    private Date noticeDate;

    /**
     * 检查结果通知形式代码
     */
    private String noticeWay;

    /**
     * 通知到达人姓名
     */
    private String noticeName;

    /**
     * 通知到达人与新生儿关系代码
     */
    private String noticeNameRelation;

    /**
     * 通知者姓名
     */
    private String noticeOperatorName;

    /**
     * 预约日期
     */
    private Date precontractDate;

    /**
     * 登记日期
     */
    private Date createDate;

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

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPrecontractDate() {
        return this.precontractDate;
    }

    public void setPrecontractDate(Date precontractDate) {
        this.precontractDate = precontractDate;
    }

    public String getNoticeOperatorName() {
        return this.noticeOperatorName;
    }

    public void setNoticeOperatorName(String noticeOperatorName) {
        this.noticeOperatorName = noticeOperatorName;
    }

    public String getNoticeNameRelation() {
        return this.noticeNameRelation;
    }

    public void setNoticeNameRelation(String noticeNameRelation) {
        this.noticeNameRelation = noticeNameRelation;
    }

    public String getNoticeName() {
        return this.noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeWay() {
        return this.noticeWay;
    }

    public void setNoticeWay(String noticeWay) {
        this.noticeWay = noticeWay;
    }

    public Date getNoticeDate() {
        return this.noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public Date getCallbackDate() {
        return this.callbackDate;
    }

    public void setCallbackDate(Date callbackDate) {
        this.callbackDate = callbackDate;
    }

    public String getExamineOrgName() {
        return this.examineOrgName;
    }

    public void setExamineOrgName(String examineOrgName) {
        this.examineOrgName = examineOrgName;
    }

    public String getExamineOperatorName() {
        return this.examineOperatorName;
    }

    public void setExamineOperatorName(String examineOperatorName) {
        this.examineOperatorName = examineOperatorName;
    }

    public Date getExamineDate() {
        return this.examineDate;
    }

    public void setExamineDate(Date examineDate) {
        this.examineDate = examineDate;
    }

    public String getScreenWay() {
        return this.screenWay;
    }

    public void setScreenWay(String screenWay) {
        this.screenWay = screenWay;
    }

    public String getSampleUncheckoutReason() {
        return this.sampleUncheckoutReason;
    }

    public void setSampleUncheckoutReason(String sampleUncheckoutReason) {
        this.sampleUncheckoutReason = sampleUncheckoutReason;
    }

    public String getSpecimenQuantity() {
        return this.specimenQuantity;
    }

    public void setSpecimenQuantity(String specimenQuantity) {
        this.specimenQuantity = specimenQuantity;
    }

    public Date getSampleReceiveDate() {
        return this.sampleReceiveDate;
    }

    public void setSampleReceiveDate(Date sampleReceiveDate) {
        this.sampleReceiveDate = sampleReceiveDate;
    }

    public Date getSampleSendDate() {
        return this.sampleSendDate;
    }

    public void setSampleSendDate(Date sampleSendDate) {
        this.sampleSendDate = sampleSendDate;
    }

    public String getBloodOperatorName() {
        return this.bloodOperatorName;
    }

    public void setBloodOperatorName(String bloodOperatorName) {
        this.bloodOperatorName = bloodOperatorName;
    }

    public String getBloodOrgName() {
        return this.bloodOrgName;
    }

    public void setBloodOrgName(String bloodOrgName) {
        this.bloodOrgName = bloodOrgName;
    }

    public String getBloodPart() {
        return this.bloodPart;
    }

    public void setBloodPart(String bloodPart) {
        this.bloodPart = bloodPart;
    }

    public String getBloodWay() {
        return this.bloodWay;
    }

    public void setBloodWay(String bloodWay) {
        this.bloodWay = bloodWay;
    }

    public Date getBloodTime() {
        return this.bloodTime;
    }

    public void setBloodTime(Date bloodTime) {
        this.bloodTime = bloodTime;
    }

    public String getSampleNo() {
        return this.sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getScreenType() {
        return this.screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getTelNo() {
        return this.telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPresentAddress() {
        return this.presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getHouseholdAddress() {
        return this.householdAddress;
    }

    public void setHouseholdAddress(String householdAddress) {
        this.householdAddress = householdAddress;
    }

    public String getCommunicationAddress() {
        return this.communicationAddress;
    }

    public void setCommunicationAddress(String communicationAddress) {
        this.communicationAddress = communicationAddress;
    }

    public String getParturientInfo() {
        return this.parturientInfo;
    }

    public void setParturientInfo(String parturientInfo) {
        this.parturientInfo = parturientInfo;
    }

    public String getChildInfo() {
        return this.childInfo;
    }

    public void setChildInfo(String childInfo) {
        this.childInfo = childInfo;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getApgar10Score() {
        return this.apgar10Score;
    }

    public void setApgar10Score(Integer apgar10Score) {
        this.apgar10Score = apgar10Score;
    }

    public Integer getApgar5Score() {
        return this.apgar5Score;
    }

    public void setApgar5Score(Integer apgar5Score) {
        this.apgar5Score = apgar5Score;
    }

    public Integer getApgar1Score() {
        return this.apgar1Score;
    }

    public void setApgar1Score(Integer apgar1Score) {
        this.apgar1Score = apgar1Score;
    }

    public String getDeliveryWay() {
        return this.deliveryWay;
    }

    public void setDeliveryWay(String deliveryWay) {
        this.deliveryWay = deliveryWay;
    }

    public String getPregnancyNo() {
        return this.pregnancyNo;
    }

    public void setPregnancyNo(String pregnancyNo) {
        this.pregnancyNo = pregnancyNo;
    }

    public String getBedNo() {
        return this.bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public String getResiCaseNo() {
        return this.resiCaseNo;
    }

    public void setResiCaseNo(String resiCaseNo) {
        this.resiCaseNo = resiCaseNo;
    }

    public String getDeliveryOrgName() {
        return this.deliveryOrgName;
    }

    public void setDeliveryOrgName(String deliveryOrgName) {
        this.deliveryOrgName = deliveryOrgName;
    }

    public String getMotherIdNo() {
        return this.motherIdNo;
    }

    public void setMotherIdNo(String motherIdNo) {
        this.motherIdNo = motherIdNo;
    }

    public String getMotherIdTypeCode() {
        return this.motherIdTypeCode;
    }

    public void setMotherIdTypeCode(String motherIdTypeCode) {
        this.motherIdTypeCode = motherIdTypeCode;
    }

    public Date getMotherBirthDate() {
        return this.motherBirthDate;
    }

    public void setMotherBirthDate(Date motherBirthDate) {
        this.motherBirthDate = motherBirthDate;
    }

    public String getMotherName() {
        return this.motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSexCode() {
        return this.sexCode;
    }

    public void setSexCode(String sexCode) {
        this.sexCode = sexCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChildDiseaseScreenNo() {
        return this.childDiseaseScreenNo;
    }

    public void setChildDiseaseScreenNo(String childDiseaseScreenNo) {
        this.childDiseaseScreenNo = childDiseaseScreenNo;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getChildDiseaseScreenId() {
        return this.childDiseaseScreenId;
    }

    public void setChildDiseaseScreenId(String childDiseaseScreenId) {
        this.childDiseaseScreenId = childDiseaseScreenId;
    }

    @Generated(hash = 1903944943)
    public ChildDiseaseScreen(String childDiseaseScreenId, String personInfoId,
            String childDiseaseScreenNo, String name, String sexCode,
            Date birthDate, String motherName, Date motherBirthDate,
            String motherIdTypeCode, String motherIdNo, String deliveryOrgName,
            String resiCaseNo, String bedNo, String pregnancyNo,
            String deliveryWay, Integer apgar1Score, Integer apgar5Score,
            Integer apgar10Score, Double weight, String childInfo,
            String parturientInfo, String communicationAddress,
            String householdAddress, String presentAddress, String postalCode,
            String telNo, String screenType, String sampleNo, Date bloodTime,
            String bloodWay, String bloodPart, String bloodOrgName,
            String bloodOperatorName, Date sampleSendDate, Date sampleReceiveDate,
            String specimenQuantity, String sampleUncheckoutReason,
            String screenWay, Date examineDate, String examineOperatorName,
            String examineOrgName, Date callbackDate, Date noticeDate,
            String noticeWay, String noticeName, String noticeNameRelation,
            String noticeOperatorName, Date precontractDate, Date createDate,
            Integer isCancel, String createOrgId, String orgName, String creatorId,
            String creator, Date createTime, String modifiedOrgId,
            String modifiedOrgName, String modifierId, String modifier,
            Date modifiedTime) {
        this.childDiseaseScreenId = childDiseaseScreenId;
        this.personInfoId = personInfoId;
        this.childDiseaseScreenNo = childDiseaseScreenNo;
        this.name = name;
        this.sexCode = sexCode;
        this.birthDate = birthDate;
        this.motherName = motherName;
        this.motherBirthDate = motherBirthDate;
        this.motherIdTypeCode = motherIdTypeCode;
        this.motherIdNo = motherIdNo;
        this.deliveryOrgName = deliveryOrgName;
        this.resiCaseNo = resiCaseNo;
        this.bedNo = bedNo;
        this.pregnancyNo = pregnancyNo;
        this.deliveryWay = deliveryWay;
        this.apgar1Score = apgar1Score;
        this.apgar5Score = apgar5Score;
        this.apgar10Score = apgar10Score;
        this.weight = weight;
        this.childInfo = childInfo;
        this.parturientInfo = parturientInfo;
        this.communicationAddress = communicationAddress;
        this.householdAddress = householdAddress;
        this.presentAddress = presentAddress;
        this.postalCode = postalCode;
        this.telNo = telNo;
        this.screenType = screenType;
        this.sampleNo = sampleNo;
        this.bloodTime = bloodTime;
        this.bloodWay = bloodWay;
        this.bloodPart = bloodPart;
        this.bloodOrgName = bloodOrgName;
        this.bloodOperatorName = bloodOperatorName;
        this.sampleSendDate = sampleSendDate;
        this.sampleReceiveDate = sampleReceiveDate;
        this.specimenQuantity = specimenQuantity;
        this.sampleUncheckoutReason = sampleUncheckoutReason;
        this.screenWay = screenWay;
        this.examineDate = examineDate;
        this.examineOperatorName = examineOperatorName;
        this.examineOrgName = examineOrgName;
        this.callbackDate = callbackDate;
        this.noticeDate = noticeDate;
        this.noticeWay = noticeWay;
        this.noticeName = noticeName;
        this.noticeNameRelation = noticeNameRelation;
        this.noticeOperatorName = noticeOperatorName;
        this.precontractDate = precontractDate;
        this.createDate = createDate;
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

    @Generated(hash = 332566636)
    public ChildDiseaseScreen() {
    }


}