package net.greatsoft.main.db.po.child;


import net.greatsoft.main.db.po.Entry;
import net.greatsoft.main.db.po.RecordChoice;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Transient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年7月19日 下午12:17:26 
 * @Description: 儿童健康检查
 *
 */
@Entity
public class ChildHealthExam extends Entry {
    /**
     * 儿童健康检查ID
     */
    private String childHealthExamId;

    /**
     * 个人档案ID
     */
    private String personInfoId;

    /**
     * 儿童健康检查表单编号
     */
    private String childHealthExamFormNo;

    /**
     * 月（年）龄代码
     */
    private String ageCode;
    
    /**
     * 儿童随访类型: 1：新生儿家庭访视，2：1岁以内随访，3：1~2岁随访，4：3~6岁随访
     */
    private Integer visitType;

    /**
     * 姓名
     */
    private String newbornName;

    /**
     * 身长(cm)
     */
    private Double height;

    /**
     * 年龄别身高评价结果代码
     */
    private String heightEvalCode;

    /**
     * 体重(kg)
     */
    private Double weight;

    /**
     * 年龄别体重评价结果代码
     */
    private String weightEvalCode;

    /**
     * 体重/身高
     */
    private Double weightDivHeight;

    /**
     * 年龄别体重/身高评价结果代码
     */
    private String weightDivHeightEvalCode;

    /**
     * 体格发育评价代码
     */
    private String physicalDevelopEvalCode;

    /**
     * 头围（cm)
     */
    private Double headCircumference;

    /**
     * 儿童面色代码
     */
    private String childComplexionCode;

    /**
     * 儿童面色中文
     */
    private String childComplexionValue;

    /**
     * 皮肤检查异常标志
     */
    private String skinAbnormCode;

    /**
     * 皮肤检查异常中文
     */
    private String skinAbnormValue;

    /**
     * 前囟闭合标志
     */
    private String bregmaCloseCode;

    /**
     * 前囟横径(cm)
     */
    private Double bregmaHorizDiameter;

    /**
     * 前囟纵径(cm)
     */
    private Double bregmaVertDiameter;

    /**
     * 颈部包块标志
     */
    private String neckMassCode;

    /**
     * 眼外观检查异常标志
     */
    private String eyeAbnormCode;

    /**
     * 眼外观检查异常中文
     */
    private String eyeAbnormValue;

    /**
     * 左眼裸眼远视力值
     */
    private String leftOriginalEyesight;

    /**
     * 右眼裸眼远视力值
     */
    private Double rightOriginalEyesight;

    /**
     * 左眼矫正远视力值
     */
    private Double leftCorrectEyesight;

    /**
     * 右眼矫正远视力值
     */
    private Double rightCorrectEyesight;

    /**
     * 耳外观检查异常标志
     */
    private String earAbnormCode;

    /**
     * 耳外观检查异常中文
     */
    private String earAbnormValue;

    /**
     * 听力筛查结果代码
     */
    private String hearingScreenResultCode;

    /**
     * 口腔检查异常标志
     */
    private String oralAbnormCode;

    /**
     * 口腔检查异常中文
     */
    private String oralAbnormValue;

    /**
     * 出牙数（颗）
     */
    private Integer teethCount;

    /**
     * 龋齿数(颗）
     */
    private Integer cariesCount;

    /**
     * 肺部听诊异常标志
     */
    private String lungAbnormCode;

    /**
     * 肺部听诊异常中文
     */
    private String lungAbnormValue;

    /**
     * 心脏听诊异常标志
     */
    private String heartAbnormCode;

    /**
     * 心脏听诊异常中文
     */
    private String heartAbnormValue;

    /**
     * 腹部触诊异常标志
     */
    private String abdomenAbnormCode;

    /**
     * 腹部触诊异常中文
     */
    private String abdomenAbnormValue;

    /**
     * 脐带脱落标志
     */
    private String umbcordFallCode;

    /**
     * 脐带脱落中文
     */
    private String umbcordFallValue;

    /**
     * 脐带检查结果代码
     */
    private String umbCordResultCode;

    /**
     * 脐疝标志
     */
    private String umbHerniaCode;

    /**
     * 四肢活动度异常标志
     */
    private String limbsAbnormCode;

    /**
     * 四肢活动度异常中文
     */
    private String limbsAbnormValue;

    /**
     * 步态异常标志
     */
    private String gaitAbnormCode;

    /**
     * 步态异常中文
     */
    private String gaitAbnormValue;

    /**
     * 可疑佝偻病症状代码
     */
    private String ricketsSymptomCode;

    /**
     * 可疑佝偻病体征代码
     */
    private String ricketsSignCode;

    /**
     * 肛门检查异常标志
     */
    private String anusAbnormCode;

    /**
     * 肛门检查异常中文
     */
    private String anusAbnormValue;

    /**
     * 外生殖器检查异常标志
     */
    private String genitaliaAbnormCode;

    /**
     * 外生殖器检查异常中文
     */
    private String genitaliaAbnormValue;

    /**
     * 血红蛋白值(g/L)
     */
    private Double hgb;

    /**
     * 其他体格检查
     */
    private String othersHealthExam;

    /**
     * 户外活动时长（h)
     */
    private Double outdoorActHours;

    /**
     * 服用维生素D名称
     */
    private String vitamindName;

    /**
     * 服用维生素D剂量（IU/d)
     */
    private Integer vitamindDose;

    /**
     * 儿童发育评估通过标志
     */
    private String developPassCode;

    /**
     * 两次随访间患病标志
     */
    private String sickVisitCode;

    /**
     * 两次随访间患肺炎住院次数
     */
    private Integer pneumVisitTimes;

    /**
     * 两次随访间患腹泻住院次数
     */
    private Integer diarrheaVisitTimes;

    /**
     * 两次随访间因外伤住院次数
     */
    private Integer traumaVisitTimes;

    /**
     * 两次随访间患其他疾病情况
     */
    private String othersVisitDesc;

    /**
     * 转诊标志
     */
    private String referralCode;

    /**
     * 转诊原因
     */
    private String referralReason;

    /**
     * 转入医疗机构名称
     */
    private String refertoOrgName;

    /**
     * 转入机构科室名称
     */
    private String refertoDeptName;

    /**
     * 随访日期
     */
    private Date followupVisitDate;

    /**
     * 本次随访医师ID
     */
    private String followupDoctorId;

    /**
     * 随访医师姓名
     */
    private String followupVisitDoctorName;

    /**
     * 下次随访日期
     */
    private Date nextFollowupDate;

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

    

    @Generated(hash = 281979390)@Keep
    public ChildHealthExam() {
        recordChoice = new ArrayList<>();
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



    public Date getNextFollowupDate() {
        return this.nextFollowupDate;
    }



    public void setNextFollowupDate(Date nextFollowupDate) {
        this.nextFollowupDate = nextFollowupDate;
    }



    public String getFollowupVisitDoctorName() {
        return this.followupVisitDoctorName;
    }



    public void setFollowupVisitDoctorName(String followupVisitDoctorName) {
        this.followupVisitDoctorName = followupVisitDoctorName;
    }



    public String getFollowupDoctorId() {
        return this.followupDoctorId;
    }



    public void setFollowupDoctorId(String followupDoctorId) {
        this.followupDoctorId = followupDoctorId;
    }



    public Date getFollowupVisitDate() {
        return this.followupVisitDate;
    }



    public void setFollowupVisitDate(Date followupVisitDate) {
        this.followupVisitDate = followupVisitDate;
    }



    public String getRefertoDeptName() {
        return this.refertoDeptName;
    }



    public void setRefertoDeptName(String refertoDeptName) {
        this.refertoDeptName = refertoDeptName;
    }



    public String getRefertoOrgName() {
        return this.refertoOrgName;
    }



    public void setRefertoOrgName(String refertoOrgName) {
        this.refertoOrgName = refertoOrgName;
    }



    public String getReferralReason() {
        return this.referralReason;
    }



    public void setReferralReason(String referralReason) {
        this.referralReason = referralReason;
    }



    public String getReferralCode() {
        return this.referralCode;
    }



    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }



    public String getOthersVisitDesc() {
        return this.othersVisitDesc;
    }



    public void setOthersVisitDesc(String othersVisitDesc) {
        this.othersVisitDesc = othersVisitDesc;
    }



    public Integer getTraumaVisitTimes() {
        return this.traumaVisitTimes;
    }



    public void setTraumaVisitTimes(Integer traumaVisitTimes) {
        this.traumaVisitTimes = traumaVisitTimes;
    }



    public Integer getDiarrheaVisitTimes() {
        return this.diarrheaVisitTimes;
    }



    public void setDiarrheaVisitTimes(Integer diarrheaVisitTimes) {
        this.diarrheaVisitTimes = diarrheaVisitTimes;
    }



    public Integer getPneumVisitTimes() {
        return this.pneumVisitTimes;
    }



    public void setPneumVisitTimes(Integer pneumVisitTimes) {
        this.pneumVisitTimes = pneumVisitTimes;
    }



    public String getSickVisitCode() {
        return this.sickVisitCode;
    }



    public void setSickVisitCode(String sickVisitCode) {
        this.sickVisitCode = sickVisitCode;
    }



    public String getDevelopPassCode() {
        return this.developPassCode;
    }



    public void setDevelopPassCode(String developPassCode) {
        this.developPassCode = developPassCode;
    }



    public Integer getVitamindDose() {
        return this.vitamindDose;
    }



    public void setVitamindDose(Integer vitamindDose) {
        this.vitamindDose = vitamindDose;
    }



    public String getVitamindName() {
        return this.vitamindName;
    }



    public void setVitamindName(String vitamindName) {
        this.vitamindName = vitamindName;
    }



    public Double getOutdoorActHours() {
        return this.outdoorActHours;
    }



    public void setOutdoorActHours(Double outdoorActHours) {
        this.outdoorActHours = outdoorActHours;
    }



    public String getOthersHealthExam() {
        return this.othersHealthExam;
    }



    public void setOthersHealthExam(String othersHealthExam) {
        this.othersHealthExam = othersHealthExam;
    }



    public Double getHgb() {
        return this.hgb;
    }



    public void setHgb(Double hgb) {
        this.hgb = hgb;
    }



    public String getGenitaliaAbnormValue() {
        return this.genitaliaAbnormValue;
    }



    public void setGenitaliaAbnormValue(String genitaliaAbnormValue) {
        this.genitaliaAbnormValue = genitaliaAbnormValue;
    }



    public String getGenitaliaAbnormCode() {
        return this.genitaliaAbnormCode;
    }



    public void setGenitaliaAbnormCode(String genitaliaAbnormCode) {
        this.genitaliaAbnormCode = genitaliaAbnormCode;
    }



    public String getAnusAbnormValue() {
        return this.anusAbnormValue;
    }



    public void setAnusAbnormValue(String anusAbnormValue) {
        this.anusAbnormValue = anusAbnormValue;
    }



    public String getAnusAbnormCode() {
        return this.anusAbnormCode;
    }



    public void setAnusAbnormCode(String anusAbnormCode) {
        this.anusAbnormCode = anusAbnormCode;
    }



    public String getRicketsSignCode() {
        return this.ricketsSignCode;
    }



    public void setRicketsSignCode(String ricketsSignCode) {
        this.ricketsSignCode = ricketsSignCode;
    }



    public String getRicketsSymptomCode() {
        return this.ricketsSymptomCode;
    }



    public void setRicketsSymptomCode(String ricketsSymptomCode) {
        this.ricketsSymptomCode = ricketsSymptomCode;
    }



    public String getGaitAbnormValue() {
        return this.gaitAbnormValue;
    }



    public void setGaitAbnormValue(String gaitAbnormValue) {
        this.gaitAbnormValue = gaitAbnormValue;
    }



    public String getGaitAbnormCode() {
        return this.gaitAbnormCode;
    }



    public void setGaitAbnormCode(String gaitAbnormCode) {
        this.gaitAbnormCode = gaitAbnormCode;
    }



    public String getLimbsAbnormValue() {
        return this.limbsAbnormValue;
    }



    public void setLimbsAbnormValue(String limbsAbnormValue) {
        this.limbsAbnormValue = limbsAbnormValue;
    }



    public String getLimbsAbnormCode() {
        return this.limbsAbnormCode;
    }



    public void setLimbsAbnormCode(String limbsAbnormCode) {
        this.limbsAbnormCode = limbsAbnormCode;
    }



    public String getUmbHerniaCode() {
        return this.umbHerniaCode;
    }



    public void setUmbHerniaCode(String umbHerniaCode) {
        this.umbHerniaCode = umbHerniaCode;
    }



    public String getUmbCordResultCode() {
        return this.umbCordResultCode;
    }



    public void setUmbCordResultCode(String umbCordResultCode) {
        this.umbCordResultCode = umbCordResultCode;
    }



    public String getUmbcordFallValue() {
        return this.umbcordFallValue;
    }



    public void setUmbcordFallValue(String umbcordFallValue) {
        this.umbcordFallValue = umbcordFallValue;
    }



    public String getUmbcordFallCode() {
        return this.umbcordFallCode;
    }



    public void setUmbcordFallCode(String umbcordFallCode) {
        this.umbcordFallCode = umbcordFallCode;
    }



    public String getAbdomenAbnormValue() {
        return this.abdomenAbnormValue;
    }



    public void setAbdomenAbnormValue(String abdomenAbnormValue) {
        this.abdomenAbnormValue = abdomenAbnormValue;
    }



    public String getAbdomenAbnormCode() {
        return this.abdomenAbnormCode;
    }



    public void setAbdomenAbnormCode(String abdomenAbnormCode) {
        this.abdomenAbnormCode = abdomenAbnormCode;
    }



    public String getHeartAbnormValue() {
        return this.heartAbnormValue;
    }



    public void setHeartAbnormValue(String heartAbnormValue) {
        this.heartAbnormValue = heartAbnormValue;
    }



    public String getHeartAbnormCode() {
        return this.heartAbnormCode;
    }



    public void setHeartAbnormCode(String heartAbnormCode) {
        this.heartAbnormCode = heartAbnormCode;
    }



    public String getLungAbnormValue() {
        return this.lungAbnormValue;
    }



    public void setLungAbnormValue(String lungAbnormValue) {
        this.lungAbnormValue = lungAbnormValue;
    }



    public String getLungAbnormCode() {
        return this.lungAbnormCode;
    }



    public void setLungAbnormCode(String lungAbnormCode) {
        this.lungAbnormCode = lungAbnormCode;
    }



    public Integer getCariesCount() {
        return this.cariesCount;
    }



    public void setCariesCount(Integer cariesCount) {
        this.cariesCount = cariesCount;
    }



    public Integer getTeethCount() {
        return this.teethCount;
    }



    public void setTeethCount(Integer teethCount) {
        this.teethCount = teethCount;
    }



    public String getOralAbnormValue() {
        return this.oralAbnormValue;
    }



    public void setOralAbnormValue(String oralAbnormValue) {
        this.oralAbnormValue = oralAbnormValue;
    }



    public String getOralAbnormCode() {
        return this.oralAbnormCode;
    }



    public void setOralAbnormCode(String oralAbnormCode) {
        this.oralAbnormCode = oralAbnormCode;
    }



    public String getHearingScreenResultCode() {
        return this.hearingScreenResultCode;
    }



    public void setHearingScreenResultCode(String hearingScreenResultCode) {
        this.hearingScreenResultCode = hearingScreenResultCode;
    }



    public String getEarAbnormValue() {
        return this.earAbnormValue;
    }



    public void setEarAbnormValue(String earAbnormValue) {
        this.earAbnormValue = earAbnormValue;
    }



    public String getEarAbnormCode() {
        return this.earAbnormCode;
    }



    public void setEarAbnormCode(String earAbnormCode) {
        this.earAbnormCode = earAbnormCode;
    }



    public Double getRightCorrectEyesight() {
        return this.rightCorrectEyesight;
    }



    public void setRightCorrectEyesight(Double rightCorrectEyesight) {
        this.rightCorrectEyesight = rightCorrectEyesight;
    }



    public Double getLeftCorrectEyesight() {
        return this.leftCorrectEyesight;
    }



    public void setLeftCorrectEyesight(Double leftCorrectEyesight) {
        this.leftCorrectEyesight = leftCorrectEyesight;
    }



    public Double getRightOriginalEyesight() {
        return this.rightOriginalEyesight;
    }



    public void setRightOriginalEyesight(Double rightOriginalEyesight) {
        this.rightOriginalEyesight = rightOriginalEyesight;
    }



    public String getLeftOriginalEyesight() {
        return this.leftOriginalEyesight;
    }



    public void setLeftOriginalEyesight(String leftOriginalEyesight) {
        this.leftOriginalEyesight = leftOriginalEyesight;
    }



    public String getEyeAbnormValue() {
        return this.eyeAbnormValue;
    }



    public void setEyeAbnormValue(String eyeAbnormValue) {
        this.eyeAbnormValue = eyeAbnormValue;
    }



    public String getEyeAbnormCode() {
        return this.eyeAbnormCode;
    }



    public void setEyeAbnormCode(String eyeAbnormCode) {
        this.eyeAbnormCode = eyeAbnormCode;
    }



    public String getNeckMassCode() {
        return this.neckMassCode;
    }



    public void setNeckMassCode(String neckMassCode) {
        this.neckMassCode = neckMassCode;
    }



    public Double getBregmaVertDiameter() {
        return this.bregmaVertDiameter;
    }



    public void setBregmaVertDiameter(Double bregmaVertDiameter) {
        this.bregmaVertDiameter = bregmaVertDiameter;
    }



    public Double getBregmaHorizDiameter() {
        return this.bregmaHorizDiameter;
    }



    public void setBregmaHorizDiameter(Double bregmaHorizDiameter) {
        this.bregmaHorizDiameter = bregmaHorizDiameter;
    }



    public String getBregmaCloseCode() {
        return this.bregmaCloseCode;
    }



    public void setBregmaCloseCode(String bregmaCloseCode) {
        this.bregmaCloseCode = bregmaCloseCode;
    }



    public String getSkinAbnormValue() {
        return this.skinAbnormValue;
    }



    public void setSkinAbnormValue(String skinAbnormValue) {
        this.skinAbnormValue = skinAbnormValue;
    }



    public String getSkinAbnormCode() {
        return this.skinAbnormCode;
    }



    public void setSkinAbnormCode(String skinAbnormCode) {
        this.skinAbnormCode = skinAbnormCode;
    }



    public String getChildComplexionValue() {
        return this.childComplexionValue;
    }



    public void setChildComplexionValue(String childComplexionValue) {
        this.childComplexionValue = childComplexionValue;
    }



    public String getChildComplexionCode() {
        return this.childComplexionCode;
    }



    public void setChildComplexionCode(String childComplexionCode) {
        this.childComplexionCode = childComplexionCode;
    }



    public Double getHeadCircumference() {
        return this.headCircumference;
    }



    public void setHeadCircumference(Double headCircumference) {
        this.headCircumference = headCircumference;
    }



    public String getPhysicalDevelopEvalCode() {
        return this.physicalDevelopEvalCode;
    }



    public void setPhysicalDevelopEvalCode(String physicalDevelopEvalCode) {
        this.physicalDevelopEvalCode = physicalDevelopEvalCode;
    }



    public String getWeightDivHeightEvalCode() {
        return this.weightDivHeightEvalCode;
    }



    public void setWeightDivHeightEvalCode(String weightDivHeightEvalCode) {
        this.weightDivHeightEvalCode = weightDivHeightEvalCode;
    }



    public Double getWeightDivHeight() {
        return this.weightDivHeight;
    }



    public void setWeightDivHeight(Double weightDivHeight) {
        this.weightDivHeight = weightDivHeight;
    }



    public String getWeightEvalCode() {
        return this.weightEvalCode;
    }



    public void setWeightEvalCode(String weightEvalCode) {
        this.weightEvalCode = weightEvalCode;
    }



    public Double getWeight() {
        return this.weight;
    }



    public void setWeight(Double weight) {
        this.weight = weight;
    }



    public String getHeightEvalCode() {
        return this.heightEvalCode;
    }



    public void setHeightEvalCode(String heightEvalCode) {
        this.heightEvalCode = heightEvalCode;
    }



    public Double getHeight() {
        return this.height;
    }



    public void setHeight(Double height) {
        this.height = height;
    }



    public String getNewbornName() {
        return this.newbornName;
    }



    public void setNewbornName(String newbornName) {
        this.newbornName = newbornName;
    }



    public Integer getVisitType() {
        return this.visitType;
    }



    public void setVisitType(Integer visitType) {
        this.visitType = visitType;
    }



    public String getAgeCode() {
        return this.ageCode;
    }



    public void setAgeCode(String ageCode) {
        this.ageCode = ageCode;
    }



    public String getChildHealthExamFormNo() {
        return this.childHealthExamFormNo;
    }



    public void setChildHealthExamFormNo(String childHealthExamFormNo) {
        this.childHealthExamFormNo = childHealthExamFormNo;
    }



    public String getPersonInfoId() {
        return this.personInfoId;
    }



    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }



    public String getChildHealthExamId() {
        return this.childHealthExamId;
    }



    public void setChildHealthExamId(String childHealthExamId) {
        this.childHealthExamId = childHealthExamId;
    }

    public List<RecordChoice> getRecordChoice() {
        return recordChoice;
    }

    public void setRecordChoice(List<RecordChoice> recordChoice) {
        this.recordChoice = recordChoice;
    }

    @Generated(hash = 1621134606)
    public ChildHealthExam(String childHealthExamId, String personInfoId,
            String childHealthExamFormNo, String ageCode, Integer visitType,
            String newbornName, Double height, String heightEvalCode,
            Double weight, String weightEvalCode, Double weightDivHeight,
            String weightDivHeightEvalCode, String physicalDevelopEvalCode,
            Double headCircumference, String childComplexionCode,
            String childComplexionValue, String skinAbnormCode,
            String skinAbnormValue, String bregmaCloseCode,
            Double bregmaHorizDiameter, Double bregmaVertDiameter,
            String neckMassCode, String eyeAbnormCode, String eyeAbnormValue,
            String leftOriginalEyesight, Double rightOriginalEyesight,
            Double leftCorrectEyesight, Double rightCorrectEyesight,
            String earAbnormCode, String earAbnormValue,
            String hearingScreenResultCode, String oralAbnormCode,
            String oralAbnormValue, Integer teethCount, Integer cariesCount,
            String lungAbnormCode, String lungAbnormValue, String heartAbnormCode,
            String heartAbnormValue, String abdomenAbnormCode,
            String abdomenAbnormValue, String umbcordFallCode,
            String umbcordFallValue, String umbCordResultCode,
            String umbHerniaCode, String limbsAbnormCode, String limbsAbnormValue,
            String gaitAbnormCode, String gaitAbnormValue,
            String ricketsSymptomCode, String ricketsSignCode,
            String anusAbnormCode, String anusAbnormValue,
            String genitaliaAbnormCode, String genitaliaAbnormValue, Double hgb,
            String othersHealthExam, Double outdoorActHours, String vitamindName,
            Integer vitamindDose, String developPassCode, String sickVisitCode,
            Integer pneumVisitTimes, Integer diarrheaVisitTimes,
            Integer traumaVisitTimes, String othersVisitDesc, String referralCode,
            String referralReason, String refertoOrgName, String refertoDeptName,
            Date followupVisitDate, String followupDoctorId,
            String followupVisitDoctorName, Date nextFollowupDate,
            Integer isCancel, String createOrgId, String orgName, String creatorId,
            String creator, Date createTime, String modifiedOrgId,
            String modifiedOrgName, String modifierId, String modifier,
            Date modifiedTime) {
        this.childHealthExamId = childHealthExamId;
        this.personInfoId = personInfoId;
        this.childHealthExamFormNo = childHealthExamFormNo;
        this.ageCode = ageCode;
        this.visitType = visitType;
        this.newbornName = newbornName;
        this.height = height;
        this.heightEvalCode = heightEvalCode;
        this.weight = weight;
        this.weightEvalCode = weightEvalCode;
        this.weightDivHeight = weightDivHeight;
        this.weightDivHeightEvalCode = weightDivHeightEvalCode;
        this.physicalDevelopEvalCode = physicalDevelopEvalCode;
        this.headCircumference = headCircumference;
        this.childComplexionCode = childComplexionCode;
        this.childComplexionValue = childComplexionValue;
        this.skinAbnormCode = skinAbnormCode;
        this.skinAbnormValue = skinAbnormValue;
        this.bregmaCloseCode = bregmaCloseCode;
        this.bregmaHorizDiameter = bregmaHorizDiameter;
        this.bregmaVertDiameter = bregmaVertDiameter;
        this.neckMassCode = neckMassCode;
        this.eyeAbnormCode = eyeAbnormCode;
        this.eyeAbnormValue = eyeAbnormValue;
        this.leftOriginalEyesight = leftOriginalEyesight;
        this.rightOriginalEyesight = rightOriginalEyesight;
        this.leftCorrectEyesight = leftCorrectEyesight;
        this.rightCorrectEyesight = rightCorrectEyesight;
        this.earAbnormCode = earAbnormCode;
        this.earAbnormValue = earAbnormValue;
        this.hearingScreenResultCode = hearingScreenResultCode;
        this.oralAbnormCode = oralAbnormCode;
        this.oralAbnormValue = oralAbnormValue;
        this.teethCount = teethCount;
        this.cariesCount = cariesCount;
        this.lungAbnormCode = lungAbnormCode;
        this.lungAbnormValue = lungAbnormValue;
        this.heartAbnormCode = heartAbnormCode;
        this.heartAbnormValue = heartAbnormValue;
        this.abdomenAbnormCode = abdomenAbnormCode;
        this.abdomenAbnormValue = abdomenAbnormValue;
        this.umbcordFallCode = umbcordFallCode;
        this.umbcordFallValue = umbcordFallValue;
        this.umbCordResultCode = umbCordResultCode;
        this.umbHerniaCode = umbHerniaCode;
        this.limbsAbnormCode = limbsAbnormCode;
        this.limbsAbnormValue = limbsAbnormValue;
        this.gaitAbnormCode = gaitAbnormCode;
        this.gaitAbnormValue = gaitAbnormValue;
        this.ricketsSymptomCode = ricketsSymptomCode;
        this.ricketsSignCode = ricketsSignCode;
        this.anusAbnormCode = anusAbnormCode;
        this.anusAbnormValue = anusAbnormValue;
        this.genitaliaAbnormCode = genitaliaAbnormCode;
        this.genitaliaAbnormValue = genitaliaAbnormValue;
        this.hgb = hgb;
        this.othersHealthExam = othersHealthExam;
        this.outdoorActHours = outdoorActHours;
        this.vitamindName = vitamindName;
        this.vitamindDose = vitamindDose;
        this.developPassCode = developPassCode;
        this.sickVisitCode = sickVisitCode;
        this.pneumVisitTimes = pneumVisitTimes;
        this.diarrheaVisitTimes = diarrheaVisitTimes;
        this.traumaVisitTimes = traumaVisitTimes;
        this.othersVisitDesc = othersVisitDesc;
        this.referralCode = referralCode;
        this.referralReason = referralReason;
        this.refertoOrgName = refertoOrgName;
        this.refertoDeptName = refertoDeptName;
        this.followupVisitDate = followupVisitDate;
        this.followupDoctorId = followupDoctorId;
        this.followupVisitDoctorName = followupVisitDoctorName;
        this.nextFollowupDate = nextFollowupDate;
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

}