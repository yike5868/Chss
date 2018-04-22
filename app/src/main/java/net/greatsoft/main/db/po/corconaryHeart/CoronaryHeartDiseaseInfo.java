package net.greatsoft.main.db.po.corconaryHeart;

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
 * @author HS
 * @date 2016年11月12日 下午12:25:20
 * @Description: 冠心病管理卡
 *
 */

@Entity
public class CoronaryHeartDiseaseInfo extends Entry {

	/**
	 * 冠心病患者管理卡随访ID
	 */
	private String coronaryHeartDiseaseInfoId;

	/**
	 * 个人档案ID
	 */
	private String personInfoId;

	/**
	 * 管理机构ID
	 */
	private String manageOrgId;

	/**
	 * 管理卡编号
	 */
	private String heartDiseaseInfoNo;

	/**
	 * 管理组别
	 */
	private String manageGroup;

	/**
	 * 建卡日期
	 */
	private Date userCreateTime;

	/**
	 * 病例来源
	 */
	private String caseSource;

	/**
	 * 冠心病确诊日期
	 */
	private Date confirmDate;

	/**
	 * 确诊机构
	 */
	private String confirmOrgName;

	/**
	 * 冠心病类型
	 */
	private String heartDiseaseType;

	/**
	 * 身高（cm)
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
	 * 收缩压(mmHg)
	 */
	private Integer sbp;

	/**
	 * 舒张压(mmHg)
	 */
	private Integer dbp;

	/**
	 * 腰围(cm)
	 */
	private Double waist;

	/**
	 * 空腹血糖值（mmol/L)
	 */
	private Double fbgMmol;

	/**
	 * 餐后2小时血糖值（mmol/L)
	 */
	private Double pbgMmol;

	/**
	 * 总胆固醇值（mmol/L)
	 */
	private Double tcho;

	/**
	 * 甘油三酯值（mmol/L)
	 */
	private Double tg;

	/**
	 * 血清低密度脂蛋白胆固醇检测值（mmol/L)
	 */
	private Double ldlc;

	/**
	 * 血淸高密度脂蛋白胆固醇检测值(mmol/L)
	 */
	private Double hdlc;

	/**
	 * 体检日期
	 */
	private Date checkDate;

	/**
	 * 心率(次/min)
	 */
	private Integer heartRate;

	/**
	 * 心电图检查结果
	 */
	private String ecgAbnormResult;

	/**
	 * 心脏彩超检查结果
	 */
	private String heartCheckResult;

	/**
	 * 冠状动脉造影结果
	 */
    private String coronaryArteryResult;

	/**
	 * 心电图运动负荷试验结果
	 */
	private String ecgExerciseResult;

	/**
	 * 心肌酶学检查结果（u/L）
	 */
	private String cardiacEnzymesResult;

	/**
	 * 锻炼频率代码
	 */
	private String exerciseFreqCode;

	/**
	 * 吸烟状况代码
	 */
	private String smokingStatusCode;

	/**
	 * 饮酒频率代码
	 */
	private String drinkingFreqCode;

	/**
	 * 生活自理能力自我评估代码
	 */
	private String selfCareAssessCode;

	/**
	 * 是否用药
	 */
	private String hasUseDrugs;

	/**
	 * 服药依从性代码
	 */
	private String drugComplianceCode;

	/**
	 * 是否终止管理
	 */
	private String hasEndManage;

	/**
	 * 终止管理日期
	 */
	private Date endManageDate;

	/**
	 * 终止管理原因
	 */
	private String endManageReason;

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
	 * 选项指标记录 json串
	 */
	private String jsonDetail;

    /**
     * 冠心病患者专档用药
     */
    @Transient
	private List<ChdInfoDrugs> chdInfoDrug;
    

	/**
	 * 考核项总数
	 */
	private Integer assessmentCount;

	/**
	 * 考核未通过数
	 */
	private Integer missingCount;

	/**
	 * 完整率
	 */
	private Double intactRate;

	/**
	 * 选项指标记录
	 */
    @Transient
    private List<RecordChoice> recordChoice;

	/**
	 * 是否是程序自动创建的管理卡，1是，其他值否
	 */
	private String isAutoBuild;

    public List<ChdInfoDrugs> getChdInfoDrug() {
        return chdInfoDrug;
    }

    public void setChdInfoDrug(List<ChdInfoDrugs> chdInfoDrug) {
        this.chdInfoDrug = chdInfoDrug;
    }

    public List<RecordChoice> getRecordChoice() {
        return recordChoice;
    }

    public void setRecordChoice(List<RecordChoice> recordChoice) {
        this.recordChoice = recordChoice;
    }

    public String getIsAutoBuild() {
		return this.isAutoBuild;
	}

	public void setIsAutoBuild(String isAutoBuild) {
		this.isAutoBuild = isAutoBuild;
	}

	public Double getIntactRate() {
		return this.intactRate;
	}

	public void setIntactRate(Double intactRate) {
		this.intactRate = intactRate;
	}

	public Integer getMissingCount() {
		return this.missingCount;
	}

	public void setMissingCount(Integer missingCount) {
		this.missingCount = missingCount;
	}

	public Integer getAssessmentCount() {
		return this.assessmentCount;
	}

	public void setAssessmentCount(Integer assessmentCount) {
		this.assessmentCount = assessmentCount;
	}

	public String getJsonDetail() {
		return this.jsonDetail;
	}

	public void setJsonDetail(String jsonDetail) {
		this.jsonDetail = jsonDetail;
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

	public String getEndManageReason() {
		return this.endManageReason;
	}

	public void setEndManageReason(String endManageReason) {
		this.endManageReason = endManageReason;
	}

	public Date getEndManageDate() {
		return this.endManageDate;
	}

	public void setEndManageDate(Date endManageDate) {
		this.endManageDate = endManageDate;
	}

	public String getHasEndManage() {
		return this.hasEndManage;
	}

	public void setHasEndManage(String hasEndManage) {
		this.hasEndManage = hasEndManage;
	}

	public String getDrugComplianceCode() {
		return this.drugComplianceCode;
	}

	public void setDrugComplianceCode(String drugComplianceCode) {
		this.drugComplianceCode = drugComplianceCode;
	}

	public String getHasUseDrugs() {
		return this.hasUseDrugs;
	}

	public void setHasUseDrugs(String hasUseDrugs) {
		this.hasUseDrugs = hasUseDrugs;
	}

	public String getSelfCareAssessCode() {
		return this.selfCareAssessCode;
	}

	public void setSelfCareAssessCode(String selfCareAssessCode) {
		this.selfCareAssessCode = selfCareAssessCode;
	}

	public String getDrinkingFreqCode() {
		return this.drinkingFreqCode;
	}

	public void setDrinkingFreqCode(String drinkingFreqCode) {
		this.drinkingFreqCode = drinkingFreqCode;
	}

	public String getSmokingStatusCode() {
		return this.smokingStatusCode;
	}

	public void setSmokingStatusCode(String smokingStatusCode) {
		this.smokingStatusCode = smokingStatusCode;
	}

	public String getExerciseFreqCode() {
		return this.exerciseFreqCode;
	}

	public void setExerciseFreqCode(String exerciseFreqCode) {
		this.exerciseFreqCode = exerciseFreqCode;
	}

	public String getCardiacEnzymesResult() {
		return this.cardiacEnzymesResult;
	}

	public void setCardiacEnzymesResult(String cardiacEnzymesResult) {
		this.cardiacEnzymesResult = cardiacEnzymesResult;
	}

	public String getEcgExerciseResult() {
		return this.ecgExerciseResult;
	}

	public void setEcgExerciseResult(String ecgExerciseResult) {
		this.ecgExerciseResult = ecgExerciseResult;
	}

	public String getCoronaryArteryResult() {
		return this.coronaryArteryResult;
	}

	public void setCoronaryArteryResult(String coronaryArteryResult) {
		this.coronaryArteryResult = coronaryArteryResult;
	}

	public String getHeartCheckResult() {
		return this.heartCheckResult;
	}

	public void setHeartCheckResult(String heartCheckResult) {
		this.heartCheckResult = heartCheckResult;
	}

	public String getEcgAbnormResult() {
		return this.ecgAbnormResult;
	}

	public void setEcgAbnormResult(String ecgAbnormResult) {
		this.ecgAbnormResult = ecgAbnormResult;
	}

	public Integer getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}

	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
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

	public Double getTg() {
		return this.tg;
	}

	public void setTg(Double tg) {
		this.tg = tg;
	}

	public Double getTcho() {
		return this.tcho;
	}

	public void setTcho(Double tcho) {
		this.tcho = tcho;
	}

	public Double getPbgMmol() {
		return this.pbgMmol;
	}

	public void setPbgMmol(Double pbgMmol) {
		this.pbgMmol = pbgMmol;
	}

	public Double getFbgMmol() {
		return this.fbgMmol;
	}

	public void setFbgMmol(Double fbgMmol) {
		this.fbgMmol = fbgMmol;
	}

	public Double getWaist() {
		return this.waist;
	}

	public void setWaist(Double waist) {
		this.waist = waist;
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

	public String getHeartDiseaseType() {
		return this.heartDiseaseType;
	}

	public void setHeartDiseaseType(String heartDiseaseType) {
		this.heartDiseaseType = heartDiseaseType;
	}

	public String getConfirmOrgName() {
		return this.confirmOrgName;
	}

	public void setConfirmOrgName(String confirmOrgName) {
		this.confirmOrgName = confirmOrgName;
	}

	public Date getConfirmDate() {
		return this.confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getCaseSource() {
		return this.caseSource;
	}

	public void setCaseSource(String caseSource) {
		this.caseSource = caseSource;
	}

	public Date getUserCreateTime() {
		return this.userCreateTime;
	}

	public void setUserCreateTime(Date userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public String getManageGroup() {
		return this.manageGroup;
	}

	public void setManageGroup(String manageGroup) {
		this.manageGroup = manageGroup;
	}

	public String getHeartDiseaseInfoNo() {
		return this.heartDiseaseInfoNo;
	}

	public void setHeartDiseaseInfoNo(String heartDiseaseInfoNo) {
		this.heartDiseaseInfoNo = heartDiseaseInfoNo;
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

	public String getCoronaryHeartDiseaseInfoId() {
		return this.coronaryHeartDiseaseInfoId;
	}

	public void setCoronaryHeartDiseaseInfoId(String coronaryHeartDiseaseInfoId) {
		this.coronaryHeartDiseaseInfoId = coronaryHeartDiseaseInfoId;
	}

	@Generated(hash = 959173451)
	public CoronaryHeartDiseaseInfo(String coronaryHeartDiseaseInfoId,
			String personInfoId, String manageOrgId, String heartDiseaseInfoNo,
			String manageGroup, Date userCreateTime, String caseSource, Date confirmDate,
			String confirmOrgName, String heartDiseaseType, Double height, Double weight,
			Double bmi, Integer sbp, Integer dbp, Double waist, Double fbgMmol,
			Double pbgMmol, Double tcho, Double tg, Double ldlc, Double hdlc,
			Date checkDate, Integer heartRate, String ecgAbnormResult,
			String heartCheckResult, String coronaryArteryResult,
			String ecgExerciseResult, String cardiacEnzymesResult,
			String exerciseFreqCode, String smokingStatusCode, String drinkingFreqCode,
			String selfCareAssessCode, String hasUseDrugs, String drugComplianceCode,
			String hasEndManage, Date endManageDate, String endManageReason,
			Integer isCancel, String createOrgId, String orgName, String creatorId,
			String creator, Date createTime, String modifiedOrgId,
			String modifiedOrgName, String modifierId, String modifier,
			Date modifiedTime, String jsonDetail, Integer assessmentCount,
			Integer missingCount, Double intactRate, String isAutoBuild) {
		this.coronaryHeartDiseaseInfoId = coronaryHeartDiseaseInfoId;
		this.personInfoId = personInfoId;
		this.manageOrgId = manageOrgId;
		this.heartDiseaseInfoNo = heartDiseaseInfoNo;
		this.manageGroup = manageGroup;
		this.userCreateTime = userCreateTime;
		this.caseSource = caseSource;
		this.confirmDate = confirmDate;
		this.confirmOrgName = confirmOrgName;
		this.heartDiseaseType = heartDiseaseType;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.sbp = sbp;
		this.dbp = dbp;
		this.waist = waist;
		this.fbgMmol = fbgMmol;
		this.pbgMmol = pbgMmol;
		this.tcho = tcho;
		this.tg = tg;
		this.ldlc = ldlc;
		this.hdlc = hdlc;
		this.checkDate = checkDate;
		this.heartRate = heartRate;
		this.ecgAbnormResult = ecgAbnormResult;
		this.heartCheckResult = heartCheckResult;
		this.coronaryArteryResult = coronaryArteryResult;
		this.ecgExerciseResult = ecgExerciseResult;
		this.cardiacEnzymesResult = cardiacEnzymesResult;
		this.exerciseFreqCode = exerciseFreqCode;
		this.smokingStatusCode = smokingStatusCode;
		this.drinkingFreqCode = drinkingFreqCode;
		this.selfCareAssessCode = selfCareAssessCode;
		this.hasUseDrugs = hasUseDrugs;
		this.drugComplianceCode = drugComplianceCode;
		this.hasEndManage = hasEndManage;
		this.endManageDate = endManageDate;
		this.endManageReason = endManageReason;
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
		this.jsonDetail = jsonDetail;
		this.assessmentCount = assessmentCount;
		this.missingCount = missingCount;
		this.intactRate = intactRate;
		this.isAutoBuild = isAutoBuild;
	}

	@Generated(hash = 1683302365)
    @Keep
	public CoronaryHeartDiseaseInfo() {
        recordChoice = new ArrayList<>();
        chdInfoDrug = new ArrayList<>();
    }

}