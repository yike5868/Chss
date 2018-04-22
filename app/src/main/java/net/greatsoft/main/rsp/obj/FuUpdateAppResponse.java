package net.greatsoft.main.rsp.obj;


import net.greatsoft.main.control.FuResponse;

public class FuUpdateAppResponse extends FuResponse {

	private String mAppName;
	private String mAvVersion;
	private String mAvIsMajor;
	private String mAvUrl;
	private String mAvText;
	private String mAvCTime;
	
	private String AV_RESOURCE; //资源轮播图
	
	public String getAV_RESOURCE() {
		return AV_RESOURCE;
	}

	public void setAV_RESOURCE(String aV_RESOURCE) {
		AV_RESOURCE = aV_RESOURCE;
	}

	public String getmAppName() {
		return mAppName;
	}

	public void setmAppName(String mAppName) {
		this.mAppName = mAppName;
	}

	public String getmAvVersion() {
		return mAvVersion;
	}

	public void setmAvVersion(String mAvVersion) {
		this.mAvVersion = mAvVersion;
	}

	public String getmAvIsMajor() {
		return mAvIsMajor;
	}

	public void setmAvIsMajor(String mAvIsMajor) {
		this.mAvIsMajor = mAvIsMajor;
	}

	public String getmAvUrl() {
		return mAvUrl;
	}

	public void setmAvUrl(String mAvUrl) {
		this.mAvUrl = mAvUrl;
	}

	public String getmAvText() {
		return mAvText;
	}

	public void setmAvText(String mAvText) {
		this.mAvText = mAvText;
	}

	public String getmAvCTime() {
		return mAvCTime;
	}

	public void setmAvCTime(String mAvCTime) {
		this.mAvCTime = mAvCTime;
	}

}
