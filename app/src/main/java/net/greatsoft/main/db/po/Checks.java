package net.greatsoft.main.db.po;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhanglin on 16/8/22.
 */
@Entity
public class Checks extends Entry {
    private String type; //checkBox的类型
    private String code; //选项的值
    private String value; //选项的中文名字
    private String isDefault; //是否是默认
    private String isOther; //是否是其他
    private Integer serialNumber; //没用
    public Integer getSerialNumber() {
        return this.serialNumber;
    }
    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }
    public String getIsOther() {
        return this.isOther;
    }
    public void setIsOther(String isOther) {
        this.isOther = isOther;
    }
    public String getIsDefault() {
        return this.isDefault;
    }
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
    public String getValue() {
        return this.value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Generated(hash = 689910196)
    public Checks(String type, String code, String value, String isDefault,
            String isOther, Integer serialNumber) {
        this.type = type;
        this.code = code;
        this.value = value;
        this.isDefault = isDefault;
        this.isOther = isOther;
        this.serialNumber = serialNumber;
    }
    @Generated(hash = 1863098628)
    public Checks() {
    }

    @Override
    public String toString() {
        return value;
    }
}
