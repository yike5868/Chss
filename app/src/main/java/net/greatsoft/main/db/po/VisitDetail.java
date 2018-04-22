package net.greatsoft.main.db.po;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年8月3日 上午11:20:56 
 * @Description: 随访复选信息
 *
 */
@Entity
public class VisitDetail extends Entry {


	private String VISIT_ID;
	
	private String TYPE;
	
	private String CODE;
	
	private String VALUE;
	
	private String ISOTHER;

	public String getISOTHER() {
		return this.ISOTHER;
	}

	public void setISOTHER(String ISOTHER) {
		this.ISOTHER = ISOTHER;
	}

	public String getVALUE() {
		return this.VALUE;
	}

	public void setVALUE(String VALUE) {
		this.VALUE = VALUE;
	}

	public String getCODE() {
		return this.CODE;
	}

	public void setCODE(String CODE) {
		this.CODE = CODE;
	}

	public String getTYPE() {
		return this.TYPE;
	}

	public void setTYPE(String TYPE) {
		this.TYPE = TYPE;
	}

	public String getVISIT_ID() {
		return this.VISIT_ID;
	}

	public void setVISIT_ID(String VISIT_ID) {
		this.VISIT_ID = VISIT_ID;
	}

	@Generated(hash = 1082654962)
	public VisitDetail(String VISIT_ID, String TYPE, String CODE, String VALUE,
			String ISOTHER) {
		this.VISIT_ID = VISIT_ID;
		this.TYPE = TYPE;
		this.CODE = CODE;
		this.VALUE = VALUE;
		this.ISOTHER = ISOTHER;
	}

	@Generated(hash = 324620336)
	public VisitDetail() {
	}


}
