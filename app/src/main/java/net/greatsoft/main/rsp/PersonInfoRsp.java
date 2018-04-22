package net.greatsoft.main.rsp;

import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.db.po.person.PersonInfo;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/1.
 */

public class PersonInfoRsp {

    private Integer total;
    private Integer pageNo;
    private Integer pages;
    private Integer pageSize;
    private List<PersonInfo> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<PersonInfo> getRows() {
        return rows;
    }

    public void setRows(List<PersonInfo> rows) {
        this.rows = rows;
    }
}
