package net.greatsoft.main.db.po;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhanglin on 2016/12/13.
 * 字典
 */
@Entity
public class Term {
    private String term_version;
    private String term_pinyin;
    private String term_name;
    private String term_priority;
    private String term_code;
    private String dict_code;
    public String getDict_code() {
        return this.dict_code;
    }
    public void setDict_code(String dict_code) {
        this.dict_code = dict_code;
    }
    public String getTerm_code() {
        return this.term_code;
    }
    public void setTerm_code(String term_code) {
        this.term_code = term_code;
    }
    public String getTerm_priority() {
        return this.term_priority;
    }
    public void setTerm_priority(String term_priority) {
        this.term_priority = term_priority;
    }
    public String getTerm_name() {
        return this.term_name;
    }
    public void setTerm_name(String term_name) {
        this.term_name = term_name;
    }
    public String getTerm_pinyin() {
        return this.term_pinyin;
    }
    public void setTerm_pinyin(String term_pinyin) {
        this.term_pinyin = term_pinyin;
    }
    public String getTerm_version() {
        return this.term_version;
    }
    public void setTerm_version(String term_version) {
        this.term_version = term_version;
    }
    @Generated(hash = 165153449)
    public Term(String term_version, String term_pinyin, String term_name,
            String term_priority, String term_code, String dict_code) {
        this.term_version = term_version;
        this.term_pinyin = term_pinyin;
        this.term_name = term_name;
        this.term_priority = term_priority;
        this.term_code = term_code;
        this.dict_code = dict_code;
    }
    @Generated(hash = 142182234)
    public Term() {
    }
    @Override
    public String toString() {
        return term_name;
    }

}
