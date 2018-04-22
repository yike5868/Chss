package net.greatsoft.main.db.po.child;

import java.util.Date;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年7月19日 下午12:02:07 
 * @Description: 新生儿疾病筛查诊断
 *
 */
@Entity
public class ChildDiseaseScreenDiag extends Entry{
    /**
     * 新生儿疾病筛查诊断ID
     */
    
    private String childDiseaseScreenDiagId;

    /**
     * 新生儿疾病筛查ID
     */
    
    private String childDiseaseScreenId;

    /**
     * 诊断项目
     */
    
    private String diagnosisItem;

    /**
     * 诊断日期
     */
    
    
    private Date diagnosisDate;

    /**
     * 诊断方法描述
     */

    private String diagnosisWay;

    /**
     * 疾病诊断
     */
    
    private String diagnosis;

    /**
     * 疾病诊断名称
     */
    
    private String diagnosisName;

    /**
     * 诊断结果
     */
    
    private String diagResultCode;

    /**
     * 确诊苯丙酮尿症
     */
    
    private String diagPhenylketonuria;

    /**
     * 确诊甲状腺功能减低症
     */
    
    private String diagHypothyroidism;

    /**
     * 诊断单位名称
     */
    
    private String diagnosisOrgName;

    /**
     * 诊断医师姓名
     */
    
    private String diagnosisDoctorName;

    /**
     * 治疗日期
     */
    
    
    private Date cureDate;

    /**
     * 治疗记录
     */
    
    private String cureInfo;

    /**
     * 疾病转归代码
     */
    private String transferStatus;

    /**
     * 结案日期
     */
    
    
    private Date finalDate;

    /**
     * 备注
     */
    private String notes;

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

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getFinalDate() {
        return this.finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public String getTransferStatus() {
        return this.transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getCureInfo() {
        return this.cureInfo;
    }

    public void setCureInfo(String cureInfo) {
        this.cureInfo = cureInfo;
    }

    public Date getCureDate() {
        return this.cureDate;
    }

    public void setCureDate(Date cureDate) {
        this.cureDate = cureDate;
    }

    public String getDiagnosisDoctorName() {
        return this.diagnosisDoctorName;
    }

    public void setDiagnosisDoctorName(String diagnosisDoctorName) {
        this.diagnosisDoctorName = diagnosisDoctorName;
    }

    public String getDiagnosisOrgName() {
        return this.diagnosisOrgName;
    }

    public void setDiagnosisOrgName(String diagnosisOrgName) {
        this.diagnosisOrgName = diagnosisOrgName;
    }

    public String getDiagHypothyroidism() {
        return this.diagHypothyroidism;
    }

    public void setDiagHypothyroidism(String diagHypothyroidism) {
        this.diagHypothyroidism = diagHypothyroidism;
    }

    public String getDiagPhenylketonuria() {
        return this.diagPhenylketonuria;
    }

    public void setDiagPhenylketonuria(String diagPhenylketonuria) {
        this.diagPhenylketonuria = diagPhenylketonuria;
    }

    public String getDiagResultCode() {
        return this.diagResultCode;
    }

    public void setDiagResultCode(String diagResultCode) {
        this.diagResultCode = diagResultCode;
    }

    public String getDiagnosisName() {
        return this.diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosisWay() {
        return this.diagnosisWay;
    }

    public void setDiagnosisWay(String diagnosisWay) {
        this.diagnosisWay = diagnosisWay;
    }

    public Date getDiagnosisDate() {
        return this.diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getDiagnosisItem() {
        return this.diagnosisItem;
    }

    public void setDiagnosisItem(String diagnosisItem) {
        this.diagnosisItem = diagnosisItem;
    }

    public String getChildDiseaseScreenId() {
        return this.childDiseaseScreenId;
    }

    public void setChildDiseaseScreenId(String childDiseaseScreenId) {
        this.childDiseaseScreenId = childDiseaseScreenId;
    }

    public String getChildDiseaseScreenDiagId() {
        return this.childDiseaseScreenDiagId;
    }

    public void setChildDiseaseScreenDiagId(String childDiseaseScreenDiagId) {
        this.childDiseaseScreenDiagId = childDiseaseScreenDiagId;
    }

    @Generated(hash = 1704169642)
    public ChildDiseaseScreenDiag(String childDiseaseScreenDiagId,
            String childDiseaseScreenId, String diagnosisItem, Date diagnosisDate,
            String diagnosisWay, String diagnosis, String diagnosisName,
            String diagResultCode, String diagPhenylketonuria,
            String diagHypothyroidism, String diagnosisOrgName,
            String diagnosisDoctorName, Date cureDate, String cureInfo,
            String transferStatus, Date finalDate, String notes, Integer isCancel,
            String createOrgId, String orgName, String creatorId, String creator,
            Date createTime, String modifiedOrgId, String modifiedOrgName,
            String modifierId, String modifier, Date modifiedTime) {
        this.childDiseaseScreenDiagId = childDiseaseScreenDiagId;
        this.childDiseaseScreenId = childDiseaseScreenId;
        this.diagnosisItem = diagnosisItem;
        this.diagnosisDate = diagnosisDate;
        this.diagnosisWay = diagnosisWay;
        this.diagnosis = diagnosis;
        this.diagnosisName = diagnosisName;
        this.diagResultCode = diagResultCode;
        this.diagPhenylketonuria = diagPhenylketonuria;
        this.diagHypothyroidism = diagHypothyroidism;
        this.diagnosisOrgName = diagnosisOrgName;
        this.diagnosisDoctorName = diagnosisDoctorName;
        this.cureDate = cureDate;
        this.cureInfo = cureInfo;
        this.transferStatus = transferStatus;
        this.finalDate = finalDate;
        this.notes = notes;
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

    @Generated(hash = 1929669984)
    public ChildDiseaseScreenDiag() {
    }


}