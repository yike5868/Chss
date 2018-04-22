package net.greatsoft.main.db.po.exam;

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
 * @author AlphGo
 * @date 2016年6月25日 上午8:54:54
 * @Description: 个人健康体检实体
 */
@Entity
public class HealthExam extends Entry {
    /**
     * 个人健康体检ID
     */
    private String healthExamId;

    /**
     * 个人档案ID
     */
    private String personInfoId;

    /**
     * 卫生服务机构ID
     */
    private String orgId;

    /**
     * 健康体检表编号
     */
    private String healthExamNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 体检日期
     */
    private Date healthExamDate;

    /**
     * 责任医生ID
     */
    private String respDoctorId;

    /**
     * 责任医师姓名
     */
    private String respDoctorName;

    /**
     * 体温（℃)
     */
    private Double bodyTemperature;

    /**
     * 脉率(次/min)
     */
    private Integer pulseRate;

    /**
     * 呼吸频率（次/min)
     */
    private Integer breathingRate;

    /**
     * 左侧收缩压（mmHg)
     */
    private Integer lsbp;

    /**
     * 左侧舒张压（mmHg)
     */
    private Integer ldbp;

    /**
     * 右侧收缩压（mmHg)
     */
    private Integer rsbp;

    /**
     * 右侧舒张压（mmHg)
     */
    private Integer rdbp;

    /**
     * 身高（cm)
     */
    private Double height;

    /**
     * 体重(kg)
     */
    private Double weight;

    /**
     * 腰围(cm)
     */
    private Double waist;

    /**
     * 体质指数
     */
    private Double bmi;

    /**
     * 老年人自理能力评估表ID
     */
    private String elderSelfcareAbilityId;

    /**
     * 老年人健康状态自我评估代码
     */
    private String elderHealthAssessCode;

    /**
     * 老年人生活自理能力自我评估代码
     */
    private String elderSelfCareAssessCode;

    /**
     * 老年人认知功能粗筛结果代码
     */
    private String elderCognitionResultCode;

    /**
     * 老年人认知功能量表ID
     */
    private String elderCognitionId;

    /**
     * 老年人认知功能评分
     */
    private Integer elderBrainScore;

    /**
     * 老年人情感状态粗筛结果代码
     */
    private String elderEmotionalResultCode;

    /**
     * 老年抑郁量表ID
     */
    private String elderDepressedId;

    /**
     * 老年人抑郁评分
     */
    private Integer elderDepressionScore;

    /**
     * 锻炼频率代码
     */
    private String exerciseFreqCode;

    /**
     * 每次锻炼时长（分钟)
     */
    private Integer exerciseDurationMins;

    /**
     * 坚持锻炼时间（年）
     */
    private Integer exerciseYear;

    /**
     * 锻炼方式
     */
    private String exerciseWay;

    /**
     * 吸烟状况代码
     */
    private String smokingStatusCode;

    /**
     * 日吸烟量（支）
     */
    private Integer dailySmoking;

    /**
     * 开始吸烟年龄（岁）
     */
    private Integer startSmokingAge;

    /**
     * 戒烟年龄（岁）
     */
    private Integer stopSmokingAge;

    /**
     * 饮酒频率代码
     */
    private String drinkingFreqCode;

    /**
     * 日饮酒量（两）
     */
    private Integer dailyDrinking;

    /**
     * 戒酒标志
     */
    private String stopDrinkingCode;

    /**
     * 戒酒年龄（岁）
     */
    private Integer stopDrinkingAge;

    /**
     * 开始饮酒年龄（岁）
     */
    private Integer startDrinkingAge;

    /**
     * 醉酒标志
     */
    private String drunkCode;

    /**
     * 职业病危险因素标志
     */
    private String occupExposureCode;

    /**
     * 职业病危险工种
     */
    private String occupExposureWork;

    /**
     * 职业病危险工种从业时间（年）
     */
    private Integer occupExposureWorkYear;

    /**
     * 毒物（粉尘）
     */
    private String poisonDust;

    /**
     * 毒物（粉尘）防护措施标志
     */
    private String poisonDustProtectCode;

    /**
     * 毒物（粉尘）防护措施中文
     */
    private String poisonDustProtectValue;

    /**
     * 毒物（放射物质）
     */
    private String poisonRadiogen;

    /**
     * 毒物（放射物质）防护措施标志
     */
    private String poisonRadiogenProtectCode;

    /**
     * 毒物（放射物质）防护措施中文
     */
    private String poisonRadiogenProtectValue;

    /**
     * 毒物（物理因素）
     */
    private String poisonPhysical;

    /**
     * 毒物（物理因素）防护措施标志
     */
    private String poisonPhysicalProtectCode;

    /**
     * 毒物（物理因素）防护措施中文
     */
    private String poisonPhysicalProtectValue;

    /**
     * 毒物（化学物质）
     */
    private String poisonChemical;

    /**
     * 毒物（化学物质）防护措施标志
     */
    private String poisonChemicalProtectCode;

    /**
     * 毒物（化学物质）防护措施中文
     */
    private String poisonChemicalProtectValue;

    /**
     * 毒物（其他）
     */
    private String poisonOthers;

    /**
     * 毒物（其他）防护措施标志
     */
    private String poisonOthersProtectCode;

    /**
     * 毒物（其他）防护措施中文
     */
    private String poisonOthersProtectValue;

    /**
     * 口唇外观检査结果代码
     */
    private String lipExamResultCode;

    /**
     * 齿列类别代码
     */
    private String dentitionTypeCode;

    /**
     * 是否缺齿代码值
     */
    private Integer isLosetTeeth;

    /**
     * 缺齿全口
     */
    private Integer allLoseTeeth;

    /**
     * 缺齿数左上
     */
    private Integer loseUlTeethNum;

    /**
     * 缺齿数左下
     */
    private Integer loseUrTeethNum;

    /**
     * 缺齿数右上
     */
    private Integer loseBlTeethNum;

    /**
     * 缺齿数右下
     */
    private Integer loseBrTeethNum;

    /**
     * 是否龋齿代码值
     */
    private Integer isDecayedTooth;

    /**
     * 龋齿数左上
     */
    private Integer decayedUlToothNum;

    /**
     * 龋齿数左下
     */
    private Integer decayedUrToothNum;

    /**
     * 龋齿数右上
     */
    private Integer decayedBlToothNum;

    /**
     * 龋齿数右下
     */
    private Integer decayedBrToothNum;

    /**
     * 是否义齿代码值
     */
    private Integer isFalseTeeth;

    /**
     * 义齿全口
     */
    private Integer allFalseTeeth;

    /**
     * 义齿数左上
     */
    private Integer falseUlTeethNum;

    /**
     * 义齿数右上
     */
    private Integer falseUrTeethNum;

    /**
     * 义齿数左下
     */
    private Integer falseBlTeethNum;

    /**
     * 义齿数右下
     */
    private Integer falseBrTeethNum;

    /**
     * 咽部检查结果代码
     */
    private String pharynxExamResultCode;

    /**
     * 左眼裸眼远视力值
     */
    private Double leftOriginalEyesight;

    /**
     * 右眼裸眼远视力值
     */
    private Double rightOriginalEyesight;

    /**
     * 左眼矫正远视力值
     */
    private Double leftCorrectEyesight;

    /**
     * 右眼矫正远视力值
     */
    private Double rightCorrectEyesight;

    /**
     * 听力检测结果代码
     */
    private String hearingCode;

    /**
     * 运动功能状态代码
     */
    private String movementFunctionCode;

    /**
     * 眼底检査结果代码
     */
    private String eyegroundCode;

    /**
     * 眼底检查结果异常描述
     */
    private String eyegroundAbnormDesc;

    /**
     * 皮肤检查结果代码
     */
    private String skinCode;

    /**
     * 皮肤检查结果其他描述
     */
    private String skinOthersDesc;

    /**
     * 巩膜检査结果代码
     */
    private String scleralCode;

    /**
     * 巩膜检査结果其他描述
     */
    private String scleralOthersDesc;

    /**
     * 淋巴结检查结果代码
     */
    private String lymphCode;

    /**
     * 淋巴结检查结果其他描述
     */
    private String lymphOthersDesc;

    /**
     * 桶状胸代码
     */
    private String barrelChestCode;

    /**
     * 肺部呼吸音代码
     */
    private String lungSoundCode;

    /**
     * 肺部呼吸音异常描述
     */
    private String lungSoundAbnormDesc;

    /**
     * 肺部罗音标志
     */
    private String lungRaleCode;

    /**
     * 肺部罗音其他描述
     */
    private String lungRaleOthersDesc;

    /**
     * 心率(次/min)
     */
    private Integer heartRate;

    /**
     * 心律类别代码
     */
    private String heartRhythmTypeCode;

    /**
     * 心脏杂音代码
     */
    private String heartMurmurCode;

    /**
     * 心脏杂音描述
     */
    private String heartMurmurDesc;

    /**
     * 腹部压痛代码
     */
    private String abdominalTendCode;

    /**
     * 腹部压痛描述
     */
    private String hasAbdominalTendDesc;

    /**
     * 腹部包块代码
     */
    private String abdominalMassCode;

    /**
     * 腹部包块描述
     */
    private String hasAbdominalMassDesc;

    /**
     * 肝大代码
     */
    private String hepatauxeCode;

    /**
     * 肝大描述
     */
    private String hasHepatauxeDesc;

    /**
     * 脾大代码
     */
    private String splenomegalyCode;

    /**
     * 脾大描述
     */
    private String hasSplenomegalyDesc;

    /**
     * 腹部移动性浊音代码
     */
    private String abdominalDullnessCode;

    /**
     * 腹部移动性浊音描述
     */
    private String hasAbdominalDullnessDesc;

    /**
     * 下肢水肿检査结果代码
     */
    private String eoleCode;

    /**
     * 足背动脉搏动代码
     */
    private String pofdaCode;

    /**
     * 肛门指诊检查结果类别代码
     */
    private String dreCode;

    /**
     * 肛门指诊其他描述
     */
    private String dreOthersDesc;

    /**
     * 外阴异常标志
     */
    private String vulvaCode;

    /**
     * 外阴异常描述
     */
    private String vulvaAbnormDesc;

    /**
     * 阴道异常标志
     */
    private String vaginaCode;

    /**
     * 阴道异常描述
     */
    private String vaginaAbnormDesc;

    /**
     * 宫颈异常标志
     */
    private String cervixCode;

    /**
     * 宫颈异常描述
     */
    private String cervixAbnormDesc;

    /**
     * 宫体异常标志
     */
    private String corpusuteriCode;

    /**
     * 宫体异常描述
     */
    private String corpusuteriAbnormDesc;

    /**
     * 附件异常标志
     */
    private String adnexaCode;

    /**
     * 附件异常描述
     */
    private String adnexaAbnormDesc;

    /**
     * 其他查体结果
     */
    private String otherHealthExamResult;

    /**
     * 血红蛋白值(g/L)
     */
    private Integer hgb;

    /**
     * 白细胞计数值（G/L)
     */
    private Double wbc;

    /**
     * 血小板计数值(G/L)
     */
    private Integer plt;

    /**
     * 其他血常规
     */
    private String cbcOthers;

    /**
     * 尿蛋白定性检测结果代码
     */
    private String proQualResultCode;

    /**
     * 尿蛋白定量检测值(mg/24h)
     */
    private Double proQuanTestValue;

    /**
     * 尿糖定性检测结果代码
     */
    private String gluQualResultCode;

    /**
     * 尿糖定量检测值（mmol/L）
     */
    private Double gluQuanTestValue;

    /**
     * 尿酮体定性检测结果代码
     */
    private String ketQualResultCode;

    /**
     * 尿酮体定量检测值（mmol/L）
     */
    private Double ketQualResultValue;

    /**
     * 尿潜血定性检测结果代码
     */
    private String uobTestResultCode;

    /**
     * 尿潜血定量检测值（mmol/L）
     */
    private Double uobTestResultValue;

    /**
     * 尿比重
     */
    private Double urineSg;

    /**
     * 尿液酸碱度
     */
    private Double urinePh;

    /**
     * 尿微量白蛋白（mg/dL)
     */
    private Double urineMalb;

    /**
     * 其他尿常规
     */
    private String urineOthers;

    /**
     * 空腹血糖值（mmol/L)
     */
    private Double fbgMmol;

    /**
     * 空腹血糖值（mg/dL)
     */
    private Double fbgMg;

    /**
     * 餐后2小时血糖值（mmol/L)
     */
    private Double pbgMmol;

    /**
     * 餐后2小时血糖值（mg/dL)
     */
    private Double pbgMg;

    /**
     * 心电图异常标志
     */
    private String ecgAbnormCode;

    /**
     * 心电图异常描述
     */
    private String ecgAbnormDesc;

    /**
     * 大便潜血标志
     */
    private String fobCode;

    /**
     * 糖化血红蛋白值（％)
     */
    private Double ghb;

    /**
     * 乙型肝炎病毒表面抗原检测结果代码
     */
    private String hbsagTestResultCode;

    /**
     * 乙型肝炎病毒e抗原检测结果代码
     */
    private String hbeagTestResultCode;

    /**
     * 乙型肝炎病毒表面抗体检测结果代码
     */
    private String hbsabTestResultCode;

    /**
     * 乙型肝炎病毒e抗体检测结果代码
     */
    private String hbeabTestResultCode;

    /**
     * 乙型肝炎病毒核心抗体检测结果代码
     */
    private String hbcabTestResultCode;

    /**
     * 血清谷丙转氨酶值（U/L)
     */
    private Integer sgpt;

    /**
     * 血清谷草转氨酶值（U/L)
     */
    private Integer ast;

    /**
     * 白蛋白浓度(g/L)
     */
    private Integer alb;

    /**
     * 总胆红素值（μmol/L)
     */
    private Double tbi;

    /**
     * 结合胆红素值(μmol/L)
     */
    private Double dbil;

    /**
     * 血清肌酐值(μmol/L)
     */
    private Double scr;

    /**
     * 血尿素氮检测值（mmol/L)
     */
    private Double bun;

    /**
     * 血钾浓度（mmol/L)
     */
    private Double bloodK;

    /**
     * 血钠浓度（mmol/L)
     */
    private Integer bloodNa;

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
     * 癌胚抗原浓度值(μg/L)
     */
    private Double cea;

    /**
     * 胸部X线检查异常标志
     */
    private String xrayChestCode;

    /**
     * 胸部X线检査异常描述
     */
    private String xrayChestAbnormDesc;

    /**
     * 腹部B超检査异常标志
     */
    private String bscanAbdomenCode;

    /**
     * 腹部B超检查异常描述
     */
    private String bscanAbdomenAbnormDesc;

    /**
     * 其他B超检査异常标志
     */
    private String bscanOthersCode;

    /**
     * 其他B超检查异常描述
     */
    private String bscanOthersAbnormDesc;

    /**
     * 宫颈涂片异常标志
     */
    private String cpsCode;

    /**
     * 宫颈涂片异常描述
     */
    private String cpsAbnormDesc;

    /**
     * 其他辅助检查
     */
    private String otherAssistExam;

    /**
     * 老年人中医药健康表ID
     */
    private String elderTcmHealthId;

    /**
     * 中医平和质判定结果代码
     */
    private String gentleQualityCode;

    /**
     * 中医气虚质判定结果代码
     */
    private String qiDeficiencyCode;

    /**
     * 中医阳虚质判定结果代码
     */
    private String yangDeficiencyCode;

    /**
     * 中医阴虚质判定结果代码
     */
    private String yinDeficiencyCode;

    /**
     * 中医痰湿质判定结果代码
     */
    private String phlegmWetCode;

    /**
     * 中医湿热质判定结果代码
     */
    private String dampHeatCode;

    /**
     * 中医血瘀质判定结果代码
     */
    private String bloodStasisCode;

    /**
     * 中医气郁质判定结果代码
     */
    private String qiDepressionCode;

    /**
     * 中医特秉质判定结果代码
     */
    private String specialDiathsisCode;

    /**
     * 精神系统疾病代码
     */
    private String diseNervousCode;

    /**
     * 精神系统疾病描述
     */
    private String diseNervousAbnormDesc;

    /**
     * 其他系统疾病代码
     */
    private String diseOthersCode;

    /**
     * 其他系统疾病描述
     */
    private String diseOthersAbnormDesc;

    /**
     * 健康评价异常标志
     */
    private String healthAbnormCode;

    /**
     * 健康评价异常描述1
     */
    private String healthAbnormDesc1;

    /**
     * 健康评价异常描述2
     */
    private String healthAbnormDesc2;

    /**
     * 健康评价异常描述3
     */
    private String healthAbnormDesc3;

    /**
     * 健康评价异常描述4
     */
    private String healthAbnormDesc4;

    /**
     * 区分大小体检1表示是大体检，其他值是小体检
     */
    private Integer isBigExam;

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

    private Integer isAllExam;

    @Transient
    private List<HealthExamInhos> healthExamInhos;

    @Transient
    private List<HealthExamDrug> healthExamDrug;

    @Transient
    private List<HealthExamNoplanVacc> healthExamNoplanVacc;

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

    public Integer getIsBigExam() {
        return this.isBigExam;
    }

    public void setIsBigExam(Integer isBigExam) {
        this.isBigExam = isBigExam;
    }

    public String getHealthAbnormDesc4() {
        return this.healthAbnormDesc4;
    }

    public void setHealthAbnormDesc4(String healthAbnormDesc4) {
        this.healthAbnormDesc4 = healthAbnormDesc4;
    }

    public String getHealthAbnormDesc3() {
        return this.healthAbnormDesc3;
    }

    public void setHealthAbnormDesc3(String healthAbnormDesc3) {
        this.healthAbnormDesc3 = healthAbnormDesc3;
    }

    public String getHealthAbnormDesc2() {
        return this.healthAbnormDesc2;
    }

    public void setHealthAbnormDesc2(String healthAbnormDesc2) {
        this.healthAbnormDesc2 = healthAbnormDesc2;
    }

    public String getHealthAbnormDesc1() {
        return this.healthAbnormDesc1;
    }

    public void setHealthAbnormDesc1(String healthAbnormDesc1) {
        this.healthAbnormDesc1 = healthAbnormDesc1;
    }

    public String getHealthAbnormCode() {
        return this.healthAbnormCode;
    }

    public void setHealthAbnormCode(String healthAbnormCode) {
        this.healthAbnormCode = healthAbnormCode;
    }

    public String getDiseOthersAbnormDesc() {
        return this.diseOthersAbnormDesc;
    }

    public void setDiseOthersAbnormDesc(String diseOthersAbnormDesc) {
        this.diseOthersAbnormDesc = diseOthersAbnormDesc;
    }

    public String getDiseOthersCode() {
        return this.diseOthersCode;
    }

    public void setDiseOthersCode(String diseOthersCode) {
        this.diseOthersCode = diseOthersCode;
    }

    public String getDiseNervousAbnormDesc() {
        return this.diseNervousAbnormDesc;
    }

    public void setDiseNervousAbnormDesc(String diseNervousAbnormDesc) {
        this.diseNervousAbnormDesc = diseNervousAbnormDesc;
    }

    public String getDiseNervousCode() {
        return this.diseNervousCode;
    }

    public void setDiseNervousCode(String diseNervousCode) {
        this.diseNervousCode = diseNervousCode;
    }

    public String getSpecialDiathsisCode() {
        return this.specialDiathsisCode;
    }

    public void setSpecialDiathsisCode(String specialDiathsisCode) {
        this.specialDiathsisCode = specialDiathsisCode;
    }

    public String getQiDepressionCode() {
        return this.qiDepressionCode;
    }

    public void setQiDepressionCode(String qiDepressionCode) {
        this.qiDepressionCode = qiDepressionCode;
    }

    public String getBloodStasisCode() {
        return this.bloodStasisCode;
    }

    public void setBloodStasisCode(String bloodStasisCode) {
        this.bloodStasisCode = bloodStasisCode;
    }

    public String getDampHeatCode() {
        return this.dampHeatCode;
    }

    public void setDampHeatCode(String dampHeatCode) {
        this.dampHeatCode = dampHeatCode;
    }

    public String getPhlegmWetCode() {
        return this.phlegmWetCode;
    }

    public void setPhlegmWetCode(String phlegmWetCode) {
        this.phlegmWetCode = phlegmWetCode;
    }

    public String getYinDeficiencyCode() {
        return this.yinDeficiencyCode;
    }

    public void setYinDeficiencyCode(String yinDeficiencyCode) {
        this.yinDeficiencyCode = yinDeficiencyCode;
    }

    public String getYangDeficiencyCode() {
        return this.yangDeficiencyCode;
    }

    public void setYangDeficiencyCode(String yangDeficiencyCode) {
        this.yangDeficiencyCode = yangDeficiencyCode;
    }

    public String getQiDeficiencyCode() {
        return this.qiDeficiencyCode;
    }

    public void setQiDeficiencyCode(String qiDeficiencyCode) {
        this.qiDeficiencyCode = qiDeficiencyCode;
    }

    public String getGentleQualityCode() {
        return this.gentleQualityCode;
    }

    public void setGentleQualityCode(String gentleQualityCode) {
        this.gentleQualityCode = gentleQualityCode;
    }

    public String getElderTcmHealthId() {
        return this.elderTcmHealthId;
    }

    public void setElderTcmHealthId(String elderTcmHealthId) {
        this.elderTcmHealthId = elderTcmHealthId;
    }

    public String getOtherAssistExam() {
        return this.otherAssistExam;
    }

    public void setOtherAssistExam(String otherAssistExam) {
        this.otherAssistExam = otherAssistExam;
    }

    public String getCpsAbnormDesc() {
        return this.cpsAbnormDesc;
    }

    public void setCpsAbnormDesc(String cpsAbnormDesc) {
        this.cpsAbnormDesc = cpsAbnormDesc;
    }

    public String getCpsCode() {
        return this.cpsCode;
    }

    public void setCpsCode(String cpsCode) {
        this.cpsCode = cpsCode;
    }

    public String getBscanOthersAbnormDesc() {
        return this.bscanOthersAbnormDesc;
    }

    public void setBscanOthersAbnormDesc(String bscanOthersAbnormDesc) {
        this.bscanOthersAbnormDesc = bscanOthersAbnormDesc;
    }

    public String getBscanOthersCode() {
        return this.bscanOthersCode;
    }

    public void setBscanOthersCode(String bscanOthersCode) {
        this.bscanOthersCode = bscanOthersCode;
    }

    public String getBscanAbdomenAbnormDesc() {
        return this.bscanAbdomenAbnormDesc;
    }

    public void setBscanAbdomenAbnormDesc(String bscanAbdomenAbnormDesc) {
        this.bscanAbdomenAbnormDesc = bscanAbdomenAbnormDesc;
    }

    public String getBscanAbdomenCode() {
        return this.bscanAbdomenCode;
    }

    public void setBscanAbdomenCode(String bscanAbdomenCode) {
        this.bscanAbdomenCode = bscanAbdomenCode;
    }

    public String getXrayChestAbnormDesc() {
        return this.xrayChestAbnormDesc;
    }

    public void setXrayChestAbnormDesc(String xrayChestAbnormDesc) {
        this.xrayChestAbnormDesc = xrayChestAbnormDesc;
    }

    public String getXrayChestCode() {
        return this.xrayChestCode;
    }

    public void setXrayChestCode(String xrayChestCode) {
        this.xrayChestCode = xrayChestCode;
    }

    public Double getCea() {
        return this.cea;
    }

    public void setCea(Double cea) {
        this.cea = cea;
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

    public Integer getBloodNa() {
        return this.bloodNa;
    }

    public void setBloodNa(Integer bloodNa) {
        this.bloodNa = bloodNa;
    }

    public Double getBloodK() {
        return this.bloodK;
    }

    public void setBloodK(Double bloodK) {
        this.bloodK = bloodK;
    }

    public Double getBun() {
        return this.bun;
    }

    public void setBun(Double bun) {
        this.bun = bun;
    }

    public Double getScr() {
        return this.scr;
    }

    public void setScr(Double scr) {
        this.scr = scr;
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

    public Integer getAlb() {
        return this.alb;
    }

    public void setAlb(Integer alb) {
        this.alb = alb;
    }

    public Integer getAst() {
        return this.ast;
    }

    public void setAst(Integer ast) {
        this.ast = ast;
    }

    public Integer getSgpt() {
        return this.sgpt;
    }

    public void setSgpt(Integer sgpt) {
        this.sgpt = sgpt;
    }

    public String getHbcabTestResultCode() {
        return this.hbcabTestResultCode;
    }

    public void setHbcabTestResultCode(String hbcabTestResultCode) {
        this.hbcabTestResultCode = hbcabTestResultCode;
    }

    public String getHbeabTestResultCode() {
        return this.hbeabTestResultCode;
    }

    public void setHbeabTestResultCode(String hbeabTestResultCode) {
        this.hbeabTestResultCode = hbeabTestResultCode;
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

    public String getHbsagTestResultCode() {
        return this.hbsagTestResultCode;
    }

    public void setHbsagTestResultCode(String hbsagTestResultCode) {
        this.hbsagTestResultCode = hbsagTestResultCode;
    }

    public Double getGhb() {
        return this.ghb;
    }

    public void setGhb(Double ghb) {
        this.ghb = ghb;
    }

    public String getFobCode() {
        return this.fobCode;
    }

    public void setFobCode(String fobCode) {
        this.fobCode = fobCode;
    }

    public String getEcgAbnormDesc() {
        return this.ecgAbnormDesc;
    }

    public void setEcgAbnormDesc(String ecgAbnormDesc) {
        this.ecgAbnormDesc = ecgAbnormDesc;
    }

    public String getEcgAbnormCode() {
        return this.ecgAbnormCode;
    }

    public void setEcgAbnormCode(String ecgAbnormCode) {
        this.ecgAbnormCode = ecgAbnormCode;
    }

    public Double getPbgMg() {
        return this.pbgMg;
    }

    public void setPbgMg(Double pbgMg) {
        this.pbgMg = pbgMg;
    }

    public Double getPbgMmol() {
        return this.pbgMmol;
    }

    public void setPbgMmol(Double pbgMmol) {
        this.pbgMmol = pbgMmol;
    }

    public Double getFbgMg() {
        return this.fbgMg;
    }

    public void setFbgMg(Double fbgMg) {
        this.fbgMg = fbgMg;
    }

    public Double getFbgMmol() {
        return this.fbgMmol;
    }

    public void setFbgMmol(Double fbgMmol) {
        this.fbgMmol = fbgMmol;
    }

    public String getUrineOthers() {
        return this.urineOthers;
    }

    public void setUrineOthers(String urineOthers) {
        this.urineOthers = urineOthers;
    }

    public Double getUrineMalb() {
        return this.urineMalb;
    }

    public void setUrineMalb(Double urineMalb) {
        this.urineMalb = urineMalb;
    }

    public Double getUrinePh() {
        return this.urinePh;
    }

    public void setUrinePh(Double urinePh) {
        this.urinePh = urinePh;
    }

    public Double getUrineSg() {
        return this.urineSg;
    }

    public void setUrineSg(Double urineSg) {
        this.urineSg = urineSg;
    }

    public Double getUobTestResultValue() {
        return this.uobTestResultValue;
    }

    public void setUobTestResultValue(Double uobTestResultValue) {
        this.uobTestResultValue = uobTestResultValue;
    }

    public String getUobTestResultCode() {
        return this.uobTestResultCode;
    }

    public void setUobTestResultCode(String uobTestResultCode) {
        this.uobTestResultCode = uobTestResultCode;
    }

    public Double getKetQualResultValue() {
        return this.ketQualResultValue;
    }

    public void setKetQualResultValue(Double ketQualResultValue) {
        this.ketQualResultValue = ketQualResultValue;
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

    public Double getProQuanTestValue() {
        return this.proQuanTestValue;
    }

    public void setProQuanTestValue(Double proQuanTestValue) {
        this.proQuanTestValue = proQuanTestValue;
    }

    public String getProQualResultCode() {
        return this.proQualResultCode;
    }

    public void setProQualResultCode(String proQualResultCode) {
        this.proQualResultCode = proQualResultCode;
    }

    public String getCbcOthers() {
        return this.cbcOthers;
    }

    public void setCbcOthers(String cbcOthers) {
        this.cbcOthers = cbcOthers;
    }

    public Integer getPlt() {
        return this.plt;
    }

    public void setPlt(Integer plt) {
        this.plt = plt;
    }

    public Double getWbc() {
        return this.wbc;
    }

    public void setWbc(Double wbc) {
        this.wbc = wbc;
    }

    public Integer getHgb() {
        return this.hgb;
    }

    public void setHgb(Integer hgb) {
        this.hgb = hgb;
    }

    public String getOtherHealthExamResult() {
        return this.otherHealthExamResult;
    }

    public void setOtherHealthExamResult(String otherHealthExamResult) {
        this.otherHealthExamResult = otherHealthExamResult;
    }

    public String getAdnexaAbnormDesc() {
        return this.adnexaAbnormDesc;
    }

    public void setAdnexaAbnormDesc(String adnexaAbnormDesc) {
        this.adnexaAbnormDesc = adnexaAbnormDesc;
    }

    public String getAdnexaCode() {
        return this.adnexaCode;
    }

    public void setAdnexaCode(String adnexaCode) {
        this.adnexaCode = adnexaCode;
    }

    public String getCorpusuteriAbnormDesc() {
        return this.corpusuteriAbnormDesc;
    }

    public void setCorpusuteriAbnormDesc(String corpusuteriAbnormDesc) {
        this.corpusuteriAbnormDesc = corpusuteriAbnormDesc;
    }

    public String getCorpusuteriCode() {
        return this.corpusuteriCode;
    }

    public void setCorpusuteriCode(String corpusuteriCode) {
        this.corpusuteriCode = corpusuteriCode;
    }

    public String getCervixAbnormDesc() {
        return this.cervixAbnormDesc;
    }

    public void setCervixAbnormDesc(String cervixAbnormDesc) {
        this.cervixAbnormDesc = cervixAbnormDesc;
    }

    public String getCervixCode() {
        return this.cervixCode;
    }

    public void setCervixCode(String cervixCode) {
        this.cervixCode = cervixCode;
    }

    public String getVaginaAbnormDesc() {
        return this.vaginaAbnormDesc;
    }

    public void setVaginaAbnormDesc(String vaginaAbnormDesc) {
        this.vaginaAbnormDesc = vaginaAbnormDesc;
    }

    public String getVaginaCode() {
        return this.vaginaCode;
    }

    public void setVaginaCode(String vaginaCode) {
        this.vaginaCode = vaginaCode;
    }

    public String getVulvaAbnormDesc() {
        return this.vulvaAbnormDesc;
    }

    public void setVulvaAbnormDesc(String vulvaAbnormDesc) {
        this.vulvaAbnormDesc = vulvaAbnormDesc;
    }

    public String getVulvaCode() {
        return this.vulvaCode;
    }

    public void setVulvaCode(String vulvaCode) {
        this.vulvaCode = vulvaCode;
    }

    public String getDreOthersDesc() {
        return this.dreOthersDesc;
    }

    public void setDreOthersDesc(String dreOthersDesc) {
        this.dreOthersDesc = dreOthersDesc;
    }

    public String getDreCode() {
        return this.dreCode;
    }

    public void setDreCode(String dreCode) {
        this.dreCode = dreCode;
    }

    public String getPofdaCode() {
        return this.pofdaCode;
    }

    public void setPofdaCode(String pofdaCode) {
        this.pofdaCode = pofdaCode;
    }

    public String getHasAbdominalDullnessDesc() {
        return this.hasAbdominalDullnessDesc;
    }

    public void setHasAbdominalDullnessDesc(String hasAbdominalDullnessDesc) {
        this.hasAbdominalDullnessDesc = hasAbdominalDullnessDesc;
    }

    public String getAbdominalDullnessCode() {
        return this.abdominalDullnessCode;
    }

    public void setAbdominalDullnessCode(String abdominalDullnessCode) {
        this.abdominalDullnessCode = abdominalDullnessCode;
    }

    public String getHasSplenomegalyDesc() {
        return this.hasSplenomegalyDesc;
    }

    public void setHasSplenomegalyDesc(String hasSplenomegalyDesc) {
        this.hasSplenomegalyDesc = hasSplenomegalyDesc;
    }

    public String getSplenomegalyCode() {
        return this.splenomegalyCode;
    }

    public void setSplenomegalyCode(String splenomegalyCode) {
        this.splenomegalyCode = splenomegalyCode;
    }

    public String getHasHepatauxeDesc() {
        return this.hasHepatauxeDesc;
    }

    public void setHasHepatauxeDesc(String hasHepatauxeDesc) {
        this.hasHepatauxeDesc = hasHepatauxeDesc;
    }

    public String getHepatauxeCode() {
        return this.hepatauxeCode;
    }

    public void setHepatauxeCode(String hepatauxeCode) {
        this.hepatauxeCode = hepatauxeCode;
    }

    public String getHasAbdominalMassDesc() {
        return this.hasAbdominalMassDesc;
    }

    public void setHasAbdominalMassDesc(String hasAbdominalMassDesc) {
        this.hasAbdominalMassDesc = hasAbdominalMassDesc;
    }

    public String getAbdominalMassCode() {
        return this.abdominalMassCode;
    }

    public void setAbdominalMassCode(String abdominalMassCode) {
        this.abdominalMassCode = abdominalMassCode;
    }

    public String getHasAbdominalTendDesc() {
        return this.hasAbdominalTendDesc;
    }

    public void setHasAbdominalTendDesc(String hasAbdominalTendDesc) {
        this.hasAbdominalTendDesc = hasAbdominalTendDesc;
    }

    public String getAbdominalTendCode() {
        return this.abdominalTendCode;
    }

    public void setAbdominalTendCode(String abdominalTendCode) {
        this.abdominalTendCode = abdominalTendCode;
    }

    public String getHeartMurmurDesc() {
        return this.heartMurmurDesc;
    }

    public void setHeartMurmurDesc(String heartMurmurDesc) {
        this.heartMurmurDesc = heartMurmurDesc;
    }

    public String getHeartMurmurCode() {
        return this.heartMurmurCode;
    }

    public void setHeartMurmurCode(String heartMurmurCode) {
        this.heartMurmurCode = heartMurmurCode;
    }

    public String getHeartRhythmTypeCode() {
        return this.heartRhythmTypeCode;
    }

    public void setHeartRhythmTypeCode(String heartRhythmTypeCode) {
        this.heartRhythmTypeCode = heartRhythmTypeCode;
    }

    public Integer getHeartRate() {
        return this.heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public String getLungRaleOthersDesc() {
        return this.lungRaleOthersDesc;
    }

    public void setLungRaleOthersDesc(String lungRaleOthersDesc) {
        this.lungRaleOthersDesc = lungRaleOthersDesc;
    }

    public String getLungRaleCode() {
        return this.lungRaleCode;
    }

    public void setLungRaleCode(String lungRaleCode) {
        this.lungRaleCode = lungRaleCode;
    }

    public String getLungSoundAbnormDesc() {
        return this.lungSoundAbnormDesc;
    }

    public void setLungSoundAbnormDesc(String lungSoundAbnormDesc) {
        this.lungSoundAbnormDesc = lungSoundAbnormDesc;
    }

    public String getLungSoundCode() {
        return this.lungSoundCode;
    }

    public void setLungSoundCode(String lungSoundCode) {
        this.lungSoundCode = lungSoundCode;
    }

    public String getBarrelChestCode() {
        return this.barrelChestCode;
    }

    public void setBarrelChestCode(String barrelChestCode) {
        this.barrelChestCode = barrelChestCode;
    }

    public String getLymphOthersDesc() {
        return this.lymphOthersDesc;
    }

    public void setLymphOthersDesc(String lymphOthersDesc) {
        this.lymphOthersDesc = lymphOthersDesc;
    }

    public String getLymphCode() {
        return this.lymphCode;
    }

    public void setLymphCode(String lymphCode) {
        this.lymphCode = lymphCode;
    }

    public String getScleralOthersDesc() {
        return this.scleralOthersDesc;
    }

    public void setScleralOthersDesc(String scleralOthersDesc) {
        this.scleralOthersDesc = scleralOthersDesc;
    }

    public String getScleralCode() {
        return this.scleralCode;
    }

    public void setScleralCode(String scleralCode) {
        this.scleralCode = scleralCode;
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

    public String getEyegroundAbnormDesc() {
        return this.eyegroundAbnormDesc;
    }

    public void setEyegroundAbnormDesc(String eyegroundAbnormDesc) {
        this.eyegroundAbnormDesc = eyegroundAbnormDesc;
    }

    public String getEyegroundCode() {
        return this.eyegroundCode;
    }

    public void setEyegroundCode(String eyegroundCode) {
        this.eyegroundCode = eyegroundCode;
    }

    public String getMovementFunctionCode() {
        return this.movementFunctionCode;
    }

    public void setMovementFunctionCode(String movementFunctionCode) {
        this.movementFunctionCode = movementFunctionCode;
    }

    public String getHearingCode() {
        return this.hearingCode;
    }

    public void setHearingCode(String hearingCode) {
        this.hearingCode = hearingCode;
    }

    public Double getRightCorrectEyesight() {
        return this.rightCorrectEyesight;
    }

    public void setRightCorrectEyesight(Double rightCorrectEyesight) {
        this.rightCorrectEyesight = rightCorrectEyesight;
    }

    public Double getLeftCorrectEyesight() {
        return this.leftCorrectEyesight;
    }

    public void setLeftCorrectEyesight(Double leftCorrectEyesight) {
        this.leftCorrectEyesight = leftCorrectEyesight;
    }

    public Double getRightOriginalEyesight() {
        return this.rightOriginalEyesight;
    }

    public void setRightOriginalEyesight(Double rightOriginalEyesight) {
        this.rightOriginalEyesight = rightOriginalEyesight;
    }

    public Double getLeftOriginalEyesight() {
        return this.leftOriginalEyesight;
    }

    public void setLeftOriginalEyesight(Double leftOriginalEyesight) {
        this.leftOriginalEyesight = leftOriginalEyesight;
    }

    public String getPharynxExamResultCode() {
        return this.pharynxExamResultCode;
    }

    public void setPharynxExamResultCode(String pharynxExamResultCode) {
        this.pharynxExamResultCode = pharynxExamResultCode;
    }

    public Integer getFalseBrTeethNum() {
        return this.falseBrTeethNum;
    }

    public void setFalseBrTeethNum(Integer falseBrTeethNum) {
        this.falseBrTeethNum = falseBrTeethNum;
    }

    public Integer getFalseBlTeethNum() {
        return this.falseBlTeethNum;
    }

    public void setFalseBlTeethNum(Integer falseBlTeethNum) {
        this.falseBlTeethNum = falseBlTeethNum;
    }

    public Integer getFalseUrTeethNum() {
        return this.falseUrTeethNum;
    }

    public void setFalseUrTeethNum(Integer falseUrTeethNum) {
        this.falseUrTeethNum = falseUrTeethNum;
    }

    public Integer getFalseUlTeethNum() {
        return this.falseUlTeethNum;
    }

    public void setFalseUlTeethNum(Integer falseUlTeethNum) {
        this.falseUlTeethNum = falseUlTeethNum;
    }

    public Integer getAllFalseTeeth() {
        return this.allFalseTeeth;
    }

    public void setAllFalseTeeth(Integer allFalseTeeth) {
        this.allFalseTeeth = allFalseTeeth;
    }

    public Integer getIsFalseTeeth() {
        return this.isFalseTeeth;
    }

    public void setIsFalseTeeth(Integer isFalseTeeth) {
        this.isFalseTeeth = isFalseTeeth;
    }

    public Integer getDecayedBrToothNum() {
        return this.decayedBrToothNum;
    }

    public void setDecayedBrToothNum(Integer decayedBrToothNum) {
        this.decayedBrToothNum = decayedBrToothNum;
    }

    public Integer getDecayedBlToothNum() {
        return this.decayedBlToothNum;
    }

    public void setDecayedBlToothNum(Integer decayedBlToothNum) {
        this.decayedBlToothNum = decayedBlToothNum;
    }

    public Integer getDecayedUrToothNum() {
        return this.decayedUrToothNum;
    }

    public void setDecayedUrToothNum(Integer decayedUrToothNum) {
        this.decayedUrToothNum = decayedUrToothNum;
    }

    public Integer getDecayedUlToothNum() {
        return this.decayedUlToothNum;
    }

    public void setDecayedUlToothNum(Integer decayedUlToothNum) {
        this.decayedUlToothNum = decayedUlToothNum;
    }

    public Integer getIsDecayedTooth() {
        return this.isDecayedTooth;
    }

    public void setIsDecayedTooth(Integer isDecayedTooth) {
        this.isDecayedTooth = isDecayedTooth;
    }

    public Integer getLoseBrTeethNum() {
        return this.loseBrTeethNum;
    }

    public void setLoseBrTeethNum(Integer loseBrTeethNum) {
        this.loseBrTeethNum = loseBrTeethNum;
    }

    public Integer getLoseBlTeethNum() {
        return this.loseBlTeethNum;
    }

    public void setLoseBlTeethNum(Integer loseBlTeethNum) {
        this.loseBlTeethNum = loseBlTeethNum;
    }

    public Integer getLoseUrTeethNum() {
        return this.loseUrTeethNum;
    }

    public void setLoseUrTeethNum(Integer loseUrTeethNum) {
        this.loseUrTeethNum = loseUrTeethNum;
    }

    public Integer getLoseUlTeethNum() {
        return this.loseUlTeethNum;
    }

    public void setLoseUlTeethNum(Integer loseUlTeethNum) {
        this.loseUlTeethNum = loseUlTeethNum;
    }

    public Integer getAllLoseTeeth() {
        return this.allLoseTeeth;
    }

    public void setAllLoseTeeth(Integer allLoseTeeth) {
        this.allLoseTeeth = allLoseTeeth;
    }

    public Integer getIsLosetTeeth() {
        return this.isLosetTeeth;
    }

    public void setIsLosetTeeth(Integer isLosetTeeth) {
        this.isLosetTeeth = isLosetTeeth;
    }

    public String getDentitionTypeCode() {
        return this.dentitionTypeCode;
    }

    public void setDentitionTypeCode(String dentitionTypeCode) {
        this.dentitionTypeCode = dentitionTypeCode;
    }

    public String getLipExamResultCode() {
        return this.lipExamResultCode;
    }

    public void setLipExamResultCode(String lipExamResultCode) {
        this.lipExamResultCode = lipExamResultCode;
    }

    public String getPoisonOthersProtectValue() {
        return this.poisonOthersProtectValue;
    }

    public void setPoisonOthersProtectValue(String poisonOthersProtectValue) {
        this.poisonOthersProtectValue = poisonOthersProtectValue;
    }

    public String getPoisonOthersProtectCode() {
        return this.poisonOthersProtectCode;
    }

    public void setPoisonOthersProtectCode(String poisonOthersProtectCode) {
        this.poisonOthersProtectCode = poisonOthersProtectCode;
    }

    public String getPoisonOthers() {
        return this.poisonOthers;
    }

    public void setPoisonOthers(String poisonOthers) {
        this.poisonOthers = poisonOthers;
    }

    public String getPoisonChemicalProtectValue() {
        return this.poisonChemicalProtectValue;
    }

    public void setPoisonChemicalProtectValue(String poisonChemicalProtectValue) {
        this.poisonChemicalProtectValue = poisonChemicalProtectValue;
    }

    public String getPoisonChemicalProtectCode() {
        return this.poisonChemicalProtectCode;
    }

    public void setPoisonChemicalProtectCode(String poisonChemicalProtectCode) {
        this.poisonChemicalProtectCode = poisonChemicalProtectCode;
    }

    public String getPoisonChemical() {
        return this.poisonChemical;
    }

    public void setPoisonChemical(String poisonChemical) {
        this.poisonChemical = poisonChemical;
    }

    public String getPoisonPhysicalProtectValue() {
        return this.poisonPhysicalProtectValue;
    }

    public void setPoisonPhysicalProtectValue(String poisonPhysicalProtectValue) {
        this.poisonPhysicalProtectValue = poisonPhysicalProtectValue;
    }

    public String getPoisonPhysicalProtectCode() {
        return this.poisonPhysicalProtectCode;
    }

    public void setPoisonPhysicalProtectCode(String poisonPhysicalProtectCode) {
        this.poisonPhysicalProtectCode = poisonPhysicalProtectCode;
    }

    public String getPoisonPhysical() {
        return this.poisonPhysical;
    }

    public void setPoisonPhysical(String poisonPhysical) {
        this.poisonPhysical = poisonPhysical;
    }

    public String getPoisonRadiogenProtectValue() {
        return this.poisonRadiogenProtectValue;
    }

    public void setPoisonRadiogenProtectValue(String poisonRadiogenProtectValue) {
        this.poisonRadiogenProtectValue = poisonRadiogenProtectValue;
    }

    public String getPoisonRadiogenProtectCode() {
        return this.poisonRadiogenProtectCode;
    }

    public void setPoisonRadiogenProtectCode(String poisonRadiogenProtectCode) {
        this.poisonRadiogenProtectCode = poisonRadiogenProtectCode;
    }

    public String getPoisonRadiogen() {
        return this.poisonRadiogen;
    }

    public void setPoisonRadiogen(String poisonRadiogen) {
        this.poisonRadiogen = poisonRadiogen;
    }

    public String getPoisonDustProtectValue() {
        return this.poisonDustProtectValue;
    }

    public void setPoisonDustProtectValue(String poisonDustProtectValue) {
        this.poisonDustProtectValue = poisonDustProtectValue;
    }

    public String getPoisonDustProtectCode() {
        return this.poisonDustProtectCode;
    }

    public void setPoisonDustProtectCode(String poisonDustProtectCode) {
        this.poisonDustProtectCode = poisonDustProtectCode;
    }

    public String getPoisonDust() {
        return this.poisonDust;
    }

    public void setPoisonDust(String poisonDust) {
        this.poisonDust = poisonDust;
    }

    public Integer getOccupExposureWorkYear() {
        return this.occupExposureWorkYear;
    }

    public void setOccupExposureWorkYear(Integer occupExposureWorkYear) {
        this.occupExposureWorkYear = occupExposureWorkYear;
    }

    public String getOccupExposureWork() {
        return this.occupExposureWork;
    }

    public void setOccupExposureWork(String occupExposureWork) {
        this.occupExposureWork = occupExposureWork;
    }

    public String getOccupExposureCode() {
        return this.occupExposureCode;
    }

    public void setOccupExposureCode(String occupExposureCode) {
        this.occupExposureCode = occupExposureCode;
    }

    public String getDrunkCode() {
        return this.drunkCode;
    }

    public void setDrunkCode(String drunkCode) {
        this.drunkCode = drunkCode;
    }

    public Integer getStartDrinkingAge() {
        return this.startDrinkingAge;
    }

    public void setStartDrinkingAge(Integer startDrinkingAge) {
        this.startDrinkingAge = startDrinkingAge;
    }

    public Integer getStopDrinkingAge() {
        return this.stopDrinkingAge;
    }

    public void setStopDrinkingAge(Integer stopDrinkingAge) {
        this.stopDrinkingAge = stopDrinkingAge;
    }

    public String getStopDrinkingCode() {
        return this.stopDrinkingCode;
    }

    public void setStopDrinkingCode(String stopDrinkingCode) {
        this.stopDrinkingCode = stopDrinkingCode;
    }

    public Integer getDailyDrinking() {
        return this.dailyDrinking;
    }

    public void setDailyDrinking(Integer dailyDrinking) {
        this.dailyDrinking = dailyDrinking;
    }

    public String getDrinkingFreqCode() {
        return this.drinkingFreqCode;
    }

    public void setDrinkingFreqCode(String drinkingFreqCode) {
        this.drinkingFreqCode = drinkingFreqCode;
    }

    public Integer getStopSmokingAge() {
        return this.stopSmokingAge;
    }

    public void setStopSmokingAge(Integer stopSmokingAge) {
        this.stopSmokingAge = stopSmokingAge;
    }

    public Integer getStartSmokingAge() {
        return this.startSmokingAge;
    }

    public void setStartSmokingAge(Integer startSmokingAge) {
        this.startSmokingAge = startSmokingAge;
    }

    public Integer getDailySmoking() {
        return this.dailySmoking;
    }

    public void setDailySmoking(Integer dailySmoking) {
        this.dailySmoking = dailySmoking;
    }

    public String getSmokingStatusCode() {
        return this.smokingStatusCode;
    }

    public void setSmokingStatusCode(String smokingStatusCode) {
        this.smokingStatusCode = smokingStatusCode;
    }

    public String getExerciseWay() {
        return this.exerciseWay;
    }

    public void setExerciseWay(String exerciseWay) {
        this.exerciseWay = exerciseWay;
    }

    public Integer getExerciseYear() {
        return this.exerciseYear;
    }

    public void setExerciseYear(Integer exerciseYear) {
        this.exerciseYear = exerciseYear;
    }

    public Integer getExerciseDurationMins() {
        return this.exerciseDurationMins;
    }

    public void setExerciseDurationMins(Integer exerciseDurationMins) {
        this.exerciseDurationMins = exerciseDurationMins;
    }

    public String getExerciseFreqCode() {
        return this.exerciseFreqCode;
    }

    public void setExerciseFreqCode(String exerciseFreqCode) {
        this.exerciseFreqCode = exerciseFreqCode;
    }

    public Integer getElderDepressionScore() {
        return this.elderDepressionScore;
    }

    public void setElderDepressionScore(Integer elderDepressionScore) {
        this.elderDepressionScore = elderDepressionScore;
    }

    public String getElderDepressedId() {
        return this.elderDepressedId;
    }

    public void setElderDepressedId(String elderDepressedId) {
        this.elderDepressedId = elderDepressedId;
    }

    public String getElderEmotionalResultCode() {
        return this.elderEmotionalResultCode;
    }

    public void setElderEmotionalResultCode(String elderEmotionalResultCode) {
        this.elderEmotionalResultCode = elderEmotionalResultCode;
    }

    public Integer getElderBrainScore() {
        return this.elderBrainScore;
    }

    public void setElderBrainScore(Integer elderBrainScore) {
        this.elderBrainScore = elderBrainScore;
    }

    public String getElderCognitionId() {
        return this.elderCognitionId;
    }

    public void setElderCognitionId(String elderCognitionId) {
        this.elderCognitionId = elderCognitionId;
    }

    public String getElderCognitionResultCode() {
        return this.elderCognitionResultCode;
    }

    public void setElderCognitionResultCode(String elderCognitionResultCode) {
        this.elderCognitionResultCode = elderCognitionResultCode;
    }

    public String getElderSelfCareAssessCode() {
        return this.elderSelfCareAssessCode;
    }

    public void setElderSelfCareAssessCode(String elderSelfCareAssessCode) {
        this.elderSelfCareAssessCode = elderSelfCareAssessCode;
    }

    public String getElderHealthAssessCode() {
        return this.elderHealthAssessCode;
    }

    public void setElderHealthAssessCode(String elderHealthAssessCode) {
        this.elderHealthAssessCode = elderHealthAssessCode;
    }

    public String getElderSelfcareAbilityId() {
        return this.elderSelfcareAbilityId;
    }

    public void setElderSelfcareAbilityId(String elderSelfcareAbilityId) {
        this.elderSelfcareAbilityId = elderSelfcareAbilityId;
    }

    public Double getBmi() {
        return this.bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getWaist() {
        return this.waist;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
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

    public Integer getRdbp() {
        return this.rdbp;
    }

    public void setRdbp(Integer rdbp) {
        this.rdbp = rdbp;
    }

    public Integer getRsbp() {
        return this.rsbp;
    }

    public void setRsbp(Integer rsbp) {
        this.rsbp = rsbp;
    }

    public Integer getLdbp() {
        return this.ldbp;
    }

    public void setLdbp(Integer ldbp) {
        this.ldbp = ldbp;
    }

    public Integer getLsbp() {
        return this.lsbp;
    }

    public void setLsbp(Integer lsbp) {
        this.lsbp = lsbp;
    }

    public Integer getBreathingRate() {
        return this.breathingRate;
    }

    public void setBreathingRate(Integer breathingRate) {
        this.breathingRate = breathingRate;
    }

    public Integer getPulseRate() {
        return this.pulseRate;
    }

    public void setPulseRate(Integer pulseRate) {
        this.pulseRate = pulseRate;
    }

    public Double getBodyTemperature() {
        return this.bodyTemperature;
    }

    public void setBodyTemperature(Double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
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

    public Date getHealthExamDate() {
        return this.healthExamDate;
    }

    public void setHealthExamDate(Date healthExamDate) {
        this.healthExamDate = healthExamDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealthExamNo() {
        return this.healthExamNo;
    }

    public void setHealthExamNo(String healthExamNo) {
        this.healthExamNo = healthExamNo;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getHealthExamId() {
        return this.healthExamId;
    }

    public void setHealthExamId(String healthExamId) {
        this.healthExamId = healthExamId;
    }

    public List<HealthExamInhos> getHealthExamInhos() {
        return healthExamInhos;
    }

    public void setHealthExamInhos(List<HealthExamInhos> healthExamInhos) {
        this.healthExamInhos = healthExamInhos;
    }

    public List<HealthExamDrug> getHealthExamDrug() {
        return healthExamDrug;
    }

    public void setHealthExamDrug(List<HealthExamDrug> healthExamDrug) {
        this.healthExamDrug = healthExamDrug;
    }

    public List<HealthExamNoplanVacc> getHealthExamNoplanVacc() {
        return healthExamNoplanVacc;
    }

    public void setHealthExamNoplanVacc(List<HealthExamNoplanVacc> healthExamNoplanVacc) {
        this.healthExamNoplanVacc = healthExamNoplanVacc;
    }

    public String getEoleCode() {
        return this.eoleCode;
    }

    public void setEoleCode(String eoleCode) {
        this.eoleCode = eoleCode;
    }

    public Integer getIsAllExam() {
        return this.isAllExam;
    }

    public void setIsAllExam(Integer isAllExam) {
        this.isAllExam = isAllExam;
    }

    @Generated(hash = 380610359)
    public HealthExam(String healthExamId, String personInfoId, String orgId, String healthExamNo,
            String name, Date healthExamDate, String respDoctorId, String respDoctorName,
            Double bodyTemperature, Integer pulseRate, Integer breathingRate, Integer lsbp,
            Integer ldbp, Integer rsbp, Integer rdbp, Double height, Double weight, Double waist,
            Double bmi, String elderSelfcareAbilityId, String elderHealthAssessCode,
            String elderSelfCareAssessCode, String elderCognitionResultCode, String elderCognitionId,
            Integer elderBrainScore, String elderEmotionalResultCode, String elderDepressedId,
            Integer elderDepressionScore, String exerciseFreqCode, Integer exerciseDurationMins,
            Integer exerciseYear, String exerciseWay, String smokingStatusCode, Integer dailySmoking,
            Integer startSmokingAge, Integer stopSmokingAge, String drinkingFreqCode,
            Integer dailyDrinking, String stopDrinkingCode, Integer stopDrinkingAge,
            Integer startDrinkingAge, String drunkCode, String occupExposureCode,
            String occupExposureWork, Integer occupExposureWorkYear, String poisonDust,
            String poisonDustProtectCode, String poisonDustProtectValue, String poisonRadiogen,
            String poisonRadiogenProtectCode, String poisonRadiogenProtectValue, String poisonPhysical,
            String poisonPhysicalProtectCode, String poisonPhysicalProtectValue, String poisonChemical,
            String poisonChemicalProtectCode, String poisonChemicalProtectValue, String poisonOthers,
            String poisonOthersProtectCode, String poisonOthersProtectValue, String lipExamResultCode,
            String dentitionTypeCode, Integer isLosetTeeth, Integer allLoseTeeth,
            Integer loseUlTeethNum, Integer loseUrTeethNum, Integer loseBlTeethNum,
            Integer loseBrTeethNum, Integer isDecayedTooth, Integer decayedUlToothNum,
            Integer decayedUrToothNum, Integer decayedBlToothNum, Integer decayedBrToothNum,
            Integer isFalseTeeth, Integer allFalseTeeth, Integer falseUlTeethNum,
            Integer falseUrTeethNum, Integer falseBlTeethNum, Integer falseBrTeethNum,
            String pharynxExamResultCode, Double leftOriginalEyesight, Double rightOriginalEyesight,
            Double leftCorrectEyesight, Double rightCorrectEyesight, String hearingCode,
            String movementFunctionCode, String eyegroundCode, String eyegroundAbnormDesc,
            String skinCode, String skinOthersDesc, String scleralCode, String scleralOthersDesc,
            String lymphCode, String lymphOthersDesc, String barrelChestCode, String lungSoundCode,
            String lungSoundAbnormDesc, String lungRaleCode, String lungRaleOthersDesc,
            Integer heartRate, String heartRhythmTypeCode, String heartMurmurCode,
            String heartMurmurDesc, String abdominalTendCode, String hasAbdominalTendDesc,
            String abdominalMassCode, String hasAbdominalMassDesc, String hepatauxeCode,
            String hasHepatauxeDesc, String splenomegalyCode, String hasSplenomegalyDesc,
            String abdominalDullnessCode, String hasAbdominalDullnessDesc, String eoleCode,
            String pofdaCode, String dreCode, String dreOthersDesc, String vulvaCode,
            String vulvaAbnormDesc, String vaginaCode, String vaginaAbnormDesc, String cervixCode,
            String cervixAbnormDesc, String corpusuteriCode, String corpusuteriAbnormDesc,
            String adnexaCode, String adnexaAbnormDesc, String otherHealthExamResult, Integer hgb,
            Double wbc, Integer plt, String cbcOthers, String proQualResultCode,
            Double proQuanTestValue, String gluQualResultCode, Double gluQuanTestValue,
            String ketQualResultCode, Double ketQualResultValue, String uobTestResultCode,
            Double uobTestResultValue, Double urineSg, Double urinePh, Double urineMalb,
            String urineOthers, Double fbgMmol, Double fbgMg, Double pbgMmol, Double pbgMg,
            String ecgAbnormCode, String ecgAbnormDesc, String fobCode, Double ghb,
            String hbsagTestResultCode, String hbeagTestResultCode, String hbsabTestResultCode,
            String hbeabTestResultCode, String hbcabTestResultCode, Integer sgpt, Integer ast,
            Integer alb, Double tbi, Double dbil, Double scr, Double bun, Double bloodK,
            Integer bloodNa, Double tcho, Double tg, Double ldlc, Double hdlc, Double cea,
            String xrayChestCode, String xrayChestAbnormDesc, String bscanAbdomenCode,
            String bscanAbdomenAbnormDesc, String bscanOthersCode, String bscanOthersAbnormDesc,
            String cpsCode, String cpsAbnormDesc, String otherAssistExam, String elderTcmHealthId,
            String gentleQualityCode, String qiDeficiencyCode, String yangDeficiencyCode,
            String yinDeficiencyCode, String phlegmWetCode, String dampHeatCode,
            String bloodStasisCode, String qiDepressionCode, String specialDiathsisCode,
            String diseNervousCode, String diseNervousAbnormDesc, String diseOthersCode,
            String diseOthersAbnormDesc, String healthAbnormCode, String healthAbnormDesc1,
            String healthAbnormDesc2, String healthAbnormDesc3, String healthAbnormDesc4,
            Integer isBigExam, Integer isCancel, String createOrgId, String orgName, String creatorId,
            String creator, Date createTime, String modifiedOrgId, String modifiedOrgName,
            String modifierId, String modifier, Date modifiedTime, Integer isAllExam) {
        this.healthExamId = healthExamId;
        this.personInfoId = personInfoId;
        this.orgId = orgId;
        this.healthExamNo = healthExamNo;
        this.name = name;
        this.healthExamDate = healthExamDate;
        this.respDoctorId = respDoctorId;
        this.respDoctorName = respDoctorName;
        this.bodyTemperature = bodyTemperature;
        this.pulseRate = pulseRate;
        this.breathingRate = breathingRate;
        this.lsbp = lsbp;
        this.ldbp = ldbp;
        this.rsbp = rsbp;
        this.rdbp = rdbp;
        this.height = height;
        this.weight = weight;
        this.waist = waist;
        this.bmi = bmi;
        this.elderSelfcareAbilityId = elderSelfcareAbilityId;
        this.elderHealthAssessCode = elderHealthAssessCode;
        this.elderSelfCareAssessCode = elderSelfCareAssessCode;
        this.elderCognitionResultCode = elderCognitionResultCode;
        this.elderCognitionId = elderCognitionId;
        this.elderBrainScore = elderBrainScore;
        this.elderEmotionalResultCode = elderEmotionalResultCode;
        this.elderDepressedId = elderDepressedId;
        this.elderDepressionScore = elderDepressionScore;
        this.exerciseFreqCode = exerciseFreqCode;
        this.exerciseDurationMins = exerciseDurationMins;
        this.exerciseYear = exerciseYear;
        this.exerciseWay = exerciseWay;
        this.smokingStatusCode = smokingStatusCode;
        this.dailySmoking = dailySmoking;
        this.startSmokingAge = startSmokingAge;
        this.stopSmokingAge = stopSmokingAge;
        this.drinkingFreqCode = drinkingFreqCode;
        this.dailyDrinking = dailyDrinking;
        this.stopDrinkingCode = stopDrinkingCode;
        this.stopDrinkingAge = stopDrinkingAge;
        this.startDrinkingAge = startDrinkingAge;
        this.drunkCode = drunkCode;
        this.occupExposureCode = occupExposureCode;
        this.occupExposureWork = occupExposureWork;
        this.occupExposureWorkYear = occupExposureWorkYear;
        this.poisonDust = poisonDust;
        this.poisonDustProtectCode = poisonDustProtectCode;
        this.poisonDustProtectValue = poisonDustProtectValue;
        this.poisonRadiogen = poisonRadiogen;
        this.poisonRadiogenProtectCode = poisonRadiogenProtectCode;
        this.poisonRadiogenProtectValue = poisonRadiogenProtectValue;
        this.poisonPhysical = poisonPhysical;
        this.poisonPhysicalProtectCode = poisonPhysicalProtectCode;
        this.poisonPhysicalProtectValue = poisonPhysicalProtectValue;
        this.poisonChemical = poisonChemical;
        this.poisonChemicalProtectCode = poisonChemicalProtectCode;
        this.poisonChemicalProtectValue = poisonChemicalProtectValue;
        this.poisonOthers = poisonOthers;
        this.poisonOthersProtectCode = poisonOthersProtectCode;
        this.poisonOthersProtectValue = poisonOthersProtectValue;
        this.lipExamResultCode = lipExamResultCode;
        this.dentitionTypeCode = dentitionTypeCode;
        this.isLosetTeeth = isLosetTeeth;
        this.allLoseTeeth = allLoseTeeth;
        this.loseUlTeethNum = loseUlTeethNum;
        this.loseUrTeethNum = loseUrTeethNum;
        this.loseBlTeethNum = loseBlTeethNum;
        this.loseBrTeethNum = loseBrTeethNum;
        this.isDecayedTooth = isDecayedTooth;
        this.decayedUlToothNum = decayedUlToothNum;
        this.decayedUrToothNum = decayedUrToothNum;
        this.decayedBlToothNum = decayedBlToothNum;
        this.decayedBrToothNum = decayedBrToothNum;
        this.isFalseTeeth = isFalseTeeth;
        this.allFalseTeeth = allFalseTeeth;
        this.falseUlTeethNum = falseUlTeethNum;
        this.falseUrTeethNum = falseUrTeethNum;
        this.falseBlTeethNum = falseBlTeethNum;
        this.falseBrTeethNum = falseBrTeethNum;
        this.pharynxExamResultCode = pharynxExamResultCode;
        this.leftOriginalEyesight = leftOriginalEyesight;
        this.rightOriginalEyesight = rightOriginalEyesight;
        this.leftCorrectEyesight = leftCorrectEyesight;
        this.rightCorrectEyesight = rightCorrectEyesight;
        this.hearingCode = hearingCode;
        this.movementFunctionCode = movementFunctionCode;
        this.eyegroundCode = eyegroundCode;
        this.eyegroundAbnormDesc = eyegroundAbnormDesc;
        this.skinCode = skinCode;
        this.skinOthersDesc = skinOthersDesc;
        this.scleralCode = scleralCode;
        this.scleralOthersDesc = scleralOthersDesc;
        this.lymphCode = lymphCode;
        this.lymphOthersDesc = lymphOthersDesc;
        this.barrelChestCode = barrelChestCode;
        this.lungSoundCode = lungSoundCode;
        this.lungSoundAbnormDesc = lungSoundAbnormDesc;
        this.lungRaleCode = lungRaleCode;
        this.lungRaleOthersDesc = lungRaleOthersDesc;
        this.heartRate = heartRate;
        this.heartRhythmTypeCode = heartRhythmTypeCode;
        this.heartMurmurCode = heartMurmurCode;
        this.heartMurmurDesc = heartMurmurDesc;
        this.abdominalTendCode = abdominalTendCode;
        this.hasAbdominalTendDesc = hasAbdominalTendDesc;
        this.abdominalMassCode = abdominalMassCode;
        this.hasAbdominalMassDesc = hasAbdominalMassDesc;
        this.hepatauxeCode = hepatauxeCode;
        this.hasHepatauxeDesc = hasHepatauxeDesc;
        this.splenomegalyCode = splenomegalyCode;
        this.hasSplenomegalyDesc = hasSplenomegalyDesc;
        this.abdominalDullnessCode = abdominalDullnessCode;
        this.hasAbdominalDullnessDesc = hasAbdominalDullnessDesc;
        this.eoleCode = eoleCode;
        this.pofdaCode = pofdaCode;
        this.dreCode = dreCode;
        this.dreOthersDesc = dreOthersDesc;
        this.vulvaCode = vulvaCode;
        this.vulvaAbnormDesc = vulvaAbnormDesc;
        this.vaginaCode = vaginaCode;
        this.vaginaAbnormDesc = vaginaAbnormDesc;
        this.cervixCode = cervixCode;
        this.cervixAbnormDesc = cervixAbnormDesc;
        this.corpusuteriCode = corpusuteriCode;
        this.corpusuteriAbnormDesc = corpusuteriAbnormDesc;
        this.adnexaCode = adnexaCode;
        this.adnexaAbnormDesc = adnexaAbnormDesc;
        this.otherHealthExamResult = otherHealthExamResult;
        this.hgb = hgb;
        this.wbc = wbc;
        this.plt = plt;
        this.cbcOthers = cbcOthers;
        this.proQualResultCode = proQualResultCode;
        this.proQuanTestValue = proQuanTestValue;
        this.gluQualResultCode = gluQualResultCode;
        this.gluQuanTestValue = gluQuanTestValue;
        this.ketQualResultCode = ketQualResultCode;
        this.ketQualResultValue = ketQualResultValue;
        this.uobTestResultCode = uobTestResultCode;
        this.uobTestResultValue = uobTestResultValue;
        this.urineSg = urineSg;
        this.urinePh = urinePh;
        this.urineMalb = urineMalb;
        this.urineOthers = urineOthers;
        this.fbgMmol = fbgMmol;
        this.fbgMg = fbgMg;
        this.pbgMmol = pbgMmol;
        this.pbgMg = pbgMg;
        this.ecgAbnormCode = ecgAbnormCode;
        this.ecgAbnormDesc = ecgAbnormDesc;
        this.fobCode = fobCode;
        this.ghb = ghb;
        this.hbsagTestResultCode = hbsagTestResultCode;
        this.hbeagTestResultCode = hbeagTestResultCode;
        this.hbsabTestResultCode = hbsabTestResultCode;
        this.hbeabTestResultCode = hbeabTestResultCode;
        this.hbcabTestResultCode = hbcabTestResultCode;
        this.sgpt = sgpt;
        this.ast = ast;
        this.alb = alb;
        this.tbi = tbi;
        this.dbil = dbil;
        this.scr = scr;
        this.bun = bun;
        this.bloodK = bloodK;
        this.bloodNa = bloodNa;
        this.tcho = tcho;
        this.tg = tg;
        this.ldlc = ldlc;
        this.hdlc = hdlc;
        this.cea = cea;
        this.xrayChestCode = xrayChestCode;
        this.xrayChestAbnormDesc = xrayChestAbnormDesc;
        this.bscanAbdomenCode = bscanAbdomenCode;
        this.bscanAbdomenAbnormDesc = bscanAbdomenAbnormDesc;
        this.bscanOthersCode = bscanOthersCode;
        this.bscanOthersAbnormDesc = bscanOthersAbnormDesc;
        this.cpsCode = cpsCode;
        this.cpsAbnormDesc = cpsAbnormDesc;
        this.otherAssistExam = otherAssistExam;
        this.elderTcmHealthId = elderTcmHealthId;
        this.gentleQualityCode = gentleQualityCode;
        this.qiDeficiencyCode = qiDeficiencyCode;
        this.yangDeficiencyCode = yangDeficiencyCode;
        this.yinDeficiencyCode = yinDeficiencyCode;
        this.phlegmWetCode = phlegmWetCode;
        this.dampHeatCode = dampHeatCode;
        this.bloodStasisCode = bloodStasisCode;
        this.qiDepressionCode = qiDepressionCode;
        this.specialDiathsisCode = specialDiathsisCode;
        this.diseNervousCode = diseNervousCode;
        this.diseNervousAbnormDesc = diseNervousAbnormDesc;
        this.diseOthersCode = diseOthersCode;
        this.diseOthersAbnormDesc = diseOthersAbnormDesc;
        this.healthAbnormCode = healthAbnormCode;
        this.healthAbnormDesc1 = healthAbnormDesc1;
        this.healthAbnormDesc2 = healthAbnormDesc2;
        this.healthAbnormDesc3 = healthAbnormDesc3;
        this.healthAbnormDesc4 = healthAbnormDesc4;
        this.isBigExam = isBigExam;
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
        this.isAllExam = isAllExam;
    }

    @Generated(hash = 857472307)
    @Keep
    public HealthExam() {
        recordChoice = new ArrayList<>();

        healthExamInhos = new ArrayList<>();

        healthExamDrug = new ArrayList<>();

        healthExamNoplanVacc = new ArrayList<>();
    }




}