package net.greatsoft.main.db.po;

import com.alibaba.fastjson.annotation.JSONField;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

import java.util.Date;

/**
 * 
 * @author :hn
 * @createDate:2016年5月31日
 * @description:保存多选项的记录				
 */
@Entity
public class RecordChoice extends Entry{

	/**
	 * 表主键
	 */
	private String tableKey;
	
	/**
	 * 代码类型代码
	 */
    private String codeType;

    /**
     * 与本人关系代码
     */
    private String relationCode;

    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 初始时间
     */
    @JSONField(format="yyyy-MM-dd")
    private Date initDate;

    /**
     * 结束时间
     */
    @JSONField(format="yyyy-MM-dd")
    private Date endDate;

    /**
     * 备注
     */
    private String remark;

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getInitDate() {
        return this.initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRelationCode() {
        return this.relationCode;
    }

    public void setRelationCode(String relationCode) {
        this.relationCode = relationCode;
    }

    public String getCodeType() {
        return this.codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getTableKey() {
        return this.tableKey;
    }

    public void setTableKey(String tableKey) {
        this.tableKey = tableKey;
    }

    @Generated(hash = 392623754)
    public RecordChoice(String tableKey, String codeType, String relationCode,
            String code, String name, Date initDate, Date endDate, String remark) {
        this.tableKey = tableKey;
        this.codeType = codeType;
        this.relationCode = relationCode;
        this.code = code;
        this.name = name;
        this.initDate = initDate;
        this.endDate = endDate;
        this.remark = remark;
    }

    @Generated(hash = 924559894)
    public RecordChoice() {
    }



}