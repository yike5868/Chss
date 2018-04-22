package net.greatsoft.main.db.po.person;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author :hn
 * @createDate:2016年6月3日
 * @description:个人档案服务记录表
 */
@Entity
public class PersonServiceCatalog extends Entry{
    /**
     * 个人档案服务记录ID
     */
    private String personCatalogId;

    /**
     * 服务ID
     */
    private String serviceId;

    /**
     * 服务项目ID
     */
    private String serviceItemId;

    /**
     * 服务项目名称
     */
    private String serviceItemName;

    /**
     * 服务日期
     */
    private Date serviceDate;

    /**
     * 服务方式
     */
    private String serviceModeCode;

    /**
     * 下次预约日期
     */
    private Date nextServiceDate;

    /**
     * 下次预约地点
     */
    private String nextServiceAddress;

    /**
     * 是否删除
     */
    private Integer isCancel;

    /**
     * 建档机构ID
     */
    private String createOrgId;

    /**
     * 建档机构名称
     */
    private String orgName;

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
     * 个人档案ID
     */
    private String personInfoId;
    
    /**
     * 孕产登记ID
     */
    private String maternalRegisterId;

    public String getMaternalRegisterId() {
        return this.maternalRegisterId;
    }

    public void setMaternalRegisterId(String maternalRegisterId) {
        this.maternalRegisterId = maternalRegisterId;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
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

    public String getNextServiceAddress() {
        return this.nextServiceAddress;
    }

    public void setNextServiceAddress(String nextServiceAddress) {
        this.nextServiceAddress = nextServiceAddress;
    }

    public Date getNextServiceDate() {
        return this.nextServiceDate;
    }

    public void setNextServiceDate(Date nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public String getServiceModeCode() {
        return this.serviceModeCode;
    }

    public void setServiceModeCode(String serviceModeCode) {
        this.serviceModeCode = serviceModeCode;
    }

    public Date getServiceDate() {
        return this.serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceItemName() {
        return this.serviceItemName;
    }

    public void setServiceItemName(String serviceItemName) {
        this.serviceItemName = serviceItemName;
    }

    public String getServiceItemId() {
        return this.serviceItemId;
    }

    public void setServiceItemId(String serviceItemId) {
        this.serviceItemId = serviceItemId;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getPersonCatalogId() {
        return this.personCatalogId;
    }

    public void setPersonCatalogId(String personCatalogId) {
        this.personCatalogId = personCatalogId;
    }

    @Generated(hash = 698790136)
    public PersonServiceCatalog(String personCatalogId, String serviceId,
            String serviceItemId, String serviceItemName, Date serviceDate,
            String serviceModeCode, Date nextServiceDate,
            String nextServiceAddress, Integer isCancel, String createOrgId,
            String orgName, String creatorId, String creator, Date createTime,
            String modifiedOrgId, String modifiedOrgName, String modifierId,
            String modifier, Date modifiedTime, String personInfoId,
            String maternalRegisterId) {
        this.personCatalogId = personCatalogId;
        this.serviceId = serviceId;
        this.serviceItemId = serviceItemId;
        this.serviceItemName = serviceItemName;
        this.serviceDate = serviceDate;
        this.serviceModeCode = serviceModeCode;
        this.nextServiceDate = nextServiceDate;
        this.nextServiceAddress = nextServiceAddress;
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
        this.personInfoId = personInfoId;
        this.maternalRegisterId = maternalRegisterId;
    }

    @Generated(hash = 650490476)
    public PersonServiceCatalog() {
    }

}