package net.greatsoft.main.db.po.person;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 
 * @author :hn
 * @createDate:2016年6月3日
 * @description:个人表
 */
@Entity
public class Person extends Entry{
    /**
     * 个人ID
     */
    private String personId;

    /**
     * 家庭ID
     */
    private String familyId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别代码
     */
    private String sexCode;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 身份证号
     */
    private String idNo;

    /**
     * 状态代码
     */
    private String personStatusCode;

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

    /**
     * 父亲ID
     */
    private String fatherPersonId;

    /**
     * 配偶ID
     */
    private String spousePersonId;

    public String getSpousePersonId() {
        return this.spousePersonId;
    }

    public void setSpousePersonId(String spousePersonId) {
        this.spousePersonId = spousePersonId;
    }

    public String getFatherPersonId() {
        return this.fatherPersonId;
    }

    public void setFatherPersonId(String fatherPersonId) {
        this.fatherPersonId = fatherPersonId;
    }

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

    public String getPersonStatusCode() {
        return this.personStatusCode;
    }

    public void setPersonStatusCode(String personStatusCode) {
        this.personStatusCode = personStatusCode;
    }

    public String getIdNo() {
        return this.idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getFamilyId() {
        return this.familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getPersonId() {
        return this.personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Generated(hash = 784141369)
    public Person(String personId, String familyId, String name, String sexCode,
            Date birthday, String idNo, String personStatusCode,
            String cancelReasonCode, Date cancelTime, Date createTime,
            Date modifiedTime, String fatherPersonId, String spousePersonId) {
        this.personId = personId;
        this.familyId = familyId;
        this.name = name;
        this.sexCode = sexCode;
        this.birthday = birthday;
        this.idNo = idNo;
        this.personStatusCode = personStatusCode;
        this.cancelReasonCode = cancelReasonCode;
        this.cancelTime = cancelTime;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.fatherPersonId = fatherPersonId;
        this.spousePersonId = spousePersonId;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }

}