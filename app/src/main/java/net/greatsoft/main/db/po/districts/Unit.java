package net.greatsoft.main.db.po.districts;

import net.greatsoft.main.db.po.Entry;

/**
 * Created by zhanglin on 2016/12/1.
 */

public class Unit extends Entry{
    private String buildingUnitNo;

    private String buildingUnitName;

    public String getBuildingUnitNo() {
        return buildingUnitNo;
    }

    public void setBuildingUnitNo(String buildingUnitNo) {
        this.buildingUnitNo = buildingUnitNo;
    }

    public String getBuildingUnitName() {
        return buildingUnitName;
    }

    public void setBuildingUnitName(String buildingUnitName) {
        this.buildingUnitName = buildingUnitName;
    }
}
