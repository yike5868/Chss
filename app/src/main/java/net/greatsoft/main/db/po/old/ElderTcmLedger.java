package net.greatsoft.main.db.po.old;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author hn
 * @date 2016年7月25日 下午10:52:44
 * @Description: 老年人中医药健康管理台账
 *
 */
@Entity
public class ElderTcmLedger  extends Entry {
	/**
	 * 老年人中医药健康管理台账ID
	 */
	
	private String elderTcmLedgerId;

	/**
	 * 个人档案ID
	 */
	
	private String personInfoId;

	/**
	 * 老年人中医药健康表ID
	 */
	
	private String elderTcmHealthId;

	/**
	 * 编号
	 */
	
	private String personInfoNo;

	/**
	 * 本人姓名
	 */
	
	private String name;

	/**
	 * 地址
	 */
	
	private String address;

	/**
	 * 随访日期
	 */
	
	
	private Date followupDate;

	/**
	 * 体质类型-气虚质
	 */
	
	private String qiDeficiency;

	/**
	 * 体质类型-阳虚质
	 */
	
	private String yangDeficiency;

	/**
	 * 体质类型-阴虚质
	 */
	
	private String yinDeficiency;

	/**
	 * 体质类型-痰湿质
	 */
	
	private String phlegmWet;

	/**
	 * 体质类型-湿热质
	 */
	
	private String dampHeat;

	/**
	 * 体质类型-血淤质
	 */
	
	private String bloodStasis;

	/**
	 * 体质类型-气郁质
	 */
	
	private String qiDepression;

	/**
	 * 体质类型-特禀质
	 */
	
	private String specialDiathsis;

	/**
	 * 体质类型-平和质
	 */
	
	private String gentleQuality;

	/**
	 * 保健指导-情志调摄
	 */
	
	private String emotionGuide;

	/**
	 * 保健指导-饮食调养
	 */
	
	private String dietGuide;

	/**
	 * 保健指导-起居调摄
	 */
	
	private String livingGuide;

	/**
	 * 保健指导-运动保健
	 */
	
	private String sportsGuide;

	/**
	 * 保健指导-穴位保健
	 */
	
	private String acupointGuide;

	/**
	 * 保健指导-其他
	 */
	
	private String otherGuide;

	/**
	 * 是否删除
	 */
	private Integer isCancel;

	/**
	 * 录入机构ID
	 */
	
	private String createOrgId;

	/**
	 * 录入机构名称
	 */
	
	private String orgName;

	/**
	 * 录入人ID
	 */
	
	private String creatorId;

	/**
	 * 录入人姓名
	 */
	
	private String creator;

	/**
	 * 录入时间
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

	public String getOtherGuide() {
		return this.otherGuide;
	}

	public void setOtherGuide(String otherGuide) {
		this.otherGuide = otherGuide;
	}

	public String getAcupointGuide() {
		return this.acupointGuide;
	}

	public void setAcupointGuide(String acupointGuide) {
		this.acupointGuide = acupointGuide;
	}

	public String getSportsGuide() {
		return this.sportsGuide;
	}

	public void setSportsGuide(String sportsGuide) {
		this.sportsGuide = sportsGuide;
	}

	public String getLivingGuide() {
		return this.livingGuide;
	}

	public void setLivingGuide(String livingGuide) {
		this.livingGuide = livingGuide;
	}

	public String getDietGuide() {
		return this.dietGuide;
	}

	public void setDietGuide(String dietGuide) {
		this.dietGuide = dietGuide;
	}

	public String getEmotionGuide() {
		return this.emotionGuide;
	}

	public void setEmotionGuide(String emotionGuide) {
		this.emotionGuide = emotionGuide;
	}

	public String getGentleQuality() {
		return this.gentleQuality;
	}

	public void setGentleQuality(String gentleQuality) {
		this.gentleQuality = gentleQuality;
	}

	public String getSpecialDiathsis() {
		return this.specialDiathsis;
	}

	public void setSpecialDiathsis(String specialDiathsis) {
		this.specialDiathsis = specialDiathsis;
	}

	public String getQiDepression() {
		return this.qiDepression;
	}

	public void setQiDepression(String qiDepression) {
		this.qiDepression = qiDepression;
	}

	public String getBloodStasis() {
		return this.bloodStasis;
	}

	public void setBloodStasis(String bloodStasis) {
		this.bloodStasis = bloodStasis;
	}

	public String getDampHeat() {
		return this.dampHeat;
	}

	public void setDampHeat(String dampHeat) {
		this.dampHeat = dampHeat;
	}

	public String getPhlegmWet() {
		return this.phlegmWet;
	}

	public void setPhlegmWet(String phlegmWet) {
		this.phlegmWet = phlegmWet;
	}

	public String getYinDeficiency() {
		return this.yinDeficiency;
	}

	public void setYinDeficiency(String yinDeficiency) {
		this.yinDeficiency = yinDeficiency;
	}

	public String getYangDeficiency() {
		return this.yangDeficiency;
	}

	public void setYangDeficiency(String yangDeficiency) {
		this.yangDeficiency = yangDeficiency;
	}

	public String getQiDeficiency() {
		return this.qiDeficiency;
	}

	public void setQiDeficiency(String qiDeficiency) {
		this.qiDeficiency = qiDeficiency;
	}

	public Date getFollowupDate() {
		return this.followupDate;
	}

	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonInfoNo() {
		return this.personInfoNo;
	}

	public void setPersonInfoNo(String personInfoNo) {
		this.personInfoNo = personInfoNo;
	}

	public String getElderTcmHealthId() {
		return this.elderTcmHealthId;
	}

	public void setElderTcmHealthId(String elderTcmHealthId) {
		this.elderTcmHealthId = elderTcmHealthId;
	}

	public String getPersonInfoId() {
		return this.personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getElderTcmLedgerId() {
		return this.elderTcmLedgerId;
	}

	public void setElderTcmLedgerId(String elderTcmLedgerId) {
		this.elderTcmLedgerId = elderTcmLedgerId;
	}

	@Generated(hash = 1605990076)
	public ElderTcmLedger(String elderTcmLedgerId, String personInfoId,
			String elderTcmHealthId, String personInfoNo, String name, String address,
			Date followupDate, String qiDeficiency, String yangDeficiency,
			String yinDeficiency, String phlegmWet, String dampHeat, String bloodStasis,
			String qiDepression, String specialDiathsis, String gentleQuality,
			String emotionGuide, String dietGuide, String livingGuide,
			String sportsGuide, String acupointGuide, String otherGuide,
			Integer isCancel, String createOrgId, String orgName, String creatorId,
			String creator, Date createTime, String modifiedOrgId,
			String modifiedOrgName, String modifierId, String modifier, Date modifiedTime) {
		this.elderTcmLedgerId = elderTcmLedgerId;
		this.personInfoId = personInfoId;
		this.elderTcmHealthId = elderTcmHealthId;
		this.personInfoNo = personInfoNo;
		this.name = name;
		this.address = address;
		this.followupDate = followupDate;
		this.qiDeficiency = qiDeficiency;
		this.yangDeficiency = yangDeficiency;
		this.yinDeficiency = yinDeficiency;
		this.phlegmWet = phlegmWet;
		this.dampHeat = dampHeat;
		this.bloodStasis = bloodStasis;
		this.qiDepression = qiDepression;
		this.specialDiathsis = specialDiathsis;
		this.gentleQuality = gentleQuality;
		this.emotionGuide = emotionGuide;
		this.dietGuide = dietGuide;
		this.livingGuide = livingGuide;
		this.sportsGuide = sportsGuide;
		this.acupointGuide = acupointGuide;
		this.otherGuide = otherGuide;
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

	@Generated(hash = 1574250448)
	public ElderTcmLedger() {
	}


}