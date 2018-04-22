package net.greatsoft.main.db.po.child;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年7月19日 下午12:06:20 
 * @Description: 高危儿童专案管理随访
 *
 */
@Entity
public class ChildWeakFollowup extends Entry{
    /**
     * 高危儿童专案管理随访ID
     */
    private String childWeakFollowupId;

    /**
     * 个人档案ID
     */
    private String personInfoId;

    /**
     * 高危儿童专案管理随访单编号
     */
    private String childWeakFollowupFormNo;

    /**
     * 随访日期
     */
    private Date followupDate;

    /**
     * 随访医生
     */
    private String followupDoctor;

    /**
     * 随诊月龄
     */
    private Integer moonAge;

    /**
     * 症状描述
     */
    private String symptom;

    /**
     * 体征
     */
    private String objectiveSign;

    /**
     * 身高(cm)
     */
    private Double height;

    /**
     * 体重(kg)
     */
    private Double weight;

    /**
     * 血红蛋白值：单位：g/L
     */
    private Integer hb;

    /**
     * 户外活动时间：单位：小时/日
     */
    private String outdoorExercise;

    /**
     * 评估方法
     */
    private String evaluationMethod;

    /**
     * 评估结果
     */
    private String evaluationResult;

    /**
     * 存在问题
     */
    private String problem;

    /**
     * 治疗方案
     */
    private String cureSolution;

    /**
     * 辅助检查-项目名称
     */
    private String examItemName;

    /**
     * 辅助检查-结果
     */
    private String examResult;

    /**
     * 处理
     */
    private String dispose;

    /**
     * 指导
     */
    private String guide;

    /**
     * 预约日期
     */
    private Date precontractDate;

    /**
     * 会诊
     */
    private String consultationInfo;

    /**
     * 转诊记录
     */
    private String transferInfo;

    /**
     * 登记日期
     */
    private Date createDate;

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

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTransferInfo() {
        return this.transferInfo;
    }

    public void setTransferInfo(String transferInfo) {
        this.transferInfo = transferInfo;
    }

    public String getConsultationInfo() {
        return this.consultationInfo;
    }

    public void setConsultationInfo(String consultationInfo) {
        this.consultationInfo = consultationInfo;
    }

    public Date getPrecontractDate() {
        return this.precontractDate;
    }

    public void setPrecontractDate(Date precontractDate) {
        this.precontractDate = precontractDate;
    }

    public String getGuide() {
        return this.guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getDispose() {
        return this.dispose;
    }

    public void setDispose(String dispose) {
        this.dispose = dispose;
    }

    public String getExamResult() {
        return this.examResult;
    }

    public void setExamResult(String examResult) {
        this.examResult = examResult;
    }

    public String getExamItemName() {
        return this.examItemName;
    }

    public void setExamItemName(String examItemName) {
        this.examItemName = examItemName;
    }

    public String getCureSolution() {
        return this.cureSolution;
    }

    public void setCureSolution(String cureSolution) {
        this.cureSolution = cureSolution;
    }

    public String getProblem() {
        return this.problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getEvaluationResult() {
        return this.evaluationResult;
    }

    public void setEvaluationResult(String evaluationResult) {
        this.evaluationResult = evaluationResult;
    }

    public String getEvaluationMethod() {
        return this.evaluationMethod;
    }

    public void setEvaluationMethod(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    public String getOutdoorExercise() {
        return this.outdoorExercise;
    }

    public void setOutdoorExercise(String outdoorExercise) {
        this.outdoorExercise = outdoorExercise;
    }

    public Integer getHb() {
        return this.hb;
    }

    public void setHb(Integer hb) {
        this.hb = hb;
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

    public String getObjectiveSign() {
        return this.objectiveSign;
    }

    public void setObjectiveSign(String objectiveSign) {
        this.objectiveSign = objectiveSign;
    }

    public String getSymptom() {
        return this.symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public Integer getMoonAge() {
        return this.moonAge;
    }

    public void setMoonAge(Integer moonAge) {
        this.moonAge = moonAge;
    }

    public String getFollowupDoctor() {
        return this.followupDoctor;
    }

    public void setFollowupDoctor(String followupDoctor) {
        this.followupDoctor = followupDoctor;
    }

    public Date getFollowupDate() {
        return this.followupDate;
    }

    public void setFollowupDate(Date followupDate) {
        this.followupDate = followupDate;
    }

    public String getChildWeakFollowupFormNo() {
        return this.childWeakFollowupFormNo;
    }

    public void setChildWeakFollowupFormNo(String childWeakFollowupFormNo) {
        this.childWeakFollowupFormNo = childWeakFollowupFormNo;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getChildWeakFollowupId() {
        return this.childWeakFollowupId;
    }

    public void setChildWeakFollowupId(String childWeakFollowupId) {
        this.childWeakFollowupId = childWeakFollowupId;
    }

    @Generated(hash = 1991085768)
    public ChildWeakFollowup(String childWeakFollowupId, String personInfoId,
            String childWeakFollowupFormNo, Date followupDate,
            String followupDoctor, Integer moonAge, String symptom,
            String objectiveSign, Double height, Double weight, Integer hb,
            String outdoorExercise, String evaluationMethod,
            String evaluationResult, String problem, String cureSolution,
            String examItemName, String examResult, String dispose, String guide,
            Date precontractDate, String consultationInfo, String transferInfo,
            Date createDate, Integer isCancel, String createOrgId, String orgName,
            String creatorId, String creator, Date createTime,
            String modifiedOrgId, String modifiedOrgName, String modifierId,
            String modifier, Date modifiedTime) {
        this.childWeakFollowupId = childWeakFollowupId;
        this.personInfoId = personInfoId;
        this.childWeakFollowupFormNo = childWeakFollowupFormNo;
        this.followupDate = followupDate;
        this.followupDoctor = followupDoctor;
        this.moonAge = moonAge;
        this.symptom = symptom;
        this.objectiveSign = objectiveSign;
        this.height = height;
        this.weight = weight;
        this.hb = hb;
        this.outdoorExercise = outdoorExercise;
        this.evaluationMethod = evaluationMethod;
        this.evaluationResult = evaluationResult;
        this.problem = problem;
        this.cureSolution = cureSolution;
        this.examItemName = examItemName;
        this.examResult = examResult;
        this.dispose = dispose;
        this.guide = guide;
        this.precontractDate = precontractDate;
        this.consultationInfo = consultationInfo;
        this.transferInfo = transferInfo;
        this.createDate = createDate;
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

    @Generated(hash = 572648723)
    public ChildWeakFollowup() {
    }
}