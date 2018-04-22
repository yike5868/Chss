package net.greatsoft.main.db.po.vaccine;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年8月16日 上午11:23:53 
 * @Description: 机构选择的疫苗
 *
 */
@Entity
public class OrgChoiceVaccine extends Entry{

    /**
     * 机构选择的疫苗ID
     */
    private String orgChoiceVaccineId;

    /**
     * 疫苗流水号
     */
    private String vaccineId;
    
    /**
     * 机构ID
     */
    private String orgId;

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getVaccineId() {
        return this.vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getOrgChoiceVaccineId() {
        return this.orgChoiceVaccineId;
    }

    public void setOrgChoiceVaccineId(String orgChoiceVaccineId) {
        this.orgChoiceVaccineId = orgChoiceVaccineId;
    }

    @Generated(hash = 2031981532)
    public OrgChoiceVaccine(String orgChoiceVaccineId, String vaccineId,
            String orgId) {
        this.orgChoiceVaccineId = orgChoiceVaccineId;
        this.vaccineId = vaccineId;
        this.orgId = orgId;
    }

    @Generated(hash = 871825768)
    public OrgChoiceVaccine() {
    }

}