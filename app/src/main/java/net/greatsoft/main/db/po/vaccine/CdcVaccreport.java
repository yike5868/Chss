package net.greatsoft.main.db.po.vaccine;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 
 * @author AlphGo
 * @date 2016年8月15日 上午11:08:54 
 * @Description: 预防接种卡信息
 *
 */
@Entity
public class CdcVaccreport extends Entry{
    /**
     * 预防接种卡ID
     */
    private String cdcVaccreportId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;

    /**
     * 预防接种卡编号
     */
    
    private String cdcVaccreportNo;

    /**
     * 本人姓名
     */
    
    private String name;

    /**
     * 城乡居民健康档案编号
     */
    
    private String healthRecordNo;

    /**
     * 性别代码
     */
    
    private String sexCode;

    /**
     * 出生日期
     */
    
    private String birthDate;

    /**
     * 监护人姓名
     */
    private String guardianName;

    /**
     * 监护人与本人关系代码
     */
    
    private String guardianRelationCode;

    /**
     * 本人电话号码
     */
    
    private String telNo;

    /**
     * 家人电话号码
     */
    
    private String familyTelNo;

    /**
     * 工作单位-电话
     */
    
    private String employerTelNo;

    /**
     * 现住地址
     */
    private String presentAddr;

    /**
     * 户籍地址
     */
    private String registerAddrProvince;

    /**
     * 现住址与户籍地址是否一样
     */
    
    private String isSame;

    /**
     * 迁出日期
     */
    
    
    private Date moveOutDate;

    /**
     * 迁出原因
     */
    private String moveOutReason;

    /**
     * 迁入日期
     */
    
    
    private Date moveInDate;

    /**
     * 疫苗异常反应史
     */
    
    private String vaccineAbnormHistory;

    /**
     * 接种禁忌
     */
    
    private String vaccinateContraindication;

    /**
     * 传染病史
     */
    
    private String infectionHistory;

    /**
     * 建卡人姓名
     */
    
    private String cardIssuerName;

    /**
     * 建卡日期
     */
    
    
    private Date cardIssueDate;

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

    public Date getCardIssueDate() {
        return this.cardIssueDate;
    }

    public void setCardIssueDate(Date cardIssueDate) {
        this.cardIssueDate = cardIssueDate;
    }

    public String getCardIssuerName() {
        return this.cardIssuerName;
    }

    public void setCardIssuerName(String cardIssuerName) {
        this.cardIssuerName = cardIssuerName;
    }

    public String getInfectionHistory() {
        return this.infectionHistory;
    }

    public void setInfectionHistory(String infectionHistory) {
        this.infectionHistory = infectionHistory;
    }

    public String getVaccinateContraindication() {
        return this.vaccinateContraindication;
    }

    public void setVaccinateContraindication(String vaccinateContraindication) {
        this.vaccinateContraindication = vaccinateContraindication;
    }

    public String getVaccineAbnormHistory() {
        return this.vaccineAbnormHistory;
    }

    public void setVaccineAbnormHistory(String vaccineAbnormHistory) {
        this.vaccineAbnormHistory = vaccineAbnormHistory;
    }

    public Date getMoveInDate() {
        return this.moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public String getMoveOutReason() {
        return this.moveOutReason;
    }

    public void setMoveOutReason(String moveOutReason) {
        this.moveOutReason = moveOutReason;
    }

    public Date getMoveOutDate() {
        return this.moveOutDate;
    }

    public void setMoveOutDate(Date moveOutDate) {
        this.moveOutDate = moveOutDate;
    }

    public String getIsSame() {
        return this.isSame;
    }

    public void setIsSame(String isSame) {
        this.isSame = isSame;
    }

    public String getRegisterAddrProvince() {
        return this.registerAddrProvince;
    }

    public void setRegisterAddrProvince(String registerAddrProvince) {
        this.registerAddrProvince = registerAddrProvince;
    }

    public String getPresentAddr() {
        return this.presentAddr;
    }

    public void setPresentAddr(String presentAddr) {
        this.presentAddr = presentAddr;
    }

    public String getEmployerTelNo() {
        return this.employerTelNo;
    }

    public void setEmployerTelNo(String employerTelNo) {
        this.employerTelNo = employerTelNo;
    }

    public String getFamilyTelNo() {
        return this.familyTelNo;
    }

    public void setFamilyTelNo(String familyTelNo) {
        this.familyTelNo = familyTelNo;
    }

    public String getTelNo() {
        return this.telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
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

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSexCode() {
        return this.sexCode;
    }

    public void setSexCode(String sexCode) {
        this.sexCode = sexCode;
    }

    public String getHealthRecordNo() {
        return this.healthRecordNo;
    }

    public void setHealthRecordNo(String healthRecordNo) {
        this.healthRecordNo = healthRecordNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCdcVaccreportNo() {
        return this.cdcVaccreportNo;
    }

    public void setCdcVaccreportNo(String cdcVaccreportNo) {
        this.cdcVaccreportNo = cdcVaccreportNo;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getCdcVaccreportId() {
        return this.cdcVaccreportId;
    }

    public void setCdcVaccreportId(String cdcVaccreportId) {
        this.cdcVaccreportId = cdcVaccreportId;
    }

    @Generated(hash = 751310642)
    public CdcVaccreport(String cdcVaccreportId, String personInfoId,
            String cdcVaccreportNo, String name, String healthRecordNo,
            String sexCode, String birthDate, String guardianName,
            String guardianRelationCode, String telNo, String familyTelNo,
            String employerTelNo, String presentAddr, String registerAddrProvince,
            String isSame, Date moveOutDate, String moveOutReason, Date moveInDate,
            String vaccineAbnormHistory, String vaccinateContraindication,
            String infectionHistory, String cardIssuerName, Date cardIssueDate,
            Integer isCancel, String createOrgId, String orgName, String creatorId,
            String creator, Date createTime, String modifiedOrgId,
            String modifiedOrgName, String modifierId, String modifier,
            Date modifiedTime) {
        this.cdcVaccreportId = cdcVaccreportId;
        this.personInfoId = personInfoId;
        this.cdcVaccreportNo = cdcVaccreportNo;
        this.name = name;
        this.healthRecordNo = healthRecordNo;
        this.sexCode = sexCode;
        this.birthDate = birthDate;
        this.guardianName = guardianName;
        this.guardianRelationCode = guardianRelationCode;
        this.telNo = telNo;
        this.familyTelNo = familyTelNo;
        this.employerTelNo = employerTelNo;
        this.presentAddr = presentAddr;
        this.registerAddrProvince = registerAddrProvince;
        this.isSame = isSame;
        this.moveOutDate = moveOutDate;
        this.moveOutReason = moveOutReason;
        this.moveInDate = moveInDate;
        this.vaccineAbnormHistory = vaccineAbnormHistory;
        this.vaccinateContraindication = vaccinateContraindication;
        this.infectionHistory = infectionHistory;
        this.cardIssuerName = cardIssuerName;
        this.cardIssueDate = cardIssueDate;
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

    @Generated(hash = 871873690)
    public CdcVaccreport() {
    }

}