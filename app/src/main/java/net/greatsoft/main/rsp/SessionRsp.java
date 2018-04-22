package net.greatsoft.main.rsp;

import net.greatsoft.main.control.FuResponse;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhanglin on 2016/12/5.
 */
@Entity
public class SessionRsp extends FuResponse{
    /**
     * 所属机构id
     */
    public String pos_id;
    /**
     * 所属机构名称
     */
    public String pos_name;
    /**
     * 所属机构组织机构代码
     */
    public String pos_code;
    /**
     * 默认科室id
     */
    public String dept_id;
    /**
     * 默认科室名称
     */
    public String dept_name;
    /**
     * 人员id
     */
    public String emp_id;
    /**
     * 人员姓名
     */
    public String emp_name;
    /**
     * 区划id
     */
    public String district_id;
    /**
     * 区划名称
     */
    public String district_name;
    /**
     * 区划级别
     */
    public String district_level;
    /**
     * 是否是公卫人员
     */
    public String is_gw;
    /**
     * 身份证号码
     */
    public String emp_rin;
    /**
     * 性别
     */
    public String emp_gender;
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
     * 人员属性
     */
    public String emp_property;
    /**
     * 上级机构id
     */
    public String pos_pid;
    public String getPos_pid() {
        return this.pos_pid;
    }
    public void setPos_pid(String pos_pid) {
        this.pos_pid = pos_pid;
    }
    public String getEmp_property() {
        return this.emp_property;
    }
    public void setEmp_property(String emp_property) {
        this.emp_property = emp_property;
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
    public String getEmp_gender() {
        return this.emp_gender;
    }
    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
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
    public String getDistrict_level() {
        return this.district_level;
    }
    public void setDistrict_level(String district_level) {
        this.district_level = district_level;
    }
    public String getDistrict_name() {
        return this.district_name;
    }
    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }
    public String getDistrict_id() {
        return this.district_id;
    }
    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
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
    public String getDept_name() {
        return this.dept_name;
    }
    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
    public String getDept_id() {
        return this.dept_id;
    }
    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }
    public String getPos_code() {
        return this.pos_code;
    }
    public void setPos_code(String pos_code) {
        this.pos_code = pos_code;
    }
    public String getPos_name() {
        return this.pos_name;
    }
    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }
    public String getPos_id() {
        return this.pos_id;
    }
    public void setPos_id(String pos_id) {
        this.pos_id = pos_id;
    }
    @Generated(hash = 627630571)
    public SessionRsp(String pos_id, String pos_name, String pos_code,
            String dept_id, String dept_name, String emp_id, String emp_name,
            String district_id, String district_name, String district_level,
            String is_gw, String emp_rin, String emp_gender, String emp_mobile,
            String emp_title, String emp_birthday, String emp_property,
            String pos_pid) {
        this.pos_id = pos_id;
        this.pos_name = pos_name;
        this.pos_code = pos_code;
        this.dept_id = dept_id;
        this.dept_name = dept_name;
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.district_id = district_id;
        this.district_name = district_name;
        this.district_level = district_level;
        this.is_gw = is_gw;
        this.emp_rin = emp_rin;
        this.emp_gender = emp_gender;
        this.emp_mobile = emp_mobile;
        this.emp_title = emp_title;
        this.emp_birthday = emp_birthday;
        this.emp_property = emp_property;
        this.pos_pid = pos_pid;
    }
    @Generated(hash = 1855046529)
    public SessionRsp() {
    }



}
