package net.greatsoft.main.db.po.child;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年7月19日 下午12:04:04 
 * @Description: 新生儿听力筛查
 *
 */
@Entity
public class ChildHearScreen extends Entry{
    /**
     * 新生儿听力筛查ID
     */
    
    private String childHearScreenId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;

    /**
     * 新生儿疾病筛查编号
     */
    
    private String childHearScreenNo;

    /**
     * 新生儿姓名
     */
    private String name;

    /**
     * 性别代码
     */
    private String sexCode;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 联系电话
     */
    private String telNo;

    /**
     * 户籍地址
     */
    
    private String householdAddress;

    /**
     * 现住地址
     */
    
    private String presentAddress;

    /**
     * 筛查方法代码
     */
    
    private String screenMethodCode;

    /**
     * 筛查地点
     */
    
    private String screenAddressCode;

    /**
     * 筛查时间
     */
    private Date screenDate;

    /**
     * 筛查医生
     */
    private String screenDoctor;

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

    public String getScreenDoctor() {
        return this.screenDoctor;
    }

    public void setScreenDoctor(String screenDoctor) {
        this.screenDoctor = screenDoctor;
    }

    public Date getScreenDate() {
        return this.screenDate;
    }

    public void setScreenDate(Date screenDate) {
        this.screenDate = screenDate;
    }

    public String getScreenAddressCode() {
        return this.screenAddressCode;
    }

    public void setScreenAddressCode(String screenAddressCode) {
        this.screenAddressCode = screenAddressCode;
    }

    public String getScreenMethodCode() {
        return this.screenMethodCode;
    }

    public void setScreenMethodCode(String screenMethodCode) {
        this.screenMethodCode = screenMethodCode;
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

    public String getTelNo() {
        return this.telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
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

    public String getChildHearScreenNo() {
        return this.childHearScreenNo;
    }

    public void setChildHearScreenNo(String childHearScreenNo) {
        this.childHearScreenNo = childHearScreenNo;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getChildHearScreenId() {
        return this.childHearScreenId;
    }

    public void setChildHearScreenId(String childHearScreenId) {
        this.childHearScreenId = childHearScreenId;
    }

    @Generated(hash = 286970949)
    public ChildHearScreen(String childHearScreenId, String personInfoId,
            String childHearScreenNo, String name, String sexCode, Date birthDate,
            String telNo, String householdAddress, String presentAddress,
            String screenMethodCode, String screenAddressCode, Date screenDate,
            String screenDoctor, Integer isCancel, String createOrgId,
            String orgName, String creatorId, String creator, Date createTime,
            String modifiedOrgId, String modifiedOrgName, String modifierId,
            String modifier, Date modifiedTime) {
        this.childHearScreenId = childHearScreenId;
        this.personInfoId = personInfoId;
        this.childHearScreenNo = childHearScreenNo;
        this.name = name;
        this.sexCode = sexCode;
        this.birthDate = birthDate;
        this.telNo = telNo;
        this.householdAddress = householdAddress;
        this.presentAddress = presentAddress;
        this.screenMethodCode = screenMethodCode;
        this.screenAddressCode = screenAddressCode;
        this.screenDate = screenDate;
        this.screenDoctor = screenDoctor;
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

    @Generated(hash = 2025341261)
    public ChildHearScreen() {
    }



}