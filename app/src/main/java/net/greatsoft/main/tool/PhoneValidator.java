package net.greatsoft.main.tool;

import android.text.TextUtils;

/**
 * 手机号码格式校验工具类
 * 
 * @author zhangzhicheng
 * 
 */
public class PhoneValidator {

	/**
	 * 校验手机号码
	 * 
	 * @param phone
	 *            手机号码
	 * @return 正确则返回NULL，否则返回错误信息
	 */
	// public static String validate(String phone) {
	//
	// if (TextUtils.isEmpty(phone)) {
	// return "手机号码不能为空";
	// }
	//
	// /*
	// * /**
	// * 手机号码
	// * 移动：134[0-8],135,136,137,138,139,150,151,157,158,159,182,187,188
	// * 联通：130,131,132,152,155,156,185,186
	// * 电信：133,1349,153,180,189
	// */
	// String mobile = "^1(3[0-9]|5[0-35-9]|8[025-9])\\d{8}$";
	// /*
	// * 中国移动：China Mobile
	// * 134[0-8],135,136,137,138,139,150,151,157,158,159,182,187,188,183
	// */
	// String cm = "^1(34[0-8]|(3[5-9]|5[017-9]|8[2378])\\d)\\d{7}$";
	// /*
	// * 中国联通：China Unicom
	// * 130,131,132,152,155,156,185,186
	// */
	// String cu = "^1(3[0-2]|5[256]|8[56])\\d{8}$";
	// /*
	// * 中国电信：China Telecom
	// * 133,1349,153,180,189
	// */
	// String ct = "^1((33|53|8[019])[0-9]|349)\\d{7}$";
	// // String regex = "^(1(([35][0-9])|(47)|[8][0126789]))\\d{8}$";
	// boolean flag1 = Pattern.compile(mobile).matcher(phone).matches();
	// boolean flag2 = Pattern.compile(cm).matcher(phone).matches();
	// boolean flag3 = Pattern.compile(cu).matcher(phone).matches();
	// boolean flag4 = Pattern.compile(ct).matcher(phone).matches();
	// if (!flag1 & !flag2 & !flag3 & !flag4) {
	// return "手机号码格式有误";
	// }
	// return null;
	// }

	public static String validate(String phone) {

		if (TextUtils.isEmpty(phone)) {
			return "手机号码不能为空";
		}

		if (phone.trim().length() != 11) {
			return "手机号码格式有误";
		}

		return null;
	}

}
