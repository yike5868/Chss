package net.greatsoft.main.db.po.smi;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 
 * @author AlphGo
 * @date 2016年7月7日 下午7:22:30
 * @Description: 严重精神障碍患者随访用药数据模型
 *
 */
@Entity
public class SmiFollowupDrug extends Entry {
	/**
	 * 2型糖尿病随访信息用药ID
	 */
	private String smiFollowupDrugId;

	/**
	 * 2型糖尿病患者随访ID
	 */
	private String smiFollowupId;

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

	private String unit;

	/**
	 * 药物使用总剂量
	 */
	private Double drugTotalDose;

	/**
	 * 药物使用途径代码
	 */
	private String drugRouteCode;

	/**
	 * 类型1.用药情况2.用药指导（第三版规范添加）
	 */
	private String drugType;

	public String getDrugType() {
		return drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}

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

	public String getSmiFollowupId() {
		return this.smiFollowupId;
	}

	public void setSmiFollowupId(String smiFollowupId) {
		this.smiFollowupId = smiFollowupId;
	}

	public String getSmiFollowupDrugId() {
		return this.smiFollowupDrugId;
	}

	public void setSmiFollowupDrugId(String smiFollowupDrugId) {
		this.smiFollowupDrugId = smiFollowupDrugId;
	}

	@Generated(hash = 1479347857)
	public SmiFollowupDrug(String smiFollowupDrugId, String smiFollowupId,
			String drugId, String drugName, String drugUsingFreq, String drugDoseUnit,
			String drugPerDose, String unit, Double drugTotalDose, String drugRouteCode,
			String drugType) {
		this.smiFollowupDrugId = smiFollowupDrugId;
		this.smiFollowupId = smiFollowupId;
		this.drugId = drugId;
		this.drugName = drugName;
		this.drugUsingFreq = drugUsingFreq;
		this.drugDoseUnit = drugDoseUnit;
		this.drugPerDose = drugPerDose;
		this.unit = unit;
		this.drugTotalDose = drugTotalDose;
		this.drugRouteCode = drugRouteCode;
		this.drugType = drugType;
	}

	@Generated(hash = 1391301701)
	public SmiFollowupDrug() {
	}

}