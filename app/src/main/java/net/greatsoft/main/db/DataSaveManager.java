package net.greatsoft.main.db;

import android.content.Context;
import android.content.SharedPreferences;

import net.greatsoft.main.db.po.districts.RoomAll;

/**
 * 数组存储
 * 
 * 
 */
public class DataSaveManager {

	private static DataSaveManager mSaveManager;

	private Context mContext;

	private DataSaveManager(Context context) {

		mContext = context;
	}

	public static DataSaveManager getInstance(Context context) {

		if (mSaveManager == null) {
			mSaveManager = new DataSaveManager(context);
		}
		return mSaveManager;
	}

	/**
	 * 存储创建好的对象
	 * 
	 * @param task
	 */
	public void addSaveTask(SaveTask task) {

		if (task == null) {
			return;
		}

		String lKey = task.getmTaskKey();

		if (lKey.equals(SaveTask.KEY_LOGIN)) {

			saveLoginData(lKey, task.getmData());

		} else if (lKey.equals(SaveTask.KEY_MESSAGE)) {

			saveMessageData(lKey, task.getmData());

		} else if (lKey.equals(SaveTask.KEY_VERSION)) {

			saveVersionData(lKey, task.getmData());

		} else if (lKey.equals(SaveTask.KEY_BANNER)) {

			saveBanner(lKey, task.getmData());
		}else if (lKey.equals(SaveTask.KEY_DISTRICTS)) {
			saveRoomAllData(lKey, task.getmData());
		}

	}


	/**
	 * 读取指定的数据对象
	 * 
	 * @param keyTask
	 * @return
	 */
	public Object getSaveData(String keyTask) {

		if (keyTask == null || keyTask.trim().length() < 1) {
			return null;
		}

		if (keyTask.equals(SaveTask.KEY_LOGIN)) {

			return getLoginData(keyTask);
		}
		if (keyTask.equals(SaveTask.KEY_MESSAGE)) {

			return getMessageData(keyTask);
		}

		if (keyTask.equals(SaveTask.KEY_VERSION)) {

			return getVersionData(keyTask);
		}

		if (keyTask.equals(SaveTask.KEY_BANNER)) {

			return getBannerNameData(keyTask);
		}

		if(keyTask.equals(SaveTask.KEY_DISTRICTS)){
			return getRoomAllData(keyTask);
		}

		return null;

	}

	// ==========================================

	private final String KEY_LOGIN_USERNAME = "key_login_user_name"; // 登录用户名关键字

	private final String KEY_LOGIN_PASSWORD = "key_login_password"; // 登录密码关键字

	private final String KEY_LOGIN_REMBER_PSW = "key_login_rember"; // 是否记住登录密码

	private final String KEY_BASE_URL = "key_base_url";//地址

	private final String KEY_PT_URL = "key_pt_url";//平台地址

	private final String KEY_PT_URL2 = "key_pt_url2";//平台地址2

	private void saveLoginData(String key, Object data) {

		if (data == null) {
			return;
		}

		LoginData lData = (LoginData) data;

		SharedPreferences lPre = mContext.getSharedPreferences(key,
				Context.MODE_PRIVATE);

		String lgetmUserName = lData.getmUserName();
		if (lgetmUserName != null && lgetmUserName.trim().length() > 0) {

			lPre.edit().putString(KEY_LOGIN_USERNAME, lgetmUserName).commit();
		}

		String baseUrl = lData.getBaseUrl();

		if (baseUrl != null && baseUrl.trim().length() > 0) {

			lPre.edit().putString(KEY_BASE_URL, baseUrl).commit();
		}

		String ptBaseUrl = lData.getPtBaseUrl();

		if (ptBaseUrl != null && ptBaseUrl.trim().length() > 0) {

			lPre.edit().putString(KEY_PT_URL, ptBaseUrl).commit();
		}

		String ptBaseUrl2 = lData.getPtBaseUrl2();

		if (ptBaseUrl2 != null && ptBaseUrl2.trim().length() > 0) {

			lPre.edit().putString(KEY_PT_URL2, ptBaseUrl2).commit();
		}


		String lPassword = lData.getmPassword();
		if (lPassword != null && lPassword.trim().length() > 0) {

			lPre.edit().putString(KEY_LOGIN_PASSWORD, lPassword).commit();
		}

		boolean lIsmCheckRemeber = lData.ismCheckRemeber();
		if (lIsmCheckRemeber) {
			lPre.edit().putBoolean(KEY_LOGIN_REMBER_PSW, lIsmCheckRemeber)
					.commit();
		}
	}

	private LoginData getLoginData(String key) {

		SharedPreferences lPre = mContext.getSharedPreferences(key,
				Context.MODE_PRIVATE);

		String lUserName = lPre.getString(KEY_LOGIN_USERNAME, null);
		String lUserPsw = lPre.getString(KEY_LOGIN_PASSWORD, null);
		boolean lCheck = lPre.getBoolean(KEY_LOGIN_REMBER_PSW, false);
		String baseUrl = lPre.getString(KEY_BASE_URL,null);

		String pturl = lPre.getString(KEY_PT_URL,null);
		String pturl2 = lPre.getString(KEY_PT_URL2,null);

		LoginData lData = new LoginData();

		lData.setmCheckRemeber(lCheck);

		if (lUserName != null && lUserName.trim().length() > 0) {
			lData.setmUserName(lUserName);
		}

		if (lUserPsw != null && lUserPsw.trim().length() > 0) {
			lData.setmPassword(lUserPsw);
		}
		if (baseUrl != null && baseUrl.trim().length() > 0) {
			lData.setBaseUrl(baseUrl);
		}

		if (pturl != null && pturl.trim().length() > 0) {
			lData.setPtBaseUrl(pturl);
		}
		if (pturl2 != null && pturl2.trim().length() > 0) {
			lData.setPtBaseUrl2(pturl2);
		}

		return lData;

	}

	// ==========================================

	private final String KEY_MESSAGE_SIZE = "key_message_size"; // 消息

	private void saveMessageData(String key, Object data) {

		if (data == null) {
			return;
		}

		MessageData lData = (MessageData) data;

		SharedPreferences lPre = mContext.getSharedPreferences(key,
				Context.MODE_PRIVATE);

		int lMessageArray = lData.getmMessageSize();

		lPre.edit().putInt(KEY_MESSAGE_SIZE, lMessageArray).commit();

	}

	private MessageData getMessageData(String key) {

		SharedPreferences lPre = mContext.getSharedPreferences(key,
				Context.MODE_PRIVATE);

		int lMessAgeSize = lPre.getInt(KEY_MESSAGE_SIZE, 0);

		MessageData lData = new MessageData();
		lData.setmMessageSize(lMessAgeSize);

		return lData;

	}



	// ================================================================
	
	private final String KEY_BANNER_NAME = "key_banner_name"; // 
	private final String KEY_BANNER_URL = "key_banner_url"; //  

	private void saveBanner(String key, Object data){
		
		if (data == null) {
			return;
		}

		BannerNameData lData = (BannerNameData) data;

		SharedPreferences lPre = mContext.getSharedPreferences(key,
				Context.MODE_PRIVATE);
		
		lPre.edit().putString(KEY_BANNER_NAME, lData.getIMAGE_NAME()).commit();
		
		lPre.edit().putString(KEY_BANNER_URL, lData.getBANNER_URL()).commit();
		
	}

	private BannerNameData getBannerNameData(String key) {

		SharedPreferences lPre = mContext.getSharedPreferences(key,
				Context.MODE_PRIVATE);
		
	    String lName=lPre.getString(KEY_BANNER_NAME, "NO");
	    
	    String lUrl=lPre.getString(KEY_BANNER_URL, "NO#NO#NO");

	    BannerNameData lData = new BannerNameData();

		lData.setIMAGE_NAME(lName);
		lData.setBANNER_URL(lUrl);

		return lData;

	}
	
	//========================================================

	private final String KEY_VERSION_INFO = "key_version_info"; // 版本信息

	private void saveVersionData(String key, Object data) {

		if (data == null) {
			return;
		}

		VersionData lData = (VersionData) data;

		SharedPreferences lPre = mContext.getSharedPreferences(key,
				Context.MODE_PRIVATE);

		lPre.edit().putInt(KEY_VERSION_INFO, lData.getmVersion()).commit();

	}

	private VersionData getVersionData(String key) {

		SharedPreferences lPre = mContext.getSharedPreferences(key,
				Context.MODE_PRIVATE);

		int lVersion = lPre.getInt(KEY_VERSION_INFO, -1);

		VersionData lData = new VersionData();

		lData.setmVersion(lVersion);

		return lData;

	}

	// ==============================================

	private final String KEY_DISTRICTS_INFO = "key_districts_info"; // 地区
	private final String KEY_DISTRICTS_NAME = "key_districts_name";//地区名称
	private final String KEY_SUBDISTRICTS_INFO = "key_subdistricts_info"; // 小区
	private final String KEY_SUBDISTRICTS_NAME = "key_subdistricts_name";//小区名称
	private final String KEY_BUILDING_INFO = "key_building_info"; // 楼
	private final String KEY_BUILDING_NAME = "key_building_name";//楼名称
	private final String KEY_UNIT_INFO = "key_unit_info";//单元
	private final String KEY_ROOM_INFO = "key_room_info";//房间


	private void saveRoomAllData(String key, Object data) {

		if (data == null) {
			return;
		}

		RoomAll roomAll = (RoomAll) data;

		SharedPreferences lPre = mContext.getSharedPreferences(key,
				Context.MODE_PRIVATE);

		lPre.edit().putString(KEY_DISTRICTS_INFO, roomAll.getDistrictId()).commit();
		lPre.edit().putString(KEY_DISTRICTS_NAME,roomAll.getDistrictName()).commit();
		lPre.edit().putString(KEY_SUBDISTRICTS_INFO, roomAll.getSubDistrictId()).commit();
		lPre.edit().putString(KEY_SUBDISTRICTS_NAME,roomAll.getSubDistrictName()).commit();
		lPre.edit().putString(KEY_BUILDING_INFO,roomAll.getBuildingId()).commit();
		lPre.edit().putString(KEY_BUILDING_NAME,roomAll.getBuildingName()).commit();
		lPre.edit().putString(KEY_UNIT_INFO,roomAll.getUnitNo()).commit();
		lPre.edit().putString(KEY_ROOM_INFO,roomAll.getRoomNum()).commit();

	}

	private RoomAll getRoomAllData(String key) {

		SharedPreferences lPre = mContext.getSharedPreferences(key,
				Context.MODE_PRIVATE);

		RoomAll roomAll = new RoomAll();
		roomAll.setDistrictId(lPre.getString(KEY_DISTRICTS_INFO,null));
		roomAll.setDistrictName(lPre.getString(KEY_DISTRICTS_NAME,null));
		roomAll.setSubDistrictId(lPre.getString(KEY_SUBDISTRICTS_INFO,null));
		roomAll.setSubDistrictName(lPre.getString(KEY_SUBDISTRICTS_NAME,null));
		roomAll.setBuildingId(lPre.getString(KEY_BUILDING_INFO,null));
		roomAll.setBuildingName(lPre.getString(KEY_BUILDING_NAME,null));
		roomAll.setUnitNo(lPre.getString(KEY_UNIT_INFO,null));
		roomAll.setRoomNum(lPre.getString(KEY_ROOM_INFO,null));



		return roomAll;

	}
	//===========================================================


}
