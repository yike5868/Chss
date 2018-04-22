package net.greatsoft.main.db.po.family;


import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * 
 * @author :hn
 * @createDate:2016年5月31日
 * @description:家庭经济状况信息表
 */
@Entity
public class FamilyEconomic extends Entry {

	/**
	 * 家庭经济状况ID
	 */
	private String familyEconomicId;

	/**
	 * 居住面积
	 */
	private Double dwellingArea;

	/**
	 * 人均居住面积
	 */
	private Double dwellingAreaPer;

	/**
	 * 户籍类型代码
	 */
	private String householdTypeCode;

	/**
	 * 户籍类型名称
	 */
	private String householdTypeName;

	/**
	 * 户属性代码
	 */
	private String householdPropertyCode;

	/**
	 * 户属性名称
	 */
	private String householdPropertyName;
	
	/**
	 * 房屋类型代码
	 */
	private String houseTypeCode;
	
	/**
	 * 房屋类型名称
	 */
	private String houseTypeName;
	
	/**
	 * 厨房使用方式
	 */
	private String kitchenUseModeCode;
	
	/**
	 * 厨房排风设施
	 */
	private String kitchenExhaustCode;
	
	/**
	 * 卫生厕所代码
	 */
	private String sanitaryToiletCode;
	
	/**
	 * 非卫生厕所代码
	 */
	private String noSanitaryToiletCode;
	
	/**
	 * 禽畜栏代码
	 */
	private String livestockFenceCode;
	
	/**
	 * 垃圾处理代码
	 */
	private String garbageDisposalCode;
	
	/**
	 * 垃圾处理中文
	 */
	private String garbageDisposalName;

	/**
	 * 家庭id
	 */
	@Id
	private String familyInfoId;

	public String getGarbageDisposalName() {
		return this.garbageDisposalName;
	}

	public void setGarbageDisposalName(String garbageDisposalName) {
		this.garbageDisposalName = garbageDisposalName;
	}

	public String getGarbageDisposalCode() {
		return this.garbageDisposalCode;
	}

	public void setGarbageDisposalCode(String garbageDisposalCode) {
		this.garbageDisposalCode = garbageDisposalCode;
	}

	public String getLivestockFenceCode() {
		return this.livestockFenceCode;
	}

	public void setLivestockFenceCode(String livestockFenceCode) {
		this.livestockFenceCode = livestockFenceCode;
	}

	public String getNoSanitaryToiletCode() {
		return this.noSanitaryToiletCode;
	}

	public void setNoSanitaryToiletCode(String noSanitaryToiletCode) {
		this.noSanitaryToiletCode = noSanitaryToiletCode;
	}

	public String getSanitaryToiletCode() {
		return this.sanitaryToiletCode;
	}

	public void setSanitaryToiletCode(String sanitaryToiletCode) {
		this.sanitaryToiletCode = sanitaryToiletCode;
	}

	public String getKitchenExhaustCode() {
		return this.kitchenExhaustCode;
	}

	public void setKitchenExhaustCode(String kitchenExhaustCode) {
		this.kitchenExhaustCode = kitchenExhaustCode;
	}

	public String getKitchenUseModeCode() {
		return this.kitchenUseModeCode;
	}

	public void setKitchenUseModeCode(String kitchenUseModeCode) {
		this.kitchenUseModeCode = kitchenUseModeCode;
	}

	public String getHouseTypeName() {
		return this.houseTypeName;
	}

	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}

	public String getHouseTypeCode() {
		return this.houseTypeCode;
	}

	public void setHouseTypeCode(String houseTypeCode) {
		this.houseTypeCode = houseTypeCode;
	}

	public String getHouseholdPropertyName() {
		return this.householdPropertyName;
	}

	public void setHouseholdPropertyName(String householdPropertyName) {
		this.householdPropertyName = householdPropertyName;
	}

	public String getHouseholdPropertyCode() {
		return this.householdPropertyCode;
	}

	public void setHouseholdPropertyCode(String householdPropertyCode) {
		this.householdPropertyCode = householdPropertyCode;
	}

	public String getHouseholdTypeName() {
		return this.householdTypeName;
	}

	public void setHouseholdTypeName(String householdTypeName) {
		this.householdTypeName = householdTypeName;
	}

	public String getHouseholdTypeCode() {
		return this.householdTypeCode;
	}

	public void setHouseholdTypeCode(String householdTypeCode) {
		this.householdTypeCode = householdTypeCode;
	}

	public Double getDwellingAreaPer() {
		return this.dwellingAreaPer;
	}

	public void setDwellingAreaPer(Double dwellingAreaPer) {
		this.dwellingAreaPer = dwellingAreaPer;
	}

	public Double getDwellingArea() {
		return this.dwellingArea;
	}

	public void setDwellingArea(Double dwellingArea) {
		this.dwellingArea = dwellingArea;
	}

	public String getFamilyEconomicId() {
		return this.familyEconomicId;
	}

	public void setFamilyEconomicId(String familyEconomicId) {
		this.familyEconomicId = familyEconomicId;
	}

	public String getFamilyInfoId() {
		return this.familyInfoId;
	}

	public void setFamilyInfoId(String familyInfoId) {
		this.familyInfoId = familyInfoId;
	}

	@Generated(hash = 693984166)
	public FamilyEconomic(String familyEconomicId, Double dwellingArea,
			Double dwellingAreaPer, String householdTypeCode, String householdTypeName,
			String householdPropertyCode, String householdPropertyName,
			String houseTypeCode, String houseTypeName, String kitchenUseModeCode,
			String kitchenExhaustCode, String sanitaryToiletCode,
			String noSanitaryToiletCode, String livestockFenceCode,
			String garbageDisposalCode, String garbageDisposalName, String familyInfoId) {
		this.familyEconomicId = familyEconomicId;
		this.dwellingArea = dwellingArea;
		this.dwellingAreaPer = dwellingAreaPer;
		this.householdTypeCode = householdTypeCode;
		this.householdTypeName = householdTypeName;
		this.householdPropertyCode = householdPropertyCode;
		this.householdPropertyName = householdPropertyName;
		this.houseTypeCode = houseTypeCode;
		this.houseTypeName = houseTypeName;
		this.kitchenUseModeCode = kitchenUseModeCode;
		this.kitchenExhaustCode = kitchenExhaustCode;
		this.sanitaryToiletCode = sanitaryToiletCode;
		this.noSanitaryToiletCode = noSanitaryToiletCode;
		this.livestockFenceCode = livestockFenceCode;
		this.garbageDisposalCode = garbageDisposalCode;
		this.garbageDisposalName = garbageDisposalName;
		this.familyInfoId = familyInfoId;
	}

	@Generated(hash = 665226493)
	public FamilyEconomic() {
	}
	
}
