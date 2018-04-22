package net.greatsoft.main.db.po.districts;

import net.greatsoft.main.db.po.Entry;
import net.greatsoft.main.view.tree.TreeNodeId;
import net.greatsoft.main.view.tree.TreeNodeLabel;
import net.greatsoft.main.view.tree.TreeNodePid;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;

/**
 * Created by zhanglin on 16/8/12.
 */
@Entity
public class Districts extends Entry {

    /**
     * 区划ID
     */
    @TreeNodeId
    private String districtId;

    /**
     * 区划编码
     */
    private String districtCode;

    /**
     * 区划名称
     */
    @TreeNodeLabel
    private String districtName;

    /**
     * 区划级别
     */
    private Integer districtLevel;

    /**
     * 上级区划ID
     */
    @TreeNodePid
    private String parentId;

    /**
     * 拼音码
     */
    private String pym;

    /**
     * 省级区划ID
     */
    private String provinceId;

    /**
     * 省级区划名称
     */
    private String provinceName;

    /**
     * 市级区划ID
     */
    private String cityId;

    /**
     * 市级区划名称
     */
    private String cityName;

    /**
     * 县级区划ID
     */
    private String countyId;

    /**
     * 县级区划名称
     */
    private String countyName;

    /**
     * 乡镇区划ID
     */
    private String townId;

    /**
     * 乡镇区划名称
     */
    private String townName;

    /**
     * 村级区划ID
     */
    private String villageId;

    /**
     * 村级区划名称
     */
    private String villageName;

    @Transient
    private List<Districts> children;

    @Transient
    private List<Subdistricts> subDistrict;

    public List<Subdistricts> getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(List<Subdistricts> subDistrict) {
        this.subDistrict = subDistrict;
    }

    public List<Districts> getChildren() {
        return children;
    }

    public void setChildren(List<Districts> children) {
        this.children = children;
    }

    public String getVillageName() {
        return this.villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getVillageId() {
        return this.villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getTownName() {
        return this.townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getTownId() {
        return this.townId;
    }

    public void setTownId(String townId) {
        this.townId = townId;
    }

    public String getCountyName() {
        return this.countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyId() {
        return this.countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return this.cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getProvinceName() {
        return this.provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceId() {
        return this.provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getPym() {
        return this.pym;
    }

    public void setPym(String pym) {
        this.pym = pym;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getDistrictLevel() {
        return this.districtLevel;
    }

    public void setDistrictLevel(Integer districtLevel) {
        this.districtLevel = districtLevel;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictCode() {
        return this.districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictId() {
        return this.districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    @Generated(hash = 1261954920)
    public Districts(String districtId, String districtCode, String districtName,
            Integer districtLevel, String parentId, String pym, String provinceId,
            String provinceName, String cityId, String cityName, String countyId,
            String countyName, String townId, String townName, String villageId,
            String villageName) {
        this.districtId = districtId;
        this.districtCode = districtCode;
        this.districtName = districtName;
        this.districtLevel = districtLevel;
        this.parentId = parentId;
        this.pym = pym;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.cityId = cityId;
        this.cityName = cityName;
        this.countyId = countyId;
        this.countyName = countyName;
        this.townId = townId;
        this.townName = townName;
        this.villageId = villageId;
        this.villageName = villageName;
    }

    @Generated(hash = 635320084)
    public Districts() {
    }

   
}
