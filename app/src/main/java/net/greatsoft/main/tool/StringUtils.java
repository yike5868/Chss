package net.greatsoft.main.tool;

import android.widget.Spinner;

import net.greatsoft.main.db.po.SpinnerItem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/**
	 * 电话号码中间四位****号显示
	 */
	public static String getXPhoneNum(String phoneNum) {

		if (phoneNum == null) {
			return phoneNum;
		}

		return phoneNum.substring(0, 3) + "****" + phoneNum.substring(7);

	}

	public static boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	public static boolean isMobileNO(String mobiles) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	public static boolean is(Integer i,Integer j){
		if(i == null || j ==null)
			return false;
		return i==j;
	}

	public static String getStringId(Spinner spinner){
		if(spinner==null){
			return "";
		}
		if(spinner.getSelectedItem()==null){
			return "";
		}
		return ((SpinnerItem)spinner.getSelectedItem()).getId();
	}
	public static String getStringName(Spinner spinner){
		if(spinner==null){
			return "";
		}
		if(spinner.getSelectedItem()==null){
			return "";
		}
		return ((SpinnerItem)spinner.getSelectedItem()).getValue();
	}
}
