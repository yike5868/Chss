package net.greatsoft.main.rsp;

import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.rsp.medicine.MedicineData;

/**
 * Created by zhanglin on 2016/12/4.
 */

public class MedicineListRsp extends FuResponse{

    String name;
    String code;
    MedicineData data;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public MedicineData getData() {
        return data;
    }

    public void setData(MedicineData data) {
        this.data = data;
    }
}
