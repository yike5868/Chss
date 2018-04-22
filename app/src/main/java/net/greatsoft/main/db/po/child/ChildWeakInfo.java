package net.greatsoft.main.db.po.child;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
/**
 * 
 * @author AlphGo
 * @date 2016年7月19日 下午12:06:42 
 * @Description: 高危儿童专案
 *
 */
@Entity
public class ChildWeakInfo extends Entry{
    /**
     * 高危儿童专案ID
     */
    private String childWeakInfoId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;

    /**
     * 高危儿童专案编号
     */
    
    private String childWeakInfoNo;

    /**
     * 专案管理项目
     */
    
    private String infoType;

    /**
     * 专案管理项目其他
     */
    
    private String infoTypeOther;

    /**
     * 出生史-早产
     */
    
    private String bornHistoryEarly;

    /**
     * 出生史-低出生体重
     */
    
    private String bornHistoryLessWeight;

    /**
     * 出生史-多胎
     */
    
    private String bornHistoryFetusMore;

    /**
     * 母孕期贫血情况-孕周
     */
    private Integer pregnancyAnemiaWeek;

    /**
     * 母孕期贫血情况-Hb
     */
    private Integer pregnancyAnemiaHb;

    /**
     * 母孕期和哺乳期-未补充VitD
     */
    
    private String pregnancyBreastNotakevitd;

    /**
     * 母孕期和哺乳期-日照不足
     */
    
    private String pregnancyBreastLesssunshine;

    /**
     * 母孕期和哺乳期-下肢痉挛
     */
    
    private String pregnancyBreastSpasm;

    /**
     * 铁剂治疗
     */
    
    private String ferralis;

    /**
     * 服用VitD
     */
    
    private String takeVitd;

    /**
     * 开始服用VitD年龄-月
     */
    private Integer takeVitdAgeMonth;

    /**
     * 开始服用VitD年龄-天
     */
    private Integer takeVitdAgeDay;

    /**
     * 药物名称
     */
    
    private String medicineName;

    /**
     * 剂量
     */
    
    private Double dosage;

    /**
     * 剂量单位
     */
    
    private String dosageUnit;

    /**
     * 疗程周数
     */
    private Integer courseWeek;

    /**
     * 母乳喂养情况
     */
    
    private String feedCondition;

    /**
     * 儿童开始转换食物年龄
     */
    private Integer changeFoodAge;

    /**
     * 既往疾病史
     */
    private String illness;

    /**
     * 体征-方颅
     */
    
    private String signCaputQuadratum;

    /**
     * 体征-肋骨串珠
     */
    
    private String signRachiticrosary;

    /**
     * 体征-肋软骨沟
     */
    
    private String signCartilageSulcus;

    /**
     * 体征-鸡胸
     */
    
    private String signPectusCarinatum;

    /**
     * 体征-手(足)镯
     */
    
    private String signScleromata;

    /**
     * 体征-X型腿
     */
    
    private String signBakerLeg;

    /**
     * 体征-O型腿
     */
    
    private String signBandyLeg;

    /**
     * 血液检查-血钙
     */
    
    private String bloodCalcuim;

    /**
     * 血液检查-血磷
     */
    
    private String bloodPhosphorus;

    /**
     * 血液检查-血AKP
     */
    
    private String bloodAkp;

    /**
     * 血液检查-血25-(OH)D
     */
    
    private String blood25ohd;

    /**
     * X线检查
     */
    
    private String xRatios;

    /**
     * 喂养史
     */
    private String feedHistory;

    /**
     * 疾病诊断
     */
    private String weakDiagnosis;

    /**
     * 追访结果
     */
    
    private String followupResult;

    /**
     * 评估
     */
    
    private String evaluation;

    /**
     * 分度
     */
    
    private String weakLevel;

    /**
     * 立案日期
     */
    
    
    private Date createDate;

    /**
     * 结案日期
     */
    
    
    private Date weakFinishDate;

    /**
     * 结案转归代码
     */
    
    private String weakTransfer;

    /**
     * 转诊单位名称
     */
    
    private String refferalOrgName;

    /**
     * 结案转归其他
     */
    
    private String weakTransferOther;

    /**
     * 结案医师姓名
     */
    private String finishOperatorName;

    /**
     * 结案单位名称
     */
    private String finishOrgName;

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

    public String getFinishOrgName() {
        return this.finishOrgName;
    }

    public void setFinishOrgName(String finishOrgName) {
        this.finishOrgName = finishOrgName;
    }

    public String getFinishOperatorName() {
        return this.finishOperatorName;
    }

    public void setFinishOperatorName(String finishOperatorName) {
        this.finishOperatorName = finishOperatorName;
    }

    public String getWeakTransferOther() {
        return this.weakTransferOther;
    }

    public void setWeakTransferOther(String weakTransferOther) {
        this.weakTransferOther = weakTransferOther;
    }

    public String getRefferalOrgName() {
        return this.refferalOrgName;
    }

    public void setRefferalOrgName(String refferalOrgName) {
        this.refferalOrgName = refferalOrgName;
    }

    public String getWeakTransfer() {
        return this.weakTransfer;
    }

    public void setWeakTransfer(String weakTransfer) {
        this.weakTransfer = weakTransfer;
    }

    public Date getWeakFinishDate() {
        return this.weakFinishDate;
    }

    public void setWeakFinishDate(Date weakFinishDate) {
        this.weakFinishDate = weakFinishDate;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getWeakLevel() {
        return this.weakLevel;
    }

    public void setWeakLevel(String weakLevel) {
        this.weakLevel = weakLevel;
    }

    public String getEvaluation() {
        return this.evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getFollowupResult() {
        return this.followupResult;
    }

    public void setFollowupResult(String followupResult) {
        this.followupResult = followupResult;
    }

    public String getWeakDiagnosis() {
        return this.weakDiagnosis;
    }

    public void setWeakDiagnosis(String weakDiagnosis) {
        this.weakDiagnosis = weakDiagnosis;
    }

    public String getFeedHistory() {
        return this.feedHistory;
    }

    public void setFeedHistory(String feedHistory) {
        this.feedHistory = feedHistory;
    }

    public String getXRatios() {
        return this.xRatios;
    }

    public void setXRatios(String xRatios) {
        this.xRatios = xRatios;
    }

    public String getBlood25ohd() {
        return this.blood25ohd;
    }

    public void setBlood25ohd(String blood25ohd) {
        this.blood25ohd = blood25ohd;
    }

    public String getBloodAkp() {
        return this.bloodAkp;
    }

    public void setBloodAkp(String bloodAkp) {
        this.bloodAkp = bloodAkp;
    }

    public String getBloodPhosphorus() {
        return this.bloodPhosphorus;
    }

    public void setBloodPhosphorus(String bloodPhosphorus) {
        this.bloodPhosphorus = bloodPhosphorus;
    }

    public String getBloodCalcuim() {
        return this.bloodCalcuim;
    }

    public void setBloodCalcuim(String bloodCalcuim) {
        this.bloodCalcuim = bloodCalcuim;
    }

    public String getSignBandyLeg() {
        return this.signBandyLeg;
    }

    public void setSignBandyLeg(String signBandyLeg) {
        this.signBandyLeg = signBandyLeg;
    }

    public String getSignBakerLeg() {
        return this.signBakerLeg;
    }

    public void setSignBakerLeg(String signBakerLeg) {
        this.signBakerLeg = signBakerLeg;
    }

    public String getSignScleromata() {
        return this.signScleromata;
    }

    public void setSignScleromata(String signScleromata) {
        this.signScleromata = signScleromata;
    }

    public String getSignPectusCarinatum() {
        return this.signPectusCarinatum;
    }

    public void setSignPectusCarinatum(String signPectusCarinatum) {
        this.signPectusCarinatum = signPectusCarinatum;
    }

    public String getSignCartilageSulcus() {
        return this.signCartilageSulcus;
    }

    public void setSignCartilageSulcus(String signCartilageSulcus) {
        this.signCartilageSulcus = signCartilageSulcus;
    }

    public String getSignRachiticrosary() {
        return this.signRachiticrosary;
    }

    public void setSignRachiticrosary(String signRachiticrosary) {
        this.signRachiticrosary = signRachiticrosary;
    }

    public String getSignCaputQuadratum() {
        return this.signCaputQuadratum;
    }

    public void setSignCaputQuadratum(String signCaputQuadratum) {
        this.signCaputQuadratum = signCaputQuadratum;
    }

    public String getIllness() {
        return this.illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public Integer getChangeFoodAge() {
        return this.changeFoodAge;
    }

    public void setChangeFoodAge(Integer changeFoodAge) {
        this.changeFoodAge = changeFoodAge;
    }

    public String getFeedCondition() {
        return this.feedCondition;
    }

    public void setFeedCondition(String feedCondition) {
        this.feedCondition = feedCondition;
    }

    public Integer getCourseWeek() {
        return this.courseWeek;
    }

    public void setCourseWeek(Integer courseWeek) {
        this.courseWeek = courseWeek;
    }

    public String getDosageUnit() {
        return this.dosageUnit;
    }

    public void setDosageUnit(String dosageUnit) {
        this.dosageUnit = dosageUnit;
    }

    public Double getDosage() {
        return this.dosage;
    }

    public void setDosage(Double dosage) {
        this.dosage = dosage;
    }

    public String getMedicineName() {
        return this.medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getTakeVitdAgeDay() {
        return this.takeVitdAgeDay;
    }

    public void setTakeVitdAgeDay(Integer takeVitdAgeDay) {
        this.takeVitdAgeDay = takeVitdAgeDay;
    }

    public Integer getTakeVitdAgeMonth() {
        return this.takeVitdAgeMonth;
    }

    public void setTakeVitdAgeMonth(Integer takeVitdAgeMonth) {
        this.takeVitdAgeMonth = takeVitdAgeMonth;
    }

    public String getTakeVitd() {
        return this.takeVitd;
    }

    public void setTakeVitd(String takeVitd) {
        this.takeVitd = takeVitd;
    }

    public String getFerralis() {
        return this.ferralis;
    }

    public void setFerralis(String ferralis) {
        this.ferralis = ferralis;
    }

    public String getPregnancyBreastSpasm() {
        return this.pregnancyBreastSpasm;
    }

    public void setPregnancyBreastSpasm(String pregnancyBreastSpasm) {
        this.pregnancyBreastSpasm = pregnancyBreastSpasm;
    }

    public String getPregnancyBreastLesssunshine() {
        return this.pregnancyBreastLesssunshine;
    }

    public void setPregnancyBreastLesssunshine(String pregnancyBreastLesssunshine) {
        this.pregnancyBreastLesssunshine = pregnancyBreastLesssunshine;
    }

    public String getPregnancyBreastNotakevitd() {
        return this.pregnancyBreastNotakevitd;
    }

    public void setPregnancyBreastNotakevitd(String pregnancyBreastNotakevitd) {
        this.pregnancyBreastNotakevitd = pregnancyBreastNotakevitd;
    }

    public Integer getPregnancyAnemiaHb() {
        return this.pregnancyAnemiaHb;
    }

    public void setPregnancyAnemiaHb(Integer pregnancyAnemiaHb) {
        this.pregnancyAnemiaHb = pregnancyAnemiaHb;
    }

    public Integer getPregnancyAnemiaWeek() {
        return this.pregnancyAnemiaWeek;
    }

    public void setPregnancyAnemiaWeek(Integer pregnancyAnemiaWeek) {
        this.pregnancyAnemiaWeek = pregnancyAnemiaWeek;
    }

    public String getBornHistoryFetusMore() {
        return this.bornHistoryFetusMore;
    }

    public void setBornHistoryFetusMore(String bornHistoryFetusMore) {
        this.bornHistoryFetusMore = bornHistoryFetusMore;
    }

    public String getBornHistoryLessWeight() {
        return this.bornHistoryLessWeight;
    }

    public void setBornHistoryLessWeight(String bornHistoryLessWeight) {
        this.bornHistoryLessWeight = bornHistoryLessWeight;
    }

    public String getBornHistoryEarly() {
        return this.bornHistoryEarly;
    }

    public void setBornHistoryEarly(String bornHistoryEarly) {
        this.bornHistoryEarly = bornHistoryEarly;
    }

    public String getInfoTypeOther() {
        return this.infoTypeOther;
    }

    public void setInfoTypeOther(String infoTypeOther) {
        this.infoTypeOther = infoTypeOther;
    }

    public String getInfoType() {
        return this.infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getChildWeakInfoNo() {
        return this.childWeakInfoNo;
    }

    public void setChildWeakInfoNo(String childWeakInfoNo) {
        this.childWeakInfoNo = childWeakInfoNo;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getChildWeakInfoId() {
        return this.childWeakInfoId;
    }

    public void setChildWeakInfoId(String childWeakInfoId) {
        this.childWeakInfoId = childWeakInfoId;
    }

    @Generated(hash = 774805556)
    public ChildWeakInfo(String childWeakInfoId, String personInfoId,
            String childWeakInfoNo, String infoType, String infoTypeOther,
            String bornHistoryEarly, String bornHistoryLessWeight,
            String bornHistoryFetusMore, Integer pregnancyAnemiaWeek,
            Integer pregnancyAnemiaHb, String pregnancyBreastNotakevitd,
            String pregnancyBreastLesssunshine, String pregnancyBreastSpasm,
            String ferralis, String takeVitd, Integer takeVitdAgeMonth,
            Integer takeVitdAgeDay, String medicineName, Double dosage,
            String dosageUnit, Integer courseWeek, String feedCondition,
            Integer changeFoodAge, String illness, String signCaputQuadratum,
            String signRachiticrosary, String signCartilageSulcus,
            String signPectusCarinatum, String signScleromata, String signBakerLeg,
            String signBandyLeg, String bloodCalcuim, String bloodPhosphorus,
            String bloodAkp, String blood25ohd, String xRatios, String feedHistory,
            String weakDiagnosis, String followupResult, String evaluation,
            String weakLevel, Date createDate, Date weakFinishDate,
            String weakTransfer, String refferalOrgName, String weakTransferOther,
            String finishOperatorName, String finishOrgName, Integer isCancel,
            String createOrgId, String orgName, String creatorId, String creator,
            Date createTime, String modifiedOrgId, String modifiedOrgName,
            String modifierId, String modifier, Date modifiedTime) {
        this.childWeakInfoId = childWeakInfoId;
        this.personInfoId = personInfoId;
        this.childWeakInfoNo = childWeakInfoNo;
        this.infoType = infoType;
        this.infoTypeOther = infoTypeOther;
        this.bornHistoryEarly = bornHistoryEarly;
        this.bornHistoryLessWeight = bornHistoryLessWeight;
        this.bornHistoryFetusMore = bornHistoryFetusMore;
        this.pregnancyAnemiaWeek = pregnancyAnemiaWeek;
        this.pregnancyAnemiaHb = pregnancyAnemiaHb;
        this.pregnancyBreastNotakevitd = pregnancyBreastNotakevitd;
        this.pregnancyBreastLesssunshine = pregnancyBreastLesssunshine;
        this.pregnancyBreastSpasm = pregnancyBreastSpasm;
        this.ferralis = ferralis;
        this.takeVitd = takeVitd;
        this.takeVitdAgeMonth = takeVitdAgeMonth;
        this.takeVitdAgeDay = takeVitdAgeDay;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.dosageUnit = dosageUnit;
        this.courseWeek = courseWeek;
        this.feedCondition = feedCondition;
        this.changeFoodAge = changeFoodAge;
        this.illness = illness;
        this.signCaputQuadratum = signCaputQuadratum;
        this.signRachiticrosary = signRachiticrosary;
        this.signCartilageSulcus = signCartilageSulcus;
        this.signPectusCarinatum = signPectusCarinatum;
        this.signScleromata = signScleromata;
        this.signBakerLeg = signBakerLeg;
        this.signBandyLeg = signBandyLeg;
        this.bloodCalcuim = bloodCalcuim;
        this.bloodPhosphorus = bloodPhosphorus;
        this.bloodAkp = bloodAkp;
        this.blood25ohd = blood25ohd;
        this.xRatios = xRatios;
        this.feedHistory = feedHistory;
        this.weakDiagnosis = weakDiagnosis;
        this.followupResult = followupResult;
        this.evaluation = evaluation;
        this.weakLevel = weakLevel;
        this.createDate = createDate;
        this.weakFinishDate = weakFinishDate;
        this.weakTransfer = weakTransfer;
        this.refferalOrgName = refferalOrgName;
        this.weakTransferOther = weakTransferOther;
        this.finishOperatorName = finishOperatorName;
        this.finishOrgName = finishOrgName;
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

    @Generated(hash = 2005483823)
    public ChildWeakInfo() {
    }


}