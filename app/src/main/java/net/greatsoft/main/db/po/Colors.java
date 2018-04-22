package net.greatsoft.main.db.po;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhanglin on 16/9/26.
 */
@Entity
public class Colors {
    private String color;
    private String satic;
    private String type;
    private String isDefault;
    
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSatic() {
        return this.satic;
    }
    public void setSatic(String satic) {
        this.satic = satic;
    }
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getIsDefault() {
        return this.isDefault;
    }
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
    @Generated(hash = 1809374984)
    public Colors(String color, String satic, String type, String isDefault) {
        this.color = color;
        this.satic = satic;
        this.type = type;
        this.isDefault = isDefault;
    }
    @Generated(hash = 1618454045)
    public Colors() {
    }

}
