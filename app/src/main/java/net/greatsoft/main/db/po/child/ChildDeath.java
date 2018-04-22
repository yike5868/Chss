package net.greatsoft.main.db.po.child;

import net.greatsoft.main.db.po.Entry;
import net.greatsoft.main.db.po.RecordChoice;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Transient;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年7月19日 下午12:01:03 
 * @Description: 儿童死亡登记
 *
 */
@Entity
public class ChildDeath extends Entry{
    /**
     * 儿童死亡登记ID
     */
    
    private String childDeathId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;

    /**
     * 儿童死亡登记表单编号
     */
    
    private String childDeathFormNo;

    /**
     * 姓名
     */
    private String newbornName;

    /**
     * 性别
     */
    
    private String sexCode;

    /**
     * 住址
     */
    private String address;

    /**
     * 户口类型代码
     */
    private String householdTypeCode;

    /**
     * 父亲姓名
     */
    private String fatherName;

    /**
     * 母亲姓名
     */
    private String motherName;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 出生体重
     */
    private Double birthWeight;

    /**
     * 体重测量方式代码
     */
    private String weightMeasureTypeCode;

    /**
     * 孕周
     */
    private Double weeks;

    /**
     * 出生地址
     */
    private String birthAddress;

    /**
     * 死亡日期
     */
    private Date deathDate;

    /**
     * 死亡年龄(岁)
     */
    private Integer deathAge;

    /**
     * 死亡年龄(月)
     */
    private Integer deathMonths;

    /**
     * 死亡年龄(天)
     */
    private Integer deathDays;

    /**
     * 死因分类代码
     */
    private String deathReasonTypeCode;

    /**
     * 死亡诊断
     */
    
    private String deathDiagnosis;

    /**
     * 死亡地点
     */
    
    private String deathAddress;

    /**
     * 死前治疗
     */
    
    private String predeathTreatment;

    /**
     * 诊断级别
     */
    
    private String diagnoseGrade;

    /**
     * 未就医或治疗主要原因代码
     */
    
    private String notreatmentReasonCode;

    /**
     * 未就医或治疗主要原因其他说明
     */
    
    private String notreatmentOthersReasonDesc;

    /**
     * 死因诊断依据
     */
    
    private String deathAccording;

    /**
     * 死亡判断依据
     */
    
    private String deathProof ;

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

	@Transient
	private List<RecordChoice> recordChoice;

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

    public String getDeathProof() {
        return this.deathProof;
    }

    public void setDeathProof(String deathProof) {
        this.deathProof = deathProof;
    }

    public String getDeathAccording() {
        return this.deathAccording;
    }

    public void setDeathAccording(String deathAccording) {
        this.deathAccording = deathAccording;
    }

    public String getNotreatmentOthersReasonDesc() {
        return this.notreatmentOthersReasonDesc;
    }

    public void setNotreatmentOthersReasonDesc(String notreatmentOthersReasonDesc) {
        this.notreatmentOthersReasonDesc = notreatmentOthersReasonDesc;
    }

    public String getNotreatmentReasonCode() {
        return this.notreatmentReasonCode;
    }

    public void setNotreatmentReasonCode(String notreatmentReasonCode) {
        this.notreatmentReasonCode = notreatmentReasonCode;
    }

    public String getDiagnoseGrade() {
        return this.diagnoseGrade;
    }

    public void setDiagnoseGrade(String diagnoseGrade) {
        this.diagnoseGrade = diagnoseGrade;
    }

    public String getPredeathTreatment() {
        return this.predeathTreatment;
    }

    public void setPredeathTreatment(String predeathTreatment) {
        this.predeathTreatment = predeathTreatment;
    }

    public String getDeathAddress() {
        return this.deathAddress;
    }

    public void setDeathAddress(String deathAddress) {
        this.deathAddress = deathAddress;
    }

    public String getDeathDiagnosis() {
        return this.deathDiagnosis;
    }

    public void setDeathDiagnosis(String deathDiagnosis) {
        this.deathDiagnosis = deathDiagnosis;
    }

    public String getDeathReasonTypeCode() {
        return this.deathReasonTypeCode;
    }

    public void setDeathReasonTypeCode(String deathReasonTypeCode) {
        this.deathReasonTypeCode = deathReasonTypeCode;
    }

    public Integer getDeathDays() {
        return this.deathDays;
    }

    public void setDeathDays(Integer deathDays) {
        this.deathDays = deathDays;
    }

    public Integer getDeathMonths() {
        return this.deathMonths;
    }

    public void setDeathMonths(Integer deathMonths) {
        this.deathMonths = deathMonths;
    }

    public Integer getDeathAge() {
        return this.deathAge;
    }

    public void setDeathAge(Integer deathAge) {
        this.deathAge = deathAge;
    }

    public Date getDeathDate() {
        return this.deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getBirthAddress() {
        return this.birthAddress;
    }

    public void setBirthAddress(String birthAddress) {
        this.birthAddress = birthAddress;
    }

    public Double getWeeks() {
        return this.weeks;
    }

    public void setWeeks(Double weeks) {
        this.weeks = weeks;
    }

    public String getWeightMeasureTypeCode() {
        return this.weightMeasureTypeCode;
    }

    public void setWeightMeasureTypeCode(String weightMeasureTypeCode) {
        this.weightMeasureTypeCode = weightMeasureTypeCode;
    }

    public Double getBirthWeight() {
        return this.birthWeight;
    }

    public void setBirthWeight(Double birthWeight) {
        this.birthWeight = birthWeight;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMotherName() {
        return this.motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return this.fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getHouseholdTypeCode() {
        return this.householdTypeCode;
    }

    public void setHouseholdTypeCode(String householdTypeCode) {
        this.householdTypeCode = householdTypeCode;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSexCode() {
        return this.sexCode;
    }

    public void setSexCode(String sexCode) {
        this.sexCode = sexCode;
    }

    public String getNewbornName() {
        return this.newbornName;
    }

    public void setNewbornName(String newbornName) {
        this.newbornName = newbornName;
    }

    public String getChildDeathFormNo() {
        return this.childDeathFormNo;
    }

    public void setChildDeathFormNo(String childDeathFormNo) {
        this.childDeathFormNo = childDeathFormNo;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getChildDeathId() {
        return this.childDeathId;
    }

    public void setChildDeathId(String childDeathId) {
        this.childDeathId = childDeathId;
    }

    @Generated(hash = 1338099788)
    public ChildDeath(String childDeathId, String personInfoId,
            String childDeathFormNo, String newbornName, String sexCode,
            String address, String householdTypeCode, String fatherName,
            String motherName, Date birthday, Double birthWeight,
            String weightMeasureTypeCode, Double weeks, String birthAddress,
            Date deathDate, Integer deathAge, Integer deathMonths,
            Integer deathDays, String deathReasonTypeCode, String deathDiagnosis,
            String deathAddress, String predeathTreatment, String diagnoseGrade,
            String notreatmentReasonCode, String notreatmentOthersReasonDesc,
            String deathAccording, String deathProof, Integer isCancel,
            String createOrgId, String orgName, String creatorId, String creator,
            Date createTime, String modifiedOrgId, String modifiedOrgName,
            String modifierId, String modifier, Date modifiedTime) {
        this.childDeathId = childDeathId;
        this.personInfoId = personInfoId;
        this.childDeathFormNo = childDeathFormNo;
        this.newbornName = newbornName;
        this.sexCode = sexCode;
        this.address = address;
        this.householdTypeCode = householdTypeCode;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.birthday = birthday;
        this.birthWeight = birthWeight;
        this.weightMeasureTypeCode = weightMeasureTypeCode;
        this.weeks = weeks;
        this.birthAddress = birthAddress;
        this.deathDate = deathDate;
        this.deathAge = deathAge;
        this.deathMonths = deathMonths;
        this.deathDays = deathDays;
        this.deathReasonTypeCode = deathReasonTypeCode;
        this.deathDiagnosis = deathDiagnosis;
        this.deathAddress = deathAddress;
        this.predeathTreatment = predeathTreatment;
        this.diagnoseGrade = diagnoseGrade;
        this.notreatmentReasonCode = notreatmentReasonCode;
        this.notreatmentOthersReasonDesc = notreatmentOthersReasonDesc;
        this.deathAccording = deathAccording;
        this.deathProof = deathProof;
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

    @Generated(hash = 9594238)
    public ChildDeath() {
    }


}