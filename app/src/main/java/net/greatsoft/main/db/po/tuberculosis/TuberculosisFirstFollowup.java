package net.greatsoft.main.db.po.tuberculosis;

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
 * @date 2016年7月6日 下午6:02:32
 * @Description: 肺结核患者第一次入户随访
 */
@Entity
public class TuberculosisFirstFollowup extends Entry {
    /**
     * 肺结核患者随访ID
     */

    private String tuberculosisFirstFollowupId;

    /**
     * 肺结核档案ID
     */

    private String tuberculosisInfoId;

    /**
     * 个人档案ID
     */

    private String personInfoId;

    /**
     * 肺结核患者随访编号
     */

    private String tuberculosisFirstFollowupNo;

    /**
     * 本人姓名
     */

    private String name;

    /**
     * 本次随访日期
     */


    private Date followupDate;

    /**
     * 随访方式代码
     */

    private String followupWayCode;

    /**
     * 患者类型代码
     */

    private String patientTypeCode;

    /**
     * 痰菌情况代码
     */

    private String sputumCode;

    /**
     * 耐药情况代码
     */

    private String drugResistanceCode;

    /**
     * 化疗方案
     */

    private String chemotherapyCode;

    /**
     * 化疗方案结果
     */
    private String chemotherapyValue;

    /**
     * 药物用法代码
     */

    private String drugUseCode;

    /**
     * 督导人员选择代码
     */

    private String supervisorKindCode;

    /**
     * 单独的居室代码
     */

    private String separateRoomCode;

    /**
     * 通风情况代码
     */

    private String ventilationCode;

    /**
     * 日吸烟量（支）
     */
    private Integer dailySmoking;

    /**
     * 目标日吸烟量(支）
     */
    private Integer aimDailySmoking;

    /**
     * 日饮酒量（两）
     */
    private Integer dailyDrinking;

    /**
     * 目标日饮酒量（两）
     */
    private Integer aimDailyDrinking;

    /**
     * 取药地点
     */
    private String getMedicinePlace;

    /**
     * 取药时间
     */


    private Date getMedicineDate;

    /**
     * 服药记录卡的填写代码
     */

    private String medicationRecCardCode;

    /**
     * 服药方法及药品存放代码
     */

    private String drugLimitCode;

    /**
     * 肺结核治疗疗程代码
     */

    private String treatmentCourseCode;

    /**
     * 不规律服药危害代码
     */

    private String irregularMedicationCode;

    /**
     * 服药后不良反应及处理代码(adverseReactionTreatmentCode)
     */

    private String artCode;
    /**
     * 治疗期间复诊查痰代码
     */

    private String treatmentSputumCode;

    /**
     * 外出期间如何坚持服药代码
     */

    private String adhereMedicationCode;

    /**
     * 生活习惯及注意事项代码
     */

    private String livingHabitsCode;

    /**
     * 密切接触者检查代码
     */

    private String closeContactCheckCode;

    /**
     * 下次随访日期
     */


    private Date nextFollowupDate;

    /**
     * 本次随访医师ID
     */

    private String followupDoctorId;

    /**
     * 本次随访医师姓名
     */

    private String followupDoctorName;

    /**
     * 是否删除
     */
    private Integer isCancel;

    /**
     * 建档机构ID
     */

    private String createOrgId;

    /**
     * 建档机构名称
     */

    private String orgName;

    /**
     * 建档人ID
     */

    private String creatorId;

    /**
     * 建档人姓名
     */

    private String creator;

    /**
     * 建档时间
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
     * 选项指标记录，用来前后交互传输数据使用的
     */
    @Transient
    private List<RecordChoice> recordChoice;

    public List<RecordChoice> getRecordChoice() {
        return recordChoice;
    }

    public void setRecordChoice(List<RecordChoice> recordChoice) {
        this.recordChoice = recordChoice;
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


    public String getFollowupDoctorName() {
        return this.followupDoctorName;
    }


    public void setFollowupDoctorName(String followupDoctorName) {
        this.followupDoctorName = followupDoctorName;
    }


    public String getFollowupDoctorId() {
        return this.followupDoctorId;
    }


    public void setFollowupDoctorId(String followupDoctorId) {
        this.followupDoctorId = followupDoctorId;
    }


    public Date getNextFollowupDate() {
        return this.nextFollowupDate;
    }


    public void setNextFollowupDate(Date nextFollowupDate) {
        this.nextFollowupDate = nextFollowupDate;
    }


    public String getCloseContactCheckCode() {
        return this.closeContactCheckCode;
    }


    public void setCloseContactCheckCode(String closeContactCheckCode) {
        this.closeContactCheckCode = closeContactCheckCode;
    }


    public String getLivingHabitsCode() {
        return this.livingHabitsCode;
    }


    public void setLivingHabitsCode(String livingHabitsCode) {
        this.livingHabitsCode = livingHabitsCode;
    }


    public String getAdhereMedicationCode() {
        return this.adhereMedicationCode;
    }


    public void setAdhereMedicationCode(String adhereMedicationCode) {
        this.adhereMedicationCode = adhereMedicationCode;
    }


    public String getTreatmentSputumCode() {
        return this.treatmentSputumCode;
    }


    public void setTreatmentSputumCode(String treatmentSputumCode) {
        this.treatmentSputumCode = treatmentSputumCode;
    }


    public String getArtCode() {
        return this.artCode;
    }


    public void setArtCode(String artCode) {
        this.artCode = artCode;
    }


    public String getIrregularMedicationCode() {
        return this.irregularMedicationCode;
    }


    public void setIrregularMedicationCode(String irregularMedicationCode) {
        this.irregularMedicationCode = irregularMedicationCode;
    }


    public String getTreatmentCourseCode() {
        return this.treatmentCourseCode;
    }


    public void setTreatmentCourseCode(String treatmentCourseCode) {
        this.treatmentCourseCode = treatmentCourseCode;
    }


    public String getDrugLimitCode() {
        return this.drugLimitCode;
    }


    public void setDrugLimitCode(String drugLimitCode) {
        this.drugLimitCode = drugLimitCode;
    }


    public String getMedicationRecCardCode() {
        return this.medicationRecCardCode;
    }


    public void setMedicationRecCardCode(String medicationRecCardCode) {
        this.medicationRecCardCode = medicationRecCardCode;
    }


    public Date getGetMedicineDate() {
        return this.getMedicineDate;
    }


    public void setGetMedicineDate(Date getMedicineDate) {
        this.getMedicineDate = getMedicineDate;
    }


    public String getGetMedicinePlace() {
        return this.getMedicinePlace;
    }


    public void setGetMedicinePlace(String getMedicinePlace) {
        this.getMedicinePlace = getMedicinePlace;
    }


    public Integer getAimDailyDrinking() {
        return this.aimDailyDrinking;
    }


    public void setAimDailyDrinking(Integer aimDailyDrinking) {
        this.aimDailyDrinking = aimDailyDrinking;
    }


    public Integer getDailyDrinking() {
        return this.dailyDrinking;
    }


    public void setDailyDrinking(Integer dailyDrinking) {
        this.dailyDrinking = dailyDrinking;
    }


    public Integer getAimDailySmoking() {
        return this.aimDailySmoking;
    }


    public void setAimDailySmoking(Integer aimDailySmoking) {
        this.aimDailySmoking = aimDailySmoking;
    }


    public Integer getDailySmoking() {
        return this.dailySmoking;
    }


    public void setDailySmoking(Integer dailySmoking) {
        this.dailySmoking = dailySmoking;
    }


    public String getVentilationCode() {
        return this.ventilationCode;
    }


    public void setVentilationCode(String ventilationCode) {
        this.ventilationCode = ventilationCode;
    }


    public String getSeparateRoomCode() {
        return this.separateRoomCode;
    }


    public void setSeparateRoomCode(String separateRoomCode) {
        this.separateRoomCode = separateRoomCode;
    }


    public String getSupervisorKindCode() {
        return this.supervisorKindCode;
    }


    public void setSupervisorKindCode(String supervisorKindCode) {
        this.supervisorKindCode = supervisorKindCode;
    }


    public String getDrugUseCode() {
        return this.drugUseCode;
    }


    public void setDrugUseCode(String drugUseCode) {
        this.drugUseCode = drugUseCode;
    }


    public String getChemotherapyValue() {
        return this.chemotherapyValue;
    }


    public void setChemotherapyValue(String chemotherapyValue) {
        this.chemotherapyValue = chemotherapyValue;
    }


    public String getChemotherapyCode() {
        return this.chemotherapyCode;
    }


    public void setChemotherapyCode(String chemotherapyCode) {
        this.chemotherapyCode = chemotherapyCode;
    }


    public String getDrugResistanceCode() {
        return this.drugResistanceCode;
    }


    public void setDrugResistanceCode(String drugResistanceCode) {
        this.drugResistanceCode = drugResistanceCode;
    }


    public String getSputumCode() {
        return this.sputumCode;
    }


    public void setSputumCode(String sputumCode) {
        this.sputumCode = sputumCode;
    }


    public String getPatientTypeCode() {
        return this.patientTypeCode;
    }


    public void setPatientTypeCode(String patientTypeCode) {
        this.patientTypeCode = patientTypeCode;
    }


    public String getFollowupWayCode() {
        return this.followupWayCode;
    }


    public void setFollowupWayCode(String followupWayCode) {
        this.followupWayCode = followupWayCode;
    }


    public Date getFollowupDate() {
        return this.followupDate;
    }


    public void setFollowupDate(Date followupDate) {
        this.followupDate = followupDate;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getTuberculosisFirstFollowupNo() {
        return this.tuberculosisFirstFollowupNo;
    }


    public void setTuberculosisFirstFollowupNo(String tuberculosisFirstFollowupNo) {
        this.tuberculosisFirstFollowupNo = tuberculosisFirstFollowupNo;
    }


    public String getPersonInfoId() {
        return this.personInfoId;
    }


    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }


    public String getTuberculosisInfoId() {
        return this.tuberculosisInfoId;
    }


    public void setTuberculosisInfoId(String tuberculosisInfoId) {
        this.tuberculosisInfoId = tuberculosisInfoId;
    }


    public String getTuberculosisFirstFollowupId() {
        return this.tuberculosisFirstFollowupId;
    }


    public void setTuberculosisFirstFollowupId(String tuberculosisFirstFollowupId) {
        this.tuberculosisFirstFollowupId = tuberculosisFirstFollowupId;
    }


    @Generated(hash = 752903818)
    public TuberculosisFirstFollowup(String tuberculosisFirstFollowupId,
                                     String tuberculosisInfoId, String personInfoId,
                                     String tuberculosisFirstFollowupNo, String name, Date followupDate,
                                     String followupWayCode, String patientTypeCode, String sputumCode,
                                     String drugResistanceCode, String chemotherapyCode, String chemotherapyValue,
                                     String drugUseCode, String supervisorKindCode, String separateRoomCode,
                                     String ventilationCode, Integer dailySmoking, Integer aimDailySmoking,
                                     Integer dailyDrinking, Integer aimDailyDrinking, String getMedicinePlace,
                                     Date getMedicineDate, String medicationRecCardCode, String drugLimitCode,
                                     String treatmentCourseCode, String irregularMedicationCode, String artCode,
                                     String treatmentSputumCode, String adhereMedicationCode,
                                     String livingHabitsCode, String closeContactCheckCode, Date nextFollowupDate,
                                     String followupDoctorId, String followupDoctorName, Integer isCancel,
                                     String createOrgId, String orgName, String creatorId, String creator,
                                     Date createTime, String modifiedOrgId, String modifiedOrgName,
                                     String modifierId, String modifier, Date modifiedTime) {
        this.tuberculosisFirstFollowupId = tuberculosisFirstFollowupId;
        this.tuberculosisInfoId = tuberculosisInfoId;
        this.personInfoId = personInfoId;
        this.tuberculosisFirstFollowupNo = tuberculosisFirstFollowupNo;
        this.name = name;
        this.followupDate = followupDate;
        this.followupWayCode = followupWayCode;
        this.patientTypeCode = patientTypeCode;
        this.sputumCode = sputumCode;
        this.drugResistanceCode = drugResistanceCode;
        this.chemotherapyCode = chemotherapyCode;
        this.chemotherapyValue = chemotherapyValue;
        this.drugUseCode = drugUseCode;
        this.supervisorKindCode = supervisorKindCode;
        this.separateRoomCode = separateRoomCode;
        this.ventilationCode = ventilationCode;
        this.dailySmoking = dailySmoking;
        this.aimDailySmoking = aimDailySmoking;
        this.dailyDrinking = dailyDrinking;
        this.aimDailyDrinking = aimDailyDrinking;
        this.getMedicinePlace = getMedicinePlace;
        this.getMedicineDate = getMedicineDate;
        this.medicationRecCardCode = medicationRecCardCode;
        this.drugLimitCode = drugLimitCode;
        this.treatmentCourseCode = treatmentCourseCode;
        this.irregularMedicationCode = irregularMedicationCode;
        this.artCode = artCode;
        this.treatmentSputumCode = treatmentSputumCode;
        this.adhereMedicationCode = adhereMedicationCode;
        this.livingHabitsCode = livingHabitsCode;
        this.closeContactCheckCode = closeContactCheckCode;
        this.nextFollowupDate = nextFollowupDate;
        this.followupDoctorId = followupDoctorId;
        this.followupDoctorName = followupDoctorName;
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


    @Generated(hash = 1801310167)
    @Keep
    public TuberculosisFirstFollowup() {
        recordChoice = new ArrayList<>();
    }


}
