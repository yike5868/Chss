package net.greatsoft.main.db.po.diabetes;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 
 * @author hn
 * @date 2016年7月7日 下午1:10:02 
 * @Description: 2型糖尿病患者专档并发症
 *
 */
@Entity
public class DiabetesInfoComp extends Entry {
    /**
     * 2型糖尿病患者专档并发症ID
     */
    private String diabetesInfoCompId;

    /**
     * 2型糖尿病患者专档ID
     */
    private String diabetesInfoId;

    /**
     * 并发症疾病ID
     */
    private String complicationId;
    
    /**
     * 并发症疾病名称
     */
    private String complication;

    /**
     * 目前情况：1无2有
     */
    private String currentSituation;

    /**
     * 诊断时间
     */
    private Date diagnoseDate;

    /**
     * 目前治疗方式
     */
    private String treatmentMethod;

    public String getTreatmentMethod() {
        return this.treatmentMethod;
    }

    public void setTreatmentMethod(String treatmentMethod) {
        this.treatmentMethod = treatmentMethod;
    }

    public Date getDiagnoseDate() {
        return this.diagnoseDate;
    }

    public void setDiagnoseDate(Date diagnoseDate) {
        this.diagnoseDate = diagnoseDate;
    }

    public String getCurrentSituation() {
        return this.currentSituation;
    }

    public void setCurrentSituation(String currentSituation) {
        this.currentSituation = currentSituation;
    }

    public String getComplication() {
        return this.complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    public String getComplicationId() {
        return this.complicationId;
    }

    public void setComplicationId(String complicationId) {
        this.complicationId = complicationId;
    }

    public String getDiabetesInfoId() {
        return this.diabetesInfoId;
    }

    public void setDiabetesInfoId(String diabetesInfoId) {
        this.diabetesInfoId = diabetesInfoId;
    }

    public String getDiabetesInfoCompId() {
        return this.diabetesInfoCompId;
    }

    public void setDiabetesInfoCompId(String diabetesInfoCompId) {
        this.diabetesInfoCompId = diabetesInfoCompId;
    }

    @Generated(hash = 595763919)
    public DiabetesInfoComp(String diabetesInfoCompId, String diabetesInfoId,
            String complicationId, String complication, String currentSituation,
            Date diagnoseDate, String treatmentMethod) {
        this.diabetesInfoCompId = diabetesInfoCompId;
        this.diabetesInfoId = diabetesInfoId;
        this.complicationId = complicationId;
        this.complication = complication;
        this.currentSituation = currentSituation;
        this.diagnoseDate = diagnoseDate;
        this.treatmentMethod = treatmentMethod;
    }

    @Generated(hash = 303361588)
    public DiabetesInfoComp() {
    }



}