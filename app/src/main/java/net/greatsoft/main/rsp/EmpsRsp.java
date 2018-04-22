package net.greatsoft.main.rsp;

import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.db.po.Emp;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/5.
 */

public class EmpsRsp extends FuResponse{
    List<Emp> empList;

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }
}
