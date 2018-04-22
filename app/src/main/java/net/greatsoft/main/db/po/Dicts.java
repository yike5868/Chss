package net.greatsoft.main.db.po;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhanglin on 2016/12/13.
 */
@Entity
public class Dicts extends Entry{
    private String dict_code;
    private String dict_id;
    private String dict_name;
    private String dict_version;
    public String getDict_version() {
        return this.dict_version;
    }
    public void setDict_version(String dict_version) {
        this.dict_version = dict_version;
    }
    public String getDict_name() {
        return this.dict_name;
    }
    public void setDict_name(String dict_name) {
        this.dict_name = dict_name;
    }
    public String getDict_id() {
        return this.dict_id;
    }
    public void setDict_id(String dict_id) {
        this.dict_id = dict_id;
    }
    public String getDict_code() {
        return this.dict_code;
    }
    public void setDict_code(String dict_code) {
        this.dict_code = dict_code;
    }
    @Generated(hash = 30920509)
    public Dicts(String dict_code, String dict_id, String dict_name,
            String dict_version) {
        this.dict_code = dict_code;
        this.dict_id = dict_id;
        this.dict_name = dict_name;
        this.dict_version = dict_version;
    }
    @Generated(hash = 1411214147)
    public Dicts() {
    }
}
