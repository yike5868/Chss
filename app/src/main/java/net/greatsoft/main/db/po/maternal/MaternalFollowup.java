package net.greatsoft.main.db.po.maternal;

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
 * 
 * @author hn
 * @date 2016年7月11日 下午5:39:55 
 * @Description: 孕产妇非首次产前随访
 *
 */
@Entity
public class MaternalFollowup extends Entry {
    /**
     * 孕产妇产前随访ID
     */
    
    private String maternalFollowupId;

    /**
     * 孕产妇基本信息ID
     */
    
    private String maternalInfoId;
    
    /**
     * 个人档案ID
     */
    
    private String personInfoId;
    
    /**
     * 孕产妇产前随访编号
     */
    
    private String maternalFollowupNo;
    
	/**
	 * 孕产登记ID
	 */
	private String maternalRegisterId;

    /**
     * 孕产登记次数
     */
    private Integer pregnantCount;

    /**
     * 本人姓名
     */
    private String name;
    
    /**
     * 服务次数
     */
    private Integer serviceTimes;

    /**
     * 本次随访日期
     */
    private Date followupDate;

    /**
     * 随访方式代码
     */
    private String followupWayCode;

    /**
     * 孕周(周)
     */
    private Integer gestWeeks;
    /**
     * 孕周(天)
     */
    private Integer gestDays;

    /**
     * 体重(kg)
     */
    private Double weight;

    /**
     * 主诉
     */
    private String chiefComplaint;

    /**
     * 宫底高度（cm)
     */
    private Double fundusHeight;

    /**
     * 腹围（cm)
     */
    private Double abdomenCircum;

    /**
     * 胎方位代码
     */
    private String fetusPositionCode;
    
    /**
     * 胎方位
     */
    private String fetusPositionValue;

    /**
     * 胎心率（次/min)
     */
    private String fetalHeartRate;

    /**
     * 收缩压(mmHg)
     */
    private Integer sbp;

    /**
     * 舒张压(mmHg)
     */
    private Integer dbp;

    /**
     * 血红蛋白值(g/L)
     */
    private Double hgb;

    /**
     * 尿蛋白定量检测值(mg/24h)
     */
    private Double proQuanTestValue;

    /**
     * 尿蛋白定性检测结果代码
     */
    private String proQualResultCode;

    /**
     * 其他辅助检查
     */
    private String otherAssistExam;

    /**
     * 孕产妇健康评估异常标志
     */
    private String pregHealthAbnormCode;

    /**
     * 孕产妇健康评估异常结果描述
     */
    private String pregHealthAbnormDesc;

    /**
     * 转诊标志
     */
    private String referralCode;

    /**
     * 转入医疗机构名称
     */
    private String refertoOrgName;

    /**
     * 转入机构科室名称
     */
    private String refertoDeptName;

    /**
     * 转诊原因
     */
    private String referralReason;

    /**
     * 下次随访日期
     */
    private Date nextFollowupDate;

    /**
     * 上次随访日期
     */
    private Date previousVisitDate;

    /**
     * 上次随访医师
     */
    
	private String previousVisitPerson;

    /**
     * 上次随访类型
     */
	private String previousVisitTypeCode;
	
    /**
     * 本次随访医师id
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

    public String getPreviousVisitTypeCode() {
        return this.previousVisitTypeCode;
    }

    public void setPreviousVisitTypeCode(String previousVisitTypeCode) {
        this.previousVisitTypeCode = previousVisitTypeCode;
    }

    public String getPreviousVisitPerson() {
        return this.previousVisitPerson;
    }

    public void setPreviousVisitPerson(String previousVisitPerson) {
        this.previousVisitPerson = previousVisitPerson;
    }

    public Date getPreviousVisitDate() {
        return this.previousVisitDate;
    }

    public void setPreviousVisitDate(Date previousVisitDate) {
        this.previousVisitDate = previousVisitDate;
    }

    public Date getNextFollowupDate() {
        return this.nextFollowupDate;
    }

    public void setNextFollowupDate(Date nextFollowupDate) {
        this.nextFollowupDate = nextFollowupDate;
    }

    public String getReferralReason() {
        return this.referralReason;
    }

    public void setReferralReason(String referralReason) {
        this.referralReason = referralReason;
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

    public String getReferralCode() {
        return this.referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getPregHealthAbnormDesc() {
        return this.pregHealthAbnormDesc;
    }

    public void setPregHealthAbnormDesc(String pregHealthAbnormDesc) {
        this.pregHealthAbnormDesc = pregHealthAbnormDesc;
    }

    public String getPregHealthAbnormCode() {
        return this.pregHealthAbnormCode;
    }

    public void setPregHealthAbnormCode(String pregHealthAbnormCode) {
        this.pregHealthAbnormCode = pregHealthAbnormCode;
    }

    public String getOtherAssistExam() {
        return this.otherAssistExam;
    }

    public void setOtherAssistExam(String otherAssistExam) {
        this.otherAssistExam = otherAssistExam;
    }

    public String getProQualResultCode() {
        return this.proQualResultCode;
    }

    public void setProQualResultCode(String proQualResultCode) {
        this.proQualResultCode = proQualResultCode;
    }

    public Double getProQuanTestValue() {
        return this.proQuanTestValue;
    }

    public void setProQuanTestValue(Double proQuanTestValue) {
        this.proQuanTestValue = proQuanTestValue;
    }

    public Double getHgb() {
        return this.hgb;
    }

    public void setHgb(Double hgb) {
        this.hgb = hgb;
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

    public String getFetalHeartRate() {
        return this.fetalHeartRate;
    }

    public void setFetalHeartRate(String fetalHeartRate) {
        this.fetalHeartRate = fetalHeartRate;
    }

    public String getFetusPositionValue() {
        return this.fetusPositionValue;
    }

    public void setFetusPositionValue(String fetusPositionValue) {
        this.fetusPositionValue = fetusPositionValue;
    }

    public String getFetusPositionCode() {
        return this.fetusPositionCode;
    }

    public void setFetusPositionCode(String fetusPositionCode) {
        this.fetusPositionCode = fetusPositionCode;
    }

    public Double getAbdomenCircum() {
        return this.abdomenCircum;
    }

    public void setAbdomenCircum(Double abdomenCircum) {
        this.abdomenCircum = abdomenCircum;
    }

    public Double getFundusHeight() {
        return this.fundusHeight;
    }

    public void setFundusHeight(Double fundusHeight) {
        this.fundusHeight = fundusHeight;
    }

    public String getChiefComplaint() {
        return this.chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getGestDays() {
        return this.gestDays;
    }

    public void setGestDays(Integer gestDays) {
        this.gestDays = gestDays;
    }

    public Integer getGestWeeks() {
        return this.gestWeeks;
    }

    public void setGestWeeks(Integer gestWeeks) {
        this.gestWeeks = gestWeeks;
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

    public Integer getServiceTimes() {
        return this.serviceTimes;
    }

    public void setServiceTimes(Integer serviceTimes) {
        this.serviceTimes = serviceTimes;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPregnantCount() {
        return this.pregnantCount;
    }

    public void setPregnantCount(Integer pregnantCount) {
        this.pregnantCount = pregnantCount;
    }

    public String getMaternalRegisterId() {
        return this.maternalRegisterId;
    }

    public void setMaternalRegisterId(String maternalRegisterId) {
        this.maternalRegisterId = maternalRegisterId;
    }

    public String getMaternalFollowupNo() {
        return this.maternalFollowupNo;
    }

    public void setMaternalFollowupNo(String maternalFollowupNo) {
        this.maternalFollowupNo = maternalFollowupNo;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getMaternalInfoId() {
        return this.maternalInfoId;
    }

    public void setMaternalInfoId(String maternalInfoId) {
        this.maternalInfoId = maternalInfoId;
    }

    public String getMaternalFollowupId() {
        return this.maternalFollowupId;
    }

    public void setMaternalFollowupId(String maternalFollowupId) {
        this.maternalFollowupId = maternalFollowupId;
    }

    @Generated(hash = 1243828891)
    public MaternalFollowup(String maternalFollowupId, String maternalInfoId,
            String personInfoId, String maternalFollowupNo,
            String maternalRegisterId, Integer pregnantCount, String name,
            Integer serviceTimes, Date followupDate, String followupWayCode,
            Integer gestWeeks, Integer gestDays, Double weight,
            String chiefComplaint, Double fundusHeight, Double abdomenCircum,
            String fetusPositionCode, String fetusPositionValue,
            String fetalHeartRate, Integer sbp, Integer dbp, Double hgb,
            Double proQuanTestValue, String proQualResultCode,
            String otherAssistExam, String pregHealthAbnormCode,
            String pregHealthAbnormDesc, String referralCode,
            String refertoOrgName, String refertoDeptName, String referralReason,
            Date nextFollowupDate, Date previousVisitDate,
            String previousVisitPerson, String previousVisitTypeCode,
            String followupDoctorId, String followupDoctorName, Integer isCancel,
            String createOrgId, String orgName, String creatorId, String creator,
            Date createTime, String modifiedOrgId, String modifiedOrgName,
            String modifierId, String modifier, Date modifiedTime) {
        this.maternalFollowupId = maternalFollowupId;
        this.maternalInfoId = maternalInfoId;
        this.personInfoId = personInfoId;
        this.maternalFollowupNo = maternalFollowupNo;
        this.maternalRegisterId = maternalRegisterId;
        this.pregnantCount = pregnantCount;
        this.name = name;
        this.serviceTimes = serviceTimes;
        this.followupDate = followupDate;
        this.followupWayCode = followupWayCode;
        this.gestWeeks = gestWeeks;
        this.gestDays = gestDays;
        this.weight = weight;
        this.chiefComplaint = chiefComplaint;
        this.fundusHeight = fundusHeight;
        this.abdomenCircum = abdomenCircum;
        this.fetusPositionCode = fetusPositionCode;
        this.fetusPositionValue = fetusPositionValue;
        this.fetalHeartRate = fetalHeartRate;
        this.sbp = sbp;
        this.dbp = dbp;
        this.hgb = hgb;
        this.proQuanTestValue = proQuanTestValue;
        this.proQualResultCode = proQualResultCode;
        this.otherAssistExam = otherAssistExam;
        this.pregHealthAbnormCode = pregHealthAbnormCode;
        this.pregHealthAbnormDesc = pregHealthAbnormDesc;
        this.referralCode = referralCode;
        this.refertoOrgName = refertoOrgName;
        this.refertoDeptName = refertoDeptName;
        this.referralReason = referralReason;
        this.nextFollowupDate = nextFollowupDate;
        this.previousVisitDate = previousVisitDate;
        this.previousVisitPerson = previousVisitPerson;
        this.previousVisitTypeCode = previousVisitTypeCode;
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

    @Generated(hash = 1129765424)@Keep
    public MaternalFollowup() {
        recordChoice = new ArrayList<>();
    }

}