package net.greatsoft.main.db.po.tuberculosis;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author hn
 * @date 2016年7月6日 下午5:55:16
 * @Description: 肺结核基本情况
 *
 */
@Entity
public class TuberculosisInfo extends Entry{
	/**
	 * 肺结核档案ID
	 */
    
    private String tuberculosisInfoId;

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
    
    private String tuberculosisInfoNo;

    /**
     * 姓名
     */
    
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 家庭住址
     */
    
    private String address;

    /**
     * 联系方式
     */
    
    private String phone;

    /**
     * 患者家属姓名
     */
    
    private String familyname;

    /**
     * 与患者关系
     */
    
    private String familyrelation;

    /**
     * 患者家属联系电话
     */
    
    private String famliyphone;

    /**
     * 结核病定点医疗机构名称
     */
    
    private String commitOrg;

    /**
     * 结核病定点医疗机构医生
     */
    
    private String commitDoctor;

    /**
     * 结核病确诊日期
     */
    
    
    private Date commitDate;

    /**
     * 是否第一次随访
     */
    
    private String hasFirstVisit;

    /**
     * 出现停止治疗时间
     */
    
    
    private Date stopTreatmentDate;

    /**
     * 停止治疗原因
     */
    private String stopTreatmentReasonCode;

    /**
     * 应访视患者次数
     */
    private Integer shouldFollowupTimes;

    /**
     * 实际访视患者次数
     */
    private Integer actualFollowupTimes;

    /**
     * 应服药次数
     */
    private Integer shouldDrugTimes;

    /**
     * 实际服药次数
     */
    private Integer actualDrugTimes;

    /**
     * 服药率%
     */
    private Integer drugRatio;

    /**
     * 评估医生ID
     */
    
    private String assessDoctorId;

    /**
     * 评估医生姓名
     */
    
    private String assessDoctorName;

    /**
     * 开始管理时间
     */
    
    
    private Date beginManageDate;

    /**
     * 专项档案状态
     */
    private String caseStatus;

    /**
     * 最近随访日期
     */
    
    
    private Date lastVisitDate;

    /**
     * 下次预约日期
     */
    
    
    private Date nextVisitDate;

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
	 * 是否是程序自动创建的管理卡，1是，其他值否
	 */
	private String isAutoBuild;

    public String getIsAutoBuild() {
        return this.isAutoBuild;
    }

    public void setIsAutoBuild(String isAutoBuild) {
        this.isAutoBuild = isAutoBuild;
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

    public Date getNextVisitDate() {
        return this.nextVisitDate;
    }

    public void setNextVisitDate(Date nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
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

    public Date getBeginManageDate() {
        return this.beginManageDate;
    }

    public void setBeginManageDate(Date beginManageDate) {
        this.beginManageDate = beginManageDate;
    }

    public String getAssessDoctorName() {
        return this.assessDoctorName;
    }

    public void setAssessDoctorName(String assessDoctorName) {
        this.assessDoctorName = assessDoctorName;
    }

    public String getAssessDoctorId() {
        return this.assessDoctorId;
    }

    public void setAssessDoctorId(String assessDoctorId) {
        this.assessDoctorId = assessDoctorId;
    }

    public Integer getDrugRatio() {
        return this.drugRatio;
    }

    public void setDrugRatio(Integer drugRatio) {
        this.drugRatio = drugRatio;
    }

    public Integer getActualDrugTimes() {
        return this.actualDrugTimes;
    }

    public void setActualDrugTimes(Integer actualDrugTimes) {
        this.actualDrugTimes = actualDrugTimes;
    }

    public Integer getShouldDrugTimes() {
        return this.shouldDrugTimes;
    }

    public void setShouldDrugTimes(Integer shouldDrugTimes) {
        this.shouldDrugTimes = shouldDrugTimes;
    }

    public Integer getActualFollowupTimes() {
        return this.actualFollowupTimes;
    }

    public void setActualFollowupTimes(Integer actualFollowupTimes) {
        this.actualFollowupTimes = actualFollowupTimes;
    }

    public Integer getShouldFollowupTimes() {
        return this.shouldFollowupTimes;
    }

    public void setShouldFollowupTimes(Integer shouldFollowupTimes) {
        this.shouldFollowupTimes = shouldFollowupTimes;
    }

    public String getStopTreatmentReasonCode() {
        return this.stopTreatmentReasonCode;
    }

    public void setStopTreatmentReasonCode(String stopTreatmentReasonCode) {
        this.stopTreatmentReasonCode = stopTreatmentReasonCode;
    }

    public Date getStopTreatmentDate() {
        return this.stopTreatmentDate;
    }

    public void setStopTreatmentDate(Date stopTreatmentDate) {
        this.stopTreatmentDate = stopTreatmentDate;
    }

    public String getHasFirstVisit() {
        return this.hasFirstVisit;
    }

    public void setHasFirstVisit(String hasFirstVisit) {
        this.hasFirstVisit = hasFirstVisit;
    }

    public Date getCommitDate() {
        return this.commitDate;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
    }

    public String getCommitDoctor() {
        return this.commitDoctor;
    }

    public void setCommitDoctor(String commitDoctor) {
        this.commitDoctor = commitDoctor;
    }

    public String getCommitOrg() {
        return this.commitOrg;
    }

    public void setCommitOrg(String commitOrg) {
        this.commitOrg = commitOrg;
    }

    public String getFamliyphone() {
        return this.famliyphone;
    }

    public void setFamliyphone(String famliyphone) {
        this.famliyphone = famliyphone;
    }

    public String getFamilyrelation() {
        return this.familyrelation;
    }

    public void setFamilyrelation(String familyrelation) {
        this.familyrelation = familyrelation;
    }

    public String getFamilyname() {
        return this.familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTuberculosisInfoNo() {
        return this.tuberculosisInfoNo;
    }

    public void setTuberculosisInfoNo(String tuberculosisInfoNo) {
        this.tuberculosisInfoNo = tuberculosisInfoNo;
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

    public String getTuberculosisInfoId() {
        return this.tuberculosisInfoId;
    }

    public void setTuberculosisInfoId(String tuberculosisInfoId) {
        this.tuberculosisInfoId = tuberculosisInfoId;
    }

    @Generated(hash = 1639417777)
    public TuberculosisInfo(String tuberculosisInfoId, String personInfoId,
            String manageOrgId, String tuberculosisInfoNo, String name,
            Integer age, String address, String phone, String familyname,
            String familyrelation, String famliyphone, String commitOrg,
            String commitDoctor, Date commitDate, String hasFirstVisit,
            Date stopTreatmentDate, String stopTreatmentReasonCode,
            Integer shouldFollowupTimes, Integer actualFollowupTimes,
            Integer shouldDrugTimes, Integer actualDrugTimes, Integer drugRatio,
            String assessDoctorId, String assessDoctorName, Date beginManageDate,
            String caseStatus, Date lastVisitDate, Date nextVisitDate,
            Integer isCancel, String createOrgId, String orgName, String creatorId,
            String creator, Date createTime, String modifiedOrgId,
            String modifiedOrgName, String modifierId, String modifier,
            Date modifiedTime, String isAutoBuild) {
        this.tuberculosisInfoId = tuberculosisInfoId;
        this.personInfoId = personInfoId;
        this.manageOrgId = manageOrgId;
        this.tuberculosisInfoNo = tuberculosisInfoNo;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.familyname = familyname;
        this.familyrelation = familyrelation;
        this.famliyphone = famliyphone;
        this.commitOrg = commitOrg;
        this.commitDoctor = commitDoctor;
        this.commitDate = commitDate;
        this.hasFirstVisit = hasFirstVisit;
        this.stopTreatmentDate = stopTreatmentDate;
        this.stopTreatmentReasonCode = stopTreatmentReasonCode;
        this.shouldFollowupTimes = shouldFollowupTimes;
        this.actualFollowupTimes = actualFollowupTimes;
        this.shouldDrugTimes = shouldDrugTimes;
        this.actualDrugTimes = actualDrugTimes;
        this.drugRatio = drugRatio;
        this.assessDoctorId = assessDoctorId;
        this.assessDoctorName = assessDoctorName;
        this.beginManageDate = beginManageDate;
        this.caseStatus = caseStatus;
        this.lastVisitDate = lastVisitDate;
        this.nextVisitDate = nextVisitDate;
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
        this.isAutoBuild = isAutoBuild;
    }

    @Generated(hash = 1407399451)
    public TuberculosisInfo() {
    }
	

}
