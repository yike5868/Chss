package net.greatsoft.main.db.po.districts;

import java.io.Serializable;

/**
 * Created by zhanglin on 2016/11/16.
 */

public class RoomAll implements Serializable{
    private String districtId;      //地区
    private String districtName;
    private String subDistrictId;  //小区
    private String subDistrictName;
    private String buildingId;      // 楼
    private String buildingName;
    private String unitNo;          //  单元
    private String roomNum;         //房间

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getSubDistrictId() {
        return subDistrictId;
    }

    public void setSubDistrictId(String subDistrictId) {
        this.subDistrictId = subDistrictId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }


    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getSubDistrictName() {
        return subDistrictName;
    }

    public void setSubDistrictName(String subDistrictName) {
        this.subDistrictName = subDistrictName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
