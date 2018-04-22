package net.greatsoft.main.db.po.family;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
/**
 * 
 * @author :hn
 * @createDate:2016年5月31日
 * @description: 家庭表
 */

@Entity
public class Family extends Entry{

	/**
	 * 家庭ID
	 */
    private String familyId;

	/**
	 * 区域ID
	 */
    private String districtId;

    /**
     * 户主姓名
     */
    private String householder;

    /**
     * 户主身份证号
     */
    private String householderIdNo;

    /**
     * 家庭地址
     */
    private String address;

    /**
     * 电话号码
     */
    private String telNo;

    /**
     * 状态代码
     */
    private String familyStatusCode;

    /**
     * 注销删除原因代码
     */
    private String cancelReasonCode;

    /**
     * 注销删除时间
     */
    private Date cancelTime;

    /**
     * 创建时间
     */
    private Date createTime;

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

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCancelTime() {
        return this.cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getCancelReasonCode() {
        return this.cancelReasonCode;
    }

    public void setCancelReasonCode(String cancelReasonCode) {
        this.cancelReasonCode = cancelReasonCode;
    }

    public String getFamilyStatusCode() {
        return this.familyStatusCode;
    }

    public void setFamilyStatusCode(String familyStatusCode) {
        this.familyStatusCode = familyStatusCode;
    }

    public String getTelNo() {
        return this.telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHouseholderIdNo() {
        return this.householderIdNo;
    }

    public void setHouseholderIdNo(String householderIdNo) {
        this.householderIdNo = householderIdNo;
    }

    public String getHouseholder() {
        return this.householder;
    }

    public void setHouseholder(String householder) {
        this.householder = householder;
    }

    public String getDistrictId() {
        return this.districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    @Generated(hash = 612394515)
    public Family(String familyId, String districtId, String householder,
            String householderIdNo, String address, String telNo,
            String familyStatusCode, String cancelReasonCode, Date cancelTime,
            Date createTime, Date modifiedTime) {
        this.familyId = familyId;
        this.districtId = districtId;
        this.householder = householder;
        this.householderIdNo = householderIdNo;
        this.address = address;
        this.telNo = telNo;
        this.familyStatusCode = familyStatusCode;
        this.cancelReasonCode = cancelReasonCode;
        this.cancelTime = cancelTime;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    @Generated(hash = 627106668)
    public Family() {
    }

}