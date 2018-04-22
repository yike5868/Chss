package net.greatsoft.main.db.po.exam;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年6月25日 上午8:57:15 
 * @Description: 个人健康体检非免疫规划预防接种史实体
 *
 */
@Entity
public class HealthExamNoplanVacc extends Entry {

    /**
     * 个人健康体检ID
     */
    private String healthExamId;

    /**
     * 表内顺序
     */
    private Integer ssn;

    /**
     * 疫苗名称代码
     */
    private String vaccineCode;

    /**
     * 疫苗接种日期
     */
    private Date vaccinationDate;

    /**
     * 疫苗接种单位名称
     */
    private String vaccinationOrgName;

    public String getVaccinationOrgName() {
        return this.vaccinationOrgName;
    }

    public void setVaccinationOrgName(String vaccinationOrgName) {
        this.vaccinationOrgName = vaccinationOrgName;
    }

    public Date getVaccinationDate() {
        return this.vaccinationDate;
    }

    public void setVaccinationDate(Date vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String getVaccineCode() {
        return this.vaccineCode;
    }

    public void setVaccineCode(String vaccineCode) {
        this.vaccineCode = vaccineCode;
    }

    public Integer getSsn() {
        return this.ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public String getHealthExamId() {
        return this.healthExamId;
    }

    public void setHealthExamId(String healthExamId) {
        this.healthExamId = healthExamId;
    }

    @Generated(hash = 570055932)
    public HealthExamNoplanVacc(String healthExamId, Integer ssn,
            String vaccineCode, Date vaccinationDate, String vaccinationOrgName) {
        this.healthExamId = healthExamId;
        this.ssn = ssn;
        this.vaccineCode = vaccineCode;
        this.vaccinationDate = vaccinationDate;
        this.vaccinationOrgName = vaccinationOrgName;
    }

    @Generated(hash = 262572979)
    public HealthExamNoplanVacc() {
    }
}