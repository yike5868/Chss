package net.greatsoft.main.db.po.child;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年7月19日 下午12:05:30 
 * @Description: 围产儿死亡报告
 *
 */
@Entity
public class ChildPerinatalDeath extends Entry{
    /**
     * 围产儿死亡报告ID
     */
    
    private String childPerinatalDeathId;

    /**
     * 围产儿死亡报告编号
     */
   
    private String childPerinatalDeathNo;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;

    /**
     * 住院号
     */
    
    private String resiCaseNo;

    /**
     * 医院代码
     */
    private String hospitalCode;

    /**
     * 现住地址
     */
    private String presentAddress;

    /**
     * 常住地址户籍标志
     */
    
    private String provinceHouseholdFlag;

    /**
     * 计划内外
     */
    
    private String planType;

    /**
     * 母亲姓名
     */
    
    private String motherName;

    /**
     * 母亲年龄
     */
    private Integer motherAge;

    /**
     * 母亲文化程度代码
     */
    private String motherEducationCode;

    /**
     * 母亲职业类别代码
     */
   
    private String motherOccupCode;

    /**
     * 父亲姓名
     */
    
    private String fatherName;

    /**
     * 父亲文化程度代码
     */
    private String fatherEducationCode;

    /**
     * 父亲职业类别代码
     */
   
    private String fatherOccupCode;

    /**
     * 家庭年人均收入（元）
     */
    private String familyIncome;

    /**
     * 居住地区类型代码
     */
    
    private String permanentTypeCode;

    /**
     * 孕次
     */
    private Integer gravidity;

    /**
     * 产次
     */
    private Integer parity;

    /**
     * 自然流产次数
     */
    private Integer spontaneousAbortion;

    /**
     * 人工流产次数
     */
    private Integer inducedAbortion;

    /**
     * 药流次数
     */
    private Integer medicalAbortion;

    /**
     * 引产次数
     */
    private Integer labourInduction;

    /**
     * 死胎标志
     */
    private Integer deathFetus;

    /**
     * 死产例数
     */
    private Integer deathDelivery;

    /**
     * 早期新生儿死亡
     */
    private Integer newbornDeath;

    /**
     * 活产
     */
    private Integer liveBirth;

    /**
     * 初检孕周(周)
     */
    private Integer pregnancyWeek;

    /**
     * 早孕期间产检次数
     */
    private Integer earlyPregnancyExam;

    /**
     * 中孕期间产检次数
     */
    private Integer midPregnancyExam;

    /**
     * 晚孕期间产检次数
     */
    private Integer latePregnancyExam;

    /**
     * 孕期情况
     */
    private String pregnancyHealth;

    /**
     * 孕期服药
     */
    
    private String pregnancyDrug;

    /**
     * 孕期服药名称
     */
    private String pregnancyDrugName;

    /**
     * 孕期接触有害物质
     */
    
    private String detrimental;

    /**
     * 孕期接触有害物质名称
     */
    private String detrimentalName;

    /**
     * 宫内感染
     */
    
    private String intrauterineInfection;

    /**
     * 妊娠并发症标志
     */
    
    private String pregnancyComplicationCode;

    /**
     * 子痫前期
     */
    
    private String preeclampsia;

    /**
     * IUGR标志
     */
    
    private String iugr;

    /**
     * 羊水过多
     */
    
    private String hydramnion;

    /**
     * 羊水过少
     */
    
    private String hypamnion;

    /**
     * 出血标志
     */
    
    private String hemorrhage;

    /**
     * 妊娠合并症标志
     */
    
    private String pregnancyCompliCode;

    /**
     * 心脏病
     */
    
    private String cardiopathy;

    /**
     * 肝病
     */
    
    private String hepatopathy;

    /**
     * 甲亢
     */
    
    private String hyperthyrodism;

    /**
     * 贫血
     */
    
    private String anemia;

    /**
     * 泌尿系统
     */
    
    private String urinarySystem;

    /**
     * 外伤标志
     */
    
    private String traumaHistoryCode;

    /**
     * 高危妊娠
     */
    
    private String highRiskPregnancy;

    /**
     * 高危管理
     */
    
    private String highRiskRecord;

    /**
     * 本院分娩
     */
    
    private String localDelivery;

    /**
     * 分娩医院
     */
    private String deliveryHospital;

    /**
     * 分娩医院其他
     */
    private String deliveryHospitalOther;

    /**
     * 分娩方式
     */
    private String deliveryWay;

    /**
     * 非住院分娩新法接生
     */
    
    private String noResiDelivery;

    /**
     * 接生者
     */
    
    private String midwife;

    /**
     * 分娩时间
     */
    
    
    private Date deliveryTime;

    /**
     * 分娩孕周
     */
    private Integer deliveryPregnancyWeek;

    /**
     * 胎别
     */
    
    private String fetusTypeCode;

    /**
     * 胎婴儿性别代码
     */
    
    private String sexCode;

    /**
     * 产时情况代码
     */
    
    private String deliverySituation;

    /**
     * 产时羊水过多
     */
    
    private String deliveryHydramnion;

    /**
     * 产时羊水过少
     */
    
    private String deliveryHypamnion;

    /**
     * 胎膜早破
     */
    
    private String membranePrematureRupture;

    /**
     * 产程延长标志
     */
    
    private String prolongedLabor;

    /**
     * 脐带异常
     */
    
    private String umbilialCordAbnormality;

    /**
     * 胎盘异常
     */
    
    private String placentalAbnormality;

    /**
     * 胎位异常
     */
    
    private String fetalPositionAbnormality;

    /**
     * 中重度妊高症
     */
    
    private String severePih;

    /**
     * 宫内窘迫
     */
    
    private String intrauterineDistress;

    /**
     * 窒息标志
     */
    
    private String asphyxia;

    /**
     * 畸形
     */
    
    private String deformity;

    /**
     * 何种畸形
     */
    private String deformityName;

    /**
     * 出生体重(g)
     */
    private Integer birthWeight;

    /**
     * 胎婴儿情况代码
     */
    
    private String fetusStatus;

    /**
     * 死亡地点类别
     */
    private String deathPlaceType;

    /**
     * 死亡诊断
     */
    private String deathDiagnosis;

    /**
     * 死因诊断依据
     */
    private String diagnosisBasis;

    /**
     * 评审意见
     */
    private String auditSuggest;

    /**
     * 死亡病历摘要或调查小结
     */
    private String deathSummary;

    /**
     * 填卡人姓名
     */
    
    private String fillOperatorName;

    /**
     * 填卡日期
     */
    
    
    private Date createDate;

    /**
     * 死亡时间
     */
    
    
    private Date deathDtime;

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

    public Date getDeathDtime() {
        return this.deathDtime;
    }

    public void setDeathDtime(Date deathDtime) {
        this.deathDtime = deathDtime;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFillOperatorName() {
        return this.fillOperatorName;
    }

    public void setFillOperatorName(String fillOperatorName) {
        this.fillOperatorName = fillOperatorName;
    }

    public String getDeathSummary() {
        return this.deathSummary;
    }

    public void setDeathSummary(String deathSummary) {
        this.deathSummary = deathSummary;
    }

    public String getAuditSuggest() {
        return this.auditSuggest;
    }

    public void setAuditSuggest(String auditSuggest) {
        this.auditSuggest = auditSuggest;
    }

    public String getDiagnosisBasis() {
        return this.diagnosisBasis;
    }

    public void setDiagnosisBasis(String diagnosisBasis) {
        this.diagnosisBasis = diagnosisBasis;
    }

    public String getDeathDiagnosis() {
        return this.deathDiagnosis;
    }

    public void setDeathDiagnosis(String deathDiagnosis) {
        this.deathDiagnosis = deathDiagnosis;
    }

    public String getDeathPlaceType() {
        return this.deathPlaceType;
    }

    public void setDeathPlaceType(String deathPlaceType) {
        this.deathPlaceType = deathPlaceType;
    }

    public String getFetusStatus() {
        return this.fetusStatus;
    }

    public void setFetusStatus(String fetusStatus) {
        this.fetusStatus = fetusStatus;
    }

    public Integer getBirthWeight() {
        return this.birthWeight;
    }

    public void setBirthWeight(Integer birthWeight) {
        this.birthWeight = birthWeight;
    }

    public String getDeformityName() {
        return this.deformityName;
    }

    public void setDeformityName(String deformityName) {
        this.deformityName = deformityName;
    }

    public String getDeformity() {
        return this.deformity;
    }

    public void setDeformity(String deformity) {
        this.deformity = deformity;
    }

    public String getAsphyxia() {
        return this.asphyxia;
    }

    public void setAsphyxia(String asphyxia) {
        this.asphyxia = asphyxia;
    }

    public String getIntrauterineDistress() {
        return this.intrauterineDistress;
    }

    public void setIntrauterineDistress(String intrauterineDistress) {
        this.intrauterineDistress = intrauterineDistress;
    }

    public String getSeverePih() {
        return this.severePih;
    }

    public void setSeverePih(String severePih) {
        this.severePih = severePih;
    }

    public String getFetalPositionAbnormality() {
        return this.fetalPositionAbnormality;
    }

    public void setFetalPositionAbnormality(String fetalPositionAbnormality) {
        this.fetalPositionAbnormality = fetalPositionAbnormality;
    }

    public String getPlacentalAbnormality() {
        return this.placentalAbnormality;
    }

    public void setPlacentalAbnormality(String placentalAbnormality) {
        this.placentalAbnormality = placentalAbnormality;
    }

    public String getUmbilialCordAbnormality() {
        return this.umbilialCordAbnormality;
    }

    public void setUmbilialCordAbnormality(String umbilialCordAbnormality) {
        this.umbilialCordAbnormality = umbilialCordAbnormality;
    }

    public String getProlongedLabor() {
        return this.prolongedLabor;
    }

    public void setProlongedLabor(String prolongedLabor) {
        this.prolongedLabor = prolongedLabor;
    }

    public String getMembranePrematureRupture() {
        return this.membranePrematureRupture;
    }

    public void setMembranePrematureRupture(String membranePrematureRupture) {
        this.membranePrematureRupture = membranePrematureRupture;
    }

    public String getDeliveryHypamnion() {
        return this.deliveryHypamnion;
    }

    public void setDeliveryHypamnion(String deliveryHypamnion) {
        this.deliveryHypamnion = deliveryHypamnion;
    }

    public String getDeliveryHydramnion() {
        return this.deliveryHydramnion;
    }

    public void setDeliveryHydramnion(String deliveryHydramnion) {
        this.deliveryHydramnion = deliveryHydramnion;
    }

    public String getDeliverySituation() {
        return this.deliverySituation;
    }

    public void setDeliverySituation(String deliverySituation) {
        this.deliverySituation = deliverySituation;
    }

    public String getSexCode() {
        return this.sexCode;
    }

    public void setSexCode(String sexCode) {
        this.sexCode = sexCode;
    }

    public String getFetusTypeCode() {
        return this.fetusTypeCode;
    }

    public void setFetusTypeCode(String fetusTypeCode) {
        this.fetusTypeCode = fetusTypeCode;
    }

    public Integer getDeliveryPregnancyWeek() {
        return this.deliveryPregnancyWeek;
    }

    public void setDeliveryPregnancyWeek(Integer deliveryPregnancyWeek) {
        this.deliveryPregnancyWeek = deliveryPregnancyWeek;
    }

    public Date getDeliveryTime() {
        return this.deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getMidwife() {
        return this.midwife;
    }

    public void setMidwife(String midwife) {
        this.midwife = midwife;
    }

    public String getNoResiDelivery() {
        return this.noResiDelivery;
    }

    public void setNoResiDelivery(String noResiDelivery) {
        this.noResiDelivery = noResiDelivery;
    }

    public String getDeliveryWay() {
        return this.deliveryWay;
    }

    public void setDeliveryWay(String deliveryWay) {
        this.deliveryWay = deliveryWay;
    }

    public String getDeliveryHospitalOther() {
        return this.deliveryHospitalOther;
    }

    public void setDeliveryHospitalOther(String deliveryHospitalOther) {
        this.deliveryHospitalOther = deliveryHospitalOther;
    }

    public String getDeliveryHospital() {
        return this.deliveryHospital;
    }

    public void setDeliveryHospital(String deliveryHospital) {
        this.deliveryHospital = deliveryHospital;
    }

    public String getLocalDelivery() {
        return this.localDelivery;
    }

    public void setLocalDelivery(String localDelivery) {
        this.localDelivery = localDelivery;
    }

    public String getHighRiskRecord() {
        return this.highRiskRecord;
    }

    public void setHighRiskRecord(String highRiskRecord) {
        this.highRiskRecord = highRiskRecord;
    }

    public String getHighRiskPregnancy() {
        return this.highRiskPregnancy;
    }

    public void setHighRiskPregnancy(String highRiskPregnancy) {
        this.highRiskPregnancy = highRiskPregnancy;
    }

    public String getTraumaHistoryCode() {
        return this.traumaHistoryCode;
    }

    public void setTraumaHistoryCode(String traumaHistoryCode) {
        this.traumaHistoryCode = traumaHistoryCode;
    }

    public String getUrinarySystem() {
        return this.urinarySystem;
    }

    public void setUrinarySystem(String urinarySystem) {
        this.urinarySystem = urinarySystem;
    }

    public String getAnemia() {
        return this.anemia;
    }

    public void setAnemia(String anemia) {
        this.anemia = anemia;
    }

    public String getHyperthyrodism() {
        return this.hyperthyrodism;
    }

    public void setHyperthyrodism(String hyperthyrodism) {
        this.hyperthyrodism = hyperthyrodism;
    }

    public String getHepatopathy() {
        return this.hepatopathy;
    }

    public void setHepatopathy(String hepatopathy) {
        this.hepatopathy = hepatopathy;
    }

    public String getCardiopathy() {
        return this.cardiopathy;
    }

    public void setCardiopathy(String cardiopathy) {
        this.cardiopathy = cardiopathy;
    }

    public String getPregnancyCompliCode() {
        return this.pregnancyCompliCode;
    }

    public void setPregnancyCompliCode(String pregnancyCompliCode) {
        this.pregnancyCompliCode = pregnancyCompliCode;
    }

    public String getHemorrhage() {
        return this.hemorrhage;
    }

    public void setHemorrhage(String hemorrhage) {
        this.hemorrhage = hemorrhage;
    }

    public String getHypamnion() {
        return this.hypamnion;
    }

    public void setHypamnion(String hypamnion) {
        this.hypamnion = hypamnion;
    }

    public String getHydramnion() {
        return this.hydramnion;
    }

    public void setHydramnion(String hydramnion) {
        this.hydramnion = hydramnion;
    }

    public String getIugr() {
        return this.iugr;
    }

    public void setIugr(String iugr) {
        this.iugr = iugr;
    }

    public String getPreeclampsia() {
        return this.preeclampsia;
    }

    public void setPreeclampsia(String preeclampsia) {
        this.preeclampsia = preeclampsia;
    }

    public String getPregnancyComplicationCode() {
        return this.pregnancyComplicationCode;
    }

    public void setPregnancyComplicationCode(String pregnancyComplicationCode) {
        this.pregnancyComplicationCode = pregnancyComplicationCode;
    }

    public String getIntrauterineInfection() {
        return this.intrauterineInfection;
    }

    public void setIntrauterineInfection(String intrauterineInfection) {
        this.intrauterineInfection = intrauterineInfection;
    }

    public String getDetrimentalName() {
        return this.detrimentalName;
    }

    public void setDetrimentalName(String detrimentalName) {
        this.detrimentalName = detrimentalName;
    }

    public String getDetrimental() {
        return this.detrimental;
    }

    public void setDetrimental(String detrimental) {
        this.detrimental = detrimental;
    }

    public String getPregnancyDrugName() {
        return this.pregnancyDrugName;
    }

    public void setPregnancyDrugName(String pregnancyDrugName) {
        this.pregnancyDrugName = pregnancyDrugName;
    }

    public String getPregnancyDrug() {
        return this.pregnancyDrug;
    }

    public void setPregnancyDrug(String pregnancyDrug) {
        this.pregnancyDrug = pregnancyDrug;
    }

    public String getPregnancyHealth() {
        return this.pregnancyHealth;
    }

    public void setPregnancyHealth(String pregnancyHealth) {
        this.pregnancyHealth = pregnancyHealth;
    }

    public Integer getLatePregnancyExam() {
        return this.latePregnancyExam;
    }

    public void setLatePregnancyExam(Integer latePregnancyExam) {
        this.latePregnancyExam = latePregnancyExam;
    }

    public Integer getMidPregnancyExam() {
        return this.midPregnancyExam;
    }

    public void setMidPregnancyExam(Integer midPregnancyExam) {
        this.midPregnancyExam = midPregnancyExam;
    }

    public Integer getEarlyPregnancyExam() {
        return this.earlyPregnancyExam;
    }

    public void setEarlyPregnancyExam(Integer earlyPregnancyExam) {
        this.earlyPregnancyExam = earlyPregnancyExam;
    }

    public Integer getPregnancyWeek() {
        return this.pregnancyWeek;
    }

    public void setPregnancyWeek(Integer pregnancyWeek) {
        this.pregnancyWeek = pregnancyWeek;
    }

    public Integer getLiveBirth() {
        return this.liveBirth;
    }

    public void setLiveBirth(Integer liveBirth) {
        this.liveBirth = liveBirth;
    }

    public Integer getNewbornDeath() {
        return this.newbornDeath;
    }

    public void setNewbornDeath(Integer newbornDeath) {
        this.newbornDeath = newbornDeath;
    }

    public Integer getDeathDelivery() {
        return this.deathDelivery;
    }

    public void setDeathDelivery(Integer deathDelivery) {
        this.deathDelivery = deathDelivery;
    }

    public Integer getDeathFetus() {
        return this.deathFetus;
    }

    public void setDeathFetus(Integer deathFetus) {
        this.deathFetus = deathFetus;
    }

    public Integer getLabourInduction() {
        return this.labourInduction;
    }

    public void setLabourInduction(Integer labourInduction) {
        this.labourInduction = labourInduction;
    }

    public Integer getMedicalAbortion() {
        return this.medicalAbortion;
    }

    public void setMedicalAbortion(Integer medicalAbortion) {
        this.medicalAbortion = medicalAbortion;
    }

    public Integer getInducedAbortion() {
        return this.inducedAbortion;
    }

    public void setInducedAbortion(Integer inducedAbortion) {
        this.inducedAbortion = inducedAbortion;
    }

    public Integer getSpontaneousAbortion() {
        return this.spontaneousAbortion;
    }

    public void setSpontaneousAbortion(Integer spontaneousAbortion) {
        this.spontaneousAbortion = spontaneousAbortion;
    }

    public Integer getParity() {
        return this.parity;
    }

    public void setParity(Integer parity) {
        this.parity = parity;
    }

    public Integer getGravidity() {
        return this.gravidity;
    }

    public void setGravidity(Integer gravidity) {
        this.gravidity = gravidity;
    }

    public String getPermanentTypeCode() {
        return this.permanentTypeCode;
    }

    public void setPermanentTypeCode(String permanentTypeCode) {
        this.permanentTypeCode = permanentTypeCode;
    }

    public String getFamilyIncome() {
        return this.familyIncome;
    }

    public void setFamilyIncome(String familyIncome) {
        this.familyIncome = familyIncome;
    }

    public String getFatherOccupCode() {
        return this.fatherOccupCode;
    }

    public void setFatherOccupCode(String fatherOccupCode) {
        this.fatherOccupCode = fatherOccupCode;
    }

    public String getFatherEducationCode() {
        return this.fatherEducationCode;
    }

    public void setFatherEducationCode(String fatherEducationCode) {
        this.fatherEducationCode = fatherEducationCode;
    }

    public String getFatherName() {
        return this.fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherOccupCode() {
        return this.motherOccupCode;
    }

    public void setMotherOccupCode(String motherOccupCode) {
        this.motherOccupCode = motherOccupCode;
    }

    public String getMotherEducationCode() {
        return this.motherEducationCode;
    }

    public void setMotherEducationCode(String motherEducationCode) {
        this.motherEducationCode = motherEducationCode;
    }

    public Integer getMotherAge() {
        return this.motherAge;
    }

    public void setMotherAge(Integer motherAge) {
        this.motherAge = motherAge;
    }

    public String getMotherName() {
        return this.motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getPlanType() {
        return this.planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getProvinceHouseholdFlag() {
        return this.provinceHouseholdFlag;
    }

    public void setProvinceHouseholdFlag(String provinceHouseholdFlag) {
        this.provinceHouseholdFlag = provinceHouseholdFlag;
    }

    public String getPresentAddress() {
        return this.presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getHospitalCode() {
        return this.hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public String getResiCaseNo() {
        return this.resiCaseNo;
    }

    public void setResiCaseNo(String resiCaseNo) {
        this.resiCaseNo = resiCaseNo;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getChildPerinatalDeathNo() {
        return this.childPerinatalDeathNo;
    }

    public void setChildPerinatalDeathNo(String childPerinatalDeathNo) {
        this.childPerinatalDeathNo = childPerinatalDeathNo;
    }

    public String getChildPerinatalDeathId() {
        return this.childPerinatalDeathId;
    }

    public void setChildPerinatalDeathId(String childPerinatalDeathId) {
        this.childPerinatalDeathId = childPerinatalDeathId;
    }

    @Generated(hash = 1164661242)
    public ChildPerinatalDeath(String childPerinatalDeathId,
            String childPerinatalDeathNo, String personInfoId, String resiCaseNo,
            String hospitalCode, String presentAddress,
            String provinceHouseholdFlag, String planType, String motherName,
            Integer motherAge, String motherEducationCode, String motherOccupCode,
            String fatherName, String fatherEducationCode, String fatherOccupCode,
            String familyIncome, String permanentTypeCode, Integer gravidity,
            Integer parity, Integer spontaneousAbortion, Integer inducedAbortion,
            Integer medicalAbortion, Integer labourInduction, Integer deathFetus,
            Integer deathDelivery, Integer newbornDeath, Integer liveBirth,
            Integer pregnancyWeek, Integer earlyPregnancyExam,
            Integer midPregnancyExam, Integer latePregnancyExam,
            String pregnancyHealth, String pregnancyDrug, String pregnancyDrugName,
            String detrimental, String detrimentalName,
            String intrauterineInfection, String pregnancyComplicationCode,
            String preeclampsia, String iugr, String hydramnion, String hypamnion,
            String hemorrhage, String pregnancyCompliCode, String cardiopathy,
            String hepatopathy, String hyperthyrodism, String anemia,
            String urinarySystem, String traumaHistoryCode,
            String highRiskPregnancy, String highRiskRecord, String localDelivery,
            String deliveryHospital, String deliveryHospitalOther,
            String deliveryWay, String noResiDelivery, String midwife,
            Date deliveryTime, Integer deliveryPregnancyWeek, String fetusTypeCode,
            String sexCode, String deliverySituation, String deliveryHydramnion,
            String deliveryHypamnion, String membranePrematureRupture,
            String prolongedLabor, String umbilialCordAbnormality,
            String placentalAbnormality, String fetalPositionAbnormality,
            String severePih, String intrauterineDistress, String asphyxia,
            String deformity, String deformityName, Integer birthWeight,
            String fetusStatus, String deathPlaceType, String deathDiagnosis,
            String diagnosisBasis, String auditSuggest, String deathSummary,
            String fillOperatorName, Date createDate, Date deathDtime,
            Integer isCancel, String createOrgId, String orgName, String creatorId,
            String creator, Date createTime, String modifiedOrgId,
            String modifiedOrgName, String modifierId, String modifier,
            Date modifiedTime) {
        this.childPerinatalDeathId = childPerinatalDeathId;
        this.childPerinatalDeathNo = childPerinatalDeathNo;
        this.personInfoId = personInfoId;
        this.resiCaseNo = resiCaseNo;
        this.hospitalCode = hospitalCode;
        this.presentAddress = presentAddress;
        this.provinceHouseholdFlag = provinceHouseholdFlag;
        this.planType = planType;
        this.motherName = motherName;
        this.motherAge = motherAge;
        this.motherEducationCode = motherEducationCode;
        this.motherOccupCode = motherOccupCode;
        this.fatherName = fatherName;
        this.fatherEducationCode = fatherEducationCode;
        this.fatherOccupCode = fatherOccupCode;
        this.familyIncome = familyIncome;
        this.permanentTypeCode = permanentTypeCode;
        this.gravidity = gravidity;
        this.parity = parity;
        this.spontaneousAbortion = spontaneousAbortion;
        this.inducedAbortion = inducedAbortion;
        this.medicalAbortion = medicalAbortion;
        this.labourInduction = labourInduction;
        this.deathFetus = deathFetus;
        this.deathDelivery = deathDelivery;
        this.newbornDeath = newbornDeath;
        this.liveBirth = liveBirth;
        this.pregnancyWeek = pregnancyWeek;
        this.earlyPregnancyExam = earlyPregnancyExam;
        this.midPregnancyExam = midPregnancyExam;
        this.latePregnancyExam = latePregnancyExam;
        this.pregnancyHealth = pregnancyHealth;
        this.pregnancyDrug = pregnancyDrug;
        this.pregnancyDrugName = pregnancyDrugName;
        this.detrimental = detrimental;
        this.detrimentalName = detrimentalName;
        this.intrauterineInfection = intrauterineInfection;
        this.pregnancyComplicationCode = pregnancyComplicationCode;
        this.preeclampsia = preeclampsia;
        this.iugr = iugr;
        this.hydramnion = hydramnion;
        this.hypamnion = hypamnion;
        this.hemorrhage = hemorrhage;
        this.pregnancyCompliCode = pregnancyCompliCode;
        this.cardiopathy = cardiopathy;
        this.hepatopathy = hepatopathy;
        this.hyperthyrodism = hyperthyrodism;
        this.anemia = anemia;
        this.urinarySystem = urinarySystem;
        this.traumaHistoryCode = traumaHistoryCode;
        this.highRiskPregnancy = highRiskPregnancy;
        this.highRiskRecord = highRiskRecord;
        this.localDelivery = localDelivery;
        this.deliveryHospital = deliveryHospital;
        this.deliveryHospitalOther = deliveryHospitalOther;
        this.deliveryWay = deliveryWay;
        this.noResiDelivery = noResiDelivery;
        this.midwife = midwife;
        this.deliveryTime = deliveryTime;
        this.deliveryPregnancyWeek = deliveryPregnancyWeek;
        this.fetusTypeCode = fetusTypeCode;
        this.sexCode = sexCode;
        this.deliverySituation = deliverySituation;
        this.deliveryHydramnion = deliveryHydramnion;
        this.deliveryHypamnion = deliveryHypamnion;
        this.membranePrematureRupture = membranePrematureRupture;
        this.prolongedLabor = prolongedLabor;
        this.umbilialCordAbnormality = umbilialCordAbnormality;
        this.placentalAbnormality = placentalAbnormality;
        this.fetalPositionAbnormality = fetalPositionAbnormality;
        this.severePih = severePih;
        this.intrauterineDistress = intrauterineDistress;
        this.asphyxia = asphyxia;
        this.deformity = deformity;
        this.deformityName = deformityName;
        this.birthWeight = birthWeight;
        this.fetusStatus = fetusStatus;
        this.deathPlaceType = deathPlaceType;
        this.deathDiagnosis = deathDiagnosis;
        this.diagnosisBasis = diagnosisBasis;
        this.auditSuggest = auditSuggest;
        this.deathSummary = deathSummary;
        this.fillOperatorName = fillOperatorName;
        this.createDate = createDate;
        this.deathDtime = deathDtime;
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

    @Generated(hash = 1474571160)
    public ChildPerinatalDeath() {
    }


}