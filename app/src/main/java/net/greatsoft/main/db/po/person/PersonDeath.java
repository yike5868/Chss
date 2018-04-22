package net.greatsoft.main.db.po.person;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;


/**
 * 
 * @author hn
 * @date 2016年8月10日 下午7:26:57 
 * @Description: 死亡登记				
 *
 */
@Entity
public class PersonDeath extends Entry {

	/**
	 * 主键
	 */

	private String personDeathId;
	/**
	 * 个人档案ID
	 */
	private String personInfoId;
	
	/**
	 * 死亡日期
	 */
	private Date deathDate;

	/**
	 * 死亡地点
	 */
	private String deathAddress;
	
	/**
	 * 死亡原因
	 */
	private String deathReason;

	/**
	 * 申报人
	 */
	private String reportMan;

	/**
	 * 联系方式
	 */
	private String reportContact;
	
	/**
	 * 是否删除
	 */
	private Integer isCancel;
	
	/**
	 * 建档机构ID
	 */
	private String createOrgId;

	/**
	 * 建档机构名称
	 */
	private String orgName;

	/**
	 * 建档人ID
	 */
	private String creatorId;

	/**
	 * 建档人姓名
	 */
	private String creator;

	/**
	 * 建档时间
	 */
	private Date createTime;

	/**
	 * 最后更新机构ID
	 */
	private String modifiedOrgId;

	/**
	 * 最后更新机构名称
	 */
	private String modifiedOrgName;

	/**
	 * 最后更新人ID
	 */
	private String modifierId;

	/**
	 * 最后更新人姓名
	 */
	private String modifier;

	/**
	 * 最后更新时间
	 */
	private Date modifiedTime;

	public Date getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getModifier() {
		return this.modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModifierId() {
		return this.modifierId;
	}

	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}

	public String getModifiedOrgName() {
		return this.modifiedOrgName;
	}

	public void setModifiedOrgName(String modifiedOrgName) {
		this.modifiedOrgName = modifiedOrgName;
	}

	public String getModifiedOrgId() {
		return this.modifiedOrgId;
	}

	public void setModifiedOrgId(String modifiedOrgId) {
		this.modifiedOrgId = modifiedOrgId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getCreateOrgId() {
		return this.createOrgId;
	}

	public void setCreateOrgId(String createOrgId) {
		this.createOrgId = createOrgId;
	}

	public Integer getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(Integer isCancel) {
		this.isCancel = isCancel;
	}

	public String getReportContact() {
		return this.reportContact;
	}

	public void setReportContact(String reportContact) {
		this.reportContact = reportContact;
	}

	public String getReportMan() {
		return this.reportMan;
	}

	public void setReportMan(String reportMan) {
		this.reportMan = reportMan;
	}

	public String getDeathReason() {
		return this.deathReason;
	}

	public void setDeathReason(String deathReason) {
		this.deathReason = deathReason;
	}

	public String getDeathAddress() {
		return this.deathAddress;
	}

	public void setDeathAddress(String deathAddress) {
		this.deathAddress = deathAddress;
	}

	public Date getDeathDate() {
		return this.deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getPersonInfoId() {
		return this.personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getPersonDeathId() {
		return this.personDeathId;
	}

	public void setPersonDeathId(String personDeathId) {
		this.personDeathId = personDeathId;
	}

	@Generated(hash = 8148092)
	public PersonDeath(String personDeathId, String personInfoId, Date deathDate,
			String deathAddress, String deathReason, String reportMan,
			String reportContact, Integer isCancel, String createOrgId, String orgName,
			String creatorId, String creator, Date createTime, String modifiedOrgId,
			String modifiedOrgName, String modifierId, String modifier, Date modifiedTime) {
		this.personDeathId = personDeathId;
		this.personInfoId = personInfoId;
		this.deathDate = deathDate;
		this.deathAddress = deathAddress;
		this.deathReason = deathReason;
		this.reportMan = reportMan;
		this.reportContact = reportContact;
		this.isCancel = isCancel;
		this.createOrgId = createOrgId;
		this.orgName = orgName;
		this.creatorId = creatorId;
		this.creator = creator;
		this.createTime = createTime;
		this.modifiedOrgId = modifiedOrgId;
		this.modifiedOrgName = modifiedOrgName;
		this.modifierId = modifierId;
		this.modifier = modifier;
		this.modifiedTime = modifiedTime;
	}

	@Generated(hash = 563219279)
	public PersonDeath() {
	}


}
