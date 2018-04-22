package net.greatsoft.main.db.po.old;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author hn
 * @date 2016年7月25日 下午10:49:25 
 * @Description: 老年抑郁量表
 *
 */
@Entity
public class ElderDepressed extends Entry {
    /**
     * 老年抑郁量表ID
     */
    
    private String elderDepressedId;

    /**
     * 个人档案ID
     */
    
    private String personInfoId;

    /**
     * 姓名
     */
    
    private String name;

    /**
     * 性别代码
     */
    
    private String sexCode;

    /**
     * 出生日期
     */
    
    
    private Date birthday;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 职业代码
     */
    
    private String occupationCode;

    /**
     * 文化程度代码
     */
    
    private String educationCode;

    /**
     * 评定时间
     */
    
    
    private Date assessDate;

    /**
     * 总分
     */
    
    private String totalScore;

    /**
     * 生活是否满意
     */
    
    private String isLifesatisfaction;

    /**
     * 是否丧失乐趣
     */
    
    private String isJoy;

    /**
     * 生活是否空虚
     */
    
    private String isVoid;

    /**
     * 是否无聊
     */
    
    private String isBored;

    /**
     * 是否对未来充满希望
     */
    
    private String isHope;

    /**
     * 是否感到烦恼
     */
    
    private String isWorry;

    /**
     * 是否精神抖擞
     */
    
    private String isSpirit;

    /**
     * 是否感到害怕
     */
    
    private String isAfraid;

    /**
     * 是否快乐
     */
    
    private String isHappy;

    /**
     * 是否感到无助
     */
    
    private String isHelpless;

    /**
     * 是否感到坐立不安
     */
    
    private String isUnsafe;

    /**
     * 是否不愿出门
     */
    
    private String isGoout;

    /**
     * 是否担心未来
     */
    
    private String isFuture;

    /**
     * 是否记忆力异常
     */
    
    private String isMemory;

    /**
     * 是否觉得活的精彩
     */
    
    private String isSplendid;

    /**
     * 是否无精打采
     */
    
    private String isLaziness;

    /**
     * 是否觉得自己没用
     */
    
    private String isUseless;

    /**
     * 是否担心过去
     */
    
    private String isFormerly;

    /**
     * 生活是否兴奋
     */
    
    private String isExcite;

    /**
     * 是否学习困难
     */
    
    private String isLearnhard;

    /**
     * 是否精力充沛
     */
    
    private String isEnergyfull;

    /**
     * 是否觉得现状毫无希望
     */
    
    private String isNohope;

    /**
     * 是否觉得生活不好
     */
    
    private String isHappylife;

    /**
     * 是否把事情弄糟糕
     */
    
    private String isThingbad;

    /**
     * 是否经常想哭
     */
    
    private String isCry;

    /**
     * 是否注意力集中困难
     */
    
    private String isMindhard;

    /**
     * 是否喜欢起床感觉
     */
    
    private String isGetup;

    /**
     * 是否喜欢社交活动
     */
    
    private String isExercise;

    /**
     * 做决定是否容易
     */
    
    private String isDecideeasy;

    /**
     * 头脑是否清楚
     */
    
    private String isClearhead;

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

    public String getIsClearhead() {
        return this.isClearhead;
    }

    public void setIsClearhead(String isClearhead) {
        this.isClearhead = isClearhead;
    }

    public String getIsDecideeasy() {
        return this.isDecideeasy;
    }

    public void setIsDecideeasy(String isDecideeasy) {
        this.isDecideeasy = isDecideeasy;
    }

    public String getIsExercise() {
        return this.isExercise;
    }

    public void setIsExercise(String isExercise) {
        this.isExercise = isExercise;
    }

    public String getIsGetup() {
        return this.isGetup;
    }

    public void setIsGetup(String isGetup) {
        this.isGetup = isGetup;
    }

    public String getIsMindhard() {
        return this.isMindhard;
    }

    public void setIsMindhard(String isMindhard) {
        this.isMindhard = isMindhard;
    }

    public String getIsCry() {
        return this.isCry;
    }

    public void setIsCry(String isCry) {
        this.isCry = isCry;
    }

    public String getIsThingbad() {
        return this.isThingbad;
    }

    public void setIsThingbad(String isThingbad) {
        this.isThingbad = isThingbad;
    }

    public String getIsHappylife() {
        return this.isHappylife;
    }

    public void setIsHappylife(String isHappylife) {
        this.isHappylife = isHappylife;
    }

    public String getIsNohope() {
        return this.isNohope;
    }

    public void setIsNohope(String isNohope) {
        this.isNohope = isNohope;
    }

    public String getIsEnergyfull() {
        return this.isEnergyfull;
    }

    public void setIsEnergyfull(String isEnergyfull) {
        this.isEnergyfull = isEnergyfull;
    }

    public String getIsLearnhard() {
        return this.isLearnhard;
    }

    public void setIsLearnhard(String isLearnhard) {
        this.isLearnhard = isLearnhard;
    }

    public String getIsExcite() {
        return this.isExcite;
    }

    public void setIsExcite(String isExcite) {
        this.isExcite = isExcite;
    }

    public String getIsFormerly() {
        return this.isFormerly;
    }

    public void setIsFormerly(String isFormerly) {
        this.isFormerly = isFormerly;
    }

    public String getIsUseless() {
        return this.isUseless;
    }

    public void setIsUseless(String isUseless) {
        this.isUseless = isUseless;
    }

    public String getIsLaziness() {
        return this.isLaziness;
    }

    public void setIsLaziness(String isLaziness) {
        this.isLaziness = isLaziness;
    }

    public String getIsSplendid() {
        return this.isSplendid;
    }

    public void setIsSplendid(String isSplendid) {
        this.isSplendid = isSplendid;
    }

    public String getIsMemory() {
        return this.isMemory;
    }

    public void setIsMemory(String isMemory) {
        this.isMemory = isMemory;
    }

    public String getIsFuture() {
        return this.isFuture;
    }

    public void setIsFuture(String isFuture) {
        this.isFuture = isFuture;
    }

    public String getIsGoout() {
        return this.isGoout;
    }

    public void setIsGoout(String isGoout) {
        this.isGoout = isGoout;
    }

    public String getIsUnsafe() {
        return this.isUnsafe;
    }

    public void setIsUnsafe(String isUnsafe) {
        this.isUnsafe = isUnsafe;
    }

    public String getIsHelpless() {
        return this.isHelpless;
    }

    public void setIsHelpless(String isHelpless) {
        this.isHelpless = isHelpless;
    }

    public String getIsHappy() {
        return this.isHappy;
    }

    public void setIsHappy(String isHappy) {
        this.isHappy = isHappy;
    }

    public String getIsAfraid() {
        return this.isAfraid;
    }

    public void setIsAfraid(String isAfraid) {
        this.isAfraid = isAfraid;
    }

    public String getIsSpirit() {
        return this.isSpirit;
    }

    public void setIsSpirit(String isSpirit) {
        this.isSpirit = isSpirit;
    }

    public String getIsWorry() {
        return this.isWorry;
    }

    public void setIsWorry(String isWorry) {
        this.isWorry = isWorry;
    }

    public String getIsHope() {
        return this.isHope;
    }

    public void setIsHope(String isHope) {
        this.isHope = isHope;
    }

    public String getIsBored() {
        return this.isBored;
    }

    public void setIsBored(String isBored) {
        this.isBored = isBored;
    }

    public String getIsVoid() {
        return this.isVoid;
    }

    public void setIsVoid(String isVoid) {
        this.isVoid = isVoid;
    }

    public String getIsJoy() {
        return this.isJoy;
    }

    public void setIsJoy(String isJoy) {
        this.isJoy = isJoy;
    }

    public String getIsLifesatisfaction() {
        return this.isLifesatisfaction;
    }

    public void setIsLifesatisfaction(String isLifesatisfaction) {
        this.isLifesatisfaction = isLifesatisfaction;
    }

    public String getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public Date getAssessDate() {
        return this.assessDate;
    }

    public void setAssessDate(Date assessDate) {
        this.assessDate = assessDate;
    }

    public String getEducationCode() {
        return this.educationCode;
    }

    public void setEducationCode(String educationCode) {
        this.educationCode = educationCode;
    }

    public String getOccupationCode() {
        return this.occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSexCode() {
        return this.sexCode;
    }

    public void setSexCode(String sexCode) {
        this.sexCode = sexCode;
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

    public String getElderDepressedId() {
        return this.elderDepressedId;
    }

    public void setElderDepressedId(String elderDepressedId) {
        this.elderDepressedId = elderDepressedId;
    }

    @Generated(hash = 781208302)
    public ElderDepressed(String elderDepressedId, String personInfoId,
            String name, String sexCode, Date birthday, Integer age,
            String occupationCode, String educationCode, Date assessDate,
            String totalScore, String isLifesatisfaction, String isJoy,
            String isVoid, String isBored, String isHope, String isWorry,
            String isSpirit, String isAfraid, String isHappy, String isHelpless,
            String isUnsafe, String isGoout, String isFuture, String isMemory,
            String isSplendid, String isLaziness, String isUseless,
            String isFormerly, String isExcite, String isLearnhard,
            String isEnergyfull, String isNohope, String isHappylife,
            String isThingbad, String isCry, String isMindhard, String isGetup,
            String isExercise, String isDecideeasy, String isClearhead,
            Integer isCancel, String createOrgId, String orgName, String creatorId,
            String creator, Date createTime, String modifiedOrgId,
            String modifiedOrgName, String modifierId, String modifier,
            Date modifiedTime) {
        this.elderDepressedId = elderDepressedId;
        this.personInfoId = personInfoId;
        this.name = name;
        this.sexCode = sexCode;
        this.birthday = birthday;
        this.age = age;
        this.occupationCode = occupationCode;
        this.educationCode = educationCode;
        this.assessDate = assessDate;
        this.totalScore = totalScore;
        this.isLifesatisfaction = isLifesatisfaction;
        this.isJoy = isJoy;
        this.isVoid = isVoid;
        this.isBored = isBored;
        this.isHope = isHope;
        this.isWorry = isWorry;
        this.isSpirit = isSpirit;
        this.isAfraid = isAfraid;
        this.isHappy = isHappy;
        this.isHelpless = isHelpless;
        this.isUnsafe = isUnsafe;
        this.isGoout = isGoout;
        this.isFuture = isFuture;
        this.isMemory = isMemory;
        this.isSplendid = isSplendid;
        this.isLaziness = isLaziness;
        this.isUseless = isUseless;
        this.isFormerly = isFormerly;
        this.isExcite = isExcite;
        this.isLearnhard = isLearnhard;
        this.isEnergyfull = isEnergyfull;
        this.isNohope = isNohope;
        this.isHappylife = isHappylife;
        this.isThingbad = isThingbad;
        this.isCry = isCry;
        this.isMindhard = isMindhard;
        this.isGetup = isGetup;
        this.isExercise = isExercise;
        this.isDecideeasy = isDecideeasy;
        this.isClearhead = isClearhead;
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

    @Generated(hash = 565694525)
    public ElderDepressed() {
    }


}