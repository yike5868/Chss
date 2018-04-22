package net.greatsoft.main.rsp.obj;

import net.greatsoft.main.db.po.family.FamilyInfo;


/**
 * Created by zhanglin on 2016/12/2.
 */

public class FamilyRsp {

    DistrictsRsp district;

    FamilyInfo familyInfo;


    public FamilyInfo getFamilyInfo() {
        return familyInfo;
    }

    public void setFamilyInfo(FamilyInfo familyInfo) {
        this.familyInfo = familyInfo;
    }

    public DistrictsRsp getDistrict() {
        return district;
    }

    public void setDistrict(DistrictsRsp district) {
        this.district = district;
    }
}
