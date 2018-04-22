package net.greatsoft.main.rqt.obj;


import net.greatsoft.main.control.FuRequset;

public class FuRegistAppRequest extends FuRequset {

	private String mRealName; // 真实姓名
	private String mIdNumber; // 身份证号
	private String mPasswordMD5; // 密码（MD5加密）
	private String mPhone; // 手机号
	private String mValidateCode; // 验证码

	public String getmRealName() {
		return mRealName;
	}

	public void setmRealName(String mRealName) {
		this.mRealName = mRealName;
	}

	public String getmIdNumber() {
		return mIdNumber;
	}

	public void setmIdNumber(String mIdNumber) {
		this.mIdNumber = mIdNumber;
	}

	public String getmPasswordMD5() {
		return mPasswordMD5;
	}

	public void setmPasswordMD5(String mPasswordMD5) {
		this.mPasswordMD5 = mPasswordMD5;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public String getmValidateCode() {
		return mValidateCode;
	}

	public void setmValidateCode(String mValidateCode) {
		this.mValidateCode = mValidateCode;
	}


}
