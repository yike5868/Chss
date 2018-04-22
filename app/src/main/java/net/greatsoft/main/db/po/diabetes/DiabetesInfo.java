package net.greatsoft.main.db.po.diabetes;

import net.greatsoft.main.db.po.Entry;
import net.greatsoft.main.db.po.RecordChoice;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Transient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hn
 * @date 2016年7月7日 下午1:09:25
 * @Description: 2型糖尿病患者专档
 */
@Entity
public class DiabetesInfo extends Entry {
    /**
     * 2型糖尿病患者专档ID
     */
    private String diabetesInfoId;

    /**
     * 个人档案ID
     */
    private String personInfoId;

    /**
     * 管理机构ID
     */
    private String manageOrgId;

    /**
     * 2型糖尿病患者专档编号
     */
    private String diabetesInfoNo;

    /**
     * 个人史
     */
    private String personalHistory;

    /**
     * 现病史
     */
    private String diseaseHistory;

    /**
     * 糖尿病家族史
     */
    private String dmFamilyHistory;

    /**
     * 过敏史
     */
    private String allergicHistory;

    /**
     * 确诊时间
     */
    private Date diagnoseDate;

    /**
     * 确诊方式
     */
    private String diagnoseModeCode;

    /**
     * 确诊单位
     */
    private String diagnoseOrgName;

    /**
     * 确诊时高血压标志
     */
    private String diagnoseHyperCode;

    /**
     * 药物名称及用量
     */
    private String medicationName;

    /**
     * 确诊时视网膜病变标志
     */
    private String diagnoseRetionopathyCode;

    /**
     * 确诊时糖尿病足标志
     */
    private String diagnoseDmFootCode;

    /**
     * 确诊时糖尿病肾病标志
     */
    private String diagnoseDnCode;

    /**
     * 确诊时糖尿病神经病变标志
     */
    private String diagnoseNeuropathyCode;

    /**
     * 确诊时高血脂标志
     */
    private String diagnoseHyperlipidemiaCode;

    /**
     * 确诊时冠心病（心肌梗死）标志
     */
    private String diagnoseAmiCode;

    /**
     * 确诊时脑卒中标志
     */
    private String diagnoseStrokeCode;

    /**
     * 既往空腹血糖
     */
    private Double pastFbg;

    /**
     * 既往餐后2小时血糖
     */
    private Double pastPbg;

    /**
     * 既往糖化血红蛋白
     */
    private Double pastGhb;

    /**
     * 吸烟标志
     */
    private String smokingCode;

    /**
     * 日吸烟量（支）
     */
    private Integer dailySmoking;

    /**
     * 饮酒标志
     */
    private String drinkingCode;

    /**
     * 日饮酒量（两）
     */
    private Integer dailyDrinking;

    /**
     * 身高(cm)
     */
    private Double height;

    /**
     * 体重(kg)
     */
    private Double weight;

    /**
     * 体质指数
     */
    private Double bmi;

    /**
     * 空腹血糖值（mmol/L)
     */
    private Double fbg;

    /**
     * 餐后两小时血糖值（mmol/L)
     */
    private Double pbg;

    /**
     * 糖化血红蛋白值（％)
     */
    private Double ghb;

    /**
     * 甘油三酯值（mmol/L)
     */
    private Double tg;

    /**
     * 收缩压(mmHg)
     */
    private Integer sbp;

    /**
     * 舒张压(mmHg)
     */
    private Integer dbp;

    /**
     * 总胆固醇值（mmol/L)
     */
    private Double tcho;

    /**
     * 血清低密度脂蛋白胆固醇检测值（mmol/L)
     */
    private Double ldlc;

    /**
     * 血淸高密度脂蛋白胆固醇检测值(mmol/L)
     */
    private Double hdlc;

    /**
     * 视网膜病变
     */
    private String retionopathyCode;

    /**
     * 神经病变
     */
    private String neuropathyCode;

    /**
     * 糖尿病足
     */
    private String dmFootCode;

    /**
     * 尿微量白蛋白（mg/dL)
     */
    private Double urineMalb;

    /**
     * 饮食控制标志
     */
    private String dietControlCode;

    /**
     * 体力活动标志
     */
    private String exerciseCode;

    /**
     * 体力活动每周次数
     */
    private Integer exerciseFreqCode;

    /**
     * 体力活动每次分钟数
     */
    private Integer exerciseDurationMins;

    /**
     * 口服降糖药标志
     */
    private String takeMedicineCode;

    /**
     * 胰岛素标志
     */
    private String insulinCode;
    /**
     * 胰岛素种类
     */
    private String insulinType;

    /**
     * 胰岛素用量
     */
    private String insulinPerDose;

    /**
     * 戒烟标志
     */
    private String stopSmokingCode;

    /**
     * 限酒标志
     */
    private String limitAlcoholCode;

    /**
     * 最近随访日期
     */
    private Date lastVisitDate;

    /**
     * 下次预约日期
     */
    private Date nextVisitDate;

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

    /**
     * 单位电话
     */
    private String companyTel;

    /**
     * 家庭电话
     */
    private String familyTel;

    /**
     * 定点医疗单位
     */
    private String healthcareOrg;

    /**
     * 建档时间
     */
    private Date userCreateTime;

    /**
     * 建档医生Id
     */
    private String respDoctorId;

    /**
     * 建档医生姓名
     */
    private String respDoctorName;

    /**
     * 返回给前台使用的json串
     */
    private String jsonDetail;

    //籍贯
    private String householdRegister;

    @Transient
    List<RecordChoice> recordChoice;

    @Transient
    List<DiabetesInfoDrug> diabetesInfoDrug;

    @Transient
    List<DiabetesInfoComp> diabetesInfoComp;

    public List<RecordChoice> getRecordChoice() {
        return recordChoice;
    }

    public void setRecordChoice(List<RecordChoice> recordChoice) {
        this.recordChoice = recordChoice;
    }

    public List<DiabetesInfoDrug> getDiabetesInfoDrug() {
        return diabetesInfoDrug;
    }

    public void setDiabetesInfoDrug(List<DiabetesInfoDrug> diabetesInfoDrug) {
        this.diabetesInfoDrug = diabetesInfoDrug;
    }

    public List<DiabetesInfoComp> getDiabetesInfoComp() {
        return diabetesInfoComp;
    }

    public void setDiabetesInfoComp(List<DiabetesInfoComp> diabetesInfoComp) {
        this.diabetesInfoComp = diabetesInfoComp;
    }

    public String getHouseholdRegister() {
        return this.householdRegister;
    }

    public void setHouseholdRegister(String householdRegister) {
        this.householdRegister = householdRegister;
    }

    public String getJsonDetail() {
        return this.jsonDetail;
    }

    public void setJsonDetail(String jsonDetail) {
        this.jsonDetail = jsonDetail;
    }

    public String getRespDoctorName() {
        return this.respDoctorName;
    }

    public void setRespDoctorName(String respDoctorName) {
        this.respDoctorName = respDoctorName;
    }

    public String getRespDoctorId() {
        return this.respDoctorId;
    }

    public void setRespDoctorId(String respDoctorId) {
        this.respDoctorId = respDoctorId;
    }

    public Date getUserCreateTime() {
        return this.userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public String getHealthcareOrg() {
        return this.healthcareOrg;
    }

    public void setHealthcareOrg(String healthcareOrg) {
        this.healthcareOrg = healthcareOrg;
    }

    public String getFamilyTel() {
        return this.familyTel;
    }

    public void setFamilyTel(String familyTel) {
        this.familyTel = familyTel;
    }

    public String getCompanyTel() {
        return this.companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

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

    public Date getNextVisitDate() {
        return this.nextVisitDate;
    }

    public void setNextVisitDate(Date nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }

    public Date getLastVisitDate() {
        return this.lastVisitDate;
    }

    public void setLastVisitDate(Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getLimitAlcoholCode() {
        return this.limitAlcoholCode;
    }

    public void setLimitAlcoholCode(String limitAlcoholCode) {
        this.limitAlcoholCode = limitAlcoholCode;
    }

    public String getStopSmokingCode() {
        return this.stopSmokingCode;
    }

    public void setStopSmokingCode(String stopSmokingCode) {
        this.stopSmokingCode = stopSmokingCode;
    }

    public String getInsulinPerDose() {
        return this.insulinPerDose;
    }

    public void setInsulinPerDose(String insulinPerDose) {
        this.insulinPerDose = insulinPerDose;
    }

    public String getInsulinType() {
        return this.insulinType;
    }

    public void setInsulinType(String insulinType) {
        this.insulinType = insulinType;
    }

    public String getInsulinCode() {
        return this.insulinCode;
    }

    public void setInsulinCode(String insulinCode) {
        this.insulinCode = insulinCode;
    }

    public String getTakeMedicineCode() {
        return this.takeMedicineCode;
    }

    public void setTakeMedicineCode(String takeMedicineCode) {
        this.takeMedicineCode = takeMedicineCode;
    }

    public Integer getExerciseDurationMins() {
        return this.exerciseDurationMins;
    }

    public void setExerciseDurationMins(Integer exerciseDurationMins) {
        this.exerciseDurationMins = exerciseDurationMins;
    }

    public Integer getExerciseFreqCode() {
        return this.exerciseFreqCode;
    }

    public void setExerciseFreqCode(Integer exerciseFreqCode) {
        this.exerciseFreqCode = exerciseFreqCode;
    }

    public String getExerciseCode() {
        return this.exerciseCode;
    }

    public void setExerciseCode(String exerciseCode) {
        this.exerciseCode = exerciseCode;
    }

    public String getDietControlCode() {
        return this.dietControlCode;
    }

    public void setDietControlCode(String dietControlCode) {
        this.dietControlCode = dietControlCode;
    }

    public Double getUrineMalb() {
        return this.urineMalb;
    }

    public void setUrineMalb(Double urineMalb) {
        this.urineMalb = urineMalb;
    }

    public String getDmFootCode() {
        return this.dmFootCode;
    }

    public void setDmFootCode(String dmFootCode) {
        this.dmFootCode = dmFootCode;
    }

    public String getNeuropathyCode() {
        return this.neuropathyCode;
    }

    public void setNeuropathyCode(String neuropathyCode) {
        this.neuropathyCode = neuropathyCode;
    }

    public String getRetionopathyCode() {
        return this.retionopathyCode;
    }

    public void setRetionopathyCode(String retionopathyCode) {
        this.retionopathyCode = retionopathyCode;
    }

    public Double getHdlc() {
        return this.hdlc;
    }

    public void setHdlc(Double hdlc) {
        this.hdlc = hdlc;
    }

    public Double getLdlc() {
        return this.ldlc;
    }

    public void setLdlc(Double ldlc) {
        this.ldlc = ldlc;
    }

    public Double getTcho() {
        return this.tcho;
    }

    public void setTcho(Double tcho) {
        this.tcho = tcho;
    }

    public Integer getDbp() {
        return this.dbp;
    }

    public void setDbp(Integer dbp) {
        this.dbp = dbp;
    }

    public Integer getSbp() {
        return this.sbp;
    }

    public void setSbp(Integer sbp) {
        this.sbp = sbp;
    }

    public Double getTg() {
        return this.tg;
    }

    public void setTg(Double tg) {
        this.tg = tg;
    }

    public Double getGhb() {
        return this.ghb;
    }

    public void setGhb(Double ghb) {
        this.ghb = ghb;
    }

    public Double getPbg() {
        return this.pbg;
    }

    public void setPbg(Double pbg) {
        this.pbg = pbg;
    }

    public Double getFbg() {
        return this.fbg;
    }

    public void setFbg(Double fbg) {
        this.fbg = fbg;
    }

    public Double getBmi() {
        return this.bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getDailyDrinking() {
        return this.dailyDrinking;
    }

    public void setDailyDrinking(Integer dailyDrinking) {
        this.dailyDrinking = dailyDrinking;
    }

    public String getDrinkingCode() {
        return this.drinkingCode;
    }

    public void setDrinkingCode(String drinkingCode) {
        this.drinkingCode = drinkingCode;
    }

    public Integer getDailySmoking() {
        return this.dailySmoking;
    }

    public void setDailySmoking(Integer dailySmoking) {
        this.dailySmoking = dailySmoking;
    }

    public String getSmokingCode() {
        return this.smokingCode;
    }

    public void setSmokingCode(String smokingCode) {
        this.smokingCode = smokingCode;
    }

    public Double getPastGhb() {
        return this.pastGhb;
    }

    public void setPastGhb(Double pastGhb) {
        this.pastGhb = pastGhb;
    }

    public Double getPastPbg() {
        return this.pastPbg;
    }

    public void setPastPbg(Double pastPbg) {
        this.pastPbg = pastPbg;
    }

    public Double getPastFbg() {
        return this.pastFbg;
    }

    public void setPastFbg(Double pastFbg) {
        this.pastFbg = pastFbg;
    }

    public String getDiagnoseStrokeCode() {
        return this.diagnoseStrokeCode;
    }

    public void setDiagnoseStrokeCode(String diagnoseStrokeCode) {
        this.diagnoseStrokeCode = diagnoseStrokeCode;
    }

    public String getDiagnoseAmiCode() {
        return this.diagnoseAmiCode;
    }

    public void setDiagnoseAmiCode(String diagnoseAmiCode) {
        this.diagnoseAmiCode = diagnoseAmiCode;
    }

    public String getDiagnoseHyperlipidemiaCode() {
        return this.diagnoseHyperlipidemiaCode;
    }

    public void setDiagnoseHyperlipidemiaCode(String diagnoseHyperlipidemiaCode) {
        this.diagnoseHyperlipidemiaCode = diagnoseHyperlipidemiaCode;
    }

    public String getDiagnoseNeuropathyCode() {
        return this.diagnoseNeuropathyCode;
    }

    public void setDiagnoseNeuropathyCode(String diagnoseNeuropathyCode) {
        this.diagnoseNeuropathyCode = diagnoseNeuropathyCode;
    }

    public String getDiagnoseDnCode() {
        return this.diagnoseDnCode;
    }

    public void setDiagnoseDnCode(String diagnoseDnCode) {
        this.diagnoseDnCode = diagnoseDnCode;
    }

    public String getDiagnoseDmFootCode() {
        return this.diagnoseDmFootCode;
    }

    public void setDiagnoseDmFootCode(String diagnoseDmFootCode) {
        this.diagnoseDmFootCode = diagnoseDmFootCode;
    }

    public String getDiagnoseRetionopathyCode() {
        return this.diagnoseRetionopathyCode;
    }

    public void setDiagnoseRetionopathyCode(String diagnoseRetionopathyCode) {
        this.diagnoseRetionopathyCode = diagnoseRetionopathyCode;
    }

    public String getMedicationName() {
        return this.medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDiagnoseHyperCode() {
        return this.diagnoseHyperCode;
    }

    public void setDiagnoseHyperCode(String diagnoseHyperCode) {
        this.diagnoseHyperCode = diagnoseHyperCode;
    }

    public String getDiagnoseOrgName() {
        return this.diagnoseOrgName;
    }

    public void setDiagnoseOrgName(String diagnoseOrgName) {
        this.diagnoseOrgName = diagnoseOrgName;
    }

    public String getDiagnoseModeCode() {
        return this.diagnoseModeCode;
    }

    public void setDiagnoseModeCode(String diagnoseModeCode) {
        this.diagnoseModeCode = diagnoseModeCode;
    }

    public Date getDiagnoseDate() {
        return this.diagnoseDate;
    }

    public void setDiagnoseDate(Date diagnoseDate) {
        this.diagnoseDate = diagnoseDate;
    }

    public String getAllergicHistory() {
        return this.allergicHistory;
    }

    public void setAllergicHistory(String allergicHistory) {
        this.allergicHistory = allergicHistory;
    }

    public String getDmFamilyHistory() {
        return this.dmFamilyHistory;
    }

    public void setDmFamilyHistory(String dmFamilyHistory) {
        this.dmFamilyHistory = dmFamilyHistory;
    }

    public String getDiseaseHistory() {
        return this.diseaseHistory;
    }

    public void setDiseaseHistory(String diseaseHistory) {
        this.diseaseHistory = diseaseHistory;
    }

    public String getPersonalHistory() {
        return this.personalHistory;
    }

    public void setPersonalHistory(String personalHistory) {
        this.personalHistory = personalHistory;
    }

    public String getDiabetesInfoNo() {
        return this.diabetesInfoNo;
    }

    public void setDiabetesInfoNo(String diabetesInfoNo) {
        this.diabetesInfoNo = diabetesInfoNo;
    }

    public String getManageOrgId() {
        return this.manageOrgId;
    }

    public void setManageOrgId(String manageOrgId) {
        this.manageOrgId = manageOrgId;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getDiabetesInfoId() {
        return this.diabetesInfoId;
    }

    public void setDiabetesInfoId(String diabetesInfoId) {
        this.diabetesInfoId = diabetesInfoId;
    }

    @Generated(hash = 108675820)
    public DiabetesInfo(String diabetesInfoId, String personInfoId,
                        String manageOrgId, String diabetesInfoNo, String personalHistory,
                        String diseaseHistory, String dmFamilyHistory, String allergicHistory,
                        Date diagnoseDate, String diagnoseModeCode, String diagnoseOrgName,
                        String diagnoseHyperCode, String medicationName,
                        String diagnoseRetionopathyCode, String diagnoseDmFootCode,
                        String diagnoseDnCode, String diagnoseNeuropathyCode,
                        String diagnoseHyperlipidemiaCode, String diagnoseAmiCode,
                        String diagnoseStrokeCode, Double pastFbg, Double pastPbg, Double pastGhb,
                        String smokingCode, Integer dailySmoking, String drinkingCode,
                        Integer dailyDrinking, Double height, Double weight, Double bmi, Double fbg,
                        Double pbg, Double ghb, Double tg, Integer sbp, Integer dbp, Double tcho,
                        Double ldlc, Double hdlc, String retionopathyCode, String neuropathyCode,
                        String dmFootCode, Double urineMalb, String dietControlCode,
                        String exerciseCode, Integer exerciseFreqCode, Integer exerciseDurationMins,
                        String takeMedicineCode, String insulinCode, String insulinType,
                        String insulinPerDose, String stopSmokingCode, String limitAlcoholCode,
                        Date lastVisitDate, Date nextVisitDate, Integer isCancel, String createOrgId,
                        String orgName, String creatorId, String creator, Date createTime,
                        String modifiedOrgId, String modifiedOrgName, String modifierId,
                        String modifier, Date modifiedTime, String companyTel, String familyTel,
                        String healthcareOrg, Date userCreateTime, String respDoctorId,
                        String respDoctorName, String jsonDetail, String householdRegister) {
        this.diabetesInfoId = diabetesInfoId;
        this.personInfoId = personInfoId;
        this.manageOrgId = manageOrgId;
        this.diabetesInfoNo = diabetesInfoNo;
        this.personalHistory = personalHistory;
        this.diseaseHistory = diseaseHistory;
        this.dmFamilyHistory = dmFamilyHistory;
        this.allergicHistory = allergicHistory;
        this.diagnoseDate = diagnoseDate;
        this.diagnoseModeCode = diagnoseModeCode;
        this.diagnoseOrgName = diagnoseOrgName;
        this.diagnoseHyperCode = diagnoseHyperCode;
        this.medicationName = medicationName;
        this.diagnoseRetionopathyCode = diagnoseRetionopathyCode;
        this.diagnoseDmFootCode = diagnoseDmFootCode;
        this.diagnoseDnCode = diagnoseDnCode;
        this.diagnoseNeuropathyCode = diagnoseNeuropathyCode;
        this.diagnoseHyperlipidemiaCode = diagnoseHyperlipidemiaCode;
        this.diagnoseAmiCode = diagnoseAmiCode;
        this.diagnoseStrokeCode = diagnoseStrokeCode;
        this.pastFbg = pastFbg;
        this.pastPbg = pastPbg;
        this.pastGhb = pastGhb;
        this.smokingCode = smokingCode;
        this.dailySmoking = dailySmoking;
        this.drinkingCode = drinkingCode;
        this.dailyDrinking = dailyDrinking;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.fbg = fbg;
        this.pbg = pbg;
        this.ghb = ghb;
        this.tg = tg;
        this.sbp = sbp;
        this.dbp = dbp;
        this.tcho = tcho;
        this.ldlc = ldlc;
        this.hdlc = hdlc;
        this.retionopathyCode = retionopathyCode;
        this.neuropathyCode = neuropathyCode;
        this.dmFootCode = dmFootCode;
        this.urineMalb = urineMalb;
        this.dietControlCode = dietControlCode;
        this.exerciseCode = exerciseCode;
        this.exerciseFreqCode = exerciseFreqCode;
        this.exerciseDurationMins = exerciseDurationMins;
        this.takeMedicineCode = takeMedicineCode;
        this.insulinCode = insulinCode;
        this.insulinType = insulinType;
        this.insulinPerDose = insulinPerDose;
        this.stopSmokingCode = stopSmokingCode;
        this.limitAlcoholCode = limitAlcoholCode;
        this.lastVisitDate = lastVisitDate;
        this.nextVisitDate = nextVisitDate;
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
        this.companyTel = companyTel;
        this.familyTel = familyTel;
        this.healthcareOrg = healthcareOrg;
        this.userCreateTime = userCreateTime;
        this.respDoctorId = respDoctorId;
        this.respDoctorName = respDoctorName;
        this.jsonDetail = jsonDetail;
        this.householdRegister = householdRegister;
    }

    @Generated(hash = 1615769437)
    @Keep
    public DiabetesInfo() {
        recordChoice = new ArrayList<>();
        diabetesInfoDrug = new ArrayList<>();
        diabetesInfoComp = new ArrayList<>();
    }


}