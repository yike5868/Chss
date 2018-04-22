package net.greatsoft.main;


public class FuUserInfo {

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 用户真实姓名
	 */
	private String userRealName;

	/**
	 * 用户所在机构
	 */
	private String orgId;

	/**
	 * 用户所在机构名称
	 */
	private String orgName;

	/**
	 * 当前用户机构所在区划ID
	 */
	private String districtId;
	/**
	 * 当前用户机构所在区划名称
	 */
	private String districtName;

	/**
	 * 当前用户机构所在区划级别
	 */
	private Integer districtLevel;

	/**
	 * 当前用户机构所在县级区划代码
	 */
	private String districtCountyCode;

	/**
	 * 当前用户机构所在市级级区划代码
	 */
	private String districtCityCode;
	/**
	 * 机构代码
	 */
	private String orgCode;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public Integer getDistrictLevel() {
		return districtLevel;
	}

	public void setDistrictLevel(Integer districtLevel) {
		this.districtLevel = districtLevel;
	}

	public String getDistrictCountyCode() {
		return districtCountyCode;
	}

	public void setDistrictCountyCode(String districtCountyCode) {
		this.districtCountyCode = districtCountyCode;
	}

	public String getDistrictCityCode() {
		return districtCityCode;
	}

	public void setDistrictCityCode(String districtCityCode) {
		this.districtCityCode = districtCityCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
}
