package net.greatsoft.main.db.po.hyperinfo;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年7月4日 下午12:47:41 
 * @Description: 高血压患者专档用药数据模型
 *
 */
@Entity
public class HyperInfoDrug extends Entry {
    /**
     * 高血压患者专档用药ID
     */
    private String hyperInfoDrugId;

    /**
     * 高血压患者专档ID
     */
    private String hyperInfoId;

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

    public String getHyperInfoId() {
        return this.hyperInfoId;
    }

    public void setHyperInfoId(String hyperInfoId) {
        this.hyperInfoId = hyperInfoId;
    }

    public String getHyperInfoDrugId() {
        return this.hyperInfoDrugId;
    }

    public void setHyperInfoDrugId(String hyperInfoDrugId) {
        this.hyperInfoDrugId = hyperInfoDrugId;
    }

    @Generated(hash = 65504963)
    public HyperInfoDrug(String hyperInfoDrugId, String hyperInfoId, String drugId,
            String drugName, String drugUsingFreq, String drugDoseUnit,
            String drugPerDose, Double drugTotalDose, String drugRouteCode) {
        this.hyperInfoDrugId = hyperInfoDrugId;
        this.hyperInfoId = hyperInfoId;
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugUsingFreq = drugUsingFreq;
        this.drugDoseUnit = drugDoseUnit;
        this.drugPerDose = drugPerDose;
        this.drugTotalDose = drugTotalDose;
        this.drugRouteCode = drugRouteCode;
    }

    @Generated(hash = 1244273190)
    public HyperInfoDrug() {
    }

}