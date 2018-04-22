package net.greatsoft.main.db.po.vaccine;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年8月16日 上午11:24:28 
 * @Description: 疫苗管理
 *
 */
@Entity
public class Vaccine extends Entry{
    /**
     * 疫苗流水号
     */
    
    private String vaccineId;

    /**
     * 编码
     */
    
    private String vaccineCode;

    /**
     * 名称
     */
    
    private String name;

    /**
     * 计量单位
     */
    
    private String unit;
    
    /**
     * 接种剂量
     */
    
    private String vaccreportMeasure;

    /**
     * 接种部位
     */
    private String part;
    
    /**
     * 接种部位中文
     */
    private String partCN;

    /**
     * 接种途径
     */
    private String approach;

    /**
     * 可预防疾病
     */
    private String preventDisease;

    /**
     * 有效预警天数
     */
    private Integer remindDays;

    /**
     * 一支（瓶）可以接种的人数
     */
    private Integer vaccinePeople;

    /**
     * 是否属于计划内
     */
    private Integer isPlan;

    /**
     * 是否启用
     */
    private Integer isValid;

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

    public Integer getIsValid() {
        return this.isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Integer getIsPlan() {
        return this.isPlan;
    }

    public void setIsPlan(Integer isPlan) {
        this.isPlan = isPlan;
    }

    public Integer getVaccinePeople() {
        return this.vaccinePeople;
    }

    public void setVaccinePeople(Integer vaccinePeople) {
        this.vaccinePeople = vaccinePeople;
    }

    public Integer getRemindDays() {
        return this.remindDays;
    }

    public void setRemindDays(Integer remindDays) {
        this.remindDays = remindDays;
    }

    public String getPreventDisease() {
        return this.preventDisease;
    }

    public void setPreventDisease(String preventDisease) {
        this.preventDisease = preventDisease;
    }

    public String getApproach() {
        return this.approach;
    }

    public void setApproach(String approach) {
        this.approach = approach;
    }

    public String getPartCN() {
        return this.partCN;
    }

    public void setPartCN(String partCN) {
        this.partCN = partCN;
    }

    public String getPart() {
        return this.part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getVaccreportMeasure() {
        return this.vaccreportMeasure;
    }

    public void setVaccreportMeasure(String vaccreportMeasure) {
        this.vaccreportMeasure = vaccreportMeasure;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVaccineCode() {
        return this.vaccineCode;
    }

    public void setVaccineCode(String vaccineCode) {
        this.vaccineCode = vaccineCode;
    }

    public String getVaccineId() {
        return this.vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    @Generated(hash = 899363968)
    public Vaccine(String vaccineId, String vaccineCode, String name, String unit,
            String vaccreportMeasure, String part, String partCN, String approach,
            String preventDisease, Integer remindDays, Integer vaccinePeople,
            Integer isPlan, Integer isValid, String remark, Integer isCancel,
            String createOrgId, String orgName, String creatorId, String creator,
            Date createTime, String modifiedOrgId, String modifiedOrgName,
            String modifierId, String modifier, Date modifiedTime) {
        this.vaccineId = vaccineId;
        this.vaccineCode = vaccineCode;
        this.name = name;
        this.unit = unit;
        this.vaccreportMeasure = vaccreportMeasure;
        this.part = part;
        this.partCN = partCN;
        this.approach = approach;
        this.preventDisease = preventDisease;
        this.remindDays = remindDays;
        this.vaccinePeople = vaccinePeople;
        this.isPlan = isPlan;
        this.isValid = isValid;
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

    @Generated(hash = 2125395277)
    public Vaccine() {
    }

}