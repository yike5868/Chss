package net.greatsoft.main.db.po;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 
 * @author hn
 * @date 2016年7月11日 下午5:42:36 
 * @Description: 孕产妇专档
 *
 */
@Entity
public class MaternalInfo extends Entry{
    
    /**
     * 孕产妇专项档案ID
     */
    private String maternalInfoId;

    /**
     * 个人档案ID
     */
    private String personInfoId;

    /**
     * 本人姓名
     */
    private String name;
    
    /**
     * 出生日期
     */
    private Date birthday;
    
    /**
     * 丈夫档案ID
     */
    private String husbandPersonInfoId;
    
    /**
     * 丈夫姓名
     */
    private String husbandName;
    
    /**
     * 是否删除
     */
    private Integer isCancel;
    
    /**
     * 丈夫电话号码
     */
    private String husbandTelNo;
    
    /**
     * 丈夫出生日期
     */
    private Date husbandBirthday;
    
    /**
     * 孕产登记次数
     */
    private Integer pregantCount;
   
    /**
     * 孕次
     */
    private Integer gravidity;

    /**
     * 产次
     */
    private Integer parity;
    
	/**
	 * 自然流产次数
	 */
	private Integer spontaneousAbortionCount;

	/**
	 * 人工流产次数
	 */
	private Integer artificialAbortionCount;

    /**
     * 身高(cm)
     */
    private Double height;
    
    /**
     * 体重(kg)
     */
    private Double weight;
    
    /**
     * 体制指数
     */
    private Double bmi;

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
     * 最近一次随访日期
     */
    private Date lastVisitDate;

    /**
     * 最近一次随访类型
     */
	private String lastVisitDoctor;

    /**
     * 最近一次随访医师
     */
	private Integer lastVisitType;
	
    /**
     * 下次随访日期
     */
    private Date nextVisitDate;

    /**
     * 下次随访医生
     */
	private String nextVisitDoctor;

    /**
     * 下次随访类型
     */
	private Integer nextVisitType;

    /**
     * 是否上传  0否  1 是
     */
    private Integer isUpload;

    public Integer getIsUpload() {
        return this.isUpload;
    }

    public void setIsUpload(Integer isUpload) {
        this.isUpload = isUpload;
    }

    public Integer getNextVisitType() {
        return this.nextVisitType;
    }

    public void setNextVisitType(Integer nextVisitType) {
        this.nextVisitType = nextVisitType;
    }

    public String getNextVisitDoctor() {
        return this.nextVisitDoctor;
    }

    public void setNextVisitDoctor(String nextVisitDoctor) {
        this.nextVisitDoctor = nextVisitDoctor;
    }

    public Date getNextVisitDate() {
        return this.nextVisitDate;
    }

    public void setNextVisitDate(Date nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }

    public Integer getLastVisitType() {
        return this.lastVisitType;
    }

    public void setLastVisitType(Integer lastVisitType) {
        this.lastVisitType = lastVisitType;
    }

    public String getLastVisitDoctor() {
        return this.lastVisitDoctor;
    }

    public void setLastVisitDoctor(String lastVisitDoctor) {
        this.lastVisitDoctor = lastVisitDoctor;
    }

    public Date getLastVisitDate() {
        return this.lastVisitDate;
    }

    public void setLastVisitDate(Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
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

    public Integer getArtificialAbortionCount() {
        return this.artificialAbortionCount;
    }

    public void setArtificialAbortionCount(Integer artificialAbortionCount) {
        this.artificialAbortionCount = artificialAbortionCount;
    }

    public Integer getSpontaneousAbortionCount() {
        return this.spontaneousAbortionCount;
    }

    public void setSpontaneousAbortionCount(Integer spontaneousAbortionCount) {
        this.spontaneousAbortionCount = spontaneousAbortionCount;
    }

    public Integer getParity() {
        return this.parity;
    }

    public void setParity(Integer parity) {
        this.parity = parity;
    }

    public Integer getGravidity() {
        return this.gravidity;
    }

    public void setGravidity(Integer gravidity) {
        this.gravidity = gravidity;
    }

    public Integer getPregantCount() {
        return this.pregantCount;
    }

    public void setPregantCount(Integer pregantCount) {
        this.pregantCount = pregantCount;
    }

    public Date getHusbandBirthday() {
        return this.husbandBirthday;
    }

    public void setHusbandBirthday(Date husbandBirthday) {
        this.husbandBirthday = husbandBirthday;
    }

    public String getHusbandTelNo() {
        return this.husbandTelNo;
    }

    public void setHusbandTelNo(String husbandTelNo) {
        this.husbandTelNo = husbandTelNo;
    }

    public Integer getIsCancel() {
        return this.isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public String getHusbandName() {
        return this.husbandName;
    }

    public void setHusbandName(String husbandName) {
        this.husbandName = husbandName;
    }

    public String getHusbandPersonInfoId() {
        return this.husbandPersonInfoId;
    }

    public void setHusbandPersonInfoId(String husbandPersonInfoId) {
        this.husbandPersonInfoId = husbandPersonInfoId;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Generated(hash = 1815441807)
    public MaternalInfo(String maternalInfoId, String personInfoId, String name,
            Date birthday, String husbandPersonInfoId, String husbandName,
            Integer isCancel, String husbandTelNo, Date husbandBirthday,
            Integer pregantCount, Integer gravidity, Integer parity,
            Integer spontaneousAbortionCount, Integer artificialAbortionCount,
            Double height, Double weight, Double bmi, String createOrgId,
            String orgName, String creatorId, String creator, Date createTime,
            String modifiedOrgId, String modifiedOrgName, String modifierId,
            String modifier, Date modifiedTime, Date lastVisitDate,
            String lastVisitDoctor, Integer lastVisitType, Date nextVisitDate,
            String nextVisitDoctor, Integer nextVisitType, Integer isUpload) {
        this.maternalInfoId = maternalInfoId;
        this.personInfoId = personInfoId;
        this.name = name;
        this.birthday = birthday;
        this.husbandPersonInfoId = husbandPersonInfoId;
        this.husbandName = husbandName;
        this.isCancel = isCancel;
        this.husbandTelNo = husbandTelNo;
        this.husbandBirthday = husbandBirthday;
        this.pregantCount = pregantCount;
        this.gravidity = gravidity;
        this.parity = parity;
        this.spontaneousAbortionCount = spontaneousAbortionCount;
        this.artificialAbortionCount = artificialAbortionCount;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
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
        this.lastVisitDate = lastVisitDate;
        this.lastVisitDoctor = lastVisitDoctor;
        this.lastVisitType = lastVisitType;
        this.nextVisitDate = nextVisitDate;
        this.nextVisitDoctor = nextVisitDoctor;
        this.nextVisitType = nextVisitType;
        this.isUpload = isUpload;
    }

    @Generated(hash = 805226261)
    public MaternalInfo() {
    }



}