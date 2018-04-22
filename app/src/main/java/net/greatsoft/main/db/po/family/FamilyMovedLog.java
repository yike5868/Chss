package net.greatsoft.main.db.po.family;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 
 * @author AlphGo
 * @date 2016年8月9日 上午11:44:55 
 * @Description: 家庭档案变动日志
 *
 */
@Entity
public class FamilyMovedLog extends Entry{
    
    /**
     * 主键
     */
    private String familyMovedLogId;

    /**
     * 家庭档案ID
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
     * 单元
     */
    private String unit;

    /**
     * 房间号
     */
    private String roomNumber;

    /**
     * 操作类型
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

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public String getFamilyMovedLogId() {
        return this.familyMovedLogId;
    }

    public void setFamilyMovedLogId(String familyMovedLogId) {
        this.familyMovedLogId = familyMovedLogId;
    }

    @Generated(hash = 1717273287)
    public FamilyMovedLog(String familyMovedLogId, String familyInfoId,
            String districtId, String subDistrictId, String buildingId,
            String unit, String roomNumber, Integer operType, String createOrgId,
            String orgName, String creatorId, String creator, Date createTime) {
        this.familyMovedLogId = familyMovedLogId;
        this.familyInfoId = familyInfoId;
        this.districtId = districtId;
        this.subDistrictId = subDistrictId;
        this.buildingId = buildingId;
        this.unit = unit;
        this.roomNumber = roomNumber;
        this.operType = operType;
        this.createOrgId = createOrgId;
        this.orgName = orgName;
        this.creatorId = creatorId;
        this.creator = creator;
        this.createTime = createTime;
    }

    @Generated(hash = 1820765111)
    public FamilyMovedLog() {
    }


}