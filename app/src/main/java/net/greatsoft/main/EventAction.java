package net.greatsoft.main;

import java.util.HashMap;

public class EventAction {

	public static final boolean LOG_INOUT = true;

	// -------------------导航栏事件

	public static HashMap<String, Object> REGISTER_NUMBER; // 挂号的信息的数据缓存 ,用完之后立即清空

	public static HashMap<String, Object> BACK_CACHE_DATA; // 返回携带数据的缓存对象，用完之后立即清空

	public static int CURRENT_FRAGMENT_INDEX = 0; // 用户百度数据统计中的不同Fragment的切换标记

}
