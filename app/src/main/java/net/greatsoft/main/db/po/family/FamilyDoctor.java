package net.greatsoft.main.db.po.family;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 
 * @author :hn
 * @createDate:2016年5月31日
 * @description:家庭医生签约记录				
 */
@Entity
public class FamilyDoctor extends Entry{

	/**
	 * 家庭医生签约ID
	 */

    private String familyDoctorId;

	/**
	 * 家庭ID
	 */
    private String familyId;

    /**
     * 家庭签约医生团队ID
     */
    private String familyDoctorTeamId;

    /**
     * 起始日期
     */
    private Date startDate;

    /**
     * 终止日期
     */
    private Date endDate;

    /**
     * 家庭签约人
     */
    private String familyContractor;

    /**
     * 机构签约人
     */
    private String orgContractor;

    /**
     * 签约方式代码
     */
    private String contractModeCode;

    public String getContractModeCode() {
        return this.contractModeCode;
    }

    public void setContractModeCode(String contractModeCode) {
        this.contractModeCode = contractModeCode;
    }

    public String getOrgContractor() {
        return this.orgContractor;
    }

    public void setOrgContractor(String orgContractor) {
        this.orgContractor = orgContractor;
    }

    public String getFamilyContractor() {
        return this.familyContractor;
    }

    public void setFamilyContractor(String familyContractor) {
        this.familyContractor = familyContractor;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getFamilyDoctorTeamId() {
        return this.familyDoctorTeamId;
    }

    public void setFamilyDoctorTeamId(String familyDoctorTeamId) {
        this.familyDoctorTeamId = familyDoctorTeamId;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getFamilyDoctorId() {
        return this.familyDoctorId;
    }

    public void setFamilyDoctorId(String familyDoctorId) {
        this.familyDoctorId = familyDoctorId;
    }

    @Generated(hash = 1425131577)
    public FamilyDoctor(String familyDoctorId, String familyId,
            String familyDoctorTeamId, Date startDate, Date endDate,
            String familyContractor, String orgContractor, String contractModeCode) {
        this.familyDoctorId = familyDoctorId;
        this.familyId = familyId;
        this.familyDoctorTeamId = familyDoctorTeamId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.familyContractor = familyContractor;
        this.orgContractor = orgContractor;
        this.contractModeCode = contractModeCode;
    }

    @Generated(hash = 1911220225)
    public FamilyDoctor() {
    }


}