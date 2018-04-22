package net.greatsoft.main.rsp;

import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.db.po.Dicts;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/13.
 */

public class DictsRsp  extends FuResponse {
    List<Dicts> dictsList;

    public List<Dicts> getDictsList() {
        return dictsList;
    }

    public void setDictsList(List<Dicts> dictsList) {
        this.dictsList = dictsList;
    }
}
