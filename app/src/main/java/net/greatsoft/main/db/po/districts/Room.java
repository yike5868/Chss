package net.greatsoft.main.db.po.districts;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 房间
 */
@Entity
public class Room extends Entry  {

	private String buildingUnitNo;
	private String buildingId;
	private String roomNumberNo;
	private String roomNumberId;
	private String floorNum;
	public String getFloorNum() {
		return this.floorNum;
	}
	public void setFloorNum(String floorNum) {
		this.floorNum = floorNum;
	}
	public String getRoomNumberId() {
		return this.roomNumberId;
	}
	public void setRoomNumberId(String roomNumberId) {
		this.roomNumberId = roomNumberId;
	}
	public String getRoomNumberNo() {
		return this.roomNumberNo;
	}
	public void setRoomNumberNo(String roomNumberNo) {
		this.roomNumberNo = roomNumberNo;
	}
	public String getBuildingId() {
		return this.buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingUnitNo() {
		return this.buildingUnitNo;
	}
	public void setBuildingUnitNo(String buildingUnitNo) {
		this.buildingUnitNo = buildingUnitNo;
	}
	@Generated(hash = 203769444)
	public Room(String buildingUnitNo, String buildingId, String roomNumberNo,
			String roomNumberId, String floorNum) {
		this.buildingUnitNo = buildingUnitNo;
		this.buildingId = buildingId;
		this.roomNumberNo = roomNumberNo;
		this.roomNumberId = roomNumberId;
		this.floorNum = floorNum;
	}
	@Generated(hash = 703125385)
	public Room() {
	}

	





}
