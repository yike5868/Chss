package net.greatsoft.main.db.po.person;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 
 * @author AlphGo
 * @date 2016年8月9日 上午11:44:15 
 * @Description: 个人档案变动日志
 *
 */
@Entity
public class MemberMovedLog extends Entry{

    private String memberMovedLogId;

    /**
     * 家庭迁入迁出日志 主键
     */
    private String familyMovedLogId;

    /**
     * 个人档案ID
     */
    private String personInfoId;

    /**
     * 成员迁入到的家庭
     */
    private String familyInfoId;

    /**
     * 居委会
     */
    private String districtId;

    /**
     * 小区
     */
    private String subDistrictId;

    /**
     * 楼栋
     */
    private String buildingId;

    /**
     * 操作类型：1家庭、成员迁入，2家庭成员迁出，3成员迁入，4成员迁出，5成员移出，6加入成员
     */
    private Integer operType;

    /**
     * 操作机构ID
     */
    private String createOrgId;

    /**
     * 操作机构名称
     */
    private String orgName;

    /**
     * 操作人ID
     */
    private String creatorId;

    /**
     * 操作人姓名
     */
    private String creator;

    /**
     * 操作时间
     */
    private Date createTime;

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

    public Integer getOperType() {
        return this.operType;
    }

    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getSubDistrictId() {
        return this.subDistrictId;
    }

    public void setSubDistrictId(String subDistrictId) {
        this.subDistrictId = subDistrictId;
    }

    public String getDistrictId() {
        return this.districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getFamilyInfoId() {
        return this.familyInfoId;
    }

    public void setFamilyInfoId(String familyInfoId) {
        this.familyInfoId = familyInfoId;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getFamilyMovedLogId() {
        return this.familyMovedLogId;
    }

    public void setFamilyMovedLogId(String familyMovedLogId) {
        this.familyMovedLogId = familyMovedLogId;
    }

    public String getMemberMovedLogId() {
        return this.memberMovedLogId;
    }

    public void setMemberMovedLogId(String memberMovedLogId) {
        this.memberMovedLogId = memberMovedLogId;
    }

    @Generated(hash = 982711922)
    public MemberMovedLog(String memberMovedLogId, String familyMovedLogId,
            String personInfoId, String familyInfoId, String districtId,
            String subDistrictId, String buildingId, Integer operType,
            String createOrgId, String orgName, String creatorId, String creator,
            Date createTime) {
        this.memberMovedLogId = memberMovedLogId;
        this.familyMovedLogId = familyMovedLogId;
        this.personInfoId = personInfoId;
        this.familyInfoId = familyInfoId;
        this.districtId = districtId;
        this.subDistrictId = subDistrictId;
        this.buildingId = buildingId;
        this.operType = operType;
        this.createOrgId = createOrgId;
        this.orgName = orgName;
        this.creatorId = creatorId;
        this.creator = creator;
        this.createTime = createTime;
    }

    @Generated(hash = 496777787)
    public MemberMovedLog() {
    }



}