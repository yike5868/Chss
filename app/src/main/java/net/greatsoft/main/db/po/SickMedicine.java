/*
 * $Id: SickMedicine.java 1103 2016-08-04 09:59:18Z huliangyin $
 * 版权所有 2016 冠新软件。
 * 保留所有权利。
 */
package net.greatsoft.main.db.po;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author HS
 * @date 2016年6月27日 下午8:16:10
 * @Description: 重症患者常用药品
 * 
 */
@Entity
public class SickMedicine extends Entry {

	/**
	 * 药品ID VARCHAR2(36)
	 */
	private String sickMedicineId;

	/**
	 * 药品名称 VARCHAR2(50)
	 */
	private String name;

	/**
	 * 药品编码 VARCHAR2(20)
	 */
	private String code;

	/**
	 * 拼音码 VARCHAR2(50)
	 */
	private String pym;

	/**
	 * 五笔码 VARCHAR2(50)
	 */
	private String wbm;

	/**
	 * 有效标志(0无效1有效) VARCHAR2(3)
	 */
	private String isValid;

	/**
	 * 是否删除 0：正常，1：删除 
	 */
	private Integer isCancel;

	/**
	 * 每次剂量 VARCHAR2(50)
	 */
	private String medicineDose;

	/**
	 * 类型
	 * 糖尿病1 高血压2  精神病3
     */

	private String type;

	/**
	 * 单位 VARCHAR2(50)
	 */
	private String unit;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMedicineDose() {
		return this.medicineDose;
	}

	public void setMedicineDose(String medicineDose) {
		this.medicineDose = medicineDose;
	}

	public Integer getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(Integer isCancel) {
		this.isCancel = isCancel;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getWbm() {
		return this.wbm;
	}

	public void setWbm(String wbm) {
		this.wbm = wbm;
	}

	public String getPym() {
		return this.pym;
	}

	public void setPym(String pym) {
		this.pym = pym;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSickMedicineId() {
		return this.sickMedicineId;
	}

	public void setSickMedicineId(String sickMedicineId) {
		this.sickMedicineId = sickMedicineId;
	}

	@Generated(hash = 1402576827)
	public SickMedicine(String sickMedicineId, String name, String code,
			String pym, String wbm, String isValid, Integer isCancel,
			String medicineDose, String type, String unit) {
		this.sickMedicineId = sickMedicineId;
		this.name = name;
		this.code = code;
		this.pym = pym;
		this.wbm = wbm;
		this.isValid = isValid;
		this.isCancel = isCancel;
		this.medicineDose = medicineDose;
		this.type = type;
		this.unit = unit;
	}

	@Generated(hash = 1396898657)
	public SickMedicine() {
	}

	@Override
	public String toString() {
		return name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
