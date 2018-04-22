package net.greatsoft.main.db.po.cerebralApoplexy;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author HS
 * @date 2016年11月12日 下午1:40:50
 * @Description: 脑卒中患者管理卡用药
 */
@Entity
public class CaInfoDrugs {
    /**
     * 脑卒中患者管理卡随访用药ID
     */
    private String caInfoDrugId;

    /**
     * 脑卒中患者管理卡ID
     */
    private String caInfoId;

    /**
     * 药物ID
     */
    private String drugId;

    /**
     * 药物名称
     */
    private String drugName;

    /**
     * 药物使用频率
     */
    private String drugUsingFreq;

    /**
     * 药物使用剂量单位
     */
    private String drugDoseUnit;

    /**
     * 药物使用次剂量
     */
    private String drugPerDose;

    /**
     * 药物使用总剂量
     */
    private Double drugTotalDose;

    /**
     * 药物使用途径代码
     */
    private String drugRouteCode;

    /**
     * 药物使用单位
     */
    private String unit;

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDrugRouteCode() {
        return this.drugRouteCode;
    }

    public void setDrugRouteCode(String drugRouteCode) {
        this.drugRouteCode = drugRouteCode;
    }

    public Double getDrugTotalDose() {
        return this.drugTotalDose;
    }

    public void setDrugTotalDose(Double drugTotalDose) {
        this.drugTotalDose = drugTotalDose;
    }

    public String getDrugPerDose() {
        return this.drugPerDose;
    }

    public void setDrugPerDose(String drugPerDose) {
        this.drugPerDose = drugPerDose;
    }

    public String getDrugDoseUnit() {
        return this.drugDoseUnit;
    }

    public void setDrugDoseUnit(String drugDoseUnit) {
        this.drugDoseUnit = drugDoseUnit;
    }

    public String getDrugUsingFreq() {
        return this.drugUsingFreq;
    }

    public void setDrugUsingFreq(String drugUsingFreq) {
        this.drugUsingFreq = drugUsingFreq;
    }

    public String getDrugName() {
        return this.drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugId() {
        return this.drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getCaInfoId() {
        return this.caInfoId;
    }

    public void setCaInfoId(String caInfoId) {
        this.caInfoId = caInfoId;
    }

    public String getCaInfoDrugId() {
        return this.caInfoDrugId;
    }

    public void setCaInfoDrugId(String caInfoDrugId) {
        this.caInfoDrugId = caInfoDrugId;
    }

    @Generated(hash = 502428096)
    public CaInfoDrugs(String caInfoDrugId, String caInfoId, String drugId,
                       String drugName, String drugUsingFreq, String drugDoseUnit,
                       String drugPerDose, Double drugTotalDose, String drugRouteCode,
                       String unit) {
        this.caInfoDrugId = caInfoDrugId;
        this.caInfoId = caInfoId;
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugUsingFreq = drugUsingFreq;
        this.drugDoseUnit = drugDoseUnit;
        this.drugPerDose = drugPerDose;
        this.drugTotalDose = drugTotalDose;
        this.drugRouteCode = drugRouteCode;
        this.unit = unit;
    }

    @Generated(hash = 2027578328)
    public CaInfoDrugs() {
    }

}