package net.greatsoft.main.db.po.old;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 
 * @author hn
 * @date 2016年7月25日 下午10:50:44 
 * @Description: 老年人专档
 *
 */
@Entity
public class ElderInfo  extends Entry {
    /**
     * 老年人专档ID
     */
    
    private String elderInfoId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;

    /**
     * 管理机构ID
     */
    
    private String manageOrgId;

    /**
     * 本人姓名
     */
    
    private String name;

    /**
     * 赡养方式
     */
    
    private String maintenanceModeCode;

    /**
     * 监护人姓名
     */
    
    private String guardianName;

    /**
     * 监护人与本人关系代码
     */
    
    private String guardianRelationCode;

    /**
     * 监护人地址
     */
    
    private String guardianAddr;

    /**
     * 监护人电话号码
     */
    
    private String guardianTelNo;

    /**
     * 监护人手机号码
     */
    
    private String guardianMobile;

    /**
     * 被调查者
     */
    
    private String informant;

    /**
     * 签名日期
     */
    
    
    private Date informantDate;

    /**
     * 调查者
     */
    
    private String investigator;

    /**
     * 调查日期
     */
    
    
    private Date investigatorDate;

    /**
     * 纳入老年人管理日期
     */
    
    
    private Date manageDate;

    /**
     * 备注
     */
    private String remarks;

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

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getManageDate() {
        return this.manageDate;
    }

    public void setManageDate(Date manageDate) {
        this.manageDate = manageDate;
    }

    public Date getInvestigatorDate() {
        return this.investigatorDate;
    }

    public void setInvestigatorDate(Date investigatorDate) {
        this.investigatorDate = investigatorDate;
    }

    public String getInvestigator() {
        return this.investigator;
    }

    public void setInvestigator(String investigator) {
        this.investigator = investigator;
    }

    public Date getInformantDate() {
        return this.informantDate;
    }

    public void setInformantDate(Date informantDate) {
        this.informantDate = informantDate;
    }

    public String getInformant() {
        return this.informant;
    }

    public void setInformant(String informant) {
        this.informant = informant;
    }

    public String getGuardianMobile() {
        return this.guardianMobile;
    }

    public void setGuardianMobile(String guardianMobile) {
        this.guardianMobile = guardianMobile;
    }

    public String getGuardianTelNo() {
        return this.guardianTelNo;
    }

    public void setGuardianTelNo(String guardianTelNo) {
        this.guardianTelNo = guardianTelNo;
    }

    public String getGuardianAddr() {
        return this.guardianAddr;
    }

    public void setGuardianAddr(String guardianAddr) {
        this.guardianAddr = guardianAddr;
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

    public String getMaintenanceModeCode() {
        return this.maintenanceModeCode;
    }

    public void setMaintenanceModeCode(String maintenanceModeCode) {
        this.maintenanceModeCode = maintenanceModeCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getElderInfoId() {
        return this.elderInfoId;
    }

    public void setElderInfoId(String elderInfoId) {
        this.elderInfoId = elderInfoId;
    }

    @Generated(hash = 1186208868)
    public ElderInfo(String elderInfoId, String personInfoId, String manageOrgId,
            String name, String maintenanceModeCode, String guardianName,
            String guardianRelationCode, String guardianAddr, String guardianTelNo,
            String guardianMobile, String informant, Date informantDate,
            String investigator, Date investigatorDate, Date manageDate,
            String remarks, Integer isCancel, String createOrgId, String orgName,
            String creatorId, String creator, Date createTime,
            String modifiedOrgId, String modifiedOrgName, String modifierId,
            String modifier, Date modifiedTime) {
        this.elderInfoId = elderInfoId;
        this.personInfoId = personInfoId;
        this.manageOrgId = manageOrgId;
        this.name = name;
        this.maintenanceModeCode = maintenanceModeCode;
        this.guardianName = guardianName;
        this.guardianRelationCode = guardianRelationCode;
        this.guardianAddr = guardianAddr;
        this.guardianTelNo = guardianTelNo;
        this.guardianMobile = guardianMobile;
        this.informant = informant;
        this.informantDate = informantDate;
        this.investigator = investigator;
        this.investigatorDate = investigatorDate;
        this.manageDate = manageDate;
        this.remarks = remarks;
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

    @Generated(hash = 67592707)
    public ElderInfo() {
    }

}