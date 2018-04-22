package net.greatsoft.main.db.po.person;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author :hn
 * @createDate:2016年6月3日
 * @description:个人档案地址信息表
 */
@Entity
public class PersonAddress extends Entry{
    /**
     * 个人地址ID
     */
    private String personAddressId;
    /**
     * 地址类别代码
     */
    private String addressTypeCode;

    /**
     * 省（自治区、直辖市）
     */
    private String province;

    /**
     * 市（地区、州）
     */
    private String city;

    /**
     * 县（区）
     */
    private String county;

    /**
     * 乡（镇、街道办事处）
     */
    private String town;

    /**
     * 村（街、路、弄等）
     */
    private String village;

    /**
     * 门牌号码
     */
    private String houseNo;

    /**
     * 邮政编码
     */
    private String postalCode;
    
    /**
     * 个人档案ID
     */
    private String personInfoId;

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getHouseNo() {
        return this.houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getVillage() {
        return this.village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return this.county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddressTypeCode() {
        return this.addressTypeCode;
    }

    public void setAddressTypeCode(String addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    public String getPersonAddressId() {
        return this.personAddressId;
    }

    public void setPersonAddressId(String personAddressId) {
        this.personAddressId = personAddressId;
    }

    @Generated(hash = 370462890)
    public PersonAddress(String personAddressId, String addressTypeCode,
            String province, String city, String county, String town,
            String village, String houseNo, String postalCode, String personInfoId) {
        this.personAddressId = personAddressId;
        this.addressTypeCode = addressTypeCode;
        this.province = province;
        this.city = city;
        this.county = county;
        this.town = town;
        this.village = village;
        this.houseNo = houseNo;
        this.postalCode = postalCode;
        this.personInfoId = personInfoId;
    }

    @Generated(hash = 834017599)
    public PersonAddress() {
    }


}