package net.greatsoft.main.db.po.child;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年7月19日 下午12:05:12 
 * @Description: 儿童台账信息
 *
 */
@Entity
public class ChildLedger extends Entry{
    /**
     * 儿童台账信息ID
     */
    
    private String childLedgerId;

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
     * 建卡时间
     */
    
    
    private Date createDate;

    /**
     * 新生儿访视日期
     */
    
    
    private Date childHomeVisitDate;
    
    /**
     * 录入机构ID
     */
    
    private String childHomeVisitOrgId;

    /**
     * 满月
     */
    
    
    private Date oneMonth;
    
    /**
     * 录入机构ID
     */
    
    private String oneMonthOrgId;

    /**
     * 3月
     */
    
    
    private Date threeMonth;
    
    /**
     * 录入机构ID
     */
    
    private String threeMonthOrgId;

    /**
     * 6月(中)
     */
    
    
    private Date sixMonth;
    
    /**
     * 录入机构ID
     */
    
    private String sixMonthOrgId;

    /**
     * 8月
     */
    
    
    private Date eight;
    /**
     * 录入机构ID
     */
    
    private String eightOrgId;

    /**
     * 12月(中)
     */
    
    
    private Date oneYear;
    
    /**
     * 录入机构ID
     */
    
    private String oneYearOrgId;

    /**
     * 18月(中)
     */
    
    
    private Date eighteen;
    
    /**
     * 录入机构ID
     */
    
    private String eighteenOrgId;

    /**
     * 24月(中)
     */
    
    
    private Date twentyFourMonth;
    
    /**
     * 录入机构ID
     */
    
    private String twentyFourMonthOrgId;

    /**
     * 30月(中)
     */
    
    
    private Date thirtyMonth;
    
    /**
     * 录入机构ID
     */
    
    private String thirtyMonthOrgId;

    /**
     * 3岁(中)
     */
    
    
    private Date threeYear;
    
    /**
     * 录入机构ID
     */
    
    private String threeYearOrgId;

    /**
     * 4岁
     */
    
    
    private Date fourYear;
    
    /**
     * 录入机构ID
     */
    
    private String fourYearOrgId;

    /**
     * 5岁
     */
    
    
    private Date fiveYear;
    
    /**
     * 录入机构ID
     */
    
    private String fiveYearOrgId;

    /**
     * 6岁
     */
    
    
    private Date sixYear;
    
    /**
     * 录入机构ID
     */
    
    private String sixYearOrgId;

    /**
     * 血红蛋白-6月
     */
    
    private Double hematochromeSix;

    /**
     * 血红蛋白-12月
     */
    
    private Double hematochromeTwelev;

    /**
     * 血红蛋白-18月
     */
    
    private Double hematochromeEighteen;

    /**
     * 血红蛋白-24月
     */
    
    private Double hematochromeTwentyFour;

    /**
     * 中医保健-6月
     */
    
    
    private Date tcmSixMonth;

    /**
     * 中医保健-12月
     */
    
    
    private Date tcmOneYear;

    /**
     * 中医保健-18月
     */
    
    
    private Date tcmEighteen;

    /**
     * 中医保健-24月
     */
    
    
    private Date tcmTwentyFourMonth;

    /**
     * 中医保健-30月
     */
    
    
    private Date tcmThirtyMonth;

    /**
     * 中医保健-3岁
     */
    
    
    private Date tcmThreeYear;

    /**
     * 转出时间
     */
    
    
    private Date turnOutDate;

    /**
     * 喂养方式
     */
    
    private String feedType;

    /**
     * 早产儿（小于37周填是，否则填否）
     */
    
    private String premature;
    
    /**
     * 低体重
     */
    
    private String lowweight;

    /**
     * 生长迟缓
     */
    
    private String growSlow;

    /**
     * 超重
     */
    
    private String overweight;

    /**
     * 肥胖
     */
    
    private String fat;

    /**
     * 备注
     */
    
    private String remark;
    
    /**
     * 是否删除
     */
    private Integer isCancel;

    /**
     * 年龄
     */
    private Integer age;

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getIsCancel() {
        return this.isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFat() {
        return this.fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getOverweight() {
        return this.overweight;
    }

    public void setOverweight(String overweight) {
        this.overweight = overweight;
    }

    public String getGrowSlow() {
        return this.growSlow;
    }

    public void setGrowSlow(String growSlow) {
        this.growSlow = growSlow;
    }

    public String getLowweight() {
        return this.lowweight;
    }

    public void setLowweight(String lowweight) {
        this.lowweight = lowweight;
    }

    public String getPremature() {
        return this.premature;
    }

    public void setPremature(String premature) {
        this.premature = premature;
    }

    public String getFeedType() {
        return this.feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public Date getTurnOutDate() {
        return this.turnOutDate;
    }

    public void setTurnOutDate(Date turnOutDate) {
        this.turnOutDate = turnOutDate;
    }

    public Date getTcmThreeYear() {
        return this.tcmThreeYear;
    }

    public void setTcmThreeYear(Date tcmThreeYear) {
        this.tcmThreeYear = tcmThreeYear;
    }

    public Date getTcmThirtyMonth() {
        return this.tcmThirtyMonth;
    }

    public void setTcmThirtyMonth(Date tcmThirtyMonth) {
        this.tcmThirtyMonth = tcmThirtyMonth;
    }

    public Date getTcmTwentyFourMonth() {
        return this.tcmTwentyFourMonth;
    }

    public void setTcmTwentyFourMonth(Date tcmTwentyFourMonth) {
        this.tcmTwentyFourMonth = tcmTwentyFourMonth;
    }

    public Date getTcmEighteen() {
        return this.tcmEighteen;
    }

    public void setTcmEighteen(Date tcmEighteen) {
        this.tcmEighteen = tcmEighteen;
    }

    public Date getTcmOneYear() {
        return this.tcmOneYear;
    }

    public void setTcmOneYear(Date tcmOneYear) {
        this.tcmOneYear = tcmOneYear;
    }

    public Date getTcmSixMonth() {
        return this.tcmSixMonth;
    }

    public void setTcmSixMonth(Date tcmSixMonth) {
        this.tcmSixMonth = tcmSixMonth;
    }

    public Double getHematochromeTwentyFour() {
        return this.hematochromeTwentyFour;
    }

    public void setHematochromeTwentyFour(Double hematochromeTwentyFour) {
        this.hematochromeTwentyFour = hematochromeTwentyFour;
    }

    public Double getHematochromeEighteen() {
        return this.hematochromeEighteen;
    }

    public void setHematochromeEighteen(Double hematochromeEighteen) {
        this.hematochromeEighteen = hematochromeEighteen;
    }

    public Double getHematochromeTwelev() {
        return this.hematochromeTwelev;
    }

    public void setHematochromeTwelev(Double hematochromeTwelev) {
        this.hematochromeTwelev = hematochromeTwelev;
    }

    public Double getHematochromeSix() {
        return this.hematochromeSix;
    }

    public void setHematochromeSix(Double hematochromeSix) {
        this.hematochromeSix = hematochromeSix;
    }

    public String getSixYearOrgId() {
        return this.sixYearOrgId;
    }

    public void setSixYearOrgId(String sixYearOrgId) {
        this.sixYearOrgId = sixYearOrgId;
    }

    public Date getSixYear() {
        return this.sixYear;
    }

    public void setSixYear(Date sixYear) {
        this.sixYear = sixYear;
    }

    public String getFiveYearOrgId() {
        return this.fiveYearOrgId;
    }

    public void setFiveYearOrgId(String fiveYearOrgId) {
        this.fiveYearOrgId = fiveYearOrgId;
    }

    public Date getFiveYear() {
        return this.fiveYear;
    }

    public void setFiveYear(Date fiveYear) {
        this.fiveYear = fiveYear;
    }

    public String getFourYearOrgId() {
        return this.fourYearOrgId;
    }

    public void setFourYearOrgId(String fourYearOrgId) {
        this.fourYearOrgId = fourYearOrgId;
    }

    public Date getFourYear() {
        return this.fourYear;
    }

    public void setFourYear(Date fourYear) {
        this.fourYear = fourYear;
    }

    public String getThreeYearOrgId() {
        return this.threeYearOrgId;
    }

    public void setThreeYearOrgId(String threeYearOrgId) {
        this.threeYearOrgId = threeYearOrgId;
    }

    public Date getThreeYear() {
        return this.threeYear;
    }

    public void setThreeYear(Date threeYear) {
        this.threeYear = threeYear;
    }

    public String getThirtyMonthOrgId() {
        return this.thirtyMonthOrgId;
    }

    public void setThirtyMonthOrgId(String thirtyMonthOrgId) {
        this.thirtyMonthOrgId = thirtyMonthOrgId;
    }

    public Date getThirtyMonth() {
        return this.thirtyMonth;
    }

    public void setThirtyMonth(Date thirtyMonth) {
        this.thirtyMonth = thirtyMonth;
    }

    public String getTwentyFourMonthOrgId() {
        return this.twentyFourMonthOrgId;
    }

    public void setTwentyFourMonthOrgId(String twentyFourMonthOrgId) {
        this.twentyFourMonthOrgId = twentyFourMonthOrgId;
    }

    public Date getTwentyFourMonth() {
        return this.twentyFourMonth;
    }

    public void setTwentyFourMonth(Date twentyFourMonth) {
        this.twentyFourMonth = twentyFourMonth;
    }

    public String getEighteenOrgId() {
        return this.eighteenOrgId;
    }

    public void setEighteenOrgId(String eighteenOrgId) {
        this.eighteenOrgId = eighteenOrgId;
    }

    public Date getEighteen() {
        return this.eighteen;
    }

    public void setEighteen(Date eighteen) {
        this.eighteen = eighteen;
    }

    public String getOneYearOrgId() {
        return this.oneYearOrgId;
    }

    public void setOneYearOrgId(String oneYearOrgId) {
        this.oneYearOrgId = oneYearOrgId;
    }

    public Date getOneYear() {
        return this.oneYear;
    }

    public void setOneYear(Date oneYear) {
        this.oneYear = oneYear;
    }

    public String getEightOrgId() {
        return this.eightOrgId;
    }

    public void setEightOrgId(String eightOrgId) {
        this.eightOrgId = eightOrgId;
    }

    public Date getEight() {
        return this.eight;
    }

    public void setEight(Date eight) {
        this.eight = eight;
    }

    public String getSixMonthOrgId() {
        return this.sixMonthOrgId;
    }

    public void setSixMonthOrgId(String sixMonthOrgId) {
        this.sixMonthOrgId = sixMonthOrgId;
    }

    public Date getSixMonth() {
        return this.sixMonth;
    }

    public void setSixMonth(Date sixMonth) {
        this.sixMonth = sixMonth;
    }

    public String getThreeMonthOrgId() {
        return this.threeMonthOrgId;
    }

    public void setThreeMonthOrgId(String threeMonthOrgId) {
        this.threeMonthOrgId = threeMonthOrgId;
    }

    public Date getThreeMonth() {
        return this.threeMonth;
    }

    public void setThreeMonth(Date threeMonth) {
        this.threeMonth = threeMonth;
    }

    public String getOneMonthOrgId() {
        return this.oneMonthOrgId;
    }

    public void setOneMonthOrgId(String oneMonthOrgId) {
        this.oneMonthOrgId = oneMonthOrgId;
    }

    public Date getOneMonth() {
        return this.oneMonth;
    }

    public void setOneMonth(Date oneMonth) {
        this.oneMonth = oneMonth;
    }

    public String getChildHomeVisitOrgId() {
        return this.childHomeVisitOrgId;
    }

    public void setChildHomeVisitOrgId(String childHomeVisitOrgId) {
        this.childHomeVisitOrgId = childHomeVisitOrgId;
    }

    public Date getChildHomeVisitDate() {
        return this.childHomeVisitDate;
    }

    public void setChildHomeVisitDate(Date childHomeVisitDate) {
        this.childHomeVisitDate = childHomeVisitDate;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getChildLedgerId() {
        return this.childLedgerId;
    }

    public void setChildLedgerId(String childLedgerId) {
        this.childLedgerId = childLedgerId;
    }

    @Generated(hash = 170552233)
    public ChildLedger(String childLedgerId, String personInfoId,
            String newbornName, String newbornSexCode, String newbornSexValue,
            Date newbornBirthDate, String newbornNation,
            String presentAddrProvince, String fatherId, String fatherName,
            String fatherIdno, String fatherOccupCode, String fatherTelNo,
            Date fatherBirthDate, String motherId, String motherName,
            String motherIdno, String motherOccupCode, String motherTelNo,
            Date motherBirthDate, String household, Date createDate,
            Date childHomeVisitDate, String childHomeVisitOrgId, Date oneMonth,
            String oneMonthOrgId, Date threeMonth, String threeMonthOrgId,
            Date sixMonth, String sixMonthOrgId, Date eight, String eightOrgId,
            Date oneYear, String oneYearOrgId, Date eighteen, String eighteenOrgId,
            Date twentyFourMonth, String twentyFourMonthOrgId, Date thirtyMonth,
            String thirtyMonthOrgId, Date threeYear, String threeYearOrgId,
            Date fourYear, String fourYearOrgId, Date fiveYear,
            String fiveYearOrgId, Date sixYear, String sixYearOrgId,
            Double hematochromeSix, Double hematochromeTwelev,
            Double hematochromeEighteen, Double hematochromeTwentyFour,
            Date tcmSixMonth, Date tcmOneYear, Date tcmEighteen,
            Date tcmTwentyFourMonth, Date tcmThirtyMonth, Date tcmThreeYear,
            Date turnOutDate, String feedType, String premature, String lowweight,
            String growSlow, String overweight, String fat, String remark,
            Integer isCancel, Integer age) {
        this.childLedgerId = childLedgerId;
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
        this.createDate = createDate;
        this.childHomeVisitDate = childHomeVisitDate;
        this.childHomeVisitOrgId = childHomeVisitOrgId;
        this.oneMonth = oneMonth;
        this.oneMonthOrgId = oneMonthOrgId;
        this.threeMonth = threeMonth;
        this.threeMonthOrgId = threeMonthOrgId;
        this.sixMonth = sixMonth;
        this.sixMonthOrgId = sixMonthOrgId;
        this.eight = eight;
        this.eightOrgId = eightOrgId;
        this.oneYear = oneYear;
        this.oneYearOrgId = oneYearOrgId;
        this.eighteen = eighteen;
        this.eighteenOrgId = eighteenOrgId;
        this.twentyFourMonth = twentyFourMonth;
        this.twentyFourMonthOrgId = twentyFourMonthOrgId;
        this.thirtyMonth = thirtyMonth;
        this.thirtyMonthOrgId = thirtyMonthOrgId;
        this.threeYear = threeYear;
        this.threeYearOrgId = threeYearOrgId;
        this.fourYear = fourYear;
        this.fourYearOrgId = fourYearOrgId;
        this.fiveYear = fiveYear;
        this.fiveYearOrgId = fiveYearOrgId;
        this.sixYear = sixYear;
        this.sixYearOrgId = sixYearOrgId;
        this.hematochromeSix = hematochromeSix;
        this.hematochromeTwelev = hematochromeTwelev;
        this.hematochromeEighteen = hematochromeEighteen;
        this.hematochromeTwentyFour = hematochromeTwentyFour;
        this.tcmSixMonth = tcmSixMonth;
        this.tcmOneYear = tcmOneYear;
        this.tcmEighteen = tcmEighteen;
        this.tcmTwentyFourMonth = tcmTwentyFourMonth;
        this.tcmThirtyMonth = tcmThirtyMonth;
        this.tcmThreeYear = tcmThreeYear;
        this.turnOutDate = turnOutDate;
        this.feedType = feedType;
        this.premature = premature;
        this.lowweight = lowweight;
        this.growSlow = growSlow;
        this.overweight = overweight;
        this.fat = fat;
        this.remark = remark;
        this.isCancel = isCancel;
        this.age = age;
    }

    @Generated(hash = 900656244)
    public ChildLedger() {
    }


}