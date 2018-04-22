/*
 * $Id: codetemplates.xml 2918 2014-01-22 15:29:26Z hn $
 * 版权所有 2016 冠新软件。
 * 保留所有权利。
 */
package net.greatsoft.main.db.po.hyperinfo;


import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author hn
 * @date 2016年6月24日 下午5:13:42
 * @Description: 高血压患者随访信息用药表
 *
 */
@Entity
public class HyperFollowupDrug extends Entry {
    /**
     * 高血压患者随访用药ID
     */
    private String hyperFollowupDrugId;

    /**
     * 高血压患者随访ID
     */
    private String hyperFollowupId;

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
     * 药物使用剂量单位
     */
    private String unit;

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

    public String getHyperFollowupId() {
        return this.hyperFollowupId;
    }

    public void setHyperFollowupId(String hyperFollowupId) {
        this.hyperFollowupId = hyperFollowupId;
    }

    public String getHyperFollowupDrugId() {
        return this.hyperFollowupDrugId;
    }

    public void setHyperFollowupDrugId(String hyperFollowupDrugId) {
        this.hyperFollowupDrugId = hyperFollowupDrugId;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Generated(hash = 262618508)
    public HyperFollowupDrug(String hyperFollowupDrugId, String hyperFollowupId,
            String drugId, String drugName, String drugUsingFreq, String drugDoseUnit,
            String unit, String drugPerDose, Double drugTotalDose, String drugRouteCode) {
        this.hyperFollowupDrugId = hyperFollowupDrugId;
        this.hyperFollowupId = hyperFollowupId;
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugUsingFreq = drugUsingFreq;
        this.drugDoseUnit = drugDoseUnit;
        this.unit = unit;
        this.drugPerDose = drugPerDose;
        this.drugTotalDose = drugTotalDose;
        this.drugRouteCode = drugRouteCode;
    }

    @Generated(hash = 937898385)
    public HyperFollowupDrug() {
    }



}