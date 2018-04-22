package net.greatsoft.main.db.po.vaccine;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 
 * @author AlphGo
 * @date 2016年8月16日 上午11:26:31 
 * @Description: 针次管理
 *
 */
@Entity
public class VaccineInjectTimes extends Entry{
    /**
     * 疫苗针次流水号
     */
    
    private String vaccineInjectTimesId;

    /**
     * 疫苗ID
     */
    
    private String vaccineId;

    /**
     * 针次
     */
    private Integer vaccineInjectTimes;

    /**
     * 针次描述
     */
    
    private String injectTimesRemark;

    /**
     * 接种月龄
     */
    private Integer monthsAge;

    /**
     * 月龄描述
     */
    
    private String monthsAgeRemark;

    /**
     * 接种天数
     */
    private Integer injectday;

    /**
     * 免疫类型
     */

    private String vaccineType;

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

    public String getVaccineType() {
        return this.vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public Integer getInjectday() {
        return this.injectday;
    }

    public void setInjectday(Integer injectday) {
        this.injectday = injectday;
    }

    public String getMonthsAgeRemark() {
        return this.monthsAgeRemark;
    }

    public void setMonthsAgeRemark(String monthsAgeRemark) {
        this.monthsAgeRemark = monthsAgeRemark;
    }

    public Integer getMonthsAge() {
        return this.monthsAge;
    }

    public void setMonthsAge(Integer monthsAge) {
        this.monthsAge = monthsAge;
    }

    public String getInjectTimesRemark() {
        return this.injectTimesRemark;
    }

    public void setInjectTimesRemark(String injectTimesRemark) {
        this.injectTimesRemark = injectTimesRemark;
    }

    public Integer getVaccineInjectTimes() {
        return this.vaccineInjectTimes;
    }

    public void setVaccineInjectTimes(Integer vaccineInjectTimes) {
        this.vaccineInjectTimes = vaccineInjectTimes;
    }

    public String getVaccineId() {
        return this.vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineInjectTimesId() {
        return this.vaccineInjectTimesId;
    }

    public void setVaccineInjectTimesId(String vaccineInjectTimesId) {
        this.vaccineInjectTimesId = vaccineInjectTimesId;
    }

    @Generated(hash = 1267239707)
    public VaccineInjectTimes(String vaccineInjectTimesId, String vaccineId,
            Integer vaccineInjectTimes, String injectTimesRemark,
            Integer monthsAge, String monthsAgeRemark, Integer injectday,
            String vaccineType, String remark, Integer isCancel,
            String createOrgId, String orgName, String creatorId, String creator,
            Date createTime, String modifiedOrgId, String modifiedOrgName,
            String modifierId, String modifier, Date modifiedTime) {
        this.vaccineInjectTimesId = vaccineInjectTimesId;
        this.vaccineId = vaccineId;
        this.vaccineInjectTimes = vaccineInjectTimes;
        this.injectTimesRemark = injectTimesRemark;
        this.monthsAge = monthsAge;
        this.monthsAgeRemark = monthsAgeRemark;
        this.injectday = injectday;
        this.vaccineType = vaccineType;
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

    @Generated(hash = 381392111)
    public VaccineInjectTimes() {
    }


}