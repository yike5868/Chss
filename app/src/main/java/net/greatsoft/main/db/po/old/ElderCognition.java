package net.greatsoft.main.db.po.old;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author hn
 * @date 2016年7月25日 下午10:48:56 
 * @Description: 老年人认知功能量表
 *
 */
@Entity
public class ElderCognition  extends Entry {
    /**
     * 老年人认知功能量表ID
     */
    private String elderCognitionId;

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
     * 年龄
     */
    private Integer age;

    /**
     * 文化程度代码
     */
    private String educationCode;

    /**
     * 评定时间
     */
    private Date assessDate;

    /**
     * 既往病史
     */
    private String diseaseHistory;

    /**
     * 总分
     */
    private String totalScore;

    /**
     * 定向力记录1
     */
    private String directiveRecord1;

    /**
     * 定向力评分1
     */
    private String directiveScore1;

    /**
     * 定向力记录2
     */
    private String directiveRecord2;

    /**
     * 定向力评分2
     */
    private String directiveScore2;

    /**
     * 定向力记录3
     */
    private String directiveRecord3;

    /**
     * 定向力评分3
     */
    private String directiveScore3;

    /**
     * 定向力记录4
     */
    private String directiveRecord4;

    /**
     * 定向力评分4
     */
    private String directiveScore4;

    /**
     * 定向力记录5
     */
    private String directiveRecord5;

    /**
     * 定向力评分5
     */
    private String directiveScore5;

    /**
     * 定向力记录6
     */
    private String directiveRecord6;

    /**
     * 定向力评分6
     */
    private String directiveScore6;

    /**
     * 定向力记录7
     */
    private String directiveRecord7;

    /**
     * 定向力评分7
     */
    private String directiveScore7;

    /**
     * 定向力记录8
     */
    private String directiveRecord8;

    /**
     * 定向力评分8
     */
    private String directiveScore8;

    /**
     * 定向力记录9
     */
    private String directiveRecord9;

    /**
     * 定向力评分9
     */
    private String directiveScore9;

    /**
     * 定向力记录10
     */
    private String directiveRecord10;

    /**
     * 定向力评分10
     */
    private String directiveScore10;

    /**
     * 记忆力记录1
     */
    private String memoryRecord1;

    /**
     * 记忆力评分1
     */
    private String memoryScore1;

    /**
     * 记忆力记录2
     */
    private String memoryRecord2;

    /**
     * 记忆力评分2
     */
    private String memoryScore2;

    /**
     * 记忆力记录3
     */
    private String memoryRecord3;

    /**
     * 记忆力评分3
     */
    private String memoryScore3;

    /**
     * 注意力和计算力记录1
     */
    private String countRecord1;

    /**
     * 注意力和计算力评分1
     */
    private String countScore1;

    /**
     * 注意力和计算力记录2
     */
    private String countRecord2;

    /**
     * 注意力和计算力评分2
     */
    private String countScore2;

    /**
     * 注意力和计算力记录3
     */
    private String countRecord3;

    /**
     * 注意力和计算力评分3
     */
    private String countScore3;

    /**
     * 注意力和计算力记录4
     */
    private String countRecord4;

    /**
     * 注意力和计算力评分4
     */
    private String countScore4;

    /**
     * 注意力和计算力记录5
     */
    private String countRecord5;

    /**
     * 注意力和计算力评分5
     */
    private String countScore5;

    /**
     * 回忆能力记录1
     */
    private String recollectRecord1;

    /**
     * 回忆能力评分1
     */
    private String recollectScore1;

    /**
     * 回忆能力记录2
     */
    private String recollectRecord2;

    /**
     * 回忆能力评分2
     */
    private String recollectScore2;

    /**
     * 回忆能力记录3
     */
    private String recollectRecord3;

    /**
     * 回忆能力评分3
     */
    private String recollectScore3;

    /**
     * 命名能力问题1
     */
    private String namingQuestion1;

    /**
     * 命名能力记录1
     */
    private String namingRecord1;

    /**
     * 命名能力评分1
     */
    private String namingScore1;

    /**
     * 命名能力问题2
     */
    private String namingQuestion2;

    /**
     * 命名能力记录2
     */
    private String namingRecord2;

    /**
     * 命名能力评分2
     */
    private String namingScore2;

    /**
     * 复述能力问题
     */
    private String languageQuestion;

    /**
     * 复述能力记录
     */
    private String languageRecord;

    /**
     * 复述能力评分
     */
    private String languageScore;

    /**
     * 三步命令问题1
     */
    private String threestepQuestion1;

    /**
     * 三步命令记录1
     */
    private String threestepRecord1;

    /**
     * 三步命令评分1
     */
    private String threestepScore1;

    /**
     * 三步命令问题2
     */
    private String threestepQuestion2;

    /**
     * 三步命令记录2
     */
    private String threestepRecord2;

    /**
     * 三步命令评分2
     */
    private String threestepScore2;

    /**
     * 三步命令问题3
     */
    private String threestepQuestion3;

    /**
     * 三步命令记录3
     */
    private String threestepRecord3;

    /**
     * 三步命令评分3
     */
    private String threestepScore3;

    /**
     * 阅读能力问题
     */
    private String readQuestion;

    /**
     * 阅读能力记录
     */
    private String readRecord;

    /**
     * 阅读能力评分
     */
    private String readScore;

    /**
     * 书写能力问题
     */
    private String writeQuestion;

    /**
     * 书写能力记录
     */
    private String writeRecord;

    /**
     * 书写能力评分
     */
    private String writeScore;

    /**
     * 结构能力记录
     */
    private String structureRecord;

    /**
     * 结构能力评分
     */
    private String structureScore;

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

    public String getStructureScore() {
        return this.structureScore;
    }

    public void setStructureScore(String structureScore) {
        this.structureScore = structureScore;
    }

    public String getStructureRecord() {
        return this.structureRecord;
    }

    public void setStructureRecord(String structureRecord) {
        this.structureRecord = structureRecord;
    }

    public String getWriteScore() {
        return this.writeScore;
    }

    public void setWriteScore(String writeScore) {
        this.writeScore = writeScore;
    }

    public String getWriteRecord() {
        return this.writeRecord;
    }

    public void setWriteRecord(String writeRecord) {
        this.writeRecord = writeRecord;
    }

    public String getWriteQuestion() {
        return this.writeQuestion;
    }

    public void setWriteQuestion(String writeQuestion) {
        this.writeQuestion = writeQuestion;
    }

    public String getReadScore() {
        return this.readScore;
    }

    public void setReadScore(String readScore) {
        this.readScore = readScore;
    }

    public String getReadRecord() {
        return this.readRecord;
    }

    public void setReadRecord(String readRecord) {
        this.readRecord = readRecord;
    }

    public String getReadQuestion() {
        return this.readQuestion;
    }

    public void setReadQuestion(String readQuestion) {
        this.readQuestion = readQuestion;
    }

    public String getThreestepScore3() {
        return this.threestepScore3;
    }

    public void setThreestepScore3(String threestepScore3) {
        this.threestepScore3 = threestepScore3;
    }

    public String getThreestepRecord3() {
        return this.threestepRecord3;
    }

    public void setThreestepRecord3(String threestepRecord3) {
        this.threestepRecord3 = threestepRecord3;
    }

    public String getThreestepQuestion3() {
        return this.threestepQuestion3;
    }

    public void setThreestepQuestion3(String threestepQuestion3) {
        this.threestepQuestion3 = threestepQuestion3;
    }

    public String getThreestepScore2() {
        return this.threestepScore2;
    }

    public void setThreestepScore2(String threestepScore2) {
        this.threestepScore2 = threestepScore2;
    }

    public String getThreestepRecord2() {
        return this.threestepRecord2;
    }

    public void setThreestepRecord2(String threestepRecord2) {
        this.threestepRecord2 = threestepRecord2;
    }

    public String getThreestepQuestion2() {
        return this.threestepQuestion2;
    }

    public void setThreestepQuestion2(String threestepQuestion2) {
        this.threestepQuestion2 = threestepQuestion2;
    }

    public String getThreestepScore1() {
        return this.threestepScore1;
    }

    public void setThreestepScore1(String threestepScore1) {
        this.threestepScore1 = threestepScore1;
    }

    public String getThreestepRecord1() {
        return this.threestepRecord1;
    }

    public void setThreestepRecord1(String threestepRecord1) {
        this.threestepRecord1 = threestepRecord1;
    }

    public String getThreestepQuestion1() {
        return this.threestepQuestion1;
    }

    public void setThreestepQuestion1(String threestepQuestion1) {
        this.threestepQuestion1 = threestepQuestion1;
    }

    public String getLanguageScore() {
        return this.languageScore;
    }

    public void setLanguageScore(String languageScore) {
        this.languageScore = languageScore;
    }

    public String getLanguageRecord() {
        return this.languageRecord;
    }

    public void setLanguageRecord(String languageRecord) {
        this.languageRecord = languageRecord;
    }

    public String getLanguageQuestion() {
        return this.languageQuestion;
    }

    public void setLanguageQuestion(String languageQuestion) {
        this.languageQuestion = languageQuestion;
    }

    public String getNamingScore2() {
        return this.namingScore2;
    }

    public void setNamingScore2(String namingScore2) {
        this.namingScore2 = namingScore2;
    }

    public String getNamingRecord2() {
        return this.namingRecord2;
    }

    public void setNamingRecord2(String namingRecord2) {
        this.namingRecord2 = namingRecord2;
    }

    public String getNamingQuestion2() {
        return this.namingQuestion2;
    }

    public void setNamingQuestion2(String namingQuestion2) {
        this.namingQuestion2 = namingQuestion2;
    }

    public String getNamingScore1() {
        return this.namingScore1;
    }

    public void setNamingScore1(String namingScore1) {
        this.namingScore1 = namingScore1;
    }

    public String getNamingRecord1() {
        return this.namingRecord1;
    }

    public void setNamingRecord1(String namingRecord1) {
        this.namingRecord1 = namingRecord1;
    }

    public String getNamingQuestion1() {
        return this.namingQuestion1;
    }

    public void setNamingQuestion1(String namingQuestion1) {
        this.namingQuestion1 = namingQuestion1;
    }

    public String getRecollectScore3() {
        return this.recollectScore3;
    }

    public void setRecollectScore3(String recollectScore3) {
        this.recollectScore3 = recollectScore3;
    }

    public String getRecollectRecord3() {
        return this.recollectRecord3;
    }

    public void setRecollectRecord3(String recollectRecord3) {
        this.recollectRecord3 = recollectRecord3;
    }

    public String getRecollectScore2() {
        return this.recollectScore2;
    }

    public void setRecollectScore2(String recollectScore2) {
        this.recollectScore2 = recollectScore2;
    }

    public String getRecollectRecord2() {
        return this.recollectRecord2;
    }

    public void setRecollectRecord2(String recollectRecord2) {
        this.recollectRecord2 = recollectRecord2;
    }

    public String getRecollectScore1() {
        return this.recollectScore1;
    }

    public void setRecollectScore1(String recollectScore1) {
        this.recollectScore1 = recollectScore1;
    }

    public String getRecollectRecord1() {
        return this.recollectRecord1;
    }

    public void setRecollectRecord1(String recollectRecord1) {
        this.recollectRecord1 = recollectRecord1;
    }

    public String getCountScore5() {
        return this.countScore5;
    }

    public void setCountScore5(String countScore5) {
        this.countScore5 = countScore5;
    }

    public String getCountRecord5() {
        return this.countRecord5;
    }

    public void setCountRecord5(String countRecord5) {
        this.countRecord5 = countRecord5;
    }

    public String getCountScore4() {
        return this.countScore4;
    }

    public void setCountScore4(String countScore4) {
        this.countScore4 = countScore4;
    }

    public String getCountRecord4() {
        return this.countRecord4;
    }

    public void setCountRecord4(String countRecord4) {
        this.countRecord4 = countRecord4;
    }

    public String getCountScore3() {
        return this.countScore3;
    }

    public void setCountScore3(String countScore3) {
        this.countScore3 = countScore3;
    }

    public String getCountRecord3() {
        return this.countRecord3;
    }

    public void setCountRecord3(String countRecord3) {
        this.countRecord3 = countRecord3;
    }

    public String getCountScore2() {
        return this.countScore2;
    }

    public void setCountScore2(String countScore2) {
        this.countScore2 = countScore2;
    }

    public String getCountRecord2() {
        return this.countRecord2;
    }

    public void setCountRecord2(String countRecord2) {
        this.countRecord2 = countRecord2;
    }

    public String getCountScore1() {
        return this.countScore1;
    }

    public void setCountScore1(String countScore1) {
        this.countScore1 = countScore1;
    }

    public String getCountRecord1() {
        return this.countRecord1;
    }

    public void setCountRecord1(String countRecord1) {
        this.countRecord1 = countRecord1;
    }

    public String getMemoryScore3() {
        return this.memoryScore3;
    }

    public void setMemoryScore3(String memoryScore3) {
        this.memoryScore3 = memoryScore3;
    }

    public String getMemoryRecord3() {
        return this.memoryRecord3;
    }

    public void setMemoryRecord3(String memoryRecord3) {
        this.memoryRecord3 = memoryRecord3;
    }

    public String getMemoryScore2() {
        return this.memoryScore2;
    }

    public void setMemoryScore2(String memoryScore2) {
        this.memoryScore2 = memoryScore2;
    }

    public String getMemoryRecord2() {
        return this.memoryRecord2;
    }

    public void setMemoryRecord2(String memoryRecord2) {
        this.memoryRecord2 = memoryRecord2;
    }

    public String getMemoryScore1() {
        return this.memoryScore1;
    }

    public void setMemoryScore1(String memoryScore1) {
        this.memoryScore1 = memoryScore1;
    }

    public String getMemoryRecord1() {
        return this.memoryRecord1;
    }

    public void setMemoryRecord1(String memoryRecord1) {
        this.memoryRecord1 = memoryRecord1;
    }

    public String getDirectiveScore10() {
        return this.directiveScore10;
    }

    public void setDirectiveScore10(String directiveScore10) {
        this.directiveScore10 = directiveScore10;
    }

    public String getDirectiveRecord10() {
        return this.directiveRecord10;
    }

    public void setDirectiveRecord10(String directiveRecord10) {
        this.directiveRecord10 = directiveRecord10;
    }

    public String getDirectiveScore9() {
        return this.directiveScore9;
    }

    public void setDirectiveScore9(String directiveScore9) {
        this.directiveScore9 = directiveScore9;
    }

    public String getDirectiveRecord9() {
        return this.directiveRecord9;
    }

    public void setDirectiveRecord9(String directiveRecord9) {
        this.directiveRecord9 = directiveRecord9;
    }

    public String getDirectiveScore8() {
        return this.directiveScore8;
    }

    public void setDirectiveScore8(String directiveScore8) {
        this.directiveScore8 = directiveScore8;
    }

    public String getDirectiveRecord8() {
        return this.directiveRecord8;
    }

    public void setDirectiveRecord8(String directiveRecord8) {
        this.directiveRecord8 = directiveRecord8;
    }

    public String getDirectiveScore7() {
        return this.directiveScore7;
    }

    public void setDirectiveScore7(String directiveScore7) {
        this.directiveScore7 = directiveScore7;
    }

    public String getDirectiveRecord7() {
        return this.directiveRecord7;
    }

    public void setDirectiveRecord7(String directiveRecord7) {
        this.directiveRecord7 = directiveRecord7;
    }

    public String getDirectiveScore6() {
        return this.directiveScore6;
    }

    public void setDirectiveScore6(String directiveScore6) {
        this.directiveScore6 = directiveScore6;
    }

    public String getDirectiveRecord6() {
        return this.directiveRecord6;
    }

    public void setDirectiveRecord6(String directiveRecord6) {
        this.directiveRecord6 = directiveRecord6;
    }

    public String getDirectiveScore5() {
        return this.directiveScore5;
    }

    public void setDirectiveScore5(String directiveScore5) {
        this.directiveScore5 = directiveScore5;
    }

    public String getDirectiveRecord5() {
        return this.directiveRecord5;
    }

    public void setDirectiveRecord5(String directiveRecord5) {
        this.directiveRecord5 = directiveRecord5;
    }

    public String getDirectiveScore4() {
        return this.directiveScore4;
    }

    public void setDirectiveScore4(String directiveScore4) {
        this.directiveScore4 = directiveScore4;
    }

    public String getDirectiveRecord4() {
        return this.directiveRecord4;
    }

    public void setDirectiveRecord4(String directiveRecord4) {
        this.directiveRecord4 = directiveRecord4;
    }

    public String getDirectiveScore3() {
        return this.directiveScore3;
    }

    public void setDirectiveScore3(String directiveScore3) {
        this.directiveScore3 = directiveScore3;
    }

    public String getDirectiveRecord3() {
        return this.directiveRecord3;
    }

    public void setDirectiveRecord3(String directiveRecord3) {
        this.directiveRecord3 = directiveRecord3;
    }

    public String getDirectiveScore2() {
        return this.directiveScore2;
    }

    public void setDirectiveScore2(String directiveScore2) {
        this.directiveScore2 = directiveScore2;
    }

    public String getDirectiveRecord2() {
        return this.directiveRecord2;
    }

    public void setDirectiveRecord2(String directiveRecord2) {
        this.directiveRecord2 = directiveRecord2;
    }

    public String getDirectiveScore1() {
        return this.directiveScore1;
    }

    public void setDirectiveScore1(String directiveScore1) {
        this.directiveScore1 = directiveScore1;
    }

    public String getDirectiveRecord1() {
        return this.directiveRecord1;
    }

    public void setDirectiveRecord1(String directiveRecord1) {
        this.directiveRecord1 = directiveRecord1;
    }

    public String getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public String getDiseaseHistory() {
        return this.diseaseHistory;
    }

    public void setDiseaseHistory(String diseaseHistory) {
        this.diseaseHistory = diseaseHistory;
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

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getElderCognitionId() {
        return this.elderCognitionId;
    }

    public void setElderCognitionId(String elderCognitionId) {
        this.elderCognitionId = elderCognitionId;
    }

    @Generated(hash = 770065433)
    public ElderCognition(String elderCognitionId, String personInfoId,
            String name, String sexCode, Integer age, String educationCode,
            Date assessDate, String diseaseHistory, String totalScore,
            String directiveRecord1, String directiveScore1,
            String directiveRecord2, String directiveScore2,
            String directiveRecord3, String directiveScore3,
            String directiveRecord4, String directiveScore4,
            String directiveRecord5, String directiveScore5,
            String directiveRecord6, String directiveScore6,
            String directiveRecord7, String directiveScore7,
            String directiveRecord8, String directiveScore8,
            String directiveRecord9, String directiveScore9,
            String directiveRecord10, String directiveScore10,
            String memoryRecord1, String memoryScore1, String memoryRecord2,
            String memoryScore2, String memoryRecord3, String memoryScore3,
            String countRecord1, String countScore1, String countRecord2,
            String countScore2, String countRecord3, String countScore3,
            String countRecord4, String countScore4, String countRecord5,
            String countScore5, String recollectRecord1, String recollectScore1,
            String recollectRecord2, String recollectScore2,
            String recollectRecord3, String recollectScore3,
            String namingQuestion1, String namingRecord1, String namingScore1,
            String namingQuestion2, String namingRecord2, String namingScore2,
            String languageQuestion, String languageRecord, String languageScore,
            String threestepQuestion1, String threestepRecord1,
            String threestepScore1, String threestepQuestion2,
            String threestepRecord2, String threestepScore2,
            String threestepQuestion3, String threestepRecord3,
            String threestepScore3, String readQuestion, String readRecord,
            String readScore, String writeQuestion, String writeRecord,
            String writeScore, String structureRecord, String structureScore,
            Integer isCancel, String createOrgId, String orgName, String creatorId,
            String creator, Date createTime, String modifiedOrgId,
            String modifiedOrgName, String modifierId, String modifier,
            Date modifiedTime) {
        this.elderCognitionId = elderCognitionId;
        this.personInfoId = personInfoId;
        this.name = name;
        this.sexCode = sexCode;
        this.age = age;
        this.educationCode = educationCode;
        this.assessDate = assessDate;
        this.diseaseHistory = diseaseHistory;
        this.totalScore = totalScore;
        this.directiveRecord1 = directiveRecord1;
        this.directiveScore1 = directiveScore1;
        this.directiveRecord2 = directiveRecord2;
        this.directiveScore2 = directiveScore2;
        this.directiveRecord3 = directiveRecord3;
        this.directiveScore3 = directiveScore3;
        this.directiveRecord4 = directiveRecord4;
        this.directiveScore4 = directiveScore4;
        this.directiveRecord5 = directiveRecord5;
        this.directiveScore5 = directiveScore5;
        this.directiveRecord6 = directiveRecord6;
        this.directiveScore6 = directiveScore6;
        this.directiveRecord7 = directiveRecord7;
        this.directiveScore7 = directiveScore7;
        this.directiveRecord8 = directiveRecord8;
        this.directiveScore8 = directiveScore8;
        this.directiveRecord9 = directiveRecord9;
        this.directiveScore9 = directiveScore9;
        this.directiveRecord10 = directiveRecord10;
        this.directiveScore10 = directiveScore10;
        this.memoryRecord1 = memoryRecord1;
        this.memoryScore1 = memoryScore1;
        this.memoryRecord2 = memoryRecord2;
        this.memoryScore2 = memoryScore2;
        this.memoryRecord3 = memoryRecord3;
        this.memoryScore3 = memoryScore3;
        this.countRecord1 = countRecord1;
        this.countScore1 = countScore1;
        this.countRecord2 = countRecord2;
        this.countScore2 = countScore2;
        this.countRecord3 = countRecord3;
        this.countScore3 = countScore3;
        this.countRecord4 = countRecord4;
        this.countScore4 = countScore4;
        this.countRecord5 = countRecord5;
        this.countScore5 = countScore5;
        this.recollectRecord1 = recollectRecord1;
        this.recollectScore1 = recollectScore1;
        this.recollectRecord2 = recollectRecord2;
        this.recollectScore2 = recollectScore2;
        this.recollectRecord3 = recollectRecord3;
        this.recollectScore3 = recollectScore3;
        this.namingQuestion1 = namingQuestion1;
        this.namingRecord1 = namingRecord1;
        this.namingScore1 = namingScore1;
        this.namingQuestion2 = namingQuestion2;
        this.namingRecord2 = namingRecord2;
        this.namingScore2 = namingScore2;
        this.languageQuestion = languageQuestion;
        this.languageRecord = languageRecord;
        this.languageScore = languageScore;
        this.threestepQuestion1 = threestepQuestion1;
        this.threestepRecord1 = threestepRecord1;
        this.threestepScore1 = threestepScore1;
        this.threestepQuestion2 = threestepQuestion2;
        this.threestepRecord2 = threestepRecord2;
        this.threestepScore2 = threestepScore2;
        this.threestepQuestion3 = threestepQuestion3;
        this.threestepRecord3 = threestepRecord3;
        this.threestepScore3 = threestepScore3;
        this.readQuestion = readQuestion;
        this.readRecord = readRecord;
        this.readScore = readScore;
        this.writeQuestion = writeQuestion;
        this.writeRecord = writeRecord;
        this.writeScore = writeScore;
        this.structureRecord = structureRecord;
        this.structureScore = structureScore;
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

    @Generated(hash = 1813377013)
    public ElderCognition() {
    }



}