package net.greatsoft.main.db.po;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhanglin on 16/8/29.
 */
@Entity
public class Doctor {

    private String emp_id;
    private String emp_name;
    private String is_gw;
    public String getIs_gw() {
        return this.is_gw;
    }
    public void setIs_gw(String is_gw) {
        this.is_gw = is_gw;
    }
    public String getEmp_name() {
        return this.emp_name;
    }
    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }
    public String getEmp_id() {
        return this.emp_id;
    }
    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }
    @Generated(hash = 1368386655)
    public Doctor(String emp_id, String emp_name, String is_gw) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.is_gw = is_gw;
    }
    @Generated(hash = 73626718)
    public Doctor() {
    }

}
