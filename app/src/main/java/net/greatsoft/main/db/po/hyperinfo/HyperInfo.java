package net.greatsoft.main.db.po.hyperinfo;

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
 * @author AlphGo
 * @date 2016年7月4日 下午12:45:45
 * @Description: 高血压患者专档数据模型
 *
 */
@Entity
public class HyperInfo extends Entry {
	/**
	 * 高血压患者专档ID
	 */
	private String hyperInfoId;

	/**
	 * 个人档案ID
	 */
	private String personInfoId;

	/**
	 * 管理机构ID
	 */
	private String manageOrgId;

	/**
	 * 建档医生ID
	 */
	private String respDoctorId;

	/**
	 * 建档医生姓名
	 */
	private String respDoctorName;

	/**
	 * 高血压患者专档编号
	 */
	private String hyperInfoNo;

	/**
	 * 高血压管理级别代码
	 */
	private String hyperManagLevelCode;

	/**
	 * 高血压管理级别名称
	 */
	private String hyperManagLevelName;

	/**
	 * 高血压类别代码
	 */
	private String hyperTypeCode;

	/**
	 * 确诊收缩压(mmHg)
	 */
	private Integer diagnoseSbp;

	/**
	 * 确诊舒张压(mmHg)
	 */
	private Integer diagnoseDbp;

	/**
	 * 个人史
	 */
	private String personalHistory;

	/**
	 * 过敏史代码
	 */
	private String allergicHistoryCode;

	/**
	 * 过敏史中文
	 */
	private String allergicHistoryValue;

	/**
	 * 确诊时间
	 */
	private Date diagnoseDate;

	/**
	 * 确诊单位
	 */
	private String diagnoseOrgName;
	
	/**
	 * 建档日期
	 */
	private Date userCreateTime;

	/**
	 * 并发症标志
	 */
	private String complicationCode;

	/**
	 * 生活自理能力
	 */
	private String selfCareCode;

	/**
	 * 吸烟标志
	 */
	private String smokingCode;

	/**
	 * 饮酒标志
	 */
	private String drinkingCode;

	/**
	 * 体力活动标志
	 */
	private String exerciseCode;

	/**
	 * 身高(cm)
	 */
	private Double height;

	/**
	 * 体重(kg)
	 */
	private Double weight;

	/**
	 * 脉搏（次/分钟）
	 */
	private Integer pulse;

	/**
	 * 心率（次/分钟）
	 */
	private Integer heartRate;

	/**
	 * 收缩压(mmHg)
	 */
	private Integer sbp;

	/**
	 * 舒张压(mmHg)
	 */
	private Integer dbp;

	/**
	 * 空腹血糖值（mmol/L)
	 */
	private Double fbg;

	/**
	 * 餐后两小时血糖值（mmol/L)
	 */
	private Double pbg;

	/**
	 * 甘油三酯值（mmol/L)
	 */
	private Double tg;

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
	 * 尿微量白蛋白（mg/dL)
	 */
	private Double urineMalb;

	/**
	 * 心电图检查结果
	 */
	private String ecgResult;

	/**
	 * 其他检查
	 */
	private String othersExam;

	/**
	 * 是否使用降压药
	 */
	private String hasUseDrugs;
	/**
	 * 限盐饮食标志
	 */
	private String limitSaltCode;

	/**
	 * 体力活动治疗标志
	 */
	private String physicalActivityCode;

	/**
	 * 戒烟标志
	 */
	private String stopSmokingCode;
	/**
	 * 定点医疗机构
	 */
	private String healthcareOrg;

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
	 * 选项指标记录 json串
	 */
	private String jsonDetail;

	//籍贯
	private String householdRegister;

	@Transient
	List<RecordChoice> recordChoice;
	@Transient
	List<HyperInfoDrug> hyperInfoDrug;

	public List<RecordChoice> getRecordChoice() {
		return recordChoice;
	}

	public void setRecordChoice(List<RecordChoice> recordChoice) {
		this.recordChoice = recordChoice;
	}

	public List<HyperInfoDrug> getHyperInfoDrug() {
		return hyperInfoDrug;
	}

	public void setHyperInfoDrug(List<HyperInfoDrug> hyperInfoDrug) {
		this.hyperInfoDrug = hyperInfoDrug;
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
	public String getHealthcareOrg() {
		return this.healthcareOrg;
	}
	public void setHealthcareOrg(String healthcareOrg) {
		this.healthcareOrg = healthcareOrg;
	}
	public String getStopSmokingCode() {
		return this.stopSmokingCode;
	}
	public void setStopSmokingCode(String stopSmokingCode) {
		this.stopSmokingCode = stopSmokingCode;
	}
	public String getPhysicalActivityCode() {
		return this.physicalActivityCode;
	}
	public void setPhysicalActivityCode(String physicalActivityCode) {
		this.physicalActivityCode = physicalActivityCode;
	}
	public String getLimitSaltCode() {
		return this.limitSaltCode;
	}
	public void setLimitSaltCode(String limitSaltCode) {
		this.limitSaltCode = limitSaltCode;
	}
	public String getHasUseDrugs() {
		return this.hasUseDrugs;
	}
	public void setHasUseDrugs(String hasUseDrugs) {
		this.hasUseDrugs = hasUseDrugs;
	}
	public String getOthersExam() {
		return this.othersExam;
	}
	public void setOthersExam(String othersExam) {
		this.othersExam = othersExam;
	}
	public String getEcgResult() {
		return this.ecgResult;
	}
	public void setEcgResult(String ecgResult) {
		this.ecgResult = ecgResult;
	}
	public Double getUrineMalb() {
		return this.urineMalb;
	}
	public void setUrineMalb(Double urineMalb) {
		this.urineMalb = urineMalb;
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
	public Double getTg() {
		return this.tg;
	}
	public void setTg(Double tg) {
		this.tg = tg;
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
	public Integer getHeartRate() {
		return this.heartRate;
	}
	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}
	public Integer getPulse() {
		return this.pulse;
	}
	public void setPulse(Integer pulse) {
		this.pulse = pulse;
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
	public String getExerciseCode() {
		return this.exerciseCode;
	}
	public void setExerciseCode(String exerciseCode) {
		this.exerciseCode = exerciseCode;
	}
	public String getDrinkingCode() {
		return this.drinkingCode;
	}
	public void setDrinkingCode(String drinkingCode) {
		this.drinkingCode = drinkingCode;
	}
	public String getSmokingCode() {
		return this.smokingCode;
	}
	public void setSmokingCode(String smokingCode) {
		this.smokingCode = smokingCode;
	}
	public String getSelfCareCode() {
		return this.selfCareCode;
	}
	public void setSelfCareCode(String selfCareCode) {
		this.selfCareCode = selfCareCode;
	}
	public String getComplicationCode() {
		return this.complicationCode;
	}
	public void setComplicationCode(String complicationCode) {
		this.complicationCode = complicationCode;
	}
	public Date getUserCreateTime() {
		return this.userCreateTime;
	}
	public void setUserCreateTime(Date userCreateTime) {
		this.userCreateTime = userCreateTime;
	}
	public String getDiagnoseOrgName() {
		return this.diagnoseOrgName;
	}
	public void setDiagnoseOrgName(String diagnoseOrgName) {
		this.diagnoseOrgName = diagnoseOrgName;
	}
	public Date getDiagnoseDate() {
		return this.diagnoseDate;
	}
	public void setDiagnoseDate(Date diagnoseDate) {
		this.diagnoseDate = diagnoseDate;
	}
	public String getAllergicHistoryValue() {
		return this.allergicHistoryValue;
	}
	public void setAllergicHistoryValue(String allergicHistoryValue) {
		this.allergicHistoryValue = allergicHistoryValue;
	}
	public String getAllergicHistoryCode() {
		return this.allergicHistoryCode;
	}
	public void setAllergicHistoryCode(String allergicHistoryCode) {
		this.allergicHistoryCode = allergicHistoryCode;
	}
	public String getPersonalHistory() {
		return this.personalHistory;
	}
	public void setPersonalHistory(String personalHistory) {
		this.personalHistory = personalHistory;
	}
	public Integer getDiagnoseDbp() {
		return this.diagnoseDbp;
	}
	public void setDiagnoseDbp(Integer diagnoseDbp) {
		this.diagnoseDbp = diagnoseDbp;
	}
	public Integer getDiagnoseSbp() {
		return this.diagnoseSbp;
	}
	public void setDiagnoseSbp(Integer diagnoseSbp) {
		this.diagnoseSbp = diagnoseSbp;
	}
	public String getHyperTypeCode() {
		return this.hyperTypeCode;
	}
	public void setHyperTypeCode(String hyperTypeCode) {
		this.hyperTypeCode = hyperTypeCode;
	}
	public String getHyperManagLevelName() {
		return this.hyperManagLevelName;
	}
	public void setHyperManagLevelName(String hyperManagLevelName) {
		this.hyperManagLevelName = hyperManagLevelName;
	}
	public String getHyperManagLevelCode() {
		return this.hyperManagLevelCode;
	}
	public void setHyperManagLevelCode(String hyperManagLevelCode) {
		this.hyperManagLevelCode = hyperManagLevelCode;
	}
	public String getHyperInfoNo() {
		return this.hyperInfoNo;
	}
	public void setHyperInfoNo(String hyperInfoNo) {
		this.hyperInfoNo = hyperInfoNo;
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
	public String getHyperInfoId() {
		return this.hyperInfoId;
	}
	public void setHyperInfoId(String hyperInfoId) {
		this.hyperInfoId = hyperInfoId;
	}
	@Generated(hash = 2082627392)
	public HyperInfo(String hyperInfoId, String personInfoId, String manageOrgId,
			String respDoctorId, String respDoctorName, String hyperInfoNo,
			String hyperManagLevelCode, String hyperManagLevelName, String hyperTypeCode,
			Integer diagnoseSbp, Integer diagnoseDbp, String personalHistory,
			String allergicHistoryCode, String allergicHistoryValue, Date diagnoseDate,
			String diagnoseOrgName, Date userCreateTime, String complicationCode,
			String selfCareCode, String smokingCode, String drinkingCode,
			String exerciseCode, Double height, Double weight, Integer pulse,
			Integer heartRate, Integer sbp, Integer dbp, Double fbg, Double pbg,
			Double tg, Double tcho, Double ldlc, Double hdlc, String retionopathyCode,
			String neuropathyCode, Double urineMalb, String ecgResult, String othersExam,
			String hasUseDrugs, String limitSaltCode, String physicalActivityCode,
			String stopSmokingCode, String healthcareOrg, String limitAlcoholCode,
			Date lastVisitDate, Date nextVisitDate, Integer isCancel, String createOrgId,
			String orgName, String creatorId, String creator, Date createTime,
			String modifiedOrgId, String modifiedOrgName, String modifierId,
			String modifier, Date modifiedTime, String jsonDetail,
			String householdRegister) {
		this.hyperInfoId = hyperInfoId;
		this.personInfoId = personInfoId;
		this.manageOrgId = manageOrgId;
		this.respDoctorId = respDoctorId;
		this.respDoctorName = respDoctorName;
		this.hyperInfoNo = hyperInfoNo;
		this.hyperManagLevelCode = hyperManagLevelCode;
		this.hyperManagLevelName = hyperManagLevelName;
		this.hyperTypeCode = hyperTypeCode;
		this.diagnoseSbp = diagnoseSbp;
		this.diagnoseDbp = diagnoseDbp;
		this.personalHistory = personalHistory;
		this.allergicHistoryCode = allergicHistoryCode;
		this.allergicHistoryValue = allergicHistoryValue;
		this.diagnoseDate = diagnoseDate;
		this.diagnoseOrgName = diagnoseOrgName;
		this.userCreateTime = userCreateTime;
		this.complicationCode = complicationCode;
		this.selfCareCode = selfCareCode;
		this.smokingCode = smokingCode;
		this.drinkingCode = drinkingCode;
		this.exerciseCode = exerciseCode;
		this.height = height;
		this.weight = weight;
		this.pulse = pulse;
		this.heartRate = heartRate;
		this.sbp = sbp;
		this.dbp = dbp;
		this.fbg = fbg;
		this.pbg = pbg;
		this.tg = tg;
		this.tcho = tcho;
		this.ldlc = ldlc;
		this.hdlc = hdlc;
		this.retionopathyCode = retionopathyCode;
		this.neuropathyCode = neuropathyCode;
		this.urineMalb = urineMalb;
		this.ecgResult = ecgResult;
		this.othersExam = othersExam;
		this.hasUseDrugs = hasUseDrugs;
		this.limitSaltCode = limitSaltCode;
		this.physicalActivityCode = physicalActivityCode;
		this.stopSmokingCode = stopSmokingCode;
		this.healthcareOrg = healthcareOrg;
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
		this.jsonDetail = jsonDetail;
		this.householdRegister = householdRegister;
	}
	@Generated(hash = 687253297)
	@Keep
	public HyperInfo() {
		recordChoice = new ArrayList<>();
		hyperInfoDrug = new ArrayList<>();
	}

}