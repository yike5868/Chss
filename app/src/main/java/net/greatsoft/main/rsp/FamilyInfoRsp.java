package net.greatsoft.main.rsp;

import net.greatsoft.main.db.po.family.FamilyInfo;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/1.
 */

public class FamilyInfoRsp {

    private Integer total;
    private Integer pageNo;
    private Integer pages;
    private Integer pageSize;
    private List<FamilyInfo> rows;

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

    public List<FamilyInfo> getRows() {
        return rows;
    }

    public void setRows(List<FamilyInfo> rows) {
        this.rows = rows;
    }
}
