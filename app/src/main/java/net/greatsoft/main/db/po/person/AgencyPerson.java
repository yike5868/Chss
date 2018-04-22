/*
 * $Id: codetemplates.xml 2918 2014-01-22 15:29:26Z hn $
 * 版权所有 2016 冠新软件。
 * 保留所有权利。
 */
package net.greatsoft.main.db.po.person;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author hujunxiang
 * @date 2016年6月21日 下午1:25:19 
 * @Description: 机构管辖的个人
 * 
 */
@Entity
public class AgencyPerson  extends Entry{
    /**
     * 机构管辖的个人ID
     */
    private String agencyFamilyId;

    /**
     * 个人健康档案ID
     */
    private String personInfoId;

    /**
     * 迁入前机构ID
     */
    private String moveBeforeOrgId;

    /**
     * 迁出后机构ID
     */
    private String moveAfterOrgId;

    /**
     * 迁入/新增时间
     */
    private Date moveInDate;

    /**
     * 迁入原因:1：迁入、2：新增
     */
    private Integer moveInReason;

    /**
     * 迁入操作机构ID
     */
    private String moveInOrgId;

    /**
     * 迁入操作机构名称
     */
    private String moveInOrgName;

    /**
     * 迁入操作人ID
     */
    private String moveInCreatorId;

    /**
     * 迁入操作人姓名
     */
    private String moveInCreator;

    /**
     * 迁入操作时间
     */
    private Date moveInTime;

    /**
     * 迁出时间
     */
    private Date moveOutDate;

    /**
     * 迁出原因:1：迁出、2：注销、3：删除
     */
    private Integer moveOutReason;

    /**
     * 迁出操作机构ID
     */
    private String moveOutOrgId;

    /**
     * 迁出操作机构名称
     */
    private String moveOutOrgName;

    /**
     * 迁出操作人ID
     */
    private String moveOutCreatorId;

    /**
     * 迁出操作人姓名
     */
    private String moveOutCreator;

    /**
     * 迁出操作时间
     */
    private Date moveOutTime;

    public Date getMoveOutTime() {
        return this.moveOutTime;
    }

    public void setMoveOutTime(Date moveOutTime) {
        this.moveOutTime = moveOutTime;
    }

    public String getMoveOutCreator() {
        return this.moveOutCreator;
    }

    public void setMoveOutCreator(String moveOutCreator) {
        this.moveOutCreator = moveOutCreator;
    }

    public String getMoveOutCreatorId() {
        return this.moveOutCreatorId;
    }

    public void setMoveOutCreatorId(String moveOutCreatorId) {
        this.moveOutCreatorId = moveOutCreatorId;
    }

    public String getMoveOutOrgName() {
        return this.moveOutOrgName;
    }

    public void setMoveOutOrgName(String moveOutOrgName) {
        this.moveOutOrgName = moveOutOrgName;
    }

    public String getMoveOutOrgId() {
        return this.moveOutOrgId;
    }

    public void setMoveOutOrgId(String moveOutOrgId) {
        this.moveOutOrgId = moveOutOrgId;
    }

    public Integer getMoveOutReason() {
        return this.moveOutReason;
    }

    public void setMoveOutReason(Integer moveOutReason) {
        this.moveOutReason = moveOutReason;
    }

    public Date getMoveOutDate() {
        return this.moveOutDate;
    }

    public void setMoveOutDate(Date moveOutDate) {
        this.moveOutDate = moveOutDate;
    }

    public Date getMoveInTime() {
        return this.moveInTime;
    }

    public void setMoveInTime(Date moveInTime) {
        this.moveInTime = moveInTime;
    }

    public String getMoveInCreator() {
        return this.moveInCreator;
    }

    public void setMoveInCreator(String moveInCreator) {
        this.moveInCreator = moveInCreator;
    }

    public String getMoveInCreatorId() {
        return this.moveInCreatorId;
    }

    public void setMoveInCreatorId(String moveInCreatorId) {
        this.moveInCreatorId = moveInCreatorId;
    }

    public String getMoveInOrgName() {
        return this.moveInOrgName;
    }

    public void setMoveInOrgName(String moveInOrgName) {
        this.moveInOrgName = moveInOrgName;
    }

    public String getMoveInOrgId() {
        return this.moveInOrgId;
    }

    public void setMoveInOrgId(String moveInOrgId) {
        this.moveInOrgId = moveInOrgId;
    }

    public Integer getMoveInReason() {
        return this.moveInReason;
    }

    public void setMoveInReason(Integer moveInReason) {
        this.moveInReason = moveInReason;
    }

    public Date getMoveInDate() {
        return this.moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public String getMoveAfterOrgId() {
        return this.moveAfterOrgId;
    }

    public void setMoveAfterOrgId(String moveAfterOrgId) {
        this.moveAfterOrgId = moveAfterOrgId;
    }

    public String getMoveBeforeOrgId() {
        return this.moveBeforeOrgId;
    }

    public void setMoveBeforeOrgId(String moveBeforeOrgId) {
        this.moveBeforeOrgId = moveBeforeOrgId;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getAgencyFamilyId() {
        return this.agencyFamilyId;
    }

    public void setAgencyFamilyId(String agencyFamilyId) {
        this.agencyFamilyId = agencyFamilyId;
    }

    @Generated(hash = 920277802)
    public AgencyPerson(String agencyFamilyId, String personInfoId,
            String moveBeforeOrgId, String moveAfterOrgId, Date moveInDate,
            Integer moveInReason, String moveInOrgId, String moveInOrgName,
            String moveInCreatorId, String moveInCreator, Date moveInTime,
            Date moveOutDate, Integer moveOutReason, String moveOutOrgId,
            String moveOutOrgName, String moveOutCreatorId, String moveOutCreator,
            Date moveOutTime) {
        this.agencyFamilyId = agencyFamilyId;
        this.personInfoId = personInfoId;
        this.moveBeforeOrgId = moveBeforeOrgId;
        this.moveAfterOrgId = moveAfterOrgId;
        this.moveInDate = moveInDate;
        this.moveInReason = moveInReason;
        this.moveInOrgId = moveInOrgId;
        this.moveInOrgName = moveInOrgName;
        this.moveInCreatorId = moveInCreatorId;
        this.moveInCreator = moveInCreator;
        this.moveInTime = moveInTime;
        this.moveOutDate = moveOutDate;
        this.moveOutReason = moveOutReason;
        this.moveOutOrgId = moveOutOrgId;
        this.moveOutOrgName = moveOutOrgName;
        this.moveOutCreatorId = moveOutCreatorId;
        this.moveOutCreator = moveOutCreator;
        this.moveOutTime = moveOutTime;
    }

    @Generated(hash = 1244419754)
    public AgencyPerson() {
    }

}
