package net.greatsoft.main.rsp.obj;

import net.greatsoft.main.db.po.districts.Buildings;
import net.greatsoft.main.db.po.districts.Districts;
import net.greatsoft.main.db.po.districts.Room;
import net.greatsoft.main.db.po.districts.Subdistricts;
import net.greatsoft.main.db.po.districts.Unit;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/3.
 */

public class DistrictsRsp {

    private List<Districts>  district;
    private List<Subdistricts> subDistrict;
    private List<Buildings> building;
    private List<Unit> unit;
    private List<Room> roomNumber;

    public List<Unit> getUnit() {
        return unit;
    }

    public void setUnit(List<Unit> unit) {
        this.unit = unit;
    }

    public List<Districts> getDistrict() {
        return district;
    }

    public void setDistrict(List<Districts> district) {
        this.district = district;
    }

    public List<Subdistricts> getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(List<Subdistricts> subDistrict) {
        this.subDistrict = subDistrict;
    }

    public List<Buildings> getBuilding() {
        return building;
    }

    public void setBuilding(List<Buildings> building) {
        this.building = building;
    }

    public List<Room> getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(List<Room> roomNumber) {
        this.roomNumber = roomNumber;
    }
}
