/*
 * $Id: SickChoiceMedicine.java 337 2016-06-27 14:19:09Z huangshuang $
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
public class SickChoiceMedicine extends Entry {
	/**
	 * PK
	 */
	private String sickChoiceMedicineId;

	/**
	 * 药品ID
	 */
	private String sickMedicineId;

	/**
	 * 疾病系统码(1糖尿病2高血压3精神病)
	 */
	private String sickCode;

	public String getSickCode() {
		return this.sickCode;
	}

	public void setSickCode(String sickCode) {
		this.sickCode = sickCode;
	}

	public String getSickMedicineId() {
		return this.sickMedicineId;
	}

	public void setSickMedicineId(String sickMedicineId) {
		this.sickMedicineId = sickMedicineId;
	}

	public String getSickChoiceMedicineId() {
		return this.sickChoiceMedicineId;
	}

	public void setSickChoiceMedicineId(String sickChoiceMedicineId) {
		this.sickChoiceMedicineId = sickChoiceMedicineId;
	}

	@Generated(hash = 679454988)
	public SickChoiceMedicine(String sickChoiceMedicineId, String sickMedicineId,
			String sickCode) {
		this.sickChoiceMedicineId = sickChoiceMedicineId;
		this.sickMedicineId = sickMedicineId;
		this.sickCode = sickCode;
	}

	@Generated(hash = 557134400)
	public SickChoiceMedicine() {
	}


}
