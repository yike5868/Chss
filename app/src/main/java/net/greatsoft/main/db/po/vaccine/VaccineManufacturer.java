package net.greatsoft.main.db.po.vaccine;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年8月16日 上午11:27:09 
 * @Description: 疫苗厂商管理
 *
 */
@Entity
public class VaccineManufacturer extends Entry{
    /**
     * 疫苗厂商流水号
     */
    
    private String vaccineManufacturerId;

    /**
     * 疫苗ID
     */
    
    private String vaccineId;

    /**
     * 名称
     */
    
    private String name;

    /**
     * 地址
     */
    
    private String adrress;

    /**
     * 联系人
     */
    
    private String linkman;

    /**
     * 联系电话
     */
    
    private String phone;

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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinkman() {
        return this.linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getAdrress() {
        return this.adrress;
    }

    public void setAdrress(String adrress) {
        this.adrress = adrress;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVaccineId() {
        return this.vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineManufacturerId() {
        return this.vaccineManufacturerId;
    }

    public void setVaccineManufacturerId(String vaccineManufacturerId) {
        this.vaccineManufacturerId = vaccineManufacturerId;
    }

    @Generated(hash = 297656415)
    public VaccineManufacturer(String vaccineManufacturerId, String vaccineId,
            String name, String adrress, String linkman, String phone,
            Integer isValid, String remark, Integer isCancel, String createOrgId,
            String orgName, String creatorId, String creator, Date createTime,
            String modifiedOrgId, String modifiedOrgName, String modifierId,
            String modifier, Date modifiedTime) {
        this.vaccineManufacturerId = vaccineManufacturerId;
        this.vaccineId = vaccineId;
        this.name = name;
        this.adrress = adrress;
        this.linkman = linkman;
        this.phone = phone;
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

    @Generated(hash = 1981700382)
    public VaccineManufacturer() {
    }


}