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
 * @date 2016年7月11日 下午5:23:23 
 * @Description: 孕产妇第一次产前随访表
 *
 */
@Entity
public class MaternalFirstFollowup extends Entry {
    /**
     * 孕产妇第一次产前随访ID
     */
    
    private String maternalFirstFollowupId;

    /**
     * 孕产妇基本信息ID
     */
    
    private String maternalInfoId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;

    /**
     * 孕产妇第一次产前随访编号
     */
    
    private String maternalFirstFollowupNo;
    
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
     * 本次随访日期
     */
    
	
    private Date followupDate;

    /**
     * 随访方式代码
     */
    
    private String followupWayCode;

    /**
     * 孕周（周)
     */
    private Integer gestWeeks;
    
    /**
     * 孕周（天）
     */
    private Integer gestDays;

    /**
     * 年龄
     */
    
    private Integer age;

    /**
     * 丈夫姓名
     */
    
    private String husbandName;

    /**
     * 丈夫电话号码
     */
    
    private String husbandTelNo;
    
    /**
     * 丈夫年龄
     */
    private Integer husbandAge;

    /**
     * 丈夫出生日期
     */
    
	
    private Date husbandBirthday;

    /**
     * 孕次
     */
    private Integer gravidity;

    /**
     * 阴道分娩次数（次）
     */
    private Integer vaginalDeliveryTimes;

    /**
     * 剖宫产次数（次）
     */
    private Integer caesareanDeliveryTimes;

    /**
     * 末次月经日期明确标志
     */
    
    private String lastMensesCode;

    /**
     * 末次月经日期
     */
    
	
    private Date mensesLastDate;

    /**
     * 预产期
     */
    
	
    private Date expectedChildBirthday;

    /**
     * 妇科手术史标志
     */
    
    private String gynOpHistoryCode;

    /**
     * 妇科手术史
     */
    private String gynOpHistory;

    /**
     * 流产总次数(次)
     */
    private Integer abortionTimes;

    /**
     * 死产例数
     */
    private Integer stillbirthNum;

    /**
     * 死胎例数
     */
    private Integer deadFetusNum;

    /**
     * 新生儿死亡例数
     */
    private Integer newbornDeathNum;

    /**
     * 出生缺陷儿例数
     */
    private Integer birthDefectCount;

    /**
     * 身高(cm)
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
     * 肺部听诊异常标志
     */
    
    private String lungAbnormCode;

    /**
     * 肺部听诊异常结果描述
     */
    
    private String lungAbnormDesc;

    /**
     * 心脏听诊异常标志
     */
    
    private String heartAbnormCode;

    /**
     * 心脏听诊异常结果描述
     */
    
    private String heartAbnormDesc;

    /**
     * 外阴异常标志
     */
    
    private String vulvaAbnormCode;

    /**
     * 外阴异常描述
     */
    
    private String vulvaAbnormDesc;

    /**
     * 阴道异常标志
     */
    
    private String vaginaAbnormCode;

    /**
     * 阴道异常描述
     */
    
    private String vaginaAbnormDesc;

    /**
     * 宫颈异常标志
     */
    
    private String cervixAbnormCode;

    /**
     * 宫颈异常描述
     */
    
    private String cervixAbnormDesc;

    /**
     * 子宫异常标志
     */
    
    private String corpusuteriAbnormCode;

    /**
     * 子宫异常描述
     */
    
    private String corpusuteriAbnormDesc;

    /**
     * 附件异常标志
     */
    
    private String adnexaAbnormCode;

    /**
     * 附件异常描述
     */
    
    private String adnexaAbnormDesc;

    /**
     * 血红蛋白值(g/L)
     */
    
    private Double hgb;

    /**
     * 白细胞计数值(G/L)
     */
    
    private Double wbc;

    /**
     * 血小板计数值(G/L)
     */
    
    private Double plt;

    /**
     * 其他血常规
     */
    
    private String cbcOthers;

    /**
     * 尿蛋白定量检测值(mg/24h)
     */
    
    private Double proQuanTestValue;

    /**
     * 尿蛋白定性检测结果代码
     */
    
    private String proQualResultCode;

    /**
     * 尿糖定性检测结果代码
     */
    
    private String gluQualResultCode;

    /**
     * 尿糖定量检测（mmol/L)
     */
    
    private Double gluQuanTestValue;

    /**
     * 尿酮体定性检测结果代码
     */
    
    private String ketQualResultCode;

    /**
     * 尿潜血检测结果代码
     */
    
    private String uobTestResultCode;
    
    /**
     * 尿常规其他
     */
    
    private String urineRoutineOther;

    /**
     * 血型ABO/RH*
     */
    
    private String aboRhValue;
    
    /**
     * ABO血型代码
     */
    
    private String aboCode;

    /**
     * Rh血型代码
     */
    
    private String rhCode;

    /**
     * 血糖检测值（mmol/L）
     */
    
    private Double glu;

    /**
     * 血清谷丙转氨酶值（U/L)
     */
    
    private Double sgpt;

    /**
     * 血清谷草转氨酶值（U/L)
     */
    
    private Double ast;

    /**
     * 白蛋白浓度（g/L)
     */
    
    private Double alb;

    /**
     * 总胆红素值（μmol/L)
     */
    
    private Double tbi;

    /**
     * 结合胆红素值(μmol/L)
     */
    
    private Double dbil;

    /**
     * 血尿素氮检测值（mmol/L)
     */
    
    private Double bun;

    /**
     * 血肌酐值(μmol/L)
     */
    
    private Double scr;

    /**
     * 阴道分泌物淸洁度代码
     */
    
    private String wvdCleanCode;

    /**
     * 乙型肝炎病毒e抗体检测结果代码
     */
    
    private String hbeabTestResultCode;

    /**
     * 乙型肝炎病毒e抗原检测结果代码
     */
    
    private String hbeagTestResultCode;

    /**
     * 乙型肝炎病毒表面抗体检测结果代码
     */
    
    private String hbsabTestResultCode;

    /**
     * 乙型肝炎病毒表面抗原检测结果代码
     */
    
    private String hbsagTestResultCode;

    /**
     * 乙型肝炎病毒核心抗体检测结果代码
     */
    
    private String hbcabTestResultCode;

    /**
     * 梅毒血清学试验结果代码
     */
    
    private String stsResultCode;

    /**
     * HIV抗体检测结果代码
     */
    
    private String hivAntiResultCode;

    /**
     * B超检查结果
     */
    
    private String bscanResultDesc;

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
     * 下次随访日期
     */
    
	
    private Date nextFollowupDate;

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

    /**
     * 辅助检查其它
     */
    private String examOthers;

    public String getExamOthers() {
        return examOthers;
    }

    public void setExamOthers(String examOthers) {
        this.examOthers = examOthers;
    }

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


    public Date getNextFollowupDate() {
        return this.nextFollowupDate;
    }


    public void setNextFollowupDate(Date nextFollowupDate) {
        this.nextFollowupDate = nextFollowupDate;
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


    public String getBscanResultDesc() {
        return this.bscanResultDesc;
    }


    public void setBscanResultDesc(String bscanResultDesc) {
        this.bscanResultDesc = bscanResultDesc;
    }


    public String getHivAntiResultCode() {
        return this.hivAntiResultCode;
    }


    public void setHivAntiResultCode(String hivAntiResultCode) {
        this.hivAntiResultCode = hivAntiResultCode;
    }


    public String getStsResultCode() {
        return this.stsResultCode;
    }


    public void setStsResultCode(String stsResultCode) {
        this.stsResultCode = stsResultCode;
    }


    public String getHbcabTestResultCode() {
        return this.hbcabTestResultCode;
    }


    public void setHbcabTestResultCode(String hbcabTestResultCode) {
        this.hbcabTestResultCode = hbcabTestResultCode;
    }


    public String getHbsagTestResultCode() {
        return this.hbsagTestResultCode;
    }


    public void setHbsagTestResultCode(String hbsagTestResultCode) {
        this.hbsagTestResultCode = hbsagTestResultCode;
    }


    public String getHbsabTestResultCode() {
        return this.hbsabTestResultCode;
    }


    public void setHbsabTestResultCode(String hbsabTestResultCode) {
        this.hbsabTestResultCode = hbsabTestResultCode;
    }


    public String getHbeagTestResultCode() {
        return this.hbeagTestResultCode;
    }


    public void setHbeagTestResultCode(String hbeagTestResultCode) {
        this.hbeagTestResultCode = hbeagTestResultCode;
    }


    public String getHbeabTestResultCode() {
        return this.hbeabTestResultCode;
    }


    public void setHbeabTestResultCode(String hbeabTestResultCode) {
        this.hbeabTestResultCode = hbeabTestResultCode;
    }


    public String getWvdCleanCode() {
        return this.wvdCleanCode;
    }


    public void setWvdCleanCode(String wvdCleanCode) {
        this.wvdCleanCode = wvdCleanCode;
    }


    public Double getScr() {
        return this.scr;
    }


    public void setScr(Double scr) {
        this.scr = scr;
    }


    public Double getBun() {
        return this.bun;
    }


    public void setBun(Double bun) {
        this.bun = bun;
    }


    public Double getDbil() {
        return this.dbil;
    }


    public void setDbil(Double dbil) {
        this.dbil = dbil;
    }


    public Double getTbi() {
        return this.tbi;
    }


    public void setTbi(Double tbi) {
        this.tbi = tbi;
    }


    public Double getAlb() {
        return this.alb;
    }


    public void setAlb(Double alb) {
        this.alb = alb;
    }


    public Double getAst() {
        return this.ast;
    }


    public void setAst(Double ast) {
        this.ast = ast;
    }


    public Double getSgpt() {
        return this.sgpt;
    }


    public void setSgpt(Double sgpt) {
        this.sgpt = sgpt;
    }


    public Double getGlu() {
        return this.glu;
    }


    public void setGlu(Double glu) {
        this.glu = glu;
    }


    public String getRhCode() {
        return this.rhCode;
    }


    public void setRhCode(String rhCode) {
        this.rhCode = rhCode;
    }


    public String getAboCode() {
        return this.aboCode;
    }


    public void setAboCode(String aboCode) {
        this.aboCode = aboCode;
    }


    public String getAboRhValue() {
        return this.aboRhValue;
    }


    public void setAboRhValue(String aboRhValue) {
        this.aboRhValue = aboRhValue;
    }


    public String getUrineRoutineOther() {
        return this.urineRoutineOther;
    }


    public void setUrineRoutineOther(String urineRoutineOther) {
        this.urineRoutineOther = urineRoutineOther;
    }


    public String getUobTestResultCode() {
        return this.uobTestResultCode;
    }


    public void setUobTestResultCode(String uobTestResultCode) {
        this.uobTestResultCode = uobTestResultCode;
    }


    public String getKetQualResultCode() {
        return this.ketQualResultCode;
    }


    public void setKetQualResultCode(String ketQualResultCode) {
        this.ketQualResultCode = ketQualResultCode;
    }


    public Double getGluQuanTestValue() {
        return this.gluQuanTestValue;
    }


    public void setGluQuanTestValue(Double gluQuanTestValue) {
        this.gluQuanTestValue = gluQuanTestValue;
    }


    public String getGluQualResultCode() {
        return this.gluQualResultCode;
    }


    public void setGluQualResultCode(String gluQualResultCode) {
        this.gluQualResultCode = gluQualResultCode;
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


    public String getCbcOthers() {
        return this.cbcOthers;
    }


    public void setCbcOthers(String cbcOthers) {
        this.cbcOthers = cbcOthers;
    }


    public Double getPlt() {
        return this.plt;
    }


    public void setPlt(Double plt) {
        this.plt = plt;
    }


    public Double getWbc() {
        return this.wbc;
    }


    public void setWbc(Double wbc) {
        this.wbc = wbc;
    }


    public Double getHgb() {
        return this.hgb;
    }


    public void setHgb(Double hgb) {
        this.hgb = hgb;
    }


    public String getAdnexaAbnormDesc() {
        return this.adnexaAbnormDesc;
    }


    public void setAdnexaAbnormDesc(String adnexaAbnormDesc) {
        this.adnexaAbnormDesc = adnexaAbnormDesc;
    }


    public String getAdnexaAbnormCode() {
        return this.adnexaAbnormCode;
    }


    public void setAdnexaAbnormCode(String adnexaAbnormCode) {
        this.adnexaAbnormCode = adnexaAbnormCode;
    }


    public String getCorpusuteriAbnormDesc() {
        return this.corpusuteriAbnormDesc;
    }


    public void setCorpusuteriAbnormDesc(String corpusuteriAbnormDesc) {
        this.corpusuteriAbnormDesc = corpusuteriAbnormDesc;
    }


    public String getCorpusuteriAbnormCode() {
        return this.corpusuteriAbnormCode;
    }


    public void setCorpusuteriAbnormCode(String corpusuteriAbnormCode) {
        this.corpusuteriAbnormCode = corpusuteriAbnormCode;
    }


    public String getCervixAbnormDesc() {
        return this.cervixAbnormDesc;
    }


    public void setCervixAbnormDesc(String cervixAbnormDesc) {
        this.cervixAbnormDesc = cervixAbnormDesc;
    }


    public String getCervixAbnormCode() {
        return this.cervixAbnormCode;
    }


    public void setCervixAbnormCode(String cervixAbnormCode) {
        this.cervixAbnormCode = cervixAbnormCode;
    }


    public String getVaginaAbnormDesc() {
        return this.vaginaAbnormDesc;
    }


    public void setVaginaAbnormDesc(String vaginaAbnormDesc) {
        this.vaginaAbnormDesc = vaginaAbnormDesc;
    }


    public String getVaginaAbnormCode() {
        return this.vaginaAbnormCode;
    }


    public void setVaginaAbnormCode(String vaginaAbnormCode) {
        this.vaginaAbnormCode = vaginaAbnormCode;
    }


    public String getVulvaAbnormDesc() {
        return this.vulvaAbnormDesc;
    }


    public void setVulvaAbnormDesc(String vulvaAbnormDesc) {
        this.vulvaAbnormDesc = vulvaAbnormDesc;
    }


    public String getVulvaAbnormCode() {
        return this.vulvaAbnormCode;
    }


    public void setVulvaAbnormCode(String vulvaAbnormCode) {
        this.vulvaAbnormCode = vulvaAbnormCode;
    }


    public String getHeartAbnormDesc() {
        return this.heartAbnormDesc;
    }


    public void setHeartAbnormDesc(String heartAbnormDesc) {
        this.heartAbnormDesc = heartAbnormDesc;
    }


    public String getHeartAbnormCode() {
        return this.heartAbnormCode;
    }


    public void setHeartAbnormCode(String heartAbnormCode) {
        this.heartAbnormCode = heartAbnormCode;
    }


    public String getLungAbnormDesc() {
        return this.lungAbnormDesc;
    }


    public void setLungAbnormDesc(String lungAbnormDesc) {
        this.lungAbnormDesc = lungAbnormDesc;
    }


    public String getLungAbnormCode() {
        return this.lungAbnormCode;
    }


    public void setLungAbnormCode(String lungAbnormCode) {
        this.lungAbnormCode = lungAbnormCode;
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


    public Integer getBirthDefectCount() {
        return this.birthDefectCount;
    }


    public void setBirthDefectCount(Integer birthDefectCount) {
        this.birthDefectCount = birthDefectCount;
    }


    public Integer getNewbornDeathNum() {
        return this.newbornDeathNum;
    }


    public void setNewbornDeathNum(Integer newbornDeathNum) {
        this.newbornDeathNum = newbornDeathNum;
    }


    public Integer getDeadFetusNum() {
        return this.deadFetusNum;
    }


    public void setDeadFetusNum(Integer deadFetusNum) {
        this.deadFetusNum = deadFetusNum;
    }


    public Integer getStillbirthNum() {
        return this.stillbirthNum;
    }


    public void setStillbirthNum(Integer stillbirthNum) {
        this.stillbirthNum = stillbirthNum;
    }


    public Integer getAbortionTimes() {
        return this.abortionTimes;
    }


    public void setAbortionTimes(Integer abortionTimes) {
        this.abortionTimes = abortionTimes;
    }


    public String getGynOpHistory() {
        return this.gynOpHistory;
    }


    public void setGynOpHistory(String gynOpHistory) {
        this.gynOpHistory = gynOpHistory;
    }


    public String getGynOpHistoryCode() {
        return this.gynOpHistoryCode;
    }


    public void setGynOpHistoryCode(String gynOpHistoryCode) {
        this.gynOpHistoryCode = gynOpHistoryCode;
    }


    public Date getExpectedChildBirthday() {
        return this.expectedChildBirthday;
    }


    public void setExpectedChildBirthday(Date expectedChildBirthday) {
        this.expectedChildBirthday = expectedChildBirthday;
    }


    public Date getMensesLastDate() {
        return this.mensesLastDate;
    }


    public void setMensesLastDate(Date mensesLastDate) {
        this.mensesLastDate = mensesLastDate;
    }


    public String getLastMensesCode() {
        return this.lastMensesCode;
    }


    public void setLastMensesCode(String lastMensesCode) {
        this.lastMensesCode = lastMensesCode;
    }


    public Integer getCaesareanDeliveryTimes() {
        return this.caesareanDeliveryTimes;
    }


    public void setCaesareanDeliveryTimes(Integer caesareanDeliveryTimes) {
        this.caesareanDeliveryTimes = caesareanDeliveryTimes;
    }


    public Integer getVaginalDeliveryTimes() {
        return this.vaginalDeliveryTimes;
    }


    public void setVaginalDeliveryTimes(Integer vaginalDeliveryTimes) {
        this.vaginalDeliveryTimes = vaginalDeliveryTimes;
    }


    public Integer getGravidity() {
        return this.gravidity;
    }


    public void setGravidity(Integer gravidity) {
        this.gravidity = gravidity;
    }


    public Date getHusbandBirthday() {
        return this.husbandBirthday;
    }


    public void setHusbandBirthday(Date husbandBirthday) {
        this.husbandBirthday = husbandBirthday;
    }


    public Integer getHusbandAge() {
        return this.husbandAge;
    }


    public void setHusbandAge(Integer husbandAge) {
        this.husbandAge = husbandAge;
    }


    public String getHusbandTelNo() {
        return this.husbandTelNo;
    }


    public void setHusbandTelNo(String husbandTelNo) {
        this.husbandTelNo = husbandTelNo;
    }


    public String getHusbandName() {
        return this.husbandName;
    }


    public void setHusbandName(String husbandName) {
        this.husbandName = husbandName;
    }


    public Integer getAge() {
        return this.age;
    }


    public void setAge(Integer age) {
        this.age = age;
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


    public String getMaternalFirstFollowupNo() {
        return this.maternalFirstFollowupNo;
    }


    public void setMaternalFirstFollowupNo(String maternalFirstFollowupNo) {
        this.maternalFirstFollowupNo = maternalFirstFollowupNo;
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


    public String getMaternalFirstFollowupId() {
        return this.maternalFirstFollowupId;
    }


    public void setMaternalFirstFollowupId(String maternalFirstFollowupId) {
        this.maternalFirstFollowupId = maternalFirstFollowupId;
    }


    @Generated(hash = 828776149)
    public MaternalFirstFollowup(String maternalFirstFollowupId,
            String maternalInfoId, String personInfoId,
            String maternalFirstFollowupNo, String maternalRegisterId,
            Integer pregnantCount, String name, Date followupDate,
            String followupWayCode, Integer gestWeeks, Integer gestDays,
            Integer age, String husbandName, String husbandTelNo,
            Integer husbandAge, Date husbandBirthday, Integer gravidity,
            Integer vaginalDeliveryTimes, Integer caesareanDeliveryTimes,
            String lastMensesCode, Date mensesLastDate, Date expectedChildBirthday,
            String gynOpHistoryCode, String gynOpHistory, Integer abortionTimes,
            Integer stillbirthNum, Integer deadFetusNum, Integer newbornDeathNum,
            Integer birthDefectCount, Double height, Double weight, Double bmi,
            Integer sbp, Integer dbp, String lungAbnormCode, String lungAbnormDesc,
            String heartAbnormCode, String heartAbnormDesc, String vulvaAbnormCode,
            String vulvaAbnormDesc, String vaginaAbnormCode,
            String vaginaAbnormDesc, String cervixAbnormCode,
            String cervixAbnormDesc, String corpusuteriAbnormCode,
            String corpusuteriAbnormDesc, String adnexaAbnormCode,
            String adnexaAbnormDesc, Double hgb, Double wbc, Double plt,
            String cbcOthers, Double proQuanTestValue, String proQualResultCode,
            String gluQualResultCode, Double gluQuanTestValue,
            String ketQualResultCode, String uobTestResultCode,
            String urineRoutineOther, String aboRhValue, String aboCode,
            String rhCode, Double glu, Double sgpt, Double ast, Double alb,
            Double tbi, Double dbil, Double bun, Double scr, String wvdCleanCode,
            String hbeabTestResultCode, String hbeagTestResultCode,
            String hbsabTestResultCode, String hbsagTestResultCode,
            String hbcabTestResultCode, String stsResultCode,
            String hivAntiResultCode, String bscanResultDesc,
            String pregHealthAbnormCode, String pregHealthAbnormDesc,
            String referralCode, String refertoOrgName, String refertoDeptName,
            String referralReason, Date previousVisitDate,
            String previousVisitPerson, String previousVisitTypeCode,
            Date nextFollowupDate, String followupDoctorId,
            String followupDoctorName, Integer isCancel, String createOrgId,
            String orgName, String creatorId, String creator, Date createTime,
            String modifiedOrgId, String modifiedOrgName, String modifierId,
            String modifier, Date modifiedTime, String examOthers) {
        this.maternalFirstFollowupId = maternalFirstFollowupId;
        this.maternalInfoId = maternalInfoId;
        this.personInfoId = personInfoId;
        this.maternalFirstFollowupNo = maternalFirstFollowupNo;
        this.maternalRegisterId = maternalRegisterId;
        this.pregnantCount = pregnantCount;
        this.name = name;
        this.followupDate = followupDate;
        this.followupWayCode = followupWayCode;
        this.gestWeeks = gestWeeks;
        this.gestDays = gestDays;
        this.age = age;
        this.husbandName = husbandName;
        this.husbandTelNo = husbandTelNo;
        this.husbandAge = husbandAge;
        this.husbandBirthday = husbandBirthday;
        this.gravidity = gravidity;
        this.vaginalDeliveryTimes = vaginalDeliveryTimes;
        this.caesareanDeliveryTimes = caesareanDeliveryTimes;
        this.lastMensesCode = lastMensesCode;
        this.mensesLastDate = mensesLastDate;
        this.expectedChildBirthday = expectedChildBirthday;
        this.gynOpHistoryCode = gynOpHistoryCode;
        this.gynOpHistory = gynOpHistory;
        this.abortionTimes = abortionTimes;
        this.stillbirthNum = stillbirthNum;
        this.deadFetusNum = deadFetusNum;
        this.newbornDeathNum = newbornDeathNum;
        this.birthDefectCount = birthDefectCount;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.sbp = sbp;
        this.dbp = dbp;
        this.lungAbnormCode = lungAbnormCode;
        this.lungAbnormDesc = lungAbnormDesc;
        this.heartAbnormCode = heartAbnormCode;
        this.heartAbnormDesc = heartAbnormDesc;
        this.vulvaAbnormCode = vulvaAbnormCode;
        this.vulvaAbnormDesc = vulvaAbnormDesc;
        this.vaginaAbnormCode = vaginaAbnormCode;
        this.vaginaAbnormDesc = vaginaAbnormDesc;
        this.cervixAbnormCode = cervixAbnormCode;
        this.cervixAbnormDesc = cervixAbnormDesc;
        this.corpusuteriAbnormCode = corpusuteriAbnormCode;
        this.corpusuteriAbnormDesc = corpusuteriAbnormDesc;
        this.adnexaAbnormCode = adnexaAbnormCode;
        this.adnexaAbnormDesc = adnexaAbnormDesc;
        this.hgb = hgb;
        this.wbc = wbc;
        this.plt = plt;
        this.cbcOthers = cbcOthers;
        this.proQuanTestValue = proQuanTestValue;
        this.proQualResultCode = proQualResultCode;
        this.gluQualResultCode = gluQualResultCode;
        this.gluQuanTestValue = gluQuanTestValue;
        this.ketQualResultCode = ketQualResultCode;
        this.uobTestResultCode = uobTestResultCode;
        this.urineRoutineOther = urineRoutineOther;
        this.aboRhValue = aboRhValue;
        this.aboCode = aboCode;
        this.rhCode = rhCode;
        this.glu = glu;
        this.sgpt = sgpt;
        this.ast = ast;
        this.alb = alb;
        this.tbi = tbi;
        this.dbil = dbil;
        this.bun = bun;
        this.scr = scr;
        this.wvdCleanCode = wvdCleanCode;
        this.hbeabTestResultCode = hbeabTestResultCode;
        this.hbeagTestResultCode = hbeagTestResultCode;
        this.hbsabTestResultCode = hbsabTestResultCode;
        this.hbsagTestResultCode = hbsagTestResultCode;
        this.hbcabTestResultCode = hbcabTestResultCode;
        this.stsResultCode = stsResultCode;
        this.hivAntiResultCode = hivAntiResultCode;
        this.bscanResultDesc = bscanResultDesc;
        this.pregHealthAbnormCode = pregHealthAbnormCode;
        this.pregHealthAbnormDesc = pregHealthAbnormDesc;
        this.referralCode = referralCode;
        this.refertoOrgName = refertoOrgName;
        this.refertoDeptName = refertoDeptName;
        this.referralReason = referralReason;
        this.previousVisitDate = previousVisitDate;
        this.previousVisitPerson = previousVisitPerson;
        this.previousVisitTypeCode = previousVisitTypeCode;
        this.nextFollowupDate = nextFollowupDate;
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
        this.examOthers = examOthers;
    }

    @Generated(hash = 20634557)@Keep
    public MaternalFirstFollowup() {
        recordChoice = new ArrayList<>();
    }


}