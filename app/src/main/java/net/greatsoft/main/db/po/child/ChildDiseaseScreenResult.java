package net.greatsoft.main.db.po.child;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
/**
 * 
 * @author AlphGo
 * @date 2016年7月19日 下午12:02:42 
 * @Description: 新生儿疾病筛查结果
 *
 */
@Entity
public class ChildDiseaseScreenResult extends Entry{
    /**
     * 新生儿疾病筛查结果ID
     */
    
    private String childDiseaseScreenResultId;

    /**
     * 新生儿疾病筛查ID
     */
    
    private String childDiseaseScreenId;

    /**
     * 新生儿疾病筛查项目代码
     */
    
    private String childScreenItem;

    /**
     * 新生儿疾病筛查结果
     */
    
    private String childScreenResult;

    /**
     * 结果判定
     */
    
    private String resultAssessment;

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

    public String getResultAssessment() {
        return this.resultAssessment;
    }

    public void setResultAssessment(String resultAssessment) {
        this.resultAssessment = resultAssessment;
    }

    public String getChildScreenResult() {
        return this.childScreenResult;
    }

    public void setChildScreenResult(String childScreenResult) {
        this.childScreenResult = childScreenResult;
    }

    public String getChildScreenItem() {
        return this.childScreenItem;
    }

    public void setChildScreenItem(String childScreenItem) {
        this.childScreenItem = childScreenItem;
    }

    public String getChildDiseaseScreenId() {
        return this.childDiseaseScreenId;
    }

    public void setChildDiseaseScreenId(String childDiseaseScreenId) {
        this.childDiseaseScreenId = childDiseaseScreenId;
    }

    public String getChildDiseaseScreenResultId() {
        return this.childDiseaseScreenResultId;
    }

    public void setChildDiseaseScreenResultId(String childDiseaseScreenResultId) {
        this.childDiseaseScreenResultId = childDiseaseScreenResultId;
    }

    @Generated(hash = 1366797090)
    public ChildDiseaseScreenResult(String childDiseaseScreenResultId,
            String childDiseaseScreenId, String childScreenItem,
            String childScreenResult, String resultAssessment, String notes,
            Integer isCancel, String createOrgId, String orgName, String creatorId,
            String creator, Date createTime, String modifiedOrgId,
            String modifiedOrgName, String modifierId, String modifier,
            Date modifiedTime) {
        this.childDiseaseScreenResultId = childDiseaseScreenResultId;
        this.childDiseaseScreenId = childDiseaseScreenId;
        this.childScreenItem = childScreenItem;
        this.childScreenResult = childScreenResult;
        this.resultAssessment = resultAssessment;
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

    @Generated(hash = 329086018)
    public ChildDiseaseScreenResult() {
    }

}