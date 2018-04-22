package net.greatsoft.main.db.po;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhanglin on 2017/1/18.
 */
@Entity
public class UpdateState extends Entry {
    /**
     * 表主键
     */
    private String tableKey;

    /**
     * 表类型 高血压糖尿病人员，家庭
     */

    private String tableType;

    /**
     * 上传状态
     * 0未上传 1已上传（删除本条记录）2 出错
     * 3 代表新增（家庭、人员） 4 出错
     */
    private Integer tableState;

    /**
     * 新增/修改
     */

    /**
     * 出错错误信息
     */
    private String tableReson;

    /**
     * 姓名
     */

    private String name;
    /**
     * 时间
     */
    private String time;

    

    public String getTableReson() {
        return this.tableReson;
    }

    public void setTableReson(String tableReson) {
        this.tableReson = tableReson;
    }

    public Integer getTableState() {
        return this.tableState;
    }

    public void setTableState(Integer tableState) {
        this.tableState = tableState;
    }

    public String getTableType() {
        return this.tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getTableKey() {
        return this.tableKey;
    }

    public void setTableKey(String tableKey) {
        this.tableKey = tableKey;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Generated(hash = 1038214909)
    public UpdateState(String tableKey, String tableType, Integer tableState,
                       String tableReson, String name, String time) {
        this.tableKey = tableKey;
        this.tableType = tableType;
        this.tableState = tableState;
        this.tableReson = tableReson;
        this.name = name;
        this.time = time;
    }

    @Generated(hash = 909631757)
    public UpdateState() {
    }

}
