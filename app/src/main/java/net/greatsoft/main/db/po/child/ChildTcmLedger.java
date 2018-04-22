package net.greatsoft.main.db.po.child;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年7月19日 下午12:06:01 
 * @Description: 儿童中医药台账
 *
 */
@Entity
public class ChildTcmLedger extends Entry{
    /**
     * 儿童中医药台账ID
     */
    
    private String childTcmLedgerId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;

    /**
     * 新生儿姓名
     */
    
    private String newbornName;

    /**
     * 新生儿性别代码  
     */
    
    private String newbornSexCode;

    /**
     * 新生儿性别中文 
     */
    
    private String newbornSexValue;

    /**
     * 新生儿出生日期
     */
    
    
    private Date newbornBirthDate;

    /**
     * 新生儿民族
     */
    
    private String newbornNation;

    /**
     * 家庭住址
     */
    private String presentAddrProvince;

    /**
     * 父亲档案ID
     */
    
    private String fatherId;

    /**
     * 父亲姓名
     */
   
    private String fatherName;

    /**
     * 父亲身份证号
     */
    private String fatherIdno;

    /**
     * 父亲职业
     */
    private String fatherOccupCode;

    /**
     * 父亲电话号码
     */
    
    private String fatherTelNo;

    /**
     * 父亲出生日期
     */
    
    
    private Date fatherBirthDate;

    /**
     * 母亲档案ID
     */
    
    private String motherId;

    /**
     * 母亲姓名
     */
   
    private String motherName;

    /**
     * 母亲身份证号
     */
    private String motherIdno;

    /**
     * 母亲职业
     */
    private String motherOccupCode;

    /**
     * 母亲电话号码  
     */
    
    private String motherTelNo;

    /**
     * 母亲出生日期
     */
    
    
    private Date motherBirthDate;

    /**
     * 户口
     */
    
    private String household;

    /**
     * 月龄
     */
    private Integer monthOfAge;

    /**
     * 随访日期
     */
    
    
    private Date visitDate;

    /**
     * 中医饮食调养指导
     */
    
    private String childTcmOne;

    /**
     * 中医起居调摄指导
     */
    
    private String childTcmTwo;

    /**
     * 传授摩腹、捏脊方法
     */
    
    private String childTcmThree;

    /**
     * 传授按揉迎香穴、足三里穴方法
     */
    
    private String childTcmFour;

    /**
     * 传授按揉四神聪穴方法
     */
    
    private String childTcmFive;

    /**
     * 其他
     */
   
    private String childTcmOther;
    
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

    public String getChildTcmOther() {
        return this.childTcmOther;
    }

    public void setChildTcmOther(String childTcmOther) {
        this.childTcmOther = childTcmOther;
    }

    public String getChildTcmFive() {
        return this.childTcmFive;
    }

    public void setChildTcmFive(String childTcmFive) {
        this.childTcmFive = childTcmFive;
    }

    public String getChildTcmFour() {
        return this.childTcmFour;
    }

    public void setChildTcmFour(String childTcmFour) {
        this.childTcmFour = childTcmFour;
    }

    public String getChildTcmThree() {
        return this.childTcmThree;
    }

    public void setChildTcmThree(String childTcmThree) {
        this.childTcmThree = childTcmThree;
    }

    public String getChildTcmTwo() {
        return this.childTcmTwo;
    }

    public void setChildTcmTwo(String childTcmTwo) {
        this.childTcmTwo = childTcmTwo;
    }

    public String getChildTcmOne() {
        return this.childTcmOne;
    }

    public void setChildTcmOne(String childTcmOne) {
        this.childTcmOne = childTcmOne;
    }

    public Date getVisitDate() {
        return this.visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getMonthOfAge() {
        return this.monthOfAge;
    }

    public void setMonthOfAge(Integer monthOfAge) {
        this.monthOfAge = monthOfAge;
    }

    public String getHousehold() {
        return this.household;
    }

    public void setHousehold(String household) {
        this.household = household;
    }

    public Date getMotherBirthDate() {
        return this.motherBirthDate;
    }

    public void setMotherBirthDate(Date motherBirthDate) {
        this.motherBirthDate = motherBirthDate;
    }

    public String getMotherTelNo() {
        return this.motherTelNo;
    }

    public void setMotherTelNo(String motherTelNo) {
        this.motherTelNo = motherTelNo;
    }

    public String getMotherOccupCode() {
        return this.motherOccupCode;
    }

    public void setMotherOccupCode(String motherOccupCode) {
        this.motherOccupCode = motherOccupCode;
    }

    public String getMotherIdno() {
        return this.motherIdno;
    }

    public void setMotherIdno(String motherIdno) {
        this.motherIdno = motherIdno;
    }

    public String getMotherName() {
        return this.motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherId() {
        return this.motherId;
    }

    public void setMotherId(String motherId) {
        this.motherId = motherId;
    }

    public Date getFatherBirthDate() {
        return this.fatherBirthDate;
    }

    public void setFatherBirthDate(Date fatherBirthDate) {
        this.fatherBirthDate = fatherBirthDate;
    }

    public String getFatherTelNo() {
        return this.fatherTelNo;
    }

    public void setFatherTelNo(String fatherTelNo) {
        this.fatherTelNo = fatherTelNo;
    }

    public String getFatherOccupCode() {
        return this.fatherOccupCode;
    }

    public void setFatherOccupCode(String fatherOccupCode) {
        this.fatherOccupCode = fatherOccupCode;
    }

    public String getFatherIdno() {
        return this.fatherIdno;
    }

    public void setFatherIdno(String fatherIdno) {
        this.fatherIdno = fatherIdno;
    }

    public String getFatherName() {
        return this.fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherId() {
        return this.fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public String getPresentAddrProvince() {
        return this.presentAddrProvince;
    }

    public void setPresentAddrProvince(String presentAddrProvince) {
        this.presentAddrProvince = presentAddrProvince;
    }

    public String getNewbornNation() {
        return this.newbornNation;
    }

    public void setNewbornNation(String newbornNation) {
        this.newbornNation = newbornNation;
    }

    public Date getNewbornBirthDate() {
        return this.newbornBirthDate;
    }

    public void setNewbornBirthDate(Date newbornBirthDate) {
        this.newbornBirthDate = newbornBirthDate;
    }

    public String getNewbornSexValue() {
        return this.newbornSexValue;
    }

    public void setNewbornSexValue(String newbornSexValue) {
        this.newbornSexValue = newbornSexValue;
    }

    public String getNewbornSexCode() {
        return this.newbornSexCode;
    }

    public void setNewbornSexCode(String newbornSexCode) {
        this.newbornSexCode = newbornSexCode;
    }

    public String getNewbornName() {
        return this.newbornName;
    }

    public void setNewbornName(String newbornName) {
        this.newbornName = newbornName;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getChildTcmLedgerId() {
        return this.childTcmLedgerId;
    }

    public void setChildTcmLedgerId(String childTcmLedgerId) {
        this.childTcmLedgerId = childTcmLedgerId;
    }

    @Generated(hash = 1122239131)
    public ChildTcmLedger(String childTcmLedgerId, String personInfoId,
            String newbornName, String newbornSexCode, String newbornSexValue,
            Date newbornBirthDate, String newbornNation,
            String presentAddrProvince, String fatherId, String fatherName,
            String fatherIdno, String fatherOccupCode, String fatherTelNo,
            Date fatherBirthDate, String motherId, String motherName,
            String motherIdno, String motherOccupCode, String motherTelNo,
            Date motherBirthDate, String household, Integer monthOfAge,
            Date visitDate, String childTcmOne, String childTcmTwo,
            String childTcmThree, String childTcmFour, String childTcmFive,
            String childTcmOther, Integer isCancel, String createOrgId,
            String orgName, String creatorId, String creator, Date createTime,
            String modifiedOrgId, String modifiedOrgName, String modifierId,
            String modifier, Date modifiedTime) {
        this.childTcmLedgerId = childTcmLedgerId;
        this.personInfoId = personInfoId;
        this.newbornName = newbornName;
        this.newbornSexCode = newbornSexCode;
        this.newbornSexValue = newbornSexValue;
        this.newbornBirthDate = newbornBirthDate;
        this.newbornNation = newbornNation;
        this.presentAddrProvince = presentAddrProvince;
        this.fatherId = fatherId;
        this.fatherName = fatherName;
        this.fatherIdno = fatherIdno;
        this.fatherOccupCode = fatherOccupCode;
        this.fatherTelNo = fatherTelNo;
        this.fatherBirthDate = fatherBirthDate;
        this.motherId = motherId;
        this.motherName = motherName;
        this.motherIdno = motherIdno;
        this.motherOccupCode = motherOccupCode;
        this.motherTelNo = motherTelNo;
        this.motherBirthDate = motherBirthDate;
        this.household = household;
        this.monthOfAge = monthOfAge;
        this.visitDate = visitDate;
        this.childTcmOne = childTcmOne;
        this.childTcmTwo = childTcmTwo;
        this.childTcmThree = childTcmThree;
        this.childTcmFour = childTcmFour;
        this.childTcmFive = childTcmFive;
        this.childTcmOther = childTcmOther;
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

    @Generated(hash = 1377864295)
    public ChildTcmLedger() {
    }


}