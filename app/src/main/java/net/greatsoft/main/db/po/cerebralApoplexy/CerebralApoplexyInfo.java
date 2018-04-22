package net.greatsoft.main.db.po.cerebralApoplexy;

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
 * @date 2016年11月12日 下午12:25:33
 * @Description: 脑卒中患者管理卡
 *
 */
@Entity
public class CerebralApoplexyInfo extends Entry {

	/**
	 * 脑卒中患者管理卡ID
	 */
	private String cerebralApoplexyInfoId;

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
	 * 建卡日期
	 */
	private Date userCreateTime;

	/**
	 * 管理组别
	 */
	private String manageGroup;

	/**
	 * 病例来源
	 */
	private String caseSource;

	/**
	 * 发病时间
	 */
	private Date confirmDate;

	/**
	 * 诊断医院
	 */
	private String confirmOrgName;

	/**
	 * mRS评分
	 */
	private String mrsScore;

	/**
	 * CT检查结果
	 */
	private String ctResult;

	/**
	 * MRI检查结果
	 */
	private String mriResult;

	/**
	 * 脑卒中分类
	 */
	private String cerebralApoplexyType;

	/**
	 * 脑卒中部位
	 */
	private String cerebralApoplexyPosition;

	/**
	 * 生活自理能力自我评估代码
	 */
	private String selfCareAssessCode;

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
     * 脑卒中患者专档用药
     */
    @Transient
	private List<CaInfoDrugs> caInfoDrug;

	/**
	 * 选项指标记录
	 */
    @Transient
    private List< RecordChoice> recordChoice;

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
	 * 是否是程序自动创建的管理卡，1是，其他值否
	 */
	private String isAutoBuild;

    public List<CaInfoDrugs> getCaInfoDrug() {
        return caInfoDrug;
    }

    public void setCaInfoDrug(List<CaInfoDrugs> caInfoDrug) {
        this.caInfoDrug = caInfoDrug;
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

	public String getSelfCareAssessCode() {
		return this.selfCareAssessCode;
	}

	public void setSelfCareAssessCode(String selfCareAssessCode) {
		this.selfCareAssessCode = selfCareAssessCode;
	}

	public String getCerebralApoplexyPosition() {
		return this.cerebralApoplexyPosition;
	}

	public void setCerebralApoplexyPosition(String cerebralApoplexyPosition) {
		this.cerebralApoplexyPosition = cerebralApoplexyPosition;
	}

	public String getCerebralApoplexyType() {
		return this.cerebralApoplexyType;
	}

	public void setCerebralApoplexyType(String cerebralApoplexyType) {
		this.cerebralApoplexyType = cerebralApoplexyType;
	}

	public String getMriResult() {
		return this.mriResult;
	}

	public void setMriResult(String mriResult) {
		this.mriResult = mriResult;
	}

	public String getCtResult() {
		return this.ctResult;
	}

	public void setCtResult(String ctResult) {
		this.ctResult = ctResult;
	}

	public String getMrsScore() {
		return this.mrsScore;
	}

	public void setMrsScore(String mrsScore) {
		this.mrsScore = mrsScore;
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

	public String getManageGroup() {
		return this.manageGroup;
	}

	public void setManageGroup(String manageGroup) {
		this.manageGroup = manageGroup;
	}

	public Date getUserCreateTime() {
		return this.userCreateTime;
	}

	public void setUserCreateTime(Date userCreateTime) {
		this.userCreateTime = userCreateTime;
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

	public String getCerebralApoplexyInfoId() {
		return this.cerebralApoplexyInfoId;
	}

	public void setCerebralApoplexyInfoId(String cerebralApoplexyInfoId) {
		this.cerebralApoplexyInfoId = cerebralApoplexyInfoId;
	}

	@Generated(hash = 1895812517)
	public CerebralApoplexyInfo(String cerebralApoplexyInfoId, String personInfoId,
			String manageOrgId, String heartDiseaseInfoNo, Date userCreateTime,
			String manageGroup, String caseSource, Date confirmDate,
			String confirmOrgName, String mrsScore, String ctResult, String mriResult,
			String cerebralApoplexyType, String cerebralApoplexyPosition,
			String selfCareAssessCode, Double height, Double weight, Double bmi,
			Integer sbp, Integer dbp, Double waist, Double fbgMmol, Double pbgMmol,
			Double tcho, Double tg, Double ldlc, Double hdlc, Date checkDate,
			String hasUseDrugs, String drugComplianceCode, String hasEndManage,
			Date endManageDate, String endManageReason, Integer isCancel,
			String createOrgId, String orgName, String creatorId, String creator,
			Date createTime, String modifiedOrgId, String modifiedOrgName,
			String modifierId, String modifier, Date modifiedTime, String jsonDetail,
			Integer assessmentCount, Integer missingCount, Double intactRate,
			String isAutoBuild) {
		this.cerebralApoplexyInfoId = cerebralApoplexyInfoId;
		this.personInfoId = personInfoId;
		this.manageOrgId = manageOrgId;
		this.heartDiseaseInfoNo = heartDiseaseInfoNo;
		this.userCreateTime = userCreateTime;
		this.manageGroup = manageGroup;
		this.caseSource = caseSource;
		this.confirmDate = confirmDate;
		this.confirmOrgName = confirmOrgName;
		this.mrsScore = mrsScore;
		this.ctResult = ctResult;
		this.mriResult = mriResult;
		this.cerebralApoplexyType = cerebralApoplexyType;
		this.cerebralApoplexyPosition = cerebralApoplexyPosition;
		this.selfCareAssessCode = selfCareAssessCode;
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

	@Generated(hash = 224019169)
    @Keep
	public CerebralApoplexyInfo() {
        recordChoice = new ArrayList<>();
        caInfoDrug = new ArrayList<>();
    }
	
}
