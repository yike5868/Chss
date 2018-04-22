package net.greatsoft.main.db.po.vaccine;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;



/**
 * 
 * @author AlphGo
 * @date 2016年8月15日 上午11:09:59 
 * @Description: 预防接种卡信息_接种记录
 *
 */
@Entity
public class CdcVaccreportVaccinate extends Entry{
    /**
     * 预防接种卡信息_接种记录ID
     */
    private String cdcVaccreportVaccinateId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;
    
    /**
     * 预防接种卡ID
     */
    
    private String cdcVaccreportId;

    /**
     * 预防接种卡信息_接种记录编号
     */
    
    private String cdcVaccreportVaccinateNo;

    /**
     * 疫苗名称ID
     */
    
    private String vaccineId;
    
    /**
     * 疫苗名称
     */
    
    private String vaccineName;
    
    /**
     * 疫苗应接种日期
     */
    
    
    private Date vaccinatePlanDate;

    /**
     * 疫苗接种日期
     */
    
    
    private Date vaccinateDate;

    /**
     * 接种部位代码
     */
    private String vaccinateSiteCode;

    /**
     * 接种部位名称
     */
    
    private String vaccinateSiteValue;

    /**
     * 疫苗批号
     */
    
    private String vaccineBatchNo;
    
    /**
     * 接种针次ID
     */
    
    private String injectTimesId;

    /**
     * 接种剂次
     */
    private Integer vaccinateDoses;

    /**
     * 接种计量
     */
    private String measure;
    
    /**
     * 生产企业
     */
    
    private String manufacturerId;
    
    /**
     * 疫苗接种医生ID
     */
    
    private String vaccinateDoctorId;

    /**
     * 疫苗接种医生姓名
     */
    private String vaccinateDoctorName;

    /**
     * 疫苗接种单位名称
     */
    private String vaccinateOrgName;

    /**
     * 备注
     */
    
    private String remark;

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

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVaccinateOrgName() {
        return this.vaccinateOrgName;
    }

    public void setVaccinateOrgName(String vaccinateOrgName) {
        this.vaccinateOrgName = vaccinateOrgName;
    }

    public String getVaccinateDoctorName() {
        return this.vaccinateDoctorName;
    }

    public void setVaccinateDoctorName(String vaccinateDoctorName) {
        this.vaccinateDoctorName = vaccinateDoctorName;
    }

    public String getVaccinateDoctorId() {
        return this.vaccinateDoctorId;
    }

    public void setVaccinateDoctorId(String vaccinateDoctorId) {
        this.vaccinateDoctorId = vaccinateDoctorId;
    }

    public String getManufacturerId() {
        return this.manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getMeasure() {
        return this.measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Integer getVaccinateDoses() {
        return this.vaccinateDoses;
    }

    public void setVaccinateDoses(Integer vaccinateDoses) {
        this.vaccinateDoses = vaccinateDoses;
    }

    public String getInjectTimesId() {
        return this.injectTimesId;
    }

    public void setInjectTimesId(String injectTimesId) {
        this.injectTimesId = injectTimesId;
    }

    public String getVaccineBatchNo() {
        return this.vaccineBatchNo;
    }

    public void setVaccineBatchNo(String vaccineBatchNo) {
        this.vaccineBatchNo = vaccineBatchNo;
    }

    public String getVaccinateSiteValue() {
        return this.vaccinateSiteValue;
    }

    public void setVaccinateSiteValue(String vaccinateSiteValue) {
        this.vaccinateSiteValue = vaccinateSiteValue;
    }

    public String getVaccinateSiteCode() {
        return this.vaccinateSiteCode;
    }

    public void setVaccinateSiteCode(String vaccinateSiteCode) {
        this.vaccinateSiteCode = vaccinateSiteCode;
    }

    public Date getVaccinateDate() {
        return this.vaccinateDate;
    }

    public void setVaccinateDate(Date vaccinateDate) {
        this.vaccinateDate = vaccinateDate;
    }

    public Date getVaccinatePlanDate() {
        return this.vaccinatePlanDate;
    }

    public void setVaccinatePlanDate(Date vaccinatePlanDate) {
        this.vaccinatePlanDate = vaccinatePlanDate;
    }

    public String getVaccineName() {
        return this.vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineId() {
        return this.vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getCdcVaccreportVaccinateNo() {
        return this.cdcVaccreportVaccinateNo;
    }

    public void setCdcVaccreportVaccinateNo(String cdcVaccreportVaccinateNo) {
        this.cdcVaccreportVaccinateNo = cdcVaccreportVaccinateNo;
    }

    public String getCdcVaccreportId() {
        return this.cdcVaccreportId;
    }

    public void setCdcVaccreportId(String cdcVaccreportId) {
        this.cdcVaccreportId = cdcVaccreportId;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getCdcVaccreportVaccinateId() {
        return this.cdcVaccreportVaccinateId;
    }

    public void setCdcVaccreportVaccinateId(String cdcVaccreportVaccinateId) {
        this.cdcVaccreportVaccinateId = cdcVaccreportVaccinateId;
    }

    @Generated(hash = 642713407)
    public CdcVaccreportVaccinate(String cdcVaccreportVaccinateId,
            String personInfoId, String cdcVaccreportId,
            String cdcVaccreportVaccinateNo, String vaccineId, String vaccineName,
            Date vaccinatePlanDate, Date vaccinateDate, String vaccinateSiteCode,
            String vaccinateSiteValue, String vaccineBatchNo, String injectTimesId,
            Integer vaccinateDoses, String measure, String manufacturerId,
            String vaccinateDoctorId, String vaccinateDoctorName,
            String vaccinateOrgName, String remark, Integer isCancel,
            String createOrgId, String orgName, String creatorId, String creator,
            Date createTime, String modifiedOrgId, String modifiedOrgName,
            String modifierId, String modifier, Date modifiedTime) {
        this.cdcVaccreportVaccinateId = cdcVaccreportVaccinateId;
        this.personInfoId = personInfoId;
        this.cdcVaccreportId = cdcVaccreportId;
        this.cdcVaccreportVaccinateNo = cdcVaccreportVaccinateNo;
        this.vaccineId = vaccineId;
        this.vaccineName = vaccineName;
        this.vaccinatePlanDate = vaccinatePlanDate;
        this.vaccinateDate = vaccinateDate;
        this.vaccinateSiteCode = vaccinateSiteCode;
        this.vaccinateSiteValue = vaccinateSiteValue;
        this.vaccineBatchNo = vaccineBatchNo;
        this.injectTimesId = injectTimesId;
        this.vaccinateDoses = vaccinateDoses;
        this.measure = measure;
        this.manufacturerId = manufacturerId;
        this.vaccinateDoctorId = vaccinateDoctorId;
        this.vaccinateDoctorName = vaccinateDoctorName;
        this.vaccinateOrgName = vaccinateOrgName;
        this.remark = remark;
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

    @Generated(hash = 518159882)
    public CdcVaccreportVaccinate() {
    }

}