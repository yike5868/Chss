/*
 * $Id: codetemplates.xml 2918 2014-01-22 15:29:26Z hn $
 * 版权所有 2016 冠新软件。
 * 保留所有权利。
 */
package net.greatsoft.main.db.po.person;


import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author hn
 * @date 2016年6月18日 下午9:44:25 
 * @Description: 个人档案编号流水号		
 * 
 */
@Entity
public class PersonSerialNo extends Entry{

	/**
	 * 区划ID
	 */
	private String districtId;
	
	/**
	 * 流水号
	 */
	private Integer serialNo;

	public Integer getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	@Generated(hash = 2010900817)
	public PersonSerialNo(String districtId, Integer serialNo) {
		this.districtId = districtId;
		this.serialNo = serialNo;
	}

	@Generated(hash = 1314988426)
	public PersonSerialNo() {
	}


}
