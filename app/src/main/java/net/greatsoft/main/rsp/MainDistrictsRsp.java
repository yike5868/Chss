package net.greatsoft.main.rsp;

import net.greatsoft.main.db.po.districts.Districts;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/3.
 */

public class MainDistrictsRsp {

    List<String> selectedItems;
    List<Districts> items;

    public List<String> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<String> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public List<Districts> getItems() {
        return items;
    }

    public void setItems(List<Districts> items) {
        this.items = items;
    }
}
