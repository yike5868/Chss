package net.greatsoft.main.db.po.person;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author hn
 * @date 2016年6月14日 上午12:44:06 
 * @Description: 既往史疾病表
 */

@Entity
public class PersonDisease extends Entry{
    /**
     * 既往史疾病ID
     */
    private String personDiseaseId;

    /**
     * 个人档案ID
     */
    private String personInfoId;

    /**
     * 疾病代码
     */
    private String diseaseCode;

    /**
     * 疾病名称
     */
    private String diseaseName;

    /**
     *确诊年月
     */
    private Integer confirmDate;

    public Integer getConfirmDate() {
        return this.confirmDate;
    }

    public void setConfirmDate(Integer confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getDiseaseName() {
        return this.diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseCode() {
        return this.diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getPersonDiseaseId() {
        return this.personDiseaseId;
    }

    public void setPersonDiseaseId(String personDiseaseId) {
        this.personDiseaseId = personDiseaseId;
    }

    @Generated(hash = 1261201065)
    public PersonDisease(String personDiseaseId, String personInfoId,
            String diseaseCode, String diseaseName, Integer confirmDate) {
        this.personDiseaseId = personDiseaseId;
        this.personInfoId = personInfoId;
        this.diseaseCode = diseaseCode;
        this.diseaseName = diseaseName;
        this.confirmDate = confirmDate;
    }

    @Generated(hash = 477843968)
    public PersonDisease() {
    }
    
}