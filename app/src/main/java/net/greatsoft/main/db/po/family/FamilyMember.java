package net.greatsoft.main.db.po.family;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author :hn
 * @createDate:2016年5月31日
 * @description:家庭成员表
 */
@Entity
public class FamilyMember extends Entry{
	/**
	 * 家庭成员ID
	 */
    private String familyMemberId;

	/**
	 * 成员顺序号
	 */
    private Integer memberNo;

    /**
     * 家庭ID
     */
    private String familyId;

    /**
     * 个人ID
     */
    private String personId;

    /**
     * 转入时间
     */
    private Date moveInDate;
    
    /**
     * 转入原因
     */
    private String moveInReason;

    /**
     * 转出时间
     */
    private Date moveOutDate;
    /**
     * 转出原因
     */
    private String moveOutReason;

    /**
     * 是否从家庭中删除
     */
    private Integer isCancel;

    public Integer getIsCancel() {
        return this.isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public String getMoveOutReason() {
        return this.moveOutReason;
    }

    public void setMoveOutReason(String moveOutReason) {
        this.moveOutReason = moveOutReason;
    }

    public Date getMoveOutDate() {
        return this.moveOutDate;
    }

    public void setMoveOutDate(Date moveOutDate) {
        this.moveOutDate = moveOutDate;
    }

    public String getMoveInReason() {
        return this.moveInReason;
    }

    public void setMoveInReason(String moveInReason) {
        this.moveInReason = moveInReason;
    }

    public Date getMoveInDate() {
        return this.moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public String getPersonId() {
        return this.personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public Integer getMemberNo() {
        return this.memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public String getFamilyMemberId() {
        return this.familyMemberId;
    }

    public void setFamilyMemberId(String familyMemberId) {
        this.familyMemberId = familyMemberId;
    }

    @Generated(hash = 1056143224)
    public FamilyMember(String familyMemberId, Integer memberNo, String familyId,
            String personId, Date moveInDate, String moveInReason,
            Date moveOutDate, String moveOutReason, Integer isCancel) {
        this.familyMemberId = familyMemberId;
        this.memberNo = memberNo;
        this.familyId = familyId;
        this.personId = personId;
        this.moveInDate = moveInDate;
        this.moveInReason = moveInReason;
        this.moveOutDate = moveOutDate;
        this.moveOutReason = moveOutReason;
        this.isCancel = isCancel;
    }

    @Generated(hash = 991782851)
    public FamilyMember() {
    }


}