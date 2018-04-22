package net.greatsoft.main.db.po.vaccine;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;



/**
 * 
 * @author AlphGo
 * @date 2016年8月15日 上午11:09:28 
 * @Description: 预防接种卡信息_不良反应
 *
 */
@Entity
public class CdcVaccreportAdverse extends Entry{
    /**
     * 预防接种卡信息_不良反应ID
     */
    private String cdcVaccreportAdverseId;

    /**
     * 预防接种卡ID
     */
    
    private String cdcVaccreportId;

    /**
     * 引起预防接种后不良反应的可疑疫苗ID
     */
    
    private String doubtfulVaccineCode;

    /**
     * 引起预防接种后不良反应的可疑疫苗名称
     */
    
    private String doubtfulVaccineValue;

    /**
     * 接种时间
     */
    
    private Date inoculateDate;

    /**
     * 预防接种后不良反应处理结果
     */
    private String adverseDealResult;

    /**
     * 预防接种后不良反应发生日期
     */
    
    private Date adverseOccurDate;

    /**
     * 预防接种后不良反应临床诊断代码
     */
    
    private String adverseDiagnosisCode;

    /**
     * 调查者姓名
     */
    
    private String investigator;
    
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

    public String getInvestigator() {
        return this.investigator;
    }

    public void setInvestigator(String investigator) {
        this.investigator = investigator;
    }

    public String getAdverseDiagnosisCode() {
        return this.adverseDiagnosisCode;
    }

    public void setAdverseDiagnosisCode(String adverseDiagnosisCode) {
        this.adverseDiagnosisCode = adverseDiagnosisCode;
    }

    public Date getAdverseOccurDate() {
        return this.adverseOccurDate;
    }

    public void setAdverseOccurDate(Date adverseOccurDate) {
        this.adverseOccurDate = adverseOccurDate;
    }

    public String getAdverseDealResult() {
        return this.adverseDealResult;
    }

    public void setAdverseDealResult(String adverseDealResult) {
        this.adverseDealResult = adverseDealResult;
    }

    public Date getInoculateDate() {
        return this.inoculateDate;
    }

    public void setInoculateDate(Date inoculateDate) {
        this.inoculateDate = inoculateDate;
    }

    public String getDoubtfulVaccineValue() {
        return this.doubtfulVaccineValue;
    }

    public void setDoubtfulVaccineValue(String doubtfulVaccineValue) {
        this.doubtfulVaccineValue = doubtfulVaccineValue;
    }

    public String getDoubtfulVaccineCode() {
        return this.doubtfulVaccineCode;
    }

    public void setDoubtfulVaccineCode(String doubtfulVaccineCode) {
        this.doubtfulVaccineCode = doubtfulVaccineCode;
    }

    public String getCdcVaccreportId() {
        return this.cdcVaccreportId;
    }

    public void setCdcVaccreportId(String cdcVaccreportId) {
        this.cdcVaccreportId = cdcVaccreportId;
    }

    public String getCdcVaccreportAdverseId() {
        return this.cdcVaccreportAdverseId;
    }

    public void setCdcVaccreportAdverseId(String cdcVaccreportAdverseId) {
        this.cdcVaccreportAdverseId = cdcVaccreportAdverseId;
    }

    @Generated(hash = 1619175828)
    public CdcVaccreportAdverse(String cdcVaccreportAdverseId,
            String cdcVaccreportId, String doubtfulVaccineCode,
            String doubtfulVaccineValue, Date inoculateDate,
            String adverseDealResult, Date adverseOccurDate,
            String adverseDiagnosisCode, String investigator, Integer isCancel,
            String createOrgId, String orgName, String creatorId, String creator,
            Date createTime, String modifiedOrgId, String modifiedOrgName,
            String modifierId, String modifier, Date modifiedTime) {
        this.cdcVaccreportAdverseId = cdcVaccreportAdverseId;
        this.cdcVaccreportId = cdcVaccreportId;
        this.doubtfulVaccineCode = doubtfulVaccineCode;
        this.doubtfulVaccineValue = doubtfulVaccineValue;
        this.inoculateDate = inoculateDate;
        this.adverseDealResult = adverseDealResult;
        this.adverseOccurDate = adverseOccurDate;
        this.adverseDiagnosisCode = adverseDiagnosisCode;
        this.investigator = investigator;
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

    @Generated(hash = 257297328)
    public CdcVaccreportAdverse() {
    }

}