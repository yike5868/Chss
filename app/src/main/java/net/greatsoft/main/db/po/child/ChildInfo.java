package net.greatsoft.main.db.po.child;

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
 * @author AlphGo
 * @date 2016年7月19日 下午12:04:50
 * @Description: 儿童基本信息
 */
@Entity
public class ChildInfo extends Entry {
    /**
     * 新生儿档案ID
     */

    private String childInfoId;

    /**
     * 个人档案ID
     */

    private String personInfoId;

    /**
     * 管理机构ID
     */

    private String manageOrgId;

    /**
     * 档案编号
     */

    private String childInfoNo;

    /**
     * 档案自行编号
     */

    private String childInfoSno;

    /**
     * 新生儿姓名
     */

    private String newbornName;

    /**
     * 新生儿性别代码
     */

    private String newbornSexCode;

    /**
     * 新生儿出生日期
     */


    private Date newbornBirthDate;

    /**
     * 新生儿身份证号码
     */

    private String newbornIdNo;

    /**
     * 家庭住址
     */
    private String presentAddrProvince;

    /**
     * 父亲档案ID
     */

    private String fatherId;

    /**
     * 父亲姓名
     */

    private String fatherName;

    /**
     * 父亲身份证号
     */

    private String fatherIdno;

    /**
     * 父亲职业类别代码
     */

    private String fatherOccupCode;

    /**
     * 父亲电话号码
     */

    private String fatherTelNo;

    /**
     * 父亲出生日期
     */


    private Date fatherBirthDate;

    /**
     * 父亲工作单位
     */
    private String fatherWorkUnit;

    /**
     * 母亲档案ID
     */

    private String motherId;

    /**
     * 母亲姓名
     */

    private String motherName;

    /**
     * 母亲身份证号
     */

    private String motherIdno;

    /**
     * 母亲职业类别代码
     */

    private String motherOccupCode;

    /**
     * 母亲电话号码
     */

    private String motherTelNo;

    /**
     * 母亲出生日期
     */


    private Date motherBirthDate;

    /**
     * 母亲工作单位
     */
    private String motherWorkUnit;

    /**
     * 其他监护人
     */

    private String guardian;

    /**
     * 监护人关系
     */

    private String guardianRelation;

    /**
     * 监护人电话
     */
    private String guardianTelNo;

    /**
     * 监护人工作单位
     */

    private String guardianWorkUnit;

    /**
     * 监护人联系地址
     */
    private String guardianAddress;

    /**
     * 出生孕周
     */
    private Integer birthGestWeeks;

    /**
     * 出生孕天
     */
    private Integer birthGestDays;

    /**
     * 母亲妊娠期患病代码
     */

    private String motherHdcpCode;

    /**
     * 母亲妊娠期其他患病描述
     */
    private String motherHdcpOthersDesc;

    /**
     * 助产机构名称
     */
    private String deliveryOrgName;

    /**
     * 末次分娩方式代码
     */
    private String lastDeliverWayCode;

    /**
     * 双多胎标志
     */

    private String twinsCode;

    /**
     * 新生儿窒息标志
     */

    private String asphyxiaCode;

    /**
     * 窒息严重情况
     */
    private String suffocationType;

    /**
     * Apgar评分代码
     */

    private String apgarScoreCode;

    /**
     * Apgar评分值（分）
     */
    private Integer apgarScore;

    /**
     * 新生儿畸形标志
     */

    private String malformCode;

    /**
     * 新生儿畸形描述
     */

    private String malformDesc;

    /**
     * 新生儿听力筛查情况代码
     */
    private String hearingScreenCode;

    /**
     * 新生儿听力筛查结果代码
     */

    private String hearingScreenResultCode;

    /**
     * 新生儿疾病筛查项目代码
     */
    private String diseaseScreenCode;

    /**
     * 新生儿疾病筛查其他描述
     */

    private String diseaseScreenOthersDesc;

    /**
     * 出生体重(g)
     */
    private Double birthWeight;

    /**
     * 出生身长（cm)
     */
    private Double birthLength;

    /**
     * 是否建立儿童保健手册
     */
    private Integer childrenBookIsBuild;

    /**
     * 建立儿童保健手册时间
     */


    private Date childrenBookBuildDate;

    /**
     * 被调查人
     */

    private String respondent;

    /**
     * 调查时间
     */


    private Date investigateDate;

    /**
     * 专项档案状态
     */

    private String caseStatus;

    /**
     * 最近一次随访日期
     */


    private Date lastVisitDate;

    /**
     * 最近一次随访类型
     */

    private String lastVisitTypeCode;

    /**
     * 最近一次随访医师
     */

    private String lastVisitPerson;

    /**
     * 下次随访日期
     */


    private Date nextVisitDate;

    /**
     * 下次随访类型
     */

    private String nextVisitTypeCode;

    /**
     * 下次随访医师
     */

    private String nextVisitPerson;

    /**
     * 是否体弱儿(1是，2否)
     */
    private Integer isWeakChildren;

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

    private String jsonDetail;

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

    /**
     * 手工结案标志 1是 2否
     */
    private String closeCaseCode;

    /**
     * 手工结案原因
     */
    private String closeCaseReason;

    public List<RecordChoice> getRecordChoice() {
        return recordChoice;
    }

    public void setRecordChoice(List<RecordChoice> recordChoice) {
        this.recordChoice = recordChoice;
    }

    public String getCloseCaseReason() {
        return this.closeCaseReason;
    }

    public void setCloseCaseReason(String closeCaseReason) {
        this.closeCaseReason = closeCaseReason;
    }

    public String getCloseCaseCode() {
        return this.closeCaseCode;
    }

    public void setCloseCaseCode(String closeCaseCode) {
        this.closeCaseCode = closeCaseCode;
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

    public Integer getIsWeakChildren() {
        return this.isWeakChildren;
    }

    public void setIsWeakChildren(Integer isWeakChildren) {
        this.isWeakChildren = isWeakChildren;
    }

    public String getNextVisitPerson() {
        return this.nextVisitPerson;
    }

    public void setNextVisitPerson(String nextVisitPerson) {
        this.nextVisitPerson = nextVisitPerson;
    }

    public String getNextVisitTypeCode() {
        return this.nextVisitTypeCode;
    }

    public void setNextVisitTypeCode(String nextVisitTypeCode) {
        this.nextVisitTypeCode = nextVisitTypeCode;
    }

    public Date getNextVisitDate() {
        return this.nextVisitDate;
    }

    public void setNextVisitDate(Date nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }

    public String getLastVisitPerson() {
        return this.lastVisitPerson;
    }

    public void setLastVisitPerson(String lastVisitPerson) {
        this.lastVisitPerson = lastVisitPerson;
    }

    public String getLastVisitTypeCode() {
        return this.lastVisitTypeCode;
    }

    public void setLastVisitTypeCode(String lastVisitTypeCode) {
        this.lastVisitTypeCode = lastVisitTypeCode;
    }

    public Date getLastVisitDate() {
        return this.lastVisitDate;
    }

    public void setLastVisitDate(Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getCaseStatus() {
        return this.caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public Date getInvestigateDate() {
        return this.investigateDate;
    }

    public void setInvestigateDate(Date investigateDate) {
        this.investigateDate = investigateDate;
    }

    public String getRespondent() {
        return this.respondent;
    }

    public void setRespondent(String respondent) {
        this.respondent = respondent;
    }

    public Date getChildrenBookBuildDate() {
        return this.childrenBookBuildDate;
    }

    public void setChildrenBookBuildDate(Date childrenBookBuildDate) {
        this.childrenBookBuildDate = childrenBookBuildDate;
    }

    public Integer getChildrenBookIsBuild() {
        return this.childrenBookIsBuild;
    }

    public void setChildrenBookIsBuild(Integer childrenBookIsBuild) {
        this.childrenBookIsBuild = childrenBookIsBuild;
    }

    public Double getBirthLength() {
        return this.birthLength;
    }

    public void setBirthLength(Double birthLength) {
        this.birthLength = birthLength;
    }

    public Double getBirthWeight() {
        return this.birthWeight;
    }

    public void setBirthWeight(Double birthWeight) {
        this.birthWeight = birthWeight;
    }

    public String getDiseaseScreenOthersDesc() {
        return this.diseaseScreenOthersDesc;
    }

    public void setDiseaseScreenOthersDesc(String diseaseScreenOthersDesc) {
        this.diseaseScreenOthersDesc = diseaseScreenOthersDesc;
    }

    public String getDiseaseScreenCode() {
        return this.diseaseScreenCode;
    }

    public void setDiseaseScreenCode(String diseaseScreenCode) {
        this.diseaseScreenCode = diseaseScreenCode;
    }

    public String getHearingScreenResultCode() {
        return this.hearingScreenResultCode;
    }

    public void setHearingScreenResultCode(String hearingScreenResultCode) {
        this.hearingScreenResultCode = hearingScreenResultCode;
    }

    public String getHearingScreenCode() {
        return this.hearingScreenCode;
    }

    public void setHearingScreenCode(String hearingScreenCode) {
        this.hearingScreenCode = hearingScreenCode;
    }

    public String getMalformDesc() {
        return this.malformDesc;
    }

    public void setMalformDesc(String malformDesc) {
        this.malformDesc = malformDesc;
    }

    public String getMalformCode() {
        return this.malformCode;
    }

    public void setMalformCode(String malformCode) {
        this.malformCode = malformCode;
    }

    public Integer getApgarScore() {
        return this.apgarScore;
    }

    public void setApgarScore(Integer apgarScore) {
        this.apgarScore = apgarScore;
    }

    public String getApgarScoreCode() {
        return this.apgarScoreCode;
    }

    public void setApgarScoreCode(String apgarScoreCode) {
        this.apgarScoreCode = apgarScoreCode;
    }

    public String getSuffocationType() {
        return this.suffocationType;
    }

    public void setSuffocationType(String suffocationType) {
        this.suffocationType = suffocationType;
    }

    public String getAsphyxiaCode() {
        return this.asphyxiaCode;
    }

    public void setAsphyxiaCode(String asphyxiaCode) {
        this.asphyxiaCode = asphyxiaCode;
    }

    public String getTwinsCode() {
        return this.twinsCode;
    }

    public void setTwinsCode(String twinsCode) {
        this.twinsCode = twinsCode;
    }

    public String getLastDeliverWayCode() {
        return this.lastDeliverWayCode;
    }

    public void setLastDeliverWayCode(String lastDeliverWayCode) {
        this.lastDeliverWayCode = lastDeliverWayCode;
    }

    public String getDeliveryOrgName() {
        return this.deliveryOrgName;
    }

    public void setDeliveryOrgName(String deliveryOrgName) {
        this.deliveryOrgName = deliveryOrgName;
    }

    public String getMotherHdcpOthersDesc() {
        return this.motherHdcpOthersDesc;
    }

    public void setMotherHdcpOthersDesc(String motherHdcpOthersDesc) {
        this.motherHdcpOthersDesc = motherHdcpOthersDesc;
    }

    public String getMotherHdcpCode() {
        return this.motherHdcpCode;
    }

    public void setMotherHdcpCode(String motherHdcpCode) {
        this.motherHdcpCode = motherHdcpCode;
    }

    public Integer getBirthGestDays() {
        return this.birthGestDays;
    }

    public void setBirthGestDays(Integer birthGestDays) {
        this.birthGestDays = birthGestDays;
    }

    public Integer getBirthGestWeeks() {
        return this.birthGestWeeks;
    }

    public void setBirthGestWeeks(Integer birthGestWeeks) {
        this.birthGestWeeks = birthGestWeeks;
    }

    public String getGuardianAddress() {
        return this.guardianAddress;
    }

    public void setGuardianAddress(String guardianAddress) {
        this.guardianAddress = guardianAddress;
    }

    public String getGuardianWorkUnit() {
        return this.guardianWorkUnit;
    }

    public void setGuardianWorkUnit(String guardianWorkUnit) {
        this.guardianWorkUnit = guardianWorkUnit;
    }

    public String getGuardianTelNo() {
        return this.guardianTelNo;
    }

    public void setGuardianTelNo(String guardianTelNo) {
        this.guardianTelNo = guardianTelNo;
    }

    public String getGuardianRelation() {
        return this.guardianRelation;
    }

    public void setGuardianRelation(String guardianRelation) {
        this.guardianRelation = guardianRelation;
    }

    public String getGuardian() {
        return this.guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public String getMotherWorkUnit() {
        return this.motherWorkUnit;
    }

    public void setMotherWorkUnit(String motherWorkUnit) {
        this.motherWorkUnit = motherWorkUnit;
    }

    public Date getMotherBirthDate() {
        return this.motherBirthDate;
    }

    public void setMotherBirthDate(Date motherBirthDate) {
        this.motherBirthDate = motherBirthDate;
    }

    public String getMotherTelNo() {
        return this.motherTelNo;
    }

    public void setMotherTelNo(String motherTelNo) {
        this.motherTelNo = motherTelNo;
    }

    public String getMotherOccupCode() {
        return this.motherOccupCode;
    }

    public void setMotherOccupCode(String motherOccupCode) {
        this.motherOccupCode = motherOccupCode;
    }

    public String getMotherIdno() {
        return this.motherIdno;
    }

    public void setMotherIdno(String motherIdno) {
        this.motherIdno = motherIdno;
    }

    public String getMotherName() {
        return this.motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherId() {
        return this.motherId;
    }

    public void setMotherId(String motherId) {
        this.motherId = motherId;
    }

    public String getFatherWorkUnit() {
        return this.fatherWorkUnit;
    }

    public void setFatherWorkUnit(String fatherWorkUnit) {
        this.fatherWorkUnit = fatherWorkUnit;
    }

    public Date getFatherBirthDate() {
        return this.fatherBirthDate;
    }

    public void setFatherBirthDate(Date fatherBirthDate) {
        this.fatherBirthDate = fatherBirthDate;
    }

    public String getFatherTelNo() {
        return this.fatherTelNo;
    }

    public void setFatherTelNo(String fatherTelNo) {
        this.fatherTelNo = fatherTelNo;
    }

    public String getFatherOccupCode() {
        return this.fatherOccupCode;
    }

    public void setFatherOccupCode(String fatherOccupCode) {
        this.fatherOccupCode = fatherOccupCode;
    }

    public String getFatherIdno() {
        return this.fatherIdno;
    }

    public void setFatherIdno(String fatherIdno) {
        this.fatherIdno = fatherIdno;
    }

    public String getFatherName() {
        return this.fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherId() {
        return this.fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public String getPresentAddrProvince() {
        return this.presentAddrProvince;
    }

    public void setPresentAddrProvince(String presentAddrProvince) {
        this.presentAddrProvince = presentAddrProvince;
    }

    public String getNewbornIdNo() {
        return this.newbornIdNo;
    }

    public void setNewbornIdNo(String newbornIdNo) {
        this.newbornIdNo = newbornIdNo;
    }

    public Date getNewbornBirthDate() {
        return this.newbornBirthDate;
    }

    public void setNewbornBirthDate(Date newbornBirthDate) {
        this.newbornBirthDate = newbornBirthDate;
    }

    public String getNewbornSexCode() {
        return this.newbornSexCode;
    }

    public void setNewbornSexCode(String newbornSexCode) {
        this.newbornSexCode = newbornSexCode;
    }

    public String getNewbornName() {
        return this.newbornName;
    }

    public void setNewbornName(String newbornName) {
        this.newbornName = newbornName;
    }

    public String getChildInfoSno() {
        return this.childInfoSno;
    }

    public void setChildInfoSno(String childInfoSno) {
        this.childInfoSno = childInfoSno;
    }

    public String getChildInfoNo() {
        return this.childInfoNo;
    }

    public void setChildInfoNo(String childInfoNo) {
        this.childInfoNo = childInfoNo;
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

    public String getChildInfoId() {
        return this.childInfoId;
    }

    public void setChildInfoId(String childInfoId) {
        this.childInfoId = childInfoId;
    }

    @Generated(hash = 90398760)
    public ChildInfo(String childInfoId, String personInfoId, String manageOrgId,
            String childInfoNo, String childInfoSno, String newbornName,
            String newbornSexCode, Date newbornBirthDate, String newbornIdNo,
            String presentAddrProvince, String fatherId, String fatherName,
            String fatherIdno, String fatherOccupCode, String fatherTelNo,
            Date fatherBirthDate, String fatherWorkUnit, String motherId,
            String motherName, String motherIdno, String motherOccupCode,
            String motherTelNo, Date motherBirthDate, String motherWorkUnit,
            String guardian, String guardianRelation, String guardianTelNo,
            String guardianWorkUnit, String guardianAddress,
            Integer birthGestWeeks, Integer birthGestDays, String motherHdcpCode,
            String motherHdcpOthersDesc, String deliveryOrgName,
            String lastDeliverWayCode, String twinsCode, String asphyxiaCode,
            String suffocationType, String apgarScoreCode, Integer apgarScore,
            String malformCode, String malformDesc, String hearingScreenCode,
            String hearingScreenResultCode, String diseaseScreenCode,
            String diseaseScreenOthersDesc, Double birthWeight, Double birthLength,
            Integer childrenBookIsBuild, Date childrenBookBuildDate,
            String respondent, Date investigateDate, String caseStatus,
            Date lastVisitDate, String lastVisitTypeCode, String lastVisitPerson,
            Date nextVisitDate, String nextVisitTypeCode, String nextVisitPerson,
            Integer isWeakChildren, Integer isCancel, String createOrgId,
            String orgName, String creatorId, String creator, Date createTime,
            String modifiedOrgId, String modifiedOrgName, String modifierId,
            String modifier, Date modifiedTime, String jsonDetail,
            Integer assessmentCount, Integer missingCount, Double intactRate,
            String closeCaseCode, String closeCaseReason) {
        this.childInfoId = childInfoId;
        this.personInfoId = personInfoId;
        this.manageOrgId = manageOrgId;
        this.childInfoNo = childInfoNo;
        this.childInfoSno = childInfoSno;
        this.newbornName = newbornName;
        this.newbornSexCode = newbornSexCode;
        this.newbornBirthDate = newbornBirthDate;
        this.newbornIdNo = newbornIdNo;
        this.presentAddrProvince = presentAddrProvince;
        this.fatherId = fatherId;
        this.fatherName = fatherName;
        this.fatherIdno = fatherIdno;
        this.fatherOccupCode = fatherOccupCode;
        this.fatherTelNo = fatherTelNo;
        this.fatherBirthDate = fatherBirthDate;
        this.fatherWorkUnit = fatherWorkUnit;
        this.motherId = motherId;
        this.motherName = motherName;
        this.motherIdno = motherIdno;
        this.motherOccupCode = motherOccupCode;
        this.motherTelNo = motherTelNo;
        this.motherBirthDate = motherBirthDate;
        this.motherWorkUnit = motherWorkUnit;
        this.guardian = guardian;
        this.guardianRelation = guardianRelation;
        this.guardianTelNo = guardianTelNo;
        this.guardianWorkUnit = guardianWorkUnit;
        this.guardianAddress = guardianAddress;
        this.birthGestWeeks = birthGestWeeks;
        this.birthGestDays = birthGestDays;
        this.motherHdcpCode = motherHdcpCode;
        this.motherHdcpOthersDesc = motherHdcpOthersDesc;
        this.deliveryOrgName = deliveryOrgName;
        this.lastDeliverWayCode = lastDeliverWayCode;
        this.twinsCode = twinsCode;
        this.asphyxiaCode = asphyxiaCode;
        this.suffocationType = suffocationType;
        this.apgarScoreCode = apgarScoreCode;
        this.apgarScore = apgarScore;
        this.malformCode = malformCode;
        this.malformDesc = malformDesc;
        this.hearingScreenCode = hearingScreenCode;
        this.hearingScreenResultCode = hearingScreenResultCode;
        this.diseaseScreenCode = diseaseScreenCode;
        this.diseaseScreenOthersDesc = diseaseScreenOthersDesc;
        this.birthWeight = birthWeight;
        this.birthLength = birthLength;
        this.childrenBookIsBuild = childrenBookIsBuild;
        this.childrenBookBuildDate = childrenBookBuildDate;
        this.respondent = respondent;
        this.investigateDate = investigateDate;
        this.caseStatus = caseStatus;
        this.lastVisitDate = lastVisitDate;
        this.lastVisitTypeCode = lastVisitTypeCode;
        this.lastVisitPerson = lastVisitPerson;
        this.nextVisitDate = nextVisitDate;
        this.nextVisitTypeCode = nextVisitTypeCode;
        this.nextVisitPerson = nextVisitPerson;
        this.isWeakChildren = isWeakChildren;
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
        this.closeCaseCode = closeCaseCode;
        this.closeCaseReason = closeCaseReason;
    }

    @Generated(hash = 554637612)
    @Keep
    public ChildInfo() {
        recordChoice = new ArrayList<>();
    }

    /**
     * 选项指标记录
     */

}