package net.greatsoft.main.db;

public class SaveTask {

	// ================================ 存储任务关键字

	public final static String KEY_LOGIN = "key_login"; // 登录存储

	public final static String KEY_MESSAGE = "key_message"; // 消息存储
	public final static String KEY_VERSION = "key_version"; // 版本存储
	public final static String KEY_BANNER = "key_banner_image"; // 首页轮播图的最新文件显示存储

	public final static String KEY_DISTRICTS = "key_districts";//地区的选择


	public final static String ACCESS_TOKEN = "access_token";//获取token


	// =====================================

	private String mTaskKey; // 任务关键字

	private Object mData; // 要存储的数据对象

	public Object getmData() {
		return mData;
	}

	public void setmData(Object mData) {
		this.mData = mData;
	}

	public String getmTaskKey() {
		return mTaskKey;
	}

	public void setmTaskKey(String mTaskKey) {
		this.mTaskKey = mTaskKey;
	}

}
