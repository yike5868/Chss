package net.greatsoft.main.db.po.diabetes;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;



/**
 * 
 * @author hn
 * @date 2016年7月7日 下午1:10:31 
 * @Description: 2型糖尿病患者专档用药
 *
 */
@Entity
public class DiabetesInfoDrug extends Entry {
    /**
     * 2型糖尿病患者专档用药ID
     */
    private String diabetesInfoDrugId;

    /**
     * 2型糖尿病患者专档ID
     */
    private String diabetesInfoId;

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

    public String getDiabetesInfoId() {
        return this.diabetesInfoId;
    }

    public void setDiabetesInfoId(String diabetesInfoId) {
        this.diabetesInfoId = diabetesInfoId;
    }

    public String getDiabetesInfoDrugId() {
        return this.diabetesInfoDrugId;
    }

    public void setDiabetesInfoDrugId(String diabetesInfoDrugId) {
        this.diabetesInfoDrugId = diabetesInfoDrugId;
    }

    @Generated(hash = 707683057)
    public DiabetesInfoDrug(String diabetesInfoDrugId, String diabetesInfoId,
            String drugId, String drugName, String drugUsingFreq,
            String drugDoseUnit, String drugPerDose, Double drugTotalDose,
            String drugRouteCode) {
        this.diabetesInfoDrugId = diabetesInfoDrugId;
        this.diabetesInfoId = diabetesInfoId;
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugUsingFreq = drugUsingFreq;
        this.drugDoseUnit = drugDoseUnit;
        this.drugPerDose = drugPerDose;
        this.drugTotalDose = drugTotalDose;
        this.drugRouteCode = drugRouteCode;
    }

    @Generated(hash = 916795499)
    public DiabetesInfoDrug() {
    }


}