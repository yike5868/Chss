package net.greatsoft.main;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import net.greatsoft.main.control.fragment.CustomFragmentManager;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.helper.ALocalSqlHelper;
import net.greatsoft.main.tool.CrashHandler;

public class FuApp extends Application {

	private boolean isNeedCaughtExeption = true;// 是否捕获未知异常
	private PendingIntent mRestartIntent;



	private ALocalSqlHelper sqlHelper;

	@Override
	public void onCreate() {
		super.onCreate();

		if (isNeedCaughtExeption) {
//			cauchException();
		}

//		MobclickAgent.setDebugMode( true );//友盟集成测试

		//捕捉异常 提示
		CrashHandler crashHandler = CrashHandler.getInstance();
		crashHandler.init(getApplicationContext());

		sqlHelper = new ALocalSqlHelper(this);
		initImageLoader();
	}



	private void initImageLoader() {

		DisplayImageOptions.Builder b = new DisplayImageOptions.Builder();
		b.cacheInMemory(true).cacheOnDisk(true);

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getApplicationContext())
				.threadPoolSize(3)
				.threadPriority(Thread.NORM_PRIORITY - 1)
				.tasksProcessingOrder(QueueProcessingType.FIFO)
				.denyCacheImageMultipleSizesInMemory()
				// .diskCache(new UnlimitedDiscCache(cacheDir))
				.diskCacheFileCount(100)
				.diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
				.imageDownloader(
						new BaseImageDownloader(getApplicationContext())) // default
				.imageDecoder(new BaseImageDecoder(true)) // default
				.defaultDisplayImageOptions(b.build()) // default
				.build();

		ImageLoader.getInstance().init(config);
	}

//	private void cauchException() {
//
//		Intent intent = new Intent();
//		// 参数1：包名，参数2：程序入口的activity
//		intent.setClassName(getPackageName(), getPackageName()
//				+ ".JkxInitNavActivity");
//		mRestartIntent = PendingIntent.getActivity(getApplicationContext(), -1,
//				intent, Intent.FLAG_ACTIVITY_NEW_TASK);
//
//		// 程序崩溃时触发线程
//		UIHandler uiHandler = new UIHandler();
//		Thread.setDefaultUncaughtExceptionHandler(uiHandler);
//
//	}

	public String getChannelValue() {

		String channel = "";

//		try {
//			channel = this.getPackageManager().getApplicationInfo(
//					getPackageName(), PackageManager.GET_META_DATA).metaData
//					.getString("FU_CHANNEL");
//
//		} catch (NameNotFoundException e) {
//
//			channel = "gx_base_fu"; // 默认渠道为基础版本
//		}

		return (channel == null || "channel".equals(channel)) ? "gx_base_fu"
				: channel;
	}

	private CustomFragmentManager mFragmentManager;

	public CustomFragmentManager getFragmentManager() {

		if (mFragmentManager == null) {

			mFragmentManager = new CustomFragmentManager();
		}

		return mFragmentManager;
	}

	// 原选通知服务注册
	// private void registPushService() {
	// IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);
	// BootReceiver receiver = new BootReceiver();
	// registerReceiver(receiver, filter);
	// }


	private FuUiFrameManager mFuUiFrameManager;

	public FuUiFrameManager getFuUiFrameManager() {

		if (mFuUiFrameManager == null) {
			mFuUiFrameManager = new FuUiFrameManager();
		}

		return mFuUiFrameManager;
	}

	private FuUserInfo mFuUserInfo;

	public FuUserInfo getFuUserInfo() {

		if (mFuUserInfo == null) {
			mFuUserInfo = new FuUserInfo();
		}

		return mFuUserInfo;
	}

	public void setmFuUserInfo(FuUserInfo fuUserInfo){
		mFuUserInfo = fuUserInfo;
	}

	public void exitPersonInfo() {

		mFuUserInfo = null;
	}

	// -------------------------

	private class UIHandler implements Thread.UncaughtExceptionHandler {

		@Override
		public void uncaughtException(Thread thread, Throwable ex) {

			// 1秒钟后重启应用
			AlarmManager mgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
			mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1000,
					mRestartIntent);

			android.os.Process.killProcess(android.os.Process.myPid());

		}
	}
	/**
	 * 保存错误信息到文件中
	 *
	 * @return 返回文件名称,便于将文件传送到服务器
	 */
	// private String saveCatchInfo2File(Throwable ex) {
	//
	// DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	//
	// StringBuffer sb = new StringBuffer();
	//
	// Writer writer = new StringWriter();
	// PrintWriter printWriter = new PrintWriter(writer);
	// ex.printStackTrace(printWriter);
	// Throwable cause = ex.getCause();
	// while (cause != null) {
	// cause.printStackTrace(printWriter);
	// cause = cause.getCause();
	// }
	// printWriter.close();
	// String result = writer.toString();
	// sb.append(result);
	// try {
	// long timestamp = System.currentTimeMillis();
	// String time = formatter.format(new Date());
	// String fileName = "crash-" + time + "-" + timestamp + ".log";
	//
	// if (Environment.getExternalStorageState().equals(
	// Environment.MEDIA_MOUNTED)) {
	// String path = Environment.getExternalStorageDirectory()
	// .toString() + "/jkx/logcat/";
	// File dir = new File(path);
	// if (!dir.exists()) {
	// dir.mkdirs();
	// }
	// FileOutputStream fos = new FileOutputStream(path + fileName);
	// fos.write(sb.toString().getBytes());
	// fos.close();
	// }
	// return fileName;
	// } catch (Exception e) {
	//
	// }
	// return null;
	// }

	public ALocalSqlHelper getSqlHelper() {
		if(sqlHelper == null)
			sqlHelper = new ALocalSqlHelper(this);
		return sqlHelper;
	}

}
