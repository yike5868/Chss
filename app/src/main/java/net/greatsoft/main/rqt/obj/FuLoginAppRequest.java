package net.greatsoft.main.rqt.obj;


import net.greatsoft.main.control.FuRequset;
import net.greatsoft.main.db.po.Entry;

public class FuLoginAppRequest extends Entry {

	private String mAccount; // 用户名
	private String mPasswordMD5; // 密码 （MD5加密）

	private String mDevcieID; // 设备ID
	private String mDevcieType; // 设备类型

	public FuLoginAppRequest(String mAccount,String mPasswordMD5){
		this.mAccount = mAccount;
		this.mPasswordMD5 = mPasswordMD5;
	}


	public String getmDevcieID() {
		return mDevcieID;
	}

	public void setmDevcieID(String mDevcieID) {
		this.mDevcieID = mDevcieID;
	}

	public String getmAccount() {
		return mAccount;
	}

	public void setmAccount(String mAccount) {
		this.mAccount = mAccount;
	}

	public String getmPasswordMD5() {
		return mPasswordMD5;
	}

	public void setmPasswordMD5(String mPasswordMD5) {
		this.mPasswordMD5 = mPasswordMD5;
	}

	public String getmDevcieType() {
		return mDevcieType;
	}

	public void setmDevcieType(String mDevcieType) {
		this.mDevcieType = mDevcieType;
	}

}
