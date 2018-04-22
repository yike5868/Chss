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
 * @author hn
 * @date 2016年7月29日 上午10:24:54
 * @Description: 孕产登记(孕产妇台账)
 */
@Entity
public class MaternalRegister extends Entry {
    /**
     * 孕产登记ID
     */

    private String maternalRegisterId;

    /**
     * 孕产妇基本信息ID
     */

    private String maternalInfoId;

    /**
     * 个人档案ID
     */

    private String personInfoId;

    /**
     * 孕产登记档案编号
     */

    private String maternalInfoNo;

    /**
     * 孕产登记次数
     */
    private Integer pregnantCount;

    /**
     * 本人电话号码
     */

    private String telNo;

    /**
     * 户口(个人档案中的常住类型，存中文)
     */

    private String household;

    /**
     * 本人姓名
     */

    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 丈夫年龄
     */
    private Integer husbandAge;

    /**
     * 丈夫档案ID
     */

    private String husbandPersonInfoId;

    /**
     * 丈夫姓名
     */

    private String husbandName;

    /**
     * 丈夫工作单位
     */

    private String husbandUnit;

    /**
     * 住址
     */

    private String address;

    /**
     * 丈夫电话号码
     */

    private String husbandTelNo;

    /**
     * 月经周期
     */
    private Integer mensesPeriod;

    /**
     * 月经量
     */

    private String mensesMeasure;

    /**
     * 末次月经日期
     */


    private Date mensesLastDate;

    /**
     * 预产期
     */


    private Date expectedChildBirthday;

    /**
     * 现有子女数
     */
    private Integer childrenCount;

    /**
     * 是否建册
     */

    private String buildingManualCode;

    /**
     * 建册日期
     */


    private Date buildingManualDate;

    /**
     * 自然流产次数
     */
    private Integer spontaneousAbortionCount;

    /**
     * 人工流产次数
     */
    private Integer artificialAbortionCount;
    /**
     * 药物流产次数
     */
    private Integer drugAbortionCount;

    /**
     * 是否为计划内妊娠
     */

    private String pregnancyInplan;

    /**
     * 前次妊娠时间
     */


    private Date pregnancyLasttime;

    /**
     * 孕次
     */
    private Integer gravidity;

    /**
     * 产次
     */
    private Integer parity;

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
     * 收缩压(mmHg)
     */
    private Integer sbp;

    /**
     * 舒张压(mmHg)
     */
    private Integer dbp;

    /**
     * 备注
     */

    private String remark;

    /**
     * 档案状态
     */

    private String caseStatus;

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
     * 建档孕周（周)
     */
    private Integer buildWeeks;

    /**
     * 当前孕周
     */
    private Integer currentWeeks;

    /**
     * 建档孕周（天)
     */
    private Integer buildDays;

    /**
     * 产前第1次随访日期
     */


    private Date firstFollowupDate;

    /**
     * 产前第1次随访孕周
     */
    private Integer firstFollowupWeeks;

    /**
     * 产前第1次随访孕天
     */
    private Integer firstFollowupDays;

    /**
     * 产前第1次随访录入机构ID
     */

    private String firstFollowupOrgId;

    /**
     * 产前第2次随访日期
     */


    private Date secondFollowupDate;

    /**
     * 产前第2次随访孕周
     */
    private Integer secondFollowupWeeks;

    /**
     * 产前第2次随访孕天
     */
    private Integer secondFollowupDays;

    /**
     * 产前第2次随访录入机构ID
     */

    private String secondFollowupOrgId;

    /**
     * 产前第3次随访日期
     */


    private Date thirdFollowupDate;

    /**
     * 产前第3次随访孕周
     */
    private Integer thirdFollowupWeeks;

    /**
     * 产前第3次随访孕天
     */
    private Integer thirdFollowupDays;

    /**
     * 产前第3次随访录入机构ID
     */

    private String thirdFollowupOrgId;

    /**
     * 产前第4次随访日期
     */


    private Date fourthFollowupDate;

    /**
     * 产前第4次随访孕周
     */
    private Integer fourthFollowupWeeks;

    /**
     * 产前第4次随访孕天
     */
    private Integer fourthFollowupDays;

    /**
     * 产前第4次随访录入机构ID
     */

    private String fourthFollowupOrgId;

    /**
     * 产前第5次随访日期
     */


    private Date fifthFollowupDate;

    /**
     * 产前第5次随访孕周
     */
    private Integer fifthFollowupWeeks;

    /**
     * 产前第5次随访孕天
     */
    private Integer fifthFollowupDays;

    /**
     * 产前第5次随访录入机构ID
     */

    private String fifthFollowupOrgId;

    /**
     * 第1次其他随访日期
     */


    private Date followupDate1;

    /**
     * 第1次其他随访孕周
     */
    private Integer followupWeeks1;

    /**
     * 第1次其他随访孕天
     */
    private Integer followupDays1;

    /**
     * 第1次其他随访录入机构ID
     */

    private String followupOrgId1;

    /**
     * 第2次其他随访日期
     */


    private Date followupDate2;

    /**
     * 第2次其他随访孕周
     */
    private Integer followupWeeks2;

    /**
     * 第2次其他随访孕天
     */
    private Integer followupDays2;

    /**
     * 第2次其他随访录入机构ID
     */

    private String followupOrgId2;

    /**
     * 第3次其他随访日期
     */


    private Date followupDate3;

    /**
     * 第3次其他随访孕周
     */
    private Integer followupWeeks3;

    /**
     * 第3次其他随访孕天
     */
    private Integer followupDays3;

    /**
     * 第3次其他随访录入机构ID
     */

    private String followupOrgId3;

    /**
     * 第4次其他随访日期
     */


    private Date followupDate4;

    /**
     * 第4次其他随访孕周
     */
    private Integer followupWeeks4;

    /**
     * 第4次其他随访孕天
     */
    private Integer followupDays4;

    /**
     * 第4次其他随访录入机构ID
     */

    private String followupOrgId4;

    /**
     * 第5次其他随访日期
     */


    private Date followupDate5;

    /**
     * 第5次其他随访孕周
     */
    private Integer followupWeeks5;

    /**
     * 第5次其他随访孕天
     */
    private Integer followupDays5;

    /**
     * 第5次其他随访录入机构ID
     */

    private String followupOrgId5;

    /**
     * 第6次其他随访日期
     */


    private Date followupDate6;

    /**
     * 第6次其他随访孕周
     */
    private Integer followupWeeks6;

    /**
     * 第6次其他随访孕天
     */
    private Integer followupDays6;

    /**
     * 第6次其他随访录入机构ID
     */

    private String followupOrgId6;
    /**
     * 第7次其他随访日期
     */


    private Date followupDate7;

    /**
     * 第7次其他随访孕周
     */
    private Integer followupWeeks7;

    /**
     * 第7次其他随访孕天
     */
    private Integer followupDays7;

    /**
     * 第7次其他随访录入机构ID
     */

    private String followupOrgId7;

    /**
     * 第8次其他随访日期
     */


    private Date followupDate8;

    /**
     * 第8次其他随访孕周
     */
    private Integer followupWeeks8;

    /**
     * 第8次其他随访孕天
     */
    private Integer followupDays8;

    /**
     * 第8次其他随访录入机构ID
     */

    private String followupOrgId8;
    /**
     * 第9次其他随访日期
     */


    private Date followupDate9;

    /**
     * 第9次其他随访孕周
     */
    private Integer followupWeeks9;

    /**
     * 第9次其他随访孕天
     */
    private Integer followupDays9;

    /**
     * 第9次其他随访录入机构ID
     */

    private String followupOrgId9;

    /**
     * 第10次其他随访日期
     */


    private Date followupDate10;

    /**
     * 第10次其他随访孕周
     */
    private Integer followupWeeks10;

    /**
     * 第10次其他随访孕天
     */
    private Integer followupDays10;

    /**
     * 第10次其他随访录入机构ID
     */

    private String followupOrgId10;

    /**
     * 孕期检查HB(血红蛋白)[来自于第一次产前随访]
     */

    private String anemia;

    /**
     * 孕期检查HIV[来自于第一次产前随访]
     */

    private String hivExamination;

    /**
     * 孕期检查-乙肝[来自于第一次产前随访]
     */

    private String hepatitisCheck;

    /**
     * 孕期检查-梅毒[来自于第一次产前随访]
     */

    private String syphilisExamination;

    /**
     * 高危评分-早期[来自于高危妊娠评分]
     */
    private Integer hrScoreEarly;

    /**
     * 高危评分-中期[来自于高危妊娠评分]
     */
    private Integer hrScoreMiddle;

    /**
     * 高危评分-晩期[来自于高危妊娠评分]
     */
    private Integer hrScoreEarlyLater;

    /**
     * 唐筛
     */
    private String downsSyndrome;

    /**
     * 产前诊断
     */
    private String prenatalDiagnosis;

    /**
     * 分娩日期
     */


    private Date maternalChildbirthDate;

    /**
     * 分娩孕周
     */
    private Integer maternalWeeks;

    /**
     * 分娩孕天
     */
    private Integer maternalDays;

    /**
     * 分娩医院
     */

    private String maternalHospital;

    /**
     * 分娩方式
     */
    private String laborWayValue;

    /**
     * 围产儿-评分
     */
    private String perinatalBabyScore;

    /**
     * 围产儿-体重
     */
    private String perinatalBabyWeight;

    /**
     * 产后访式日期
     */


    private Date postpartumFollowupDate;

    /**
     * 产后访式-评估分类
     */

    private String postpartumPostpartumMom;

    /**
     * 产后访式录入机构ID
     */

    private String postpartumOrgId;

    /**
     * 产后42天访视日期
     */


    private Date lastFollowupDate;

    /**
     * 产后42天访视-分类
     */
    private String lastFollowupResult;

    /**
     * 产后42天访视录入机构ID
     */
    private String lastFollowupOrgId;

    /**
     * 宝贝性别
     */
    private String babySex;

    /**
     * 随访方式
     */

    private String followupType;

    /**
     * 台账备注
     */

    private String ledgerRemark;

    /**
     * 手工结案标志
     */

    private String closeCaseCode;

    /**
     * 手工结案原因
     */

    private String closeCaseReason;


    @Transient
    private List<RecordChoice> recordChoice;

    private String workUnit;

    public List<RecordChoice> getRecordChoice() {
        return recordChoice;
    }

    public void setRecordChoice(List<RecordChoice> recordChoice) {
        this.recordChoice = recordChoice;
    }

    public String getWorkUnit() {
        return this.workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getCloseCaseReason() {
        return this.closeCaseReason;
    }

    public void setCloseCaseReason(String closeCaseReason) {
        this.closeCaseReason = closeCaseReason;
    }

    public String getCloseCaseCode() {
        return this.closeCaseCode;
    }

    public void setCloseCaseCode(String closeCaseCode) {
        this.closeCaseCode = closeCaseCode;
    }

    public String getLedgerRemark() {
        return this.ledgerRemark;
    }

    public void setLedgerRemark(String ledgerRemark) {
        this.ledgerRemark = ledgerRemark;
    }

    public String getFollowupType() {
        return this.followupType;
    }

    public void setFollowupType(String followupType) {
        this.followupType = followupType;
    }

    public String getBabySex() {
        return this.babySex;
    }

    public void setBabySex(String babySex) {
        this.babySex = babySex;
    }

    public String getLastFollowupOrgId() {
        return this.lastFollowupOrgId;
    }

    public void setLastFollowupOrgId(String lastFollowupOrgId) {
        this.lastFollowupOrgId = lastFollowupOrgId;
    }

    public String getLastFollowupResult() {
        return this.lastFollowupResult;
    }

    public void setLastFollowupResult(String lastFollowupResult) {
        this.lastFollowupResult = lastFollowupResult;
    }

    public Date getLastFollowupDate() {
        return this.lastFollowupDate;
    }

    public void setLastFollowupDate(Date lastFollowupDate) {
        this.lastFollowupDate = lastFollowupDate;
    }

    public String getPostpartumOrgId() {
        return this.postpartumOrgId;
    }

    public void setPostpartumOrgId(String postpartumOrgId) {
        this.postpartumOrgId = postpartumOrgId;
    }

    public String getPostpartumPostpartumMom() {
        return this.postpartumPostpartumMom;
    }

    public void setPostpartumPostpartumMom(String postpartumPostpartumMom) {
        this.postpartumPostpartumMom = postpartumPostpartumMom;
    }

    public Date getPostpartumFollowupDate() {
        return this.postpartumFollowupDate;
    }

    public void setPostpartumFollowupDate(Date postpartumFollowupDate) {
        this.postpartumFollowupDate = postpartumFollowupDate;
    }

    public String getPerinatalBabyWeight() {
        return this.perinatalBabyWeight;
    }

    public void setPerinatalBabyWeight(String perinatalBabyWeight) {
        this.perinatalBabyWeight = perinatalBabyWeight;
    }

    public String getPerinatalBabyScore() {
        return this.perinatalBabyScore;
    }

    public void setPerinatalBabyScore(String perinatalBabyScore) {
        this.perinatalBabyScore = perinatalBabyScore;
    }

    public String getLaborWayValue() {
        return this.laborWayValue;
    }

    public void setLaborWayValue(String laborWayValue) {
        this.laborWayValue = laborWayValue;
    }

    public String getMaternalHospital() {
        return this.maternalHospital;
    }

    public void setMaternalHospital(String maternalHospital) {
        this.maternalHospital = maternalHospital;
    }

    public Integer getMaternalDays() {
        return this.maternalDays;
    }

    public void setMaternalDays(Integer maternalDays) {
        this.maternalDays = maternalDays;
    }

    public Integer getMaternalWeeks() {
        return this.maternalWeeks;
    }

    public void setMaternalWeeks(Integer maternalWeeks) {
        this.maternalWeeks = maternalWeeks;
    }

    public Date getMaternalChildbirthDate() {
        return this.maternalChildbirthDate;
    }

    public void setMaternalChildbirthDate(Date maternalChildbirthDate) {
        this.maternalChildbirthDate = maternalChildbirthDate;
    }

    public String getPrenatalDiagnosis() {
        return this.prenatalDiagnosis;
    }

    public void setPrenatalDiagnosis(String prenatalDiagnosis) {
        this.prenatalDiagnosis = prenatalDiagnosis;
    }

    public String getDownsSyndrome() {
        return this.downsSyndrome;
    }

    public void setDownsSyndrome(String downsSyndrome) {
        this.downsSyndrome = downsSyndrome;
    }

    public Integer getHrScoreEarlyLater() {
        return this.hrScoreEarlyLater;
    }

    public void setHrScoreEarlyLater(Integer hrScoreEarlyLater) {
        this.hrScoreEarlyLater = hrScoreEarlyLater;
    }

    public Integer getHrScoreMiddle() {
        return this.hrScoreMiddle;
    }

    public void setHrScoreMiddle(Integer hrScoreMiddle) {
        this.hrScoreMiddle = hrScoreMiddle;
    }

    public Integer getHrScoreEarly() {
        return this.hrScoreEarly;
    }

    public void setHrScoreEarly(Integer hrScoreEarly) {
        this.hrScoreEarly = hrScoreEarly;
    }

    public String getSyphilisExamination() {
        return this.syphilisExamination;
    }

    public void setSyphilisExamination(String syphilisExamination) {
        this.syphilisExamination = syphilisExamination;
    }

    public String getHepatitisCheck() {
        return this.hepatitisCheck;
    }

    public void setHepatitisCheck(String hepatitisCheck) {
        this.hepatitisCheck = hepatitisCheck;
    }

    public String getHivExamination() {
        return this.hivExamination;
    }

    public void setHivExamination(String hivExamination) {
        this.hivExamination = hivExamination;
    }

    public String getAnemia() {
        return this.anemia;
    }

    public void setAnemia(String anemia) {
        this.anemia = anemia;
    }

    public String getFollowupOrgId10() {
        return this.followupOrgId10;
    }

    public void setFollowupOrgId10(String followupOrgId10) {
        this.followupOrgId10 = followupOrgId10;
    }

    public Integer getFollowupDays10() {
        return this.followupDays10;
    }

    public void setFollowupDays10(Integer followupDays10) {
        this.followupDays10 = followupDays10;
    }

    public Integer getFollowupWeeks10() {
        return this.followupWeeks10;
    }

    public void setFollowupWeeks10(Integer followupWeeks10) {
        this.followupWeeks10 = followupWeeks10;
    }

    public Date getFollowupDate10() {
        return this.followupDate10;
    }

    public void setFollowupDate10(Date followupDate10) {
        this.followupDate10 = followupDate10;
    }

    public String getFollowupOrgId9() {
        return this.followupOrgId9;
    }

    public void setFollowupOrgId9(String followupOrgId9) {
        this.followupOrgId9 = followupOrgId9;
    }

    public Integer getFollowupDays9() {
        return this.followupDays9;
    }

    public void setFollowupDays9(Integer followupDays9) {
        this.followupDays9 = followupDays9;
    }

    public Integer getFollowupWeeks9() {
        return this.followupWeeks9;
    }

    public void setFollowupWeeks9(Integer followupWeeks9) {
        this.followupWeeks9 = followupWeeks9;
    }

    public Date getFollowupDate9() {
        return this.followupDate9;
    }

    public void setFollowupDate9(Date followupDate9) {
        this.followupDate9 = followupDate9;
    }

    public String getFollowupOrgId8() {
        return this.followupOrgId8;
    }

    public void setFollowupOrgId8(String followupOrgId8) {
        this.followupOrgId8 = followupOrgId8;
    }

    public Integer getFollowupDays8() {
        return this.followupDays8;
    }

    public void setFollowupDays8(Integer followupDays8) {
        this.followupDays8 = followupDays8;
    }

    public Integer getFollowupWeeks8() {
        return this.followupWeeks8;
    }

    public void setFollowupWeeks8(Integer followupWeeks8) {
        this.followupWeeks8 = followupWeeks8;
    }

    public Date getFollowupDate8() {
        return this.followupDate8;
    }

    public void setFollowupDate8(Date followupDate8) {
        this.followupDate8 = followupDate8;
    }

    public String getFollowupOrgId7() {
        return this.followupOrgId7;
    }

    public void setFollowupOrgId7(String followupOrgId7) {
        this.followupOrgId7 = followupOrgId7;
    }

    public Integer getFollowupDays7() {
        return this.followupDays7;
    }

    public void setFollowupDays7(Integer followupDays7) {
        this.followupDays7 = followupDays7;
    }

    public Integer getFollowupWeeks7() {
        return this.followupWeeks7;
    }

    public void setFollowupWeeks7(Integer followupWeeks7) {
        this.followupWeeks7 = followupWeeks7;
    }

    public Date getFollowupDate7() {
        return this.followupDate7;
    }

    public void setFollowupDate7(Date followupDate7) {
        this.followupDate7 = followupDate7;
    }

    public String getFollowupOrgId6() {
        return this.followupOrgId6;
    }

    public void setFollowupOrgId6(String followupOrgId6) {
        this.followupOrgId6 = followupOrgId6;
    }

    public Integer getFollowupDays6() {
        return this.followupDays6;
    }

    public void setFollowupDays6(Integer followupDays6) {
        this.followupDays6 = followupDays6;
    }

    public Integer getFollowupWeeks6() {
        return this.followupWeeks6;
    }

    public void setFollowupWeeks6(Integer followupWeeks6) {
        this.followupWeeks6 = followupWeeks6;
    }

    public Date getFollowupDate6() {
        return this.followupDate6;
    }

    public void setFollowupDate6(Date followupDate6) {
        this.followupDate6 = followupDate6;
    }

    public String getFollowupOrgId5() {
        return this.followupOrgId5;
    }

    public void setFollowupOrgId5(String followupOrgId5) {
        this.followupOrgId5 = followupOrgId5;
    }

    public Integer getFollowupDays5() {
        return this.followupDays5;
    }

    public void setFollowupDays5(Integer followupDays5) {
        this.followupDays5 = followupDays5;
    }

    public Integer getFollowupWeeks5() {
        return this.followupWeeks5;
    }

    public void setFollowupWeeks5(Integer followupWeeks5) {
        this.followupWeeks5 = followupWeeks5;
    }

    public Date getFollowupDate5() {
        return this.followupDate5;
    }

    public void setFollowupDate5(Date followupDate5) {
        this.followupDate5 = followupDate5;
    }

    public String getFollowupOrgId4() {
        return this.followupOrgId4;
    }

    public void setFollowupOrgId4(String followupOrgId4) {
        this.followupOrgId4 = followupOrgId4;
    }

    public Integer getFollowupDays4() {
        return this.followupDays4;
    }

    public void setFollowupDays4(Integer followupDays4) {
        this.followupDays4 = followupDays4;
    }

    public Integer getFollowupWeeks4() {
        return this.followupWeeks4;
    }

    public void setFollowupWeeks4(Integer followupWeeks4) {
        this.followupWeeks4 = followupWeeks4;
    }

    public Date getFollowupDate4() {
        return this.followupDate4;
    }

    public void setFollowupDate4(Date followupDate4) {
        this.followupDate4 = followupDate4;
    }

    public String getFollowupOrgId3() {
        return this.followupOrgId3;
    }

    public void setFollowupOrgId3(String followupOrgId3) {
        this.followupOrgId3 = followupOrgId3;
    }

    public Integer getFollowupDays3() {
        return this.followupDays3;
    }

    public void setFollowupDays3(Integer followupDays3) {
        this.followupDays3 = followupDays3;
    }

    public Integer getFollowupWeeks3() {
        return this.followupWeeks3;
    }

    public void setFollowupWeeks3(Integer followupWeeks3) {
        this.followupWeeks3 = followupWeeks3;
    }

    public Date getFollowupDate3() {
        return this.followupDate3;
    }

    public void setFollowupDate3(Date followupDate3) {
        this.followupDate3 = followupDate3;
    }

    public String getFollowupOrgId2() {
        return this.followupOrgId2;
    }

    public void setFollowupOrgId2(String followupOrgId2) {
        this.followupOrgId2 = followupOrgId2;
    }

    public Integer getFollowupDays2() {
        return this.followupDays2;
    }

    public void setFollowupDays2(Integer followupDays2) {
        this.followupDays2 = followupDays2;
    }

    public Integer getFollowupWeeks2() {
        return this.followupWeeks2;
    }

    public void setFollowupWeeks2(Integer followupWeeks2) {
        this.followupWeeks2 = followupWeeks2;
    }

    public Date getFollowupDate2() {
        return this.followupDate2;
    }

    public void setFollowupDate2(Date followupDate2) {
        this.followupDate2 = followupDate2;
    }

    public String getFollowupOrgId1() {
        return this.followupOrgId1;
    }

    public void setFollowupOrgId1(String followupOrgId1) {
        this.followupOrgId1 = followupOrgId1;
    }

    public Integer getFollowupDays1() {
        return this.followupDays1;
    }

    public void setFollowupDays1(Integer followupDays1) {
        this.followupDays1 = followupDays1;
    }

    public Integer getFollowupWeeks1() {
        return this.followupWeeks1;
    }

    public void setFollowupWeeks1(Integer followupWeeks1) {
        this.followupWeeks1 = followupWeeks1;
    }

    public Date getFollowupDate1() {
        return this.followupDate1;
    }

    public void setFollowupDate1(Date followupDate1) {
        this.followupDate1 = followupDate1;
    }

    public String getFifthFollowupOrgId() {
        return this.fifthFollowupOrgId;
    }

    public void setFifthFollowupOrgId(String fifthFollowupOrgId) {
        this.fifthFollowupOrgId = fifthFollowupOrgId;
    }

    public Integer getFifthFollowupDays() {
        return this.fifthFollowupDays;
    }

    public void setFifthFollowupDays(Integer fifthFollowupDays) {
        this.fifthFollowupDays = fifthFollowupDays;
    }

    public Integer getFifthFollowupWeeks() {
        return this.fifthFollowupWeeks;
    }

    public void setFifthFollowupWeeks(Integer fifthFollowupWeeks) {
        this.fifthFollowupWeeks = fifthFollowupWeeks;
    }

    public Date getFifthFollowupDate() {
        return this.fifthFollowupDate;
    }

    public void setFifthFollowupDate(Date fifthFollowupDate) {
        this.fifthFollowupDate = fifthFollowupDate;
    }

    public String getFourthFollowupOrgId() {
        return this.fourthFollowupOrgId;
    }

    public void setFourthFollowupOrgId(String fourthFollowupOrgId) {
        this.fourthFollowupOrgId = fourthFollowupOrgId;
    }

    public Integer getFourthFollowupDays() {
        return this.fourthFollowupDays;
    }

    public void setFourthFollowupDays(Integer fourthFollowupDays) {
        this.fourthFollowupDays = fourthFollowupDays;
    }

    public Integer getFourthFollowupWeeks() {
        return this.fourthFollowupWeeks;
    }

    public void setFourthFollowupWeeks(Integer fourthFollowupWeeks) {
        this.fourthFollowupWeeks = fourthFollowupWeeks;
    }

    public Date getFourthFollowupDate() {
        return this.fourthFollowupDate;
    }

    public void setFourthFollowupDate(Date fourthFollowupDate) {
        this.fourthFollowupDate = fourthFollowupDate;
    }

    public String getThirdFollowupOrgId() {
        return this.thirdFollowupOrgId;
    }

    public void setThirdFollowupOrgId(String thirdFollowupOrgId) {
        this.thirdFollowupOrgId = thirdFollowupOrgId;
    }

    public Integer getThirdFollowupDays() {
        return this.thirdFollowupDays;
    }

    public void setThirdFollowupDays(Integer thirdFollowupDays) {
        this.thirdFollowupDays = thirdFollowupDays;
    }

    public Integer getThirdFollowupWeeks() {
        return this.thirdFollowupWeeks;
    }

    public void setThirdFollowupWeeks(Integer thirdFollowupWeeks) {
        this.thirdFollowupWeeks = thirdFollowupWeeks;
    }

    public Date getThirdFollowupDate() {
        return this.thirdFollowupDate;
    }

    public void setThirdFollowupDate(Date thirdFollowupDate) {
        this.thirdFollowupDate = thirdFollowupDate;
    }

    public String getSecondFollowupOrgId() {
        return this.secondFollowupOrgId;
    }

    public void setSecondFollowupOrgId(String secondFollowupOrgId) {
        this.secondFollowupOrgId = secondFollowupOrgId;
    }

    public Integer getSecondFollowupDays() {
        return this.secondFollowupDays;
    }

    public void setSecondFollowupDays(Integer secondFollowupDays) {
        this.secondFollowupDays = secondFollowupDays;
    }

    public Integer getSecondFollowupWeeks() {
        return this.secondFollowupWeeks;
    }

    public void setSecondFollowupWeeks(Integer secondFollowupWeeks) {
        this.secondFollowupWeeks = secondFollowupWeeks;
    }

    public Date getSecondFollowupDate() {
        return this.secondFollowupDate;
    }

    public void setSecondFollowupDate(Date secondFollowupDate) {
        this.secondFollowupDate = secondFollowupDate;
    }

    public String getFirstFollowupOrgId() {
        return this.firstFollowupOrgId;
    }

    public void setFirstFollowupOrgId(String firstFollowupOrgId) {
        this.firstFollowupOrgId = firstFollowupOrgId;
    }

    public Integer getFirstFollowupDays() {
        return this.firstFollowupDays;
    }

    public void setFirstFollowupDays(Integer firstFollowupDays) {
        this.firstFollowupDays = firstFollowupDays;
    }

    public Integer getFirstFollowupWeeks() {
        return this.firstFollowupWeeks;
    }

    public void setFirstFollowupWeeks(Integer firstFollowupWeeks) {
        this.firstFollowupWeeks = firstFollowupWeeks;
    }

    public Date getFirstFollowupDate() {
        return this.firstFollowupDate;
    }

    public void setFirstFollowupDate(Date firstFollowupDate) {
        this.firstFollowupDate = firstFollowupDate;
    }

    public Integer getBuildDays() {
        return this.buildDays;
    }

    public void setBuildDays(Integer buildDays) {
        this.buildDays = buildDays;
    }

    public Integer getCurrentWeeks() {
        return this.currentWeeks;
    }

    public void setCurrentWeeks(Integer currentWeeks) {
        this.currentWeeks = currentWeeks;
    }

    public Integer getBuildWeeks() {
        return this.buildWeeks;
    }

    public void setBuildWeeks(Integer buildWeeks) {
        this.buildWeeks = buildWeeks;
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

    public String getCaseStatus() {
        return this.caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getPregnancyLasttime() {
        return this.pregnancyLasttime;
    }

    public void setPregnancyLasttime(Date pregnancyLasttime) {
        this.pregnancyLasttime = pregnancyLasttime;
    }

    public String getPregnancyInplan() {
        return this.pregnancyInplan;
    }

    public void setPregnancyInplan(String pregnancyInplan) {
        this.pregnancyInplan = pregnancyInplan;
    }

    public Integer getDrugAbortionCount() {
        return this.drugAbortionCount;
    }

    public void setDrugAbortionCount(Integer drugAbortionCount) {
        this.drugAbortionCount = drugAbortionCount;
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

    public Date getBuildingManualDate() {
        return this.buildingManualDate;
    }

    public void setBuildingManualDate(Date buildingManualDate) {
        this.buildingManualDate = buildingManualDate;
    }

    public String getBuildingManualCode() {
        return this.buildingManualCode;
    }

    public void setBuildingManualCode(String buildingManualCode) {
        this.buildingManualCode = buildingManualCode;
    }

    public Integer getChildrenCount() {
        return this.childrenCount;
    }

    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
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

    public String getMensesMeasure() {
        return this.mensesMeasure;
    }

    public void setMensesMeasure(String mensesMeasure) {
        this.mensesMeasure = mensesMeasure;
    }

    public Integer getMensesPeriod() {
        return this.mensesPeriod;
    }

    public void setMensesPeriod(Integer mensesPeriod) {
        this.mensesPeriod = mensesPeriod;
    }

    public String getHusbandTelNo() {
        return this.husbandTelNo;
    }

    public void setHusbandTelNo(String husbandTelNo) {
        this.husbandTelNo = husbandTelNo;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHusbandUnit() {
        return this.husbandUnit;
    }

    public void setHusbandUnit(String husbandUnit) {
        this.husbandUnit = husbandUnit;
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

    public Integer getHusbandAge() {
        return this.husbandAge;
    }

    public void setHusbandAge(Integer husbandAge) {
        this.husbandAge = husbandAge;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHousehold() {
        return this.household;
    }

    public void setHousehold(String household) {
        this.household = household;
    }

    public String getTelNo() {
        return this.telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public Integer getPregnantCount() {
        return this.pregnantCount;
    }

    public void setPregnantCount(Integer pregnantCount) {
        this.pregnantCount = pregnantCount;
    }

    public String getMaternalInfoNo() {
        return this.maternalInfoNo;
    }

    public void setMaternalInfoNo(String maternalInfoNo) {
        this.maternalInfoNo = maternalInfoNo;
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

    public String getMaternalRegisterId() {
        return this.maternalRegisterId;
    }

    public void setMaternalRegisterId(String maternalRegisterId) {
        this.maternalRegisterId = maternalRegisterId;
    }

    @Generated(hash = 535761629)
    public MaternalRegister(String maternalRegisterId, String maternalInfoId,
                            String personInfoId, String maternalInfoNo, Integer pregnantCount,
                            String telNo, String household, String name, Integer age,
                            Integer husbandAge, String husbandPersonInfoId, String husbandName,
                            String husbandUnit, String address, String husbandTelNo,
                            Integer mensesPeriod, String mensesMeasure, Date mensesLastDate,
                            Date expectedChildBirthday, Integer childrenCount,
                            String buildingManualCode, Date buildingManualDate,
                            Integer spontaneousAbortionCount, Integer artificialAbortionCount,
                            Integer drugAbortionCount, String pregnancyInplan,
                            Date pregnancyLasttime, Integer gravidity, Integer parity,
                            Double height, Double weight, Double bmi, Integer sbp, Integer dbp,
                            String remark, String caseStatus, Integer isCancel, String createOrgId,
                            String orgName, String creatorId, String creator, Date createTime,
                            String modifiedOrgId, String modifiedOrgName, String modifierId,
                            String modifier, Date modifiedTime, Integer buildWeeks,
                            Integer currentWeeks, Integer buildDays, Date firstFollowupDate,
                            Integer firstFollowupWeeks, Integer firstFollowupDays,
                            String firstFollowupOrgId, Date secondFollowupDate,
                            Integer secondFollowupWeeks, Integer secondFollowupDays,
                            String secondFollowupOrgId, Date thirdFollowupDate,
                            Integer thirdFollowupWeeks, Integer thirdFollowupDays,
                            String thirdFollowupOrgId, Date fourthFollowupDate,
                            Integer fourthFollowupWeeks, Integer fourthFollowupDays,
                            String fourthFollowupOrgId, Date fifthFollowupDate,
                            Integer fifthFollowupWeeks, Integer fifthFollowupDays,
                            String fifthFollowupOrgId, Date followupDate1, Integer followupWeeks1,
                            Integer followupDays1, String followupOrgId1, Date followupDate2,
                            Integer followupWeeks2, Integer followupDays2, String followupOrgId2,
                            Date followupDate3, Integer followupWeeks3, Integer followupDays3,
                            String followupOrgId3, Date followupDate4, Integer followupWeeks4,
                            Integer followupDays4, String followupOrgId4, Date followupDate5,
                            Integer followupWeeks5, Integer followupDays5, String followupOrgId5,
                            Date followupDate6, Integer followupWeeks6, Integer followupDays6,
                            String followupOrgId6, Date followupDate7, Integer followupWeeks7,
                            Integer followupDays7, String followupOrgId7, Date followupDate8,
                            Integer followupWeeks8, Integer followupDays8, String followupOrgId8,
                            Date followupDate9, Integer followupWeeks9, Integer followupDays9,
                            String followupOrgId9, Date followupDate10, Integer followupWeeks10,
                            Integer followupDays10, String followupOrgId10, String anemia,
                            String hivExamination, String hepatitisCheck,
                            String syphilisExamination, Integer hrScoreEarly,
                            Integer hrScoreMiddle, Integer hrScoreEarlyLater, String downsSyndrome,
                            String prenatalDiagnosis, Date maternalChildbirthDate,
                            Integer maternalWeeks, Integer maternalDays, String maternalHospital,
                            String laborWayValue, String perinatalBabyScore,
                            String perinatalBabyWeight, Date postpartumFollowupDate,
                            String postpartumPostpartumMom, String postpartumOrgId,
                            Date lastFollowupDate, String lastFollowupResult,
                            String lastFollowupOrgId, String babySex, String followupType,
                            String ledgerRemark, String closeCaseCode, String closeCaseReason,
                            String workUnit) {
        this.maternalRegisterId = maternalRegisterId;
        this.maternalInfoId = maternalInfoId;
        this.personInfoId = personInfoId;
        this.maternalInfoNo = maternalInfoNo;
        this.pregnantCount = pregnantCount;
        this.telNo = telNo;
        this.household = household;
        this.name = name;
        this.age = age;
        this.husbandAge = husbandAge;
        this.husbandPersonInfoId = husbandPersonInfoId;
        this.husbandName = husbandName;
        this.husbandUnit = husbandUnit;
        this.address = address;
        this.husbandTelNo = husbandTelNo;
        this.mensesPeriod = mensesPeriod;
        this.mensesMeasure = mensesMeasure;
        this.mensesLastDate = mensesLastDate;
        this.expectedChildBirthday = expectedChildBirthday;
        this.childrenCount = childrenCount;
        this.buildingManualCode = buildingManualCode;
        this.buildingManualDate = buildingManualDate;
        this.spontaneousAbortionCount = spontaneousAbortionCount;
        this.artificialAbortionCount = artificialAbortionCount;
        this.drugAbortionCount = drugAbortionCount;
        this.pregnancyInplan = pregnancyInplan;
        this.pregnancyLasttime = pregnancyLasttime;
        this.gravidity = gravidity;
        this.parity = parity;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.sbp = sbp;
        this.dbp = dbp;
        this.remark = remark;
        this.caseStatus = caseStatus;
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
        this.buildWeeks = buildWeeks;
        this.currentWeeks = currentWeeks;
        this.buildDays = buildDays;
        this.firstFollowupDate = firstFollowupDate;
        this.firstFollowupWeeks = firstFollowupWeeks;
        this.firstFollowupDays = firstFollowupDays;
        this.firstFollowupOrgId = firstFollowupOrgId;
        this.secondFollowupDate = secondFollowupDate;
        this.secondFollowupWeeks = secondFollowupWeeks;
        this.secondFollowupDays = secondFollowupDays;
        this.secondFollowupOrgId = secondFollowupOrgId;
        this.thirdFollowupDate = thirdFollowupDate;
        this.thirdFollowupWeeks = thirdFollowupWeeks;
        this.thirdFollowupDays = thirdFollowupDays;
        this.thirdFollowupOrgId = thirdFollowupOrgId;
        this.fourthFollowupDate = fourthFollowupDate;
        this.fourthFollowupWeeks = fourthFollowupWeeks;
        this.fourthFollowupDays = fourthFollowupDays;
        this.fourthFollowupOrgId = fourthFollowupOrgId;
        this.fifthFollowupDate = fifthFollowupDate;
        this.fifthFollowupWeeks = fifthFollowupWeeks;
        this.fifthFollowupDays = fifthFollowupDays;
        this.fifthFollowupOrgId = fifthFollowupOrgId;
        this.followupDate1 = followupDate1;
        this.followupWeeks1 = followupWeeks1;
        this.followupDays1 = followupDays1;
        this.followupOrgId1 = followupOrgId1;
        this.followupDate2 = followupDate2;
        this.followupWeeks2 = followupWeeks2;
        this.followupDays2 = followupDays2;
        this.followupOrgId2 = followupOrgId2;
        this.followupDate3 = followupDate3;
        this.followupWeeks3 = followupWeeks3;
        this.followupDays3 = followupDays3;
        this.followupOrgId3 = followupOrgId3;
        this.followupDate4 = followupDate4;
        this.followupWeeks4 = followupWeeks4;
        this.followupDays4 = followupDays4;
        this.followupOrgId4 = followupOrgId4;
        this.followupDate5 = followupDate5;
        this.followupWeeks5 = followupWeeks5;
        this.followupDays5 = followupDays5;
        this.followupOrgId5 = followupOrgId5;
        this.followupDate6 = followupDate6;
        this.followupWeeks6 = followupWeeks6;
        this.followupDays6 = followupDays6;
        this.followupOrgId6 = followupOrgId6;
        this.followupDate7 = followupDate7;
        this.followupWeeks7 = followupWeeks7;
        this.followupDays7 = followupDays7;
        this.followupOrgId7 = followupOrgId7;
        this.followupDate8 = followupDate8;
        this.followupWeeks8 = followupWeeks8;
        this.followupDays8 = followupDays8;
        this.followupOrgId8 = followupOrgId8;
        this.followupDate9 = followupDate9;
        this.followupWeeks9 = followupWeeks9;
        this.followupDays9 = followupDays9;
        this.followupOrgId9 = followupOrgId9;
        this.followupDate10 = followupDate10;
        this.followupWeeks10 = followupWeeks10;
        this.followupDays10 = followupDays10;
        this.followupOrgId10 = followupOrgId10;
        this.anemia = anemia;
        this.hivExamination = hivExamination;
        this.hepatitisCheck = hepatitisCheck;
        this.syphilisExamination = syphilisExamination;
        this.hrScoreEarly = hrScoreEarly;
        this.hrScoreMiddle = hrScoreMiddle;
        this.hrScoreEarlyLater = hrScoreEarlyLater;
        this.downsSyndrome = downsSyndrome;
        this.prenatalDiagnosis = prenatalDiagnosis;
        this.maternalChildbirthDate = maternalChildbirthDate;
        this.maternalWeeks = maternalWeeks;
        this.maternalDays = maternalDays;
        this.maternalHospital = maternalHospital;
        this.laborWayValue = laborWayValue;
        this.perinatalBabyScore = perinatalBabyScore;
        this.perinatalBabyWeight = perinatalBabyWeight;
        this.postpartumFollowupDate = postpartumFollowupDate;
        this.postpartumPostpartumMom = postpartumPostpartumMom;
        this.postpartumOrgId = postpartumOrgId;
        this.lastFollowupDate = lastFollowupDate;
        this.lastFollowupResult = lastFollowupResult;
        this.lastFollowupOrgId = lastFollowupOrgId;
        this.babySex = babySex;
        this.followupType = followupType;
        this.ledgerRemark = ledgerRemark;
        this.closeCaseCode = closeCaseCode;
        this.closeCaseReason = closeCaseReason;
        this.workUnit = workUnit;
    }

    @Generated(hash = 1951207697)
    @Keep
    public MaternalRegister() {
        recordChoice = new ArrayList<>();
    }


}