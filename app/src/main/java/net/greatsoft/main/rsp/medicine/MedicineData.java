package net.greatsoft.main.rsp.medicine;

import net.greatsoft.main.db.po.SickMedicine;

import java.util.List;

/**
 * Created by zhanglin on 2016/12/4.
 */

public class MedicineData {
    List<SickMedicine> hyper;
    List<SickMedicine> diabetes;
    List<SickMedicine> smi;
    List<SickMedicine> ca;//脑卒中
    List<SickMedicine> chd;//冠心病

    public List<SickMedicine> getCa() {
        return ca;
    }

    public void setCa(List<SickMedicine> ca) {
        this.ca = ca;
    }

    public List<SickMedicine> getChd() {
        return chd;
    }

    public void setChd(List<SickMedicine> chd) {
        this.chd = chd;
    }

    public List<SickMedicine> getHyper() {
        return hyper;
    }

    public void setHyper(List<SickMedicine> hyper) {
        this.hyper = hyper;
    }

    public List<SickMedicine> getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(List<SickMedicine> diabetes) {
        this.diabetes = diabetes;
    }

    public List<SickMedicine> getSmi() {
        return smi;
    }

    public void setSmi(List<SickMedicine> smi) {
        this.smi = smi;
    }
}
