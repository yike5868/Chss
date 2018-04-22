package net.greatsoft.main.db.po.tuberculosis;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 
 * @author AlphGo
 * @date 2016年7月30日 上午10:10:10 
 * @Description: 结核病转诊单
 *
 */
@Entity
public class TuberculosisReferral extends Entry{
    
    /**
     * 结核病转诊单ID
     */
    private String tuberculosisReferralId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;

    /**
     * 档案编号
     */
    private String personInfoNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sexValue;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 转入时间
     */
    
    private Date transferIntoDate;

    /**
     * 转入医院
     */
    
    private String transferIntoOrg;

    /**
     * 转入科室
     */
    
    private String transferIntoDept;

    /**
     * 接诊医生
     */
    
    private String transferIntoDoctor;

    /**
     * 转诊医生（签字）ID
     */
    
    private String doctorSignId;

    /**
     * 转诊医生（签字）名称
     */
    private String doctorSignName;

    /**
     * 转诊医生签字日期
     */
    
    private Date doctorSignDate;

    /**
     * 初步印象
     */
    
    private String fringeeffect;

    /**
     * 主要现病史（转出原因）
     */
    
    private String transferOutReason;

    /**
     * 主要既往史
     */
    
    private String diseaseHistory;

    /**
     * 治疗经过
     */
    
    private String treatment;

    /**
     * 转出机构名称
     */
    
    private String transferOutOrg;

    /**
     * 联系电话
     */
    private String telephone;

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

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTransferOutOrg() {
        return this.transferOutOrg;
    }

    public void setTransferOutOrg(String transferOutOrg) {
        this.transferOutOrg = transferOutOrg;
    }

    public String getTreatment() {
        return this.treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDiseaseHistory() {
        return this.diseaseHistory;
    }

    public void setDiseaseHistory(String diseaseHistory) {
        this.diseaseHistory = diseaseHistory;
    }

    public String getTransferOutReason() {
        return this.transferOutReason;
    }

    public void setTransferOutReason(String transferOutReason) {
        this.transferOutReason = transferOutReason;
    }

    public String getFringeeffect() {
        return this.fringeeffect;
    }

    public void setFringeeffect(String fringeeffect) {
        this.fringeeffect = fringeeffect;
    }

    public Date getDoctorSignDate() {
        return this.doctorSignDate;
    }

    public void setDoctorSignDate(Date doctorSignDate) {
        this.doctorSignDate = doctorSignDate;
    }

    public String getDoctorSignName() {
        return this.doctorSignName;
    }

    public void setDoctorSignName(String doctorSignName) {
        this.doctorSignName = doctorSignName;
    }

    public String getDoctorSignId() {
        return this.doctorSignId;
    }

    public void setDoctorSignId(String doctorSignId) {
        this.doctorSignId = doctorSignId;
    }

    public String getTransferIntoDoctor() {
        return this.transferIntoDoctor;
    }

    public void setTransferIntoDoctor(String transferIntoDoctor) {
        this.transferIntoDoctor = transferIntoDoctor;
    }

    public String getTransferIntoDept() {
        return this.transferIntoDept;
    }

    public void setTransferIntoDept(String transferIntoDept) {
        this.transferIntoDept = transferIntoDept;
    }

    public String getTransferIntoOrg() {
        return this.transferIntoOrg;
    }

    public void setTransferIntoOrg(String transferIntoOrg) {
        this.transferIntoOrg = transferIntoOrg;
    }

    public Date getTransferIntoDate() {
        return this.transferIntoDate;
    }

    public void setTransferIntoDate(Date transferIntoDate) {
        this.transferIntoDate = transferIntoDate;
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

    public String getSexValue() {
        return this.sexValue;
    }

    public void setSexValue(String sexValue) {
        this.sexValue = sexValue;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonInfoNo() {
        return this.personInfoNo;
    }

    public void setPersonInfoNo(String personInfoNo) {
        this.personInfoNo = personInfoNo;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getTuberculosisReferralId() {
        return this.tuberculosisReferralId;
    }

    public void setTuberculosisReferralId(String tuberculosisReferralId) {
        this.tuberculosisReferralId = tuberculosisReferralId;
    }

    @Generated(hash = 1511137850)
    public TuberculosisReferral(String tuberculosisReferralId, String personInfoId,
            String personInfoNo, String name, String sexValue, Integer age,
            String address, String phone, Date transferIntoDate,
            String transferIntoOrg, String transferIntoDept,
            String transferIntoDoctor, String doctorSignId, String doctorSignName,
            Date doctorSignDate, String fringeeffect, String transferOutReason,
            String diseaseHistory, String treatment, String transferOutOrg,
            String telephone, Integer isCancel, String createOrgId, String orgName,
            String creatorId, String creator, Date createTime,
            String modifiedOrgId, String modifiedOrgName, String modifierId,
            String modifier, Date modifiedTime) {
        this.tuberculosisReferralId = tuberculosisReferralId;
        this.personInfoId = personInfoId;
        this.personInfoNo = personInfoNo;
        this.name = name;
        this.sexValue = sexValue;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.transferIntoDate = transferIntoDate;
        this.transferIntoOrg = transferIntoOrg;
        this.transferIntoDept = transferIntoDept;
        this.transferIntoDoctor = transferIntoDoctor;
        this.doctorSignId = doctorSignId;
        this.doctorSignName = doctorSignName;
        this.doctorSignDate = doctorSignDate;
        this.fringeeffect = fringeeffect;
        this.transferOutReason = transferOutReason;
        this.diseaseHistory = diseaseHistory;
        this.treatment = treatment;
        this.transferOutOrg = transferOutOrg;
        this.telephone = telephone;
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

    @Generated(hash = 1928903105)
    public TuberculosisReferral() {
    }


}