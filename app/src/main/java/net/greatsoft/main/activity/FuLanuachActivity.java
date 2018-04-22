package net.greatsoft.main.activity;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


import net.greatsoft.main.Constant;

public class FuLanuachActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);

		checkNodifyLanuch();

	}

	private void checkNodifyLanuch() {

		Context context = getApplicationContext();
		// --------------

		ActivityManager lManager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);

		List<RunningAppProcessInfo> lApp = lManager.getRunningAppProcesses();

		List<RunningTaskInfo> lRunningInfo = lManager.getRunningTasks(lApp
				.size());

		String lPackName = context.getPackageName();

		String lClassName = null;

		if (lRunningInfo != null) {

			for (int i = 0; i < lRunningInfo.size(); i++) {

				ComponentName lCn = lRunningInfo.get(i).topActivity;

				String lTempPackName = lCn.getPackageName();

				if (lTempPackName.equals(lPackName)) {

					lClassName = lCn.getClassName();

					break;

				}

			}
		}

		SharedPreferences lPreferences = getSharedPreferences(
				Constant.LOGIN_CONFIG, MODE_PRIVATE);

		boolean lLogin = lPreferences.getBoolean(Constant.IS_LOGIN_RUNNING,
				false);

		if (lClassName == null || !lLogin) { // 程序已经消亡或者退出登录，要求重新初始化

			startActivity(new Intent(this, FuInitNavActivity.class));

		} else { // 进入离开时的页面

			Intent notifyIntent = new Intent(Intent.ACTION_MAIN);
			notifyIntent.addCategory(Intent.CATEGORY_LAUNCHER);

			notifyIntent.setComponent(new ComponentName(lPackName, lClassName));

			notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);// 关键的一步，设置启动模式
			startActivity(notifyIntent);
		}

		finish();
	}

}
