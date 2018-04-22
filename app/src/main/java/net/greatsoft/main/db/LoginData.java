package net.greatsoft.main.db;

/**
 * 登录数据存储结构
 * 
 * 
 */
public class LoginData {

	private String mUserName; // 用户名

	private String mPassword; // 密码

	private boolean mCheckRemeber; // 是否记住密码

	private String baseUrl;//地址

	private String ptBaseUrl;//平台地址

	private String ptBaseUrl2;//平台地址2

	public boolean ismCheckRemeber() {
		return mCheckRemeber;
	}

	public void setmCheckRemeber(boolean mCheckRemeber) {
		this.mCheckRemeber = mCheckRemeber;
	}

	public String getmUserName() {
		return mUserName;
	}

	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public String getPtBaseUrl() {
		return ptBaseUrl;
	}

	public void setPtBaseUrl(String ptBaseUrl) {
		this.ptBaseUrl = ptBaseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getPtBaseUrl2() {
		return ptBaseUrl2;
	}

	public void setPtBaseUrl2(String ptBaseUrl2) {
		this.ptBaseUrl2 = ptBaseUrl2;
	}
}
