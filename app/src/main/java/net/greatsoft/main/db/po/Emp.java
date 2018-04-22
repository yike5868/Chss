package net.greatsoft.main.db.po;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhanglin on 2016/12/5.
 */
@Entity
public class Emp {

    public String emp_id;
    /**
     * 姓名
     */
    public String emp_name;
    /**
     * 性别代码
     */
    public String emp_gender;
    /**
     * 人员属性
     */
    public String emp_property;
    /**
     * 是否是公卫人员
     */
    public String is_gw;
    /**
     * 身份证号码
     */
    public String emp_rin;
    /**
     * 手机号码
     */
    public String emp_mobile;
    /**
     * 专业技术职务类别
     */
    public String emp_title;
    /**
     * 出生日期
     */
    public String emp_birthday;
    /**
     * 人员状态
     */
    public String emp_status;
    public String getEmp_status() {
        return this.emp_status;
    }
    public void setEmp_status(String emp_status) {
        this.emp_status = emp_status;
    }
    public String getEmp_birthday() {
        return this.emp_birthday;
    }
    public void setEmp_birthday(String emp_birthday) {
        this.emp_birthday = emp_birthday;
    }
    public String getEmp_title() {
        return this.emp_title;
    }
    public void setEmp_title(String emp_title) {
        this.emp_title = emp_title;
    }
    public String getEmp_mobile() {
        return this.emp_mobile;
    }
    public void setEmp_mobile(String emp_mobile) {
        this.emp_mobile = emp_mobile;
    }
    public String getEmp_rin() {
        return this.emp_rin;
    }
    public void setEmp_rin(String emp_rin) {
        this.emp_rin = emp_rin;
    }
    public String getIs_gw() {
        return this.is_gw;
    }
    public void setIs_gw(String is_gw) {
        this.is_gw = is_gw;
    }
    public String getEmp_property() {
        return this.emp_property;
    }
    public void setEmp_property(String emp_property) {
        this.emp_property = emp_property;
    }
    public String getEmp_gender() {
        return this.emp_gender;
    }
    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
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
    @Generated(hash = 1027885905)
    public Emp(String emp_id, String emp_name, String emp_gender,
            String emp_property, String is_gw, String emp_rin, String emp_mobile,
            String emp_title, String emp_birthday, String emp_status) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_gender = emp_gender;
        this.emp_property = emp_property;
        this.is_gw = is_gw;
        this.emp_rin = emp_rin;
        this.emp_mobile = emp_mobile;
        this.emp_title = emp_title;
        this.emp_birthday = emp_birthday;
        this.emp_status = emp_status;
    }
    @Generated(hash = 2081885797)
    public Emp() {
    }

    @Override
    public String toString() {
        return emp_name;
    }
}
