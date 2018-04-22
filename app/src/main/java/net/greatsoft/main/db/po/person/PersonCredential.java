package net.greatsoft.main.db.po.person;


import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author :hn
 * @createDate:2016年6月3日
 * @description:个人证件表
 */
@Entity
public class PersonCredential extends Entry {
	/**
	 * 个人证件ID
	 */
	private String personCredentialId;

	/**
	 * 个人ID
	 */
	private String personInfoId;

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
	 * @return
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

	public String getPersonInfoId() {
		return this.personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getPersonCredentialId() {
		return this.personCredentialId;
	}

	public void setPersonCredentialId(String personCredentialId) {
		this.personCredentialId = personCredentialId;
	}

	@Generated(hash = 611855807)
	public PersonCredential(String personCredentialId, String personInfoId,
			String credentialTypeCode, String credentialNo, String credentialTypeValue) {
		this.personCredentialId = personCredentialId;
		this.personInfoId = personInfoId;
		this.credentialTypeCode = credentialTypeCode;
		this.credentialNo = credentialNo;
		this.credentialTypeValue = credentialTypeValue;
	}

	@Generated(hash = 333361630)
	public PersonCredential() {
	}


}