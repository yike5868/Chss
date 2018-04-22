package net.greatsoft.main.db.po.diabetes;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年6月28日 下午10:40:53 
 * @Description: 2型糖尿病随访信息用药
 *
 */
@Entity
public class DiabetesFollowupDrug {
    /**
     * 2型糖尿病随访信息用药ID
     */
    private String diabetesFollowupDrugId;

    /**
     * 2型糖尿病患者随访ID
     */
    private String diabetesFollowupId;

    /**
     * 药物ID
     */
    private String drugId;

    /**
     * 药物名称
     */
    private String drugName;

    /**
     * 药物使用频率(次/日)
     */
    private String drugUsingFreq;

    /**
     * 药物使用剂量单位
     */
    private String drugDoseUnit;

    /**
     * 药物使用次剂量(mg/次)
     */
    private String drugPerDose;

    private String unit;

    /**
     * 药物使用总剂量
     */
    private Double drugTotalDose;

    /**
     * 药物使用途径代码
     */
    private String drugRouteCode;

    public String getUnit() {
        return unit;
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

    public String getDiabetesFollowupId() {
        return this.diabetesFollowupId;
    }

    public void setDiabetesFollowupId(String diabetesFollowupId) {
        this.diabetesFollowupId = diabetesFollowupId;
    }

    public String getDiabetesFollowupDrugId() {
        return this.diabetesFollowupDrugId;
    }

    public void setDiabetesFollowupDrugId(String diabetesFollowupDrugId) {
        this.diabetesFollowupDrugId = diabetesFollowupDrugId;
    }

    @Generated(hash = 1677307907)
    public DiabetesFollowupDrug(String diabetesFollowupDrugId,
            String diabetesFollowupId, String drugId, String drugName,
            String drugUsingFreq, String drugDoseUnit, String drugPerDose,
            String unit, Double drugTotalDose, String drugRouteCode) {
        this.diabetesFollowupDrugId = diabetesFollowupDrugId;
        this.diabetesFollowupId = diabetesFollowupId;
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugUsingFreq = drugUsingFreq;
        this.drugDoseUnit = drugDoseUnit;
        this.drugPerDose = drugPerDose;
        this.unit = unit;
        this.drugTotalDose = drugTotalDose;
        this.drugRouteCode = drugRouteCode;
    }

    @Generated(hash = 105135190)
    public DiabetesFollowupDrug() {
    }



}