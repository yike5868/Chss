package net.greatsoft.main.db.po.exam;


import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年6月25日 上午8:56:57 
 * @Description: 个人健康体检住院用药情况实体
 *
 */
@Entity
public class HealthExamDrug extends Entry {
    /**
     * 个人健康体检ID
     */
    private String healthExamId;

    /**
     * 药物名称
     */
    private String drugName;

    /**
     * 用法代码，因历史数据原因，先存成中文
     */
    private String drugUsageCode;

    /**
     * 用量
     */
    private String drugDose;

    /**
     * 用药时间
     */
    private String drugTime;

    /**
     * 服药依从性
     */
    private String drugComplianceCode;
    
    /**
     * 服药依从性中文
     */
    private String drugComplianceValue;

    public String getDrugComplianceValue() {
        return this.drugComplianceValue;
    }

    public void setDrugComplianceValue(String drugComplianceValue) {
        this.drugComplianceValue = drugComplianceValue;
    }

    public String getDrugComplianceCode() {
        return this.drugComplianceCode;
    }

    public void setDrugComplianceCode(String drugComplianceCode) {
        this.drugComplianceCode = drugComplianceCode;
    }

    public String getDrugTime() {
        return this.drugTime;
    }

    public void setDrugTime(String drugTime) {
        this.drugTime = drugTime;
    }

    public String getDrugDose() {
        return this.drugDose;
    }

    public void setDrugDose(String drugDose) {
        this.drugDose = drugDose;
    }

    public String getDrugUsageCode() {
        return this.drugUsageCode;
    }

    public void setDrugUsageCode(String drugUsageCode) {
        this.drugUsageCode = drugUsageCode;
    }

    public String getDrugName() {
        return this.drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getHealthExamId() {
        return this.healthExamId;
    }

    public void setHealthExamId(String healthExamId) {
        this.healthExamId = healthExamId;
    }

    @Generated(hash = 1879681356)
    public HealthExamDrug(String healthExamId, String drugName,
            String drugUsageCode, String drugDose, String drugTime,
            String drugComplianceCode, String drugComplianceValue) {
        this.healthExamId = healthExamId;
        this.drugName = drugName;
        this.drugUsageCode = drugUsageCode;
        this.drugDose = drugDose;
        this.drugTime = drugTime;
        this.drugComplianceCode = drugComplianceCode;
        this.drugComplianceValue = drugComplianceValue;
    }

    @Generated(hash = 126303639)
    public HealthExamDrug() {
    }

}