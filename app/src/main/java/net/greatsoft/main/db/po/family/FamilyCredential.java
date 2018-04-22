package net.greatsoft.main.db.po.family;


import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author :hn
 * @createDate:2016年5月31日
 * @description:家庭有效证件表
 */
@Entity
public class FamilyCredential extends Entry{

	/**
	 *家庭证件ID
	 */
    private String familyCredentialId;

	/**
	 * 家庭档案ID
	 */
    private String familyInfoId;

    /**
     * 证件类型代码
     */
    private String credentialTypeCode;

    /**
     * 证件号码
     */
    private String credentialNo;

    /**
     * 证件类型名称
     */
    private String credentialTypeValue;

    public String getCredentialTypeValue() {
        return this.credentialTypeValue;
    }

    public void setCredentialTypeValue(String credentialTypeValue) {
        this.credentialTypeValue = credentialTypeValue;
    }

    public String getCredentialNo() {
        return this.credentialNo;
    }

    public void setCredentialNo(String credentialNo) {
        this.credentialNo = credentialNo;
    }

    public String getCredentialTypeCode() {
        return this.credentialTypeCode;
    }

    public void setCredentialTypeCode(String credentialTypeCode) {
        this.credentialTypeCode = credentialTypeCode;
    }

    public String getFamilyInfoId() {
        return this.familyInfoId;
    }

    public void setFamilyInfoId(String familyInfoId) {
        this.familyInfoId = familyInfoId;
    }

    public String getFamilyCredentialId() {
        return this.familyCredentialId;
    }

    public void setFamilyCredentialId(String familyCredentialId) {
        this.familyCredentialId = familyCredentialId;
    }

    @Generated(hash = 31983842)
    public FamilyCredential(String familyCredentialId, String familyInfoId,
            String credentialTypeCode, String credentialNo,
            String credentialTypeValue) {
        this.familyCredentialId = familyCredentialId;
        this.familyInfoId = familyInfoId;
        this.credentialTypeCode = credentialTypeCode;
        this.credentialNo = credentialNo;
        this.credentialTypeValue = credentialTypeValue;
    }

    @Generated(hash = 1593389421)
    public FamilyCredential() {
    }


}