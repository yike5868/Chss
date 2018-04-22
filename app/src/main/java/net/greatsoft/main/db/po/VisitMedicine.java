package net.greatsoft.main.db.po;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class VisitMedicine extends Entry {

	private String VISIT_ID;
	
	private String MEDICINE_TIMES;// 使用次数
	
	private String MEDICINE_NAME;// 药品名称
	
	private String MEDICINE_DOSAGE;// 用量

	public String getMEDICINE_DOSAGE() {
		return this.MEDICINE_DOSAGE;
	}

	public void setMEDICINE_DOSAGE(String MEDICINE_DOSAGE) {
		this.MEDICINE_DOSAGE = MEDICINE_DOSAGE;
	}

	public String getMEDICINE_NAME() {
		return this.MEDICINE_NAME;
	}

	public void setMEDICINE_NAME(String MEDICINE_NAME) {
		this.MEDICINE_NAME = MEDICINE_NAME;
	}

	public String getMEDICINE_TIMES() {
		return this.MEDICINE_TIMES;
	}

	public void setMEDICINE_TIMES(String MEDICINE_TIMES) {
		this.MEDICINE_TIMES = MEDICINE_TIMES;
	}

	public String getVISIT_ID() {
		return this.VISIT_ID;
	}

	public void setVISIT_ID(String VISIT_ID) {
		this.VISIT_ID = VISIT_ID;
	}

	@Generated(hash = 314781811)
	public VisitMedicine(String VISIT_ID, String MEDICINE_TIMES,
			String MEDICINE_NAME, String MEDICINE_DOSAGE) {
		this.VISIT_ID = VISIT_ID;
		this.MEDICINE_TIMES = MEDICINE_TIMES;
		this.MEDICINE_NAME = MEDICINE_NAME;
		this.MEDICINE_DOSAGE = MEDICINE_DOSAGE;
	}

	@Generated(hash = 402544993)
	public VisitMedicine() {
	}


}
