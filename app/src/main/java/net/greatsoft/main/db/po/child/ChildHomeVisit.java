package net.greatsoft.main.db.po.child;

import net.greatsoft.main.db.po.Entry;
import net.greatsoft.main.db.po.RecordChoice;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Transient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年7月19日 下午12:04:20
 * @Description: 新生儿家庭访视
 *
 */
@Entity
public class ChildHomeVisit extends Entry {
	/**
	 * 新生儿家庭访视ID
	 */
	private String childHomeVisitId;

	/**
	 * 个人档案ID
	 */
	private String personInfoId;

	/**
	 * 新生儿家庭访视记录表单编号
	 */
	
	private String newbornVisitFormNo;

	/**
	 * 新生儿姓名
	 */
	
	private String newbornName;

	/**
	 * 新生儿性别代码
	 */
	
	private String newbornSexCode;

	/**
	 * 新生儿出生日期
	 */
	private Date newbornBirthDate;

	/**
	 * 新生儿身份证号码
	 */
	private String newbornIdNo;

	/**
	 * 家庭住址
	 */
	private String presentAddrProvince;

	/**
	 * 父亲档案ID
	 */
	private String fatherId;

	/**
	 * 父亲姓名
	 */
	private String fatherName;

	/**
	 * 父亲身份证号
	 */
	private String fatherIdno;

	/**
	 * 父亲职业类别代码
	 */
	private String fatherOccupCode;

	/**
	 * 父亲电话号码
	 */
	
	private String fatherTelNo;

	/**
	 * 父亲出生日期
	 */
	private Date fatherBirthDate;

	/**
	 * 母亲档案ID
	 */
	private String motherId;

	/**
	 * 母亲姓名
	 */
	private String motherName;

	/**
	 * 母亲身份证号
	 */
	private String motherIdno;

	/**
	 * 母亲职业类别代码
	 */
	private String motherOccupCode;

	/**
	 * 母亲电话号码
	 */
	
	private String motherTelNo;

	/**
	 * 母亲出生日期
	 */
	private Date motherBirthDate;

	/**
	 * 出生孕周
	 */
	private Integer birthGestWeeks;

	/**
	 * 出生孕天
	 */
	private Integer birthGestDays;

	/**
	 * 母亲妊娠期患病代码
	 */
	
	private String motherHdcpCode;

	/**
	 * 母亲妊娠期其他患病描述
	 */
	private String motherHdcpOthersDesc;

	/**
	 * 助产机构名称
	 */
	private String deliveryOrgName;

	/**
	 * 末次分娩方式代码
	 */
	private String lastDeliverWayCode;

	/**
	 * 新生儿窒息标志
	 */
	
	private String asphyxiaCode;

	/**
	 * Apgar评分代码
	 */
	
	private String apgarScoreCode;

	/**
	 * Apgar评分值（分）
	 */
	private String apgarScore;

	/**
	 * 新生儿畸形标志
	 */
	
	private String malformCode;

	/**
	 * 新生儿畸形描述
	 */
	private String malformDesc;

	/**
	 * 新生儿听力筛查情况代码
	 */
	private String hearingScreenCode;

	/**
	 * 新生儿疾病筛查项目代码
	 */
	private String diseaseScreenCode;

	/**
	 * 新生儿疾病筛查其他描述
	 */
	private String diseaseScreenOthersDesc;

	/**
	 * 出生体重(kg)
	 */
	private Double birthWeight;

	/**
	 * 体重(kg)
	 */
	private Double weight;

	/**
	 * 出生身长（cm)
	 */
	private Double birthLength;

	/**
	 * 身长（cm)
	 */
	private Double length;

	/**
	 * 喂养方式类别代码
	 */
	
	private String feedWayCode;

	/**
	 * 每天吃奶次数
	 */
	private String dailyFeedingTimes;

	/**
	 * 每次吃奶量（mL)
	 */
	private Integer feedingAmountEachTime;

	/**
	 * 呕吐标志
	 */
	
	private String vomitCode;

	/**
	 * 新生儿大便性状代码
	 */
	private String stoolPropCode;

	/**
	 * 大便次数（次/日)
	 */
	private String stoolTimes;

	/**
	 * 体温(℃)
	 */
	private Double bodyTemperature;

	/**
	 * 心(脉)率(次/分钟)
	 */
	private Integer pulses;

	/**
	 * 呼吸频率(次/分钟)
	 */
	private Integer breathingRate;

	/**
	 * 新生儿面色代码
	 */
	
	private String newbornComplexionCode;

	/**
	 * 新生儿面色其他描述
	 */
	private String newbornComplexionOthersDesc;

	/**
	 * 黄疸部位代码
	 */
	
	private String jaundiceSiteCode;

	/**
	 * 前囟横径(cm)
	 */
	private Double bregmaHorizDiameter;

	/**
	 * 前囟纵径(cm)
	 */
	private Double bregmaVertDiameter;

	/**
	 * 前囟张力代码
	 */
	
	private String bregmaTensionCode;

	/**
	 * 前囟张力其他描述
	 */
	private String bregmaTensionOthersDesc;

	/**
	 * 眼外观检查异常标志
	 */
	
	private String eyeAbnormCode;

	/**
	 * 眼外观检查异常结果描述
	 */
	private String eyeAbnormDesc;

	/**
	 * 耳外观检查异常标志
	 */
	
	private String earAbnormCode;

	/**
	 * 耳外观检查异常结果描述
	 */
	private String earAbnormDesc;

	/**
	 * 鼻检查异常标志
	 */
	
	private String noseAbnormCode;

	/**
	 * 鼻检查异常结果描述
	 */
	private String noseAbnormDesc;

	/**
	 * 口腔检查异常标志
	 */
	
	private String oralAbnormCode;

	/**
	 * 口腔检查异常结果描述
	 */
	private String oralAbnormDesc;

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
	 * 腹部触诊异常标志
	 */
	
	private String abdomenAbnormCode;

	/**
	 * 腹部触诊异常结果描述
	 */
	private String abdomenAbnormDesc;

	/**
	 * 四肢活动度异常标志
	 */
	
	private String limbsAbnormCode;

	/**
	 * 四肢活动度异常结果描述
	 */
	private String limbsAbnormDesc;

	/**
	 * 颈部包块标志
	 */
	
	private String neckMassCode;

	/**
	 * 颈部包块检查结果描述
	 */
	private String neckMassDesc;

	/**
	 * 皮肤检查结果代码
	 */
	
	private String skinCode;

	/**
	 * 皮肤检查其他描述
	 */
	private String skinOthersDesc;

	/**
	 * 肛门检查异常标志
	 */
	
	private String anusCode;

	/**
	 * 肛门检查异常结果描述
	 */
	private String anusAbnormDesc;

	/**
	 * 胸部检查异常标志
	 */
	
	private String chestCode;

	/**
	 * 胸部检查异常描述
	 */
	private String chestAbnormDesc;

	/**
	 * 外生殖器检查异常标志
	 */
	
	private String genitaliaCode;

	/**
	 * 外生殖器检查异常结果描述
	 */
	private String genitaliaAbnormDesc;

	/**
	 * 脊柱检查异常标志
	 */
	
	private String spineAbnormCode;

	/**
	 * 脊柱检查异常结果描述
	 */
	private String spineAbnormDesc;

	/**
	 * 脐带检查结果代码
	 */
	
	private String umbCordResultCode;

	/**
	 * 脐带检查结果其他描述
	 */
	private String umbCordOthersDesc;

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
	 * 访视医师ID
	 */
	private String visitDoctorId;

	/**
	 * 访视医师姓名
	 */
	
	private String visitDoctorName;

	/**
	 * 本次访视日期
	 */
	private Date thisVisitDate;

	/**
	 * 下次访视日期
	 */
	private Date nextVisitDate;

	/**
	 * 下次访视地点
	 */
	private String nextVisitPlace;

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
	 * 从表 json串
	 */
	private String jsonDetail;

	/**
	 * 选项指标记录，用来前后交互传输数据使用的
	 */
	@Transient
	private List<RecordChoice> recordChoice;
	
	/**
	 * Apgar评分1
	 */
	private Integer apgarScore1;
	
	/**
	 * Apgar评分5
	 */
	private Integer apgarScore5;
	
	/**
	 * Apgar评分 不详
	 */
	private Integer apgarScoreOther;

	public Integer getApgarScoreOther() {
		return this.apgarScoreOther;
	}

	public void setApgarScoreOther(Integer apgarScoreOther) {
		this.apgarScoreOther = apgarScoreOther;
	}

	public Integer getApgarScore5() {
		return this.apgarScore5;
	}

	public void setApgarScore5(Integer apgarScore5) {
		this.apgarScore5 = apgarScore5;
	}

	public Integer getApgarScore1() {
		return this.apgarScore1;
	}

	public void setApgarScore1(Integer apgarScore1) {
		this.apgarScore1 = apgarScore1;
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

	public String getNextVisitPlace() {
		return this.nextVisitPlace;
	}

	public void setNextVisitPlace(String nextVisitPlace) {
		this.nextVisitPlace = nextVisitPlace;
	}

	public Date getNextVisitDate() {
		return this.nextVisitDate;
	}

	public void setNextVisitDate(Date nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public Date getThisVisitDate() {
		return this.thisVisitDate;
	}

	public void setThisVisitDate(Date thisVisitDate) {
		this.thisVisitDate = thisVisitDate;
	}

	public String getVisitDoctorName() {
		return this.visitDoctorName;
	}

	public void setVisitDoctorName(String visitDoctorName) {
		this.visitDoctorName = visitDoctorName;
	}

	public String getVisitDoctorId() {
		return this.visitDoctorId;
	}

	public void setVisitDoctorId(String visitDoctorId) {
		this.visitDoctorId = visitDoctorId;
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

	public String getUmbCordOthersDesc() {
		return this.umbCordOthersDesc;
	}

	public void setUmbCordOthersDesc(String umbCordOthersDesc) {
		this.umbCordOthersDesc = umbCordOthersDesc;
	}

	public String getUmbCordResultCode() {
		return this.umbCordResultCode;
	}

	public void setUmbCordResultCode(String umbCordResultCode) {
		this.umbCordResultCode = umbCordResultCode;
	}

	public String getSpineAbnormDesc() {
		return this.spineAbnormDesc;
	}

	public void setSpineAbnormDesc(String spineAbnormDesc) {
		this.spineAbnormDesc = spineAbnormDesc;
	}

	public String getSpineAbnormCode() {
		return this.spineAbnormCode;
	}

	public void setSpineAbnormCode(String spineAbnormCode) {
		this.spineAbnormCode = spineAbnormCode;
	}

	public String getGenitaliaAbnormDesc() {
		return this.genitaliaAbnormDesc;
	}

	public void setGenitaliaAbnormDesc(String genitaliaAbnormDesc) {
		this.genitaliaAbnormDesc = genitaliaAbnormDesc;
	}

	public String getGenitaliaCode() {
		return this.genitaliaCode;
	}

	public void setGenitaliaCode(String genitaliaCode) {
		this.genitaliaCode = genitaliaCode;
	}

	public String getChestAbnormDesc() {
		return this.chestAbnormDesc;
	}

	public void setChestAbnormDesc(String chestAbnormDesc) {
		this.chestAbnormDesc = chestAbnormDesc;
	}

	public String getChestCode() {
		return this.chestCode;
	}

	public void setChestCode(String chestCode) {
		this.chestCode = chestCode;
	}

	public String getAnusAbnormDesc() {
		return this.anusAbnormDesc;
	}

	public void setAnusAbnormDesc(String anusAbnormDesc) {
		this.anusAbnormDesc = anusAbnormDesc;
	}

	public String getAnusCode() {
		return this.anusCode;
	}

	public void setAnusCode(String anusCode) {
		this.anusCode = anusCode;
	}

	public String getSkinOthersDesc() {
		return this.skinOthersDesc;
	}

	public void setSkinOthersDesc(String skinOthersDesc) {
		this.skinOthersDesc = skinOthersDesc;
	}

	public String getSkinCode() {
		return this.skinCode;
	}

	public void setSkinCode(String skinCode) {
		this.skinCode = skinCode;
	}

	public String getNeckMassDesc() {
		return this.neckMassDesc;
	}

	public void setNeckMassDesc(String neckMassDesc) {
		this.neckMassDesc = neckMassDesc;
	}

	public String getNeckMassCode() {
		return this.neckMassCode;
	}

	public void setNeckMassCode(String neckMassCode) {
		this.neckMassCode = neckMassCode;
	}

	public String getLimbsAbnormDesc() {
		return this.limbsAbnormDesc;
	}

	public void setLimbsAbnormDesc(String limbsAbnormDesc) {
		this.limbsAbnormDesc = limbsAbnormDesc;
	}

	public String getLimbsAbnormCode() {
		return this.limbsAbnormCode;
	}

	public void setLimbsAbnormCode(String limbsAbnormCode) {
		this.limbsAbnormCode = limbsAbnormCode;
	}

	public String getAbdomenAbnormDesc() {
		return this.abdomenAbnormDesc;
	}

	public void setAbdomenAbnormDesc(String abdomenAbnormDesc) {
		this.abdomenAbnormDesc = abdomenAbnormDesc;
	}

	public String getAbdomenAbnormCode() {
		return this.abdomenAbnormCode;
	}

	public void setAbdomenAbnormCode(String abdomenAbnormCode) {
		this.abdomenAbnormCode = abdomenAbnormCode;
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

	public String getOralAbnormDesc() {
		return this.oralAbnormDesc;
	}

	public void setOralAbnormDesc(String oralAbnormDesc) {
		this.oralAbnormDesc = oralAbnormDesc;
	}

	public String getOralAbnormCode() {
		return this.oralAbnormCode;
	}

	public void setOralAbnormCode(String oralAbnormCode) {
		this.oralAbnormCode = oralAbnormCode;
	}

	public String getNoseAbnormDesc() {
		return this.noseAbnormDesc;
	}

	public void setNoseAbnormDesc(String noseAbnormDesc) {
		this.noseAbnormDesc = noseAbnormDesc;
	}

	public String getNoseAbnormCode() {
		return this.noseAbnormCode;
	}

	public void setNoseAbnormCode(String noseAbnormCode) {
		this.noseAbnormCode = noseAbnormCode;
	}

	public String getEarAbnormDesc() {
		return this.earAbnormDesc;
	}

	public void setEarAbnormDesc(String earAbnormDesc) {
		this.earAbnormDesc = earAbnormDesc;
	}

	public String getEarAbnormCode() {
		return this.earAbnormCode;
	}

	public void setEarAbnormCode(String earAbnormCode) {
		this.earAbnormCode = earAbnormCode;
	}

	public String getEyeAbnormDesc() {
		return this.eyeAbnormDesc;
	}

	public void setEyeAbnormDesc(String eyeAbnormDesc) {
		this.eyeAbnormDesc = eyeAbnormDesc;
	}

	public String getEyeAbnormCode() {
		return this.eyeAbnormCode;
	}

	public void setEyeAbnormCode(String eyeAbnormCode) {
		this.eyeAbnormCode = eyeAbnormCode;
	}

	public String getBregmaTensionOthersDesc() {
		return this.bregmaTensionOthersDesc;
	}

	public void setBregmaTensionOthersDesc(String bregmaTensionOthersDesc) {
		this.bregmaTensionOthersDesc = bregmaTensionOthersDesc;
	}

	public String getBregmaTensionCode() {
		return this.bregmaTensionCode;
	}

	public void setBregmaTensionCode(String bregmaTensionCode) {
		this.bregmaTensionCode = bregmaTensionCode;
	}

	public Double getBregmaVertDiameter() {
		return this.bregmaVertDiameter;
	}

	public void setBregmaVertDiameter(Double bregmaVertDiameter) {
		this.bregmaVertDiameter = bregmaVertDiameter;
	}

	public Double getBregmaHorizDiameter() {
		return this.bregmaHorizDiameter;
	}

	public void setBregmaHorizDiameter(Double bregmaHorizDiameter) {
		this.bregmaHorizDiameter = bregmaHorizDiameter;
	}

	public String getJaundiceSiteCode() {
		return this.jaundiceSiteCode;
	}

	public void setJaundiceSiteCode(String jaundiceSiteCode) {
		this.jaundiceSiteCode = jaundiceSiteCode;
	}

	public String getNewbornComplexionOthersDesc() {
		return this.newbornComplexionOthersDesc;
	}

	public void setNewbornComplexionOthersDesc(String newbornComplexionOthersDesc) {
		this.newbornComplexionOthersDesc = newbornComplexionOthersDesc;
	}

	public String getNewbornComplexionCode() {
		return this.newbornComplexionCode;
	}

	public void setNewbornComplexionCode(String newbornComplexionCode) {
		this.newbornComplexionCode = newbornComplexionCode;
	}

	public Integer getBreathingRate() {
		return this.breathingRate;
	}

	public void setBreathingRate(Integer breathingRate) {
		this.breathingRate = breathingRate;
	}

	public Integer getPulses() {
		return this.pulses;
	}

	public void setPulses(Integer pulses) {
		this.pulses = pulses;
	}

	public Double getBodyTemperature() {
		return this.bodyTemperature;
	}

	public void setBodyTemperature(Double bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public String getStoolTimes() {
		return this.stoolTimes;
	}

	public void setStoolTimes(String stoolTimes) {
		this.stoolTimes = stoolTimes;
	}

	public String getStoolPropCode() {
		return this.stoolPropCode;
	}

	public void setStoolPropCode(String stoolPropCode) {
		this.stoolPropCode = stoolPropCode;
	}

	public String getVomitCode() {
		return this.vomitCode;
	}

	public void setVomitCode(String vomitCode) {
		this.vomitCode = vomitCode;
	}

	public Integer getFeedingAmountEachTime() {
		return this.feedingAmountEachTime;
	}

	public void setFeedingAmountEachTime(Integer feedingAmountEachTime) {
		this.feedingAmountEachTime = feedingAmountEachTime;
	}

	public String getDailyFeedingTimes() {
		return this.dailyFeedingTimes;
	}

	public void setDailyFeedingTimes(String dailyFeedingTimes) {
		this.dailyFeedingTimes = dailyFeedingTimes;
	}

	public String getFeedWayCode() {
		return this.feedWayCode;
	}

	public void setFeedWayCode(String feedWayCode) {
		this.feedWayCode = feedWayCode;
	}

	public Double getLength() {
		return this.length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getBirthLength() {
		return this.birthLength;
	}

	public void setBirthLength(Double birthLength) {
		this.birthLength = birthLength;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getBirthWeight() {
		return this.birthWeight;
	}

	public void setBirthWeight(Double birthWeight) {
		this.birthWeight = birthWeight;
	}

	public String getDiseaseScreenOthersDesc() {
		return this.diseaseScreenOthersDesc;
	}

	public void setDiseaseScreenOthersDesc(String diseaseScreenOthersDesc) {
		this.diseaseScreenOthersDesc = diseaseScreenOthersDesc;
	}

	public String getDiseaseScreenCode() {
		return this.diseaseScreenCode;
	}

	public void setDiseaseScreenCode(String diseaseScreenCode) {
		this.diseaseScreenCode = diseaseScreenCode;
	}

	public String getHearingScreenCode() {
		return this.hearingScreenCode;
	}

	public void setHearingScreenCode(String hearingScreenCode) {
		this.hearingScreenCode = hearingScreenCode;
	}

	public String getMalformDesc() {
		return this.malformDesc;
	}

	public void setMalformDesc(String malformDesc) {
		this.malformDesc = malformDesc;
	}

	public String getMalformCode() {
		return this.malformCode;
	}

	public void setMalformCode(String malformCode) {
		this.malformCode = malformCode;
	}

	public String getApgarScore() {
		return this.apgarScore;
	}

	public void setApgarScore(String apgarScore) {
		this.apgarScore = apgarScore;
	}

	public String getApgarScoreCode() {
		return this.apgarScoreCode;
	}

	public void setApgarScoreCode(String apgarScoreCode) {
		this.apgarScoreCode = apgarScoreCode;
	}

	public String getAsphyxiaCode() {
		return this.asphyxiaCode;
	}

	public void setAsphyxiaCode(String asphyxiaCode) {
		this.asphyxiaCode = asphyxiaCode;
	}

	public String getLastDeliverWayCode() {
		return this.lastDeliverWayCode;
	}

	public void setLastDeliverWayCode(String lastDeliverWayCode) {
		this.lastDeliverWayCode = lastDeliverWayCode;
	}

	public String getDeliveryOrgName() {
		return this.deliveryOrgName;
	}

	public void setDeliveryOrgName(String deliveryOrgName) {
		this.deliveryOrgName = deliveryOrgName;
	}

	public String getMotherHdcpOthersDesc() {
		return this.motherHdcpOthersDesc;
	}

	public void setMotherHdcpOthersDesc(String motherHdcpOthersDesc) {
		this.motherHdcpOthersDesc = motherHdcpOthersDesc;
	}

	public String getMotherHdcpCode() {
		return this.motherHdcpCode;
	}

	public void setMotherHdcpCode(String motherHdcpCode) {
		this.motherHdcpCode = motherHdcpCode;
	}

	public Integer getBirthGestDays() {
		return this.birthGestDays;
	}

	public void setBirthGestDays(Integer birthGestDays) {
		this.birthGestDays = birthGestDays;
	}

	public Integer getBirthGestWeeks() {
		return this.birthGestWeeks;
	}

	public void setBirthGestWeeks(Integer birthGestWeeks) {
		this.birthGestWeeks = birthGestWeeks;
	}

	public Date getMotherBirthDate() {
		return this.motherBirthDate;
	}

	public void setMotherBirthDate(Date motherBirthDate) {
		this.motherBirthDate = motherBirthDate;
	}

	public String getMotherTelNo() {
		return this.motherTelNo;
	}

	public void setMotherTelNo(String motherTelNo) {
		this.motherTelNo = motherTelNo;
	}

	public String getMotherOccupCode() {
		return this.motherOccupCode;
	}

	public void setMotherOccupCode(String motherOccupCode) {
		this.motherOccupCode = motherOccupCode;
	}

	public String getMotherIdno() {
		return this.motherIdno;
	}

	public void setMotherIdno(String motherIdno) {
		this.motherIdno = motherIdno;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherId() {
		return this.motherId;
	}

	public void setMotherId(String motherId) {
		this.motherId = motherId;
	}

	public Date getFatherBirthDate() {
		return this.fatherBirthDate;
	}

	public void setFatherBirthDate(Date fatherBirthDate) {
		this.fatherBirthDate = fatherBirthDate;
	}

	public String getFatherTelNo() {
		return this.fatherTelNo;
	}

	public void setFatherTelNo(String fatherTelNo) {
		this.fatherTelNo = fatherTelNo;
	}

	public String getFatherOccupCode() {
		return this.fatherOccupCode;
	}

	public void setFatherOccupCode(String fatherOccupCode) {
		this.fatherOccupCode = fatherOccupCode;
	}

	public String getFatherIdno() {
		return this.fatherIdno;
	}

	public void setFatherIdno(String fatherIdno) {
		this.fatherIdno = fatherIdno;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherId() {
		return this.fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public String getPresentAddrProvince() {
		return this.presentAddrProvince;
	}

	public void setPresentAddrProvince(String presentAddrProvince) {
		this.presentAddrProvince = presentAddrProvince;
	}

	public String getNewbornIdNo() {
		return this.newbornIdNo;
	}

	public void setNewbornIdNo(String newbornIdNo) {
		this.newbornIdNo = newbornIdNo;
	}

	public Date getNewbornBirthDate() {
		return this.newbornBirthDate;
	}

	public void setNewbornBirthDate(Date newbornBirthDate) {
		this.newbornBirthDate = newbornBirthDate;
	}

	public String getNewbornSexCode() {
		return this.newbornSexCode;
	}

	public void setNewbornSexCode(String newbornSexCode) {
		this.newbornSexCode = newbornSexCode;
	}

	public String getNewbornName() {
		return this.newbornName;
	}

	public void setNewbornName(String newbornName) {
		this.newbornName = newbornName;
	}

	public String getNewbornVisitFormNo() {
		return this.newbornVisitFormNo;
	}

	public void setNewbornVisitFormNo(String newbornVisitFormNo) {
		this.newbornVisitFormNo = newbornVisitFormNo;
	}

	public String getPersonInfoId() {
		return this.personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getChildHomeVisitId() {
		return this.childHomeVisitId;
	}

	public void setChildHomeVisitId(String childHomeVisitId) {
		this.childHomeVisitId = childHomeVisitId;
	}

	public List<RecordChoice> getRecordChoice() {
		return recordChoice;
	}

	public void setRecordChoice(List<RecordChoice> recordChoice) {
		this.recordChoice = recordChoice;
	}

	@Generated(hash = 1513043876)
	public ChildHomeVisit(String childHomeVisitId, String personInfoId,
			String newbornVisitFormNo, String newbornName, String newbornSexCode,
			Date newbornBirthDate, String newbornIdNo, String presentAddrProvince,
			String fatherId, String fatherName, String fatherIdno,
			String fatherOccupCode, String fatherTelNo, Date fatherBirthDate,
			String motherId, String motherName, String motherIdno,
			String motherOccupCode, String motherTelNo, Date motherBirthDate,
			Integer birthGestWeeks, Integer birthGestDays, String motherHdcpCode,
			String motherHdcpOthersDesc, String deliveryOrgName,
			String lastDeliverWayCode, String asphyxiaCode, String apgarScoreCode,
			String apgarScore, String malformCode, String malformDesc,
			String hearingScreenCode, String diseaseScreenCode,
			String diseaseScreenOthersDesc, Double birthWeight, Double weight,
			Double birthLength, Double length, String feedWayCode,
			String dailyFeedingTimes, Integer feedingAmountEachTime, String vomitCode,
			String stoolPropCode, String stoolTimes, Double bodyTemperature,
			Integer pulses, Integer breathingRate, String newbornComplexionCode,
			String newbornComplexionOthersDesc, String jaundiceSiteCode,
			Double bregmaHorizDiameter, Double bregmaVertDiameter,
			String bregmaTensionCode, String bregmaTensionOthersDesc,
			String eyeAbnormCode, String eyeAbnormDesc, String earAbnormCode,
			String earAbnormDesc, String noseAbnormCode, String noseAbnormDesc,
			String oralAbnormCode, String oralAbnormDesc, String lungAbnormCode,
			String lungAbnormDesc, String heartAbnormCode, String heartAbnormDesc,
			String abdomenAbnormCode, String abdomenAbnormDesc, String limbsAbnormCode,
			String limbsAbnormDesc, String neckMassCode, String neckMassDesc,
			String skinCode, String skinOthersDesc, String anusCode,
			String anusAbnormDesc, String chestCode, String chestAbnormDesc,
			String genitaliaCode, String genitaliaAbnormDesc, String spineAbnormCode,
			String spineAbnormDesc, String umbCordResultCode, String umbCordOthersDesc,
			String referralCode, String refertoOrgName, String refertoDeptName,
			String referralReason, String visitDoctorId, String visitDoctorName,
			Date thisVisitDate, Date nextVisitDate, String nextVisitPlace,
			Integer isCancel, String createOrgId, String orgName, String creatorId,
			String creator, Date createTime, String modifiedOrgId,
			String modifiedOrgName, String modifierId, String modifier,
			Date modifiedTime, String jsonDetail, Integer apgarScore1,
			Integer apgarScore5, Integer apgarScoreOther) {
		this.childHomeVisitId = childHomeVisitId;
		this.personInfoId = personInfoId;
		this.newbornVisitFormNo = newbornVisitFormNo;
		this.newbornName = newbornName;
		this.newbornSexCode = newbornSexCode;
		this.newbornBirthDate = newbornBirthDate;
		this.newbornIdNo = newbornIdNo;
		this.presentAddrProvince = presentAddrProvince;
		this.fatherId = fatherId;
		this.fatherName = fatherName;
		this.fatherIdno = fatherIdno;
		this.fatherOccupCode = fatherOccupCode;
		this.fatherTelNo = fatherTelNo;
		this.fatherBirthDate = fatherBirthDate;
		this.motherId = motherId;
		this.motherName = motherName;
		this.motherIdno = motherIdno;
		this.motherOccupCode = motherOccupCode;
		this.motherTelNo = motherTelNo;
		this.motherBirthDate = motherBirthDate;
		this.birthGestWeeks = birthGestWeeks;
		this.birthGestDays = birthGestDays;
		this.motherHdcpCode = motherHdcpCode;
		this.motherHdcpOthersDesc = motherHdcpOthersDesc;
		this.deliveryOrgName = deliveryOrgName;
		this.lastDeliverWayCode = lastDeliverWayCode;
		this.asphyxiaCode = asphyxiaCode;
		this.apgarScoreCode = apgarScoreCode;
		this.apgarScore = apgarScore;
		this.malformCode = malformCode;
		this.malformDesc = malformDesc;
		this.hearingScreenCode = hearingScreenCode;
		this.diseaseScreenCode = diseaseScreenCode;
		this.diseaseScreenOthersDesc = diseaseScreenOthersDesc;
		this.birthWeight = birthWeight;
		this.weight = weight;
		this.birthLength = birthLength;
		this.length = length;
		this.feedWayCode = feedWayCode;
		this.dailyFeedingTimes = dailyFeedingTimes;
		this.feedingAmountEachTime = feedingAmountEachTime;
		this.vomitCode = vomitCode;
		this.stoolPropCode = stoolPropCode;
		this.stoolTimes = stoolTimes;
		this.bodyTemperature = bodyTemperature;
		this.pulses = pulses;
		this.breathingRate = breathingRate;
		this.newbornComplexionCode = newbornComplexionCode;
		this.newbornComplexionOthersDesc = newbornComplexionOthersDesc;
		this.jaundiceSiteCode = jaundiceSiteCode;
		this.bregmaHorizDiameter = bregmaHorizDiameter;
		this.bregmaVertDiameter = bregmaVertDiameter;
		this.bregmaTensionCode = bregmaTensionCode;
		this.bregmaTensionOthersDesc = bregmaTensionOthersDesc;
		this.eyeAbnormCode = eyeAbnormCode;
		this.eyeAbnormDesc = eyeAbnormDesc;
		this.earAbnormCode = earAbnormCode;
		this.earAbnormDesc = earAbnormDesc;
		this.noseAbnormCode = noseAbnormCode;
		this.noseAbnormDesc = noseAbnormDesc;
		this.oralAbnormCode = oralAbnormCode;
		this.oralAbnormDesc = oralAbnormDesc;
		this.lungAbnormCode = lungAbnormCode;
		this.lungAbnormDesc = lungAbnormDesc;
		this.heartAbnormCode = heartAbnormCode;
		this.heartAbnormDesc = heartAbnormDesc;
		this.abdomenAbnormCode = abdomenAbnormCode;
		this.abdomenAbnormDesc = abdomenAbnormDesc;
		this.limbsAbnormCode = limbsAbnormCode;
		this.limbsAbnormDesc = limbsAbnormDesc;
		this.neckMassCode = neckMassCode;
		this.neckMassDesc = neckMassDesc;
		this.skinCode = skinCode;
		this.skinOthersDesc = skinOthersDesc;
		this.anusCode = anusCode;
		this.anusAbnormDesc = anusAbnormDesc;
		this.chestCode = chestCode;
		this.chestAbnormDesc = chestAbnormDesc;
		this.genitaliaCode = genitaliaCode;
		this.genitaliaAbnormDesc = genitaliaAbnormDesc;
		this.spineAbnormCode = spineAbnormCode;
		this.spineAbnormDesc = spineAbnormDesc;
		this.umbCordResultCode = umbCordResultCode;
		this.umbCordOthersDesc = umbCordOthersDesc;
		this.referralCode = referralCode;
		this.refertoOrgName = refertoOrgName;
		this.refertoDeptName = refertoDeptName;
		this.referralReason = referralReason;
		this.visitDoctorId = visitDoctorId;
		this.visitDoctorName = visitDoctorName;
		this.thisVisitDate = thisVisitDate;
		this.nextVisitDate = nextVisitDate;
		this.nextVisitPlace = nextVisitPlace;
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
		this.apgarScore1 = apgarScore1;
		this.apgarScore5 = apgarScore5;
		this.apgarScoreOther = apgarScoreOther;
	}

	@Generated(hash = 300628898)@Keep
	public ChildHomeVisit() {
		recordChoice = new ArrayList<>();
	}


}
