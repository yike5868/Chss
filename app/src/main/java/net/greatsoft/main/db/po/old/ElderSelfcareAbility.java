package net.greatsoft.main.db.po.old;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
/**
 * 
 * @author hn
 * @date 2016年7月25日 下午10:51:16 
 * @Description: 老年人自理能力评估表
 *
 */
@Entity
public class ElderSelfcareAbility extends Entry {
    /**
     * 老年人自理能力评估表ID
     */
    
    private String elderSelfcareAbilityId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;

    /**
     * 老年人健康状态自我评估代码
     */
    
    private String elderHealthAssessCode;

    /**
     * 进餐评分
     */
    private Integer dineScore;

    /**
     * 梳洗评分
     */
    private Integer cleanupScore;

    /**
     * 穿衣评分
     */
    private Integer dressedScore;

    /**
     * 如厕评分
     */
    private Integer defecationScore;

    /**
     * 活动评分
     */
    private Integer activityScore;

    /**
     * 总评分
     */
    private Integer totalScore;

    /**
     * 填表时间
     */
    
    
    private Date fillDate;

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

    public Date getFillDate() {
        return this.fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    public Integer getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getActivityScore() {
        return this.activityScore;
    }

    public void setActivityScore(Integer activityScore) {
        this.activityScore = activityScore;
    }

    public Integer getDefecationScore() {
        return this.defecationScore;
    }

    public void setDefecationScore(Integer defecationScore) {
        this.defecationScore = defecationScore;
    }

    public Integer getDressedScore() {
        return this.dressedScore;
    }

    public void setDressedScore(Integer dressedScore) {
        this.dressedScore = dressedScore;
    }

    public Integer getCleanupScore() {
        return this.cleanupScore;
    }

    public void setCleanupScore(Integer cleanupScore) {
        this.cleanupScore = cleanupScore;
    }

    public Integer getDineScore() {
        return this.dineScore;
    }

    public void setDineScore(Integer dineScore) {
        this.dineScore = dineScore;
    }

    public String getElderHealthAssessCode() {
        return this.elderHealthAssessCode;
    }

    public void setElderHealthAssessCode(String elderHealthAssessCode) {
        this.elderHealthAssessCode = elderHealthAssessCode;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getElderSelfcareAbilityId() {
        return this.elderSelfcareAbilityId;
    }

    public void setElderSelfcareAbilityId(String elderSelfcareAbilityId) {
        this.elderSelfcareAbilityId = elderSelfcareAbilityId;
    }

    @Generated(hash = 851522855)
    public ElderSelfcareAbility(String elderSelfcareAbilityId, String personInfoId,
            String elderHealthAssessCode, Integer dineScore, Integer cleanupScore,
            Integer dressedScore, Integer defecationScore, Integer activityScore,
            Integer totalScore, Date fillDate, Integer isCancel,
            String createOrgId, String orgName, String creatorId, String creator,
            Date createTime, String modifiedOrgId, String modifiedOrgName,
            String modifierId, String modifier, Date modifiedTime) {
        this.elderSelfcareAbilityId = elderSelfcareAbilityId;
        this.personInfoId = personInfoId;
        this.elderHealthAssessCode = elderHealthAssessCode;
        this.dineScore = dineScore;
        this.cleanupScore = cleanupScore;
        this.dressedScore = dressedScore;
        this.defecationScore = defecationScore;
        this.activityScore = activityScore;
        this.totalScore = totalScore;
        this.fillDate = fillDate;
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

    @Generated(hash = 334485931)
    public ElderSelfcareAbility() {
    }

}