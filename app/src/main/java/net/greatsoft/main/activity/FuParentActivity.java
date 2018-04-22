package net.greatsoft.main.activity;


import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.FuUserInfo;
import net.greatsoft.main.R;
import net.greatsoft.main.view.TimePicker.OnDateSetListener;
import net.greatsoft.main.view.TimePicker.TimePickerDialog;
import net.greatsoft.main.view.TimePicker.Type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FuParentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle bundle) {

        super.onCreate(bundle);
        if (bundle == null || !bundle.getBoolean("Home", false)) {
            return;
        }
        FuApp app = (FuApp) getApplication();
        FuUserInfo lUser = app.getFuUserInfo();
        lUser.setDistrictCityCode(bundle.getString("districtCityCode"));
        lUser.setDistrictCountyCode(bundle.getString("districtCountyCode"));
        lUser.setDistrictId(bundle.getString("districtId"));
        lUser.setDistrictLevel(bundle.getInt("districtLevel"));
        lUser.setDistrictName(bundle.getString("districtName"));
        lUser.setOrgCode(bundle.getString("orgCode"));
        lUser.setOrgId(bundle.getString("orgId"));
        lUser.setOrgName(bundle.getString("orgName"));
        lUser.setUserId(bundle.getString("userId"));
        lUser.setUserRealName(bundle.getString("userRealName"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putBoolean("Home", true);
        FuApp app = (FuApp) getApplication();
        FuUserInfo lUser = app.getFuUserInfo();

        outState.putString("districtCityCode", lUser.getDistrictCityCode());
        outState.putString("districtCountyCode", lUser.getDistrictCountyCode());
        outState.putString("districtId", lUser.getDistrictId());
        outState.putInt("districtLevel", lUser.getDistrictLevel());
        outState.putString("districtName", lUser.getDistrictName());
        outState.putString("orgCode", lUser.getOrgCode());
        outState.putString("orgId", lUser.getOrgId());
        outState.putString("orgName", lUser.getOrgName());
        outState.putString("userId", lUser.getUserId());
        outState.putString("userRealName", lUser.getUserRealName());

    }

    //动态添加代码的时候 设置dip TypedValue.COMPLEX_UNIT_DIP
    public float getRawSize(int unit, float value) {
        Resources res = this.getResources();
        return TypedValue.applyDimension(unit, value, res.getDisplayMetrics());
    }

    public int getIntFromDimens(int index) {
        int result = this.getResources().getDimensionPixelSize(index);
        return result;
    }

    public double getScreenSizeOfDevice() {
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        double x = Math.pow(point.x/ dm.xdpi, 2);
        double y = Math.pow(point.y / dm.ydpi, 2);
        double screenInches = Math.sqrt(x + y);

        if (screenInches > 6.5) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        return screenInches;
    }


    //	public void showTimeDialog(final TextView view) {
//		DatePicker picker=new DatePicker(this);
//		picker.setRangeStart(1900, 1, 1);
//		picker.setRangeEnd(2020, 1, 1);
//		int[] time = getSystemTime();
//		picker.setSelectedItem(time[0],time[1],time[2]);
//		picker.setGravity(Gravity.CENTER);//弹框居中
//
//		picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
//			@Override
//			public void onDatePicked(String year, String month, String day) {
//				view.setText(year + "-" + month + "-" + day);
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//				try {
//					Date parse = dateFormat.parse(year + "-" + month + "-" + day);
//					view.setTag(parse);
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		picker.show();
//		picker.setOnDismissListener(new DialogInterface.OnDismissListener() {
//			@Override
//			public void onDismiss(DialogInterface dialog) {
//				view.setEnabled(true);
//			}
//		});
//		if (picker.isShowing()) {
//			view.setEnabled(false);
//		}
//	}
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

    public TimePickerDialog showTimeDialog(final TextView tv) {
        long hundredYears = 100L * 365 * 1000 * 60 * 60 * 24L;
        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
        TimePickerDialog mDialogYearMonthDay = new TimePickerDialog.Builder()
                .setType(Type.YEAR_MONTH_DAY)
                .setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        Date date = new Date(millseconds);
                        String format = sf.format(date);
                        try {
                            Date parse = sf.parse(format);
                            tv.setTag(parse);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        tv.setText(getDateToString(millseconds));
                    }
                })
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("请选择日期")
                .setYearText("年")
                .setMonthText("月")
                .setDayText("号")
                .setThemeColor(getResources().getColor(R.color.bg_title_top_bottom))
                .setMinMillseconds(System.currentTimeMillis() - hundredYears)
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                .build();
        return mDialogYearMonthDay;
    }

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }

    public int[] getSystemTime() {
        long l = System.currentTimeMillis();
        SimpleDateFormat dateFormatYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MM");
        SimpleDateFormat dateFormatDay = new SimpleDateFormat("dd");
        int[] a = new int[3];
        a[0] = Integer.parseInt(dateFormatYear.format(l));
        a[1] = Integer.parseInt(dateFormatMonth.format(l));
        a[2] = Integer.parseInt(dateFormatDay.format(l));

        return a;
    }

}
