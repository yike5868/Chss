package net.greatsoft.main.rsp;

import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.db.po.districts.Districts;

import java.util.List;

/**
 * Created by zhanglin on 2017/2/14.
 */

public class FindCurrentUserDistrictsRsp extends FuResponse {
    private String name;
    private List<Districts> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Districts> getData() {
        return data;
    }

    public void setData(List<Districts> data) {
        this.data = data;
    }
}
