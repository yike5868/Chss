package net.greatsoft.main.db.po.maternal;

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
 * @date 2016年7月14日 上午12:11:27 
 * @Description: 分娩登记数据模型
 *
 */
@Entity
public class MaternalChildbirth  extends Entry {
    /**
     * 分娩登记ID
     */
    
    private String maternalChildbirthId;

    /**
     * 孕产妇基本信息ID
     */
    
    private String maternalInfoId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;
    
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
     * 随访类型
     */
    
    private String visitType;

    /**
     * 分娩地点
     */
    
    private String laborPlaceCode;
    
    /**
     * 分娩地点中文
     */
    
    private String laborPlaceValue;

    /**
     * 分娩方式
     */
    
    private String laborWay;

    /**
     * 分娩时间
     */
    
    
    private Date laborTime;

    /**
     * 孕周（周)
     */
    private Integer gestWeeks;

    /**
     * 孕周（天)
     */
    private Integer gestDays;

    /**
     * 产程时间1
     */
    
    private Double birthTime1;

    /**
     * 产程时间2
     */
    
    private Double birthTime2;

    /**
     * 产程时间3
     */
    
    private Double birthTime3;

    /**
     * 总产程
     */
    
    private Double birthTotal;

    /**
     * 会阴情况
     */
    
    private String perineumSituation;

    /**
     * 产妇情况中文
     */
    
    private String parturientSituationCn;

    /**
     * 多胎胎数
     */
    
    private String babyFetusCounts;
    
    /**
     * 多胎胎数
     */
    private Integer babyFetusCountsCn;

    /**
     * HIV咨询
     */
    
    private String hivConsultative;

    /**
     * HIV检测
     */
    
    private String hivExamination;

    /**
     * 梅毒检测
     */
    
    private String syphilisExamination;

    /**
     * 下次随访类型
     */
    
    private String nextVisitType;

    /**
     * 下次随访时间
     */
    
    
    private Date nextVisitDate;
    
    /**
     * 上次随访时间
     */
    
    
    private Date previousVisitDate;
    
    /**
     * 上次随访类型
     */
    
    private String previousVisitTypeCode;
    
    /**
     * 上次随访医师
     */
    
    private String previousVisitPerson;

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
	 * 分娩登记-新生儿记录情况
	 */
    @Transient
	private List<MaternalNewbornSituation> maternalNewbornSituation;

	/**
	 * 选项指标记录，用来前后交互传输数据使用的
	 */
	@Transient
	private List<RecordChoice> recordChoice;

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

    public String getPreviousVisitPerson() {
        return this.previousVisitPerson;
    }

    public void setPreviousVisitPerson(String previousVisitPerson) {
        this.previousVisitPerson = previousVisitPerson;
    }

    public String getPreviousVisitTypeCode() {
        return this.previousVisitTypeCode;
    }

    public void setPreviousVisitTypeCode(String previousVisitTypeCode) {
        this.previousVisitTypeCode = previousVisitTypeCode;
    }

    public Date getPreviousVisitDate() {
        return this.previousVisitDate;
    }

    public void setPreviousVisitDate(Date previousVisitDate) {
        this.previousVisitDate = previousVisitDate;
    }

    public Date getNextVisitDate() {
        return this.nextVisitDate;
    }

    public void setNextVisitDate(Date nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }

    public String getNextVisitType() {
        return this.nextVisitType;
    }

    public void setNextVisitType(String nextVisitType) {
        this.nextVisitType = nextVisitType;
    }

    public String getSyphilisExamination() {
        return this.syphilisExamination;
    }

    public void setSyphilisExamination(String syphilisExamination) {
        this.syphilisExamination = syphilisExamination;
    }

    public String getHivExamination() {
        return this.hivExamination;
    }

    public void setHivExamination(String hivExamination) {
        this.hivExamination = hivExamination;
    }

    public String getHivConsultative() {
        return this.hivConsultative;
    }

    public void setHivConsultative(String hivConsultative) {
        this.hivConsultative = hivConsultative;
    }

    public Integer getBabyFetusCountsCn() {
        return this.babyFetusCountsCn;
    }

    public void setBabyFetusCountsCn(Integer babyFetusCountsCn) {
        this.babyFetusCountsCn = babyFetusCountsCn;
    }

    public String getBabyFetusCounts() {
        return this.babyFetusCounts;
    }

    public void setBabyFetusCounts(String babyFetusCounts) {
        this.babyFetusCounts = babyFetusCounts;
    }

    public String getParturientSituationCn() {
        return this.parturientSituationCn;
    }

    public void setParturientSituationCn(String parturientSituationCn) {
        this.parturientSituationCn = parturientSituationCn;
    }

    public String getPerineumSituation() {
        return this.perineumSituation;
    }

    public void setPerineumSituation(String perineumSituation) {
        this.perineumSituation = perineumSituation;
    }

    public Double getBirthTotal() {
        return this.birthTotal;
    }

    public void setBirthTotal(Double birthTotal) {
        this.birthTotal = birthTotal;
    }

    public Double getBirthTime3() {
        return this.birthTime3;
    }

    public void setBirthTime3(Double birthTime3) {
        this.birthTime3 = birthTime3;
    }

    public Double getBirthTime2() {
        return this.birthTime2;
    }

    public void setBirthTime2(Double birthTime2) {
        this.birthTime2 = birthTime2;
    }

    public Double getBirthTime1() {
        return this.birthTime1;
    }

    public void setBirthTime1(Double birthTime1) {
        this.birthTime1 = birthTime1;
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

    public Date getLaborTime() {
        return this.laborTime;
    }

    public void setLaborTime(Date laborTime) {
        this.laborTime = laborTime;
    }

    public String getLaborWay() {
        return this.laborWay;
    }

    public void setLaborWay(String laborWay) {
        this.laborWay = laborWay;
    }

    public String getLaborPlaceValue() {
        return this.laborPlaceValue;
    }

    public void setLaborPlaceValue(String laborPlaceValue) {
        this.laborPlaceValue = laborPlaceValue;
    }

    public String getLaborPlaceCode() {
        return this.laborPlaceCode;
    }

    public void setLaborPlaceCode(String laborPlaceCode) {
        this.laborPlaceCode = laborPlaceCode;
    }

    public String getVisitType() {
        return this.visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
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

    public String getMaternalChildbirthId() {
        return this.maternalChildbirthId;
    }

    public void setMaternalChildbirthId(String maternalChildbirthId) {
        this.maternalChildbirthId = maternalChildbirthId;
    }

    @Generated(hash = 266801395)
    public MaternalChildbirth(String maternalChildbirthId, String maternalInfoId,
            String personInfoId, String maternalRegisterId, Integer pregnantCount,
            String name, String visitType, String laborPlaceCode,
            String laborPlaceValue, String laborWay, Date laborTime,
            Integer gestWeeks, Integer gestDays, Double birthTime1,
            Double birthTime2, Double birthTime3, Double birthTotal,
            String perineumSituation, String parturientSituationCn,
            String babyFetusCounts, Integer babyFetusCountsCn,
            String hivConsultative, String hivExamination,
            String syphilisExamination, String nextVisitType, Date nextVisitDate,
            Date previousVisitDate, String previousVisitTypeCode,
            String previousVisitPerson, Integer isCancel, String createOrgId,
            String orgName, String creatorId, String creator, Date createTime,
            String modifiedOrgId, String modifiedOrgName, String modifierId,
            String modifier, Date modifiedTime) {
        this.maternalChildbirthId = maternalChildbirthId;
        this.maternalInfoId = maternalInfoId;
        this.personInfoId = personInfoId;
        this.maternalRegisterId = maternalRegisterId;
        this.pregnantCount = pregnantCount;
        this.name = name;
        this.visitType = visitType;
        this.laborPlaceCode = laborPlaceCode;
        this.laborPlaceValue = laborPlaceValue;
        this.laborWay = laborWay;
        this.laborTime = laborTime;
        this.gestWeeks = gestWeeks;
        this.gestDays = gestDays;
        this.birthTime1 = birthTime1;
        this.birthTime2 = birthTime2;
        this.birthTime3 = birthTime3;
        this.birthTotal = birthTotal;
        this.perineumSituation = perineumSituation;
        this.parturientSituationCn = parturientSituationCn;
        this.babyFetusCounts = babyFetusCounts;
        this.babyFetusCountsCn = babyFetusCountsCn;
        this.hivConsultative = hivConsultative;
        this.hivExamination = hivExamination;
        this.syphilisExamination = syphilisExamination;
        this.nextVisitType = nextVisitType;
        this.nextVisitDate = nextVisitDate;
        this.previousVisitDate = previousVisitDate;
        this.previousVisitTypeCode = previousVisitTypeCode;
        this.previousVisitPerson = previousVisitPerson;
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

    @Generated(hash = 2003696826)@Keep
    public MaternalChildbirth() {
        recordChoice = new ArrayList<>();
    }

}