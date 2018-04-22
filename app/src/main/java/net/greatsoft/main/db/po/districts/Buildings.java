package net.greatsoft.main.db.po.districts;


import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Buildings extends Entry{
	private String buildingId;
	private String buildingName;
	private String subDistrictId;
	private String userid;
	public String getUserid() {
		return this.userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSubDistrictId() {
		return this.subDistrictId;
	}
	public void setSubDistrictId(String subDistrictId) {
		this.subDistrictId = subDistrictId;
	}
	public String getBuildingName() {
		return this.buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getBuildingId() {
		return this.buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	@Generated(hash = 315063921)
	public Buildings(String buildingId, String buildingName, String subDistrictId,
			String userid) {
		this.buildingId = buildingId;
		this.buildingName = buildingName;
		this.subDistrictId = subDistrictId;
		this.userid = userid;
	}
	@Generated(hash = 1243294117)
	public Buildings() {
	}


}
