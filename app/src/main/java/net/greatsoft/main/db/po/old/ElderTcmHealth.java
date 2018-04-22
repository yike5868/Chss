package net.greatsoft.main.db.po.old;

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
 * @date 2016年7月25日 下午10:52:05 
 * @Description: 老年人中医药健康表
 *
 */
@Entity
public class ElderTcmHealth extends Entry {
    /**
     * 老年人中医药健康表ID
     */
    
    private String elderTcmHealthId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;

    /**
     * 编号
     */
    
    private String elderTcmHealthNo;

    /**
     * 姓名
     */
    
    private String name;

    /**
     * (1)您精力充沛吗？（指精神头足，乐于做事）
     */
    
    private String energy;

    /**
     * 2)您容易疲乏吗？（指体力如何，是否稍微活动一下或做一点家务劳动就感到累）
     */
    
    private String fatigue;

    /**
     * (3)您容易气短，呼吸短促，接不上气吗？
     */
    
    private String breathe;

    /**
     * (4)您说话声音低弱无力吗?（指说话没有力气）
     */
    
    private String speak;

    /**
     * (5)您感到闷闷不乐、情绪低沉吗?（指心情不愉快，情绪低落）
     */
    
    private String unpleasant;
    
    /**
     * (6)您容易精神紧张、焦虑不安吗?（指遇事是否心情紧张）
     */
    
    private String nervous;

    /**
     * (7)您因为生活状态改变而感到孤独、失落吗？
     */
    
    private String solitary;

    /**
     * (8)您容易感到害怕或受到惊吓吗?
     */
    
    private String scare;

    /**
     * (9)您感到身体超重不轻松吗?(感觉身体沉重) [BMI指数=体重（kg）/身高2（m）]
     */
    
    private String weight;

    /**
     * (10)您眼睛干涩吗?
     */
    
    private String eye;

    /**
     * (11)您手脚发凉吗?（不包含因周围温度低或穿的少导致的手脚发冷）
     */
    
    private String hand;

    /**
     * (12)您胃脘部、背部或腰膝部怕冷吗？（指上腹部、背部、腰部或膝关节等，有一处或多处怕冷）
     */
    
    private String craw;

    /**
     * (13)您比一般人耐受不了寒冷吗？（指比别人容易害怕冬天或是夏天的冷空调、电扇等）
     */
    
    private String cold;

    /**
     * (14)您容易患感冒吗?（指每年感冒的次数）
     */
    
    private String catchacold;

    /**
     * (15)您没有感冒时也会鼻塞、流鼻涕吗?
     */
    
    private String runathenose;

    /**
     * (16)您有口粘口腻，或睡眠打鼾吗？
     */
    
    private String mouth;

    /**
     * (17)您容易过敏(对药物、食物、气味、花粉或在季节交替、气候变化时)吗?
     */
    
    private String food;

    /**
     * (18)您的皮肤容易起荨麻疹吗? (包括风团、风疹块、风疙瘩)
     */
    
    private String derma;

    /**
     * (19)您的皮肤在不知不觉中会出现青紫瘀斑、皮下出血吗?（指皮肤在没有外伤的情况下出现青一块紫一块的情况）
     */
    
    private String bleeding;

    /**
     * (20)您的皮肤一抓就红，并出现抓痕吗?（指被指甲或钝物划过后皮肤的反应）
     */
    
    private String fingermail;

    /**
     * (21)您皮肤或口唇干吗?
     */
    
    private String oraldry;

    /**
     * (22)您有肢体麻木或固定部位疼痛的感觉吗？
     */
    
    private String ache;

    /**
     * (23)您面部或鼻部有油腻感或者油亮发光吗?（指脸上或鼻子）
     */
    
    private String face;

    /**
     * (24)您面色或目眶晦黯，或出现褐色斑块/斑点吗?
     */
    
    private String spot;

    /**
     * (25)您有皮肤湿疹、疮疖吗？
     */
    
    private String sore;

    /**
     * (26)您感到口干咽燥、总想喝水吗？
     */
    
    private String drinking;

    /**
     * (27)您感到口苦或嘴里有异味吗?（指口苦或口臭）
     */
    
    private String bittertaste;

    /**
     * (28)您腹部肥大吗?（指腹部脂肪肥厚）
     */
    
    private String abdomen;

    /**
     * (29)您吃(喝)凉的东西会感到不舒服或者怕吃(喝)凉的东西吗？（指不喜欢吃凉的食物，或吃了凉的食物后会不舒服）
     */
    
    private String uncomfortable;

    /**
     * (30)您有大便黏滞不爽、解不尽的感觉吗?(大便容易粘在马桶或便坑壁上)
     */
    
    private String unwell;

    /**
     * (31)您容易大便干燥吗?
     */
    
    private String malaise;

    /**
     * (32)您舌苔厚腻或有舌苔厚厚的感觉吗?（如果自我感觉不清楚可由调查员观察后填写）
     */
    
    private String tongue;

    /**
     * (33)您舌下静脉瘀紫或增粗吗？（可由调查员辅助观察后填写）
     */
    
    private String vein;

    /**
     * 气虚质得分
     */
    private Integer qiDeficiencyScore;

    /**
     * 气虚质代码
     */
    
    private String qiDeficiencyCode;

    /**
     * 阳虚质得分
     */
    private Integer yangDeficiencyScore;

    /**
     * 阳虚质代码
     */
    
    private String yangDeficiencyCode;

    /**
     * 阴虚质得分
     */
    private Integer yinDeficiencyScore;

    /**
     * 阴虚质代码
     */
    
    private String yinDeficiencyCode;

    /**
     * 痰湿质得分
     */
    private Integer phlegmWetScore;

    /**
     * 痰湿质代码
     */
    
    private String phlegmWetCode;

    /**
     * 湿热质得分
     */
    private Integer dampHeatScore;

    /**
     * 湿热质代码
     */
    
    private String dampHeatCode;

    /**
     * 血瘀质得分
     */
    private Integer bloodStasisScore;

    /**
     * 血瘀质代码
     */
    
    private String bloodStasisCode;

    /**
     * 气郁质得分
     */
    private Integer qiDepressionScore;

    /**
     * 气郁质代码
     */
    
    private String qiDepressionCode;

    /**
     * 特禀质得分
     */
    private Integer specialDiathsisScore;

    /**
     * 特禀质代码
     */
    
    private String specialDiathsisCode;

    /**
     * 平和质得分
     */
    private Integer gentleQualityScore;

    /**
     * 平和质代码
     */
    
    private String gentleQualityCode;

    /**
     * 签名医生id
     */
    
    private String doctorId;
    
    /**
     * 签名医生姓名
     */
    
    private String doctorName;

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

	private String jsonDetail;
	
	@Transient
	private List<RecordChoice> recordChoice;

    public List<RecordChoice> getRecordChoice() {
        return recordChoice;
    }

    public void setRecordChoice(List<RecordChoice> recordChoice) {
        this.recordChoice = recordChoice;
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

    public Date getFillDate() {
        return this.fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    public String getDoctorName() {
        return this.doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorId() {
        return this.doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getGentleQualityCode() {
        return this.gentleQualityCode;
    }

    public void setGentleQualityCode(String gentleQualityCode) {
        this.gentleQualityCode = gentleQualityCode;
    }

    public Integer getGentleQualityScore() {
        return this.gentleQualityScore;
    }

    public void setGentleQualityScore(Integer gentleQualityScore) {
        this.gentleQualityScore = gentleQualityScore;
    }

    public String getSpecialDiathsisCode() {
        return this.specialDiathsisCode;
    }

    public void setSpecialDiathsisCode(String specialDiathsisCode) {
        this.specialDiathsisCode = specialDiathsisCode;
    }

    public Integer getSpecialDiathsisScore() {
        return this.specialDiathsisScore;
    }

    public void setSpecialDiathsisScore(Integer specialDiathsisScore) {
        this.specialDiathsisScore = specialDiathsisScore;
    }

    public String getQiDepressionCode() {
        return this.qiDepressionCode;
    }

    public void setQiDepressionCode(String qiDepressionCode) {
        this.qiDepressionCode = qiDepressionCode;
    }

    public Integer getQiDepressionScore() {
        return this.qiDepressionScore;
    }

    public void setQiDepressionScore(Integer qiDepressionScore) {
        this.qiDepressionScore = qiDepressionScore;
    }

    public String getBloodStasisCode() {
        return this.bloodStasisCode;
    }

    public void setBloodStasisCode(String bloodStasisCode) {
        this.bloodStasisCode = bloodStasisCode;
    }

    public Integer getBloodStasisScore() {
        return this.bloodStasisScore;
    }

    public void setBloodStasisScore(Integer bloodStasisScore) {
        this.bloodStasisScore = bloodStasisScore;
    }

    public String getDampHeatCode() {
        return this.dampHeatCode;
    }

    public void setDampHeatCode(String dampHeatCode) {
        this.dampHeatCode = dampHeatCode;
    }

    public Integer getDampHeatScore() {
        return this.dampHeatScore;
    }

    public void setDampHeatScore(Integer dampHeatScore) {
        this.dampHeatScore = dampHeatScore;
    }

    public String getPhlegmWetCode() {
        return this.phlegmWetCode;
    }

    public void setPhlegmWetCode(String phlegmWetCode) {
        this.phlegmWetCode = phlegmWetCode;
    }

    public Integer getPhlegmWetScore() {
        return this.phlegmWetScore;
    }

    public void setPhlegmWetScore(Integer phlegmWetScore) {
        this.phlegmWetScore = phlegmWetScore;
    }

    public String getYinDeficiencyCode() {
        return this.yinDeficiencyCode;
    }

    public void setYinDeficiencyCode(String yinDeficiencyCode) {
        this.yinDeficiencyCode = yinDeficiencyCode;
    }

    public Integer getYinDeficiencyScore() {
        return this.yinDeficiencyScore;
    }

    public void setYinDeficiencyScore(Integer yinDeficiencyScore) {
        this.yinDeficiencyScore = yinDeficiencyScore;
    }

    public String getYangDeficiencyCode() {
        return this.yangDeficiencyCode;
    }

    public void setYangDeficiencyCode(String yangDeficiencyCode) {
        this.yangDeficiencyCode = yangDeficiencyCode;
    }

    public Integer getYangDeficiencyScore() {
        return this.yangDeficiencyScore;
    }

    public void setYangDeficiencyScore(Integer yangDeficiencyScore) {
        this.yangDeficiencyScore = yangDeficiencyScore;
    }

    public String getQiDeficiencyCode() {
        return this.qiDeficiencyCode;
    }

    public void setQiDeficiencyCode(String qiDeficiencyCode) {
        this.qiDeficiencyCode = qiDeficiencyCode;
    }

    public Integer getQiDeficiencyScore() {
        return this.qiDeficiencyScore;
    }

    public void setQiDeficiencyScore(Integer qiDeficiencyScore) {
        this.qiDeficiencyScore = qiDeficiencyScore;
    }

    public String getVein() {
        return this.vein;
    }

    public void setVein(String vein) {
        this.vein = vein;
    }

    public String getTongue() {
        return this.tongue;
    }

    public void setTongue(String tongue) {
        this.tongue = tongue;
    }

    public String getMalaise() {
        return this.malaise;
    }

    public void setMalaise(String malaise) {
        this.malaise = malaise;
    }

    public String getUnwell() {
        return this.unwell;
    }

    public void setUnwell(String unwell) {
        this.unwell = unwell;
    }

    public String getUncomfortable() {
        return this.uncomfortable;
    }

    public void setUncomfortable(String uncomfortable) {
        this.uncomfortable = uncomfortable;
    }

    public String getAbdomen() {
        return this.abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public String getBittertaste() {
        return this.bittertaste;
    }

    public void setBittertaste(String bittertaste) {
        this.bittertaste = bittertaste;
    }

    public String getDrinking() {
        return this.drinking;
    }

    public void setDrinking(String drinking) {
        this.drinking = drinking;
    }

    public String getSore() {
        return this.sore;
    }

    public void setSore(String sore) {
        this.sore = sore;
    }

    public String getSpot() {
        return this.spot;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }

    public String getFace() {
        return this.face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getAche() {
        return this.ache;
    }

    public void setAche(String ache) {
        this.ache = ache;
    }

    public String getOraldry() {
        return this.oraldry;
    }

    public void setOraldry(String oraldry) {
        this.oraldry = oraldry;
    }

    public String getFingermail() {
        return this.fingermail;
    }

    public void setFingermail(String fingermail) {
        this.fingermail = fingermail;
    }

    public String getBleeding() {
        return this.bleeding;
    }

    public void setBleeding(String bleeding) {
        this.bleeding = bleeding;
    }

    public String getDerma() {
        return this.derma;
    }

    public void setDerma(String derma) {
        this.derma = derma;
    }

    public String getFood() {
        return this.food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getMouth() {
        return this.mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    public String getRunathenose() {
        return this.runathenose;
    }

    public void setRunathenose(String runathenose) {
        this.runathenose = runathenose;
    }

    public String getCatchacold() {
        return this.catchacold;
    }

    public void setCatchacold(String catchacold) {
        this.catchacold = catchacold;
    }

    public String getCold() {
        return this.cold;
    }

    public void setCold(String cold) {
        this.cold = cold;
    }

    public String getCraw() {
        return this.craw;
    }

    public void setCraw(String craw) {
        this.craw = craw;
    }

    public String getHand() {
        return this.hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getEye() {
        return this.eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getScare() {
        return this.scare;
    }

    public void setScare(String scare) {
        this.scare = scare;
    }

    public String getSolitary() {
        return this.solitary;
    }

    public void setSolitary(String solitary) {
        this.solitary = solitary;
    }

    public String getNervous() {
        return this.nervous;
    }

    public void setNervous(String nervous) {
        this.nervous = nervous;
    }

    public String getUnpleasant() {
        return this.unpleasant;
    }

    public void setUnpleasant(String unpleasant) {
        this.unpleasant = unpleasant;
    }

    public String getSpeak() {
        return this.speak;
    }

    public void setSpeak(String speak) {
        this.speak = speak;
    }

    public String getBreathe() {
        return this.breathe;
    }

    public void setBreathe(String breathe) {
        this.breathe = breathe;
    }

    public String getFatigue() {
        return this.fatigue;
    }

    public void setFatigue(String fatigue) {
        this.fatigue = fatigue;
    }

    public String getEnergy() {
        return this.energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElderTcmHealthNo() {
        return this.elderTcmHealthNo;
    }

    public void setElderTcmHealthNo(String elderTcmHealthNo) {
        this.elderTcmHealthNo = elderTcmHealthNo;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getElderTcmHealthId() {
        return this.elderTcmHealthId;
    }

    public void setElderTcmHealthId(String elderTcmHealthId) {
        this.elderTcmHealthId = elderTcmHealthId;
    }

    @Generated(hash = 351321668)
    public ElderTcmHealth(String elderTcmHealthId, String personInfoId,
            String elderTcmHealthNo, String name, String energy, String fatigue,
            String breathe, String speak, String unpleasant, String nervous,
            String solitary, String scare, String weight, String eye, String hand,
            String craw, String cold, String catchacold, String runathenose,
            String mouth, String food, String derma, String bleeding,
            String fingermail, String oraldry, String ache, String face,
            String spot, String sore, String drinking, String bittertaste,
            String abdomen, String uncomfortable, String unwell, String malaise,
            String tongue, String vein, Integer qiDeficiencyScore,
            String qiDeficiencyCode, Integer yangDeficiencyScore,
            String yangDeficiencyCode, Integer yinDeficiencyScore,
            String yinDeficiencyCode, Integer phlegmWetScore, String phlegmWetCode,
            Integer dampHeatScore, String dampHeatCode, Integer bloodStasisScore,
            String bloodStasisCode, Integer qiDepressionScore,
            String qiDepressionCode, Integer specialDiathsisScore,
            String specialDiathsisCode, Integer gentleQualityScore,
            String gentleQualityCode, String doctorId, String doctorName,
            Date fillDate, Integer isCancel, String createOrgId, String orgName,
            String creatorId, String creator, Date createTime,
            String modifiedOrgId, String modifiedOrgName, String modifierId,
            String modifier, Date modifiedTime, String jsonDetail) {
        this.elderTcmHealthId = elderTcmHealthId;
        this.personInfoId = personInfoId;
        this.elderTcmHealthNo = elderTcmHealthNo;
        this.name = name;
        this.energy = energy;
        this.fatigue = fatigue;
        this.breathe = breathe;
        this.speak = speak;
        this.unpleasant = unpleasant;
        this.nervous = nervous;
        this.solitary = solitary;
        this.scare = scare;
        this.weight = weight;
        this.eye = eye;
        this.hand = hand;
        this.craw = craw;
        this.cold = cold;
        this.catchacold = catchacold;
        this.runathenose = runathenose;
        this.mouth = mouth;
        this.food = food;
        this.derma = derma;
        this.bleeding = bleeding;
        this.fingermail = fingermail;
        this.oraldry = oraldry;
        this.ache = ache;
        this.face = face;
        this.spot = spot;
        this.sore = sore;
        this.drinking = drinking;
        this.bittertaste = bittertaste;
        this.abdomen = abdomen;
        this.uncomfortable = uncomfortable;
        this.unwell = unwell;
        this.malaise = malaise;
        this.tongue = tongue;
        this.vein = vein;
        this.qiDeficiencyScore = qiDeficiencyScore;
        this.qiDeficiencyCode = qiDeficiencyCode;
        this.yangDeficiencyScore = yangDeficiencyScore;
        this.yangDeficiencyCode = yangDeficiencyCode;
        this.yinDeficiencyScore = yinDeficiencyScore;
        this.yinDeficiencyCode = yinDeficiencyCode;
        this.phlegmWetScore = phlegmWetScore;
        this.phlegmWetCode = phlegmWetCode;
        this.dampHeatScore = dampHeatScore;
        this.dampHeatCode = dampHeatCode;
        this.bloodStasisScore = bloodStasisScore;
        this.bloodStasisCode = bloodStasisCode;
        this.qiDepressionScore = qiDepressionScore;
        this.qiDepressionCode = qiDepressionCode;
        this.specialDiathsisScore = specialDiathsisScore;
        this.specialDiathsisCode = specialDiathsisCode;
        this.gentleQualityScore = gentleQualityScore;
        this.gentleQualityCode = gentleQualityCode;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
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
        this.jsonDetail = jsonDetail;
    }

    @Generated(hash = 759337445)@Keep
    public ElderTcmHealth() {
        recordChoice = new ArrayList<>();
    }


}