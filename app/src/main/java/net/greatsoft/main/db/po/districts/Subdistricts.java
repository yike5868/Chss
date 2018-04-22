package net.greatsoft.main.db.po.districts;


import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Subdistricts extends Entry {
	private String districtId;
	private String subDistrictId;
	private String subDistrictName;
	private String userid;
	public String getUserid() {
		return this.userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSubDistrictName() {
		return this.subDistrictName;
	}
	public void setSubDistrictName(String subDistrictName) {
		this.subDistrictName = subDistrictName;
	}
	public String getSubDistrictId() {
		return this.subDistrictId;
	}
	public void setSubDistrictId(String subDistrictId) {
		this.subDistrictId = subDistrictId;
	}
	public String getDistrictId() {
		return this.districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	@Generated(hash = 1088847272)
	public Subdistricts(String districtId, String subDistrictId,
			String subDistrictName, String userid) {
		this.districtId = districtId;
		this.subDistrictId = subDistrictId;
		this.subDistrictName = subDistrictName;
		this.userid = userid;
	}
	@Generated(hash = 1505134374)
	public Subdistricts() {
	}



}
