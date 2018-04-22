package net.greatsoft.main.db.po.exam;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 
 * @author AlphGo
 * @date 2016年6月25日 上午8:56:28 
 * @Description: 个人健康体检住院治疗情况实体
 *
 */
@Entity
public class HealthExamInhos extends Entry {

    /**
     * 个人健康体检ID
     */
    private String healthExamId;

    /**
     * 住院史类型代码
     */
    private String inhosHistoryTypeCode;

    /**
     * 入院日期/建床日期
     */
    private Date admissionDate;

    /**
     * 出院日期/撤床日期
     */
    private Date dischargeDate;

    /**
     * 原因
     */
    private String admissionReason;

    /**
     * 医疗机构名称
     */
    private String hospitalName;

    /**
     * 病案号
     */
    private String medicalRecordNo;

    public String getMedicalRecordNo() {
        return this.medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo;
    }

    public String getHospitalName() {
        return this.hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAdmissionReason() {
        return this.admissionReason;
    }

    public void setAdmissionReason(String admissionReason) {
        this.admissionReason = admissionReason;
    }

    public Date getDischargeDate() {
        return this.dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Date getAdmissionDate() {
        return this.admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getInhosHistoryTypeCode() {
        return this.inhosHistoryTypeCode;
    }

    public void setInhosHistoryTypeCode(String inhosHistoryTypeCode) {
        this.inhosHistoryTypeCode = inhosHistoryTypeCode;
    }

    public String getHealthExamId() {
        return this.healthExamId;
    }

    public void setHealthExamId(String healthExamId) {
        this.healthExamId = healthExamId;
    }

    @Generated(hash = 568500954)
    public HealthExamInhos(String healthExamId, String inhosHistoryTypeCode,
            Date admissionDate, Date dischargeDate, String admissionReason,
            String hospitalName, String medicalRecordNo) {
        this.healthExamId = healthExamId;
        this.inhosHistoryTypeCode = inhosHistoryTypeCode;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.admissionReason = admissionReason;
        this.hospitalName = hospitalName;
        this.medicalRecordNo = medicalRecordNo;
    }

    @Generated(hash = 547012929)
    public HealthExamInhos() {
    }

}