/***/
package net.greatsoft.main.db.po.family;

import net.greatsoft.main.control.FuRequset;
import net.greatsoft.main.db.po.Entry;
import net.greatsoft.main.db.po.RecordChoice;

import org.greenrobot.greendao.annotation.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;

/**
 * 
 * @author :hn
 * @createDate:2016年5月31日
 * @description:家庭档案及家庭基本信息，是业务经办过程中使用和更新的数据， 家庭表是为数据完整性和对外服务使用，不在业务中直接使用，个人表同
 */
@Entity
public class FamilyInfo extends Entry {

	/**
	 * 家庭档案ID
	 */
	private String familyInfoId;

	/**
	 * 建档机构ID
	 */
	private String createOrgId;

	/**
	 * 管理机构ID
	 */
	private String manageOrgId;

	/**
	 * 家庭健康档案编号
	 */
	private String familyRecordNo;

	/**
	 * 家庭健康档案自行编号
	 */
	private String familyRecordSno;

	/**
	 * 家庭医生签约机构ID
	 */
	private String familyDoctorOrgId;

	/**
	 * 家庭医生团队ID
	 */
	private String familyDoctorTeamId;

	/**
	 * 责任医生ID
	 */
	private String respDoctorId;
	/**
	 * 责任医生姓名
	 */
	private String respDoctorName;

	/**
	 * 家庭医生签约截止日期
	 */
	private Date familyDoctorEndDate;

	/**
	 * 户主姓名
	 */
	private String householder;

	/**
	 * 户主身份证号
	 */
	private String householderIdNo;

	/**
	 * 家庭地址
	 */
	private String address;

	/**
	 * 家庭电话
	 */
	private String telNo;

	/**
	 * 户口本编号
	 */
	private String householdNo;

	/**
	 * 家庭人数
	 */
	private Integer familySize;

	/**
	 * 居（村）委会
	 */
	private String committee;

	/**
	 * 小区
	 */
	private String residential;

	/**
	 * 楼栋
	 */
	private String building;

	/**
	 * 单元
	 */
	private String unit;

	/**
	 * 房间号
	 */
	private String roomNumber;

	/**
	 * 档案状态代码
	 */
	private String statusCode;

	/**
	 * 档案注销删除原因代码
	 */
	private String cancelReasonCode;

	/**
	 * 档案注销删除原因
	 */
	private String cancelReason;

	/**
	 * 档案注销删除时间
	 */
	private Date cancelTime;

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

	/**
	 * 选项指标记录 json串
	 */
	private String jsonDetail;


	@Transient
	private FamilyEconomic familyEconomic;

	@Transient
	private List<FamilyCredential> familyCredential;
	@Transient
	private List<RecordChoice> recordChoice;

	public List<RecordChoice> getRecordChoice() {
		return recordChoice;
	}

	public void setRecordChoice(List<RecordChoice> recordChoice) {
		this.recordChoice = recordChoice;
	}

	public String getJsonDetail() {
		return this.jsonDetail;
	}

	public void setJsonDetail(String jsonDetail) {
		this.jsonDetail = jsonDetail;
	}

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

	public Date getCancelTime() {
		return this.cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getCancelReason() {
		return this.cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancelReasonCode() {
		return this.cancelReasonCode;
	}

	public void setCancelReasonCode(String cancelReasonCode) {
		this.cancelReasonCode = cancelReasonCode;
	}

	public String getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getResidential() {
		return this.residential;
	}

	public void setResidential(String residential) {
		this.residential = residential;
	}

	public String getCommittee() {
		return this.committee;
	}

	public void setCommittee(String committee) {
		this.committee = committee;
	}

	public Integer getFamilySize() {
		return this.familySize;
	}

	public void setFamilySize(Integer familySize) {
		this.familySize = familySize;
	}

	public String getHouseholdNo() {
		return this.householdNo;
	}

	public void setHouseholdNo(String householdNo) {
		this.householdNo = householdNo;
	}

	public String getTelNo() {
		return this.telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHouseholderIdNo() {
		return this.householderIdNo;
	}

	public void setHouseholderIdNo(String householderIdNo) {
		this.householderIdNo = householderIdNo;
	}

	public String getHouseholder() {
		return this.householder;
	}

	public void setHouseholder(String householder) {
		this.householder = householder;
	}

	public Date getFamilyDoctorEndDate() {
		return this.familyDoctorEndDate;
	}

	public void setFamilyDoctorEndDate(Date familyDoctorEndDate) {
		this.familyDoctorEndDate = familyDoctorEndDate;
	}

	public String getRespDoctorName() {
		return this.respDoctorName;
	}

	public void setRespDoctorName(String respDoctorName) {
		this.respDoctorName = respDoctorName;
	}

	public String getRespDoctorId() {
		return this.respDoctorId;
	}

	public void setRespDoctorId(String respDoctorId) {
		this.respDoctorId = respDoctorId;
	}

	public String getFamilyDoctorTeamId() {
		return this.familyDoctorTeamId;
	}

	public void setFamilyDoctorTeamId(String familyDoctorTeamId) {
		this.familyDoctorTeamId = familyDoctorTeamId;
	}

	public String getFamilyDoctorOrgId() {
		return this.familyDoctorOrgId;
	}

	public void setFamilyDoctorOrgId(String familyDoctorOrgId) {
		this.familyDoctorOrgId = familyDoctorOrgId;
	}

	public String getFamilyRecordSno() {
		return this.familyRecordSno;
	}

	public void setFamilyRecordSno(String familyRecordSno) {
		this.familyRecordSno = familyRecordSno;
	}

	public String getFamilyRecordNo() {
		return this.familyRecordNo;
	}

	public void setFamilyRecordNo(String familyRecordNo) {
		this.familyRecordNo = familyRecordNo;
	}

	public String getManageOrgId() {
		return this.manageOrgId;
	}

	public void setManageOrgId(String manageOrgId) {
		this.manageOrgId = manageOrgId;
	}

	public String getCreateOrgId() {
		return this.createOrgId;
	}

	public void setCreateOrgId(String createOrgId) {
		this.createOrgId = createOrgId;
	}

	public String getFamilyInfoId() {
		return this.familyInfoId;
	}

	public void setFamilyInfoId(String familyInfoId) {
		this.familyInfoId = familyInfoId;
	}

	@Generated(hash = 1824718789)
	public FamilyInfo(String familyInfoId, String createOrgId, String manageOrgId,
			String familyRecordNo, String familyRecordSno, String familyDoctorOrgId,
			String familyDoctorTeamId, String respDoctorId, String respDoctorName,
			Date familyDoctorEndDate, String householder, String householderIdNo,
			String address, String telNo, String householdNo, Integer familySize,
			String committee, String residential, String building, String unit,
			String roomNumber, String statusCode, String cancelReasonCode,
			String cancelReason, Date cancelTime, String orgName, String creatorId,
			String creator, Date createTime, String modifiedOrgId,
			String modifiedOrgName, String modifierId, String modifier,
			Date modifiedTime, String jsonDetail) {
		this.familyInfoId = familyInfoId;
		this.createOrgId = createOrgId;
		this.manageOrgId = manageOrgId;
		this.familyRecordNo = familyRecordNo;
		this.familyRecordSno = familyRecordSno;
		this.familyDoctorOrgId = familyDoctorOrgId;
		this.familyDoctorTeamId = familyDoctorTeamId;
		this.respDoctorId = respDoctorId;
		this.respDoctorName = respDoctorName;
		this.familyDoctorEndDate = familyDoctorEndDate;
		this.householder = householder;
		this.householderIdNo = householderIdNo;
		this.address = address;
		this.telNo = telNo;
		this.householdNo = householdNo;
		this.familySize = familySize;
		this.committee = committee;
		this.residential = residential;
		this.building = building;
		this.unit = unit;
		this.roomNumber = roomNumber;
		this.statusCode = statusCode;
		this.cancelReasonCode = cancelReasonCode;
		this.cancelReason = cancelReason;
		this.cancelTime = cancelTime;
		this.orgName = orgName;
		this.creatorId = creatorId;
		this.creator = creator;
		this.createTime = createTime;
		this.modifiedOrgId = modifiedOrgId;
		this.modifiedOrgName = modifiedOrgName;
		this.modifierId = modifierId;
		this.modifier = modifier;
		this.modifiedTime = modifiedTime;
		this.jsonDetail = jsonDetail;
	}

	@Generated(hash = 1646544217) @Keep
	public FamilyInfo() {

		familyCredential = new ArrayList<>();
		familyEconomic = new FamilyEconomic();
		recordChoice = new ArrayList<>();
	}


	public FamilyEconomic getFamilyEconomic() {
		return familyEconomic;
	}

	public void setFamilyEconomic(FamilyEconomic familyEconomic) {
		this.familyEconomic = familyEconomic;
	}

	public List<FamilyCredential> getFamilyCredential() {
		return familyCredential;
	}

	public void setFamilyCredential(List<FamilyCredential> familyCredential) {
		this.familyCredential = familyCredential;
	}
}
